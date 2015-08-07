package com.poly.util;

import java.util.List;
import java.util.TimerTask;

import car_beans.TbSiteMap;

import com.poly.service.URLMappingService;

public class SitemapTask extends TimerTask {

	public static final int PAGESIZE = 5000;

	public void run() {
		System.out.println("��ʱ���� :����sitemap.xml begin ...");

		int counts = URLMappingService.getCount();
		int allPage = counts / PAGESIZE;
		if (counts % PAGESIZE != 0) {
			allPage++;
		}
		if (allPage < 1) {
			allPage = 1;
		}

		for (int i = 1; i <= allPage; i++) {
			List<TbSiteMap> siteMaps = URLMappingService.getPageList(PAGESIZE, i);
			try {
				HtmlGenerator.genSitemapXML(siteMaps, i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("��ʱ���� :����sitemap.xml end ...");
	}
}
