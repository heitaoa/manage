package com.poly.action.car_info;

import java.util.Date;
import java.util.List;

import car_beans.DboCarBaiketitle;
import car_daos.DboCarBaiketitleDao;

import com.poly.action.MyActionSupport;
import com.poly.dao.SeqDao;
import com.poly.service.CarPropertyService;
import com.poly.util.CalcPageUtil;
import com.poly.util.FieldUtil;

import car_daos.BaseDao;


public class CarProperty extends MyActionSupport{

	private final int pageSize=20;
	private int page=1;
	private int pages=1;
	private List<DboCarBaiketitle> propertyList;
	private String titleName="";
	private int id;
	private String titlename;
	private String property;
	
	public String execute(){
		list();
		return SUCCESS;
	}
	
	private void list(){
		titleName=titleName.trim();
		int amount=CarPropertyService.getInstance().getAmount(titleName);
		pages=CalcPageUtil.getPages(amount, pageSize);
		if(page<1)
			page=1;
		if(page>pages){
			page=pages;
		}
		propertyList=CarPropertyService.getInstance().findList(page, pageSize, titleName);
	}
	
	public String DelCarProperty(){
		try{
			String delSql=" id ="+id;
			DboCarBaiketitleDao.delete(delSql);
			setAjax("1");
		}catch(Exception e){
			setAjax("0");
		}
		return AJAX;
	}
	
	public String SaveProperty(){
		try{
			String saveSql="UPDATE dbo_car_baiketitle SET title = '"+titlename+" ' ,baikecontent = ' "+ property+" ' where id ="+id;
			BaseDao.execute(saveSql);
			setAjax("1");
		}catch(Exception e){
			e.printStackTrace();
			setAjax("0");
		}
		return AJAX;
	}
	
	public String AddProperty(){
		try{
			int id=SeqDao.getNextId("dbo_car_baiketitle");
			Date time=new Date();
			DboCarBaiketitle carProperty=new DboCarBaiketitle();
			carProperty.setId(id);
			carProperty.setAddtime(time);
			carProperty.setUptime(time);
			carProperty.setTitle(titlename);
			carProperty.setBaikecontent(property);
			DboCarBaiketitleDao.save(carProperty);
			setAjax("1");
		}catch(Exception e){
			setAjax("0");
		}
		return AJAX;
	}
	
	
	public List<DboCarBaiketitle> getPropertyList(){
		return propertyList;
	}
	public void setPropertyList(List<DboCarBaiketitle> propertyList){
		this.propertyList=propertyList;
	}
	
	public String getTitleName(){
		return titleName;
	}
	public void setTitleName(String titleName){
		this.titleName=titleName;
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
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	
	public String getTitlename(){
		return titlename;
	}
	public void setTitlename(String titlename){
		this.titlename=titlename;
	}
	
	public String getProperty(){
		return property;
	}
	public void setProperty(String property){
		this.property=property;
	}
}
