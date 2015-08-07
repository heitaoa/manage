package com.poly.action.action_data;

import java.util.List;
import java.util.Map;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class ServiceShowProjectForExamineAction extends MyActionSupport {
	private List<Map<String, String>> projectList;
	public String execute(){
		String userid = (String) session.get("userid");
		Map<String, String> orgAndDep = ProjectService.getInstance().findOrgAndDepById(userid);
		projectList = ProjectService.getInstance().getProjectForServiceExamine(userid,orgAndDep);
		return SUCCESS;
	}
	public List<Map<String, String>> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<Map<String, String>> projectList) {
		this.projectList = projectList;
	}
	
}
