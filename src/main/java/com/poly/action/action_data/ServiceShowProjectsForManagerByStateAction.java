package com.poly.action.action_data;

import com.poly.action.MyActionSupport;

public class ServiceShowProjectsForManagerByStateAction extends MyActionSupport {
	
	private int state;//1--待审核
	public String execute(){
		
		return SUCCESS;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	 
}
