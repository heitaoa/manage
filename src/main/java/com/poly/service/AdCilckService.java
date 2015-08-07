package com.poly.service;

import java.util.List;

import com.poly.dao.che.AdClickDao;

import car_beans.DboAdPopad;

public class AdCilckService {

	public static List<DboAdPopad> getAdClickInfo() {
		// TODO Auto-generated method stub
		return AdClickDao.getAdClickInfo();
	}

}
