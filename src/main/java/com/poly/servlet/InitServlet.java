package com.poly.servlet;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.service.SeqService;
import com.poly.util.PublishNewsPageTask;
import com.poly.util.TaskManager;

//import org.apache.log4j.Logger;

//import org.jdom.Document;
//import org.jdom.Element;
//import org.jdom.input.SAXBuilder;

//import com.sun.corba.se.spi.servicecontext.ServiceContext;

public class InitServlet extends HttpServlet {

	public static Properties constant = new Properties();

	HttpServletRequest request;
	
	public static Properties p = new Properties();

	public static HashMap appConfig = new HashMap();

	public static HashMap goldIp = new HashMap();

	public static Pattern pt = null;

	public static ServletContext servletContext;

	public static String rootPath;

	public static int timer_gen_static_file = 7200000;
	
	public static int timer_public_news_page = 60000;

	public static int delay_sitemap = 24 * 60 *60 * 1000;

	// private static Logger logger =
	// Logger.getLogger(InitServlet.class.getName());

	public void init(ServletConfig config) {
		servletContext = config.getServletContext();
		rootPath = servletContext.getRealPath("/");
		System.out.println("rootPath====>" + rootPath);

		car_daos.DBConnectionManager.init(rootPath);
		//car_daos.DBConnectionManagerFin.init(rootPath);
		// ����maxid
//		SeqService.initMaxId();
		System.out.println(">>> >>> initservlet start");

		// ��ʱ����
		//TaskManager.startTask(new SyncTask(), 20000, timer_gen_static_file);// ���ɾ�̬FILE

		//TaskManager.startTask(new SitemapTask(), 5 * 1000 + (int)(Math.random() * (12 * 60 * 60 * 1000)), delay_sitemap);// ���ɾ�̬FILE
		
		TaskManager.startTask(new PublishNewsPageTask(), 10000, timer_public_news_page);
		//暂时未用 
		//TreeService.paiqitimer();
		
		// config.getServletContext()
		// ɾ����½cookie
		// CookieManager.delCookie(request, response, cookieName);
		// ��ʼ������
		// if (MemAsList.find(Category.mem_list) == null ||
		// MemAsMap.find(Category.mem_map) == null) {
		// CategoryService.getInstance().initMem();
		// logger.info("CategoryService.getInstance().initMem()...");
		// }

		//
		// DocumentService.getInstance().initData();
		// UploadFileService.getInstance().initData();
		//
		// AgencyService.getInstance().initData();
		// BrandService.getInstance().initData();
		// CarSerieService.getInstance().initData();
		// AgencyCarService.getInstance().initData();
		// NewCategoryService.getInstance().initData();
		// NewDocumentService.getInstance().initData();
		// OrderPreService.getInstance().initData();
		// CustomerService.getInstance().initData();

		// ManagerDao.getInstance().initData();

		// ��ȡϵͳ����constant.properties
		// Constant.reload(config.getServletContext());
		//
		// InputStream in = null;
		// try {
		// in = new FileInputStream(servletContext
		// .getRealPath("/WEB-INF/classes/constant.properties"));
		// Properties p = new Properties();
		// p.load(in);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		process(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		process(request, response);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("InitServlet.process");

		// ��ȡ��ϵͳ��Ϣapp.xml
		// String appPath = rootPath + "/WEB-INF/classes/";
		// java.io.File cfgxmlfile = new java.io.File(appPath + "app.xml");
		// try {
		// SAXBuilder builder = new SAXBuilder();
		// Document doc = builder.build(cfgxmlfile);
		// Element root = doc.getRootElement();
		// List apps = root.getChildren();
		// for (int i = 0; i < apps.size(); i++) {
		// App app = new App();
		// Element ele = (Element) apps.get(i);
		// int id = ele.getAttribute("id").getIntValue();
		// String name = ele.getAttribute("name").getValue();
		// String url = ele.getAttribute("url").getValue();
		// app.setId(id);
		// app.setName(name);
		// app.setUrl(url);
		// appConfig.put(new Integer(id), app);
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// goldIp.clear();
		// List ips = UserDAO.getAllGoldIp();
		// for (int i = 0; i < ips.size(); i++) {
		// goldIp.put(ips.get(i), "1");
		// }
		//
		// String type = request.getParameter("type");
		// System.out.println(type);
		// if (type != null) {
		// List list = ActiveDao.findAllGold();
		// for (int i = 0; i < list.size(); i++) {
		// User user = (User) list.get(i);
		// Constant.genGoldJs(user);
		// }
		// }
	}
}
