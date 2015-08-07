package com.poly.dao.subDaos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import car_daos.DBConnectionManager;

public class Publish4sSubDao {
	/**
	 * 获取vip经销商
	 * @return
	 */
	public  List<HashMap<String, String>> getVipDealers() {
		Connection dbc = getNew315Connection();
		String sql = "select iway, eid,areaid,mainbrand,c.catalogid,c.fatherid,shortename from dbo_dea_dealers b LEFT OUTER JOIN dbo_are_catalog c on b.areaid = c.catalogid where (paylevel=4 or paylevel=5)  and b.ExpirationDate >= now() and (b.isdelete = 0 and b.isdelete is not null )";
		HashMap<String, String> map = null;
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		try {
			PreparedStatement pstmt = dbc.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("eid", rs.getString("eid"));
				map.put("areaid", rs.getString("areaid"));
				map.put("mainbrand", rs.getString("mainbrand"));
				map.put("iway",
						rs.getString("iway") == null ? "" : rs
								.getString("iway"));
				String catalogid = "0";
				if ("0".equals(rs.getString("fatherid"))
						|| "10".equals(rs.getString("fatherid")))
					catalogid = rs.getString("catalogid");
				else
					catalogid = rs.getString("fatherid");
				map.put("catalogid", catalogid);
				map.put("ename", rs.getString("shortename"));
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
	/**
	 * 保存经销商信息
	 * @param dataList 经销商报名列表
	 */
	public  void saveVip(List<HashMap<String, String>> dataList) {
		Connection dbc = getNew315Connection();
		String sql = "insert into dbo_dea_ordercar(eid,carid,orderdate,phone,customername,ordertype,areaid) values (?,?,?,?,?,?,?)";
		try {
			dbc.setAutoCommit(false);
			PreparedStatement pstmt = dbc.prepareStatement(sql);
			for (int i = 0; i < dataList.size(); i++) {
				HashMap<String, String> data = dataList.get(i);
				pstmt.setString(1, data.get("eid"));
				pstmt.setInt(2, Integer.parseInt(data.get("carid")));
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				//Date date = sdf.parse(data.get("orderdate").toString());
				Timestamp time = new Timestamp(new Date().getTime());
				pstmt.setTimestamp(3, time);
				pstmt.setString(4, data.get("phone"));
				pstmt.setString(5, data.get("customername"));
				pstmt.setInt(6, 1);
				pstmt.setInt(7, Integer.parseInt(data.get("areaid")));
				pstmt.addBatch();
				if (i % 1000 == 0) {
					pstmt.executeBatch();
					dbc.commit();
					pstmt.clearBatch();
				}
			}
			pstmt.executeBatch();
			dbc.commit();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//dbc.setAutoCommit(true);
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	//新315db
		private 	static Connection getNew315Connection() {
				String url = "jdbc:mysql://182.254.131.113:3306/car_315?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=round";
				Connection con = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");// 要求JVM查找并加载指定的类，也就是说JVM会执行该类的静态代码段
					DriverManager.setLoginTimeout(10);// 超过10s拿不到链接报错
					con = DriverManager.getConnection(url, "main_ls",
							"main_ls");
					con.setAutoCommit(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return con;

			}
	
}
