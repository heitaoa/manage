package com.poly.service;

import java.util.ArrayList;
import java.util.List;

import com.poly.util.CalcPageUtil;
import com.poly.util.FieldUtil;

import car_beans.DboCarBaiketitle;
import car_daos.DboCarBaiketitleDao;

public class CarPropertyService {

	private static final CarPropertyService instance=new CarPropertyService();
	
	private CarPropertyService(){
		
	}
	
	public static CarPropertyService getInstance(){
		return instance;
	}
	
	public List<DboCarBaiketitle> findList(int page,int pageSize,String name){
		
		int begin=(page-1)*pageSize;
		int end=begin+pageSize;
		List<DboCarBaiketitle> list=new ArrayList<DboCarBaiketitle>();
		if(!FieldUtil.isEmpty(name)){
			String nSql="title LIKE '%"+name+"%' ORDER BY id ASC LIMIT "+begin+","+end;
			list=DboCarBaiketitleDao.where(nSql);
		}else{
			list=DboCarBaiketitleDao.DboCarBaiketitleSelectAllColumnBylimit_beginlimit_num(begin, pageSize);
		}
		return list;
	}
	//��¼����
	public int getAmount(String name){
		int amount=0;
		List<DboCarBaiketitle> list=new ArrayList<DboCarBaiketitle>();
		if(!FieldUtil.isEmpty(name)){
			String sql="title like '%"+name+"%'";
			list=DboCarBaiketitleDao.where(sql);
			amount=list.size();
		}else{
			list=DboCarBaiketitleDao.find();
			amount=list.size();
		}
		return amount;
	}
	
}
