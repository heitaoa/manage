package com.poly.action.action_data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import car_beans.TbDataProject;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class ServiceShowMyProjectsAction extends MyActionSupport{
	public static final String CUSTOM_DEPT_CODE = "16";
	
	private List<Map<String,String>> onGoing = new ArrayList<Map<String,String>>() ;
	
	private List<Map<String,String>> ended = new ArrayList<Map<String,String>>();
	
	private Map<String,String>info = new HashMap<String,String>();
	
	private List<Map<String,String>>customServices = new ArrayList<Map<String,String>>();
	
	private List<Map<String,String>>brands = new ArrayList<Map<String,String>>();
	
	public String execute(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String sysdate = sdf.format(new Date());
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
		info.put("sysdate", new SimpleDateFormat ("yyyy-MM-dd").format(new Date()));
		String orgCode = orgAndDep.get("org_code");
		if("1".equals(orgCode)||"0".equals(orgCode)){
			customServices = projectService.findUsersByCode("0",CUSTOM_DEPT_CODE,null);
		}else{
			customServices = projectService.findUsersByCode(orgCode,null,null);
		}	
		List<Map<String,String>> all = projectService.finProjectsById(id);
		for(Map<String,String> p:all){
			if(Integer.parseInt(sysdate)>Integer.parseInt(p.get("acti_exec_date"))){
				ended.add(p);
			}else{
				onGoing.add(p);
			}
		}
		
		return SUCCESS;
	}
	public List<Map<String,String>> getOnGoing() {
		return onGoing;
	}

	public void setOnGoing(List<Map<String,String>> onGoing) {
		this.onGoing = onGoing;
	}

	public List<Map<String,String>> getEnded() {
		return ended;
	}

	public void setEnded(List<Map<String,String>> ended) {
		this.ended = ended;
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
	public List<Map<String, String>> getBrands() {
		return brands;
	}
	public void setBrands(List<Map<String, String>> brands) {
		this.brands = brands;
	}
	
	
}
