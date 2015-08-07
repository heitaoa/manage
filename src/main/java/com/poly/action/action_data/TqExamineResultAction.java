package com.poly.action.action_data;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.action.MyActionSupport;
import com.poly.service.TiquService;

public class TqExamineResultAction extends MyActionSupport {
	
	private TiquService tiquService = TiquService.getInstance();
	
	private List<Map<String, String>> proList;
	private String tiqu_num = "";
	
	public String execute(){
		String user_id = (String)session.get("userid");
		Map<String, String> whereMap = new HashMap<String, String>();
		whereMap.put("user_id", user_id);
		
		proList = tiquService.getExamineResult(whereMap);
		
		return SUCCESS;
	}
	
	public void executeYes() throws IOException{
		int result = tiquService.perExecute(tiqu_num, 1);
		
		response.setContentType("text/html;charset=gbk");
		response.getWriter().write("" + result);
	}
	
	public void executeNo() throws IOException{
		int result = tiquService.perExecute(tiqu_num, 2);
		
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
}
