package com.poly.dao.subDaos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import car_daos.DBConnect;

public class TbApplyDetailSubDao {
	HashMap<String, Object> map = null;
	public List<HashMap<String, Object>> getApplyDetail(int start,int rows,String sid,int ulevel,String name,String bgtime,String edtime) {
		DBConnect dbc = null;
		String str  = "";
		if(ulevel==2||ulevel==3)
			str = "and  (t4.ulevel = "+ulevel+" and t4.sub_sites_id = "+sid+") ";
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String sql1 = "SELECT t1.*,t2.nickname,t3.name,t3.phone from tb_apply_detail t1 join dbo_dnt_users t2 on t1.uid  = t2.uid join tb_apply_info t3 on t1.applyid = t3.id join dbo_dnt_userlevel t4 on t1.uid = t4.uid where t1.addtime "
				+ "between '"+bgtime+"' "
				+ "and '"+edtime+"' "
				+ str
				+ " and t2.nickname like '%"+name+"%' "
				+ " ORDER BY addtime DESC limit?,?";
		String sql2 = "SELECT count(*) count from tb_apply_detail t1 join dbo_dnt_users t2 on t1.uid  = t2.uid  join tb_apply_info t3 on t1.applyid = t3.id join dbo_dnt_userlevel t4 on t1.uid = t4.uid where t1.addtime "
				+ "between '"+bgtime+"' "
				+ "and '"+edtime+"' "
				+ " and t2.nickname like '%"+name+"%' "
				+ str;
		int count = 0;
		try {
			dbc = new DBConnect(sql2);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
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
			dbc = new DBConnect(sql1);
			dbc.setInt(1, start);
			dbc.setInt(2, rows);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("count", count);
				map.put("id", rs.getString("id"));
				map.put("type", rs.getString("type").equals("1")?"删除":"恢复");
				map.put("remark", rs.getString("remark"));
				map.put("addtime", rs.getString("addtime"));
				map.put("name", rs.getString("name"));
				map.put("phone", rs.getString("phone"));
				map.put("nickname", rs.getString("nickname"));
				map.put("applyid", rs.getString("applyid"));
				result.add(map);
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
		return result;

	}
}
