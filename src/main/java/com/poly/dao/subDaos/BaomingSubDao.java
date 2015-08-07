package com.poly.dao.subDaos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.poly.util.StringUtils;

import car_daos.DBConnect;

public class BaomingSubDao {
	/**
	 * 获取推广项目
	 * 
	 * @param pro_nums
	 *            所拥有的推广项目编号
	 * @param uleve
	 *            uleve=4 客服 ulevel = 0 管理员
	 * @param pstatus
	 * @return
	 */
	public List<Map<String, String>> queryTuiguangInfo(String pro_nums,
			String uleve, int pstatus) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		String sql = "SELECT t1.pro_state,t1.iway,pro_num,acti_name,competing,competing_name,promo_start_date,promo_end_date,brand as 'brandId',t2.catalogname as 'brandName',car as 'chexiId',t3.catalogname as 'chexiName',model as 'chexingId',t4.catalogname as 'chexingName',promo_prov as 'provId',CASE promo_prov WHEN -1 THEN '全国'  ELSE  t5.catalogname END 'provName',promo_city as 'cityId',t6.catalogname as 'cityName' from tb_data_project t1 LEFT OUTER JOIN dbo_car_catalognew t2 on t1.brand = t2.catalogid LEFT OUTER JOIN dbo_car_catalognew t3 on t1.car = t3.catalogid LEFT OUTER JOIN dbo_car_catalognew t4 on t1.model = t4.catalogid LEFT OUTER  join dbo_are_catalog t5 on t1.promo_prov = t5.catalogid LEFT OUTER JOIN dbo_are_catalog t6 on t1.promo_city = t6.catalogid where 1=1";
		// if("3".equals(uleve) ||"2".equals(uleve) )
		// sql += " and pro_num in ("+formatSqlIn(pro_nums)+")";
		// else if(!"0".equals(uleve))
		// return list;
		if (uleve.contains("0")) {

		} else {
			sql += " and pro_num in (" + formatSqlIn(pro_nums) + ")";
		}

		if (pstatus == 1)
			sql += " and pro_state in (3,100) order by ini_date desc";
		if (pstatus == 2)
			sql += " and pro_state = 5 order by ini_date desc";
		if (pstatus == 3)
			sql += " and pro_state in (3,5,100) order by ini_date desc";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("pro_num", formatStr(rs.getString("pro_num")));
				map.put("pro_state", formatStr(rs.getString("pro_state")));
				map.put("acti_name", formatStr(rs.getString("acti_name")));
				map.put("promo_start_date",
						formatStr(rs.getString("promo_start_date")));
				map.put("promo_end_date",
						formatStr(rs.getString("promo_end_date")));
				map.put("brandId", formatStr(rs.getString("brandId")));
				map.put("brandName", formatStr(rs.getString("brandName")));
				map.put("chexiId", formatStr(rs.getString("chexiId")));
				map.put("chexiName", formatStr(rs.getString("chexiName")));
				map.put("chexingId", formatStr(rs.getString("chexingId")));
				map.put("chexingName", formatStr(rs.getString("chexingName")));
				map.put("provId", formatStr(rs.getString("provId")));
				map.put("provName", formatStr(rs.getString("provName")));
				map.put("cityId", formatStr(rs.getString("cityId")));
				map.put("cityName", formatStr(rs.getString("cityName")));
				map.put("competing", formatStr(rs.getString("competing")));
				map.put("iway", formatStr(rs.getString("iway")));
				map.put("competing_name",
						formatStr(rs.getString("competing_name")));
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

	public List<Map<String, String>> queryTuiguangInfoByPro(String pro_nums,
			String uleve, int pstatus, String pro_num) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		String sql = "SELECT t1.pro_state,t1.iway,pro_num,acti_name,competing,competing_name,promo_start_date,promo_end_date,brand as 'brandId',t2.catalogname as 'brandName',car as 'chexiId',t3.catalogname as 'chexiName',model as 'chexingId',t4.catalogname as 'chexingName',promo_prov as 'provId',CASE promo_prov WHEN -1 THEN '全国'  ELSE  t5.catalogname END 'provName',promo_city as 'cityId',t6.catalogname as 'cityName' from tb_data_project t1 LEFT OUTER JOIN dbo_car_catalognew t2 on t1.brand = t2.catalogid LEFT OUTER JOIN dbo_car_catalognew t3 on t1.car = t3.catalogid LEFT OUTER JOIN dbo_car_catalognew t4 on t1.model = t4.catalogid LEFT OUTER  join dbo_are_catalog t5 on t1.promo_prov = t5.catalogid LEFT OUTER JOIN dbo_are_catalog t6 on t1.promo_city = t6.catalogid where 1=1";
		// if("3".equals(uleve) ||"2".equals(uleve) )
		// sql += " and pro_num in ("+formatSqlIn(pro_nums)+")";
		// else if(!"0".equals(uleve))
		// return list;

		sql += " and pro_num = '" + pro_num + "'";
		// if(uleve.contains("0")){
		//
		// }else if(uleve.contains("2") || uleve.contains("3")){
		// sql += " and pro_num in ("+formatSqlIn(pro_nums)+")";
		// }else
		// return list;
		if (pstatus == 1)
			sql += " and pro_state in (3,100) order by ini_date desc";
		if (pstatus == 2)
			sql += " and pro_state = 5 order by ini_date desc";
		if (pstatus == 3)
			sql += " and pro_state in (3,5,100) order by ini_date desc";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("pro_num", formatStr(rs.getString("pro_num")));
				map.put("iway", formatStr(rs.getString("iway")));
				map.put("pro_state", formatStr(rs.getString("pro_state")));
				map.put("acti_name", formatStr(rs.getString("acti_name")));
				map.put("promo_start_date",
						formatStr(rs.getString("promo_start_date")));
				map.put("promo_end_date",
						formatStr(rs.getString("promo_end_date")));
				map.put("brandId", formatStr(rs.getString("brandId")));
				map.put("brandName", formatStr(rs.getString("brandName")));
				map.put("chexiId", formatStr(rs.getString("chexiId")));
				map.put("chexiName", formatStr(rs.getString("chexiName")));
				map.put("chexingId", formatStr(rs.getString("chexingId")));
				map.put("chexingName", formatStr(rs.getString("chexingName")));
				map.put("provId", formatStr(rs.getString("provId")));
				map.put("provName", formatStr(rs.getString("provName")));
				map.put("cityId", formatStr(rs.getString("cityId")));
				map.put("cityName", formatStr(rs.getString("cityName")));
				map.put("competing", formatStr(rs.getString("competing")));
				map.put("competing_name",
						formatStr(rs.getString("competing_name")));
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

	String formatStr(String str) {
		if (str == null)
			return "";
		else
			return str;
	}

	String formatSqlIn(String str) {
		String result = "";
		if (str == null || str.length() == 0)
			return result;
		String[] strs = str.split(",");
		for (String id : strs) {
			if (id.length() > 0) {
				result += "'" + id + "',";
			}
		}
		if (result.length() > 0)
			result = result.substring(0, result.length() - 1);
		return result;
	}

	String formatSqlIn2(String str) {
		String result = "";
		if (str == null || str.length() == 0)
			return result;
		String[] strs = str.split(",");
		for (String id : strs) {

			if (id.length() > 0) {
				String[] ids = id.split("-");

				result += "'" + ids[1] + "',";

			}
		}
		if (result.length() > 0)
			result = result.substring(0, result.length() - 1);
		return result;
	}

	String formatSqlIn3(String str) {
		String result = "";
		String result2 = "";
		List<Map<String, String>> maps = new ArrayList<Map<String, String>>();
		if (str == null || str.length() == 0)
			return ")";
		String[] strs = str.split(",");
		for (String id : strs) {
			Map<String, String> map = new HashMap<String, String>();
			String[] ids;
			if (id.contains("①")) {
				ids = id.split("①");
			} else {
				// String[] ids = id.split("-");
				ids = id.split("-");
			}
			map.put("brand", ids[0]);
			map.put("serial", ids[1]);
			maps.add(map);
		}
		String brand = "";
		String serial = "";
		for (int i = 0; i < maps.size(); i++) {
			Map<String, String> m = maps.get(i);
			if ("0".equals(m.get("serial"))) {
				brand += ("'" + m.get("brand") + "',");
				// result +=
				// " or (t1.serial in (select catalogid  from dbo_car_catalognew where iway = '"+m.get("brand")+"' and pathlevel = 2 and isdelete = 0))";
			} else {
				serial += (m.get("serial") + ",");
				// result += " or ( t1.serial = "+m.get("serial")+")";
			}
		}
		if (brand.length() > 0) {
			brand = brand.substring(0, brand.length() - 1);
			result = "or (t1.serial in (select catalogid  from dbo_car_catalognew where iway in ("
					+ brand + ") and pathlevel = 2 and isdelete = 0))";
		}
		if (serial.length() > 0) {
			serial = serial.substring(0, serial.length() - 1);
			result2 = " or ( t1.serial in (" + serial + "))";
		}

		result = result + result2 + ")";

		return result;
	}

