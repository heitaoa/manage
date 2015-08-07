package com.poly.action.action_baoming;

import java.io.IOException;
import java.io.PrintWriter;
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

public class SampleQuery extends MyActionSupport{
	private int page = 1;
	private int pages = 1;
	private int size = 20;
	
	
	
	//查询条件
	private String beginDate=getDay();//开始时间
	private String endDate=getDay();//结束时间
	private String customerName="";//被抽查人员
	private String customerName2="";//抽查人员
	private int count = 0;//数据总量
	List<Map<String, String>> kctList ;
	
	
	public String sampleQuery() throws SQLException, ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//判断日期是否合法
		if(checkDate(beginDate)&&checkDate(endDate)){
			int prefIndex = size * (page - 1);
			kctList =  BaomingService.getInstance().querySampleResult(customerName,customerName2,beginDate,endDate,prefIndex, size);
			count = BaomingService.getInstance().querySampleResultCount(customerName,customerName2,beginDate,endDate);
			if(count%size == 0)
				pages = count/size;
			else
				pages = count/size + 1;
		}
			
		
		return SUCCESS;
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
	
	
	public void sampleQueryDetail() throws IOException, NumberFormatException, SQLException{
		
		String baomingid = request.getParameter("baomingid");
		Map<String, Object> map = BaomingService.getInstance().kctmanageDetail(
				Integer.valueOf(baomingid));
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(map);
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


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerName2() {
		return customerName2;
	}


	public void setCustomerName2(String customerName2) {
		this.customerName2 = customerName2;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public List<Map<String, String>> getKctList() {
		return kctList;
	}


	public void setKctList(List<Map<String, String>> kctList) {
		this.kctList = kctList;
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
