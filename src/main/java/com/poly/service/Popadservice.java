package com.poly.service;

import java.util.List;

import com.poly.dao.che.PopadDao;

import car_beans.DboAdPopad;
import car_daos.DboAdPopadDao;

public class Popadservice {
	
	public static List<DboAdPopad> getPopad(){
		
		String sql = "isdelete = 0";
		List<DboAdPopad> list = DboAdPopadDao.where(sql);
		return list;
	}

	public static void insertPopad(DboAdPopad popad){
		PopadDao.insertPopad(popad);	
	}
	
	public static void deletePopad(String popadid){
		PopadDao.deletePopad(popadid);
	}
	
	public static void updatePopad(DboAdPopad popad){
		PopadDao.updatePopad(popad);
	}
	
	public static DboAdPopad getPoapdById(String popadid){	
		return PopadDao.getPoapdById(popadid);
	}

	public static int getMaxPopId() {
		// TODO Auto-generated method stub
		return PopadDao.getMaxPopId();
	}

	public static List<DboAdPopad> getPopadByPage(int from, int i) {
		// TODO Auto-generated method stub
		return PopadDao.getPopadByPage(from,i);
	}

	public static int getPopadCount() {
		return PopadDao.getPopadCount();
		
		// TODO Auto-generated method stub

	}

	
}
