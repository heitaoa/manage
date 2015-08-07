package com.poly.action.action_groupBuy;

import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import car_beans.DboAreCatalog;
import car_beans.DboCarCatalognew;
import car_daos.DboAreCatalogDao;
import car_daos.DboCarCatalognewDao;

import com.poly.action.MyActionSupport;
import com.poly.bean.GroupExcelEntity;
import com.poly.service.AdminService;
import com.poly.service.GroupExcelService;

public class GroupExcelAction extends MyActionSupport {
	private String excelName;
	private int prov = -1;
	private int city = -1;
	private String spaceid;
	private String level;
	private String secques;
	private GroupExcelEntity groupExcelEntity;
	private String brands;
	private String sub_sites_id = "1";
	private void setRole(){
		Map<String,Object> map = (Map<String, Object>) session.get("userInfo");
		sub_sites_id = map.get("sub_sites_id")+"";
		spaceid = (String) map.get("prov");
		level = (String) map.get("ulevel");
		secques = (String)map.get("city");
		brands = ((String)map.get("brands"));
	}
	public void signExcel() throws Exception {
		setRole();
		if(level.contains("2")||level.contains("3")||level.contains("6")){
			DboAreCatalog area = AdminService.getInstance().getProvId(sub_sites_id);
			int pid =  area.getFatherid()==0? area.getCatalogid():area.getFatherid();
			int cid =  area.getFatherid()==0? -1:area.getCatalogid();
			spaceid = pid+"";
			if("11".equals(sub_sites_id)||"12".equals(sub_sites_id)||"8".equals(sub_sites_id))
				secques = cid+"";
		}
		if(level.contains("2")||level.contains("3")||level.contains("6")){
			prov = Integer.parseInt(spaceid);
			city = Integer.parseInt(secques);
		}
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		String now = sdf1.format(calendar.getTime());
		String filename = "看车签到表" + now + ".xls";
		String newName = "";
		if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
			newName = new String(filename.getBytes("UTF-8"), "ISO8859-1");
		} else {
			if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0)
				newName = URLEncoder.encode(filename, "UTF-8");
			else if (request.getHeader("User-Agent").toUpperCase().indexOf("CHROME") > 0) 
				newName = new String(filename.getBytes("UTF-8"), "ISO8859-1");
		}
		response.setContentType("application/msexcel;charset=gbk");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ newName);
		response.addHeader("Pargam", "no-cache");
		response.addHeader("Cache-Control", "no-cache");
		List<Map<String, Object>> excelMap = GroupExcelService.getInstance()
				.getGroupApply(groupExcelEntity,prov,city,brands);
		String fi = GroupExcelAction.class.getResource("/").getPath()
				.replace("classes/", "template")
				+ "/excel/signtemplate.xls";
		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fi));
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(0);
		for (int i = 0; i < excelMap.size(); i++) {
			HSSFRow row = sheet.createRow(i + 2);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue(i+1);
			cell = row.createCell(1);
			cell.setCellValue(excelMap.get(i).get("name").toString());
			cell = row.createCell(2);
			String prov = "";
			String city = "";
			List<DboAreCatalog> provlist = DboAreCatalogDao
					.where("catalogid = " + excelMap.get(i).get("prov"));
			if (provlist.size() > 0) {
				prov = provlist.get(0).getCatalogname();
			}
			List<DboAreCatalog> citylist = DboAreCatalogDao
					.where("catalogid = " + excelMap.get(i).get("city"));
			if (citylist.size() > 0) {
				city = citylist.get(0).getCatalogname();
			}
			cell.setCellValue(prov + " " + city);
			cell = row.createCell(3);
			cell.setCellValue(excelMap.get(i).get("phone").toString());
			cell = row.createCell(4);
			cell.setCellValue(excelMap.get(i).get("iway").toString());
			cell = row.createCell(5);
			String catalogName = "";
			List<DboCarCatalognew> catalogNameList = DboCarCatalognewDao
					.where("catalogid = "
							+ excelMap.get(i).get("modelid").toString());
			if (catalogNameList.size() > 0) {
				catalogName = catalogNameList.get(0).getCatalogname();
			}
			cell.setCellValue(catalogName);
			
			cell = row.createCell(6);
			String isatt = "";
			if (("0").equals(excelMap.get(i).get("is_attend").toString())) {
				isatt = "未知";
			}
			if (("1").equals(excelMap.get(i).get("is_attend").toString())) {
				isatt = "跟团到";
			}
			if (("2").equals(excelMap.get(i).get("is_attend").toString())) {
				isatt = "自行到";
			}
			if (("3").equals(excelMap.get(i).get("is_attend").toString())) {
				isatt = "方式待定";
			}
			if (("4").equals(excelMap.get(i).get("is_attend").toString())) {
				isatt = "可能参加";
			}
			if (("5").equals(excelMap.get(i).get("is_attend").toString())) {
				isatt = "不参加";
			}
			cell.setCellValue(isatt);
			cell = row.createCell(7);
			cell = row.createCell(8);
			
		}
		wb.write(response.getOutputStream());
	}

	public void backExcel() throws Exception {
		setRole();
		if(level.contains("2")||level.contains("3")||level.contains("6")){
			DboAreCatalog area = AdminService.getInstance().getProvId(sub_sites_id);
			int pid =  area.getFatherid()==0? area.getCatalogid():area.getFatherid();
			int cid =  area.getFatherid()==0? -1:area.getCatalogid();
			spaceid = pid+"";
			if("11".equals(sub_sites_id)||"12".equals(sub_sites_id)||"8".equals(sub_sites_id))
				secques = cid+"";
		}
		if(level.contains("2")||level.contains("3")||level.contains("6")){
			prov = Integer.parseInt(spaceid);
			city = Integer.parseInt(secques);
		}
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		String now = sdf1.format(calendar.getTime());
		String filename = "报名回访数据" + now + ".xls";
		String newName = "";
		if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
			newName = new String(filename.getBytes("UTF-8"), "ISO8859-1");
		} else {
			if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0)
				newName = URLEncoder.encode(filename, "UTF-8");
			else if (request.getHeader("User-Agent").toUpperCase().indexOf("CHROME") > 0) 
				newName = new String(filename.getBytes("UTF-8"), "ISO8859-1");
		}
		response.setContentType("application/msexcel;charset=gbk");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ newName);
		response.addHeader("Pargam", "no-cache");
		response.addHeader("Cache-Control", "no-cache");
		List<Map<String, Object>> excelMap = GroupExcelService.getInstance()
				.getGroupApply(groupExcelEntity,prov,city,brands);
		String fi = GroupExcelAction.class.getResource("/").getPath()
				.replace("classes/", "template")
				+ "/excel/backtemplate.xls";
		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fi));
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(0);
		for (int i = 0; i < excelMap.size(); i++) {
			HSSFRow row = sheet.createRow(i + 2);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue(i+1);
			cell = row.createCell(2);
			cell.setCellValue(excelMap.get(i).get("appdate").toString());
			cell = row.createCell(1);
			cell.setCellValue(excelMap.get(i).get("name").toString());
			cell = row.createCell(3);
			String prov = "";
			String city = "";
			List<DboAreCatalog> provlist = DboAreCatalogDao
					.where("catalogid = " + excelMap.get(i).get("prov"));
			if (provlist.size() > 0) {
				prov = provlist.get(0).getCatalogname();
			}
			List<DboAreCatalog> citylist = DboAreCatalogDao
					.where("catalogid = " + excelMap.get(i).get("city"));
			if (citylist.size() > 0) {
				city = citylist.get(0).getCatalogname();
			}
			cell.setCellValue(prov + " " + city);
			cell = row.createCell(4);
			cell.setCellValue(excelMap.get(i).get("phone").toString());
			cell = row.createCell(5);
			cell.setCellValue(excelMap.get(i).get("iway").toString());
			cell = row.createCell(6);
			String catalogName = "";
			List<DboCarCatalognew> catalogNameList = DboCarCatalognewDao
					.where("catalogid = "
							+ excelMap.get(i).get("modelid").toString());
			if (catalogNameList.size() > 0) {
				catalogName = catalogNameList.get(0).getCatalogname();
			}
			cell.setCellValue(catalogName);
			cell = row.createCell(7);
			if (excelMap.get(i).get("remarks") != null) {
				cell.setCellValue(excelMap.get(i).get("remarks")
						.toString().replaceAll("<br>", "\r\n"));
			}
			cell = row.createCell(8);
			String isatt = "";
			if (("0").equals(excelMap.get(i).get("is_attend").toString())) {
				isatt = "未知";
			}
			if (("1").equals(excelMap.get(i).get("is_attend").toString())) {
				isatt = "跟团到";
			}
			if (("2").equals(excelMap.get(i).get("is_attend").toString())) {
				isatt = "自行到";
			}
			if (("3").equals(excelMap.get(i).get("is_attend").toString())) {
				isatt = "方式待定";
			}
			if (("4").equals(excelMap.get(i).get("is_attend").toString())) {
				isatt = "可能参加";
			}
			if (("5").equals(excelMap.get(i).get("is_attend").toString())) {
				isatt = "不参加";
			}
			cell.setCellValue(isatt);
			cell = row.createCell(9);
			cell.setCellValue(excelMap.get(i).get("cus_intention").toString());
		}
		wb.write(response.getOutputStream());
	}

	public String getExcelName() {
		return excelName;
	}

	public void setExcelName(String excelName) {
		this.excelName = excelName;
	}

	public GroupExcelEntity getGroupExcelEntity() {
		return groupExcelEntity;
	}

	public void setGroupExcelEntity(GroupExcelEntity groupExcelEntity) {
		this.groupExcelEntity = groupExcelEntity;
	}

}
