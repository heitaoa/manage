package com.poly.dao;

import java.sql.ResultSet;
import java.util.concurrent.ConcurrentHashMap;

import com.poly.dao.subDaos.DboSubDataSubDao;

import car_daos.DBConnect;

public class SeqDao {

	private static ConcurrentHashMap<String, Integer> keyMap = new ConcurrentHashMap<String, Integer>();

	// ȡ����
	synchronized public static int getNextId(String tab) {
		// int next = keyMap.get(tab) + 1;
		// keyMap.put(tab, next);
		// return next;
		int res = -1;
		try {
			res = DboSubDataSubDao.nextVal(tab);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	// ���ö�Ӧ���ID���ֵ
	public static int setMaxIdTRFU(DBConnect dbc, String tbName, String key) throws Exception {
		String sql = "select MAX(" + key + ") as max from " + tbName + " for update";
		dbc.prepareStatement(sql);
		ResultSet rs = dbc.executeQuery();
		if (rs.next()) {
			int max = rs.getInt("max");
			keyMap.put(tbName, max);
		}
		dbc.closePrepareStmt();
		return 1;
	}

	public static void main(String[] args) {
		// setMaxId("tt", 5);
		// System.out.println(getNextId("tt"));

	}

}
