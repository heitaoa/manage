 package com.poly.action;

//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import car_beans.DboCarCatalognew;

import com.poly.action.MyActionSupport;
import com.poly.service.AdminService;
import com.poly.service.LeftMenuService;
import com.poly.service.LoginService;
import com.poly.service.SaleFavoredService;
import com.poly.util.ChangeSiteUtil;
import com.poly.util.Constant;
import com.poly.util.CookieManager;
import com.poly.util.MD5;

public class Login extends MyActionSupport {

	private String password;

	private String username;
	
	LoginService loginService;
	
	private int loginCheck = 0;
	List<String> keyNames = null;
	Map<String, Object> map = null;
	private String rdStr = "";
	public String getRdStr() {
		return rdStr;
	}

	public void setRdStr(String rdStr) {
		this.rdStr = rdStr;
	}

	public String execute() throws UnsupportedEncodingException {
		//System.out.println("Login.execute()  >>> ");
		/*Cookie loginCookie = CookieManager.getCookie(request, Constant.COOKIE_NAME);
		String userid = null;
		if (loginCookie != null) {
			String cookieValue = loginCookie.getValue();
			userid = cookieValue.split("/")[1];
			String name = URLDecoder.decode(cookieValue.split("/")[3],"utf-8");
			
			
			Map<String,Object> map = LoginService.getInstance().getUserInfos(userid);
			//map.ulevel 用户权限  0-系统管理员 1-大客户回访人员  2-销售 3-客服  4-总站编辑 5-分站编辑  6-分站管理员
			map.put("userid", userid);
			map.put("username", name);
			map.put("sub_sites_id",ChangeSiteUtil.getSite(1)+"");//315分站
			map.put("sub_sites_id2","1");//财务分站
			session.put("userInfo", map);
			List<Object> list =  LeftMenuService.getInstance().getLeftMenu(map.get("ulevel").toString());
			keyNames = (List<String>)list.get(0);
			map = (Map<String, Object>)list.get(1);
			session.put("map", map);
			session.put("keyNames", keyNames);
			session.put("userid", userid);
			session.put("name", name);
		}*/
		rdStr = System.currentTimeMillis()+"";
			return SUCCESS;
	}
	
	public String setLogin() throws UnsupportedEncodingException{
		System.err.println("unlogin..");
		/*//System.out.println("login start");
		String name = "系统管理员";
		String cooValue = "1/" + "Poly0040" + "/" + 1
				+ "/"+ java.net.URLEncoder.encode(name,"utf-8")+"/appid/1/";
		CookieManager.setCookie(request, response, cooValue);

		System.out.println("Login.setLogin() end");*/
		return SUCCESS;
	}
	
	public void login315() throws IOException{
		
		String flag = "0";
		String token = "";
		try {
			String username = "吴浩";
			//String userid = URLDecoder.decode(request.getParameter("userid"), "utf-8");
			String userid = "Poly0044";
			String siteid = "0";
			String type = "315che";
			token = "5722f79876bfec4ad54d9ec74b7151b3";
			String realToken = createToken();
			Map<String,Object> map = LoginService.getInstance().getUserInfos(userid);
			if(realToken.equals(token)&&map.size()!=0){
				flag  = "1";
				//map.ulevel 用户权限  0-系统管理员 1-大客户回访人员  2-销售 3-客服  4-总站编辑 5-分站编辑  6-分站管理员
				map.put("userid", userid);
				map.put("username", username);
				map.put("sub_sites_id",ChangeSiteUtil.getSite(Integer.parseInt(siteid))+"");//315分站
				/*if("3".equals(map.get("ulevel"))){
					String pro_nums = LoginService.getInstance().queryTuiguangPro(userid);
					session.put("pro_nums", pro_nums);
					
				}*/
				session.clear();
				String pro_nums = LoginService.getInstance().queryTuiguangPro(userid);
				session.put("pro_nums", pro_nums);
				session.put("ulevel", map.get("ulevel"));
				session.put("prov", map.get("prov"));
				session.put("city", map.get("city"));
				session.put("brands", map.get("brands"));
				map.put("sub_sites_id2",siteid);//财务分站
				session.put("userInfo", map);
				session.put("site_name", map.get("site_name"));
				List<Object> list =  LeftMenuService.getInstance().getLeftMenu(map.get("detail").toString(),type);
				keyNames = (List<String>)list.get(0);
				Map<String,Object> mapx = (Map<String, Object>)list.get(1);
				session.put("map", mapx);
				session.put("keyNames", keyNames);
				session.put("type", type);
				session.put("userid", userid);
				session.put("name", username);
				session.put("realName", map.get("realName"));
				session.put("siteid", siteid);
				
				//String oldid = AdminService.getInstance().getOldUser(username);
				String oldid = AdminService.getInstance().getOldUser(userid);
				session.put("oldid", oldid);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String jsonp=request.getParameter("jsonpcallback");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		out.print(jsonp+"("+flag+")");
	}
	
	String createToken(){
		String token = "";
		String key1 = "www.finance.chetuan.com";
		String key2 = "www.315che.com";
		String key3 = "0f1340da76c0305a793ad45b69bc01b0";
		token = MD5.toMD5(key1+key2+key3);
		return token;
	}
	
	public String logout(){
		CookieManager.delCookie(request, response, Constant.COOKIE_NAME);
		return SUCCESS;
	}
	
	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getLoginCheck() {
		return loginCheck;
	}

	public void setLoginCheck(int loginCheck) {
		this.loginCheck = loginCheck;
	}

	public List<String> getKeyNames() {
		return keyNames;
	}

	public void setKeyNames(List<String> keyNames) {
		this.keyNames = keyNames;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
}
