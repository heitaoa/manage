package com.poly.dao.subDaos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import car_beans.DboImgContent;
import car_beans.DboImgNewcontent;
import car_daos.DBConnect;
import car_daos.DboImgNewcontentDao;

import com.poly.bean.ImageEntity;
import com.poly.service.ImageService.carImg;

public class DboImgNewcontentSubDao extends DboImgNewcontentDao{
	
	
	
	HashMap<String, Object> map = null;
	
	
	public List<HashMap<String, Object>> getImageInfo(int id) {
		DBConnect dbc = null;

		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();

		String sql = "SELECT id,titleId,title,keywords,path FROM dbo_img_newcontent WHERE isdelete = 0 AND id =?";
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, id);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("id", rs.getInt("id"));
				map.put("titleId", rs.getInt("titleId"));
				map.put("title", rs.getString("title"));
				map.put("keywords", rs.getString("keywords"));
				map.put("path", rs.getString("path"));
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
	
	
	public int updateImage(ImageEntity imageEntity){
		DBConnect dbc = null;
		String  sql = "UPDATE dbo_img_newcontent SET `title`=?,keywords=?,path=? WHERE id = ?";
		int result = -1 ;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, imageEntity.getTitle());
			dbc.setString(2, imageEntity.getKeywords());
			if(("").equals(imageEntity.getImagePath())){
				dbc.setString(3, imageEntity.getOldpath());
			}else{
				dbc.setString(3, imageEntity.getImagePath());
			}
			dbc.setInt(4, imageEntity.getImageId());
			result = dbc.executeUpdateReturnInt();
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
	
	public int addImage(ImageEntity imageEntity) throws Exception{
		int result = -1;
		DboImgNewcontent dboimgnewcontent = new DboImgNewcontent();
		dboimgnewcontent.setId(getImageMaxid()+1);
		dboimgnewcontent.setTitle(imageEntity.getTitle());
		dboimgnewcontent.setKeywords(imageEntity.getKeywords());
		dboimgnewcontent.setPath(imageEntity.getImagePath());
		dboimgnewcontent.setTitleid(imageEntity.getTitleid());
		//dboimgnewcontent.setType(imageEntity.getType());
		//dboimgnewcontent.setCatalogid(imageEntity.getCatalogid());
		dboimgnewcontent.setSortid(getNextSotid(imageEntity.getTitleid()));
		dboimgnewcontent.setAdddate(new Date());
		dboimgnewcontent.setLastupdate(new Date());
		this.save(dboimgnewcontent);
		return getImageMaxid();
	}
	
	public int getNextSotid(int titleid){
		DBConnect dbc = null;
		int sortid = 0;
		String sql = "select max(sortid) as max from dbo_img_newcontent where titleid =?";
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, titleid);
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				sortid= rs.getInt("max");
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
		return sortid+1;
	}
	
	
	public int getImageMaxid(){
		DBConnect dbc = null;
		String  sql = "SELECT MAX(id) as max FROM dbo_img_newcontent";
		int result = -1 ;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				result= rs.getInt("max");
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
	public List<HashMap<String, Object>> getImageDetail(String catalogid,
			String keywords, int type, int start, int rows) {
		DBConnect dbc = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String str = "";
		if (type != 0)
			str = "t3.type= " + type + " AND ";
		String sql1 = "SELECT COUNT(*) AS count FROM  dbo_car_catalognew t1 ,dbo_img_title t2,dbo_img_newcontent t3 WHERE t1.catalogid=t2.catalogid AND t2.id=t3.titleid AND "
				+ "t1.catalogid in("
				+ catalogid
				+ ") AND "
				+ "t3.keywords like '%"
				+ keywords
				+ "%' AND "
				+ str
				+ "t3.isdelete = 0";
		String sql2 = "SELECT t2.title  'title1',t3.title 'title2',t3.type,t3.adddate ,t3.path,t3.id FROM  dbo_car_catalognew t1 ,dbo_img_title t2,dbo_img_newcontent t3 WHERE t1.catalogid=t2.catalogid AND t2.id=t3.titleid AND "
				+ "t1.catalogid in("
				+ catalogid
				+ ") AND "
				+ "t3.keywords like '%"
				+ keywords
				+ "%' AND "
				+ str
				+ "t3.isdelete = 0 ORDER BY t1.catalogid,t3.id,t3.type limit ?,?";
		int count = 0;
		try {
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
		}
		try {
			dbc = new DBConnect(sql2);
			dbc.setInt(1, start);
			dbc.setInt(2, rows);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("id", rs.getInt("id"));
				map.put("count", count);
				map.put("title1", rs.getString("title1"));
				map.put("title2", rs.getString("title2"));
				map.put("type", carImg.getEnum(rs.getInt("type")).getName());
				map.put("adddate", rs.getDate("adddate"));
				map.put("path", rs.getString("path"));
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
