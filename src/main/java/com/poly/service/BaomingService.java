package com.poly.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.impl.jam.internal.elements.PrimitiveClassImpl;

import car_beans.TbCityArea;
import car_beans.TbDataBaoming;
import car_beans.TbDataProject;
import car_daos.DBConnect;
import car_daos.TbCityAreaDao;
import car_daos.TbDataBaomingDao;
import car_daos.TbDataProjectDao;

import com.poly.bean.newNews;
import com.poly.dao.DAOUtil;
import com.poly.dao.subDaos.BaomingSubDao;
import com.poly.util.IpCityUtil;

public class BaomingService {
	private static final BaomingService instance = new BaomingService();
	public static  BaomingService getInstance(){
		return instance;
	}
	BaomingSubDao baomingSubDao = new BaomingSubDao();
	TbDataProjectDao tbDataProjectDao = new TbDataProjectDao();
	public List<Map<String, String>> queryTuiguangInfo(String pro_nums,String uleve, int pstatus){
		return baomingSubDao.queryTuiguangInfo(pro_nums,uleve,pstatus);
	}
	
	public List<Map<String, String>> queryKCTBaoming(String name,String phone,String beginDate,String endDate,int return_visit_state,int buycar_emergency,int is_key_cus,int phoneerror,int provId,int cityId,int brandId,int chexiId,int chexingId,int prefIndex,int size, String iway,int prov3,int city3,int chexiId3,String iway3,int apply_source,int buy_status){
		endDate = getEndDate2(endDate);
		//String whereSql = "";
		return baomingSubDao.queryKCTBaoming(name, phone, beginDate, endDate, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId,cityId,brandId,chexiId,chexingId, prefIndex, size,iway,prov3,city3,chexiId3,iway3,apply_source,buy_status);
	}
	
	public List<Map<String, String>> queryKCTBaoming01(String name,String phone,String beginDate,String endDate,int return_visit_state,int buycar_emergency,int is_key_cus,int phoneerror,int provId,int cityId,int brandId,int chexiId,int chexingId,int prefIndex,int size, String iway,int prov3,int city3,int chexiId3,String iway3,String pro_state,String provs,String citys,int apply_source,int buy_status ){
		endDate = getEndDate2(endDate);
		//String whereSql = "";
		return baomingSubDao.queryKCTBaoming01(name, phone, beginDate, endDate, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId,cityId,brandId,chexiId,chexingId, prefIndex, size,iway,prov3,city3,chexiId3,iway3,provs,citys,apply_source,buy_status);
	}
	
	public int  queryKCTBaomingCount(String name,String phone,String beginDate,String endDate,int return_visit_state,int buycar_emergency,int is_key_cus,int phoneerror,int provId,int cityId,int brandId,int chexiId,int chexingId, String iway,int prov3,int city3,int chexiId3,String iway3,int apply_source,int buy_status){
		endDate = getEndDate2(endDate);
		//String whereSql = "";
		return baomingSubDao.queryKCTBaomingCount(name, phone, beginDate, endDate, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId,cityId,brandId,chexiId,chexingId,iway,prov3,city3,chexiId3,iway3,apply_source,buy_status);
	}
	
	public int  queryKCTBaomingCount01(String name,String phone,String beginDate,String endDate,int return_visit_state,int buycar_emergency,int is_key_cus,int phoneerror,int provId,int cityId,int brandId,int chexiId,int chexingId, String iway,int prov3,int city3,int chexiId3,String iway3,String pro_state,String provs,String citys,int apply_source,int buy_status){
		endDate = getEndDate2(endDate);
		//String whereSql = "";
		return baomingSubDao.queryKCTBaomingCount01(name, phone, beginDate, endDate, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId,cityId,brandId,chexiId,chexingId,iway,prov3,city3,chexiId3,iway3,provs,citys,apply_source,buy_status);
	}

	
	public TbDataProject queryProjectDetailByPId(String pro_num){
		TbDataProject project = null;
		List<TbDataProject> list = tbDataProjectDao.where("pro_num = '"+pro_num+"'");
		if(list.size() > 0)
			project = list.get(0);
		return project;
	}
	
