package com.poly.dao.data;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.crypto.Data;

import org.omg.PortableInterceptor.SUCCESSFUL;

import car_beans.TbDataPromoMethod;
import car_daos.DBConnect;
import car_daos.TbDataPromoMethodDao;

public class PromoMethodDao extends TbDataPromoMethodDao {

	public static int updatePromoForPer(Map<String, String> map) {
		
		int result = EXECUTE_FAIL;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(map.get("promo_date"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		TbDataPromoMethod tbDataPromoMethod = new TbDataPromoMethod();
		tbDataPromoMethod.setPro_num(map.get("pro_num"));
		tbDataPromoMethod.setPromo_channel(map.get("promo_channel"));
		tbDataPromoMethod.setPromo_date(date);
		tbDataPromoMethod.setPromo_pageid(map.get("promo_pageid"));
		tbDataPromoMethod.setPromo_remarks(map.get("promo_remarks"));
		tbDataPromoMethod.setPromo_url(map.get("promo_url"));
		
		if (map.get("promo_id").equals("0")) {
			try {
				result = save(tbDataPromoMethod);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			tbDataPromoMethod.setPromo_id(Integer.parseInt(map.get("promo_id")));
			
			result = update(tbDataPromoMethod);
		}
		
		return result;
	}
	
}
