package com.poly.action.action_data;

import java.io.IOException;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class ServiceExamineProjectAction extends MyActionSupport{
	private String state;
	
	private String pro_num;
	
	public void back() throws IOException{
		String back = ProjectService.getInstance().examineProjectForService(pro_num,state);
		response.getWriter().write(back);
	}
	public void backBl() throws IOException{
		String back = ProjectService.getInstance().examineBlProjectForService(pro_num,state);
		response.getWriter().write(back);
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPro_num() {
		return pro_num;
	}

	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
	}
	
	
}
