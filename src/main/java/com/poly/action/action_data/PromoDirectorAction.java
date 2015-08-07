package com.poly.action.action_data;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import car_beans.TbDataProject;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;
import com.poly.service.TiquService;
import com.poly.util.PageUtilNew;

public class PromoDirectorAction extends MyActionSupport {
	
	ProjectService projectService = ProjectService.getInstance();
	
	List<TbDataProject> projects = new ArrayList<TbDataProject>();
	
	List<Map<String, String>> projectList;  //项目列表
	List<Map<String, String>> projectList_bl;  //补量项目列表
	
	private Map<String, String> deptMap;  //部门--列表
	private Map<String, String> inimanMap; //发起人--列表
	private Map<String, String> brandMap;  //品牌--列表
	private List<String> areaList;         //推广区域--列表
	private Map<String, String> promoPerMap;  //推广人员列表
	
//	private Map<String, String> provMap;  //省份列表
	private List<Map<String, String>> provList;  //省份列表
	
	private String pro_num = ""; //项目编号
	private String promo_man = ""; //推广负责人
	private String ini_dept = "";  //部门
	private String ini_man = "";  //发起人
	private String service_type = "";  //业务类型
	private String brand = "";  //品牌
	private String ini_date = "";  //发起日期
	private String promo_area = "";  //推广区域
	private String promo_prov = "";  //推广省份
	private String promo_city = "";  //推广城市
	private String pro_state = "";  //项目状态
	
	private int pro_num_will = 0;  //待审核数量
	private int pro_num_yes = 0;   //审核通过数量
	private int pro_num_no = 0;    //驳回数量
	private int pro_num_out = 0;   //结束数量
	
	private int projectList_bl_count = 0; //补量项目数量
	
	private String pro_searchType=""; //分类查询参数 1-待审查 3-审查通过 4-驳回 -1-已完成
	
	private int page = 1;  //显示页
	private int pages = 0;     //总页数
	private int pagelength = 5;  //显示页码数
	
	private int pageNum = 10; //每页显示条数
	private List<String> pageList;  //返回页面的页码列表
	
	
	//推广主管 查看所有项目的页面
	public String execute(){
		String userid = (String)session.get("userid");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("states","1,3,4,5");
		
		map.put("pro_num", pro_num);
		map.put("dept_name", ini_dept);
		map.put("ini_man", ini_man);
		map.put("service_type", service_type);
		map.put("brand", brand);
		map.put("ini_date", ini_date);
		map.put("promo_area", promo_area);
		map.put("promo_prov", promo_prov);
		map.put("promo_city", promo_city);
		map.put("pro_state", pro_state);
		
		map.put("pageNum", String.valueOf(pageNum));
		map.put("page", String.valueOf(page));
		if (!pro_searchType.equals("")) {
			map.put("pro_state", pro_searchType);
		}
		
		deptMap = projectService.getDeptMap(map);
		inimanMap = projectService.getInimanMap(map);
		brandMap = projectService.getBrandMap(map);
		
		areaList = projectService.getAreaList(map);
//		provMap = projectService.getProvMap();
		provList = TiquService.getInstance().getProvList(0);
		
		promoPerMap = projectService.getPromoPerMap(userid);
		
		pages = projectService.getProjectsPagesForPromoDirector(map);
		projectList = projectService.getProjectsForPromoDirector(map);
		
		System.out.println(pages);
//		System.out.println("pro_state--------------"+map);
		
		pageList = PageUtilNew.getPageListNew(page, pages, pagelength);
		
		//获取相关数据
		Map<String, Integer> stateMap = ProjectService.getInstance().getProjectStateNum();
		if (stateMap.containsKey("1")) {
			pro_num_will = stateMap.get("1");
		}
		if (stateMap.containsKey("3")) {
			pro_num_yes = stateMap.get("3");
		}
		if (stateMap.containsKey("4")) {
			pro_num_no = stateMap.get("4");
		}
		if (stateMap.containsKey("5")) {
			pro_num_out = stateMap.get("5");
		}
		
		
//		pro_num_out = projectService.getProjectFinishNum();
		
		//获取增补项目列表
		projectList_bl = projectService.getProjectListBlListForPromoDir(map);
		for (Map<String, String> map2:projectList_bl) {
			if (map2.get("pro_state").equals("1")) {
				projectList_bl_count++;
			}
		}
		
		return SUCCESS;
	}
	
