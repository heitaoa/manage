package com.poly.dao.che;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import car_beans.DboPubAd;
import car_daos.DboPubAdDao;

public class AdInfoDao extends DboPubAdDao {

	private static ResultSet rs;
	
	public static List<DboPubAd> getAdInfoByCity(String city) {
		// TODO Auto-generated method stub
		String subsql = "and city = '"+city+"'";
		List<DboPubAd> list = new ArrayList<DboPubAd>();
		list = where(subsql);
		return list;
	}

}
