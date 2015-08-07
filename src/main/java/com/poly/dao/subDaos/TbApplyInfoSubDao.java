package com.poly.dao.subDaos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import sun.management.counter.Variability;
import car_beans.TbApplyDetail;
import car_beans.TbApplyInfo;
import car_daos.DBConnect;
import car_daos.TbApplyDetailDao;
import car_daos.TbApplyInfoDao;

import com.poly.bean.GroupExcelEntity;
import com.poly.service.AppInfoService.AttendType;
import com.poly.service.AppInfoService.Cusintention;
import com.poly.service.AppInfoService.SourceType;
import com.poly.util.IpCityUtil;
import com.sun.org.apache.bcel.internal.generic.DCMPG;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.IntData;

public class TbApplyInfoSubDao extends TbApplyInfoDao{

	public List<HashMap<String, Object>> listApplyInfo(int start, int rows,String beginDate,String endDate,String name,String phone,String beginOrderDate,String endOrderDate,int isBuy,int phoneState,String brandname,int chexiId,int againReturnVisit,int prov,int city,int type,int againType,String brands,String is_key_cus,String cus_intention){
		HashMap<String, Object> map = null;
		DBConnect dbc = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String brandStr  = "";
		if(!"-1".equals(brandname)){
			if("-2".equals(brandname))
				brandStr = " and t2.iway in ("+brands+")";
			else
				brandStr = " and t2.iway = '"+brandname+"'";
		}
		String keyCusStr = "";
		if(!"-1".equals(is_key_cus))
			keyCusStr = " and t1.is_key_cus = "+is_key_cus;
		String chexiStr = "";
		if(chexiId > 0)
			chexiStr = " and t2.fatherid = "+chexiId;
		String provStr = "";
		String provStr1 = "";
		if(prov > 0){
			provStr = " and (t1.prov = "+prov+" or t1.phone_prov = "+prov+" ) ";
			provStr1 = " and t1.prov = "+prov+" ";
		}
			
		String cityStr = "";
		String cityStr1 = "";
		if(city > 0){
			cityStr = " and (t1.city = "+city+" or t1.phone_city = "+city+" ) ";
			cityStr1 = " and t1.city = "+city+" ";
		}
			
		String orderDateStr = "";
		if(!"".equals(beginOrderDate)&&!"".equals(endOrderDate))
			orderDateStr =" and t1.order_time between '"+beginOrderDate+"' and "
						  + "'"+endOrderDate+"'";
		String isBuyStr = "";
		if(isBuy >= 0)
			isBuyStr = " and t1.isbuy = " +isBuy;
		String againTypeStr = "";
		if(againType >= 0)
			againTypeStr = " and t1.again_return_visit = "+againType;
		String typeStr = "";
		if(type!=-1)
			typeStr = " and t1.type= "+type;
		String phoneStateStr = "";
		if(phoneState >= 0)
			phoneStateStr = " and phone_state = "+phoneState +" ";
		String rvs = "";
		if(againReturnVisit==0)
			rvs = " and ( t1.return_visit_state = 0 and ( (t1.tuisong_flag = 1  "+provStr1+cityStr1+") or (t1.tuisong_flag = 0  "+provStr+cityStr+")))";
		else
			rvs = " and t1.return_visit_state = 1 and ( (t1.tuisong_flag = 1  "+provStr1+cityStr1+") or (t1.tuisong_flag = 0  "+provStr+cityStr+"))";
		String cus_intentionStr = "";
		if(!"-1".equals(cus_intention))
			cus_intentionStr = " and t1.cus_intention = "+cus_intention+" ";
		String sql1 = "select  t1.phone,t1.return_visit_state,t1.id,t1.name,t1.appdate from tb_apply_info t1  left outer  join dbo_car_catalognew t2 on t1.modelid = t2.catalogid where t1.appdate BETWEEN "
				+ "'"+beginDate+"' and "
				+ "'"+endDate+"' and "
				+ "t1.name like '%"+name+"%' and "
				+ "t1.phone like '%"+phone+"%' "
				+ " and t1.isDelete = 0 "
				+ orderDateStr
				+ phoneStateStr
				+ isBuyStr
				+ brandStr
				+ chexiStr
				+ rvs
				//+ provStr
				//+ cityStr
				+ againTypeStr
				+ typeStr
				+ keyCusStr
				+ cus_intentionStr
				+ " order by t1.appdate desc limit ?,?";
		String sql2 = "select count(*) count from tb_apply_info t1  left outer  join dbo_car_catalognew t2 on t1.modelid = t2.catalogid where t1.appdate BETWEEN "
				+ "'"+beginDate+"' and "
				+ "'"+endDate+"' and "
				+ "t1.name like '%"+name+"%' and "
				+ "t1.phone like '%"+phone+"%' "
				+ " and t1.isDelete = 0 "
				+ orderDateStr
				+ phoneStateStr
				+ isBuyStr
				+ brandStr
				+ chexiStr
				+ rvs
				//+ provStr
				//+ cityStr
				+ againTypeStr
				+ typeStr
				+ keyCusStr
				+ cus_intentionStr;
		int count = 0;
		try {
			dbc = new DBConnect(sql2);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
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
		//List<String> phoneList = getDoublePhone();
		try {
			dbc = new DBConnect(sql1);
			dbc.setInt(1, start);
			dbc.setInt(2, rows);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("count", count);
				map.put("id", rs.getInt("id"));
				map.put("name", rs.getString("name"));
				map.put("appdate", rs.getDate("appdate"));
				map.put("return_visit_state", rs.getInt("return_visit_state"));	
				String pho = rs.getString("phone");
				String state  = "";
				//if(phoneList.contains(pho))
				//	state = "重复号码";
				map.put("phoneState", state);
				result.add(map);
			}

		} catch (Exception e) {
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
		return result;
	}
	public List<HashMap<String, Object>> listRev(int start, int rows,String beginDate,String endDate,String carId,int chexiId,int prov,int city,int type,String rvman,int typex,String brands){
		HashMap<String, Object> map = null;
		DBConnect dbc = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String brandStr  = "";
		if(!"-1".equals(carId)){
			if("-2".equals(carId))
				brandStr = " and t3.iway in ("+brands+")";
			else
				brandStr = " and t3.iway = '"+carId+"'";
		}

		String chexiStr = "";
		if(chexiId > 0)
			chexiStr = " and t3.fatherid = "+chexiId;
		String provStr = "";
		if(prov > 0)
			provStr = " and (t1.prov = "+prov+" or t1.phone_prov = "+prov+" ) ";
		String cityStr = "";
		if(city > 0)
			cityStr = " and (t1.city = "+city+" or t1.phone_city = "+city+" ) ";
		String rvmanStr="";
		if(!"-1".equals(rvman))
			rvmanStr=" and t1.return_visit_man='"+rvman+"'";
		String retimeStr = "";
		if(type==1)
			retimeStr =" and t1.return_visit_time between"
					+ " '"+beginDate+"' and"
					+ " '"+endDate+"'";
		String typeStr = "";
		if(typex!=-1)
			typeStr = " and t1.type= "+typex;
		String sql1 = "select t1.type,t1.name,t1.appdate,t1.phone,t1.phone_state,t1.return_visit_time,t1.return_visit_man,t1.remarks,t3.iway pingpai,t4.catalogname chexi from tb_apply_info t1   left outer  join dbo_car_catalognew t3 on t1.modelid = t3.catalogid left outer join  dbo_car_catalognew t4 on t3.fatherid = t4.catalogid where "
				+ "t1.return_visit_state="+type
				+ " and t1.isDelete = 0 "
				+ typeStr
				+ retimeStr
				+ brandStr
				+ chexiStr
				+ rvmanStr
				+ provStr
				+ cityStr
				+ " order by t1.appdate desc limit?,?";
		String sql2 =  "select count(*) count from tb_apply_info t1   left outer  join dbo_car_catalognew t3 on t1.modelid = t3.catalogid left outer join  dbo_car_catalognew t4 on t3.fatherid = t4.catalogid where "
				+ "t1.return_visit_state="+type
				+ " and t1.isDelete = 0 "
				+ typeStr
				+ retimeStr
				+ brandStr
				+ chexiStr
				+ rvmanStr
				+ provStr
				+ cityStr;
		int count = 0;
		try {
			dbc = new DBConnect(sql2);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
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
		try {
			dbc = new DBConnect(sql1);
			dbc.setInt(1, start);
			dbc.setInt(2, rows);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("count", count);
				map.put("name", rs.getString("name"));
				map.put("phone", rs.getString("phone"));
				map.put("appdate", rs.getString("appdate"));
				map.put("type", SourceType.getEnum(rs.getString("type")).getType());
				int state = rs.getInt("phone_state");
				String pState = "";
				if(state==0)
					pState = "有效号码";
				else if(state==1)
					pState = "无效号码";
				else
					pState = "重复号码";
				map.put("phone_state", pState);
				map.put("return_visit_time", rs.getString("return_visit_time"));
				map.put("return_visit_man", rs.getString("return_visit_man"));
				map.put("remarks", rs.getString("remarks"));
				map.put("pingpai", rs.getString("pingpai"));
				map.put("chexi", rs.getString("chexi"));
				result.add(map);
			}

		} catch (Exception e) {
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
		return result;
	}
	public String getDownloadSql(String carId,int chexiId,int prov,int city,String beginDate,String endDate,String name,String phone,String rvman,int type,int typex,String brands,String is_key_cus,String visit_type,String beginOrderDate,String endOrderDate,String cus_intention){
		String brandStr="";
		if(!"-1".equals(carId)){
			if("-2".equals(carId))
				brandStr = " and t3.iway in ("+brands+")";
			else
				brandStr = " and t3.iway='"+carId+"'";
		
		}
		String keyCusStr = "";
		if(!"-1".equals(is_key_cus))
			keyCusStr = " and t1.is_key_cus = "+is_key_cus;	
		String chexiStr = "";
		if(chexiId > 0)
			chexiStr = " and t3.fatherid="+chexiId;
		String chexingStr ="";
		String provStr = "";
		if(prov > 0)
			provStr = " and (t1.prov = "+prov+" or t1.phone_prov = "+prov+" ) ";
		String cityStr = "";
		if(city > 0)
			cityStr =  " and (t1.city = "+city+" or t1.phone_city = "+city+" ) ";
		String rvmanStr="";
			if(!"-1".equals(rvman))
				rvmanStr=" and t1.return_visit_man='"+rvman+"'";
		String typeStr="";
			if(type>=0)
				typeStr=" and t1.isbuy="+type;
		String typexStr = "";
			if(typex!=-1)
				typexStr = " and t1.type= "+typex;	
			String visit_typeStr  = "";
			if(!"-1".equals(visit_type))
				visit_typeStr  = " and t1.return_visit_state = "+visit_type;
			String revDateStr = "";
			if(!("".equals(beginOrderDate)&&"".equals(endOrderDate)))
			{
				if("".equals(beginOrderDate))
					beginOrderDate = "1970-1-1";
				if("".equals(endOrderDate))
					endOrderDate = "2100-1-1";
				revDateStr  = " and (t1.return_visit_time between '"+beginOrderDate+" 00:00:00' and '"+endOrderDate+" 23:59:59' ) ";
			}
			String cus_intentionStr = "";
			if(!"-1".equals(cus_intention))
				cus_intentionStr = " and t1.cus_intention = "+cus_intention+" ";
		String sql1 = "select  t1.cus_intention,t1.is_key_cus,t7.prov 'phone_prov',t7.city 'phone_city',t5.catalogname 'app_prov',t6.catalogname 'app_city', t1.type,t1.remarks,  t1.name,t1.appdate, t3.iway 'pingpai',t1.phone,t1.phone_state,t3.catalogname 'chexing', t4.catalogname 'chexi'  from tb_apply_info t1   left outer  join dbo_car_catalognew t3 on t1.modelid = t3.catalogid  left outer  join dbo_car_catalognew t4 on t3.fatherid = t4.catalogid    LEFT OUTER JOIN dbo_are_catalog t5 on t1.prov = t5.catalogid LEFT OUTER JOIN dbo_are_catalog t6 on t1.city = t6.catalogid LEFT OUTER JOIN tb_dict_phone t7 on SUBSTRING(t1.phone,1,7) = t7.phone_num where"
				+ " t1.name like '%"+name+"%' "
				+ " and t1.phone like '%"+phone+"%'"
				+ " and t1.isDelete = 0 "
				+ typexStr
				+ provStr
				+ cityStr
				+ " and t1.appdate between "
				+ "'"+beginDate+"' and "
				+ "'"+endDate+"' "
				+ rvmanStr
				+ typeStr
				+ brandStr
				+ cityStr
				+ chexiStr
				+ chexingStr
				+ keyCusStr
				+ visit_typeStr
				+ revDateStr
				+ cus_intentionStr
				+ " order by t1.appdate desc ";
		return sql1;
	}
	public List<HashMap<String, Object>> downBaoming(String carId,int chexiId,int prov,int city,String beginDate,String endDate,String name,String phone,String rvman,int type,int typex,String brands,String is_key_cus,String visit_type,String beginOrderDate,String endOrderDate,String cus_intention){
		HashMap<String, Object> map = null;
		DBConnect dbc = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String brandStr="";
		if(!"-1".equals(carId)){
			if("-2".equals(carId))
				brandStr = " and t3.iway in ("+brands+")";
			else
				brandStr = " and t3.iway='"+carId+"'";
		
		}
		String keyCusStr = "";
		if(!"-1".equals(is_key_cus))
			keyCusStr = " and t1.is_key_cus = "+is_key_cus;	
		String chexiStr = "";
		if(chexiId > 0)
			chexiStr = " and t3.fatherid="+chexiId;
		String chexingStr ="";
		String provStr = "";
		if(prov > 0)
			provStr = " and (t1.prov = "+prov+" or t1.phone_prov = "+prov+" ) ";
		String cityStr = "";
		if(city > 0)
			cityStr =  " and (t1.city = "+city+" or t1.phone_city = "+city+" ) ";
		String rvmanStr="";
			if(!"-1".equals(rvman))
				rvmanStr=" and t1.return_visit_man='"+rvman+"'";
		String typeStr="";
			if(type>=0)
				typeStr=" and t1.isbuy="+type;
		String typexStr = "";
			if(typex!=-1)
				typexStr = " and t1.type= "+typex;	
			String visit_typeStr  = "";
			if(!"-1".equals(visit_type))
				visit_typeStr  = " and t1.return_visit_state = "+visit_type;
			String revDateStr = "";
			if(!("".equals(beginOrderDate)&&"".equals(endOrderDate)))
			{
				if("".equals(beginOrderDate))
					beginOrderDate = "1970-1-1";
				if("".equals(endOrderDate))
					endOrderDate = "2100-1-1";
				revDateStr  = " and (t1.return_visit_time between '"+beginOrderDate+" 00:00:00' and '"+endOrderDate+" 23:59:59' ) ";
			}
			//String revDateStr  = " and (t1.return_visit_time between '"+beginOrderDate+" 00:00:00' and '"+endOrderDate+" 23:59:59' ) ";
			String cus_intentionStr = "";
			if(!"-1".equals(cus_intention))
				cus_intentionStr = " and t1.cus_intention = "+cus_intention+" ";
		String sql1 = "select  t1.cus_intention,t1.is_key_cus,t7.prov 'phone_prov',t7.city 'phone_city',t5.catalogname 'app_prov',t6.catalogname 'app_city', t1.type,t1.remarks,  t1.name,t1.appdate, t3.iway 'pingpai',t1.phone,t1.phone_state,t3.catalogname 'chexing', t4.catalogname 'chexi'  from tb_apply_info t1   left outer  join dbo_car_catalognew t3 on t1.modelid = t3.catalogid  left outer  join dbo_car_catalognew t4 on t3.fatherid = t4.catalogid    LEFT OUTER JOIN dbo_are_catalog t5 on t1.prov = t5.catalogid LEFT OUTER JOIN dbo_are_catalog t6 on t1.city = t6.catalogid LEFT OUTER JOIN tb_dict_phone t7 on SUBSTRING(t1.phone,1,7) = t7.phone_num where"
				+ " t1.name like '%"+name+"%' "
				+ " and t1.phone like '%"+phone+"%'"
				+ " and t1.isDelete = 0 "
				+ typexStr
				+ provStr
				+ cityStr
				+ " and t1.appdate between "
				+ "'"+beginDate+"' and "
				+ "'"+endDate+"' "
				+ rvmanStr
				+ typeStr
				+ brandStr
				+ cityStr
				+ chexiStr
				+ chexingStr
				+ keyCusStr
				+ visit_typeStr
				+ revDateStr
				+ cus_intentionStr
				+ " order by t1.appdate desc ";
		try {
			dbc = new DBConnect(sql1);
			ResultSet rs = dbc.executeQuery();
			int id=1;
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("id", id);
				//map.put("area1", rs.getString("area1")==null?"未知":rs.getString("area1"));
				map.put("name", rs.getString("name"));
				map.put("appdate", rs.getString("appdate"));
				map.put("pingpai", rs.getString("pingpai")==null?"":rs.getString("pingpai"));
				map.put("chexi", rs.getString("chexi"));
				map.put("phone", rs.getString("phone"));
				map.put("type", rs.getString("type"));
				map.put("phone_prov", rs.getString("phone_prov")==null?"":rs.getString("phone_prov"));
				map.put("phone_city", rs.getString("phone_city")==null?"":rs.getString("phone_city"));
				map.put("app_prov", rs.getString("app_prov")==null?"":rs.getString("app_prov"));
				map.put("app_city", rs.getString("app_city")==null?"":rs.getString("app_city"));
				int state = rs.getInt("phone_state");
				String pState = "";
				if(state==0)
					pState = "有效号码";
				else if(state==1)
					pState = "无效号码";
				else
					pState = "重复号码";
				map.put("phone_state", pState);
				map.put("chexing", rs.getString("chexing"));
				map.put("remarks", rs.getString("remarks")==null?"":rs.getString("remarks"));
				map.put("is_key_cus", ("0").equals( rs.getString("is_key_cus"))?"普通客户":"重点客户");
				map.put("cus_intention",rs.getString("cus_intention"));
				result.add(map);
				id++;
			}

		} catch (Exception e) {
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
		return result;
	}
	public List<HashMap<String, Object>> listApply(int start,int rows,String carId,int chexiId,int prov,int city,String beginDate,String endDate,String name,String phone,String rvman,int type, int typex,String brands,String is_key_cus,String visit_type,String beginOrderDate,String endOrderDate,String cus_intention){
		HashMap<String, Object> map = null;
		DBConnect dbc = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String brandStr="";
		if(!"-1".equals(carId)){
			if("-2".equals(carId))
				brandStr = " and t3.iway in ("+brands+")";
			else
				brandStr = " and t3.iway='"+carId+"'";
		}
		String keyCusStr = "";
		if(!"-1".equals(is_key_cus))
			keyCusStr = " and t1.is_key_cus = "+is_key_cus;
		String chexiStr = "";
		if(chexiId > 0)
			chexiStr = " and t3.fatherid="+chexiId;
		String chexingStr ="";
		String provStr = "";
		if(prov > 0)
			provStr = " and (t1.prov = "+prov+" or t1.phone_prov = "+prov+" ) ";
		String cityStr = "";
		if(city > 0)
			cityStr =  " and (t1.city = "+city+" or t1.phone_city = "+city+" ) ";
		String rvmanStr="";
			if(!"-1".equals(rvman))
				rvmanStr=" and t1.return_visit_man='"+rvman+"'";
		String typeStr="";
			if(type>=0)
				typeStr=" and t1.isbuy="+type;
		String typexStr = "";
			if(typex!=-1)
				typexStr = " and t1.type= "+typex;	
		String visit_typeStr  = "";
		if(!"-1".equals(visit_type))
			visit_typeStr  = " and t1.return_visit_state = "+visit_type;
		String revDateStr = "";
		if(!("".equals(beginOrderDate)&&"".equals(endOrderDate)))
		{
			if("".equals(beginOrderDate))
				beginOrderDate = "1970-1-1";
			if("".equals(endOrderDate))
				endOrderDate = "2100-1-1";
			revDateStr  = " and (t1.return_visit_time between '"+beginOrderDate+" 00:00:00' and '"+endOrderDate+" 23:59:59' ) ";
		}
		String cus_intentionStr = "";
		if(!"-1".equals(cus_intention))
			cus_intentionStr = " and t1.cus_intention = "+cus_intention+" ";
		String sql1 = "select  t1.cus_intention,t1.type,t1.remarks,  t1.name,t1.appdate, t3.iway 'pingpai',t1.phone,t1.phone_state, t4.catalogname 'chexi'  from tb_apply_info t1   left outer  join dbo_car_catalognew t3 on t1.modelid = t3.catalogid  left outer  join dbo_car_catalognew t4 on t3.fatherid = t4.catalogid    where "
				+ " t1.name like '%"+name+"%' "
				+ " and t1.phone like '%"+phone+"%'"
				+ " and t1.isDelete = 0 "
				+ typexStr
				+ provStr
				+ cityStr
				+ " and t1.appdate between "
				+ "'"+beginDate+"' and "
				+ "'"+endDate+"' "
				+ rvmanStr
				+ typeStr
				+ brandStr
				+ chexiStr
				+ chexingStr
				+ provStr
				+ cityStr
				+ keyCusStr
				+ visit_typeStr
				+ revDateStr
				+ cus_intentionStr
				+ " order by t1.appdate desc limit ?,?";
		String sql2 = "select count(*) count  from tb_apply_info t1    left outer  join dbo_car_catalognew t3 on t1.modelid = t3.catalogid  left outer  join dbo_car_catalognew t4 on t3.fatherid = t4.catalogid    where"
				+ " t1.name like '%"+name+"%' "
				+ " and t1.phone like '%"+phone+"%'"
				+ " and t1.isDelete = 0 "
				+ typexStr
				+ provStr
				+ cityStr
				+ " and t1.appdate between "
				+ "'"+beginDate+"' and "
				+ "'"+endDate+"' "
				+ " and  t1.name like '%"+name+"%' "
				+ rvmanStr
				+ typeStr
				+ provStr
				+ cityStr
				+ brandStr
				+ chexiStr
				+ keyCusStr
				+ visit_typeStr
				+ revDateStr
				+ cus_intentionStr
				+ chexingStr;
		int count = 0;
		try {
			dbc = new DBConnect(sql2);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
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
		try {
			dbc = new DBConnect(sql1);
			dbc.setInt(1, start);
			dbc.setInt(2, rows);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("count", count);
				//map.put("area1", rs.getString("area1")==null?"未知":rs.getString("area1"));
				map.put("name", rs.getString("name"));
				map.put("appdate", rs.getString("appdate"));
				map.put("pingpai", rs.getString("pingpai"));
				map.put("chexi", rs.getString("chexi"));
				map.put("phone", rs.getString("phone"));
				map.put("type", SourceType.getEnum(rs.getString("type")).getType());
				int state = rs.getInt("phone_state");
				String pState = "";
				if(state==0)
					pState = "有效号码";
				else if(state==1)
					pState = "无效号码";
				else
					pState = "重复号码";
				map.put("phone_state", pState);
				//map.put("chexing", rs.getString("chexing"));
				map.put("remarks", rs.getString("remarks")==null?"":rs.getString("remarks"));
				result.add(map);
			}

		} catch (Exception e) {
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
		return result;
	
	}
/*	public List<HashMap<String, Object>> listByLookTime(int carId,String lookTime){
		DBConnect dbc = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String sql = "select  t1.name,t1.phone,t2.catalogname 'brand',t3.catalogname 'chexing',t4.catalogname 'prov',t5.catalogname 'city',t6.area1 from tb_apply_info t1 join dbo_car_catalognew t2 on t1.carid = t2.catalogid join dbo_car_catalognew t3 on t1.modelid = t3.catalogid   join dbo_are_catalog t4 on t1.prov = t4.catalogid join dbo_are_catalog t5 on t1.city = t5.catalogid left outer join dbo_are_mobile t6 on substring(t1.phone,1,7) = t6.mobstart ";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
			}
		} catch (Exception e) {
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
		return result;
	}*/
	public List<HashMap<String, Object>> getRevman(){
		DBConnect dbc = null;
		HashMap<String, Object> map = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String sql = "select DISTINCT(return_visit_man) return_visit_man from tb_apply_info where return_visit_man is not null and return_visit_man !=''";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("return_visit_man", rs.getString("return_visit_man"));
				result.add(map);
			}
		} catch (Exception e) {
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
		return result;
	
	}
	//获取所属成员回访人
	public List<HashMap<String, Object>> getRevman(String level,String sid){
		DBConnect dbc = null;
		HashMap<String, Object> map = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String sql = "";
		if(level.contains("0"))
			sql = "SELECT t2.USER_NAME from car_315.tb_users t1 LEFT JOIN finance.tb_fin_user t2 on t1.userid = t2.USER_CODE where t1.isdelete = 0 and (t1.ulevel  like '%0%' or t1.ulevel  like '%1%' or t1.ulevel  like '%2%' or t1.ulevel  like '%3%' or t1.ulevel  like '%6%')";
		else if(level.contains("2")||level.contains("3")||level.contains("6"))
			sql = "SELECT t2.USER_NAME from car_315.tb_users t1 LEFT JOIN finance.tb_fin_user t2 on t1.userid = t2.USER_CODE where t1.isdelete = 0 and (t1.ulevel  like '%0%'  or t1.ulevel  like '%2%' or t1.ulevel  like '%3%' or t1.ulevel  like '%6%') and t2.ORG_CODE="+sid;
		else if(level.contains("1"))
			sql = "SELECT t2.USER_NAME from car_315.tb_users t1 LEFT JOIN finance.tb_fin_user t2 on t1.userid = t2.USER_CODE where t1.isdelete = 0 and  t1.ulevel  like '%1%' and t2.ORG_CODE="+sid;
		else
			return result;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("return_visit_man", rs.getString("USER_NAME"));
				result.add(map);
			}
		} catch (Exception e) {
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
		return result;
	
	}
	public List<HashMap<String, Object>> getCheXing(int id){
		DBConnect dbc = null;
		HashMap<String, Object> map = null;
		String sql = "select t3.catalogname,t3.lname,t3.catalogid from dbo_car_catalognew t1 join dbo_car_catalognew t2 on t1.catalogid = t2.fatherid  join dbo_car_catalognew t3 on t3.fatherid = t2.catalogid where t3.isdelete = 0 and t1.catalogid ="+id+" order by t2.lname";
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("catalogid", rs.getString("catalogid"));
				map.put("lname", rs.getString("lname"));
				map.put("catalogname", rs.getString("catalogname"));
				result.add(map);
			}
		} catch (Exception e) {
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
		return result;
		
	}
	
