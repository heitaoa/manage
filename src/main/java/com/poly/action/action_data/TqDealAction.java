package com.poly.action.action_data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import net.sf.json.JSONArray;

import com.poly.action.MyActionSupport;
import com.poly.service.TiquService;

public class TqDealAction extends MyActionSupport {
	private TiquService tiquService = TiquService.getInstance();
	
	private List<Map<String, String>> proList;
	private List<Map<String, String>> baomingList;
	private String tiqu_num = "";
	private String select_ids = "";
	private int date_count = 0;
	
	public String execute(){
		proList = tiquService.getProListForDeal();
		return SUCCESS;
	}
	
	public void exportData() throws IOException{
//		baomingList = getDataByTiquNum(tiqu_num);
		
		String baoming_ids = select_ids.replace("-", ",");
		baomingList = tiquService.getBaomingListForExport(baoming_ids);
		
		String[] ids = select_ids.split("-");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String downloadName = tiqu_num + "（导出数据）.xls";
		downloadName = new String(downloadName.getBytes("UTF-8"), "ISO8859-1");
		response.setContentType("application/msexcel;charset=gbk");
		response.setHeader("Content-Disposition", "attachment;filename=" + downloadName);
		response.addHeader("Pargam", "no-cache");
		response.addHeader("Cache-Control", "no-cache");
		
		HSSFWorkbook hwb = new HSSFWorkbook();
		HSSFSheet sheet = hwb.createSheet("sheet1");
		sheet.setDefaultColumnWidth(30);
		sheet.setDefaultRowHeight((short) 60);
		
		HSSFRow row = null;
		HSSFCell cell = null;
		row = sheet.createRow(0);
		String[] headers = { "姓名", "手机", "报名时间", "地区", "品牌", "是否回访"};
		for (short i = 0; i < headers.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(headers[i]);
		}
//		for (int i = 0; i < ids.length; i++) {
//			Map<String, String> map = baomingList.get(Integer.parseInt(ids[i]));
//			row = sheet.createRow(i + 1);
//			cell = row.createCell(0);
//			cell.setCellValue(map.get("uname"));
//			cell = row.createCell(1);
//			cell.setCellValue(map.get("phone"));
//			cell = row.createCell(2);
//			cell.setCellValue(map.get("baoming_date"));
//			cell = row.createCell(3);
//			cell.setCellValue(map.get("prov_name") + "--" + map.get("city_name"));
//			cell = row.createCell(4);
//			cell.setCellValue(map.get("car_info"));
//			cell = row.createCell(5);
//			cell.setCellValue(map.get("return_visit_state"));
//		}
		
		Map<String, Map<String, String>> mmap = new HashMap<String, Map<String,String>>();
		for (int i = 0; i < baomingList.size(); i++) {
			Map<String, String> map = baomingList.get(i);
			mmap.put(map.get("baoming_id"), map);
		}
		
		for (int i = 0; i < ids.length; i++) {
			Map<String, String> map = mmap.get(ids[i]);
			row = sheet.createRow(i + 1);
			cell = row.createCell(0);
			cell.setCellValue(map.get("uname"));
			cell = row.createCell(1);
			cell.setCellValue(map.get("phone"));
			cell = row.createCell(2);
			cell.setCellValue(map.get("baoming_date"));
			cell = row.createCell(3);
			cell.setCellValue(map.get("prov_name") + "--" + map.get("city_name"));
			cell = row.createCell(4);
			cell.setCellValue("品牌：" + map.get("brand_name") + "   车系：" + map.get("car_name"));
			cell = row.createCell(5);
			cell.setCellValue(map.get("return_visit_state"));
		}
		
//		for (int i = 0; i < baomingList.size(); i++) {
//			Map<String, String> map = baomingList.get(i);
//			
//		}
		
		OutputStream out = response.getOutputStream();
		hwb.write(out);
		out.close();
		
		tiquService.updateExportCount(tiqu_num);
	}
	
	public void getBaomingData() throws IOException {
		baomingList = getDataByTiquNum(tiqu_num);
		
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(baomingList);
		out.print(json.toString());
	}
	
	public void executeYes() throws IOException{
		String result = tiquService.querenExecute(tiqu_num);
		
		response.setContentType("text/html;charset=gbk");
		response.getWriter().write(result);
	}
	
	private List<Map<String, String>> getDataByTiquNum(String num){
		List<Map<String, String>> resultList = tiquService.getBaomingListForDeal(num, date_count);
		if (resultList.size()<date_count) {
			int needNum = date_count - resultList.size();
			List<Map<String, String>> addList = tiquService.getBaomingListAddForDeal(num, needNum);
			resultList.addAll(addList);
		}
		
		return resultList;
	}

	public List<Map<String, String>> getProList() {
		return proList;
	}

	public void setProList(List<Map<String, String>> proList) {
		this.proList = proList;
	}

	public String getTiqu_num() {
		return tiqu_num;
	}

	public void setTiqu_num(String tiqu_num) {
		this.tiqu_num = tiqu_num;
	}

	public List<Map<String, String>> getBaomingList() {
		return baomingList;
	}

	public void setBaomingList(List<Map<String, String>> baomingList) {
		this.baomingList = baomingList;
	}

	public String getSelect_ids() {
		return select_ids;
	}

	public void setSelect_ids(String select_ids) {
		this.select_ids = select_ids;
	}

	public int getDate_count() {
		return date_count;
	}

	public void setDate_count(int date_count) {
		this.date_count = date_count;
	}
}
