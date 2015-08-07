package com.poly.action.action_statistics;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import car_beans.DboNewNews;
import car_daos.DboNewNewsDao;

import com.poly.service.AdminService;
import com.poly.service.StatisticsService;
import com.redis.Redis2Dao;

public class StatisticsData {

	// userid, addadmin, USER_CODE, USER_NAME, ORG_CODE, ORG_NAME
	private static List<Map<String, String>> editorList;

	private static List<String> sites;

	public static List<Map<String, String>> getEditorList() throws Exception {
		if (editorList == null)
			editorList = AdminService.getInstance().listEditor();
		return editorList;
	}

	public static List<String> getSites() throws Exception {
		if (sites == null) {
			sites = new ArrayList<String>();
			for (Map<String, String> map : getEditorList()) {
				String siteStr = map.get("ORG_NAME");
				if (!sites.contains(siteStr))
					sites.add(siteStr);
			}
		}
		return sites;
	}

	//public static Map<String, List<String[]>> csvMap;
	public static Map<String, List<Map<String,String>>> csvMap = new HashMap<String, List<Map<String,String>>>();
	
	//public static List<Map<String,String>> csvList;

	public static void main(String[] args) {
		String str = "http://inf.315che.com/n/2015_04/605822/";
		System.out.println(str.substring(32, str.lastIndexOf("/", 50)));
		// String userid = str.substring(str.indexOf("/", -1), endIndex)

	}

	public static void getCSVList(String csvPath) throws Exception {
		//List<String[]> list = new ArrayList();
		DataInputStream in = new DataInputStream(new FileInputStream(new File(csvPath)));
		BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(in, "GBK"));
		String stemp;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Map<String,String>> csvList = new ArrayList<Map<String,String>>();
		//获取行情信息
		/*DboNewCatalog catalog_hq = NewsAdmService.queryNewsCatalogById(43);
		List<DboNewCatalog> allNewsCatalogList_hq = new ArrayList<DboNewCatalog>();
		NewsAdmService.getNewCatalogByFatherid(allNewsCatalogList_hq, catalog_hq);*/
		//行情目录
		List<Integer> hqList = StatisticsService.getNewsMarketCatalogList();
		//新车目录
		List<Integer> newCarList = StatisticsService.getNewsCatalogList("135");
		//新闻目录
		List<Integer> newNewsList = StatisticsService.getNewsCatalogList("50");
		
		/*for(DboNewCatalog dbo : allNewsCatalogList_hq){
			hqList.add(dbo.getCatalogid());
		}*/
		
