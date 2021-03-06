package com.poly.action.action_data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class CountKctDataAction extends MyActionSupport {
	Map<String, String> brandMap;     //所有品牌列表
	Map<String, String> orgMap;       //所有分站列表
	Map<String, String> executorMap;  //执行人列表
	List<Map<String, String>> countActiveDataList;  //活动数据列表
	
	public String orgid;
	public String executor;
	public String brand;
	
	public String execute(){
		//System.out.println("------------ hello CountKtcDataAction ------------------");
		Map<String, String> map = new HashMap<String, String>();
		map.put("orgid", orgid);
		map.put("executor", executor);
		map.put("brand", brand);
		
		brandMap = ProjectService.getInstance().getBrandMapForCount();
		orgMap = ProjectService.getInstance().getOrgMapForCount();
		executorMap = ProjectService.getInstance().getExecutorMapForCount();
		
		countActiveDataList = ProjectService.getInstance().getListForActiveData(map);
		
		return SUCCESS;
	}

	public Map<String, String> getBrandMap() {
		return brandMap;
	}

	public void setBrandMap(Map<String, String> brandMap) {
		this.brandMap = brandMap;
	}

	public Map<String, String> getOrgMap() {
		return orgMap;
	}

	public void setOrgMap(Map<String, String> orgMap) {
		this.orgMap = orgMap;
	}

	public Map<String, String> getExecutorMap() {
		return executorMap;
	}

	public void setExecutorMap(Map<String, String> executorMap) {
		this.executorMap = executorMap;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getExecutor() {
		return executor;
	}

	public void setExecutor(String executor) {
		this.executor = executor;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public List<Map<String, String>> getCountActiveDataList() {
		return countActiveDataList;
	}

	public void setCountActiveDataList(List<Map<String, String>> countActiveDataList) {
		this.countActiveDataList = countActiveDataList;
	}
	
	
}
