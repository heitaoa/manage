package com.poly.service;

import java.sql.ResultSet;
import java.util.Map;

import car_daos.DBConnect;
import car_daos.DboDntUsersDao;
import car_daos.TbUsersDao;

import com.poly.dao.subDaos.LoginSubDao;
import com.poly.dao.subDaos.TbUserSubDao;

public class LoginService {

	public static final LoginService instance = new LoginService();

	public static LoginService getInstance() {
		return instance;
	}
	LoginSubDao loginSubDao = new LoginSubDao();
	TbUserSubDao tbUserSubDao = new TbUserSubDao();
	public String checkLogin(String username){
		return loginSubDao.checkLogin(username);
	}
	
	public Map<String,Object> getUserInfo(String username){
		return loginSubDao.getUserInfo(username);
	}
	
	public Map<String,Object> getUserInfos(String username){
		return tbUserSubDao.getUserInfo(username);
	}
	
	/**
	 * 获取客服所分管的项目
	 * @param uname
	 * @return
	 */
	public String queryTuiguangPro(String uname){
		return tbUserSubDao.queryTuiguangPro(uname);
	}
	
}
