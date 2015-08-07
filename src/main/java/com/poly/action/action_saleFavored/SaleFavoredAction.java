package com.poly.action.action_saleFavored;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.action.MyActionSupport;
import com.poly.service.SaleFavoredService;
import com.poly.service.SaleFavoredService.StationType;

import net.sf.json.JSONArray;
import car_beans.DboCarCatalognew;
import car_beans.DboDeaDealers;
import car_beans.TbCarGroupbuy;


public class SaleFavoredAction extends MyActionSupport {
	private TbCarGroupbuy carGroupbuy;
	private int fatherid;
	private int catalogid;
	private int page = 1;
	private int pages = 1;
	private int rows = 10;
	private int count;
	private int id;
	private int flag;
	private int type = 0;
	private String pinpai  = "-1";
	private Map<String, Object> carGroup;
	private String keywords="";
	private List<HashMap<String, Object>> carGroupbuyList;
	private String stationId = "-1";
	private String stationName;
	private String isdelete = "-1";
	private String idx = "";
	private HashMap<String, String> groupInfo;
	private String state = "0";
	private String ulevel = "";
	//private String ulevel;
	public void getCarBrand() throws IOException{
		//List<DboCarCatalognew> brands = SaleFavoredService.getInstance().getCarBrand();
		List<HashMap<String, Object>> brands = SaleFavoredService.getInstance().getCarBrand2();
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(brands);
		String jsonp=request.getParameter("jsonpcallback");
		out.print(jsonp+"("+json.toString()+")");
	}
	public void getCarBrand2() throws IOException{
		List<HashMap<String, Object>> brands = SaleFavoredService.getInstance().getCarBrand2();
		List<HashMap<String, Object>> newbrands = new ArrayList<HashMap<String,Object>>();
		Map<String, Object> newMap = null;
		Map<String,Object> map = (Map<String, Object>) session.get("userInfo");
		String lbrand = (String) map.get("brands");
		if(!"".equals(lbrand)){
			String[] brandx = lbrand.split(",");
			for (int i = 0; i < brandx.length; i++) {
				for (int j = 0; j < brands.size(); j++) {
					if(brands.get(j).get("iway").toString().equals(brandx[i])){
						newMap = brands.get(j);
						newbrands.add((HashMap<String, Object>) newMap);
					}
						
				}
			}
		}
		else {
			newbrands.addAll(brands);
		}
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(newbrands);
		String jsonp=request.getParameter("jsonpcallback");
		out.print(jsonp+"("+json.toString()+")");
	}
	public void getCars() throws IOException{
		List<DboCarCatalognew> brands = SaleFavoredService.getInstance().getCarBrandByFatherId(fatherid);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(brands);
		String jsonp=request.getParameter("jsonpcallback");
		out.print(jsonp+"("+json.toString()+")");
	}
	public void getCarsx() throws IOException{
		String brandNmae = URLDecoder.decode(request.getParameter("brandNmae"), "utf-8");;
		List<DboCarCatalognew> brands = SaleFavoredService.getInstance().getCarBrandByFatherIdx(brandNmae);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(brands);
		String jsonp=request.getParameter("jsonpcallback");
		out.print(jsonp+"("+json.toString()+")");
	}
	public void getCarsx00() throws IOException{
		String brandNmae = URLDecoder.decode(request.getParameter("brandNmae"), "utf-8");;
		List<DboCarCatalognew> brands = SaleFavoredService.getInstance().getCarBrandByFatherIdx2(brandNmae);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(brands);
		String jsonp=request.getParameter("jsonpcallback");
		out.print(jsonp+"("+json.toString()+")");
	}
	public void getCars2() throws IOException{
		List<DboCarCatalognew> brands = SaleFavoredService.getInstance().getCarByFatherId(fatherid);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(brands);
		String jsonp=request.getParameter("jsonpcallback");
		out.print(jsonp+"("+json.toString()+")");
	}
	public void getCars2x() throws IOException{
		List<DboCarCatalognew> brands = SaleFavoredService.getInstance().getCarByFatherId(fatherid);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(brands);
		String jsonp=request.getParameter("jsonpcallback");
		out.print(jsonp+"("+json.toString()+")");
	}
	public void updateGroupState() throws IOException{
		String ids = URLDecoder.decode(request.getParameter("ids"), "utf-8");
		String state = URLDecoder.decode(request.getParameter("state"), "utf-8");
		//System.err.println(ids);
		String idArr[] = ids.split("#");
		for(int i = 0;i<idArr.length;i++){
			SaleFavoredService.getInstance().updateGroupState(Integer.parseInt(idArr[i]),Integer.parseInt(state));
		}
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		String jsonp=request.getParameter("jsonpcallback");
		out.print(jsonp+"(1)");
	}
	public String updateGroupState2(){
		SaleFavoredService.getInstance().updateGroupState2(id);
		return SUCCESS;
	}
	public void getDeaDealers() throws IOException{
		String name = URLDecoder.decode(request.getParameter("deaName"), "utf-8");
		int start = rows * (page - 1);
		List<HashMap<String, Object>> brands = SaleFavoredService.getInstance().getDeaDealers(start,rows,name.trim());
		if(brands.size()>0){
			count = (Integer) brands.get(0).get("count");
		}
		pages = count / rows;
		if (count % rows != 0) {
			pages++;
		}	
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		List resList = new ArrayList();
		resList.add(brands);
		resList.add(page);
		resList.add(pages);
		JSONArray json = JSONArray.fromObject(resList);
		String jsonp=request.getParameter("jsonpcallback");
		out.print(jsonp+"("+json.toString()+")");
	}
	public String manage() throws UnsupportedEncodingException{
		//setInfo();
		if("0".equals(state))
		{
			if(!ulevel.contains("5"))
				stationId = "-1";
			else 
				setInfo();
		}
		changePage();
		return SUCCESS;
	}
	private void changePage(){
		int start = rows * (page - 1);
		carGroupbuyList = SaleFavoredService.getInstance().getAllCarGroup(start, rows,keywords.trim(),type,pinpai,stationId,isdelete);
		if(carGroupbuyList.size()>0){
			count = (Integer) carGroupbuyList.get(0).get("count");
		}
		pages = count / rows;
		if (count % rows != 0) {
			pages++;
		}
	}
	public String add(){
		setInfo();
		return SUCCESS;
	}
	public String update(){
		//setInfo();
		System.out.println("SaleFavoredAction.update()");
		carGroup = SaleFavoredService.getInstance().getCarGroupById(id);
		stationId = carGroup.get("sites_id").toString();
		if(!"0".equals(stationId))
			stationName = StationType.getEnum(stationId).getType();
		return SUCCESS;
	}
	
