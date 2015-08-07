package com.poly.dao.che;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import car_beans.DboPubSubjectdata;
import car_daos.DBConnect;
import car_daos.DboPubSubjectdataDao;

public class SubjectDataDao extends DboPubSubjectdataDao {

	private static ResultSet rs;
	public static void saveSubjectData(DboPubSubjectdata subjectdata) {
		// TODO Auto-generated method stub
		String sql ="insert into dbo_pub_subjectdata (sid,mid,photo,photourl,photoclass,text,texturl,textclass,title,titleurl,titleclass) values (?,?,?,?,?,?,?,?,?,?,?)";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, subjectdata.getSid());
			dbc.setInt(2, subjectdata.getMid());
			dbc.setString(3, subjectdata.getPhoto());
			dbc.setString(4, subjectdata.getPhotourl());
			dbc.setString(5, subjectdata.getPhotoclass());
			dbc.setString(6, subjectdata.getText());
			dbc.setString(7, subjectdata.getTexturl());
			dbc.setString(8, subjectdata.getTextclass());
			dbc.setString(9, subjectdata.getTitle());
			dbc.setString(10, subjectdata.getTitleurl());
			dbc.setString(11, subjectdata.getTitleclass());
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

	public static List<DboPubSubjectdata> getSubjectDataListById(String subjectId,
			String mouldId) {
		// TODO Auto-generated method stub
		String sql = "select * from dbo_pub_subjectdata where sid = '"+subjectId+"' and mid = '"+mouldId+"'";
		DBConnect dbc = null;
		List<DboPubSubjectdata> list = new ArrayList<DboPubSubjectdata>();
		try {
			dbc = new DBConnect(sql);
			rs = dbc.executeQuery();
			while(rs.next()){
				DboPubSubjectdata subjectdata = new DboPubSubjectdata();
				fill(rs, subjectdata);
				list.add(subjectdata);
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

	public static DboPubSubjectdata getSubjectDataById(String dataId) {
		// TODO Auto-generated method stub
		String sql = "select * from dbo_pub_subjectdata where dataid = '"+dataId+"'";
		DboPubSubjectdata subjectdata = new DboPubSubjectdata();
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			rs = dbc.executeQuery();
			if(rs.next()){
				fill(rs, subjectdata);
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
		return subjectdata;
	}

	public static void updateSubjectData(DboPubSubjectdata subjectdata) {
		// TODO Auto-generated method stub
		String sql = "update dbo_pub_subjectdata set text=?,texturl=?,textclass=?,title=?,titleurl=?,titleclass=?,photo=?,photourl=?,photoclass=? where dataid = ?";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1,subjectdata.getText());
			dbc.setString(2,subjectdata.getTexturl());
			dbc.setString(3,subjectdata.getTextclass());
			dbc.setString(4,subjectdata.getTitle());
			dbc.setString(5,subjectdata.getTitleurl());
			dbc.setString(6,subjectdata.getTitleclass());
			dbc.setString(7,subjectdata.getPhoto());
			dbc.setString(8,subjectdata.getPhotourl());
			dbc.setString(9,subjectdata.getPhotoclass());
			dbc.setInt(10,subjectdata.getDataid());
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
