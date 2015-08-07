package com.poly.action.action_data;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;
import car_beans.TbDataProject;
import car_beans.TbDataProjectBl;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class ServiceEditProjectAction extends MyActionSupport{
	private static final int SERVICE_TYPE_QT=5;
	private String pro_num;
	private int service_type;
	private String contact_num;
	private String acti_name;
	private int brand;
	private String iway;
	private int car;
	private int promo_prov;
	private int promo_city;
	private String promo_start_date;
	private String promo_end_date;
	private String contact_start_date;
	private String contact_end_date;
	private String acti_start_date;
	private String acti_end_date;
	private String cust_name;
	private int tar_clue_num;
	private int tar_reach_num;
	private int tar_trans_num;
	private String custom_service;
	private String custom_service_name;
	private String competing;
	private String competing_name;
	private String data_source;
	private String data_source_name;
	private TbDataProject project=new TbDataProject();
	private TbDataProjectBl bl = new TbDataProjectBl();
	public String execute() throws ParseException{
		ProjectService projectService = ProjectService.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		project.setPro_num(pro_num);
		if(acti_start_date!=null){
			project.setActi_start_date((sdf.parse(acti_start_date)));
		}
		if(acti_end_date!=null){
			project.setActi_end_date((sdf.parse(acti_end_date)));
		}
		if(StringUtils.isNotEmpty(acti_name)){
			project.setActi_name(acti_name);
		}
		project.setIway(iway);
		if(iway!=null){
			project.setBrand(projectService.getBrandIdByIway(iway));
		}else{
			project.setBrand(-1);
		}
		project.setCar(car);
		if(contact_end_date!=null){
			project.setContact_end_date(sdf.parse(contact_end_date));
		}
		project.setContact_num(contact_num);
		if(contact_start_date!=null){
			project.setContact_start_date(sdf.parse(contact_start_date));
		}
		project.setCust_name(cust_name);
		project.setCustom_service(custom_service);
		project.setCustom_service_name(custom_service_name);
		project.setPro_num(pro_num);
		project.setPromo_prov(promo_prov);
		project.setPromo_city(promo_city);
		if(service_type==SERVICE_TYPE_QT){
			
		}else{
			project.setPro_state(0);
		}
		if(promo_end_date!=null){
			project.setPromo_end_date(sdf.parse(promo_end_date));
		}
		if(promo_start_date!=null){
			project.setPromo_start_date(sdf.parse(promo_start_date));
		}
		project.setService_type(service_type); 
		project.setTar_clue_num(tar_clue_num);
		project.setTar_reach_num(tar_reach_num);
		project.setTar_trans_num(tar_trans_num);
		project.setCompeting(competing);
		project.setData_source(data_source);
		project.setData_source_name(data_source_name);
		project.setCompeting_name(competing_name);
		return SUCCESS;
		
	}
	public String editBl() throws ParseException{
		ProjectService projectService = ProjectService.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		bl.setPro_num(pro_num);
		bl.setActi_start_date((sdf.parse(acti_start_date)));
		bl.setActi_end_date((sdf.parse(acti_end_date)));
		bl.setActi_name(acti_name);
		if(iway!=null){
			bl.setBrand(projectService.getBrandIdByIway(iway));
		}else{
			bl.setBrand(-1);
		}
		bl.setIway(iway);
		bl.setCar(car);
		bl.setContact_end_date(sdf.parse(contact_end_date));
		bl.setContact_num(contact_num);
		bl.setContact_start_date(sdf.parse(contact_start_date));
		bl.setCust_name(cust_name);
		bl.setCustom_service(custom_service);
		bl.setCustom_service_name(custom_service_name);
		bl.setPro_num(pro_num);
		bl.setPromo_prov(promo_prov);
		bl.setPromo_city(promo_city);
		bl.setPro_state(0);
		bl.setPromo_end_date(sdf.parse(promo_end_date));
		bl.setPromo_start_date(sdf.parse(promo_start_date));
		bl.setService_type(service_type); 
		bl.setTar_clue_num(tar_clue_num);
		bl.setTar_reach_num(tar_reach_num);
		bl.setTar_trans_num(tar_trans_num);
		bl.setCompeting(competing);
		bl.setCompeting_name(competing_name);
		bl.setData_source(data_source);
		bl.setData_source_name(data_source_name);
		return SUCCESS;
		
	}

	public String getPro_num() {
		return pro_num;
	}

	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
	}

	public int getService_type() {
		return service_type;
	}

	public void setService_type(int service_type) {
		this.service_type = service_type;
	}

	public String getContact_num() {
		return contact_num;
	}

	public void setContact_num(String contact_num) {
		this.contact_num = contact_num;
	}

	public String getActi_name() {
		return acti_name;
	}

	public void setActi_name(String acti_name) {
		this.acti_name = acti_name;
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

	public String getContact_start_date() {
		return contact_start_date;
	}

	public void setContact_start_date(String contact_start_date) {
		this.contact_start_date = contact_start_date;
	}

	public String getContact_end_date() {
		return contact_end_date;
	}

	public void setContact_end_date(String contact_end_date) {
		this.contact_end_date = contact_end_date;
	}


	public String getActi_start_date() {
		return acti_start_date;
	}

	public void setActi_start_date(String acti_start_date) {
		this.acti_start_date = acti_start_date;
	}

	public String getActi_end_date() {
		return acti_end_date;
	}

	public void setActi_end_date(String acti_end_date) {
		this.acti_end_date = acti_end_date;
	}

	public String getCompeting() {
		return competing;
	}

	public void setCompeting(String competing) {
		this.competing = competing;
	}

	public String getData_source() {
		return data_source;
	}

	public void setData_source(String data_source) {
		this.data_source = data_source;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public int getTar_clue_num() {
		return tar_clue_num;
	}

	public void setTar_clue_num(int tar_clue_num) {
		this.tar_clue_num = tar_clue_num;
	}

	public int getTar_reach_num() {
		return tar_reach_num;
	}

	public void setTar_reach_num(int tar_reach_num) {
		this.tar_reach_num = tar_reach_num;
	}

	public int getTar_trans_num() {
		return tar_trans_num;
	}

	public void setTar_trans_num(int tar_trans_num) {
		this.tar_trans_num = tar_trans_num;
	}

	public String getCustom_service() {
		return custom_service;
	}

	public void setCustom_service(String custom_service) {
		this.custom_service = custom_service;
	}

	public TbDataProject getProject() {
		return project;
	}

	public void setProject(TbDataProject project) {
		this.project = project;
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
	public TbDataProjectBl getBl() {
		return bl;
	}
	public void setBl(TbDataProjectBl bl) {
		this.bl = bl;
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
	public String getData_source_name() {
		return data_source_name;
	}
	public void setData_source_name(String data_source_name) {
		this.data_source_name = data_source_name;
	}
	public String getIway() {
		return iway;
	}
	public void setIway(String iway) {
		this.iway = iway;
	}
	
	
	
}
