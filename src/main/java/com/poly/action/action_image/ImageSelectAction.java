package com.poly.action.action_image;

import java.util.HashMap;
import java.util.List;

import com.poly.action.MyActionSupport;
import com.poly.service.ImageService;

public class ImageSelectAction extends MyActionSupport{
	private static final long serialVersionUID = -3674375759202723273L;
	private int page = 1;
	private int totalPage;
	private int rows = 10;
	private int count;
	private int catalogId;
	private String carTypeArr="0";
	private int type=0;
	private String keywords="";
	private List<HashMap<String, Object>> imgPageList;
	
	public String execute(){
		return selectCar();
	}
	public String selectCar(){
		int start = rows * (page - 1);
		imgPageList = ImageService.getInstance().getImageDetail(carTypeArr,keywords.trim(),type,start,rows);
		if(imgPageList.size()>0){
			count = (Integer) imgPageList.get(0).get("count");
		}
		totalPage = count / rows;
		if (count % rows != 0) {
			totalPage++;
		}
		return SUCCESS;
	}
	public String showLeft(){
		return SUCCESS;
	}
	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}
	public List<HashMap<String, Object>> getImgPageList() {
		return imgPageList;
	}
	public void setImgPageList(List<HashMap<String, Object>> imgPageList) {
		this.imgPageList = imgPageList;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getCarTypeArr() {
		return carTypeArr;
	}
	public void setCarTypeArr(String carTypeArr) {
		this.carTypeArr = carTypeArr;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

}
