package com.poly.action.action_baoming;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.xml.crypto.Data;

import net.sf.json.JSONArray;
import car_beans.DboAreCatalog;
import car_beans.DboCarCatalognew;
import car_beans.DboDntTousu;
import car_beans.TbCityArea;
import car_beans.TbDataBaoming;
import car_beans.TbDataBaominglog;
import car_beans.TbDataVisitRecord;
import car_daos.TbDataBaomingDao;
import car_daos.TbDataBaominglogDao;
import car_daos.TbDataVisitRecordDao;

import com.poly.action.MyActionSupport;
import com.poly.service.AppInfoService;
import com.poly.service.BaomingService;
import com.poly.service.ProjectService;
import com.poly.service.SaleFavoredService;
import com.poly.service.TousuService;
import com.poly.util.DeleteTosuDetailUtil;
import com.poly.util.TbSequenceUtil;
import com.redis.RedisDao;

public class KCTManage extends MyActionSupport{
	private int page = 1;
	private int pages = 1;
	private int size = 20;
	
	private List<Map<String, String>> tuiguangList ;//推广项目列表
	private String tuiguangListStr ;//推广项目列表json串
	
	private  List<Map<String, String>> iwayList ;//推广渠道列表
	private String iway = "";//推广渠道
	private String iway2 = "";//推广渠道
	private String iway3 = "";//推广渠道
	private int iserial = 0; //推广车系
	
	private String competing;//推广
	
	//查询条件
	private String name = "";//姓名
	private String phone = "";//电话
	private String beginDate;//开始时间
	private String endDate;//结束时间
	private String promo_start_date;//推广开始时间
	private String promo_end_date;//推广结束时间
	private int return_visit_state = 0;//回访状态 0-未回访 1-一呼 2-二呼 3-三呼 4-其他
	private int buycar_emergency = -1;//购车紧急度  -1-全部
	private int is_key_cus = -1;//客户类型 -1 全部  0-普通客户  1-重点客户
	private int phoneerror = 0;//电话能否接通 0-全部  1-未接通
	private int provId = 0;//推广省份
	private int cityId = 0;//推广城市
	private int prov3 = -1;
	private int city3 = -1;
	private int brandId = 0;//推广品牌
	private int chexiId = 0;//推广车系
	private int chexiId3 = 0;//推广车系
	private int chexingId = 0;//推广车型
	private String pro_num = "";//推广编号
	private int flag = 0;//0-初次进入 1-后续进入
	private int count = 0;//数据总量
	private int switchRadio = 0;
	List<Map<String, String>> kctList ;
	private TbDataBaoming baoming;
	private String pro_state;
	private int apply_source = -1;
	private int buy_status = -1;
	
