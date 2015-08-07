package com.poly.dao.data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import car_daos.BaseDao;
import car_daos.DBConnect;

public class PresentApplyDao extends BaseDao {

	public Map<String, String> getProvMap() {
		Map<String, String> resultMap = null;
		String sql = "SELECT catalogid,catalogname,lname FROM car_315.dbo_are_catalog WHERE fatherid = 0 ORDER BY lname";
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			resultMap = new LinkedHashMap<String, String>();
			while (rs.next()) {
				resultMap.put(String.valueOf(rs.getInt("catalogid")), rs.getString("catalogname"));
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

	public String getCityStrByProv(String prov) {
		String sql = "SELECT catalogid,catalogname FROM car_315.dbo_are_catalog WHERE fatherid = "+ prov +" ORDER BY catalogid";
		
		StringBuffer citybuffer = new StringBuffer();
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				citybuffer.append(rs.getInt("catalogid") + "|" + rs.getString("catalogname") + "|");
			}
			
			if (citybuffer.length()>1) {
				citybuffer.deleteCharAt(citybuffer.length()-1);
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
		
		return citybuffer.toString();
	}

	public List<Map<String, String>> getApplyList(Map<String, String> mapWhere) {
		List<Map<String, String>> resultList = null;
		
		StringBuffer sqlWhere = new StringBuffer();
		String whereString = "";
		if (mapWhere != null) {
			if (mapWhere.get("state")!=null && mapWhere.get("state").length()!=0){
				sqlWhere.append("t1.apply_state = "+ mapWhere.get("state") +" AND ");
			}
			if (mapWhere.get("owner_name")!=null && mapWhere.get("owner_name").length()!=0){
				sqlWhere.append("t1.owner_name = '"+ mapWhere.get("owner_name") +"' AND ");
			}
			if (mapWhere.get("owner_phone")!=null && mapWhere.get("owner_phone").length()!=0){
				sqlWhere.append("t1.owner_phone = '"+ mapWhere.get("owner_phone") +"' AND ");
			}
			if (mapWhere.get("owner_carcode")!=null && mapWhere.get("owner_carcode").length()!=0){
				sqlWhere.append("t1.owner_carcode = '"+ mapWhere.get("owner_carcode") +"' AND ");
			}
			if (mapWhere.get("prov")!=null && mapWhere.get("prov").length()!=0){
				sqlWhere.append("t3.fatherid = "+ mapWhere.get("prov") +" AND ");
			}
			if (mapWhere.get("city")!=null && mapWhere.get("city").length()!=0){
				sqlWhere.append("t3.catalogid = "+ mapWhere.get("city") +" AND ");
			}
			
			if (mapWhere.get("gift_examine_state")!=null && mapWhere.get("gift_examine_state").length()!=0){
				sqlWhere.append("t6.gift_examine_state = "+ mapWhere.get("gift_examine_state") +" AND ");
			}
			
			if ("1".equals(mapWhere.get("org_code"))) {
				sqlWhere.append("(t3.catalogid NOT IN (SELECT t1.catalogid FROM car_315.dbo_are_catalog t1, finance.tb_fin_org t2 WHERE (t1.catalogid=t2.ORG_COMMENT OR t1.fatherid=t2.ORG_COMMENT) AND t2.ORG_ID!=1) OR "
						+ "t1.id IN (SELECT id  FROM car_315.tb_data_present_apply WHERE city_buy IS NULL OR city_buy='')) AND ");
			}else {
				sqlWhere.append("t3.catalogid IN (SELECT t1.catalogid FROM car_315.dbo_are_catalog t1 WHERE t1.catalogid="+ mapWhere.get("org_comment") +" OR t1.fatherid="+ mapWhere.get("org_comment") +") AND ");
			}
			
//			if (mapWhere.get("cityfatherid").equals("0")) {
//				sqlWhere.append("t3.fatherid = "+ mapWhere.get("cityid") +" AND ");
//			}else {
//				sqlWhere.append("t1.city_buy = "+ mapWhere.get("cityid") +" AND ");
//			}
			
		}
		sqlWhere.append("t1.is_del=0 AND ");
		
		int pageNum = Integer.valueOf(mapWhere.get("pageNum"));
		int page = Integer.valueOf(mapWhere.get("page")) - 1;
		
		if (sqlWhere.length()>0) {
			whereString = sqlWhere.toString();
			whereString = "WHERE " + whereString.substring(0, whereString.length()-4);
		}
		
		String sql = "SELECT t1.id apply_id, t1.owner_name, t1.owner_phone, t1.owner_carcode, t1.owner_address, t1.owner_idcode, t1.apply_date, "
							+ "t1.travelcard_date, t1.carbill_date, t1.giftverify_img, t1.carbill_img, t1.travelcard_img, t1.idcard_img, t1.car_img, "
							+ "t1.owner_remark, t1.remark, t1.apply_state, t1.transid verify_transid, t1.postbill_code,t1.transid transid_original, "
							+ "t1.engine_num, t1.vin_num, "
							+ "CASE WHEN t1.transid>0 THEN t6.gift_examine_state WHEN t1.transid=0 THEN -1 END AS gift_examine_state, "
							+ "CASE WHEN t1.transid>0 THEN t1.transid "
								 + "WHEN t1.transid=0 AND COUNT(t4.id)=1 THEN t2.id "
								 + "WHEN t1.transid=0 AND COUNT(t4.id)>1 THEN 0 "
								 + "WHEN t1.transid=0 AND COUNT(t4.id)=0 THEN -1 "
								 + "END AS trans_id, "
							+ "CASE WHEN COUNT(t4.id)=1 THEN t2.giving_name "
								 + "WHEN t1.transid>0 THEN t5.giving_name "
								 + "WHEN t1.transid=0 OR COUNT(t4.id)>1 OR COUNT(t4.id)=0 THEN '' "
								 + "END AS giving_name, "
							+ "COUNT(t4.id) trans_count "
					+ "FROM car_315.tb_data_present_apply t1 "
							+ "LEFT JOIN car_315.tb_data_trans_info t2 ON t1.owner_phone=t2.phone "
							+ "LEFT JOIN car_315.dbo_are_catalog t3 ON t1.city_buy = t3.catalogid "
							+ "LEFT JOIN car_315.tb_data_trans_info t4 ON t1.owner_phone=t4.phone AND t1.transid=0 AND t4.id NOT IN (SELECT transid FROM car_315.tb_data_present_apply WHERE transid>0) "
							+ "LEFT JOIN (SELECT tb2.id, tb1.giving_name FROM car_315.tb_data_trans_info tb1, car_315.tb_data_present_apply tb2 WHERE tb1.id=tb2.transid) t5 ON t1.id=t5.id "
							+ "LEFT JOIN car_315.tb_data_trans_info t6 ON t1.transid=t6.id "
					+ whereString
					+ " GROUP BY t1.id "
					+ "ORDER BY t1.id DESC LIMIT "+ page*pageNum +","+ pageNum +" ";
		System.out.println(sql);
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			resultList = new ArrayList<Map<String,String>>();
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("apply_id", String.valueOf(rs.getInt("apply_id")));
				map.put("owner_name", rs.getString("owner_name"));
				map.put("owner_phone", rs.getString("owner_phone"));
				map.put("owner_carcode", rs.getString("owner_carcode"));
				map.put("owner_address", rs.getString("owner_address"));
				map.put("owner_idcode", rs.getString("owner_idcode"));
				if (rs.getDate("travelcard_date")==null) {
					map.put("travelcard_date", null);
				}else {
					map.put("travelcard_date", rs.getDate("travelcard_date").toString());
				}
				
				if (rs.getDate("carbill_date")==null) {
					map.put("carbill_date", null);
				}else {
					map.put("carbill_date", rs.getDate("carbill_date").toString());
				}
				
				map.put("giftverify_img", rs.getString("giftverify_img"));
				map.put("carbill_img", rs.getString("carbill_img"));
				map.put("travelcard_img", rs.getString("travelcard_img"));
				map.put("idcard_img", rs.getString("idcard_img"));
				map.put("car_img", rs.getString("car_img"));
				map.put("owner_remark", rs.getString("owner_remark"));
				map.put("remark", rs.getString("remark"));
				map.put("apply_state", String.valueOf(rs.getInt("apply_state")));
				map.put("giving_name", rs.getString("giving_name"));
				map.put("vin_num", rs.getString("vin_num"));
				map.put("engine_num", rs.getString("engine_num"));
				map.put("trans_id", String.valueOf(rs.getInt("trans_id")));
				if (rs.getDate("apply_date")==null) {
					map.put("apply_date", null);
				}else {
					map.put("apply_date", rs.getDate("apply_date").toString());
				}
				map.put("trans_count", rs.getString("trans_count"));
				map.put("gift_examine_state", String.valueOf(rs.getInt("gift_examine_state")));
				map.put("verify_transid", String.valueOf(rs.getInt("verify_transid")));
				map.put("postbill_code", rs.getString("postbill_code"));
				map.put("transid_original", rs.getInt("transid_original")+"");
				
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

	public int updateCarMsg(Map<String, String> map) {
		int result = EXECUTE_FAIL;
		
		String sql = "";
		if (map.get("carmsg_type").equals("engine")) {
			sql = "UPDATE car_315.tb_data_present_apply "
				+ "SET engine_num = '"+ map.get("engine_num") +"' "
				+ "WHERE id = " + map.get("apply_id");
		}else if (map.get("carmsg_type").equals("vin")) {
			sql = "UPDATE car_315.tb_data_present_apply "
				+ "SET vin_num = '"+ map.get("vin_num") +"' "
				+ "WHERE id = " + map.get("apply_id");
		}else if (map.get("carmsg_type").equals("all")) {
			sql = "UPDATE car_315.tb_data_present_apply "
				+ "SET vin_num = '"+ map.get("vin_num") +"', engine_num = '"+ map.get("engine_num") +"' "
				+ "WHERE id = " + map.get("apply_id");
		}else {
			return result;
		}
		System.out.println(sql);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect();
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			dbc.close();
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

	public int updateRemark(Map<String, String> map) {
		int result = EXECUTE_FAIL;
		
		String sql = "UPDATE car_315.tb_data_present_apply "
					+ "SET remark = '"+ map.get("remark") +"' "
					+ "WHERE id = " + map.get("apply_id");
		System.out.println(sql);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect();
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			dbc.close();
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

	public int updateState(Map<String, String> map) {
		int result = EXECUTE_FAIL;
		
		String sql = "UPDATE car_315.tb_data_present_apply "
				+ "SET apply_state = '"+ map.get("apply_state") +"' "
				+ "WHERE id = " + map.get("apply_id");
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect();
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			dbc.close();
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

	public String checkCarMsg(Map<String, String> map) {
		String resultString = "";
		
		String sql = "SELECT `name`,phone FROM car_315.tb_data_trans_info "
					+ "WHERE engine_num='"+ map.get("engine_num") +"' AND VIN_num='"+ map.get("vin_num") +"' AND id<>"+ map.get("trans_id");
		System.out.println(sql);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				resultString = "信息重复：成交车主姓名：" + rs.getString("name") + "  手机号：" + rs.getString("phone");
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
		return resultString;
	}

	public List<Map<String, String>> getPresentByPhone(String apply_id) {
		List<Map<String, String>> resultList = null;
		
		String sql = "SELECT t1.id, t1.giving_name "
					+ "FROM car_315.tb_data_trans_info t1, car_315.tb_data_present_apply t2 "
					+ "WHERE t1.phone = t2.owner_phone AND t2.id="+ apply_id +" "
							+ "AND t1.id NOT IN (SELECT transid FROM car_315.tb_data_present_apply WHERE transid>0)";
		
		System.out.println(sql);
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			resultList = new ArrayList<Map<String,String>>();
			while(rs.next()){
				Map<String, String> map = new HashMap<String, String>();
				map.put("trans_id", String.valueOf(rs.getInt("id")));
				map.put("giving_name", rs.getString("giving_name"));
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

	public int setPresentForApply(Map<String, String> map) {
		int result = EXECUTE_FAIL;
		
		String sql = "UPDATE car_315.tb_data_present_apply "
					+ "SET transid = "+ map.get("trans_id") +" "
					+ "WHERE id = " + map.get("apply_id");
		
		System.out.println(sql);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect();
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			dbc.close();
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

	public int getPagesForApplyList(Map<String, String> mapWhere) {
		int pages = 0;
		int rows;
		
		StringBuffer sqlWhere = new StringBuffer();
		String whereString = "";
		
		if (mapWhere != null) {
			if (mapWhere.get("state")!=null && mapWhere.get("state").length()!=0){
				sqlWhere.append("t1.apply_state = "+ mapWhere.get("state") +" AND ");
			}
			if (mapWhere.get("owner_name")!=null && mapWhere.get("owner_name").length()!=0){
				sqlWhere.append("t1.owner_name = '"+ mapWhere.get("owner_name") +"' AND ");
			}
			if (mapWhere.get("owner_phone")!=null && mapWhere.get("owner_phone").length()!=0){
				sqlWhere.append("t1.owner_phone = '"+ mapWhere.get("owner_phone") +"' AND ");
			}
			if (mapWhere.get("owner_carcode")!=null && mapWhere.get("owner_carcode").length()!=0){
				sqlWhere.append("t1.owner_carcode = '"+ mapWhere.get("owner_carcode") +"' AND ");
			}
			if (mapWhere.get("prov")!=null && mapWhere.get("prov").length()!=0){
				sqlWhere.append("t3.fatherid = "+ mapWhere.get("prov") +" AND ");
			}
			if (mapWhere.get("city")!=null && mapWhere.get("city").length()!=0){
				sqlWhere.append("t3.catalogid = "+ mapWhere.get("city") +" AND ");
			}
			
			if (mapWhere.get("gift_examine_state")!=null && mapWhere.get("gift_examine_state").length()!=0){
				sqlWhere.append("t6.gift_examine_state = "+ mapWhere.get("gift_examine_state") +" AND ");
			}
			
			if ("1".equals(mapWhere.get("org_code"))) {
				sqlWhere.append("t3.catalogid NOT IN (SELECT t1.catalogid FROM car_315.dbo_are_catalog t1, finance.tb_fin_org t2 WHERE (t1.catalogid=t2.ORG_COMMENT OR t1.fatherid=t2.ORG_COMMENT) AND t2.ORG_ID!=1) AND ");
			}else {
				sqlWhere.append("t3.catalogid IN (SELECT t1.catalogid FROM car_315.dbo_are_catalog t1 WHERE t1.catalogid="+ mapWhere.get("org_comment") +" OR t1.fatherid="+ mapWhere.get("org_comment") +") AND ");
			}
			
//			if (mapWhere.get("cityfatherid").equals("0")) {
//				sqlWhere.append("t3.fatherid = "+ mapWhere.get("cityid") +" AND ");
//			}else {
//				sqlWhere.append("t1.city_buy = "+ mapWhere.get("cityid") +" AND ");
//			}
			
		}
		
		sqlWhere.append("t1.is_del=0 AND ");
		
		if (sqlWhere.length()>0) {
			whereString = sqlWhere.toString();
			whereString = whereString.substring(0, whereString.length()-4);
		}
		
		String sql = "SELECT COUNT(t1.id) apply_count "
					+ "FROM car_315.tb_data_present_apply t1 "
						+ "LEFT JOIN car_315.dbo_are_catalog t3 ON t1.city_buy = t3.catalogid "
						+ "LEFT JOIN car_315.tb_data_trans_info t6 ON t1.transid=t6.id "
					+ "WHERE "
					+ whereString;
		System.out.println(sql);
		
		int pageNum = Integer.valueOf(mapWhere.get("pageNum"));
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			rs.next();
			rows = rs.getInt("apply_count");
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

	public Map<String, String> getUserCityId(String userid) {
		Map<String, String> resultMap = null;
		
		
		String org_name = null;
		int org_id = 0;
		String sql = "SELECT t2.ORG_ID, t2.ORG_NAME "
					+ "FROM finance.tb_fin_user t1, finance.tb_fin_org t2 "
					+ "WHERE t1.USER_CODE='"+ userid +"' AND t1.ORG_CODE=t2.ORG_ID AND t1.ISONJOB=0";
		System.out.println(sql);
		DBConnect dbc = null;
		ResultSet rs = null;
		try {
			dbc = new DBConnect(sql);
			rs = dbc.executeQuery();
			if (rs.next()) {
				org_id = rs.getInt("ORG_ID");
				org_name = rs.getString("ORG_NAME");
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
		
		org_name = org_name.substring(0, org_name.length()-1);
		
		sql = "SELECT catalogid,fatherid FROM car_315.dbo_are_catalog WHERE catalogname LIKE '%"+ org_name +"%'";
		System.out.println(sql);
		try {
			dbc = new DBConnect(sql);
			rs = dbc.executeQuery();
			if (rs.next()) {
				resultMap = new HashMap<String, String>();
				resultMap.put("cityid", rs.getInt("catalogid")+"");
				resultMap.put("fatherid", rs.getInt("fatherid")+"");
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

	public int updatePostBill(Map<String, String> map) {
		int result = EXECUTE_FAIL;
		
		String sql = "UPDATE car_315.tb_data_present_apply "
					+ "SET postbill_code = '"+ map.get("postbill_code") +"' "
					+ "WHERE id = " + map.get("apply_id");
		
		System.out.println(sql);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect();
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			dbc.close();
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
	
}
