package com.poly.action.action_data;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;
import com.poly.util.PageUtilNew;

public class PresentApplyAction extends MyActionSupport {
	
	Map<String, String> provMap;
	List<Map<String, String>> applyList;
	
	private String prov;
	private String city;
	private String state = "";
	private String gift_examine_state = "";
	private String owner_name;
	private String owner_phone;
	private String owner_carcode;
	private String owner_idcode = "";
	
	private String engine_num;
	private String vin_num;
	private String carmsg_type = "";
	private String trans_id;
	
	private String remark;
	private String apply_id;
	
	private String apply_state;
	
	private String postbill_code = "";
	
	private int page = 1;  //显示页
	private int pages = 0;     //总页数
	private int pagelength = 5;  //显示页码数
	
	private int pageNum = 5; //每页显示条数
	private List<String> pageList;  //返回页面的页码列表
	
	private ProjectService projectService = ProjectService.getInstance();
	
	public String execute(){
		provMap = projectService.getProvMap();
		
		String userid = (String)session.get("userid");
//		Map<String, String> cityCatalogMap = projectService.getUserCityId(userid);
		Map<String, String> orgMap = projectService.findOrgAndDepById(userid);
		
		Map<String, String> mapWhere = new HashMap<String, String>();
		mapWhere.put("prov", prov);
		mapWhere.put("city", city);
		mapWhere.put("state", state);
		mapWhere.put("gift_examine_state", gift_examine_state);
		mapWhere.put("owner_name", owner_name);
		mapWhere.put("owner_phone", owner_phone);
		mapWhere.put("owner_carcode", owner_carcode);
		
		mapWhere.put("pageNum", String.valueOf(pageNum));
		mapWhere.put("page", String.valueOf(page));
		mapWhere.put("userid", userid);
		
		mapWhere.put("org_code", orgMap.get("org_code"));
		mapWhere.put("org_comment", orgMap.get("org_comment"));
		
//		mapWhere.put("cityid", cityCatalogMap.get("cityid"));
//		mapWhere.put("cityfatherid", cityCatalogMap.get("fatherid"));
		
		pages = projectService.getPagesForApplyList(mapWhere);
		applyList = projectService.getApplyList(mapWhere);
		
		int update_num = 0;
		for (int i = 0; i < applyList.size(); i++) {
			Map<String, String> map = applyList.get(i);
			if (!map.get("transid_original").equals(map.get("trans_id")) && Integer.valueOf(map.get("trans_id"))>0) {
				Map<String, String> nmap = new HashMap<String, String>();
				nmap.put("apply_id", map.get("apply_id"));
				nmap.put("trans_id", map.get("trans_id"));
				projectService.setPresentForApply(nmap);
				update_num = update_num + 1;
			}
		}
		if (update_num>0) {
			applyList = projectService.getApplyList(mapWhere);
		}
		
//		System.out.println("------pages >>>>>>>> "+pages);
		
		pageList = PageUtilNew.getPageListNew(page, pages, pagelength);
		return SUCCESS;
	}
	
	public void updateCarMsg() throws IOException{
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("engine_num", engine_num);
		map.put("vin_num", vin_num);
		map.put("carmsg_type", carmsg_type);
//		map.put("trans_id", trans_id);
		map.put("apply_id", apply_id);
		
		int result = projectService.updateCarMsg(map);
		
		response.setContentType("text/html;charset=gbk");
		response.getWriter().write("" + result);
		
//		String returnString = projectService.checkCarMsg(map);
//		if(returnString.equals("")){
//			int result = projectService.updateCarMsg(map);
//			
//			response.setContentType("text/html;charset=gbk");
//			response.getWriter().write("" + result);
//		}else {
//			response.setContentType("text/html;charset=gbk");
//			response.getWriter().write(returnString);
//		}
	}
	
	public void updateRemark() throws IOException{
		Map<String, String> map = new HashMap<String, String>();
		map.put("remark", remark);
		map.put("apply_id", apply_id);
		
		int result = projectService.updateRemark(map);
		
		response.setContentType("text/html;charset=gbk");
		response.getWriter().write("" + result);
	}
	
