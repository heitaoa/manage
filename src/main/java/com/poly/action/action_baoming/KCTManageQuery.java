package com.poly.action.action_baoming;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import car_beans.TbDataBaoming;

import com.poly.action.MyActionSupport;
import com.poly.service.BaomingService;

public class KCTManageQuery extends MyActionSupport{
	private int page = 1;
	private int pages = 1;
	private int size = 20;
	
	private List<Map<String, String>> tuiguangList ;//推广项目列表
	private String tuiguangListStr ;//推广项目列表json串
	
	private  List<Map<String, String>> iwayList ;//推广渠道列表
	private String iway = "";//推广渠道
	private String iway2 = "";//推广渠道
	private String iway3 = "";//推广渠道
	private int iserial = 0; //推广车系
	
	private String competing;//推广
	
	//查询条件
	private String name = "";//姓名
	private String phone = "";//电话
	private String beginDate;//开始时间
	private String endDate;//结束时间
	private String promo_start_date;//推广开始时间
	private String promo_end_date;//推广结束时间
	private int return_visit_state = 0;//回访状态 0-未回访 1-一呼 2-二呼 3-三呼 4-其他
	private int buycar_emergency = -1;//购车紧急度  -1-全部
	private int is_key_cus = -1;//客户类型 -1 全部  0-普通客户  1-重点客户
	private int phoneerror = 0;//电话能否接通 0-全部  1-未接通
	private int provId = 0;//推广省份
	private int cityId = 0;//推广城市
	private int prov3 = -1;
	private int city3 = -1;
	private int brandId = 0;//推广品牌
	private int chexiId = 0;//推广车系
	private int chexiId3 = 0;//推广车系
	private int chexingId = 0;//推广车型
	private String pro_num = "";//推广编号
	private int flag = 0;//0-初次进入 1-后续进入
	private int count = 0;//数据总量
	private int switchRadio = 0;
	List<Map<String, String>> kctList ;
	private TbDataBaoming baoming;
	private String pro_state = "";
	private int apply_source = -1;
	private int buy_status = -1;
	
public String kctmanageQuery() throws SQLException, ParseException{
	String pro_nums = (String) session.get("pro_nums");
	
	String uleve = (String) session.get("ulevel");
	
	String prov = (String) session.get("prov");
	
	String city = (String) session.get("city");
	
	String brands = (String) session.get("brands");
	
	String sub_sites_id = (String)session.get("siteid");
	
	String citys = "";
	
	String provs = "";
	
	String pro_numid = request.getParameter("pro_numid");
	
	if(!"0".equals(sub_sites_id)){
		List<Map<String,Object>> siteList = BaomingService.getInstance().querySub(sub_sites_id);
		
		Map<String,Object> sites = siteList.get(0);
		
		//int i = (Integer)sites.get("id");
		int chid = (Integer)sites.get("chid");
		String fpid = (String)sites.get("fpid");
		int catalogid = (Integer)sites.get("catalogid");
		int fatherid = (Integer)sites.get("fatherid");
		//DboAreCatalog area = AdminService.getInstance().getProvId(i+"");
		
		int pid =  fatherid==0? catalogid:fatherid;
		
		if(pid == 9){
			provs = "";
		}else if(pid==1||pid ==2){
			
			provs = " and = "+pid;
		}
		
		
//		if("11".equals(sub_sites_id)||"12".equals(sub_sites_id)||"8".equals(sub_sites_id))
//			secques = cid+"";
		if(1==chid || 0==chid){
//			String city1  = "";
//			List<Map<String, Object>> maps = BaomingService.getInstance().queryFchid(fpid,(pid+""));
//			if(maps.size()>0){
//				for(int j=0;j<maps.size();j++){
//					Map<String,Object> map2 = maps.get(j);
//					if(j!=0){
//						city1 += " and ";
//						
//					}
//					city1 += " city<>"+map2.get("catalogid");
//				
//				}
//				citys = " and ("+city1+")";
//				
//			}
			citys = " and city in ("+fpid+")";
		}
//		
		}
//	
	//iwayList = BaomingService.getInstance().queryIwayInfo(brands);
	
	int pstatus = 1;
	
	int prefIndex = size * (page - 1);
	tuiguangList = BaomingService.getInstance().queryTuiguangInfo(pro_nums,uleve,pstatus);
	tuiguangListStr = JSONArray.fromObject(tuiguangList).toString();
	if(switchRadio == 0){
	if(tuiguangList.size() == 0)
		return SUCCESS;
	}
	//初次进入
	if(flag == 0){
		if(beginDate == null)
			beginDate = getBeginDatex();
		if(endDate == null)
			endDate = getEndDatex();
		if(promo_start_date == null)
			promo_start_date = tuiguangList.get(0).get("promo_start_date").toString();
		if(promo_end_date == null)
			promo_end_date = tuiguangList.get(0).get("promo_end_date").toString();
		provId = Integer.valueOf(tuiguangList.get(0).get("provId").toString());
		cityId = Integer.valueOf(tuiguangList.get(0).get("cityId").toString());
		brandId = Integer.valueOf(tuiguangList.get(0).get("brandId").toString());
		chexiId = Integer.valueOf(tuiguangList.get(0).get("chexiId").toString());
		chexingId = Integer.valueOf(tuiguangList.get(0).get("chexingId").toString());
		iway2 = tuiguangList.get(0).get("iway").toString();
		competing = tuiguangList.get(0).get("competing").toString();
		pro_state = tuiguangList.get(0).get("pro_state").toString();
	}
	
	if(null!=pro_numid && !"".equals(pro_numid)){
		List<Map<String, String>> tuiguangLists = BaomingService.getInstance().queryTuiguangInfoByPro(pro_nums,uleve,pstatus,pro_numid);
		pro_num = pro_numid;
		if(beginDate == null)
			beginDate = getBeginDatex();
		if(endDate == null)
			endDate = getEndDatex();
		if(promo_start_date == null)
			promo_start_date = tuiguangLists.get(0).get("promo_start_date").toString();
		if(promo_end_date == null)
			promo_end_date = tuiguangLists.get(0).get("promo_end_date").toString();
		provId = Integer.valueOf(tuiguangLists.get(0).get("provId").toString());
		cityId = Integer.valueOf(tuiguangLists.get(0).get("cityId").toString());
		brandId = Integer.valueOf(tuiguangLists.get(0).get("brandId").toString());
		chexiId = Integer.valueOf(tuiguangLists.get(0).get("chexiId").toString());
		chexingId = Integer.valueOf(tuiguangLists.get(0).get("chexingId").toString());
		competing = tuiguangLists.get(0).get("competing").toString();
		iway2 = tuiguangLists.get(0).get("iway").toString();
		pro_state = tuiguangList.get(0).get("pro_state").toString();
	}
	
	if(switchRadio == 1){
		String begin = "";
		String end = "";
		if(beginDate == null || "".equals(beginDate)){
			beginDate = getBeginDatex();
			begin = getBeginDatex();
		}else{
			begin = beginDate;
		}
		if(endDate == null || "".equals(endDate)){
			end = getEndDatex();
			endDate = getEndDatex();
		}else{
			end = endDate;
		}
		
		kctList =  BaomingService.getInstance().queryKCTBaoming2(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, prov, city, brands,  prefIndex, size,iway,iserial);
		count = BaomingService.getInstance().queryKCTBaoming2Count(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, prov, city, brands,iway,iserial);
		
		if(count%size == 0)
			pages = count/size;
		else
			pages = count/size + 1;
		
	}else{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//判断日期是否合法
		if(checkDate(beginDate)&&checkDate(endDate)&&checkDate(promo_start_date)&&checkDate(promo_end_date)){
			String begin = "";
			String end = "";
			if(sdf.parse(beginDate).compareTo(sdf.parse(promo_start_date))> 0)
				begin = beginDate;
			else
				begin = promo_start_date;
			
			if(sdf.parse(endDate).compareTo(sdf.parse(promo_end_date)) > 0)
				end = promo_end_date;
			else
				end = endDate;
			
			if("100".equals(pro_state)){
				
				if(null == competing || "".equals(competing)){
					kctList =  BaomingService.getInstance().queryKCTBaoming01(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId, prefIndex, size,iway2,prov3,city3,chexiId3,iway3,pro_state,provs,citys,apply_source,buy_status);
					count = BaomingService.getInstance().queryKCTBaomingCount01(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId,iway2,prov3,city3,chexiId3,iway3,pro_state,provs,citys,apply_source,buy_status);
				
				}else{
					kctList =  BaomingService.getInstance().queryKCTBaoming31(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId, prefIndex, size,competing,iway2,prov3,city3,chexiId3,iway3,pro_state,provs,citys,apply_source,buy_status);
					count = BaomingService.getInstance().queryKCTBaomingCount31(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId,competing,iway2,prov3,city3,chexiId3,iway3,pro_state,provs,citys,apply_source,buy_status);
				}
				
			}else{
			
				if(null == competing || "".equals(competing)){
					kctList =  BaomingService.getInstance().queryKCTBaoming(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId, prefIndex, size,iway2,prov3,city3,chexiId3,iway3,apply_source,buy_status);
					count = BaomingService.getInstance().queryKCTBaomingCount(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId,iway2,prov3,city3,chexiId3,iway3,apply_source,buy_status);
				
				}else{
					kctList =  BaomingService.getInstance().queryKCTBaoming3(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId, prefIndex, size,competing,iway2,prov3,city3,chexiId3,iway3,apply_source,buy_status);
					count = BaomingService.getInstance().queryKCTBaomingCount3(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId,competing,iway2,prov3,city3,chexiId3,iway3,apply_source,buy_status);
				}
			
			}
			
			
			if(count%size == 0)
				pages = count/size;
			else
				pages = count/size + 1;
			
		}	
	}
		return SUCCESS;
	}

public void export() throws SQLException, ParseException, IOException{
	String pro_nums = (String) session.get("pro_nums");
	
	String uleve = (String) session.get("ulevel");
	
	String prov = (String) session.get("prov");
	
	String city = (String) session.get("city");
	
	String brands = (String) session.get("brands");
	
	String sub_sites_id = (String)session.get("siteid");
	
	String citys = "";
	
	String provs = "";
	
	String pro_numid = request.getParameter("pro_numid");
	
	if(!"0".equals(sub_sites_id)){
		List<Map<String,Object>> siteList = BaomingService.getInstance().querySub(sub_sites_id);
		
		Map<String,Object> sites = siteList.get(0);
		
		//int i = (Integer)sites.get("id");
		int chid = (Integer)sites.get("chid");
		String fpid = (String)sites.get("fpid");
		int catalogid = (Integer)sites.get("catalogid");
		int fatherid = (Integer)sites.get("fatherid");
		//DboAreCatalog area = AdminService.getInstance().getProvId(i+"");
		
		int pid =  fatherid==0? catalogid:fatherid;
		
		if(pid == 9){
			provs = "";
		}else if(pid==1||pid ==2){
			
			provs = " and prov = "+pid;
		}
		
		
//		if("11".equals(sub_sites_id)||"12".equals(sub_sites_id)||"8".equals(sub_sites_id))
//			secques = cid+"";
		if(1==chid || 0==chid){
//			String city1  = "";
//			List<Map<String, Object>> maps = BaomingService.getInstance().queryFchid(fpid,(pid+""));
//			if(maps.size()>0){
//				for(int j=0;j<maps.size();j++){
//					Map<String,Object> map2 = maps.get(j);
//					if(j!=0){
//						city1 += " and ";
//						
//					}
//					city1 += " city<>"+map2.get("catalogid");
//				
//				}
//				citys = " and ("+city1+")";
//				
//			}
			citys = " and city in ("+fpid+")";
		}
//		
		}
	
	
//	
	//iwayList = BaomingService.getInstance().queryIwayInfo(brands);
	
	int pstatus = 1;
	
	int prefIndex = size * (page - 1);
	tuiguangList = BaomingService.getInstance().queryTuiguangInfo(pro_nums,uleve,pstatus);
	tuiguangListStr = JSONArray.fromObject(tuiguangList).toString();
	if(switchRadio == 0){
	if(tuiguangList.size() == 0)
		return ;
	}
	//初次进入
	if(flag == 0){
		if(beginDate == null)
			beginDate = getBeginDatex();
		if(endDate == null)
			endDate = getEndDatex();
		if(promo_start_date == null)
			promo_start_date = tuiguangList.get(0).get("promo_start_date").toString();
		if(promo_end_date == null)
			promo_end_date = tuiguangList.get(0).get("promo_end_date").toString();
		provId = Integer.valueOf(tuiguangList.get(0).get("provId").toString());
		cityId = Integer.valueOf(tuiguangList.get(0).get("cityId").toString());
		brandId = Integer.valueOf(tuiguangList.get(0).get("brandId").toString());
		chexiId = Integer.valueOf(tuiguangList.get(0).get("chexiId").toString());
		chexingId = Integer.valueOf(tuiguangList.get(0).get("chexingId").toString());
		iway2 = tuiguangList.get(0).get("iway").toString();
		competing = tuiguangList.get(0).get("competing").toString();
	}
	
	if(null!=pro_numid && !"".equals(pro_numid)){
		List<Map<String, String>> tuiguangLists = BaomingService.getInstance().queryTuiguangInfoByPro(pro_nums,uleve,pstatus,pro_numid);
		pro_num = pro_numid;
		if(beginDate == null)
			beginDate = getBeginDatex();
		if(endDate == null)
			endDate = getEndDatex();
		if(promo_start_date == null)
			promo_start_date = tuiguangLists.get(0).get("promo_start_date").toString();
		if(promo_end_date == null)
			promo_end_date = tuiguangLists.get(0).get("promo_end_date").toString();
		provId = Integer.valueOf(tuiguangLists.get(0).get("provId").toString());
		cityId = Integer.valueOf(tuiguangLists.get(0).get("cityId").toString());
		brandId = Integer.valueOf(tuiguangLists.get(0).get("brandId").toString());
		chexiId = Integer.valueOf(tuiguangLists.get(0).get("chexiId").toString());
		chexingId = Integer.valueOf(tuiguangLists.get(0).get("chexingId").toString());
		competing = tuiguangLists.get(0).get("competing").toString();
		iway2 = tuiguangLists.get(0).get("iway").toString();
	}
	
	if(switchRadio == 1){
		String begin = "";
		String end = "";
		if(beginDate == null || "".equals(beginDate)){
			beginDate = getBeginDatex();
			begin = getBeginDatex();
		}else{
			begin = beginDate;
		}
		if(endDate == null || "".equals(endDate)){
			end = getEndDatex();
			endDate = getEndDatex();
		}else{
			end = endDate;
		}
		
		kctList =  BaomingService.getInstance().queryKCTBaoming2(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, prov, city, brands,  0, 10000,iway,iserial);
		
		
	}else{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//判断日期是否合法
		if(checkDate(beginDate)&&checkDate(endDate)&&checkDate(promo_start_date)&&checkDate(promo_end_date)){
			String begin = "";
			String end = "";
			if(sdf.parse(beginDate).compareTo(sdf.parse(promo_start_date))> 0)
				begin = beginDate;
			else
				begin = promo_start_date;
			
			if(sdf.parse(endDate).compareTo(sdf.parse(promo_end_date)) > 0)
				end = promo_end_date;
			else
				end = endDate;
			
			if("100".equals(pro_state)){
				
				if(null == competing || "".equals(competing)){
					kctList =  BaomingService.getInstance().queryKCTBaoming01(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId, prefIndex, size,iway2,prov3,city3,chexiId3,iway3,pro_state,provs,citys,apply_source,buy_status);
					count = BaomingService.getInstance().queryKCTBaomingCount01(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId,iway2,prov3,city3,chexiId3,iway3,pro_state,provs,citys,apply_source,buy_status);
				
				}else{
					kctList =  BaomingService.getInstance().queryKCTBaoming31(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId, prefIndex, size,competing,iway2,prov3,city3,chexiId3,iway3,pro_state,provs,citys,apply_source,buy_status);
					count = BaomingService.getInstance().queryKCTBaomingCount31(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId,competing,iway2,prov3,city3,chexiId3,iway3,pro_state,provs,citys,apply_source,buy_status);
				}
				
			}else{
			
				if(null == competing || "".equals(competing)){
					kctList =  BaomingService.getInstance().queryKCTBaoming(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId, prefIndex, size,iway2,prov3,city3,chexiId3,iway3,apply_source,buy_status);
					count = BaomingService.getInstance().queryKCTBaomingCount(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId,iway2,prov3,city3,chexiId3,iway3,apply_source,buy_status);
				
				}else{
					kctList =  BaomingService.getInstance().queryKCTBaoming3(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId, prefIndex, size,competing,iway2,prov3,city3,chexiId3,iway3,apply_source,buy_status);
					count = BaomingService.getInstance().queryKCTBaomingCount3(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId,competing,iway2,prov3,city3,chexiId3,iway3,apply_source,buy_status);
				}
			
			}
			
		}	
	}
	HttpServletResponse response = ServletActionContext.getResponse();
	exportExcel(response,kctList);
	}
String getBeginDatex(){
	String beginDate = "";
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	Calendar calendar = new GregorianCalendar(); 
    calendar.setTime(date); 
	//calendar.add(calendar.DATE,-7);
	date=calendar.getTime();
	beginDate = sdf.format(date);
	return beginDate;
}
String getEndDatex(){
	String endDate = "";
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date date=new Date();
	endDate = sdf.format(date);
	return endDate;
}
boolean checkDate(String date){
	boolean flag = false;
	if(date  == null){
		flag = false;
		return flag;
	}
	String reg = "([0-9]{4}-[0-9]{2}-[0-9]{2})";
	flag= Pattern.matches(reg, date);
	return flag;
}
public int getPage() {
	return page;
}
public void setPage(int page) {
	this.page = page;
}
public int getPages() {
	return pages;
}
public void setPages(int pages) {
	this.pages = pages;
}
public int getSize() {
	return size;
}
public void setSize(int size) {
	this.size = size;
}
public List<Map<String, String>> getTuiguangList() {
	return tuiguangList;
}
public void setTuiguangList(List<Map<String, String>> tuiguangList) {
	this.tuiguangList = tuiguangList;
}
public String getTuiguangListStr() {
	return tuiguangListStr;
}
public void setTuiguangListStr(String tuiguangListStr) {
	this.tuiguangListStr = tuiguangListStr;
}
public List<Map<String, String>> getIwayList() {
	return iwayList;
}
public void setIwayList(List<Map<String, String>> iwayList) {
	this.iwayList = iwayList;
}
public String getIway() {
	return iway;
}
public void setIway(String iway) {
	this.iway = iway;
}
public String getIway2() {
	return iway2;
}
public void setIway2(String iway2) {
	this.iway2 = iway2;
}
public String getIway3() {
	return iway3;
}
public void setIway3(String iway3) {
	this.iway3 = iway3;
}
public int getIserial() {
	return iserial;
}
public void setIserial(int iserial) {
	this.iserial = iserial;
}
public String getCompeting() {
	return competing;
}
public void setCompeting(String competing) {
	this.competing = competing;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getBeginDate() {
	return beginDate;
}
public void setBeginDate(String beginDate) {
	this.beginDate = beginDate;
}
public String getEndDate() {
	return endDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
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
public int getReturn_visit_state() {
	return return_visit_state;
}
public void setReturn_visit_state(int return_visit_state) {
	this.return_visit_state = return_visit_state;
}
public int getBuycar_emergency() {
	return buycar_emergency;
}
public void setBuycar_emergency(int buycar_emergency) {
	this.buycar_emergency = buycar_emergency;
}
public int getIs_key_cus() {
	return is_key_cus;
}
public void setIs_key_cus(int is_key_cus) {
	this.is_key_cus = is_key_cus;
}
public int getPhoneerror() {
	return phoneerror;
}
public void setPhoneerror(int phoneerror) {
	this.phoneerror = phoneerror;
}
public int getProvId() {
	return provId;
}
public void setProvId(int provId) {
	this.provId = provId;
}
public int getCityId() {
	return cityId;
}
public void setCityId(int cityId) {
	this.cityId = cityId;
}
public int getProv3() {
	return prov3;
}
public void setProv3(int prov3) {
	this.prov3 = prov3;
}
public int getCity3() {
	return city3;
}
public void setCity3(int city3) {
	this.city3 = city3;
}
public int getBrandId() {
	return brandId;
}
public void setBrandId(int brandId) {
	this.brandId = brandId;
}
public int getChexiId() {
	return chexiId;
}
public void setChexiId(int chexiId) {
	this.chexiId = chexiId;
}
public int getChexiId3() {
	return chexiId3;
}
public void setChexiId3(int chexiId3) {
	this.chexiId3 = chexiId3;
}
public int getChexingId() {
	return chexingId;
}
public void setChexingId(int chexingId) {
	this.chexingId = chexingId;
}
public String getPro_num() {
	return pro_num;
}
public void setPro_num(String pro_num) {
	this.pro_num = pro_num;
}
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public int getSwitchRadio() {
	return switchRadio;
}
public void setSwitchRadio(int switchRadio) {
	this.switchRadio = switchRadio;
}
public List<Map<String, String>> getKctList() {
	return kctList;
}
public void setKctList(List<Map<String, String>> kctList) {
	this.kctList = kctList;
}
public TbDataBaoming getBaoming() {
	return baoming;
}
public void setBaoming(TbDataBaoming baoming) {
	this.baoming = baoming;
}
public String getPro_state() {
	return pro_state;
}

public void setPro_state(String pro_state) {
	this.pro_state = pro_state;
}

public int getApply_source() {
	return apply_source;
}

public void setApply_source(int apply_source) {
	this.apply_source = apply_source;
}

public int getBuy_status() {
	return buy_status;
}

public void setBuy_status(int buy_status) {
	this.buy_status = buy_status;
}

@SuppressWarnings("deprecation")
public void exportExcel(HttpServletResponse response,List<Map<String, String>> kctList2) throws IOException{
	Date now = new Date(); 
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
    String hehe = dateFormat.format( now ); 
	OutputStream os = response.getOutputStream();// 取得输出流   
    response.reset();// 清空输出流   
    response.setHeader("Content-disposition", "attachment;filename=" + java.net.URLEncoder.encode("看车团报名信息"+hehe+".xls", "UTF-8"));
    response.setContentType("application/msexcel");// 定义输出类型 
   
	 // 第一步，创建一个webbook，对应一个Excel文件  
   HSSFWorkbook wb = new HSSFWorkbook();  
   // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
   HSSFSheet sheet = wb.createSheet("看车团报名信息表"); 
   sheet.setColumnWidth(0, 20 * 256);
   sheet.setColumnWidth(1, 20 * 256);  
   sheet.setColumnWidth(2, 20 * 256);  
   sheet.setColumnWidth(3, 20 * 256);  
   sheet.setColumnWidth(4, 20 * 256);  
   // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
   HSSFRow row = sheet.createRow((int) 0);  
   // 第四步，创建单元格，并设置值表头 设置表头居中  
   HSSFCellStyle style = wb.createCellStyle();  
   style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  

   HSSFCell cell = row.createCell((short) 0);  
   cell.setCellValue("姓名");  
   cell.setCellStyle(style);  
   cell = row.createCell((short) 1);  
   cell.setCellValue("电话");  
   cell.setCellStyle(style);  
   cell = row.createCell((short) 2);  
   cell.setCellValue("报名时间");  
   cell.setCellStyle(style);  
   cell = row.createCell((short) 3);  
   cell.setCellValue("报名地区");  
   cell.setCellStyle(style);  
   cell = row.createCell((short) 4);  
   cell.setCellValue("报名车系");  
   cell.setCellStyle(style); 
   cell = row.createCell((short) 5);  
   cell.setCellValue("回访记录");  
   cell.setCellStyle(style); 

   for (int i = 0; i < kctList2.size(); i++)  
   {  
       row = sheet.createRow((int) i + 1);  
       Map<String,String> map =(Map<String, String>) kctList2.get(i);  
       // 第四步，创建单元格，并设置值  
       row.createCell((short) 0).setCellValue( map.get("name"));  
       row.createCell((short) 1).setCellValue(map.get("phone"));  
       row.createCell((short) 2).setCellValue(map.get("baoming_date"));  
       row.createCell((short) 3).setCellValue(map.get("provName")+" "+map.get("cityName"));  
       row.createCell((short) 4).setCellValue(map.get("brandName")+" "+map.get("chexiName"));  
       row.createCell((short) 5).setCellValue(map.get("remarks"));  
       cell = row.createCell((short) 6);  
   }  
   // 第六步，将文件存到指定位置  
   try  
   { 
   	
       wb.write(os);  
       os.close();  
   }  
   catch (Exception e)  
   {  
       e.printStackTrace();  
   }  
}  
	
	
}


