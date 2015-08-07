package com.poly.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.xmlbeans.SystemProperties;

import car_daos.DboDelForIdFileDao;

import com.poly.bean.newNews;
import com.poly.sftp.MyRemoteUtil;
import com.poly.util.thread.DeleteCarHtmlTgread;
import com.poly.util.thread.DeleteHtmThread;

public class DeleteCarParamFileUtil {
	
	private static List<String> pass_file;
	private static int server;
	
	static {
		// pass_file = new String[] { "html", "htm", "css", "js" };

		pass_file = new ArrayList<String>();
		pass_file.add("htm");
		pass_file.add("html");
		pass_file.add("css");
		pass_file.add("js");
	}
	
	public static void deleteFile(int id,String englishname) throws Exception{
		System.out.println("startDate------------------>"+System.currentTimeMillis());
		DeleteCarHtmlTgread dt=new DeleteCarHtmlTgread(englishname, id);
		dt.start();
	}
	
	/*
	 * 当图库报价相关表有改动时删除相关的静态页
	 */
	public static void deleteTuKuPriceFile(String htmName,String delWho){
		if("imgContent".equals(delWho)){
			System.out.println("start:-------------------------------------------------------------->>>>>>>>>"+System.currentTimeMillis());
			DeleteHtmThread dt = new DeleteHtmThread(htmName);
			dt.start();
			System.out.println("end:-------------------------------------------------------------->>>>>>>>>"+System.currentTimeMillis());
		}else if("carCatalogNew".equals(delWho)){
			//list = DboDelForIdFileDao.inCarCatalogNew(htmName);
		}
	}
	
	
	
	public static void main(String[] args) {
		
	}

//	private static void deleteTukuPriceFile_1(String htmName){
//		try {
//			RemoveFileByCarParam("price/index.htm");
//			RemoveFileByCarParam("tuku/index.htm");
//			
//			RemoveFileByCarParam("tuku/brand/0-"+htmName+".htm");
//			RemoveFileByCarParam("tuku/carpic/"+htmName+"-*.htm");
//			RemoveFileByCarParam("tuku/serial/"+htmName+".htm");
//			RemoveFileByCarParam("tuku/serialtypeimg/*-"+htmName+"-*.htm");
//			
//			RemoveFileByCarParam("price/brand/0-"+htmName+".htm");
//			RemoveFileByCarParam("price/series/0-"+htmName+".htm");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

//	private static void deleteTukuPriceFile_1(String htmName){
//		try {
//			
//
//			/*String commStr = "rm -rf " + getFilePath("tuku/index.htm") + " \n"+
//					     "rm -rf " + getFilePath("tuku/brand/0-"+htmName+".htm") + " \n"+
//					     "rm -rf " + getFilePath("tuku/carpic/"+htmName+"-*.htm") + " \n"+
//					     "rm -rf " + getFilePath("tuku/serial/"+htmName+".htm") + " \n"+
//					     "rm -rf " + getFilePath("tuku/serialtypeimg/*-"+htmName+"-*.htm") + " \n"+
//					     "rm -rf " + getFilePath("price/brand/0-"+htmName+".htm") + " \n"+
//					     "rm -rf " + getFilePath("price/series/0-"+htmName+".htm") + " \n";
//			
//			*/
//			/*RemoveFileByCarParam("tuku/index.htm");
//			RemoveFileByCarParam("tuku/brand/0-"+htmName+".htm");
//			RemoveFileByCarParam("tuku/carpic/"+htmName+"-*.htm");
//			RemoveFileByCarParam("tuku/serial/"+htmName+".htm");
//			RemoveFileByCarParam("tuku/serialtypeimg/*-"+htmName+"-*.htm");
//			RemoveFileByCarParam("price/brand/0-"+htmName+".htm");
//			RemoveFileByCarParam("price/series/0-"+htmName+".htm");*/
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	
	public static void RemoveFileByCarParam(String delFile) throws Exception{
		if (delFile != null) {
			int res = 0;

			String filePath = MyRemoteUtil.getFilePath(delFile);

			if (isLinux()) {
				System.out.println(">>> >>> os is linux");
				String commStr = "";
				commStr = "/home/tq/del.sh "+MyRemoteUtil.che_html+" "+ filePath + " \n";
				System.out.println(">>> >>> remove file command:" + commStr);

				if (delFile.indexOf("auto/") > -1) {
					server = MyRemoteUtil.auto315;
					System.out.println(">>> >>> auto315");
				}

				else if (delFile.indexOf("html_dealer/") > -1) {
					server = MyRemoteUtil.ssss315;
					System.out.println(">>> >>> ssss315");
				}

				else {
					server = MyRemoteUtil.www315;
					System.out.println(">>> >>> www315");
				}

				res = MyRemoteUtil.exeCommand(commStr, server);
			} else {
				System.out.println("os is windows");
				Boolean resBoo = delFileHandler(filePath);
				res = resBoo ? 1 : 0;
			}
		}
	}
	
	private static boolean delFileHandler(String fname) {
		try {
			File file = new File(fname);
			if (file.exists()) {
				System.out.println("删除文件：" + fname);
				return file.delete();
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private static Boolean isLinux() {
		Properties prop = System.getProperties();
		String os = prop.getProperty("os.name");
		if (os.toLowerCase().indexOf("windows") != -1)
			return false;
		return true;
	}
	

}
