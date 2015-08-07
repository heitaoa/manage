package com.poly.dao.subDaos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import car_beans.DboImgNewtitle;
import car_daos.DBConnect;
import car_daos.DboImgNewtitleDao;

import com.poly.bean.ChangeSortEntity;

public class DboImgNewtitleSubDao extends DboImgNewtitleDao {

	

	HashMap<String, Object> map = null;

	public List<HashMap<String, Object>> getTitleInfo(String catalogid,
			int start, int rows) {
		DBConnect dbc = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		
		if(("").equals(catalogid)){
			
			return result;
		}

		String sql = "SELECT count(*) as count FROM dbo_img_newcatalog a INNER JOIN "
				+ "dbo_img_newtitle c ON c.catalogid = a.catalogid "
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

		sql = "SELECT c.id,c.title,a.catalogname,c.type,c.addadmin,c.adddate,a.fatherid,a.catalogid,c.keywords FROM dbo_img_newcatalog a "
				+ "INNER JOIN dbo_img_newtitle c ON c.catalogid = a.catalogid "
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
		
		String sql = "SELECT c.id,c.title,a.catalogname,c.type,c.addadmin,c.adddate,a.fatherid,a.catalogid,c.keywords FROM dbo_img_newcatalog a "
				+ " INNER JOIN dbo_img_newtitle c ON c.catalogid = a.catalogid WHERE c.id = ?";
		
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

		String sql = "SELECT id,titleId,title,keywords,path FROM dbo_img_newcontent WHERE isdelete = 0 AND titleId in ("
				+ idStr + ")";
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
		String sql = "SELECT DISTINCT(addadmin) FROM dbo_img_newtitle WHERE isdelete = 0";
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
		String sql = "SELECT id,titleId,title,path,adddate,sortid FROM dbo_img_newcontent WHERE isdelete = 0 AND titleId = ? ORDER BY sortid ";
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
		String sql = "SELECT count(*) as count FROM dbo_img_newcontent WHERE isdelete = 0 AND titleId = ? ORDER BY sortid";
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
		sql = "SELECT id,titleId,title,path,adddate,sortid FROM dbo_img_newcontent WHERE isdelete = 0 AND titleId = ? ORDER BY sortid limit ?,?";
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
		String sql = "UPDATE dbo_img_newtitle SET isdelete = 1 WHERE id = ?";
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, titleid);
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
		DBConnect dbc = null;
		int result = -1;
		String sql = "UPDATE dbo_img_newcontent SET isdelete = 1 WHERE id = ?";
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, id);
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
		String sql = "UPDATE dbo_img_newcontent SET comefrom = ? WHERE id = ?";
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, comefrom);
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
	
	
	public int changeSort(ChangeSortEntity changeSortEntity){
		DBConnect dbc = null;
		int result = -1;
		String sql = "UPDATE dbo_img_newcontent SET sortid = ? WHERE id = ?";
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, changeSortEntity.getChangesort());
			dbc.setInt(2, changeSortEntity.getNowid());
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
		
		sql = "UPDATE dbo_img_newcontent SET sortid = ? WHERE id = ?";
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, changeSortEntity.getNowsort());
			dbc.setInt(2, changeSortEntity.getChangeid());
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
		String  sql = "SELECT MAX(id) as max FROM dbo_img_newtitle";
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
	
	public int addTitle(DboImgNewtitle dboImgTitle) throws Exception{
		int addid = getTitleMaxid()+1;
		dboImgTitle.setId(addid);
		dboImgTitle.setToptime(new Date());
		dboImgTitle.setSinktime(new Date());
		dboImgTitle.setAdddate(new Date());
		dboImgTitle.setLastupdate(new Date());
		this.save(dboImgTitle);
		return addid;
	}
	
	public int deleteTitle(int id){
		DBConnect dbc = null;
		String sql = "update dbo_img_newtitle set isdelete = 1 where id = ?";
		int result = -1;
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, id);
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

}
