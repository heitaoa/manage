package com.poly.dao.che;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import car_beans.DboPubMould;
import car_daos.DBConnect;
import car_daos.DboPubMouldDao;

public class MouldDao extends DboPubMouldDao {

	private static ResultSet rs;
	public static List<DboPubMould> getMouldList() {
		// TODO Auto-generated method stub
		String sql = "select * from dbo_pub_mould";
		List<DboPubMould> list = new ArrayList<DboPubMould>();
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			rs = dbc.executeQuery();
			while(rs.next()){
				DboPubMould mould = new DboPubMould();
				fill(rs, mould);
				list.add(mould);
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
	
	public static List<Map<String,Object>> getSubjectMouldById(String subjectId) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		String sql ="select * from dbo_pub_subject d1,dbo_pub_subjectmould d2,dbo_pub_mould d3 where d1.subjectid = d2.sid and d2.mid = d3.mouldid";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			rs = dbc.executeQuery();
			while(rs.next()){
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("smid",rs.getInt("id"));
				map.put("mouldid",rs.getInt("mouldid"));
				map.put("mouldname",rs.getString("mouldname"));
				map.put("mouldphoto",rs.getString("mouldphoto"));
				map.put("mouldhtml",rs.getString("mouldhtml"));
				map.put("mouldftl",rs.getString("mouldftl"));
				list.add(map);
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

	public static void saveMould(DboPubMould mould) {
		// TODO Auto-generated method stub
		String sql ="insert into dbo_pub_mould (mouldname,mouldhtml,mouldftl,mouldphoto) values (?,?,?,?)";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1,mould.getMouldname());
			dbc.setString(2,mould.getMouldhtml());
			dbc.setString(3,mould.getMouldftl());
			dbc.setString(4,mould.getMouldphoto());
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

	public static DboPubMould getMouldById(String mouldId) {
		// TODO Auto-generated method stub
		String sql ="select * from dbo_pub_mould where mouldid = '"+mouldId+"'";
		DboPubMould mould = new DboPubMould();
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			rs = dbc.executeQuery();
			if(rs.next()){
				fill(rs, mould);
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
		return mould;
	}

	public static void saveSubjectMould(String subjectId, int mouldId) {
		// TODO Auto-generated method stub
		String sql = "insert into dbo_pub_subjectmould (sid,mid) values (?,?)";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1,Integer.valueOf(subjectId));
			dbc.setInt(2, mouldId);
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

	public static void deleteSubjectMould(String smid) {
		// TODO Auto-generated method stub
		String sql = "delete from dbo_pub_subjectmould where id = '"+smid+"'";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
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

	public static void updateMould(DboPubMould mould) {
		// TODO Auto-generated method stub
		/*String sql = "update dbo_pub_mould set mouldname=?,mouldhtml=?,mouldftl=?,mouldphoto=? where mouldid = ?";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			update(mould);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		update(mould);
	}

	public static void deleteMould(String mouldId) {
		// TODO Auto-generated method stub
		String subsql = "mouldId='"+mouldId+"'";
		delete(subsql);
	}

}
