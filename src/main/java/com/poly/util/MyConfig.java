package com.poly.util;

import java.io.InputStream;
import java.util.Properties;

public class MyConfig {

	public static final String ADMIN_NAME = "admin_name";// ��̨��½�û���
	public static final String AGENCY_ID = "agency_id";// ������ID

	public static String che_url;
	public static String admin_che_url;
	public static String img_che_url;
	public static String html_che_path;
	public static String html_pic_upload_path;
	public static String wap_ct_url;
	public static String inf_che_url;
	
	public static String pic_che_url;
	
	
	public static String dea_che_url;
	public static String auto_che_url;
	public static String pk_che_url;
	public static String che_che_url;
	public static String price_che_url;
	public static String sun_che_url;
	public static String tousu_che_url;
	public static String koubei_che_url;
	
	public static String imgupload_che_url;
	
	//2015-03-23 start
	public static String wap_sr_path; //wapchetuan生成页面路径
	public static String www_ct_url; //车团WWW url
	public static String m_chetuan_com;   //m.chetuan.com
	//2015-03-23 end
	
	public static String bbs_che_url;
	
	public static String city_che_url;
	
	//专题
	public static String html_zt_path;
	public static String zt_che_url;
	public static String chezhan_che_url;
	
	
	public static String err_img;
	
	static {
		Properties props = new Properties();
		

		try {
			InputStream in = MyConfig.class.getResourceAsStream("/myconfig.properties");
			props.load(in);
			in.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		che_url = props.getProperty("che_url");
		wap_ct_url= props.getProperty("wap_ct_url");
		admin_che_url = props.getProperty("admin_che_url");
		img_che_url = props.getProperty("img_che_url");
		html_pic_upload_path = props.getProperty("html_pic_upload_path");
		pic_che_url = props.getProperty("pic_che_url");
		inf_che_url= props.getProperty("inf_che_url");
		
		inf_che_url = props.getProperty("inf_che_url");
		dea_che_url = props.getProperty("4s_che_url");
		auto_che_url=props.getProperty("auto_che_url");
		pk_che_url=props.getProperty("pk_che_url");
		che_che_url=props.getProperty("che_che_url");
		html_che_path = props.getProperty("html_che_path");
		price_che_url = props.getProperty("price_che_url");
		sun_che_url = props.getProperty("sun_che_url");
		tousu_che_url = props.getProperty("tousu_che_url");
		koubei_che_url = props.getProperty("koubei_che_url");
		bbs_che_url = props.getProperty("bbs_che_url");
		err_img = props.getProperty("err_img");
		city_che_url = props.getProperty("city_che_url");
		imgupload_che_url = props.getProperty("imgupload_che_url");
		
		html_zt_path = props.getProperty("html_zt_path");
		zt_che_url = props.getProperty("zt_che_url");
		chezhan_che_url = props.getProperty("chezhan_che_url");
		
		//2015-03-23 start
		wap_sr_path= props.getProperty("wap_sr_path");
		www_ct_url = props.getProperty("www_ct_url");
		m_chetuan_com = props.getProperty("m_chetuan_com");
		//2015-03-23 end
	}
}
