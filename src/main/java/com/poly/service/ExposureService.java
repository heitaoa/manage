package com.poly.service;

import java.util.List;

import com.poly.dao.che.ExposureDao;

import car_beans.DboAdExposure;
import car_daos.DboAdExposureDao;

public class ExposureService {

	public static List<DboAdExposure> getAllExposure() {
		// TODO Auto-generated method stub
		String sql = "isdelete = 0 order by url";
		List<DboAdExposure> list = DboAdExposureDao.where(sql);
		return list;
	}
	
	public static void insertExposure(DboAdExposure exposure){
		ExposureDao.insertExposure(exposure);
	}

	public static void deleteExposure(String exposureid) {
		// TODO Auto-generated method stub
		ExposureDao.deleteExposure(exposureid);
	}
    
	public static void updateExposure(DboAdExposure exposure){
		ExposureDao.updateExposure(exposure);
	}

	public static DboAdExposure getExposureById(String exposureid) {
		// TODO Auto-generated method stub
		return ExposureDao.getExposureById(exposureid);
	}

	public static int getAllExposureCount() {
		// TODO Auto-generated method stub
		return ExposureDao.getAllExposureCount();
	}

	public static List<DboAdExposure> getAllExposureByPage(int from, int i) {
		// TODO Auto-generated method stub
		return ExposureDao.getAllExposureByPage(from,i);
	}
	
	
	
}
