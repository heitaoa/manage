package com.poly.action.action_data;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class ServiceSaveEditKctQiandaoAction extends MyActionSupport{
	
	private String data;
	
	public void back() throws IOException{
		ProjectService projectService = ProjectService.getInstance();
		List<Map<String,String>>list = projectService.JsonToBaomingInfoList(data);
//		String back = projectService.saveBaomingInfo(list);
		String back = projectService.saveQiandaoInfo(list);
		response.setContentType("text/html;charset=gbk");
		response.getWriter().write(back);
	}
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
