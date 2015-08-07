package com.poly.dao.subDaos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sun.print.resources.serviceui;

import com.poly.bean.newNews;
import com.poly.freemarkerMethod.ImageFormatMethod;

import car_beans.DboDntTousu;
import car_beans.TbApplyInfo;
import car_daos.DBConnect;
import car_daos.DBConnectionManager;
import car_daos.DboDntTousuDao;

public class TousuSubDao extends DboDntTousuDao {
	public List<Map<String, String>> queryToutu(int state, String beginDate,
			String endDate, String name, String phone, String keyword,
			int brandId, int chexiId, int prov, int city, int start, int rows) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		StringBuffer sql1 = new StringBuffer();
		StringBuffer sql2 = new StringBuffer();
		sql1.append("SELECT t1.id,t1.`name`,t1.phone,t1.state,t3.catalogname as 'prov',t2.catalogname as 'city',title,addtime,t5.catalogname as 'pinpai',t4.catalogname as 'chexi' from dbo_dnt_tousu t1 join dbo_are_catalog t2 on t1.xladdress = t2.catalogid JOIN dbo_are_catalog t3 on t2.fatherid = t3.catalogid join dbo_car_catalognew t4 on t1.serial = t4.catalogid join dbo_car_catalognew t5 on t4.fatherid = t5.catalogid where 1=1 ");
		sql2.append("SELECT count(1) count from dbo_dnt_tousu t1 join dbo_are_catalog t2 on t1.xladdress = t2.catalogid JOIN dbo_are_catalog t3 on t2.fatherid = t3.catalogid join dbo_car_catalognew t4 on t1.serial = t4.catalogid join dbo_car_catalognew t5 on t4.fatherid = t5.catalogid where 1=1 ");
		if (state != -2) {
			sql1.append(" and t1.state = " + state);
			sql2.append(" and t1.state = " + state);
		}
		sql1.append(" and t1.addtime between  '" + beginDate + "' and '"
				+ endDate + "' ");
		sql2.append(" and t1.addtime between  '" + beginDate + "' and '"
				+ endDate + "' ");
		if (!"".equals(name)) {
			sql1.append(" and t1.name like '%" + name + "%'");
			sql2.append(" and t1.name like '%" + name + "%'");
		}
		if (!"".equals(phone)) {
			sql1.append(" and t1.phone like '%" + phone + "%'");
			sql2.append(" and t1.phone like '%" + phone + "%'");
		}
		if (!"".equals(keyword)) {
			sql1.append(" and t1.title like '%" + keyword + "%'");
			sql2.append(" and t1.title like '%" + keyword + "%'");
		}
		if (brandId != -1) {
			sql1.append(" and t5.catalogid = " + brandId);
			sql2.append(" and t5.catalogid = " + brandId);
		}
		if (chexiId != -1) {
			sql1.append(" and t4.catalogid = " + chexiId);
			sql2.append(" and t4.catalogid = " + chexiId);
		}
		if (prov != -1) {
			sql1.append(" and t3.catalogid = " + prov);
			sql2.append(" and t3.catalogid = " + prov);
		}
		if (city != -1) {
			sql1.append(" and t2.catalogid = " + city);
			sql2.append(" and t2.catalogid = " + city);
		}
		sql1.append(" order by t1.addtime desc  limit " + start + "," + rows);
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
				map.put("id", rs.getString("id"));
				map.put("name", rs.getString("name"));
				map.put("phone", rs.getString("phone"));
				map.put("prov", rs.getString("prov"));
				map.put("city", rs.getString("city"));
				map.put("title", rs.getString("title"));
				map.put("addtime", rs.getString("addtime"));
				map.put("pinpai", rs.getString("pinpai"));
				map.put("chexi", rs.getString("chexi"));
				map.put("state", getState(rs.getInt("state")));
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

	String getCarState(int carstate) {
		String state = "";
		switch (carstate) {
		case 1:
			state = "一个月内";
			break;
		case 2:
			state = "磨合期内";
			break;
		case 3:
			state = "保修期内";
			break;
		case 4:
			state = "保修期外";
			break;
		default:
			state = "磨合期内";
			break;
		}
		return state;
	}

	String getState(int state) {
		String state_ = "";
		switch (state) {
		case 0:
			state_ = "待审核";
			break;
		case 1:
			state_ = "已审核";
			break;
		case 2:
			state_ = "处理结束";
			break;
		case -1:
			state_ = "删除";
			break;
		default:
			state_ = "待审核";
			break;
		}
		return state_;
	}

