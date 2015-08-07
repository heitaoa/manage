package com.poly.action.car_info;

import java.util.List;

import com.poly.action.MyActionSupport;
import com.poly.service.CarChannelService;
import com.poly.util.CalcPageUtil;

import car_beans.DboCarCatalognew;
import car_beans.DboCarIway;
import car_daos.BaseDao;
import car_daos.DboCarIwayDao;

public class CarChannel  extends MyActionSupport{

	private final int pageSize=40;
	private int page=1;
	private int pages=1;
	private List<DboCarCatalognew> channelList;
	private String channelname="";
	private List<DboCarIway> iwayList;
	private String iwayname;
	private int id;
	private String ids;
	private int type=3;
	
	public String execute(){
		list();
		return SUCCESS;
	}
	
	private void list(){
		int amount=CarChannelService.getInstance().getAmount(channelname);
		pages=CalcPageUtil.getPages(amount, pageSize);
		if(page<1)
			page=1;
		if(page>pages){
			page=pages;
		}
		channelList=CarChannelService.getInstance().findList(page, pageSize, channelname);
		iwayList=DboCarIwayDao.find();
	}
	
	public String SaveChannel(){
		try{
			String saveSql="UPDATE dbo_car_catalognew SET iway='"+iwayname+"' where catalogid="+id;
			BaseDao.execute(saveSql);
			setAjax("1");
		}catch(Exception e){
			setAjax("0");
		}
		return AJAX;
	}
	
	public String PlSaveChannel(){
		int cid=0;
		String ciway="";
		String cidStr="";
		
		String saveSql="";
		try{
			cidStr=ids.substring(1, ids.length());
			for(int i=0;i<cidStr.split(",").length;i++){
				cid=Integer.parseInt(cidStr.split(",")[i].split("_")[0]);
				ciway=cidStr.split(",")[i].split("_")[1];
				saveSql="UPDATE dbo_car_catalognew SET iway='"+ciway+"' where catalogid="+cid;
				BaseDao.execute(saveSql);
			}
			setAjax("1");
		}catch(Exception e){
			setAjax("0");
		}
		return AJAX;
	}
	
	public int getType(){
		return type;
	}
	public void setType(int type){
		this.type=type;
	}
	
	public String getIds(){
		return ids;
	}
	public void setIds(String ids){
		this.ids=ids;
	}
	
	public String getIwayname(){
		return iwayname;
	}
	public void setIwayname(String iwayname){
		this.iwayname=iwayname;
	}
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	
	public List<DboCarCatalognew> getChannelList(){
		return channelList;
	}
	public void setChannelList(List<DboCarCatalognew> channelList){
		this.channelList=channelList;
	}
	
	public String getChannelname(){
		return channelname;
	}
	public void setChannelname(String channelname){
		this.channelname=channelname;
	}
	
	public List<DboCarIway> getIwayList(){
		return iwayList;
	}
	public void setIwayList(List<DboCarIway> iwayList){
		this.iwayList=iwayList;
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
	
}
