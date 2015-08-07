package com.poly.action.action_data;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import car_beans.TbDataPromoMethod;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;
import com.poly.util.PageUtilNew;

public class PromoPerAction extends MyActionSupport {
	
	List<Map<String, String>> projectList;
	List<TbDataPromoMethod> promoList;
	
	public String pro_num = "";  //项目编号
	public String promo_id = "";  //推广方案id
	public String promo_channel = "";  //推广渠道
	public String promo_url = "";  //URL
	public String promo_pageid = "";  //页面标识
	public String promo_date = "";  //推广日期
	public String promo_remarks = "";  //备注
	public String search_state = "";  //按状态检索项目；new-新项目，old-进行中，finish-已完成
	
	public int new_num = 0;      //新项目数量
	public int old_num = 0;      //正在进行的项目数量
	public int finish_num = 0;   //已完成数量
	
	public int page = 1;  //显示页
	public int pages = 1;     //总页数
	public int pagelength = 5;  //显示页码数
	
	public int pageNum = 10; //每页显示条数
	public List<String> pageList;  //返回页面的页码列表
	
	//推广人员刚进入项目列表页
	public String execute(){
		
		String userid = (String)session.get("userid");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("search_state", search_state);
		
		map.put("pageNum", String.valueOf(pageNum));
		map.put("page", String.valueOf(page));
		
		pages =  ProjectService.getInstance().getProjectsPagesForPromoPer(map);
		projectList = ProjectService.getInstance().getProjectsForPromoPer(map);
		
//		new_num = ProjectService.getInstance().getCountForPromoPerNew(map);
		old_num = ProjectService.getInstance().getCountForPromoPerOld(map);
		finish_num = ProjectService.getInstance().getCountForPromoPerFinish(map);
		
		pageList = PageUtilNew.getPageListNew(page, pages, pagelength);
		
		
		return SUCCESS;
	}
	
	//查看项目
	public String proIN(){
		
		projectList = ProjectService.getInstance().getProjectsByPronumForPer(pro_num);
//		promoList = ProjectService.getInstance().getPromoListByPronum(pro_num);
		return SUCCESS;
	}
	
	public void getPromoMethod() throws IOException{
		
		List<Map<String, String>> listResult = new ArrayList<Map<String,String>>();
		promoList = ProjectService.getInstance().getPromoListByPronum(pro_num);
		
		for (int i = 0; i < promoList.size(); i++) {
			TbDataPromoMethod promoMethod = promoList.get(i);
			Map<String, String> map = new HashMap<String, String>();
			
			SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
			String dd = dateformat.format(promoMethod.getPromo_date());
			
			map.put("promo_channel", promoMethod.getPromo_channel());
			map.put("promo_url", promoMethod.getPromo_url());
			map.put("promo_pageid", promoMethod.getPromo_pageid());
			map.put("promo_date", dd);
			map.put("promo_remarks", promoMethod.getPromo_remarks());
			listResult.add(map);
			
		}
		
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(listResult);
		out.print(json.toString());
	}
	
	//提交推广方案
	public String subFunction() {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("pro_num", pro_num);
		map.put("promo_id", promo_id);
		map.put("promo_channel", promo_channel);
		map.put("promo_url", promo_url);
		map.put("promo_pageid", promo_pageid);
		map.put("promo_date", promo_date);
		map.put("promo_remarks", promo_remarks);
		
		ProjectService.getInstance().updatePromoForPer(map);
		projectList = ProjectService.getInstance().getProjectsByPronumForPer(pro_num);
		
		promoList = ProjectService.getInstance().getPromoListByPronum(pro_num);
		
		return SUCCESS;
	}
	
	//删除推广方案
	public void deleteFunction(){
		int result;
		result = ProjectService.getInstance().deletePromoFunctionById(promo_id);
		
		try {
			response.getWriter().write("" + result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//获取项目信息--没有推广计划
	public void getProInfo() throws IOException{
		Map<String, String> result = ProjectService.getInstance().getProjectInfoForPromoByProNum(pro_num);
		
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(result);
		out.print(json.toString());
	}

	public List<Map<String, String>> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Map<String, String>> projectList) {
		this.projectList = projectList;
	}

	public String getPro_num() {
		return pro_num;
	}

	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
	}

	public String getPromo_id() {
		return promo_id;
	}

	public void setPromo_id(String promo_id) {
		this.promo_id = promo_id;
	}

	public String getPromo_url() {
		return promo_url;
	}

	public void setPromo_url(String promo_url) {
		this.promo_url = promo_url;
	}

	public String getPromo_pageid() {
		return promo_pageid;
	}

	public void setPromo_pageid(String promo_pageid) {
		this.promo_pageid = promo_pageid;
	}

	public String getPromo_date() {
		return promo_date;
	}

	public void setPromo_date(String promo_date) {
		this.promo_date = promo_date;
	}

	public String getPromo_remarks() {
		return promo_remarks;
	}

	public void setPromo_remarks(String promo_remarks) {
		this.promo_remarks = promo_remarks;
	}

	public String getPromo_channel() {
		return promo_channel;
	}

	public void setPromo_channel(String promo_channel) {
		this.promo_channel = promo_channel;
	}

	public List<TbDataPromoMethod> getPromoList() {
		return promoList;
	}

	public void setPromoList(List<TbDataPromoMethod> promoList) {
		this.promoList = promoList;
	}

	public String getSearch_state() {
		return search_state;
	}

	public void setSearch_state(String search_state) {
		this.search_state = search_state;
	}

	public int getNew_num() {
		return new_num;
	}

	public void setNew_num(int new_num) {
		this.new_num = new_num;
	}

	public int getOld_num() {
		return old_num;
	}

	public void setOld_num(int old_num) {
		this.old_num = old_num;
	}

	public int getFinish_num() {
		return finish_num;
	}

	public void setFinish_num(int finish_num) {
		this.finish_num = finish_num;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public List<String> getPageList() {
		return pageList;
	}

	public void setPageList(List<String> pageList) {
		this.pageList = pageList;
	}
	
	
}