	//进入看车团回访界面
	public String kctmanage() throws SQLException, ParseException{
		
		String pro_nums = (String) session.get("pro_nums");
				
		String uleve = (String) session.get("ulevel");
		
		String prov = (String) session.get("prov");
		
		String city = (String) session.get("city");
		
		String brands = (String) session.get("brands");
		
		String sub_sites_id = (String)session.get("siteid");
		
		String citys = "";
		
		String provs = "";
		
		String pro_numid = request.getParameter("pro_numid");
		
		phone = phone.trim();
		
		if(!"0".equals(sub_sites_id)){
		List<Map<String,Object>> siteList = BaomingService.getInstance().querySub(sub_sites_id);
		
		Map<String,Object> sites = siteList.get(0);
		
		//int i = (Integer)sites.get("id");
		int chid = (Integer)sites.get("chid");
		String fpid = (String)sites.get("fpid");
		int catalogid = (Integer)sites.get("catalogid");
		int fatherid = (Integer)sites.get("fatherid");
		//DboAreCatalog area = AdminService.getInstance().getProvId(i+"");
		
		int pid =  fatherid==0? catalogid:fatherid;
		
		if(pid == 9){
			provs = "";
		}else if(pid==1||pid ==2){
			
			provs = " and prov = "+pid;
		}
		
		
//		if("11".equals(sub_sites_id)||"12".equals(sub_sites_id)||"8".equals(sub_sites_id))
//			secques = cid+"";
		if(1==chid || 0==chid){
//			String city1  = "";
//			List<Map<String, Object>> maps = BaomingService.getInstance().queryFchid(fpid,(pid+""));
//			if(maps.size()>0){
//				for(int j=0;j<maps.size();j++){
//					Map<String,Object> map2 = maps.get(j);
//					if(j!=0){
//						city1 += " and ";
//						
//					}
//					city1 += " city<>"+map2.get("catalogid");
//				
//				}
//				citys = " and ("+city1+")";
//				
//			}
			citys = " and city in ("+fpid+")";
		}
//		
		}
		//iwayList = BaomingService.getInstance().queryIwayInfo(brands);
		
		int pstatus = 1;
		
		int prefIndex = size * (page - 1);
		tuiguangList = BaomingService.getInstance().queryTuiguangInfo(pro_nums,uleve,pstatus);
		tuiguangListStr = JSONArray.fromObject(tuiguangList).toString();
		if(switchRadio == 0){
		if(tuiguangList.size() == 0)
			return SUCCESS;
		}
		//初次进入
		if(flag == 0){
			if(beginDate == null)
				beginDate = getBeginDatex();
			if(endDate == null)
				endDate = getEndDatex();
			if(promo_start_date == null)
				promo_start_date = tuiguangList.get(0).get("promo_start_date").toString();
			if(promo_end_date == null)
				promo_end_date = tuiguangList.get(0).get("promo_end_date").toString();
			provId = Integer.valueOf(tuiguangList.get(0).get("provId").toString());
			cityId = Integer.valueOf(tuiguangList.get(0).get("cityId").toString());
			brandId = Integer.valueOf(tuiguangList.get(0).get("brandId").toString());
			chexiId = Integer.valueOf(tuiguangList.get(0).get("chexiId").toString());
			chexingId = Integer.valueOf(tuiguangList.get(0).get("chexingId").toString());
			iway2 = tuiguangList.get(0).get("iway").toString();
			competing = tuiguangList.get(0).get("competing").toString();
			pro_state = tuiguangList.get(0).get("pro_state").toString();
		}
		
		if(null!=pro_numid && !"".equals(pro_numid)){
			List<Map<String, String>> tuiguangLists = BaomingService.getInstance().queryTuiguangInfoByPro(pro_nums,uleve,pstatus,pro_numid);
			pro_num = pro_numid;
			if(beginDate == null)
				beginDate = getBeginDatex();
			if(endDate == null)
				endDate = getEndDatex();
			if(promo_start_date == null)
				promo_start_date = tuiguangLists.get(0).get("promo_start_date").toString();
			if(promo_end_date == null)
				promo_end_date = tuiguangLists.get(0).get("promo_end_date").toString();
			provId = Integer.valueOf(tuiguangLists.get(0).get("provId").toString());
			cityId = Integer.valueOf(tuiguangLists.get(0).get("cityId").toString());
			brandId = Integer.valueOf(tuiguangLists.get(0).get("brandId").toString());
			chexiId = Integer.valueOf(tuiguangLists.get(0).get("chexiId").toString());
			chexingId = Integer.valueOf(tuiguangLists.get(0).get("chexingId").toString());
			competing = tuiguangLists.get(0).get("competing").toString();
			iway2 = tuiguangLists.get(0).get("iway").toString();
			pro_state = tuiguangList.get(0).get("pro_state").toString();
		}
		
		if(switchRadio == 1){
			String begin = "";
			String end = "";
			if(beginDate == null || "".equals(beginDate)){
				beginDate = getBeginDatex();
				begin = getBeginDatex();
			}else{
				begin = beginDate;
			}
			if(endDate == null || "".equals(endDate)){
				end = getEndDatex();
				endDate = getEndDatex();
			}else{
				end = endDate;
			}
			
			kctList =  BaomingService.getInstance().queryKCTBaoming2(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, prov, city, brands,  prefIndex, size,iway,iserial);
			count = BaomingService.getInstance().queryKCTBaoming2Count(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, prov, city, brands,iway,iserial);
			
			if(count%size == 0)
				pages = count/size;
			else
				pages = count/size + 1;
			
		}else{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//判断日期是否合法
			if(checkDate(beginDate)&&checkDate(endDate)&&checkDate(promo_start_date)&&checkDate(promo_end_date)){
				String begin = "";
				String end = "";
				if(sdf.parse(beginDate).compareTo(sdf.parse(promo_start_date))> 0)
					begin = beginDate;
				else
					begin = promo_start_date;
				
				if(sdf.parse(endDate).compareTo(sdf.parse(promo_end_date)) > 0)
					end = promo_end_date;
				else
					end = endDate;
				
				if("100".equals(pro_state)){
					
					if(null == competing || "".equals(competing)){
						kctList =  BaomingService.getInstance().queryKCTBaoming01(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId, prefIndex, size,iway2,prov3,city3,chexiId3,iway3,pro_state,provs,citys,apply_source,buy_status);
						count = BaomingService.getInstance().queryKCTBaomingCount01(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId,iway2,prov3,city3,chexiId3,iway3,pro_state,provs,citys,apply_source,buy_status);
					
					}else{
						kctList =  BaomingService.getInstance().queryKCTBaoming31(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId, prefIndex, size,competing,iway2,prov3,city3,chexiId3,iway3,pro_state,provs,citys,apply_source,buy_status);
						count = BaomingService.getInstance().queryKCTBaomingCount31(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId,competing,iway2,prov3,city3,chexiId3,iway3,pro_state,provs,citys,apply_source,buy_status);
					}
					
				}else{
				
					if(null == competing || "".equals(competing)){
						kctList =  BaomingService.getInstance().queryKCTBaoming(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId, prefIndex, size,iway2,prov3,city3,chexiId3,iway3,apply_source,buy_status);
						count = BaomingService.getInstance().queryKCTBaomingCount(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId,iway2,prov3,city3,chexiId3,iway3,apply_source,buy_status);
					
					}else{
						kctList =  BaomingService.getInstance().queryKCTBaoming3(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId, prefIndex, size,competing,iway2,prov3,city3,chexiId3,iway3,apply_source,buy_status);
						count = BaomingService.getInstance().queryKCTBaomingCount3(name, phone, begin, end, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId, cityId, brandId, chexiId, chexingId,competing,iway2,prov3,city3,chexiId3,iway3,apply_source,buy_status);
					}
				
				}
				
				if(count%size == 0)
					pages = count/size;
				else
					pages = count/size + 1;
				
			}	
		}
		return SUCCESS;
	}
	boolean checkDate(String date){
		boolean flag = false;
		if(date  == null){
			flag = false;
			return flag;
		}
		String reg = "([0-9]{4}-[0-9]{2}-[0-9]{2})";
		flag= Pattern.matches(reg, date);
		return flag;
	}
	String getEndDatex(){
		String endDate = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		endDate = sdf.format(date);
		return endDate;
	}
	String getBeginDatex(){
		String beginDate = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Calendar calendar = new GregorianCalendar(); 
	    calendar.setTime(date); 
		//calendar.add(calendar.DATE,-7);
		date=calendar.getTime();
		beginDate = sdf.format(date);
		return beginDate;
	}
	
