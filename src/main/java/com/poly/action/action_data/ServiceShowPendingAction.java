package com.poly.action.action_data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class ServiceShowPendingAction extends MyActionSupport{
	public static final String CUSTOM_DEPT_CODE = "16";
	private Map<String,String>info = new HashMap<String,String>();
	private List<Map<String,String>>list = new ArrayList<Map<String,String>>();
	private List<Map<String,String>>bl = new ArrayList<Map<String,String>>();
	private List<Map<String,String>>orglist = new ArrayList<Map<String,String>>();
	
	private List<Map<String,String>>customServices;
	public String execute(){
		String id = (String)session.get("userid");
		String name = (String)session.get("name");
		ProjectService projectService = ProjectService.getInstance();
		Map<String,String> orgAndDep = projectService.findOrgAndDepById(id);
		info.put("id", id);
		info.put("name", name);
		info.put("orgName",orgAndDep.get("org_name"));
		info.put("depName",orgAndDep.get("dep_name"));
		info.put("orgCode",orgAndDep.get("org_code"));
		info.put("depCode",orgAndDep.get("dep_code"));
		String orgCode = orgAndDep.get("org_code");
		orglist = ProjectService.getInstance().getOrgList();
		if("1".equals(orgCode)||"0".equals(orgCode)){
			customServices = projectService.findUsersByCode("0",CUSTOM_DEPT_CODE,null);
		}else{
			customServices = projectService.findUsersByCode(orgCode,null,null);
		}
		info.put("sysdate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		list = projectService.findProjectsByUseridAndState(id,1);//1--审核中
		bl = projectService.findProjectsBlByUseridAndState(id,1);//1--审核中
		return SUCCESS;
	}
	public Map<String, String> getInfo() {
		return info;
	}
	public void setInfo(Map<String, String> info) {
		this.info = info;
	}
	public List<Map<String, String>> getList() {
		return list;
	}
	public void setList(List<Map<String, String>> list) {
		this.list = list;
	}
	public List<Map<String, String>> getBl() {
		return bl;
	}
	public void setBl(List<Map<String, String>> bl) {
		this.bl = bl;
	}
	public List<Map<String, String>> getOrglist() {
		return orglist;
	}
	public void setOrglist(List<Map<String, String>> orglist) {
		this.orglist = orglist;
	}
	public List<Map<String, String>> getCustomServices() {
		return customServices;
	}
	public void setCustomServices(List<Map<String, String>> customServices) {
		this.customServices = customServices;
	}
	
}
