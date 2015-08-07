package com.poly.dao.subDaos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import car_beans.DboAreCatalog;
import car_daos.DBConnect;
import car_daos.DboAreCatalogDao;

import com.poly.bean.TreeEntity;

public class DboAreCatalogSubDao extends DboAreCatalogDao{
	
	public List<TreeEntity> getAreTreeInfo(){
		DBConnect dbc = null;
		List<TreeEntity> result = new ArrayList<TreeEntity>();
		String sql = "SELECT catalogid,fatherid,catalogname,lname from dbo_are_catalog WHERE isdelete <> 1 ORDER BY lname,catalogname";
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			TreeEntity treeEntity = null;
			while (rs.next()) {
				treeEntity = new TreeEntity();
				treeEntity.setId(rs.getInt("catalogid"));;
				treeEntity.setpId(rs.getInt("fatherid"));
				treeEntity.setName(rs.getString("catalogname"));
				treeEntity.setLname(rs.getString("lname"));
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
	
	
	public int addAreTree(int fatherId,String name,String lname){
		DBConnect dbc = null;
		String  sql = "SELECT Max(catalogid) as max FROM dbo_are_catalog";
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
		
		DboAreCatalog dboAreCatalog = new DboAreCatalog();
		dboAreCatalog.setCatalogid(maxId+1);
		dboAreCatalog.setCatalogname(name);
		dboAreCatalog.setFatherid(fatherId);
		dboAreCatalog.setIsdelete(0);
		dboAreCatalog.setLname(lname);
		
		try {
			this.save(dboAreCatalog);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return maxId+1;
		
	}
	
	public int deleteAreTree(int id){
		DBConnect dbc = null;
		String  sql = "UPDATE dbo_are_catalog SET isdelete = 1 WHERE catalogid = ?";
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
	
	public int editAreTreeName(int id,String name){
		DBConnect dbc = null;
		String  sql = "UPDATE dbo_are_catalog SET catalogname = ? WHERE catalogid = ?";
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
	
	public List<TreeEntity> getAreTreeAll(){
		DBConnect dbc = null;
		List<TreeEntity> result = new ArrayList<TreeEntity>();
		String sql = "SELECT catalogid,byname,englingname from dbo_are_catalog WHERE isdelete <> 1 ";
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			TreeEntity treeEntity = null;
			while (rs.next()) {
				treeEntity = new TreeEntity();
				treeEntity.setId(rs.getInt("catalogid"));;
				treeEntity.setpId(rs.getInt("byname"));
				treeEntity.setName(rs.getString("englingname"));
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

}
