package com.poly.service;

import java.util.HashMap;

import car_beans.DboImgNewtitle;
import car_beans.DboImgTitle;
import car_daos.DboImgNewtitleDao;
import car_daos.DboImgTitleDao;

import com.poly.bean.ImageEntity;
import com.poly.dao.subDaos.DboImgNewcatalogSubDao;
import com.poly.dao.subDaos.DboImgNewcontentSubDao;
import com.poly.dao.subDaos.DboImgNewtitleSubDao;

public class ImageEditNotService {
	
	public static final ImageEditNotService instance = new ImageEditNotService();

	public static ImageEditNotService getInstance() {
		return instance;
	}
	
	
	DboImgNewcatalogSubDao dboImgNewcatalogSubDao = new DboImgNewcatalogSubDao();
	DboImgNewtitleSubDao dboImgNewtitleSubDao = new DboImgNewtitleSubDao();
	DboImgNewcontentSubDao dboImgNewcontentSubDao= new DboImgNewcontentSubDao();
	
	public int addImage(ImageEntity imageEntity) throws Exception{
		String path = imageEntity.getImagePath();
		if(!("").equals(path)){
			imageEntity.setImagePath("ct1"+path.substring(path.indexOf("/upload/"), path.length()));//upload��Ϊ����Ŀ¼
		}
		return dboImgNewcontentSubDao.addImage(imageEntity);
	}

	public int updateImage(ImageEntity imageEntity){
		String path = imageEntity.getImagePath();
		if(!("").equals(path)){
			imageEntity.setImagePath("ct1"+path.substring(path.indexOf("/upload/"), path.length()));//upload��Ϊ����Ŀ¼
		}
		return dboImgNewcontentSubDao.updateImage(imageEntity);
	}
	
	public HashMap<String, Object> getImageInfo(int id){
		return dboImgNewcontentSubDao.getImageInfo(id).get(0);
	}
	
	public String getImgName(int catalogid){
		return dboImgNewcatalogSubDao.getImgName(catalogid);
	}
	
	public int addTitle(DboImgNewtitle dboImgTitle) throws Exception{
		return dboImgNewtitleSubDao.addTitle(dboImgTitle);
	}
	
	public DboImgNewtitle carTitleChange(int id){
		return DboImgNewtitleDao.where("id = "+id).get(0);
	}
	
	public void updateTitle(DboImgNewtitle titleBean){
		DboImgNewtitleDao.update(titleBean);
	}

}
