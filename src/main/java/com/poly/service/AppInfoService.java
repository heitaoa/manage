package com.poly.service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.crypto.Data;

import car_beans.DboAreCatalog;
import car_beans.DboCarCatalognew;
import car_beans.TbApplyDownloadDetail;
import car_beans.TbApplyInfo;
import car_daos.DboCarCatalognewDao;
import car_daos.TbApplyCountDao;
import car_daos.TbApplyDownloadDetailDao;
import car_daos.TbApplyInfoDao;
import car_daos.TbSubSitesDao;

import com.poly.dao.subDaos.DboAreCatalogSubDao;
import com.poly.dao.subDaos.TbApplyDetailSubDao;
import com.poly.dao.subDaos.TbApplyInfoSubDao;

public class AppInfoService {
	public enum SourceType{
		ct_tg("0","车团-团购"),
		ct_tmh("3","车团-特卖惠"),
		ct_xzdj("1","车团-询最低价"),
		ct_yysj("2","车团-预约试驾"),
		ct_wxcl("9","合作媒体"),
		ct_shuang11("11","专题页报名"),
		ct_tuan315pc("4","tuan.315che.com-PC(百度)"),
		ct_tuan315phone("5","tuan.315che.com-手机(百度)"),
		ct_315pc("6","315che-PC"),
		ct_315phone("8","315che-手机"),
		ct_suncarspc("7","suncars-PC"),
		ct_suncarsphone("10","suncars-手机"),
		ct_youshu("12","优数"),
		ct_yiche("13","合作网站"),
		ct_test("14","合作媒体测试"),
		ct_tmhwap("15","车团-特卖惠-手机"),
		ct_tgwap("16","车团-团购-手机"),
		ct_xzdjwap("17","车团-询最低价-手机");
		private String id;
		private String type;
		SourceType(String id,String type){
			this.id = id;
			this.type = type;
		}
		public String getId() {
			return id;
		}
		public String getType() {
			return type;
		}
		public static SourceType getEnum(String id){
			for (SourceType st : SourceType.values()) {
				if (st.getId().equals(id)) {
					return st;
				}
			}
			return null;
		}
	}
	public enum AttendType{
		type0(0,"未知"),
		type1(1,"参加-跟团到"),
		type2(2,"参加-自行到"),
		type3(3,"参加-方式待定"),
		type4(4,"可能参加"),
		type5(5,"不参加");
		private Integer id;
		private String type;
		AttendType(int id,String type){
			this.id = id;
			this.type = type;
		}
		public Integer getId() {
			return id;
		}
		public String getType() {
			return type;
		}
		public static AttendType getEnum(int id){
			for (AttendType at : AttendType.values()) {
				if (at.getId()==id) {
					return at;
				}
			}
			return null;
		}
	}
	public enum Cusintention{
		type0("0","未知"),
		type1("1","非常紧急，越快越好"),
		type2("2","本周有时间参加"),
		type3("3","下周有时间参加"),
		type4("4","要买，但不太确定时间"),
		type5("5","不需要购买了"),
		type6("6","未接通，需再次电话"),
		type7("7","其他情况");
		private String id;
		private String type;
		Cusintention(String id,String type){
			this.id = id;
			this.type = type;
		}
		public String getId() {
			return id;
		}
		public String getType() {
			return type;
		}
		public static Cusintention getEnum(String id){
			for (Cusintention at : Cusintention.values()) {
				if (id.equals(at.getId())) {
					return at;
				}
			}
			return null;
		}
	}
public static final AppInfoService instance = new AppInfoService();
	public static AppInfoService getInstance() {
		return instance;
	}
	TbApplyInfoSubDao tbApplyInfoSubDao = new TbApplyInfoSubDao();
	TbApplyInfoDao tbApplyInfoDao = new TbApplyInfoDao();
	DboAreCatalogSubDao dboAreCatalogSubDao =  new DboAreCatalogSubDao();
	DboCarCatalognewDao dboCarCatalognewDao = new DboCarCatalognewDao();
	TbApplyCountDao tbApplyCountDao = new TbApplyCountDao();
	TbApplyDetailSubDao tbApplyDetailSubDao = new TbApplyDetailSubDao();
	TbApplyDownloadDetailDao tbApplyDownloadDetailDao = new TbApplyDownloadDetailDao();
	public String getLast_update_time(int type){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(type>3){
			if(tbApplyCountDao.where("id = 1").get(0).getLast_update_time()==null)
				return "时间获取失败";
			else
				return sdf.format(tbApplyCountDao.find().get(0).getLast_update_time());
			}
		else 
			return sdf.format(new Date());
	}
	public List<HashMap<String, Object>> listApplyInfo(int start, int rows,String beginDate,String endDate,String name,String phone,String beginOrderDate,String endOrderDate,int isBuy,int phoneState,String brandname,int chexiId,int againReturnVisit,int prov,int city,int type,int againType,String brands,String is_key_cus,String cus_intention){
		if("".equals(beginDate))
			beginDate = "1970-1-1";
		if("".equals(endDate))
			endDate = "2100-1-1";
	/*	if("".equals(beginOrderDate))
			beginOrderDate = "1970-1-1";
		if("".equals(endOrderDate))
			endOrderDate = "2100-1-1";*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date = sdf.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = new GregorianCalendar(); 
	    calendar.setTime(date); 
		calendar.add(calendar.DATE,1);
		date=calendar.getTime();
		endDate = sdf.format(date);
		String newBrands = getBrands(brands);
		return tbApplyInfoSubDao.listApplyInfo(start, rows, beginDate, endDate, name, phone, beginOrderDate, endOrderDate, isBuy, phoneState, brandname, chexiId, againReturnVisit, prov,city,type,againType,newBrands,is_key_cus,cus_intention);
	}
	public String getBrands(String brands){
		String newBrands = "";
		if(!"".equals(brands)){
		String[] brandsx = brands.split(",");
		for (int i = 0;i<brandsx.length;i++) {
			if(i == brandsx.length-1)
				newBrands +="'"+brandsx[i]+"'";
			else
				newBrands +="'"+brandsx[i]+"',";
		}
		}
		return newBrands;
	}
	public List<HashMap<String, Object>> listApply(int start,int rows,String carId,int chexiId,int prov,int city,String beginDate,String endDate,String name,String phone,String rvman,int type,int typex,String brands,String is_key_cus,String visit_type,String beginOrderDate,String endOrderDate,String cus_intention){
		if("".equals(beginDate))
			beginDate = "1970-1-1";
		if("".equals(endDate))
			endDate = "2100-1-1";
		/*if("".equals(beginOrderDate))
			beginOrderDate = "1970-1-1";
		if("".equals(endOrderDate))
			endOrderDate = "2100-1-1";*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date = sdf.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = new GregorianCalendar(); 
	    calendar.setTime(date); 
		calendar.add(calendar.DATE,1);
		date=calendar.getTime();
		endDate = sdf.format(date);
		String newBrands = getBrands(brands);
		return tbApplyInfoSubDao.listApply(start, rows, carId, chexiId, prov, city, beginDate, endDate, name, phone, rvman,type,typex,newBrands,is_key_cus,visit_type,beginOrderDate,endOrderDate,cus_intention);
	}
	public List<DboAreCatalog> getCityInfo(int id){
		String sql = "fatherid = "+id+" and isdelete = 0 order by lname";
		return dboAreCatalogSubDao.where(sql);
	}
	public List<HashMap<String, Object>> downBaoming(String carId,int chexiId,int prov,int city,String beginDate,String endDate,String name,String phone,String rvman,int type,int typex,String brands,String is_key_cus,String visit_type,String beginOrderDate,String endOrderDate,String cus_intention){
		if("".equals(beginDate))
			beginDate = "1970-1-1";
		if("".equals(endDate))
			endDate = "2100-1-1";
		/*if("".equals(beginOrderDate))
			beginOrderDate = "1970-1-1";
		if("".equals(endOrderDate))
			endOrderDate = "2100-1-1";*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date = sdf.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = new GregorianCalendar(); 
	    calendar.setTime(date); 
		calendar.add(calendar.DATE,1);
		date=calendar.getTime();
		endDate = sdf.format(date);
		String newBrand = getBrands(brands);
		return tbApplyInfoSubDao.downBaoming(carId, chexiId,  prov, city, beginDate, endDate, name, phone, rvman, type, typex,newBrand,is_key_cus,visit_type,beginOrderDate,endOrderDate,cus_intention);
	}
	public String getDownLoadSql(String carId,int chexiId,int prov,int city,String beginDate,String endDate,String name,String phone,String rvman,int type,int typex,String brands,String is_key_cus,String visit_type,String beginOrderDate,String endOrderDate,String cus_intention){
		if("".equals(beginDate))
			beginDate = "1970-1-1";
		if("".equals(endDate))
			endDate = "2100-1-1";
		return tbApplyInfoSubDao.getDownloadSql(carId, chexiId, prov, city, beginDate, endDate, name, phone, rvman, type, typex, brands, is_key_cus, visit_type, beginOrderDate, endOrderDate, cus_intention);
				
	}
	public void saveDownloadDetail(TbApplyDownloadDetail detail){
		try {
			tbApplyDownloadDetailDao.save(detail);
		} catch (Exception e) {
			System.err.println("保存下载信息失败!"+e.getMessage());
		}
	}
	public List<HashMap<String, Object>> getRevman(){
		return tbApplyInfoSubDao.getRevman();
	}
	public List<HashMap<String, Object>> getRevman(String level,String sid){
		return tbApplyInfoSubDao.getRevman(level,sid);
	}
	public List<HashMap<String, Object>> listRev(int start, int rows,String beginDate,String endDate,String barndName,int chexiId,int prov,int city,int type,String rvman,int typex,String brands){
		if("".equals(beginDate))
			beginDate = "1970-1-1";
		if("".equals(endDate))
			endDate = "2100-1-1";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date = sdf.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = new GregorianCalendar(); 
	    calendar.setTime(date); 
		calendar.add(calendar.DATE,1);
		date=calendar.getTime();
		endDate = sdf.format(date);
		//System.err.println(endDate);
		String newBrands = getBrands(brands);
		return tbApplyInfoSubDao.listRev(start, rows, beginDate, endDate, barndName, chexiId, prov, city, type, rvman,typex,newBrands);
	}
	public String getCarName(String id){
		return tbApplyInfoSubDao.getCarName(id);
	}
	public List<HashMap<String, Object>> getCheXing(int id){
		return tbApplyInfoSubDao.getCheXing(id);
	}
	public Map<String, Object> getDetail(int id){
		return tbApplyInfoSubDao.getDetail(id);
	}
	public int updateApply(TbApplyInfo tbApplyInfo)
	{
		return tbApplyInfoSubDao.updateApply(tbApplyInfo);
	}
	
	public int tuisong(TbApplyInfo tbApplyInfo)
	{
		return tbApplyInfoSubDao.tuisong(tbApplyInfo);
	}
	
	public void deleteApply(String uid,String applyid,String content,int type){
		tbApplyInfoSubDao.UpdateApplyState(uid,applyid,content,type);
	}
	
	public List<HashMap<String, Object>> getApplyDetail(int start,int rows,String sid,int ulevel,String name,String bgtime,String edtime) {
		if("".equals(bgtime))
			bgtime = "1970-1-1";
		if("".equals(edtime))
			edtime = "2100-1-1";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date = sdf.parse(edtime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = new GregorianCalendar(); 
	    calendar.setTime(date); 
		calendar.add(calendar.DATE,1);
		date=calendar.getTime();
		edtime = sdf.format(date);
		return tbApplyDetailSubDao.getApplyDetail(start, rows, sid, ulevel, name, bgtime, edtime);
	}
	public List<String> getChartData(String time){
		return tbApplyInfoSubDao.getChartData(time);
	}
	public int getDailyCount(int prov,String date){
		return tbApplyInfoSubDao.getDailyCount(prov, date);
	}
	public List<HashMap<String, Object>> getRevCount(String bgtime,String edtime,List<String> rvmans){
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		//return tbApplyInfoSubDao.getRevCount(bgtime, edtime, rvman);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		int count = 0;
		try {
			long from = df.parse(bgtime).getTime();
			long to = df.parse(edtime).getTime();
			int diff =  (int) ((to - from) / (1000 * 60 * 60 * 24));
			for(int  i = 0;i<=diff;i++){
				Calendar calendar = new GregorianCalendar(); 
				calendar.setTime(df.parse(bgtime));
				calendar.add(calendar.DATE,i);
				String bg = df.format(calendar.getTime());
				Calendar calendar2 = new GregorianCalendar(); 
				calendar2.setTime(df.parse(bgtime));
				calendar2.add(calendar.DATE,i+1);
				String ed = df.format(calendar2.getTime());
				
				HashMap<String, Object> map2 = new HashMap<String, Object>();
				List<HashMap<String, Object>> listx = new ArrayList<HashMap<String,Object>>();
				for (String rvman : rvmans) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					count = tbApplyInfoSubDao.getRevCount(bg, ed, rvman);
					map.put("rvman", rvman);
					map.put("count", count);
					listx.add(map);
				}
				map2.put("time", bg);
				map2.put("countData",listx);
				list.add(map2);
			}
		} catch (ParseException e) {
			System.err.println("时间转换出错!"+e.getMessage());
		}
		return list;
	}
	public List<HashMap<String, Object>> getsiteCount(String bgtime,String edtime,String prov,String city,String sid){
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		//return tbApplyInfoSubDao.getRevCount(bgtime, edtime, rvman);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			long from = df.parse(bgtime).getTime();
			long to = df.parse(edtime).getTime();
			int diff =  (int) ((to - from) / (1000 * 60 * 60 * 24));
			for(int  i = 0;i<=diff;i++){
				HashMap<String, Object> map = new HashMap<String, Object>();
				Calendar calendar = new GregorianCalendar(); 
				calendar.setTime(df.parse(bgtime));
				calendar.add(calendar.DATE,i);
				String bg = df.format(calendar.getTime());
				Calendar calendar2 = new GregorianCalendar(); 
				calendar2.setTime(df.parse(bgtime));
				calendar2.add(calendar.DATE,i+1);
				String ed = df.format(calendar2.getTime());
				int ucount = tbApplyInfoSubDao.getsiteCount(bg, ed, prov, city,0,sid);
				int icount = tbApplyInfoSubDao.getsiteCount(bg, ed, prov, city,1,sid);
				int total = ucount + icount;
				map.put("bg",bg);
				map.put("total",total);
				map.put("icount", icount);
				map.put("ucount", ucount);
				map.put("persent", getPercent(icount, total));
				list.add(map);
			}
		} catch (ParseException e) {
			System.err.println("时间转换出错!"+e.getMessage());
		}
		return list;
	}
	
	public List<HashMap<String, Object>> getsiteCountForAdm(String bgtime,String edtime){
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		//return tbApplyInfoSubDao.getRevCount(bgtime, edtime, rvman);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		TbSubSitesDao tbSubSitesDa = new TbSubSitesDao();
		List<DboAreCatalog> areas = dboAreCatalogSubDao.where("isDelete = 0 and pathlevel=1");
		
		int max = tbSubSitesDa.whereCount("1=1");
		try {
			Calendar calendar = new GregorianCalendar(); 
			calendar.setTime(df.parse(edtime));
			calendar.add(calendar.DATE,1);
			edtime = df.format(calendar.getTime());
			for(int i = 1;i<=max;i++){
				HashMap<String, Object> map = new HashMap<String, Object>();
				int ucount = tbApplyInfoSubDao.getsiteCountForAdm(bgtime, edtime, getProvAndCity(i).split(",")[0], getProvAndCity(i).split(",")[1],0,i);
				int icount = tbApplyInfoSubDao.getsiteCountForAdm(bgtime, edtime, getProvAndCity(i).split(",")[0], getProvAndCity(i).split(",")[1],1,i);
				int total = ucount + icount;
				String sitename = tbSubSitesDa.where("id="+i).get(0).getName();
				map.put("siteName",sitename);
				map.put("total",total);
				map.put("icount", icount);
				map.put("ucount", ucount);
				map.put("persent", getPercent(icount, total));
				list.add(map);
			}
			for (DboAreCatalog area : areas) {
				if(!checkSite(String.valueOf(area.getCatalogid()), max)){
					HashMap<String, Object> map = new HashMap<String, Object>();
					int ucount = tbApplyInfoSubDao.getsiteCountForAdm(bgtime, edtime, String.valueOf(area.getCatalogid()), "-1",0,1);
					int icount = tbApplyInfoSubDao.getsiteCountForAdm(bgtime, edtime, String.valueOf(area.getCatalogid()), "-1",1,1);
					int total = ucount + icount;
					map.put("siteName",area.getCatalogname());
					map.put("total",total);
					map.put("icount", icount);
					map.put("ucount", ucount);
					map.put("persent", getPercent(icount, total));
					list.add(map);
				
				}
			}
			
		} catch (ParseException e) {
			System.err.println("时间转换出错!"+e.getMessage());
		}
		return list;
	}
	boolean checkSite(String prov,int max){
		boolean flag = false;
		for(int i = 1;i<=max;i++){
			String p = getProvAndCity(i).split(",")[0];
			if(prov.equals(p)){
				flag = true;
				break;
			}
		}
		return flag;
	}
	public String getProvAndCity(int sid){
		String str = "";
		DboAreCatalog area =  AdminService.getInstance().getProvId(sid+"");{
			str = ""+(area.getFatherid()==0? area.getCatalogid():area.getFatherid()) +",-1";
			if(area.getFatherid()==10)
				str = "10,"+area.getCatalogid();
		}	
		if(sid==4)
			str = "10,-1";
		if(sid==8)
			str = "6,107";
/*		if(sid==11)
			str = "10,174";
		if(sid==12)
			str = "10,163";*/
		return str;
	}
	public String getProvName(int provId){
		String name="上海市";
		List<DboAreCatalog> dboAreCatalogs =   dboAreCatalogSubDao.where("catalogid = "+provId);
		if(dboAreCatalogs.size()>0)
			name = dboAreCatalogs.get(0).getCatalogname();
		return name;
	}
	public List<Map<String, String>> get14DayCount(int prov){
		List<Map<String, String>> resultList = new ArrayList<Map<String,String>>();
		Map<String, String> map = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
		String date="";
		String date2 = "";
		for(int i = 0;i<14;i++){
			map = new HashMap<String, String>();
			Calendar calendar = new GregorianCalendar(); 
			calendar.setTime(new Date()); 
			calendar.add(calendar.DATE,-i);
			date = sdf.format(calendar.getTime());
			date2 = sdf2.format(calendar.getTime());
			map.put("id",i+"");
			map.put("date", date);
			map.put("date2", calendar.getTimeInMillis()+"");
			map.put("provCount", tbApplyInfoSubDao.getDailyCount(prov, date)+"");
			map.put("chinaCount", tbApplyInfoSubDao.getDailyCount(-1, date)+"");
			resultList.add(map);
		}
		return resultList;
	}
	
