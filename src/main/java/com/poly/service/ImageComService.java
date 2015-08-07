package com.poly.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.redis.RedisDao;

public class ImageComService {

	public static final ImageComService instance = new ImageComService();

	public static ImageComService getInstance() {
		return instance;
	}

	public Map<String,String> imageNum(int carid){
		Map<String,String> map = RedisDao.getCarsNum(carid);
		return map;
	}
	
	public Map<String, List<Map<String, String>>> carTypeImages(int carid){
		List<Map<String, String>> cartype = RedisDao.getImgTitleContentByCatalogid(carid);
		for(Map<String, String> map:cartype){
			map.put("title", map.get("title").replace("&nbsp", " "));
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
		
		Map<String, List<Map<String, String>>> rsMap = new TreeMap<String, List<Map<String, String>>>();
		if (cartype.size() == 0) {
			return rsMap;
		}
		List<Map<String, String>> newlist = new ArrayList<Map<String, String>>();
		String type = cartype.get(0).get("type").toString();
		for (Map<String, String> map : cartype) {
			if (!type.equals(map.get("type").toString())) {
				rsMap.put(type, newlist);
				newlist = new ArrayList<Map<String, String>>();
				type = map.get("type").toString();
			}
			newlist.add(map);
		}
		rsMap.put(type, newlist);
		return rsMap;
	}
	
	//车型车系获取图片
	public List<String> typespic(String carid,String type,int num){
		List<String> result = new ArrayList<String>();
		Map<String,String> carinfo = RedisDao.getCatalognewById(Integer.parseInt(carid));
		String sid = "";
		if(carinfo.get("pathlevel").equals("3")){
			sid = carinfo.get("fatherid");
		}else{
			sid = carinfo.get("catalogid");
		}
		Map<String,String> imgnummap = ImageComService.getInstance().imageNum(Integer.parseInt(sid));
		loop:for(String key:imgnummap.keySet()){
			if(imgnummap.get(key)!=null){
				Map<String, List<Map<String, String>>> imgmap = carTypeImages(Integer.parseInt(key));
				if(imgmap.get(type)!=null){
					List<Map<String, String>> list = imgmap.get(type);
					if(list.size() > num){
						for(int i = 0;i< num;i++){
							result.add(list.get(i).get("path"));
						}
						break loop;
					}else{
						for(Map<String, String> map:list){
							result.add(map.get("path"));
						}
						num = num - list.size();
					}
				}
			}
		}
		return result;
	}

}
