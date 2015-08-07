package com.poly.dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import car_daos.DBConnect;

public class DboSendCshDao {
	
	public static Map<String,String> getCshMap(){
		Map<String,String> map = new HashMap<String,String>();
		DBConnect dbc = null;
		String sql = "select * from dbo_send_csh";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()){
				map.put(rs.getString("id"),rs.getString("count"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(dbc!=null){
				try {
					dbc.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return map;
	}

	public static void saveDboSendCsh(String id,String count) {
		// TODO Auto-generated method stub
		String sql = "insert into dbo_send_csh (id,count) values (?,?)";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1,id);
			dbc.setString(2,count);
			dbc.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(dbc!=null){
				try {
					dbc.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void updateDboSendCsh(String key, String count) {
		// TODO Auto-generated method stub
		String sql = "update dbo_send_csh set count=? where id = ?";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1,count);
			dbc.setString(2,key);
			dbc.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(dbc!=null){
				try {
					dbc.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
