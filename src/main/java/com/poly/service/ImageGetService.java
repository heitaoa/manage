package com.poly.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.dao.subDaos.ImageGetSubDao;
import com.poly.service.ImageService.carImg;
import com.poly.util.MyConfig;
import com.poly.util.UrlChangeUtil;
import com.redis.RedisDao;

public class ImageGetService {
	
	public static final ImageGetService instance = new ImageGetService();

	public static ImageGetService getInstance() {
		return instance;
	}
	
	ImageGetSubDao imageGetSubDao = new ImageGetSubDao();
	
	public List<HashMap<String, Object>> getImageInfo(String catalogid){
		List<HashMap<String, Object>> maplist = imageGetSubDao.getImageInfo(catalogid);
		for (HashMap<String, Object> map : maplist) {
			map.put("typeName",
					carImg.getEnum(Integer.parseInt(map.get("type").toString()))
							.getName());
			String pic = map.get("path").toString();
			/*if(pic.substring(0, 3).equals("315")){
				pic = UrlChangeUtil.FormatImg(pic, 150, 50);
				map.put("cturl","http://img.315che.com/");
			}else{
				//pic = pic.replace(".jpg", "_150x50.jpg").replace("ct1", MyConfig.www_ct_url);
				//map.put("cturl",MyConfig.www_ct_url);
			}*/
			pic = UrlChangeUtil.FormatCom(pic, 75, 50);
			String newspic = map.get("path").toString();
			newspic = UrlChangeUtil.FormatCom(newspic, 600, 400);
			map.put("newPath",pic);
			map.put("newsimgPath",newspic);
		}
		return maplist;
	}
	
	public List<Map<String, String>> getImageInfo(String catalogid,String titleKey){
		//List<HashMap<String, Object>> maplist = imageGetSubDao.getImageInfo(catalogid,titleKey);
		List<Map<String, String>> maplist = new ArrayList<Map<String, String>>();
		String[] idlist = catalogid.split(",");
		
		for(String key:idlist){
			maplist.addAll(this.carTypeImages(Integer.parseInt(key)));
		}
		List<Map<String, String>> rslist = new ArrayList<Map<String, String>>();
		for (Map<String, String> map : maplist) {
			if(map.get("type").equals(titleKey)){
				map.put("typeName",
						carImg.getEnum(Integer.parseInt(map.get("type").toString()))
								.getName());
				String pic = map.get("path").toString();
				pic = UrlChangeUtil.FormatCom(pic, 75, 50);
				map.put("newPath",pic);
				String newspic = map.get("path").toString();
				
				map.put("newsimgPath1",UrlChangeUtil.FormatCom(newspic, 600, 0));
				map.put("newsimgPath2",UrlChangeUtil.FormatCom(newspic, 290, 0));
				map.put("newsimgPath3",UrlChangeUtil.FormatCom(newspic, 0, 0));
				map.put("BigImgPath", MyConfig.pic_che_url+"carpic-"+map.get("id")+".htm");
				rslist.add(map);
			}
		}
		return rslist;
	}
	
	
	public List<Map<String, String>> carTypeImages(int carid){
		List<Map<String, String>> cartype = RedisDao.getImgTitleContentByCatalogid(carid);
		for(Map<String, String> map:cartype){
			map.put("title", map.get("title").replace("&nbsp", " "));
			map.put("path", map.get("path").replace("&nbsp", " "));
		}
		Collections.sort(cartype, new Comparator<Map<String, String>>(){
			public int compare(Map<String, String> a, Map<String, String> b){
				if((a.get("type").compareTo(b.get("type")))>0){
					return 1;
				}else if((a.get("type").compareTo(b.get("type")))<0){
					return -1;
				}else{
					if(Integer.parseInt(a.get("titleid"))<Integer.parseInt(b.get("titleid"))){
						return 1;
					}else if(Integer.parseInt(a.get("titleid"))>Integer.parseInt(b.get("titleid"))){
						return -1;
					}else{
						if(Integer.parseInt(a.get("sortid"))<Integer.parseInt(b.get("sortid"))){
							return 1;
						}else if(Integer.parseInt(a.get("sortid"))>Integer.parseInt(b.get("sortid"))){
							return -1;
						}else{
							return 0;
						}
					}
				}
			}
		});
		if (cartype.size() == 0) {
			return cartype;
		}
		int i = 1;
		for (Map<String, String> map : cartype) {
			map.put("showid", i+"");
			i++;
		}
		return cartype;
	}
	
	public List<HashMap<String, Object>> getImageNotInfo(String catalogid){
		List<HashMap<String, Object>> maplist = imageGetSubDao.getImageNotInfo(catalogid);
		for (HashMap<String, Object> map : maplist) {
			map.put("typeName",
					carImg.getEnum(Integer.parseInt(map.get("type").toString()))
							.getName());
			String pic = map.get("path").toString();
			if(pic.substring(0, 3).equals("315")){
				pic = UrlChangeUtil.FormatImg(pic, 150, 50);
				map.put("cturl","http://img.315che.com/");
			}else{
				//pic = pic.replace(".jpg", "_150x50.jpg").replace("ct1", MyConfig.www_ct_url);
				//map.put("cturl",MyConfig.www_ct_url);
			}
			map.put("newPath",pic);
		}
		return maplist;
	}
	
	public List<HashMap<String, Object>> getImageNotInfo(String catalogid,String titleKey){
		List<HashMap<String, Object>> maplist = imageGetSubDao.getImageNotInfo(catalogid,titleKey);
		for (HashMap<String, Object> map : maplist) {
			map.put("typeName",
					carImg.getEnum(Integer.parseInt(map.get("type").toString()))
							.getName());
			String pic = map.get("path").toString();
			if(pic.substring(0, 3).equals("315")){
				pic = UrlChangeUtil.FormatImg(pic, 150, 50);
				map.put("cturl","http://img.315che.com/");
			}else{
				//pic = pic.replace(".jpg", "_150x50.jpg").replace("ct1", MyConfig.www_ct_url);
				//map.put("cturl",MyConfig.www_ct_url);
			}
			map.put("newPath",pic);
		}
		return maplist;
	}

}
