package com.poly.action.action_data;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class ServiceGetDeptPersonAction extends MyActionSupport{
	public void back() throws IOException{
		String userid = (String) session.get("userid");
		ProjectService projectService = ProjectService.getInstance();
		Map<String,String> orgAndDep = projectService.findOrgAndDepById(userid);
		String org = orgAndDep.get("org_code");
		String dep = orgAndDep.get("dep_code");
		List<Map<String,String>> list = projectService.findUsersByCode(org, dep, null);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(list);
		out.print(json.toString());
		
	}
}
