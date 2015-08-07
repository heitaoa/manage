package com.poly.action.action_data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import car_beans.TbDataActDetail;
import car_beans.TbDataProject;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class ServiceEnterKCTEditQiandaoAction extends MyActionSupport{
	private int page = 1;
	private int pages;
	public static final int pageSize=10;
	private String acti_name;
	private String pro_num;
	private List<Map<String,String>> list ;
	private List<Map<String,String>> models;
	private List<Map<String,String>>givings;
	private List<String> pageList;
	private Map<String,String> info = new HashMap<String,String>();
	private TbDataProject  project ;
	private List<Map<String,String>> deptPerson = new ArrayList<Map<String,String>>();
	public String execute(){
		ProjectService projectService = ProjectService.getInstance();
		project = projectService.getProjectByProNum(pro_num);
//		list = projectService.findKctBaomingListByPage(page,pageSize,project);
		list = projectService.findKctQiandaoListByPage(page,pageSize,pro_num);
//		totalPage = projectService.getKctBaomingTotalPage(pageSize, project);
		pages = projectService.getKctQiandaoTotalPage(pageSize, pro_num);
		acti_name = projectService.getProjectByProNum(pro_num).getActi_name();
		givings = projectService.getGivings();
		models = projectService.findKctModelsByProNum(pro_num);
		pageList = getPageList(page, pages, 2);
		TbDataActDetail actDetail = projectService.findActDetailByProNum(pro_num);
		String acti_name = projectService.getProjectByProNum(pro_num).getActi_name();
		if(actDetail.getDetail_id()!=0){
			info.put("detail_executor", actDetail.getDetail_executor());
			info.put("detail_assist_person", actDetail.getDetail_assist_person());
			info.put("detail_acti_date", new SimpleDateFormat("yyyy-MM-dd").format(actDetail.getDetail_acti_date()));
			info.put("detail_time_interval", actDetail.getDetail_time_interval()+"");
			info.put("detail_traffic_expense", actDetail.getDetail_traffic_expense());
			info.put("detail_acti_sub", actDetail.getDetail_acti_sub());
			info.put("detail_acti_report", actDetail.getDetail_acti_report());
			info.put("detail_acti_addr",actDetail.getDetail_acti_addr() );
			info.put("acti_name",acti_name );
		}
		String userid = (String) session.get("userid");
		Map<String,String> orgAndDep = projectService.findOrgAndDepById(userid);
		String org = orgAndDep.get("org_code");
		String dep = orgAndDep.get("dep_code");
		deptPerson = projectService.findUsersByCode(org, dep, null);
		return 	SUCCESS;
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
	public String getActi_name() {
		return acti_name;
	}
	public void setActi_name(String acti_name) {
		this.acti_name = acti_name;
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
	public List<Map<String, String>> getModels() {
		return models;
	}
	public void setModels(List<Map<String, String>> models) {
		this.models = models;
	}
	public List<Map<String, String>> getList() {
		return list;
	}
	public void setList(List<Map<String, String>> list) {
		this.list = list;
	}
	public List<Map<String, String>> getGivings() {
		return givings;
	}
	public void setGivings(List<Map<String, String>> givings) {
		this.givings = givings;
	}
	public List<String> getPageList() {
		return pageList;
	}
	public void setPageList(List<String> pageList) {
		this.pageList = pageList;
	}
	public Map<String, String> getInfo() {
		return info;
	}
	public void setInfo(Map<String, String> info) {
		this.info = info;
	}
	public List<Map<String, String>> getDeptPerson() {
		return deptPerson;
	}
	public void setDeptPerson(List<Map<String, String>> deptPerson) {
		this.deptPerson = deptPerson;
	}
	public TbDataProject getProject() {
		return project;
	}
	public void setProject(TbDataProject project) {
		this.project = project;
	}
	
	
	
} 
