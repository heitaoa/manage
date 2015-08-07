package com.poly.action.action_advertisement;

import java.util.List;

import car_beans.DboPubAd;

import com.poly.action.MyActionSupport;
import com.poly.service.AdInfoService;

public class AdInfoAction extends MyActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//广告位信息列表
	private List<DboPubAd> adInfoList;
	//城市站
	private String city;
	
	//获取广告位信息
	public String toAdInfoList(){
		adInfoList = AdInfoService.getAdInfoByCity(city);
		return "toAllAdInfoList";
	}

	public List<DboPubAd> getAdInfoList() {
		return adInfoList;
	}

	public void setAdInfoList(List<DboPubAd> adInfoList) {
		this.adInfoList = adInfoList;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
