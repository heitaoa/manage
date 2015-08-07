package com.poly.action.action_data;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class CountKctSignAction extends MyActionSupport {
	public String pro_num;
	List<Map<String, String>> signList;
	
	public void getSignTable() throws IOException{
		signList = ProjectService.getInstance().getSignTable(pro_num);
		
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(signList);
		out.print(json.toString());
	}

	public String getPro_num() {
		return pro_num;
	}

	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
	}

	public List<Map<String, String>> getSignList() {
		return signList;
	}

	public void setSignList(List<Map<String, String>> signList) {
		this.signList = signList;
	}
	
	
}
