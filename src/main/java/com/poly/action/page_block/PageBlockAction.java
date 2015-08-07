package com.poly.action.page_block;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import car_beans.DboNewNews;
import car_beans.DboSubContent;
import car_beans.DboSubData;
import car_daos.DboNewNewsDao;
import car_daos.DboSubContentDao;
import car_daos.DboSubDataDao;

import com.poly.action.MyActionSupport;
import com.poly.dao.subDaos.DboSubDataSubDao;
import com.poly.service.SubContentService;
import com.poly.util.HtmlGenerator;
import com.poly.util.MyConfig;

@SuppressWarnings("serial")
public class PageBlockAction extends MyActionSupport {
	private String urlPath = MyConfig.che_url;

	public static final int HIS_COUNT = 5;
	private Map<Integer, String> menuMapping;
	private boolean newMenu = false;
	private int menu = 1;

	private int sid;

	private int pageSize = 20;
	private int count;
	private int curPage;
	private int allPage;
	private String keyword;

	private List<DboSubContent> contents;

	private List<DboSubData> subDatas;

	private String modifiIds;
	private String ajax;

	private String message;
	private String paging;

	private DboSubData subData;

	private int newsId;

	public PageBlockAction() {
		menuMapping = new HashMap<Integer, String>();
		menuMapping.put(1, "ȫ��");
	}

	public String execute() {
		paging = "toPageBlock";

		String pb_his_kw = getHisCookie();
		initMenuMapping(pb_his_kw);

		String sql = "isdelete=0 and pname not like 'zt_%' and pname not like 'carzt_%'";
		showPage(sql);
		return SUCCESS;
	}

	public String refreshToHTML() {
		try {
			DboSubContent content = DboSubContentDao.where(" isdelete=0 and id=" + sid).get(0);
			if (content.getStype() == 3) {
				// WPA ҳ��ˢ��
//				WAPHtmlGenerator.generatorHTML(content);
				ajax = "true";
			} else {
				// PC ҳ��ˢ��
				List<DboSubData> list = DboSubDataSubDao.where(" isdelete=0 and sid=" + sid + " order by sortid desc");
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
				ajax = "true";
			}

		} catch (Exception e) {
			e.printStackTrace();
			ajax = "false";
		}
		return "modifi";
	}

	private void print(DboSubContent content, Object[] param) throws Exception {
		Object[] objArr = { param };
		// if (content.getPlace() != null
		// && content.getPlace().indexOf("index") != -1) {
		
		//����html
		if (content.getHtmltype() == 1) {
			
			//xx��ҳ��
			if(content.getParent_id() == 0){
				Map<String, List<DboSubData>> dataMap = SubContentService.queryPagesubDataBySid(content.getId());

				// ��վ����վ��ûȱ�ٵ���������վ�������
				if (content.getParent_id() != 1) {
					// �Ϻ�վΪ��վ
					Map<String, List<DboSubData>> defaultMap = SubContentService.queryPagesubDataBySid(1);
					for (String pname : defaultMap.keySet()) {
						List<DboSubData> subList = dataMap.get(pname);
						if (subList == null) {
							dataMap.put(pname, defaultMap.get(pname));
						}
					}
				}
				HtmlGenerator.genIndex(content, objArr, dataMap);
			}

		}
		
		//����js��
		if (content.getHtmltype() == 2) {
			HtmlGenerator.genBlockjs(content, objArr);
		}
		
	}

	private void showPage(String sql) {
		count = DboSubContentDao.whereCount(sql);
		allPage = count / pageSize;
		if (count % pageSize != 0) {
			allPage++;
		}
		if (curPage <= 0) {
			curPage = 1;
		}
		if (curPage > allPage) {
			curPage = allPage;
		}
		int start = 0;
		start = pageSize * (curPage - 1);
		if (start < 0) {
			start = 0;
		}
		if (start > count) {
			start = count;
		}
		contents = DboSubContentDao.where(sql + " limit " + start + "," + pageSize);
	}

