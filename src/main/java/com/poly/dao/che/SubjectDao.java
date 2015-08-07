package com.poly.dao.che;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import car_beans.DboPubSubject;
import car_beans.DboZhtContent;
import car_daos.DBConnect;
import car_daos.DboZhtContentDao;

public class SubjectDao extends DboZhtContentDao {
	
	private static ResultSet rs;

	//获取专题列表
	public static List<DboZhtContent> getSubjectList(int from,int end) {
		// TODO Auto-generated method stub
		String sql = "select * from dbo_zht_content order by adddate desc limit "+from+","+end;
		DBConnect dbc = null;
		List<DboZhtContent> list = new ArrayList<DboZhtContent>();
		try {
			dbc = new DBConnect(sql);
			rs = dbc.executeQuery();
			while(rs.next()){
				DboZhtContent subject = new DboZhtContent();
				fill(rs, subject);
				list.add(subject);
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

	//添加专题
	public static void saveSubject(DboZhtContent subject) {
		// TODO Auto-generated method stub
		String sql = "insert into dbo_zht_content (name,content,isdelete,isshow,adddate,titlephoto,keywords,descstr,type,lastup) values (?,?,?,?,?,?,?,?,?,?)";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1,subject.getName());
			dbc.setString(2,subject.getContent());
			dbc.setInt(3,subject.getIsdelete());
			dbc.setInt(4,subject.getIsshow());
			dbc.setDate(5,new java.sql.Date(subject.getAdddate().getTime()));
			dbc.setString(6,subject.getTitlephoto());
			dbc.setString(7,subject.getKeywords());
			dbc.setString(8,subject.getDescstr());
			dbc.setString(9,subject.getType());
			dbc.setDate(10,new java.sql.Date(subject.getLastup().getTime()));
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
	
	
	//修改专题
	public static void updateSubject(DboZhtContent subject) {
		// TODO Auto-generated method stub
		String sql = "update dbo_zht_content set name=?,content=?,titlephoto=?,keywords=?,descstr=?,type=?,lastup=? where id=?";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1,subject.getName());
			dbc.setString(2,subject.getContent());
			dbc.setString(3,subject.getTitlephoto());
			dbc.setString(4,subject.getKeywords());
			dbc.setString(5,subject.getDescstr());
			dbc.setString(6,subject.getType());
			dbc.setDate(7,new java.sql.Date(subject.getLastup().getTime()));
			dbc.setInt(8,subject.getId());
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
