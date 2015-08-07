package com.poly.action.action_data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;
import com.poly.service.TiquService;
import com.poly.util.PageUtilNew;

public class TqProListAction extends MyActionSupport {
	
	private TiquService tiquService = TiquService.getInstance();
	
	private List<Map<String, String>> proList;
	private Map<String, String> deptMap;  //部门--列表
	
	private String user_id = "poly0372";   //登陆者id
	private String formUrl = "tiqu_proList";
	private String dept_code = "";  //部门
	private String apply_startdate = "";  //申请开始时间
	private String apply_enddate = "";  //申请结束时间
	private String examine_state = "";  //审核状态
	private String tiqu_state = "";     //执行状态
	
	private String isDir = "0";
	
	private int page = 1;  //显示页
	private int pages = 0;     //总页数
	private int pagelength = 5;  //显示页码数
	
	private int pageNum = 10; //每页显示条数
	private List<String> pageList;  //返回页面的页码列表
	
	public String execute(){
		if (!user_id.equals("")) {
			user_id = (String)session.get("userid");
		}
		Map<String, String> whereMap = new HashMap<String, String>();
		whereMap.put("user_id", user_id);
		whereMap.put("dept_code", dept_code);
		whereMap.put("apply_startdate", apply_startdate);
		whereMap.put("apply_enddate", apply_enddate);
		whereMap.put("examine_state", examine_state);
		whereMap.put("tiqu_state", tiqu_state);
		whereMap.put("isDir", isDir);
		
		if (!user_id.equals("")) {
			Map<String, String> userInfo = tiquService.getUserinfo(user_id);
			whereMap.put("dept_code", userInfo.get("dept_code"));
			whereMap.put("org_code", userInfo.get("org_code"));
		}
		
		whereMap.put("pageNum", String.valueOf(pageNum));
		whereMap.put("page", String.valueOf(page));
		
		deptMap = tiquService.getDeptMap();
		proList = tiquService.getProList(whereMap);
		pages = tiquService.getProListPages(whereMap);
		
		pageList = PageUtilNew.getPageListNew(page, pages, pagelength);
		return SUCCESS;
	}
	
	public String executeHigh(){
		user_id = "";
		formUrl = "tiqu_proList_high";
		return execute();
	}
	
	public String executeDir(){
		isDir = "1";
		formUrl = "tiqu_proList_dir";
		return execute();
	}
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public List<Map<String, String>> getProList() {
		return proList;
	}

	public void setProList(List<Map<String, String>> proList) {
		this.proList = proList;
	}

	public String getDept_code() {
		return dept_code;
	}

	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}

	public String getApply_startdate() {
		return apply_startdate;
	}

	public void setApply_startdate(String apply_startdate) {
		this.apply_startdate = apply_startdate;
	}

	public String getApply_enddate() {
		return apply_enddate;
	}

	public void setApply_enddate(String apply_enddate) {
		this.apply_enddate = apply_enddate;
	}

	public String getExamine_state() {
		return examine_state;
	}

	public void setExamine_state(String examine_state) {
		this.examine_state = examine_state;
	}

	public String getTiqu_state() {
		return tiqu_state;
	}

	public void setTiqu_state(String tiqu_state) {
		this.tiqu_state = tiqu_state;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPagelength() {
		return pagelength;
	}

	public void setPagelength(int pagelength) {
		this.pagelength = pagelength;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public List<String> getPageList() {
		return pageList;
	}

	public void setPageList(List<String> pageList) {
		this.pageList = pageList;
	}

	public Map<String, String> getDeptMap() {
		return deptMap;
	}

	public void setDeptMap(Map<String, String> deptMap) {
		this.deptMap = deptMap;
	}

	public String getFormUrl() {
		return formUrl;
	}

	public void setFormUrl(String formUrl) {
		this.formUrl = formUrl;
	}

	public String getIsDir() {
		return isDir;
	}

	public void setIsDir(String isDir) {
		this.isDir = isDir;
	}
	
	
}