	public int tuisong(TbApplyInfo tbapplyinfo){
		int result = 0;
		DBConnect dbc = null;
		String sql ="update tb_apply_info set prov=?,city=? ,tuisong_flag = ? where id =?";
		try {
			dbc = new DBConnect(sql);
			dbc.prepareStatement(sql);
			dbc.setString(1, tbapplyinfo.getProv());
			dbc.setString(2, tbapplyinfo.getCity());
			dbc.setInt(3, 1);//设置推送
			dbc.setInt(4, tbapplyinfo.getId());
			int i = dbc.executeUpdateReturnInt();
			result = i;
		} catch (Exception e) {
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
		return result;
	}
	
	
	public int updateApply(TbApplyInfo tbapplyinfo){
		int result = 0;
		DBConnect dbc = null;
		tbapplyinfo.setCarid(getbrandId(tbapplyinfo.getCarid()));
		tbapplyinfo.setTuisong_flag(0);//保存的时候取消推送
		String sql ="update tb_apply_info set prov=?,city=? ,is_attend=?,look_time=?,isbuy=?,buy_time=?,phone_state=?,order_time=?,order_state=?,return_visit_state=?,return_visit_time=?,return_visit_man=?,return_visit_content=?,again_return_visit=?, carid=?,modelid=? , remarks=?,name=? ,tuisong_flag =?,is_key_cus = ?,cus_intention=? where id=?";
		try {
			dbc = new DBConnect(sql);
			dbc.prepareStatement(sql);
			
			dbc.setInt(22, tbapplyinfo.getId());
			dbc.setInt(15, tbapplyinfo.getCarid());
			dbc.setInt(16, tbapplyinfo.getModelid());
			dbc.setString(17, tbapplyinfo.getRemarks());
			dbc.setString(18, tbapplyinfo.getName());
			dbc.setInt(19, tbapplyinfo.getTuisong_flag());
			dbc.setInt(20, tbapplyinfo.getIs_key_cus());
			dbc.setInt(21, tbapplyinfo.getCus_intention());
			//dbc.setString(18, tbapplyinfo.getRemarks());
			//dbc.setString(4, tbapplyinfo.getName());
			//dbc.setString(5, tbapplyinfo.getPhone());
			//dbc.setInt(6, tbapplyinfo.getSex());
			dbc.setString(1, tbapplyinfo.getProv());
			dbc.setString(2, tbapplyinfo.getCity());
			//dbc.setTimestamp(9, new Timestamp(tbapplyinfo.getAppdate().getTime()));
			//dbc.setInt(10, tbapplyinfo.getType());
			//dbc.setInt(11, tbapplyinfo.getIssendsms());
			//dbc.setInt(12, tbapplyinfo.getLeft_num());
			dbc.setInt(3, tbapplyinfo.getIs_attend());
			dbc.setTimestamp(4, tbapplyinfo.getLook_time()==null? null:new Timestamp(tbapplyinfo.getLook_time().getTime()));
			dbc.setInt(5, tbapplyinfo.getIsbuy());
			dbc.setTimestamp(6, tbapplyinfo.getBuy_time()==null? null:new Timestamp(tbapplyinfo.getBuy_time().getTime()));
			//dbc.setInt(17, tbapplyinfo.getIs_key_cus());
			dbc.setInt(7, tbapplyinfo.getPhone_state());
			dbc.setTimestamp(8, tbapplyinfo.getOrder_time()==null?null:new Timestamp(tbapplyinfo.getOrder_time().getTime()));
			dbc.setInt(9, tbapplyinfo.getOrder_state());
			dbc.setInt(10, tbapplyinfo.getReturn_visit_state());
			dbc.setTimestamp(11, tbapplyinfo.getReturn_visit_time()==null?null:new Timestamp(tbapplyinfo.getReturn_visit_time().getTime()));
			dbc.setString(12, tbapplyinfo.getReturn_visit_man());
			dbc.setString(13, tbapplyinfo.getReturn_visit_content());
			dbc.setInt(14, tbapplyinfo.getAgain_return_visit());
			int i = dbc.executeUpdateReturnInt();
			
			//System.err.println(dbc.toString());
			result = i;
		} catch (Exception e) {
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
		return result;
	}
	public String getCarName(String id){
		DBConnect dbc = null;
		String sql = "select catalogname from dbo_car_catalognew  where catalogid = "+id;
		String catalogname = "";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				catalogname =rs.getString("catalogname");
			}
		} catch (Exception e) {
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
		return catalogname;
	}
	
	int  getbrandId(int id){
		DBConnect dbc = null;
		String sql = "select DISTINCT fatherid from dbo_car_catalognew  where catalogid = "+id;
		int brandid = 0;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				brandid =rs.getInt("fatherid");
				break;
			}
		} catch (Exception e) {
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
		return brandid;
	}
	
