package com.poly.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.opensymphony.xwork2.inject.util.Function;

import car_beans.DboAdmFunction;
import car_beans.TbUlevelDetail;
import car_daos.DboAdmFunctionDao;
import car_daos.TbUlevelDetailDao;

public class LeftMenuService {
	public static final int dms_father_id = 46;
	public static final LeftMenuService instance = new LeftMenuService();

	public static LeftMenuService getInstance() {
		return instance;
	}
	DboAdmFunctionDao dboAdmFunctionDao = new DboAdmFunctionDao();
	TbUlevelDetailDao tbUlevelDetailDao = new TbUlevelDetailDao();
	public List<Object> getLeftMenu(String detail,String type){
		/*String levels = getLevelDetail(ulevels);
		String lDetails = "";
		List<TbUlevelDetail> levelDetails = tbUlevelDetailDao.where("level in("+levels+")");
		for (TbUlevelDetail tbUlevelDetail : levelDetails) {
			lDetails +=tbUlevelDetail.getFunctionid()+",";
		}
		lDetails = lDetails.substring(0,lDetails.length()-1);*/
		
		if(detail==null)
			detail = "";
		//System.err.println(lDetails);
		List<Object> objects = new ArrayList<Object>();
		List<String> keys = new ArrayList<String>();
		Map<String, Object> map = new TreeMap<String, Object>();
		List<DboAdmFunction> totalList = dboAdmFunctionDao.where(" isdelete = 0 and id in("+detail+")");
		//List<DboAdmFunction> rootList = dboAdmFunctionDao.where("fatherid=0 and isdelete = 0 and id in("+lDetails+")");
		List<DboAdmFunction> rootList = null;
		List<Integer>filter = new ArrayList<Integer>();
		if("dms".equals(type)){
			filter.add(dms_father_id);
			rootList = getChildMenuWithFilter(totalList,0,filter);
		}else if("315che".equals(type)){
			filter.clear();
			filter.add(dms_father_id);
			rootList = getChildMenuWithOutFilter(totalList,0,filter);
		}
		for (DboAdmFunction root : rootList) {
			List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
			//List<DboAdmFunction> level2List = dboAdmFunctionDao.where("isdelete = 0 and fatherid="+root.getId()+" and id in("+lDetails+")");
			List<DboAdmFunction> level2List = getChildMenu(totalList,root.getId());
			Map<String, Object> map2 = null;
			for (DboAdmFunction level2 : level2List) {
				map2 = new TreeMap<String, Object>();
				map2.put("name", level2.getName());
				map2.put("action", level2.getAction());
				String flag  = "0";
				Map<String, Object> map3 = null;
				//List<DboAdmFunction> level3List = dboAdmFunctionDao.where("isdelete = 0 and fatherid="+level2.getId()+" and id in("+lDetails+")");
				List<DboAdmFunction> level3List = getChildMenu(totalList,level2.getId());
				List<Map<String, Object>> list2 = new ArrayList<Map<String,Object>>();
				for (DboAdmFunction level3 : level3List) {
					map3 = new HashMap<String, Object>();
					map3.put("name", level3.getName());
					map3.put("action", level3.getAction());
					map3.put("flag", "0");
					flag = "1";
					list2.add(map3);
				}
				map2.put("data", list2);
				map2.put("flag", flag);
				list.add(map2);
			}
			//System.err.println(root.getName());
			//System.err.println(list.size());
			map.put(root.getName(), list);
			keys.add(root.getName());
		}
		objects.add(keys);
		objects.add(map);
		return objects;
	}
	
	public List<Object> getAllLeftMenu(){
		List<Object> objects = new ArrayList<Object>();
		List<String> keys = new ArrayList<String>();
		Map<String, Object> map = new TreeMap<String, Object>();
		List<DboAdmFunction> totalList = dboAdmFunctionDao.where(" isdelete = 0");
		List<DboAdmFunction> rootList = getChildMenu(totalList,0);
		for (DboAdmFunction root : rootList) {
			List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
			List<DboAdmFunction> level2List = getChildMenu(totalList,root.getId());
			Map<String, Object> map2 = null;
			for (DboAdmFunction level2 : level2List) {
				map2 = new TreeMap<String, Object>();
				map2.put("name", level2.getName());
				map2.put("id", level2.getId());
				map2.put("action", level2.getAction());
				String flag  = "0";
				Map<String, Object> map3 = null;
				List<DboAdmFunction> level3List = getChildMenu(totalList,level2.getId());
				List<Map<String, Object>> list2 = new ArrayList<Map<String,Object>>();
				for (DboAdmFunction level3 : level3List) {
					map3 = new HashMap<String, Object>();
					map3.put("id", level3.getId());
					map3.put("name", level3.getName());
					map3.put("action", level3.getAction());
					map3.put("flag", "0");
					flag = "1";
					list2.add(map3);
				}
				map2.put("data", list2);
				map2.put("flag", flag);
				list.add(map2);
			}
			map.put(root.getName(), list);
			keys.add(root.getName());
		}
		objects.add(keys);
		objects.add(map);
		return objects;
	}
	
	
	//List<DboAdmFunction> rootList = dboAdmFunctionDao.where("fatherid=0 and isdelete = 0 and id in("+lDetails+")");
	List<DboAdmFunction> getChildMenu(List<DboAdmFunction> rootList,int fatherid){
		List<DboAdmFunction> resultList = new ArrayList<DboAdmFunction>();
		for (DboAdmFunction dboAdmFunction : rootList) {
			if(fatherid == dboAdmFunction.getFatherid())
				resultList.add(dboAdmFunction);
		}
		
		
		return resultList;
	}
	List<DboAdmFunction> getChildMenuWithFilter(List<DboAdmFunction> rootList,int fatherid,List<Integer> list){
		List<DboAdmFunction> resultList = new ArrayList<DboAdmFunction>();
		for (DboAdmFunction dboAdmFunction : rootList) {
			if(fatherid == dboAdmFunction.getFatherid()){
				for(Integer id:list){
					if(id==dboAdmFunction.getId()){
						resultList.add(dboAdmFunction);
						break;
					}
				}
			}
		}
		
		
		return resultList;
	}
	List<DboAdmFunction> getChildMenuWithOutFilter(List<DboAdmFunction> rootList,int fatherid,List<Integer> list){
		List<DboAdmFunction> resultList = new ArrayList<DboAdmFunction>();
		d:for (DboAdmFunction dboAdmFunction : rootList) {
			if(fatherid == dboAdmFunction.getFatherid()){
				for(Integer id:list){
					if(id==dboAdmFunction.getId()){
						continue d;
					}
				}
				resultList.add(dboAdmFunction);
			}
		}
		
		
		return resultList;
	}
	public String getLevelDetail(String levels){
		String detail = "";
		if(!"".equals(levels)){
		String[] brandsx = levels.split(",");
		for (int i = 0;i<brandsx.length;i++) {
			if(i == brandsx.length-1)
				detail +="'"+brandsx[i]+"'";
			else
				detail +="'"+brandsx[i]+"',";
		}
		}
		return detail;
	}

}
