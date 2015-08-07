package com.poly.action.car_info;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import car_beans.DboCarCatalognew;
import car_daos.BaseDao;
import car_daos.DboCarCatalognewDao;

import com.poly.action.MyActionSupport;
import com.poly.service.CarChannelService;
import com.poly.service.CarMainSeriesService;
import com.poly.util.CalcPageUtil;

public class CarMainSeries extends MyActionSupport{
 
	private final int pageSize=40;
	private int page=1;
	private int pages=1;
	private String seriesname="";
	private int id;
	private List<DboCarCatalognew> catalogList=new ArrayList<DboCarCatalognew>();
	private Map<Integer,String> brank=new HashMap<Integer,String>();
	private int series;
	private String ids;
	
	

	private int Fname;

	public String test(){
		list();
		return SUCCESS;
	}
	
	private void list(){
		int amount=CarMainSeriesService.getInstance().getAmount(seriesname);
		pages=CalcPageUtil.getPages(amount, pageSize);
		if(page<1)
			page=1;
		if(page>pages){
			page=pages;
		}
		catalogList=CarMainSeriesService.getInstance().findList(page, pageSize, seriesname);
		String bSql="pathlevel = 1";
		List<DboCarCatalognew> list=DboCarCatalognewDao.where(bSql);
		for(int i=0;i<list.size();i++){
			brank.put(list.get(i).getCatalogid(),list.get(i).getCatalogname());
		}
	}
	
	public void GetMarker() throws IOException{
		List<String> marker=new ArrayList<String>();
		List<DboCarCatalognew> clist=new ArrayList<DboCarCatalognew>();
		String cSql="fatherid="+Fname;
		clist=DboCarCatalognewDao.where(cSql);
		List<String> data=new ArrayList<String>();
		for(int i=0;i<clist.size();i++){
			data.add(clist.get(i).getCatalogid()+"@"+clist.get(i).getCatalogname());
		}
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(data);
		//String jsonp=request.getParameter("jsonpcallback");
		out.print(json.toString());
		out.close();
	}
	
	public String SaveSeries(){
		try{
			String saveSQL="update dbo_car_catalognew set fatherid = "+series+" where catalogid = "+id;
			BaseDao.execute(saveSQL);
			setAjax("1");
		}catch(Exception e){
			setAjax("0");
		}
		return AJAX;
	}
	
	public String PlSaveSeries(){
		try{
			String cidStr=ids.substring(1, ids.length());
			for(int i=0;i<cidStr.split(",").length;i++){
				int cid=Integer.parseInt(cidStr.split(",")[i].split("@")[0]);
				String ciway=cidStr.split(",")[i].split("@")[1];
				String saveSql=" UPDATE dbo_car_catalognew set fatherid = "+ciway+" where catalogid= "+cid;
				BaseDao.execute(saveSql);
			}
			setAjax("1");
		}catch(Exception e){
			setAjax("0");
		}
		return AJAX;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}

	public Map<Integer, String> getBrank() {
		return brank;
	}

	public void setBrank(Map<Integer, String> brank) {
		this.brank = brank;
	}
	public int getFname() {
		return Fname;
	}

	public void setFname(int fname) {
		Fname = fname;
	}
	
	public String getSeriesname(){
		return seriesname;
	}
	public void setSeriesname(String seriesname){
		this.seriesname=seriesname;
	}
	
	public int getPage(){
		return page;
	}
	public void setPage(int page){
		this.page=page;
	}
	
	public int getPages(){
		return pages;
	}
	public void setPages(int pages){
		this.pages=pages;
	}
	
	public List<DboCarCatalognew> getCatalogList() {
		return catalogList;
	}

	public void setCatalogList(List<DboCarCatalognew> catalogList) {
		this.catalogList = catalogList;
	}
	
}
