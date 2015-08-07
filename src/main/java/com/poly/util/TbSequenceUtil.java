package com.poly.util;

import java.sql.ResultSet;

import car_daos.DBConnect;

/**
 * 根据表名，获取表的下个主键
 * @author niuhaidong
 *
 * 2015年5月7日
 */
public class TbSequenceUtil {
	/**
	 * 根据表名，获取表的下个主键
	 * @param tName
	 * @return
	 * @throws Exception
	 */
	public static int nextVal(String tName) throws Exception {
		DBConnect dbc = null;
		try {
			String sql = "select _nextval(?) as val";
			dbc = new DBConnect(sql);
			dbc.setString(1, tName);
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				return rs.getInt("val");
			} else {
				throw new Exception("no sequence for " + tName);
			}
		} finally {
			if (dbc != null) {
				dbc.close();
			}
		}
	}
}
