package com.poly.action.action_tree;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import car_beans.TbSubSites;

import com.poly.action.MyActionSupport;
import com.poly.bean.TreeEntity;
import com.poly.bean.TreeEntity2;
import com.poly.service.TreeService;
import com.redis.RedisParseUtil;

public class Tree extends MyActionSupport{
	public enum TreeInfo{
		
		NewsTree("新闻目录",0,"dbo_new_catalog"),
		CarImgTree("车型图库目录",1,"dbo_img_catalog"),
		NoCarImgTree("非车型图库目录",2,"dbo_img_newcatalog"),
		CarTree("车型目录",3,"dbo_car_catalognew"),
		AreaTree("城市目录",4,"dbo_are_catalog");
		
		private String name;
		
		private int id;
		
		private String dbName;
		
		TreeInfo(String name ,int id,String dbName){
			this.name =name;
			this.id =id;
			this.dbName = dbName;
		}
		
		TreeInfo(String name ){
			this.name =name;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}
		
		public String getDbName() {
			return dbName;
		}
		
		public static TreeInfo getEnum(final String name){
			for(TreeInfo ti:TreeInfo.values()){
				if(ti.getName().equals(name)){
					return ti;
				}
			}
			return null;
		}
		
	}
	
	List<TbSubSites> newssitelist ;
	
	
	public List<TbSubSites> getNewssitelist() {
		return newssitelist;
	}

	public void setNewssitelist(List<TbSubSites> newssitelist) {
		this.newssitelist = newssitelist;
	}

	public String execute(){
		//newssitelist = TreeService.getInstance().getSubSite();
		return SUCCESS;
	}
	
	
	public void initTree() throws IOException {
		String treeName = URLDecoder.decode(request.getParameter("treeName"), "utf-8");
		int treeId = TreeInfo.getEnum(treeName).getId();
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		List<TreeEntity> list = TreeService.getInstance().getNewsTreeInfo(treeId);
		JSONArray json = JSONArray.fromObject(list);
		session.put(treeName, json.toString());
		out.print(json.toString());
	}
	
	
	public void initCustomerTree() throws IOException{
		String treeName = URLDecoder.decode(request.getParameter("treeName"), "utf-8");
		int treeId = TreeInfo.getEnum(treeName).getId();
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		if(session.get(treeName)==null){
			List<TreeEntity> list = TreeService.getInstance().getNewsTreeInfo(treeId);
			JSONArray json = JSONArray.fromObject(list);
			session.put(treeName, json.toString());
			out.print(json.toString());
		}else{
			out.print(session.get(treeName).toString());
		}
	}
	public void initCustomerTree2() throws IOException{
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		List<TreeEntity> list = TreeService.getInstance().getNewsTreeInfo();
		JSONArray json = JSONArray.fromObject(list);
		out.print(json.toString());
	}
	public void addTreeNodes() throws IOException{
		String treeName = URLDecoder.decode(request.getParameter("treeName"), "utf-8");
		int treeId = TreeInfo.getEnum(treeName).getId();
		int fatherId = Integer.parseInt(request.getParameter("fatherId"));
		String addName = URLDecoder.decode(request.getParameter("addName"), "utf-8");
		int id = TreeService.getInstance().addNewsTree(treeId,fatherId,addName);
		RedisParseUtil.jedisPublish("insert", TreeInfo.getEnum(treeName).getDbName(), id+"");
		response.setContentType("text/html;charset=gbk");
		List<TreeEntity> list = TreeService.getInstance().getNewsTreeInfo(treeId);
		JSONArray json1 = JSONArray.fromObject(list);
		session.put(treeName, json1.toString());
		PrintWriter out = response.getWriter();
		TreeEntity data = new TreeEntity();
		data.setId(id);
		data.setpId(fatherId);
		data.setName(addName);
		JSONObject json = JSONObject.fromObject(data);
		out.print(json.toString());
	}
	
	public void deleteTreeNodes() throws IOException{
		String treeName = URLDecoder.decode(request.getParameter("treeName"), "utf-8");
		int treeId = TreeInfo.getEnum(treeName).getId();
		int id = Integer.parseInt(request.getParameter("id"));
		int result = TreeService.getInstance().deleteNewsTree(treeId,id);
		RedisParseUtil.jedisPublish("delete", TreeInfo.getEnum(treeName).getDbName(), id+"");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		List<TreeEntity> list = TreeService.getInstance().getNewsTreeInfo(treeId);
		JSONArray json = JSONArray.fromObject(list);
		session.put(treeName, json.toString());
		out.print(result);
	}
	
	public void editTreeName() throws IOException{
		String treeName = URLDecoder.decode(request.getParameter("treeName"), "utf-8");
		int treeId = TreeInfo.getEnum(treeName).getId();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = URLDecoder.decode(request.getParameter("updateName"), "utf-8");;
		int result = TreeService.getInstance().editNewsTreeName(treeId,id, name);
		RedisParseUtil.jedisPublish("update", TreeInfo.getEnum(treeName).getDbName(), id+"");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		List<TreeEntity> list = TreeService.getInstance().getNewsTreeInfo(treeId);
		JSONArray json = JSONArray.fromObject(list);
		session.put(treeName, json.toString());
		out.print(result);
	}
	
	
	public void setSite() throws IOException{
		String siteid = URLDecoder.decode(request.getParameter("newssite"), "utf-8");
		String treeName = URLDecoder.decode(request.getParameter("treeName"), "utf-8");
		int treeId = TreeInfo.getEnum(treeName).getId();
		int id = Integer.parseInt(request.getParameter("id"));
		//String name = URLDecoder.decode(request.getParameter("updateName"), "utf-8");;
		//int result = TreeService.getInstance().editNewsTreeName(treeId,id, name);
		int result = TreeService.getInstance().updateNewsSite(id, siteid);
		RedisParseUtil.jedisPublish("update", TreeInfo.getEnum(treeName).getDbName(), id+"");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		List<TreeEntity> list = TreeService.getInstance().getNewsTreeInfo(treeId);
		JSONArray json = JSONArray.fromObject(list);
		session.put(treeName, json.toString());
		out.print(result);
	}
	
	
	public void searchsite() throws IOException{
		String id = request.getParameter("id");
		int siteid = TreeService.getInstance().searchsite(id);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		//JSONArray json = JSONArray.fromObject(list);
		out.print(siteid);
	}
	
	public void initULevelTree() throws IOException{
		List<TreeEntity> list = TreeService.getInstance().getULevelTree();
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(list);
		out.print(json.toString());
	}
}
