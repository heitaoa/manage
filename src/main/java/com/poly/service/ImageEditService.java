package com.poly.service;

import java.util.HashMap;
import java.util.List;

import car_beans.DboImgTitle;
import car_beans.TbImgTypinfo;
import car_daos.DboImgTitleDao;
import car_daos.TbImgTypinfoDao;

import com.poly.bean.ImageEntity;
import com.poly.dao.subDaos.DboCarCatalognewSubDao;
import com.poly.dao.subDaos.DboImgContentSubDao;
import com.poly.dao.subDaos.DboImgTitleSubDao;

public class ImageEditService {
	
	public static final ImageEditService instance = new ImageEditService();

	public static ImageEditService getInstance() {
		return instance;
	}
	
	DboImgContentSubDao  dboImgContentSubDao = new DboImgContentSubDao();
	
	DboCarCatalognewSubDao dboCarCatalognewSubDao = new DboCarCatalognewSubDao();
	
	DboImgTitleSubDao dboImgTitleSubDao = new DboImgTitleSubDao();
	
	public int addImage(ImageEntity imageEntity) throws Exception{
		/*String path = imageEntity.getImagePath();
		if(!("").equals(path)){
			imageEntity.setImagePath("ct1"+path.substring(path.indexOf("/upload/"), path.length()));//upload��Ϊ����Ŀ¼
		}*/
		return dboImgContentSubDao.addImage(imageEntity);
	}

	public int updateImage(ImageEntity imageEntity){
		/*String path = imageEntity.getImagePath();
		if(!("").equals(path)){
			imageEntity.setImagePath("ct1"+path.substring(path.indexOf("/upload/"), path.length()));//upload��Ϊ����Ŀ¼
		}*/
		return dboImgContentSubDao.updateImage(imageEntity);
	}
	
	public int updateContentTitle(String title,int id){
		return dboImgContentSubDao.updateTitle(title, id);
	}
	
	
	public HashMap<String, Object> getImageInfo(int id){
		return dboImgContentSubDao.getImageInfo(id).get(0);
	}
	
	public String getCarName(int catalogid){
		return dboCarCatalognewSubDao.getCarName(catalogid);
	}
	
	public int addTitle(DboImgTitle dboImgTitle) throws Exception{
		return dboImgTitleSubDao.addTitle(dboImgTitle);
	}
	
	public DboImgTitle carTitleChange(int id){
		return DboImgTitleDao.where("id = "+id).get(0);
	}
	
	public void updateTitle(DboImgTitle titleBean){
		DboImgTitleDao.update(titleBean);
	}
	
	public List<TbImgTypinfo> getAllimgType(String type){
		return TbImgTypinfoDao.where("type="+type);
	}

}
