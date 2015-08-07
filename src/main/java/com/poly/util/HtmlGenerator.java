package com.poly.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import car_beans.DboAreCatalog;
import car_beans.DboCarCatalognew;
import car_beans.DboNewCatalog;
import car_beans.DboNewContent;
import car_beans.DboNewNews;
import car_beans.DboNewRelated;
import car_beans.DboSubContent;
import car_beans.DboSubData;
import car_beans.TbKeywords;
import car_beans.TbSiteMap;
import car_daos.DboNewCatalogDao;

import com.poly.service.KeywordsService;
import com.poly.service.URLMappingService;
import com.poly.servlet.InitServlet;
import com.poly.sftp.MyRemoteUtil;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;

public class HtmlGenerator {

	private static Configuration cfg = new Configuration();

	static {
		try {
			// Properties p = new Properties();
			// p.load(HtmlGenerator.class.getResourceAsStream("/news.properties"));
			// MyConfig.html_che_path = p.getProperty("html.path");
			// //ftlPath = p.getProperty("ftl.path");
			// urlPath = p.getProperty("url.path");

			// FileTemplateLoader ftl = new FileTemplateLoader(new
			// File(ftlPath));
			String ftlPath = InitServlet.rootPath + "/WEB-INF/template";
			FileTemplateLoader ftl = new FileTemplateLoader(new File(ftlPath));

			ClassTemplateLoader ctl = new ClassTemplateLoader(HtmlGenerator.class, "");

			String wapftlPath = InitServlet.rootPath + "/WEB-INF/waptemplate";
			FileTemplateLoader wapftl = new FileTemplateLoader(new File(wapftlPath));

			TemplateLoader[] loader = new TemplateLoader[] { ftl, ctl, wapftl };
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
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	//
	public static void main(String[] args) {

		File file = new File(MyConfig.html_che_path + "sub/news_11.js");
		System.out.println("--->" + file.getParent());
		new File(file.getParent()).mkdirs();
	}

	/*
	 * ��̬��վ��ɲ��֣�index block page
	 * 
	 * page���֣�ģ���������� ---> ���ɳ�����html��������
	 * template/new/page_<catalogid>.ftl --->
	 * MyConfig.html_che_path/new/<catalogid>/page_<newid>_<calcpage>.html
	 * template/car/page_<catalogid>.ftl --->
	 * MyConfig.html_che_path/car/<catalogid>/page_<newid>_<calcpage>.html
	 * template/img/page_<catalogid>.ftl --->
	 * MyConfig.html_che_path/img/<catalogid>/page_<newid>_<calcpage>.html
	 * 
	 * block���֣�ģ���������� ---> ���ɳ�����js��������
	 * template/sub/block_<sub_content.id>.ftl --->
	 * MyConfig.html_che_path/sub/block_<sub_content.id>.js
	 * 
	 * index���֣� template/index/index_<xxxx>.ftl --->
	 * MyConfig.html_che_path/index/index_<xxxx>.html
	 */

	// ������ҳ
	public static void genIndex(DboSubContent subContent, Object[] param, Map<String, List<DboSubData>> dataMap) throws Exception {
		PrintWriter pw = null;
		String tempName = subContent.getTemplatename();
		if (tempName == null || tempName.length() < 4) {
			tempName = "index/index_" + subContent.getId() + ".ftl";
		}
		Template t = cfg.getTemplate(tempName);

		File file = null;
		if (subContent.getHtmlname() != null)
			file = new File(MyConfig.html_che_path + subContent.getHtmlname());
		else
			file = new File(MyConfig.html_che_path + "index_" + subContent.getId() + ".html");

		new File(file.getParent()).mkdirs();
		file.createNewFile();

		System.out.println("HtmlGenerator.genIndex(): " + tempName + " >>> " + file.getPath());
		pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file, false), "UTF-8"));
		Map<Object, Object> root = new HashMap<Object, Object>();
		root.put("che_url", MyConfig.che_url);
		root.put("ver", System.currentTimeMillis());
		root.put("subContent", subContent);
		root.put("dataMap", dataMap);
		root.put("param", param);

		// start
		int sites_id = subContent.getSub_sites_id();
		List<DboNewCatalog> catalogs = DboNewCatalogDao.where(" sub_sites_id=" + sites_id);
		// Map<String, DboNewCatalog> catalogMap<Object,Object>= new
		// HashMap<String,
		// DboNewCatalog>();
		for (DboNewCatalog catalog : catalogs) {
			String navName = catalog.getNavname();
			if (navName != null && !"".equals(navName.trim())) {
				root.put(navName, catalog);
				// System.out.println(navName);
			}
		}
		root.put("catalogs", catalogs);
		// end

