package com.poly.dao.che;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;

import car_beans.DboAdExposure;
import car_daos.DBConnect;
import car_daos.DboAdExposureDao;

public class ExposureDao extends DboAdExposureDao {
   
	//添加数据
	public static void insertExposure(DboAdExposure exposure){
		DBConnect dbc = null;
		String sql = "insert into dbo_ad_exposure (url,sdate,edate,count,isdelete,title) value (?,?,?,?,?,?)";
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1,exposure.getUrl());
			dbc.setTimestamp(2,new Timestamp(exposure.getSdate().getTime()));
			dbc.setTimestamp(3,new Timestamp(exposure.getEdate().getTime()));
			dbc.setInt(4,exposure.getCount());
			dbc.setInt(5,exposure.getIsdelete());
			dbc.setString(6,exposure.getTitle());
			dbc.executeUpdate();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
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
	
	//删除
	 public static void deleteExposure(String exposureid){
        DBConnect dbc = null;
		String sql="update dbo_ad_exposure set isdelete = 1 where id = '"+exposureid+"'"; 
        try {
			dbc = new DBConnect(sql);
			dbc.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
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
	
	 //修改
	public static void updateExposure(DboAdExposure exposure){
	   DBConnect dbc = null;
	   String  sql="update dbo_ad_exposure set url = ?,sdate = ?,edate = ?,count =?,title =? WHERE id = ?";
         try {
			dbc = new DBConnect(sql);
			dbc.setString(1, exposure.getUrl());
			dbc.setTimestamp(2, new Timestamp(exposure.getSdate().getTime()));
			dbc.setTimestamp(3, new Timestamp(exposure.getEdate().getTime()));
			dbc.setInt(4, exposure.getCount());
			dbc.setString(5, exposure.getTitle());
			dbc.setInt(6, exposure.getId());
			dbc.executeUpdate();
			dbc.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();	 
		}
		
		
		
		
	}

	public static DboAdExposure getExposureById(String exposureid) {
		// TODO Auto-generated method stub
		String subsql = " id = '"+exposureid+"'";
		return where(subsql).get(0);
	}

	public static int getAllExposureCount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) as count from dbo_ad_exposure where isdelete=0";
		DBConnect dbc = null;
		int count = 0;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			if(rs.next()){
				count = rs.getInt("count");	
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
		return count;
	}

	public static List<DboAdExposure> getAllExposureByPage(int from, int i) {
		// TODO Auto-generated method stub
		String subsql = "isdelete = 0 limit "+from+","+i;
		return where(subsql);
	}
	

		 

}
