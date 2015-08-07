package com.poly.action.page_block;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import car_beans.DboSubContent;
import car_beans.DboSubData;

import com.poly.action.MyActionSupport;
import com.poly.dao.che.PageBlockDAO;
import com.poly.dao.subDaos.DboSubDataSubDao;
import com.poly.service.SubContentService;
import com.poly.util.HtmlGenerator;
import com.poly.util.JsonUtil;
import com.poly.util.wap.WAPHtmlGenerator;
import com.redis.RedisDao;

@SuppressWarnings("serial")
public class ChePageBlockAction extends MyActionSupport {

	/** 平台选择*/
	public static Map<String, String> stypeMap = new HashMap<String, String>();
	static {
		stypeMap.put("1", "车团");
		stypeMap.put("3", "车团WAP");
		stypeMap.put("4", "315车");
		stypeMap.put("5", "315车WAP");
	}

	private List<Map<String, Object>> allSites;
	private List<String> search_kws;
	private int sub_sites_id;

	/**
	 * 页面模块编辑
	 * 入口页
	 */
	public String toPageBlock() throws Exception {
		// 查询分站名称，areaid， 
		allSites = PageBlockDAO.queryAllSites();

		if (keywords == null) {
			keywords = (String) session.get("keywords");
		}

		// 查询 sid =20227 页面模块为关键字的数据 （用于关键字（快捷搜素））
		List<DboSubData> subDatas = PageBlockDAO.querySubDatasByCid(20227);
		
		// 将subDatas 的所有关键字 放入search_kws
		search_kws = new ArrayList<String>();
		for (DboSubData subData : subDatas) {
			search_kws.add(subData.getTitle());
		}

		Map<?, ?> userInfo = (Map<?, ?>) session.get("userInfo");
		
		// 从session内获取城市站id sub_sites_id 
		sub_sites_id = Integer.parseInt((String) userInfo.get("sub_sites_id"));

		return SUCCESS;
	}

	private String keywords;
	private String pingtai = "4";
	private int page = 1;
	private int sites_id;
	private int pageSize = 10;

	/**
	 * 页面模块编辑 分页 ajax 
	 * @throws Exception
	 */
	public void listData() throws Exception {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if (keywords == null) {
			keywords = (String) session.get("keywords");
		}

		// 根据关键字，平台，分站id查询 页面模块
		List<Map<String, Object>> maps = PageBlockDAO.queryPageBlockListData(
				keywords, pingtai, sites_id, page, pageSize);
		for (Map<String, Object> map : maps) {
			String stype = map.get("stype").toString();

			String tname = stypeMap.get(stype);
			if (tname == null) {
				tname = "其他";
			}

			map.put("tname", tname);
		}

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		if (keywords != null && "".equals(keywords)) {
			jsonMap.put("keywords", keywords);
		}
		jsonMap.put("dataList", maps);

		String json = JsonUtil.toJsonString(jsonMap);
		out.println(json);
	}

	public int getSub_sites_id() {
		return sub_sites_id;
	}

	public void setSub_sites_id(int sub_sites_id) {
		this.sub_sites_id = sub_sites_id;
	}

	private int cid;

	public void syncData() throws Exception {
		PageBlockDAO.syncSubData(cid);
	}

	public void refreshPage() throws IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String result = null;
		try {
			DboSubContent content = PageBlockDAO.querySubContentById(cid);
			if (content.getStype() == 3) {
				// 车团WAP页面刷新

				WAPHtmlGenerator.generatorHTML(content);
			} else {
				// 根据页面模块id，查询该模块下所有内容
				List<DboSubData> list = DboSubDataSubDao
						.where(" isdelete=0 and sid=" + cid
								+ " order by sortid desc");
				
				// 去除换行
				for (DboSubData dboSubData : list) {
					String str = dboSubData.getContent();
					if (str != null) {
						Pattern p = Pattern.compile("\r|\n");
						Matcher m = p.matcher(str);
						dboSubData.setContent(m.replaceAll(""));
					}
				}

				Object[] param = list.toArray();
				print(content, param);
			}
			
			result = "true";
		} catch (Exception e) {
			e.printStackTrace();
			result = "false";
		}

		//清除首页的redis
		RedisDao.cleanCheIndex();
		
		out.println(result);
	}

	private void print(DboSubContent content, Object[] param) throws Exception {
		Object[] objArr = { param };
		// if (content.getPlace() != null
		// && content.getPlace().indexOf("index") != -1) {

		if (content.getHtmltype() == 1) {

			if (content.getParent_id() == 0) {
				Map<String, List<DboSubData>> dataMap = SubContentService
						.queryPagesubDataBySid(content.getId());

				// if (content.getParent_id() != 1) {
				Map<String, List<DboSubData>> defaultMap = SubContentService
						.queryPagesubDataBySid(1);
				for (String pname : defaultMap.keySet()) {
					List<DboSubData> subList = dataMap.get(pname);
					if (subList == null) {
						dataMap.put(pname, defaultMap.get(pname));
					}
				}
				// }
				HtmlGenerator.genIndex(content, objArr, dataMap);
			}
		}
		//
		if (content.getHtmltype() == 2) {
			HtmlGenerator.genBlockjs(content, objArr);
			if (content.getStype() == 4) {
				HtmlGenerator.gen315Blockjs(content, objArr);
			}
		}

	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public void setAllSites(List<Map<String, Object>> allSites) {
		this.allSites = allSites;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getPingtai() {
		return pingtai;
	}

	public void setPingtai(String pingtai) {
		this.pingtai = pingtai;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSites_id() {
		return sites_id;
	}

	public void setSites_id(int sites_id) {
		this.sites_id = sites_id;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<Map<String, Object>> getAllSites() {
		return allSites;
	}

	public Map<String, String> getStypeMap() {
		return stypeMap;
	}

	public List<String> getSearch_kws() {
		return search_kws;
	}

	public void setSearch_kws(List<String> search_kws) {
		this.search_kws = search_kws;
	}

}
