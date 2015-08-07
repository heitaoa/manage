package com.poly.action.action_index;

import com.poly.action.MyActionSupport;



public class Index extends MyActionSupport {
	

	private boolean admin;

	// ��ҳ
	public String execute() {
		System.out.println(">>> welcome login");
		//String name = CookieManager.getCookieValue(request, Constant.COOKIE_USERNAME);
		//System.out.println("name:"+this.getUser().getUsername());
		return SUCCESS;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
