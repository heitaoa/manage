package com.poly.bean;

public class UserEntity {

	private String uid;

	private String username;

	private String nickname;

	private String password;

	private String ulevel;
	
	private String ucity;
	
	private String uprov;
	
	private String ufman;//是否是分站管理员
	
	private String groupid;
	
	private String brands;
	
	private String siteid;
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(String uid, String username, String nickname,
			String password, String ulevel,String ufman,String siteid) {
		super();
		this.uid = uid;
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.ulevel = ulevel;
		this.ufman = ufman;
		this.siteid = siteid;
	}
	
	public UserEntity(String username, String nickname,
			String password, String ulevel,String ufman,String siteid) {
		super();
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.ulevel = ulevel;
		this.ufman = ufman;
		this.siteid = siteid;
	}
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUlevel() {
		return ulevel;
	}

	public void setUlevel(String ulevel) {
		this.ulevel = ulevel;
	}

	public String getUcity() {
		return ucity;
	}

	public void setUcity(String ucity) {
		this.ucity = ucity;
	}

	public String getUprov() {
		return uprov;
	}

	public void setUprov(String uprov) {
		this.uprov = uprov;
	}

	public String getUfman() {
		return ufman;
	}

	public void setUfman(String ufman) {
		this.ufman = ufman;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getBrands() {
		return brands;
	}

	public void setBrands(String brands) {
		this.brands = brands;
	}

	public String getSiteid() {
		return siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}



}
