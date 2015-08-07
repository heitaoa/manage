package com.poly.service;

import java.util.ArrayList;
import java.util.List;

import com.poly.util.FieldUtil;

import car_beans.DboCarCatalognew;
import car_daos.DboCarCatalognewDao;

public class CarMainSeriesService {

	private static final CarMainSeriesService instance=new CarMainSeriesService();
	
	private CarMainSeriesService(){
		
	}
	
	public static CarMainSeriesService getInstance(){
		return instance;
	}
	
	public List<DboCarCatalognew> findList(int page,int pageSize ,String name){
		int begin=(page-1)*pageSize;
		int end=begin+pageSize;
		List<DboCarCatalognew> list =new ArrayList<DboCarCatalognew>();
		if(!FieldUtil.isEmpty(name)){
			String fSql="catalogname LIKE '%"+name+"%'";
			List<DboCarCatalognew> flist=DboCarCatalognewDao.where(fSql);
			String cSql="pathlevel=3 and fatherid in (";
			for(int i=0;i<flist.size();i++){
				cSql=cSql+flist.get(i).getCatalogid()+",";
			}
			cSql=cSql.substring(0, cSql.length()-1)+") ORDER BY catalogid ASC LIMIT "+begin+","+end;
			list=DboCarCatalognewDao.where(cSql);
		}else{
			String Csql="pathlevel=3 ORDER BY catalogid ASC LIMIT "+begin+","+end;
			list=DboCarCatalognewDao.where(Csql);
		}
		String fidStr=" catalogid in ( ";
		for(int j=0;j<list.size();j++){
			int fid=list.get(j).getFatherid();
			fidStr=fidStr+fid+",";
		}
		fidStr=fidStr.substring(0, fidStr.length()-1)+" )";
		List<DboCarCatalognew> Flist=DboCarCatalognewDao.where(fidStr);
		for(int m=0;m<list.size();m++){
			for(int n=0;n<Flist.size();n++){
				if(list.get(m).getFatherid()==Flist.get(n).getCatalogid()){
					list.get(m).setCarSeries(Flist.get(n));
				}
			}
		}
		return list;
	}
	
	public int getAmount(String name){
		int amount=0;
		List<DboCarCatalognew> list =new ArrayList<DboCarCatalognew>();
		if(!FieldUtil.isEmpty(name)){
			String fSql="catalogname LIKE '%"+name+"%'";
			List<DboCarCatalognew> flist=DboCarCatalognewDao.where(fSql);
			String cSql="pathlevel=3 and fatherid in (";
			for(int i=0;i<flist.size();i++){
				cSql=cSql+flist.get(i).getCatalogid()+",";
			}
			cSql=cSql.substring(0, cSql.length()-1)+")";
			list=DboCarCatalognewDao.where(cSql);
			amount=list.size();
		}else{
			String Csql="pathlevel=3";
			list=DboCarCatalognewDao.where(Csql);
			amount=list.size();
		}
		return amount;
	}
	
}
