package com.poly.action.action_admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.LinkedMap;

import net.sf.json.JSONArray;
import car_beans.DboAreCatalog;
import car_beans.TbUserlevel;
import car_beans.TbUsers;

import com.poly.action.MyActionSupport;
import com.poly.bean.TreeEntity;
import com.poly.bean.TreeEntity2;
import com.poly.bean.UserEntity;
import com.poly.service.AdminService;
import com.poly.service.LeftMenuService;
import com.poly.service.SaleFavoredService;
import com.poly.service.TreeService;
import com.poly.util.ChangeSiteUtil;

public class AdminAction extends MyActionSupport{
	private  List<Map<String, Object>> siteList;
	private  List<Map<String, Object>> userList;
	private String userid="";
	private String name = "";
	private String id ="";
	private Map<String, Object> user;
	private List<HashMap<String, Object>> unUsedbrands;
	private int siteProv;
	private List<String> keyNames = null;
	private Map<String,Object> map ;
	public String execute(){
		userList = AdminService.getInstance().getUser(name);
		return SUCCESS;
	}
	public String stationusermanage(){
		Map<String,Object> map = (Map<String, Object>) session.get("userInfo");
		userList = AdminService.getInstance().getStationUser(name,map.get("sub_sites_id2").toString(),map.get("userid").toString());
		return SUCCESS;
	}
	public String adduser(){
		siteList = AdminService.getInstance().getFinanceSite();
		//List<Object> list = LeftMenuService.getInstance().getAllLeftMenu();
		//keyNames = (List<String>)list.get(0);
		//map = (Map<String, Object>)list.get(1);
		return SUCCESS;
	}
	public String addstationuser(){
		Map<String,Object> map = (Map<String, Object>) session.get("userInfo");
		unUsedbrands = AdminService.getInstance().getUnUsedBrands(map.get("sub_sites_id2").toString());
		siteList = AdminService.getInstance().getFinanceSite();
		DboAreCatalog area = AdminService.getInstance().getProvId(map.get("sub_sites_id2").toString());
			if(area.getFatherid()==0)
				siteProv = area.getCatalogid();
			else
				siteProv = area.getFatherid();
		return SUCCESS;
	}
	public void getFinanceUser() throws IOException{
		String siteId = request.getParameter("siteId");
		String name =  URLDecoder.decode(request.getParameter("name"), "utf-8");
		List<Map<String, Object>> users = AdminService.getInstance().getFinanceUser(siteId, name);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(users);
		String jsonp=request.getParameter("jsonpcallback");
		out.print(jsonp+"("+json.toString()+")");
		
	}
	public void checkUser() throws IOException{
		String userid =  URLDecoder.decode(request.getParameter("userid"), "utf-8");;
		int count = AdminService.getInstance().checkUser(userid);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		String jsonp=request.getParameter("jsonpcallback");
		out.print(jsonp+"("+count+")");
		
	}
	public void saveUser() throws Exception{
		String userid = URLDecoder.decode(request.getParameter("userid"), "utf-8");
		String level = URLDecoder.decode(request.getParameter("level"), "utf-8");
		String prov = URLDecoder.decode(request.getParameter("prov"), "utf-8");
		String city = URLDecoder.decode(request.getParameter("city"), "utf-8");
		String brands =URLDecoder.decode(request.getParameter("brands"), "utf-8");
		String detail = request.getParameter("detail");
		if(level!=null&&level.length()>1)
			level = level.substring(0,level.length()-1);
		if(detail!=null&&detail.length()>1)
			detail = detail.substring(0,detail.length()-1);
		
		TbUsers tbUsers = new TbUsers();
		tbUsers.setIsdelete(0);
		tbUsers.setAddtime(new Date());
		tbUsers.setBrands(brands);
		tbUsers.setCity(Integer.parseInt(city));
		tbUsers.setProv(Integer.parseInt(prov));
		tbUsers.setUserid(userid);
		tbUsers.setUlevel(level);
		tbUsers.setDetail(detail);
		AdminService.getInstance().saveUser(tbUsers);
	}
	public void updateUser() throws Exception{
		String userid = URLDecoder.decode(request.getParameter("userid"), "utf-8");
		String level = URLDecoder.decode(request.getParameter("level"), "utf-8");
		String prov = URLDecoder.decode(request.getParameter("prov"), "utf-8");
		String city = URLDecoder.decode(request.getParameter("city"), "utf-8");
		String brands =URLDecoder.decode(request.getParameter("brands"), "utf-8");
		String id = URLDecoder.decode(request.getParameter("id"), "utf-8");
		String detail = request.getParameter("detail");
		if(level!=null&&level.length()>1)
			level = level.substring(0,level.length()-1);
		if(detail!=null&&detail.length()>1)
			detail = detail.substring(0,detail.length()-1);
		TbUsers tbUsers = new TbUsers();
		tbUsers.setBrands(brands);
		tbUsers.setCity(Integer.parseInt(city));
		tbUsers.setProv(Integer.parseInt(prov));
		tbUsers.setUserid(userid);
		tbUsers.setUlevel(level);
		tbUsers.setDetail(detail);
		tbUsers.setId(Integer.parseInt(id));
		int count = AdminService.getInstance().updateUser(tbUsers);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		out.print(count);
	}
	/*public String getUser(){
		userList = AdminService.getInstance().getUser();
		return SUCCESS;
	}*/
	public void deleteUser() throws Exception{
		String id =  URLDecoder.decode(request.getParameter("id"), "utf-8");;
		int count = AdminService.getInstance().deleteUser(id);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		out.print(count);
	}
	public String gotoupdateUser(){
		
		siteList = AdminService.getInstance().getFinanceSite();
		user = AdminService.getInstance().getOneUser(id);
		return SUCCESS;
	}
	public String gotoupdatestationUser(){
		Map<String,Object> map = (Map<String, Object>) session.get("userInfo");
		unUsedbrands = AdminService.getInstance().getUnUsedBrands(map.get("sub_sites_id2").toString());
		siteList = AdminService.getInstance().getFinanceSite();
		user = AdminService.getInstance().getOneUser(id);
		/*DboAreCatalog area = AdminService.getInstance().getProvId(map.get("sub_sites_id").toString());
		if(area.getFatherid()==0)
			siteProv = area.getCatalogid();
		else
			siteProv = area.getFatherid();*/
		return SUCCESS;
	}
	
	public void initCusULevelTree() throws IOException{
		String id = request.getParameter("id");
		List<TreeEntity2> list = TreeService.getInstance().getCusULevelTree(id);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(list);
		out.print(json.toString());
	}
	public List<Map<String, Object>> getSiteList() {
		return siteList;
	}
	public void setSiteList(List<Map<String, Object>> siteList) {
		this.siteList = siteList;
	}
	public List<Map<String, Object>> getUserList() {
		return userList;
	}
	public void setUserList(List<Map<String, Object>> userList) {
		this.userList = userList;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Map<String, Object> getUser() {
		return user;
	}
	public void setUser(Map<String, Object> user) {
		this.user = user;
	}
	public List<HashMap<String, Object>> getUnUsedbrands() {
		return unUsedbrands;
	}
	public void setUnUsedbrands(List<HashMap<String, Object>> unUsedbrands) {
		this.unUsedbrands = unUsedbrands;
	}
	public int getSiteProv() {
		return siteProv;
	}
	public void setSiteProv(int siteProv) {
		this.siteProv = siteProv;
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
