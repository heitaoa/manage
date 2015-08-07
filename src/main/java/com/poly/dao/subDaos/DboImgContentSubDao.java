package com.poly.dao.subDaos;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import car_beans.DboImgContent;
import car_daos.DBConnect;
import car_daos.DboImgContentDao;

import com.poly.bean.ImageEntity;
import com.poly.service.ImageService.carImg;

public class DboImgContentSubDao extends DboImgContentDao{
	
	
	
	HashMap<String, Object> map = null;
	
	
	public List<HashMap<String, Object>> getImageInfo(int id) {
		DBConnect dbc = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();

		String sql = "SELECT id,titleId,title,keywords,path,type,totopdate,serialType FROM dbo_img_content WHERE isdelete = 0 AND id =?";
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
				map.put("type", rs.getInt("type"));
				map.put("totopdate", rs.getDouble("totopdate"));
				map.put("serialType", rs.getInt("serialType"));
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
		String  sql = "UPDATE dbo_img_content SET `title`=?,keywords=?,path=?,lastupdate=? WHERE id = ?";
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
			dbc.setTimestamp(4, new Timestamp(new Date().getTime()));
			dbc.setInt(5, imageEntity.getImageId());
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
	
	public int updateTitle(String title,int id){
		DBConnect dbc = null;
		String  sql = "UPDATE dbo_img_content SET `title`=?,lastupdate=? WHERE id = ?";
		int result = -1 ;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, title);
			dbc.setTimestamp(2, new Timestamp(new Date().getTime()));
			dbc.setInt(3, id);
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
		DboImgContent dboImgContent = new DboImgContent();
		dboImgContent.setId(getImageMaxid()+1);
		dboImgContent.setTitle(imageEntity.getTitle());
		dboImgContent.setKeywords(imageEntity.getKeywords());
		dboImgContent.setPath(imageEntity.getImagePath());
		dboImgContent.setTitleid(imageEntity.getTitleid());
		dboImgContent.setType(imageEntity.getType());
		dboImgContent.setCatalogid(imageEntity.getCatalogid());
		dboImgContent.setSortid(getMaxSortid(imageEntity.getTitleid())+1);
		dboImgContent.setAdddate(new Date());
		dboImgContent.setLastupdate(new Date());
		this.save(dboImgContent);
		return getImageMaxid();
	}
	
	
	public int getImageMaxid(){
		DBConnect dbc = null;
		String  sql = "SELECT MAX(id) as max FROM dbo_img_content";
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
	
	public int getMaxSortid(int titleid){
		DBConnect dbc = null;
		String  sql = "SELECT MAX(sortid) as max FROM dbo_img_content WHERE titleid = ?";
		int result = -1 ;
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, titleid);
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
		String sql1 = "SELECT COUNT(*) AS count FROM  dbo_car_catalognew t1 ,dbo_img_title t2,dbo_img_content t3 WHERE t1.catalogid=t2.catalogid AND t2.id=t3.titleid AND "
				+ "t1.catalogid in("
				+ catalogid
				+ ") AND "
				+ "t3.keywords like '%"
				+ keywords
				+ "%' AND "
				+ str
				+ "t3.isdelete = 0";
		String sql2 = "SELECT t2.title  'title1',t3.title 'title2',t3.type,t3.adddate ,t3.path,t3.id FROM  dbo_car_catalognew t1 ,dbo_img_title t2,dbo_img_content t3 WHERE t1.catalogid=t2.catalogid AND t2.id=t3.titleid AND "
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
