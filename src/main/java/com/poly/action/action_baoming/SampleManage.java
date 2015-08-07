package com.poly.action.action_baoming;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;
import car_beans.DboAreCatalog;
import car_beans.TbCityArea;
import car_beans.TbDataBaoming;
import car_beans.TbDataBaominglog;
import car_beans.TbDataVisitRecord;
import car_daos.TbDataBaomingDao;
import car_daos.TbDataBaominglogDao;

import com.poly.action.MyActionSupport;
import com.poly.service.AppInfoService;
import com.poly.service.BaomingService;
import com.poly.service.ProjectService;
import com.poly.util.TbSequenceUtil;
import com.redis.RedisDao;

public class SampleManage extends MyActionSupport{
	private int page = 1;
	private int pages = 1;
	private int size = 20;
	
	
	private Map<String,String> regionMap;//大区列表
	
	//查询条件
	private String beginDate=getDay();//开始时间
	private String endDate=getDay();//结束时间
	private String iway3="-1";//品牌
	private String region="-1";//大区
	private String substation="-1"; //分站
	private String customerName="";//客服
	private int count = 0;//数据总量
	List<Map<String, String>> kctList ;
	private TbDataBaoming baoming;
	
	
	public String samplemanage() throws SQLException, ParseException{
		regionMap=new HashMap<String, String>();
		regionMap.put("1", "华东区");
		regionMap.put("2", "华南区");
		regionMap.put("3", "华中区");
		regionMap.put("4", "华北区");
		regionMap.put("5", "西部区");
		regionMap.put("6", "东北区");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//判断日期是否合法
		if(checkDate(beginDate)&&checkDate(endDate)){
			int prefIndex = size * (page - 1);
			kctList =  BaomingService.getInstance().querySample(region,substation,beginDate,endDate,customerName,iway3,prefIndex, size);
			count = BaomingService.getInstance().querySampleCount(region,substation,beginDate,endDate,customerName,iway3);
			if(count%size == 0)
				pages = count/size;
			else
				pages = count/size + 1;
		}
			
		
		return SUCCESS;
	}
	public void getSubstationInfo() throws IOException{
		List<Map<String,String>> info = BaomingService.getInstance().getSubstationInfo(region);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(info);
		String jsonp=request.getParameter("jsonpcallback");
		out.print(jsonp+"("+json.toString()+")");
	}
	
	boolean checkDate(String date){
		boolean flag = false;
		if(date  == null){
			flag = false;
			return flag;
		}
		String reg = "([0-9]{4}-[0-9]{2}-[0-9]{2})";
		flag= Pattern.matches(reg, date);
		return flag;
	}
	
	
	public void samplemanageDetail() throws IOException, NumberFormatException, SQLException{
		
		String baomingid = request.getParameter("baomingid");
		Map<String, Object> map = BaomingService.getInstance().kctmanageDetail(
				Integer.valueOf(baomingid));
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(map);
		String jsonp = request.getParameter("jsonpcallback");
		out.print(jsonp + "(" + json.toString() + ")");
		
	}
	
	public void addSample() throws IOException, NumberFormatException, SQLException{
		Map<String,Object> map = (Map<String, Object>) session.get("userInfo");
		Date date = new Date();
		String man =  map.get("username").toString();
		String userid = map.get("userid").toString();
		//String man =  "阿强";
		String id = request.getParameter("id");
		String  samplecontent = URLDecoder.decode(request.getParameter("samplecontent"), "UTF-8"); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		String content = man+"  "+sdf.format(date)+"  "+ samplecontent;
		int result=BaomingService.getInstance().updateSample(man,userid,id,sdf.format(date),content);
		Map<String, Object> map1=new HashMap<String, Object>();
		map1.put("result", result);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(map1);
		String jsonp = request.getParameter("jsonpcallback");
		out.print(jsonp + "(" + json.toString() + ")");
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
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<Map<String, String>> getKctList() {
		return kctList;
	}
	public void setKctList(List<Map<String, String>> kctList) {
		this.kctList = kctList;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public TbDataBaoming getBaoming() {
		return baoming;
	}
	public void setBaoming(TbDataBaoming baoming) {
		this.baoming = baoming;
	}

	public Map<String, String> getRegionMap() {
		return regionMap;
	}

	public void setRegionMap(Map<String, String> regionMap) {
		this.regionMap = regionMap;
	}



	public String getIway3() {
		return iway3;
	}
	public void setIway3(String iway3) {
		this.iway3 = iway3;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getSubstation() {
		return substation;
	}
	public void setSubstation(String substation) {
		this.substation = substation;
	}
	
	public String getDay(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1); //得到前一天
		Date date = calendar.getTime();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    String x=	df.format(date);
		return x;
		}
}
