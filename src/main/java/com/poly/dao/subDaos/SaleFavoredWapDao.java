package com.poly.dao.subDaos;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.poly.util.MyConfig;

import car_daos.DBConnect;

public class SaleFavoredWapDao {
	public List<HashMap<String, Object>> getSaleFavoredWapList(int cityId,int carId,int activeId,int beginPrice,int endprice){
		DBConnect dbc = null;
		HashMap<String, Object> map = null;
		int count = 0;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		//String sql1 = "SELECT count(*) count from tb_car_groupbuy a LEFT OUTER JOIN dbo_car_catalognew b on a.fatherid = b.catalogid LEFT OUTER JOIN dbo_car_catalognew c on a.carid = c.catalogid LEFT OUTER JOIN dbo_dea_dealers d on a.deaid = d.eid LEFT OUTER JOIN dbo_are_catalog e on d.areaid = e.catalogid where 1=1";
		String sql2 = "SELECT a.carid,a.surplus_num 'num',b.catalogname 'chexi',c.catalogname 'chexing',a.pic ,f.photo,a.fatherid,a.car_info from tb_car_groupbuy a LEFT OUTER JOIN dbo_car_catalognew b on a.fatherid = b.catalogid LEFT OUTER JOIN dbo_car_catalognew c on a.carid = c.catalogid LEFT OUTER JOIN dbo_car_catalognew f on b.fatherid = f.catalogid LEFT OUTER JOIN dbo_dea_dealers d on a.deaid = d.eid LEFT OUTER JOIN dbo_are_catalog e on d.areaid = e.catalogid where 1=1 ";
		if(cityId>0){
			//sql1 += " and (e.catalogid = "+cityId+" or e.fatherid = "+cityId+") ";
			sql2 += " and (e.catalogid = "+cityId+" or e.fatherid = "+cityId+") ";
		}
		if(carId>0){
			//sql1 += " and b.fatherid = "+carId;
			sql2 += " and b.fatherid = "+carId;
		}
		if(activeId>0){
			//sql1 += " and a.active_type= "+activeId;
			sql2 += " and a.active_type= "+activeId;
		}
		//sql1 += "  and a.price BETWEEN "+beginPrice+" and "+endprice+"  ";
		sql2 += "  and a.price BETWEEN "+beginPrice+" and "+endprice+"  ";
		//sql1 += " and a.buy_type=1 and surplus_num>0 and a.isdelete=0 ";
		sql2 += " and a.buy_type=1 and surplus_num>0 and a.isdelete=0 order by id desc ";
		/*try {
			dbc = new DBConnect(sql1);
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
		}*/
		try {
			dbc = new DBConnect(sql2);
			//dbc.setInt(1, start);
			//dbc.setInt(2, rows);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("count", count);
				map.put("pic", getImagePath(rs.getString("pic")==null?"":rs.getString("pic")));
				map.put("car_info", rs.getString("car_info")==null?"":rs.getString("car_info"));
				map.put("num", rs.getString("num"));
				map.put("chexi", rs.getString("chexi"));
				map.put("chexing", rs.getString("chexing"));
				map.put("carid", rs.getString("carid"));
				map.put("fatherid", rs.getString("fatherid"));
				map.put("photo",getImagePath(rs.getString("photo")==null?"":rs.getString("photo")));
				result.add(map);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (dbc != null) {
				try {
					dbc.close();
					dbc = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
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
}
