package com.poly.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

import car_beans.TbSubSites;
import car_beans.TbUsers;
import car_daos.TbSubSitesDao;

import com.poly.bean.TreeEntity;
import com.poly.bean.TreeEntity2;
import com.poly.bean.newNews;
import com.poly.dao.subDaos.DboAreCatalogSubDao;
import com.poly.dao.subDaos.DboCarCatalognewSubDao;
import com.poly.dao.subDaos.DboImgCatalogSubDao;
import com.poly.dao.subDaos.DboImgNewcatalogSubDao;
import com.poly.dao.subDaos.DboNewCatalogSubDao;
import com.poly.dao.subDaos.TbUserSubDao;
import com.poly.util.GetPy;
import com.redis.RedisDao;

public class TreeService {
	
	public static final TreeService instance = new TreeService();
	public static Map<String,String> carnuminfo;
	
	public static TreeService getInstance() {
		return instance;
	}
	DboNewCatalogSubDao dboNewCataSubDao = new DboNewCatalogSubDao();
	
	DboImgCatalogSubDao dboImgCatalogSubDao = new DboImgCatalogSubDao();
	
	DboImgNewcatalogSubDao dboImgNewcatalogSubDao = new DboImgNewcatalogSubDao();
	
	DboCarCatalognewSubDao dboCarCatalognewSubDao = new DboCarCatalognewSubDao();
	
	DboAreCatalogSubDao dboAreCatalogSubDao = new DboAreCatalogSubDao();
	
	public List<TbSubSites> getSubSite(){
		return TbSubSitesDao.find();
	}
	
	
	public List<TreeEntity> getNewsTreeInfo(int treeId){
		List<TreeEntity> treelist = new ArrayList<TreeEntity>();
		if(treeId == 0){
			treelist = dboNewCataSubDao.getNewsTreeInfo();
		}
		
		if(treeId == 1){
			treelist = dboImgCatalogSubDao.getImgTreeInfo();
		}
		
		if(treeId == 2){
			treelist = dboImgNewcatalogSubDao.getImgNewTreeInfo();
		}
		
		if(treeId == 3){
			treelist = dboCarCatalognewSubDao.getCarNewTreeInfo();
			for(TreeEntity tree:treelist){
				if(tree.getpId()==0){
					tree.setName(tree.getLname()+" "+tree.getName());
				}
			}
		}
		
		if(treeId == 4){
			treelist = dboAreCatalogSubDao.getAreTreeInfo();
			for(TreeEntity tree:treelist){
				if(tree.getpId()==0){
					tree.setName(tree.getLname()+" "+tree.getName());
				}
			}
		}
		return treelist;
	}
	
	/**2015-4-13
	 * dingyifan
	 * 新闻页面编辑模块 图库弹出框左侧品牌车系树更改为只加载有品牌或车系图片的树
	 * @return 品牌车系树
	 */
	public List<TreeEntity> getNewsTreeInfo(){
		List<TreeEntity> treelist = new ArrayList<TreeEntity>();
		treelist = dboCarCatalognewSubDao.getCarNewTreeInfo2();
		List<TreeEntity> treelist2 = new ArrayList<TreeEntity>();
		for(TreeEntity tree:treelist){
			String cnum = carnuminfo.get(String.valueOf(tree.getId()));
			if(cnum==null){ //|| ("0").equals(pnum)) & (!("1").equals(tree.getPathlevel())) & !("2").equals(tree.getPathlevel())
				continue;
			}
			
			if(tree.getpId()==0){
				tree.setName(tree.getLname()+" "+tree.getName());
			}
			
			treelist2.add(tree);
		}
		return treelist2;
	}
	
