package com.poly.bean;

import java.util.ArrayList;

public class Pic {
	
	private String err;
	//����photo
	private String name;
	private String icon;
	//RAR��ʽ��
	private String urlPath;
	private ArrayList<String> names;
	private ArrayList<String> icons;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getErr() {
		return err;
	}
	public void setErr(String err) {
		this.err = err;
	}
	public String getUrlPath() {
		return urlPath;
	}
	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}
	public ArrayList<String> getNames() {
		return names;
	}
	public void setNames(ArrayList<String> names) {
		this.names = names;
	}
	public ArrayList<String> getIcons() {
		return icons;
	}
	public void setIcons(ArrayList<String> icons) {
		this.icons = icons;
	}
}