	String formatSqlIn4(String str) {
		String result = "";
		List<Map<String, String>> maps = new ArrayList<Map<String, String>>();
		if (str == null || str.length() == 0)
			return "t11.brand = 0 )";
		String[] strs = str.split(",");
		for (String id : strs) {
			Map<String, String> map = new HashMap<String, String>();
			String[] ids = id.split("-");
			map.put("brand", ids[0]);
			map.put("serial", ids[1]);
			maps.add(map);
		}

		for (int i = 0; i < maps.size(); i++) {
			Map<String, String> m = maps.get(i);
			if (i == 0) {
				if ("0".equals(m.get("serial"))) {
					result += "  (t1.brand = " + m.get("brand") + ")";
				} else {
					result += "  (t1.brand = " + m.get("brand")
							+ " and t1.serial = " + m.get("serial") + ")";
				}
			} else {
				if ("0".equals(m.get("serial"))) {
					result += " or (t1.brand = " + m.get("brand") + ")";
				} else {
					result += " or (t1.brand = " + m.get("brand")
							+ " and t1.serial = " + m.get("serial") + ")";
				}
			}
		}

		result += ")";

		return result;
	}

	// /sql
	/*
	 * SELECT t1.id,t1.name,t1.phone,t1.baoming_date,t2.catalogname as
	 * 'brandName',t3.catalogname as 'chexiName',t4.catalogname as 'provName'
	 * ,t5.catalogname 'cityName' from tb_data_baoming t1 LEFT OUTER JOIN
	 * dbo_car_catalognew t2 on t1.brand = t2.catalogid LEFT OUTER JOIN
	 * dbo_car_catalognew t3 on t1.serial = t3.catalogid LEFT OUTER JOIN
	 * dbo_are_catalog t4 on t1.prov = t4.catalogid LEFT OUTER JOIN
	 * dbo_are_catalog t5 on t1.city = t5.catalogid where t1.baoming_date
	 * BETWEEN '2015-01-01' and '2015-06-01' and t1.`name` like '%张%' and
	 * t1.phone like '%%' and t1.return_visit_state = 0 and t1.buycar_emergency
	 * = 0 and t1.is_key_cus = 0 and t1.phoneerror = 0 and t1.prov = 9 and
	 * t1.city = 0 and t1.brand = 85 #and t1.serial = #and t1.model = GROUP BY
	 * t1.phone ORDER BY t1.baoming_date DESC
	 */

	public List<Map<String, String>> queryKCTBaoming(String name, String phone,
			String beginDate, String endDate, int return_visit_state,
			int buycar_emergency, int is_key_cus, int phoneerror, int provId,
			int cityId, int brandId, int chexiId, int chexingId, int prefIndex,
			int size, String iway, int prov3, int city3, int chexiId3,
			String iway3,int apply_source,int buy_status) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT t1.real_type,t1.id,t1.name,t1.phone,date_format(t1.baoming_date,'%Y-%m-%d %H:%i:%s') baoming_date,t2.catalogname as 'brandName',t3.catalogname as 'chexiName',t4.catalogname as 'provName' ,t5.catalogname 'cityName' , t1.remarks , t1.phoneerror_count ,t1.constacterror_count ,t1.remarks from tb_data_baoming t1 LEFT OUTER JOIN dbo_car_catalognew t2 on t1.brand = t2.catalogid LEFT OUTER JOIN dbo_car_catalognew t3 on t1.serial = t3.catalogid");
		sql.append(" LEFT OUTER JOIN dbo_are_catalog t4 on t1.prov = t4.catalogid LEFT OUTER JOIN dbo_are_catalog t5 on t1.city = t5.catalogid where ");
		sql.append(" t1.baoming_date BETWEEN '" + beginDate + "' and '"
				+ endDate + "' ");
		if (!"".equals(name))
			sql.append(" and t1.`name` like '%" + name + "%' ");
		if (!"".equals(phone))
			sql.append(" and t1.phone like '%" + phone + "%' ");
		sql.append(" and t1.return_visit_state = " + return_visit_state);
		if (buycar_emergency != -1)
			sql.append(" and t1.buycar_emergency = " + buycar_emergency);
		if (is_key_cus != -1)
			sql.append(" and t1.is_key_cus = " + is_key_cus);
		if (phoneerror == 1)
			sql.append(" and t1.phoneerror = " + phoneerror);
		sql.append(" and t1.isDelete = 0 ");
		if(buy_status != -1){
			sql.append(" and t1.is_buycar ="+buy_status);
		}
		if(apply_source != -1){
			sql.append(" and t1.real_type ="+apply_source);
		}
		if (provId != -1) {
			sql.append(" and t1.prov =" + provId);
			if (cityId != -1)
				sql.append("  and t1.city =" + cityId);
		}
		if (prov3 != -1) {
			sql.append(" and t1.prov =" + prov3);
			if (city3 != -1)
				sql.append("  and t1.city =" + city3);
		}
		if (null == iway3 || "".equals(iway3)) {

		} else {
			if (chexiId3 == 0 || chexiId3 == -1) {
				sql.append(" and  t1.serial in (select distinct CATALOGID  from dbo_car_catalognew t22 where t22.iway = '"
						+ iway3 + "' and t22.pathlevel = 2)");
			} else {
				sql.append(" and  t1.serial =" + chexiId3);
				if (chexingId != -1)
					sql.append(" and  t1.model =" + chexingId);
			}
		}

		if (null == iway || "".equals(iway)) {

		} else {
			if (chexiId == 0 || chexiId == -1) {
				sql.append(" and  t1.serial in (select distinct fatherid  from dbo_car_catalognew t22 where t22.iway = '"
						+ iway + "' and t22.pathlevel = 3)");
			} else {
				sql.append(" and  t1.serial =" + chexiId);
				if (chexingId != -1)
					sql.append(" and  t1.model =" + chexingId);
			}
		}

		sql.append(" ORDER BY t1.baoming_date DESC,t1.phone  limit "
				+ prefIndex + " , " + size);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("id", formatStr(rs.getString("id")));
				map.put("name", formatStr(rs.getString("name")));
				String pcode = formatStr(rs.getString("phone"));
				pcode = pcode.substring(0, 3) + "****" + pcode.substring(7);
				map.put("real_type", formatStr(rs.getString("real_type")));
				map.put("phone", formatStr(rs.getString("phone")));
				map.put("baoming_date", formatStr(rs.getString("baoming_date")));
				map.put("brandName", formatStr(rs.getString("brandName")));
				map.put("chexiName", formatStr(rs.getString("chexiName")));
				map.put("provName", formatStr(rs.getString("provName")));
				map.put("cityName", formatStr(rs.getString("cityName")));
				map.put("phoneerror_count",
						formatStr(rs.getString("phoneerror_count")));
				map.put("constacterror_count",
						formatStr(rs.getString("constacterror_count")));
				map.put("remarks", formatStr(rs.getString("remarks")));
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

	public List<Map<String, String>> queryKCTBaoming01(String name,
			String phone, String beginDate, String endDate,
			int return_visit_state, int buycar_emergency, int is_key_cus,
			int phoneerror, int provId, int cityId, int brandId, int chexiId,
			int chexingId, int prefIndex, int size, String iway, int prov3,
			int city3, int chexiId3, String iway3, String provs, String citys,int apply_source,int buy_status) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT t1.real_type,t1.id,t1.name,t1.phone,date_format(t1.baoming_date,'%Y-%m-%d %H:%i:%s') baoming_date,t2.catalogname as 'brandName',t3.catalogname as 'chexiName',t4.catalogname as 'provName' ,t5.catalogname 'cityName' , t1.remarks , t1.phoneerror_count ,t1.constacterror_count ,t1.remarks from tb_data_baoming t1 LEFT OUTER JOIN dbo_car_catalognew t2 on t1.brand = t2.catalogid LEFT OUTER JOIN dbo_car_catalognew t3 on t1.serial = t3.catalogid");
		sql.append(" LEFT OUTER JOIN dbo_are_catalog t4 on t1.prov = t4.catalogid LEFT OUTER JOIN dbo_are_catalog t5 on t1.city = t5.catalogid where ");
		sql.append(" t1.baoming_date BETWEEN '" + beginDate + "' and '"
				+ endDate + "' ");
		if (!"".equals(name))
			sql.append(" and t1.`name` like '%" + name + "%' ");
		if (!"".equals(phone))
			sql.append(" and t1.phone like '%" + phone + "%' ");
		sql.append(provs);
		sql.append(citys);
		sql.append(" and t1.return_visit_state = " + return_visit_state);
		if (buycar_emergency != -1)
			sql.append(" and t1.buycar_emergency = " + buycar_emergency);
		if (is_key_cus != -1)
			sql.append(" and t1.is_key_cus = " + is_key_cus);
		if (phoneerror == 1)
			sql.append(" and t1.phoneerror = " + phoneerror);
		sql.append(" and t1.isDelete = 0 ");
		if(buy_status != -1){
			sql.append(" and t1.is_buycar ="+buy_status);
		}
		if(apply_source != -1){
			sql.append(" and t1.real_type ="+apply_source);
		}
		if (provId != -1) {
			sql.append(" and t1.prov =" + provId);
			if (cityId != -1)
				sql.append("  and t1.city =" + cityId);
		}
		if (prov3 != -1) {
			sql.append(" and t1.prov =" + prov3);
			if (city3 != -1)
				sql.append("  and t1.city =" + city3);
		}
		if (null == iway3 || "".equals(iway3)) {

		} else {
			if (chexiId3 == 0 || chexiId3 == -1) {
				sql.append(" and  t1.serial in (select distinct CATALOGID  from dbo_car_catalognew t22 where t22.iway = '"
						+ iway3 + "' and t22.pathlevel = 2)");
			} else {
				sql.append(" and  t1.serial =" + chexiId3);
				if (chexingId != -1)
					sql.append(" and  t1.model =" + chexingId);
			}
		}

