package com.poly.action.action_data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import car_beans.TbDataProject;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class AddQtProjectAction extends MyActionSupport {
	private String ini_man;
	private String ini_dept;
	private String ini_org;
	private int brand;
	private String iway;
	private int car = -1;
	private int model = -1;
	private int promo_prov;
	private int promo_city;
	private String promo_start_date;
	private String promo_end_date;
	private String custom_service;
	private String competing;
	private String custom_service_name;
	private String competing_name;
	private TbDataProject project = new TbDataProject();

	public String execute() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ProjectService projectService = ProjectService.getInstance();
		String pro_num = projectService.getCodeByOrg(5,Integer.parseInt(ini_org));
		project.setPro_num(pro_num);
		project.setIni_man(ini_man);
		project.setIni_dept(Integer.parseInt(ini_dept));
		project.setIni_org(Integer.parseInt(ini_org));
		project.setIway(iway);
		if(iway!=null){
			project.setBrand(projectService.getBrandIdByIway(iway));
		}else{
			project.setBrand(-1);
		}
		project.setCar(-1);
		project.setModel(-1);
		project.setPromo_prov(promo_prov);
		project.setPromo_city(promo_city);
		project.setPromo_start_date(sdf.parse(promo_start_date));
		project.setPromo_end_date(sdf.parse(promo_end_date));
		project.setPro_state(100);
		project.setActi_name("常态品牌回访");
		project.setService_type(5);
		project.setCustom_service(custom_service);
		project.setCustom_service_name(custom_service_name);
		project.setCompeting(competing);
		project.setCompeting_name(competing_name);
		project.setIni_date(new Date());
		project.setActi_start_date(new Date());
		project.setActi_end_date(new Date());
		project.setContact_start_date(new Date());
		project.setContact_end_date(new Date());
		return SUCCESS;
	}

	public String getIni_man() {
		return ini_man;
	}

	public void setIni_man(String ini_man) {
		this.ini_man = ini_man;
	}

	public String getIni_dept() {
		return ini_dept;
	}

	public void setIni_dept(String ini_dept) {
		this.ini_dept = ini_dept;
	}

	public String getIni_org() {
		return ini_org;
	}

	public void setIni_org(String ini_org) {
		this.ini_org = ini_org;
	}

	public int getBrand() {
		return brand;
	}

	public void setBrand(int brand) {
		this.brand = brand;
	}

	public int getCar() {
		return car;
	}

	public void setCar(int car) {
		this.car = car;
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public int getPromo_prov() {
		return promo_prov;
	}

	public void setPromo_prov(int promo_prov) {
		this.promo_prov = promo_prov;
	}

	public int getPromo_city() {
		return promo_city;
	}

	public void setPromo_city(int promo_city) {
		this.promo_city = promo_city;
	}

	public String getPromo_start_date() {
		return promo_start_date;
	}

	public void setPromo_start_date(String promo_start_date) {
		this.promo_start_date = promo_start_date;
	}

	public String getPromo_end_date() {
		return promo_end_date;
	}

	public void setPromo_end_date(String promo_end_date) {
		this.promo_end_date = promo_end_date;
	}

	public String getCustom_service() {
		return custom_service;
	}

	public void setCustom_service(String custom_service) {
		this.custom_service = custom_service;
	}

	public String getCompeting() {
		return competing;
	}

	public void setCompeting(String competing) {
		this.competing = competing;
	}

	public String getCustom_service_name() {
		return custom_service_name;
	}

	public void setCustom_service_name(String custom_service_name) {
		this.custom_service_name = custom_service_name;
	}

	public String getCompeting_name() {
		return competing_name;
	}

	public void setCompeting_name(String competing_name) {
		this.competing_name = competing_name;
	}

	public TbDataProject getProject() {
		return project;
	}

	public void setProject(TbDataProject project) {
		this.project = project;
	}

	public String getIway() {
		return iway;
	}

	public void setIway(String iway) {
		this.iway = iway;
	}
	
}
