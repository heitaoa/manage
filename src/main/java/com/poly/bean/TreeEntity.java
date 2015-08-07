package com.poly.bean;

public class TreeEntity {
	
	private int id;
	
	private int pId;
	
	private String name;
	
	private boolean open;
	
	private String lname;
	
	private String pathlevel;
	
	private int areaid;
	

	public int getAreaid() {
		return areaid;
	}

	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}

	public String getPathlevel() {
		return pathlevel;
	}

	public void setPathlevel(String pathlevel) {
		this.pathlevel = pathlevel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

}
