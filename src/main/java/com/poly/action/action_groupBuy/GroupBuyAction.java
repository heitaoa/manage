package com.poly.action.action_groupBuy;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import car_beans.DboAreCatalog;
import car_beans.TbApplyDownloadDetail;
import car_beans.TbApplyInfo;

import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.poly.action.MyActionSupport;
import com.poly.service.AdminService;
import com.poly.service.AppInfoService;
import com.poly.service.AppInfoService.Cusintention;
import com.poly.service.AppInfoService.SourceType;

public class GroupBuyAction extends MyActionSupport {
	int id;
	private int page = 1;
	private int pages = 1;
	private int rows = 20;
	private int count;
	private String beginDate="";
	private String endDate="";
	private String name="";
	private String phone = "";
	private String beginOrderDate="";
	private String endOrderDate="";
	private int isBuy=-1;
	private int phoneState=-1;
	private int carId = -1;
	private int chexiId = -1;
	private int chexingId = -1;
	private int againReturnVisit;
	private int prov = -1;
	private int city = -1;
	private int type = -1;
	private String rvman="-1";
	private List<HashMap<String, Object>> applyInfo;
	private Map<String, Object> detail;
	private TbApplyInfo tbApplyInfo;
	private InputStream excelFile;
	private String downloadFileName;
	private int start;
	private String spaceid;
	private String level;
	private int typex=-1;
	private int againType=-1;
	private String last_update_time;
	private String secques;
	private String barndName = "-1";
	private int cityflag;
	private int chexiidx;
	private String brandFlag ="";
	private String aid;
	private String deleteContent;
	private String brands="";
	private String is_key_cus = "-1";
	private String visit_type = "-1";
	private String cus_intention = "-1";
	private String sub_sites_id = "1";
	private String sub_sites_id2 = "1";
	private String data;
	private String rvmanStr;
	private String userid = "";
	private List<HashMap<String, Object>> siteInfo;
	public String execute(){
		changePage();
		//System.err.println(name);
		return SUCCESS;
	}
	private void setRole(){
		Map<String,Object> map = (Map<String, Object>) session.get("userInfo");
		sub_sites_id = map.get("sub_sites_id")+"";
		sub_sites_id2 = map.get("sub_sites_id2")+"";
		spaceid = (String) map.get("prov");
		level = (String) map.get("ulevel");
		secques = (String)map.get("city");
		userid = (String)map.get("userid");
		if(level.contains("2")||level.contains("3")||level.contains("6")){
			DboAreCatalog area = AdminService.getInstance().getProvId(sub_sites_id);
			int pid =  area.getFatherid()==0? area.getCatalogid():area.getFatherid();
			int cid =  area.getFatherid()==0? -1:area.getCatalogid();
			spaceid = pid+"";
			if("11".equals(sub_sites_id)||"12".equals(sub_sites_id)||"8".equals(sub_sites_id))
				secques = cid+"";
		}
		if ("".equals((String)map.get("brands"))){
			brandFlag = "0";
		}
		else {
			brands = ((String)map.get("brands"));
			brandFlag = "1";
		}
		if("1".equals(brandFlag)&&"-1".equals(barndName))
			barndName = "-2";
	}
	private void changePage(){
		last_update_time = AppInfoService.getInstance().getLast_update_time(type);
		setRole();
		if(level.contains("2")||level.contains("3")||level.contains("6")){
			prov = Integer.parseInt(spaceid);
			if(city == -1)
				city = Integer.parseInt(secques);
			if(Integer.parseInt(secques)!=-1)
				cityflag = 1;
		}
		//System.err.println(prov);
		//System.err.println(city);
		start = rows * (page - 1);
		applyInfo = AppInfoService.getInstance().listApplyInfo(start,rows,beginDate,endDate,name,phone.trim(),beginOrderDate,endOrderDate,isBuy,phoneState,barndName,chexiId,againReturnVisit,prov,city,type,againType,brands,is_key_cus,cus_intention);
		//applyInfo = AppInfoService.getInstance().listApplyInfo(0, 10, "", "", "", "", "1900-1-1", "2015-1-1", 0, 0, -1, -1, 0, -1, -1);
		if(applyInfo.size()>0){
			count = (Integer) applyInfo.get(0).get("count");
		}
		//System.err.println(count);
		pages = count / rows;
		if (count % rows != 0) {
			pages++;
		}
	}
	private void  changePage2(){
		last_update_time = AppInfoService.getInstance().getLast_update_time(type);
		setRole();
		start = rows * (page - 1);
		if(level.contains("2")||level.contains("3")||level.contains("6")){
			prov = Integer.parseInt(spaceid);
			if(city == -1)
				city = Integer.parseInt(secques);
			if(Integer.parseInt(secques)!=-1)
				cityflag = 1;
		}
		//applyInfo = AppInfoService.getInstance().listApplyInfo(start,rows,beginDate,endDate,name,phone,beginOrderDate,endOrderDate,isBuy,phoneState,carId,chexiId,againReturnVisit,prov,city,type);
		applyInfo = AppInfoService.getInstance().listApply(start, rows, barndName, chexiId, prov, city, beginDate, endDate, name, phone.trim(), rvman,type,typex,brands,is_key_cus,visit_type,beginOrderDate,endOrderDate,cus_intention);
		//applyInfo = AppInfoService.getInstance().listApplyInfo(0, 10, "", "", "", "", "1900-1-1", "2015-1-1", 0, 0, -1, -1, 0, -1, -1);
		if(applyInfo.size()>0){
			count = (Integer) applyInfo.get(0).get("count");
		}
		//System.err.println(count);
		pages = count / rows;
		if (count % rows != 0) {
			pages++;
		}
		
	}
	private void  changePage3(){
		last_update_time = AppInfoService.getInstance().getLast_update_time(type);
		setRole();
		if(level.contains("2")||level.contains("3")||level.contains("6")){
			prov = Integer.parseInt(spaceid);
			if(city == -1)
				city = Integer.parseInt(secques);
			if(Integer.parseInt(secques)!=-1)
				cityflag = 1;
		}
		//System.err.println(prov);
		start = rows * (page - 1);
		applyInfo = AppInfoService.getInstance().listRev(start, rows, beginDate, endDate, barndName, chexiId, prov, city, type, rvman,typex,brands);
		if(applyInfo.size()>0){
			count = (Integer) applyInfo.get(0).get("count");
		}
		//System.err.println(count);
		pages = count / rows;
		if (count % rows != 0) {
			pages++;
		}
	}
	public void getCityInfo() throws IOException{
		List<DboAreCatalog> info = AppInfoService.getInstance().getCityInfo(city);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(info);
		String jsonp=request.getParameter("jsonpcallback");
		out.print(jsonp+"("+json.toString()+")");
	}
	public void getDetails() throws IOException{
		detail = AppInfoService.getInstance().getDetail(id);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONObject  json = JSONObject.fromObject(detail);
		String jsonp=request.getParameter("jsonpcallback");
		out.print(jsonp+"("+json.toString()+")");
	}
	public void getCheXing() throws IOException{
		List<HashMap<String, Object>> info = AppInfoService.getInstance().getCheXing(carId);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(info);
		String jsonp=request.getParameter("jsonpcallback");
		out.print(jsonp+"("+json.toString()+")");
	}
	public void saveApply() throws IOException{
		Map<String,Object> map = (Map<String, Object>) session.get("userInfo");
		Date date = new Date();
		String man =  map.get("username").toString();
		tbApplyInfo.setReturn_visit_state(1);
		tbApplyInfo.setReturn_visit_time(date);
		tbApplyInfo.setReturn_visit_man(man);
		//System.err.println(tbApplyInfo.getCus_intention());
		String remarks = "";
		String content = tbApplyInfo.getReturn_visit_content();
		if("".equals(content.trim()))
			content = "未填写";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		String carName = AppInfoService.getInstance().getCarName(tbApplyInfo.getCarid()+"");
		remarks = man+"  "+sdf.format(date)+"  "+ content+"("+carName+")<br>";
		tbApplyInfo.setRemarks(tbApplyInfo.getRemarks()+remarks);
		//System.err.println(tbApplyInfo.getRemarks());
		int result =  AppInfoService.getInstance().updateApply(tbApplyInfo);
		//detail = AppInfoService.getInstance().getDetail(id);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		out.print(result);
		
	}
	
