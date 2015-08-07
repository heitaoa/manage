package com.poly.action.action_data;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import car_beans.TbDataActDetail;
import car_beans.TbDataProject;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class ServiceSaveEditActDetailAction extends MyActionSupport{
	private String pro_num;
	private String base_zx;
	private String base_fz;
	private String base_hdrq;
	private String base_sd;
	private String base_jtf;
	private String base_hdrybz;
	private String base_hdzj;
	private String base_addr;
	private String acti_name;
	public void back() throws IOException{
		String back  = "1";
		ProjectService projectService = ProjectService.getInstance();
		TbDataActDetail detail = new TbDataActDetail();
		TbDataProject project = new TbDataProject();
		detail.setDetail_acti_addr(base_addr);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			detail.setDetail_acti_date(sdf.parse(base_hdrq));
			project.setActi_name(acti_name);
			project.setActi_start_date(sdf.parse(base_hdrq));
			project.setActi_end_date(sdf.parse(base_hdrq));
			project.setPro_num(pro_num);
			projectService.updateOrInsert(project);
		} catch (ParseException e) {
			e.printStackTrace();
			back =  "-1";
		}
		detail.setDetail_acti_report(base_hdzj);
		detail.setDetail_acti_sub(base_hdrybz);
		detail.setDetail_assist_person(base_fz);
		detail.setDetail_executor(base_zx);
		detail.setDetail_time_interval(Integer.parseInt(base_sd));
		detail.setDetail_traffic_expense(base_jtf);
		detail.setPro_num(pro_num);
		back = projectService.insertOrUpdateActDetail(detail);
		response.setContentType("text/html;charset=gbk");
		response.getWriter().write(back);
	}
	public String getPro_num() {
		return pro_num;
	}
	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
	}
	public String getBase_zx() {
		return base_zx;
	}
	public void setBase_zx(String base_zx) {
		this.base_zx = base_zx;
	}
	public String getBase_fz() {
		return base_fz;
	}
	public void setBase_fz(String base_fz) {
		this.base_fz = base_fz;
	}
	public String getBase_hdrq() {
		return base_hdrq;
	}
	public void setBase_hdrq(String base_hdrq) {
		this.base_hdrq = base_hdrq;
	}
	public String getBase_sd() {
		return base_sd;
	}
	public void setBase_sd(String base_sd) {
		this.base_sd = base_sd;
	}
	public String getBase_jtf() {
		return base_jtf;
	}
	public void setBase_jtf(String base_jtf) {
		this.base_jtf = base_jtf;
	}
	public String getBase_hdrybz() {
		return base_hdrybz;
	}
	public void setBase_hdrybz(String base_hdrybz) {
		this.base_hdrybz = base_hdrybz;
	}
	public String getBase_hdzj() {
		return base_hdzj;
	}
	public void setBase_hdzj(String base_hdzj) {
		this.base_hdzj = base_hdzj;
	}
	public String getBase_addr() {
		return base_addr;
	}
	public void setBase_addr(String base_addr) {
		this.base_addr = base_addr;
	}
	public String getActi_name() {
		return acti_name;
	}
	public void setActi_name(String acti_name) {
		this.acti_name = acti_name;
	}
	
	
}
