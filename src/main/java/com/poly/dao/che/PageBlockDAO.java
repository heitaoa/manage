package com.poly.dao.che;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;
import car_beans.DboSubContent;
import car_beans.DboSubData;
import car_daos.DBConnect;
import car_daos.DboSubContentDao;
import car_daos.DboSubDataDao;

import com.poly.util.DateUtils;
import com.redis.RedisDao;
import com.redis.RedisManager;

public class PageBlockDAO {
	public static List<DboSubData> queryPagesubDataBySid(int sid)
			throws Exception {
		String sql = "select * from dbo_sub_data a, dbo_sub_content b where b.parent_id=? and a.sid=b.id and a.isdelete=0 order by sortid desc";
		DBConnect connect = null;
		try {
			connect = new DBConnect(sql);
			connect.setInt(1, sid);
			ResultSet rs = connect.executeQuery();

			List<DboSubData> subDatas = new ArrayList<DboSubData>();
			while (rs.next()) {
				DboSubData dbosubdata = new DboSubData();
				fillSubData(rs, dbosubdata);
				subDatas.add(dbosubdata);
			}
			return subDatas;
		} finally {
			if (connect != null) {
				connect.close();
			}
		}
	}

	public static void fillSubData(ResultSet rs, DboSubData dbosubdata)
			throws SQLException {
		dbosubdata.setId(rs.getInt("id"));//
		dbosubdata.setSid(rs.getInt("sid"));//
		dbosubdata.setTitle(rs.getString("title"));//
		dbosubdata.setContent(rs.getString("content"));//
		dbosubdata.setPic(rs.getString("pic"));//
		dbosubdata.setLink(rs.getString("link"));//
		dbosubdata.setCtitle(rs.getString("ctitle"));// 目录名
		dbosubdata.setClink(rs.getString("clink"));// 目录连接
		dbosubdata.setColor(rs.getString("color"));// 控制标题颜色
		dbosubdata.setBold(rs.getInt("bold"));// 标题是否加粗
		dbosubdata.setAdddate(rs.getTimestamp("adddate"));//
		dbosubdata.setIsdelete(rs.getInt("isdelete"));//
		dbosubdata.setSortid(rs.getInt("sortid"));//
		dbosubdata.setLink_back(rs.getString("link_back"));//
		dbosubdata.setClink_back(rs.getString("clink_back"));//
		dbosubdata.setIsad(rs.getInt("isad"));// 是否是广告
	}

	public static DboSubData querySubDataById(int id) {
		List<DboSubData> subDatas = DboSubDataDao.where(" id=" + id);
		if (subDatas == null || subDatas.size() <= 0) {
			return null;
		}
		return subDatas.get(0);
	}

	public static int deleteSubDataById(int id) {
		String now = DateUtils.getNow();
		System.out.println("================>>"+now);
		String sql = "update dbo_sub_data set isdelete=1, adddate='"+now+"' where id=?";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, id);
			return dbc.executeUpdateReturnInt();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public static List<DboSubData> querySubDatasByCid(int cid) {
		return DboSubDataDao.where(" sid=" + cid
				+ " and isdelete=0 order by sortid desc");
	}

	public static List<Map<String, Object>> resuleSetForList(ResultSet rs)
			throws SQLException {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		if (rs != null) {
			Map<String, Object> map = null;
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCounts = metaData.getColumnCount();
			String columns[] = new String[columnCounts];
			for (int i = 0; i < columnCounts; i++) {
				columns[i] = metaData.getColumnName(i + 1);
			}

			while (rs.next()) {
				map = new HashMap<String, Object>();
				for (String column : columns) {
					map.put(column, rs.getObject(column));
				}
				results.add(map);
			}
		}
		return results;
	}

	/**
	 * 查询分站名称，areaid，
	 * @return
	 * @throws Exception
	 */
	public static List<Map<String, Object>> queryAllSites() throws Exception {
		DBConnect dbc = null;
		try {
			String sql = "select * from tb_sub_sites";
			dbc = new DBConnect(sql);

			ResultSet rs = dbc.executeQuery();
			return resuleSetForList(rs);
		} finally {
			if (dbc != null) {
				dbc.close();
			}
		}
	}

	public static void syncSubData(int cid) throws Exception {
		int sid = querySubContentById(cid).getSync_id();
		if (sid > 0) {
			String sql = "delete from dbo_sub_data where sid=?";
			DBConnect dbc = new DBConnect(sql);
			dbc.setInt(1, sid);
			dbc.executeUpdate();

			List<DboSubData> subDatas = querySubDatasByCid(cid);
			for (int i = subDatas.size() - 1; i >= 0; i--) {
				DboSubData subData = subDatas.get(i);
				subData.setSid(sid);
				subData.setId(getSubDataId());

				insertSubData(subData);
			}
		}
	}

	public static DboSubContent querySubContentById(int id) {
		List<DboSubContent> contents = DboSubContentDao.where(" id=" + id);
		if (contents != null && contents.size() > 0) {
			return contents.get(0);
		}
		return null;
	}

