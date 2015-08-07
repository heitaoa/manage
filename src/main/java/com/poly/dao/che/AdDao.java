package com.poly.dao.che;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.record.formula.functions.FinanceFunction;

import car_beans.DboPubAd;
import car_beans.DboPubAdinfo;
import car_beans.DboPubAdschedule;
import car_daos.DBConnect;

public class AdDao {
	private static ResultSet rs = null;
	
	//获取各城市站对应的广告位
	public static List<Map<String,String>> getAdInfoByCity(int city, String adUrl){
		
		List<Map<String,String>> mapList = new ArrayList<Map<String,String>>();
		DBConnect dbc = null;
		String sql = "select * from dbo_pub_ad where city = '"+city+"'";
		if(adUrl!=null&&!adUrl.equals("")){
			sql +=" and html='"+adUrl+"'";
		}
		System.out.println(sql);
		try {
			dbc = new DBConnect(sql);
			rs = dbc.executeQuery();
			while(rs.next()){
				Map<String,String> map = new HashMap<String, String>();
				map.put("id",String.valueOf(rs.getString("id")));
				map.put("city",String.valueOf(rs.getInt("city")));
				map.put("html",rs.getString("html"));
				map.put("adwidth",String.valueOf(rs.getInt("adwidth")));
				map.put("adheight",String.valueOf(rs.getInt("adheight")));
				//map.put("adurl",rs.getString("adurl"));
				//map.put("adimg", rs.getString("adimg"));
				map.put("adtype", rs.getString("adtype"));
				map.put("adplace",String.valueOf(rs.getInt("adplace")));
				mapList.add(map);
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
		return mapList;
	}
	//获取广告元素详情
	public static List<Map<String,String>> getInfoById(String adId) {
		// TODO Auto-generated method stub
		//Map<String,String> map = new HashMap<String, String>();
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DBConnect dbc = null;
		//String sql = "select d1.*,d2.*,d2.id as adInfoId from dbo_pub_ad d1 left JOIN dbo_pub_adinfo d2 on d1.id = d2.aid where d1.id = '"+adId+"'";
		String sql = "select d1.*,d2.* from dbo_pub_adinfo d1,dbo_pub_adschedule d2 where d1.adinfoid = d2.adinfoid and d2.edate >= '"+sdf.format(new Date().getTime())+"' and d1.isdelete = '0' and d1.adid = '"+adId+"' order by edate";
		System.out.println(sql);
		try {
			dbc = new DBConnect(sql);
			rs = dbc.executeQuery();
			while(rs.next()){
				Map<String,String> map = new HashMap<String, String>();
				//map.put("id",String.valueOf(rs.getString("id")));
				//map.put("city",String.valueOf(rs.getInt("city")));
				//map.put("html",rs.getString("html"));
				//map.put("adwidth",String.valueOf(rs.getInt("adwidth")));
				//map.put("adheight",String.valueOf(rs.getInt("adheight")));
				//map.put("adtype",rs.getString("adtype"));
				map.put("adurl",rs.getString("adurl"));
				map.put("adimg", rs.getString("adimg"));
				map.put("isdefault",String.valueOf(rs.getInt("isdefault")));
				map.put("isshow",String.valueOf(rs.getInt("isshow")));
				//map.put("adtype", rs.getString("adtype"));
				//map.put("adplace",String.valueOf(rs.getInt("adplace")));
				map.put("adInfoId",String.valueOf(rs.getInt("adinfoid")));
				map.put("aid",String.valueOf(rs.getInt("adid")));
				map.put("sdate",sdf.format(rs.getTimestamp("sdate")));
				map.put("edate",sdf.format(rs.getTimestamp("edate")));
				map.put("sid",String.valueOf(rs.getInt("sid")));
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
	//添加广告排期
	public static void addAdSchedule(String edate, String sdate,String adId) {
		// TODO Auto-generated method stub
		String sql = "insert into dbo_pub_adschedule (adinfoid,edate,sdate) values (?,?,?)";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1,Integer.parseInt(adId));
			dbc.setDate(2,new java.sql.Date(sdf.parse(edate).getTime()));
			dbc.setDate(3,new java.sql.Date(sdf.parse(sdate).getTime()));
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
	//获取广告排期
	public static List<Map<String,String>> getAdScheduleByAdId(String adId) {
		// TODO Auto-generated method stub
		List<Map<String,String>> adscheduleList = new ArrayList<Map<String,String>>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DBConnect dbc = null;
		String sql = "SELECT * from dbo_pub_adschedule where edate >= '"+sdf.format(new Date().getTime())+"' and adinfoid ="+Integer.valueOf(adId);
		System.out.println(sql);
		try {
			dbc = new DBConnect(sql);
			rs = dbc.executeQuery();
			while(rs.next()){
				Map<String,String> map = new HashMap<String, String>();
				map.put("sid",String.valueOf(rs.getInt("sid")));
				map.put("aid",String.valueOf(rs.getInt("adinfoid")));
				//map.put("sdate",String.valueOf(rs.getTimestamp("sdate")).substring(0, 10));
				map.put("sdate",sdf.format(rs.getTimestamp("sdate")));
				map.put("edate",String.valueOf(rs.getTimestamp("edate")).substring(0, 10));
				adscheduleList.add(map);
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
		return adscheduleList;
		
	}
	
	//删除广告排期
	public static void deleteAdSchedule(String id){
		String sql = "delete from dbo_pub_adschedule where sid = '"+id+"'";
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
	
	//插入广告元素详情
	public static void saveAdInfo(DboPubAdinfo adInfo) {
		// TODO Auto-generated method stub
		String sql = "insert into dbo_pub_adinfo (adid,adimg,adexposure,adclick,adurl,isdelete,isshow,isdefault,adftl) values (?,?,?,?,?,?,?,?,?)";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1,adInfo.getAdid());
			dbc.setString(2,adInfo.getAdimg());
			dbc.setLong(3,adInfo.getAdexposure());
			dbc.setLong(4,adInfo.getAdclick());
			dbc.setString(5,adInfo.getAdurl());
			dbc.setInt(6,adInfo.getIsdelete());
			dbc.setInt(7,adInfo.getIsshow());
			dbc.setInt(8,adInfo.getIsdefault());
			dbc.setString(9,adInfo.getAdftl());
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
	//更新广告元素
	public static void updateAdInfo(DboPubAdinfo adInfo) {
		// TODO Auto-generated method stub
		String sql ="update dbo_pub_adinfo set adid=?,adimg=?,adexposure=?,adclick=?,adurl=?,isdelete=?,isshow=?,isdefault=?,adftl=? where adinfoid = ?";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1,adInfo.getAdid());
			dbc.setString(2,adInfo.getAdimg());
			dbc.setLong(3,adInfo.getAdexposure());
			dbc.setLong(4,adInfo.getAdclick());
			dbc.setString(5,adInfo.getAdurl());
			dbc.setInt(6,adInfo.getIsdelete());
			dbc.setInt(7,adInfo.getIsshow());
			dbc.setInt(8,adInfo.getIsdefault());
			dbc.setString(9,adInfo.getAdftl());
			dbc.setInt(10,adInfo.getAdinfoid());
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
	//获取广告元素最大ID
	public static int getMaxId() {
		// TODO Auto-generated method stub
		String sql = "select max(adinfoid) as id from dbo_pub_adinfo";
		DBConnect dbc = null;
		int id = 0;
		try {
			dbc = new DBConnect(sql);
			rs = dbc.executeQuery();
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
	public static DboPubAdinfo getAdInfoById(String adId) {
		// TODO Auto-generated method stub
		String sql ="select * from dbo_pub_adinfo where adinfoid = '"+adId+"'";
		DBConnect dbc = null;
		DboPubAdinfo adInfo = new DboPubAdinfo();
		try {
			dbc = new DBConnect(sql);
			rs = dbc.executeQuery();
			if(rs.next()){
				adInfo.setAdinfoid(rs.getInt("adinfoid"));
				adInfo.setAdid(rs.getInt("adid"));
				adInfo.setAdimg(rs.getString("adimg"));
				adInfo.setAdurl(rs.getString("adurl"));
				adInfo.setIsdelete(rs.getInt("isdelete"));
				adInfo.setIsdefault(rs.getInt("isdefault"));
				adInfo.setIsshow(rs.getInt("isshow"));
				adInfo.setAdclick(rs.getLong("adclick"));
				adInfo.setAdexposure(rs.getLong("adexposure"));
				adInfo.setAdftl(rs.getString("adftl"));
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
		return adInfo;
	}
	//获取广告位信息
	public static DboPubAd getAdById(String adId) {
		// TODO Auto-generated method stub
		String sql = "select * from dbo_pub_ad where id = '"+adId+"'";
		DBConnect dbc = null;
		DboPubAd ad = new DboPubAd();
		try {
			dbc = new DBConnect(sql);
			rs = dbc.executeQuery();
			if(rs.next()){
				ad.setId(rs.getInt("id"));
				ad.setAdheight(rs.getInt("adheight"));
				ad.setAdwidth(rs.getInt("adwidth"));
				ad.setAdplace(rs.getInt("adplace"));
				ad.setAdprice(rs.getDouble("adprice"));
				ad.setAdtype(rs.getString("adtype"));
				ad.setCity(rs.getInt("city"));
				ad.setHtml(rs.getString("html"));
				ad.setPredictclick(rs.getLong("predictclick"));
				ad.setPredictcpc(rs.getDouble("predictcpc"));
				ad.setPredictcpl(rs.getDouble("predictcpl"));
				ad.setPredictexposure(rs.getLong("predictexposure"));
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
		return ad;
	}
	//检查排期是否冲突
	public static Boolean judgeAdschedule(String sdate, String edate,
			String adId) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//String sql = "select * from dbo_pub_adinfo d1,dbo_pub_adschedule d2 where d1.id = d2.aid and d2.edate >= '"+sdf.format(edate)+"' and d1.isdelete = '0' and d1.aid = '"+adId+"' order by edate";
		String sql = "select * from dbo_pub_adinfo d1,dbo_pub_adschedule d2 where d1.adinfoid = d2.adinfoid and d1.isdelete = '0' and d1.adid = ? and (d2.edate between ? and ? or d2.sdate between ? and ? or (d2.sdate<= ? and d2.edate>=?))";
		System.out.println(sql);
		DBConnect dbc = null;
		boolean flag = true;
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1,Integer.valueOf(adId));
			dbc.setDate(2,new java.sql.Date(sdf.parse(sdate).getTime()));
			dbc.setDate(3,new java.sql.Date(sdf.parse(edate).getTime()));
			dbc.setDate(4,new java.sql.Date(sdf.parse(sdate).getTime()));
			dbc.setDate(5,new java.sql.Date(sdf.parse(edate).getTime()));
			dbc.setDate(6,new java.sql.Date(sdf.parse(sdate).getTime()));
			dbc.setDate(7,new java.sql.Date(sdf.parse(edate).getTime()));
			rs = dbc.executeQuery();
			if(rs.next()){
				flag = false;
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
		
		return flag;
	}
	//删除广告元素信息
	public static void updateAdInfoById(String adInfoId) {
		// TODO Auto-generated method stub
		String sql = "update dbo_pub_adinfo set isdelete = '1' where adinfoid = '"+adInfoId+"'";
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
	public static void saveAd(DboPubAd ad) {
		// TODO Auto-generated method stub
		String sql = "insert into dbo_pub_ad (city,html,adtype,adwidth,adheight,adplace,adprice,predictclick,predictexposure,predictcpc,predictcpl) values(?,?,?,?,?,?,?,?,?,?,?)";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1,ad.getCity());
			dbc.setString(2, ad.getHtml());
			dbc.setString(3,ad.getAdtype());
			dbc.setInt(4,ad.getAdwidth());
			dbc.setInt(5,ad.getAdheight());
			dbc.setInt(6,ad.getAdplace());
			dbc.setDouble(7, ad.getAdprice());
			dbc.setLong(8,ad.getPredictclick());
			dbc.setLong(9,ad.getPredictexposure());
			dbc.setDouble(10,ad.getPredictcpc());
			dbc.setDouble(11,ad.getPredictcpl());
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
	public static Map<String, Object> getAdInfoScheduleById(int aid) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sql = "select * from dbo_pub_adinfo d1,dbo_pub_adschedule d2 where d1.adinfoid = d2.adinfoid and d1.adinfoid='"+aid+"' and d2.edate >= '"+sdf.format(new Date().getTime())+"' and d2.sdate <='"+sdf.format(new Date().getTime())+"'";
		DBConnect dbc = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			dbc = new DBConnect(sql);
			rs = dbc.executeQuery();
			if(rs.next()){
				map.put("adurl",rs.getString("adurl"));
				map.put("adftl",rs.getString("adftl"));
				map.put("adimg", rs.getString("adimg"));
				map.put("isdefault",rs.getInt("isdefault"));
				map.put("isshow",rs.getInt("isshow"));
				//map.put("adtype", rs.getString("adtype"));
				//map.put("adplace",String.valueOf(rs.getInt("adplace")));
				map.put("adInfoId",rs.getInt("id"));
				map.put("adId",String.valueOf(rs.getInt("adId")));
				map.put("sdate",sdf.format(rs.getTimestamp("sdate")));
				map.put("edate",sdf.format(rs.getTimestamp("edate")));
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
		return map;
	}
	//更新广告位
	public static void updateAdvertisement(DboPubAd ad) {
		// TODO Auto-generated method stub
		String sql = "update dbo_pub_ad set city=?,html=?,adtype=?,adwidth=?,adheight=?,adplace=?,adprice=?,predictclick=?,predictexposure=?,predictcpc=?,predictcpl=? where id = ?";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1,ad.getCity());
			dbc.setString(2, ad.getHtml());
			dbc.setString(3,ad.getAdtype());
			dbc.setInt(4,ad.getAdwidth());
			dbc.setInt(5,ad.getAdheight());
			dbc.setInt(6,ad.getAdplace());
			dbc.setDouble(7, ad.getAdprice());
			dbc.setLong(8,ad.getPredictclick());
			dbc.setLong(9,ad.getPredictexposure());
			dbc.setDouble(10,ad.getPredictcpc());
			dbc.setDouble(11,ad.getPredictcpl());
			dbc.setInt(12,ad.getId());
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
	public static boolean judgeAdHasOrNot(String sql) {
		// TODO Auto-generated method stub
		DBConnect dbc = null;
		boolean flag = false;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			if(rs.next()){
				flag = true;
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
		return flag;
	} 
}
