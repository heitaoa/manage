package com.poly.action.action_data;

import java.util.List;
import java.util.Map;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class CountBaomingChannelAction extends MyActionSupport{
	private String start;
	private String end;
	private List<Map<String,String>> list;
	public String execute(){
		ProjectService projectService = new ProjectService();
		list = projectService.getCountBaomingChannelList(start,end);
		return SUCCESS;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public List<Map<String, String>> getList() {
		return list;
	}
	public void setList(List<Map<String, String>> list) {
		this.list = list;
	}
	
}
