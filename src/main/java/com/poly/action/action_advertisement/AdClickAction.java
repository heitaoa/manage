package com.poly.action.action_advertisement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import car_beans.DboAdPopad;

import com.poly.action.MyActionSupport;
import com.poly.service.AdCilckService;
import com.poly.service.AdService;
import com.poly.util.AdScheduleUtil;

public class AdClickAction extends MyActionSupport {
	
	private String sdate;
	private String edate;
	private String adInfoId;
	//广告排期列表
	private List<Map<String,String>> adscheduleList;
	//排期列表编号
	private int number;
	//排期Id
	private String scheduleId;
	private String html;
	
	//点击信息
	private List<DboAdPopad> adClickList;
	
	//获取点击信息
	public String getAdClickInfo(){
		
		adClickList = AdCilckService.getAdClickInfo();
		
		return SUCCESS;
	}
	
	public void addAdSchedule(){
		if(!AdService.judgeAdschedule(sdate,edate,adInfoId)){
			adscheduleList = new ArrayList<Map<String,String>>();
		}else{
			if(adInfoId!=null&&!adInfoId.equals("")){
				AdService.addAdSchedule(edate, sdate, adInfoId);
				adscheduleList = AdService.getAdScheduleByAdId(adInfoId);
			}else{
				if(html.trim().equals("")&&AdScheduleUtil.adScheduleList.size()>0){
					AdScheduleUtil.adScheduleList = new ArrayList<Map<String,String>>();
				}
				Map<String,String> map = new HashMap<String, String>();
				map.put("sdate",sdate);
				map.put("edate",edate);
				AdScheduleUtil.adScheduleList.add(map);
				adscheduleList = AdScheduleUtil.adScheduleList;
			}
		}
		response.setContentType("text/html;charset=utf-8");
		JSONArray json = JSONArray.fromObject(adscheduleList);
		try {
			PrintWriter out = response.getWriter();
			out.print(json.toString());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//删除广告排期
	public void deleteAdSchedule(){
		if(adInfoId!=null&&!adInfoId.equals("")){
			AdService.deleteAdSchedule(scheduleId);
			adscheduleList = AdService.getAdScheduleByAdId(adInfoId);
		}else{
			//AdScheduleUtil.adScheduleList.remove(Integer.valueOf(number));
		    for(int i=AdScheduleUtil.adScheduleList.size()-1;i >=0;i--){
		    	if(i==Integer.valueOf(number)){
		    		AdScheduleUtil.adScheduleList.remove(i);
		    	}
		    }
			adscheduleList = AdScheduleUtil.adScheduleList;
		}	
		response.setContentType("text/html;charset=utf-8");
		JSONArray json = JSONArray.fromObject(adscheduleList);
		try {
			PrintWriter out = response.getWriter();
			out.print(json.toString());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<DboAdPopad> getAdClickList() {
		return adClickList;
	}

	public void setAdClickList(List<DboAdPopad> adClickList) {
		this.adClickList = adClickList;
	}

}
