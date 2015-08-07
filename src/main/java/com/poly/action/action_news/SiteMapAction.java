package com.poly.action.action_news;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import car_beans.DboCarCatalognew;
import car_beans.DboNewCatalog;
import car_beans.DboNewContent;
import car_beans.DboNewNews;
import car_beans.DboNewPublishtime;
import car_beans.DboNewRelated;
import car_beans.DboNewSource;
import car_beans.TbSiteMap;
import car_daos.DboNewCatalogDao;
import car_daos.DboNewSourceDao;

import com.poly.action.MyActionSupport;
import com.poly.dao.NewsAdmDao;
import com.poly.dao.SeqDao;
import com.poly.service.NewsAdmService;
import com.poly.service.URLMappingService;
import com.poly.util.CalcPageUtil;
import com.poly.util.DateUtils;
import com.poly.util.FieldUtil;
import com.poly.util.FileUtil;
import com.poly.util.HtmlGenerator;
import com.poly.util.MyConfig;
import com.poly.util.SitemapTask;
import com.poly.util.StringUtils;

//���۹���
public class SiteMapAction extends MyActionSupport {

	private int PAGESIZE = SitemapTask.PAGESIZE;
	
	public String genSiteMap() {
		System.out.println("SiteMapAction.genSiteMap()");
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
		setAjax("���ɳɹ�");
		return AJAX;
	}

}
