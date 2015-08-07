package com.poly.action.action_groupBuy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import car_beans.DboAreCatalog;

import com.poly.action.MyActionSupport;
import com.poly.service.AdminService;
import com.poly.service.AppInfoService;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class GroupBuyChartAction extends MyActionSupport{
	private List<String> chartList;
	private String addtime="";
	private int count  =0;
	private int yesCount = 0;//昨日某地
	private int nowCount = 0;//今日某地
	private int totalCount = 0;//昨日全国
	private String provName ="上海";
	private List<Map<String, String>> cusCount;
	private List<Map<String, String>> desCount;
	private String startTime;
	private String endTime;
	private List<Map<String, String>> typeList;
	private String prov = "-1";
	private String city = "-1";
	private List<HashMap<String, Object>> brandList;
	private String spaceid;
	private String level;
	private String secques;
	private String sub_sites_id = "1";
	private int cityflag;
	private int hfcount = 0;
	private String totalpersent = "-";
	public String execute(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		addtime = sdf.format((new Date()));
		chartList = AppInfoService.getInstance().getChartData(addtime);
		for (String counts : chartList) {
			count +=Integer.parseInt(counts);
		}
		return SUCCESS;
	}
	
	public String getChart(){
		chartList = AppInfoService.getInstance().getChartData(addtime);
		for (String counts : chartList) {
			count +=Integer.parseInt(counts);
		}
		return SUCCESS;
	}
	public String getChartCount(){
		String xx = "SELECT count(*) count ,substring(appdate,1,10) date  from tb_apply_info where isDelete  = 0 and prov = 9 and appdate BETWEEN '' and '' GROUP BY substring(appdate,1,10)";
		int provId = 9;
		Map<String,Object> map = (Map<String, Object>) session.get("userInfo");
		String prov = (String) map.get("prov");
		String level = (String) map.get("ulevel");
		if((level.contains("2")||level.contains("3"))||level.contains("6"))
			provId = Integer.parseInt(prov);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String Nowdate = sdf.format(new Date());
		
		nowCount = AppInfoService.getInstance().getDailyCount(provId, Nowdate);
		
		Calendar calendar = new GregorianCalendar(); 
	    calendar.setTime(new Date()); 
		calendar.add(calendar.DATE,-1);
		Date yesDate = calendar.getTime();
		
		yesCount = AppInfoService.getInstance().getDailyCount(provId, sdf.format(yesDate));
		totalCount = AppInfoService.getInstance().getDailyCount(-1,sdf.format(yesDate));
		provName = AppInfoService.getInstance().getProvName(provId);
		cusCount = AppInfoService.getInstance().get14DayCount(provId);
		List<Map<String, String>> des = new ArrayList<Map<String,String>>();
		for(int i = (cusCount.size()-1);i>=0;i--){
			des.add(cusCount.get(i));
		}
		desCount = des;
		return SUCCESS;
	}
	public String getTypeChart(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String Nowdate = sdf.format(new Date());
		startTime = Nowdate;
		endTime = Nowdate;
		typeList = AppInfoService.getInstance().getTypeCount(startTime, startTime);
		return SUCCESS;
	}
	public String searchTypeChart(){
		typeList = AppInfoService.getInstance().getTypeCount(startTime, endTime);
		return SUCCESS;
	}
	private void setRole(){
		Map<String,Object> map = (Map<String, Object>) session.get("userInfo");
		sub_sites_id = map.get("sub_sites_id")+"";
		spaceid = (String) map.get("prov");
		level = (String) map.get("ulevel");
		secques = (String)map.get("city");
		if(level.contains("2")||level.contains("3")||level.contains("6")){
			DboAreCatalog area = AdminService.getInstance().getProvId(sub_sites_id);
			int pid =  area.getFatherid()==0? area.getCatalogid():area.getFatherid();
			int cid =  area.getFatherid()==0? -1:area.getCatalogid();
			spaceid = pid+"";
			if("11".equals(sub_sites_id)||"12".equals(sub_sites_id)||"8".equals(sub_sites_id)||"4".equals(sub_sites_id))
				secques = cid+"";
		}
	}
	
	public String getBrandChart(){
		setRole();
		if(level.contains("2")||level.contains("3")||level.contains("6")){
			prov = spaceid;
			if("-1".equals(city))
				city = secques;
			if(Integer.parseInt(secques)!=-1)
				cityflag = 1;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		Calendar calendar = new GregorianCalendar(); 
	    calendar.setTime(now); 
		calendar.add(calendar.DATE,-1);
		now = calendar.getTime();
		startTime = sdf.format(now);
		endTime = startTime;
		brandList = AppInfoService.getInstance().getBrandsChart( sdf.format(now),  sdf.format(now), prov, city);
		for (HashMap<String, Object> map : brandList) {
			count += Integer.parseInt(map.get("bmcount").toString());
			hfcount += Integer.parseInt(map.get("hfcount").toString());
			
		}
		if(count>0)
			totalpersent = AppInfoService.getInstance().getPercent(hfcount, count);
		return SUCCESS;
	}
	public String searchBrandChart(){
		setRole();
		if("2".equals(level)||"3".equals(level)||level.contains("6")){
			prov = spaceid;
			if("-1".equals(city))
				city = secques;
			if(Integer.parseInt(secques)!=-1)
				cityflag = 1;
		}
		brandList = AppInfoService.getInstance().getBrandsChart(startTime, endTime, prov, city);
		for (HashMap<String, Object> map : brandList) {
			count += Integer.parseInt(map.get("bmcount").toString());
			hfcount += Integer.parseInt(map.get("hfcount").toString());
			
		}
		if(count>0)
			totalpersent = AppInfoService.getInstance().getPercent(hfcount, count);
		return SUCCESS;
	}
	public List<String> getChartList() {
		return chartList;
	}

	public void setChartList(List<String> chartList) {
		this.chartList = chartList;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getYesCount() {
		return yesCount;
	}

	public void setYesCount(int yesCount) {
		this.yesCount = yesCount;
	}

	public int getNowCount() {
		return nowCount;
	}

	public void setNowCount(int nowCount) {
		this.nowCount = nowCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getProvName() {
		return provName;
	}

	public void setProvName(String provName) {
		this.provName = provName;
	}

	public List<Map<String, String>> getCusCount() {
		return cusCount;
	}

	public void setCusCount(List<Map<String, String>> cusCount) {
		this.cusCount = cusCount;
	}

	public List<Map<String, String>> getDesCount() {
		return desCount;
	}

	public void setDesCount(List<Map<String, String>> desCount) {
		this.desCount = desCount;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public List<Map<String, String>> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<Map<String, String>> typeList) {
		this.typeList = typeList;
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

	public List<HashMap<String, Object>> getBrandList() {
		return brandList;
	}

	public void setBrandList(List<HashMap<String, Object>> brandList) {
		this.brandList = brandList;
	}

	public String getSpaceid() {
		return spaceid;
	}

	public void setSpaceid(String spaceid) {
		this.spaceid = spaceid;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getSecques() {
		return secques;
	}

	public void setSecques(String secques) {
		this.secques = secques;
	}

	public String getSub_sites_id() {
		return sub_sites_id;
	}

	public void setSub_sites_id(String sub_sites_id) {
		this.sub_sites_id = sub_sites_id;
	}

	public int getCityflag() {
		return cityflag;
	}

	public void setCityflag(int cityflag) {
		this.cityflag = cityflag;
	}

	public int getHfcount() {
		return hfcount;
	}

	public void setHfcount(int hfcount) {
		this.hfcount = hfcount;
	}

	public String getTotalpersent() {
		return totalpersent;
	}

	public void setTotalpersent(String totalpersent) {
		this.totalpersent = totalpersent;
	}




}
