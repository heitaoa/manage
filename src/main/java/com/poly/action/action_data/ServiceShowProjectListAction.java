package com.poly.action.action_data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import car_beans.DboAreCatalog;

import com.poly.action.MyActionSupport;
import com.poly.service.AppInfoService;
import com.poly.service.ProjectService;

public class ServiceShowProjectListAction extends MyActionSupport{
	
	private List<Map<String, String>> projectList;
	
	private  Map<String, String> deptMap;  //部门--列表
	private Map<String, String> inimanMap; //发起人--列表
	private Map<String, String> iwayMap;  //品牌--列表
	
	private String ini_man;  //发起人
	private String service_type;  //业务类型
	private String iway;  //品牌
	private String ini_date;  //发起日期
	private int promo_prov;  //推广区域
	private int promo_city;
	private String pro_state;  //项目状态
	private List<DboAreCatalog> citys = new ArrayList<DboAreCatalog>();
	private int page = 1;
	private int pages;
	
	private int pageNum = 10;
	private List<String> pageList;
	
	public String execute(){
		Map<String, String> map = new HashMap<String, String>();
		String userid = (String) session.get("userid");
		Map<String, String> orgAndDep = ProjectService.getInstance().findOrgAndDepById(userid);
		String ini_dept = orgAndDep.get("dep_code");
		String ini_org = orgAndDep.get("org_code");
		map.put("ini_org", ini_org);
		if("1".equals(ini_org)){
			map.put("ini_dept", ini_dept);
		}else{
			map.put("ini_dept", null);
		}
		map.put("ini_man", ini_man);
		map.put("service_type", service_type);
		map.put("iway", iway);
		map.put("ini_date", ini_date);
		if(promo_prov==0){
			map.put("promo_prov",null);
		}else{
			map.put("promo_prov",promo_prov+"" );
		}
		if(promo_city==0){
			map.put("promo_city",null );
		}else{
			map.put("promo_city",promo_city+"" );
		}
		map.put("pro_state", pro_state);
		map.put("userid", userid);
		map.put("states", "1,2,3,4,5");
		map.put("pageNum", String.valueOf(pageNum));
		if(promo_prov!=-1&&promo_prov!=0){
			citys = AppInfoService.getInstance().getCityInfo(promo_prov);
		}
		
		deptMap = ProjectService.getInstance().getDeptMap(map);
		inimanMap = ProjectService.getInstance().getInimanMap(map);
		iwayMap = ProjectService.getInstance().getBrandMap(map);
		pages = ProjectService.getInstance().getProjectsPagesForSerDirector(map);
		if(page>pages){
			page=pages;
		}
		map.put("page", String.valueOf(page));
		projectList = ProjectService.getInstance().getProjectsForSerDirector(map);
		pageList = getPageList(page, pages, 10);
		return SUCCESS;
	}
	
	
	
	private List<String> getPageList(int ipage, int ipages, int ipageLength){
		List<String> pList = new ArrayList<String>();
		if (ipages<ipageLength) {
			for (int i = 1; i < ipages + 1; i++) {
				pList.add(String.valueOf(i));
			}
		}else {
			if (ipage<ipageLength) {
				for (int i = 1; i < ipageLength + 1; i++) {
					pList.add(String.valueOf(i));
				}
			}else if (ipages-ipage>ipageLength-2) {
				for (int i = ipage; i < ipageLength + ipage; i++) {
					pList.add(String.valueOf(i));
				}
			}else {
				for (int i = ipages - ipageLength + 1; i < ipages; i++) {
					pList.add(String.valueOf(i));
				}
			}
		}
		return pList;
	}
	public List<Map<String, String>> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<Map<String, String>> projectList) {
		this.projectList = projectList;
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
	
	public String getIni_date() {
		return ini_date;
	}
	public void setIni_date(String ini_date) {
		this.ini_date = ini_date;
	}
	public String getPro_state() {
		return pro_state;
	}
	public void setPro_state(String pro_state) {
		this.pro_state = pro_state;
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
	public List<DboAreCatalog> getCitys() {
		return citys;
	}
	public void setCitys(List<DboAreCatalog> citys) {
		this.citys = citys;
	}
	public int getPromo_prov() {
		return promo_prov;
	}
	public void setPromo_prov(int promo_prov) {
		this.promo_prov = promo_prov;
	}
	public int getPromo_city() {
		return promo_city;
	}
	public void setPromo_city(int promo_city) {
		this.promo_city = promo_city;
	}



	public Map<String, String> getIwayMap() {
		return iwayMap;
	}



	public void setIwayMap(Map<String, String> iwayMap) {
		this.iwayMap = iwayMap;
	}



	public String getIway() {
		return iway;
	}



	public void setIway(String iway) {
		this.iway = iway;
	}
	
	
	
	
}
