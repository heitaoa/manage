package com.poly.service;

import car_daos.DBConnect;


public class BaseService {

	// DBConnect���캯��,�����ʶ,�������������캯��
	private static final int isTX = 1;

	/**
	 * ��������
	 * 
	 * @return DBConnect
	 * @throws Exception
	 */
	public static DBConnect createTransaction() throws Exception {
		DBConnect dbc = new DBConnect(isTX);
		dbc.setAutoCommit(false);
		return dbc;
	}

	/**
	 * commit����
	 * 
	 * @return
	 * @throws Exception
	 */
	public static void commitTransaction(DBConnect dbc) throws Exception {
		if (dbc != null) {
			dbc.commit();
			dbc.close();
		}
	}

	/**
	 * rollback����
	 * 
	 * @return DBConnect
	 * @throws Exception
	 */
	public static void rollbackTransaction(DBConnect dbc) throws Exception {
		if (dbc != null) {
			dbc.rollback();
			dbc.close();
		}
	}

	/**
	 * ��һ������
	 * 
	 * @return
	 */
	public DBConnect createNewDBConnect(int ds) {
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(ds);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dbc;
	}

//	public long getNextSeqId(String seqName, int ds) {
//		BaseDao baseDao = new BaseDao();
//		return baseDao.nextLongSeq(seqName, ds);
//	}
//
//	public String queryCurrentDate(int ds) {
//		BaseDao baseDao = new BaseDao();
//		return baseDao.queryCurrentDate(ds);
//	}
}
