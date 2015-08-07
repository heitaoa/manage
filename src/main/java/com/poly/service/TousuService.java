package com.poly.service;

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

import car_beans.DboCarCatalognew;
import car_beans.DboDntTousu;
import car_beans.DboDntTousuDetail;
import car_daos.DboDntTousuDetailDao;

import com.poly.bean.newNews;
import com.poly.dao.subDaos.DboCarCatalognewSubDao;
import com.poly.dao.subDaos.TousuDetailSubDao;
import com.poly.dao.subDaos.TousuSubDao;
import com.redis.RedisDao;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

public class TousuService {
	private static final TousuService instance = new TousuService();
	public static TousuService getInstance(){
		return instance;
	}
	TousuSubDao tousuSubDao = new TousuSubDao();
	public List<Map<String, String>> queryToutu(int state,String beginDate,String endDate,String name,String phone,String keyword,int brandId,int chexiId,int prov,int city,int start,int rows){
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
		return tousuSubDao.queryToutu(state, beginDate, endDate, name, phone, keyword, brandId, chexiId, prov, city, start, rows);
	}
	
	public Map<String,Object> queryTousuDetail(int tousuid){
		return tousuSubDao.queryTousuDetail(tousuid);
	}
	
	public int updateTtousu(DboDntTousu dbodnttousu){
		return tousuSubDao.update(dbodnttousu);
	}
	DboDntTousuDetailDao dboDntTousuDetailDao = new DboDntTousuDetailDao();
	TousuDetailSubDao tousuDetailSubDao = new TousuDetailSubDao();
	public int saveTousuDetail(DboDntTousuDetail dboDntTousuDetail){
		int out = 0;
		try {
			//out =  dboDntTousuDetailDao.save(dboDntTousuDetail);
			 out =  tousuDetailSubDao.saveT(dboDntTousuDetail);
			 dboDntTousuDetail.setId(out);
			 RedisDao.saveTousuDetail(dboDntTousuDetail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}
	
	public List<DboDntTousuDetail> queryTousuComment(String tousuid){
		List<DboDntTousuDetail> list = dboDntTousuDetailDao.where("tousuid = "+tousuid+" order by addtime desc");
		return list==null? new ArrayList<DboDntTousuDetail>():list;
	}
	public void batchUpdateTousu(List<DboDntTousu> tousuList){
		tousuSubDao.batchUpdateTousu(tousuList);
	}
	
	public List<Map<String, Object>> queryToutuTotal(int state,
			String beginDate, String endDate, String name, String phone,
			String keyword, int brandId, int chexiId, int prov, int city){
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
		return tousuSubDao.queryToutuTotal(state, beginDate, endDate, name, phone, keyword, brandId, chexiId, prov, city);
	}
	
	//更具渠道获取投诉统计量
	public List<Map<String, Object>> queryTousuByIway(String beginDate,String endDate,int prov,int city,int brandId,int chexiId,String iway){
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
		return tousuSubDao.queryTousuByIway(beginDate, endDate, prov, city, brandId, chexiId, iway);
	}
	
	DboCarCatalognewSubDao dboCarCatalognewSubDao = new DboCarCatalognewSubDao();
	//更具品牌获取渠道
	public List<Map<String, String>> queryIwayByBrandId(int brandid){
		return dboCarCatalognewSubDao.queryIwayByBrandId(brandid);
	}
	
	public List<DboCarCatalognew> queryCarInfoByIway(String iway){
		String sql = " isdelete = 0 and pathlevel = 2 and iway = '"+iway+"'";
		return dboCarCatalognewSubDao.where(sql);
	}
	
	public List<Map<String, Object>> queryTousuSerialBySerial(String beginDate,String endDate,int prov,int city,String iway,int chexiId,int brandId){
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
		return tousuSubDao.queryTousuSerialBySerial(beginDate, endDate, prov, city, iway, chexiId, brandId);
	}
	public List<Map<String, Object>> queryTousuBySerial(String beginDate,String endDate,int prov,int city,int brandId,int chexiId,String iway){
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
		return tousuSubDao.queryTousuBySerial(beginDate, endDate, prov, city, brandId, chexiId, iway);
	}
	
	public Map<String, Object> queryTousuSerialByDuixiang(String beginDate,String endDate,int prov,int city,int brandId,int chexiId,String iway){
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
		String[] tousuObj = {"发动机","变速箱","悬架与传动系统","制动与转向系统","电器设备","轮胎","漆面与玻璃","其他附件","售前服务","售后服务"};
		Map<String, Object> objMap = new HashMap<String, Object>();
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = null;
		for (String str : tousuObj) {
			map = new HashMap<String, Object>();
			int count = tousuSubDao.queryTousuSerialByDuixiang(beginDate, endDate, prov, city, brandId, chexiId, iway,str);
			map.put("problem", str);
			map.put("count", count);
			list.add(map);
		}
		int totalCount = tousuSubDao.queryTousuSerialByDuixiang(beginDate, endDate, prov, city, brandId, chexiId, iway,"");
		objMap.put("totalCount", totalCount);
		Collections.sort(list,new Comparator<Map<String, Object>>(){
			public int compare(Map<String, Object> map1, Map<String, Object> map2) {
				int count1 = Integer.parseInt(map1.get("count").toString());
				int count2 = Integer.parseInt(map2.get("count").toString());
				if(count1>count2)
					return -1;
				if(count1<count2)
					return 1;
				return 0;
			}
		});
		objMap.put("info", list);
		return objMap;
	}

}
