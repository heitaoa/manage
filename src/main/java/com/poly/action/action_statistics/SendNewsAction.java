package com.poly.action.action_statistics;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.namespace.QName;

import net.sf.json.JSONArray;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.poly.action.MyActionSupport;
import com.poly.dao.DboSendCshDao;
import com.poly.service.StatisticsService;
import com.poly.util.UrlChangeUtil;
import com.redis.Redis2Dao;

public class SendNewsAction extends MyActionSupport {

	// 新闻开始时间
	private String fromTime;
	private String toTime;
	//已推送到车生活数据
	private Map<String,String> oldMap = new HashMap<String, String>();
	//待更新的新闻数据
	private Map<String,String> updateMap = new HashMap<String, String>();
	// 待插入的新闻数据
	private Map<String,String> saveMap = new HashMap<String, String>();
	//上传的文件名称
	private String fileName;
	
	public String toSendNews(){
		return SUCCESS;
	}
	
	public void sendNews() throws Exception{
		getNewsCountInfo(fileName);
		Map<String,String> map = new HashMap<String, String>();
		String saveresult = "";
		String updateresult = "";
		if(!saveMap.isEmpty()){
			saveresult = sendNewsToChe();
		}
		//如果推送成功，，将最新的数据录入数据库
		if(isNumeric(saveresult)&&saveresult!="-1"){
			for(String key : saveMap.keySet()){
				DboSendCshDao.saveDboSendCsh(key,saveMap.get(key));
			}
			map.put("saveresult","true");
		}else{
			map.put("saveresult","false");
		}
		
		if(!updateMap.isEmpty()){
			updateresult = updateNewsToChe();
		}
		//如果推送成功，，将最新的数据录入数据库
		if(isNumeric(updateresult)&&updateresult!="-1"){
			for(String key : updateMap.keySet()){
				DboSendCshDao.updateDboSendCsh(key,updateMap.get(key));
			}
			map.put("updateresult","true");
		}else{
			map.put("updateresult","false");
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(map);
		out.print(json.toString());
		out.close();
	}
	
	//判断字符串是否为数字
	public boolean isNumeric(String str){ 
	   Pattern pattern = Pattern.compile("^-?[0-9]+"); 
	   Matcher isNum = pattern.matcher(str);
	   if( !isNum.matches() ){
	       return false; 
	   } 
	   return true; 
	}
	

	//向车生活推送数据
	private String sendNewsToChe() throws Exception{
		//String newsDataXml = genNewsXml(fromTime,toTime);
		//调用webservice接口
		String result = "-1";
		try {

			String endpoint = "http://nsws.btbo.me/NewsWebService.asmx";
			//String endpoint = "";
			//直接引用远程的wsdl文件
			//以下都是套路
			//String newsDataXml = genNewsXml(fromTime,toTime);
			String newsDataXml = genNewsXmlByMap(saveMap);
	        //String newsDataXml = "接口测试";
			//String newsDataXml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><News><NewsModel><title>测试新闻</title><subtitle>副标题</subtitle><digest>引言</digest><cover_img>http://img.test.com/14794238233.jpeg</cover_img><content>新闻内容</content><url>http://www.test.com?id=1</url><type>导购</type><source>新闻来源公司</source><published_time>2015-06-01 10:30:55</published_time><like_count>0</like_count><dislike_count>0</dislike_count><visit_count>0</visit_count><comment_count>0</comment_count></NewsModel></News>";
			String name= "qichexiaofei";
			String pwd ="btbo!@12345";
			String sign ="f67b83fabed6ceda2a049060662b6e9f";
			Service service = new Service();
			Call call = (Call) service.createCall();
			
			
			call.setTargetEndpointAddress(new java.net.URL(endpoint));   
		      
	        call.setOperationName(new QName("http://tempuri.org/","NewsData")); 
	        //call.setOperationName(new QName("http://tempuri.org/","TestMethod")); 
	            //Add 是net 那边的方法 "http://tempuri.org/" 这个也要注意Namespace 的地址,不带也会报错
	        call.addParameter(new QName("http://tempuri.org/","newsDataXml"), 
	                   org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
	        call.addParameter(new QName("http://tempuri.org/","name"), 
	        		org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
	        call.addParameter(new QName("http://tempuri.org/","pwd"), 
	        		org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
	        call.addParameter(new QName("http://tempuri.org/","sign"), 
	        		org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
	        // 这就是我搞了一天的原因所在,"test" 这个就是传参数的变量,也就是NET方面的参数,一定不要带错了
	            // 我当初不知道 ,以为这个参数是自己随便写的,结果总是报NULL,真是气死人了   
	        call.setUseSOAPAction(true);
	        call.setReturnType(org.apache.axis.encoding.XMLType.SOAP_STRING); //返回参数的类型
	        call.setSOAPActionURI("http://tempuri.org/NewsData"); //这个也要注意 就是要加上要调用的方法Add,不然也会报错

			//给方法传递参数，并且调用方法
			result = (String)call.invoke(new Object[]{newsDataXml,name,pwd,sign});
	        //String result = (String)call.invoke(new Object[]{name,pwd,sign});
			System.out.println("result is "+result);
		}
		catch (Exception e) {
			System.err.println(e.toString());
		}
		return result;
	}

	// 更新推送给车生活的数据
	private String updateNewsToChe() {
		String result = "-1";
		try {
			String endpoint = "http://nsws.btbo.me/NewsWebService.asmx";
			//String endpoint = "";
			String newsDataXml = genNewsXmlByMap(updateMap);
			String name= "qichexiaofei";
			String pwd ="btbo!@12345";
			String sign ="f67b83fabed6ceda2a049060662b6e9f";
			Service service = new Service();
			Call call = (Call) service.createCall();
			
			call.setTargetEndpointAddress(new java.net.URL(endpoint));   
		      
	        call.setOperationName(new QName("http://tempuri.org/","UpdateNewsData")); 
	        //Add 是net 那边的方法 "http://tempuri.org/" 这个也要注意Namespace 的地址,不带也会报错
	        call.addParameter(new QName("http://tempuri.org/","newsDataXml"), 
	                   org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
	        call.addParameter(new QName("http://tempuri.org/","name"), 
	        		org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
	        call.addParameter(new QName("http://tempuri.org/","pwd"), 
	        		org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
	        call.addParameter(new QName("http://tempuri.org/","sign"), 
	        		org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
	        // 这就是我搞了一天的原因所在,"test" 这个就是传参数的变量,也就是NET方面的参数,一定不要带错了
	            // 我当初不知道 ,以为这个参数是自己随便写的,结果总是报NULL,真是气死人了
	            
	        call.setUseSOAPAction(true);
	        call.setReturnType(org.apache.axis.encoding.XMLType.SOAP_STRING); //返回参数的类型
	        call.setSOAPActionURI("http://tempuri.org/UpdateNewsData"); //这个也要注意 就是要加上要调用的方法Add,不然也会报错
			//给方法传递参数，并且调用方法
			result = (String)call.invoke(new Object[]{newsDataXml,name,pwd,sign});
			System.out.println("result is "+result);
		}
		catch (Exception e) {
			System.err.println(e.toString());
		}
		return result;
	}

	// 批量删除数据
	// 更新推送给车生活的数据
	public void deleteNewsToChe() {

	}

	
	// 处理新闻数据生成xml格式的数据
	private String genNewsXmlByMap(Map<String,String> map) {
		StringBuffer sb = new StringBuffer();
		List<Map<String, String>> newsContentList = new ArrayList<Map<String, String>>();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>");
		sb.append("<News>");
		//获取对应目录下的子目录
		List<Integer> newCarList = StatisticsService.getNewsCatalogList("135");
		List<Integer> newNewsList = StatisticsService.getNewsCatalogList("50");
		List<Integer> driverList = StatisticsService.getNewsCatalogList("133");
		List<Integer> buyList = StatisticsService.getNewsCatalogList("1");

		Iterator<String> iterator = map.keySet().iterator();
		int num = 0;
		while (iterator.hasNext()) {
			// 获取相关新闻信息
			//获取新闻数据
			String key = iterator.next();
			String content = "";
			newsContentList = Redis2Dao.getNewsContentByNewsid(Integer
					.valueOf(key));
			if (newsContentList.size() > 0) {
				for (int j = 0; j < newsContentList.size(); j++) {
					List<Map<String, String>> contentInfoList = Redis2Dao
							.getContentbakByCid(Integer.valueOf(newsContentList
									.get(j).get("id")));
					if (contentInfoList.size() > 0) {
						Map<String, String> contentInfo = contentInfoList
								.get(0);
						content += contentInfo.get("contentstr");
					}
				}
			}
			if(content==null||"".endsWith(content)){
				iterator.remove();
				map.remove(key);
				continue;
			}
			Map<String,String> newsMap = Redis2Dao.getObjectsByKey("dbo_new_news:id:"+key);
			if(!newsMap.isEmpty()){
				
				String catalogid = newsMap.get("newscatalogid");// 新闻类型
				String catalogname = "";
				if(newCarList.contains(Integer.valueOf(catalogid))){
					catalogname = "新车";
				}else if(newNewsList.contains(Integer.valueOf(catalogid))){
					catalogname = "新闻";
				}else if(driverList.contains(Integer.valueOf(catalogid))){
					catalogname = "评测";
				}else if(buyList.contains(Integer.valueOf(catalogid))){
					catalogname = "导购";
				}else{
					iterator.remove();
					map.remove(key);
					continue;
				}
				System.out.println(catalogname);

				content = content.replaceAll("&nbsp", " ").replaceAll("&kmdt", "%")
						.replaceAll("< xml:", "<?xml:");
				String title = newsMap.get("newstitle")
						.replaceAll("&nbsp", " ").replaceAll("&kmdt", "%");// 标题
				
				String pic = newsMap.get("titlephoto");// 图片
				if (pic.indexOf("http://") == -1) {
					pic = UrlChangeUtil.FormatCom(newsMap.get("titlephoto"),0,0);
				}
				
				String adddate = newsMap.get("adddate")
						.replaceAll("&nbsp", " ");// 新闻添加时间
				// 新闻原链接
				String url = "http://inf.315che.com/n/"
						+ adddate.substring(0, 7).replace("-", "_") + "/"
						+ key + "/";
				
				/*Map<String, String> newsCatalogMap = Redis2Dao
						.getObjectsByKey("dbo_new_catalog:catalogid:" + catalogid);
				int rootcatalogid = 1;
				if (!newsCatalogMap.isEmpty()) {
					rootcatalogid = getRootNewsCatalogid(
							Integer.valueOf(newsCatalogMap.get("catalogid")),
							Integer.valueOf(newsCatalogMap.get("pathlevel")),
							Integer.valueOf(newsCatalogMap.get("fatherid")));
				}
				Map<String, String> rootCatalogMap = Redis2Dao
						.getObjectsByKey("dbo_new_catalog:catalogid:"
								+ rootcatalogid);*/
				//获取新闻评论数
				int comment_count = 0;
				comment_count = StatisticsService.getNewsCommentCount(key);
				sb.append("<NewsModel>");
				sb.append("<title>" + title + "</title>");
				sb.append("<subtitle></subtitle>");
				sb.append("<digest></digest>");
				sb.append("<cover_img>" + pic + "</cover_img>");
				sb.append("<content><![CDATA[" + content + "]]></content>");
				sb.append("<url>" + url + "</url>");
				sb.append("<type>" + catalogname + "</type>");
				sb.append("<source>中国汽车消费网</source>");
				sb.append("<published_time>" + adddate + "</published_time>");
				sb.append("<like_count>0</like_count>");
				sb.append("<dislike_count>0</dislike_count>");
				sb.append("<visit_count>"+map.get(key)+"</visit_count>");
				sb.append("<comment_count>"+comment_count+"</comment_count>");
				sb.append("</NewsModel>");
			}
			num++;
		}
		sb.append("</News>");
		System.out.println(map.size()+"------->"+num);
		return sb.toString();
	}

	
	
	// 处理新闻数据生成xml格式的数据
	private String genNewsXml(String fromTime, String toTime) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// SimpleDateFormat newsDataFormat = new SimpleDateFormat("yyyy-MM");
		long begintime = 0;
		long lasttime = 0;
		try {
			begintime = simpleDateFormat.parse(fromTime).getTime() / 1000;
			lasttime = simpleDateFormat.parse(toTime).getTime() / 1000;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取需要同步的新闻信息
		List<Map<String, String>> list = Redis2Dao.getNewsByOriginal("1",
				begintime, lasttime, 1, 1000);
		int count = list.size();
		StringBuffer sb = new StringBuffer();
		List<Map<String, String>> newsContentList = new ArrayList<Map<String, String>>();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>");
		sb.append("<News>");
		for (int i = 0; i < 1; i++) {
			// 获取相关新闻信息
			String title = list.get(i).get("newstitle")
					.replaceAll("&nbsp", " ").replaceAll("&kmdt", "%");// 标题
			String pic = list.get(i).get("titlephoto");// 图片
			if (pic.indexOf("http://") == -1) {
				pic = "http://img.315che.com/" + pic;
			}
			String content = "";
			newsContentList = Redis2Dao.getNewsContentByNewsid(Integer
					.valueOf(list.get(i).get("id")));
			if (newsContentList.size() > 0) {
				for (int j = 0; j < newsContentList.size(); j++) {
					List<Map<String, String>> contentInfoList = Redis2Dao
							.getContentbakByCid(Integer.valueOf(newsContentList
									.get(j).get("id")));
					if (contentInfoList.size() > 0) {
						Map<String, String> contentInfo = contentInfoList
								.get(0);
						content += contentInfo.get("contentstr");
					}
				}
			}
			content = content.replaceAll("&nbsp", " ").replaceAll("&kmdt", "%")
					.replaceAll("< xml:", "<?xml:");
			String adddate = list.get(i).get("adddate")
					.replaceAll("&nbsp", " ");// 新闻添加时间
			// 新闻原链接
			System.out.println(adddate + "----->>>adddate");
			String url = "http://inf.315che.com/n/"
					+ adddate.substring(0, 7).replace("-", "_") + "/"
					+ list.get(i).get("id") + "/";
			String catalogid = list.get(i).get("newscatalogid");// 新闻类型
			Map<String, String> newsCatalogMap = Redis2Dao
					.getObjectsByKey("dbo_new_catalog:catalogid:" + catalogid);
			int rootcatalogid = 1;
			if (!newsCatalogMap.isEmpty()) {
				rootcatalogid = getRootNewsCatalogid(
						Integer.valueOf(newsCatalogMap.get("catalogid")),
						Integer.valueOf(newsCatalogMap.get("pathlevel")),
						Integer.valueOf(newsCatalogMap.get("fatherid")));
			}
			Map<String, String> rootCatalogMap = Redis2Dao
					.getObjectsByKey("dbo_new_catalog:catalogid:"
							+ rootcatalogid);
			sb.append("<NewsModel>");
			sb.append("<title>" + title + "</title>");
			sb.append("<subtitle></subtitle>");
			sb.append("<digest></digest>");
			sb.append("<cover_img>" + pic + "</cover_img>");
			sb.append("<content><![CDATA[" + content + "]]></content>");
			sb.append("<url>" + url + "</url>");
			sb.append("<type>" + rootCatalogMap.get("catalogname") + "</type>");
			sb.append("<source>中国汽车消费网</source>");
			sb.append("<published_time>" + adddate + "</published_time>");
			sb.append("<like_count>0</like_count>");
			sb.append("<dislike_count>0</dislike_count>");
			sb.append("<visit_count>0</visit_count>");
			sb.append("<comment_count>0</comment_count>");
			sb.append("</NewsModel>");
		}
		sb.append("</News>");
		System.out.println(sb.toString());
		return sb.toString();
	}

	//上传cnzz信息
	private File image; // 上传的文件
	private String imageFileName; // 文件名称
	private String imageContentType; // 文件类型

	public String upload() throws Exception {
		String realpath = ServletActionContext.getServletContext().getRealPath("/images");
		// D:\apache-tomcat-6.0.18\webapps\struts2_upload\images
		System.out.println("realpath: " + realpath);
		imageFileName = System.currentTimeMillis()+imageFileName.substring(imageFileName.lastIndexOf("."),imageFileName.length());
		if (image != null) {
			File savefile = new File(new File(realpath), imageFileName);
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			FileUtils.copyFile(image, savefile);
			ActionContext.getContext().put("message", "文件上传成功");
		}
		//getNewsCountInfo(realpath+File.separator+imageFileName);
		setAjax(realpath+File.separator+imageFileName);
		return AJAX;
	}
	
	//获取上传的文件信息
	private void getNewsCountInfo(String pathname) throws Exception{
		DataInputStream dis = new DataInputStream(new FileInputStream(new File(pathname)));
		BufferedReader buff = new BufferedReader(new InputStreamReader(dis,"GBK"));
		oldMap = DboSendCshDao.getCshMap();
		String stemp;
		Random r = new Random();
		while((stemp=buff.readLine())!=null){
			if(stemp.length()>7){
				if (stemp.substring(0, 7).equals("http://")) {
					String[] arr = stemp.split(",");
					if (arr.length == 7) {
						//新闻链接
						String url = arr[0];
						//新闻浏览数
						String count = arr[1];
						/*if(Integer.valueOf(arr[1])<10000){
							count = String.valueOf(Integer.valueOf(arr[1])*(r.nextInt(5)+10));
						}*/
						//String count = String.valueOf(Integer.valueOf(arr[1])*(r.nextInt(5)+10));
						//新闻id
						String newsid = stemp.substring(32, url.lastIndexOf("/", 50));
						count = String.valueOf(Integer.valueOf(arr[1])*(r.nextInt(5)+10));
						if(oldMap.containsKey(newsid)){
							count = String.valueOf(Integer.valueOf(arr[1])*(r.nextInt(2)+1)+Integer.valueOf(oldMap.get(newsid)));
							updateMap.put(newsid,count);
						}else{	
							saveMap.put(newsid, count);
						}
					}
				}
			}
		}
	}
	
	// 获取原创新闻

	// 获取新闻类型
	// 取跟目录ID
	private int getRootNewsCatalogid(int catalogid, int pathlevel, int fatherid) {
		if (pathlevel == 1) {
			return catalogid;
		}
		Map<String, String> newsCatalogMap = Redis2Dao
				.getObjectsByKey("dbo_new_catalog:catalogid:" + fatherid);
		if (newsCatalogMap != null && newsCatalogMap.size() > 0) {
			int up_catalogid = Integer.valueOf(newsCatalogMap.get("catalogid"));
			int up_pathlevel = Integer.valueOf(newsCatalogMap.get("pathlevel"));
			int up_fatherid = Integer.valueOf(newsCatalogMap.get("fatherid"));

			return getRootNewsCatalogid(up_catalogid, up_pathlevel, up_fatherid);
		}
		return 0;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