		if (null == iway || "".equals(iway)) {

		} else {
			if (chexiId == 0 || chexiId == -1) {
				sql.append(" and  t1.serial in (select distinct fatherid  from dbo_car_catalognew t22 where t22.iway = '"
						+ iway + "' and t22.pathlevel = 3)");
			} else {
				sql.append(" and  t1.serial =" + chexiId);
				if (chexingId != -1)
					sql.append(" and  t1.model =" + chexingId);
			}
		}

		sql.append(" ORDER BY t1.baoming_date DESC,t1.phone  limit "
				+ prefIndex + " , " + size);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("id", formatStr(rs.getString("id")));
				map.put("name", formatStr(rs.getString("name")));
				String pcode = formatStr(rs.getString("phone"));
				pcode = pcode.substring(0, 3) + "****" + pcode.substring(7);
				map.put("real_type", formatStr(rs.getString("real_type")));
				map.put("phone", formatStr(rs.getString("phone")));
				map.put("baoming_date", formatStr(rs.getString("baoming_date")));
				map.put("brandName", formatStr(rs.getString("brandName")));
				map.put("chexiName", formatStr(rs.getString("chexiName")));
				map.put("provName", formatStr(rs.getString("provName")));
				map.put("cityName", formatStr(rs.getString("cityName")));
				map.put("phoneerror_count",
						formatStr(rs.getString("phoneerror_count")));
				map.put("constacterror_count",
						formatStr(rs.getString("constacterror_count")));
				map.put("remarks", formatStr(rs.getString("remarks")));
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

