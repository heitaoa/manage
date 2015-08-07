package com.poly.action.action_data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class NewQtProjectAction extends MyActionSupport {
	private Map<String,String>info = new HashMap<String,String>();
	private List<Map<String,String>>customServices;
	private List<Map<String,String>> iways;
	private Set<String> iways_select;
	public static final String CUSTOM_DEPT_CODE = "16";
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
		if("1".equals(orgCode)||"0".equals(orgCode)){
			customServices = projectService.findUsersByCode("0",CUSTOM_DEPT_CODE,null);
		}else{
			customServices = projectService.findUsersByCode(orgCode,null,null);
		}
		
		iways = projectService.getIways();
		iways_select = projectService.getIwaysSelect(orgAndDep.get("org_code"));
		return SUCCESS;
	}
	public Map<String, String> getInfo() {
		return info;
	}
	public void setInfo(Map<String, String> info) {
		this.info = info;
	}
	public List<Map<String, String>> getCustomServices() {
		return customServices;
	}
	public void setCustomServices(List<Map<String, String>> customServices) {
		this.customServices = customServices;
	}
	public List<Map<String, String>> getIways() {
		return iways;
	}
	public void setIways(List<Map<String, String>> iways) {
		this.iways = iways;
	}
	public Set<String> getIways_select() {
		return iways_select;
	}
	public void setIways_select(Set<String> iways_select) {
		this.iways_select = iways_select;
	}
	
}
