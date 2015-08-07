package com.poly.action.action_data;

import java.io.IOException;
import java.io.PrintWriter;

import net.sf.json.JSONArray;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class ServiceDeleteProjectAction extends MyActionSupport{
	
	private String pro_num;
	
	public void back() throws IOException{
		ProjectService projectService = ProjectService.getInstance();
		String back = projectService.deleteProjectByProNum(pro_num);
		response.getWriter().write(back);
	}
	public void backBl() throws IOException{
		ProjectService projectService = ProjectService.getInstance();
		String back = projectService.deleteBlProjectByProNum(pro_num);
		response.getWriter().write(back);
	}
	public String getPro_num() {
		return pro_num;
	}

	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
	}
	
	
}