	public void getNewProjectNum(){
		Map<String, Integer> stateMap = ProjectService.getInstance().getProjectStateNum();
		if (stateMap.containsKey("1")) {
			pro_num_will = stateMap.get("1");
		}
		try {
			response.getWriter().write(""+pro_num_will+"");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//推广项目审查---通过
	public void examineYes(){
		
		int result = projectService.promoDirectorExamineYes(promo_man,pro_num);
		
		try {
			response.getWriter().write(""+result+"");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//推广项目审查---驳回
	public void examineNo(){
		
		int result = projectService.promoDirectorExamineNo(pro_num);
		
		try {
			response.getWriter().write(""+result+"");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//获取补量项目信息
	public void getBlProjectInfo() throws IOException{
		Map info1 = projectService.getProjectInfoByProNum(pro_num);
		Map info2 = projectService.getBlProjectInfoForDir(pro_num);
		
		Map<String, Map> info_all = new HashMap<String, Map>();
		info_all.put("info1", info1);
		info_all.put("info2", info2);
		
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(info_all);
		out.print(json.toString());
	}
	
	//审查补量项目----通过
	public void examineYesForBl() throws IOException{
		int result = projectService.examineYesForBl(pro_num);
		projectService.delProjectBl(pro_num);
		response.getWriter().write(""+result+"");
	}
	
	//审查补量项目----驳回
	public void examineNoForBl() throws IOException{
		int result = projectService.examineNoForBl(pro_num);
		response.getWriter().write(""+result+"");
	}
	
	
	public List<TbDataProject> getProjects() {
		return projects;
	}

	public void setProjects(List<TbDataProject> projects) {
		this.projects = projects;
	}

	public String getPromo_man() {
		return promo_man;
	}

	public void setPromo_man(String promo_man) {
		this.promo_man = promo_man;
	}

	public String getPro_num() {
		return pro_num;
	}

	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
	}

	public Map<String, String> getDeptMap() {
		return deptMap;
	}

	public void setDeptMap(Map<String, String> deptMap) {
		this.deptMap = deptMap;
	}

	public Map<String, String> getInimanMap() {
		return inimanMap;
	}

	public void setInimanMap(Map<String, String> inimanMap) {
		this.inimanMap = inimanMap;
	}

	public Map<String, String> getBrandMap() {
		return brandMap;
	}

	public void setBrandMap(Map<String, String> brandMap) {
		this.brandMap = brandMap;
	}

	public List<String> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<String> areaList) {
		this.areaList = areaList;
	}

	public List<Map<String, String>> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Map<String, String>> projectList) {
		this.projectList = projectList;
	}

	public String getIni_dept() {
		return ini_dept;
	}

	public void setIni_dept(String ini_dept) {
		this.ini_dept = ini_dept;
	}

	public String getIni_man() {
		return ini_man;
	}

	public void setIni_man(String ini_man) {
		this.ini_man = ini_man;
	}

	public String getService_type() {
		return service_type;
	}

	public void setService_type(String service_type) {
		this.service_type = service_type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getIni_date() {
		return ini_date;
	}

	public void setIni_date(String ini_date) {
		this.ini_date = ini_date;
	}

	public String getPromo_area() {
		return promo_area;
	}

	public void setPromo_area(String promo_area) {
		this.promo_area = promo_area;
	}

	public String getPro_state() {
		return pro_state;
	}

	public void setPro_state(String pro_state) {
		this.pro_state = pro_state;
	}

	public Map<String, String> getPromoPerMap() {
		return promoPerMap;
	}

	public void setPromoPerMap(Map<String, String> promoPerMap) {
		this.promoPerMap = promoPerMap;
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

	public int getPro_num_will() {
		return pro_num_will;
	}

	public void setPro_num_will(int pro_num_will) {
		this.pro_num_will = pro_num_will;
	}

	public int getPro_num_yes() {
		return pro_num_yes;
	}

	public void setPro_num_yes(int pro_num_yes) {
		this.pro_num_yes = pro_num_yes;
	}

	public int getPro_num_no() {
		return pro_num_no;
	}

	public void setPro_num_no(int pro_num_no) {
		this.pro_num_no = pro_num_no;
	}

	public int getPro_num_out() {
		return pro_num_out;
	}

	public void setPro_num_out(int pro_num_out) {
		this.pro_num_out = pro_num_out;
	}

	public String getPro_searchType() {
		return pro_searchType;
	}

	public void setPro_searchType(String pro_searchType) {
		this.pro_searchType = pro_searchType;
	}

	public List<Map<String, String>> getProvList() {
		return provList;
	}

	public void setProvList(List<Map<String, String>> provList) {
		this.provList = provList;
	}

	public String getPromo_prov() {
		return promo_prov;
	}

	public void setPromo_prov(String promo_prov) {
		this.promo_prov = promo_prov;
	}

	public String getPromo_city() {
		return promo_city;
	}

	public void setPromo_city(String promo_city) {
		this.promo_city = promo_city;
	}

	public int getPagelength() {
		return pagelength;
	}

	public void setPagelength(int pagelength) {
		this.pagelength = pagelength;
	}

	public List<Map<String, String>> getProjectList_bl() {
		return projectList_bl;
	}

	public void setProjectList_bl(List<Map<String, String>> projectList_bl) {
		this.projectList_bl = projectList_bl;
	}

	public int getProjectList_bl_count() {
		return projectList_bl_count;
	}

	public void setProjectList_bl_count(int projectList_bl_count) {
		this.projectList_bl_count = projectList_bl_count;
	}
	
}
