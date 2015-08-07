package com.poly.action.action_baoming;

import java.util.List;
import java.util.Map;

import com.poly.action.MyActionSupport;
import com.poly.service.BaomingService;

public class KCTMyproject extends MyActionSupport {

	private int prov = -1;
	private int city = -1;
	private int brandId = -1;
	private int chexiId = -1;
	private int state = -1;// 头部审核状态
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

	private List<Map<String, String>> tuiguangList;// 推广项目列表
	private String tuiguangListStr;// 推广项目列表json串

	private int flag = 0;// 0-初次进入 1-后续进入
	private String pro_num = "";// 推广编号
	private String iway;
	private int ywtype = -1;
	
	// 投诉查询
	public String myProject() {

		String pro_nums = (String) session.get("pro_nums");

		String uleve = (String) session.get("ulevel");
		
		String username = (String) session.get("userid");

		String ini_man = "";
		
		int pstatus = 3;

		if (page < 0)
			page = 1;
		int start = (page - 1) * rows;
		
		tuiguangList = BaomingService.getInstance().queryTuiguangInfoByPage(pro_nums,
				uleve, pstatus,beginDate, endDate, name, phone, keyword, brandId, chexiId,
				prov, city, start, rows,iway,ywtype);
		// tuiguangListStr = JSONArray.fromObject(tuiguangList).toString();
		
		if (tuiguangList.size() > 0){
			count = Integer.valueOf(tuiguangList.get(0).get("count"));
			ini_man = tuiguangList.get(0).get("username");
		}
		if (count % rows == 0)
			pages = count / rows;
		else
			pages = count / rows + 1;
		
		if(uleve.contains("0")||(username).equals(ini_man)){
			return SUCCESS;
		}else {
			return "kfsuccess";
		}
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

	public int getYwtype() {
		return ywtype;
	}

	public void setYwtype(int ywtype) {
		this.ywtype = ywtype;
	}
	
	
}
