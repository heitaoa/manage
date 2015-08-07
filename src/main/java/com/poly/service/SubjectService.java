package com.poly.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import car_beans.DboSubContent;
import car_beans.DboSubData;
import car_beans.DboZhtContent;
import car_daos.DBConnect;
import car_daos.DboSubContentDao;
import car_daos.DboSubDataDao;
import car_daos.DboZhtContentDao;

import com.poly.action.action_subject.GenSubjectHtml;
import com.poly.dao.che.PageBlockDAO;
import com.poly.dao.che.SubjectDao;
import com.poly.util.MyConfig;
import com.poly.util.DateUtils;


public class SubjectService {

	public static void saveSubject(DboZhtContent subject) {
		// TODO Auto-generated method stub
		SubjectDao.saveSubject(subject);
	}
	
	public static void updateSubject(DboZhtContent subject) {
		// TODO Auto-generated method stub
		SubjectDao.updateSubject(subject);
	}
	
	//判断专题模板是否已经存在
	public static int selectMaxId(String content) {
		// TODO Auto-generated method stub
		String sql = "select max(id) as id from dbo_zht_content where content = '"+content+"'";
		DBConnect dbc = null;
		int id = 0;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			if(rs.next()){
				id = rs.getInt("id");
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
		return id;
	}
	

	public static List<DboZhtContent> getAllSubjectList(int from,int end) {
		// TODO Auto-generated method stub
		String subsql ="isdelete = 0 and isshow = 0 order by adddate desc limit "+from+","+end;
		return DboZhtContentDao.where(subsql);
	}
	
	public static int getAllSubjectCount() {
		// TODO Auto-generated method stub
		String subsql ="isdelete = 0 and isshow = 0 ";
		return DboZhtContentDao.whereCount(subsql);
	}

	public static void updateSubjectById(String subjectId) {
		// TODO Auto-generated method stub
		String sql ="update dbo_zht_content set isdelete = 1 where id = '"+subjectId+"'";
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
	
	//生成专题静态页面
	public static void genSubjectIndexById(String subjectId){
		String subsql1 = "id = '"+subjectId+"'";
		DboZhtContent subject = DboZhtContentDao.where(subsql1).get(0);
		String subsql2 = "isdelete = 0 and pname = 'zt_"+subjectId+"'";
		List<DboSubContent> subList = DboSubContentDao.where(subsql2);
		Map<String,List<DboSubData>> dataMap = new HashMap<String,List<DboSubData>>();
		if(subList!=null&&subList.size()>0){
			for(int i=0;i<subList.size();i++){
				List<DboSubData> dataList = new ArrayList<DboSubData>();
				String sql = "isdelete = 0 and sid = '"+subList.get(i).getId()+"'";
				dataList = DboSubDataDao.where(sql);
				dataMap.put(subList.get(i).getPlace(),dataList);
			}
		}
		try {
			GenSubjectHtml.genIndex(subject, dataMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//插入数据
	public static void insertSubjectContent(DboSubContent content) {
		// TODO Auto-generated method stub
		String sql = "insert into dbo_sub_content (id,pname,place,lastvisittime,isdelete,stype) values (?,?,?,?,?,?)";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setAutoCommit(false);
			dbc.setInt(1,PageBlockDAO.nextVal("dbo_sub_content"));
			dbc.setString(2,content.getPname());
			dbc.setString(3,content.getPlace());
			dbc.setDate(4,new java.sql.Date(content.getLastvisittime().getTime()));
			dbc.setInt(5,content.getIsdelete());
			dbc.setInt(6,content.getStype());
			dbc.executeUpdate();
			dbc.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				dbc.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
	
	
	//更新数据
	public static void updateSubjectContentById(DboSubContent content) {
		// TODO Auto-generated method stub
		String sql = "update dbo_sub_content set place=? where id = ?";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1,content.getPlace());
			dbc.setInt(2,content.getId());
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
	//删除数据
	public static void deleteSubjectContentById(String contenid) {
		// TODO Auto-generated method stub
		String sql = "update dbo_sub_content set isdelete = 1 where id = '"+contenid+"'";
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
	
	public static void insertSubjectData(DboSubData subjectdata) {
		// TODO Auto-generated method stub
		String sql = "insert dbo_sub_data (id,sid,title,content,pic,link,ctitle,clink,color,adddate,isdelete) values(?,?,?,?,?,?,?,?,?,?,?)";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1,PageBlockDAO.nextVal("dbo_sub_data"));
			dbc.setInt(2,subjectdata.getSid());
			dbc.setString(3,subjectdata.getTitle());
			dbc.setString(4,subjectdata.getContent());
			dbc.setString(5,subjectdata.getPic());
			dbc.setString(6,subjectdata.getLink());
			dbc.setString(7,subjectdata.getCtitle());
			dbc.setString(8,subjectdata.getClink());
			dbc.setString(9,subjectdata.getColor());
			dbc.setDate(10,new java.sql.Date(subjectdata.getAdddate().getTime()));
			dbc.setInt(11,subjectdata.getIsdelete());
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

	public static void updateSubjectData(DboSubData subjectdata) {
		subjectdata.setAdddate(new Date());
		DboSubDataDao.update(subjectdata);
//		// TODO Auto-generated method stub
//		String sql = "update dbo_sub_data set title=?,content=?,pic=?,link=?,ctitle=?,clink=?,color=? where id = ?";
//		DBConnect dbc = null;
//		try {
//			dbc = new DBConnect(sql);
//			dbc.setString(1,subjectdata.getTitle());
//			dbc.setString(2,subjectdata.getContent());
//			dbc.setString(3,subjectdata.getPic());
//			dbc.setString(4,subjectdata.getLink());
//			dbc.setString(5,subjectdata.getCtitle());
//			dbc.setString(6,subjectdata.getClink());
//			dbc.setString(7,subjectdata.getColor());
//			dbc.setInt(8,subjectdata.getId());
//			dbc.executeUpdate();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			if(dbc!=null){
//				try {
//					dbc.close();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
	}

	public static void deleteSubjectData(String dataId) {
		// TODO Auto-generated method stub
		String now = DateUtils.getNow();
		String sql = "update dbo_sub_data set isdelete = 1 , adddate='"+now+"' where id = '"+dataId+"'";
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

	public static void setSubjectToMould(String subjectId) {
		// TODO Auto-generated method stub
		String sql ="update dbo_zht_content set ishead = 0 where id = '"+subjectId+"'";
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

	public static void setSubjectNotToMould(String subjectId) {
		// TODO Auto-generated method stub
		String sql ="update dbo_zht_content set ishead = 1 where id = '"+subjectId+"'";
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

	public static List<Map<String,String>> getSubjectListByTempname(
			String tempName) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String subsql = " isdelete = 0 and content = '"+tempName+"' and lastup >="+sdf.format(new java.util.Date());
		//String subsql = "isdelete = 0 and content = '"+tempName+"'";
		List<DboZhtContent> list = DboZhtContentDao.where(subsql);
		List<Map<String,String>> mapList = new ArrayList<Map<String,String>>();
		for(int i=0;i<list.size();i++){
			DboZhtContent  dboZhtContent = list.get(i);
			List<DboSubContent> dboSubContentList = DboSubContentDao.where("place = '车展城市' and isdelete = 0 and pname = 'zt_"+dboZhtContent.getId()+"'");
			if(dboSubContentList.size()>0){
				DboSubContent dboSubContent = dboSubContentList.get(0);
				List<DboSubData> subDataList = DboSubDataDao.where("isdelete = 0 and sid = '"+dboSubContent.getId()+"'");
				if(subDataList.size()>0){
					DboSubData dboSubData = subDataList.get(0);
					Map<String,String> map = new HashMap<String, String>();
					map.put("title",dboSubData.getTitle());
					map.put("url",MyConfig.chezhan_che_url+"chezhan/"+dboZhtContent.getId()+"/index.html");
					mapList.add(map);
				}
			};
		}
		return mapList;
	}
}
