package com.poly.action.action_data;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import net.sf.json.JSONArray;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;
import com.redis.RedisDao;

public class GiftExamineAction extends MyActionSupport{
	private String service_type="-1";
	private String pro_num="-1";
	private String start;
	private String end;
	private String examine_state="-1";
	private String send_state="-1";
	private String brand;
	private String model="-1";
	private String s_name;
	private String s_phone;
	private List<Map<String,String>>list;
	private List<Map<String,String>>brands;
	private List<Map<String,String>>models;
	private List<Map<String,String>>pro_numList;
	private String trans_id;
	private int page=1;
	private int pages;
	private int pageSize=10;
	private String iway="";
	private List<Map<String,String>>iways;
	public String execute(){
		iways = ProjectService.getInstance().getIways();
		return SUCCESS;
	}
	public String search(){
		iways = ProjectService.getInstance().getIways();
		ProjectService projectService  = ProjectService.getInstance();
		if(StringUtils.isNotEmpty(iway)){
			models = projectService.getModelsByIway(iway);
		}
		if(!"-1".equals(service_type)){
			pro_numList = projectService.getProNumsByType(service_type);
		}
		s_name = s_name.trim();
		s_phone = s_phone.trim();
		pages = projectService.getExamineListPages(service_type,pro_num,start,end,examine_state,send_state,iway,model,page,pageSize,s_name,s_phone);
		list = projectService.getExamineList(service_type,pro_num,start,end,examine_state,send_state,iway,model,page,pageSize,s_name,s_phone);
		return SUCCESS;
	}
	public void getProNums() throws IOException{
		ProjectService projectService  = ProjectService.getInstance();
		pro_numList = projectService.getProNumsByType(service_type);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(pro_numList);
		out.print(json.toString());
	}
	public void getModelsByIway() throws IOException{
		ProjectService projectService  = ProjectService.getInstance();
		models = projectService.getModelsByIway(iway);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(models);
		out.print(json.toString());
	}
	public void examineGift() throws IOException{
		ProjectService projectService  = ProjectService.getInstance();
		String back = projectService.examineGift(trans_id,examine_state);
		response.setContentType("text/html;charset=gbk");
		response.getWriter().write(back);
	}
	public String getPro_num() {
		return pro_num;
	}
	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
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
	public List<Map<String, String>> getList() {
		return list;
	}
	public void setList(List<Map<String, String>> list) {
		this.list = list;
	}
	public List<Map<String, String>> getBrands() {
		return brands;
	}
	public void setBrands(List<Map<String, String>> brands) {
		this.brands = brands;
	}
	public List<Map<String, String>> getModels() {
		return models;
	}
	public void setModels(List<Map<String, String>> models) {
		this.models = models;
	}
	public String getService_type() {
		return service_type;
	}
	public void setService_type(String service_type) {
		this.service_type = service_type;
	}
	public String getExamine_state() {
		return examine_state;
	}
	public void setExamine_state(String examine_state) {
		this.examine_state = examine_state;
	}
	public String getSend_state() {
		return send_state;
	}
	public void setSend_state(String send_state) {
		this.send_state = send_state;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(String trans_id) {
		this.trans_id = trans_id;
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
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_phone() {
		return s_phone;
	}
	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}
	public List<Map<String, String>> getPro_numList() {
		return pro_numList;
	}
	public void setPro_numList(List<Map<String, String>> pro_numList) {
		this.pro_numList = pro_numList;
	}
	public String getIway() {
		return iway;
	}
	public void setIway(String iway) {
		this.iway = iway;
	}
	public List<Map<String, String>> getIways() {
		return iways;
	}
	public void setIways(List<Map<String, String>> iways) {
		this.iways = iways;
	}
	
}
