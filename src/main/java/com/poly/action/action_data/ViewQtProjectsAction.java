package com.poly.action.action_data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class ViewQtProjectsAction extends MyActionSupport {
	private List<Map<String,String>> list ;
	private Map<String,String>info = new HashMap<String,String>();
	private List<Map<String,String>>customServices;
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
			list = ProjectService.getInstance().getQtProjects("0");
		}else{
			customServices = projectService.findUsersByCode(orgCode,null,null);
			list = ProjectService.getInstance().getQtProjects(orgCode);
		}
		return SUCCESS;
	}

	public List<Map<String, String>> getList() {
		return list;
	}

	public void setList(List<Map<String, String>> list) {
		this.list = list;
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
	
}
