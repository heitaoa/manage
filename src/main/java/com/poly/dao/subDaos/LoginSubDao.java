package com.poly.dao.subDaos;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import car_daos.DBConnect;

public class LoginSubDao {
	
	public String checkLogin(String username){
		DBConnect dbc = null;
		String result = "";
		String sql = "SELECT password from dbo_dnt_users WHERE username=?";
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, username);
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				result = rs.getString("password");
			}
		}  catch (Exception e) {
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
	
	public Map<String,Object> getUserInfo(String username){
		Map<String,Object> result = new HashMap<String,Object>();
		DBConnect dbc = null;
		String sql = "SELECT a.uid,a.secques,a.spaceid,b.ulevel,a.username,a.nickname,a.password,a.pass,a.gender,b.sub_sites_id FROM dbo_dnt_users a INNER JOIN dbo_dnt_userlevel b ON a.uid = b.uid WHERE a.username = ?";
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, username);
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				result.put("spaceid", rs.getString("spaceid"));
				result.put("ulevel", rs.getString("ulevel"));
				result.put("username", rs.getString("username"));
				result.put("nickname", rs.getString("nickname"));
				result.put("uid", rs.getString("uid"));
				result.put("password", rs.getString("password"));
				result.put("gender", rs.getString("gender")==null?"0":rs.getString("gender"));
				result.put("brands", rs.getString("pass")==null?"": rs.getString("pass"));//�ֹܵ�Ʒ��
				result.put("secques", rs.getString("secques")==null?"-1":rs.getString("secques"));
				result.put("sub_sites_id", rs.getInt("sub_sites_id"));
			}
		}  catch (Exception e) {
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
