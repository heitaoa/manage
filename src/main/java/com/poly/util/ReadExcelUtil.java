package com.poly.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import sun.net.www.content.audio.x_aiff;
import sun.org.mozilla.javascript.internal.IdScriptableObject;
import car_beans.DboAreCatalog;
import car_beans.DboCarCatalognew;
import car_beans.TbApplyInfo;
import car_daos.DBConnectionManager;
import car_daos.DboAreCatalogDao;
import car_daos.DboCarCatalognewDao;

import com.poly.action.action_groupBuy.GroupExcelAction;

public class ReadExcelUtil {
	static List<HashMap<String,String>> cityList = null;
	static List<HashMap<String,String>> chexingList = null;
	static int count = 0;
	static
	{
		cityList = getCityList();
		chexingList = getChexiList();
	}
	public static void main(String args[]) throws Exception{
		//saveToFile();
		saveToDB();
		//System.err.println(count);
		
		
	}
	static void saveToDB() throws Exception{
		List<TbApplyInfo> applyInfos = new ArrayList<TbApplyInfo>();
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		for(int i = 1;i<=9;i++)
		{
			list.addAll(getRealDate("C:\\Users\\barry\\Desktop\\xiaopangnew\\baoming"+i+".xls"));
		}
		System.err.println(list.size());
		for (HashMap<String, String> map : list) {
			String carName = map.get("carName");
			String name = map.get("name");
			String phone = map.get("phone");
			String appdate = map.get("appdate");
			String address = map.get("address").substring(map.get("address").indexOf("-")+1,map.get("address").length());
			//System.err.println(address);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = null;
			try {
				date = sdf.parse(appdate);
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println(carName+"  "+name);
				continue;
				//System.err.println();
			}
			if(checkPhone(phone))
			{
				//System.err.println(phone);
				continue;
			}
			int pingpaiId = 0;
			int chexingId= 0;
			int city = 0;
			int prov = 9;
			List<Integer> carIds = getCarId(carName);
			if(carIds.get(1)==0||carIds.get(0)==0)
				System.err.println(carName);
			List<Integer> areaIds = getArea(address);
			if(areaIds.get(1)==0&&areaIds.get(0)==0)
				System.err.println(address);
			pingpaiId = carIds.get(0);
			chexingId = carIds.get(1);
			prov = areaIds.get(0);
			city = areaIds.get(1);
			TbApplyInfo applyInfo = new TbApplyInfo();
			applyInfo.setAppdate(date);
			applyInfo.setCarid(pingpaiId);
			applyInfo.setModelid(chexingId);
			applyInfo.setName(name);
			applyInfo.setPhone(phone);
			applyInfo.setType(13);
			applyInfo.setCity(city+"");
			applyInfo.setProv(prov+"");
			applyInfo.setCar_info("Ʒ��:"+carName+" ע��:�׳���������ֻ�б���Ʒ��,��ͷ��ط�ʱע���ô�!");;
			applyInfos.add(applyInfo);
		}
		System.err.println(applyInfos.size());
		for (TbApplyInfo hashMap : applyInfos) {
			System.err.println(hashMap.getPhone());
		}
		//saveBatch(applyInfos);
	}
	static List<Integer> getCarId(String carName){
		List<Integer> ids = new ArrayList<Integer>();
		int cid = 0;
		int mid = 0;
		for (HashMap<String,String> map : chexingList) {
			int catalogid = Integer.parseInt(map.get("catalogid"));
			String iway = map.get("iway");
			int fatherid = Integer.parseInt(map.get("fatherid"));
			if(carName.equals(iway))
			{
				cid = fatherid;
				mid = catalogid;
				break;
			}
		}
		if(cid == 0){
		for (HashMap<String,String> map : chexingList) {
			int catalogid = Integer.parseInt(map.get("catalogid"));
			String iway = map.get("iway");
			int fatherid = Integer.parseInt(map.get("fatherid"));
			if(iway.contains(carName))
			{
				cid = fatherid;
				mid = catalogid;
				break;
			}
		}
		}
		ids.add(cid);
		ids.add(mid);
		return ids;
	}
	static List<Integer> getArea(String area){
		List<Integer> ids = new ArrayList<Integer>();
		int prov = 0;
		int city = 0;
		for (HashMap<String,String> map : cityList) {
			int catalogid = Integer.parseInt(map.get("catalogid"));
			int fatherid = Integer.parseInt(map.get("fatherid"));
			String catalogname = map.get("catalogname");
			String byname = map.get("byname");
			if(area.equals(catalogname)||area.equals(byname))
			{
				if(fatherid == 0)
				{
					prov = catalogid;
					city = 0;
				}else {
					prov = fatherid;
					city = catalogid;
				}
			}
		}
		ids.add(prov);
		ids.add(city);
		return ids;
	}
	static void saveToFile() throws FileNotFoundException, IOException{
		for(int i= 1;i<=9;i++){
		List<HashMap<String, String>> list = getPhones("C:\\Users\\barry\\Desktop\\xiaopang\\baoming"+i+".xlsx");
		saveExcel("C:\\Users\\barry\\Desktop\\xiaopangnew\\baoming"+i+".xls",list);
		}
	
	}
	static List<HashMap<String, String>> getRealDate(String from) throws IOException{
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		HashMap<String,String> map = null;
		 InputStream is = new FileInputStream(from);
		 HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		 //HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
	        // ѭ��������Sheet
	        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
	        	HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
	            
	            if (hssfSheet == null) {
	                continue;
	            }
	            // ѭ����Row
	            for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
	            	HSSFRow hssfRow = hssfSheet.getRow(rowNum);
	                if (hssfRow == null) {
	                    continue;
	                }
	                map = new HashMap<String, String>();
	                map.put("carName",getValue(hssfRow.getCell(0)));
	                map.put("name", getValue(hssfRow.getCell(1)));
	                map.put("phone",getValue(hssfRow.getCell(2)));
	                map.put("appdate", getValue(hssfRow.getCell(3)));
	                map.put("address", getValue(hssfRow.getCell(4)));
	                list.add(map);
	            }
	        }
	        return list;
	}
	static List<HashMap<String, String>> getPhones(String from) throws IOException{
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		HashMap<String,String> map = null;
		 InputStream is = new FileInputStream(from);
		 XSSFWorkbook hssfWorkbook = new XSSFWorkbook(is);
		 //HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
	        // ѭ��������Sheet
	        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
	            XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
	            
	            if (hssfSheet == null) {
	                continue;
	            }
	            // ѭ����Row
	            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
	            	
	                XSSFRow hssfRow = hssfSheet.getRow(rowNum);
	                if (hssfRow == null) {
	                    continue;
	                }
	                
	                map = new HashMap<String, String>();
	                String oldName = hssfSheet.getSheetName();
	                String carName = hssfSheet.getSheetName().replace("һ������","һ��-����").replace("����", "���ڱ���").replace("�µ�","һ��-���ڰµ�");
	                String name = hssfRow.getCell(1)==null? "�׳�����": getValue(hssfRow.getCell(1));
	                XSSFCell cell = hssfRow.getCell(2);
	                if(cell==null)
	                {
	                	continue;
	                }
	                String info = getValue(hssfRow.getCell(7));
	                oldName = oldName.substring(0,oldName.lastIndexOf("-"));
	                if(!info.contains(oldName))
	                	continue;
	                count++;
	                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
	                String phone = getValue(cell);
	                String appdate = getValue(hssfRow.getCell(5));
	                String address = getValue(hssfRow.getCell(4));
	                String carNameNew = carName.substring(0,carName.lastIndexOf("-"));
	                
	                if("����".equals(carNameNew))
	                	carNameNew = "��������";
	                if("����".equals(carNameNew))
	                	carNameNew = "��������";
	                map.put("carName",carNameNew);
	                map.put("name", name);
	                map.put("phone", phone);
	                map.put("appdate", appdate);
	                map.put("address", address);
	                list.add(map);
	            }
	        }
	        return list;
	}
	static void saveExcel(String fi,List<HashMap<String, String>> excelMap) throws FileNotFoundException, IOException{
		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fi));
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(0);
		for (int i = 0; i < excelMap.size(); i++) {
			HashMap<String, String> map = excelMap.get(i);
			HSSFRow row = sheet.createRow(i);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue(map.get("carName"));
			cell = row.createCell(1);
			cell.setCellValue(map.get("name"));
			cell = row.createCell(2);
			cell.setCellValue(map.get("phone"));
			cell = row.createCell(3);
			cell.setCellValue(map.get("appdate"));
			cell = row.createCell(4);
			cell.setCellValue(map.get("address"));
		}
		 FileOutputStream fileoutputstream = new FileOutputStream(fi);
		 wb.write(fileoutputstream);
		 fileoutputstream.close();
	}
	static String getValue(XSSFCell cell){
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
	static List<HashMap<String, String>> getCityList(){
		Connection dbc = getMySqlConnection2();
		String sql  = "select catalogid,catalogname,fatherid,byname from dbo_are_catalog ";
		HashMap<String, String> map = null;
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		try {
			PreparedStatement pstmt = dbc.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("catalogid",rs.getString("catalogid"));
				map.put("catalogname",rs.getString("catalogname"));
				map.put("fatherid",rs.getString("fatherid"));
				map.put("byname",rs.getString("byname"));
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	static boolean checkPhone(String phone){

		Connection dbc = getMySqlConnection2();
		String sql  = "select count(*) count from tb_apply_info where phone = '"+phone+"' and type = 13";
		boolean flag = false;
		int count = 0;
		try {
			PreparedStatement pstmt = dbc.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(count>0)
			flag = true;
		return flag;
	
	}
	static List<HashMap<String,String>> getChexiList(){
		Connection dbc = getMySqlConnection2();
		String sql  = "select t1.catalogid,t1.iway,t3.fatherid from dbo_car_catalognew t1 LEFT OUTER JOIN dbo_car_catalognew t2 on t1.catalogid = t2.catalogid LEFT OUTER JOIN dbo_car_catalognew t3 on t2.fatherid = t3.catalogid  where t1.pathlevel= 3 and t1.isdelete=0 and t1.iway is not null and t1.iway!=''";
		HashMap<String, String> map = null;
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		try {
			PreparedStatement pstmt = dbc.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("catalogid",rs.getString("catalogid"));
				map.put("iway",rs.getString("iway"));
				map.put("fatherid",rs.getString("fatherid"));
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	} 
	static Connection getMySqlConnection2(){
		Connection conn = null;
		String url = "jdbc:mysql://182.254.147.194:3306/car?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=round";
		//String url = "jdbc:mysql://192.168.137.48:3306/car?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=round";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");// Ҫ��JVM���Ҳ�����ָ�����࣬Ҳ����˵JVM��ִ�и���ľ�̬�����
			DriverManager.setLoginTimeout(10);// ����10s�ò������ӱ���
			conn = DriverManager.getConnection(url,"main_select","main_select");
			//conn = DriverManager.getConnection(url,"main","main");
			//conn.setAutoCommit(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	static Connection getMySqlConnection(){
		Connection conn = null;
		String url = "jdbc:mysql://182.254.147.194:3306/car?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=round";
		//String url = "jdbc:mysql://192.168.137.48:3306/car?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=round";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");// Ҫ��JVM���Ҳ�����ָ�����࣬Ҳ����˵JVM��ִ�и���ľ�̬�����
			DriverManager.setLoginTimeout(10);// ����10s�ò������ӱ���
			conn = DriverManager.getConnection(url,"main_zq","main!@#");
			//conn = DriverManager.getConnection(url,"main","main");
			//conn.setAutoCommit(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	static void saveBatch(List<TbApplyInfo> applyInfos) throws Exception{
		String sql = "insert into tb_apply_info(`id`,`carid`,`modelid`,`name`,`phone`,`sex`,`prov`,`city`,`appdate`,`type`,isSendSms,car_info,ip,phone_prov,phone_city) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		Connection  con = null;
		
		try {
			con = getMySqlConnection();
			con.setAutoCommit(false);
			PreparedStatement pst = con.prepareStatement(sql);
			for (int i = 0;i<applyInfos.size();i++) {
				TbApplyInfo applyInfo = applyInfos.get(i);
				pst.setInt(1, applyInfo.getId());
				pst.setInt(2, applyInfo.getCarid());
				pst.setInt(3, applyInfo.getModelid());
				pst.setString(4, applyInfo.getName());
				pst.setString(5, applyInfo.getPhone());
				pst.setInt(6, applyInfo.getSex());
				pst.setString(7, applyInfo.getProv());
				pst.setString(8, applyInfo.getCity());
				pst.setTimestamp(9, new Timestamp(applyInfo.getAppdate().getTime()));
				pst.setInt(10, applyInfo.getType());
				pst.setInt(11, 1);
				pst.setString(12, applyInfo.getCar_info());
				pst.setString(13, applyInfo.getIp());
				pst.setInt(14, applyInfo.getPhone_prov());
				pst.setInt(15, applyInfo.getPhone_city());
				//pst.setInt(14, applyInfo.getIs_other_city());
				pst.addBatch();
				if(i%1000==0){
					pst.executeBatch();
					con.commit();
				    pst.clearBatch();
				}
			}
			pst.executeBatch();
			con.commit();
			pst.close();
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
	
	static void updateYiche1(List<TbApplyInfo>  datas){
		Long beginTime = System.currentTimeMillis();
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		Connection dbc = getMySqlConnection2();
		String sql  = "select id,phone,city from tb_apply_Info where  type = 13 and city=0";
		HashMap<String, String> map = null;
		try {
			PreparedStatement pstmt = dbc.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("id",rs.getString("id"));
				map.put("phone",rs.getString("phone"));
				map.put("city",rs.getString("city"));
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//if (dbc != null)
				//	dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		List<HashMap<String, String>> newList = new ArrayList<HashMap<String,String>>();
		for (HashMap<String, String> hashMap : list) {
			String city = hashMap.get("city");
			String id = hashMap.get("id");
			String phone = hashMap.get("phone");
			for (TbApplyInfo app : datas) {
				if(app.getPhone().equals(phone)){
					HashMap<String, String> mapx = new HashMap<String, String>();
					mapx.put("id", id);
					mapx.put("city", app.getCity());
					System.err.println(app.getCity());
					System.err.println(app.getCity());
					newList.add(mapx);
				}
			}
		}
		System.err.println(newList.size());
		Connection dbc2 =null;
		try {
			dbc2 = getMySqlConnection();
			dbc2.setAutoCommit(false);
			String sqlx  = "update tb_apply_info set city = ? where id =? ";
			PreparedStatement pstmtx = dbc2.prepareStatement(sqlx);
			for (int i=0;i<newList.size();i++) {
				HashMap<String, String> mapx = newList.get(i);
				pstmtx.setString(1, mapx.get("city"));
				pstmtx.setString(2, mapx.get("id"));
				pstmtx.addBatch();
				if(i%1000==0){
					pstmtx.executeBatch();
					dbc2.commit();
					pstmtx.clearBatch();
				}
			}
			pstmtx.executeBatch();
			dbc2.commit();
			pstmtx.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	static void updatePhoneState1(){
		Long beginTime = System.currentTimeMillis();
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		Connection dbc = getMySqlConnection2();
		String sql  = "SELECT t1.name,t1.id,phone,t1.prov,t1.city,phone_prov,phone_city,t2.provid,t2.cityid from tb_apply_info t1 LEFT OUTER JOIN  tb_dict_phone t2  on SUBSTRING(t1.phone,1,7) = t2.phone_num where phone_prov=11  and phone_city=0";
		HashMap<String, String> map = null;
		try {
			PreparedStatement pstmt = dbc.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("id",rs.getString("id"));
				map.put("provid",rs.getString("provid"));
				map.put("cityid",rs.getString("cityid"));
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//if (dbc != null)
				//	dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.err.println(list.size());
		List<HashMap<String, String>> listx = list;
		Connection dbc2 =null;
		try {
			dbc2 = getMySqlConnection();
			dbc2.setAutoCommit(false);
			String sqlx  = "update tb_apply_info set phone_prov=? ,phone_city = ? where id =? ";
			PreparedStatement pstmtx = dbc2.prepareStatement(sqlx);
			for (int i=0;i<listx.size();i++) {
				HashMap<String, String> mapx = listx.get(i);
				pstmtx.setString(1, mapx.get("provid"));
				pstmtx.setString(2, mapx.get("cityid"));
				pstmtx.setString(3, mapx.get("id"));
				pstmtx.addBatch();
				if(i%1000==0){
					pstmtx.executeBatch();
					dbc2.commit();
					pstmtx.clearBatch();
				}
			}
			pstmtx.executeBatch();
			dbc2.commit();
			pstmtx.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		Long endtime = System.currentTimeMillis();
		System.out.println("���뱨��������ʱ��"+(endtime-beginTime)/1000+"��");
	}
}
