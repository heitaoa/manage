package com.poly.dao.subDaos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import car_beans.DboImgNewcatalog;
import car_daos.DBConnect;
import car_daos.DboImgNewcatalogDao;

import com.poly.bean.TreeEntity;

public class DboImgNewcatalogSubDao extends DboImgNewcatalogDao{
	
	public List<TreeEntity> getImgNewTreeInfo(){
		DBConnect dbc = null;
		List<TreeEntity> result = new ArrayList<TreeEntity>();
		String sql = "SELECT catalogid,fatherid,catalogname from dbo_img_newcatalog WHERE isdelete <> 1 ORDER BY lname";
		
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
	
	
	public int addImgNewTree(int fatherId,String name,String lname){
		DBConnect dbc = null;
		String  sql = "SELECT Max(catalogid) as max FROM dbo_img_newcatalog";
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
		
		DboImgNewcatalog dboImgNewcatalog = new DboImgNewcatalog();
		dboImgNewcatalog.setCatalogid(maxId+1);
		dboImgNewcatalog.setCatalogname(name);
		dboImgNewcatalog.setFatherid(fatherId);
		dboImgNewcatalog.setIsdelete(0);
		dboImgNewcatalog.setLname(lname);
		dboImgNewcatalog.setAdddate(new Date());
		
		try {
			this.save(dboImgNewcatalog);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return maxId+1;
		
	}
	
	public int deleteImgNewTree(int id){
		DBConnect dbc = null;
		String  sql = "UPDATE dbo_img_newcatalog SET isdelete = 1 WHERE catalogid = ?";
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
	
	public int editImgNewTreeName(int id,String name){
		DBConnect dbc = null;
		String  sql = "UPDATE dbo_img_newcatalog SET catalogname = ? WHERE catalogid = ?";
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
	
	public String getImgName(int catalogid){
		DBConnect dbc = null;
		String result ="";
		String  sql = "SELECT catalogname FROM dbo_img_newcatalog WHERE catalogid = ?";
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, catalogid);
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				result = rs.getString("catalogname");
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
