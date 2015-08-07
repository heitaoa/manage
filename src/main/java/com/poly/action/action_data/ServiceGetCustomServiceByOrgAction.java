package com.poly.action.action_data;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class ServiceGetCustomServiceByOrgAction extends MyActionSupport{
	public static final String CUSTOM_DEPT_CODE = "16";
	private String org;
	public void back() throws IOException{
		List<Map<String,String>>customServices = null;
		if("1".equals(org)||"0".equals(org)){
			customServices = ProjectService.getInstance().findUsersByCode("0",CUSTOM_DEPT_CODE,null);
		}else{
			customServices = ProjectService.getInstance().findUsersByCode(org,null,null);
		}
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(customServices);
		out.print(json.toString());
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	
}
