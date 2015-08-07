package com.poly.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import car_daos.DBConnect;
import car_daos.TbSequenceDao;

import com.poly.dao.SeqDao;

public class SeqService extends BaseService {

	private static Map<String, String> tabMap;

	static {
		tabMap = new HashMap<String, String>();
		tabMap.put("dbo_car_catalognew", "catalogid");
		tabMap.put("dbo_dea_byschedulesenior", "id");
		tabMap.put("dbo_dea_byyuyue", "id");
		tabMap.put("dbo_dea_dealerinfo", "infoid");
		tabMap.put("dbo_dea_dealers", "eid");
		tabMap.put("dbo_dea_employee", "empid");
		tabMap.put("dbo_dea_hqnews", "id");
		tabMap.put("dbo_dea_hqprice", "id");
		tabMap.put("dbo_dea_message", "id");
		tabMap.put("dbo_dea_news", "newsid");
		tabMap.put("dbo_dea_opertions", "id");
		tabMap.put("dbo_dea_ordercar", "orderid");
		tabMap.put("dbo_dea_phonemanage", "id");
		tabMap.put("dbo_dea_prizeinfo", "id");
		tabMap.put("dbo_dea_sccommodity", "id");
		tabMap.put("dbo_dea_scoressort", "id");
		tabMap.put("dbo_dea_scsignature", "id");
		tabMap.put("dbo_dea_smsnotice", "id");
		tabMap.put("dbo_dea_storedisplay", "picid");
		tabMap.put("dbo_dea_wxaccount", "id");
		tabMap.put("dbo_dea_wxactivities", "id");
		tabMap.put("dbo_dea_wxactjoin", "id");
		tabMap.put("dbo_dea_wxershouche", "id");
		tabMap.put("dbo_dea_wxintmsg", "id");
		tabMap.put("dbo_dea_wxmsg", "id");
		tabMap.put("dbo_dea_wxservice", "id");
		tabMap.put("dbo_ent_product", "id");
		tabMap.put("tb_car_info", "id");
		tabMap.put("dbo_new_news", "id");
		tabMap.put("dbo_new_content", "id");
		tabMap.put("dbo_car_baiketitle", "id");
		tabMap.put("dbo_car_newproperty", "id");
		tabMap.put("dbo_car_info", "id");
		tabMap.put("dbo_sub_content", "id");
		tabMap.put("dbo_car_autohomeprop", "id");
		//tabMap.put("dbo_new_publishtime", "id");
		
	}

//	public static int initMaxId() {
//		BaseService baseService = new BaseService();
//		DBConnect dbc = null;
//		try {
//			//
//			dbc = baseService.createTransaction();
//			//
//			for (Entry<String, String> entry : tabMap.entrySet()) {
//				SeqDao.setMaxIdTRFU(dbc, entry.getKey(), entry.getValue());
//			}
//			baseService.commitTransaction(dbc);
//			return 1;
//		} catch (Exception e) {
//			try {
//				e.printStackTrace();
//				baseService.rollbackTransaction(dbc);
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//			return -1;
//		}
//	}

	//
	public static int initMaxId() {
		DBConnect dbc = null;
		try {
			dbc = BaseService.createTransaction();
			//
			String subsql = "";
			String sql = "";
			for (Entry<String, String> entry : tabMap.entrySet()) {
				// delete
				subsql = "name = '" + entry.getKey() + "'";
				TbSequenceDao.delete(dbc, subsql);
				// insert
				// insert into tb_sequence(`name`,`current_value`,`_increment`)
				// select "dbo_new_news3", MAX(id) , 1 from dbo_new_news;

				sql = "insert into tb_sequence(`name`,`current_value`,`_increment`) select '" + entry.getKey()
						+ "', MAX(" + entry.getValue() + ")+1 , 1 from " + entry.getKey();
				System.out.println("-->" + sql);
				TbSequenceDao.execute(dbc, sql);
			}
			BaseService.commitTransaction(dbc);
			return 1;
		} catch (Exception e) {
			try {
				e.printStackTrace();
				BaseService.rollbackTransaction(dbc);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return -1;
		}
	}

}
