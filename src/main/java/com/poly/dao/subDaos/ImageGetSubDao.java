package com.poly.dao.subDaos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import car_daos.DBConnect;

public class ImageGetSubDao {
	
	

	HashMap<String, Object> map = null;
	
	
	public List<HashMap<String, Object>> getImageInfo(String catalogid){
		DBConnect dbc = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String sql = "SELECT c.id,c.title AS ctitle,a.catalogname,c.type,c.addadmin,c.adddate,a.fatherid,a.catalogid,c.keywords,d.title ,d.path FROM dbo_car_catalognew a "
				+ "INNER JOIN dbo_img_title c ON c.catalogid = a.catalogid "
				+ "INNER JOIN dbo_img_content d ON c.id = d.titleid "
				+ "WHERE a.catalogid in ("
				+ catalogid
				+ ") AND c.isdelete = 0 order by a.fatherid,c.id,c.type";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("id", rs.getInt("id"));
				map.put("ctitle", rs.getString("ctitle"));
				map.put("catalogname", rs.getString("catalogname"));
				map.put("type", rs.getInt("type"));
				map.put("addadmin", rs.getString("addadmin"));
				//map.put("adddate", rs.getDate("adddate"));
				map.put("fatherid", rs.getInt("fatherid"));
				map.put("catalogid", rs.getInt("catalogid"));
				map.put("keywords", rs.getString("keywords"));
				map.put("title", rs.getString("title"));
				map.put("path", rs.getString("path"));
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
	
	
	public List<HashMap<String, Object>> getImageInfo(String catalogid,String titleKey){
		DBConnect dbc = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String sql = "SELECT c.id,c.title  AS ctitle,a.catalogname,c.type,c.addadmin,c.adddate,a.fatherid,a.catalogid,c.keywords,d.title,d.path FROM dbo_car_catalognew a "
				+ "INNER JOIN dbo_img_title c ON c.catalogid = a.catalogid "
				+ "INNER JOIN dbo_img_content d ON c.id = d.titleid "
				+ "WHERE a.catalogid in ("
				+ catalogid
				+ ") AND c.isdelete = 0 "+"AND c.type = "+titleKey+" "
				+ "order by a.fatherid,c.id,c.type,d.sortid Desc";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("id", rs.getInt("id"));
				map.put("ctitle", rs.getString("ctitle"));
				map.put("catalogname", rs.getString("catalogname"));
				map.put("type", rs.getInt("type"));
				map.put("addadmin", rs.getString("addadmin"));
				//map.put("adddate", rs.getDate("adddate"));
				map.put("fatherid", rs.getInt("fatherid"));
				map.put("catalogid", rs.getInt("catalogid"));
				map.put("keywords", rs.getString("keywords"));
				map.put("title", rs.getString("title"));
				map.put("path", rs.getString("path"));
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
	
	
	public List<HashMap<String, Object>> getImageNotInfo(String catalogid){
		DBConnect dbc = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String sql = "SELECT c.type,d.title,d.path FROM dbo_img_newcatalog a "
				+ "INNER JOIN dbo_img_newtitle c ON c.catalogid = a.catalogid "
				+ "INNER JOIN dbo_img_newcontent d ON c.id = d.titleid "
				+ "WHERE a.catalogid in ("
				+ catalogid
				+ ") AND c.isdelete = 0 order by a.fatherid,c.id,c.type";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("type", rs.getInt("type"));
				map.put("title", rs.getString("title"));
				map.put("path", rs.getString("path"));
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
	
	public List<HashMap<String, Object>> getImageNotInfo(String catalogid,String titleKey){
		DBConnect dbc = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String sql = "SELECT c.type,d.title,d.path FROM dbo_img_newcatalog a "
				+ "INNER JOIN dbo_img_newtitle c ON c.catalogid = a.catalogid "
				+ "INNER JOIN dbo_img_newcontent d ON c.id = d.titleid "
				+ "WHERE a.catalogid in ("
				+ catalogid
				+ ") AND c.isdelete = 0 "+"AND d.title LIKE '%"+titleKey+"%' "
				+ "order by a.fatherid,c.id,c.type";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("type", rs.getInt("type"));
				map.put("title", rs.getString("title"));
				map.put("path", rs.getString("path"));
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