		while ((stemp = bufferedreader.readLine()) != null) {
			// System.out.println(stemp);
			// http://inf.315che.com/n/2015_04/605822/,6,6,6,1,6,28.67秒,,,,,,,
			if(stemp.length()>7){
				if (stemp.substring(0, 7).equals("http://")) {
					String[] arr = stemp.split(",");
					if (arr.length == 7) {
						Map<String,String> map = new HashMap<String, String>();
						//String[] record = new String[7];
						String url = arr[0];
						//System.out.println(url);
						//新闻链接
						map.put("url",url);
						//浏览次数
						map.put("count",arr[1]);
						//独立访客	
						map.put("peopleCount",arr[2]);
						//IP
						map.put("ipCount",arr[3]);
						//人均浏览页数
						map.put("perCount",arr[4]);
						//输出PV
						map.put("pvCount",arr[5]);
						//平均页面停留时间
						map.put("time",arr[6]);
						
						String newsid = stemp.substring(32, url.lastIndexOf("/", 50));
						//System.out.println(newsid);
						
						//String count = arr[1];
						//System.out.println(count);
						//Map<String, String> newsMap = new HashMap<String, String>();
						Map<String, String> newsMap = (Map<String, String>)Redis2Dao.getObjectByKey("dbo_new_related:id:"+newsid);
						boolean flag = true;
						if(newsMap.isEmpty()){
							DboNewNews dboNews = DboNewNewsDao.where("id = "+newsid).get(0);
							if(dboNews.getAddadmin()!=null&&dboNews.getAddadmin().length()>0){
								map.put("addadmin",dboNews.getAddadmin());
								map.put("newstitle",dboNews.getNewstitle());
								map.put("newsid",newsid);
								map.put("adddate",sdf.format(dboNews.getAdddate()));
								map.put("isoriginal",String.valueOf(dboNews.getIsoriginal()));
								/*if(csvMap.containsKey(dboNews.getAddadmin())){
									List<Map<String,String>> objList = csvMap.get(dboNews.getAddadmin());
									objList.add(map);
									csvMap.put(dboNews.getAddadmin(), objList);
								}else{
									List<Map<String,String>> list = new ArrayList<Map<String,String>>();
									list.add(map);
									csvMap.put(dboNews.getAddadmin(), list);
								}*/
								if(dboNews.getIsoriginal()==1){
									map.put("newsType","原创新闻");
								}else if(hqList.contains(dboNews.getNewscatalogid())){
									map.put("newsType","行情");
								}else if(newCarList.contains(dboNews.getNewscatalogid())){
									map.put("newsType","新车");
								}else if(newNewsList.contains(dboNews.getNewscatalogid())){
									map.put("newsType","新闻");
								}else{
									map.put("newsType","软文");
								}
								flag = true;
							}else{
								flag = false;
							}
						}else{
							if(newsMap.get("addadmin")!=null&&"".equals(newsMap.get("addadmin"))){
								map.put("addadmin",newsMap.get("addadmin"));
								map.put("newstitle",newsMap.get("newstitle"));
								map.put("newsid",newsMap.get("newsid"));
								map.put("adddate",newsMap.get("adddate"));
								map.put("isoriginal",newsMap.get("isoriginal"));
								/*if(csvMap.containsKey(newsMap.get("addadmin"))){
									List<Map<String,String>> objList = csvMap.get(newsMap.get("addadmin"));
									objList.add(map);
									csvMap.put(newsMap.get("addadmin"), objList);
								}else{
									List<Map<String,String>> list = new ArrayList<Map<String,String>>();
									list.add(map);
									csvMap.put(newsMap.get("addadmin"), list);
								}*/
								if(Integer.valueOf(newsMap.get("isoriginal"))==1){
									map.put("newsType","原创新闻");
								}else if(hqList.contains(newsMap.get("newscatalogid"))){
									map.put("newsType","行情");
								}else if(newCarList.contains(newsMap.get("newscatalogid"))){
									map.put("newsType","新车");
								}else if(newNewsList.contains(newsMap.get("newscatalogid"))){
									map.put("newsType","新闻");
								}else{
									map.put("newsType","软文");
								}
								flag = true;
							}else{
								flag = false;
							}
						}
						if(flag){
							csvList.add(map);
						}
						//record[0] = url;
					}
	
				}
			}
		}
		csvMap.put(csvPath,dealWithNewsList(csvList));
		bufferedreader.close();
		in.close();
	}

	//将一篇文章多页的数据统一到一页上
	private static List<Map<String,String>> dealWithNewsList(List<Map<String,String>> objList){
		Map<String,Map<String,String>> newsmap = new LinkedHashMap<String, Map<String,String>>();
		for(Map<String,String> map : objList){
			if(newsmap.containsKey(map.get("newsid"))){
				map.put("count",String.valueOf(Integer.valueOf(map.get("count"))+Integer.valueOf(newsmap.get(map.get("newsid")).get("count"))));
				map.put("peopleCount",String.valueOf(Integer.valueOf(map.get("peopleCount"))+Integer.valueOf(newsmap.get(map.get("newsid")).get("peopleCount"))));
				map.put("ipCount",String.valueOf(Integer.valueOf(map.get("ipCount"))+Integer.valueOf(newsmap.get(map.get("newsid")).get("ipCount"))));
				map.put("pvCount",String.valueOf(Integer.valueOf(map.get("pvCount"))+Integer.valueOf(newsmap.get(map.get("newsid")).get("pvCount"))));
				newsmap.put(map.get("newsid"),map);
			}else{
				newsmap.put(map.get("newsid"),map);
			}
		}
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		for(String key : newsmap.keySet()){
			list.add(newsmap.get(key));
		}
		return list;
	}
	
}
