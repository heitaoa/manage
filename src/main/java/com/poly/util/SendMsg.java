package com.poly.util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;

import com.poly.util.HttpRequest;

public class SendMsg {
	public static void main(String args[]) throws Exception{
		String msg  = "С�ֿ�����:��ӭ���μӡ�С�ֿ����š���֯�Ķ��籾�������ػ�ר���Ź���������Ź��ʱ��:12��7�գ����գ���ȫ����Ѵ�ͽ��͵ص㣺����㳡����������ţ���������㳡վ1�ſڳ���/����ʤ·��ͣ��������ԤԼ�Ĺ���ʱ��Ϊ�����գ�����13��00׼ʱ������һվʽȫ�̷�����Ϊ�����ţ���ȥ���Ĵ�����ѯ�ۣ������򳵾��޺��֮�Ǿ�������ͼۣ���ص㣺�ֶ�������ɽ·1589�ţ�����·�ڣ������ɶ��籾��ʱ�䣺13��00~~~16��30.���α��������ڶ࣬�밲�ź�ʱ��׼ʱ������ͣ���������ʧ������õ�ʱ�����ֳ��ų���ϵ�绰:15821598956С�� �յ�����ظ�лл��";
		String emsg =  java.net.URLEncoder.encode(msg,"utf-8");
		int i = 0;
		 SendMsg(emsg,"18652499337");
		/* List<String> phones = getPhones();
		 System.err.println(phones.size());
		
		 Exception exception=null;
		for (String phone : phones) {
			try {
				//System.err.println(phone);
				//SendMsg(emsg,phone);
				i++;
			} catch (Exception e) {
				exception= e;
				System.err.println(phone);
			}
		}*/
		System.err.println(i);
	}
	static void SendMsg(String msg,String phone) throws IOException{
		//System.err.println(phone);
		String str = "http://www.10690071.com:9007/url_sms/struts/urlCurrentAction!toCurrentSms?userName=admin&compCode=blcm&pwd=5EFA1616F10DBF3F54E4998C571D3235&message=" + msg + "&phone="+phone ;
		 URL url = new URL(str);  
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();    
        urlConnection.setDoInput(true);
        urlConnection.setRequestMethod("POST");  
        urlConnection.connect();
        url.openStream();
	}
	static List<String> getPhones() throws IOException{
		List<String> phones = new ArrayList<String>();
		 InputStream is = new FileInputStream("E:\\msg\\newxfl.xls");
	        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
	        // ѭ��������Sheet
	        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
	            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
	            if (hssfSheet == null) {
	                continue;
	            }
	            // ѭ����Row
	            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
	                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
	                if (hssfRow == null) {
	                    continue;
	                }
	                HSSFCell xh = hssfRow.getCell(0);
	                String phone = getValue(xh);
	                phones.add(phone);
	            }
	        }
	        return phones;
	}
	static String getValue(HSSFCell cell){
		if(cell==null)
		{
			System.err.println();
		}
		String cellValue = "";
		 switch (cell.getCellType())  
         {  
         case XSSFCell.CELL_TYPE_NUMERIC: // ����  
             cellValue = cell.getNumericCellValue() + "";  
             break;  

         case XSSFCell.CELL_TYPE_STRING: // �ַ���  
             cellValue = cell.getStringCellValue();  
             break;  
         case XSSFCell.CELL_TYPE_BOOLEAN: // Boolean  
             cellValue = cell.getBooleanCellValue() + "";  
             break;  

         case XSSFCell.CELL_TYPE_FORMULA: // ��ʽ  
             cellValue = cell.getCellFormula() + "";  
             break;  

         case XSSFCell.CELL_TYPE_BLANK: // ��ֵ  
             cellValue = "";  
             break;  

         case XSSFCell.CELL_TYPE_ERROR: // ����  
             cellValue = "�Ƿ��ַ�";  
             break;  

         default:  
             cellValue = "δ֪����";  
             break;  
         } 
		 
		if (HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()) {
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
				Date d = cell.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");	
				cellValue = sdf.format(d);
		}}
		 return cellValue;
	}

}
