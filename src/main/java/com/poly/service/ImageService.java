package com.poly.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import car_daos.DboDntUsersDao;

import com.poly.action.action_tree.Tree.TreeInfo;
import com.poly.bean.ChangeSortEntity;
import com.poly.dao.subDaos.DboImgContentSubDao;
import com.poly.dao.subDaos.DboImgTitleSubDao;
import com.poly.util.MyConfig;
import com.poly.util.UrlChangeUtil;
import com.redis.RedisParseUtil;

public class ImageService {

	public static final ImageService instance = new ImageService();

	public static ImageService getInstance() {
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

	DboImgTitleSubDao dboImgTitleSubDao = new DboImgTitleSubDao();
	DboImgContentSubDao dboImgContentSubDao= new DboImgContentSubDao();

	//ȡ������Ϣ
	public List<HashMap<String, Object>> getTitleInfo(String catalogid,
			int start, int rows) {
		List<HashMap<String, Object>> maplist = dboImgTitleSubDao.getTitleInfo(
				catalogid, start, rows);
		for (HashMap<String, Object> map : maplist) {
			map.put("typeName",
					carImg.getEnum(Integer.parseInt(map.get("type").toString()))
							.getName());
		}
		return maplist;
	}
	
	public HashMap<String, Object> getTitleById(String id){
		return dboImgTitleSubDao.getTitleById(id).get(0);
	}
	
	
	//ȡ��������µ�ͼƬ
	public List<HashMap<String, Object>> getImagePage(
			List<HashMap<String, Object>> imgTitleList) {
		List<String> idlist = new ArrayList<String>();
		for (HashMap<String, Object> map : imgTitleList) {
			idlist.add(map.get("id").toString().trim());
		}
		String idStr = idlist.toString().replace("[", "").replace("]", "");
		List<HashMap<String, Object>> maplist = dboImgTitleSubDao
				.getImagePage(idStr);
		return maplist;
	}
	
	//ȡһ�������µ�ͼƬ
	public List<HashMap<String, Object>> getImagePage(
			String id) {
		List<HashMap<String, Object>> maplist = dboImgTitleSubDao
				.getImagePage(id);
		return maplist;
	}

	//��λ����Ϣ
	public List<HashMap<String, Object>> getImageChangePage(String titleId,
			int start, int rows) {
		return dboImgTitleSubDao.getImageChangePage(titleId, start, rows);
	}
	
	//ȫ��λ����Ϣ
	public List<HashMap<String, Object>> getAllImageChangePage(String idStr){
		return dboImgTitleSubDao.getAllImageChangePage(idStr);
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
		return dboImgTitleSubDao.getAddadmin();
	}
	
	public int deleteImageTitle(int titleid){
		return dboImgTitleSubDao.deleteImageTitle(titleid);
	}
	
	public int deleteImageContent(int id){
		return dboImgTitleSubDao.deleteImageContent(id);
	}
	
	public int deleteImageContentBatch(List<Integer> deleteArr){
		for(Integer id :deleteArr){
			dboImgTitleSubDao.deleteImageContent(id);
			RedisParseUtil.jedisPublish("delete", "dbo_img_content", id+"");
		}
		return 1;
	}
	
	public int setComefrom(String comefrom,int id){
		return dboImgTitleSubDao.setComefrom(comefrom, id);
	}
	
	public int setComefromBatch(String comefrom,List<Integer> deleteArr){
		for(Integer id :deleteArr){
			dboImgTitleSubDao.setComefrom(comefrom, id);
		}
		return 1;
	}
	
	public int changeSort(ChangeSortEntity changeSortEntity){
		return dboImgTitleSubDao.changeSort(changeSortEntity);
	}
	
	public List<HashMap<String, Object>> getImageDetail(String  catalogid,String keywords,int type,int start, int rows) {
		return dboImgContentSubDao.getImageDetail(catalogid,keywords,type,start,rows);
	}
	
	public void deleteTitle(List<String> imgTitle){
		for(String id :imgTitle){
			dboImgTitleSubDao.deleteTitle(Integer.parseInt(id));
			RedisParseUtil.jedisPublish("delete", "dbo_img_title", id);
		}
	}
	
	
	public List<HashMap<String, Object>> getSortImage(String titleid){
		List<HashMap<String, Object>> list = dboImgTitleSubDao.getSortImage(titleid);
		for(HashMap<String, Object> map:list){
			String pic = map.get("path").toString();
			pic = UrlChangeUtil.FormatCom(pic, 90, 60);
			map.put("newPath",pic);
		}
		return list;
	}
	
	public int updateSort(String id,int sortid){
		return dboImgTitleSubDao.updateSort(id, sortid);
	}
	
	public int imagechouqu(String carid){
		return dboImgTitleSubDao.imagechouqu(carid);
	}

}
