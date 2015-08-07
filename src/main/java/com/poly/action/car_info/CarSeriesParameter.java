package com.poly.action.car_info;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import car_beans.DboCarSerialpeizhides;
import car_daos.DboCarSerialpeizhidesDao;

import com.poly.action.MyActionSupport;

public class CarSeriesParameter extends MyActionSupport{

	private int id;
	private String link1;
	private String link2;
	private String link3;
	private String link4;
	private String link5;
	
	public String execute(){
		return SUCCESS;
	}
	
	public void CarSeriesParameterA() throws IOException{
		String csql="serialid = "+id;
		List<DboCarSerialpeizhides> list=DboCarSerialpeizhidesDao.where(csql);
		DboCarSerialpeizhides carSerial= new DboCarSerialpeizhides();
		if(list.size()>0){
			carSerial=list.get(0);
		}
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONObject json = JSONObject.fromObject(carSerial);
		//String jsonp=request.getParameter("jsonpcallback");
		out.print(json.toString());
		out.close();
	}
	
	public String SaveCarSeriesParameter(){
		try{
			String csql="serialid = "+id;
			List<DboCarSerialpeizhides> list=DboCarSerialpeizhidesDao.where(csql);
			DboCarSerialpeizhides carSerial= new DboCarSerialpeizhides();
			carSerial.setSerialid(id);
			carSerial.setLink1(link1);
			carSerial.setLink2(link2);
			carSerial.setLink3(link3);
			carSerial.setLink4(link4);
			carSerial.setLink5(link5);
			Date date=new Date();
			carSerial.setAdddate(date);
			carSerial.setUpdatetime(date);
			if(list.size()>0){
				DboCarSerialpeizhidesDao.update(carSerial);
			}else{
				DboCarSerialpeizhidesDao.save(carSerial);
			}
			setAjax("1");
		}catch(Exception e){
			e.printStackTrace();
			setAjax("0");
		}
		return AJAX;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getLink1() {
		return link1;
	}

	public void setLink1(String link1) {
		this.link1 = link1;
	}

	public String getLink2() {
		return link2;
	}

	public void setLink2(String link2) {
		this.link2 = link2;
	}

	public String getLink3() {
		return link3;
	}

	public void setLink3(String link3) {
		this.link3 = link3;
	}

	public String getLink4() {
		return link4;
	}

	public void setLink4(String link4) {
		this.link4 = link4;
	}

	public String getLink5() {
		return link5;
	}

	public void setLink5(String link5) {
		this.link5 = link5;
	}
}
