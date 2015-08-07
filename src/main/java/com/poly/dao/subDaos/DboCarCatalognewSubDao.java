package com.poly.dao.subDaos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import car_beans.DboCarAutohomeprop;
import car_beans.DboCarCatalognew;
import car_daos.DBConnect;
import car_daos.DboCarAutohomepropDao;
import car_daos.DboCarCatalognewDao;

import com.poly.bean.TreeEntity;
import com.poly.util.DeleteCarParamFileUtil;
import com.redis.RedisDao;

public class DboCarCatalognewSubDao extends DboCarCatalognewDao{
	
	public List<TreeEntity> getCarNewTreeInfo(){
		DBConnect dbc = null;
		List<TreeEntity> result = new ArrayList<TreeEntity>();
		String sql = "SELECT catalogid,fatherid,catalogname,lname from dbo_car_catalognew WHERE isdelete <> 1 ORDER BY lname,catalogname";
		
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
	
	public List<TreeEntity> getCarNewTreeInfo2(){
		DBConnect dbc = null;
		List<TreeEntity> result = new ArrayList<TreeEntity>();
		String sql = "SELECT catalogid,fatherid,catalogname,lname,pathlevel from dbo_car_catalognew WHERE isdelete <> 1 ORDER BY lname,catalogname";
		
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
				treeEntity.setPathlevel(rs.getString("pathlevel"));
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
	public String getCarName(int catalogid){
		DBConnect dbc = null;
		String result ="";
		String  sql = "SELECT catalogname FROM dbo_car_catalognew WHERE catalogid = ?";
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
	
	
	public int addCarNewTree(int fatherId,String name,String lname){
		DBConnect dbc = null;
		String  sql = "SELECT Max(catalogid) as max FROM dbo_car_catalognew";
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
		
		sql = "SELECT pathlevel FROM dbo_car_catalognew WHERE catalogid = ?";
		int pathlevel = 1;
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, fatherId);
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				pathlevel = rs.getInt("pathlevel")+1;
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
		String  chexiname = "";
		String iway = "";
		if(pathlevel == 3){
			sql = "SELECT catalogname,iway FROM dbo_car_catalognew WHERE catalogid = ?";
			try {
				dbc = new DBConnect(sql);
				dbc.setInt(1, fatherId);
				ResultSet rs = dbc.executeQuery();
				if (rs.next()) {
					chexiname = rs.getString("catalogname");
					iway = rs.getString("iway");
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
		}else{
			chexiname = name;
		}
		
		String byname = name.replace(chexiname+" ", "");
		DboCarCatalognew dboCarCatalognew = new DboCarCatalognew();
		dboCarCatalognew.setCatalogid(maxId+1);
		dboCarCatalognew.setCatalogname(name);
		dboCarCatalognew.setByname(byname);
		dboCarCatalognew.setFatherid(fatherId);
		dboCarCatalognew.setIsdelete(0);
		dboCarCatalognew.setLname(lname);
		dboCarCatalognew.setAdddate(new Date());
		dboCarCatalognew.setLastupdate(new Date());
		dboCarCatalognew.setPathlevel(pathlevel);
		dboCarCatalognew.setIslive(1);
		dboCarCatalognew.setOnsale(1);
		dboCarCatalognew.setIway(iway);
		
		try {
			this.save(dboCarCatalognew);
			if(dboCarCatalognew.getPathlevel()==3){
				String  autosql = "SELECT Max(id) as max FROM dbo_car_autohomeprop";
				int automaxId = 0;
				try {
					dbc = new DBConnect(autosql);
					ResultSet rs = dbc.executeQuery();
					if (rs.next()) {
						automaxId = rs.getInt("max");
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
				DboCarAutohomeprop autohomeprop=new DboCarAutohomeprop();
				autohomeprop.setId(automaxId+1);
				autohomeprop.setCarid(maxId+1);
				autohomeprop.setAutohomecarid(0);
				autohomeprop.setIway(iway);
				DboCarAutohomepropDao.save(autohomeprop);
				RedisDao.UpDateAutohomepropByAdd(maxId+1, autohomeprop);
			}
			RedisDao.UpDateCatalognowByAdd(maxId+1, dboCarCatalognew);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return maxId+1;
		
	}
	
	public int deleteCarNewTree(int id){
		DeleteCarParamFileUtil.deleteTuKuPriceFile(id+"","carCatalogNew");
		DBConnect dbc = null;
		List<DboCarCatalognew> olds=DboCarCatalognewDao.where(" catalogid="+id);
		String  sql = "UPDATE dbo_car_catalognew SET isdelete = 1 WHERE catalogid = ?";
		int result = -1 ;
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, id);
			result = dbc.executeUpdateReturnInt();
			RedisDao.UpDateCatalognowByDelete(id,olds.get(0));
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
	
	public int editCarNewTreeName(int id,String name){
		DBConnect dbc = null;
		String  sql = "UPDATE dbo_car_catalognew SET catalogname = ? WHERE catalogid = ?";
		int result = -1 ;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, name);
			dbc.setInt(2, id);
			result = dbc.executeUpdateReturnInt();
			RedisDao.UpDateCatalognowByEdit(id,name);
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
		DeleteCarParamFileUtil.deleteTuKuPriceFile(id+"","carCatalogNew");
		return result;
	}
	
	public List<Map<String, String>> queryIwayByBrandId(int brandid){
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		DBConnect dbc = null;
		String  sql = "SELECT DISTINCT(iway) from dbo_car_catalognew where isdelete = 0 and fatherid = "+brandid+" and pathlevel = 2 and iway is not null and iway!=''";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("iway", rs.getString("iway"));
				list.add(map);
				
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
		return list;
	}
	
}
