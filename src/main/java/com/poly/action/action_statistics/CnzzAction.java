package com.poly.action.action_statistics;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.poly.action.MyActionSupport;
import com.poly.freemarkerMethod.RealnameMethod;
import com.redis.Redis2Dao;

@SuppressWarnings("serial")
public class CnzzAction extends MyActionSupport {

	private List<Map<String, String>> editors;

	private List<String> sites; // 分站集合

	private String addadmin;

	private Map<String, String> currEditor;

	private Date publishBeginTm;
	private Date publishEndTm;
	private String site;

	public String view() {

		System.out.println("StatisticsAction.view()");

		try {
			editors = StatisticsData.getEditorList();
			
			sites = StatisticsData.getSites();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}

	private int page=1;
	private int totalPage;
	private int pageSize = 10;

	private int detailFlag;// 是否详细查询

	//private List<DboNewNews> newslist;
	private List<Map<String,String>> newslist;

	//private final int catalogid_hq = 43;// 行情

	private RealnameMethod realnameMethod = new RealnameMethod();
	
	//总浏览次数
	private int  allCount;
	//总独立访客
	private int  allPeopleCount;
	
	
	private String csvPath;
	
	private String newsType;
	
	//每人的文章访问总量
	private Map<String,Map<String,Integer>> countMap;

	public String search() {
		System.out.println("StatisticsAction.search()");

		try {

			if (csvPath == null || csvPath.length() <2) {
				setAjax("请先上传csv文件");
				return AJAX;
			}
			
			if(detailFlag==1){
				for(Map<String,String> map : getListByParam(csvPath,addadmin,publishBeginTm,publishEndTm,newsType)){
					allCount +=Integer.valueOf(map.get("count"));
					allPeopleCount +=Integer.valueOf(map.get("peopleCount"));
				}
				
				int count = getListByParam(csvPath,addadmin,publishBeginTm,publishEndTm,newsType).size();
				int from = (page-1)*pageSize;
				totalPage = count/10 + 1;
				int end = page*pageSize;
				if(end > count){
					end = count;
				}
				newslist = getListByParam(csvPath,addadmin,publishBeginTm,publishEndTm,newsType).subList(from,end);
				return "stat_news_list_sub";
			}else{
				List<Map<String,String>> objList = getListByParam(csvPath,addadmin,publishBeginTm,publishEndTm,newsType);
				/*for(Map<String,String> map : objList){
					if(countMap.containsKey(map.get("addadmin"))){
						Map<String,Integer> objmap = countMap.get(map.get("addadmin"));
						objmap.put("totalCount",objmap.get("totalCount")+Integer.valueOf(map.get("count")));
						objmap.put("totalPeopleCount",objmap.get("totalPeopleCount")+Integer.valueOf(map.get("peopleCount")));
						objmap.put("totalIpCount",objmap.get("totalIpCount")+Integer.valueOf(map.get("ipCount")));
						//objmap.put("totalPerCount",objmap.get("totalPerCount")+Integer.valueOf(map.get("perCount")));
						objmap.put("totalPvCount",objmap.get("totalPvCount")+Integer.valueOf(map.get("pvCount")));
						countMap.put(map.get("addadmin"), objmap);
					}else{
						Map<String,Integer> objmap = new HashMap<String, Integer>();
						objmap.put("totalCount",Integer.valueOf(map.get("count")));
						objmap.put("totalPeopleCount",Integer.valueOf(map.get("peopleCount")));
						objmap.put("totalIpCount",Integer.valueOf(map.get("ipCount")));
						//objmap.put("totalPerCount",Integer.valueOf(map.get("perCount")));
						objmap.put("totalPvCount",Integer.valueOf(map.get("pvCount")));
						countMap.put(map.get("addadmin"), objmap);
					}
				}*/
				getAddAdminNewsCount(objList);
				return "cnzz_count_list_sub";
			}
			
			//StatisticsData.getCSVList(csvPath);
			
			
			
			

//			// if (addadmin == null || addadmin.length()<2) {
//			// setAjax("请选择编辑");
//			// return AJAX;
//			// }
//
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			String beginStr = sdf.format(publishBeginTm);
//			String endStr = sdf.format(publishEndTm);
//			endStr += " 23:59:59";
//
//			String resStr = "";
//
//			// 行情
//			DboNewCatalog catalog_hq = NewsAdmService.queryNewsCatalogById(catalogid_hq);
//			List<DboNewCatalog> allNewsCatalogList_hq = new ArrayList<DboNewCatalog>();
//
//			NewsAdmService.getNewCatalogByFatherid(allNewsCatalogList_hq, catalog_hq);
//
//			String catalogidStr_hq = "";
//			for (DboNewCatalog dboNewCatalog : allNewsCatalogList_hq) {
//				catalogidStr_hq += "," + dboNewCatalog.getCatalogid();
//			}
//			catalogidStr_hq = catalogidStr_hq.substring(1);
//			System.out.println("newsCatalogidStr-->" + catalogidStr_hq);
//
//			//
//			int amount_hq = StatisticsService.getInstance().amount(addadmin, beginStr, endStr, catalogidStr_hq);
//			resStr += "行情：" + amount_hq;
//
//			setAjax(resStr);
//			//
//			if (detailFlag == 1) {
//				totalPage = CalcPageUtil.getPages(amount_hq, pageSize);
//				if (page < 1)
//					page = 1;
//				if (page > totalPage)
//					page = totalPage;
//
//				int begin = (page - 1) * pageSize;
//
//				newslist = StatisticsService.getInstance().list(addadmin, beginStr, endStr, begin, pageSize, catalogidStr_hq);
//
//				setErr(resStr);
//				return "stat_news_list_sub";
//			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return AJAX;
	}
	
	//获取对应条件的数据
	private List<Map<String,String>> getListByParam(String csvPath,String addadmin,Date beginTm,Date endTm,String newsType) throws ParseException{
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<Map<String,String>> objList = StatisticsData.csvMap.get(csvPath);
		
		if(addadmin!=null&&!"".equals(addadmin)&&beginTm!=null&&!"".equals(beginTm)&&newsType!=null&&!"".equals(newsType)){
			for(Map<String,String> map : objList){
				if(map.get("newsType").equals(newsType)&&map.get("addadmin").equals(addadmin)&&judgeTime(beginTm, endTm, map.get("adddate").toString())){
					list.add(map);
				}
			}
		}else if(addadmin!=null&&!"".equals(addadmin)&&newsType!=null&&!"".equals(newsType)){
			for(Map<String,String> map : objList){
				if(map.get("newsType").equals(newsType)&&map.get("addadmin").equals(addadmin)){
					list.add(map);
				}
			}
		}else if(addadmin!=null&&!"".equals(addadmin)&&beginTm!=null&&!"".equals(beginTm)){
			for(Map<String,String> map : objList){
				if(judgeTime(beginTm, endTm, map.get("adddate").toString())&&map.get("addadmin").equals(addadmin)){
					list.add(map);
				}
			}
		}else if(newsType!=null&&!"".equals(newsType)&&beginTm!=null&&!"".equals(beginTm)){
			for(Map<String,String> map : objList){
				if(judgeTime(beginTm, endTm, map.get("adddate").toString())&&map.get("newsType").equals(newsType)){
					list.add(map);
				}
			}
		}else if(beginTm!=null&&!"".equals(beginTm)){
			for(Map<String,String> map : objList){
				if(judgeTime(beginTm, endTm, map.get("adddate").toString())){
					list.add(map);
				}
			}
		}else if(addadmin!=null&&!"".equals(addadmin)){
			for(Map<String,String> map : objList){
				if(map.get("addadmin").equals(addadmin)){
					list.add(map);
				}
			}
		}else if(newsType!=null&&!"".equals(newsType)){
			for(Map<String,String> map : objList){
				if(map.get("newsType").equals(newsType)){
					list.add(map);
				}
			}
		}else{
			list = objList;
		}
		 //排序
		Collections.sort(list, new Comparator<Map<String, String>>(){
			@Override
			public int compare(Map<String, String> o1, Map<String, String> o2) {
				if(Integer.valueOf(o1.get("count")).compareTo(Integer.valueOf(o2.get("count")))>0) {
					return -1;
				} 
				return 1;
			}
		});
		
		//获取分站对应的编辑
		
		if((addadmin==null||"".equals(addadmin))&&site!=null&&!"".equals(site)){
			try {
				editors = StatisticsData.getEditorList();
				List<String> editorList = new ArrayList<String>();
				for(int i=0;i<editors.size();i++){
					if(editors.get(i).get("ORG_NAME").equals(site)){
						editorList.add(editors.get(i).get("addadmin"));
					}
				} 
				List<Map<String,String>> dataList = new ArrayList<Map<String,String>>(10000);
				for(int i=0;i<list.size();i++){
					Map<String,String> objMap = list.get(i);
					if(editorList.contains(objMap.get("addadmin"))){
						dataList.add(objMap);
					}
				}
				return dataList;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}
	
	//获取编辑新闻点击总数
	private void getAddAdminNewsCount(List<Map<String,String>> objList){
		countMap = new HashMap<String, Map<String,Integer>>();
		for(Map<String,String> map : objList){
			if(countMap.containsKey(map.get("addadmin"))){
				Map<String,Integer> objmap = countMap.get(map.get("addadmin"));
				objmap.put("totalCount",objmap.get("totalCount")+Integer.valueOf(map.get("count")));
				objmap.put("totalPeopleCount",objmap.get("totalPeopleCount")+Integer.valueOf(map.get("peopleCount")));
				objmap.put("totalIpCount",objmap.get("totalIpCount")+Integer.valueOf(map.get("ipCount")));
				//objmap.put("totalPerCount",objmap.get("totalPerCount")+Integer.valueOf(map.get("perCount")));
				objmap.put("totalPvCount",objmap.get("totalPvCount")+Integer.valueOf(map.get("pvCount")));
				countMap.put(map.get("addadmin"), objmap);
			}else{
				Map<String,Integer> objmap = new HashMap<String, Integer>();
				objmap.put("totalCount",Integer.valueOf(map.get("count")));
				objmap.put("totalPeopleCount",Integer.valueOf(map.get("peopleCount")));
				objmap.put("totalIpCount",Integer.valueOf(map.get("ipCount")));
				//objmap.put("totalPerCount",Integer.valueOf(map.get("perCount")));
				objmap.put("totalPvCount",Integer.valueOf(map.get("pvCount")));
				countMap.put(map.get("addadmin"), objmap);
			}
		}
	}
	
	
	
	//判断日期
	private boolean judgeTime(Date beginTm,Date endTm,String objDate) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		boolean flag = false;
		if(sdf.parse(objDate).getTime()>=beginTm.getTime()&&sdf.parse(objDate).getTime()<=endTm.getTime()){
			flag = true; 
		}
		return flag;
	}
	
	
	public void ExportUserToExcel() throws Exception{
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		String now = sdf1.format(calendar.getTime());
		String filename = "新闻点击统计" + now + ".xls";
		String newName = "";
		if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
			newName = new String(filename.getBytes("UTF-8"), "ISO8859-1");
		} else {
			if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0)
				newName = URLEncoder.encode(filename, "UTF-8");
			else if (request.getHeader("User-Agent").toUpperCase().indexOf("CHROME") > 0) 
				newName = new String(filename.getBytes("UTF-8"), "ISO8859-1");
		}
		response.setContentType("application/msexcel;charset=gbk");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ newName);
		response.addHeader("Pargam", "no-cache");
		response.addHeader("Cache-Control", "no-cache");
		System.out.println(CnzzAction.class.getResource("/").getPath()+"=======");
		
		String location = CnzzAction.class.getResource("/").getPath()
				.replace("classes/", "ftl")+"/statistics/excel/signtemplate.xls";
		if(detailFlag==0){
			location = CnzzAction.class.getResource("/").getPath()
					.replace("classes/", "ftl")+"/statistics/excel/counttemplate.xls";
		}
		
			
		
		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(location));
		HSSFWorkbook workbook = new HSSFWorkbook(fs);
		HSSFSheet sheet = workbook.getSheetAt(0);
		//ExportExcel excel = new ExportExcel(workbook, sheet);
//		//创建列表头的list
//		List<String> params = new ArrayList<String>();
//		params.add("序号");
//		params.add("员工编号");
//		params.add("姓名");
//		params.add("性别");
//		params.add("所属站点");
//		params.add("所属部门");
//		params.add("工作职位");
//		params.add("入职日期");
//		params.add("员工qq");
//		params.add("联系方式");
//		
		//计算该报表的列数
		//int colNumber = params.size();
		
