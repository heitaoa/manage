package com.poly.dao.data;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import car_daos.BaseDao;
import car_daos.DBConnect;

public class CountDao extends BaseDao {

	public Map<String, String> getBrandMapForCount() {
		Map<String, String> map = null; 
		
		String sql = "SELECT catalogid,catalogname FROM car_315.dbo_car_catalognew WHERE fatherid = 0 ORDER BY catalogid";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			map = new HashMap<String, String>();
			while (rs.next()) {
				map.put(String.valueOf(rs.getInt("catalogid")), rs.getString("catalogname"));
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
	
		return map;
	}

	public Map<String, String> getOrgMapForCount() {
		Map<String, String> map = null; 
		
		String sql = "SELECT ORG_ID,ORG_NAME FROM finance.tb_fin_org ORDER BY ORG_ID";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			map = new HashMap<String, String>();
			while (rs.next()) {
				map.put(String.valueOf(rs.getInt("ORG_ID")), rs.getString("ORG_NAME"));
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
	
		return map;
	}

	public Map<String, String> getExecutorMapForCount() {
		Map<String, String> map = null; 
		
		String sql = "SELECT DISTINCT t1.detail_executor, t2.USER_NAME "
					+ "FROM car_315.tb_data_act_detail t1, finance.tb_fin_user t2 "
					+ "WHERE t1.detail_executor = t2.USER_CODE "
					+ "ORDER BY t1.detail_id DESC ";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			map = new HashMap<String, String>();
			while (rs.next()) {
				map.put(rs.getString("detail_executor"), rs.getString("USER_NAME"));
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
	
		return map;
	}

	public List<Map<String, String>> getListForActiveCost(Map<String, String> requireMap) {
		List<Map<String, String>> list = null;
		
		StringBuffer sqlWhere = new StringBuffer();
		if (requireMap != null) {
			if (requireMap.get("orgid")!=null && requireMap.get("orgid").length()!=0){
				sqlWhere.append("t4.ORG_CODE = '"+ requireMap.get("orgid") +"' AND ");
			}
			if (requireMap.get("executor")!=null && requireMap.get("executor").length()!=0){
				sqlWhere.append("t1.detail_executor = '"+ requireMap.get("executor") +"' AND ");
			}
			if (requireMap.get("brand")!=null && requireMap.get("brand").length()!=0){
				sqlWhere.append("t2.brand = '"+ requireMap.get("brand") +"' AND ");
			}
		}
		
		String sql = "SELECT t2.pro_num, t2.acti_name, t2.contact_num, t2.cust_name, t2.brand, t3.catalogname brand_name, "
							+ "t1.detail_assist_person, t1.detail_executor, t4.USER_NAME executor_name, t5.ORG_NAME, "
							+ "t1.detail_traffic_expense, t1.detail_acti_sub, t1.detail_acti_date, COUNT(t6.id) trans_count, SUM(t6.giving_total_price) giving_money "
					+ "FROM car_315.tb_data_act_detail t1 "
							+ "LEFT JOIN car_315.tb_data_project t2 ON t1.pro_num = t2.pro_num "
							+ "LEFT JOIN car_315.dbo_car_catalognew t3 ON t2.brand = t3.catalogid "
							+ "LEFT JOIN finance.tb_fin_user t4 ON t1.detail_executor = t4.USER_CODE "
							+ "LEFT JOIN finance.tb_fin_org t5 ON t4.ORG_CODE = t5.ORG_ID "
							+ "LEFT JOIN car_315.tb_data_trans_info t6 ON t1.pro_num = t6.pro_num ";
		
		if (sqlWhere.length()>0) {
			String whereString = sqlWhere.toString();
			sql = sql + "WHERE " + whereString.substring(0, whereString.length()-4);
		}
		
		sql = sql + " GROUP BY t1.pro_num ";
		
		//System.out.println(sql);
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			list = new ArrayList<Map<String,String>>();
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("pro_num", rs.getString("pro_num"));
				map.put("acti_name", rs.getString("acti_name"));
				map.put("contact_num", rs.getString("contact_num"));
				map.put("cust_name", rs.getString("cust_name"));
				map.put("brand", rs.getString("brand"));
				map.put("brand_name", rs.getString("brand_name"));
				map.put("detail_assist_person", rs.getString("detail_assist_person"));
				map.put("detail_executor", rs.getString("detail_executor"));
				map.put("executor_name", rs.getString("executor_name"));
				map.put("ORG_NAME", rs.getString("ORG_NAME"));
				map.put("detail_traffic_expense", rs.getString("detail_traffic_expense"));
				map.put("detail_acti_sub", rs.getString("detail_acti_sub"));
				map.put("detail_acti_date", rs.getDate("detail_acti_date").toString());
				map.put("trans_count", rs.getString("trans_count"));
				map.put("giving_money", rs.getString("giving_money"));
				
				double allmoney = Double.parseDouble(map.get("giving_money")) + Double.parseDouble(map.get("detail_acti_sub")) + Double.parseDouble(map.get("detail_traffic_expense"));
				map.put("allmoney", String.valueOf(allmoney));
				list.add(map);
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
		
		return list;
	}

	public List<Map<String, String>> getListForActiveData(Map<String, String> requireMap) {
		List<Map<String, String>> resultList = null;
		
		StringBuffer sqlWhere = new StringBuffer();
		if (requireMap != null) {
			if (requireMap.get("orgid")!=null && requireMap.get("orgid").length()!=0){
				sqlWhere.append("t4.ORG_CODE = '"+ requireMap.get("orgid") +"' AND ");
			}
			if (requireMap.get("executor")!=null && requireMap.get("executor").length()!=0){
				sqlWhere.append("t1.detail_executor = '"+ requireMap.get("executor") +"' AND ");
			}
			if (requireMap.get("brand")!=null && requireMap.get("brand").length()!=0){
				sqlWhere.append("t2.brand = '"+ requireMap.get("brand") +"' AND ");
			}
		}
		
		String sql = "SELECT t10.USER_NAME detail_executor, t1.detail_acti_date, t1.pro_num, t2.acti_name, t3.catalogname brand_name, t4.USER_NAME service_name, t5.ORG_NAME, "
				   			+ "COUNT(t6.id) baoming_count, t7.invite_count, t8.reach_count, t9.trans_count "
				   	+ "FROM car_315.tb_data_act_detail t1 "
				   			+ "LEFT JOIN car_315.tb_data_project t2 ON t1.pro_num = t2.pro_num "
				   			+ "LEFT JOIN car_315.dbo_car_catalognew t3 ON t2.brand = t3.catalogid "
				   			+ "LEFT JOIN finance.tb_fin_user t4 ON t2.custom_service = t4.USER_CODE "
				   			+ "LEFT JOIN finance.tb_fin_org t5 ON t4.ORG_CODE = t5.ORG_ID "
//				   			+ "LEFT JOIN (SELECT tb1.pro_num, COUNT(tb3.id) baoming_count "
//					   					+ "FROM car_315.tb_data_act_detail tb1, car_315.tb_data_project tb2,car_315.tb_data_baoming tb3 "
//					   					+ "WHERE tb1.pro_num = tb2.pro_num AND tb2.car = tb3.serial AND tb2.service_type = tb3.type AND tb3.baoming_date > tb2.promo_start_date AND tb3.baoming_date < tb2.promo_end_date "
//					   					+ "GROUP BY tb1.pro_num) "
//					   					+ "t6 ON t6.pro_num = t1.pro_num " //报名数
							+ "LEFT JOIN car_315.tb_data_baoming t6 "
									+ "ON TO_DAYS(t6.baoming_date)>=TO_DAYS(t2.promo_start_date) AND TO_DAYS(t6.baoming_date)<=TO_DAYS(t2.promo_end_date) "
									+ "AND t2.promo_prov=(CASE WHEN t2.promo_prov!=-1 THEN t6.prov ELSE -1 END) AND t2.promo_city=(CASE WHEN t2.promo_city!=-1 THEN t6.city ELSE -1 END) "
									+ "AND t2.brand=(CASE WHEN t2.brand!=-1 THEN t6.brand ELSE -1 END) AND t2.car=(CASE WHEN t2.car!=-1 THEN t6.serial ELSE -1 END) AND t2.model=(CASE WHEN t2.model!=-1 THEN t6.model ELSE -1 END) " //报名数
//						   	+ "LEFT JOIN (SELECT tb1.pro_num, COUNT(tb3.id) invite_count "
//							   			+ "FROM car_315.tb_data_act_detail tb1, car_315.tb_data_project tb2,car_315.tb_data_baoming tb3 "
//							   			+ "WHERE tb1.pro_num = tb2.pro_num AND tb2.car = tb3.serial AND tb2.service_type = tb3.type AND tb3.baoming_date > tb2.promo_start_date AND tb3.baoming_date < tb2.promo_end_date AND tb3.is_invite = 1 "
//							   			+ "GROUP BY tb1.pro_num ) "
//					   					+ "t7 ON t7.pro_num = t1.pro_num "  //邀约数
							+ "LEFT JOIN (SELECT COUNT(record_id) invite_count,t1.pro_num "
										+ "FROM car_315.tb_data_act_detail t1,car_315.tb_data_visit_record t2 "
										+ "WHERE t1.pro_num=t2.pro_num AND t2.is_invite=1 "
										+ "GROUP BY t1.pro_num ) t7 "
									+ "ON t1.pro_num = t7.pro_num " //邀约数
//				   			+ "LEFT JOIN (SELECT tb1.pro_num, COUNT(tb3.id) reach_count "
//							   			+ "FROM car_315.tb_data_act_detail tb1, car_315.tb_data_project tb2,car_315.tb_data_baoming tb3 "
//							   			+ "WHERE tb1.pro_num = tb2.pro_num AND tb2.car = tb3.serial AND tb2.service_type = tb3.type AND tb3.baoming_date > tb2.promo_start_date AND tb3.baoming_date < tb2.promo_end_date AND tb3.is_reach= 1 "
//							   			+ "GROUP BY tb1.pro_num ) "
//							   			+ "t8 ON t8.pro_num = t1.pro_num "  //到达数
							+ "LEFT JOIN (SELECT COUNT(record_id) reach_count,t1.pro_num "
										+ "FROM car_315.tb_data_act_detail t1,car_315.tb_data_visit_record t2 "
										+ "WHERE t1.pro_num=t2.pro_num AND t2.is_reach=1 "
										+ "GROUP BY t1.pro_num ) t8 "
									+ "ON t1.pro_num = t8.pro_num " //到达数
//				   			+ "LEFT JOIN (SELECT tb1.pro_num, COUNT(tb3.id) trans_count "
//							   			+ "FROM car_315.tb_data_act_detail tb1, car_315.tb_data_project tb2,car_315.tb_data_baoming tb3 "
//							   			+ "WHERE tb1.pro_num = tb2.pro_num AND tb2.car = tb3.serial AND tb2.service_type = tb3.type AND tb3.baoming_date > tb2.promo_start_date AND tb3.baoming_date < tb2.promo_end_date AND tb3.is_trans= 1 "
//							   			+ "GROUP BY tb1.pro_num) "
//							   			+ "t9 ON t9.pro_num = t1.pro_num "  //成交数
							+ "LEFT JOIN (SELECT COUNT(record_id) trans_count,t1.pro_num "
										+ "FROM car_315.tb_data_act_detail t1,car_315.tb_data_visit_record t2 "
										+ "WHERE t1.pro_num=t2.pro_num AND t2.is_trans=1 "
										+ "GROUP BY t1.pro_num ) t9 "
									+ "ON t1.pro_num = t9.pro_num " //成交数
				   			+ "LEFT JOIN finance.tb_fin_user t10 ON t1.detail_executor = t10.USER_CODE "
				   			+ "GROUP BY t1.pro_num ";
		

		if (sqlWhere.length()>0) {
			String whereString = sqlWhere.toString();
			sql = sql + "WHERE " + whereString.substring(0, whereString.length()-4);
		}
		
		System.out.println(sql);
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			resultList = new ArrayList<Map<String,String>>();
			double dd = 0;
			DecimalFormat df = new DecimalFormat("######0.0");
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("detail_executor", rs.getString("detail_executor"));             //执行人
				map.put("detail_acti_date", rs.getDate("detail_acti_date").toString());  //执行日期
				map.put("pro_num", rs.getString("pro_num"));                             //项目编号
				map.put("acti_name", rs.getString("acti_name"));                         //活动名称
				map.put("brand_name", rs.getString("brand_name"));                       //品牌名
				map.put("service_name", rs.getString("service_name"));                   //客服
				map.put("org_name", rs.getString("ORG_NAME"));                           //分站名称
				map.put("baoming_count", String.valueOf(rs.getInt("baoming_count")));    //报名数
				map.put("invite_count", String.valueOf(rs.getInt("invite_count")));      //邀请数
				map.put("reach_count", String.valueOf(rs.getInt("reach_count")));        //到达数
				map.put("trans_count", String.valueOf(rs.getInt("trans_count")));        //成交数
				if (rs.getInt("baoming_count")>0) {
					dd = rs.getInt("invite_count")*1.0/rs.getInt("baoming_count")*100;
					map.put("ratio_invite", df.format(dd) + "%");                                  //邀请率
				}else {
					map.put("ratio_invite", "0");                                  //邀请率
				}
				
				if (rs.getInt("baoming_count")>0) {
					dd = rs.getInt("reach_count")*1.0/rs.getInt("baoming_count")*100;
					map.put("ratio_reach", df.format(dd) + "%");                                   //到达率
				}else {
					map.put("ratio_reach", "0");
				}
				
				if (rs.getInt("baoming_count")>0) {
					dd = rs.getInt("trans_count")*1.0/rs.getInt("baoming_count")*100;
					map.put("ratio_trans", df.format(dd) + "%");                                   //成交率
				}else {
					map.put("ratio_trans", "0");
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

	public List<Map<String, String>> getSignTable(String pro_num) {
		List<Map<String, String>> list = null;
		
		String sql = "SELECT t1.`name`,t1.phone,t1.baoming_date,t3.catalogname prov,t4.catalogname city,t2.acti_name,t1.is_trans "
					+ "FROM car_315.tb_data_baoming t1 LEFT JOIN car_315.tb_data_project t2 ON t2.car = t1.serial AND t2.service_type = t1.type AND t1.baoming_date > t2.promo_start_date AND t1.baoming_date < t2.promo_end_date "
						+ "LEFT JOIN car_315.dbo_are_catalog t3 ON t1.prov = t3.catalogid "
						+ "LEFT JOIN car_315.dbo_are_catalog t4 ON t1.city = t4.catalogid "
					+ "WHERE t2.pro_num='"+ pro_num +"' ";
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			list = new ArrayList<Map<String,String>>();
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("name", rs.getString("name"));
				map.put("phone", rs.getString("phone"));
				map.put("baoming_date", rs.getDate("baoming_date").toString());
				map.put("prov", rs.getString("prov"));
				map.put("city", rs.getString("city"));
				map.put("acti_name", rs.getString("acti_name"));
				map.put("is_trans", String.valueOf(rs.getInt("is_trans")));
				list.add(map);
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
		
		return list;
	}

	public Map<String, String> getTransAreaMap() {
		Map<String, String> map = null;
		
		String sql = "SELECT DISTINCT t3.prov,t4.catalogname "
					+ "FROM car_315.tb_data_trans_info t1, car_315.tb_data_qiandao t2, car_315.tb_data_baoming t3, car_315.dbo_are_catalog t4 "
					+ "WHERE t1.qiandao_id = t2.id AND t2.id = t3.id AND t3.prov = t4.catalogid AND t3.prov IS NOT NULL ";
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			map = new HashMap<String, String>();
			while (rs.next()) {
				map.put(String.valueOf(rs.getInt("prov")), rs.getString("catalogname"));
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
		
		return map;
	}

	public List<Map<String, String>> getTransList(Map<String, String> mapWhere) {
		List<Map<String, String>> resultList = null;
		
		StringBuffer sqlWhere = new StringBuffer();
		if (mapWhere != null) {
			if (mapWhere.get("date_start")!=null && mapWhere.get("date_start").length()!=0){
				sqlWhere.append("TO_DAYS(t1.trans_date)>=TO_DAYS('"+ mapWhere.get("date_start") +"') AND ");
			}
			if (mapWhere.get("date_end")!=null && mapWhere.get("date_end").length()!=0){
				sqlWhere.append("TO_DAYS(t1.trans_date)<=TO_DAYS('"+ mapWhere.get("date_end") +"') AND ");
			}
			if (mapWhere.get("promo_prov")!=null && mapWhere.get("promo_prov").length()!=0) sqlWhere.append("t2.promo_prov=" + mapWhere.get("promo_prov") + " AND ");  //推广省份
			if (mapWhere.get("promo_city")!=null && mapWhere.get("promo_city").length()!=0) sqlWhere.append("t2.promo_city=" + mapWhere.get("promo_city") + " AND ");  //推广省份
			if (mapWhere.get("service_type")!="-1" && mapWhere.get("service_type").length()!=0){
				sqlWhere.append("t2.service_type = "+ mapWhere.get("service_type") +" AND ");
			}
		}
		
		String wheresString = "";
		
		if (sqlWhere.length() > 0) {
			wheresString = "WHERE " + sqlWhere.substring(0, sqlWhere.length() - 4);
		}
		
		int pageNum = Integer.valueOf(mapWhere.get("pageNum"));
		int page = Integer.valueOf(mapWhere.get("page")) - 1;
		
		String sql = "SELECT t1.`name`,t1.phone,t1.plate,t1.addr,t1.model,t3.catalogname model_name,t1.trans_date,"
						+ "t2.acti_name,t1.giving_name,t1.trans_price,t1.engine_num,t1.VIN_num, t1.giving_total_price "
					+ "FROM car_315.tb_data_trans_info t1 "
						+ "INNER JOIN car_315.tb_data_project t2 ON t1.pro_num=t2.pro_num "
						+ "LEFT JOIN car_315.dbo_car_catalognew t3 ON t1.model = t3.catalogid "
					+ wheresString
					+ " ORDER BY t1.trans_date DESC LIMIT "+ page*pageNum +","+ pageNum +" ";
		
		System.out.println(sql);
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			resultList = new ArrayList<Map<String,String>>();
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("name", rs.getString("name"));
				map.put("phone", rs.getString("phone"));
				map.put("plate", rs.getString("plate"));
				map.put("addr", rs.getString("addr"));
				map.put("model_name", rs.getString("model_name"));
				//此处为了处理日期不存在的情况，等正式运行的时候，无需验证
				if (rs.getDate("trans_date")==null) {
//					DateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");
//					map.put("trans_date", String.valueOf(format.format(new Date())));
					map.put("trans_date", "");
				}else {
					map.put("trans_date", String.valueOf(rs.getDate("trans_date")));
				}
				map.put("acti_name", rs.getString("acti_name"));
				map.put("giving_name", rs.getString("giving_name"));
				map.put("trans_price", rs.getString("trans_price"));
				map.put("engine_num", rs.getString("engine_num"));
				map.put("VIN_num", rs.getString("VIN_num"));
				map.put("giving_total_price", rs.getString("giving_total_price"));
				
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

	public List<Map<String, String>> getNotsaleList(Map<String, String> mapWhere) {
		List<Map<String, String>> resultList = null;
		
		String sql = "";
		
		
		return null;
	}

	public int getTransListPages(Map<String, String> mapWhere) {
		int pages = 0;
		int rows;
		
		StringBuffer sqlWhere = new StringBuffer();
		if (mapWhere != null) {
			if (mapWhere.get("date_start")!=null && mapWhere.get("date_start").length()!=0){
				sqlWhere.append("TO_DAYS(t1.trans_date)>=TO_DAYS('"+ mapWhere.get("date_start") +"') AND ");
			}
			if (mapWhere.get("date_end")!=null && mapWhere.get("date_end").length()!=0){
				sqlWhere.append("TO_DAYS(t1.trans_date)<=TO_DAYS('"+ mapWhere.get("date_end") +"') AND ");
			}
			if (mapWhere.get("promo_prov")!=null && mapWhere.get("promo_prov").length()!=0) sqlWhere.append("t2.promo_prov=" + mapWhere.get("promo_prov") + " AND ");  //推广省份
			if (mapWhere.get("promo_city")!=null && mapWhere.get("promo_city").length()!=0) sqlWhere.append("t2.promo_city=" + mapWhere.get("promo_city") + " AND ");  //推广省份
			if (mapWhere.get("service_type")!="-1" && mapWhere.get("service_type").length()!=0){
				sqlWhere.append("t2.service_type = "+ mapWhere.get("service_type") +" AND ");
			}
		}
		
		String wheresString = "";
		
		if (sqlWhere.length() > 0) {
			wheresString = "WHERE " + sqlWhere.substring(0, sqlWhere.length() - 4);
		}
		
		String sql = "SELECT COUNT(t1.id) trans_count "
					+ "FROM car_315.tb_data_trans_info t1 "
						+ "INNER JOIN car_315.tb_data_project t2 ON t1.pro_num=t2.pro_num "
					+ wheresString;
		
		int pageNum = Integer.valueOf(mapWhere.get("pageNum"));
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			rs.next();
			rows = rs.getInt("trans_count");
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
	
	public int 	getApplyListPages(Map<String, String> mapWhere) {
		int pages = 0;
		int rows;
		
		StringBuffer sqlWhere = new StringBuffer();
		if (mapWhere != null) {
			if (mapWhere.get("date_start")!=null && mapWhere.get("date_start").length()!=0){
				sqlWhere.append("TO_DAYS(t1.baoming_date)>=TO_DAYS('"+ mapWhere.get("date_start") +"') AND ");
			}
			if (mapWhere.get("date_end")!=null && mapWhere.get("date_end").length()!=0){
				sqlWhere.append("TO_DAYS(t1.baoming_date)<=TO_DAYS('"+ mapWhere.get("date_end") +"') AND ");
			}
			if (mapWhere.get("promo_prov")!=null && mapWhere.get("promo_prov").length()!=0) sqlWhere.append("t1.prov=" + mapWhere.get("promo_prov") + " AND ");  //推广省份
			if (mapWhere.get("promo_city")!=null && mapWhere.get("promo_city").length()!=0) sqlWhere.append("t1.city=" + mapWhere.get("promo_city") + " AND ");  //推广省份
			if (mapWhere.get("real_type")!="-1" && mapWhere.get("real_type").length()!=0){
				sqlWhere.append("t1.real_type = "+ mapWhere.get("real_type") +" AND ");
			}
		}
		
		String wheresString = "";
		
		if (sqlWhere.length() > 0) {
			wheresString = " and " + sqlWhere.substring(0, sqlWhere.length() - 4);
		}
		String sql = "select count(*) counts from (SELECT tb.iway,count(tb.iway) count from (select t2.iway  from tb_data_baoming t1 LEFT OUTER JOIN dbo_car_catalognew t2 on t1.serial  = t2.catalogid  and t1.isDelete=0"
				 + wheresString+" ) tb GROUP BY tb.iway having count>0 ORDER BY count(tb.iway))tb1 ";
		
		int pageNum = Integer.valueOf(mapWhere.get("pageNum"));
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			rs.next();
			rows = rs.getInt("counts");
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
	public List<Map<String, String>> getApplyList(Map<String, String> mapWhere) {
		List<Map<String, String>> resultList = null;
		
		StringBuffer sqlWhere = new StringBuffer();
		if (mapWhere != null) {
			if (mapWhere.get("date_start")!=null && mapWhere.get("date_start").length()!=0){
				sqlWhere.append("TO_DAYS(t1.baoming_date)>=TO_DAYS('"+ mapWhere.get("date_start") +"') AND ");
			}
			if (mapWhere.get("date_end")!=null && mapWhere.get("date_end").length()!=0){
				sqlWhere.append("TO_DAYS(t1.baoming_date)<=TO_DAYS('"+ mapWhere.get("date_end") +"') AND ");
			}
			if (mapWhere.get("promo_prov")!=null && mapWhere.get("promo_prov").length()!=0) sqlWhere.append("t1.prov=" + mapWhere.get("promo_prov") + " AND ");  //推广省份
			if (mapWhere.get("promo_city")!=null && mapWhere.get("promo_city").length()!=0) sqlWhere.append("t1.city=" + mapWhere.get("promo_city") + " AND ");  //推广省份
			if (mapWhere.get("real_type")!="-1" && mapWhere.get("real_type").length()!=0){
				sqlWhere.append("t1.real_type = "+ mapWhere.get("real_type") +" AND ");
			}
		}
		
		String wheresString = "";
		
		if (sqlWhere.length() > 0) {
			wheresString = " and " + sqlWhere.substring(0, sqlWhere.length() - 4);
		}
		int pageNum = Integer.valueOf(mapWhere.get("pageNum"));
		int page = Integer.valueOf(mapWhere.get("page")) - 1;
		
		String sql = "SELECT tb.iway,count(tb.iway) count from (select t2.iway from tb_data_baoming t1 LEFT OUTER JOIN dbo_car_catalognew t2 on t1.serial  = t2.catalogid where t1.isDelete=0   "
				 + wheresString+" ) tb GROUP BY tb.iway ORDER BY count(tb.iway) desc LIMIT "+ page*pageNum +","+ pageNum +" ";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			resultList = new ArrayList<Map<String,String>>();
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				if( rs.getString("iway")==null)
					continue;
				map.put("iway", rs.getString("iway"));
				map.put("count", rs.getString("count"));
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
	public int getbrandCountByCitys(Map<String, String> mapWhere,String iway) {
		int count=0;
		StringBuffer sqlWhere = new StringBuffer();
		if (mapWhere != null) {
			if (mapWhere.get("date_start")!=null && mapWhere.get("date_start").length()!=0){
				sqlWhere.append("TO_DAYS(t1.baoming_date)>=TO_DAYS('"+ mapWhere.get("date_start") +"') AND ");
			}
			if (mapWhere.get("date_end")!=null && mapWhere.get("date_end").length()!=0){
				sqlWhere.append("TO_DAYS(t1.baoming_date)<=TO_DAYS('"+ mapWhere.get("date_end") +"') AND ");
			}
			if (mapWhere.get("promo_prov")!=null && mapWhere.get("promo_prov").length()!=0) sqlWhere.append("t1.prov=" + mapWhere.get("promo_prov") + " AND ");  //推广省份
			if (mapWhere.get("promo_city")!=null && mapWhere.get("promo_city").length()!=0) sqlWhere.append("t1.city=" + mapWhere.get("promo_city") + " AND ");  //推广省份
			if (mapWhere.get("real_type")!="-1" && mapWhere.get("real_type").length()!=0){
				sqlWhere.append("t1.real_type = "+ mapWhere.get("real_type") +" AND ");
			}
		}
		
		String wheresString = "";
		if (sqlWhere.length() > 0) {
			wheresString = sqlWhere.toString();
		}
	
		String sql  = "SELECT count(*) count from tb_data_baoming t1 LEFT OUTER JOIN dbo_car_catalognew t2 on t1.serial = t2.catalogid where t1.isDelete=0 and t1.return_visit_state!=0 and "
				+ wheresString
				+ "  t2.iway = '"+iway+"'";

		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				count= rs.getInt("count");
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
		
		return count;
	}
	public int getbrandwCountByCitys(Map<String, String> mapWhere,String iway) {
		int count=0;
		StringBuffer sqlWhere = new StringBuffer();
		if (mapWhere != null) {
			if (mapWhere.get("date_start")!=null && mapWhere.get("date_start").length()!=0){
				sqlWhere.append("TO_DAYS(t1.baoming_date)>=TO_DAYS('"+ mapWhere.get("date_start") +"') AND ");
			}
			if (mapWhere.get("date_end")!=null && mapWhere.get("date_end").length()!=0){
				sqlWhere.append("TO_DAYS(t1.baoming_date)<=TO_DAYS('"+ mapWhere.get("date_end") +"') AND ");
			}
			if (mapWhere.get("promo_prov")!=null && mapWhere.get("promo_prov").length()!=0) sqlWhere.append("t1.prov=" + mapWhere.get("promo_prov") + " AND ");  //推广省份
			if (mapWhere.get("promo_city")!=null && mapWhere.get("promo_city").length()!=0) sqlWhere.append("t1.city=" + mapWhere.get("promo_city") + " AND ");  //推广省份
			if (mapWhere.get("real_type")!="-1" && mapWhere.get("real_type").length()!=0){
				sqlWhere.append("t1.real_type = "+ mapWhere.get("real_type") +" AND ");
			}
		}
		
		String wheresString = "";
		
		if (sqlWhere.length() > 0) {
			wheresString = sqlWhere.toString();
		}
		String sql  = "SELECT count(*) count from tb_data_baoming t1 LEFT OUTER JOIN dbo_car_catalognew t2 on t1.serial = t2.catalogid where t1.isDelete=0 and t1.phoneerror=1 and "
				+ wheresString
				+ " t2.iway = '"+iway+"'";

		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				count= rs.getInt("count");
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
		
		return count;
	}
	
	
	public int getbrandyxCountByCitys(Map<String, String> mapWhere,String iway) {
		int count=0;
		StringBuffer sqlWhere = new StringBuffer();
		if (mapWhere != null) {
			if (mapWhere.get("date_start")!=null && mapWhere.get("date_start").length()!=0){
				sqlWhere.append("TO_DAYS(t1.baoming_date)>=TO_DAYS('"+ mapWhere.get("date_start") +"') AND ");
			}
			if (mapWhere.get("date_end")!=null && mapWhere.get("date_end").length()!=0){
				sqlWhere.append("TO_DAYS(t1.baoming_date)<=TO_DAYS('"+ mapWhere.get("date_end") +"') AND ");
			}
			if (mapWhere.get("promo_prov")!=null && mapWhere.get("promo_prov").length()!=0) sqlWhere.append("t1.prov=" + mapWhere.get("promo_prov") + " AND ");  //推广省份
			if (mapWhere.get("promo_city")!=null && mapWhere.get("promo_city").length()!=0) sqlWhere.append("t1.city=" + mapWhere.get("promo_city") + " AND ");  //推广省份
			if (mapWhere.get("real_type")!="-1" && mapWhere.get("real_type").length()!=0){
				sqlWhere.append("t1.real_type = "+ mapWhere.get("real_type") +" AND ");
			}
		}
		
		String wheresString = "";
		
		if (sqlWhere.length() > 0) {
			wheresString = sqlWhere.toString();
		}
		String sql  = "SELECT count(*) count from tb_data_baoming t1 LEFT OUTER JOIN dbo_car_catalognew t2 on t1.serial = t2.catalogid where t1.isDelete=0 and t1.phone_state!=0 and "
				+ wheresString
				+ " t2.iway = '"+iway+"'";

		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				count= rs.getInt("count");
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
		
		return count;
	}
	public int selectCounts(Map<String, String> mapWhere,String str) {
		int count=0;
		StringBuffer sqlWhere = new StringBuffer();
		if (mapWhere != null) {
			if (mapWhere.get("date_start")!=null && mapWhere.get("date_start").length()!=0){
				sqlWhere.append("TO_DAYS(t1.baoming_date)>=TO_DAYS('"+ mapWhere.get("date_start") +"') AND ");
			}
			if (mapWhere.get("date_end")!=null && mapWhere.get("date_end").length()!=0){
				sqlWhere.append("TO_DAYS(t1.baoming_date)<=TO_DAYS('"+ mapWhere.get("date_end") +"') AND ");
			}
			if (mapWhere.get("promo_prov")!=null && mapWhere.get("promo_prov").length()!=0) sqlWhere.append("t1.prov=" + mapWhere.get("promo_prov") + " AND ");  //推广省份
			if (mapWhere.get("promo_city")!=null && mapWhere.get("promo_city").length()!=0) sqlWhere.append("t1.city=" + mapWhere.get("promo_city") + " AND ");  //推广省份
			if (mapWhere.get("real_type")!="-1" && mapWhere.get("real_type").length()!=0){
				sqlWhere.append("t1.real_type = "+ mapWhere.get("real_type") +" AND ");
			}
		}
		
		String wheresString = "";
		
		if (sqlWhere.length() > 0) {
			wheresString = sqlWhere.toString();
		}
		String sql="";
		if(str.trim().equals("")){
		 sql  = "select count(*) count from tb_data_baoming t1 where "+wheresString+str+" t1.isDelete=0";
		}
		else{ sql  = "select count(*) count from tb_data_baoming t1 where "+wheresString+str+" and t1.isDelete=0";}

		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				count= rs.getInt("count");
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
		
		return count;
	}

	public List<Map<String, String>> getAreaBaomingData(Map<String, String> map) {
		
		String whereStr = "";
		if (map.get("start_date").length()>0) {
			whereStr = whereStr + "AND TO_DAYS(tb1.baoming_date) >= TO_DAYS('"+ map.get("start_date") +"') ";
		}
		if (map.get("end_date").length()>0) {
			whereStr = whereStr + "AND TO_DAYS(tb1.baoming_date) <= TO_DAYS('"+ map.get("end_date") +"') ";
		}
		if (map.get("brand").length()>0) {
			whereStr = whereStr + "AND tb1.brand="+ map.get("brand") +" ";
		}
		
		List<Map<String, String>> resultList = null;
		
		String sql = "SELECT t1.baoming_count, t2.huifang_count, t3.weitong_count, IFNULL(t4.weigou_count,0) weigou_count, IFNULL(t5.wuxiao_count,0) wuxiao_count, "
							+ "IFNULL(t6.trans_count,0) trans_count, t1.sub_site, t1.site_name, t1.dis_id, t1.dis_name "
					+ "FROM (SELECT COUNT(tb1.id) baoming_count, tb1.sub_site, tb2.`name` site_name, tb3.dis_id, tb3.dis_name "
								+ "FROM car_315.tb_data_baoming tb1 LEFT JOIN car.tb_sub_sites tb2 ON tb1.sub_site=tb2.id "
								+ "LEFT JOIN finance.tb_fin_district tb3 ON tb2.dis_id=tb3.dis_id "
								+ "WHERE tb1.isDelete=0 AND tb1.sub_site>0 "
								+ whereStr 
								+" GROUP BY tb1.sub_site) t1 "  //报名量
					+ "LEFT JOIN (SELECT COUNT(tb1.id) huifang_count, tb1.sub_site "
								+ "FROM car_315.tb_data_baoming tb1 WHERE tb1.return_visit_state>0 AND tb1.sub_site>0 AND tb1.isDelete=0 "
								+ whereStr
								+ "GROUP BY tb1.sub_site) "
								+ "t2 ON t1.sub_site=t2.sub_site "  //回访量
					+ "LEFT JOIN (SELECT COUNT(tb1.id) weitong_count, tb1.sub_site "
								+ "FROM car_315.tb_data_baoming tb1 WHERE tb1.phoneerror=1 AND tb1.sub_site>0 AND tb1.isDelete=0 "
								+ whereStr
								+ "GROUP BY tb1.sub_site) "
								+ "t3 ON t1.sub_site = t3.sub_site "  //未接通量
					+ "LEFT JOIN (SELECT COUNT(tb1.id) weigou_count, tb1.sub_site "
								+ "FROM car_315.tb_data_baoming tb1 WHERE tb1.constacterror=1 AND tb1.sub_site>0 AND tb1.isDelete=0 "
								+ whereStr
								+ "GROUP BY tb1.sub_site) "
								+ "t4 ON t1.sub_site = t4.sub_site "  //未沟通量
					+ "LEFT JOIN (SELECT COUNT(tb1.id) wuxiao_count, tb1.sub_site "
								+ "FROM car_315.tb_data_baoming tb1 WHERE tb1.phone_state=1 AND tb1.sub_site>0 AND tb1.isDelete=0 "
								+ whereStr
								+ "GROUP BY tb1.sub_site) "
								+ "t5 ON t1.sub_site = t5.sub_site "  //无效报名量
					+ "LEFT JOIN (SELECT COUNT(tb1.id) trans_count, tb1.sub_site "
								+ "FROM car_315.tb_data_baoming tb1 LEFT JOIN car_315.tb_data_visit_record tb2 ON tb1.id = tb2.baoming_id "
								+ "WHERE tb2.is_trans=1 AND tb1.sub_site>0 "
								+ whereStr
								+ "GROUP BY tb1.sub_site) "
								+ "t6 ON t1.sub_site = t6.sub_site " //成交量
					+ "ORDER BY t1.dis_id, t1.sub_site ";
		System.out.println(sql);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			resultList = new ArrayList<Map<String,String>>();
			while (rs.next()) {
				Map<String, String> rmap = new HashMap<String, String>();
				rmap.put("baoming_count", rs.getInt("baoming_count") + "");
				rmap.put("huifang_count", rs.getInt("huifang_count") + "");
				rmap.put("weitong_count", rs.getInt("weitong_count") + "");
				rmap.put("weigou_count", rs.getInt("weigou_count") + "");
				rmap.put("wuxiao_count", rs.getInt("wuxiao_count") + "");
				rmap.put("trans_count", rs.getInt("trans_count") + "");
				rmap.put("sub_site", rs.getInt("sub_site") + "");
				rmap.put("site_name", rs.getString("site_name"));
				rmap.put("dis_id", rs.getInt("dis_id") + "");
				rmap.put("dis_name", rs.getString("dis_name"));
				resultList.add(rmap);
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

	public List<Map<String, String>> getAreaBaomingDataNull() {
		List<Map<String, String>> resultList = null;
		
		String sql = "SELECT t1.id sub_site, t1.`name` site_name, t1.dis_id,t2.dis_name "
					+ "FROM car.tb_sub_sites t1 LEFT JOIN finance.tb_fin_district t2 ON t1.dis_id=t2.dis_id "
					+ "ORDER BY t1.dis_id,t1.id";
		System.out.println(sql);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			resultList = new ArrayList<Map<String,String>>();
			while (rs.next()) {
				Map<String, String> rmap = new HashMap<String, String>();
				rmap.put("baoming_count", "0");
				rmap.put("huifang_count", "0");
				rmap.put("weitong_count", "0");
				rmap.put("weigou_count", "0");
				rmap.put("wuxiao_count", "0");
				rmap.put("trans_count", "0");
				rmap.put("sub_site", rs.getInt("sub_site") + "");
				rmap.put("site_name", rs.getString("site_name"));
				rmap.put("dis_id", rs.getInt("dis_id") + "");
				rmap.put("dis_name", rs.getString("dis_name"));
				resultList.add(rmap);
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

