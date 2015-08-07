package com.poly.bean;

public class ImageEntity {
	
	private String title;
	
	private String keywords;
	
	private String oldpath;
	
	private String imagePath;
	
	private int imageId;
	
	private int titleid;
	
	private int type;
	
	private int catalogid;
	
	private String imageTypeInfo;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public int getTitleid() {
		return titleid;
	}

	public void setTitleid(int titleid) {
		this.titleid = titleid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getCatalogid() {
		return catalogid;
	}

	public void setCatalogid(int catalogid) {
		this.catalogid = catalogid;
	}

	public String getOldpath() {
		return oldpath;
	}

	public void setOldpath(String oldpath) {
		this.oldpath = oldpath;
	}

	public String getImageTypeInfo() {
		return imageTypeInfo;
	}

	public void setImageTypeInfo(String imageTypeInfo) {
		this.imageTypeInfo = imageTypeInfo;
	}
}
