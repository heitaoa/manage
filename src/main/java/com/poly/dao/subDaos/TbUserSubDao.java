package com.poly.dao.subDaos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.bean.TreeEntity;
import com.poly.bean.TreeEntity2;
import com.poly.service.AdminService;

import car_beans.TbUsers;
import car_daos.DBConnect;
import car_daos.DBConnectionManagerFin;
import car_daos.TbUsersDao;

public class TbUserSubDao extends TbUsersDao{
	public Map<String,Object> getUserInfo(String username){
		Map<String,Object> result = new HashMap<String,Object>();
		DBConnect dbc = null;
		String sql = "SELECT t1.prov,t1.city,t1.brands,t1.ulevel,t1.detail from tb_users t1 where t1.userid = ? and t1.isdelete  = 0";
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, username);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()) {
				result.put("prov", rs.getString("prov"));
				result.put("city", rs.getString("city"));
				result.put("brands", rs.getString("brands")==null||"-1".equals(rs.getString("brands")) ?"":rs.getString("brands"));
				result.put("ulevel", rs.getString("ulevel"));
				result.put("detail", rs.getString("detail"));
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
		if(result!=null&&result.size() > 0){
			List<Map<String, String>> finUser =  getFinUsers();
			for (Map<String, String> map : finUser) {
				if(username.equals(map.get("USER_CODE"))){
					result.put("site_name", map.get("ORG_NAME"));
				}
			}
			Map<String, String> mapx = getFinUsersByUid(username);
			if(mapx!=null&&mapx.size()!=0){
				result.put("realName", mapx.get("USER_NAME"));
			}
		}
		
		return result;
	}
	
	public List<Map<String, Object>> getFinanceSite(){
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = null;
		Connection dbc = null;
		String sql = "SELECT ORG_ID,ORG_NAME from finance.tb_fin_org";
		try {
			dbc = DBConnectionManagerFin.getInstance().getConnection();
			PreparedStatement pstmt = dbc.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				map = new HashMap<String, Object>();
				map.put("id", rs.getString("ORG_ID"));
				map.put("name", rs.getString("ORG_NAME"));
				result.add(map);
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
	
	public Map<String, Object> getOneUser(String id){
		Map<String,Object> map = null;
		DBConnect dbc = null;
		//String sql = "SELECT t1.id,t1.userid,t1.prov,t1.city,t1.brands,t1.ulevel,t2.USER_NAME from car_315.tb_users t1 LEFT JOIN finance.tb_fin_user t2 on t1.userid = t2.USER_CODE where t1.id="+id;
		String sql1 = "SELECT t1.id,t1.userid,t1.prov,t1.city,t1.brands,t1.ulevel from car_315.tb_users t1  where t1.id="+id;
		try {
			dbc = new DBConnect(sql1);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()) {
				map = new HashMap<String, Object>();
				map.put("id", rs.getString("id"));
				map.put("userid", rs.getString("userid"));
				map.put("prov", rs.getString("prov"));
				map.put("city", rs.getString("city"));
				map.put("brands", "-1".equals(rs.getString("brands"))?"":rs.getString("brands"));
				map.put("ulevel", rs.getString("ulevel"));
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
		if(map==null)
			return map;
		String sql2 = "select USER_NAME from tb_fin_user where USER_CODE='"+map.get("userid")+"'";
		Connection con = null;
		try {
			con = DBConnectionManagerFin.getInstance().getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql2);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				map.put("user_name", rs.getString("USER_NAME"));
			}
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return map;
	}
	
	public List<Map<String, Object>> getFinanceUser(String siteId,String name){
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> result2 = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = null;
		//DBConnect dbc = null;
		Connection con = null;
		String sql = "SELECT USER_CODE,USER_NAME,t1.ORG_CODE,t2.ORG_NAME from  finance.tb_fin_user t1 LEFT JOIN  finance.tb_fin_org t2 ON t1.ORG_CODE = t2.ORG_ID where t1.ISONJOB = 0 and USER_CODE like '%Poly%' "
				+ " and t1.USER_NAME like '%"+name+"%' "
				+ " and t1.ORG_CODE='"+siteId+"' ORDER BY t1.ORG_CODE,t1.USER_CODE";
		try {
			/*dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();*/
			con = DBConnectionManagerFin.getInstance().getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				map = new HashMap<String, Object>();
				map.put("USER_CODE", rs.getString("USER_CODE"));
				map.put("USER_NAME", rs.getString("USER_NAME"));
				map.put("ORG_CODE", rs.getString("ORG_CODE"));
				map.put("ORG_NAME", rs.getString("ORG_NAME"));
				result.add(map);
			}
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		List<TbUsers> users = TbUsersDao.where("isdelete = 0");
		for (int i=0;i<result.size();i++) {
			int count = 0;
			for (int j=0;j<users.size();j++) {
				if(result.get(i).get("USER_CODE").equals(users.get(j).getUserid()))
					count++;
			}
			if(count==0)
				result2.add(result.get(i));
		}
		return result2;
	}
	
	List<Map<String, String>> getFinUsers(){
		List<Map<String, String>> result = new ArrayList<Map<String,String>>();
		Map<String,String> map = null;
		Connection dbc = null;
		String sql = "SELECT USER_CODE,USER_NAME,ORG_CODE,ORG_NAME from tb_fin_user t1 LEFT JOIN tb_fin_org t2 on t1.ORG_CODE = t2.ORG_ID where  t1.ISONJOB = 0";
		try {
			dbc = DBConnectionManagerFin.getInstance().getConnection();
			PreparedStatement pstmt = dbc.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				map = new HashMap<String, String>();
				map.put("USER_CODE", rs.getString("USER_CODE"));
				map.put("USER_NAME", rs.getString("USER_NAME"));
				map.put("ORG_CODE", rs.getString("ORG_CODE"));
				map.put("ORG_NAME", rs.getString("ORG_NAME"));
				result.add(map);
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
	
	public Map<String, String> getFinUsersByUid(String uid){
		Map<String, String> result = new HashMap<String,String>();
		Connection dbc = null;
		String sql = "SELECT USER_CODE,USER_NAME,ORG_CODE from finance.tb_fin_user  where  USER_CODE='"+uid+"'";
		try {
			dbc = DBConnectionManagerFin.getInstance().getConnection();
			PreparedStatement pstmt = dbc.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				result.put("USER_NAME", rs.getString("USER_NAME"));
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
	//wrong
	public List<Map<String, Object>> getUser(String name){
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> result2 = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = null;
		DBConnect dbc = null;
		String sql = "SELECT t1.id,t1.userid,t2.user_name,t3.org_name,t1.ulevel FROM car_315.tb_users t1 LEFT JOIN finance.tb_fin_user t2 on t1.userid = t2.USER_CODE LEFT JOIN finance.tb_fin_org t3 on t2.ORG_CODE = t3.ORG_ID where t1.isdelete = 0 "
				+ " and t2.user_name like '%"+name+"%'"
				+ " ORDER BY t2.ORG_CODE,t1.ulevel,t2.user_code";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()) {
				map = new HashMap<String, Object>();
				map.put("id", rs.getString("id"));
				map.put("userid", rs.getString("userid"));
				map.put("ulevel",getLevelDetail(rs.getString("ulevel")));
				result.add(map);
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
		List<Map<String, String>> finList = getFinUsers();
		
		for (Map<String, Object> map2 : result) {
			for (Map<String, String> fin : finList) {
				if(map2.get("userid").equals(fin.get("USER_CODE"))){
					map2.put("user_name", fin.get("USER_NAME"));
					map2.put("org_name", fin.get("ORG_NAME"));
					result2.add(map2);
				}
			}
		}
		
		
		return result2;
	}
	//wrong
	public List<Map<String, Object>> getStationUser(String name,String siteid,String userid){
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> result2 = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = null;
		DBConnect dbc = null;
		String sql = "SELECT t1.brands,t1.id,t1.userid,t2.user_name,t3.org_name,t1.ulevel FROM car_315.tb_users t1 LEFT JOIN finance.tb_fin_user t2 on t1.userid = t2.USER_CODE LEFT JOIN finance.tb_fin_org t3 on t2.ORG_CODE = t3.ORG_ID where t1.isdelete = 0 "
				+ " and t2.user_name like '%"+name+"%'"
				+ " and t2.ORG_CODE='"+siteid+"'"
				+ " and t1.userid !='"+userid+"'"
				+ " ORDER BY t2.ORG_CODE,t1.ulevel,t2.user_code";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()) {
				map = new HashMap<String, Object>();
				map.put("id", rs.getString("id"));
				map.put("userid", rs.getString("userid"));
				map.put("user_name", rs.getString("user_name"));
				map.put("org_name", rs.getString("org_name"));
				map.put("ulevel",getLevelDetail(rs.getString("ulevel")));
				map.put("brands","-1".equals(rs.getString("brands"))?"":rs.getString("brands"));
				result.add(map);
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
		List<TbUsers> users = TbUsersDao.where("isdelete = 0");
		for (Map<String, Object> map2 : result) {
			for (TbUsers tbUsers : users) {
				if(map2.get("userid").equals(tbUsers.getUserid())){
					map2.put("id",tbUsers.getId());
					map2.put("brands","-1".equals(tbUsers.getBrands())?"":tbUsers.getBrands());
					result2.add(map2);
				}
			}
		}
		
		return result2;
	}
	
	public List<String> getUsedBrands(String siteid){
		List<String> result = new ArrayList<String>();
		DBConnect dbc = null;
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		Map<String, String> map = null;
		String sql = "SELECT t1.userid,t1.brands from car_315.tb_users t1  where  t1.isdelete = 0 and brands!='-1' ";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()) {
				map = new HashMap<String, String>();
				map.put("userid",rs.getString("userid"));
				map.put("brands", rs.getString("brands"));
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
		List<Map<String, String>> finList = getFinUsers();
		for (Map<String, String> map2 : list) {
			for (Map<String, String> fin : finList) {
				if(map2.get("userid").equals(fin.get("USER_CODE"))&&fin.get("ORG_CODE").equals(siteid))
					result.add(map2.get("brands")+",");
			}
		}
		
		return result;
	}
	public List<Map<String, String>> listBianji(){
		List<String> ids = new ArrayList<String>();
		List<Map<String, String>> bianjiList = new ArrayList<Map<String,String>>();
		List<String> nameList = new ArrayList<String>();
		
		DBConnect dbc = null;
		String sql = "SELECT userid from tb_users where ulevel like '%4%' or  ulevel like '%5%' ";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()){
				ids.add(rs.getString("userid"));
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
		List<Map<String, String>> finList = getFinUsers();
		for (Map<String, String> map : finList) {
			for (String id : ids) {
				if(id.equals(map.get("USER_CODE"))){
					nameList.add(map.get("USER_NAME"));
				}
			}
		}
		List<Map<String, String>> userList = new ArrayList<Map<String,String>>();
		
		String sql2 = "SELECT username,realname from dbo_adm_user";
		try {
			dbc = new DBConnect(sql2);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()){
				Map<String, String> userMap = new HashMap<String, String>();
				userMap.put("username", rs.getString("username"));
				userMap.put("realname", rs.getString("realname"));
				userList.add(userMap);
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
		
		for (Map<String, String> map : userList) {
			for (String name : nameList) {
				if(name.equals(map.get("realname"))){
					bianjiList.add(map);
				}
				
					
			}
		}
		/*for (Map<String, String> map : bianjiList) {
			System.err.println(map.get("realname"));
			System.err.println(map.get("username"));
		}*/
		return bianjiList;
	
	}
	String getLevelDetail(String str){
		String level = "";
		if(str.contains("0"))
			level +="系统管理员,";
		if(str.contains("1"))
			level +="大客户销售,";
		if(str.contains("2"))
			level +="销售,";
		if(str.contains("3"))
			level +="客服,";
		if(str.contains("4"))
			level +="总站编辑,";
		if(str.contains("5"))
			level +="分站编辑,";
		if(str.contains("6"))
			level +="分站管理员,";
		
		return level.substring(0,level.length()-1);
	}
	
	
	
	public List<Map<String, String>> listEditor()throws Exception{
		
		List<Map<String, String>> resList = new ArrayList<Map<String,String>>();
		
		List<String> ids = new ArrayList<String>();
		
		DBConnect dbc = null;
		String sql = "SELECT userid from tb_users where ulevel like '%4%' or  ulevel like '%5%' ";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()){
				ids.add(rs.getString("userid"));
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
		
		List<Map<String, String>> finList = getFinUsers();
		for (Map<String, String> map : finList) {
			for (String userid : ids) {
				if(userid.equals(map.get("USER_CODE"))){
					map.put("userid", userid);
					
					String addadmin = AdminService.getInstance().getOldUser(userid);
					map.put("addadmin", addadmin);
					
					
					
					resList.add(map);
				}
			}
		}
		
		return resList;
	
	}
	
	public List<TreeEntity> getULevelTree(){
		DBConnect dbc = null;
		List<TreeEntity> result = new ArrayList<TreeEntity>();
		String sql = "SELECT id,fatherid,`name` from dbo_adm_function where isdelete = 0";
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			TreeEntity treeEntity = null;
			while (rs.next()) {
				treeEntity = new TreeEntity();
				treeEntity.setId(rs.getInt("id"));;
				treeEntity.setpId(rs.getInt("fatherid"));
				treeEntity.setName(rs.getString("name"));
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
	/**
	 * 获取客服所分管的项目
	 * @param uname
	 * @return
	 */
	public String queryTuiguangPro(String uname){
		DBConnect dbc = null;
		String str = "";
		String sql = "SELECT pro_num,custom_service,ini_man from tb_data_project where pro_state in (3,5,100)";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				String pro_num = rs.getString("pro_num");
				String custom_service = rs.getString("custom_service");
				String ini_man = rs.getString("ini_man");
				if(custom_service != null && custom_service.length() > 0){
					String[] ids = custom_service.split(",");
					if(ids.length > 0){
						for (String id : ids) {
							if(uname.equals(id)){
								str += pro_num + ",";
							}
						}
						
					}
				}
				if(uname.equals(ini_man)){
					if(!str.contains(pro_num))
						str += pro_num + ",";
				}
					
				
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
		if(str.length() > 0)
			str = str.substring(0,str.length()-1);
		return str;
	}
}
