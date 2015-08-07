package com.poly.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static String getYear(Date date) {
		Calendar cal = Calendar.getInstance();
		if (date != null)
			cal.setTime(date);
		String yy = new Integer(cal.get(Calendar.YEAR)).toString();
		return yy;
	}

	public static String getMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		if (date != null)
			cal.setTime(date);
		int mm = cal.get(Calendar.MONTH) + 1;
		String month = mm + "";
		if (mm < 10) {
			month = "0" + month;
		}
		return month;
	}

	public static String getRealMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		if (date != null)
			cal.setTime(date);
		int mm = cal.get(Calendar.MONTH);
		String month = mm + "";
		return month;
	}

	public static String getDay(Date date) {
		Calendar cal = Calendar.getInstance();
		if (date != null)
			cal.setTime(date);
		int dd = cal.get(Calendar.DATE);
		String day = dd + "";
		if (dd < 10) {
			day = "0" + day;
		}
		return day;
	}

	public static String getHour(Date date) {
		Calendar cal = Calendar.getInstance();
		if (date != null)
			cal.setTime(date);
		int hh = cal.get(Calendar.HOUR_OF_DAY);
		String hour = hh + "";
		if (hh < 10) {
			hour = "0" + hour;
		}
		return hour;
	}

	public static String getMinute(Date date) {
		Calendar cal = Calendar.getInstance();
		if (date != null)
			cal.setTime(date);
		int mi = cal.get(Calendar.MINUTE);
		String minute = mi + "";
		if (mi < 10) {
			minute = "0" + minute;
		}
		return minute;
	}

	public static String getSecond(Date date) {
		Calendar cal = Calendar.getInstance();
		if (date != null)
			cal.setTime(date);
		int sec = cal.get(Calendar.SECOND);
		String second = sec + "";
		if (sec < 10) {
			second = "0" + second;
		}
		return second;
	}

	public static Date getDate(String year, String month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(year));
		cal.set(Calendar.MONTH, Integer.parseInt(month));
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getLastDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * @param date
	 * @param format
	 *            1.YYYY-MM-DD(default) 2.YYYYMMDD 3.YYYY-MM-DD HH:MI:SS
	 * @return
	 */
	public static String getTime(Date date, String format) {
		String yy = getYear(date);
		String mm = getMonth(date);
		String dd = getDay(date);
		String hh = getHour(date);
		String mi = getMinute(date);
		String ss = getSecond(date);
		if ("YYYYMMDD".equals(format)) {
			return yy + mm + dd;
		} else if ("YYYY-MM-DD HH:MI:SS".equals(format)) {
			return yy + "-" + mm + "-" + dd + " " + hh + ":" + mi + ":" + ss;
		} else {
			return yy + "-" + mm + "-" + dd;
		}
	}

	public static String getNow() {
		return getTime(new Date(), "YYYY-MM-DD HH:MI:SS");
	}

	public static String getTime(Date date) {
		return getTime(date, "default");
	}

	public static String getTime() {
		return getTime(new Date(), "default");
	}

	public static String getTime(String format) {
		return getTime(new Date(), format);
	}

	/**
	 * ���ش�Ԫ�굽ָ����������������mysql to_days()�������ƣ�
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static int getDaysForCalendarDate(java.util.Calendar date) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date_start = sdf.parse("0000-01-03");
		Calendar yuan = Calendar.getInstance();
		yuan.setTime(date_start);
		if (yuan.after(date)) { // swap dates so that d1 is start and d2 is end
			java.util.Calendar swap = yuan;
			yuan = date;
			date = swap;
		}
		int days = date.get(java.util.Calendar.DAY_OF_YEAR) - yuan.get(java.util.Calendar.DAY_OF_YEAR);
		int y2 = date.get(java.util.Calendar.YEAR);
		if (yuan.get(java.util.Calendar.YEAR) != y2) {
			yuan = (java.util.Calendar) yuan.clone();
			do {
				days += yuan.getActualMaximum(java.util.Calendar.DAY_OF_YEAR);
				yuan.add(java.util.Calendar.YEAR, 1);
			} while (yuan.get(java.util.Calendar.YEAR) != y2);
		}
		return days;
	}

	public static void main(String args[]) throws Exception {

		// System.out.println(getDaysForCalendarDate(Calendar.getInstance()));
		// System.out.println(getHour(TimeUtils.getNow()));

		System.out.println(getForwardDay(30));

	}

	public static String getForwardDay(int forward) {
		Date d = getDateBefore(new Date(), forward);
		return getTime(d, "YYYY-MM-DD HH:MI:SS");
	}
	
	public static Date getDateBefore(Date d,int day){  
		   Calendar now =Calendar.getInstance();  
		   now.setTime(d);  
		   now.set(Calendar.DATE,now.get(Calendar.DATE)-day);  
		   return now.getTime();  
		  } 
	
}