	public String updateSaleFavored(){
		String pic = carGroupbuy.getPic();
		if(!("").equals(pic)){	
			if(pic.contains("315/"))
				carGroupbuy.setPic(pic);
			else
			carGroupbuy.setPic("ct1"+pic.substring(pic.indexOf("/upload/"), pic.length()));//upload后为存入目录
		}
		if(carGroupbuy.getBegdate()==null)
			carGroupbuy.setBegdate(new Date());
		if(carGroupbuy.getEnddate()==null)
			carGroupbuy.setEnddate(new Date());
		carGroupbuy.setAdddate(new Date());
		int result = SaleFavoredService.getInstance().updateCarGroupBuy(carGroupbuy);
		changePage();
		return SUCCESS;
	}
	public String saveSaleFavored() throws Exception{
		setInfo();
		String pic = carGroupbuy.getPic();
		if(!("").equals(pic)){
			carGroupbuy.setPic("ct1"+pic.substring(pic.indexOf("/upload/"), pic.length()));//upload后为存入目录
		}
		if(carGroupbuy.getBegdate()==null)
			carGroupbuy.setBegdate(new Date());
		if(carGroupbuy.getEnddate()==null)
			carGroupbuy.setEnddate(new Date());
		carGroupbuy.setAdddate(new Date());
		int buyType  = carGroupbuy.getBuy_type();
		if(buyType == 0){
			if(!ulevel.contains("5")){
				for(int i = 1;i<=12;i++){
					TbCarGroupbuy groupbuy = carGroupbuy;
					groupbuy.setSites_id(i);
					if(i!=1)
						groupbuy.setIsdelete(1);
					SaleFavoredService.getInstance().saveCarGroupBuy(groupbuy);
					
				}
			}else {
				 SaleFavoredService.getInstance().saveCarGroupBuy(carGroupbuy);
			}
			
		}
		else {
			SaleFavoredService.getInstance().saveCarGroupBuy(carGroupbuy);
		}
		
		return SUCCESS;
	}
	private void setInfo(){
		Map<String,Object> map = (Map<String, Object>) session.get("userInfo");
		//ulevel = ((Map<String, Object>) session.get("ulevel")).toString();
		stationId = map.get("sub_sites_id").toString();
		ulevel = map.get("ulevel").toString();
		if("0".equals(stationId))
			stationId = "1";
		if(!"0".equals(stationId))
			stationName = StationType.getEnum(stationId).getType();
	}
	public String showpre(){
		groupInfo = SaleFavoredService.getInstance().getPre(idx);
		return SUCCESS;
	}
	public TbCarGroupbuy getCarGroupbuy() {
		return carGroupbuy;
	}
	public void setCarGroupbuy(TbCarGroupbuy carGroupbuy) {
		this.carGroupbuy = carGroupbuy;
	}
	public int getFatherid() {
		return fatherid;
	}
	public void setFatherid(int fatherid) {
		this.fatherid = fatherid;
	}
	public int getCatalogid() {
		return catalogid;
	}
	public void setCatalogid(int catalogid) {
		this.catalogid = catalogid;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<HashMap<String, Object>> getCarGroupbuyList() {
		return carGroupbuyList;
	}
	public void setCarGroupbuyList(List<HashMap<String, Object>> carGroupbuyList) {
		this.carGroupbuyList = carGroupbuyList;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Map<String, Object> getCarGroup() {
		return carGroup;
	}
	public void setCarGroup(Map<String, Object> carGroup) {
		this.carGroup = carGroup;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getPinpai() {
		return pinpai;
	}
	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}
	public String getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public HashMap<String, String> getGroupInfo() {
		return groupInfo;
	}
	public void setGroupInfo(HashMap<String, String> groupInfo) {
		this.groupInfo = groupInfo;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
