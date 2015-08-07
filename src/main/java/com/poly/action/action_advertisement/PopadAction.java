package com.poly.action.action_advertisement;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import car_beans.DboAdPopad;
import car_beans.DboAdPopadschedule;

import com.poly.action.MyActionSupport;
import com.poly.service.AdService;
import com.poly.service.PopadscheduleService;
import com.poly.service.Popadservice;
import com.poly.util.AdScheduleUtil;

public class PopadAction extends MyActionSupport{
	
	private  List<DboAdPopadschedule> schedulelist;
             
	private  DboAdPopad popad;
	
	private  List<DboAdPopad> podlist;
	
	private  String popadid;
	
	private  DboAdPopadschedule schedule;
	
	private  String  scheduleid;
	
    private  String edate;
    
    private String sdate;
    
    private String html;
    
    private int number;
    
    private List<Map<String,String>> adscheduleList;
		
	private int pageCount;
	
	private int page=1;

	public String getAllpopad(){
		int count = Popadservice.getPopadCount();
		if(count%20==0){
			pageCount = count/20;
		}else{
			pageCount = count/20+1;
		}
		
		if(page>pageCount){
			page=pageCount;
		} 
		int from = (page-1)*20;
		podlist = Popadservice.getPopadByPage(from,20);
		//podlist = Popadservice.getPopad();
		return SUCCESS;
	}
	
	public String toinsertPopad(){
    	return SUCCESS;
    }
    
    public String deletePopad(){
       Popadservice.deletePopad(popadid);
       PopadscheduleService.deletePopadschedule(scheduleid);
       return SUCCESS;   	
    }
    
    public String updatePopad(){
		popad.setScheduledday(new Date());
		popad.setIsdelete(0);
		popad.setRemaintimes(popad.getPoptotaltimes());
    	Popadservice.updatePopad(popad);
    	return SUCCESS;
    }
    
    public String toUpdatePopad(){
    	popad = Popadservice.getPoapdById(popadid);
    	schedulelist = PopadscheduleService.getschedule(popadid);
    	return SUCCESS;
    }
    
    public String insertPopad() throws ParseException{
		popad.setScheduledday(new Date());
		popad.setIsdelete(0);
		popad.setRemaintimes(popad.getPoptotaltimes());
		Popadservice.insertPopad(popad);
		int id = Popadservice.getMaxPopId();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(AdScheduleUtil.adScheduleList.size()>0){
			for(int i=0;i<AdScheduleUtil.adScheduleList.size();i++){
				Map<String,String> map = AdScheduleUtil.adScheduleList.get(i);
				DboAdPopadschedule schedule = new DboAdPopadschedule();
				schedule.setEdate(sdf.parse(map.get("edate")));
				schedule.setSdate(sdf.parse(map.get("sdate")));
				schedule.setPopaid(id);
				PopadscheduleService.insertPopadschedule(schedule);
			}
		}
		
		return SUCCESS;		
	}

    
	public void addPopSchedule(){

		if(html.trim().equals("")&&AdScheduleUtil.adScheduleList.size()>0){
			AdScheduleUtil.adScheduleList = new ArrayList<Map<String,String>>();
		}
		Map<String,String> map = new HashMap<String, String>();
		map.put("sdate",sdate);
		map.put("edate",edate);
		AdScheduleUtil.adScheduleList.add(map);
		adscheduleList = AdScheduleUtil.adScheduleList;		
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
	  public void deletePopSchedule(){
		//AdScheduleUtil.adScheduleList.remove(Integer.valueOf(number));
	    for(int i=AdScheduleUtil.adScheduleList.size()-1;i >=0;i--){
	    	if(i==Integer.valueOf(number)){
	    		AdScheduleUtil.adScheduleList.remove(i);
	    	}
	    }
		adscheduleList = AdScheduleUtil.adScheduleList;	
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
	
		public void addPopScheduleById() throws ParseException{
			DboAdPopadschedule schedule = new DboAdPopadschedule();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			schedule.setEdate(sdf.parse(edate));
			schedule.setSdate(sdf.parse(sdate));
			schedule.setPopaid(Integer.valueOf(popadid));
			PopadscheduleService.insertPopadschedule(schedule);
			List<DboAdPopadschedule> scheduleList = PopadscheduleService.getschedule(popadid);
			response.setContentType("text/html;charset=utf-8");
			JSONArray json = JSONArray.fromObject(scheduleList);
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
		public void deletePopScheduleById(){
			//AdScheduleUtil.adScheduleList.remove(Integer.valueOf(number));
			PopadscheduleService.deletePopadschedule(scheduleid);
			List<DboAdPopadschedule> scheduleList = PopadscheduleService.getschedule(popadid);
			response.setContentType("text/html;charset=utf-8");
			JSONArray json = JSONArray.fromObject(scheduleList);
			try {
				PrintWriter out = response.getWriter();
				out.print(json.toString());
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
    
    public List<DboAdPopadschedule> getSchedulelist() {
		return schedulelist;
	}

	public void setSchedulelist(List<DboAdPopadschedule> schedulelist) {
		this.schedulelist = schedulelist;
	}

	public List<DboAdPopad> getPodlist() {
		return podlist;
	}

	public void setPodlist(List<DboAdPopad> podlist) {
		this.podlist = podlist;
	}

	public String getPopadid() {
		return popadid;
	}

	public void setPopadid(String popadid) {
		this.popadid = popadid;
	}

	public DboAdPopad getPopad() {
		return popad;
	}

	public void setPopad(DboAdPopad popad) {
		this.popad = popad;
	}
	
	public DboAdPopadschedule getSchedule() {
		return schedule;
	}

	public void setSchedule(DboAdPopadschedule schedule) {
		this.schedule = schedule;
	}
	
	public String getScheduleid() {
		return scheduleid;
	}

	public void setScheduleid(String scheduleid) {
		this.scheduleid = scheduleid;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	
 }
