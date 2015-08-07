package com.poly.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import car_beans.DboNewNews;
import car_daos.DBConnect;
import car_daos.DboNewNewsDao;

public class StatisticsService {

	private static final StatisticsService instance = new StatisticsService();

	private StatisticsService() {

	}

	public static StatisticsService getInstance() {
		return instance;
	}

	//行情
	public List<DboNewNews> list(String addadmin, String beginTm, String endTm, int begin, int size, String catalogStr) {
		String sql = "isdelete <> 1 and savedate >= '" + beginTm + "' and savedate < '" + endTm + "'";

		if(addadmin!=null && addadmin.length()>1)
			sql+=" and addadmin in (" + addadmin + ")";
		
		if(catalogStr!=null)
			sql+=" and newscatalogid in ("+catalogStr+")";
		
		sql +=" order by savedate desc limit "+begin+","+size;
		return DboNewNewsDao.where(sql);
	}

	public int amount(String addadmin, String beginTm, String endTm, String catalogStr) {
		int amount = 0;
		String sql = "isdelete <> 1 and savedate >= '" + beginTm + "' and savedate < '" + endTm + "'";
		
		if(addadmin!=null && addadmin.length()>1)
			sql+=" and addadmin in (" + addadmin + ")";
		
		if(catalogStr!=null)
			sql+=" and newscatalogid in ("+catalogStr+")";
		
		amount = DboNewNewsDao.whereCount(sql);
		return amount;
	}
	
	//原创新闻
	public List<DboNewNews> originalList(String addadmin, String beginTm, String endTm, int begin, int size) {
		String sql = "isdelete <> 1 and isoriginal = 1 and savedate >= '" + beginTm + "' and savedate < '" + endTm + "'";

		if(addadmin!=null && addadmin.length()>1)
			sql+=" and addadmin in (" + addadmin + ")";
		
		sql +=" order by savedate desc limit "+begin+","+size;
		return DboNewNewsDao.where(sql);
	}

	public int originalAmount(String addadmin, String beginTm, String endTm) {
		int amount = 0;
		String sql = "isdelete <> 1 and isoriginal = 1 and savedate >= '" + beginTm + "' and savedate < '" + endTm + "'";
		
		if(addadmin!=null && addadmin.length()>1)
			sql+=" and addadmin in (" + addadmin + ")";
		
		amount = DboNewNewsDao.whereCount(sql);
		return amount;
	}
	
	//软文
	public List<DboNewNews> otherList(String addadmin, String beginTm, String endTm, int begin, int size, String catalogStr) {
		String sql = "isdelete <> 1 and isoriginal <> 1 and savedate >= '" + beginTm + "' and savedate < '" + endTm + "'";

		if(addadmin!=null && addadmin.length()>1)
			sql+=" and addadmin in (" + addadmin + ")";
		
		if(catalogStr!=null)
			sql+=" and newscatalogid not in ("+catalogStr+")";
		
		sql +=" order by savedate desc limit "+begin+","+size;
		return DboNewNewsDao.where(sql);
	}

	public int otherAmount(String addadmin, String beginTm, String endTm, String catalogStr) {
		int amount = 0;
		String sql = "isdelete <> 1 and isoriginal <> 1 and savedate >= '" + beginTm + "' and savedate < '" + endTm + "'";
		
		if(addadmin!=null && addadmin.length()>1)
			sql+=" and addadmin in (" + addadmin + ")";
		
		if(catalogStr!=null)
			sql+=" and newscatalogid not in ("+catalogStr+")";
		
		amount = DboNewNewsDao.whereCount(sql);
		return amount;
	}
	//新车
	public List<DboNewNews> newCarList(String addadmin, String beginTm, String endTm, int begin, int size, String catalogStr) {
		String sql = "isdelete <> 1 and isoriginal <> 1 and savedate >= '" + beginTm + "' and savedate < '" + endTm + "'";

		if(addadmin!=null && addadmin.length()>1)
			sql+=" and addadmin in (" + addadmin + ")";
		
		if(catalogStr!=null)
			sql+=" and newscatalogid in ("+catalogStr+")";
		
		sql +=" order by savedate desc limit "+begin+","+size;
		return DboNewNewsDao.where(sql);
	}

