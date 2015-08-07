package com.poly.action.action_data;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.action.MyActionSupport;
import com.poly.service.TiquService;

public class TqDirExamineAction extends MyActionSupport {
	private TiquService tiquService = TiquService.getInstance();
	
	private List<Map<String, String>> proList;
	private String tiqu_num = "";
	private String deny_cause = "";
	
	public String execute(){
		String user_id = (String)session.get("userid");
		Map<String, String> userInfo = tiquService.getUserinfo(user_id);
		Map<String, String> whereMap = new HashMap<String, String>();
		whereMap.put("user_id", user_id);
		whereMap.put("dept_code", userInfo.get("dept_code"));
		whereMap.put("org_code", userInfo.get("org_code"));
		
		proList = tiquService.getProListForDirExamine(whereMap);
		
		return SUCCESS;
	}
	
	public void allow() throws IOException{
		int result = tiquService.dirExamineYes(tiqu_num);
		
		response.setContentType("text/html;charset=gbk");
		response.getWriter().write("" + result);
	}
	
	public void deny() throws IOException{
		int result = tiquService.dirExamineNo(tiqu_num, deny_cause);
		
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
	
	
}
