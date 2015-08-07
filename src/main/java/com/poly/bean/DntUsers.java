package com.poly.bean;

import car_beans.DboDntUsers;

@SuppressWarnings("serial")
public class DntUsers extends DboDntUsers{

	private String realname;//dbo_adm_user

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
	
}