	public int newCarAmount(String addadmin, String beginTm, String endTm, String catalogStr) {
		int amount = 0;
		String sql = "isdelete <> 1 and isoriginal <> 1 and savedate >= '" + beginTm + "' and savedate < '" + endTm + "'";
		
		if(addadmin!=null && addadmin.length()>1)
			sql+=" and addadmin in (" + addadmin + ")";
		
		if(catalogStr!=null)
			sql+=" and newscatalogid in ("+catalogStr+")";
		
		amount = DboNewNewsDao.whereCount(sql);
		return amount;
	}
	
	//新闻
	public List<DboNewNews> newsList(String addadmin, String beginTm, String endTm, int begin, int size, String catalogStr) {
		String sql = "isdelete <> 1 and isoriginal <> 1 and savedate >= '" + beginTm + "' and savedate < '" + endTm + "'";

		if(addadmin!=null && addadmin.length()>1)
			sql+=" and addadmin in (" + addadmin + ")";
		
		if(catalogStr!=null)
			sql+=" and newscatalogid in ("+catalogStr+")";
		
		sql +=" order by savedate desc limit "+begin+","+size;
		return DboNewNewsDao.where(sql);
	}

	public int newsAmount(String addadmin, String beginTm, String endTm, String catalogStr) {
		int amount = 0;
		String sql = "isdelete <> 1 and isoriginal <> 1 and savedate >= '" + beginTm + "' and savedate < '" + endTm + "'";
		
		if(addadmin!=null && addadmin.length()>1)
			sql+=" and addadmin in (" + addadmin + ")";
		
		if(catalogStr!=null)
			sql+=" and newscatalogid in ("+catalogStr+")";
		
		amount = DboNewNewsDao.whereCount(sql);
		return amount;
	}

	//总新闻
	public List<DboNewNews> allList(String addadmin, String beginTm,
			String endTm, int begin, int size) {
		String sql = "isdelete <> 1 and savedate >= '" + beginTm + "' and savedate < '" + endTm + "'";
		if(addadmin!=null && addadmin.length()>1)
			sql+=" and addadmin in (" + addadmin + ")";
		sql +=" order by savedate desc limit "+begin+","+size;
		return DboNewNewsDao.where(sql);
	}
	
	public int allAmount(String addadmin, String beginTm, String endTm, String catalogStr) {
		int amount = 0;
		String sql = "isdelete <> 1 and savedate >= '" + beginTm + "' and savedate < '" + endTm + "'";
		
		if(addadmin!=null && addadmin.length()>1)
			sql+=" and addadmin in (" + addadmin + ")";

		amount = DboNewNewsDao.whereCount(sql);
		return amount;
	}
	
	//获取行情目录
	public static List<Integer> getNewsMarketCatalogList(){
		List<Integer> list = new ArrayList<Integer>();
		DBConnect dbc = null;
		//String sql = "SELECT catalogid from dbo_new_catalog where fatherid in (SELECT catalogid from dbo_new_catalog WHERE fatherid in (select catalogid from dbo_new_catalog WHERE fatherid = '43' and isdelete = 0) and (catalogname like '%优惠%' || catalogname like '%行情%')) or catalogid in (SELECT catalogid from dbo_new_catalog WHERE fatherid in (select catalogid from dbo_new_catalog WHERE fatherid = '43' and isdelete = 0) and (catalogname like '%优惠%' || catalogname like '%行情%'))";
		String sql = "SELECT catalogid from dbo_new_catalog where catalogname like '%行情' or catalogname like '%优惠'";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()){
				list.add(rs.getInt("catalogid"));
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
	
	//获取新闻目录
	public static List<Integer> getNewsCatalogList(String catalogid){
		List<Integer> list = new ArrayList<Integer>();
		DBConnect dbc = null;
		String sql = "SELECT * from dbo_new_catalog where fatherid in (SELECT catalogid from dbo_new_catalog where fatherid = '"+catalogid+"') or catalogid in (SELECT catalogid from dbo_new_catalog where fatherid = '"+catalogid+"')";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()){
				list.add(rs.getInt("catalogid"));
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

	public static int getNewsCommentCount(String key) {
		// TODO Auto-generated method stub
		String sql = "select count(*) as count from dbo_all_comment where type = 1 and tid = 0 and catalogid = '"+key+"'";
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
	
}
