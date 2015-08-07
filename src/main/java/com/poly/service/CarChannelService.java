package com.poly.service;

import java.util.ArrayList;
import java.util.List;

import com.poly.util.FieldUtil;

import car_beans.DboCarCatalognew;
import car_daos.DboCarCatalognewDao;

public class CarChannelService {
	
	private static final CarChannelService instance=new CarChannelService();
	
	private CarChannelService(){
		
	}
	
	public static CarChannelService getInstance(){
		return instance;
	}
	
	public List<DboCarCatalognew> findList(int page,int pageSize ,String name){
		int begin=(page-1)*pageSize;
		int end=begin+pageSize;
		List<DboCarCatalognew> list =new ArrayList<DboCarCatalognew>();
		if(!FieldUtil.isEmpty(name)){
			String nSql="iway LIKE '%"+name+"%' ORDER BY catalogid ASC LIMIT "+begin+","+end;
			list=DboCarCatalognewDao.where(nSql);
		}else{
			//list=DboCarCatalognewDao.DboCarCatalognewSelectAllColumnBylimit_beginlimit_num2(begin, pageSize);
		}
		return list;
	}
	
	public int getAmount(String name){
		int amount=0;
		List<DboCarCatalognew> list =new ArrayList<DboCarCatalognew>();
		if(!FieldUtil.isEmpty(name)){
			String sSql="iway LIKE '%"+name+"%'";
			list=DboCarCatalognewDao.where(sSql);
			amount=list.size();
		}else{
			list=DboCarCatalognewDao.find();
			amount=list.size();
		}
		return amount;
	}
	
}