	public void updatePostBill() throws IOException{
		Map<String, String> map = new HashMap<String, String>();
		map.put("postbill_code", postbill_code);
		map.put("apply_id", apply_id);
		
		int result = projectService.updatePostBill(map);
		
		response.setContentType("text/html;charset=gbk");
		response.getWriter().write("" + result);
	}
	
	public void updateState() throws IOException{
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("apply_state", apply_state);
		map.put("apply_id", apply_id);
		map.put("trans_id", trans_id);
		
		int result = projectService.updateState(map);
		
		response.setContentType("text/html;charset=gbk");
		response.getWriter().write("" + result);
	}
	
	public void updateIdCord() throws IOException{
		Map<String, String> map = new HashMap<String, String>();
		map.put("owner_idcode", owner_idcode);
		map.put("apply_id", apply_id);
		
		int result = projectService.updateIdCord(map);
		
		response.setContentType("text/html;charset=gbk");
		response.getWriter().write("" + result);
	}
	
	public void getcity() throws IOException{
		String citystr = projectService.getCityStrByProv(prov);
		
		response.setContentType("text/html;charset=gbk");
		response.getWriter().write(citystr);
	}
	
	public void getPresent() throws IOException{
		List<Map<String, String>> presentList = projectService.getPresentByPhone(apply_id);
		
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(presentList);
		out.print(json.toString());
	}
	
	public void setPresent() throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("trans_id", trans_id);
		map.put("apply_id", apply_id);
		
		int result = projectService.setPresentForApply(map);
		
		response.setContentType("text/html;charset=gbk");
		response.getWriter().write("" + result);
	}
	
	public void delete() throws IOException{
		int result = projectService.presentDel(apply_id);
		
		response.setContentType("text/html;charset=gbk");
		response.getWriter().write("" + result);
	}

	public Map<String, String> getProvMap() {
		return provMap;
	}

	public void setProvMap(Map<String, String> provMap) {
		this.provMap = provMap;
	}

	public List<Map<String, String>> getApplyList() {
		return applyList;
	}

	public void setApplyList(List<Map<String, String>> applyList) {
		this.applyList = applyList;
	}

	public String getProv() {
		return prov;
	}

	public void setProv(String prov) {
		this.prov = prov;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGift_examine_state() {
		return gift_examine_state;
	}

	public void setGift_examine_state(String gift_examine_state) {
		this.gift_examine_state = gift_examine_state;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public String getOwner_phone() {
		return owner_phone;
	}

	public void setOwner_phone(String owner_phone) {
		this.owner_phone = owner_phone;
	}

	public String getOwner_carcode() {
		return owner_carcode;
	}

	public void setOwner_carcode(String owner_carcode) {
		this.owner_carcode = owner_carcode;
	}

	public String getOwner_idcode() {
		return owner_idcode;
	}

	public void setOwner_idcode(String owner_idcode) {
		this.owner_idcode = owner_idcode;
	}

	public String getEngine_num() {
		return engine_num;
	}

	public void setEngine_num(String engine_num) {
		this.engine_num = engine_num;
	}

	public String getVin_num() {
		return vin_num;
	}

	public void setVin_num(String vin_num) {
		this.vin_num = vin_num;
	}

	public String getCarmsg_type() {
		return carmsg_type;
	}

	public void setCarmsg_type(String carmsg_type) {
		this.carmsg_type = carmsg_type;
	}

	public String getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(String trans_id) {
		this.trans_id = trans_id;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getApply_id() {
		return apply_id;
	}

	public void setApply_id(String apply_id) {
		this.apply_id = apply_id;
	}

	public String getApply_state() {
		return apply_state;
	}

	public void setApply_state(String apply_state) {
		this.apply_state = apply_state;
	}

	public String getPostbill_code() {
		return postbill_code;
	}

	public void setPostbill_code(String postbill_code) {
		this.postbill_code = postbill_code;
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
	
}
