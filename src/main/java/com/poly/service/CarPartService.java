package com.poly.service;

import java.util.ArrayList;
import java.util.List;

import car_beans.DboCarBaiketitle;
import car_beans.DboCarNewproperty;
import car_daos.DboCarBaiketitleDao;
import car_daos.DboCarNewpropertyDao;

public class CarPartService {
	
	private static final CarPartService instance=new CarPartService();
	
	private CarPartService(){
		
	}
	
	public static CarPartService getInstance(){
		return instance;
	}
	
	public List<DboCarNewproperty> findList(int page,int pageSize){
		int begin=(page-1)*pageSize;
		int end=begin+pageSize;
		List<DboCarNewproperty> list=new ArrayList<DboCarNewproperty>();
		list=DboCarNewpropertyDao.DboCarNewpropertySelectAllColumnBylimit_beginlimit_num(begin, pageSize);
		return list;
	}
	
	public int getAmount(){
		int amount=0;
		List<DboCarNewproperty> list=new ArrayList<DboCarNewproperty>();
		list=DboCarNewpropertyDao.find();
		amount=list.size();
		return amount;
	}
	
}
