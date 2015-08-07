package com.poly.action;

import com.poly.util.Constant;
import com.poly.util.CookieManager;

public class LogoutAction extends MyActionSupport{
	public String execute(){
		CookieManager.delCookie(request, response, Constant.COOKIE_NAME);
		session.clear();
		request.getSession().invalidate();
		return SUCCESS;
	}
}