	public void tuisong() throws IOException{
		int result =  AppInfoService.getInstance().tuisong(tbApplyInfo);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		out.print(result);
	}
	
	public void getRevman() throws IOException{
		setRole();
		List<HashMap<String, Object>> info = AppInfoService.getInstance().getRevman(level,sub_sites_id2);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(info);
		String jsonp=request.getParameter("jsonpcallback");
		//System.err.println(jsonp.toString());
		out.print(jsonp+"("+json.toString()+")");
	}
	public String groupBuyApply(){
		changePage2();
		return SUCCESS;
	}
	public void  downBaoming() throws Exception{
		setRole();
		if(level.contains("2")||level.contains("3")||level.contains("6")){
			prov = Integer.parseInt(spaceid);
			if(city == -1)
				city = Integer.parseInt(secques);
			if(Integer.parseInt(secques)!=-1)
				cityflag = 1;
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd ");
		downloadFileName ="报名信息_"+ (sf.format(new Date()).toString()).trim()+".xls";
		String newName = (sf.format(new Date()).toString()).trim()+".xls";
		if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
			newName = new String(downloadFileName.getBytes("UTF-8"), "ISO8859-1");
		} else {
			if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0)
				newName = URLEncoder.encode(downloadFileName, "UTF-8");
			else if (request.getHeader("User-Agent").toUpperCase().indexOf("CHROME") > 0) 
				newName = new String(downloadFileName.getBytes("UTF-8"), "ISO8859-1");
		}
		response.setContentType("application/msexcel;charset=gbk");
		response.setHeader("Content-Disposition", "attachment;filename="+newName);
		response.addHeader("Pargam", "no-cache");
		response.addHeader("Cache-Control", "no-cache");
		applyInfo = AppInfoService.getInstance().downBaoming(barndName, chexiId, prov, city, beginDate, endDate, name, phone.trim(), rvman, type ,typex,brands,is_key_cus,visit_type,beginOrderDate,endOrderDate,cus_intention);
		
