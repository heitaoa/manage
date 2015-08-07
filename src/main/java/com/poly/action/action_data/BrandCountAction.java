package com.poly.action.action_data;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;
import com.poly.util.PageUtilNew;

public class BrandCountAction extends MyActionSupport{
	public String date_start=getDay();//默认当前日期的前一天
	public String date_end=getDay();//默认当前日期的前一天

	public String real_type="-1"; //渠道
	private Map<String, String> provMap;  //区域列表
	private Map<String,String> channelMap; //渠道列表
	private String promo_prov = "";  //省份
	private String promo_city = "";  //城市
	private int counts;//报名人数
	private int backcounts;//已回访
	private int noaccesss;//未接通
	private int validcounts;//无效人数
	private String backrates="";//回访率
	public List<Map<String, Object>> applyList=new ArrayList<Map<String,Object>>();
	
	private int page = 1;  //显示页
	private int pages = 0;     //总页数
	private int pagelength = 5;  //显示页码数
	
	private int pageNum = 10; //每页显示条数
	private List<String> pageList;  //返回页面的页码列表
	
	public String execute(){
		//初始化渠道列表
		channelMap=new HashMap<String, String>();
			channelMap.put("0", "车团PC");
			channelMap.put("1", "车团手机");
			channelMap.put("4", "tuan.315che.com-pc（百度）");
			channelMap.put("5", "tuan.315che.com-mobile(百度)");
			channelMap.put("6", "315chePC");
			channelMap.put("7", "suncarsPC");
			channelMap.put("8", "315che手机");
			channelMap.put("9", "合作媒体");
			channelMap.put("10", "suncars手机");
			channelMap.put("11", "专题页报名");
			channelMap.put("12", "特卖惠专题");
			channelMap.put("13", "合作网站");
			channelMap.put("14", "合作app");
			channelMap.put("18", "购车节专题");
			channelMap.put("19", "车展自行访客");
			channelMap.put("20", "合作渠道");

		Map<String, String> mapWhere = new HashMap<String, String>();
		mapWhere.put("date_start", date_start);
		mapWhere.put("date_end", date_end);
		mapWhere.put("real_type", real_type);
		mapWhere.put("promo_prov", promo_prov);
		mapWhere.put("promo_city", promo_city);
		mapWhere.put("real_type", real_type);
		
		mapWhere.put("pageNum", String.valueOf(pageNum));
		mapWhere.put("page", String.valueOf(page));
		provMap = ProjectService.getInstance().getProvMap();
		counts=ProjectService.getInstance().selectCounts(mapWhere, "");
		backcounts=ProjectService.getInstance().selectCounts(mapWhere, "t1.return_visit_state!=0");
		noaccesss=ProjectService.getInstance().selectCounts(mapWhere, "t1.phoneerror=1");
		validcounts=ProjectService.getInstance().selectCounts(mapWhere, "t1.phone_state!=0");
		backrates=getPercent(backcounts,counts);
		pages = ProjectService.getInstance().getApplyListPages(mapWhere);
		List<Map<String, String>> list = ProjectService.getInstance().getApplyList2(mapWhere);
		for (Map<String, String> map : list) {
			Map<String, Object> info = new HashMap<String, Object>();
			info.put("iway", map.get("iway"));
			int bmcount = Integer.parseInt(map.get("count"));
			int hfcount = ProjectService.getInstance().getbrandCountByCitys(mapWhere,map.get("iway"));
			int wjcount = ProjectService.getInstance().getbrandwCountByCitys(mapWhere,map.get("iway"));
			int yxcount=ProjectService.getInstance().getbrandyxCountByCitys(mapWhere,map.get("iway"));
			info.put("bmcount", bmcount);
			info.put("hfcount",hfcount);
			info.put("wjcount",wjcount);
			info.put("yxcount",yxcount);
			info.put("hfpercent", getPercent(hfcount,bmcount));
			applyList.add(info);
		}
		
		pageList = PageUtilNew.getPageListNew(page, pages, pagelength);
		
		return SUCCESS;
	}

	public  String getPercent(int x,int total){  
		   String result="";//接受百分比的值  
		   if(x==0){
			   result="0.00%";
		   }
		   else{
		   double x_double=x*1.0;  
		   double tempresult=x_double/total*1.0;  
		   //NumberFormat nf   =   NumberFormat.getPercentInstance();     注释掉的也是一种方法  
		   //nf.setMinimumFractionDigits( 2 );        保留到小数点后几位  
		   DecimalFormat df1 = new DecimalFormat("0.00%");    //##.00%   百分比格式，后面不足2位的用0补齐  
		   //result=nf.format(tempresult);     
		   result= df1.format(tempresult); 
		   }
		   return result;  
		}



	public String getDate_start() {
		return date_start;
	}
	public void setDate_start(String date_start) {
		this.date_start = date_start;
	}

	public String getDate_end() {
		return date_end;
	}

	public void setDate_end(String date_end) {
		this.date_end = date_end;
	}

	public Map<String, String> getChannelMap() {
		return channelMap;
	}

	public void setChannelMap(Map<String, String> channelMap) {
		this.channelMap = channelMap;
	}

	public int getValidcounts() {
		return validcounts;
	}

	public void setValidcounts(int validcounts) {
		this.validcounts = validcounts;
	}

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	public int getBackcounts() {
		return backcounts;
	}

	public void setBackcounts(int backcounts) {
		this.backcounts = backcounts;
	}

	public int getNoaccesss() {
		return noaccesss;
	}

	public void setNoaccesss(int noaccesss) {
		this.noaccesss = noaccesss;
	}

	public String getBackrates() {
		return backrates;
	}

	public void setBackrates(String backrates) {
		this.backrates = backrates;
	}

	public String getReal_type() {
		return real_type;
	}

	public void setReal_type(String real_type) {
		this.real_type = real_type;
	}

	public List<Map<String, Object>> getApplyList() {
		return applyList;
	}

	public void setApplyList(List<Map<String, Object>> applyList) {
		this.applyList = applyList;
	}
	public Map<String, String> getProvMap() {
		return provMap;
	}

	public void setProvMap(Map<String, String> provMap) {
		this.provMap = provMap;
	}

	public String getPromo_prov() {
		return promo_prov;
	}

	public void setPromo_prov(String promo_prov) {
		this.promo_prov = promo_prov;
	}

	public String getPromo_city() {
		return promo_city;
	}

	public void setPromo_city(String promo_city) {
		this.promo_city = promo_city;
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
	public String getDay(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1); //得到前一天
		Date date = calendar.getTime();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    String x=	df.format(date);
		return x;
		}
}
