package com.poly.bean;

import java.util.ArrayList;

public class UeditorImage {
	
	private String imageUrl;
	private String imagePath;
	private String imageFieldName;
	private int imageMaxSize;
	private ArrayList<String> imageAllowFiles;
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getImageFieldName() {
		return imageFieldName;
	}
	public void setImageFieldName(String imageFieldName) {
		this.imageFieldName = imageFieldName;
	}
	public int getImageMaxSize() {
		return imageMaxSize;
	}
	public void setImageMaxSize(int imageMaxSize) {
		this.imageMaxSize = imageMaxSize;
	}
	public ArrayList<String> getImageAllowFiles() {
		return imageAllowFiles;
	}
	public void setImageAllowFiles(ArrayList<String> imageAllowFiles) {
		this.imageAllowFiles = imageAllowFiles;
	}
}
