package com.poly.dao.che;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import car_beans.DboAdPopad;
import car_daos.DBConnect;

public class AdClickDao {

	public static List<DboAdPopad> getAdClickInfo() {
		// TODO Auto-generated method stub
		List<DboAdPopad> list = new ArrayList<DboAdPopad>();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sql = "select * from dbo_ad_popad d1,dbo_ad_popadschedule d2 where d1.isdelete = 0 and d2.isdelete=0 and d1.id = d2.popaid and d2.edate > '"+sdf.format(date.getTime())+"'";
		DBConnect dbc = null;
		try {
			//建立连接
			dbc = new DBConnect(sql);
			//查询结果集
			ResultSet rs = dbc.executeQuery();
			//循环游标取数据
			while(rs.next()){
				DboAdPopad pob = new DboAdPopad();
				pob.setId(rs.getInt("id"));
				pob.setAdstr(rs.getString("adstr"));
				pob.setAdtitle(rs.getString("adtitle"));
				pob.setPoptotaltimes(rs.getInt("poptotaltimes"));
				pob.setRemaintimes(rs.getInt("remaintimes"));
				pob.setTotalclick(rs.getInt("totalclick"));
				list.add(pob);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(dbc!=null){
				try {
					dbc.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
		return list;
	}
	
	

}
