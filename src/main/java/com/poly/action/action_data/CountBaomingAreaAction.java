package com.poly.action.action_data;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.poly.action.MyActionSupport;
import com.poly.bean.newNews;
import com.poly.service.ProjectService;
import com.poly.service.TiquService;

public class CountBaomingAreaAction extends MyActionSupport {
	private String start_date = "";
	private String end_date = "";
	private String brand = "";
	private String isSearch = "";
	private List<Map<String, String>> carList;
	private List<Map<String, List<Map<String, String>>>> dataList;
	
	public String execute(){
		System.out.println(isSearch);
		
		if ("".equals(isSearch)) {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			start_date = sf.format(new Date());
			end_date = start_date;
		}
		
		carList = TiquService.getInstance().getCarList("0");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("start_date", start_date);
		map.put("end_date", end_date);
		map.put("brand", brand);
		List<Map<String, String>> resultList = ProjectService.getInstance().getAreaBaomingData(map);
		
		if (resultList==null || resultList.size()==0) {
			resultList = ProjectService.getInstance().getAreaBaomingDataNull();
		}
		
		if (resultList!=null && resultList.size()!=0) {
			dataList = new ArrayList<Map<String,List<Map<String,String>>>>();
			
			List<Integer> ilist = new ArrayList<Integer>();
			List<String> nList = new ArrayList<String>();
			String disId = "";
			String dds = "";
			for (int i = 0; i < resultList.size(); i++) {
				Map<String, String> mm = resultList.get(i);
				mm.put("huifang_rate", huifanRate(mm.get("baoming_count"), mm.get("huifang_count")));
				if (disId.equals(mm.get("dis_id"))==false) {
					disId = mm.get("dis_id");
					ilist.add(i);
					nList.add(mm.get("dis_name"));
				}
			}
			if (resultList.size()>0) {
				ilist.add(resultList.size());
			}
			
			for (int i = 0; i < ilist.size()-1; i++) {
				List<Map<String, String>> rList = new ArrayList<Map<String,String>>();
				
				for (int j = ilist.get(i); j < ilist.get(i+1); j++) {
					rList.add(resultList.get(j));
				}
				
				Map<String,List<Map<String,String>>> rmap = new HashMap<String, List<Map<String,String>>>();
				rmap.put(nList.get(i), rList);
				dataList.add(rmap);
			}
		}
		
		return SUCCESS;
	}
	
	private String huifanRate(String baoming_count, String huifang_count){
		DecimalFormat df = new DecimalFormat("0.00");
		double data1 = Integer.parseInt(baoming_count)*1.00;
		double data2 = Integer.parseInt(huifang_count)*1.00;
		if (data2>0) {
			double dd = 100*data2/data1;
			return df.format(dd);
		}else {
			return "0";
		}
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public List<Map<String, String>> getCarList() {
		return carList;
	}

	public void setCarList(List<Map<String, String>> carList) {
		this.carList = carList;
	}

	public List<Map<String, List<Map<String, String>>>> getDataList() {
		return dataList;
	}

	public void setDataList(List<Map<String, List<Map<String, String>>>> dataList) {
		this.dataList = dataList;
	}

	public String getIsSearch() {
		return isSearch;
	}

	public void setIsSearch(String isSearch) {
		this.isSearch = isSearch;
	}
	
}
