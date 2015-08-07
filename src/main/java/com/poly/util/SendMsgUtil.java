package com.poly.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SendMsgUtil {
	public static void SendMsg(String msg,String phone){
		//System.err.println(phone);
		 URL url;
		try {
			String emsg = java.net.URLEncoder.encode(msg,"utf-8");
			String str = "http://www.10690071.com:9007/url_sms/struts/urlCurrentAction!toCurrentSms?userName=admin&compCode=blcm&pwd=5EFA1616F10DBF3F54E4998C571D3235&message=" + emsg + "&phone="+phone ;
			url = new URL(str);
			 HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();    
		        urlConnection.setDoInput(true);
		        urlConnection.setRequestMethod("POST");  
		        urlConnection.connect();
		        url.openStream();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
       
	}
	public static void SendMsg2(String msg,String phone){
		//System.err.println(phone);
		String str = "http://www.10690071.com:9007/url_sms/struts/urlCurrentAction!toCurrentSms?userName=admin&compCode=blcm&pwd=5EFA1616F10DBF3F54E4998C571D3235&message=" + msg + "&phone="+phone ;
		 URL url;
		try {
			url = new URL(str);
			 HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();    
		        urlConnection.setDoInput(true);
		        urlConnection.setRequestMethod("POST");  
		        urlConnection.connect();
		        url.openStream();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
       
	}
}
