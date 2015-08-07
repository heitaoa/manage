package com.poly.service;

import java.util.List;

import com.poly.dao.che.PopadscheduleDao;

import car_beans.DboAdPopadschedule;
import car_daos.DboAdPopadscheduleDao;

public class PopadscheduleService {

	public static List<DboAdPopadschedule> getschedule(String popadid){
		String sql="isdelete = 0 and popaid = '"+popadid+"'";
		List<DboAdPopadschedule> list = DboAdPopadscheduleDao.where(sql);
	    return list;
	}
	
	
	public static void insertPopadschedule(DboAdPopadschedule schedule){
		PopadscheduleDao.insertPopadschedule(schedule);	
	}

	public static void deletePopadschedule(String scheduleid){
		PopadscheduleDao.deletePopadschedule(scheduleid);
			
	}
	
}

