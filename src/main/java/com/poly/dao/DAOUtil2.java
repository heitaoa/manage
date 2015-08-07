package com.poly.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import car_daos.DBConnect2;

public class DAOUtil2 {
	public static interface fillResultSet<T> {
		public T fill(ResultSet rs) throws SQLException;
	}
	
	public static int executeUpdate(String sql,Object...args)
		throws SQLException {
		try {
			DBConnect2 dbc =new DBConnect2(sql);
			if(args!=null){
				int len=args.length;
				for(int i=1;i<=len;i++){
					Object arg = args[i-1];
					if (arg != null && arg instanceof Date) {
						long time = ((Date) arg).getTime();
						dbc.setTimestamp(i, new Timestamp(time));
					} else {
						dbc.setObject(i, arg);
					}
				}
			}
			return dbc.executeUpdateReturnInt();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T executeQuery(String sql, fillResultSet<T> fill,
			Object... args) throws SQLException {

		T result = null;
		try {
			DBConnect2 dbc = new DBConnect2(sql);
			if (args != null) {
				int len = args.length;
				for (int i = 1; i <= len; i++) {
					Object arg = args[i-1];
					if (arg != null && arg instanceof Date) {
						long time = ((Date) arg).getTime();
						dbc.setTimestamp(i, new Timestamp(time));
					} else {
						dbc.setObject(i, arg);
					}
				}

			}
			ResultSet rs = dbc.executeQuery();
			if (fill != null) {  
				result = fill.fill(rs);
			} else {
				result = (T) fillResultSetToList(rs);
			}
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException(e);
		}
		return result;
	}
	
	public static List<Map<String, Object>> fillResultSetToList(ResultSet rs)
			throws SQLException {
		if (rs == null) {
			return null;
		}
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		String[] columns = new String[columnCount];
		for (int i = 0; i < columnCount; i++) {
			columns[i] = metaData.getColumnLabel(i + 1);
		}

		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = null;
		while (rs.next()) {
			map = new HashMap<String, Object>();
			for (String column : columns) {
				map.put(column, rs.getObject(column));
			}
			result.add(map);
		}

		return result;
	}
}
