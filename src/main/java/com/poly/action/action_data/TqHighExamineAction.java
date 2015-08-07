package com.poly.action.action_data;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.poly.action.MyActionSupport;
import com.poly.service.TiquService;

public class TqHighExamineAction extends MyActionSupport {
	private TiquService tiquService = TiquService.getInstance();
	
	private List<Map<String, String>> proList;
	private String tiqu_num = "";
	private String deny_cause = "";
	private int is_deduct = 0;
	
	public String execute(){
		proList = tiquService.getProListForHighExamine();
		return SUCCESS;
	}
	
	public void allow() throws IOException{
		int result = tiquService.hightExamineYes(tiqu_num, is_deduct);
		
		response.setContentType("text/html;charset=gbk");
		response.getWriter().write("" + result);
	}
	
	public void deny() throws IOException{
		int result = tiquService.hightExamineNo(tiqu_num, deny_cause);
		
		response.setContentType("text/html;charset=gbk");
		response.getWriter().write("" + result);
	}

	public List<Map<String, String>> getProList() {
		return proList;
	}

	public void setProList(List<Map<String, String>> proList) {
		this.proList = proList;
	}

	public String getTiqu_num() {
		return tiqu_num;
	}

	public void setTiqu_num(String tiqu_num) {
		this.tiqu_num = tiqu_num;
	}

	public String getDeny_cause() {
		return deny_cause;
	}

	public void setDeny_cause(String deny_cause) {
		this.deny_cause = deny_cause;
	}

	public int getIs_deduct() {
		return is_deduct;
	}

	public void setIs_deduct(int is_deduct) {
		this.is_deduct = is_deduct;
	}
}
