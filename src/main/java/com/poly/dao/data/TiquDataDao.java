package com.poly.dao.data;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import car_daos.DBConnect;
import car_daos.TbDataTiqudataDao;

public class TiquDataDao extends TbDataTiqudataDao {

	public List<Map<String, String>> getCarList(String fatherid) {
		List<Map<String, String>> resultList = null;
		
		String sql = "SELECT * FROM car_315.dbo_car_catalognew WHERE fatherid = "+ fatherid +" AND isdelete = 0 ORDER BY lname";
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			resultList = new ArrayList<Map<String,String>>();
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("catalogid", rs.getInt("catalogid")+"");
				map.put("catalogname", rs.getString("catalogname"));
				map.put("lname", rs.getString("lname"));
				resultList.add(map);
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
		
		return resultList;
	}

	public Map<String, String> getUserinfo(String userid) {
		Map<String, String> resultMap = null;
		
		String sql = "SELECT t1.USER_NAME, t1.DEPT_CODE, t2.DEP_NAME, t1.ORG_CODE, t3.ORG_NAME "
					+ "FROM finance.tb_fin_user t1, finance.tb_fin_dep t2, finance.tb_fin_org t3 "
					+ "WHERE t1.DEPT_CODE = t2.DEP_ID AND t1.ORG_CODE = t3.ORG_ID AND t1.USER_CODE = '"+ userid +"'";
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			resultMap = new HashMap<String, String>();
			if (rs.next()) {
				resultMap.put("user_name", rs.getString("USER_NAME"));
				resultMap.put("dept_code", rs.getInt("DEPT_CODE") + "");
				resultMap.put("dept_name", rs.getString("DEP_NAME"));
				resultMap.put("org_code", rs.getInt("ORG_CODE") + "");
				resultMap.put("org_name", rs.getString("ORG_NAME"));
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
		
		return resultMap;
	}

	public List<Map<String, String>> getProvList(int fatherid) {
		List<Map<String, String>> resultList = null;
		String sql = "SELECT catalogid,catalogname,lname FROM car_315.dbo_are_catalog WHERE fatherid = "+ fatherid +" ORDER BY lname";
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			resultList = new ArrayList<Map<String,String>>();
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("catalogid", rs.getInt("catalogid")+"");
				map.put("catalogname", rs.getString("catalogname"));
				map.put("lname", rs.getString("lname"));
				resultList.add(map);
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
		
		return resultList;
	}

	public List<Map<String, String>> getProList(Map<String, String> whereMap) {
		List<Map<String, String>> resultList = null;
		
		String whereString = "";
		if (!whereMap.get("dept_code").equals("") && whereMap.get("dept_code")!=null) {
			whereString = whereString + " AND t1.ini_dept=" + whereMap.get("dept_code");
		}
		if (!whereMap.get("apply_startdate").equals("") && whereMap.get("apply_startdate")!=null) {
			whereString = whereString + " AND TO_DAYS(t1.ini_date)>=TO_DAYS('"+ whereMap.get("apply_startdate") +"')";
		}
		if (!whereMap.get("apply_enddate").equals("") && whereMap.get("apply_enddate")!=null) {
			whereString = whereString + " AND TO_DAYS(t1.ini_date)<=TO_DAYS('"+ whereMap.get("apply_enddate") +"')";
		}
		if (!whereMap.get("examine_state").equals("") && whereMap.get("examine_state")!=null) {
			whereString = whereString + " AND t1.examine_state=" + whereMap.get("examine_state");
		}
		if (whereMap.get("tiqu_state").equals("1")) {
			whereString = whereString + " AND t1.tiqu_state=3";
		}else if (whereMap.get("tiqu_state").equals("0")) {
			whereString = whereString + " AND t1.tiqu_state<>3";
		}
		if (!whereMap.get("user_id").equals("") && whereMap.get("user_id")!=null) {
			if (whereMap.get("isDir").equals("1")) {
				if (whereMap.get("org_code").equals("1")) {
					whereString = whereString + " AND t1.ini_dept=" + whereMap.get("dept_code") + " AND t1.ini_org=" + whereMap.get("org_code");
				}else {
					whereString = whereString + " AND t1.ini_org=" + whereMap.get("org_code");
				}
			}else {
				whereString = whereString + " AND t1.ini_man = '"+ whereMap.get("user_id") +"'";
			}
		}
		
		int pageNum = Integer.valueOf(whereMap.get("pageNum"));
		int page = Integer.valueOf(whereMap.get("page")) - 1;
		
		String sql = "SELECT t1.*, t2.USER_NAME ini_man_name, t3.ORG_NAME org_name, t4.DEP_NAME dept_name, "
						+ "t5.catalogname brand_name, t6.catalogname car_name, t7.catalogname prov_name, t8.catalogname city_name "
					+ "FROM car_315.tb_data_tiqudata t1 "
					+ "LEFT JOIN finance.tb_fin_user t2 ON t1.ini_man = t2.USER_CODE "
					+ "LEFT JOIN finance.tb_fin_org t3 ON t1.ini_org = t3.ORG_ID "
					+ "LEFT JOIN finance.tb_fin_dep t4 ON t1.ini_dept = t4.DEP_ID "
					+ "LEFT JOIN car_315.dbo_car_catalognew t5 ON t1.brand = t5.catalogid "
					+ "LEFT JOIN car_315.dbo_car_catalognew t6 ON t1.car = t6.catalogid "
					+ "LEFT JOIN car_315.dbo_are_catalog t7 ON t1.prov = t7.catalogid "
					+ "LEFT JOIN car_315.dbo_are_catalog t8 ON t1.city = t8.catalogid "
					+ "WHERE t1.tiqu_state<>0 "
					+ whereString
					+ " LIMIT "+ page*pageNum +","+ pageNum +" ";
		System.out.println(sql);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			resultList = new ArrayList<Map<String,String>>();
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("tiqu_num", rs.getString("tiqu_num"));
				map.put("ini_man", rs.getString("ini_man"));
				map.put("ini_man_name", rs.getString("ini_man_name"));
				map.put("ini_org", rs.getInt("ini_org")+"");
				map.put("org_name", rs.getString("org_name"));
				map.put("ini_dept", rs.getInt("ini_dept")+"");
				map.put("dept_name", rs.getString("dept_name"));
				map.put("ini_date", rs.getDate("ini_date").toString());
				map.put("contact_num", rs.getString("contact_num"));
				map.put("contact_money", rs.getString("contact_money"));
				map.put("contact_start_date", rs.getDate("contact_start_date").toString());
				map.put("contact_end_date", rs.getDate("contact_end_date").toString());
				map.put("cust_name", rs.getString("cust_name"));
				map.put("brand", rs.getInt("brand")+"");
				map.put("brand_name", rs.getString("brand_name"));
				map.put("car", rs.getInt("car")+"");
				map.put("car_name", rs.getString("car_name"));
				map.put("prov", rs.getInt("prov")+"");
				map.put("prov_name", rs.getString("prov_name"));
				map.put("city", rs.getInt("city")+"");
				map.put("city_name", rs.getString("city_name"));
				map.put("data_count", rs.getInt("data_count")+"");
				map.put("data_start_date", rs.getDate("data_start_date").toString());
				map.put("data_end_date", rs.getDate("data_end_date").toString());
				map.put("is_agree_deduct", rs.getInt("is_agree_deduct")+"");
				map.put("apply_cause", rs.getString("apply_cause"));
				map.put("is_deduct", rs.getInt("is_deduct")+"");
				map.put("examine_state", rs.getInt("examine_state")+"");
				map.put("tiqu_state", rs.getInt("tiqu_state")+"");
				
				resultList.add(map);
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
		
		return resultList;
	}

	public Map<String, String> getDeptMap() {
		Map<String, String> deptMap = null;
		
		String sql = "SELECT * FROM finance.tb_fin_dep ORDER BY DEP_ID";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			deptMap = new HashMap<String,String>();
			while(rs.next()) {
				String deptId = rs.getString("DEP_ID");
				String deptName = rs.getString("DEP_NAME");
				deptMap.put(deptId, deptName);
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
	
		return deptMap;
	}

	public List<Map<String, String>> getProListForDirExamine(Map<String, String> whereMap) {
		List<Map<String, String>> resultList = null;
		
		String whereString = "";
		if (whereMap.get("org_code").equals("1")) {
			whereString = " AND t1.ini_dept=" + whereMap.get("dept_code") + " AND t1.ini_org=" + whereMap.get("org_code");
		}else {
			whereString = " AND t1.ini_org=" + whereMap.get("org_code");
		}
		String sql = "SELECT t1.*, t2.USER_NAME ini_man_name, t3.ORG_NAME org_name, t4.DEP_NAME dept_name, "
						+ "t5.catalogname brand_name, t6.catalogname car_name, t7.catalogname prov_name, t8.catalogname city_name "
					+ "FROM car_315.tb_data_tiqudata t1 "
					+ "LEFT JOIN finance.tb_fin_user t2 ON t1.ini_man = t2.USER_CODE "
					+ "LEFT JOIN finance.tb_fin_org t3 ON t1.ini_org = t3.ORG_ID "
					+ "LEFT JOIN finance.tb_fin_dep t4 ON t1.ini_dept = t4.DEP_ID "
					+ "LEFT JOIN car_315.dbo_car_catalognew t5 ON t1.brand = t5.catalogid "
					+ "LEFT JOIN car_315.dbo_car_catalognew t6 ON t1.car = t6.catalogid "
					+ "LEFT JOIN car_315.dbo_are_catalog t7 ON t1.prov = t7.catalogid "
					+ "LEFT JOIN car_315.dbo_are_catalog t8 ON t1.city = t8.catalogid "
//					+ "INNER JOIN finance.tb_fin_user t9 ON t9.USER_CODE = '"+ whereMap.get("user_id") +"' AND t1.ini_dept = t9.DEPT_CODE "
					+ "WHERE t1.examine_state = 0 " + whereString;
		System.out.println(sql);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			resultList = new ArrayList<Map<String,String>>();
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("tiqu_num", rs.getString("tiqu_num"));
				map.put("ini_man", rs.getString("ini_man"));
				map.put("ini_man_name", rs.getString("ini_man_name"));
				map.put("ini_org", rs.getInt("ini_org")+"");
				map.put("org_name", rs.getString("org_name"));
				map.put("ini_dept", rs.getInt("ini_dept")+"");
				map.put("dept_name", rs.getString("dept_name"));
				map.put("ini_date", rs.getDate("ini_date").toString());
				map.put("contact_num", rs.getString("contact_num"));
				map.put("contact_money", rs.getString("contact_money"));
				map.put("contact_start_date", rs.getDate("contact_start_date").toString());
				map.put("contact_end_date", rs.getDate("contact_end_date").toString());
				map.put("cust_name", rs.getString("cust_name"));
				map.put("brand", rs.getInt("brand")+"");
				map.put("brand_name", rs.getString("brand_name"));
				map.put("car", rs.getInt("car")+"");
				map.put("car_name", rs.getString("car_name"));
				map.put("prov", rs.getInt("prov")+"");
				map.put("prov_name", rs.getString("prov_name"));
				map.put("city", rs.getInt("city")+"");
				map.put("city_name", rs.getString("city_name"));
				map.put("data_count", rs.getInt("data_count")+"");
				map.put("data_start_date", rs.getDate("data_start_date").toString());
				map.put("data_end_date", rs.getDate("data_end_date").toString());
				map.put("is_agree_deduct", rs.getInt("is_agree_deduct")+"");
				map.put("apply_cause", rs.getString("apply_cause"));
				map.put("is_deduct", rs.getInt("is_deduct")+"");
				map.put("examine_state", rs.getInt("examine_state")+"");
				map.put("tiqu_state", rs.getInt("tiqu_state")+"");
				
				resultList.add(map);
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
		
		return resultList;
	}

	public List<Map<String, String>> getExamineResult(Map<String, String> whereMap) {
		List<Map<String, String>> resultList = null;
		
		String sql = "SELECT t1.*, t2.USER_NAME ini_man_name, t3.ORG_NAME org_name, t4.DEP_NAME dept_name, "
						+ "t5.catalogname brand_name, t6.catalogname car_name, t7.catalogname prov_name, t8.catalogname city_name "
					+ "FROM car_315.tb_data_tiqudata t1 "
					+ "LEFT JOIN finance.tb_fin_user t2 ON t1.ini_man = t2.USER_CODE "
					+ "LEFT JOIN finance.tb_fin_org t3 ON t1.ini_org = t3.ORG_ID "
					+ "LEFT JOIN finance.tb_fin_dep t4 ON t1.ini_dept = t4.DEP_ID "
					+ "LEFT JOIN car_315.dbo_car_catalognew t5 ON t1.brand = t5.catalogid "
					+ "LEFT JOIN car_315.dbo_car_catalognew t6 ON t1.car = t6.catalogid "
					+ "LEFT JOIN car_315.dbo_are_catalog t7 ON t1.prov = t7.catalogid "
					+ "LEFT JOIN car_315.dbo_are_catalog t8 ON t1.city = t8.catalogid "
					+ "WHERE t1.ini_man = '"+ whereMap.get("user_id") +"' AND t1.tiqu_state=0 ";
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			resultList = new ArrayList<Map<String,String>>();
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("tiqu_num", rs.getString("tiqu_num"));
				map.put("ini_man", rs.getString("ini_man"));
				map.put("ini_man_name", rs.getString("ini_man_name"));
				map.put("ini_org", rs.getInt("ini_org")+"");
				map.put("org_name", rs.getString("org_name"));
				map.put("ini_dept", rs.getInt("ini_dept")+"");
				map.put("dept_name", rs.getString("dept_name"));
				map.put("ini_date", rs.getDate("ini_date").toString());
				map.put("contact_num", rs.getString("contact_num"));
				map.put("contact_money", rs.getString("contact_money"));
				map.put("contact_start_date", rs.getDate("contact_start_date").toString());
				map.put("contact_end_date", rs.getDate("contact_end_date").toString());
				map.put("cust_name", rs.getString("cust_name"));
				map.put("brand", rs.getInt("brand")+"");
				map.put("brand_name", rs.getString("brand_name"));
				map.put("car", rs.getInt("car")+"");
				map.put("car_name", rs.getString("car_name"));
				map.put("prov", rs.getInt("prov")+"");
				map.put("prov_name", rs.getString("prov_name"));
				map.put("city", rs.getInt("city")+"");
				map.put("city_name", rs.getString("city_name"));
				map.put("data_count", rs.getInt("data_count")+"");
				map.put("data_start_date", rs.getDate("data_start_date").toString());
				map.put("data_end_date", rs.getDate("data_end_date").toString());
				map.put("deny_cause", rs.getString("deny_cause"));
				map.put("is_agree_deduct", rs.getInt("is_agree_deduct")+"");
				map.put("apply_cause", rs.getString("apply_cause"));
				map.put("is_deduct", rs.getInt("is_deduct")+"");
				map.put("examine_state", rs.getInt("examine_state")+"");
				map.put("tiqu_state", rs.getInt("tiqu_state")+"");
				
				resultList.add(map);
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
		
		return resultList;
	}

	public List<Map<String, String>> getProListForHighExamine() {
		List<Map<String, String>> resultList = null;
		
		String sql = "SELECT t1.*, t2.USER_NAME ini_man_name, t3.ORG_NAME org_name, t4.DEP_NAME dept_name, "
						+ "t5.catalogname brand_name, t6.catalogname car_name, t7.catalogname prov_name, t8.catalogname city_name "
					+ "FROM car_315.tb_data_tiqudata t1 "
					+ "LEFT JOIN finance.tb_fin_user t2 ON t1.ini_man = t2.USER_CODE "
					+ "LEFT JOIN finance.tb_fin_org t3 ON t1.ini_org = t3.ORG_ID "
					+ "LEFT JOIN finance.tb_fin_dep t4 ON t1.ini_dept = t4.DEP_ID "
					+ "LEFT JOIN car_315.dbo_car_catalognew t5 ON t1.brand = t5.catalogid "
					+ "LEFT JOIN car_315.dbo_car_catalognew t6 ON t1.car = t6.catalogid "
					+ "LEFT JOIN car_315.dbo_are_catalog t7 ON t1.prov = t7.catalogid "
					+ "LEFT JOIN car_315.dbo_are_catalog t8 ON t1.city = t8.catalogid "
					+ "WHERE t1.examine_state = 1 ";
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			resultList = new ArrayList<Map<String,String>>();
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("tiqu_num", rs.getString("tiqu_num"));
				map.put("ini_man", rs.getString("ini_man"));
				map.put("ini_man_name", rs.getString("ini_man_name"));
				map.put("ini_org", rs.getInt("ini_org")+"");
				map.put("org_name", rs.getString("org_name"));
				map.put("ini_dept", rs.getInt("ini_dept")+"");
				map.put("dept_name", rs.getString("dept_name"));
				map.put("ini_date", rs.getDate("ini_date").toString());
				map.put("contact_num", rs.getString("contact_num"));
				map.put("contact_money", rs.getString("contact_money"));
				map.put("contact_start_date", rs.getDate("contact_start_date").toString());
				map.put("contact_end_date", rs.getDate("contact_end_date").toString());
				map.put("cust_name", rs.getString("cust_name"));
				map.put("brand", rs.getInt("brand")+"");
				map.put("brand_name", rs.getString("brand_name"));
				map.put("car", rs.getInt("car")+"");
				map.put("car_name", rs.getString("car_name"));
				map.put("prov", rs.getInt("prov")+"");
				map.put("prov_name", rs.getString("prov_name"));
				map.put("city", rs.getInt("city")+"");
				map.put("city_name", rs.getString("city_name"));
				map.put("data_count", rs.getInt("data_count")+"");
				map.put("data_start_date", rs.getDate("data_start_date").toString());
				map.put("data_end_date", rs.getDate("data_end_date").toString());
				map.put("is_agree_deduct", rs.getInt("is_agree_deduct")+"");
				map.put("apply_cause", rs.getString("apply_cause"));
				map.put("is_deduct", rs.getInt("is_deduct")+"");
				map.put("examine_state", rs.getInt("examine_state")+"");
				map.put("tiqu_state", rs.getInt("tiqu_state")+"");
				
				resultList.add(map);
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
		
		return resultList;
	}

	public List<Map<String, String>> getProListForDeal() {
		List<Map<String, String>> resultList = null;
		
		String sql = "SELECT t1.*, t2.USER_NAME ini_man_name, t3.ORG_NAME org_name, t4.DEP_NAME dept_name, "
						+ "t5.catalogname brand_name, t6.catalogname car_name, t7.catalogname prov_name, t8.catalogname city_name "
					+ "FROM car_315.tb_data_tiqudata t1 "
					+ "LEFT JOIN finance.tb_fin_user t2 ON t1.ini_man = t2.USER_CODE "
					+ "LEFT JOIN finance.tb_fin_org t3 ON t1.ini_org = t3.ORG_ID "
					+ "LEFT JOIN finance.tb_fin_dep t4 ON t1.ini_dept = t4.DEP_ID "
					+ "LEFT JOIN car_315.dbo_car_catalognew t5 ON t1.brand = t5.catalogid "
					+ "LEFT JOIN car_315.dbo_car_catalognew t6 ON t1.car = t6.catalogid "
					+ "LEFT JOIN car_315.dbo_are_catalog t7 ON t1.prov = t7.catalogid "
					+ "LEFT JOIN car_315.dbo_are_catalog t8 ON t1.city = t8.catalogid "
					+ "WHERE t1.tiqu_state = 1 ";
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			resultList = new ArrayList<Map<String,String>>();
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("tiqu_num", rs.getString("tiqu_num"));
				map.put("ini_man", rs.getString("ini_man"));
				map.put("ini_man_name", rs.getString("ini_man_name"));
				map.put("ini_org", rs.getInt("ini_org")+"");
				map.put("org_name", rs.getString("org_name"));
				map.put("ini_dept", rs.getInt("ini_dept")+"");
				map.put("dept_name", rs.getString("dept_name"));
				map.put("ini_date", rs.getDate("ini_date").toString());
				map.put("contact_num", rs.getString("contact_num"));
				map.put("contact_money", rs.getString("contact_money"));
				map.put("contact_start_date", rs.getDate("contact_start_date").toString());
				map.put("contact_end_date", rs.getDate("contact_end_date").toString());
				map.put("cust_name", rs.getString("cust_name"));
				map.put("brand", rs.getInt("brand")+"");
				map.put("brand_name", rs.getString("brand_name"));
				map.put("car", rs.getInt("car")+"");
				map.put("car_name", rs.getString("car_name"));
				map.put("prov", rs.getInt("prov")+"");
				map.put("prov_name", rs.getString("prov_name"));
				map.put("city", rs.getInt("city")+"");
				map.put("city_name", rs.getString("city_name"));
				map.put("data_count", rs.getInt("data_count")+"");
				map.put("data_start_date", rs.getDate("data_start_date").toString());
				map.put("data_end_date", rs.getDate("data_end_date").toString());
				map.put("is_agree_deduct", rs.getInt("is_agree_deduct")+"");
				map.put("apply_cause", rs.getString("apply_cause"));
				map.put("is_deduct", rs.getInt("is_deduct")+"");
				map.put("examine_state", rs.getInt("examine_state")+"");
				map.put("tiqu_state", rs.getInt("tiqu_state")+"");
				
				resultList.add(map);
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
		
		return resultList;
	}

	public List<Map<String, String>> getBaomingListForDeal(String tiqu_num, int needNum) {
		List<Map<String, String>> resultList = null;
		
//		String sql = "SELECT t1.`name`,t1.phone,t1.baoming_date,t1.prov,t3.catalogname prov_name,t1.city,t4.catalogname city_name,t1.car_info,t1.brand,t1.serial,t1.return_visit_state "
//					+ "FROM car_315.tb_data_baoming t1, car_315.tb_data_tiqudata t2, car_315.dbo_are_catalog t3, car_315.dbo_are_catalog t4 "
//					+ "WHERE t2.tiqu_num='"+ tiqu_num +"' "
//							+ "AND TO_DAYS(t1.baoming_date)<=TO_DAYS(t2.data_end_date) AND TO_DAYS(t1.baoming_date)>=TO_DAYS(t2.data_start_date) AND "
//							+ "t2.prov=(CASE WHEN t2.prov<>-1 THEN t1.prov ELSE -1 END) AND t2.city=(CASE WHEN t2.city<>-1 THEN t1.city ELSE -1 END) AND "
//							+ "t2.brand = t1.brand AND t2.car = (CASE WHEN t2.car<>-1 THEN t1.serial ELSE -1 END) AND "
//							+ "t1.prov = t3.catalogid AND t1.city = t4.catalogid "
//					+ "GROUP BY t1.phone "
//					+ "ORDER BY baoming_date DESC "
//					+ "LIMIT 0," + needNum;
		String sql = "SELECT t1.id baoming_id, t1.`name`,t1.phone,t1.baoming_date,t1.prov,t3.catalogname prov_name,t1.city,IFNULL(t4.catalogname,'') city_name,"
							+ "t1.car_info,t1.brand,t1.serial,t1.return_visit_state, t5.catalogname brand_name, t6.catalogname car_name "
					+ "FROM car_315.tb_data_baoming t1 "
							+ "INNER JOIN car_315.tb_data_tiqudata t2 ON t2.tiqu_num='"+ tiqu_num +"' "
									+ "AND TO_DAYS(t1.baoming_date)<=TO_DAYS(t2.data_end_date) AND TO_DAYS(t1.baoming_date)>=TO_DAYS(t2.data_start_date) "
									+ "AND t2.prov=(CASE WHEN t2.prov<>-1 THEN t1.prov ELSE -1 END) AND t2.city=(CASE WHEN t2.city<>-1 THEN t1.city ELSE -1 END) "
									+ "AND t2.brand = t1.brand AND t2.car = (CASE WHEN t2.car<>-1 THEN t1.serial ELSE -1 END) "
							+ "LEFT JOIN car_315.dbo_are_catalog t3 ON t1.prov = t3.catalogid "
							+ "LEFT JOIN car_315.dbo_are_catalog t4 ON t1.city = t4.catalogid "
							+ "LEFT JOIN car_315.dbo_car_catalognew t5 ON t1.brand = t5.catalogid "
							+ "LEFT JOIN car_315.dbo_car_catalognew t6 ON t1.serial = t6.catalogid "
					+ "GROUP BY t1.phone "
					+ "ORDER BY baoming_date DESC "
					+ "LIMIT 0," + needNum;
		System.out.println(sql);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			resultList = new ArrayList<Map<String,String>>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("baoming_id", rs.getInt("baoming_id")+"");
				map.put("uname", rs.getString("name"));
				map.put("phone", rs.getString("phone"));
				map.put("baoming_date", sdf.format(rs.getDate("baoming_date")));
				map.put("prov_name", rs.getString("prov_name"));
				map.put("city_name", rs.getString("city_name"));
				map.put("car_info", rs.getString("car_info"));
				map.put("brand_name", rs.getString("brand_name"));
				map.put("car_name", rs.getString("car_name"));
				if (rs.getInt("return_visit_state")==0) {
					map.put("return_visit_state", "否");
				}else {
					map.put("return_visit_state", "是");
				}
				
				resultList.add(map);
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
		
		return resultList;
	}

	public List<Map<String, String>> getBaomingListAddForDeal(String tiqu_num, int needNum) {
		List<Map<String, String>> resultList = null;
		
//		String sql = "SELECT t1.`name`,t1.phone,t1.baoming_date,t1.prov,t3.catalogname prov_name,t1.city,t4.catalogname city_name,t1.car_info,t1.brand,t1.serial,t1.return_visit_state "
//					+ "FROM car_315.tb_data_baoming t1, car_315.tb_data_tiqudata t2, car_315.dbo_are_catalog t3, car_315.dbo_are_catalog t4 "
//					+ "WHERE t2.tiqu_num='"+ tiqu_num +"' "
//							+ "AND TO_DAYS(t1.baoming_date)<TO_DAYS(t2.data_start_date) AND "
//							+ "t2.prov=(CASE WHEN t2.prov<>-1 THEN t1.prov ELSE -1 END) AND t2.city=(CASE WHEN t2.city<>-1 THEN t1.city ELSE -1 END) AND "
//							+ "t2.brand = t1.brand AND t2.car = (CASE WHEN t2.car<>-1 THEN t1.serial ELSE -1 END) AND "
//							+ "t1.prov = t3.catalogid AND t1.city = t4.catalogid "
//					+ "GROUP BY t1.phone "
//					+ "ORDER BY baoming_date DESC "
//					+ "LIMIT 0," + needNum;
		String sql = "SELECT t1.id baoming_id, t1.`name`,t1.phone,t1.baoming_date,t1.prov,t3.catalogname prov_name,t1.city,IFNULL(t4.catalogname,'') city_name,"
							+ "t1.car_info,t1.brand,t1.serial,t1.return_visit_state, t5.catalogname brand_name, t6.catalogname car_name "
					+ "FROM car_315.tb_data_baoming t1 "
							+ "INNER JOIN car_315.tb_data_tiqudata t2 ON t2.tiqu_num='"+ tiqu_num +"' "
									+ "AND TO_DAYS(t1.baoming_date)<TO_DAYS(t2.data_start_date) "
									+ "AND t2.prov=(CASE WHEN t2.prov<>-1 THEN t1.prov ELSE -1 END) AND t2.city=(CASE WHEN t2.city<>-1 THEN t1.city ELSE -1 END) "
									+ "AND t2.brand = t1.brand AND t2.car = (CASE WHEN t2.car<>-1 THEN t1.serial ELSE -1 END) "
							+ "LEFT JOIN car_315.dbo_are_catalog t3 ON t1.prov = t3.catalogid "
							+ "LEFT JOIN car_315.dbo_are_catalog t4 ON t1.city = t4.catalogid "
							+ "LEFT JOIN car_315.dbo_car_catalognew t5 ON t1.brand = t5.catalogid "
							+ "LEFT JOIN car_315.dbo_car_catalognew t6 ON t1.serial = t6.catalogid "
					+ "GROUP BY t1.phone "
					+ "ORDER BY baoming_date DESC "
					+ "LIMIT 0," + needNum;
		System.out.println(sql);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			resultList = new ArrayList<Map<String,String>>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("baoming_id", rs.getInt("baoming_id")+"");
				map.put("uname", rs.getString("name"));
				map.put("phone", rs.getString("phone"));
				map.put("baoming_date", sdf.format(rs.getDate("baoming_date")));
				map.put("prov_name", rs.getString("prov_name"));
				map.put("city_name", rs.getString("city_name"));
				map.put("car_info", rs.getString("car_info"));
				map.put("brand_name", rs.getString("brand_name"));
				map.put("car_name", rs.getString("car_name"));
				if (rs.getInt("return_visit_state")==0) {
					map.put("return_visit_state", "否");
				}else {
					map.put("return_visit_state", "是");
				}
				
				resultList.add(map);
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
		
		return resultList;
	}

	public int updateExportCount(String tiqu_num) {
		int result = EXECUTE_FAIL;
		String sql = "UPDATE car_315.tb_data_tiqudata SET export_count = export_count + 1 WHERE tiqu_num = '"+ tiqu_num +"'";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
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

	public int getProListPages(Map<String, String> whereMap) {
		int pages = 0;
		int rows;
		
		String whereString = "";
		if (!whereMap.get("dept_code").equals("") && whereMap.get("dept_code")!=null) {
			whereString = whereString + " AND t1.ini_dept=" + whereMap.get("dept_code");
		}
		if (!whereMap.get("apply_startdate").equals("") && whereMap.get("apply_startdate")!=null) {
			whereString = whereString + " AND TO_DAYS(t1.ini_date)>=TO_DAYS('"+ whereMap.get("apply_startdate") +"')";
		}
		if (!whereMap.get("apply_enddate").equals("") && whereMap.get("apply_enddate")!=null) {
			whereString = whereString + " AND TO_DAYS(t1.ini_date)<=TO_DAYS('"+ whereMap.get("apply_enddate") +"')";
		}
		if (!whereMap.get("examine_state").equals("") && whereMap.get("examine_state")!=null) {
			whereString = whereString + " AND t1.examine_state=" + whereMap.get("examine_state");
		}
		if (whereMap.get("tiqu_state").equals("1")) {
			whereString = whereString + " AND t1.tiqu_state=3";
		}else if (whereMap.get("tiqu_state").equals("0")) {
			whereString = whereString + " AND t1.tiqu_state<>3";
		}
		if (!whereMap.get("user_id").equals("") && whereMap.get("user_id")!=null) {
			whereString = whereString + " AND t1.ini_man = '"+ whereMap.get("user_id") +"'";
		}
		
		
		String sql = "SELECT COUNT(t1.tiqu_num) pro_count "
					+ "FROM car_315.tb_data_tiqudata t1 "
					+ "WHERE t1.tiqu_state<>0 "
					+ whereString;
		
		int pageNum = Integer.valueOf(whereMap.get("pageNum"));
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			rs.next();
			rows = rs.getInt("pro_count");
			if (rows%pageNum==0) {
				pages = rows/pageNum;
			}else {
				pages = rows/pageNum + 1;
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
		
		return pages;
	}

	public List<Map<String, String>> getBaomingListForExport(String baoming_ids) {
		List<Map<String, String>> resultList = null;
		String sql = "SELECT t1.id baoming_id, t1.`name`,t1.phone,t1.baoming_date,t1.prov,t3.catalogname prov_name,t1.city,IFNULL(t4.catalogname,'') city_name,"
							+ "t1.car_info,t1.brand,t1.serial,t1.return_visit_state, t5.catalogname brand_name, t6.catalogname car_name "
					+ "FROM car_315.tb_data_baoming t1 "
							+ "LEFT JOIN car_315.dbo_are_catalog t3 ON t1.prov = t3.catalogid "
							+ "LEFT JOIN car_315.dbo_are_catalog t4 ON t1.city = t4.catalogid "
							+ "LEFT JOIN car_315.dbo_car_catalognew t5 ON t1.brand = t5.catalogid "
							+ "LEFT JOIN car_315.dbo_car_catalognew t6 ON t1.serial = t6.catalogid "
					+ "WHERE id IN("+ baoming_ids +")";
		System.out.println(sql);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			resultList = new ArrayList<Map<String,String>>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("baoming_id", rs.getInt("baoming_id")+"");
				map.put("uname", rs.getString("name"));
				map.put("phone", rs.getString("phone"));
				map.put("baoming_date", sdf.format(rs.getDate("baoming_date")));
				map.put("prov_name", rs.getString("prov_name"));
				map.put("city_name", rs.getString("city_name"));
				map.put("car_info", rs.getString("car_info"));
				map.put("brand_name", rs.getString("brand_name"));
				map.put("car_name", rs.getString("car_name"));
				if (rs.getInt("return_visit_state")==0) {
					map.put("return_visit_state", "否");
				}else {
					map.put("return_visit_state", "是");
				}
				
				resultList.add(map);
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
		
		return resultList;
	}
	
	
	
}
