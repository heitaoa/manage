package com.poly.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//import com.deity.alchemy.services.CastleService;

public class TimeUtils {

	public static Date DBDATE = null;

	public static long DIFDATE = 0;

//	// ÿ5����ȡһ��ϵͳʱ��
//	public static Date getDBDate() {
//		CastleService castleService = new CastleService();
//		Date date = castleService.getDBNowTime(ConfUtils.dsTask);
//		DIFDATE = date.getTime() - new Date().getTime();
//		return date;
//	}

//	public static Date getDBDATE() {
//		if (DBDATE == null) {
//			DBDATE = getDBDate();
//		}
//		return DBDATE;
//	}

	public static Date getNow() {
		Date now = new Date();
		if ((DIFDATE > 3600000) || (DIFDATE < -3600000)) {
			new Exception("DIFDATE=" + DIFDATE).printStackTrace();
		}
		return new Date(now.getTime() + DIFDATE);
	}

	public static void setDBDATE(Date dbdate) {
		DBDATE = dbdate;
	}

	public static void main(String[] aa) {
		new Exception("DIFDATE=" + DIFDATE).printStackTrace();
		
		System.out.println(getNowDate());
	}
	
	
	public static String getNowDate(){
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
		String temp_str=sdf.format(cal.getTime());   
		return temp_str;
	}
}