	public String search() {
		paging = "search";

		String pb_his_kw = getHisCookie();
		String sql = "isdelete=0 and pname not like 'zt_%' and pname not like 'carzt_%'";
		if (!newMenu) {
			if (keyword != null && !"".equals(keyword.trim())) {
				keyword = keyword.trim();
				sql += " and place like '%" + keyword + "%'";
				if (pb_his_kw != null) {
					pb_his_kw += ("," + keyword);
				} else {
					pb_his_kw = keyword;
				}

				isAddKw = true;
				session.put("keyword", keyword);
			} else {
				keyword = (String) session.get("keyword");
				if (keyword != null) {
					sql += " and place like '%" + keyword + "%'";
				}
			}
		}
		initMenuMapping(pb_his_kw);
		if (newMenu) {
			if (menu != 1) {
				keyword = menuMapping.get(menu);
			} else {
				keyword = "";
			}
			if (keyword != null) {
				sql += " and place like '%" + keyword + "%'";
				session.put("keyword", keyword);
			}
		} else {
			Set<Integer> keys = menuMapping.keySet();
			for (int key : keys) {
				String value = menuMapping.get(key);
				if (keyword.equals(value)) {
					menu = key;
				}
			}
		}
		showPage(sql);
		return SUCCESS;
	}

