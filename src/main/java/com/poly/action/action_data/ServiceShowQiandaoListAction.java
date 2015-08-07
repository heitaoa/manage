package com.poly.action.action_data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;
import com.poly.util.PageUtilNew;

public class ServiceShowQiandaoListAction extends MyActionSupport{
	private String pro_num;
	private int page;
	private int pages;
	private List<String> pageList;
	public static final int pageSize=10;
	private List<Map<String,String>> list = new ArrayList<Map<String,String>>();
	public String execute(){
		ProjectService projectService = ProjectService.getInstance();
		list = projectService.findKctQiandaoListForViewByPage(page,pageSize, pro_num);
		pages = projectService.getKctQiandaoTotalPage(pageSize, pro_num);
		pageList = PageUtilNew.getPageListNew(page, pages, 5);
		return SUCCESS;
	}
	private List<String> getPageList(int ipage, int ipages, int ipageLength){
		List<String> pList = new ArrayList<String>();
		if (ipages<ipageLength) {
			for (int i = 1; i < ipages + 1; i++) {
				pList.add(String.valueOf(i));
			}
		}else {
			if (ipage<ipageLength) {
				for (int i = 1; i < ipageLength + 1; i++) {
					pList.add(String.valueOf(i));
				}
			}else if (ipages-ipage>ipageLength-2) {
				for (int i = ipage; i < ipageLength + ipage; i++) {
					pList.add(String.valueOf(i));
				}
			}else {
				for (int i = ipages - ipageLength + 1; i < ipages; i++) {
					pList.add(String.valueOf(i));
				}
			}
		}
		return pList;
	}
	public String getPro_num() {
		return pro_num;
	}
	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
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
	public List<Map<String, String>> getList() {
		return list;
	}
	public void setList(List<Map<String, String>> list) {
		this.list = list;
	}
	public List<String> getPageList() {
		return pageList;
	}
	public void setPageList(List<String> pageList) {
		this.pageList = pageList;
	}
	
}
