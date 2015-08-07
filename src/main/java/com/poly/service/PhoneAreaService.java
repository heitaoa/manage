package com.poly.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import car_beans.DboAreCatalog;
import car_beans.TbDictPhone;
import car_daos.DboAreCatalogDao;
import car_daos.TbDictPhoneDao;

public class PhoneAreaService {
	public static final PhoneAreaService instance = new PhoneAreaService();
	public static PhoneAreaService getInstance() {
		return instance;
	}
	TbDictPhoneDao tbDictPhoneDao  =  new TbDictPhoneDao();
	DboAreCatalogDao dboAreCatalogDao =  new DboAreCatalogDao();
	public Map<String, Integer> getProvAndCity(String phone){
		Map<String, Integer> area= new HashMap<String, Integer>();
		int prov = 0;
		int city = 0;
		List<TbDictPhone> tbDictPhones = tbDictPhoneDao.where(" phone_num = '"+phone+"'" );
		List<DboAreCatalog> provList;
		List<DboAreCatalog> cityList;
		if(tbDictPhones.size()>0){
			provList  = dboAreCatalogDao.where("fatherid = 0");
			cityList  = dboAreCatalogDao.where(" fatherid <> 0");
			TbDictPhone tbDictPhone = tbDictPhones.get(0);
			prov = getProvId(tbDictPhone.getProv(), provList);
			city = getCityId(tbDictPhone.getCity(), cityList);
			
		}
		area.put("prov", prov);
		area.put("city", city);
		return area;
	}
	public String getAreaname(String phone){
		String area = "";
		List<TbDictPhone> tbDictPhones = tbDictPhoneDao.where(" phone_num = '"+phone+"'" );
		if(tbDictPhones.size()>0)
			area = tbDictPhones.get(0).getCity();
		return area;
	}
	int getProvId(String prov,List<DboAreCatalog> dboAreCatalogs){
		int provId = 0;
		for (DboAreCatalog dboAreCatalog : dboAreCatalogs) {
			int provIdX = dboAreCatalog.getCatalogid();
			String byName = dboAreCatalog.getByname();
			if(prov.equals(byName)){
				provId = provIdX;
				break;
			}
		}
		return provId;
		
	}
	int getCityId(String city,List<DboAreCatalog> dboAreCatalogs){
		int cityId = 0;
		for (DboAreCatalog dboAreCatalog : dboAreCatalogs) {
			int cityIdX = dboAreCatalog.getCatalogid();
			String byName = dboAreCatalog.getByname();
			if(city.equals(byName)){
				cityId = cityIdX;
				break;
			}
		}
		return cityId;
		
	}
	public static void main(String args[]){
		System.err.println(PhoneAreaService.getInstance().getProvAndCity("1865249").get("prov"));
		System.err.println(PhoneAreaService.getInstance().getProvAndCity("1865249").get("city"));
	}
}