	public List<Map<String, String>> getTypeCount(String startTime,String endTime){
		if("".equals(startTime))
			startTime = "1970-01-01";
		if("".equals(endTime))
			endTime = "2100-12-31";
		List<Map<String, String>> list = tbApplyInfoSubDao.getTypeCount(startTime, endTime);
		ComparatorMap comparator = new ComparatorMap();
		Collections.sort(list, comparator);
		return list;
	}
	public int addGroupBuy(TbApplyInfo tbApplyInfo) throws Exception{
		int chexing = tbApplyInfo.getModelid();
		String sql = "catalogid = "+chexing;
		int chexi = dboCarCatalognewDao.where(sql).get(0).getFatherid();
		sql = "catalogid = "+chexi;
		int brand = dboCarCatalognewDao.where(sql).get(0).getFatherid();
		tbApplyInfo.setCarid(brand);
		return tbApplyInfoSubDao.addGroupBuy(tbApplyInfo);
	}
	
	public List<HashMap<String, Object>> getAttendInfo(String carId,String brands,int chexiId,int prov,int city,int typex,int attType,String lookTime,String msgType){
		String newBrands = getBrands(brands);
		return tbApplyInfoSubDao.getAttendInfo(carId, newBrands, chexiId, prov, city, typex, attType, lookTime,msgType);
	}
	public int sendMsg(String id){
		return tbApplyInfoSubDao.updateMsgState(id);
	}
	public List<HashMap<String, Object>> getBrandsChart(String startTime,String endTime,String prov,String city){
		if("".equals(startTime))
			startTime = "1970-01-01";
		if("".equals(endTime))
			endTime = "2100-12-31";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date = sdf.parse(endTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = new GregorianCalendar(); 
	    calendar.setTime(date); 
		calendar.add(calendar.DATE,1);
		date=calendar.getTime();
		endTime = sdf.format(date);
		List<HashMap<String, String>> list =  tbApplyInfoSubDao.getBrandsChart(startTime, endTime, prov, city);
		List<HashMap<String, Object>> brandList = new ArrayList<HashMap<String,Object>>();
		HashMap<String, Object> info = null;
		int count = 0;
		for (HashMap<String, String> map : list) {
			count += Integer.parseInt(map.get("count"));
		}
		if(count != 0){
			for (HashMap<String, String> map : list) {
				info = new HashMap<String, Object>();
				info.put("iway", map.get("iway"));
				int bmcount = Integer.parseInt(map.get("count"));
				int hfcount = tbApplyInfoSubDao.getbrandCount(startTime, endTime, prov, city, map.get("iway"), 1);
				info.put("bmcount", bmcount);
				info.put("hfcount",hfcount);
				info.put("hfpercent", getPercent(hfcount,bmcount));
				brandList.add(info);
			}
		}
		return brandList;
	}
	public  String getPercent(int x,int total){  
		   String result="";//接受百分比的值  
		   double x_double=x*1.0;  
		   double tempresult=x_double/total*1.0;  
		   //NumberFormat nf   =   NumberFormat.getPercentInstance();     注释掉的也是一种方法  
		   //nf.setMinimumFractionDigits( 2 );        保留到小数点后几位  
		   DecimalFormat df1 = new DecimalFormat("0.00%");    //##.00%   百分比格式，后面不足2位的用0补齐  
		   //result=nf.format(tempresult);     
		   result= df1.format(tempresult); 
		   if(total==0)
			   result = "—";
		   return result;  
		}  
}
class ComparatorMap implements Comparator{

	 public int compare(Object arg0, Object arg1) {
		 Map<String, String> type1 = (Map<String, String>)arg0;
		 Map<String, String> type2 = (Map<String, String>)arg1;
	     int flag = Integer.parseInt(type2.get("count"))  - Integer.parseInt(type1.get("count"));
	     return flag;
	 }
	 
	}