	public void kctmanageDetail() throws IOException, NumberFormatException, SQLException{
		
		String baomingid = request.getParameter("baomingid");
		Map<String, Object> map = BaomingService.getInstance().kctmanageDetail(
				Integer.valueOf(baomingid));
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(map);
		String jsonp = request.getParameter("jsonpcallback");
		out.print(jsonp + "(" + json.toString() + ")");
		
	}
	
	
	
	public void getBaojiaBySerialId() throws IOException{
		
		String chexiid = request.getParameter("chexiid");
		List<Map<String, String>> maps = new ArrayList<Map<String,String>>();
		List<Map<String, String>> map = RedisDao.getAutohomepropBySerialId2(Integer.parseInt(chexiid));
		if(map.size()>0){
			for(int i=0;i<map.size();i++){
				Map<String,String> map2 = map.get(i);
				map2.put("pkg", map2.get("p1").replaceAll("&nbsp", " "));
				maps.add(map2);
			}
		}
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(maps);
		String jsonp = request.getParameter("jsonpcallback");
		out.print(jsonp + "(" + json.toString() + ")");
		
	}
	
	
	public void getAreaByCityId() throws IOException{
		
		String city = request.getParameter("city");
		List<TbCityArea> info =  BaomingService.getInstance().getAreaInfo(city);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(info);
		String jsonp=request.getParameter("jsonpcallback");
		out.print(jsonp+"("+json.toString()+")");
	}
	
