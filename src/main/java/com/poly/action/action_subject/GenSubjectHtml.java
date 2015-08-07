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
import java.util.Properties;

import car_beans.DboNewCatalog;
import car_beans.DboSubContent;
import car_beans.DboSubContent315;
import car_beans.DboSubData;
import car_beans.DboSubData315;
import car_beans.DboZhtContent;
import car_daos.DboNewCatalogDao;

import com.poly.service.SubjectService;
import com.poly.servlet.InitServlet;
import com.poly.sftp.MyRemoteUtil;
import com.poly.util.HtmlGenerator;
import com.poly.util.MyConfig;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;

public class GenSubjectHtml {
	
	//获取配置
		private static Configuration cfg = new Configuration();

		//加载静态块
		static{
			//获取模板路径
			
			try {
				String ftlPath = InitServlet.rootPath+"/WEB-INF/template/subject";
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
		
		
		public static void genIndex(DboZhtContent subContent, Map<String, List<DboSubData>> dataMap) throws Exception {
			PrintWriter pw = null;
			String tempName = subContent.getContent();
			if(tempName==null&&"".equals(tempName)){
				tempName = "zt_" + subContent.getId() + ".ftl";
			}
			
			Template t = cfg.getTemplate(tempName);

			File file = null;
			if(subContent.getType().equals("展会")){
				file = new File(MyConfig.html_zt_path + "chezhan/" + subContent.getId() + "/index.html");
			}else{
				file = new File(MyConfig.html_zt_path + "zhuanti/" + subContent.getId() + "/index.html");
			}
		
			new File(file.getParent()).mkdirs();
			file.createNewFile();

			System.out.println("HtmlGenerator.genIndex(): " + tempName + " >>> " + file.getPath());
			pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file, false),"UTF-8"));
			Map<Object, Object> root = new HashMap<Object, Object>();
			List<Map<String,String>> subjectList = SubjectService.getSubjectListByTempname(tempName);
			root.put("che_url", MyConfig.che_url);
			root.put("img_che_url", MyConfig.img_che_url);
			root.put("zt_che_url", MyConfig.zt_che_url);
			root.put("ver", System.currentTimeMillis());
			root.put("dataMap", dataMap);
			root.put("keywords", subContent.getKeywords());
			root.put("descstr", subContent.getDescstr());
			root.put("title",subContent.getName());
			root.put("id",subContent.getId());
			root.put("subjectList",subjectList);
			t.process(root, pw);
			System.out.println("HtmlGenerator.genIndex(): " + tempName + " >>> " + file.getPath()+" >>> end");
			if (pw != null) {
				pw.close();
			}
			
			// 同步
			Properties prop = System.getProperties();
			String os = prop.getProperty("os.name");
			if (os.toLowerCase().indexOf("windows") == -1) {
				System.out.println(file.getPath()+"------------sync-----------"+file.getParent());
				MyRemoteUtil.sync(file.getPath(), file.getParent());
			}
			
			
		}
}
