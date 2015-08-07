package com.poly.action.action_baoming;

import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Date;
import java.util.Map;

import car_beans.TbApplyInfo;
import car_beans.TbDataBaoming;
import car_daos.TbDataBaomingDao;

import com.poly.action.MyActionSupport;
import com.poly.service.PhoneAreaService;
import com.redis.RedisDao;

public class AcceptApplyAction extends MyActionSupport{

	public void saveApplyInf() throws Exception{
 		String name = URLDecoder.decode(request.getParameter("name"), "utf-8");
 		String carid = URLDecoder.decode(request.getParameter("carid"), "utf-8");
 		String modelid = URLDecoder.decode(request.getParameter("modelid"), "utf-8");
 		String phone = URLDecoder.decode(request.getParameter("phone"), "utf-8");
 		String sex = URLDecoder.decode(request.getParameter("sex"), "utf-8");
 		String city = URLDecoder.decode(request.getParameter("city"), "utf-8");
 		String prov = URLDecoder.decode(request.getParameter("prov"), "utf-8");
 		String carinfo = URLDecoder.decode(request.getParameter("carinfo"), "utf-8");
 		int type = 11;
 		
 		if(request.getParameter("type")!=null){
 			try {
 				type = Integer.valueOf(request.getParameter("type"));
			} catch (Exception e) {
				// TODO: handle exception
			}
 			
 		}
 		String isSendSms = "1";
 		try {
 			isSendSms = URLDecoder.decode(request.getParameter("isSendSms"), "utf-8");
		} catch (Exception e) {
		}
 		
 		TbDataBaoming d = new TbDataBaoming();
 		d.setName(name);
		d.setPhone(phone);
		d.setType(1);
		d.setBrand(Integer.parseInt(carid));
		Map<String,String> map = RedisDao.getCatalognewById(Integer.parseInt(modelid));
		int chexi = -1;
		if(null != map){
			chexi = Integer.parseInt(map.get("fatherid"));
		}
		d.setSerial(chexi);
		d.setModel(Integer.parseInt(modelid));
		
		d.setIs_invite(1);
		d.setReal_type(type);
		
		d.setBaoming_date(new Date());
		d.setReturn_visit_time(new Date());
 		d.setCar_info(carinfo);
 		
 		
// 		TbApplyInfo applyInfo = new TbApplyInfo();
//		applyInfo.setAppdate(new Date());
//		applyInfo.setCarid(Integer.parseInt(carid));
//		applyInfo.setModelid(Integer.parseInt(modelid));
//		applyInfo.setName(name);
//		applyInfo.setPhone(phone);
//		applyInfo.setSex(Integer.parseInt(sex));
//		
//		
//		
//		applyInfo.setType(type);//双十一活动
//		applyInfo.setLeft_num(0);

//		applyInfo.setCar_info(carinfo);
		int phoneProv = 0;
		int phoneCity = 0;
		if (phone.length() > 7) {
			Map<String, Integer> areas = PhoneAreaService.getInstance()
					.getProvAndCity(phone.substring(0, 7));
			phoneProv = areas.get("prov");
			phoneCity = areas.get("city");
		}
		
		if(carinfo.contains("大客户")){
			prov = "9";
			city = "0";
			phoneProv = 0;
			phoneCity = 0;
					
		}
		
		d.setProv(Integer.parseInt(prov));
		d.setCity(Integer.parseInt(city));
		d.setPhone_prov(phoneProv);
		d.setPhone_city(phoneCity);
		
//		applyInfo.setCity(city);
//		applyInfo.setProv(prov);
//		applyInfo.setPhone_prov(phoneProv);
//		applyInfo.setPhone_city(phoneCity);
//		applyInfo.setIssendsms(Integer.parseInt(isSendSms));
		TbDataBaomingDao.save(d);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		String jsonp = request.getParameter("jsonpcallback");
		out.print(jsonp + "(1)");
	}
}
