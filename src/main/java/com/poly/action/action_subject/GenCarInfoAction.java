package com.poly.action.action_subject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.poly.action.MyActionSupport;
import com.redis.RedisDao;

public class GenCarInfoAction extends MyActionSupport {
	
	//品牌List
	private List<Map<String,String>> brandList;
	//车系List
	private List<Map<String,List<Object>>> carList;
	//品牌ID
	private int brandid;
	
	//品牌接口
	public void genBrandJson(){
		response.setContentType("text/html;charset=utf-8");
		//保留在售，在产的品牌
		brandList = dealwithBrandList(RedisDao.getcatalogMapByPatheLevel(1));
		Collections.sort(brandList,new Comparator<Map<String,String>>() {
			@Override
			public int compare(Map<String, String> o1, Map<String, String> o2) {
				// TODO Auto-generated method stub
				if(o1.get("lname").compareTo(o2.get("lname"))>0){
					return 1;
				}
				return -1;
			}
		});
		try {
			JSONArray json = JSONArray.fromObject(brandList);
			PrintWriter out = response.getWriter();
			String jsonp = request.getParameter("jsonpcallback");
			out.print(jsonp+"("+json.toString()+")");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//车系接口
	public void genCarJson(){
		response.setContentType("text/html;charset=utf-8");
		carList = RedisDao.getCarListByBrand(brandid);
		try {
			JSONArray json = JSONArray.fromObject(carList);
			PrintWriter out = response.getWriter();
			String jsonp = request.getParameter("jsonpcallback");
			out.print(jsonp+"("+json.toString()+")");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//车型接口
	private List<Map<String,String>> dealwithBrandList(List<Map<String,String>> list){
		for(int i=0;i<list.size();i++){
			Map<String,String> map = list.get(i);
			if(!"1".endsWith(map.get("islive"))&&!"1".endsWith(map.get("onsale"))){
				list.remove(i);
			}
		}
		return list; 
	}

	public int getBrandid() {
		return brandid;
	}

	public void setBrandid(int brandid) {
		this.brandid = brandid;
	}

}