		//设置列的高度
		/*for(int i=0;i<colNumber;i++){
			sheet.setColumnWidth(i, 500);
		}*/
		
		//获取excel的样式
		HSSFCellStyle style = workbook.createCellStyle();
		//指定单元格水平居中
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		//指定单元格垂直居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		//指定单元格自动换行
		style.setWrapText(true);
		//设置单元格字体  
        HSSFFont font = workbook.createFont();  
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
        font.setFontName("宋体");  
        font.setFontHeight((short) 200);  
        style.setFont(font); 
        
        //创建报表头部  
       // excel.createNormalHead("人事信息表格",colNumber);
        
        // 设置第二行  
        //excel.createNormalTwoRow(params, number);  
  
        // 设置列头  
        /*HSSFRow row2 = sheet.createRow(1);  
        for(int i=0;i<params.size();i++){
        	HSSFCell cell = row2.createCell(i);
        	cell.setCellStyle(style);
        	cell.setCellValue(params.get(i).toString());
        } */
        if(detailFlag==0){
        	List<Map<String,String>> objList = getListByParam(java.net.URLDecoder.decode(csvPath,"UTF-8"),addadmin,publishBeginTm,publishEndTm,java.net.URLDecoder.decode(newsType,"UTF-8"));
        	getAddAdminNewsCount(objList);
        	int i=0;
        	for(String key : countMap.keySet()){
        		Map<String,Integer> map = countMap.get(key);
        		
        		HSSFRow row = sheet.createRow(i+2);
	        	HSSFCell cell0 = row.createCell(0);
	        	cell0.setCellStyle(style);
	        	cell0.setCellValue(i+1);

	        	HSSFCell cell1 = row.createCell(1);
	        	cell1.setCellStyle(style);
	        	cell1.setCellValue(Redis2Dao.getAllEditorByUsername(key).get("realname")==null?key:Redis2Dao.getAllEditorByUsername(key).get("realname"));
	        	
	        	HSSFCell cell2 = row.createCell(2);
	        	cell2.setCellStyle(style);
	        	cell2.setCellValue(map.get("totalCount"));
	        	
				HSSFCell cell3 = row.createCell(3);
	        	cell3.setCellStyle(style);
				cell3.setCellValue(map.get("totalPeopleCount"));
	        	
	        	HSSFCell cell4 = row.createCell(4);
	        	cell4.setCellStyle(style);
	        	cell4.setCellValue(map.get("totalIpCount"));
	        	
	        	HSSFCell cell5 = row.createCell(5);
	        	cell5.setCellStyle(style);
	        	cell5.setCellValue(map.get("totalPvCount"));
        		i++;
        	}
        	
        }else{
			newslist = getListByParam(java.net.URLDecoder.decode(csvPath,"UTF-8"),addadmin,publishBeginTm,publishEndTm,java.net.URLDecoder.decode(newsType,"UTF-8"));
			//录入数据
			if(newslist!=null&&newslist.size()>0){
				for(int i=0;i<newslist.size();i++){
		        	HSSFRow row = sheet.createRow(i+2);
		        	HSSFCell cell0 = row.createCell(0);
		        	cell0.setCellStyle(style);
		        	cell0.setCellValue(i+1);
	
		        	HSSFCell cell1 = row.createCell(1);
		        	cell1.setCellStyle(style);
		        	cell1.setCellValue(newslist.get(i).get("newstitle"));
		        	
		        	HSSFCell cell2 = row.createCell(2);
		        	cell2.setCellStyle(style);
		        	cell2.setCellValue(Redis2Dao.getAllEditorByUsername(newslist.get(i).get("addadmin")).get("realname")==null?newslist.get(i).get("addadmin"):Redis2Dao.getAllEditorByUsername(newslist.get(i).get("addadmin")).get("realname"));
		        	
	
					HSSFCell cell3 = row.createCell(3);
		        	cell3.setCellStyle(style);
		        	cell3.setCellValue(newslist.get(i).get("newsType"));
		        	
		        	HSSFCell cell4 = row.createCell(4);
		        	cell4.setCellStyle(style);
		        	cell4.setCellValue(newslist.get(i).get("adddate"));
		        	
		        	HSSFCell cell5 = row.createCell(5);
		        	cell5.setCellStyle(style);
		        	cell5.setCellValue(newslist.get(i).get("count"));
		        	
		        	HSSFCell cell6 = row.createCell(6);
		        	cell6.setCellStyle(style);
		        	cell6.setCellValue(newslist.get(i).get("peopleCount"));
		        	
		        	HSSFCell cell7 = row.createCell(7);
		        	cell7.setCellStyle(style);
		        	cell7.setCellValue(newslist.get(i).get("ipCount"));
		        	
		        	HSSFCell cell8 = row.createCell(8);
		        	cell8.setCellStyle(style);
		        	cell8.setCellValue(newslist.get(i).get("perCount"));
		        	
		        	HSSFCell cell9 = row.createCell(9);
		        	cell9.setCellStyle(style);
		        	cell9.setCellValue(newslist.get(i).get("pvCount"));
		        	
		        	HSSFCell cell10 = row.createCell(10);
		        	cell10.setCellStyle(style);
		        	cell10.setCellValue(newslist.get(i).get("time"));
		        }  
			}
        }
        
