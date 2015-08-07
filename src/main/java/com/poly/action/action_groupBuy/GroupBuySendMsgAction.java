package com.poly.action.action_groupBuy;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.action.MyActionSupport;
import com.poly.service.AppInfoService;
import com.poly.util.HttpRequest;

public class GroupBuySendMsgAction extends MyActionSupport{
	private String barndName = "-1";
	private String brandFlag ="";
	private int chexiId = -1;
	private int prov = -1;
	private int city = -1;
	private int cityflag;
	private String spaceid;
	private String level;
	private String secques;
	private String brands="";
	private int typex=-1;
	private int attType = -1;
	private String lookTime ="";
	private String msgType = "1";
	List<HashMap<String, Object>> appyList;
	private void setRole(){
		Map<String,Object> map = (Map<String, Object>) session.get("userInfo");
		spaceid = (String) map.get("spaceid");
		level = (String) map.get("ulevel");
		secques = (String)map.get("secques");
		if ("".equals((String)map.get("brands"))){
			brandFlag = "0";
		}
		else {
			brands = ((String)map.get("brands"));
			brandFlag = "1";
		}
		
	}
	public String execute(){
		setRole();
		if("2".equals(level)||"3".equals(level)){
			prov = Integer.parseInt(spaceid);
			if(city == -1)
				city = Integer.parseInt(secques);
			if(Integer.parseInt(secques)!=-1)
				cityflag = 1;
		}
		appyList = AppInfoService.getInstance().getAttendInfo(barndName, brands, chexiId, prov, city, typex, attType, lookTime,msgType);
		return SUCCESS;
	}
	public void sendMsg() throws IOException{
		String ids = URLDecoder.decode(request.getParameter("ids"), "utf-8");
		String phones = URLDecoder.decode(request.getParameter("phones"), "utf-8");
		String msg = URLDecoder.decode(request.getParameter("msg"), "utf-8");
		String idArr[] = ids.split("#");
		String phoneArr[] = phones.split("#");
		//String msgType =  URLDecoder.decode(request.getParameter("msgType"), "utf-8");
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		for(int i = 0;i<idArr.length;i++){
			Map<String, String> map = new HashMap<String, String>();
			map.put("id",idArr[i]);
			map.put("phone", phoneArr[i]);
			list.add(map);
		}
		int count1 = 0;
		for (Map<String, String> map : list) {
			String id = map.get("id");
			String phone = map.get("phone");
			try {
				HttpRequest.sendMsg(msg, phone);
				AppInfoService.getInstance().sendMsg(id);
				count1 ++;
			} catch (Exception e) {
				System.err.println("���ŷ���ʧ��!"+phone);
			}
			
		}
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		String jsonp = request.getParameter("jsonpcallback");
		out.print(jsonp + "("+count1+")");
	}
	public String getBarndName() {
		return barndName;
	}
	public void setBarndName(String barndName) {
		this.barndName = barndName;
	}
	public String getBrandFlag() {
		return brandFlag;
	}
	public void setBrandFlag(String brandFlag) {
		this.brandFlag = brandFlag;
	}
	public int getChexiId() {
		return chexiId;
	}
	public void setChexiId(int chexiId) {
		this.chexiId = chexiId;
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
	public int getCityflag() {
		return cityflag;
	}
	public void setCityflag(int cityflag) {
		this.cityflag = cityflag;
	}
	public String getSpaceid() {
		return spaceid;
	}
	public void setSpaceid(String spaceid) {
		this.spaceid = spaceid;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getSecques() {
		return secques;
	}
	public void setSecques(String secques) {
		this.secques = secques;
	}
	public String getBrands() {
		return brands;
	}
	public void setBrands(String brands) {
		this.brands = brands;
	}
	public int getTypex() {
		return typex;
	}
	public void setTypex(int typex) {
		this.typex = typex;
	}
	public int getAttType() {
		return attType;
	}
	public void setAttType(int attType) {
		this.attType = attType;
	}
	public String getLookTime() {
		return lookTime;
	}
	public void setLookTime(String lookTime) {
		this.lookTime = lookTime;
	}
	public List<HashMap<String, Object>> getAppyList() {
		return appyList;
	}
	public void setAppyList(List<HashMap<String, Object>> appyList) {
		this.appyList = appyList;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
}
