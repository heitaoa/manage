package com.poly.action.action_data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class CountKFAction extends MyActionSupport{
	private String start;
	private String end;
	private String org_code;
	private List<Map<String,String>> orglist;
	private List<String> kfNames;
	private List<String> kfCodes;
	private Map<String,Map<String,String>> map;
	public static final String CUSTOM_DEPT_CODE = "16";
	public String execute(){
		orglist = ProjectService.getInstance().getOrgList();
		
		return SUCCESS;
	}
	public String search() throws ParseException{
		orglist = ProjectService.getInstance().getOrgList();
		if(StringUtils.isEmpty(org_code)){
			org_code="1";
		}
		List<Map<String,String>>customServices;
		ProjectService projectService = ProjectService.getInstance();
		if("1".equals(org_code)||"0".equals(org_code)){
			customServices = projectService.findUsersByCode("0",CUSTOM_DEPT_CODE,null);
		}else{
			customServices = projectService.findUsersByCode(org_code,null,null);
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		if(StringUtils.isEmpty(start)&&StringUtils.isEmpty(end)){
			end = sdf.format(now);
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DAY_OF_MONTH, -7);
			start = sdf.format(c.getTime());
		}
		String users = "";
		kfNames = new ArrayList<String>();
		kfCodes = new ArrayList<String>();
		for(Map<String,String> user:customServices){
			kfNames.add(user.get("name"));
			kfCodes.add(user.get("id"));
			users += "'"+user.get("id")+"',";
		}
		if(users.length()>0){
			users = users.substring(0,users.length()-1);
		}
		map = projectService.countKF(start, end, users);
		
		return SUCCESS;
	}
	public String single() throws ParseException{
		String id = (String)session.get("userid");
		ProjectService projectService = ProjectService.getInstance();
		if(StringUtils.isEmpty(org_code)){
			Map<String,String> orgAndDep = projectService.findOrgAndDepById(id);
			org_code = orgAndDep.get("org_code");
		}
		List<Map<String,String>>customServices;
		if("1".equals(org_code)||"0".equals(org_code)){
			customServices = projectService.findUsersByCode("0",CUSTOM_DEPT_CODE,null);
		}else{
			customServices = projectService.findUsersByCode(org_code,null,null);
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		if(StringUtils.isEmpty(start)&&StringUtils.isEmpty(end)){
			end = sdf.format(now);
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DAY_OF_MONTH, -7);
			start = sdf.format(c.getTime());
		}
		String users = "";
		kfNames = new ArrayList<String>();
		kfCodes = new ArrayList<String>();
		for(Map<String,String> user:customServices){
			kfNames.add(user.get("name"));
			kfCodes.add(user.get("id"));
			users += "'"+user.get("id")+"',";
		}
		if(users.length()>0){
			users = users.substring(0,users.length()-1);
		}
		map = projectService.countKF(start, end, users);
		
		return SUCCESS;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getOrg_code() {
		return org_code;
	}
	public void setOrg_code(String org_code) {
		this.org_code = org_code;
	}
	public List<Map<String, String>> getOrglist() {
		return orglist;
	}
	public void setOrglist(List<Map<String, String>> orglist) {
		this.orglist = orglist;
	}
	public List<String> getKfNames() {
		return kfNames;
	}
	public void setKfNames(List<String> kfNames) {
		this.kfNames = kfNames;
	}
	public List<String> getKfCodes() {
		return kfCodes;
	}
	public void setKfCodes(List<String> kfCodes) {
		this.kfCodes = kfCodes;
	}
	public Map<String, Map<String, String>> getMap() {
		return map;
	}
	public void setMap(Map<String, Map<String, String>> map) {
		this.map = map;
	}
		
}