	String getEndDate(String endDate){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date = sdf.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = new GregorianCalendar(); 
	    calendar.setTime(date); 
		calendar.add(calendar.DATE,1);
		date=calendar.getTime();
		endDate = sdf.format(date);
		return endDate;
	}
	String getEndDate2(String endDate){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date = sdf.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		endDate = sdf.format(date);
		return endDate;
	}
	public Map<String, Object> kctmanageDetail(Integer baomingid) throws SQLException {
		
		Map<String, Object> newMap = new HashMap<String, Object>();
		
		String sql = "select t1.ip ip2,t1.id,t1.name,t1.phone,DATE_FORMAT(t1.baoming_date,'%Y-%m-%d %H:%i:%s') tdate,t1.type,t1.brand,t1.serial,t1.model,t1.prov,t1.sample_content,t1.city,t1.area,t1.car_info,t1.ip,t1.return_visit_state,t1.buycar_emergency,t1.is_key_cus,t1.phoneerror,DATE_FORMAT(t1.return_visit_time,'%Y-%m-%d %H:%i:%s') trvt,t1.return_visit_content,t1.remarks,t1.return_visit_man,t1.tuisong_flag,t1.attend_type,t1.attend_date,t1.pp_state,t1.pz_city,t1.phone_state,t1.is_jp,t1.jp_car,t1.is_buycar,t1.buy_state,t1.buy_ys,t1.buy_bsx,t1.buy_pl,t1.buy_color,t1.know_yh,t1.p_job,t1.p_weixin,t1.p_qq,t1.phoneerror_count,t1.constacterror,t1.constacterror_count,t2.prov pprov,t2.city pcity,t3.iway,t1.real_type from tb_data_baoming t1 left join tb_dict_phone t2 on substring(t1.phone,1,7) = t2.phone_num left join dbo_car_catalognew t3 on t1.serial = t3.catalogid where t1.id = "+baomingid+" ";
		String remarksNew = "";
		List<Map<String, Object>> maps = DAOUtil.executeQuery(sql, null);
		int id = (Integer)maps.get(0).get("id");
		for(String key : maps.get(0).keySet()){
			if("ip".equals(key)){
				String ip = (String)maps.get(0).get(key);
				
				if(!(null==ip||"".equals(ip))){
					String city = IpCityUtil.getCity(ip);
					//System.out.println(city);
					if(null==city||"".equals(city)){
						newMap.put(key,"");
					}else{
						newMap.put(key,city);
					}
				}
			}else if("phone".equals(key)){
				newMap.put(key, maps.get(0).get(key));  
				String phone = (String)maps.get(0).get(key);
				String sql2 = "select remarks from tb_data_baoming where phone = '"+phone+"' and remarks is not null and id !="+id+" order by return_visit_man desc";
				List<Map<String, Object>> maps2 = DAOUtil.executeQuery(sql2, null);
				for(int i=0;i<maps2.size();i++){
					String str = (String)maps2.get(i).get("remarks");
					if(null!=str && (!"null".equals(str)) && (!"".equals(str)))
					remarksNew += str;
				}
				
				String sql3 = "select  DISTINCT car_info,(select CONCAT('品牌:',iway,' ','车系:',catalogname) from dbo_car_catalognew where catalogid = serial) as carinfo from tb_data_baoming where phone = '"+phone+"' and return_visit_state = 0 and id !="+id+" order by baoming_date desc";
				List<Map<String, Object>> maps3 = DAOUtil.executeQuery(sql3, null);
				if(maps3.size() == 0){
					newMap.put("carinfo1", "");   
					newMap.put("carinfo2", "");   
				}
				if(maps3.size() == 1){
					if(null==maps3.get(0).get("car_info")|| "".equals(maps3.get(0).get("car_info")))
						newMap.put("carinfo1", maps3.get(0).get("carinfo")); 
					else
						newMap.put("carinfo1", maps3.get(0).get("car_info")); 
					newMap.put("carinfo2", "");   
				}
				if(maps3.size() > 1){
					if(null==maps3.get(0).get("car_info")|| "".equals(maps3.get(0).get("car_info")))
						newMap.put("carinfo1", maps3.get(0).get("carinfo")); 
					else
						newMap.put("carinfo1", maps3.get(0).get("car_info")); 
					if(null==maps3.get(1).get("car_info")|| "".equals(maps3.get(1).get("car_info")))
						newMap.put("carinfo2", maps3.get(1).get("carinfo")); 
					else
						newMap.put("carinfo2", maps3.get(1).get("car_info"));  
				}
				
			}else{
				newMap.put(key, maps.get(0).get(key));   
			}
		}   
		
		if(null != newMap.get("remarks") && (!"null".equals(newMap.get("remarks"))) && (!"".equals(newMap.get("remarks")))){
			newMap.put("remarksNew",remarksNew+((String)newMap.get("remarks")));
		}else{
			newMap.put("remarksNew",remarksNew);
		}
			newMap.put("sample_content",newMap.get("sample_content"));
		
		return newMap;
	}