		String sql = AppInfoService.getInstance().getDownLoadSql(barndName, chexiId, prov, city, beginDate, endDate, name, phone.trim(), rvman, type ,typex,brands,is_key_cus,visit_type,beginOrderDate,endOrderDate,cus_intention);
		TbApplyDownloadDetail detail = new TbApplyDownloadDetail();
		detail.setAppenddate(new Date());
		detail.setCount(applyInfo.size());
		detail.setQuerysql(sql);
		detail.setUserid(userid);
		AppInfoService.getInstance().saveDownloadDetail(detail);
		
		String fi = GroupExcelAction.class.getResource("/").getPath()
				.replace("classes/", "template")
				+ "/excel/applytemplate.xls";
		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fi));
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(0);
		for (int i = 0; i < applyInfo.size(); i++) {
			HSSFRow row = sheet.createRow(i + 2);
			HSSFCell cell = row.createCell(9); 
			cell = row.createCell(0);
			cell.setCellValue(i+1);
			cell = row.createCell(1);
			cell.setCellValue(applyInfo.get(i).get("name").toString());
			cell = row.createCell(2);
			cell.setCellValue(applyInfo.get(i).get("appdate").toString());
			cell = row.createCell(3);
			cell.setCellValue(applyInfo.get(i).get("phone").toString());
			cell = row.createCell(4);
			cell.setCellValue(applyInfo.get(i).get("phone_state").toString());
			cell = row.createCell(5);
			cell.setCellValue(applyInfo.get(i).get("app_prov").toString()+" "+applyInfo.get(i).get("app_city").toString());
			cell = row.createCell(6);
			cell.setCellValue(applyInfo.get(i).get("phone_prov").toString()+" "+applyInfo.get(i).get("phone_city").toString());
			cell = row.createCell(7);
			cell.setCellValue(applyInfo.get(i).get("pingpai")==null? "":applyInfo.get(i).get("pingpai").toString());
			cell = row.createCell(8);
			cell.setCellValue(applyInfo.get(i).get("chexi")==null?"" :applyInfo.get(i).get("chexi").toString());
			cell = row.createCell(9);
			String chexing = applyInfo.get(i).get("chexing")==null?"":applyInfo.get(i).get("chexing").toString();
			cell.setCellValue(chexing);
			cell = row.createCell(10);
			cell.setCellValue(applyInfo.get(i).get("remarks").toString().replaceAll("<br>", "\r\n"));
			cell = row.createCell(11);
			cell.setCellValue(Cusintention.getEnum(applyInfo.get(i).get("cus_intention").toString()).getType());
			cell = row.createCell(12);
			cell.setCellValue(applyInfo.get(i).get("cus_intention").toString());
			cell = row.createCell(13);
			cell.setCellValue(applyInfo.get(i).get("is_key_cus").toString());
			cell = row.createCell(14);
			cell.setCellValue(SourceType.getEnum(applyInfo.get(i).get("type").toString()).getType());
		}
		wb.write(response.getOutputStream());
	}
	
	public String groupBuyReturnVisit(){
		setRole();
		List<String> rvList = new ArrayList<String>();
		List<HashMap<String, Object>> rvmans = AppInfoService.getInstance().getRevman(level,sub_sites_id);
		for (HashMap<String, Object> map : rvmans) {
			rvList.add(map.get("return_visit_man").toString());
		}
		siteInfo = AppInfoService.getInstance().getsiteCount(beginOrderDate, endOrderDate, spaceid,secques,sub_sites_id);
		applyInfo = AppInfoService.getInstance().getRevCount(beginDate, endDate, rvList);
		data = JSONArray.fromObject(applyInfo).toString();
		rvmanStr = JSONArray.fromObject(rvmans).toString();
		//changePage3();
		//System.err.println(count);
		return SUCCESS;
	}
	public String gotogroupBuyReturnVisit(){
		setRole();
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 Calendar c = Calendar.getInstance();
	     c = Calendar.getInstance();
	     c.set(Calendar.DAY_OF_WEEK, 2);//本周第一天，以星期日开始       
		beginDate = sdf.format(c.getTime());
		endDate = sdf.format(new Date());
		beginOrderDate = beginDate;
		endOrderDate = endDate;
		List<String> rvList = new ArrayList<String>();
		List<HashMap<String, Object>> rvmans = AppInfoService.getInstance().getRevman(level,sub_sites_id);
		for (HashMap<String, Object> map : rvmans) {
			rvList.add(map.get("return_visit_man").toString());
		}
		siteInfo = AppInfoService.getInstance().getsiteCount(beginOrderDate, endOrderDate, spaceid,secques,sub_sites_id);
		applyInfo = AppInfoService.getInstance().getRevCount(beginDate, endDate, rvList);
		data = JSONArray.fromObject(applyInfo).toString();
		rvmanStr = JSONArray.fromObject(rvmans).toString();
		//changePage3();
		//System.err.println(count);
		return SUCCESS;
	}
	public String deleteApply(){
		//System.err.println(aid);
		//System.err.println(deleteContent);
		Map<String,Object> map = (Map<String, Object>) session.get("userInfo");
		String uid = (String)map.get("userid");
		AppInfoService.getInstance().deleteApply(uid,aid,deleteContent,1);
		return SUCCESS;
	}
	public String applyDetailUpdate(){
		Map<String,Object> map = (Map<String, Object>) session.get("userInfo");
		String uid = (String)map.get("userid");
		AppInfoService.getInstance().deleteApply(uid,aid,"恢复操作",0);
		return SUCCESS;
	}
	public String applyDetailUpdate2(){
		Map<String,Object> map = (Map<String, Object>) session.get("userInfo");
		String uid = (String)map.get("userid");
		AppInfoService.getInstance().deleteApply(uid,aid,"恢复操作",0);
		return SUCCESS;
	}
	public String applyDetail(){
		changeDetailPage();
		return SUCCESS;
	}
	public String applyDetail2(){
		changeDetailPage();
		return SUCCESS;
	}
	void changeDetailPage(){
		setRole();
		start = rows * (page - 1);
		Map<String,Object> map = (Map<String, Object>) session.get("userInfo");
		String uid = (String)map.get("userid");
		String level = (String)map.get("ulevel");
		applyInfo = AppInfoService.getInstance().getApplyDetail(start, rows, sub_sites_id,  Integer.parseInt(level),name, beginDate, endDate);
		if(applyInfo.size()>0){
			count = (Integer) applyInfo.get(0).get("count");
		}
		//System.err.println(count);
		pages = count / rows;
		if (count % rows != 0) {
			pages++;
		}
		
	}
	public String getsitCountForAdm(){
		if("".equals(beginDate)||"".equals(endDate)){
			Date now = new Date();
			
			Calendar calendar = new GregorianCalendar(); 
		    calendar.setTime(now); 
			calendar.add(calendar.DATE,-1);
			now = calendar.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			beginDate = sdf.format(now);
			endDate = sdf.format(now);
		}
		applyInfo = AppInfoService.getInstance().getsiteCountForAdm(beginDate, endDate);
		return SUCCESS;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
	public String getBeginOrderDate() {
		return beginOrderDate;
	}
	public void setBeginOrderDate(String beginOrderDate) {
		this.beginOrderDate = beginOrderDate;
	}
	public String getEndOrderDate() {
		return endOrderDate;
	}
	public void setEndOrderDate(String endOrderDate) {
		this.endOrderDate = endOrderDate;
	}
	public int getIsBuy() {
		return isBuy;
	}
	public void setIsBuy(int isBuy) {
		this.isBuy = isBuy;
	}
	public int getPhoneState() {
		return phoneState;
	}
	public void setPhoneState(int phoneState) {
		this.phoneState = phoneState;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getChexiId() {
		return chexiId;
	}
	public void setChexiId(int chexiId) {
		this.chexiId = chexiId;
	}
	public int getAgainReturnVisit() {
		return againReturnVisit;
	}
	public void setAgainReturnVisit(int againReturnVisit) {
		this.againReturnVisit = againReturnVisit;
	}
	public int getProv() {
		return prov;
	}
	public void setProv(int prov) {
		this.prov = prov;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<HashMap<String, Object>> getApplyInfo() {
		return applyInfo;
	}
	public void setApplyInfo(List<HashMap<String, Object>> applyInfo) {
		this.applyInfo = applyInfo;
	}
	public Map<String, Object> getDetail() {
		return detail;
	}
	public void setDetail(Map<String, Object> detail) {
		this.detail = detail;
	}
	public TbApplyInfo getTbApplyInfo() {
		return tbApplyInfo;
	}
	public void setTbApplyInfo(TbApplyInfo tbApplyInfo) {
		this.tbApplyInfo = tbApplyInfo;
	}
	public int getChexingId() {
		return chexingId;
	}
	public void setChexingId(int chexingId) {
		this.chexingId = chexingId;
	}
	public String getRvman() {
		return rvman;
	}
	public void setRvman(String rvman) {
		this.rvman = rvman;
	}
	public InputStream getExcelFile() {
		return excelFile;
	}
	public void setExcelFile(InputStream excelFile) {
		this.excelFile = excelFile;
	}
	public String getDownloadFileName() {
		return downloadFileName;
	}
	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public String getSpaceid() {
		return spaceid;
	}
	public void setSpaceid(String spaceid) {
		this.spaceid = spaceid;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getTypex() {
		return typex;
	}
	public void setTypex(int typex) {
		this.typex = typex;
	}
	public int getAgainType() {
		return againType;
	}
	public void setAgainType(int againType) {
		this.againType = againType;
	}
	public String getLast_update_time() {
		return last_update_time;
	}
	public void setLast_update_time(String last_update_time) {
		this.last_update_time = last_update_time;
	}
	public String getSecques() {
		return secques;
	}
	public void setSecques(String secques) {
		this.secques = secques;
	}
	public String getBarndName() {
		return barndName;
	}
	public void setBarndName(String barndName) {
		this.barndName = barndName;
	}
	public int getCityflag() {
		return cityflag;
	}
	public void setCityflag(int cityflag) {
		this.cityflag = cityflag;
	}
	public int getChexiidx() {
		return chexiidx;
	}
	public void setChexiidx(int chexiidx) {
		this.chexiidx = chexiidx;
	}
	public String getBrandFlag() {
		return brandFlag;
	}
	public void setBrandFlag(String brandFlag) {
		this.brandFlag = brandFlag;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getDeleteContent() {
		return deleteContent;
	}
	public void setDeleteContent(String deleteContent) {
		this.deleteContent = deleteContent;
	}
	
	public String getBrands() {
		return brands;
	}
	public void setBrands(String brands) {
		this.brands = brands;
	}
	public String getIs_key_cus() {
		return is_key_cus;
	}
	public void setIs_key_cus(String is_key_cus) {
		this.is_key_cus = is_key_cus;
	}
	public String getVisit_type() {
		return visit_type;
	}
	public void setVisit_type(String visit_type) {
		this.visit_type = visit_type;
	}
	public String getCus_intention() {
		return cus_intention;
	}
	public void setCus_intention(String cus_intention) {
		this.cus_intention = cus_intention;
	}
	public String getSub_sites_id() {
		return sub_sites_id;
	}
	public void setSub_sites_id(String sub_sites_id) {
		this.sub_sites_id = sub_sites_id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getRvmanStr() {
		return rvmanStr;
	}
	public void setRvmanStr(String rvmanStr) {
		this.rvmanStr = rvmanStr;
	}
	public List<HashMap<String, Object>> getSiteInfo() {
		return siteInfo;
	}
	public void setSiteInfo(List<HashMap<String, Object>> siteInfo) {
		this.siteInfo = siteInfo;
	}


	
}
