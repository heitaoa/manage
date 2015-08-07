package com.poly.dao.che;

import java.sql.Date;
import java.sql.Timestamp;

import car_beans.DboAdPopadschedule;
import car_daos.DBConnect;
import car_daos.DboAdPopadscheduleDao;

public class PopadscheduleDao extends DboAdPopadscheduleDao{

	public static void insertPopadschedule(DboAdPopadschedule schedule){
		DBConnect dbc = null; 
		String sql = "insert into dbo_ad_popadschedule (popaid,sdate,edate,isdelete) values (?,?,?,?)";
		  try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, schedule.getPopaid());
			dbc.setTimestamp(2, new Timestamp(schedule.getSdate().getTime()));
			dbc.setTimestamp(3, new Timestamp(schedule.getEdate().getTime()));
			dbc.setInt(4, 0);
			dbc.executeUpdate();
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
	}
	
	public static void deletePopadschedule(String scheduleid){
		DBConnect dbc = null;
		String sql = "update dbo_ad_popadschedule set isdelete=1 where id = '"+scheduleid+"'";
		 try {
			dbc = new DBConnect(sql);
			dbc.executeUpdate();
		} catch (Exception e){
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
	}
	
	public static void updatePopadschedule(DboAdPopadschedule schedule){
		DBConnect dbc = null;
		String sql = "update dbo_ad_popadschedule set popaid = ?, sdate = ?, edate = ?, isdelete= ? where id = ?";   
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, schedule.getPopaid());
			dbc.setTimestamp(2, new Timestamp(schedule.getSdate().getTime()));
			dbc.setTimestamp(3, new Timestamp(schedule.getEdate().getTime()));
		    dbc.setInt(4, schedule.getId());
		    dbc.executeUpdate();
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
		
		
		
		
		
		
		
		
		
		
	}
	
	
	

}