	private String getHisCookie() {
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		for (Cookie cookie : cookies) {
			if ("pageBlock_search_keyword".equals(cookie.getName())) {
				String value = cookie.getValue();
				String[] vls = value.split(",");
				StringBuffer buffer = new StringBuffer();
				for (int i = 0; i < vls.length; i++) {
					if (i != 0) {
						buffer.append(",");
					}
					try {
						buffer.append(URLDecoder.decode(vls[i], "UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
				return buffer.toString();
			}
		}
		return null;
	}

	private boolean isAddKw = false;

	private void initMenuMapping(String hiskws) {
		if (hiskws == null) {
			return;
		}
		String value = null;
		if (isAddKw) {
			int index = hiskws.lastIndexOf(",");
			if (index > 0) {
				value = hiskws.substring(0, index);
			}
		} else {
			value = hiskws;
		}
		// ����cookie
		StringBuffer buffer = new StringBuffer();
		boolean hasThwd = false;
		if (value != null) {
			String kws[] = value.split(",");
			if (isAddKw) {
				for (String kw : kws) {
					if (kw.equals(keyword)) {
						hasThwd = true;
					}
				}
				if (hasThwd) {
					for (int i = 0; i < kws.length; i++) {
						menuMapping.put(i + 10, kws[i]);
					}
				} else {
					try {
						if (kws.length < HIS_COUNT) {
							int tmp = 0;
							for (int i = 0; i < kws.length; i++) {
								menuMapping.put(i + 10, kws[i]);
								if (buffer.length() > 0) {
									buffer.append(",");
								}
								buffer.append(URLEncoder.encode(kws[i], "UTF-8"));
								tmp = i;
							}
							menuMapping.put(11 + tmp, keyword);
							menu = 11 + tmp;
							buffer.append(",");
							buffer.append(URLEncoder.encode(keyword, "UTF-8"));
						} else {
							int tmp = 0;
							for (int i = 0; i < (HIS_COUNT - 1); i++) {
								menuMapping.put(i + 10, kws[i + 1]);
								if (buffer.length() > 0) {
									buffer.append(",");
								}
								buffer.append(URLEncoder.encode(kws[i + 1], "UTF-8"));
								tmp = i;
							}
							menuMapping.put(11 + tmp, keyword);
							menu = 11 + tmp;
							buffer.append(",");
							buffer.append(URLEncoder.encode(keyword, "UTF-8"));
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			} else {
				for (int i = 0; i < kws.length; i++) {
					menuMapping.put(i + 10, kws[i]);
				}
			}
		} else {
			if (isAddKw) {
				menuMapping.put(2, keyword);
				try {
					buffer.append(URLEncoder.encode(keyword, "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
		if (isAddKw && (!hasThwd)) {
			Cookie cookie = new Cookie("pageBlock_search_keyword", buffer.toString());
			cookie.setMaxAge(10000000);
			ServletActionContext.getResponse().addCookie(cookie);
		}
	}

	public String updateData() {
		subData = DboSubDataSubDao.where(" isdelete=0 and id=" + modifiIds).get(0);
		sid = subData.getSid();
		return "updateData";
	}

	public String updateDataForCommit() {
		try {
			String content = subData.getContent();
			if (content == null) {
				content = "";
			} else {
				content = content.trim();
			}
			subData.setContent(content);

			DboSubDataSubDao.updateData(subData);
			ajax = "true";
		} catch (Exception e) {
			e.printStackTrace();
			ajax = "false";
		}
		return "modifi";
	}

	public String addData() throws Exception {
		String title = subData.getTitle();
		if (title == null || "".equals(title.trim())) {
			return updateBlock();
		}
		int id = DboSubDataSubDao.getId();
		subData.setId(id);
		subData.setSid(sid);
		subData.setAdddate(new Date());
		subData.setSortid(id);
		DboSubDataSubDao.save(subData);
		return "addData";
	}

	private int newsPage;

	public int getNewsPage() {
		return newsPage;
	}

	public void setNewsPage(int newsPage) {
		this.newsPage = newsPage;
	}

	public String queryContent() {
		DboNewNews newNews = DboNewNewsDao.where("id=" + modifiIds).get(0);
		StringBuffer buf = new StringBuffer();
		buf.append(newNews.getNewstitle());
		buf.append("&");
		buf.append(newNews.getTitlephoto());
		buf.append("&");
		buf.append(newNews.getDescription());
		ajax = buf.toString();
		return "modifi";
	}

	private File photo;
	private String photoFileName;
	private String photoContentType;

	public String uploadPhoto() {

		if ("image/jpeg".equals(photoContentType) || "image/png".equals(photoContentType)) {
			String fileName = (System.currentTimeMillis() + "" + photoFileName.hashCode()).substring(0, 15) + ".jpg";
			ajax = fileName;
			String newFile = MyConfig.html_pic_upload_path + File.separator + "pageblock" + File.separator + fileName;
			File reFile = new File(newFile);
			if (!reFile.getParentFile().exists()) {
				reFile.getParentFile().mkdirs();
			}
			photo.renameTo(reFile);
		} else {
			ajax = "false";
		}
		return "modifi";
	}

	public String selectQuery() {
		int pageSize = 10;
		String sql = "newscatalogid=" + newsId;
		if (keyword != null || !"".equals(keyword.trim())) {
			sql += " and newstitle like '%" + keyword + "%'";
		}
		int count = DboNewNewsDao.whereCount(sql);
		int allPage = count / pageSize;
		if (count % pageSize != 0) {
			allPage++;
		}
		if (newsPage <= 0) {
			newsPage = 1;
		}
		if (newsPage > allPage) {
			newsPage = allPage;
		}
		int start = pageSize * (newsPage - 1);
		List<DboNewNews> newNews = DboNewNewsDao.where(sql + " limit " + start + "," + pageSize);
		StringBuffer buffer = new StringBuffer();
		buffer.append("allPage=" + allPage);
		buffer.append(",");
		buffer.append("newsPage=" + newsPage);

		if (newNews != null) {
			for (DboNewNews nnws : newNews) {
				buffer.append("&");
				buffer.append(nnws.getId());
				buffer.append(",");
				buffer.append(nnws.getNewstitle());
				buffer.append(",");
				String pic = nnws.getTitlephoto();
				if (pic != null && !"".equals(pic)) {
					buffer.append("��ͼƬ");
				} else {
					buffer.append("��ͼƬ");
				}
			}
		}
		ajax = buffer.toString();
		return "modifi";
	}

	private DboSubContent content;

	public String updateBlock() {
		try {
			content = DboSubContentDao.where("isdelete=0 and id=" + sid).get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		subDatas = DboSubDataDao.where("isdelete=0 and sid=" + sid + " order by sortid desc");
		for (DboSubData ud : subDatas) {
			String pic = ud.getPic();
			if (pic == null || "".equals(pic.trim())) {
				ud.setPic(null);
			}
		}
		return "updateBlock";
	}

	public String sortedChange() {
		if (modifiIds == null || "".equals(modifiIds)) {
			ajax = "false";
		} else {
			String ids[] = modifiIds.split(",");
			if (ids.length != 2) {
				ajax = "false";
			} else {
				int id0 = 0;
				int id1 = 0;
				try {
					id0 = Integer.parseInt(ids[0]);
					id1 = Integer.parseInt(ids[1]);
					DboSubDataSubDao.changeSorted(id0, id1);
					ajax = "true";
				} catch (Exception e) {
					e.printStackTrace();
					ajax = "false";
				}
			}
		}
		return "modifi";
	}

	public String sad() {
		if (modifiIds == null || "".equals(modifiIds)) {
			ajax = "false";
		} else {
			try {
				String pms[] = modifiIds.split(",");
				if (pms.length != 2) {
					ajax = "false";
				} else {
					int isad = Integer.parseInt(pms[0]);
					int id = Integer.parseInt(pms[1]);
					DboSubDataSubDao.updateDataSad(isad, id);
					ajax = "true";
				}
			} catch (Exception e) {
				e.printStackTrace();
				ajax = "false";
			}
		}

		return "modifi";
	}

	public String deleteData() {
		if (modifiIds == null || "".equals(modifiIds)) {
			ajax = "false";
		} else {
			try {
				int id = Integer.parseInt(modifiIds);
				DboSubDataSubDao.deleteDataById(id);
				ajax = "true";
			} catch (Exception e) {
				e.printStackTrace();
				ajax = "false";
			}
		}
		return "modifi";
	}

	public String deleteDataBatch() {
		try {
			int retainCount = Integer.parseInt(modifiIds);
			int num = DboSubDataSubDao.deleteDataBatch(retainCount, sid);
			message = "�Ѿ�ɾ�� �� " + num + " ����¼";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "modifi_deleteDataBatch";
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getAllPage() {
		return allPage;
	}

	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}

	public List<DboSubContent> getContents() {
		return contents;
	}

	public DboSubContent getContent() {
		return content;
	}

	public void setContent(DboSubContent content) {
		this.content = content;
	}

	public void setContents(List<DboSubContent> contents) {
		this.contents = contents;
	}

	public Map<Integer, String> getMenuMapping() {
		return menuMapping;
	}

	public void setMenuMapping(Map<Integer, String> menuMapping) {
		this.menuMapping = menuMapping;
	}

	public int getMenu() {
		return menu;
	}

	public void setMenu(int menu) {
		newMenu = true;
		this.menu = menu;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public List<DboSubData> getSubDatas() {
		return subDatas;
	}

	public void setSubDatas(List<DboSubData> subDatas) {
		this.subDatas = subDatas;
	}

	public String getModifiIds() {
		return modifiIds;
	}

	public void setModifiIds(String modifiIds) {
		this.modifiIds = modifiIds;
	}

	public String getAjax() {
		return ajax;
	}

	public void setAjax(String ajax) {
		this.ajax = ajax;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getPaging() {
		return paging;
	}

	public void setPaging(String paging) {
		this.paging = paging;
	}

	public DboSubData getSubData() {
		return subData;
	}

	public void setSubData(DboSubData subData) {
		this.subData = subData;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}
}
