package com.poly.action.action_data;

import java.io.IOException;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class ServiceEndProjectAction extends MyActionSupport{
	private String pro_num;
	public void back() throws IOException{
		String back = ProjectService.getInstance().endProject(pro_num);
		response.getWriter().write(back);
	}
	public String getPro_num() {
		return pro_num;
	}
	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
	}
	
}
