package com.poly.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import car_beans.DboAdmUser;
import car_beans.DboAreCatalog;
import car_beans.TbSubSites;
import car_beans.TbUsers;
import car_daos.DboAdmUserDao;
import car_daos.DboAreCatalogDao;
import car_daos.TbSubSitesDao;
import car_daos.TbUserlevelDao;
import car_daos.TbUsersDao;

import com.poly.bean.UserEntity;
import com.poly.dao.subDaos.DboDntUsersSubDao;
import com.poly.dao.subDaos.TbCarGroupbuyDaoSubDao;
import com.poly.dao.subDaos.TbUserSubDao;
import com.redis.Redis2Dao;

public class AdminService {
	
	public static final AdminService instance = new AdminService();
	
	public static AdminService getInstance() {
		return instance;
	}
	
	DboDntUsersSubDao dboDntUsersSubDao = new DboDntUsersSubDao();
	TbUserSubDao tbUserSubDao = new TbUserSubDao();
	TbUsersDao tbUsersDao = new TbUsersDao();
	TbUserlevelDao tbUserlevelDao = new TbUserlevelDao();
	DboAdmUserDao dboAdmUserDao = new DboAdmUserDao();
	public List<HashMap<String, Object>> getUsersInfo(String username){
		
		return dboDntUsersSubDao.getUsersInfo(username);
		
	}
	
	public List<HashMap<String, Object>>   getStationUsersInfo(int ulevel,String sid){
		return dboDntUsersSubDao.getStationUsersInfo(ulevel,sid);
	}
	public List<DboAreCatalog> getAreaList(){
		return DboAreCatalogDao.where("fatherid = 0 order by sortid");
	}
	
	public int addUser(UserEntity user){
		return dboDntUsersSubDao.addUser(user);
	}
	
	public int updateUser(UserEntity user){
		return dboDntUsersSubDao.updateUser(user);
	}
	public int updateStationUser(UserEntity user){
		return dboDntUsersSubDao.updateStationUser(user);
	}
	/*public int deleteUser(String uid){
		return dboDntUsersSubDao.deleteUser(uid);
	}*/
	public int addStationUser(UserEntity user){
		return dboDntUsersSubDao.addStationUser(user);
	}
	public int updateStationUserPwd(String id,String pwd){
		return dboDntUsersSubDao.updateUserPwd(id,pwd);
	}
	
	public List<HashMap<String, Object>> getUnuesdBrand(int ulevel,String sid){
		List<HashMap<String, Object>> total = (new TbCarGroupbuyDaoSubDao()).getCarBrand();
		List<HashMap<String, Object>> newtotal = new ArrayList<HashMap<String,Object>>();
		List<String> usedBrandList2 = new ArrayList<String>();
		List<String> usedBrandList = dboDntUsersSubDao.getUsedBrand(ulevel, sid);
		for (String brands : usedBrandList) {
			String[] brandStrings = brands.split(",");
			for (String str : brandStrings) {
				usedBrandList2.add(str.trim());
			}
		}
		for (HashMap<String, Object> map : total) {
			String brand = map.get("iway").toString().trim();
			if(!usedBrandList2.contains(brand))
				newtotal.add(map);
		}
		return newtotal;
	}

	public boolean isNameExist(String username){
		String name = dboDntUsersSubDao.isNameExist(username);
		if(("").equals(name)){
			return true;
		}
		return false;
	}
	//315 begin
	public  List<Map<String, Object>> getFinanceSite(){
		return tbUserSubDao.getFinanceSite();
	}
	
	public List<Map<String, Object>> getFinanceUser(String siteId,String name){
		return tbUserSubDao.getFinanceUser(siteId, name);
	}
	public int checkUser(String userid){
		return tbUsersDao.whereCount(" userid = '"+userid+"' and isdelete=0");
 	}
	public int deleteUser(String id){
		int count = 0;
		List<TbUsers> users = TbUsersDao.where("id = '"+id+"'");
		if(users.size()>0){
			TbUsers user = users.get(0);
			user.setIsdelete(1);
			count = tbUsersDao.update(user);
		}
		return count;
	}
	public void saveUser(TbUsers tbUsers) throws Exception{
		saveAdmUser(tbUsers.getUserid());
		tbUsersDao.save(tbUsers);
//		Redis2Dao.initAdmUser();
	}
	public String getOldUser(String name) throws Exception{
		String str = "";
		String uname = tbUserSubDao.getFinUsersByUid(name).get("USER_NAME");
		List<DboAdmUser> list = dboAdmUserDao.where("realname = '"+uname+"'");
		if(list.size() > 0){
			str = list.get(0).getUsername();
		}else
			str = name;
		
		return str;
	}
	public void saveAdmUser(String name) throws Exception{
		String uname = tbUserSubDao.getFinUsersByUid(name).get("USER_NAME");
		List list = dboAdmUserDao.where("realname = '"+uname+"'");
		if(list.size() == 0){
			DboAdmUser user = new DboAdmUser();
			user.setUsername(name);
			user.setAdddate(new Date());
			user.setAreaid(0);
			user.setPassword("");
			user.setPhone("");
			user.setRealname(uname);
			user.setUdate(new Date());
			dboAdmUserDao.save(user);
		}
	}
	public int updateUser(TbUsers tbUsers) throws Exception{
		int count = 0;
		List<TbUsers> users = TbUsersDao.where("id = '"+tbUsers.getId()+"'");
		if(users.size()>0){
			TbUsers user = users.get(0);
			user.setBrands(tbUsers.getBrands());
			user.setCity(tbUsers.getCity());
			user.setProv(tbUsers.getProv());
			user.setUlevel(tbUsers.getUlevel());
			user.setUserid(tbUsers.getUserid());
			user.setDetail(tbUsers.getDetail());
			count = tbUsersDao.update(user);
			saveAdmUser(tbUsers.getUserid());
		}
		return count;
	}
	public  List<Map<String, Object>> getUser(String name){
		return tbUserSubDao.getUser(name);
	}
	public List<Map<String, Object>> getStationUser(String name,String siteid,String userid){
		return tbUserSubDao.getStationUser(name,siteid,userid);
	}
	public Map<String, Object> getOneUser(String id){
		return tbUserSubDao.getOneUser(id);
	}
	
	public List<HashMap<String, Object>> getUnUsedBrands(String siteid){

		List<HashMap<String, Object>> total = (new TbCarGroupbuyDaoSubDao()).getCarBrand();
		List<HashMap<String, Object>> newtotal = new ArrayList<HashMap<String,Object>>();
		List<String> usedBrandList2 = new ArrayList<String>();
		List<String> usedBrandList = tbUserSubDao.getUsedBrands(siteid);
		for (String brands : usedBrandList) {
			String[] brandStrings = brands.split(",");
			for (String str : brandStrings) {
				usedBrandList2.add(str.trim());
			}
		}
		for (HashMap<String, Object> map : total) {
			String brand = map.get("iway").toString().trim();
			if(!usedBrandList2.contains(brand))
				newtotal.add(map);
		}
		return newtotal;
	
	}
	public DboAreCatalog getProvId(String id){
		TbSubSites sites = (new TbSubSitesDao()).where("id = "+id).get(0);
		DboAreCatalog area = (new DboAreCatalogDao()).where("catalogid = "+sites.getAreaid()).get(0);
		return area;
	}
	/**
	 * 
	 * @return username ,realname
	 */
	public List<Map<String, String>> listBianji(){
		return tbUserSubDao.listBianji();
	}
	
	public List<Map<String, String>> listEditor() throws Exception{
		return tbUserSubDao.listEditor();
	}
	
}
