package com.poly.action.action_news;

import java.util.Date;
import java.util.List;

import car_beans.DboAreCatalog;
import car_beans.DboNewNews;
import car_beans.DboSubContent;
import car_daos.DboAreCatalogDao;

import com.poly.action.MyActionSupport;
import com.poly.dao.SeqDao;
import com.poly.service.SubContentService;
import com.poly.util.HtmlGenerator;

//���۹���
public class CityPageAction extends MyActionSupport {

	private final int pageSize = 10;
	private int page = 1;
	private int pages = 1;

	private List<DboNewNews> calclist;// ��ҳ�����

	public String list() {

		return "list";
	}

	// ��������Ŀ¼
	public String generator() {
		try {
			// dbo_are_catalog
			List<DboAreCatalog> list = DboAreCatalogDao.find();
			DboSubContent subContent = null;
			for (DboAreCatalog dboAreCatalog : list) {
				// dbo_sub_content
				subContent = null;
				subContent = SubContentService.findByArea(dboAreCatalog);
				if (subContent == null) {
					subContent = new DboSubContent();
					subContent.setId(SeqDao.getNextId("dbo_sub_content"));
					subContent.setPname("������ҳ");
					subContent.setPlace(dboAreCatalog.getEnglingname());
					subContent.setHtmlname(dboAreCatalog.getEnglingname() + "/index.html");
					subContent.setLastvisittime(new Date());
					// DboSubContentDao.save(subContent);
					// System.out.println("DB >> "+dboAreCatalog.getEnglingname());
				}
				if (dboAreCatalog.getEnglingname() != null && dboAreCatalog.getEnglingname().length() > 0) {
					HtmlGenerator.genCityIndex(subContent, null, dboAreCatalog);
					System.out.println("html >> " + dboAreCatalog.getEnglingname());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setAjax("���ɳɹ�");
		return AJAX;
	}

}
