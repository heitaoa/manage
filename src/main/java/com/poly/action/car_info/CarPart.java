package com.poly.action.car_info;

import java.util.List;

import car_beans.DboCarNewproperty;
import car_daos.BaseDao;
import car_daos.DboCarNewpropertyDao;

import com.poly.action.MyActionSupport;
import com.poly.dao.SeqDao;
import com.poly.service.CarPartService;
import com.poly.service.CarPropertyService;
import com.poly.util.CalcPageUtil;

public class CarPart extends MyActionSupport{
	
	private final int pageSize=20;
	private int page=1;
	private int pages=1;
	private List<DboCarNewproperty> partList;
	private int type;
	private String name;
	private int level;
	private String explain;
	private int partid;
	
	public String execute(){
		list();
		return SUCCESS;
	}
	
	private void list(){
		int amount=CarPartService.getInstance().getAmount();
		pages=CalcPageUtil.getPages(amount, pageSize);
		if(page<1)
			page=1;
		if(page>pages){
			page=pages;
		}
		partList=CarPartService.getInstance().findList(page, pageSize);
	}
	
	public String AddPart(){
		String typeName="";
		switch(type){
			case 1:
				typeName="车身外部";
				break;
			case 2:
				typeName="内部舒适";
				break;
			case 3:
				typeName="行车功能";
				break;
			case 4:
				typeName="驾驶安全";
				break;
			default:
				break;
		}
		try{
			int id=SeqDao.getNextId("dbo_car_newproperty");
			DboCarNewproperty carPart=new DboCarNewproperty();
			carPart.setId(id);
			carPart.setName(name);
			carPart.setType(typeName);
			carPart.setLevel(level);
			carPart.setExplain(explain);
			DboCarNewpropertyDao.save(carPart);
			setAjax("1");
		}catch(Exception e){
			e.printStackTrace();
			setAjax("0");
		}
		return AJAX;
	}
	
	public String SavePart(){
		String typeName="";
		switch(type){
			case 1:
				typeName="车身外部";
				break;
			case 2:
				typeName="内部舒适";
				break;
			case 3:
				typeName="行车功能";
				break;
			case 4:
				typeName="驾驶安全";
				break;
			default:
				break;
		}
		try{
			String saSql="UPDATE dbo_car_newproperty SET name ='"+name+"' ,level = "+ level+" , `explain`='"+explain+"', type='"+typeName+"' where id ="+partid;
			BaseDao.execute(saSql);
			setAjax("1");
		}catch(Exception e){
			setAjax("0");
		}
		return AJAX;
	}
	
	
	public String DelPart(){
		try{
			String delSql=" id = "+partid;
			DboCarNewpropertyDao.delete(delSql);
			setAjax("1");
		}catch(Exception e){
			setAjax("0");
		}
		return AJAX;
	}
	
	public List<DboCarNewproperty> getPartList(){
		return partList;
	}
	
	public void setPartList(List<DboCarNewproperty> partList){
		this.partList=partList;
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
	
	public int getType(){
		return type;
	}
	public void setType(int type){
		this.type=type;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	
	public int getLevel(){
		return level;
	}
	public void setLevel(int level){
		this.level=level;
	}
	
	public String getExplain(){
		return explain;
	}
	public void setExplain(String explain){
		this.explain=explain;
	}
	
	public int getPartid(){
		return partid;
	}
	public void setPartid(int partid){
		this.partid=partid;
	}
}
