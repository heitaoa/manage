package com.poly.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import car_beans.TbUsers;
import car_daos.DBConnect;
import car_daos.TbUsersDao;

public class Tools {
	public void saveSevice(){
		List<String> ids = getIdsByDept("2,3,13,15,17");
		for(String id:ids){
			List<TbUsers> list = TbUsersDao.where("userid='"+id+"' and isdelete=0");
			if(list.size()>0){
				TbUsers user = list.get(0);
				String now_detail = user.getDetail();
				String detail = makeDetail(now_detail,"46,48,74,75,76");
				user.setDetail(detail);
				user.setId(user.getId());
//				String now_ulevel = user.getUlevel();
//				String ulevel = makeUlevel(now_ulevel,"2");
//				user.setUlevel(ulevel);
				user.setAddtime(new Date());
				TbUsersDao.update(user);
			}else{
				TbUsers user = new TbUsers();
				user.setAddtime(new Date());
				user.setDetail("46,48,74,75,76");
				user.setUlevel("2");
				user.setUserid(id);
				try {
					TbUsersDao.save(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void saveSeviceForTq(){
		List<String> ids = getIdsByDept("2,13,17");//经销商、大客户、区域
		for(String id:ids){
			List<TbUsers> list = TbUsersDao.where("userid='"+id+"' and isdelete=0");
			if(list.size()>0){
				TbUsers user = list.get(0);
				String now_detail = user.getDetail();
				String detail = makeDetail(now_detail,"46,81,82,85,86");
				user.setDetail(detail);
				user.setId(user.getId());
//				String now_ulevel = user.getUlevel();
//				String ulevel = makeUlevel(now_ulevel,"2");
//				user.setUlevel(ulevel);
				user.setAddtime(new Date());
				TbUsersDao.update(user);
			}else{
				TbUsers user = new TbUsers();
				user.setAddtime(new Date());
				user.setDetail("46,81,82,85,86");
				user.setUlevel("2");
				user.setUserid(id);
				try {
					TbUsersDao.save(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void saveSeviceForTqToManager(){
		String str = "Poly0308,Poly0087,Poly0336,Poly0522,Poly0358,Poly0431,Poly0067,Poly0509,Poly0360,Poly0080,Poly0182,Poly0411,Poly0244,Poly0167";
		String [] idsArr = str.split(",");
		List<String> ids = new ArrayList<String>();
		for(String idStr:idsArr){
			ids.add(idStr);
		}
		for(String id:ids){
			List<TbUsers> list = TbUsersDao.where("userid='"+id+"' and isdelete=0");
			if(list.size()>0){
				TbUsers user = list.get(0);
				String now_detail = user.getDetail();
				String detail = makeDetail(now_detail,"46,81,82,85,83,86,90");
				user.setDetail(detail);
				user.setId(user.getId());
//				String now_ulevel = user.getUlevel();
//				String ulevel = makeUlevel(now_ulevel,"2");
//				user.setUlevel(ulevel);
				user.setAddtime(new Date());
				TbUsersDao.update(user);
			}else{
				TbUsers user = new TbUsers();
				user.setAddtime(new Date());
				user.setDetail("46,81,82,85,83,86,90");
				user.setUlevel("2");
				user.setUserid(id);
				try {
					TbUsersDao.save(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	private String makeUlevel(String now_ulevel, String ulevel) {
		String [] arrNow = now_ulevel.split(",");
		String [] arrUlevel = ulevel.split(",");
		List<String>list = new ArrayList<String>();
		for(String n:arrNow){
			list.add(n);
		}
		u:for(String u:arrUlevel){
			for(String n:list){
				if(u.equals(n)){
					continue u;
				}
			}
			list.add(u);
		}
		String str="";
		for(int i=0;i<list.size();i++){
			if(i==list.size()-1){
				str = str+list.get(i);
			}else{
				str = str+list.get(i)+",";
			}
		}
		return str;
	}
	private String makeDetail(String now, String detail) {
		String [] arrNow = now.split(",");
		String [] arrDetail = detail.split(",");
		List<String>list = new ArrayList<String>();
		for(String n:arrNow){
			list.add(n);
		}
		d:for(String d:arrDetail){
			for(String n:list){
				if(d.equals(n)){
					continue d;
				}
			}
			list.add(d);
		}
		String str="";
		for(int i=0;i<list.size();i++){
			if(i==list.size()-1){
				str = str+list.get(i);
			}else{
				str = str+list.get(i)+",";
			}
		}
		return str;
	}
	public void savePromo(){
		List<String> ids = getIdsByDept("9");
		for(String id:ids){
			List<TbUsers> list = TbUsersDao.where("userid='"+id+"' and isdelete=0");
			if(list.size()>0){
				TbUsers user = list.get(0);
				String now_detail = user.getDetail();
				String detail = makeDetail(now_detail,"46,47,51");
				user.setDetail(detail);
				user.setId(user.getId());
//				String now_ulevel = user.getUlevel();
//				String ulevel = makeUlevel(now_ulevel,"2");
//				user.setUlevel(ulevel);
				user.setAddtime(new Date());
				TbUsersDao.update(user);
			}else{
				TbUsers user = new TbUsers();
				user.setAddtime(new Date());
				user.setDetail("46,47,51");
				user.setUlevel("2");
				user.setUserid(id);
				try {
					TbUsersDao.save(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	public void saveShCs(){
		List<String> ids = getIdsByDeptAndOrg("16","1");
		for(String id:ids){
			List<TbUsers> list = TbUsersDao.where("userid='"+id+"' and isdelete=0");
			if(list.size()>0){
				TbUsers user = list.get(0);
				String now_detail = user.getDetail();
				String detail = makeDetail(now_detail,"46,77,78,79,80");
				user.setDetail(detail);
				user.setId(user.getId());
//				String now_ulevel = user.getUlevel();
//				String ulevel = makeUlevel(now_ulevel,"3");
//				user.setUlevel(ulevel);
				user.setAddtime(new Date());
				TbUsersDao.update(user);
			}else{
				TbUsers user = new TbUsers();
				user.setAddtime(new Date());
				user.setDetail("46,77,78,79,80");
				user.setUlevel("3");
				user.setUserid(id);
				try {
					TbUsersDao.save(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void saveCs(){
		List<String> ids = getIdsByDept("16");
		for(String id:ids){
			List<TbUsers> list = TbUsersDao.where("userid='"+id+"' and isdelete=0");
			if(list.size()>0){
				TbUsers user = list.get(0);
				String now_detail = user.getDetail();
				String detail = makeDetail(now_detail,"46,77,78,79,80");
				user.setDetail(detail);
				user.setId(user.getId());
//				String now_ulevel = user.getUlevel();
//				String ulevel = makeUlevel(now_ulevel,"3");
//				user.setUlevel(ulevel);
				user.setAddtime(new Date());
				TbUsersDao.update(user);
			}else{
				TbUsers user = new TbUsers();
				user.setAddtime(new Date());
				user.setDetail("46,77,78,79,80");
				user.setUlevel("3");
				user.setUserid(id);
				try {
					TbUsersDao.save(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void saveOtherCs(){
		List<String> ids = getIdsByDeptWithoutOrg("2,3,13,15,17","1");
		for(String id:ids){
			List<TbUsers> list = TbUsersDao.where("userid='"+id+"' and isdelete=0");
			if(list.size()>0){
				TbUsers user = list.get(0);
				String now_detail = user.getDetail();
				String detail = makeDetail(now_detail,"46,77,78,79,80");
				user.setDetail(detail);
				user.setId(user.getId());
//				String now_ulevel = user.getUlevel();
//				String ulevel = makeUlevel(now_ulevel,"3");
//				user.setUlevel(ulevel);
				user.setAddtime(new Date());
				TbUsersDao.update(user);
			}
		}
	}
	private List<String> getIdsWithoutOrg(String string2) {
		String sql = "select USER_CODE from finance.tb_fin_user where ISONJOB=0 and ORG_CODE<>"+string2;
		List<String> ids = new ArrayList<String>();
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				ids.add(rs.getString("USER_CODE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ids;
	}
	private List<String> getIdsByDeptAndOrg(String string, String string2) {
		String sql = "select USER_CODE from finance.tb_fin_user where DEPT_CODE in ("+string+") and ISONJOB=0 and ORG_CODE="+string2;
		List<String> ids = new ArrayList<String>();
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				ids.add(rs.getString("USER_CODE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ids;
	}
	public static void main(String[]args){
		new Tools().saveSevice();
	}
	private List<String> getIdsByDept(String string) {
		String sql = "select USER_CODE from finance.tb_fin_user where DEPT_CODE in ("+string+") and ISONJOB=0";
		List<String> ids = new ArrayList<String>();
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				ids.add(rs.getString("USER_CODE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ids;
	}
	private List<String> getIdsByDeptWithoutOrg(String string,String string2) {
		String sql = "select USER_CODE from finance.tb_fin_user where DEPT_CODE in ("+string+") and ISONJOB=0 and ORG_CODE<>"+string2;
		List<String> ids = new ArrayList<String>();
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				ids.add(rs.getString("USER_CODE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ids;
	}
}