	public void tuisongCity() throws Exception{
		String provid = request.getParameter("provid");
		String cityid = request.getParameter("cityid");
		String id = request.getParameter("id");
		
		Map<String,Object> map = (Map<String, Object>) session.get("userInfo");
		String man =  map.get("username").toString();
		String userid = map.get("userid").toString();
		
		TbDataBaominglog bmlog = new TbDataBaominglog();
		bmlog.setId(TbSequenceUtil.nextVal("tb_data_baominglog"));
		bmlog.setBaomingid(Integer.parseInt(id));
		bmlog.setUserid(userid);
		bmlog.setUsername(man);
		bmlog.setOperate_time(new Date());
		bmlog.setOperate_content("城市id号"+provid+"--"+cityid);
		bmlog.setOperate_state("推送城市");
		TbDataBaominglogDao.save(bmlog);
		
		
//		DboDntTousu dboDntTousu = new DboDntTousu();
//		dboDntTousu.setId(Integer.valueOf(tousuid));
//		dboDntTousu.setTitle(title);
//		dboDntTousu.setContent(content);
//		dboDntTousu.setState(Integer.valueOf(state));
//		int result = TousuService.getInstance().updateTtousu(dboDntTousu);
		TbDataBaoming tb = new TbDataBaoming();
		tb.setProv(Integer.parseInt(provid));
		tb.setCity(Integer.parseInt(cityid));
		tb.setId(Integer.parseInt(id));
		int result = BaomingService.getInstance().tuisongCity(tb);
		
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		out.print(result);
	}
	
