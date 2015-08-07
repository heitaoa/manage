package com.poly.action.action_data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class ServiceShowMyActivityAction extends MyActionSupport{
	public static final String CUSTOM_DEPT_CODE = "16";
	private Map<String,String>info = new HashMap<String,String>();
	private List<Map<String,String>>onGoing = new ArrayList<Map<String,String>>();
	private List<Map<String,String>>end = new ArrayList<Map<String,String>>();
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
		onGoing = projectService.findProjectsByUseridAndState(id,2);//2--正在进行
		end = projectService.findProjectsByUseridAndState(id,3);//3--已结束
		return SUCCESS;
	}
	public Map<String, String> getInfo() {
		return info;
	}
	public void setInfo(Map<String, String> info) {
		this.info = info;
	}
	public List<Map<String, String>> getOrglist() {
		return orglist;
	}
	public void setOrglist(List<Map<String, String>> orglist) {
		this.orglist = orglist;
	}
	public List<Map<String, String>> getOnGoing() {
		return onGoing;
	}
	public void setOnGoing(List<Map<String, String>> onGoing) {
		this.onGoing = onGoing;
	}
	public List<Map<String, String>> getEnd() {
		return end;
	}
	public void setEnd(List<Map<String, String>> end) {
		this.end = end;
	}
	public List<Map<String, String>> getCustomServices() {
		return customServices;
	}
	public void setCustomServices(List<Map<String, String>> customServices) {
		this.customServices = customServices;
	}
	
}
