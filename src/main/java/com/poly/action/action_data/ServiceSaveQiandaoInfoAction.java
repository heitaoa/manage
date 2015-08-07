package com.poly.action.action_data;

import java.io.IOException;

import car_beans.TbDataVisitRecord;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class ServiceSaveQiandaoInfoAction extends MyActionSupport{
	private String bz;
	private String qq;
	private String weixin;
	private int attend_type;
	private int record_id;
	public void back() throws IOException{
		TbDataVisitRecord td = new TbDataVisitRecord();
		td.setRecord_id(record_id);
		td.setAttend_type(attend_type);
		td.setP_qq(qq);
		td.setP_weixin(weixin);
		td.setBz(bz);
		int back = ProjectService.getInstance().updateVisitRecord(td);
		response.setContentType("text/html;charset=gbk");
		response.getWriter().write(back+"");
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public int getAttend_type() {
		return attend_type;
	}
	public void setAttend_type(int attend_type) {
		this.attend_type = attend_type;
	}
	public int getRecord_id() {
		return record_id;
	}
	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}
	
}	
