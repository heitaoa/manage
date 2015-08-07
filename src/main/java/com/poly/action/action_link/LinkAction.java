package com.poly.action.action_link;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import sun.management.counter.Variability;
import car_beans.TbLinks;

import com.poly.action.MyActionSupport;
import com.poly.service.LinksService;
import com.poly.util.MakeLinkUtil;

public class LinkAction extends MyActionSupport{
	private List<TbLinks> linkList;
	public String linksManage(){
		linkList = LinksService.getInstance().listAllLinks();
		return SUCCESS;
	}
	public void linksSave() throws Exception{
		String  title = URLDecoder.decode(request.getParameter("title"), "utf-8");
		String  link = URLDecoder.decode(request.getParameter("link"), "utf-8");
		String  place = URLDecoder.decode(request.getParameter("place"), "utf-8");
		TbLinks links = new TbLinks();
		links.setAddtime(new Date());
		links.setIsdelete(0);
		links.setLink(link);
		links.setPlace(place);
		links.setTitle(title);
		int count = LinksService.getInstance().saveLinkes(links);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		out.print(count);
	}
	public void linksUpdate() throws IOException{
		String  id = URLDecoder.decode(request.getParameter("id"), "utf-8");
		String  title = URLDecoder.decode(request.getParameter("title"), "utf-8");
		String  link = URLDecoder.decode(request.getParameter("link"), "utf-8");
		String  place = URLDecoder.decode(request.getParameter("place"), "utf-8");
		TbLinks links = new TbLinks();
		links.setId(Integer.parseInt(id));
		links.setLink(link);
		links.setPlace(place);
		links.setTitle(title);
		int count = LinksService.getInstance().updateLinkes(links);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		out.print(count);
	}
	public void linksDelete() throws IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		int count = LinksService.getInstance().deleteLinkes(id);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		out.print(count);
	}
	public void makeLinkJs() throws IOException{
		Map<String, Object> linksMap = new HashMap<String, Object>();
		int count  = 0;
		try {
			List<TbLinks> linksGroup = LinksService.getInstance().getLinkGroupByPlace();
			for (TbLinks link1 : linksGroup) {
				linksMap.put(link1.getPlace(), LinksService.getInstance().getLinkGroup(link1.getPlace()));
			}
			JSONArray json = JSONArray.fromObject(linksMap);
			MakeLinkUtil.genBlockjs(json.toString());
			count  = 1;
		} catch (Exception e) {
			count  = -1;
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		out.print(count);
		
	}
	public List<TbLinks> getLinkList() {
		return linkList;
	}
	public void setLinkList(List<TbLinks> linkList) {
		this.linkList = linkList;
	}
}