	public List<TbCityArea> getAreaInfo(String city) {
		String sql = "city = "+city;
		return TbCityAreaDao.where(sql);
	}

	public int tuisongCity(TbDataBaoming tb) {
		
		return TbDataBaomingDao.update(tb);
	}

	public int updateBaomingyf(TbDataBaoming d) {
		
		return TbDataBaomingDao.update(d);
	}
	

	public void updateSamePhoneApply(TbDataBaoming d) {
		
		int state = d.getReturn_visit_state();
		if(state == 1){
		
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = sdf.format(new Date());
			String content = d.getReturn_visit_man()+" "+time + "同一号码，系统自动处理";
			String sql = "UPDATE tb_data_baoming SET phoneerror_count = 0,return_visit_state = 1,is_buycar = "+d.getIs_buycar()+",return_visit_man = '"+d.getReturn_visit_man()+"' ,return_visit_time = NOW(),return_visit_content='"+content+"' ,remarks='',area = "+d.getArea()+" where phone = '"+d.getPhone()+"' and return_visit_state = 0 and id <> "+d.getId();
			//System.err.println(sql);
			DBConnect dbc = null;
			try {
				dbc = new DBConnect(sql);
				dbc.executeUpdate();;
			}catch(Exception e){
				e.printStackTrace();
			} finally {
				if (dbc != null) {
					try {
						dbc.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		}
	}

	public List<Map<String, Object>> queryTuiguangInfo() throws SQLException {
		String sql = "select pro_num from tb_data_project";
		return DAOUtil.executeQuery(sql, null);
	}

	public List<Map<String, Object>> queryFenzhanInfo() throws SQLException {
		String sql = "select org_id,org_name from finance.tb_fin_org";
		return DAOUtil.executeQuery(sql, null);
	}

	public List<Map<String, Object>> queryShixiaoInfo(String pro_num,
			String fenzhan, String fenlei) throws SQLException {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("select t3.`name`,t3.phone,date_format(t3.baoming_date,'%Y-%m-%d %H:%i:%s') baoming_date,t4.catalogname as provname , t5.catalogname as cityname,t1.acti_name,t2.is_trans,t2.return_visit_content from tb_data_project t1,tb_data_visit_record t2,tb_data_baoming t3 , dbo_are_catalog t4,dbo_are_catalog t5 where t1.pro_num = t2.pro_num and t2.baoming_id = t3.id and t3.prov = t4.catalogid and t3.city = t5.catalogid and t2.attend_type in (1,2,3,4) and t2.is_reach = 0");
		
		if(null!=pro_num && !"".equals(pro_num)){
			sb.append(" and t1.pro_num = '"+pro_num+"'");
		}
		
		if(null!=fenzhan && !"".equals(fenzhan)){
			sb.append(" and t1.ini_org = "+fenzhan);
		}
		
		if(null!=fenlei && !"".equals(fenlei)){
			sb.append(" and t1.service_type = "+fenlei);
		}
		
		
		sb.append(" order by t3.baoming_date desc ");
		
		return DAOUtil.executeQuery(sb.toString(), null);
	}

	public List<Map<String, String>> queryKCTBaoming2(String name,
			String phone, String beginDate, String endDate, int return_visit_state,
			int buycar_emergency, int is_key_cus, int phoneerror, String prov,
			String city, String brands, int prefIndex, int size, String iway, int iserial) {
		endDate = getEndDate2(endDate);
		return baomingSubDao.queryKCTBaoming2(name, phone, beginDate, endDate, return_visit_state, buycar_emergency, is_key_cus, phoneerror, prov,city,brands,prefIndex, size,iway,iserial);
	}

	public int queryKCTBaoming2Count(String name, String phone, String beginDate,
			String endDate, int return_visit_state, int buycar_emergency,
			int is_key_cus, int phoneerror, String prov, String city,
			String brands, String iway, int iserial) {
		endDate = getEndDate2(endDate);
		return baomingSubDao.queryKCTBaoming2Count(name, phone, beginDate, endDate, return_visit_state, buycar_emergency, is_key_cus, phoneerror, prov, city, brands,iway,iserial);
	}

	public List<Map<String, String>> queryIwayInfo(String brands) throws SQLException {
		String sql = "SELECT DISTINCT iway  ,wayname from dbo_car_catalognew WHERE  iway !='' and iway is not null and  wayname is not null and wayname !='' and isdelete = 0 and pathlevel=3 ORDER BY wayname";
		if(null != brands && !"-1".equals(brands) && !"".equals(brands)){
			sql = "SELECT DISTINCT iway  ,wayname from dbo_car_catalognew WHERE  iway !='' and iway is not null and  wayname is not null and wayname !='' and isdelete = 0 and pathlevel=3 and iway in ("+formatSqlIn(brands)+") ORDER BY wayname";
		}
		
		return DAOUtil.executeQuery(sql, null);
	}
	
	private String formatSqlIn(String str){
		String result = "";
		if(str==null || str.length() == 0)
			return result;
		String[] strs = str.split(",");
		for (String id : strs) {
			if(id.length() > 0){
				result += "'" + id + "',";
			}
		}
		if(result.length() > 0)
			result = result.substring(0,result.length()-1);
		return result;
	}

	public List<Map<String, String>> querySatisfy(String pro_num, int state, String beginDate,
			String endDate, String name, String phone, String keyword,
			int brandId, int chexiId, int prov, int city, int start, int rows, String iway) {
		if("".equals(beginDate))
			beginDate = "1970-1-1";
		if("".equals(endDate))
			endDate = "2100-1-1";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date = sdf.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = new GregorianCalendar(); 
	    calendar.setTime(date); 
		calendar.add(calendar.DATE,1);
		date=calendar.getTime();
		endDate = sdf.format(date);
		return baomingSubDao.querySatisfy(pro_num,state, beginDate, endDate, name, phone, keyword, brandId, chexiId, prov, city, start, rows,iway);
	}

	public Map<String, Object> querySatisfyDetail(Integer sid) {

		return baomingSubDao.querySatisfyDetail(sid);
	}

	public List<Map<String, String>> queryKCTBaoming3(String name,
			String phone, String beginDate, String endDate, int return_visit_state,
			int buycar_emergency, int is_key_cus, int phoneerror, int provId,
			int cityId, int brandId, int chexiId, int chexingId, int prefIndex,
			int size, String competing, String iway,int prov3,int city3,int chexiId3,String iway3,int apply_source,int buy_status) {
		endDate = getEndDate2(endDate);
		//String whereSql = "";
		return baomingSubDao.queryKCTBaoming3(name, phone, beginDate, endDate, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId,cityId,brandId,chexiId,chexingId, prefIndex, size,competing,iway,prov3,city3,chexiId3,iway3,apply_source,buy_status);
	}
	
	public List<Map<String, String>> queryKCTBaoming31(String name,
			String phone, String beginDate, String endDate, int return_visit_state,
			int buycar_emergency, int is_key_cus, int phoneerror, int provId,
			int cityId, int brandId, int chexiId, int chexingId, int prefIndex,
			int size, String competing, String iway,int prov3,int city3,int chexiId3,String iway3,String pro_state,String provs,String citys,int apply_source,int buy_status) {
		endDate = getEndDate2(endDate);
		//String whereSql = "";
		return baomingSubDao.queryKCTBaoming31(name, phone, beginDate, endDate, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId,cityId,brandId,chexiId,chexingId, prefIndex, size,competing,iway,prov3,city3,chexiId3,iway3,provs,citys,apply_source,buy_status);
	}

	public int queryKCTBaomingCount3(String name, String phone, String beginDate,
			String endDate, int return_visit_state, int buycar_emergency,
			int is_key_cus, int phoneerror, int provId, int cityId,
			int brandId, int chexiId, int chexingId, String competing, String iway,int prov3,int city3,int chexiId3,String iway3,int apply_source,int buy_status) {
		endDate = getEndDate2(endDate);
		//String whereSql = "";
		return baomingSubDao.queryKCTBaomingCount3(name, phone, beginDate, endDate, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId,cityId,brandId,chexiId,chexingId,competing,iway,prov3,city3,chexiId3,iway3,apply_source,buy_status);
	}
	
	public int queryKCTBaomingCount31(String name, String phone, String beginDate,
			String endDate, int return_visit_state, int buycar_emergency,
			int is_key_cus, int phoneerror, int provId, int cityId,
			int brandId, int chexiId, int chexingId, String competing, String iway,int prov3,int city3,int chexiId3,String iway3,String pro_state,String provs,String citys,int apply_source,int buy_status) {
		endDate = getEndDate2(endDate);
		//String whereSql = "";
		return baomingSubDao.queryKCTBaomingCount31(name, phone, beginDate, endDate, return_visit_state, buycar_emergency, is_key_cus, phoneerror, provId,cityId,brandId,chexiId,chexingId,competing,iway,prov3,city3,chexiId3,iway3,provs,citys,apply_source,buy_status);
	}

	public List<Map<String, String>> queryTuiguangInfoByPage(String pro_nums,
			String uleve, int pstatus, String beginDate, String endDate,
			String name, String phone, String keyword, int brandId,
			int chexiId, int prov, int city, int start, int rows, String iway2, int ywtype) {
		List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();
		if("".equals(beginDate))
			beginDate = "1970-1-1";
		if("".equals(endDate))
			endDate = "2100-1-1";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date = sdf.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = new GregorianCalendar(); 
	    calendar.setTime(date); 
		calendar.add(calendar.DATE,1);
		date=calendar.getTime();
		endDate = sdf.format(date);
		List<Map<String, String>> maps =  baomingSubDao.queryTuiguangInfoByPage(pro_nums,uleve,pstatus,beginDate, endDate, name, phone, keyword, brandId, chexiId, prov, city, start, rows,iway2,ywtype);
		if(maps.size()>0){
			for(Map<String,String> map:maps){
				String competing = map.get("competing");
				String promo_start_date = map.get("promo_start_date");
				String promo_end_date = map.get("promo_end_date");
				String provid = map.get("provId");
				String cityid = map.get("cityId");
				String brand = map.get("brandId");
				String chexi = map.get("chexiId");
				String chexing = map.get("chexingId");
				String iway = map.get("iway");
				if(null == promo_start_date || "".equals(promo_start_date)){
					promo_start_date = "2000-01-01";
				}
				if(null == promo_end_date || "".equals(promo_end_date)){
					promo_end_date = "2100-01-01";
				}
				if(null == provid || "".equals(provid)){
					provid = "-1";
				}
				if(null == cityid || "".equals(cityid)){
					cityid = "-1";
				}
				if(null == brand || "".equals(brand)){
					brand = "-1";
				}
				if(null == chexi || "".equals(chexi)){
					chexi = "-1";
				}
				if(null == chexing || "".equals(chexing)){
					chexing = "-1";
				}
				
				int jinpin_count = 0;//baomingSubDao.queryJinpinCount(competing,promo_start_date,promo_end_date,Integer.parseInt(provid),Integer.parseInt(cityid),Integer.parseInt(brand),Integer.parseInt(chexi),Integer.parseInt(chexing),iway);
				map.put("baoming_count", jinpin_count+"");
				
				mapList.add(map);
			}
		}
		
		return mapList;
	}

	public List<Map<String, String>> queryTuiguangInfoByPro(String pro_nums,
			String uleve, int pstatus, String pro_numid) {
		return baomingSubDao.queryTuiguangInfoByPro(pro_nums,uleve,pstatus,pro_numid);
	}
	
	public List<Map<String, Object>> querySub(String sub_sites_id) throws SQLException {
		String sql = "select t.*,t1.catalogid,t1.fatherid from car.tb_sub_sites t , dbo_are_catalog t1,finance.tb_fin_org t2 where t.areaid = t2.org_comment and t.areaid = t1.catalogid and t2.org_id = "+sub_sites_id;
		return DAOUtil.executeQuery(sql, null);
	}

	public List<Map<String, Object>> queryFchid(String fpid, String id) throws SQLException {
		String sql = "select l.catalogid from dbo_are_catalog l where l.catalogid not in ("+fpid+") and l.fatherid = "+id+" and isdelete = 0";
		return DAOUtil.executeQuery(sql, null);
	}
	public List<Map<String,String>> getSubstationInfo(String id){
		String sql = "dis_id = "+id+"  order by id";
		return baomingSubDao.where(sql);
	}
	
	public List<Map<String, String>> querySample(String region,String substation,String beginDate,String endDate,String customerName,String  iway3,int prefIndex,int size ){
		return baomingSubDao.querySample(region,substation,beginDate,endDate,customerName,iway3,prefIndex, size);
	}
	public int  querySampleCount(String region,String substation,String beginDate,String endDate,String customerName,String  iway3){
		endDate = getEndDate2(endDate);
		//String whereSql = "";
		return baomingSubDao.querySampleCount(region,substation,beginDate,endDate,customerName,iway3);
	}
	public int updateSample(String man,String userid,String id,String date,String samplecontent) {
		return baomingSubDao.updateSample(man,userid,id,date,samplecontent);
	}
	public List<Map<String, String>>  querySampleResult(String customerName,String customerName2,String beginDate,String endDate,int prefIndex,int size){
		return baomingSubDao.querySampleResult(customerName,customerName2,beginDate,endDate,prefIndex, size);
	}
	public int  querySampleResultCount(String customerName,String customerName2,String beginDate,String endDate){
		endDate = getEndDate2(endDate);
		//String whereSql = "";
		return baomingSubDao.querySampleResultCount(customerName,customerName2,beginDate,endDate);
	}
	
}
