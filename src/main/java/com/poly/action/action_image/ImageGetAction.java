package com.poly.action.action_image;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.poly.action.MyActionSupport;
import com.poly.service.ImageGetService;

public class ImageGetAction extends MyActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8928647045352887889L;
	private int imageType;

	public String imageInit(){
		return SUCCESS;
	}

	public void getImageInfo() throws IOException{
		String catalogid = URLDecoder.decode(request.getParameter("catalogid"), "utf-8");
		String titleKey = "";
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		if(request.getParameter("titleKey")!=null){
			titleKey = URLDecoder.decode(request.getParameter("titleKey"), "utf-8");
		}
		if(titleKey.equals("")){
			//list = ImageGetService.getInstance().getImageInfo(catalogid);
		}else{
			list = ImageGetService.getInstance().getImageInfo(catalogid,titleKey);
		}
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(list);
		out.print(json.toString());
	}
	
	public void getImageNotInfo() throws IOException{
		String catalogid = URLDecoder.decode(request.getParameter("catalogid"), "utf-8");
		String titleKey = "";
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		if(request.getParameter("titleKey")!=null){
			titleKey = URLDecoder.decode(request.getParameter("titleKey"), "utf-8");
		}
		if(titleKey.equals("")){
			list = ImageGetService.getInstance().getImageNotInfo(catalogid);
		}else{
			list = ImageGetService.getInstance().getImageNotInfo(catalogid,titleKey);
		}
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(list);
		out.print(json.toString());
	}

	public int getImageType() {
		return imageType;
	}

	public void setImageType(int imageType) {
		this.imageType = imageType;
	}

}
