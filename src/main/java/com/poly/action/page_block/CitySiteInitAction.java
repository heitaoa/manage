package com.poly.action.page_block;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import car_beans.TbSubSites;
import car_daos.TbSubSitesDao;

import com.poly.action.MyActionSupport;

@SuppressWarnings("serial")
public class CitySiteInitAction extends MyActionSupport {
	private static Map<String, String> SiteMap;

	private static Map<String, String> keywordMap;

	public static Map<String, String> getSiteMap() {
		if (SiteMap == null) {
			initSiteMap();
		}
		return SiteMap;
	}

	public static Map<String, String> getKeywordMap() {
		if (keywordMap == null) {
			initKeywordMap();
		}
		return keywordMap;
	}

	private static void initKeywordMap() {
		keywordMap = new HashMap<String, String>();

		ResourceBundle bundle = ResourceBundle
				.getBundle("com/deity/adminCT/actions/page_block/city_site");
		String place_rs = bundle.getString("keyword");
		String places[] = place_rs.split(";");

		for (int i = 0; i < places.length; i++) {
			keywordMap.put(Integer.toString(i), places[i]);
		}
	}

	private static void initSiteMap() {
		SiteMap = new HashMap<String, String>();//<id, name>
		
		
		List<TbSubSites> subSitesList = TbSubSitesDao.find();
		for (TbSubSites tbSubSites : subSitesList) {
			SiteMap.put(String.valueOf(tbSubSites.getId()), tbSubSites.getName());
		}
		

//		ResourceBundle bundle = ResourceBundle
//				.getBundle("com/deity/adminCT/actions/page_block/city_site");
//		String areaId_city_rs = bundle.getString("areaId_city");
//		String[] areaId_city_infos = areaId_city_rs.split(";");
//
//		for (String ac : areaId_city_infos) {
//			String areaId_city[] = ac.split(":");
//			SiteMap.put(areaId_city[0], areaId_city[1]);
//		}
	}

	public void refreshCitySite() {
		initSiteMap();
		initKeywordMap();
	}

}
