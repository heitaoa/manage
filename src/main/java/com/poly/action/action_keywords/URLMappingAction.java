package com.poly.action.action_keywords;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import car_beans.TbSiteMap;

import com.poly.action.MyActionSupport;
import com.poly.service.URLMappingService;

@SuppressWarnings("serial")
public class URLMappingAction extends MyActionSupport {
	public static final String[] DOMAIN_LIST = { "http://www.chetuan.com/",
			"http://ctadm.chetuan.com/", "http://kan.chetuan.com/",
			"http://tupian.chetuan.com/", "http://shangjia.chetuan.com/",
			"http://shangjia.chetuan.com/", "http://bbs.chetuan.com/",
			"http://img.315che.com", "http://city.chetuan.com/" };

	public static final Map<Integer, String> DOMAIN_MAPPING = new HashMap<Integer, String>();
	static {
		for (int i = 0; i < DOMAIN_LIST.length; i++) {
			DOMAIN_MAPPING.put(i, DOMAIN_LIST[i]);
		}
	}

	public static final String[] CHANGEFREQ_LIST = { "daily" };

	public static final int PAGESIZE = 20;
	private List<TbSiteMap> siteMaps;
	private TbSiteMap siteMap;

	private int counts;
	private int allPage;
	private int curPage;

	private int id;

	public String toPage() {
		counts = URLMappingService.getCount();
		allPage = counts / PAGESIZE;
		if (counts % PAGESIZE != 0) {
			allPage++;
		}
		if (allPage < 1) {
			allPage = 1;
		}
		if (curPage < 1) {
			curPage = 1;
		}
		if (curPage > allPage) {
			curPage = allPage;
		}
		siteMaps = URLMappingService.getPageList(PAGESIZE, curPage);

		return "toPage";
	}

	public void delete() throws IOException {
		int result = URLMappingService.deleteById(id);
		response.getWriter().println(result);
		response.getWriter().close();
	}

	public void toUpdate() {

	}

	public void update() {

	}

	public String add() throws Exception {
		if (siteMap != null) {
			siteMap.setLastmod(new Date());
			URLMappingService.save(siteMap);
		}
		return SUCCESS;
	}

	public List<TbSiteMap> getSiteMaps() {
		return siteMaps;
	}

	public void setSiteMaps(List<TbSiteMap> siteMaps) {
		this.siteMaps = siteMaps;
	}

	public TbSiteMap getSiteMap() {
		return siteMap;
	}

	public void setSiteMap(TbSiteMap siteMap) {
		this.siteMap = siteMap;
	}

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	public int getAllPage() {
		return allPage;
	}

	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String[] getDomainList() {
		return DOMAIN_LIST;
	}

	public Map<Integer, String> getDomainMapping() {
		return DOMAIN_MAPPING;
	}

	public String[] getChangefreqList() {
		return CHANGEFREQ_LIST;
	}


}