	public void addyifang() throws Exception{
		Map<String,Object> map = (Map<String, Object>) session.get("userInfo");
		Date date = new Date();
		TbDataBaoming d = new TbDataBaoming();
		String man =  map.get("username").toString();
		String userid = map.get("userid").toString();
		//String man =  "阿强";
		String id = request.getParameter("id");
		String ip = request.getParameter("ip");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String pinpai = request.getParameter("pinpai");
		String chexi = request.getParameter("chexi");
		String prov  =  request.getParameter("prov");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		String phoneerror = request.getParameter("phoneerror");
		String phoneerror_count = request.getParameter("phoneerror_count");
		String constacterror = request.getParameter("constacterror");
		String constacterror_count = request.getParameter("constacterror_count");
		String phone_state = request.getParameter("phone_state");
		String is_key_cus = request.getParameter("is_key_cus");
		String buycar_emergency = request.getParameter("buycar_emergency");
		String attend_type = request.getParameter("attend_type");
		String attend_date = request.getParameter("attend_date");
		String pz_city = request.getParameter("pz_city");
		String pp_state = request.getParameter("pp_state");
		String jpstate = request.getParameter("jpstate");
		String jpchexi = request.getParameter("jpchexi");
		String hfstate = request.getParameter("hfstate");
		String isbuy = request.getParameter("isbuy");
		String gcstate = request.getParameter("gcstate");
		String buy_ys = request.getParameter("buy_ys");
		String bsxtype = request.getParameter("bsxtype");
		String buy_pl = request.getParameter("buy_pl");
		String buy_color = request.getParameter("buy_color");
		String know_yh = request.getParameter("know_yh");
		String zyxinxi = request.getParameter("zyxinxi");
		String weixin = request.getParameter("weixin");
		String qq = request.getParameter("qq");
		String content = request.getParameter("content");
		String remarks = request.getParameter("remarks");
		String tuiguang = request.getParameter("tuiguang");
		String tusong = request.getParameter("tusong");
		String switchid = request.getParameter("switchid");
		String ttdate = request.getParameter("ttdate");
		String chexing = request.getParameter("chexing");
		
		Map<String, String> mapChe = RedisDao.getCatalognewById(Integer.valueOf(chexi));
		
		if(mapChe!=null && mapChe.size() > 0){
			pinpai = mapChe.get("fatherid");
			
		}else{
			pinpai = "-1";
		}
		
		d.setId(Integer.parseInt(id));
		d.setName(name);
		d.setBrand(Integer.parseInt(pinpai));
		d.setSerial(Integer.parseInt(chexi));
		d.setProv(Integer.parseInt(prov));
		d.setCity(Integer.parseInt(city));
		d.setArea(Integer.parseInt(area));
		d.setPhoneerror(Integer.parseInt(phoneerror));
		d.setPhoneerror_count(Integer.parseInt(phoneerror_count));
		d.setPhone_state(Integer.parseInt(phone_state));
		d.setIs_key_cus(Integer.parseInt(is_key_cus));
		d.setBuycar_emergency(Integer.parseInt(buycar_emergency));
		d.setAttend_type(Integer.parseInt(attend_type));
		d.setAttend_date(attend_date);
		d.setPz_city(pz_city);
		d.setPp_state(pp_state);
		d.setIs_jp(Integer.parseInt(jpstate));
		d.setJp_car(jpchexi);
		d.setReturn_visit_state(Integer.parseInt(hfstate));
		d.setIs_buycar(Integer.parseInt(isbuy));
		d.setBuy_state(Integer.parseInt(gcstate));
		d.setBuy_ys(buy_ys);
		d.setBuy_bsx(Integer.parseInt(bsxtype));
		d.setBuy_pl(buy_pl);
		d.setBuy_color(buy_color);
		d.setKnow_yh(know_yh);
		d.setP_job(Integer.parseInt(zyxinxi));
		d.setP_weixin(weixin);
		d.setP_qq(qq);
		d.setReturn_visit_man(man);
		d.setPhone(phone);
		d.setReturn_visit_time(new Date());
		d.setReturn_visit_content(content);
		d.setReturn_visit_id(userid);
		d.setModel(Integer.parseInt(chexing));
		d.setConstacterror(Integer.parseInt(constacterror));
		d.setConstacterror_count(Integer.parseInt(constacterror_count));
		
		
		if("0".equals(constacterror)){
			d.setConstacterror_count(0);
		}
		
		
		if("0".equals(phoneerror)){
			d.setPhoneerror_count(0);
		}else{
			d.setReturn_visit_state(0);
			if("".equals(content.trim()))
				content = "电话未接通";
		}
		
		if("".equals(content.trim()))
			content = "未填写";
		
		String remarkss = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String carName = AppInfoService.getInstance().getCarName(chexi);
		remarkss = man+"  "+sdf.format(date)+"  "+ content+"("+carName+")<br>";
		d.setRemarks(remarkss+remarks);
		
		Date tttdate = sdf.parse(ttdate);
		
		//System.err.println(tbApplyInfo.getRemarks());
		System.err.println("=================update one begin"+(new Date()));
		int result =  BaomingService.getInstance().updateBaomingyf(d);
		System.err.println("=================update one end"+(new Date()));
		System.err.println("=================update muti begin"+(new Date()));
		BaomingService.getInstance().updateSamePhoneApply(d);
		System.err.println("=================update muti end"+(new Date()));
		
		TbDataBaominglog bmlog = new TbDataBaominglog();
		bmlog.setId(TbSequenceUtil.nextVal("tb_data_baominglog"));
		bmlog.setBaomingid(Integer.parseInt(id));
		bmlog.setUserid(userid);
		bmlog.setUsername(man);
		bmlog.setOperate_time(new Date());
		bmlog.setPhoneerror(Integer.parseInt(phoneerror));
		bmlog.setReturn_visit_state(Integer.parseInt(hfstate));
		if("0".equals(phoneerror)){
			
		}else{
			bmlog.setReturn_visit_state(0);
		}
		bmlog.setConstacterror(Integer.parseInt(constacterror));
		
		bmlog.setOperate_content(content);
		String state = "";
		if("1".equals(phoneerror)){
			state = "未接通";
		}else{
			if("1".equals(hfstate)){
				state = "一次回访";
			}
			if("2".equals(hfstate)){
				state = "二次回访";
			}
		}
		bmlog.setOperate_state(state);
		TbDataBaominglogDao.save(bmlog);
		
		TbDataVisitRecord tdvr = new TbDataVisitRecord();
		//tdvr.setRecord_id(TbSequenceUtil.nextVal("tb_data_visit_record"));
		if("0".equals(switchid))
		tdvr.setPro_num(tuiguang);
		tdvr.setIp(ip);
		tdvr.setPhone(phone);
		tdvr.setName(name);
		tdvr.setBaoming_id(Integer.parseInt(id));
		tdvr.setReturn_visit_state(d.getReturn_visit_state());
		tdvr.setIs_key_cus(d.getIs_key_cus());
		tdvr.setPhoneerror(d.getPhoneerror());
		tdvr.setReturn_visit_time(new Date());
		tdvr.setReturn_visit_content(d.getRemarks());
		tdvr.setReturn_visit_man(d.getReturn_visit_man());
		tdvr.setTuisong_flag(Integer.parseInt(tusong));
		tdvr.setAttend_type(d.getAttend_type());
		tdvr.setAttend_date(d.getAttend_date());
		tdvr.setPhone_state(d.getPhone_state());
		tdvr.setIs_jp(d.getIs_jp());
		tdvr.setJp_car(d.getJp_car());
		tdvr.setIs_buycar(d.getIs_buycar());
		tdvr.setBuy_state(d.getBuy_state());
		tdvr.setPhoneerror_count(d.getPhoneerror_count());
		tdvr.setBrand(Integer.parseInt(pinpai));
		tdvr.setSerial(Integer.parseInt(chexi));
		tdvr.setProv(Integer.parseInt(prov));
		tdvr.setCity(Integer.parseInt(city));
		tdvr.setBuycar_emergency(Integer.parseInt(buycar_emergency));
		tdvr.setPz_city(pz_city);
		tdvr.setPp_state(pp_state);
		tdvr.setBuy_ys(buy_ys);
		tdvr.setBuy_bsx(Integer.parseInt(bsxtype));
		tdvr.setBuy_pl(buy_pl);
		tdvr.setBuy_color(buy_color);
		tdvr.setKnow_yh(know_yh);
		tdvr.setP_job(Integer.parseInt(zyxinxi));
		tdvr.setP_weixin(weixin);
		tdvr.setP_qq(qq);
		tdvr.setBaoming_date(tttdate);
		tdvr.setSatisfy_date(new Date());
		tdvr.setModel(Integer.parseInt(chexing));
		
		tdvr.setIs_invite(1);
		
		 ProjectService.getInstance().saveVisitRecord(tdvr);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		out.print(result);
	}
	
