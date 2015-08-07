package com.poly.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import car_beans.DboPubAd;
import car_beans.DboPubAdinfo;

import com.poly.dao.che.AdDao;

public class AdService {

	
	public static List<Map<String,String>> getAdInfoByCity(int city, String adUrl){
		return AdDao.getAdInfoByCity(city,adUrl);
	}

	public static List<Map<String,String>> getInfoById(String adId) {
		// TODO Auto-generated method stub
		//if(AdDao.getAdScheduleByAdId(AdDao.getInfoById(adId).get("adInfoId")).size()>0){
			return AdDao.getInfoById(adId);
		/*}else{
			return new HashMap<String, String>();
		}*/
		
	}

	public static void addAdSchedule(String edate, String sdate,String adId) {
		// TODO Auto-generated method stub
		AdDao.addAdSchedule(edate,sdate,adId);
	}

	public static List<Map<String,String>> getAdScheduleByAdId(String adId) {
		// TODO Auto-generated method stub
		return AdDao.getAdScheduleByAdId(adId);
	}

	public static void saveAdInfo(DboPubAdinfo adInfo) {
		// TODO Auto-generated method stub
		AdDao.saveAdInfo(adInfo);
	}

	public static void deleteAdSchedule(String scheduleId) {
		// TODO Auto-generated method stub
		AdDao.deleteAdSchedule(scheduleId);
	}

	public static void updateAdInfo(DboPubAdinfo adInfo) {
		// TODO Auto-generated method stub
		AdDao.updateAdInfo(adInfo);
	}

	public static int getMaxId() {
		// TODO Auto-generated method stub
		return AdDao.getMaxId();
	}

	public static DboPubAdinfo getAdInfoById(String adId) {
		// TODO Auto-generated method stub
		return AdDao.getAdInfoById(adId);
	}

	public static DboPubAd getAdById(String adId) {
		// TODO Auto-generated method stub
		return AdDao.getAdById(adId);
	}

	public static Boolean judgeAdschedule(String sdate, String edate,
			String adId) {
		// TODO Auto-generated method stub
		return AdDao.judgeAdschedule(sdate,edate,adId);
	}

	public static void updateAdInfoById(String adInfoId) {
		// TODO Auto-generated method stub
		AdDao.updateAdInfoById(adInfoId);
	}

	public static void saveAd(DboPubAd ad) {
		// TODO Auto-generated method stub
		AdDao.saveAd(ad);
	}

	public static Map<String, Object> getAdInfoScheduleById(int aid) {
		// TODO Auto-generated method stub
		return AdDao.getAdInfoScheduleById(aid);
	}

	public static void updateAdvertisement(DboPubAd ad) {
		// TODO Auto-generated method stub
		AdDao.updateAdvertisement(ad);
	}

	public static boolean judgeAdHasOrNot(String sql) {
		// TODO Auto-generated method stub
		return AdDao.judgeAdHasOrNot(sql);
	}
}
