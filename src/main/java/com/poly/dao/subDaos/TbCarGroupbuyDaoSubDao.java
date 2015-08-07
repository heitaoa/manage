package com.poly.dao.subDaos;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.service.ImageService.carImg;
import com.poly.service.SaleFavoredService.StationType;
import com.poly.util.MyConfig;

import car_beans.DboCarCatalognew;
import car_daos.DBConnect;
import car_daos.TbCarGroupbuyDao;

public class TbCarGroupbuyDaoSubDao extends TbCarGroupbuyDao {

	HashMap<String, Object> map = null;

	public List<DboCarCatalognew> getCarBrandByFatherId(int fatherid) {
		DBConnect dbc = null;
		String sql = "select t1.catalogid,t1.catalogname,t1.lname from dbo_car_catalognew  t1 join dbo_car_autohomeprop t2 on t1.catalogid = t2.carid where t1.isdelete = 0 and fatherid="
				+ fatherid;
		List<DboCarCatalognew> list = new ArrayList<DboCarCatalognew>();

		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarCatalognew dbocarcatalognew = new DboCarCatalognew();
				dbocarcatalognew.setCatalogid(rs.getInt("catalogid"));
				dbocarcatalognew.setCatalogname(rs.getString("catalogname"));
				dbocarcatalognew.setLname(rs.getString("lname"));
				list.add(dbocarcatalognew);
			}
		} catch (Exception e) {
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


	public Map<String, Object> getCarGroupById(int id) {
		DBConnect dbc = null;
		Map<String, Object> result = new HashMap<String, Object>();
		String sql = "select t1.* ,t2.iway,t2.fatherid rootid ,t3.ename from tb_car_groupbuy t1 join dbo_car_catalognew t2 on t1.fatherid= t2.catalogid  join dbo_dea_dealers t3 on t1.deaid = t3.eid where t1.id=?";
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, id);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				result.put("id", rs.getInt("id"));
				result.put("carid", rs.getInt("carid"));
				result.put("deaid", rs.getInt("deaid"));
				result.put("begdate", rs.getDate("begdate"));
				result.put("enddate", rs.getDate("enddate"));
				result.put("pic", rs.getString("pic"));
				result.put("time_info", rs.getString("time_info"));
				result.put("car_info", rs.getString("car_info"));
				result.put("title", rs.getString("title"));
				result.put("address", rs.getString("address"));
				result.put("info", rs.getString("info"));
				result.put("register_num", rs.getInt("register_num"));
				result.put("surplus_num", rs.getInt("surplus_num"));
				result.put("price", rs.getDouble("price"));
				result.put("active_type", rs.getInt("active_type"));
				result.put("buy_type", rs.getInt("buy_type"));
				result.put("fatherid", rs.getInt("fatherid"));
				result.put("rootid", rs.getInt("rootid"));
				result.put("adddate", rs.getString("adddate"));
				result.put("ename", rs.getString("ename"));
				result.put("iway", rs.getString("iway"));
				result.put("isdelete", rs.getInt("isdelete"));
				result.put("sites_id", rs.getInt("sites_id"));
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

	public List<HashMap<String, Object>> getDeaDealers(int start, int rows, String dea) {
		DBConnect dbc = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String sql1 = "SELECT T1.eid,T1.ename,T2.catalogname cityName,T3.catalogname provName FROM dbo_dea_dealers T1 JOIN  dbo_are_catalog T2 ON T1.areaid = T2.catalogid JOIN dbo_are_catalog T3 ON T2.fatherid = T3.catalogid where T1.isdelete = 0 and "
				+ "T1.ename like '%"+dea+"%' LIMIT ?,?";
		String sql2 = "SELECT count(*) count FROM dbo_dea_dealers T1 JOIN  dbo_are_catalog T2 ON T1.areaid = T2.catalogid JOIN dbo_are_catalog T3 ON T2.fatherid = T3.catalogid where T1.isdelete = 0 and "
				+ " T1.ename like '%"+dea+"%'";
		int count = 0;
		try {
			dbc = new DBConnect(sql2);
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
		try {
			dbc = new DBConnect(sql1);
			dbc.setInt(1, start);
			dbc.setInt(2, rows);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("count", count);
				map.put("eid", rs.getInt("eid"));
				map.put("ename", rs.getString("ename"));
				map.put("cityName", rs.getString("cityName"));
				map.put("provName", rs.getString("provName"));
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
	public HashMap<String, String> getPre(String id){

		DBConnect dbc = null;
		HashMap<String, String> map = new HashMap<String, String>();
		String sql1 = "select t1.time_info,t1.car_info, t1.surplus_num ,t5.catalogid as rootId,t5.photo,t5.catalogname as rootname,t4.catalogname as fatherName,t1.fatherid,t1.carid, t1.pic,t1.title,t1.info,t1.begdate,t1.enddate,t1.address,t1.register_num,t2.catalogname from tb_car_groupbuy t1 LEFT OUTER join dbo_car_catalognew t2 on t1.carid=t2.catalogid LEFT outer join dbo_car_catalognew t4 on t2.fatherid = t4.catalogid left OUTER JOIN dbo_car_catalognew t5 on t5.catalogid = t4.fatherid  where    t1.id = "+id;
		try {
			dbc = new DBConnect(sql1);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map.put("pic", getImagePath(rs.getString("pic")));
				map.put("time_info", rs.getString("time_info")==null?"":rs.getString("time_info"));
				map.put("car_info", rs.getString("car_info")==null?"":rs.getString("car_info"));
				map.put("title",rs.getString("title"));
				map.put("info", rs.getString("info"));
				Date begdate=rs.getDate("begdate");
				SimpleDateFormat format=new SimpleDateFormat("yyyy.MM.dd"); 
				map.put("begdate",format.format(begdate));
				Date enddate=rs.getDate("enddate");
				map.put("enddate", format.format(enddate));
				map.put("address", rs.getString("address"));
				map.put("register_num", rs.getString("register_num"));
				map.put("surplus_num", rs.getString("surplus_num"));
				map.put("catalogname", rs.getString("catalogname"));
				map.put("carid", rs.getString("carid"));
				map.put("fatherid", rs.getString("fatherid"));
				map.put("rootId", rs.getString("rootId"));
				map.put("fatherName", rs.getString("fatherName"));
				map.put("rootname", rs.getString("rootname"));
				String photo = rs.getString("photo");
				map.put("photo",getImagePath(photo));
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
		return map;
	
	}
	String getImagePath(String str){
		String path = "";
		if(str.length()>3){
			if("315".equals(str.substring(0,3))){
				path = str.replace("315/", MyConfig.img_che_url);
			}
			if("ct1".equals(str.substring(0,3))){
				path = str.replace("ct1/",MyConfig.img_che_url);
			}
		}
		return path;
	}
	public List getAllCarGroup(int start, int rows, String keywords,int type,String pinpai,String stationId,String isdelete) {
		DBConnect dbc = null;
		String pinpaiStr = "";
		if(!"-1".equals(pinpai))
			pinpaiStr = " and  t2.iway = '"+pinpai+"'";
		String stationStr = "";
		if(!"-1".equals(stationId))
			stationStr = " and  t1.sites_id = '"+stationId+"'";
		String deleteStr = "";
		if(!"-1".equals(isdelete))
			deleteStr = " and  t1.isdelete = '"+isdelete+"'";
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String sql1 = "select t1.isdelete,t1.sites_id,t2.iway,t1.id,t1.title,t1.buy_type,t1.begdate,t1.enddate,t2.catalogname, t3.ename from tb_car_groupbuy t1 join dbo_car_catalognew t2 on t1.fatherid= t2.catalogid  join dbo_dea_dealers t3 on t1.deaid = t3.eid where  "
				+ "t1.title like '%"
				+ keywords
				+ "%'"
				+ pinpaiStr
				+ stationStr
				+ deleteStr
				+ " and t1.buy_type = "
				+ type
				+ " and t1.isdelete2=0"
				+ " order by t1.adddate desc limit ?,?";
		String sql2 = "select count(*) as  count from tb_car_groupbuy t1 join dbo_car_catalognew t2 on t1.carid= t2.catalogid  join dbo_dea_dealers t3 on t1.deaid = t3.eid where  "
				+ "t1.title like '%"
				+ keywords
				+ "%'"
				+ pinpaiStr
				+ stationStr
				+ deleteStr
				+ " and t1.buy_type = "
				+ type
				+ " and t1.isdelete2=0";
		int count = 0;
		try {
			dbc = new DBConnect(sql2);
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
		try {
			dbc = new DBConnect(sql1);
			dbc.setInt(1, start);
			dbc.setInt(2, rows);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("count", count);
				map.put("id", rs.getInt("id"));
				map.put("title", rs.getString("title"));
				map.put("buy_type", rs.getInt("buy_type"));
				map.put("catalogname", rs.getString("catalogname"));
				map.put("ename", rs.getString("ename"));
				map.put("begdate", rs.getDate("begdate"));
				map.put("enddate", rs.getDate("enddate"));
				map.put("iway", rs.getString("iway"));
				map.put("isdelete", rs.getString("isdelete"));
				map.put("siteName", StationType.getEnum(rs.getString("sites_id")).getType());
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

	public int updateGroupState(int id,int state){
		int flag = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql ="update tb_car_groupbuy set isdelete=?  where id=?";
		try {
			dbc = new DBConnect(sql);
			dbc.prepareStatement(sql);
			dbc.setInt(1,state);
			dbc.setInt(2,id);
			flag  = dbc.executeUpdateReturnInt();
		}catch (Exception e) {
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
		return flag;
	}
	public int updateGroupState2(int id){
		int flag = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql ="update tb_car_groupbuy set isdelete2=1  where id=?";
		try {
			dbc = new DBConnect(sql);
			dbc.prepareStatement(sql);
			dbc.setInt(1,id);
			flag  = dbc.executeUpdateReturnInt();
		}catch (Exception e) {
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
		return flag;
	}
	public List<HashMap<String, Object>> getCarBrand(){
		DBConnect dbc = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = null;
		String sql = "SELECT DISTINCT iway  ,wayname from dbo_car_catalognew WHERE  iway !='' and iway is not null and  wayname is not null and wayname !='' and isdelete = 0 and pathlevel=3 ORDER BY wayname";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("wayname", rs.getString("wayname"));
				map.put("iway", rs.getString("iway"));
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
}