	public void deleteBaoming() throws Exception{
		
		String id = request.getParameter("id");
		TbDataBaoming d = new TbDataBaoming();
		d.setId(Integer.parseInt(id));
		d.setIsdelete(1);
		int result =  BaomingService.getInstance().updateBaomingyf(d);
		
		Map<String,Object> map = (Map<String, Object>) session.get("userInfo");
		String man =  map.get("username").toString();
		String userid = map.get("userid").toString();
		String content = request.getParameter("content");
		TbDataBaominglog bmlog = new TbDataBaominglog();
		bmlog.setId(TbSequenceUtil.nextVal("tb_data_baominglog"));
		bmlog.setBaomingid(Integer.parseInt(id));
		bmlog.setUserid(userid);
		bmlog.setUsername(man);
		bmlog.setOperate_time(new Date());
		bmlog.setOperate_content(content);
		bmlog.setOperate_state("删除");
		TbDataBaominglogDao.save(bmlog);
		
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		out.print(result);
	}
	
	
	public void insertBaoming() throws Exception{
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String pinpai = request.getParameter("pinpai");
		String chexi = request.getParameter("chexi");
		String prov  =  request.getParameter("prov");
		String city = request.getParameter("city");
		String model = request.getParameter("model");
		String type = request.getParameter("type");
		
		Map<String, String> mapChe = RedisDao.getCatalognewById(Integer.valueOf(chexi));
		
		if(mapChe!=null && mapChe.size() > 0){
			pinpai = mapChe.get("fatherid");
			
		}else{
			pinpai = "-1";
		}
		
		TbDataBaoming d = new TbDataBaoming();
		d.setName(name);
		d.setPhone(phone);
		d.setType(Integer.parseInt(type));
		d.setBrand(Integer.parseInt(pinpai));
		d.setSerial(Integer.parseInt(chexi));
		d.setModel(Integer.parseInt(model));
		d.setProv(Integer.parseInt(prov));
		d.setCity(Integer.parseInt(city));
		d.setIs_invite(1);
		
		d.setBaoming_date(new Date());
		d.setReturn_visit_time(new Date());
		
		
		int result = TbDataBaomingDao.save(d);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		out.print(result);
	}
	
