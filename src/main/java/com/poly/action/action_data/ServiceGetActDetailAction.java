package com.poly.action.action_data;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import car_beans.TbDataActDetail;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class ServiceGetActDetailAction extends MyActionSupport{
	
	private String pro_num;
	
	public void back() throws IOException{
		ProjectService projectService = ProjectService.getInstance();
		TbDataActDetail actDetail = projectService.findActDetailByProNum(pro_num);
		String acti_name = projectService.getProjectByProNum(pro_num).getActi_name();
		Map<String,String> info = new HashMap<String,String>();
		if(actDetail.getDetail_id()!=0){
			info.put("detail_executor", actDetail.getDetail_executor());
			info.put("detail_assist_person", actDetail.getDetail_assist_person());
			info.put("detail_acti_date", new SimpleDateFormat("yyyy-MM-dd").format(actDetail.getDetail_acti_date()));
			info.put("detail_time_interval", actDetail.getDetail_time_interval()+"");
			info.put("detail_traffic_expense", actDetail.getDetail_traffic_expense());
			info.put("detail_acti_sub", actDetail.getDetail_acti_sub());
			info.put("detail_acti_report", actDetail.getDetail_acti_report());
			info.put("detail_acti_addr",actDetail.getDetail_acti_addr() );
			info.put("acti_name",acti_name );
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