        workbook.write(response.getOutputStream());
	}
	

	private File image; // 上传的文件
	private String imageFileName; // 文件名称
	private String imageContentType; // 文件类型

	public String uploadCVS() throws Exception {
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
		
		editors = StatisticsData.getEditorList();
		sites = StatisticsData.getSites();
		StatisticsData.getCSVList(realpath+File.separator+imageFileName);
		setAjax(realpath+File.separator+imageFileName);
		return AJAX;
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

	public List<Map<String, String>> getEditors() {
		return editors;
	}

	public void setEditors(List<Map<String, String>> editors) {
		this.editors = editors;
	}

	public List<String> getSites() {
		return sites;
	}

	public void setSites(List<String> sites) {
		this.sites = sites;
	}

	public Map<String, String> getCurrEditor() {
		return currEditor;
	}

	public void setCurrEditor(Map<String, String> currEditor) {
		this.currEditor = currEditor;
	}

	public Date getPublishBeginTm() {
		return publishBeginTm;
	}

	public void setPublishBeginTm(Date publishBeginTm) {
		this.publishBeginTm = publishBeginTm;
	}

	public Date getPublishEndTm() {
		return publishEndTm;
	}

	public void setPublishEndTm(Date publishEndTm) {
		this.publishEndTm = publishEndTm;
	}

	public String getAddadmin() {
		return addadmin;
	}

	public void setAddadmin(String addadmin) {
		this.addadmin = addadmin;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getCsvPath() {
		return csvPath;
	}

	public void setCsvPath(String csvPath) {
		this.csvPath = csvPath;
	}

	public int getDetailFlag() {
		return detailFlag;
	}

	public void setDetailFlag(int detailFlag) {
		this.detailFlag = detailFlag;
	}

	public List<Map<String, String>> getNewslist() {
		return newslist;
	}

	public void setNewslist(List<Map<String, String>> newslist) {
		this.newslist = newslist;
	}

	/*public List<DboNewNews> getNewslist() {
		return newslist;
	}

	public void setNewslist(List<DboNewNews> newslist) {
		this.newslist = newslist;
	}

	public int getCatalogid_hq() {
		return catalogid_hq;
	}
*/
	public RealnameMethod getRealnameMethod() {
		return realnameMethod;
	}

	public void setRealnameMethod(RealnameMethod realnameMethod) {
		this.realnameMethod = realnameMethod;
	}

	public int getAllCount() {
		return allCount;
	}

	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}

	public int getAllPeopleCount() {
		return allPeopleCount;
	}

	public void setAllPeopleCount(int allPeopleCount) {
		this.allPeopleCount = allPeopleCount;
	}

	public String getNewsType() {
		return newsType;
	}

	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}

	public Map<String, Map<String, Integer>> getCountMap() {
		return countMap;
	}

	public void setCountMap(Map<String, Map<String, Integer>> countMap) {
		this.countMap = countMap;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
}
