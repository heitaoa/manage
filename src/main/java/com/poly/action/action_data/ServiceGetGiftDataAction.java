package com.poly.action.action_data;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class ServiceGetGiftDataAction extends MyActionSupport{
	
	private String pro_num;
	public void getGiftData() throws IOException{
		
		ProjectService projectService = ProjectService.getInstance();
		Map<String,Map<String,String>> result = projectService.getGiftDataByProNum(pro_num);
		List<Map<String,String>> info = new ArrayList<Map<String,String>>();
		for(String key:result.keySet()){
			info.add(result.get(key));
		}
		response.setContentType("text/html;charset=gbk");
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