	//设置定时器
    public static void paiqitimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
            	try {
            		TreeService.generateCatalogTree();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }, 0,1000*60*10);//每小时
    }
	
	public static void generateCatalogTree(){
		Map<String,List<Map<String, String>>> treeAllBrand = new HashMap<String,List<Map<String, String>>>();
		Map<String,String> carnuminfoMethod = new HashMap<String,String>();
		Map<String,List<Map<String, String>>> treeAllCar = new HashMap<String,List<Map<String, String>>>();
		carnuminfoMethod.putAll(RedisDao.getCarsNum(0));
		treeAllBrand = brandTree();
		//遍历品牌树
		for(String brandkey:treeAllBrand.keySet()){
			for(Map<String,String> brandvalue:treeAllBrand.get(brandkey)){
				carnuminfoMethod.putAll(RedisDao.getCarsNum(Integer.parseInt(brandvalue.get("catalogid"))));
				
				treeAllCar=serialTree(Integer.parseInt(brandvalue.get("catalogid")));
				
				for(String carkey:treeAllCar.keySet()){
					for(Map<String,String> carvalue:treeAllCar.get(carkey)){
						carnuminfoMethod.putAll(RedisDao.getCarsNum(Integer.parseInt(carvalue.get("catalogid"))));
					}
				}
			}
		}
		carnuminfo=carnuminfoMethod;
	}
	//车系树（按渠道）
	public static Map<String,List<Map<String, String>>> serialTree(int catalogid){
		List<Map<String, String>> serialTree = RedisDao.getCatalognewByFatherId(catalogid);
		Collections.sort(serialTree, new Comparator<Map<String, String>>(){
			public int compare(Map<String, String> a, Map<String, String> b){
				if((a.get("lname").toString()).compareTo(b.get("lname").toString())>0){
					return 1;
				}else if((a.get("lname").toString()).compareTo(b.get("lname").toString())<0){
					return -1;
				}else{
					/*if((a.get("catalogname").toString()).compareTo(b.get("catalogname").toString())>0){
						return 1;
					}else if((a.get("catalogname").toString()).compareTo(b.get("catalogname").toString())<0){
						return -1;
					}else{
						
					}*/
					
					if((a.get("jibie").toString()).compareTo(b.get("jibie").toString())>0){
						return 1;
					}else if((a.get("jibie").toString()).compareTo(b.get("jibie").toString())<0){
						return -1;
					}else{
						return 0;
					}
				}
			}
		});
		List<String> waylist = new ArrayList<String>();//渠道列表
		String iway = "";
		for(Map<String, String> map :serialTree){
			if(!waylist.contains(map.get("iway"))){
				iway = map.get("iway");
				//System.out.println(iway);
				if(!iway.equals("NULL")){
					waylist.add(iway);
				}
			}
		}
		// 将车系内容按渠道分组
		Map<String,List<Map<String, String>>> result = new TreeMap<String,List<Map<String, String>>>();
		List<Map<String, String>> newlist = new ArrayList<Map<String, String>>();
		for(String key:waylist){
			for(Map<String, String> map :serialTree){
				if(key.equals(map.get("iway"))){
					newlist.add(map);
				}
			}
			result.put(key, newlist);
			newlist = new ArrayList<Map<String, String>>();
		}
		
		return result;
	} 
	//品牌树
	public static Map<String,List<Map<String, String>>> brandTree(){
		List<Map<String, String>> brandTree = RedisDao.getCatalognewByFatherId(0);
		Collections.sort(brandTree, new Comparator<Map<String, String>>(){
			public int compare(Map<String, String> a, Map<String, String> b){
				if((a.get("lname").toString()).compareTo(b.get("lname").toString())>0){
					return 1;
				}else if((a.get("lname").toString()).compareTo(b.get("lname").toString())<0){
					return -1;
				}else{
					if((a.get("catalogname").toString()).compareTo(b.get("catalogname").toString())>0){
						return 1;
					}else if((a.get("catalogname").toString()).compareTo(b.get("catalogname").toString())<0){
						return -1;
					}else{
						return 0;
					}
				}
			}
		});
		List<String> lnamelist = new ArrayList<String>();//字母列表
		String lname = "";
		for(Map<String, String> map :brandTree){
			if(!lnamelist.contains(map.get("lname"))){
				lname = map.get("lname");
				//System.out.println(lname);
				lnamelist.add(lname);
			}
		}
		Map<String,List<Map<String, String>>> result = new TreeMap<String,List<Map<String, String>>>();
		List<Map<String, String>> newlist = new ArrayList<Map<String, String>>();
		for(String key:lnamelist){
			for(Map<String, String> map :brandTree){
				if(key.equals(map.get("lname"))){
					newlist.add(map);
				}
			}
			result.put(key, newlist);
			newlist = new ArrayList<Map<String, String>>();
		}
		return result;
	}
	//车型按年款和排量
		public Map<String,List<Map<String, String>>> carTypeTree(int catalogid){
			List<Map<String, String>> serialTree = RedisDao.getCatalognewByFatherId(catalogid);
			Collections.sort(serialTree, new Comparator<Map<String, String>>(){
				public int compare(Map<String, String> a, Map<String, String> b){
					if((a.get("iyear").toString()).compareTo(b.get("iyear").toString())>0){
						return -1;
					}else if((a.get("iyear").toString()).compareTo(b.get("iyear").toString())<0){
						return 1;
					}else{
						if((a.get("pailiang").toString()).compareTo(b.get("pailiang").toString())>0){
							return 1;
						}else if((a.get("pailiang").toString()).compareTo(b.get("pailiang").toString())<0){
							return -1;
						}else{
							return 0;
						}
					}
				}
			});
			List<String> yearlist = new ArrayList<String>();//年款列表
			String iyear = "";
			for(Map<String, String> map :serialTree){
				if(!yearlist.contains(map.get("iyear"))){
					iyear = map.get("iyear");
					//System.out.println(iyear);
					yearlist.add(iyear);
				}
			}
			TreeMap<String,List<Map<String, String>>> result = new TreeMap<String,List<Map<String, String>>>();
			List<Map<String, String>> newlist = new ArrayList<Map<String, String>>();
			for(String key:yearlist){
				for(Map<String, String> map :serialTree){
					if(key.equals(map.get("iyear"))){
						newlist.add(map);
					}
				}
				result.put(key, newlist);
				newlist = new ArrayList<Map<String, String>>();
			}
			
			return result;
		} 
	public int addNewsTree(int treeId,int fatherId,String name) throws UnsupportedEncodingException{
		String lname = GetPy.getGBKpy(name).toUpperCase().substring(0,1);
		int id = 0;
		
		if(treeId == 0){
			id = dboNewCataSubDao.addNewsTree(fatherId, name, lname);
		}
		
		if(treeId == 1){
			id = dboImgCatalogSubDao.addImgTree(fatherId, name, lname);
		}
		
		if(treeId == 2){
			id = dboImgNewcatalogSubDao.addImgNewTree(fatherId, name, lname);
		}
		
		if(treeId == 3){
			id = dboCarCatalognewSubDao.addCarNewTree(fatherId, name, lname);
			CarQuestionService.getInstance().addCarQuestion(id);
		}
		
		if(treeId == 4){
			id = dboAreCatalogSubDao.addAreTree(fatherId, name, lname);
		}
		return id;
	}
	
	public int deleteNewsTree(int treeId,int id){
		int rsid = -1;
		
		if(treeId == 0){
			rsid = dboNewCataSubDao.deleteNewsTree(id);
		}
		
		if(treeId == 1){
			rsid = dboImgCatalogSubDao.deleteImgTree(id);
		}
		
		if(treeId == 2){
			id = dboImgNewcatalogSubDao.deleteImgNewTree(id);
		}

		if(treeId == 3){
			id = dboCarCatalognewSubDao.deleteCarNewTree(id);
		}
		
		if(treeId == 4){
			id = dboAreCatalogSubDao.deleteAreTree(id);
		}
		return rsid;
	}
	
	public int editNewsTreeName(int treeId,int id,String name){
		int rsid = -1;
		
		if(treeId == 0){
			rsid = dboNewCataSubDao.editNewsTreeName(id, name);
		}
		
		if(treeId == 1){
			rsid = dboImgCatalogSubDao.editImgTreeName(id, name);
		}
		
		if(treeId == 2){
			rsid = dboImgNewcatalogSubDao.editImgNewTreeName(id, name);
		}
		
		if(treeId == 3){
			rsid = dboCarCatalognewSubDao.editCarNewTreeName(id, name);
		}
		
		if(treeId == 4){
			rsid = dboAreCatalogSubDao.editAreTreeName(id, name);
		}
		return rsid;
	}
	
	
	public int updateNewsSite(int id,String siteid){
		return dboNewCataSubDao.updateNewsSite(id, siteid);
	}
	
	public int searchsite(String id){
		return dboNewCataSubDao.searchsite(id);
	}
	TbUserSubDao tbUserSubDao = new TbUserSubDao();
	public List<TreeEntity> getULevelTree(){
		return tbUserSubDao.getULevelTree();
	}
	
	public List<TreeEntity2> getCusULevelTree(String id){
		String detail = tbUserSubDao.where("id = "+id).get(0).getDetail();
		if(detail == null)
			detail = "";
		List<TreeEntity2> resultList = new ArrayList<TreeEntity2>();
		List<TreeEntity> list =  tbUserSubDao.getULevelTree();
		TreeEntity2 entity2 = null;
		for (TreeEntity treeEntity : list) {
			entity2 = new TreeEntity2();
			entity2.setChecked(true);
			entity2.setId(treeEntity.getId());
			entity2.setName(treeEntity.getName());
			entity2.setpId(treeEntity.getpId());
			boolean checked = checkDetail(detail,treeEntity.getId()+"");
			
			entity2.setChecked(checked);
			resultList.add(entity2);
		}
		return resultList;
	}
	
	boolean checkDetail(String detail,String id){
		boolean flag = false;
		String[] array = detail.split(",");
		for (String str : array) {
			if(!"".equals(str)){
				if(id.equals(str)){
					flag = true;
					break;
				}
					
			}
		}
		return flag;
	}
	
}
