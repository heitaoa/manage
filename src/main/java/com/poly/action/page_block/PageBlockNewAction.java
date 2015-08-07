package com.poly.action.page_block;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import car_beans.DboSubContent;

import com.poly.action.MyActionSupport;
import com.poly.bean.QueryResult;
import com.poly.service.SubContentService;

@SuppressWarnings("serial")
public class PageBlockNewAction extends MyActionSupport {

	// վ������
	private String citySite;
	private String cs_key;
	// �ؼ�������
	private String kw_key;
	private String keyword;

	private Map<String, String> SiteMap = CitySiteInitAction.getSiteMap();
	private Map<String, String> keywordMap = CitySiteInitAction.getKeywordMap();

	private List<DboSubContent> contents;

	private int curPage;
	private int allPage;
	public static final int PAGESIZE = 20;

	// stype=1 dbo_sub_content ҳ��ģ��༭
	@Override
	public String execute() throws Exception {
		int ulevel = 0;//getUlevel();
		Map<?, ?> userInfo = (Map<?, ?>) session.get("userInfo");

		if (keyword != null && !"".equals(keyword)) {
			session.put("keyword", keyword);
			kw_key = "-1";
		} else {
			if (kw_key != null && !"".equals(kw_key.trim())) {
				kw_key = kw_key.trim();
				if ("-1".equals(kw_key)) {
					keyword = (String) session.get("keyword");
				} else {
					keyword = keywordMap.get(kw_key);
				}
			} else {
				session.put("keyword", null);
			}
		}

		if (cs_key != null) {
			citySite = SiteMap.get(cs_key);
		}

		if (curPage < 1) {
			curPage = 1;
		}
		int count = 0;
		if (ulevel == 4) {// ��վ�����Բ鿴������Ϣ
			QueryResult<List<DboSubContent>> contentResult = SubContentService
					.querySubContentByKeywordAndcitySite(keyword, cs_key,
							(curPage - 1) * PAGESIZE, PAGESIZE);
			count = contentResult.getCount();
			contents = contentResult.getResult();

		} else if (ulevel == 5) {// ��վ��ֻ�ܲ鿴��վ��Ϣ
			//System.out.println(userInfo);
			Object spaceid_val = userInfo.get("sub_sites_id");
			int spaceid = -1;
			if (spaceid_val != null) {
				String spaceid_val_str = spaceid_val.toString();
				if (spaceid_val_str.matches("\\d+")) {
					spaceid = Integer.parseInt(spaceid_val_str);
				}
			}

			if (spaceid >= 0) {
				if (cs_key != null && !"".equals(cs_key.trim())
						&& !cs_key.equals(Integer.toString(spaceid))) {// ����ȷ��վ����Ϣ
					message = "��û�в鿴���վ�����ݵ�Ȩ�ޣ�";
				} else {
					citySite = SiteMap.get(Integer.toString(spaceid));

					QueryResult<List<DboSubContent>> contentResult = SubContentService
							.querySubContentByKeywordAndcitySite(keyword,
									Integer.toString(spaceid), (curPage - 1)
											* PAGESIZE, PAGESIZE);
					count = contentResult.getCount();
					contents = contentResult.getResult();
				}
			} else {
				message = "��ȷ��������վ��Ϣ���Ա�鿴��վ���ݣ�";
			}

		} else {// û�в���Ȩ��
			message = "��û�иò�����Ȩ�ޣ�";
		}

		if (contents == null) {
			contents = new ArrayList<DboSubContent>();
		} else {
			List<DboSubContent> tempList = new ArrayList<DboSubContent>();
			for (DboSubContent content : contents) {
				if (content.getPlace().endsWith("index")) {
					tempList.add(content);
				}
			}
			for (DboSubContent content : tempList) {
				contents.remove(content);
				contents.add(0, content);
			}
		}

		allPage = count / PAGESIZE;
		if (count % PAGESIZE != 0) {
			allPage++;
		}
		if (allPage < 1) {
			allPage = 1;
		}
		return super.execute();
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCitySite() {
		return citySite;
	}

	public void setCitySite(String citySite) {
		this.citySite = citySite;
	}

	public String getKw_key() {
		return kw_key;
	}

	public void setKw_key(String kw_key) {
		this.kw_key = kw_key;
	}

	public Map<String, String> getSiteMap() {
		return SiteMap;
	}

	public void setSiteMap(Map<String, String> siteMap) {
		SiteMap = siteMap;
	}

	public Map<String, String> getKeywordMap() {
		return keywordMap;
	}

	public void setKeywordMap(Map<String, String> keywordMap) {
		this.keywordMap = keywordMap;
	}

	public List<DboSubContent> getContents() {
		return contents;
	}

	public void setContents(List<DboSubContent> contents) {
		this.contents = contents;
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCs_key() {
		return cs_key;
	}

	public void setCs_key(String cs_key) {
		this.cs_key = cs_key;
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
}
