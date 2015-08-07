package com.poly.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import car_beans.DboContentbak;
import car_daos.DBConnect;
import car_daos.DboContentbakDao;

public class  ContentbakDao  extends DboContentbakDao {

	public static void fill(ResultSet rs, DboContentbak dbocontentbak) throws SQLException {
		dbocontentbak.setId(rs.getInt("id"));//
		dbocontentbak.setCid(rs.getInt("cid"));//
		dbocontentbak.setContentstr(rs.getString("contentstr"));//
		dbocontentbak.setAdddate(rs.getTimestamp("adddate"));//
	}

	public static List<DboContentbak> find() {
		DBConnect dbc = null;
		String sql = "select * from car_filecache.dbo_contentbak";
		List<DboContentbak> list = new ArrayList<DboContentbak>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboContentbak dbocontentbak = new DboContentbak();
				fill(rs, dbocontentbak);
				list.add(dbocontentbak);
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


	public static List<DboContentbak> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from car_filecache.dbo_contentbak where "+subsql+"";
		List<DboContentbak> list = new ArrayList<DboContentbak>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboContentbak dbocontentbak = new DboContentbak();
				fill(rs, dbocontentbak);
				list.add(dbocontentbak);
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

	public static int whereCount(String subsql) {
		DBConnect dbc = null;
		int result = EXECUTE_FAIL;
		String sql = "select count(*) from car_filecache.dbo_contentbak where "+subsql+"";
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			return EXECUTE_FAIL;
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


	public static int delete(String subsql) {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "delete from car_filecache.dbo_contentbak where "+subsql+"";
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

	public static int delete(DBConnect dbc,String subsql) {
		int result = EXECUTE_FAIL;
		String sql = "delete from car_filecache.dbo_contentbak where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboContentbak dbocontentbak) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into car_filecache.dbo_contentbak(`id`,`cid`,`contentstr`,`adddate`) values(?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbocontentbak.getId());
		dbc.setInt(2, dbocontentbak.getCid());
		dbc.setString(3, dbocontentbak.getContentstr());
		dbc.setTimestamp(4, new Timestamp(dbocontentbak.getAdddate().getTime()));
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboContentbak dbocontentbak) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into car_filecache.dbo_contentbak(`id`,`cid`,`contentstr`,`adddate`) values(?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbocontentbak.getId());
		dbc.setInt(2, dbocontentbak.getCid());
		dbc.setString(3, dbocontentbak.getContentstr());
		dbc.setTimestamp(4, new Timestamp(dbocontentbak.getAdddate().getTime()));
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboContentbak dbocontentbak) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update car_filecache.dbo_contentbak set ");
		boolean flag = false;
		if(dbocontentbak.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbocontentbak.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",cid=?");
			}else{
				sb.append("cid=?");
				flag=true;
			}
		}
		if(dbocontentbak.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",contentstr=?");
			}else{
				sb.append("contentstr=?");
				flag=true;
			}
		}
		if(dbocontentbak.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		
		//System.out.println("-----dd---->>>"+sb.toString());
		
		int k=1;
		if(dbocontentbak.COLUMN_FLAG[0]){
			dbc.setInt(k, dbocontentbak.getId());k++;
		}
		if(dbocontentbak.COLUMN_FLAG[1]){
			dbc.setInt(k, dbocontentbak.getCid());k++;
		}
		if(dbocontentbak.COLUMN_FLAG[2]){
			dbc.setString(k, dbocontentbak.getContentstr());k++;
			//System.out.println("--vv--->"+dbocontentbak.getContentstr());
		}
		if(dbocontentbak.COLUMN_FLAG[3]){
			dbc.setTimestamp(k, new Timestamp(dbocontentbak.getAdddate().getTime()));k++;
		}
		dbc.setInt(k, dbocontentbak.getId());
		//System.out.println("id-------->"+dbocontentbak.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboContentbak dbocontentbak) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbocontentbak);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}