package com.poly.interceptor;

//import java.util.Map;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.poly.util.Constant;
import com.poly.util.CookieManager;
import com.poly.util.FieldUtil;

public class CheckLogin implements Interceptor {

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {
//		Object user = invocation.getInvocationContext().getSession().get("user");
//		if (user == null) {
//			
//		}

		/*HttpServletRequest request = ServletActionContext.getRequest();
		Cookie userCookie = CookieManager.getCookie(request, Constant.COOKIE_NAME);
		
		if (userCookie==null)
			return "relogin";*/
//		return Action.LOGIN;
		
		Object userInfo = ServletActionContext.getRequest().getSession().getAttribute("userInfo");

		//System.out.println("userInfo============>>" + userInfo);

		if (userInfo==null)
			return "relogin";
		
		/*
		 String username = null;
		if (userCookie != null) {
			String cookieValue = userCookie.getValue();
			username = cookieValue.split("/")[1];
		}

		if (FieldUtil.isEmpty(username)) {
			return Action.LOGIN;
		}
		// ������Щ����������Ȩ���жϵ�,�ȴӶ�ȡ�������ļ���
		Object obj = invocation.getInvocationContext().getParameters().get("cid");
		String cidstr = null;
		if (obj instanceof String[]) {
			cidstr = ((String[]) obj)[0];
		} else if (obj instanceof String) {
			cidstr = (String) obj;
		}
		Map<String, Object> userinfo = (Map<String, Object>) invocation.getInvocationContext().getSession().get("userInfo");
		if (userinfo == null)
			return invocation.invoke();
		String actionname = invocation.getInvocationContext().getName();
		if (userinfo.get("ulevel").toString().equals("2") || userinfo.get("ulevel").toString().equals("3")) {
			if (actionname.equals("groupBuyManage") || actionname.equals("groupBuyApply") || actionname.equals("groupBuyReturnVisit") || actionname.equals("getCarBrand") || actionname.equals("getRevman") || actionname.equals("getCars")
					|| actionname.equals("getCityInfo") || actionname.equals("getCheXing") || actionname.equals("getDetail") || actionname.equals("downBaoming") || actionname.equals("saveApply") || actionname.equals("signExcel")
					|| actionname.equals("backExcel") || actionname.equals("getCarBrand2") || actionname.equals("getCarsx") || actionname.equals("getCars2x") || actionname.equals("stationAdmin") || actionname.equals("updateStationUser")
					|| actionname.equals("deleteStationUser") || actionname.equals("addStationUser") || actionname.equals("stationUserPwd") || actionname.equals("changeStationUserPwd") || actionname.equals("applyDetail")
					|| actionname.equals("deleteApply") || actionname.equals("applyDetailUpdate") || actionname.equals("applyDetail2") || actionname.equals("applyDetailUpdate2") || actionname.equals("tuisong") || actionname.equals("getChartCount")
					|| actionname.equals("addGroupBuy") || actionname.equals("groupBuyMsg") || actionname.equals("sendMsg") || actionname.equals("toSendMsg") || actionname.equals("sendMsgs")) {
				return invocation.invoke();
			} else {
				return "index";
			}
		}
		 */
		return invocation.invoke();
	}

}
