package com.poly.dao.subDaos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import car_beans.DboImgTitle;
import car_daos.DBConnect;
import car_daos.DBConnectionManager;
import car_daos.DboImgTitleDao;

import com.poly.bean.ChangeSortEntity;
import com.poly.util.DeleteCarParamFileUtil;

public class DboImgTitleSubDao extends DboImgTitleDao {

	

	HashMap<String, Object> map = null;

	public List<HashMap<String, Object>> getTitleInfo(String catalogid,
			int start, int rows) {
		DBConnect dbc = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		
		if(("").equals(catalogid)){
			
			return result;
		}

		String sql = "SELECT count(*) as count FROM dbo_car_catalognew a INNER JOIN "
				+ " dbo_img_title c ON c.catalogid = a.catalogid "
				+ "WHERE a.catalogid in (" + catalogid + ") AND c.isdelete = 0";
		int count = 0;
		try {
			dbc = new DBConnect(sql);
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

		sql = "SELECT c.id,c.title,a.catalogname,c.type,c.addadmin,c.adddate,a.fatherid,a.catalogid,c.keywords,c.color FROM dbo_car_catalognew a "
				+ "INNER JOIN dbo_img_title c ON c.catalogid = a.catalogid "
				+ "WHERE a.catalogid in ("
				+ catalogid
				+ ") AND c.isdelete = 0 order by c.catalogid,c.type limit ?,?";
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, start);
			dbc.setInt(2, rows);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("count", count);
				map.put("id", rs.getInt("id"));
				map.put("title", rs.getString("title"));
				map.put("catalogname", rs.getString("catalogname"));
				map.put("type", rs.getInt("type"));
				map.put("addadmin", rs.getString("addadmin"));
				map.put("adddate", rs.getDate("adddate"));
				map.put("fatherid", rs.getInt("fatherid"));
				map.put("catalogid", rs.getInt("catalogid"));
				map.put("keywords", rs.getString("keywords"));
				map.put("color", rs.getString("color"));
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
	
	public List<HashMap<String, Object>> getTitleById(String id){
		DBConnect dbc = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		
		String sql = "SELECT c.id,c.title,a.catalogname,c.type,c.addadmin,c.adddate,a.fatherid,a.catalogid,c.keywords FROM dbo_car_catalognew a "
				+ " INNER JOIN dbo_img_title c ON c.catalogid = a.catalogid WHERE c.id = ?";
		
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, id);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("id", rs.getInt("id"));
				map.put("title", rs.getString("title"));
				map.put("catalogname", rs.getString("catalogname"));
				map.put("type", rs.getInt("type"));
				map.put("addadmin", rs.getString("addadmin"));
				map.put("adddate", rs.getDate("adddate"));
				map.put("fatherid", rs.getInt("fatherid"));
				map.put("catalogid", rs.getInt("catalogid"));
				map.put("keywords", rs.getString("keywords"));
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

	public List<HashMap<String, Object>> getImagePage(String idStr) {
		DBConnect dbc = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		
		if(("").equals(idStr)){
			
			return result;
		}

		String sql = "SELECT id,titleId,title,keywords,path,type,totopdate,serialType FROM dbo_img_content WHERE isdelete = 0 AND titleId in ("
				+ idStr + ") ORDER BY sortid DESC";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("id", rs.getInt("id"));
				map.put("titleId", rs.getInt("titleId"));
				map.put("title", rs.getString("title"));
				map.put("keywords", rs.getString("keywords"));
				map.put("path", rs.getString("path"));
				map.put("type", rs.getInt("type"));
				map.put("totopdate", rs.getDouble("totopdate"));
				map.put("serialType", rs.getInt("serialType"));
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

	public List<HashMap<String, Object>> getAddadmin() {
		DBConnect dbc = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String sql = "SELECT DISTINCT(addadmin) FROM dbo_img_title WHERE isdelete = 0";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("addadmin", rs.getString("addadmin"));
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
	
	public List<HashMap<String, Object>> getAllImageChangePage(String idStr){
		DBConnect dbc = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String sql = "SELECT id,titleId,title,path,comefrom,adddate,sortid FROM dbo_img_content WHERE isdelete = 0 AND titleId = ? ORDER BY sortid DESC ";
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, idStr);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("id", rs.getInt("id"));
				map.put("titleId", rs.getInt("titleId"));
				map.put("title", rs.getString("title"));
				map.put("path", rs.getString("path"));
				map.put("comefrom", rs.getString("comefrom"));
				map.put("adddate", rs.getDate("adddate"));
				map.put("sortid", rs.getInt("sortid"));
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

	public List<HashMap<String, Object>> getImageChangePage(String idStr,int start, int rows) {
		DBConnect dbc = null;
		String sql = "SELECT count(*) as count FROM dbo_img_content WHERE isdelete = 0 AND titleId = ? ORDER BY sortid DESC";
		int count = 0;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, idStr);
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

		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		sql = "SELECT id,titleId,title,path,comefrom,adddate,sortid FROM dbo_img_content WHERE isdelete = 0 AND titleId = ? ORDER BY sortid DESC limit ?,?";
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, idStr);
			dbc.setInt(2, start);
			dbc.setInt(3, rows);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("count", count);
				map.put("id", rs.getInt("id"));
				map.put("titleId", rs.getInt("titleId"));
				map.put("title", rs.getString("title"));
				map.put("path", rs.getString("path"));
				map.put("comefrom", rs.getString("comefrom"));
				map.put("adddate", rs.getDate("adddate"));
				map.put("sortid", rs.getInt("sortid"));
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
	
	public int deleteImageTitle(int titleid){
		DBConnect dbc = null;
		int result = -1;
		String sql = "UPDATE dbo_img_title SET isdelete = 1,lastupdate=? WHERE id = ?";
		try {
			dbc = new DBConnect(sql);
			dbc.setTimestamp(1, new Timestamp(new Date().getTime()));
			dbc.setInt(2, titleid);
			result = dbc.executeUpdateReturnInt();
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
	
	public int deleteImageContent(int id){
		DeleteCarParamFileUtil.deleteTuKuPriceFile(id+"","imgContent");
		DBConnect dbc = null;
		int result = -1;
		String sql = "UPDATE dbo_img_content SET isdelete = 1,lastupdate=? WHERE id = ?";
		try {
			dbc = new DBConnect(sql);
			dbc.setTimestamp(1, new Timestamp(new Date().getTime()));
			dbc.setInt(2, id);
			result = dbc.executeUpdateReturnInt();
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
	
	public int setComefrom(String comefrom,int id){
		DBConnect dbc = null;
		int result = -1;
		String sql = "UPDATE dbo_img_content SET comefrom = ?,lastupdate=? WHERE id = ?";
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, comefrom);
			dbc.setTimestamp(2, new Timestamp(new Date().getTime()));
			dbc.setInt(3, id);
			result = dbc.executeUpdateReturnInt();
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
	
	
	public int changeSort(ChangeSortEntity changeSortEntity){
		DBConnect dbc = null;
		int result = -1;
		String sql = "UPDATE dbo_img_content SET sortid = ?,lastupdate=? WHERE id = ?";
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, changeSortEntity.getChangesort());
			dbc.setTimestamp(2, new Timestamp(new Date().getTime()));
			dbc.setInt(3, changeSortEntity.getNowid());
			result = dbc.executeUpdateReturnInt();
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
		
		sql = "UPDATE dbo_img_content SET sortid = ?,lastupdate=? WHERE id = ?";
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, changeSortEntity.getNowsort());
			dbc.setTimestamp(2, new Timestamp(new Date().getTime()));
			dbc.setInt(3, changeSortEntity.getChangeid());
			result = dbc.executeUpdateReturnInt();
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
	
	
	public int getTitleMaxid(){
		DBConnect dbc = null;
		String  sql = "SELECT MAX(id) as max FROM dbo_img_title";
		int result = -1 ;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				result= rs.getInt("max");
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
	
	public int addTitle(DboImgTitle dboImgTitle) throws Exception{
		int addid = getTitleMaxid()+1;
		dboImgTitle.setId(addid);
		dboImgTitle.setAdddate(new Date());
		dboImgTitle.setLastupdate(new Date());
		this.save(dboImgTitle);
		return addid;
	}
	
	public int deleteTitle(int id){
		DBConnect dbc = null;
		String sql = "update dbo_img_title set isdelete = 1,lastupdate=? where id = ?";
		int result = -1;
		try {
			dbc = new DBConnect(sql);
			dbc.setTimestamp(1, new Timestamp(new Date().getTime()));
			dbc.setInt(2, id);
			result =dbc.executeUpdateReturnInt();
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
	
	
	public List<HashMap<String, Object>> getSortImage(String titleId){
		DBConnect dbc = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String sql = "SELECT id,titleId,title,path,comefrom,adddate,sortid FROM dbo_img_content WHERE isdelete = 0 AND titleId = ? ORDER BY sortid DESC ";
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, titleId);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("id", rs.getInt("id"));
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
	
	public int updateSort(String id,int sortid){
		DBConnect dbc = null;
		String sql = "update dbo_img_content set sortid = ?,lastupdate=? where id = ?";
		int result = -1;
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, sortid);
			dbc.setTimestamp(2, new Timestamp(new Date().getTime()));
			dbc.setString(3, id);
			result =dbc.executeUpdateReturnInt();
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
	
	
	public int imagechouqu(String carid){
		DBConnectionManager dcm = DBConnectionManager.getInstance();
		Connection conn = dcm.getConnection();
		String sql = "{call pro_update_img_bycarid(?,?)}";
		int result = -1;
		try {
			CallableStatement  call = conn.prepareCall(sql);
			call.setString(1, carid);
			call.registerOutParameter(2, Types.INTEGER);
			call.execute();
			result = call.getInt(2);
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
