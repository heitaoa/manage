package com.poly.action.action_advertisement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;
import car_beans.DboPubAd;
import car_beans.DboPubAdinfo;
import car_daos.DboAdPopadDao;

import com.poly.action.MyActionSupport;
import com.poly.service.AdService;
import com.poly.util.AdScheduleUtil;

public class AdvertisementAction extends MyActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//城市站广告详情列表
	private List<Map<String,String>> adMapList = new ArrayList<Map<String,String>>();
	//城市站
	private int city=0;
	//广告ID
	private String adId;
	//广告信息显示
	private List<Map<String,String>> adInfoList = new ArrayList<Map<String,String>>();
	//广告时间排期字符串
	private String dateStr;
	//广告排期列表
	private List<Map<String,String>> adscheduleList;
	//广告元素详情
	private DboPubAdinfo adInfo = new DboPubAdinfo();
	//广告开始时间
	private String sdate;
	//广告结束时间
	private String edate;
	//广告排期ID
	private String scheduleId;
	//广告元素详情ID
	private String adInfoId;
	//广告排期序号
	private String number;
	//广告位信息
	private DboPubAd ad;
	//判断日期是否存在
	private String html;
	//广告页面URL
	private String adUrl="";
	
	//获取对应全国站广告
	//1、新闻详情页：http://inf.315che.com/n/2015_02/518839/
	//2、新闻类型页：http://www.315che.com/news/135/2.htm
	//3、车型文章页：http://auto.315che.com/aodittcoupe/articles__1.htm
	//4、车型口碑页：http://koubei.315che.com/kblist/439.htm
	//5、经销商页面：http://4s.315che.com/439/0_1_1.htm
	//6、图片页面：http://pic.315che.com/carpic/12226-3-0.htm
	//7、综述页面：http://auto.315che.com/aodittcoupe/
	public String toAdvertisement(){
		//对特殊的URL进行处理
		if(adUrl!=null&&!adUrl.equals("")){
			dealWithUrl();
		}
		adMapList = AdService.getAdInfoByCity(city,adUrl.trim());
		return "toAdvertisement";
	}
	//获取对应城市站广告
	public void getAdInfoByCity(){
		dealWithUrl();
		adMapList = AdService.getAdInfoByCity(city,adUrl.trim());
		JSONArray jsonArray = JSONArray.fromObject(adMapList);
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(jsonArray.toString());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//对特殊的Url进行处理
	private void dealWithUrl(){
		Pattern pattern = null;
		Matcher matcher = null;
		if(adUrl.contains("http://inf.315che.com/n/")){
			pattern = Pattern.compile("^http://inf.315che.com/n/([0-9]+)-([0-9]+)/([0-9])+/");
			matcher = pattern.matcher(adUrl);
			if(matcher.matches()) adUrl = "http://inf.315che.com/n/daogou/";
		}else if(adUrl.contains("http://www.315che.com/news/")){
			adUrl = "http://www.315che.com/news/";
		}else if(adUrl.contains("http://auto.315che.com/")&&adUrl.contains("articles")){
			adUrl = "http://auto.315che.com/englishname/articles.htm";
		}else if(adUrl.contains("http://koubei.315che.com/")){
			adUrl = "http://koubei.315che.com/englishname/";
		}else if(adUrl.contains("http://4s.315che.com/")){
		}else if(adUrl.contains("http://tousu.315che.com/")){
			adUrl = "http://tousu.315che.com/englishname/";
		}else if(adUrl.contains("http://4s.315che.com/")){
			adUrl = "http://4s.315che.com/";
		}else if(adUrl.contains("http://pic.315che.com/carpic/")){
			adUrl = "http://pic.315che.com/carpic/";
		}else if(adUrl.contains("http://auto.315che.com/")){
			pattern = Pattern.compile("^http://auto.315che.com/([a-z]+)/");
			matcher = pattern.matcher(adUrl);
			if(matcher.matches()) adUrl = "http://auto.315che.com/englishname/";
		}else if(adUrl.contains("http://price.315che.com/brand/")||adUrl.contains("http://price.315che.com/series/")){
			adUrl = "http://price.315che.com/carid/";
		}else if(adUrl.contains("http://che.315che.com/")){
			pattern = Pattern.compile("^http://che.315che.com/([0-9]+)/");
			matcher = pattern.matcher(adUrl);
			if(matcher.matches()) adUrl = "http://che.315che.com/carid/";
		}
		
	}
	
	//根据页面的链接获取通用的链接
	private String getCommonAdHtml(String html){
		Pattern pattern = null;
		Matcher matcher = null;
		if(html.contains("http://inf.315che.com/n/")){
			pattern = Pattern.compile("^http://inf.315che.com/n/([0-9]+)-([0-9]+)/([0-9])+/");
			matcher = pattern.matcher(html);
			if(matcher.matches()) html = "http://inf.315che.com/n/daogou/";
		}else if(html.contains("http://www.315che.com/news/")){
			html = "http://www.315che.com/news/";
		}else if(html.contains("http://auto.315che.com/")&&html.contains("articles")){
			html = "http://auto.315che.com/englishname/articles.htm";
		}else if(html.contains("http://koubei.315che.com/")){
			html = "http://koubei.315che.com/englishname/";
		}else if(html.contains("http://4s.315che.com/")){
		}else if(html.contains("http://tousu.315che.com/")){
			html = "http://tousu.315che.com/englishname/";
		}else if(html.contains("http://4s.315che.com/")){
			html = "http://4s.315che.com/";
		}else if(html.contains("http://pic.315che.com/carpic/")){
			html = "http://pic.315che.com/carpic/";
		}else if(html.contains("http://auto.315che.com/")){
			pattern = Pattern.compile("^http://auto.315che.com/([a-z]+)/");
			matcher = pattern.matcher(html);
			if(matcher.matches()) html = "http://auto.315che.com/englishname/";
		}else if(html.contains("http://price.315che.com/brand/")||html.contains("http://price.315che.com/series/")){
			html = "http://price.315che.com/carid/";
		}else if(html.contains("http://che.315che.com/")){
			pattern = Pattern.compile("^http://che.315che.com/([0-9]+)/");
			matcher = pattern.matcher(html);
			if(matcher.matches()) html = "http://che.315che.com/carid/";
		}
		return html;
	}
	
	
	//添加广告元素
	public String addAdInfo(){
		adInfo.setIsdelete(0);
		adInfo.setAdclick(0);
		adInfo.setAdexposure(0);
		if(adInfo.getAdinfoid()>0){
			AdService.updateAdInfo(adInfo);
		}else{
			AdService.saveAdInfo(adInfo);
			int aid = AdService.getMaxId();
			for(int i = 0;i<AdScheduleUtil.adScheduleList.size();i++){
				AdService.addAdSchedule(AdScheduleUtil.adScheduleList.get(i).get("edate"), AdScheduleUtil.adScheduleList.get(i).get("sdate"),String.valueOf((aid)));
			}
			AdScheduleUtil.adScheduleList = new ArrayList<Map<String,String>>();
		}
		adId = String.valueOf(adInfo.getAdid());
		/*Map<String,Object> map = AdService.getAdInfoScheduleById(adInfo.getAdid());
		try {
			GenJsBlock.genAdJsBlock(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return "addAdInfo";
	}
	
/*	//添加广告排期
	private void addAdDate(String dateStr,String aid){
		//SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd");
		if(dateStr.indexOf("_")>0){
			String[] date = dateStr.split("_");
			for(int i=0;i<date.length;i++){
				AdService.addAdSchedule(date[i].split("至")[0],date[i].split("至")[1],aid);
			}
		}else{
			AdService.addAdSchedule(dateStr.split("至")[0],dateStr.split("至")[1],aid);
		}
	}*/
	//添加广告排期
	public void addAdSchedule(){
		if(!AdService.judgeAdschedule(sdate,edate,adId)){
			adscheduleList = new ArrayList<Map<String,String>>();
		}else{
			if(adInfoId!=null&&!adInfoId.equals("")){
				AdService.addAdSchedule(edate, sdate, adInfoId);
				adscheduleList = AdService.getAdScheduleByAdId(adInfoId);
			}else{
				if(html.trim().equals("")&&AdScheduleUtil.adScheduleList.size()>0){
					AdScheduleUtil.adScheduleList = new ArrayList<Map<String,String>>();
				}
				Map<String,String> map = new HashMap<String, String>();
				map.put("sdate",sdate);
				map.put("edate",edate);
				AdScheduleUtil.adScheduleList.add(map);
				adscheduleList = AdScheduleUtil.adScheduleList;
			}
		}
		response.setContentType("text/html;charset=utf-8");
		JSONArray json = JSONArray.fromObject(adscheduleList);
		try {
			PrintWriter out = response.getWriter();
			out.print(json.toString());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//删除广告排期
	public void deleteAdSchedule(){
		if(adInfoId!=null&&!adInfoId.equals("")){
			AdService.deleteAdSchedule(scheduleId);
			adscheduleList = AdService.getAdScheduleByAdId(adInfoId);
		}else{
			//AdScheduleUtil.adScheduleList.remove(Integer.valueOf(number));
		    for(int i=AdScheduleUtil.adScheduleList.size()-1;i >=0;i--){
		    	if(i==Integer.valueOf(number)){
		    		AdScheduleUtil.adScheduleList.remove(i);
		    	}
		    }
			adscheduleList = AdScheduleUtil.adScheduleList;
		}	
		response.setContentType("text/html;charset=utf-8");
		JSONArray json = JSONArray.fromObject(adscheduleList);
		try {
			PrintWriter out = response.getWriter();
			out.print(json.toString());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//删除广告
	public String deleteAdvertisement(){
		if(AdService.getAdScheduleByAdId(adInfoId).size()==1){
			AdService.updateAdInfoById(adInfoId);
		}
		AdService.deleteAdSchedule(scheduleId);
		return "deleteAdvertisement";
	}
	
	
	//获取广告位元素列表
	public String getAdvertisement(){
		ad = AdService.getAdById(adId);
		adInfoList = AdService.getInfoById(adId);	
		return "getAdvertisement";
	}
		
	//添加广告位元素
	public String toAddAdInfo(){
		return "toAddAdInfo";
	}
	
	//添加广告位
	public String toAddAdvertisement(){
		return "toAddAdvertisement";
	}
	public String addAdvertisement(){
		ad.setHtml(ad.getHtml().trim());
		AdService.saveAd(ad);
		city = ad.getCity();
		return "addAdvertisement";
	}
	
	private int adplace;//���߶�
	private String adtype;
	//判断该广告位是否已经存在
	public void judgeAdHasOrNot(){
		String sql = "SELECT * from dbo_pub_ad WHERE city = '"+city+"' and html = '"+html+"' and adtype = '"+adtype+"' and adplace = '"+adplace+"'";
		boolean flag = AdService.judgeAdHasOrNot(sql);
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(flag);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//修改广告位元素
	public String toUpdateAdvertisement(){
		ad = AdService.getAdById(adId);
		return "toUpdateAdvertisement";
	}
	
	//修改广告位元素
	public String updateAdvertisement(){
		//AdService.getAdInfoById(adInfoId);
		ad.setHtml(ad.getHtml().trim());
		AdService.updateAdvertisement(ad);
		city = ad.getCity();
		return "updateAdvertisement";
	}
	
	//修改广告位元素
	public String toUpdateAdInfo(){
		adInfo = AdService.getAdInfoById(adInfoId);
		return "toUpdateAdInfo";
	}
	
	//获取广告排期
	public void getAdSchedule(){
		response.setContentType("text/html;charset=utf-8");
		adscheduleList = AdService.getAdScheduleByAdId(adInfoId);
		JSONArray json = JSONArray.fromObject(adscheduleList);
		try {
			PrintWriter out = response.getWriter();
			out.print(json.toString());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Map<String, String>> getAdMapList() {
		return adMapList;
	}
	public void setAdMapList(List<Map<String, String>> adMapList) {
		this.adMapList = adMapList;
	}
	
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public String getAdId() {
		return adId;
	}
	public void setAdId(String adId) {
		this.adId = adId;
	}
	public List<Map<String, String>> getAdInfoList() {
		return adInfoList;
	}
	public void setAdInfoList(List<Map<String, String>> adInfoList) {
		this.adInfoList = adInfoList;
	}
	public String getDateStr() {
		return dateStr;
	}
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	public List<Map<String, String>> getAdscheduleList() {
		return adscheduleList;
	}
	public void setAdscheduleList(List<Map<String, String>> adscheduleList) {
		this.adscheduleList = adscheduleList;
	}
	public DboPubAdinfo getAdInfo() {
		return adInfo;
	}
	public void setAdInfo(DboPubAdinfo adInfo) {
		this.adInfo = adInfo;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public String getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getAdInfoId() {
		return adInfoId;
	}
	public void setAdInfoId(String adInfoId) {
		this.adInfoId = adInfoId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public DboPubAd getAd() {
		return ad;
	}
	public void setAd(DboPubAd ad) {
		this.ad = ad;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public String getAdUrl() {
		return adUrl;
	}
	public void setAdUrl(String adUrl) {
		this.adUrl = adUrl;
	}
	public int getAdplace() {
		return adplace;
	}
	public void setAdplace(int adplace) {
		this.adplace = adplace;
	}
	public String getAdtype() {
		return adtype;
	}
	public void setAdtype(String adtype) {
		this.adtype = adtype;
	}

}
