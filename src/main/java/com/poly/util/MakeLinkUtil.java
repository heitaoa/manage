package com.poly.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.poly.servlet.InitServlet;

import car_beans.DboSubContent;
import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;

public class MakeLinkUtil {
	private static Configuration cfg = new Configuration();

	static {
		try {
			String ftlPath = InitServlet.rootPath + "/WEB-INF/template";
			FileTemplateLoader ftl = new FileTemplateLoader(new File(ftlPath));

			ClassTemplateLoader ctl = new ClassTemplateLoader(
					HtmlGenerator.class, "");
			TemplateLoader[] loader = new TemplateLoader[] { ftl, ctl};
			MultiTemplateLoader mtl = new MultiTemplateLoader(loader);
			cfg.setTemplateLoader(mtl);
			cfg.setNumberFormat("0.####");
			cfg.setDateFormat("yyyy-MM-dd");
			cfg.setTimeFormat("HH:mm");
			cfg.setDateTimeFormat("yyyy-MM-dd HH:mm");
			cfg.setEncoding(Locale.CHINESE, "utf-8");
			cfg.setDefaultEncoding("utf-8");
			cfg.setOutputEncoding("utf-8");
			
			cfg.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	public static void genBlockjs(String js)
			throws Exception {
		PrintWriter pw = null;
		String tempName = "sub/links.ftl";
		Template t = cfg.getTemplate(tempName);
		File file = new File(MyConfig.html_che_path + "js/links.js");
		new File(file.getParent()).mkdirs();
		file.createNewFile();
		pw = new PrintWriter(new FileOutputStream(file, false));
		Map<Object,Object> root = new HashMap<Object,Object>();
		root.put("bottomLinks", js);
		t.process(root, pw);
		if (pw != null) {
			pw.close();
		}
	}
}
