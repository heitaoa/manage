package com.poly.action.action_data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import car_beans.TbDataProject;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class ServiceViewHdxqAction extends MyActionSupport{
	private String pro_num;
	private List<Map<String,String>> gifts = new ArrayList<Map<String,String>>();
	private Map<String,String> baseInfo = new HashMap<String,String>();
	private List<Map<String,String>> list = new ArrayList<Map<String,String>>();
	private Map<String,Integer> data = new HashMap<String,Integer>();
	private Map<String,String> project =new HashMap<String,String>();
	private double  totalPrice = 0.0;
	public String execute(){
		ProjectService projectService = ProjectService.getInstance();
		Map<String,Map<String,String>> result = projectService.getGiftDataByProNum(pro_num);
		for(String key:result.keySet()){
			Map<String,String>gift = result.get(key);
			totalPrice = totalPrice+Double.parseDouble(gift.get("sum"));
			gifts.add(gift);
		}
		baseInfo = projectService.getActDetailInfoByProNum(pro_num);
		list = projectService.getQiandaoListByProNum(pro_num);
		data = projectService.getDataByProNum(pro_num);
		project = projectService.getProjectInfoByProNum(pro_num);
		return SUCCESS;
	}
	public String getPro_num() {
		return pro_num;
	}
	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
	}
	public List<Map<String, String>> getGifts() {
		return gifts;
	}
	public void setGifts(List<Map<String, String>> gifts) {
		this.gifts = gifts;
	}
	public List<Map<String, String>> getList() {
		return list;
	}
	public void setList(List<Map<String, String>> list) {
		this.list = list;
	}
	
	public Map<String, Integer> getData() {
		return data;
	}
	public void setData(Map<String, Integer> data) {
		this.data = data;
	}
	public Map<String, String> getProject() {
		return project;
	}
	public void setProject(Map<String, String> project) {
		this.project = project;
	}
	public Map<String, String> getBaseInfo() {
		return baseInfo;
	}
	public void setBaseInfo(Map<String, String> baseInfo) {
		this.baseInfo = baseInfo;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
