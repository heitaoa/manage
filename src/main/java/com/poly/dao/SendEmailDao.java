package com.poly.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class SendEmailDao {

	public List<Map<String, Object>> getManagerInfo() throws SQLException {
		String sql = "select t1.USER_NAME as name,t2.ORG_COMMENT as aid,t2.ORG_NAME as orgname,t1.TELEPHONE as phone from finance.tb_fin_user t1,finance.tb_fin_org t2 where   user_role = 4  and ISONJOB  = 0 and t1.ORG_CODE = t2.ORG_ID    ";
		return DAOUtil2.executeQuery(sql, null);
	}
	
	public String getAreaidInfo(String aid) throws SQLException {
		String sql = "select catalogid from dbo_are_catalog  where fatherid =" + aid;
		
		String result = "";
		
		List<Map<String,Object>> maps = DAOUtil.executeQuery(sql, null);
		
		for (Map<String, Object> map : maps) {
			result += "'" + map.get("catalogid").toString() + "',";
		}
		result += "'" + aid + "'";
		return result;
	}

	public List<Map<String, Object>> getSubstationInfo() throws SQLException {
		String sql = "select t.*,t1.dis_name from  finance.tb_fin_org t , finance.tb_fin_district t1 where t.DIS_ID = t1.dis_id "; 
		return DAOUtil2.executeQuery(sql, null);
	}

	public List<Map<String, Object>> getSubManagerInfo(String bid) throws SQLException {
		String sql = "select t1.USER_NAME as name,t1.TELEPHONE as phone,t1.ORG_CODE as org_code from finance.tb_fin_user t1 where   user_role = 4  and ISONJOB  = 0 and t1.USER_NAME != '张群智' and t1.ORG_CODE ="+bid;
		return DAOUtil2.executeQuery(sql, null);
	}

	public List<Map<String, Object>> getAreaInfo() throws SQLException {
		String sql = "SELECT t1.USER_NAME as name,t1.TELEPHONE as phone,t1.USER_DIS dis FROM finance.tb_fin_user t1 WHERE ISONJOB = 0 AND t1.user_dis IS NOT NULL AND t1.user_dis != '##' AND t1.USER_ROLE = 4";
		return DAOUtil2.executeQuery(sql, null);
	}
	
}