	public int queryKCTBaomingCount(String name, String phone,
			String beginDate, String endDate, int return_visit_state,
			int buycar_emergency, int is_key_cus, int phoneerror, int provId,
			int cityId, int brandId, int chexiId, int chexingId, String iway,
			int prov3, int city3, int chexiId3, String iway3,int apply_source,int buy_status) {
		int count = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(1) 'count' from tb_data_baoming t1 where");
		sql.append(" t1.baoming_date BETWEEN '" + beginDate + "' and '"
				+ endDate + "' ");
		if (!"".equals(name))
			sql.append(" and t1.`name` like '%" + name + "%' ");
		if (!"".equals(phone))
			sql.append(" and t1.phone like '%" + phone + "%' ");
		sql.append(" and t1.return_visit_state = " + return_visit_state);
		if (buycar_emergency != -1)
			sql.append(" and t1.buycar_emergency = " + buycar_emergency);
		if (is_key_cus != -1)
			sql.append(" and t1.is_key_cus = " + is_key_cus);
		if (phoneerror == 1)
			sql.append(" and t1.phoneerror = " + phoneerror);
		sql.append(" and t1.isDelete = 0 ");
		if(buy_status != -1){
			sql.append(" and t1.is_buycar ="+buy_status);
		}
		if(apply_source != -1){
			sql.append(" and t1.real_type ="+apply_source);
		}
		// sql.append(whereSql);
		if (provId != -1) {
			sql.append(" and t1.prov =" + provId);
			if (cityId != -1)
				sql.append("  and t1.city =" + cityId);
		}
		if (prov3 != -1) {
			sql.append(" and t1.prov =" + prov3);
			if (city3 != -1)
				sql.append("  and t1.city =" + city3);
		}
		if (null == iway3 || "".equals(iway3)) {

		} else {
			if (chexiId3 == 0 || chexiId3 == -1) {
				sql.append(" and  t1.serial in (select distinct CATALOGID  from dbo_car_catalognew t22 where t22.iway = '"
						+ iway3 + "' and t22.pathlevel = 2)");
			} else {
				sql.append(" and  t1.serial =" + chexiId3);
				if (chexingId != -1)
					sql.append(" and  t1.model =" + chexingId);
			}
		}
		// if(brandId != -1){
		// sql.append(" and  t1.brand ="+brandId);
		// if(chexiId != -1){
		// sql.append(" and  t1.serial ="+chexiId);
		// if(chexingId != -1)
		// sql.append(" and  t1.model ="+chexingId);
		// }
		// }
		if (null == iway || "".equals(iway)) {

		} else {
			if (chexiId == 0 || chexiId == -1) {
				sql.append(" and  t1.serial in (select distinct fatherid  from dbo_car_catalognew t22 where t22.iway = '"
						+ iway + "' and t22.pathlevel = 3)");
			} else {
				sql.append(" and  t1.serial =" + chexiId);
				if (chexingId != -1)
					sql.append(" and  t1.model =" + chexingId);
			}
		}
		sql.append(" ORDER BY t1.baoming_date DESC,t1.phone ");
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
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

	public int queryKCTBaomingCount01(String name, String phone,
			String beginDate, String endDate, int return_visit_state,
			int buycar_emergency, int is_key_cus, int phoneerror, int provId,
			int cityId, int brandId, int chexiId, int chexingId, String iway,
			int prov3, int city3, int chexiId3, String iway3, String provs,
			String citys,int apply_source,int buy_status) {
		int count = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(1) 'count' from tb_data_baoming t1 where");
		sql.append(" t1.baoming_date BETWEEN '" + beginDate + "' and '"
				+ endDate + "' ");
		if (!"".equals(name))
			sql.append(" and t1.`name` like '%" + name + "%' ");
		if (!"".equals(phone))
			sql.append(" and t1.phone like '%" + phone + "%' ");
		sql.append(provs);
		sql.append(citys);
		sql.append(" and t1.return_visit_state = " + return_visit_state);
		if (buycar_emergency != -1)
			sql.append(" and t1.buycar_emergency = " + buycar_emergency);
		if (is_key_cus != -1)
			sql.append(" and t1.is_key_cus = " + is_key_cus);
		if (phoneerror == 1)
			sql.append(" and t1.phoneerror = " + phoneerror);
		sql.append(" and t1.isDelete = 0 ");
		if(buy_status != -1){
			sql.append(" and t1.is_buycar ="+buy_status);
		}
		if(apply_source != -1){
			sql.append(" and t1.real_type ="+apply_source);
		}
		// sql.append(whereSql);
		if (provId != -1) {
			sql.append(" and t1.prov =" + provId);
			if (cityId != -1)
				sql.append("  and t1.city =" + cityId);
		}
		if (prov3 != -1) {
			sql.append(" and t1.prov =" + prov3);
			if (city3 != -1)
				sql.append("  and t1.city =" + city3);
		}
		if (null == iway3 || "".equals(iway3)) {

		} else {
			if (chexiId3 == 0 || chexiId3 == -1) {
				sql.append(" and  t1.serial in (select distinct CATALOGID  from dbo_car_catalognew t22 where t22.iway = '"
						+ iway3 + "' and t22.pathlevel = 2)");
			} else {
				sql.append(" and  t1.serial =" + chexiId3);
				if (chexingId != -1)
					sql.append(" and  t1.model =" + chexingId);
			}
		}
		// if(brandId != -1){
		// sql.append(" and  t1.brand ="+brandId);
		// if(chexiId != -1){
		// sql.append(" and  t1.serial ="+chexiId);
		// if(chexingId != -1)
		// sql.append(" and  t1.model ="+chexingId);
		// }
		// }
		if (null == iway || "".equals(iway)) {

		} else {
			if (chexiId == 0 || chexiId == -1) {
				sql.append(" and  t1.serial in (select distinct fatherid  from dbo_car_catalognew t22 where t22.iway = '"
						+ iway + "' and t22.pathlevel = 3)");
			} else {
				sql.append(" and  t1.serial =" + chexiId);
				if (chexingId != -1)
					sql.append(" and  t1.model =" + chexingId);
			}
		}
		sql.append(" ORDER BY t1.baoming_date DESC,t1.phone ");
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
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

	public List<Map<String, String>> queryKCTBaoming2(String name,
			String phone, String beginDate, String endDate,
			int return_visit_state, int buycar_emergency, int is_key_cus,
			int phoneerror, String prov, String city, String brands,
			int prefIndex, int size, String iway, int iserial) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT t1.id,t1.name,t1.phone,date_format(t1.baoming_date,'%Y-%m-%d %H:%i:%s') baoming_date,t2.catalogname as 'brandName',t3.catalogname as 'chexiName',t4.catalogname as 'provName' ,t5.catalogname 'cityName' , t1.remarks , t1.phoneerror_count,t1.constacterror_count ,t1.remarks from tb_data_baoming t1 LEFT OUTER JOIN dbo_car_catalognew t2 on t1.brand = t2.catalogid LEFT OUTER JOIN dbo_car_catalognew t3 on t1.serial = t3.catalogid");
		sql.append(" LEFT OUTER JOIN dbo_are_catalog t4 on t1.prov = t4.catalogid LEFT OUTER JOIN dbo_are_catalog t5 on t1.city = t5.catalogid where ");
		sql.append(" t1.baoming_date BETWEEN '" + beginDate + "' and '"
				+ endDate + "' ");
		if (!"".equals(name))
			sql.append(" and t1.`name` like '%" + name + "%' ");
		if (!"".equals(phone))
			sql.append(" and t1.phone like '%" + phone + "%' ");
		sql.append(" and t1.return_visit_state = " + return_visit_state);
		if (buycar_emergency != -1)
			sql.append(" and t1.buycar_emergency = " + buycar_emergency);
		if (is_key_cus != -1)
			sql.append(" and t1.is_key_cus = " + is_key_cus);
		if (phoneerror == 1)
			sql.append(" and t1.phoneerror = " + phoneerror);
		sql.append(" and t1.isDelete = 0 ");
		if (Integer.parseInt(prov) != -1) {
			sql.append(" and t1.prov =" + prov);
			if (Integer.parseInt(city) != -1)
				sql.append("  and t1.city =" + city);
		}

		if (null == iway || "".equals(iway)) {

			if (null != brands && !"-1".equals(brands) && !"".equals(brands)) {
				sql.append(" and  t1.serial in (select distinct fatherid  from dbo_car_catalognew where iway in ("
						+ formatSqlIn(brands) + ") and pathlevel = 3)");

			}
		} else {
			if (iserial == 0 || iserial == -1) {
				sql.append(" and  t1.serial in (select distinct fatherid  from dbo_car_catalognew where iway = '"
						+ iway + "' and pathlevel = 3)");
			} else {
				sql.append(" and  t1.serial =" + iserial);
			}
		}

		sql.append(" ORDER BY t1.baoming_date DESC,t1.phone  limit "
				+ prefIndex + " , " + size);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("id", formatStr(rs.getString("id")));
				map.put("name", formatStr(rs.getString("name")));
				String pcode = formatStr(rs.getString("phone"));
				pcode = pcode.substring(0, 3) + "****" + pcode.substring(7);

				map.put("phone", formatStr(rs.getString("phone")));
				map.put("baoming_date", formatStr(rs.getString("baoming_date")));
				map.put("brandName", formatStr(rs.getString("brandName")));
				map.put("chexiName", formatStr(rs.getString("chexiName")));
				map.put("provName", formatStr(rs.getString("provName")));
				map.put("cityName", formatStr(rs.getString("cityName")));
				map.put("phoneerror_count",
						formatStr(rs.getString("phoneerror_count")));
				map.put("constacterror_count",
						formatStr(rs.getString("constacterror_count")));
				map.put("remarks", formatStr(rs.getString("remarks")));
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

	public int queryKCTBaoming2Count(String name, String phone,
			String beginDate, String endDate, int return_visit_state,
			int buycar_emergency, int is_key_cus, int phoneerror, String prov,
			String city, String brands, String iway, int iserial) {
		int count = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(1) 'count' from tb_data_baoming t1 where");
		sql.append(" t1.baoming_date BETWEEN '" + beginDate + "' and '"
				+ endDate + "' ");
		if (!"".equals(name))
			sql.append(" and t1.`name` like '%" + name + "%' ");
		if (!"".equals(phone))
			sql.append(" and t1.phone like '%" + phone + "%' ");
		sql.append(" and t1.return_visit_state = " + return_visit_state);
		if (buycar_emergency != -1)
			sql.append(" and t1.buycar_emergency = " + buycar_emergency);
		if (is_key_cus != -1)
			sql.append(" and t1.is_key_cus = " + is_key_cus);
		sql.append(" and t1.phoneerror = " + phoneerror);
		sql.append(" and t1.isDelete = 0 ");
		// sql.append(whereSql);
		if (Integer.parseInt(prov) != -1) {
			sql.append(" and t1.prov =" + prov);
			if (Integer.parseInt(city) != -1)
				sql.append("  and t1.city =" + city);
		}
		if (null == iway || "".equals(iway)) {

			if (null != brands && !"-1".equals(brands) && !"".equals(brands)) {
				sql.append(" and  t1.serial in (select distinct fatherid  from dbo_car_catalognew where iway in ("
						+ formatSqlIn(brands) + ") and pathlevel = 3)");

			}
		} else {
			if (iserial == 0 || iserial == -1) {
				sql.append(" and  t1.serial in (select distinct fatherid  from dbo_car_catalognew where iway = '"
						+ iway + "' and pathlevel = 3)");
			} else {
				sql.append(" and  t1.serial =" + iserial);
			}
		}
		sql.append(" ORDER BY t1.baoming_date DESC,t1.phone ");
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
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

	public List<Map<String, String>> querySatisfy(String pro_num, int state,
			String beginDate, String endDate, String name, String phone,
			String keyword, int brandId, int chexiId, int prov, int city,
			int start, int rows, String iway) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		StringBuffer sql1 = new StringBuffer();
		StringBuffer sql2 = new StringBuffer();
		sql1.append("select t1.satisfy_state,t1.record_id,t1.`name`,t1.phone,t3.catalogname as prov,t4.catalogname as city,t1.is_reach,t1.is_trans,t2.catalogname,t1.research,t1.not_store_reason,t1.lose_reason,t1.satisfy,t1.advise from tb_data_visit_record t1 left join dbo_car_catalognew t2 on t1.model = t2.catalogid join dbo_are_catalog t3 on t1.prov = t3.catalogid left join dbo_are_catalog t4 on t1.city = t4.catalogid where 1=1 ");
		sql2.append("select count(1) count from tb_data_visit_record t1 left join dbo_car_catalognew t2 on t1.serial = t2.catalogid join dbo_are_catalog t3 on t1.prov = t3.catalogid left join dbo_are_catalog t4 on t1.city = t4.catalogid where 1=1 ");
		sql1.append(" and t1.return_visit_time between  '" + beginDate
				+ "' and '" + endDate + "' ");
		sql2.append(" and t1.return_visit_time between  '" + beginDate
				+ "' and '" + endDate + "' ");
		if (!"".equals(name)) {
			sql1.append(" and t1.name like '%" + name + "%'");
			sql2.append(" and t1.name like '%" + name + "%'");
		}
		if (!"".equals(phone)) {
			sql1.append(" and t1.phone like '%" + phone + "%'");
			sql2.append(" and t1.phone like '%" + phone + "%'");
		}
		if (null == iway || "".equals(iway)) {

		} else {
			if (chexiId == 0 || chexiId == -1) {
				sql1.append(" and  t1.serial in (select distinct fatherid  from dbo_car_catalognew where iway = '"
						+ iway + "' and pathlevel = 3)");
				sql2.append(" and  t1.serial in (select distinct fatherid  from dbo_car_catalognew where iway = '"
						+ iway + "' and pathlevel = 3)");
			} else {
				sql1.append(" and  t1.serial =" + chexiId);
				sql2.append(" and  t1.serial =" + chexiId);
			}
		}
		if (prov != -1) {
			sql1.append(" and t1.prov = " + prov);
			sql2.append(" and t1.prov = " + prov);
		}
		if (city != -1) {
			sql1.append(" and t1.city = " + city);
			sql2.append(" and t1.city = " + city);
		}
		if (state != -1) {
			sql1.append(" and t1.satisfy_state = " + state);
			sql2.append(" and t1.satisfy_state = " + state);
		}

		sql1.append(" and t1.pro_num = '" + pro_num + "'");
		sql2.append(" and t1.pro_num = '" + pro_num + "'");

		sql1.append(" order by t1.return_visit_time desc  limit " + start + ","
				+ rows);
		DBConnect dbc = null;
		int count = 0;
		try {
			dbc = new DBConnect(sql2.toString());
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (dbc != null) {
				try {
					dbc.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		try {
			dbc = new DBConnect(sql1.toString());
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("record_id", rs.getString("record_id"));
				map.put("name", rs.getString("name"));
				map.put("phone", rs.getString("phone"));
				map.put("prov", rs.getString("prov"));
				map.put("city", rs.getString("city"));
				map.put("is_reach", rs.getString("is_reach"));
				map.put("is_trans", rs.getString("is_trans"));
				map.put("catalogname", rs.getString("catalogname"));
				map.put("research", rs.getString("research"));
				map.put("not_store_reason", rs.getString("not_store_reason"));
				map.put("lose_reason", rs.getString("lose_reason"));
				map.put("satisfy", rs.getString("satisfy"));
				map.put("advise", rs.getString("advise"));
				map.put("satisfy_state", rs.getString("satisfy_state"));
				map.put("count", count + "");
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (dbc != null) {
				try {
					dbc.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public Map<String, Object> querySatisfyDetail(Integer sid) {
		Map<String, Object> map = new HashMap<String, Object>();
		String sql = "select t1.record_id,t1.`name`,t1.phone,t3.catalogname as prov,t4.catalogname as city,t1.is_reach,t1.is_trans,t2.catalogname,t1.research,t1.not_store_reason,t1.lose_reason,t1.satisfy,t1.advise from tb_data_visit_record t1 left join dbo_car_catalognew t2 on t1.serial = t2.catalogid left join dbo_are_catalog t3 on t1.prov = t3.catalogid left join dbo_are_catalog t4 on t1.city = t4.catalogid where record_id = ?";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect();
			dbc.prepareStatement(sql);
			dbc.setInt(1, sid);
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				map.put("record_id", rs.getString("record_id"));
				map.put("name", rs.getString("name"));
				map.put("phone", rs.getString("phone"));
				map.put("prov", rs.getString("prov"));
				map.put("city", rs.getString("city"));
				map.put("is_reach", rs.getString("is_reach"));
				map.put("is_trans", rs.getString("is_trans"));
				map.put("catalogname", rs.getString("catalogname"));
				map.put("research", rs.getString("research"));
				map.put("not_store_reason", rs.getString("not_store_reason"));
				map.put("lose_reason", rs.getString("lose_reason"));
				map.put("satisfy", rs.getString("satisfy"));
				map.put("advise", rs.getString("advise"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (dbc != null) {
				try {
					dbc.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return map;
	}

	public List<Map<String, String>> queryKCTBaoming3(String name,
			String phone, String beginDate, String endDate,
			int return_visit_state, int buycar_emergency, int is_key_cus,
			int phoneerror, int provId, int cityId, int brandId, int chexiId,
			int chexingId, int prefIndex, int size, String competing,
			String iway, int prov3, int city3, int chexiId3, String iway3,int apply_source,int buy_status) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT t1.real_type,t1.id,t1.name,t1.phone,date_format(t1.baoming_date,'%Y-%m-%d %H:%i:%s') baoming_date,t2.catalogname as 'brandName',t3.catalogname as 'chexiName',t4.catalogname as 'provName' ,t5.catalogname 'cityName' , t1.remarks , t1.phoneerror_count ,t1.constacterror_count ,t1.remarks from tb_data_baoming t1 LEFT OUTER JOIN dbo_car_catalognew t2 on t1.brand = t2.catalogid LEFT OUTER JOIN dbo_car_catalognew t3 on t1.serial = t3.catalogid");
		sql.append(" LEFT OUTER JOIN dbo_are_catalog t4 on t1.prov = t4.catalogid LEFT OUTER JOIN dbo_are_catalog t5 on t1.city = t5.catalogid where ");
		sql.append(" DATE_FORMAT(t1.baoming_date,'%Y-%m-%d') BETWEEN '"
				+ beginDate + "' and '" + endDate + "' ");
		if (!"".equals(name))
			sql.append(" and t1.`name` like '%" + name + "%' ");
		if (!"".equals(phone))
			sql.append(" and t1.phone like '%" + phone + "%' ");
		sql.append(" and t1.return_visit_state = " + return_visit_state);
		if (buycar_emergency != -1)
			sql.append(" and t1.buycar_emergency = " + buycar_emergency);
		if (is_key_cus != -1)
			sql.append(" and t1.is_key_cus = " + is_key_cus);
		if (phoneerror == 1)
			sql.append(" and t1.phoneerror = " + phoneerror);
		sql.append(" and t1.isDelete = 0 ");
		if(buy_status != -1){
			sql.append(" and t1.is_buycar ="+buy_status);
		}
		if(apply_source != -1){
			sql.append(" and t1.real_type ="+apply_source);
		}
		if (provId != -1) {
			sql.append(" and t1.prov =" + provId);
			if (cityId != -1)
				sql.append("  and t1.city =" + cityId);
		}
		if (prov3 != -1) {
			sql.append(" and t1.prov =" + prov3);
			if (city3 != -1)
				sql.append("  and t1.city =" + city3);
		}
		if (null == iway3 || "".equals(iway3)) {

		} else {
			if (chexiId3 == 0 || chexiId3 == -1) {
				sql.append(" and  t1.serial in (select distinct CATALOGID  from dbo_car_catalognew t22 where t22.iway = '"
						+ iway3 + "' and t22.pathlevel = 2)");
			} else {
				sql.append(" and  t1.serial =" + chexiId3);
				if (chexingId != -1)
					sql.append(" and  t1.model =" + chexingId);
			}
		}
		// if(brandId != -1){
		// sql.append(" and (( t1.brand ="+brandId);
		// if(chexiId != -1){
		// sql.append(" and  t1.serial ="+chexiId);
		// if(chexingId != -1){
		// sql.append(" and  t1.model ="+chexingId+")");
		// }else{
		// sql.append(")");
		// }
		// }else{
		// sql.append(")");
		// }
		// }
		//
		// sql.append(formatSqlIn3(competing));

		if (null == iway || "".equals(iway)) {

		} else {
			if (chexiId == 0 || chexiId == -1) {
				sql.append(" and (( t1.serial in (select distinct CATALOGID  from dbo_car_catalognew t22 where t22.iway = '"
						+ iway + "' and t22.pathlevel = 2))");
			} else {
				sql.append(" and (( t1.serial =" + chexiId);
				if (chexingId != -1)
					sql.append(" and  t1.model =" + chexingId + ")");
				else
					sql.append(")");
			}
			sql.append(formatSqlIn3(competing));
		}

		sql.append(" ORDER BY t1.baoming_date DESC,t1.phone  limit "
				+ prefIndex + " , " + size);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("id", formatStr(rs.getString("id")));
				map.put("name", formatStr(rs.getString("name")));
				String pcode = formatStr(rs.getString("phone"));
				pcode = pcode.substring(0, 3) + "****" + pcode.substring(7);
				map.put("real_type", formatStr(rs.getString("real_type")));
				map.put("phone", formatStr(rs.getString("phone")));
				map.put("baoming_date", formatStr(rs.getString("baoming_date")));
				map.put("brandName", formatStr(rs.getString("brandName")));
				map.put("chexiName", formatStr(rs.getString("chexiName")));
				map.put("provName", formatStr(rs.getString("provName")));
				map.put("cityName", formatStr(rs.getString("cityName")));
				map.put("phoneerror_count",
						formatStr(rs.getString("phoneerror_count")));
				map.put("constacterror_count",
						formatStr(rs.getString("constacterror_count")));
				map.put("remarks", formatStr(rs.getString("remarks")));
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

	public List<Map<String, String>> queryKCTBaoming31(String name,
			String phone, String beginDate, String endDate,
			int return_visit_state, int buycar_emergency, int is_key_cus,
			int phoneerror, int provId, int cityId, int brandId, int chexiId,
			int chexingId, int prefIndex, int size, String competing,
			String iway, int prov3, int city3, int chexiId3, String iway3,
			String provs, String citys,int apply_source,int buy_status) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT t1.real_type,t1.id,t1.name,t1.phone,date_format(t1.baoming_date,'%Y-%m-%d %H:%i:%s') baoming_date,t2.catalogname as 'brandName',t3.catalogname as 'chexiName',t4.catalogname as 'provName' ,t5.catalogname 'cityName' , t1.remarks , t1.phoneerror_count ,t1.constacterror_count ,t1.remarks from tb_data_baoming t1 LEFT OUTER JOIN dbo_car_catalognew t2 on t1.brand = t2.catalogid LEFT OUTER JOIN dbo_car_catalognew t3 on t1.serial = t3.catalogid");
		sql.append(" LEFT OUTER JOIN dbo_are_catalog t4 on t1.prov = t4.catalogid LEFT OUTER JOIN dbo_are_catalog t5 on t1.city = t5.catalogid where ");
		sql.append(" DATE_FORMAT(t1.baoming_date,'%Y-%m-%d') BETWEEN '"
				+ beginDate + "' and '" + endDate + "' ");
		if (!"".equals(name))
			sql.append(" and t1.`name` like '%" + name + "%' ");
		if (!"".equals(phone))
			sql.append(" and t1.phone like '%" + phone + "%' ");
		sql.append(provs);
		sql.append(citys);
		sql.append(" and t1.return_visit_state = " + return_visit_state);
		if (buycar_emergency != -1)
			sql.append(" and t1.buycar_emergency = " + buycar_emergency);
		if (is_key_cus != -1)
			sql.append(" and t1.is_key_cus = " + is_key_cus);
		if (phoneerror == 1)
			sql.append(" and t1.phoneerror = " + phoneerror);
		sql.append(" and t1.isDelete = 0 ");
		if(buy_status != -1){
			sql.append(" and t1.is_buycar ="+buy_status);
		}
		if(apply_source != -1){
			sql.append(" and t1.real_type ="+apply_source);
		}
		if (provId != -1) {
			sql.append(" and t1.prov =" + provId);
			if (cityId != -1)
				sql.append("  and t1.city =" + cityId);
		}
		if (prov3 != -1) {
			sql.append(" and t1.prov =" + prov3);
			if (city3 != -1)
				sql.append("  and t1.city =" + city3);
		}
		if (null == iway3 || "".equals(iway3)) {

		} else {
			if (chexiId3 == 0 || chexiId3 == -1) {
				sql.append(" and  t1.serial in (select distinct CATALOGID  from dbo_car_catalognew t22 where t22.iway = '"
						+ iway3 + "' and t22.pathlevel = 2)");
			} else {
				sql.append(" and  t1.serial =" + chexiId3);
				if (chexingId != -1)
					sql.append(" and  t1.model =" + chexingId);
			}
		}
		// if(brandId != -1){
		// sql.append(" and (( t1.brand ="+brandId);
		// if(chexiId != -1){
		// sql.append(" and  t1.serial ="+chexiId);
		// if(chexingId != -1){
		// sql.append(" and  t1.model ="+chexingId+")");
		// }else{
		// sql.append(")");
		// }
		// }else{
		// sql.append(")");
		// }
		// }
		//
		// sql.append(formatSqlIn3(competing));

		if (null == iway || "".equals(iway)) {

		} else {
			if (chexiId == 0 || chexiId == -1) {
				sql.append(" and (( t1.serial in (select distinct CATALOGID  from dbo_car_catalognew t22 where t22.iway = '"
						+ iway + "' and t22.pathlevel = 2))");
			} else {
				sql.append(" and (( t1.serial =" + chexiId);
				if (chexingId != -1)
					sql.append(" and  t1.model =" + chexingId + ")");
				else
					sql.append(")");
			}
			sql.append(formatSqlIn3(competing));
		}

		sql.append(" ORDER BY t1.baoming_date DESC,t1.phone  limit "
				+ prefIndex + " , " + size);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("id", formatStr(rs.getString("id")));
				map.put("name", formatStr(rs.getString("name")));
				String pcode = formatStr(rs.getString("phone"));
				pcode = pcode.substring(0, 3) + "****" + pcode.substring(7);
				map.put("real_type", formatStr(rs.getString("real_type")));
				map.put("phone", formatStr(rs.getString("phone")));
				map.put("baoming_date", formatStr(rs.getString("baoming_date")));
				map.put("brandName", formatStr(rs.getString("brandName")));
				map.put("chexiName", formatStr(rs.getString("chexiName")));
				map.put("provName", formatStr(rs.getString("provName")));
				map.put("cityName", formatStr(rs.getString("cityName")));
				map.put("phoneerror_count",
						formatStr(rs.getString("phoneerror_count")));
				map.put("constacterror_count",
						formatStr(rs.getString("constacterror_count")));
				map.put("remarks", formatStr(rs.getString("remarks")));
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

	public int queryKCTBaomingCount3(String name, String phone,
			String beginDate, String endDate, int return_visit_state,
			int buycar_emergency, int is_key_cus, int phoneerror, int provId,
			int cityId, int brandId, int chexiId, int chexingId,
			String competing, String iway, int prov3, int city3, int chexiId3,
			String iway3,int apply_source,int buy_status) {
		int count = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(1) 'count' from tb_data_baoming t1 where");
		sql.append(" DATE_FORMAT(t1.baoming_date,'%Y-%m-%d') BETWEEN '"
				+ beginDate + "' and '" + endDate + "' ");
		if (!"".equals(name))
			sql.append(" and t1.`name` like '%" + name + "%' ");
		if (!"".equals(phone))
			sql.append(" and t1.phone like '%" + phone + "%' ");
		sql.append(" and t1.return_visit_state = " + return_visit_state);
		if (buycar_emergency != -1)
			sql.append(" and t1.buycar_emergency = " + buycar_emergency);
		if (is_key_cus != -1)
			sql.append(" and t1.is_key_cus = " + is_key_cus);
		if (phoneerror == 1)
			sql.append(" and t1.phoneerror = " + phoneerror);
		sql.append(" and t1.isDelete = 0 ");
		if(buy_status != -1){
			sql.append(" and t1.is_buycar ="+buy_status);
		}
		if(apply_source != -1){
			sql.append(" and t1.real_type ="+apply_source);
		}
		// sql.append(whereSql);
		if (provId != -1) {
			sql.append(" and t1.prov =" + provId);
			if (cityId != -1)
				sql.append("  and t1.city =" + cityId);
		}
		if (prov3 != -1) {
			sql.append(" and t1.prov =" + prov3);
			if (city3 != -1)
				sql.append("  and t1.city =" + city3);
		}
		if (null == iway3 || "".equals(iway3)) {

		} else {
			if (chexiId3 == 0 || chexiId3 == -1) {
				sql.append(" and  t1.serial in (select distinct CATALOGID  from dbo_car_catalognew t22 where t22.iway = '"
						+ iway3 + "' and t22.pathlevel = 2)");
			} else {
				sql.append(" and  t1.serial =" + chexiId3);
				if (chexingId != -1)
					sql.append(" and  t1.model =" + chexingId);
			}
		}
		// if(brandId != -1){
		// sql.append(" and (( t1.brand ="+brandId);
		// if(chexiId != -1){
		// sql.append(" and  t1.serial ="+chexiId);
		// if(chexingId != -1){
		// sql.append(" and  t1.model ="+chexingId+")");
		// }else{
		// sql.append(")");
		// }
		// }else{
		// sql.append(")");
		// }
		// }
		//
		// sql.append(formatSqlIn3(competing));
		if (null == iway || "".equals(iway)) {

		} else {
			if (chexiId == 0 || chexiId == -1) {
				sql.append(" and (( t1.serial in (select distinct CATALOGID  from dbo_car_catalognew t22 where t22.iway = '"
						+ iway + "' and t22.pathlevel = 2))");
			} else {
				sql.append(" and (( t1.serial =" + chexiId);
				if (chexingId != -1)
					sql.append(" and  t1.model =" + chexingId + ")");
				else
					sql.append(")");
			}
			sql.append(formatSqlIn3(competing));
		}

		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
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

	public int queryKCTBaomingCount31(String name, String phone,
			String beginDate, String endDate, int return_visit_state,
			int buycar_emergency, int is_key_cus, int phoneerror, int provId,
			int cityId, int brandId, int chexiId, int chexingId,
			String competing, String iway, int prov3, int city3, int chexiId3,
			String iway3, String provs, String citys,int apply_source,int buy_status) {
		int count = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(1) 'count' from tb_data_baoming t1 where");
		sql.append(" DATE_FORMAT(t1.baoming_date,'%Y-%m-%d') BETWEEN '"
				+ beginDate + "' and '" + endDate + "' ");
		if (!"".equals(name))
			sql.append(" and t1.`name` like '%" + name + "%' ");
		if (!"".equals(phone))
			sql.append(" and t1.phone like '%" + phone + "%' ");
		sql.append(provs);
		sql.append(citys);
		sql.append(" and t1.return_visit_state = " + return_visit_state);
		if (buycar_emergency != -1)
			sql.append(" and t1.buycar_emergency = " + buycar_emergency);
		if (is_key_cus != -1)
			sql.append(" and t1.is_key_cus = " + is_key_cus);
		if (phoneerror == 1)
			sql.append(" and t1.phoneerror = " + phoneerror);
		sql.append(" and t1.isDelete = 0 ");
		if(buy_status != -1){
			sql.append(" and t1.is_buycar ="+buy_status);
		}
		if(apply_source != -1){
			sql.append(" and t1.real_type ="+apply_source);
		}
		// sql.append(whereSql);
		if (provId != -1) {
			sql.append(" and t1.prov =" + provId);
			if (cityId != -1)
				sql.append("  and t1.city =" + cityId);
		}
		if (prov3 != -1) {
			sql.append(" and t1.prov =" + prov3);
			if (city3 != -1)
				sql.append("  and t1.city =" + city3);
		}
		if (null == iway3 || "".equals(iway3)) {

		} else {
			if (chexiId3 == 0 || chexiId3 == -1) {
				sql.append(" and  t1.serial in (select distinct CATALOGID  from dbo_car_catalognew t22 where t22.iway = '"
						+ iway3 + "' and t22.pathlevel = 2)");
			} else {
				sql.append(" and  t1.serial =" + chexiId3);
				if (chexingId != -1)
					sql.append(" and  t1.model =" + chexingId);
			}
		}
		// if(brandId != -1){
		// sql.append(" and (( t1.brand ="+brandId);
		// if(chexiId != -1){
		// sql.append(" and  t1.serial ="+chexiId);
		// if(chexingId != -1){
		// sql.append(" and  t1.model ="+chexingId+")");
		// }else{
		// sql.append(")");
		// }
		// }else{
		// sql.append(")");
		// }
		// }
		//
		// sql.append(formatSqlIn3(competing));
		if (null == iway || "".equals(iway)) {

		} else {
			if (chexiId == 0 || chexiId == -1) {
				sql.append(" and (( t1.serial in (select distinct CATALOGID  from dbo_car_catalognew t22 where t22.iway = '"
						+ iway + "' and t22.pathlevel = 2))");
			} else {
				sql.append(" and (( t1.serial =" + chexiId);
				if (chexingId != -1)
					sql.append(" and  t1.model =" + chexingId + ")");
				else
					sql.append(")");
			}
			sql.append(formatSqlIn3(competing));
		}

		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
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

	public List<Map<String, String>> queryTuiguangInfoByPage(String pro_nums,
			String uleve, int pstatus, String beginDate, String endDate,
			String name, String phone, String keyword, int brandId,
			int chexiId, int prov, int city, int start, int rows, String iway2,
			int ywtype) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		String sql = "SELECT (select count(phone) from tb_data_visit_record t12 where t12.pro_num = t1.pro_num) as huifang_count,(select count(phone) from tb_data_visit_record t12 where t12.pro_num = t1.pro_num and t12.phone_state = 0 and t12.attend_type in (0,1,2,3,4)) as youxiao_count,pro_num,custom_service_name,ini_man as username,USER_NAME as ini_man,dep_name as ini_dept,service_type,custom_service_name,acti_start_date,pro_state,acti_end_date,tar_clue_num,acti_name,competing,competing_name,promo_start_date,promo_end_date,t1.brand as 'brandId',t2.catalogname as 'brandName',car as 'chexiId',t3.catalogname as 'chexiName',t1.model as 'chexingId',t4.catalogname as 'chexingName',promo_prov as 'provId',CASE promo_prov WHEN -1 THEN '全国'  ELSE  t5.catalogname END 'provName',promo_city as 'cityId',t6.catalogname as 'cityName',t1.iway from tb_data_project t1 LEFT OUTER JOIN dbo_car_catalognew t2 on t1.brand = t2.catalogid LEFT OUTER JOIN dbo_car_catalognew t3 on t1.car = t3.catalogid LEFT OUTER JOIN dbo_car_catalognew t4 on t1.model = t4.catalogid LEFT OUTER  join dbo_are_catalog t5 on t1.promo_prov = t5.catalogid LEFT OUTER JOIN dbo_are_catalog t6 on t1.promo_city = t6.catalogid LEFT OUTER JOIN finance.tb_fin_dep t7 on t1.ini_dept = t7.DEP_ID LEFT JOIN finance.tb_fin_user t8 ON t1.ini_man=t8.USER_CODE "
				+ "   where 1=1";
		String sql2 = "SELECT count(1) as count from tb_data_project t1 LEFT OUTER JOIN dbo_car_catalognew t2 on t1.brand = t2.catalogid LEFT OUTER JOIN dbo_car_catalognew t3 on t1.car = t3.catalogid LEFT OUTER JOIN dbo_car_catalognew t4 on t1.model = t4.catalogid LEFT OUTER  join dbo_are_catalog t5 on t1.promo_prov = t5.catalogid LEFT OUTER JOIN dbo_are_catalog t6 on t1.promo_city = t6.catalogid LEFT OUTER JOIN finance.tb_fin_dep t7 on t1.ini_dept = t7.DEP_ID LEFT JOIN finance.tb_fin_user t8 ON t1.ini_man=t8.USER_CODE  where 1=1";
		if (uleve.contains("0")) {

		} else {
			sql += " and pro_num in (" + formatSqlIn(pro_nums) + ")";
			sql2 += " and pro_num in (" + formatSqlIn(pro_nums) + ")";
		}

		sql += " and DATE_FORMAT(t1.promo_start_date,'%Y-%m-%d') BETWEEN '"
				+ beginDate + "' and '" + endDate + "' ";
		sql2 += " and DATE_FORMAT(t1.promo_start_date,'%Y-%m-%d') BETWEEN '"
				+ beginDate + "' and '" + endDate + "' ";

		if (!"".equals(name)) {
			sql += " and t8.`USER_NAME` like '%" + name + "%' ";
			sql2 += " and t8.`USER_NAME` like '%" + name + "%' ";
		}

		if (null == iway2 || "".equals(iway2)) {

		} else {
			sql += " and t1.iway = '" + iway2 + "'";
			sql2 += " and t1.iway = '" + iway2 + "'";
		}

		if (chexiId != -1) {
			sql += " and t1.car =" + chexiId;
			sql2 += " and t1.car =" + chexiId;
		}

		if (ywtype != -1) {
			sql += " and t1.service_type =" + ywtype;
			sql2 += " and t1.service_type =" + ywtype;
		}

		sql += " and pro_state in (3,5,100) order by ini_date desc";
		sql2 += " and pro_state in (3,5,100) ";

		DBConnect dbc = null;

		sql += "  limit " + start + "," + rows;

		int count = 0;
		try {
			dbc = new DBConnect(sql2.toString());
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (dbc != null) {
				try {
					dbc.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("youxiao_count",
						formatStr(rs.getString("youxiao_count")));
				map.put("iway", formatStr(rs.getString("iway")));
				map.put("huifang_count",
						formatStr(rs.getString("huifang_count")));
				map.put("pro_num", formatStr(rs.getString("pro_num")));
				map.put("username", formatStr(rs.getString("username")));
				map.put("ini_man", formatStr(rs.getString("ini_man")));
				map.put("custom_service_name",
						formatStr(rs.getString("custom_service_name")));
				map.put("ini_dept", formatStr(rs.getString("ini_dept")));
				map.put("service_type", formatStr(rs.getString("service_type")));
				map.put("custom_service_name",
						formatStr(rs.getString("custom_service_name")));
				map.put("acti_start_date",
						formatStr(rs.getString("acti_start_date")));
				map.put("acti_end_date",
						formatStr(rs.getString("acti_end_date")));
				map.put("pro_state", formatStr(rs.getString("pro_state")));
				map.put("tar_clue_num", formatStr(rs.getString("tar_clue_num")));
				map.put("acti_name", formatStr(rs.getString("acti_name")));
				map.put("promo_start_date",
						formatStr(rs.getString("promo_start_date")));
				map.put("promo_end_date",
						formatStr(rs.getString("promo_end_date")));
				map.put("brandId", formatStr(rs.getString("brandId")));
				map.put("brandName", formatStr(rs.getString("brandName")));
				map.put("chexiId", formatStr(rs.getString("chexiId")));
				map.put("chexiName", formatStr(rs.getString("chexiName")));
				map.put("chexingId", formatStr(rs.getString("chexingId")));
				map.put("chexingName", formatStr(rs.getString("chexingName")));
				map.put("provId", formatStr(rs.getString("provId")));
				map.put("provName", formatStr(rs.getString("provName")));
				map.put("cityId", formatStr(rs.getString("cityId")));
				map.put("cityName", formatStr(rs.getString("cityName")));
				map.put("competing", formatStr(rs.getString("competing")));
				map.put("competing_name",
						formatStr(rs.getString("competing_name")));
				map.put("count", count + "");
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

	public int queryJinpinCount(String competing, String promo_start_date,
			String promo_end_date, int provId, int cityId, int brandId,
			int chexiId, int chexingId, String iway) {
		int count = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("select count(t1.phone) as count from  tb_data_baoming t1 where");
		sql.append(" DATE_FORMAT(t1.baoming_date,'%Y-%m-%d') BETWEEN '"
				+ promo_start_date + "' and '" + promo_end_date + "' ");

		sql.append(" and t1.isDelete = 0 ");
		// sql.append(whereSql);
		if (provId != -1) {
			sql.append(" and t1.prov =" + provId);
			if (cityId != -1)
				sql.append("  and t1.city =" + cityId);
		}
		// if(brandId != -1){
		// sql.append(" and (( t1.brand ="+brandId);
		// if(chexiId != -1){
		// sql.append(" and  t1.serial ="+chexiId);
		// if(chexingId != -1){
		// sql.append(" and  t1.model ="+chexingId+")");
		// }else{
		// sql.append(")");
		// }
		// }else{
		// sql.append(")");
		// }
		// }
		//
		// sql.append(formatSqlIn3(competing));
		if (null == iway || "".equals(iway)) {

		} else {
			if (chexiId == 0 || chexiId == -1) {
				sql.append(" and (( t1.serial in (select distinct fatherid  from dbo_car_catalognew where iway = '"
						+ iway + "' and pathlevel = 3))");
			} else {
				sql.append(" and (( t1.serial =" + chexiId);
				if (chexingId != -1)
					sql.append(" and  t1.model =" + chexingId + ")");
				else
					sql.append(")");
			}
			sql.append(formatSqlIn3(competing));
		}

		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
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

	/**
	 * 获取分站信息
	 * 
	 * @return
	 */
	public List<Map<String, String>> where(String sql) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		String sql1 = "SELECT id,name from car.tb_sub_sites where 1=1 and "
				+ sql;
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql1);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("id", formatStr(rs.getString("id")));
				map.put("name", formatStr(rs.getString("name")));
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

	public List<Map<String, String>> querySample(String region,
			String substation, String beginDate, String endDate,
			String customerName, String iway3, int prefIndex, int size) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT t1.id,t1.name,t1.phone,date_format(t1.baoming_date,'%Y-%m-%d %H:%i:%s') baoming_date,t2.catalogname as 'brandName',t3.catalogname as 'chexiName',t4.catalogname as 'provName' ,t5.catalogname 'cityName' , t1.remarks , t1.phoneerror_count ,t1.constacterror_count ,t1.remarks from tb_data_baoming t1 LEFT OUTER JOIN dbo_car_catalognew t2 on t1.brand = t2.catalogid LEFT OUTER JOIN dbo_car_catalognew t3 on t1.serial = t3.catalogid");
		sql.append(" LEFT OUTER JOIN dbo_are_catalog t4 on t1.prov = t4.catalogid LEFT OUTER JOIN dbo_are_catalog t5 on t1.city = t5.catalogid where t1.return_visit_state!=0 and t1.is_sample=0 and");
		sql.append(" t1.baoming_date BETWEEN '" + beginDate + "' and '"
				+ endDate + "' ");
		if (null == region || "-1".equals(region)) {

		} else {
			if ("-1".equals(substation) || substation == null) {
				sql.append(" and  t1.sub_site in (select distinct id  from car.tb_sub_sites tb1 where tb1.dis_id = "
						+ region+")");
			} else {
				sql.append(" and t1.sub_site=" + substation);
			}
		}
		if (!"".equals(customerName) && customerName != null)
			sql.append(" and t1.return_visit_man like '%" + customerName
					+ "%' ");
		if (iway3 != null && !iway3.equals("-1")) {
			sql.append(" and  t1.serial in (select distinct CATALOGID  from dbo_car_catalognew t22 where t22.iway = '"
					+ iway3 + "' and t22.pathlevel = 2)");
		}
		sql.append(" ORDER BY t1.baoming_date DESC,t1.phone  limit "
				+ prefIndex + " , " + size);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("id", formatStr(rs.getString("id")));
				map.put("name", formatStr(rs.getString("name")));
				String pcode = formatStr(rs.getString("phone"));
				pcode = pcode.substring(0, 3) + "****" + pcode.substring(7);
				map.put("phone", pcode);
				map.put("baoming_date", formatStr(rs.getString("baoming_date")));
				map.put("brandName", formatStr(rs.getString("brandName")));
				map.put("chexiName", formatStr(rs.getString("chexiName")));
				map.put("provName", formatStr(rs.getString("provName")));
				map.put("cityName", formatStr(rs.getString("cityName")));
				map.put("phoneerror_count",
						formatStr(rs.getString("phoneerror_count")));
				map.put("constacterror_count",
						formatStr(rs.getString("constacterror_count")));
				map.put("remarks", formatStr(rs.getString("remarks")));
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

	public int querySampleCount(String region, String substation,
			String beginDate, String endDate, String customerName, String iway3) {
		int count = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(1) 'count' from tb_data_baoming t1 where t1.return_visit_state!=0 and t1.is_sample=0 and");
		sql.append(" t1.baoming_date BETWEEN '" + beginDate + "' and '"
				+ endDate + "' ");
		if (null == region || "-1".equals(region)) {

		} else {
			if ("-1".equals(substation) || substation == null) {
				sql.append(" and  t1.sub_site in (select distinct id  from car.tb_sub_sites tb1 where tb1.dis_id = "
						+ region+")");
			} else {
				sql.append(" and t1.sub_site=" + substation);
			}
		}
		if (!"".equals(customerName) && customerName != null)
			sql.append(" and t1.return_visit_man like '%" + customerName
					+ "%' ");
		if (iway3 != null && !iway3.equals("-1")) {
			sql.append(" and  t1.serial in (select distinct CATALOGID  from dbo_car_catalognew t22 where t22.iway = '"
					+ iway3 + "' and t22.pathlevel = 2)");
		}
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
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
	
	public int updateSample(String man,String userid,String id,String date,String samplecontent) {
		int result = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("update tb_data_baoming set ");
		sql.append(" is_sample=1,sample_man_id='"+userid+"',sample_man_name='"+man+"',sample_time='"+date+"',sample_content='"+samplecontent+"'" );
		sql.append(" where id="+id);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			result = dbc.executeUpdateReturnInt();
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
	public List<Map<String, String>> querySampleResult(String customerName,String customerName2,String beginDate,String endDate,int prefIndex,int size) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT t1.id,t1.name,t1.phone,date_format(t1.baoming_date,'%Y-%m-%d %H:%i:%s') baoming_date,t2.catalogname as 'brandName',t3.catalogname as 'chexiName',t4.catalogname as 'provName' ,t5.catalogname 'cityName' , t1.remarks , t1.phoneerror_count ,t1.constacterror_count ,t1.remarks,t1.sample_content from tb_data_baoming t1 LEFT OUTER JOIN dbo_car_catalognew t2 on t1.brand = t2.catalogid LEFT OUTER JOIN dbo_car_catalognew t3 on t1.serial = t3.catalogid");
		sql.append(" LEFT OUTER JOIN dbo_are_catalog t4 on t1.prov = t4.catalogid LEFT OUTER JOIN dbo_are_catalog t5 on t1.city = t5.catalogid where t1.return_visit_state!=0 and t1.is_sample=1 and");
		sql.append(" t1.baoming_date BETWEEN '" + beginDate + "' and '"
				+ endDate + "' ");
		if (!"".equals(customerName) && customerName != null)
			sql.append(" and t1.return_visit_man like '%" + customerName
					+ "%' ");
		if (!"".equals(customerName2) && customerName2 != null)
			sql.append(" and t1.sample_man_name like '%" + customerName2
					+ "%' ");
		sql.append(" ORDER BY t1.baoming_date DESC,t1.phone  limit "
				+ prefIndex + " , " + size);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("id", formatStr(rs.getString("id")));
				map.put("name", formatStr(rs.getString("name")));
				String pcode = formatStr(rs.getString("phone"));
				pcode = pcode.substring(0, 3) + "****" + pcode.substring(7);

				map.put("phone", pcode);
				map.put("baoming_date", formatStr(rs.getString("baoming_date")));
				map.put("brandName", formatStr(rs.getString("brandName")));
				map.put("chexiName", formatStr(rs.getString("chexiName")));
				map.put("provName", formatStr(rs.getString("provName")));
				map.put("cityName", formatStr(rs.getString("cityName")));
				map.put("phoneerror_count",
						formatStr(rs.getString("phoneerror_count")));
				map.put("constacterror_count",
						formatStr(rs.getString("constacterror_count")));
				map.put("remarks", formatStr(rs.getString("remarks")));
				map.put("sample_content",formatStr(rs.getString("sample_content")));
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

	public int querySampleResultCount(String customerName,String customerName2,String beginDate,String endDate) {
		int count = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(1) 'count' from tb_data_baoming t1 where t1.return_visit_state!=0 and t1.is_sample=1 and");
		sql.append(" t1.baoming_date BETWEEN '" + beginDate + "' and '"
				+ endDate + "' ");
		if (!"".equals(customerName) && customerName != null)
			sql.append(" and t1.return_visit_man like '%" + customerName
					+ "%' ");
		if (!"".equals(customerName2) && customerName2 != null)
			sql.append(" and t1.sample_man_name like '%" + customerName2
					+ "%' ");
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
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
	
	
}
