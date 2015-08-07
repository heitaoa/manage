package com.poly.action.action_subject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import car_beans.DboPubMould;
import car_beans.DboPubSubjectdata;

import com.poly.servlet.InitServlet;
import com.poly.util.HtmlGenerator;
import com.poly.util.MyConfig;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;

public class GenJsBlock {
	
	//获取配置
	private static Configuration cfg = new Configuration();

	//加载静态块
	static{
		//获取模板路径
		
		try {
			String ftlPath = InitServlet.rootPath+"/WEB-INF/template";
			FileTemplateLoader ftl = new FileTemplateLoader(new File(ftlPath));
			ClassTemplateLoader ctl = new ClassTemplateLoader(
					HtmlGenerator.class, "");

			TemplateLoader[] loader = new TemplateLoader[] {ftl, ctl};
			MultiTemplateLoader mtl = new MultiTemplateLoader(loader);
			cfg.setTemplateLoader(mtl);
			cfg.setNumberFormat("0.####");
			cfg.setDateFormat("yyyy-MM-dd");
			cfg.setTimeFormat("HH:mm");
			cfg.setDateTimeFormat("yyyy-MM-dd HH:mm");
			cfg.setEncoding(Locale.CHINESE, "UTF-8");
			cfg.setDefaultEncoding("UTF-8");
			cfg.setOutputEncoding("UTF-8");
			cfg.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static String generateJsBlock(List<DboPubSubjectdata> dataList,DboPubMould mould,String subjectId) throws Exception{
		PrintWriter pw = null;
		String tempName = "subject/"+mould.getMouldftl();
		Template t = cfg.getTemplate(tempName);
		File file = new File(MyConfig.html_che_path + "sub/"
				+ subjectId+"_"+mould.getMouldid()+".js");
		System.out.println("HtmlGenerator.genBlockjs(): " + tempName + " >>> "
				+ file.getPath());
		new File(file.getParent()).mkdirs();
		file.createNewFile();
		pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file, false),"utf-8"));
		Map<Object,Object> root = new HashMap<Object,Object>();

		root.put("admin_che_url", MyConfig.admin_che_url);
		root.put("che_url", MyConfig.che_url);
		root.put("html_che_path", MyConfig.html_che_path);
		root.put("html_pic_upload_path", MyConfig.html_pic_upload_path);
		root.put("img_che_url", MyConfig.img_che_url);

		root.put("ver", System.currentTimeMillis());
		root.put("dataList", dataList);
		t.process(root, pw);
		if (pw != null) {
			pw.close();
		}
		String jsUrl = MyConfig.che_url + "sub/"
				+ subjectId+"_"+mould.getMouldid()+".js";
		return jsUrl;
	}
	
	public static void genAdJsBlock(Map<String,Object> map) throws Exception{
		PrintWriter pw = null;
		String tempName = "subject/"+map.get("ftl");
		Template t = cfg.getTemplate(tempName);
		File file = new File(MyConfig.html_che_path + "sub/"
				+"block_"+map.get("adId")+".js");
		System.out.println("HtmlGenerator.genBlockjs():" + tempName + ">>>"
				+ file.getPath());
		new File(file.getParent()).mkdirs();
		file.createNewFile();
		pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file, false),"utf-8"));
		Map<Object,Object> root = new HashMap<Object,Object>();
		
		root.put("admin_che_url", MyConfig.admin_che_url);
		root.put("che_url", MyConfig.che_url);
		root.put("html_che_path", MyConfig.html_che_path);
		root.put("html_pic_upload_path", MyConfig.html_pic_upload_path);
		root.put("img_che_url", MyConfig.img_che_url);

		root.put("ver", System.currentTimeMillis());
		root.put("map", map);
		t.process(root, pw);
		if (pw != null) {
			pw.close();
		}
	}
	
	
}
