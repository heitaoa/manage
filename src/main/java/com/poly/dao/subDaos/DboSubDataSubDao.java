package com.poly.dao.subDaos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.util.DateUtils;

import car_beans.DboSubData;
import car_daos.DBConnect;
import car_daos.DboSubDataDao;

public class DboSubDataSubDao extends DboSubDataDao {

	public static Map<String, List<DboSubData>> queryPagesubDataBySid(int sid)
			throws Exception {
		String sql = "select * from dbo_sub_data a, dbo_sub_content b where b.parent_id=? and a.sid=b.id and a.isdelete=0 order by sortid desc";
		DBConnect connect = null;
		try {
			connect = new DBConnect(sql);
			connect.setInt(1, sid);
			ResultSet rs = connect.executeQuery();

			Map<String, List<DboSubData>> dataMap = new HashMap<String, List<DboSubData>>();
			List<DboSubData> subDatas = null;
			while (rs.next()) {
				String pname = rs.getString("pname");
				subDatas = dataMap.get(pname);
				if (subDatas == null) {
					subDatas = new ArrayList<DboSubData>();
					dataMap.put(pname, subDatas);
				}
				DboSubData dbosubdata = new DboSubData();
				fill(rs, dbosubdata);
				subDatas.add(dbosubdata);
			}
			return dataMap;
		} finally {
			if (connect != null) {
				connect.close();
			}
		}
	}

	public static Map<String, List<DboSubData>> queryIndexDATA()
			throws Exception {
		String sql = "select a.pname,b.* from dbo_sub_content a,dbo_sub_data b where parent_id=1 and a.id=b.sid and b.isdelete=0 order by sortid desc";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();

			Map<String, List<DboSubData>> resultMap = new HashMap<String, List<DboSubData>>();
			while (rs.next()) {
				String pname = rs.getString("pname");
				List<DboSubData> contents = resultMap.get(pname);
				if (contents == null) {
					contents = new ArrayList<DboSubData>();
					resultMap.put(pname, contents);
				}
				DboSubData content = new DboSubData();
				fill(rs, content);
				contents.add(content);
			}
			return resultMap;
		} finally {
			if (dbc != null) {
				dbc.close();
			}
		}
	}

	public static int nextVal(String tName) throws Exception {
		DBConnect dbc = null;
		try {
			String sql = "select _nextval(?) as val";
			dbc = new DBConnect(sql);
			dbc.setString(1, tName);
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				return rs.getInt("val");
			} else {
				throw new Exception("no sequence for " + tName);
			}
		} finally {
			if (dbc != null) {
				dbc.close();
			}
		}
	}

	public static int getId() throws Exception {
		return nextVal("dbo_sub_data");
	}

	public static void updateData(DboSubData subData) throws Exception {
		DBConnect dbc = null;
		try {
			String sql = "update dbo_sub_data set title=?,content=?,pic=?,"
					+ "link=?,ctitle=?,clink=?,color=?,bold=?,link_back=? where id=?";
			dbc = new DBConnect(sql);
			dbc.setString(1, subData.getTitle());
			dbc.setString(2, subData.getContent());
			dbc.setString(3, subData.getPic());
			dbc.setString(4, subData.getLink());
			dbc.setString(5, subData.getCtitle());
			dbc.setString(6, subData.getClink());
			dbc.setString(7, subData.getColor());
			dbc.setInt(8, subData.getBold());
			dbc.setString(9, subData.getLink_back());
			dbc.setInt(10, subData.getId());
			dbc.executeUpdate();
		} finally {
			if (dbc != null) {
				dbc.close();
			}
		}

	}

	public static void changeSorted(int id0, int id1) throws Exception {
		String sql = "select id,sortid from dbo_sub_data where id=? or id=? ";
		DBConnect dbc = new DBConnect(sql);
		dbc.setInt(1, id0);
		dbc.setInt(2, id1);
		ResultSet rs = dbc.executeQuery();
		Map<Integer, Integer> mappings = new HashMap<Integer, Integer>();
		while (rs.next()) {
			mappings.put(rs.getInt("id"), rs.getInt("sortid"));
		}
		String now = DateUtils.getNow();
//		System.out.println("================>>"+now);
		sql = "update dbo_sub_data set sortid=? , adddate='"+now+"' where id=?";
		dbc = new DBConnect(sql);
		dbc.setInt(1, mappings.get(id0));
		dbc.setInt(2, id1);
		dbc.addBatch();

		dbc.setInt(1, mappings.get(id1));
		dbc.setInt(2, id0);
		dbc.addBatch();

		dbc.executeBatch();
	}

	public static void deleteDataById(int id) throws Exception {
		String now = DateUtils.getNow();
//		System.out.println("================>>"+now);
		String sql = "update dbo_sub_data set isdelete=1 , adddate='"+now+"' where id=?";
		DBConnect dbc = new DBConnect(sql);
		dbc.setInt(1, id);
		dbc.executeUpdate();
	}

	public static int deleteDataBatch(int retainCount, int sid)
			throws Exception {
		String now = DateUtils.getNow();
		String sql = "update dbo_sub_data set isdelete=1, adddate='"+now+"' where id not in("
				+ "select m.id from"
				+ " (select id from dbo_sub_data where sid=? order by adddate desc limit 0,?) m"
				+ ") and sid=?";
		DBConnect dbc = new DBConnect(sql);
		dbc.setInt(1, sid);
		dbc.setInt(2, retainCount);
		dbc.setInt(3, sid);
		return dbc.executeUpdateReturnInt();
	}

	public static void updateDataSad(int isad, int id) throws Exception {
		String now = DateUtils.getNow();
		String sql = "update dbo_sub_data set isad=? , adddate='"+now+"' where id=?";
		DBConnect dbc = new DBConnect(sql);
		dbc.setInt(1, isad);
		dbc.setInt(2, id);
		dbc.executeUpdate();
	}

}