	public Map<String, Object> getDetail(int id){
		HashMap<String, Object> map = null;
		DBConnect dbc = null;
		String prov = null;
		String city = null;
		String area ="未知";
		String sql = "select t1.*,t2.prov provx,t2.city cityx,t3.iway,t3.fatherid chexiid from  tb_apply_info t1 left outer  join dbo_car_catalognew t3 on t1.modelid = t3.catalogid left outer join tb_dict_phone t2 on substring(t1.phone,1,7) = t2.phone_num where t1.id="+id;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("id", rs.getInt("id"));
				map.put("carid", rs.getString("carid"));
				map.put("isbuy", rs.getString("isbuy"));
				map.put("modelid", rs.getString("modelid"));
				map.put("name", rs.getString("name"));
				map.put("phone", rs.getString("phone"));
				map.put("prov", rs.getString("prov")==null?"-1":rs.getString("prov"));
				map.put("city", rs.getString("city")==null?"-1":rs.getString("city"));
				map.put("appdate", rs.getString("appdate"));
				map.put("type", SourceType.getEnum(rs.getString("type")).getType());
				map.put("is_attend", rs.getString("is_attend"));
				map.put("look_time", rs.getString("look_time")==null? "":rs.getString("look_time"));
				map.put("buy_time", rs.getString("buy_time")==null? "":rs.getString("buy_time"));
				map.put("phone_state", rs.getString("phone_state"));
				map.put("order_time", rs.getString("order_time")==null? "":rs.getString("order_time"));
				map.put("order_state", rs.getString("order_state"));
				map.put("return_visit_man", rs.getString("return_visit_man"));
				map.put("return_visit_content", rs.getString("return_visit_content")==null?"":rs.getString("return_visit_content"));
				map.put("again_return_visit", rs.getString("again_return_visit"));
				map.put("iway", rs.getString("iway"));
				map.put("carinfo", rs.getString("car_info")==null?"":rs.getString("car_info"));
				String remarks = rs.getString("remarks")==null?"":rs.getString("remarks");
				String remarksNew = "";
				map.put("remarks", remarks);
				List<String> phoneRemark = getRemark(rs.getString("phone"),id);
				for (String str : phoneRemark) {
					remarksNew += str;
				}
				String ip = rs.getString("ip");
				String ipcity = "";
				if(ip!=null&&!"".equals(ip)){
					String re = IpCityUtil.getCity(ip);
					ipcity = re==null?"未知":re;
				}
				map.put("ipcity",ipcity);
				map.put("remarksNew", remarksNew+remarks);
				prov = rs.getString("provx");
				city = rs.getString("cityx");
				if(prov!=null&&city!=null)
					area = prov + " " +city;
				map.put("area1", area);
				map.put("chexiid", rs.getString("chexiid"));
				map.put("tuisong_flag", rs.getInt("tuisong_flag"));
				map.put("is_key_cus", rs.getInt("is_key_cus"));
				map.put("cus_intention", rs.getInt("cus_intention"));
			}
		} catch (Exception e) {
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
		return map;
	}
	
	public List<String> getRemark(String phone,int id){
		DBConnect dbc = null;
		HashMap<String, Object> map = null;
		String sql = "select remarks from tb_apply_info where phone = '"+phone+"' and remarks is not null and id !="+id+" order by return_visit_man desc";
		List<String> result = new ArrayList<String>();
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				result.add(rs.getString("remarks"));
			}
		} catch (Exception e) {
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
		return result;
	}
	
	public List<String> getDoublePhone(){
		DBConnect dbc = null;
		String sql = "select DISTINCT(phone) from tb_apply_info  where phone_state =3";
		List<String> result = new ArrayList<String>();
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				result.add(rs.getString("phone"));
			}
		} catch (Exception e) {
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
		return result;
		
	}
	
	public void UpdateApplyState(String uid,String applyid,String content,int type){
		DBConnect dbc = null;
		String sql ="update tb_apply_info set isDelete=?  where id=?";
		try {
			dbc = new DBConnect(sql);
			dbc.prepareStatement(sql);
			dbc.setInt(1,type);
			dbc.setInt(2, Integer.parseInt(applyid));
			dbc.executeUpdate();
		}catch (Exception e) {
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
		TbApplyDetailDao tbApplyDetailDao = new TbApplyDetailDao();
		TbApplyDetail tbApplyDetail = new TbApplyDetail();
		tbApplyDetail.setApplyid(Integer.parseInt(applyid));
		tbApplyDetail.setRemark(content);
		tbApplyDetail.setType(type);
		tbApplyDetail.setUid(Integer.parseInt(uid));
		tbApplyDetail.setAddtime(new Date());
		try {
			tbApplyDetailDao.save(tbApplyDetail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Map<String, Object>> getBackExcelInfo(GroupExcelEntity groupExcelEntity,int prov,int city,String brands){
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		HashMap<String, Object> map = null;
		DBConnect dbc = null;
		String sql = "SELECT cus_intention,appdate ,`name`,prov,city,phone,t2.fatherid modelid,remarks,is_attend,t2.iway FROM tb_apply_info t1 LEFT OUTER JOIN dbo_car_catalognew t2 on t1.modelid = t2.catalogid  WHERE return_visit_state = 1  and   t1.isDelete = 0 ";
		if(!("-1").equals(groupExcelEntity.getPinpai3())){
			if("-2".equals(groupExcelEntity.getPinpai3()))
				sql =sql + " AND t2.iway in("+brands+")";
			else
				sql =sql + " AND t2.iway= '"+groupExcelEntity.getPinpai3()+"'";
		}
		if(!("-1").equals(groupExcelEntity.getChexi3())){
			sql =sql + " AND t2.fatherid = "+groupExcelEntity.getChexi3();
		}
		if(!("").equals(groupExcelEntity.getKtDate())){
			sql =sql + " AND look_time = '"+groupExcelEntity.getKtDate()+"'";
		}
		/*if((!"".equals(groupExcelEntity.getBmStart()))&&(!"".equals(groupExcelEntity.getBmEnd()))){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date=null;
			try {
				date = sdf.parse(groupExcelEntity.getBmEnd());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Calendar calendar = new GregorianCalendar(); 
		    calendar.setTime(date); 
			calendar.add(calendar.DATE,1);
			date=calendar.getTime();
			String endDate = sdf.format(date);
			sql =sql + " AND appdate BETWEEN '"+groupExcelEntity.getBmStart()+"' AND '"+endDate+"'";
		}*/
		if(!("-1").equals(groupExcelEntity.getType())){
			sql =sql + " AND type ="+groupExcelEntity.getType();
		}
		if(prov!=-1)
			sql = sql + " AND prov ="+prov;
		if(city!=-1)
			sql = sql + " AND city ="+city;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("appdate", rs.getString("appdate"));
				map.put("name", rs.getString("name"));
				map.put("prov", rs.getString("prov"));
				map.put("city", rs.getString("city"));
				map.put("phone", rs.getString("phone"));
				map.put("modelid", rs.getString("modelid"));
				map.put("remarks", rs.getString("remarks"));
				map.put("is_attend", rs.getString("is_attend"));
				map.put("iway", rs.getString("iway")==null?"":rs.getString("iway"));
				map.put("cus_intention",Cusintention.getEnum(rs.getString("cus_intention")).getType());
				result.add(map);
			}
			
		} catch (Exception e) {
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
		return result;
	}
	public List<String> getChartData(String time){
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 24; i++) {
			list.add(getChartCount(time,i));
		}
		return list;
	}
	
	 String getChartCount(String time,int i){
		String count = "0";
		DBConnect dbc = null;
		String sql = "SELECT count(*) count from tb_apply_info WHERE appdate BETWEEN '"+time+" "+i+":00:00' and '"+time+" "+i+":59:59' and isDelete = 0";
		List<String> result = new ArrayList<String>();
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				count= rs.getString("count");
			}
		} catch (Exception e) {
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
		return count;
		
	}
	 //根据手机归属地获取报名人数（某个地区）
	public int getDailyCount(int prov,String date){
		int count = 0;
		DBConnect dbc = null;
		String sql = "SELECT count( DISTINCT phone) count from tb_apply_info where isDelete  = 0 ";
		if(prov!=-1)
			sql += " and phone_prov = "+prov;
		if(!"".equals(date))
			sql += " and appdate   BETWEEN '"+date+" 00:00:00' and '"+date+" 23:59:59'";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				count= rs.getInt("count");
			}
		} catch (Exception e) {
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
		return count;
		
	}
	
	public List<Map<String, String>> getDayCount(int prov,String beginDate,String endDate){
		List<Map<String, String>> result = new ArrayList<Map<String,String>>();
		Map<String, String> map = null;
		int count = 0;
		DBConnect dbc = null;
		String sql = "SELECT count(DISTINCT phone) count ,substring(appdate,1,10) date  from tb_apply_info where isDelete  = 0 ";
		if(prov!=-1)
			sql += " and phone_prov = "+prov;
		if(!"".equals(beginDate)&&!"".equals(endDate))
			sql += " and appdate   BETWEEN '"+beginDate+" 00:00:00' and '"+endDate+" 23:59:59'";
		sql+=" GROUP BY substring(appdate,1,10)  ";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("date", rs.getString("date"));
				map.put("count", rs.getString("count"));
				result.add(map);
			}
		} catch (Exception e) {
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
		return result;
	}
	public List<Map<String, String>> getTypeCount(String startTime,String endTime){
		Map<String, String> map = new HashMap<String, String>();
		DBConnect dbc = null;
		int total = 0;
		String sql = "SELECT type, count(DISTINCT phone) count   from tb_apply_info where isDelete = 0 and appdate BETWEEN "
				+ "'"+startTime+" 00:00:00' and "
				+ "'"+endTime+" 23:59:59' GROUP BY type order by type";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map.put(rs.getString("type"),rs.getString("count"));
				total += Integer.parseInt(rs.getString("count"));
			}
		} catch (Exception e) {
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
		List<Map<String, String>> result = new ArrayList<Map<String,String>>();
		List<String> keyList = new ArrayList<String>();
		Set<String> keys = map.keySet();
		for (String key : keys) {
			keyList.add(key);
		} 
		List<String> types =Arrays.asList("0","3","1","2","9","11","4","5","6","7","8","10","12","13","14","15","16","17");
		for (String type : types) {
			Map<String, String> temp = new HashMap<String, String>();
			if(keyList.contains(type)){
					temp.put("count", map.get(type));
					temp.put("persent", getPercent(Integer.parseInt(map.get(type)),total));
					
				}
			else{
						temp.put("count", "0");
						temp.put("persent", "0.00%");
				}
			temp.put("type", SourceType.getEnum(type).getType());
			
			result.add(temp);
		}
		return result;

	}
	
	public List<HashMap<String, Object>> getAttendInfo(String carId,String brands,int chexiId,int prov,int city,int typex,int attType,String lookTime,String msgType){
		HashMap<String, Object> map = null;
		DBConnect dbc = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String brandStr  = "";
		if(!"-1".equals(carId)){
			if("-2".equals(carId))
				brandStr = " and t3.iway in ("+brands+")";
			else
				brandStr = " and t3.iway = '"+carId+"'";
		}
		String msgStr = "";
		if("1".equals(msgType))
			msgStr = " and (isSendSms = 0 or isSendSms =1)";
		else
			msgStr = " and isSendSms = "+msgType;
		String typexStr = "";
		if(typex>0)
			typexStr= " and type ="+typex;
		String attStr = "";
		if(attType > 0)
			attStr = " and is_attend ="+attType;
		else
			attStr = " and is_attend in (1,2,3,4)";
		String chexiStr = "";
		if(chexiId > 0)
			chexiStr = " and t3.fatherid = "+chexiId;
		String provStr = "";
		if(prov > 0)
			provStr = " and t1.prov = "+prov+" ";
		String cityStr = "";
		if(city > 0)
			cityStr = " and t1.city = "+city+" ";
		String sql1 = "SELECT  t1.isSendSms, t1.id,t1.`name`,t1.phone,t1.appdate,t1.look_time,t1.is_attend,t1.remarks,t2.catalogname 'brand',t4.catalogname 'chexi' from tb_apply_info t1 LEFT OUTER JOIN dbo_car_catalognew t2 on t1.carid = t2.catalogid LEFT OUTER JOIN dbo_car_catalognew t3 on t1.modelid = t3.catalogid LEFT OUTER JOIN dbo_car_catalognew t4 on t3.fatherid = t4.catalogid where (1=1) "
					+ typexStr
					+ attStr
					+ " and look_time = '"+lookTime+"' "
					+ brandStr
					+ chexiStr
					+ provStr
					+ cityStr
					+ msgStr
					+ " and t1.isDelete = 0 ";
		try {
			dbc = new DBConnect(sql1);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("id", rs.getString("id"));
				map.put("name", rs.getString("name"));
				map.put("phone", rs.getString("phone").trim());
				//map.put("phone", "18652499337");
				map.put("appdate", rs.getString("appdate"));
				map.put("look_time", rs.getString("look_time"));
				map.put("is_attend", AttendType.getEnum(rs.getInt("is_attend")).getType());
				map.put("remarks", rs.getString("remarks"));
				map.put("brand", rs.getString("brand"));
				map.put("chexi", rs.getString("chexi"));
				int msg  =  rs.getInt("isSendSms");
				String isSendSms ="未发送短信";
				if(msg==2)
					isSendSms = "已发送短信";
				map.put("isSendSms",isSendSms);
				result.add(map);
			}

		} catch (Exception e) {
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
		return result;
	
	}
	public int updateMsgState(String id){
		int flag = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql ="update tb_apply_info set isSendSms=2  where id=?";
		try {
			dbc = new DBConnect(sql);
			dbc.prepareStatement(sql);
			//dbc.setInt(1,Integer.parseInt(msgType));
			dbc.setInt(1, Integer.parseInt(id));
			flag  = dbc.executeUpdateReturnInt();
		}catch (Exception e) {
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
		return flag;
	}
	String getPercent(int x,int total){  
		   String result="";//接受百分比的值  
		   double x_double=x*1.0;  
		   double tempresult=x_double/total*1.0;  
		   //NumberFormat nf   =   NumberFormat.getPercentInstance();     注释掉的也是一种方法  
		   //nf.setMinimumFractionDigits( 2 );        保留到小数点后几位  
		   DecimalFormat df1 = new DecimalFormat("0.00%");    //##.00%   百分比格式，后面不足2位的用0补齐  
		   //result=nf.format(tempresult);     
		   result= df1.format(tempresult);    
		   return result;  
		}  
	public int getRevCount(String bgtime,String edtime,String rvman){
		int count = 0;
		DBConnect dbc = null;
		String sql  = "SELECT count(*) count from tb_apply_info where return_visit_man = '"+rvman+"'  and return_visit_time BETWEEN '"+bgtime+"' and '"+edtime+"'";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				count= rs.getInt("count");
			}
		} catch (Exception e) {
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
		return count;
	}
	public int getsiteCount(String bgtime,String edtime,String prov,String city,int state,String sid){
		int count = 0;
		DBConnect dbc = null;
		String cityStr = "";
		if(!"-1".equals(city)){
			cityStr = " and (city = "+city+" or phone_city = "+city+")";
		}
		if("4".equals(sid))
				cityStr = " and ( city<>174 and city<>163 and  phone_city<>174 and phone_city<>163)";
		if("7".equals(sid))
				cityStr = " and ( city<>107 and phone_city<>107 )";
			
		String sql  = "SELECT count(*) count from tb_apply_info where isDelete = 0 "
				+ " and appdate BETWEEN '"+bgtime+"' and '"+edtime+"' "
				+ " and ((prov = "+prov+" or phone_prov = "+prov+")) "
				+  cityStr
				+ " and return_visit_state= "+state;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				count= rs.getInt("count");
			}
		} catch (Exception e) {
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
		return count;
	}
	public int getbrandCount(String bgtime,String edtime,String prov,String city,String iway,int state){
		int count = 0;
		DBConnect dbc = null;
		String provStr = "";
		if(!"-1".equals(prov)){
			provStr = " and ((prov = "+prov+" or phone_prov = "+prov+")) ";
		}
		String cityStr = "";
		if(!"-1".equals(city)){
			cityStr = " and (city = "+city+" or phone_city = "+city+")";
		}	
		String sql  = "SELECT count(*) count from tb_apply_info t1 LEFT OUTER JOIN dbo_car_catalognew t2 on t1.modelid = t2.catalogid where t1.isDelete = 0 "
				+ " and t1.appdate BETWEEN '"+bgtime+"' and '"+edtime+"' "
				+ provStr
				+ cityStr
				+ " and t1.return_visit_state= "+state
				+ " and t2.iway = '"+iway+"'";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				count= rs.getInt("count");
			}
		} catch (Exception e) {
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
		return count;
	}
	public int getsiteCountForAdm(String bgtime,String edtime,String prov,String city,int state,int sid){
		int count = 0;
		DBConnect dbc = null;
		String cityStr = "";
		if(!"-1".equals(city)){
			cityStr = " and (city = "+city+" or phone_city = "+city+")";
		}
		if(sid == 4)
				cityStr = " and ( city<>174 and city<>163 and  phone_city<>174 and phone_city<>163)";
		if(sid == 7)
				cityStr = " and ( city<>107 and phone_city<>107 )";
			
		String sql  = "SELECT count(*) count from tb_apply_info where isDelete = 0 "
				+ " and appdate BETWEEN '"+bgtime+"' and '"+edtime+"' "
				+ " and ((prov = "+prov+" or phone_prov = "+prov+")) "
				+  cityStr
				+ " and return_visit_state= "+state;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				count= rs.getInt("count");
			}
		} catch (Exception e) {
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
		return count;
	}
	public int addGroupBuy(TbApplyInfo tbApplyInfo) throws Exception{

		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_apply_info(`carid`,`modelid`,`name`,`phone`,`prov`,`city`,`appdate`,`type`,`issendsms`) values(?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect(sql);
		dbc.setInt(1,tbApplyInfo.getCarid());
		dbc.setInt(2,tbApplyInfo.getModelid());
		dbc.setString(3,tbApplyInfo.getName());
		dbc.setString(4,tbApplyInfo.getPhone());
		dbc.setString(5,tbApplyInfo.getProv());
		dbc.setString(6,tbApplyInfo.getCity());
		dbc.setTimestamp(7, new Timestamp(tbApplyInfo.getAppdate().getTime()));
		dbc.setInt(8,tbApplyInfo.getType());
		dbc.setInt(9,tbApplyInfo.getIssendsms());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	
	}
	
	public List<HashMap<String, String>> getBrandsChart(String startTime,String endTime,String prov,String city){
		List<HashMap<String, String>> result = new ArrayList<HashMap<String,String>>();
		HashMap<String, String> map = null;
		DBConnect dbc = null;
		String provStr = "";
		if(!"-1".equals(prov))
			provStr = " and ( t1.prov = "+prov+" or t1.phone_prov="+prov+") ";
		String cityStr = "";
		if(!"-1".equals(city))
			provStr = " and ( t1.city = "+city+" or t1.phone_city="+city+") ";
		String sql = "SELECT tb.iway,count(tb.iway) count from (select t2.iway ,phone from tb_apply_info t1 LEFT OUTER JOIN dbo_car_catalognew t2 on t1.modelid  = t2.catalogid  where t1.appdate BETWEEN "
				+ "'"+startTime+"' and '"+endTime+"' and t1.isDelete = 0 "
				+ provStr
				+ cityStr
				+ " ) tb GROUP BY tb.iway ORDER BY count(tb.iway) desc";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				if( rs.getString("iway")==null)
					continue;
				map.put("iway", rs.getString("iway"));
				map.put("count", rs.getString("count"));
				result.add(map);
			}
			
		} catch (Exception e) {
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
		return result;
	
	}
}