	/**
	 * 根据关键字，平台，分站id查询 页面模块
	 * @param keywords 关键字
	 * @param pingtai 平台
	 * @param sites_id 城市站
	 * @param page 
	 * @param pageSize
	 * @return 分页数据
	 * @throws Exception
	 */
	public static List<Map<String, Object>> queryPageBlockListData(
			String keywords, String pingtai, int sites_id, int page,
			int pageSize) throws Exception {
		DBConnect dbc = null;
		try {
			StringBuffer buf = new StringBuffer(
					"select & from dbo_sub_content c ,tb_sub_sites s where c.sub_sites_id=s.id ");
			if (keywords != null) {
				buf.append(" and place like '%" + keywords + "%' ");
			}

			if (pingtai != null && pingtai.matches("\\d+(,\\d+)*")) {
				String pingtais[] = pingtai.split(",");

				buf.append(" and (");

				for (int i = 0; i < pingtais.length; i++) {
					if (i == 0) {
						buf.append(" stype=" + pingtais[i]);
					} else {
						buf.append(" or stype=" + pingtais[i]);
					}
				}

				buf.append(")");
			}
			if (sites_id > 0) {
				buf.append(" and s.id=" + sites_id);
			}

			String sql = buf.toString();
			sql = sql.replace("&", "count(1)");
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			int counts = 0;
			if (rs.next()) {
				counts = rs.getInt(1);
			}

			// 分页
			int allPage = counts / pageSize;
			if (counts % pageSize != 0) {
				allPage++;
			}
			if (page > allPage) {
				page = allPage;
			}
			if (page <= 0) {
				page = 1;
			}
			int startIndex = (page - 1) * pageSize;
			// 分页
			buf.append(" limit " + startIndex + "," + pageSize);

			sql = buf.toString();
			sql = sql
					.replace("&",
							"c.id as cid,pname,place,stype,name as area,ename as earea,sync_id");

			dbc = new DBConnect(sql);
			// System.out.println(sql);
			rs = dbc.executeQuery();
			List<Map<String, Object>> results = resuleSetForList(rs);
			for (Map<String, Object> map : results) {
				map.put("counts", counts);
				map.put("allPage", allPage);
				map.put("curPage", page);
				map.put("pageSize", pageSize);
			}

			return results;
		} finally {
			if (dbc != null) {
				dbc.close();
			}
		}
	}

	public static int updateSubData(DboSubData subData, int cid) {
		RedisDao.insertSubData(subData);

		// 删除 2 组redis 内的以下key，防止2个redis key 数据不同步
		delete_CheIndexDAOImpl_RedisKeys(cid);
		
		return DboSubDataDao.update(subData);
	}
	
	/**
	 * 删除 2 组redis 内的以下key，防止2个redis key 数据不同步
	 * 例如： CheIndexDAOImpl_queryAllSubdataByParentIdASiteId_21300_3_
	 * 用于分站首页焦点图旁的内容数据 rediskey的删除
	 */
	public static void delete_CheIndexDAOImpl_RedisKeys(int cid) {
		List<DboSubContent> list = DboSubContentDao.where("id = " + cid);
		if(list != null && list.size() == 1) {
			int sub_site_id = list.get(0).getSub_sites_id();
			String key = "CheIndexDAOImpl_queryAllSubdataByParentIdASiteId_21300_" + sub_site_id + "_"; 
			
			// redis 1 内的key删除
			Jedis jedis1 = RedisManager.getJedisObject();
			if(jedis1.exists(key)) {
				jedis1.del(key);
			}
			RedisManager.recycleJedisOjbect(jedis1);
			
			// redis 3 内的key删除
			Jedis jedis3 = RedisManager.getJedis3Object();
			if(jedis3.exists(key)) {
				jedis3.del(key);
			}
			RedisManager.recycleJedis3Ojbect(jedis3);
		}
	}
	

	/**
	 * 
	 * 
	 * @param subData
	 * @return ID
	 * @throws Exception
	 */
	public static int insertSubData(DboSubData subData) throws Exception {
		subData.setAdddate(new Date());

		RedisDao.insertSubData(subData);

		return DboSubDataDao.save(subData);
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

	public static void changeSorted(int id0, int id1) throws Exception {
		DboSubData sudData = querySubDataById(id0);
		RedisDao.insertSubData(sudData);
		sudData = querySubDataById(id1);
		RedisDao.insertSubData(sudData);

		String sql = "select id,sortid,sync_id from dbo_sub_data where id=? or id=? ";
		DBConnect dbc = new DBConnect(sql);
		dbc.setInt(1, id0);
		dbc.setInt(2, id1);
		ResultSet rs = dbc.executeQuery();
		Map<Integer, Integer> mappings = new HashMap<Integer, Integer>();
		// Map<Integer, Integer> mappings_sync = new HashMap<Integer,
		// Integer>();
		while (rs.next()) {
			mappings.put(rs.getInt("id"), rs.getInt("sortid"));
			// mappings_sync.put(rs.getInt("id"), rs.getInt("sync_id"));
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

		// if (mappings_sync.get(id0) > 0 && mappings_sync.get(id1) > 0) {
		// changeSorted(mappings_sync.get(id0), mappings_sync.get(id1));
		// }

	}

	public static int getSubDataId() throws Exception {
		return nextVal("dbo_sub_data");
	}
}
