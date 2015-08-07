package com.poly.action.action_statistics;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import car_beans.DboNewNews;

import com.poly.action.MyActionSupport;
import com.poly.freemarkerMethod.RealnameMethod;
import com.poly.service.StatisticsService;
import com.poly.util.CalcPageUtil;

@SuppressWarnings("serial")
public class StatisticsAction extends MyActionSupport {

	private List<Map<String, String>> editors;

	private List<String> sites; // 分站集合

	private String addadmin;

	private Map<String, String> currEditor;

	private Date publishBeginTm;
	private Date publishEndTm;
	private String newsType;
	private String city;

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

	private int page;
	private int totalPage;
	private int pageSize = 10;

	private int detailFlag;// 是否详细查询

	private List<DboNewNews> newslist;

	private final int catalogid_hq = 43;// 行情

	private RealnameMethod realnameMethod = new RealnameMethod();

	public String search() {
		System.out.println("StatisticsAction.search()");

		try {

			if (publishBeginTm == null || publishEndTm == null) {
				setAjax("请选择时段");
				return AJAX;
			}

//			if (addadmin == null || addadmin.length()<2) {
//				setAjax("请选择编辑");
//				return AJAX;
//			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String beginStr = sdf.format(publishBeginTm);
			String endStr = sdf.format(publishEndTm);
			endStr += " 23:59:59";

			String resStr="";
			
			// 行情
			/*DboNewCatalog catalog_hq = NewsAdmService.queryNewsCatalogById(catalogid_hq);
			List<DboNewCatalog> allNewsCatalogList_hq = new ArrayList<DboNewCatalog>();

			NewsAdmService.getNewCatalogByFatherid(allNewsCatalogList_hq, catalog_hq);*/
			
			//软文
			String catalogidStr_rw = "";
			//行情
			String catalogidStr_hq = "";
			List<Integer> hqList = StatisticsService.getNewsMarketCatalogList();
			for (Integer catalogid : hqList) {
				catalogidStr_hq += "," + catalogid;
				catalogidStr_rw += "," + catalogid;
			}
			catalogidStr_hq = catalogidStr_hq.substring(1);
			//新车
			String newCarStr = "";
			List<Integer> newCarList = StatisticsService.getNewsCatalogList("135");
			for(Integer catalogid : newCarList){
				newCarStr+=","+catalogid;
				catalogidStr_rw += "," + catalogid;
			}
			newCarStr = newCarStr.substring(1);
			//新闻
			String newNewsStr = "";
			List<Integer> newNewsList = StatisticsService.getNewsCatalogList("50");
			for(Integer catalogid : newNewsList){
				newNewsStr+=","+catalogid;
				catalogidStr_rw += "," + catalogid;
			}
			newNewsStr = newNewsStr.substring(1);
			//软文
			catalogidStr_rw = catalogidStr_rw.substring(1);

			System.out.println("newsCatalogidStr-->" + catalogidStr_hq);
			if(city!=null&&!"".equals(city)&&(addadmin==null||"".equals(addadmin))){
				editors = StatisticsData.getEditorList();
				for(Map<String,String> map : editors){
					if(city.equals(map.get("ORG_NAME"))){
						addadmin += ",'"+map.get("addadmin")+"'";
					}
				}
				addadmin = addadmin.substring(1);
			}else if(addadmin!=null&&!"".equals(addadmin)){
				addadmin = "'"+addadmin+"'";
			}
			
			int amount_hq = 0;
			if(newsType.equals("行情")){
				amount_hq = StatisticsService.getInstance().amount(addadmin, beginStr, endStr, catalogidStr_hq);
				resStr +="行情："+amount_hq;
			}else if(newsType.equals("软文")){
				amount_hq = StatisticsService.getInstance().otherAmount(addadmin, beginStr, endStr, catalogidStr_rw);
				resStr +="软文："+amount_hq;
			}else if(newsType.equals("原创新闻")){
				amount_hq = StatisticsService.getInstance().originalAmount(addadmin, beginStr, endStr);
				resStr +="原创新闻："+amount_hq;
			}else if(newsType.equals("新车")){
				amount_hq =  StatisticsService.getInstance().newCarAmount(addadmin, beginStr, endStr, newCarStr);
				resStr +="新车："+amount_hq;
			}else if(newsType.equals("新闻")){
				amount_hq =  StatisticsService.getInstance().newsAmount(addadmin, beginStr, endStr, newNewsStr);
				resStr +="新闻："+amount_hq;
			}else{
				amount_hq = StatisticsService.getInstance().allAmount(addadmin, beginStr, endStr, catalogidStr_hq);
				resStr = "总新闻数："+amount_hq+"，软文："+StatisticsService.getInstance().otherAmount(addadmin, beginStr, endStr, catalogidStr_rw)+"，行情："+StatisticsService.getInstance().amount(addadmin, beginStr, endStr, catalogidStr_hq)+"，原创新闻："+StatisticsService.getInstance().originalAmount(addadmin, beginStr, endStr);
				resStr += "，新车："+StatisticsService.getInstance().newCarAmount(addadmin, beginStr, endStr, newCarStr)+"，新闻："+StatisticsService.getInstance().newsAmount(addadmin, beginStr, endStr, newNewsStr);
			}
			//
			
			setAjax(resStr);
			//
			if (detailFlag == 1) {
				totalPage = CalcPageUtil.getPages(amount_hq, pageSize);
				if (page < 1)
					page = 1;
				if (page > totalPage)
					page = totalPage;

				int begin = (page - 1) * pageSize;
				if(newsType.equals("行情")){
					newslist = StatisticsService.getInstance().list(addadmin, beginStr, endStr, begin, pageSize, catalogidStr_hq);
				}else if(newsType.equals("软文")){
					newslist = StatisticsService.getInstance().otherList(addadmin, beginStr, endStr, begin, pageSize, catalogidStr_hq);
				}else if(newsType.equals("原创新闻")){
					newslist = StatisticsService.getInstance().originalList(addadmin, beginStr, endStr, begin, pageSize);
				}else if(newsType.equals("新车")){
					newslist = StatisticsService.getInstance().newCarList(addadmin, beginStr, endStr, begin, pageSize, newCarStr);
				}else if(newsType.equals("新闻")){
					newslist = StatisticsService.getInstance().newCarList(addadmin, beginStr, endStr, begin, pageSize, newNewsStr);
				}else{
					newslist = StatisticsService.getInstance().allList(addadmin, beginStr, endStr, begin, pageSize);
				}

				setErr(resStr);
				return "stat_news_list_sub";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return AJAX;
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

	public int getDetailFlag() {
		return detailFlag;
	}

	public void setDetailFlag(int detailFlag) {
		this.detailFlag = detailFlag;
	}

	public List<DboNewNews> getNewslist() {
		return newslist;
	}

	public void setNewslist(List<DboNewNews> newslist) {
		this.newslist = newslist;
	}

	public int getCatalogid_hq() {
		return catalogid_hq;
	}

	public RealnameMethod getRealnameMethod() {
		return realnameMethod;
	}

	public void setRealnameMethod(RealnameMethod realnameMethod) {
		this.realnameMethod = realnameMethod;
	}

	public String getNewsType() {
		return newsType;
	}

	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
