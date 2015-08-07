package com.poly.action.action_groupBuy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.poly.action.MyActionSupport;
import com.poly.service.SendMsgService;

public class SendMsgAction extends MyActionSupport{
	private String msg = "";
	private String phones = "";
	private int flag = -1;
	public String execute(){
		return SUCCESS;
	}
	public String sendMsg(){
		//System.err.println(msg);
		//System.err.println(phones);
		String[] phoneArry = phones.split(",");
		List<HashMap<String, String>> phoneList = new ArrayList<HashMap<String,String>>();
		HashMap<String, String> map = null;
		for (String phone : phoneArry) {
			map = new HashMap<String, String>();
			map.put("msg",msg);
			map.put("phone", phone);
			phoneList.add(map);
		}
		
		flag = SendMsgService.getInstance().sendMsg(phoneList);
		return SUCCESS;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getPhones() {
		return phones;
	}
	public void setPhones(String phones) {
		this.phones = phones;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}

}
