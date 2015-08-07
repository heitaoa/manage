package com.poly.dao.subDaos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import car_beans.DboNewCatalog;
import car_daos.DBConnect;
import car_daos.DboNewCatalogDao;

import com.poly.bean.TreeEntity;

public class DboNewCatalogSubDao extends DboNewCatalogDao{
	
	public List<TreeEntity> getNewsTreeInfo(){
		DBConnect dbc = null;
		List<TreeEntity> result = new ArrayList<TreeEntity>();
		String sql = "SELECT catalogid,fatherid,catalogname,areaid from dbo_new_catalog WHERE isdelete <> 1 ORDER BY lname";
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			TreeEntity treeEntity = null;
			while (rs.next()) {
				treeEntity = new TreeEntity();
				treeEntity.setId(rs.getInt("catalogid"));;
				treeEntity.setpId(rs.getInt("fatherid"));
				treeEntity.setName(rs.getString("catalogname"));
				treeEntity.setAreaid(rs.getInt("areaid"));
				result.add(treeEntity);
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
	
	
	public int addNewsTree(int fatherId,String name,String lname){
		DBConnect dbc = null;
		String  sql = "SELECT Max(catalogid) as max FROM dbo_new_catalog";
		int maxId = 0;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				maxId = rs.getInt("max");
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
		
		DboNewCatalog dboNewCatalog = new DboNewCatalog();
		dboNewCatalog.setCatalogid(maxId+1);
		dboNewCatalog.setCatalogname(name);
		dboNewCatalog.setFatherid(fatherId);
		dboNewCatalog.setIsdelete(0);
		dboNewCatalog.setLname(lname);
		
		try {
			this.save(dboNewCatalog);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return maxId+1;
		
	}
	
	public int deleteNewsTree(int id){
		DBConnect dbc = null;
		String  sql = "UPDATE dbo_new_catalog SET isdelete = 1 WHERE catalogid = ?";
		int result = -1 ;
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
	
	public int editNewsTreeName(int id,String name){
		DBConnect dbc = null;
		String  sql = "UPDATE dbo_new_catalog SET catalogname = ? WHERE catalogid = ?";
		int result = -1 ;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, name);
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
	
	
	public int updateNewsSite(int id,String siteid){
		DBConnect dbc = null;
		String  sql = "UPDATE dbo_new_catalog SET sub_sites_id = ? WHERE catalogid = ?";
		int result = -1 ;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, siteid);
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
	
	
	public int searchsite(String id){
		DBConnect dbc = null;
		int result = 0;
		String sql = "SELECT sub_sites_id from dbo_new_catalog WHERE isdelete <> 1 AND catalogid = ? ORDER BY lname";
		
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, id);
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				result = rs.getInt("sub_sites_id");
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
