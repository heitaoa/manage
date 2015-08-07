package com.poly.service;

import java.util.List;

import com.poly.dao.che.AdInfoDao;

import car_beans.DboPubAd;

public class AdInfoService {


	public static List<DboPubAd> getAdInfoByCity(String city) {
		// TODO Auto-generated method stub
		return AdInfoDao.getAdInfoByCity(city);
	}

}
