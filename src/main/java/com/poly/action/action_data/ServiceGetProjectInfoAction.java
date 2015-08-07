package com.poly.action.action_data;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import net.sf.json.JSONArray;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class ServiceGetProjectInfoAction extends MyActionSupport{
	private String pro_num;
	
	
	public void back() throws IOException{
		ProjectService projectService = ProjectService.getInstance();
		Map info = projectService.getProjectInfoByProNum(pro_num);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(info);
		out.print(json.toString());
	}
	public void backBl() throws IOException{
		ProjectService projectService = ProjectService.getInstance();
		Map info = projectService.getBlProjectInfoByProNum(pro_num);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(info);
		out.print(json.toString());
	}
	
	public String getPro_num() {
		return pro_num;
	}

	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
	}
	
}
