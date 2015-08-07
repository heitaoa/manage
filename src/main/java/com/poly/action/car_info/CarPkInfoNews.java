package com.poly.action.car_info;

import java.util.ArrayList;
import java.util.List;

import car_beans.DboCarAutohomeprop;
import car_daos.DboCarAutohomepropDao;

import com.poly.action.MyActionSupport;

public class CarPkInfoNews extends MyActionSupport{
	private int carid1;
	private int carid2;
	private int carid3;
	private int carid4;
	private String params;
	private List<DboCarAutohomeprop> autoList;
	
	public String  execute(){
		return SUCCESS;
	}
	
	public String SaveCarPkInfoNews(){
		String auto=" carid in ("+carid1;
		if(carid2!=0){
			auto=auto+","+carid2;
		}
		if(carid3!=0){
			auto=auto+","+carid3;
		}
		if(carid4!=0){
			auto=auto+","+carid4;
		}
		auto=auto+")";
		System.out.println(params);
		autoList=DboCarAutohomepropDao.where(auto);
		return SUCCESS;
	}
	
	public List<DboCarAutohomeprop> getAutoList() {
		return autoList;
	}

	public void setAutoList(List<DboCarAutohomeprop> autoList) {
		this.autoList = autoList;
	}

	
	public int getCarid1() {
		return carid1;
	}

	public void setCarid1(int carid1) {
		this.carid1 = carid1;
	}

	public int getCarid2() {
		return carid2;
	}

	public void setCarid2(int carid2) {
		this.carid2 = carid2;
	}

	public int getCarid3() {
		return carid3;
	}

	public void setCarid3(int carid3) {
		this.carid3 = carid3;
	}

	public int getCarid4() {
		return carid4;
	}

	public void setCarid4(int carid4) {
		this.carid4 = carid4;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

}
