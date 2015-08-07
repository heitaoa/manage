package com.poly.action.action_advertisement;

import java.util.List;

import car_beans.DboAdExposure;

import com.poly.action.MyActionSupport;
import com.poly.service.ExposureService;

public class AdExposureAction extends MyActionSupport {
	
	/**
	 * 
	 */

	//曝光列表
	private List<DboAdExposure> exposureList;
	
	private DboAdExposure exposure;
	
	private String exposureid;
	
	private int page=1;
	
	private int pageCount;  // 总页数
	
	public String getAllExposure(){
		//总记录数count
		int count = ExposureService.getAllExposureCount();
		if(count%10==0){
			pageCount = count/10;
		}else{
			pageCount = count/10+1;
		}
		
		
		//
		if(page>pageCount){
			page=pageCount;
		} 
		int from = (page-1)*10;
		exposureList = ExposureService.getAllExposureByPage(from,10);
		//exposureList = ExposureService.getAllExposure();
		return SUCCESS;
	}
	
	//插入曝光数据
	public String insertExposure(){
		ExposureService.insertExposure(exposure);
		return SUCCESS;
	}
	
	//删除曝光数据
	public String deleteExposure(){
		ExposureService.deleteExposure(exposureid);
		return SUCCESS;
	}
	
	//
	public String updateExposure(){
		ExposureService.updateExposure(exposure);
		return SUCCESS;	
	} 
	
	
	//添加数据
	public String toInsertExposure(){
		return SUCCESS;
	}
    //进入修改页面
	public String toUpdateExposure(){
		exposure = ExposureService.getExposureById(exposureid);
		return SUCCESS;
	} 	
	
	public List<DboAdExposure> getExposureList() {
		return exposureList;
	}

	public void setExposureList(List<DboAdExposure> exposureList) {
		this.exposureList = exposureList;
	}

	public DboAdExposure getExposure() {
		return exposure;
	}

	public void setExposure(DboAdExposure exposure) {
		this.exposure = exposure;
	}

	public String getExposureid() {
		return exposureid;
	}

	public void setExposureid(String exposureid) {
		this.exposureid = exposureid;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	
}
