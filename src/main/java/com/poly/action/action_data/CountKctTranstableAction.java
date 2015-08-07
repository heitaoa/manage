package com.poly.action.action_data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;
import com.poly.util.PageUtilNew;

public class CountKctTranstableAction extends MyActionSupport {
	
	public String date_start;
	public String date_end;
	public String area;
	private Map<String, String> provMap;  //省份列表
	private String promo_prov = "";  //推广省份
	private String promo_city = "";  //推广城市
	
	public String service_type = "-1";
	
	public Map<String, String> areaMap;
	public List<Map<String, String>> transList;
	
	private int page = 1;  //显示页
	private int pages = 0;     //总页数
	private int pagelength = 5;  //显示页码数
	
	private int pageNum = 10; //每页显示条数
	private List<String> pageList;  //返回页面的页码列表
	
	public String execute(){
		Map<String, String> mapWhere = new HashMap<String, String>();
		mapWhere.put("date_start", date_start);
		mapWhere.put("date_end", date_end);
		mapWhere.put("service_type", service_type);
		mapWhere.put("promo_prov", promo_prov);
		mapWhere.put("promo_city", promo_city);
		
		mapWhere.put("pageNum", String.valueOf(pageNum));
		mapWhere.put("page", String.valueOf(page));
		
		provMap = ProjectService.getInstance().getProvMap();
		
		pages = ProjectService.getInstance().getTransListPages(mapWhere);
		transList = ProjectService.getInstance().getTransList(mapWhere);
		
		pageList = PageUtilNew.getPageListNew(page, pages, pagelength);
		
		return SUCCESS;
	}

	public String getDate_start() {
		return date_start;
	}

	public void setDate_start(String date_start) {
		this.date_start = date_start;
	}

	public String getDate_end() {
		return date_end;
	}

	public void setDate_end(String date_end) {
		this.date_end = date_end;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getService_type() {
		return service_type;
	}

	public void setService_type(String service_type) {
		this.service_type = service_type;
	}

	public List<Map<String, String>> getTransList() {
		return transList;
	}

	public void setTransList(List<Map<String, String>> transList) {
		this.transList = transList;
	}

	public Map<String, String> getAreaMap() {
		return areaMap;
	}

	public void setAreaMap(Map<String, String> areaMap) {
		this.areaMap = areaMap;
	}

	public Map<String, String> getProvMap() {
		return provMap;
	}

	public void setProvMap(Map<String, String> provMap) {
		this.provMap = provMap;
	}

	public String getPromo_prov() {
		return promo_prov;
	}

	public void setPromo_prov(String promo_prov) {
		this.promo_prov = promo_prov;
	}

	public String getPromo_city() {
		return promo_city;
	}

	public void setPromo_city(String promo_city) {
		this.promo_city = promo_city;
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

	public int getPagelength() {
		return pagelength;
	}

	public void setPagelength(int pagelength) {
		this.pagelength = pagelength;
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
