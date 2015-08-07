package com.poly.service;

import java.util.HashMap;
import java.util.List;

import com.poly.dao.subDaos.SaleFavoredWapDao;

public class SaleFavoredWapService {
	public static final SaleFavoredWapService instance = new SaleFavoredWapService();
	public static SaleFavoredWapService getInstance(){
		return instance;
	}
	SaleFavoredWapDao saleFavoredWapDao = new SaleFavoredWapDao();
	public List<HashMap<String, Object>> getSaleFavoredList(int cityId,int carId,int activeId,int price){
		int beginPrice = 0;
		int endPrice = 0;
		switch (price) {
		case 1:
			beginPrice = 0;
			endPrice = 5;
			break;
		case 2:
			beginPrice = 5;
			endPrice = 10;
			break;
		case 3:
			beginPrice = 10;
			endPrice = 15;
			break;
		case 4:
			beginPrice = 15;
			endPrice = 20;
			break;
		case 5:
			beginPrice = 20;
			endPrice = 	30;
			break;
		case 6:
			beginPrice = 30;
			endPrice = 	40;
			break;
		case 7:
			beginPrice = 40;
			endPrice = 	50;
			break;
		case 8:
			beginPrice = 50;
			endPrice = 	80;
			break;
		case 9:
			beginPrice = 80;
			endPrice = 	Integer.MAX_VALUE;
			break;
		default:
			beginPrice = 0;
			endPrice = 	Integer.MAX_VALUE;
		}
		return saleFavoredWapDao.getSaleFavoredWapList(cityId, carId, activeId, beginPrice, endPrice);
	}
}
