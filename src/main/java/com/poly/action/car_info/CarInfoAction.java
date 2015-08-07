package com.poly.action.car_info;

import java.util.List;

import car_beans.DboDeaNews;

import com.poly.action.MyActionSupport;

//���۹���
public class CarInfoAction extends MyActionSupport {

	private final int pageSize = 8;
	private int page = 1;
	private int pages = 1;
	private List<DboDeaNews> calclist;// ��ҳ�����

	public String execute() {
		System.out.println("execute");

		return SUCCESS;
	}

	//
	public String viewList() {
		list();

		//
		// Map<String,Object> root=new HashMap<String, Object>();
		// root.put("length", new StringLengthMethod());
		// root.put("dnsUrl", getDnsUrl());
		// ...
		// FreeMarkertUtil.processTemplate(InitServlet.rootPath+"WEB-INF/ftl","news.ftl",
		// "GBK", root, new OutputStreamWriter(System.out));

		return SUCCESS;
	}

	//
	private void list() {
		// /*if (ddlNewsClass > 0)
		// System.out.println("ddlNewsClass:" + ddlNewsClass);
		// if (title_article != null)
		// System.out.println("title:" + title_article);
		// if (textContent != null)
		// System.out.println("content:" + textContent);
		//
		// // System.out.println("--->:" + request.getMethod());
		// if (queryTitle != null) {
		// if ("GET".equals(request.getMethod())) {
		// try {
		// queryTitle = new String(queryTitle.getBytes("iso8859-1"),
		// "GBK");
		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// }
		// }
		// }
		//
		// this.deaDealer = this.getDeaDealer();
		// // ���������µ�����
		// int eid = deaDealer.getEid();
		// eid = 5;// test
		// // int e_id = 100000000 + deaDealer.getEid();
		// int amnout = DeaNewsDao.countByType(eid, startDate, endDate,
		// queryTitle, ddlNewsClass);
		// pages = CalcPageUtil.getPages(amnout, pageSize);*/
		if (page < 1)
			page = 1;
		if (page > pages)
			page = pages;
		//
		int begin = (page - 1) * pageSize;
		// ��ҳ����
		// calclist = DeaNewsDao.listByType(eid, queryTitle, startDate, endDate,
		// ddlNewsClass, begin, pageSize);
	}

}
