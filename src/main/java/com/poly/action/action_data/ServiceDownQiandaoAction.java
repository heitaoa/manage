package com.poly.action.action_data;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.poly.action.MyActionSupport;
import com.poly.action.action_groupBuy.GroupExcelAction;
import com.poly.service.ProjectService;

public class ServiceDownQiandaoAction extends MyActionSupport{
	private String pro_num;
	public void downQiandao() throws Exception{
		Map<String,String> info = ProjectService.getInstance().getProjectInfoByProNum(pro_num);
		String brand_name = info.get("brand_name");
		List<Map<String,String>> list = ProjectService.getInstance().getQiandaoListForDownLoad(pro_num);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd ");
		String downloadFileName ="签到表_"+ (sf.format(new Date()).toString()).trim()+".xls";
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
		String fi = GroupExcelAction.class.getResource("/").getPath()
				.replace("classes/", "template")
				+ "/excel/qiandaotemplate.xls";
		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fi));
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFCellStyle cellStyle=wb.createCellStyle();
		cellStyle.setWrapText(true);         
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("____年__月__日"+brand_name+"签到表");
		for(int i=0;i<list.size();i++){
			row = sheet.createRow(i+2);
			cell = row.createCell(0);
			cell.setCellValue(i+1);
			cell = row.createCell(1);
			cell.setCellValue(list.get(i).get("name"));
			cell = row.createCell(2);
			cell.setCellValue(list.get(i).get("phone"));
			cell = row.createCell(3);
			cell.setCellValue(list.get(i).get("serial"));
			cell = row.createCell(4);
			String attend_type = list.get(i).get("attend_type");
			if("1".equals(attend_type)){
				attend_type="参加，跟团到";
			}else if("2".equals(attend_type)){
				attend_type="参加，自行到";
			}else if("3".equals(attend_type)){
				attend_type="参加，不确定";
			}else if("4".equals(attend_type)){
				attend_type="可能参加";
			}else{
				attend_type="";
			}
			cell.setCellValue(attend_type);
			row.createCell(5);
			row.createCell(6);
			row.createCell(7);
			cell = row.createCell(8);
			String content = list.get(i).get("return_visit_content");
			String[]cs = content.split("<br>");
			for(int j=0;j<cs.length;j++){
				String c = cs[j];
				String[]d = c.split("  ");
				List<String>dd = new ArrayList<String>();
				for(int m=0;m<d.length;m++){
					if(m>1){
						dd.add(d[m]);
					}
				}
				cs[j] = StringUtils.join(dd.toArray(),"  ").trim();
			}
			Set<String> scs = new HashSet<String>();
			for(String c:cs){
				scs.add(c);
			}
			content = StringUtils.join(scs.toArray(),"<br>");
			cell.setCellStyle(cellStyle); 
			content = content.replaceAll("<br>", "\n");
			cell.setCellValue(content);
		}
		wb.write(response.getOutputStream());
	}
	public String getPro_num() {
		return pro_num;
	}
	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
	}
	
}