		t.process(root, pw);
		if (pw != null) {
			pw.close();
		}
	}

	// ���ɳ�����ҳ
	public static void genCityIndex(DboSubContent subContent, Object[] param, DboAreCatalog areCatalog) throws Exception {
		PrintWriter pw = null;
		String tempName = "area/index_" + areCatalog.getCatalogid() + ".ftl";
		Template t = null;
		try {
			t = cfg.getTemplate(tempName);
		} catch (FileNotFoundException e) {
			// Ĭ��ģ��
			tempName = "area/index.ftl";
			t = cfg.getTemplate(tempName);
		}
		File file = new File(MyConfig.html_che_path + areCatalog.getEnglingname() + "/index.html");
		System.out.println("HtmlGenerator.genCityIndex(): " + tempName + " >>> " + file.getPath());
		new File(file.getParent()).mkdirs();
		file.createNewFile();
		pw = new PrintWriter(new FileOutputStream(file, false));
		Map<Object, Object> root = new HashMap<Object, Object>();

		root.put("ver", System.currentTimeMillis());
		root.put("subContent", subContent);
		root.put("param", param);
		root.put("areCatalog", areCatalog);
		t.process(root, pw);
		if (pw != null) {
			pw.close();
		}
	}
	
	
	public static void genBlockjsForM(DboSubContent subContent, Object[] param) throws Exception {
		PrintWriter pw = null;
		String tempName = "sub/block_30_m.ftl";
		Template t = cfg.getTemplate(tempName);
		
		File file = new File(MyConfig.html_che_path + "sub/block_30_m.js");
		System.out.println("HtmlGenerator.genBlockjs(): " + tempName + " >>> " + file.getPath());
		new File(file.getParent()).mkdirs();
		file.createNewFile();
		pw = new PrintWriter(new FileOutputStream(file, false));
		Map<Object, Object> root = new HashMap<Object, Object>();
        
		root.put("ver", System.currentTimeMillis());
		root.put("subContent", subContent);
		root.put("param", param);
		root.put("FormatImg", new FtlFormatImgMethod());
		root.put("FormatImgX", new FtlFormatImgXMethod());
		root.put("imageFormat", new ImageFormatMethod());
		t.process(root, pw);
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
	

	public static void genBlockjs(DboSubContent subContent, Object[] param) throws Exception {
		if(subContent.getId() == 30){
			HtmlGenerator.genBlockjsForM(subContent, param);
		}
		PrintWriter pw = null;
		String tempName = "sub/block_" + subContent.getId() + ".ftl";
		if (subContent.getTemplatename() != null) {
			tempName = "sub/" + subContent.getTemplatename();
		}
		Template t = cfg.getTemplate(tempName);
		// ��ȡ���·���µ�ģ�壬�����ȡ����jsĿ¼�µ�ģ�壬Ҳ����jsģ��
		File file = new File(MyConfig.html_che_path + "sub/" + subContent.getHtmlname());
		System.out.println("HtmlGenerator.genBlockjs(): " + tempName + " >>> " + file.getPath());
		new File(file.getParent()).mkdirs();
		file.createNewFile();
		pw = new PrintWriter(new FileOutputStream(file, false));
		Map<Object, Object> root = new HashMap<Object, Object>();

		root.put("ver", System.currentTimeMillis());
		root.put("subContent", subContent);
		root.put("param", param);
		root.put("FormatImg", new FtlFormatImgMethod());
		root.put("FormatImgX", new FtlFormatImgXMethod());
		root.put("imageFormat", new ImageFormatMethod());
		t.process(root, pw);
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

	public static void gen315Blockjs(DboSubContent subContent, Object[] param) throws Exception {
		PrintWriter pw = null;
		String tempName = "sub/block_" + subContent.getId() + ".ftl";
		if (subContent.getTemplatename() != null) {
			tempName = "sub/" + subContent.getTemplatename();
		}
		Template t = cfg.getTemplate(tempName);
		// ��ȡ���·���µ�ģ�壬�����ȡ����jsĿ¼�µ�ģ�壬Ҳ����jsģ��
		File file = new File(MyConfig.html_che_path + "sub/" + subContent.getHtmlname());
		System.out.println("HtmlGenerator.genBlockjs(): " + tempName + " >>> " + file.getPath());
		new File(file.getParent()).mkdirs();
		file.createNewFile();
		pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file, false), "utf-8"));
		Map<Object, Object> root = new HashMap<Object, Object>();
		root.put("che_url", MyConfig.che_url);

		root.put("ver", System.currentTimeMillis());
		root.put("subContent", subContent);
		root.put("param", param);
		root.put("FormatImg", new FtlFormatImgMethod());
		root.put("FormatImgX", new FtlFormatImgXMethod());
		root.put("imageFormat", new ImageFormatMethod());
		t.process(root, pw);
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

	// ���������б�ҳ

	// ���������б�ҳ
	public static void genNewList(DboNewCatalog newCatalog, List<DboNewNews> newslist, int page, int pages) throws Exception {
		PrintWriter pw = null;
		String tempName = "list/page_" + newCatalog.getCatalogid() + ".ftl";
		Template t = null;
		try {
			t = cfg.getTemplate(tempName);
		} catch (FileNotFoundException e) {
			// Ĭ��ģ��
			tempName = "list/ctlist.ftl";
			t = cfg.getTemplate(tempName);
		}
		File file = new File(MyConfig.html_che_path + "list/" + newCatalog.getCatalogid() + "/list_" + page + ".html");
		System.out.println("HtmlGenerator.genNewList(): " + tempName + " >>> " + file.getPath());
		new File(file.getParent()).mkdirs();
		file.createNewFile();
		pw = new PrintWriter(new FileOutputStream(file, false));
		Map<Object, Object> root = new HashMap<Object, Object>();

		root.put("ver", System.currentTimeMillis());
		root.put("newCatalog", newCatalog);
		root.put("newslist", newslist);
		root.put("page", page);
		root.put("pages", pages);
		t.process(root, pw);
		if (pw != null) {
			pw.close();
		}
	}

	// public static void genNewPage(DboNewNews news, Object[] param) throws
	// Exception {
	// genNewPage(news, param, 1);
	// }

	// Ԥ������ҳ
	public static String preNewPage(DboNewNews news, DboNewContent content, DboCarCatalognew carCatalog, int page, int pageSize) throws Exception {
		StringWriter sw = null;
		String tempName = "new/page_" + news.getNewscatalogid() + ".ftl";
		Template t = null;
		try {
			t = cfg.getTemplate(tempName);
		} catch (FileNotFoundException e) {
			// Ĭ��ģ��
			tempName = "new/ctnews.ftl";
			t = cfg.getTemplate(tempName);
		}
		File file = new File(MyConfig.html_che_path + "new/" + news.getNewscatalogid() + "/page_" + news.getId() + "_" + page + ".html");
		System.out.println("HtmlGenerator.previewNews(): " + tempName + " >>> " + file.getPath());
		new File(file.getParent()).mkdirs();
		file.createNewFile();
		sw = new StringWriter();
		Map<Object, Object> root = new HashMap<Object, Object>();

		root.put("ver", System.currentTimeMillis());

		root.put("che_url", MyConfig.che_url);
		root.put("wap_ct_url", MyConfig.wap_ct_url);
		root.put("admin_che_url", MyConfig.admin_che_url);
		root.put("img_che_url", MyConfig.img_che_url);
		root.put("html_pic_upload_path", MyConfig.html_pic_upload_path);
		root.put("inf_che_url", MyConfig.inf_che_url);
		root.put("4s_che_url", MyConfig.dea_che_url);
		root.put("auto_che_url", MyConfig.auto_che_url);
		root.put("pk_che_url", MyConfig.pk_che_url);
		root.put("che_che_url", MyConfig.che_che_url);
		root.put("html_che_path", MyConfig.html_che_path);
		root.put("price_che_url", MyConfig.price_che_url);
		root.put("sun_che_url", MyConfig.sun_che_url);
		root.put("tousu_che_url", MyConfig.tousu_che_url);
		root.put("koubei_che_url", MyConfig.koubei_che_url);
		root.put("bbs_che_url", MyConfig.bbs_che_url);
		root.put("err_img", MyConfig.err_img);
		root.put("city_che_url", MyConfig.city_che_url);

		root.put("news", news);
		root.put("carCatalog", carCatalog);
		root.put("content", content);
		root.put("contentStr", content.getNewscontent());
		root.put("page", page);
		root.put("pageSize", pageSize);
		t.process(root, sw);
		if (sw != null) {
			sw.close();
		}
		return sw.toString();
	}

	// ��������ҳ
	public static void genSitemapXML(List<TbSiteMap> siteMaps, int page) throws Exception {
		PrintWriter pw = null;
		String tempName = "xml/sitemap.ftl";
		Template t = null;
		t = cfg.getTemplate(tempName);
		try {
			File file = new File(MyConfig.html_che_path + "sitemap_" + page + ".xml");
			System.out.println("HtmlGenerator.genSitemapXML(): " + tempName + " >>> " + file.getPath());
			new File(file.getParent()).mkdirs();
			file.createNewFile();
			pw = new PrintWriter(new FileOutputStream(file, false));
			Map<Object, Object> root = new HashMap<Object, Object>();

			root.put("siteMaps", siteMaps);
			root.put("page", page);

			t.process(root, pw);
			if (pw != null) {
				pw.close();
			}
		} catch (Error err) {
			System.out.println("ERROR >>> >>>");
			err.printStackTrace();
		}
	}

	private static String replaceKeyword(String body) {
		// TODO Auto-generated method stub
		List<TbKeywords> list = KeywordsService.queryAllKeywords();
		for (TbKeywords tbKeywords : list) {
			String keyS = tbKeywords.getKeyword();
			body = body.replaceFirst(keyS, "<a style=\"border-bottom:1px dotted #ccc;\" href=" + tbKeywords.getUrl() + ">" + keyS + "</a>");
		}
		return body;
	}

	// ��������ҳ
	public static void genCarPage(DboNewNews news) throws Exception {
		PrintWriter pw = null;
		String tempName = "car/page" + news.getNewscatalogid() + ".ftl";
		Template t = cfg.getTemplate(tempName);
		File file = new File(MyConfig.html_che_path + "car/" + news.getNewscatalogid());
		System.out.println("HtmlGenerator.genCarPage(): " + tempName + " >>> " + file.getPath());
		if (!file.isDirectory()) {
			new File(MyConfig.html_che_path + "car/" + news.getNewscatalogid()).mkdir();
		}
		pw = new PrintWriter(new FileOutputStream(MyConfig.html_che_path + "car/" + news.getNewscatalogid() + "/page_" + news.getId() + ".html"));
		Map<Object, Object> root = new HashMap<Object, Object>();

		root.put("ver", System.currentTimeMillis());
		root.put("news", news);
		t.process(root, pw);
		if (pw != null) {
			pw.close();
		}
	}

	// ��������ҳ
	public static void genImgPage(DboNewNews news) throws Exception {
		PrintWriter pw = null;
		String tempName = "img/page" + news.getNewscatalogid() + ".ftl";
		Template t = cfg.getTemplate(tempName);
		File file = new File(MyConfig.html_che_path + "img/" + news.getNewscatalogid());
		System.out.println("HtmlGenerator.genImgPage(): " + tempName + " >>> " + file.getPath());
		if (!file.isDirectory()) {
			new File(MyConfig.html_che_path + "img/" + news.getNewscatalogid()).mkdir();
		}
		pw = new PrintWriter(new FileOutputStream(MyConfig.html_che_path + "img/" + news.getNewscatalogid() + "/page_" + news.getId() + ".html"));
		Map<Object, Object> root = new HashMap<Object, Object>();

		root.put("ver", System.currentTimeMillis());
		root.put("news", news);
		t.process(root, pw);
		if (pw != null) {
			pw.close();
		}
	}

	// Ԥ��
	public static String preNewPage(DboNewNews news) throws Exception {
		StringWriter sw = null;
		String tempName = "new/page" + news.getNewscatalogid() + ".ftl";
		Template t = cfg.getTemplate(tempName);
		System.out.println("HtmlGenerator.preNewPage(): " + tempName);
		sw = new StringWriter();
		Map<Object, Object> root = new HashMap<Object, Object>();

		root.put("ver", System.currentTimeMillis());
		root.put("news", news);
		t.process(root, sw);
		if (sw != null) {
			sw.close();
		}
		return sw.toString();
	}

	// �����Զ��ļ�
	public static void genFile(String tempName, File file, Map<Object, Object> root) throws Exception {
		PrintWriter pw = null;
		// String tempName = "new/page" + news.getNewscatalogid() + ".ftl";
		Template t = cfg.getTemplate(tempName);
		System.out.println("HtmlGenerator.genFile(): " + tempName + " >>> " + file.getPath());
		// File file = new File(MyConfig.html_che_path + "index/index_" +
		// subContent.getId() +
		// ".html");
		new File(file.getParent()).mkdirs();
		file.createNewFile();
		pw = new PrintWriter(new FileOutputStream(file, false));
		// Map<Object,Object>root = new HashMap<Object,Object>();
		// MyConfig.IMG_VER;
		// root.put("ver", System.currentTimeMillis());
		// root.put("news", news);
		t.process(root, pw);
		if (pw != null) {
			pw.close();
		}
	}
}
