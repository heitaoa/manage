package com.poly.action.action_data;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import net.sf.json.JSONArray;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class ServiceGetQiandaoInfoAction extends MyActionSupport{
	private int record_id;
	public void back() throws Exception{
		Map<String,String>info = ProjectService.getInstance().getQiandaoInfoByRecordId(record_id);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(info);
		out.print(json.toString());
	}
	public int getRecord_id() {
		return record_id;
	}
	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}
	
}	
