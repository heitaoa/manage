package com.poly.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.poly.util.Constant;
import com.poly.util.CookieManager;
import com.poly.util.FieldUtil;
import com.poly.util.MyConfig;

@SuppressWarnings("serial")
public class MyActionSupport extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware {

	public static final String AJAX = "ajax";

	private String ajax;

	private String err = "";

	protected Map<Object, Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;

	protected String che_url;
	protected String admin_che_url;
	protected String img_che_url;
	protected String wap_ct_url;
	protected String inf_che_url;
	protected String chezhan_che_url;
	protected String zt_che_url;
	
	protected String imgupload_che_url;

	public String getErr() {
		return err;
	}

	public FieldUtil getFieldutil() {
		return FieldUtil.getInstance();
	}

	public String getUrl() {
		return ActionContext.getContext().getName() + ".action";
	}

	public String getUsername() {
		// ��session��ȡ
		// return (String)
		// ActionContext.getContext().getSession().get(Constant.SESSION_USER);
		// HttpServletRequest request = ServletActionContext.getRequest();//
		// ���ַ���
		// Cookie userCookie = CookieManager.getCookie(request,
		// Constant.COOKIE_NAME);
		// String username = "";
		// if (userCookie != null) {
		// String cookieValue = userCookie.getValue();
		// username = cookieValue.split("/")[0];
		// } else {
		// username = "";
		// }
		// return username;
		return CookieManager.getCookieValue(request, Constant.COOKIE_USERNAME);
	}

	public void setErr(String e) {
		err = e;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void setSession(Map arg0) {
		this.session = arg0;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public String getAjax() {
		return ajax;
	}

	public void setAjax(String ajax) {
		this.ajax = ajax;
	}

	public String getChe_url() {
		return MyConfig.che_url;
	}

	public String getAdmin_che_url() {
		return MyConfig.admin_che_url;
	}

	public String getimg_che_url() {
		return MyConfig.img_che_url;
	}
	
	public String getImg_che_url() {
		return MyConfig.img_che_url;
	}

	public String getWap_ct_url() {
		return MyConfig.wap_ct_url;
	}

	public String getInf_che_url() {
		return MyConfig.inf_che_url;
	}
	
	public String getImgupload_che_url() {
		return MyConfig.imgupload_che_url;
	}

	public String getChezhan_che_url() {
		return MyConfig.chezhan_che_url;
	}

	public String getZt_che_url() {
		return MyConfig.zt_che_url;
	}
	

}
