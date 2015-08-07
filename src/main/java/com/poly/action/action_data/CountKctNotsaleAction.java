package com.poly.action.action_data;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.action.MyActionSupport;
import com.poly.service.BaomingService;
import com.poly.service.ProjectService;

public class CountKctNotsaleAction extends MyActionSupport {
	
	private String pro_num;
	
	private String fenzhan;
	
	private String fenlei;
	
	private List<Map<String, Object>> tuiguangList ;
	
	private List<Map<String,Object>> fenzhanList;
	
	private List<Map<String,Object>> shixiaoList;
	
	public String execute() throws SQLException{
		
		
		tuiguangList = BaomingService.getInstance().queryTuiguangInfo();
		fenzhanList = BaomingService.getInstance().queryFenzhanInfo();
		
		shixiaoList = BaomingService.getInstance().queryShixiaoInfo(pro_num,fenzhan,fenlei);
		
		return SUCCESS;
	}

	public String getPro_num() {
		return pro_num;
	}

	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
	}

	public String getFenzhan() {
		return fenzhan;
	}

	public void setFenzhan(String fenzhan) {
		this.fenzhan = fenzhan;
	}

	public String getFenlei() {
		return fenlei;
	}

	public void setFenlei(String fenlei) {
		this.fenlei = fenlei;
	}

	public List<Map<String, Object>> getTuiguangList() {
		return tuiguangList;
	}

	public void setTuiguangList(List<Map<String, Object>> tuiguangList) {
		this.tuiguangList = tuiguangList;
	}

	public List<Map<String, Object>> getFenzhanList() {
		return fenzhanList;
	}

	public void setFenzhanList(List<Map<String, Object>> fenzhanList) {
		this.fenzhanList = fenzhanList;
	}

	public List<Map<String, Object>> getShixiaoList() {
		return shixiaoList;
	}

	public void setShixiaoList(List<Map<String, Object>> shixiaoList) {
		this.shixiaoList = shixiaoList;
	}

	
	
}
