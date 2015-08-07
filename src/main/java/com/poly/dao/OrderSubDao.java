package com.poly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import car_daos.DBConnect;

public class OrderSubDao {

	/**
	 * 发送该分站每日推送量给分站经理
	 * @param bid
	 * @param aid
	 * @param date
	 * @return
	 * @throws SQLException 
	 */
	public List<Map<String, Object>> getPorderByDay(String bid, String aid,
			String date) throws SQLException {
		String sql = "";
		if("1".equals(aid) || "9".equals(aid)){
			sql = " select t2.catalogname,t1.cot from  (select brand , count(1) as cot from tb_data_baoming 	where isDelete = 0 and DATE_FORMAT(baoming_date,'%Y-%m-%d') = '"+date+"' and prov = "+aid+" group by brand order by count(1) desc) t1,dbo_car_catalognew t2 where t1.brand = t2.catalogid";
		}else{
			sql = "select t2.catalogname,t1.cot from  (select brand , count(1) as cot from tb_data_baoming 	where isDelete = 0 and DATE_FORMAT(baoming_date,'%Y-%m-%d') = '"+date+"' and city = "+aid+" group by brand order by count(1) desc) t1,dbo_car_catalognew t2 where t1.brand = t2.catalogid";
		}
		
		//System.out.println(sql);
		
		return DAOUtil.executeQuery(sql, null);
	}

	public List<Map<String, Object>> getPorderByWeek(String bid, String aid,
			String startdate, String enddate)throws SQLException  {
		String sql = "";
		if("1".equals(aid) || "9".equals(aid)){
			sql = "select t2.catalogname,t1.cot from  (select brand , count(1) as cot from tb_data_baoming 	where isDelete = 0 and DATE_FORMAT(baoming_date,'%Y-%m-%d') >= '"+startdate+"' and DATE_FORMAT(baoming_date,'%Y-%m-%d') < '"+enddate+"' and prov = "+aid+" group by brand order by count(1) desc) t1,dbo_car_catalognew t2 where t1.brand = t2.catalogid";
		}else{
			sql = "select t2.catalogname,t1.cot from  (select brand , count(1) as cot from tb_data_baoming 	where isDelete = 0 and DATE_FORMAT(baoming_date,'%Y-%m-%d') >= '"+startdate+"' and DATE_FORMAT(baoming_date,'%Y-%m-%d') < '"+enddate+"' and city = "+aid+" group by brand order by count(1) desc) t1,dbo_car_catalognew t2 where t1.brand = t2.catalogid";
		}
		
		//System.out.println(sql);
		
		return DAOUtil.executeQuery(sql, null);
	}

	public int getAllPorderByDay(String date, String aid) {
		int result = 0;
		String sql = "";
		if("1".equals(aid) || "9".equals(aid)){
			sql = "select count(1) as cot from tb_data_baoming 	where isDelete = 0 and DATE_FORMAT(baoming_date,'%Y-%m-%d') = ? and prov = ? ";
		}else{
			sql = "select count(1) as cot from tb_data_baoming 	where isDelete = 0 and DATE_FORMAT(baoming_date,'%Y-%m-%d') = ? and city = ? ";
		}
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, date);
			dbc.setInt(2, Integer.parseInt(aid));
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				result = rs.getInt("cot");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int getAllPorderByWeek(String startdate, String enddate, String aid) {
		int result = 0;
		String sql = "";
		if("1".equals(aid) || "9".equals(aid)){
			sql = "select count(1) as cot from tb_data_baoming 	where isDelete = 0 and DATE_FORMAT(baoming_date,'%Y-%m-%d') >= ? and DATE_FORMAT(baoming_date,'%Y-%m-%d') < ? and prov = ? ";
		}else{
			sql = "select count(1) as cot from tb_data_baoming 	where isDelete = 0 and DATE_FORMAT(baoming_date,'%Y-%m-%d') >= ? and DATE_FORMAT(baoming_date,'%Y-%m-%d') < ? and city = ? ";
		}
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, startdate);
			dbc.setString(2, enddate);
			dbc.setInt(3, Integer.parseInt(aid));
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				result = rs.getInt("cot");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int getAllllPorderByDay(String date) {
		int result = 0;
		String sql = "";
		
		sql = "select count(1) as cot from tb_data_baoming 	where isDelete = 0 and DATE_FORMAT(baoming_date,'%Y-%m-%d') = ?  ";
		
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, date);
			
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				result = rs.getInt("cot");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int getAllllPorderByWeek(String startdate, String enddate) {
		int result = 0;
		String sql = "";
		
		sql = "select count(1) as cot from tb_data_baoming 	where isDelete = 0 and DATE_FORMAT(baoming_date,'%Y-%m-%d') >= ? and DATE_FORMAT(baoming_date,'%Y-%m-%d') < ? ";
		
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, startdate);
			dbc.setString(2, enddate);
		
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				result = rs.getInt("cot");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
}
