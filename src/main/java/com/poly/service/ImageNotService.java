package com.poly.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.poly.bean.ChangeSortEntity;
import com.poly.dao.subDaos.DboImgNewcontentSubDao;
import com.poly.dao.subDaos.DboImgNewtitleSubDao;

public class ImageNotService {

	public static final ImageNotService instance = new ImageNotService();

	public static ImageNotService getInstance() {
		return instance;
	}

	public enum carImg {
		// / <summary>
		// / 所有图片
		// / </summary>
		All("所有图片", -2),
		// / <summary>
		// / 车型图片
		// / </summary>
		OnlyCar("车型图片", -1),
		// / <summary>
		// / 非车型图片
		// / </summary>
		NotCar("非车型图片", 0),
		// / <summary>
		// / 车身外观
		// / </summary>
		Appearance("车身外观", 1),
		// / <summary>
		// / 车厢座椅
		// / </summary>
		Seats("车厢座椅", 2),
		// / <summary>
		// / 中控方向盘
		// / </summary>
		Control("中控方向盘", 3),
		// / <summary>
		// / 其它与改装
		// / </summary>
		Other("其它与改装", 4),
		// / <summary>
		// / 车型图解
		// / </summary>
		Tujie("车型图解", 5),
		// / <summary>
		// / 官方图
		// / </summary>
		Guantu("官方图", 6);

		private String name;

		private int id;

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		carImg(String name, int id) {
			this.name = name;
			this.id = id;
		}

		public static carImg getEnum(final int id) {
			for (carImg ci : carImg.values()) {
				if (ci.getId() == id) {
					return ci;
				}
			}
			return null;
		}

	}

	DboImgNewtitleSubDao dboImgNewtitleSubDao = new DboImgNewtitleSubDao();
	DboImgNewcontentSubDao dboImgNewcontentSubDao= new DboImgNewcontentSubDao();

	//取主题信息
	public List<HashMap<String, Object>> getTitleInfo(String catalogid,
			int start, int rows) {
		List<HashMap<String, Object>> maplist = dboImgNewtitleSubDao.getTitleInfo(
				catalogid, start, rows);
		for (HashMap<String, Object> map : maplist) {
			map.put("typeName",
					carImg.getEnum(Integer.parseInt(map.get("type").toString()))
							.getName());
		}
		return maplist;
	}
	
	public HashMap<String, Object> getTitleById(String id){
		return dboImgNewtitleSubDao.getTitleById(id).get(0);
	}
	
	
	//取多个主题下的图片
	public List<HashMap<String, Object>> getImagePage(
			List<HashMap<String, Object>> imgTitleList) {
		List<String> idlist = new ArrayList<String>();
		for (HashMap<String, Object> map : imgTitleList) {
			idlist.add(map.get("id").toString().trim());
		}
		String idStr = idlist.toString().replace("[", "").replace("]", "");
		List<HashMap<String, Object>> maplist = dboImgNewtitleSubDao
				.getImagePage(idStr);
		return maplist;
	}
	
	//取一个主题下的图片
	public List<HashMap<String, Object>> getImagePage(
			String id) {
		List<HashMap<String, Object>> maplist = dboImgNewtitleSubDao
				.getImagePage(id);
		return maplist;
	}

	//换位置信息
	public List<HashMap<String, Object>> getImageChangePage(String titleId,
			int start, int rows) {
		return dboImgNewtitleSubDao.getImageChangePage(titleId, start, rows);
	}
	
	//全部位置信息
	public List<HashMap<String, Object>> getAllImageChangePage(String idStr){
		return dboImgNewtitleSubDao.getAllImageChangePage(idStr);
	}
	
	public List<HashMap<String, Object>> addSort(List<HashMap<String, Object>> imgPageList,List<HashMap<String, Object>> imgAllPageList){
		for(HashMap<String, Object> map: imgPageList){
			for(int i= 0 ;i<imgAllPageList.size();i++){
				if(map.get("id").equals(imgAllPageList.get(i).get("id"))){
					if(i-1<0){
						map.put("presort", imgAllPageList.get(i).get("sortid"));
						map.put("preid", imgAllPageList.get(i).get("id"));
					}else{
						map.put("presort", imgAllPageList.get(i-1).get("sortid"));
						map.put("preid", imgAllPageList.get(i-1).get("id"));
					}
					
					if(i == imgAllPageList.size()-1){
						map.put("nextsort", imgAllPageList.get(i).get("sortid"));
						map.put("nextid", imgAllPageList.get(i).get("id"));
					}else{
						map.put("nextsort", imgAllPageList.get(i+1).get("sortid"));
						map.put("nextid", imgAllPageList.get(i+1).get("id"));
					}
				}
			}
		}
		return imgPageList;
	}
	
	public List<HashMap<String, Object>> getAddadmin() {
		return dboImgNewtitleSubDao.getAddadmin();
	}
	
	public int deleteImageTitle(int titleid){
		return dboImgNewtitleSubDao.deleteImageTitle(titleid);
	}
	
	public int deleteImageContent(int id){
		return dboImgNewtitleSubDao.deleteImageContent(id);
	}
	
	public int deleteImageContentBatch(List<Integer> deleteArr){
		for(Integer id :deleteArr){
			dboImgNewtitleSubDao.deleteImageContent(id);
		}
		return 1;
	}
	
	public int setComefrom(String comefrom,int id){
		return dboImgNewtitleSubDao.setComefrom(comefrom, id);
	}
	
	public int setComefromBatch(String comefrom,List<Integer> deleteArr){
		for(Integer id :deleteArr){
			dboImgNewtitleSubDao.setComefrom(comefrom, id);
		}
		return 1;
	}
	
	public int changeSort(ChangeSortEntity changeSortEntity){
		return dboImgNewtitleSubDao.changeSort(changeSortEntity);
	}
	
	public List<HashMap<String, Object>> getImageDetail(String  catalogid,String keywords,int type,int start, int rows) {
		return dboImgNewcontentSubDao.getImageDetail(catalogid,keywords,type,start,rows);
	}
	
	public void deleteTitle(List<String> imgTitle){
		for(String id :imgTitle){
			dboImgNewtitleSubDao.deleteTitle(Integer.parseInt(id));
		}
	}

}