	// 查询投诉详情
	public Map<String, Object> queryTousuDetail(int tousuid) {
		ImageFormatMethod imageFormat = new ImageFormatMethod();
		Map<String, Object> map = new HashMap<String, Object>();
		String sql = "SELECT t1.imagename,t1.id,t1.`name`,t1.phone,t1.state,t1.email,t1.port,t1.address,t1.hao,t1.lc,t1.fdj,t1.cj,t1.buydate,t1.ssssname,t1.sssstel,t1.carstate,t1.problem,t1.suqiu,t3.catalogname as 'prov',t2.catalogname as 'city',title,addtime,t1.content,t1.image,t5.catalogname as 'pinpai',t4.catalogname as 'chexi' from dbo_dnt_tousu t1 join dbo_are_catalog t2 on t1.xladdress = t2.catalogid JOIN dbo_are_catalog t3 on t2.fatherid = t3.catalogid join dbo_car_catalognew t4 on t1.serial = t4.catalogid join dbo_car_catalognew t5 on t4.fatherid = t5.catalogid where t1.id = ?";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect();
			dbc.prepareStatement(sql);
			dbc.setInt(1, tousuid);
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				map.put("id", rs.getString("id"));
				map.put("name", rs.getString("name"));
				map.put("phone", rs.getString("phone"));
				map.put("prov", rs.getString("prov"));
				map.put("city", rs.getString("city"));
				map.put("title", rs.getString("title"));
				map.put("addtime", rs.getString("addtime"));
				map.put("pinpai", rs.getString("pinpai"));
				map.put("chexi", rs.getString("chexi"));
				map.put("state", rs.getString("state"));
				map.put("content", rs.getString("content"));
				map.put("email", rs.getString("email"));
				map.put("port", rs.getString("port"));
				map.put("address", rs.getString("address"));
				map.put("hao", rs.getString("hao"));
				map.put("lc", rs.getString("lc"));
				map.put("fdj", rs.getString("fdj"));
				map.put("cj", rs.getString("cj"));
				map.put("buydate", rs.getString("buydate"));
				map.put("ssssname", rs.getString("ssssname"));
				map.put("sssstel", rs.getString("sssstel"));
				map.put("carstate", getCarState(rs.getInt("carstate")));
				map.put("problem", rs.getString("problem"));
				map.put("suqiu", rs.getString("suqiu"));
				map.put("image", rs.getString("image"));
				map.put("imagename", rs.getString("imagename"));
				String imgs = rs.getString("image");
				List<String> images = new ArrayList<String>();
				String[] imgArray = imgs.split(",");
				for (String img : imgArray) {
					if (!"".equals(img.trim())) {
						List<Object> photoList = new ArrayList<Object>();
						photoList.add(img.trim());
						photoList.add("0");
						photoList.add("0");
						images.add(imageFormat.exec(photoList).toString());
					}

				}
				map.put("state_", getState(rs.getInt("state")));
				map.put("images", images);
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

	public void batchUpdateTousu(List<DboDntTousu> tousuList) {
		String sql = "UPDATE DBO_DNT_TOUSU SET STATE=? WHERE ID=?";
		Connection con = null;
		try {
			con = DBConnectionManager.getInstance().getConnection();
			con.setAutoCommit(false);
			PreparedStatement pst = con.prepareStatement(sql);
			for (DboDntTousu dboDntTousu : tousuList) {
				pst.setInt(1, dboDntTousu.getState());
				pst.setInt(2, dboDntTousu.getId());

				pst.addBatch();
				/*
				 * if (i % 1000 == 0) { pst.executeBatch(); con.commit();
				 * pst.clearBatch(); }
				 */
			}
			pst.executeBatch();
			con.commit();
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<Map<String, Object>> queryToutuTotal(int state,
			String beginDate, String endDate, String name, String phone,
			String keyword, int brandId, int chexiId, int prov, int city) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		ImageFormatMethod imageFormat = new ImageFormatMethod();
		Map<String, Object> map = null;
		StringBuffer sql1 = new StringBuffer();
		StringBuffer sql2 = new StringBuffer();
		sql1.append("SELECT t1.*,t1.id,t1.`name`,t1.phone,t1.state,t3.catalogname as 'provx',t2.catalogname as 'cityx',title,addtime,t5.catalogname as 'pinpai',t4.catalogname as 'chexi' from dbo_dnt_tousu t1 join dbo_are_catalog t2 on t1.xladdress = t2.catalogid JOIN dbo_are_catalog t3 on t2.fatherid = t3.catalogid join dbo_car_catalognew t4 on t1.serial = t4.catalogid join dbo_car_catalognew t5 on t4.fatherid = t5.catalogid where 1=1 ");
		if (state != -2) {
			sql1.append(" and t1.state = " + state);
		}
		sql1.append(" and t1.addtime between  '" + beginDate + "' and '"
				+ endDate + "' ");
		if (!"".equals(name)) {
			sql1.append(" and t1.name like '%" + name + "%'");
		}
		if (!"".equals(phone)) {
			sql1.append(" and t1.phone like '%" + phone + "%'");
		}
		if (!"".equals(keyword)) {
			sql1.append(" and t1.title like '%" + keyword + "%'");
		}
		if (brandId != -1) {
			sql1.append(" and t5.catalogid = " + brandId);
		}
		if (chexiId != -1) {
			sql1.append(" and t4.catalogid = " + chexiId);
		}
		if (prov != -1) {
			sql1.append(" and t3.catalogid = " + prov);
		}
		if (city != -1) {
			sql1.append(" and t2.catalogid = " + city);
		}
		sql1.append(" order by t1.addtime desc ");
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql1.toString());
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("id", rs.getString("id"));
				map.put("name", rs.getString("name"));
				map.put("phone", rs.getString("phone"));
				map.put("prov", rs.getString("provx"));
				map.put("city", rs.getString("cityx"));
				map.put("title", rs.getString("title"));
				map.put("addtime", rs.getString("addtime"));
				map.put("pinpai", rs.getString("pinpai"));
				map.put("chexi", rs.getString("chexi"));
				map.put("state", rs.getString("state"));
				map.put("content", rs.getString("content"));
				map.put("email", rs.getString("email"));
				map.put("port", rs.getString("port"));
				map.put("address", rs.getString("address"));
				map.put("hao", rs.getString("hao"));
				map.put("lc", rs.getString("lc"));
				map.put("fdj", rs.getString("fdj"));
				map.put("cj", rs.getString("cj"));
				map.put("buydate", rs.getString("buydate"));
				map.put("ssssname", rs.getString("ssssname"));
				map.put("sssstel", rs.getString("sssstel"));
				map.put("carstate", getCarState(rs.getInt("carstate")));
				map.put("problem", rs.getString("problem"));
				map.put("suqiu", rs.getString("suqiu"));
				String imgs = rs.getString("image");
				List<String> images = new ArrayList<String>();
				String[] imgArray = imgs.split(",");
				for (String img : imgArray) {
					if (!"".equals(img.trim())) {
						List<Object> photoList = new ArrayList<Object>();
						photoList.add(img.trim());
						photoList.add("0");
						photoList.add("0");
						images.add(imageFormat.exec(photoList).toString());
					}

				}
				map.put("state_", getState(rs.getInt("state")));
				map.put("images", images);

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

	// 更具渠道获取投诉统计量
	public List<Map<String, Object>> queryTousuByIway(String beginDate,
			String endDate, int prov, int city, int brandId, int chexiId,
			String iway) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(t2.iway) count ,t2.fatherid as brandid,t3.catalogname as brandname,t2.iway from dbo_dnt_tousu  t1 join dbo_car_catalognew t2 on t1.serial = t2.catalogid join dbo_car_catalognew t3 on t2.fatherid = t3.catalogid JOIN dbo_are_catalog t4 on t1.xladdress = t4.catalogid where 1=1 ");
		sql.append(" and t1.addtime between  '" + beginDate + "' and '"
				+ endDate + "' ");
		if (prov != -1)
			sql.append(" and t4.fatherid = " + prov);
		if (city != -1)
			sql.append(" and t1.xladdress = " + city);
		if (brandId != -1)
			sql.append(" and t2.fatherid = " + brandId);
		if (chexiId != -1)
			sql.append(" and t1.serial = " + chexiId);
		if (iway != null && !"".equals(iway))
			sql.append(" and t2.iway = '" + iway + "'");
		sql.append(" GROUP BY t2.iway  order by count(t2.iway) desc");
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("iway", rs.getString("iway"));
				map.put("count", rs.getString("count"));
				map.put("info",
						queryTousuSerialByIway(beginDate, endDate, prov, city,
								rs.getString("iway"), chexiId));
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

	public List<Map<String, Object>> queryTousuSerialByIway(String beginDate,
			String endDate, int prov, int city, String iway, int chexiId) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(t1.serial) count ,t2.catalogname as  chexiname,t3.catalogname as brandname,t2.iway from dbo_dnt_tousu  t1 join dbo_car_catalognew t2 on t1.serial = t2.catalogid join dbo_car_catalognew t3 on t2.fatherid = t3.catalogid JOIN dbo_are_catalog t4 on t1.xladdress = t4.catalogid  where 1=1 ");
		sql.append(" and t1.addtime between  '" + beginDate + "' and '"
				+ endDate + "' ");
		if (prov != -1)
			sql.append(" and t4.fatherid = " + prov);
		if (city != -1)
			sql.append(" and t1.xladdress = " + city);
		if (iway != null && !"".equals(iway))
			sql.append(" and t2.iway = '" + iway + "'");
		if (chexiId != -1)
			sql.append(" and t1.serial = " + chexiId);
		sql.append(" GROUP BY t1.serial  order by count(t1.serial) desc");
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("count", rs.getString("count"));
				map.put("chexiname", rs.getString("chexiname"));
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

	public List<Map<String, Object>> queryTousuSerialBySerial(String beginDate,
			String endDate, int prov, int city, String iway, int chexiId,
			int brandId) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(t1.serial) count ,t2.catalogname as  chexiname,t3.catalogname as brandname,t3.catalogid as brandid,t2.iway from dbo_dnt_tousu  t1 join dbo_car_catalognew t2 on t1.serial = t2.catalogid join dbo_car_catalognew t3 on t2.fatherid = t3.catalogid JOIN dbo_are_catalog t4 on t1.xladdress = t4.catalogid  where 1=1 ");
		sql.append(" and t1.addtime between  '" + beginDate + "' and '"
				+ endDate + "' ");
		if (prov != -1)
			sql.append(" and t4.fatherid = " + prov);
		if (city != -1)
			sql.append(" and t1.xladdress = " + city);
		if (iway != null && !"".equals(iway))
			sql.append(" and t2.iway = '" + iway + "'");
		if (chexiId != -1)
			sql.append(" and t1.serial = " + chexiId);
		if (brandId != -1)
			sql.append(" and t3.catalogid = " + brandId);
		sql.append(" GROUP BY t1.serial  order by count(t1.serial) desc");
		DBConnect dbc = null;
		Map<String, Object> brandmap = queryBrnadCount(beginDate, endDate,
				prov, city);
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {

				map = new HashMap<String, Object>();
				map.put("count", rs.getString("count"));
				map.put("chexiname", rs.getString("chexiname"));
				map.put("brandmap", brandmap.get(rs.getString("brandid")));
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

	// SELECT count(1) from dbo_dnt_tousu t1 join dbo_car_catalognew t2 on
	// t1.serial = t2.catalogid join dbo_car_catalognew t3 on t2.fatherid =
	// t3.catalogid JOIN dbo_are_catalog t4 on t1.xladdress = t4.catalogid where
	// 1=1 and t2.fatherid = 85
	public Map<String, Object> queryBrnadCount(String beginDate,
			String endDate, int prov, int city) {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(t3.catalogname) as count ,t3.catalogname as  brandname,t3.catalogid as brandid from dbo_dnt_tousu  t1 join dbo_car_catalognew t2 on t1.serial = t2.catalogid join dbo_car_catalognew t3 on t2.fatherid = t3.catalogid JOIN dbo_are_catalog t4 on t1.xladdress = t4.catalogid   where 1=1 ");
		sql.append(" and t1.addtime between  '" + beginDate + "' and '"
				+ endDate + "' ");
		if (prov != -1)
			sql.append(" and t4.fatherid = " + prov);
		if (city != -1)
			sql.append(" and t1.xladdress = " + city);
		/*
		 * if(brandId!=-1) sql.append(" and t3.catalogid = "+brandId);
		 */
		// GROUP BY t3.catalogname
		sql.append(" GROUP BY t3.catalogname");
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				Map<String, String> mapx = new HashMap<String, String>();
				mapx.put("brandname", rs.getString("brandname"));
				mapx.put("count", rs.getString("count"));
				String brandid = rs.getString("brandid");
				map.put(brandid, mapx);
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
	// 更具投诉对象获取投诉统计量
	public int  queryTousuSerialByDuixiang(String beginDate,
			String endDate, int prov, int city, int brandId, int chexiId,
			String iway,String problem) {
		int count = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(1) count from dbo_dnt_tousu  t1 join dbo_car_catalognew t2 on t1.serial = t2.catalogid join dbo_car_catalognew t3 on t2.fatherid = t3.catalogid JOIN dbo_are_catalog t4 on t1.xladdress = t4.catalogid where 1=1 ");
		sql.append(" and t1.addtime between  '" + beginDate + "' and '"
				+ endDate + "' ");
		if (prov != -1)
			sql.append(" and t4.fatherid = " + prov);
		if (city != -1)
			sql.append(" and t1.xladdress = " + city);
		if (brandId != -1)
			sql.append(" and t2.fatherid = " + brandId);
		if (chexiId != -1)
			sql.append(" and t1.serial = " + chexiId);
		if (iway != null && !"".equals(iway))
			sql.append(" and t2.iway = '" + iway + "'");
		if (iway != null && !"".equals(iway))
			sql.append(" and t2.iway = '" + iway + "'");
		if(!"".equals(problem))
			sql.append(" and t1.problem like '%"+problem+"%'");
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
			if (dbc != null) {
				try {
					dbc.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return count;
	}

	// 更具渠道获取投诉统计量
	public List<Map<String, Object>> queryTousuBySerial(String beginDate,
			String endDate, int prov, int city, int brandId, int chexiId,
			String iway) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(t3.catalogid) count ,t2.fatherid as brandid,t3.catalogname as brandname,t2.catalogid as chexiid,t2.iway from dbo_dnt_tousu  t1 join dbo_car_catalognew t2 on t1.serial = t2.catalogid join dbo_car_catalognew t3 on t2.fatherid = t3.catalogid JOIN dbo_are_catalog t4 on t1.xladdress = t4.catalogid where 1=1 ");
		sql.append(" and t1.addtime between  '" + beginDate + "' and '"
				+ endDate + "' ");
		if (prov != -1)
			sql.append(" and t4.fatherid = " + prov);
		if (city != -1)
			sql.append(" and t1.xladdress = " + city);
		if (brandId != -1)
			sql.append(" and t2.fatherid = " + brandId);
		if (chexiId != -1)
			sql.append(" and t1.serial = " + chexiId);
		if (iway != null && !"".equals(iway))
			sql.append(" and t2.iway = '" + iway + "'");
		sql.append(" GROUP BY t3.catalogid  order by count(t3.catalogid) desc");
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("brandname", rs.getString("brandname"));
				List<Map<String, Object>> countList = querySerialCount(
						beginDate, endDate, prov, city, rs.getInt("brandid"),
						chexiId, iway);
				map.put("info", countList);
				map.put("brandcount", rs.getString("count"));
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

	// SELECT count(1) from dbo_dnt_tousu t1 join dbo_car_catalognew t2 on
	// t1.serial = t2.catalogid join dbo_car_catalognew t3 on t2.fatherid =
	// t3.catalogid JOIN dbo_are_catalog t4 on t1.xladdress = t4.catalogid where
	// 1=1 and t2.fatherid = 85
	public List<Map<String, Object>> querySerialCount(String beginDate,
			String endDate, int prov, int city, int brandId, int chexiId,
			String iway) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(t2.catalogname) as count ,t2.catalogname as  serialname  from dbo_dnt_tousu  t1 join dbo_car_catalognew t2 on t1.serial = t2.catalogid join dbo_car_catalognew t3 on t2.fatherid = t3.catalogid JOIN dbo_are_catalog t4 on t1.xladdress = t4.catalogid   where 1=1 ");
		sql.append(" and t1.addtime between  '" + beginDate + "' and '"
				+ endDate + "' ");
		if (prov != -1)
			sql.append(" and t4.fatherid = " + prov);
		if (city != -1)
			sql.append(" and t1.xladdress = " + city);
		if (brandId != -1)
			sql.append(" and t3.catalogid = " + brandId);
		if (chexiId != -1)
			sql.append(" and t2.catalogid = " + chexiId);
		if (iway != null && !"".equals(iway))
			sql.append(" and t2.iway = '" + iway + "'");
		sql.append(" GROUP BY t2.catalogname ORDER BY count(t2.catalogname) DESC");
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("serialname", rs.getString("serialname"));
				map.put("count", rs.getString("count"));
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

}
