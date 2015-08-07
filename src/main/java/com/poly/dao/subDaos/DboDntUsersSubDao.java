package com.poly.dao.subDaos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import car_daos.DBConnect;
import car_daos.DboDntUsersDao;

import com.poly.bean.UserEntity;

public class DboDntUsersSubDao extends DboDntUsersDao{
	
	
	
	HashMap<String, Object> map = null;
	
	public List<String> getUsedBrand(int ulevel,String sid){

		DBConnect dbc = null;
		List<String> result = new ArrayList<String>();
		String sql = "SELECT a.pass FROM dbo_dnt_users a INNER JOIN dbo_dnt_userlevel b ON a.uid = b.uid where b.sub_sites_id = "+sid+" and a.gender = 2 and b.ulevel = "+ulevel+" and pass is not NULL";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()){
				result.add(rs.getString("pass"));
			}

		}  catch (Exception e) {
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
	public List<HashMap<String, Object>> getStationUsersInfo(int ulevel,String sid){

		DBConnect dbc = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String sql = "SELECT a.pass,a.uid,a.username,a.nickname,b.ulevel,a.password,a.spaceid,c.catalogname,a.secques,d.catalogname 'prov' FROM dbo_dnt_users a INNER JOIN dbo_dnt_userlevel b ON a.uid = b.uid "
				+ "left outer JOIN dbo_are_catalog c ON a.spaceid = c.catalogid LEFT OUTER JOIN dbo_are_catalog d ON a.secques = d.catalogid "
				+ "WHERE b.sub_sites_id = "+sid+" and a.gender = 2 and b.ulevel = "+ulevel+"";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()){
				map = new HashMap<String, Object>();
				map.put("uid", rs.getInt("uid"));
				map.put("username", rs.getString("username"));
				map.put("nickname", rs.getString("nickname"));
				map.put("password", rs.getString("password"));
				map.put("spaceid", rs.getInt("spaceid"));
				map.put("catalogname", rs.getString("catalogname"));
				map.put("prov", rs.getString("prov")==null?"":rs.getString("prov"));
				map.put("secques", rs.getString("secques")==null?"-1":rs.getString("secques"));
				map.put("brands", rs.getString("pass")==null?"":rs.getString("pass"));
				result.add(map);
			}

		}  catch (Exception e) {
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
	
	public List<HashMap<String, Object>> getUsersInfo(String username){
		DBConnect dbc = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String sql = "SELECT a.uid,a.username,a.nickname,b.ulevel,a.password,a.gender,b.sub_sites_id as siteid ,c.`name` FROM dbo_dnt_users a INNER JOIN dbo_dnt_userlevel b ON a.uid = b.uid "
				+ "LEFT JOIN tb_sub_sites c ON b.sub_sites_id = c.id "
				+ "WHERE 1=1 ";
		if(username!=null && !("").equals(username)){
			sql = sql+ "AND a.username LIKE '%"+username+"%'";
		}
		sql = sql + " order by siteid,b.ulevel";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()){
				map = new HashMap<String, Object>();
				map.put("uid", rs.getInt("uid"));
				map.put("username", rs.getString("username"));
				map.put("nickname", rs.getString("nickname"));
				map.put("ulevel", rs.getInt("ulevel"));
				map.put("password", rs.getString("password"));
				map.put("gender", rs.getString("gender")==null?"0":rs.getString("gender"));
				map.put("siteid", rs.getString("siteid")==null?"0":rs.getString("siteid"));
				map.put("name", rs.getString("name")==null?"总站":rs.getString("name"));
				result.add(map);
			}

		}  catch (Exception e) {
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
	public int addStationUser(UserEntity user){

		DBConnect dbc = null;
		int result = -1;
		
		String sql ="SELECT MAX(uid) as max FROM dbo_dnt_users";
		
		int max = 0;
		
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			if(rs.next()){
				max = rs.getInt("max");
			}

		}  catch (Exception e) {
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
		
		
		int uid = max +1;
		
		sql = "INSERT INTO dbo_dnt_users(`uid`,`username`,`nickname`,`password`,`spaceid`,`secques`,`groupid`,`pass`,`gender`) VALUES (?,?,?,?,?,?,?,?,2)";
		
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, uid);
			dbc.setString(2, user.getUsername());
			dbc.setString(3, user.getNickname());
			dbc.setString(4, user.getPassword());
			dbc.setString(5, user.getUcity());
			dbc.setString(6, user.getUprov());
			dbc.setString(7, user.getGroupid());
			dbc.setString(8, "-1".equals(user.getBrands())? null:user.getBrands());
			result = dbc.executeUpdateReturnInt();
		}  catch (Exception e) {
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
		
		sql = "INSERT INTO dbo_dnt_userlevel(`uid`,`ulevel`,`isdelete`,`sub_sites_id`) VALUES (?,?,0,?)";
		
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, uid);
			dbc.setString(2, user.getUlevel());
			dbc.setString(3, user.getSiteid());
			result = dbc.executeUpdateReturnInt();
		}  catch (Exception e) {
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
	public int addUser(UserEntity user){
		DBConnect dbc = null;
		int result = -1;
		
		String sql ="SELECT MAX(uid) as max FROM dbo_dnt_users";
		
		int max = 0;
		
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			if(rs.next()){
				max = rs.getInt("max");
			}

		}  catch (Exception e) {
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
		
		
		int uid = max +1;
		
		sql = "INSERT INTO dbo_dnt_users(`uid`,`username`,`nickname`,`password`,`spaceid`,`secques`,`gender`) VALUES (?,?,?,?,?,?,?)";
		
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, uid);
			dbc.setString(2, user.getUsername());
			dbc.setString(3, user.getNickname());
			dbc.setString(4, user.getPassword());
			dbc.setString(5, user.getUcity());
			dbc.setString(6, user.getUprov());
			dbc.setString(7, user.getUfman());
			result = dbc.executeUpdateReturnInt();
		}  catch (Exception e) {
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
		
		sql = "INSERT INTO dbo_dnt_userlevel(`uid`,`ulevel`,`isdelete`,`sub_sites_id`) VALUES (?,?,0,?)";
		
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, uid);
			dbc.setString(2, user.getUlevel());
			dbc.setString(3, user.getSiteid());
			result = dbc.executeUpdateReturnInt();
		}  catch (Exception e) {
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
	
	public int updateUserPwd(String id,String pwd){

		DBConnect dbc = null;
		int result = -1;
		
		String sql = "UPDATE dbo_dnt_users SET password=? WHERE uid = ?";
		
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, pwd);
			dbc.setString(2, id);
			result = dbc.executeUpdateReturnInt();
		}  catch (Exception e) {
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
	public int updateUser(UserEntity user){
		DBConnect dbc = null;
		int result = -1;
		
		String sql = "UPDATE dbo_dnt_users SET username = ?, nickname =?,password=?,spaceid = ?,secques=? ,gender =? WHERE uid = ?";
		
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, user.getUsername());
			dbc.setString(2, user.getNickname());
			dbc.setString(3, user.getPassword());
			dbc.setString(4, user.getUcity());
			dbc.setString(5, user.getUprov());
			dbc.setString(6, user.getUfman());
			dbc.setString(7, user.getUid());
			result = dbc.executeUpdateReturnInt();
		}  catch (Exception e) {
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
		
		sql = "UPDATE dbo_dnt_userlevel SET ulevel = ?,sub_sites_id = ? WHERE uid = ?";
		
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, user.getUlevel());
			dbc.setString(2, user.getSiteid());
			dbc.setString(3, user.getUid());
			result = dbc.executeUpdateReturnInt();
		}  catch (Exception e) {
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
	public int updateStationUser(UserEntity user){

		DBConnect dbc = null;
		int result = -1;
		
		String sql = "UPDATE dbo_dnt_users SET username = ?, nickname =?,password=?,spaceid = ?,secques=?,pass=?  WHERE uid = ?";
		
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, user.getUsername());
			dbc.setString(2, user.getNickname());
			dbc.setString(3, user.getPassword());
			dbc.setString(4, user.getUcity());
			dbc.setString(5, user.getUprov());
			dbc.setString(6, user.getBrands());
			dbc.setString(7, user.getUid());
			result = dbc.executeUpdateReturnInt();
		}  catch (Exception e) {
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
	public int deleteUser(String uid){
		DBConnect dbc = null;
		int result = -1;
		String sql = "DELETE FROM dbo_dnt_users WHERE uid = ?";
		
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, uid);
			result = dbc.executeUpdateReturnInt();
		}  catch (Exception e) {
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
		
		sql = "DELETE FROM dbo_dnt_userlevel WHERE uid = ?";
		
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, uid);
			result = dbc.executeUpdateReturnInt();
		}  catch (Exception e) {
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
	
	public String isNameExist(String username){
		String result = "";
		DBConnect dbc = null;
		String sql = "select username from dbo_dnt_users where username = ?";
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, username);
			ResultSet rs = dbc.executeQuery();
			if(rs.next()){
				result = rs.getString("username");
			}
		}  catch (Exception e) {
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

}
