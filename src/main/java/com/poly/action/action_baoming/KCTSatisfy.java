package com.poly.action.action_baoming;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import car_beans.TbDataVisitRecord;
import car_daos.TbDataVisitRecordDao;

import com.poly.action.MyActionSupport;
import com.poly.service.BaomingService;

public class KCTSatisfy  extends MyActionSupport {

	private int prov = -1;
	private int city = -1;
	private int brandId = -1;
	private int chexiId = -1;
	private int state = -1;// 头部审核状态
	private int state2 = -1;// 中部审核状态
	private String beginDate = "";// 开始时间
	private String endDate = "";// 结束时间
	private String name = "";
	private String phone = "";
	private String keyword = "";// 关键字
	private int page = 1;
	private int pages = 1;
	private int rows = 20;
	private int count = 0;
	private List<Map<String, String>> tousuList;
	
	private List<Map<String, String>> tuiguangList ;//推广项目列表
	private String tuiguangListStr ;//推广项目列表json串
	
	private int flag = 0;//0-初次进入 1-后续进入
	private String pro_num = "";//推广编号
	private String iway;

	// 投诉查询
	public String kctsatisfy() {
		
		String pro_nums = (String) session.get("pro_nums");
		
		String uleve = (String) session.get("ulevel");
		
		int pstatus = 2;
		
		
		tuiguangList = BaomingService.getInstance().queryTuiguangInfo(pro_nums,uleve,pstatus);
		//tuiguangListStr = JSONArray.fromObject(tuiguangList).toString();
		if(tuiguangList.size() == 0)
			return SUCCESS;
		if(flag == 0){
			pro_num = tuiguangList.get(0).get("pro_num").toString();
		}
		
		String pro_numid = request.getParameter("pro_numid");
		
		if(null!=pro_numid && !"".equals(pro_numid)){
			pro_num = pro_numid;
		}
		
		if (page < 0)
			page = 1;
		int start = (page - 1) * rows;
		tousuList = BaomingService.getInstance().querySatisfy(pro_num,state, beginDate,
				endDate, name, phone, keyword, brandId, chexiId, prov, city,
				start, rows,iway);
		if (tousuList.size() > 0)
			count = Integer.valueOf(tousuList.get(0).get("count"));
		if (count % rows == 0)
			pages = count / rows;
		else
			pages = count / rows + 1;
		return SUCCESS;
	}

	// 查看投诉详情
		public void querySatisfyDetail() throws IOException {
			String tousuid = request.getParameter("tousuid");
			Map<String, Object> map = BaomingService.getInstance().querySatisfyDetail(
					Integer.valueOf(tousuid));
			response.setContentType("text/html;charset=gbk");
			PrintWriter out = response.getWriter();
			JSONArray json = JSONArray.fromObject(map);
			String jsonp = request.getParameter("jsonpcallback");
			out.print(jsonp + "(" + json.toString() + ")");

		}
		
		// 更新投诉状态
		public void satisfyUpdate() throws IOException {
			String did = request.getParameter("did");
			String diaocha = request.getParameter("diaocha");
			String shixiao = request.getParameter("shixiao");
			String fuwu = request.getParameter("fuwu");
			String tcontent = request.getParameter("tcontent");
			String ttcontent = request.getParameter("ttcontent");
			
			TbDataVisitRecord tb = new TbDataVisitRecord();
			tb.setRecord_id(Integer.parseInt(did));
			tb.setResearch(Integer.parseInt(diaocha));
			tb.setLose_reason(Integer.parseInt(shixiao));
			tb.setSatisfy(Integer.parseInt(fuwu));
			tb.setNot_store_reason(tcontent);
			tb.setAdvise(ttcontent);
			tb.setSatisfy_date(new Date());
			tb.setSatisfy_state(1);
			
			int result = TbDataVisitRecordDao.update(tb);
			
			response.setContentType("text/html;charset=gbk");
			PrintWriter out = response.getWriter();
			out.print(result);
		}
		
	
	
	
	public int getProv() {
		return prov;
	}

	public void setProv(int prov) {
		this.prov = prov;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getChexiId() {
		return chexiId;
	}

	public void setChexiId(int chexiId) {
		this.chexiId = chexiId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getState2() {
		return state2;
	}

	public void setState2(int state2) {
		this.state2 = state2;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public List<Map<String, String>> getTousuList() {
		return tousuList;
	}

	public void setTousuList(List<Map<String, String>> tousuList) {
		this.tousuList = tousuList;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Map<String, String>> getTuiguangList() {
		return tuiguangList;
	}

	public void setTuiguangList(List<Map<String, String>> tuiguangList) {
		this.tuiguangList = tuiguangList;
	}

	public String getTuiguangListStr() {
		return tuiguangListStr;
	}

	public void setTuiguangListStr(String tuiguangListStr) {
		this.tuiguangListStr = tuiguangListStr;
	}

	public String getPro_num() {
		return pro_num;
	}

	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getIway() {
		return iway;
	}

	public void setIway(String iway) {
		this.iway = iway;
	}
	

}
