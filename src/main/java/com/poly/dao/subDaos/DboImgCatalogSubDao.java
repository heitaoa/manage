package com.poly.dao.subDaos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import car_beans.DboImgCatalog;
import car_daos.DBConnect;
import car_daos.DboImgCatalogDao;

import com.poly.bean.TreeEntity;
import com.poly.util.DeleteCarParamFileUtil;

public class DboImgCatalogSubDao extends DboImgCatalogDao{
	
	public List<TreeEntity> getImgTreeInfo(){
		DBConnect dbc = null;
		List<TreeEntity> result = new ArrayList<TreeEntity>();
		String sql = "SELECT catalogid,fatherid,catalogname from dbo_img_catalog WHERE isdelete <> 1 ORDER BY lname";
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			TreeEntity treeEntity = null;
			while (rs.next()) {
				treeEntity = new TreeEntity();
				treeEntity.setId(rs.getInt("catalogid"));;
				treeEntity.setpId(rs.getInt("fatherid"));
				treeEntity.setName(rs.getString("catalogname"));
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
	
	
	public int addImgTree(int fatherId,String name,String lname){
		DBConnect dbc = null;
		String  sql = "SELECT Max(catalogid) as max FROM dbo_img_catalog";
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
		
		DboImgCatalog dboimgcatalog = new DboImgCatalog();
		dboimgcatalog.setCatalogid(maxId+1);
		dboimgcatalog.setCatalogname(name);
		dboimgcatalog.setFatherid(fatherId);
		dboimgcatalog.setIsdelete(0);
		dboimgcatalog.setLname(lname);
		dboimgcatalog.setAdddate(new Date());
		
		try {
			this.save(dboimgcatalog);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return maxId+1;
		
	}
	
	public int deleteImgTree(int id){
		DBConnect dbc = null;
		String  sql = "UPDATE dbo_img_catalog SET isdelete = 1 WHERE catalogid = ?";
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
	
	public int editImgTreeName(int id,String name){
		DBConnect dbc = null;
		String  sql = "UPDATE dbo_img_catalog SET catalogname = ? WHERE catalogid = ?";
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

}