	// 获取 品牌/车系列表
		public void queryCarInfo2() throws IOException {
			String fatherid = request.getParameter("fatherid");
			List<DboCarCatalognew> brands = SaleFavoredService.getInstance()
					.getCarBrandByFatherId2(Integer.valueOf(fatherid));
			response.setContentType("text/html;charset=gbk");
			PrintWriter out = response.getWriter();
			JSONArray json = JSONArray.fromObject(brands);
			String jsonp = request.getParameter("jsonpcallback");
			out.print(jsonp + "(" + json.toString() + ")");
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
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
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
	public String getPromo_start_date() {
		return promo_start_date;
	}
	public void setPromo_start_date(String promo_start_date) {
		this.promo_start_date = promo_start_date;
	}
	public String getPromo_end_date() {
		return promo_end_date;
	}
	public void setPromo_end_date(String promo_end_date) {
		this.promo_end_date = promo_end_date;
	}
	public int getReturn_visit_state() {
		return return_visit_state;
	}
	public void setReturn_visit_state(int return_visit_state) {
		this.return_visit_state = return_visit_state;
	}
	public int getBuycar_emergency() {
		return buycar_emergency;
	}
	public void setBuycar_emergency(int buycar_emergency) {
		this.buycar_emergency = buycar_emergency;
	}
	public int getIs_key_cus() {
		return is_key_cus;
	}
	public void setIs_key_cus(int is_key_cus) {
		this.is_key_cus = is_key_cus;
	}
	public int getPhoneerror() {
		return phoneerror;
	}
	public void setPhoneerror(int phoneerror) {
		this.phoneerror = phoneerror;
	}
	public int getProvId() {
		return provId;
	}
	public void setProvId(int provId) {
		this.provId = provId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
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
	public int getChexingId() {
		return chexingId;
	}
	public void setChexingId(int chexingId) {
		this.chexingId = chexingId;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public List<Map<String, String>> getKctList() {
		return kctList;
	}
	public void setKctList(List<Map<String, String>> kctList) {
		this.kctList = kctList;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getPro_num() {
		return pro_num;
	}
	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
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
	public TbDataBaoming getBaoming() {
		return baoming;
	}
	public void setBaoming(TbDataBaoming baoming) {
		this.baoming = baoming;
	}
	public int getSwitchRadio() {
		return switchRadio;
	}
	public void setSwitchRadio(int switchRadio) {
		this.switchRadio = switchRadio;
	}
	public List<Map<String, String>> getIwayList() {
		return iwayList;
	}
	public void setIwayList(List<Map<String, String>> iwayList) {
		this.iwayList = iwayList;
	}
	public String getIway() {
		return iway;
	}
	public void setIway(String iway) {
		this.iway = iway;
	}
	public int getIserial() {
		return iserial;
	}
	public void setIserial(int iserial) {
		this.iserial = iserial;
	}
	public String getCompeting() {
		return competing;
	}
	public void setCompeting(String competing) {
		this.competing = competing;
	}
	public String getIway2() {
		return iway2;
	}
	public void setIway2(String iway2) {
		this.iway2 = iway2;
	}
	public String getIway3() {
		return iway3;
	}
	public void setIway3(String iway3) {
		this.iway3 = iway3;
	}
	public int getProv3() {
		return prov3;
	}
	public void setProv3(int prov3) {
		this.prov3 = prov3;
	}
	public int getCity3() {
		return city3;
	}
	public void setCity3(int city3) {
		this.city3 = city3;
	}
	public int getChexiId3() {
		return chexiId3;
	}
	public void setChexiId3(int chexiId3) {
		this.chexiId3 = chexiId3;
	}
	public String getPro_state() {
		return pro_state;
	}
	public void setPro_state(String pro_state) {
		this.pro_state = pro_state;
	}
	public int getApply_source() {
		return apply_source;
	}
	public void setApply_source(int apply_source) {
		this.apply_source = apply_source;
	}
	public int getBuy_status() {
		return buy_status;
	}
	public void setBuy_status(int buy_status) {
		this.buy_status = buy_status;
	}
	
	
}
