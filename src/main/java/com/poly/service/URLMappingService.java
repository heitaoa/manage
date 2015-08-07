package com.poly.service;

import java.util.Date;
import java.util.List;

import car_beans.TbSiteMap;
import car_daos.TbSiteMapDao;

import com.poly.action.action_keywords.URLMappingAction;

public class URLMappingService {
	public static int getCount() {
		return TbSiteMapDao.whereCount("1=1");
	}

	public static void save(TbSiteMap siteMap) throws Exception {
		TbSiteMapDao.save(siteMap);
	}

	public static List<TbSiteMap> getPageList(int pageSize, int curPage) {
		if (curPage < 1) {
			curPage = 1;
		}
		if (pageSize < 1) {
			pageSize = 1;
		}
		return TbSiteMapDao.where("1=1 limit " + (pageSize * (curPage - 1))
				+ "," + pageSize);
	}

	public static int deleteById(int id) {
		TbSiteMapDao.delete("id=" + id);
		return 0;
	}
	
	
	public static int deleteByLoc(String loc) {
		TbSiteMapDao.delete("loc=" + loc);
		return 0;
	}
	
	public static void addByLoc(String loc) {
		TbSiteMap siteMap = new TbSiteMap();
		siteMap.setLoc(loc);
		siteMap.setDomain(0);
		siteMap.setChangefreq(URLMappingAction.CHANGEFREQ_LIST[0]);
		siteMap.setLastmod(new Date());
		siteMap.setPriority("0.8");
		try {
			save(siteMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
