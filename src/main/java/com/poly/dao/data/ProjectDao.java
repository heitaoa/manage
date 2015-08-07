package com.poly.dao.data;

import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.jcraft.jsch.Session;
import com.poly.dao.subDaos.BaomingSubDao;

import car_beans.TbDataProject;
import car_daos.DBConnect;
import car_daos.TbDataProjectDao;

public class ProjectDao extends TbDataProjectDao {

	public List<Map<String, String>> findProductInfoById(String id) {
		DBConnect dbc = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		StringBuffer sql = new StringBuffer();
		sql.append("select t1.*,t2.catalogname brand_name ,t3.catalogname car_name,t6.catalogname model_name,");
		sql.append("	   t4.USER_NAME promo_man_name,t5.USER_NAME custom_service_name,							");
		sql.append("	   t7.catalogname prov_name,t8.catalogname city_name							");
		sql.append("  from car_315.tb_data_project t1 																			 ");
		sql.append("  left join  car_315.dbo_car_catalognew t2 								 ");
		sql.append(" 	on t1.brand = t2.catalogid 											  						 ");
		sql.append("  left join car_315.dbo_car_catalognew t3														 ");
		sql.append("	on t1.car = t3.catalogid																	 ");
		sql.append("  left join finance.tb_fin_user t4																								 ");
		sql.append("    on t1.promo_man = t4.USER_CODE																				 ");
		sql.append("  left join finance.tb_fin_user t5																				 ");
		sql.append("    on t1.custom_service = t5.USER_CODE 																				 ");
		sql.append("  left join car_315.dbo_car_catalognew t6																				 ");
		sql.append("    on t1.model = t6.catalogid 																				 ");
		sql.append("  left join car_315.dbo_are_catalog t7																			 ");
		sql.append("    on t1.promo_prov = t7.catalogid 																				 ");
		sql.append("  left join car_315.dbo_are_catalog t8																			 ");
		sql.append("    on t1.promo_city = t8.catalogid 																				 ");
		sql.append("    where t1.ini_man=?																				 ");
		try {
			dbc = new DBConnect(sql.toString());
			dbc.setString(1, id);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				Map<String,String> info = new HashMap<String,String>();
				info.put("pro_num", rs.getString("pro_num"));
				info.put("ini_man", rs.getString("ini_man"));
				info.put("ini_dept", rs.getString("ini_dept"));
				info.put("ini_org", rs.getString("ini_org"));
				info.put("ini_date", sdf.format(rs.getTimestamp("ini_date")));
				info.put("service_type", rs.getInt("service_type")+"");
				info.put("contact_num", rs.getString("contact_num"));
				info.put("acti_name", rs.getString("acti_name"));
				info.put("brand", rs.getInt("brand")+"");
				info.put("car",rs.getInt("car")+"");
				info.put("model",rs.getInt("model")+"");
				String prov_name = rs.getString("prov_name");
				String city_name = rs.getString("city_name");
				int promo_prov = rs.getInt("promo_prov");
				int promo_city = rs.getInt("promo_city");
				prov_name=prov_name == null?"":prov_name;
				city_name=city_name == null?"":city_name;
				if(promo_prov==-1){
					prov_name = "全国";
				}
				info.put("promo_prov", promo_prov+"");
				info.put("promo_city", promo_city+"");
				info.put("promo_area", prov_name+city_name);
				info.put("promo_start_date", sdf.format(rs.getTimestamp("promo_start_date")));
				info.put("promo_end_date", sdf.format(rs.getTimestamp("promo_end_date")));
				info.put("contact_start_date", sdf.format(rs.getTimestamp("contact_start_date")));
				info.put("contact_end_date", sdf.format(rs.getTimestamp("contact_end_date")));
				info.put("acti_exec_date", sdf.format(rs.getTimestamp("acti_exec_date")));
				info.put("cust_name", rs.getString("cust_name"));
				info.put("tar_clue_num", rs.getInt("tar_clue_num")+"");
				info.put("tar_reach_num", rs.getInt("tar_reach_num")+"");
				info.put("tar_trans_num", rs.getInt("tar_trans_num")+"");
				info.put("custom_service", rs.getString("custom_service"));
				info.put("pro_state", rs.getInt("pro_state")+"");
				info.put("car_name", rs.getString("car_name"));
				info.put("brand_name", rs.getString("brand_name"));
				info.put("model_name", rs.getString("model_name"));
				info.put("custom_service_name", rs.getString("custom_service_name"));
				info.put("promo_man_name", rs.getString("promo_man_name"));
				result.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public List<Map<String, String>> findProductInfoByUseridAndState(String id,int state) {
		DBConnect dbc = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		StringBuffer sql = new StringBuffer();
		sql.append("select t1.*,t2.catalogname brand_name ,t3.catalogname car_name,t6.catalogname model_name,						");
		sql.append("	   t4.USER_NAME promo_man_name,t1.iway,							");
		sql.append("	   t7.catalogname prov_name,t8.catalogname city_name, count(distinct(t13.record_id)) as visit_count			");
		sql.append("  from car_315.tb_data_project t1 																			 	");
		sql.append("  left join  car_315.dbo_car_catalognew t2 								 ");
		sql.append(" 	on t1.brand = t2.catalogid 											  						 ");
		sql.append("  left join car_315.dbo_car_catalognew t3														 ");
		sql.append("	on t1.car = t3.catalogid																	 ");
		sql.append("  left join finance.tb_fin_user t4																								 ");
		sql.append("    on t1.promo_man = t4.USER_CODE																				 ");
		sql.append("  left join car_315.dbo_car_catalognew t6																				 ");
		sql.append("    on t1.model = t6.catalogid 																				 ");
		sql.append("  left join car_315.dbo_are_catalog t7																			 ");
		sql.append("    on t1.promo_prov = t7.catalogid 																				 ");
		sql.append("  left join car_315.dbo_are_catalog t8																			 ");
		sql.append("    on t1.promo_city = t8.catalogid 																				 ");
		sql.append("  left join car_315.tb_data_visit_record t13 on t1.pro_num=t13.pro_num and t13.is_invite=1 and t13.attend_type in(1,2,3,4)    				");
		sql.append("    where t1.ini_man=?																				 ");
		//1--审核中，2--进行中，3--已结束
		if(state==1){
			sql.append("  and t1.pro_state in(0,1,2,4)																				 ");
		}
		else if(state==2){
			sql.append("  and t1.pro_state=3																			 ");
		}else if(state==3){
			sql.append("  and t1.pro_state=5																			 ");
		}	
		sql.append(" group by t1.pro_num desc  																				");
		try {
			System.out.println(sql.toString());
			dbc = new DBConnect(sql.toString());
			dbc.setString(1, id);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				Map<String,String> info = new HashMap<String,String>();
				info.put("pro_num", rs.getString("pro_num"));
				info.put("ini_man", rs.getString("ini_man"));
				info.put("ini_dept", rs.getString("ini_dept"));
				info.put("ini_org", rs.getString("ini_org"));
				Date ini_date = rs.getDate("ini_date");
				String ini_date_str = ini_date==null?"":sdf.format(ini_date);
				info.put("ini_date", ini_date_str);
				info.put("service_type", rs.getInt("service_type")+"");
				info.put("contact_num", rs.getString("contact_num"));
				info.put("acti_name", rs.getString("acti_name"));
				int brand = rs.getInt("brand");
				info.put("brand", brand+"");
				int car = rs.getInt("car");
				info.put("car",car+"");
				int model = rs.getInt("model");
				info.put("model",model+"");
				String prov_name = rs.getString("prov_name");
				String city_name = rs.getString("city_name");
				int promo_prov = rs.getInt("promo_prov");
				int promo_city = rs.getInt("promo_city");
				prov_name=prov_name == null?"":prov_name;
				city_name=city_name == null?"":city_name;
				if(promo_prov==-1){
					prov_name = "全国";
				}
				info.put("promo_prov", promo_prov+"");
				info.put("promo_city", promo_city+"");
				info.put("promo_area", prov_name+city_name);
				Date promo_start_date = rs.getDate("promo_start_date");
				String promo_start_date_str = promo_start_date==null?"":sdf.format(promo_start_date);
				info.put("promo_start_date", promo_start_date_str);
				Date promo_end_date = rs.getDate("promo_end_date");
				String promo_end_date_str = promo_end_date==null?"":sdf.format(promo_end_date);
				info.put("promo_end_date", promo_end_date_str);
				info.put("contact_start_date", sdf.format(rs.getDate("contact_start_date")));
				info.put("contact_end_date", sdf.format(rs.getDate("contact_end_date")));
				info.put("acti_start_date", sdf.format(rs.getDate("acti_start_date")));
				info.put("acti_end_date", sdf.format(rs.getDate("acti_end_date")));
				info.put("cust_name", rs.getString("cust_name"));
				info.put("tar_clue_num", rs.getInt("tar_clue_num")+"");
				info.put("tar_reach_num", rs.getInt("tar_reach_num")+"");
				info.put("tar_trans_num", rs.getInt("tar_trans_num")+"");
				info.put("custom_service", rs.getString("custom_service"));
				info.put("pro_state", rs.getInt("pro_state")+"");
				String brand_name = rs.getString("brand_name");
				String iway = rs.getString("iway")==null?"":rs.getString("iway");
				String car_name = rs.getString("car_name");
				String model_name = rs.getString("model_name");
				info.put("car_name", car_name);
				info.put("iway", iway);
				info.put("brand_name", brand_name);
				info.put("model_name", model_name);
				String brand_car_model="";
				brand_car_model += iway;//品牌改为渠道
				if(StringUtils.isNotEmpty(car_name)){
					brand_car_model += "/"+car_name;
				}
				if(StringUtils.isNotEmpty(model_name)){
					brand_car_model += "/"+model_name;
				}
				info.put("brand_car_model",brand_car_model);
				info.put("custom_service_name", rs.getString("custom_service_name"));
				info.put("promo_man_name", rs.getString("promo_man_name"));
				info.put("competing_name", rs.getString("competing_name"));
				String data_source_name = rs.getString("data_source_name");
				if(StringUtils.isNotEmpty(data_source_name)){
					data_source_name = data_source_name.replaceAll(",", "</br>");
				}
				info.put("data_source_name",data_source_name);
				info.put("visit_count",rs.getInt("visit_count")+"");
				int baoming_count = 0;
				if(state!=1){
					BaomingSubDao baomingSubDao = new BaomingSubDao();
					String competing = rs.getString("competing");
					baoming_count = baomingSubDao.queryJinpinCount(competing,promo_start_date_str,promo_end_date_str,promo_prov,promo_city,brand,car,model,iway);
				}
				info.put("baoming_count",baoming_count+"");
				result.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public List<Map<String, String>> findProductBlInfoByUseridAndState(String id,int state) {
		DBConnect dbc = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		StringBuffer sql = new StringBuffer();
		sql.append("select t1.*,t2.catalogname brand_name ,t3.catalogname car_name,t6.catalogname model_name,");
		sql.append("	   t4.USER_NAME promo_man_name,	t1.iway,						");
		sql.append("	   t7.catalogname prov_name,t8.catalogname city_name							");
		sql.append("  from car_315.tb_data_project_bl t1 																			 ");
		sql.append("  left join  car_315.dbo_car_catalognew t2 								 ");
		sql.append(" 	on t1.brand = t2.catalogid 											  						 ");
		sql.append("  left join car_315.dbo_car_catalognew t3														 ");
		sql.append("	on t1.car = t3.catalogid																	 ");
		sql.append("  left join finance.tb_fin_user t4																								 ");
		sql.append("    on t1.promo_man = t4.USER_CODE																				 ");
		sql.append("  left join car_315.dbo_car_catalognew t6																				 ");
		sql.append("    on t1.model = t6.catalogid 																				 ");
		sql.append("  left join car_315.dbo_are_catalog t7																			 ");
		sql.append("    on t1.promo_prov = t7.catalogid 																				 ");
		sql.append("  left join car_315.dbo_are_catalog t8																			 ");
		sql.append("    on t1.promo_city = t8.catalogid 																				 ");
		sql.append("    where t1.ini_man=?																				 ");
		//1--审核中，2--进行中，3--已结束
		if(state==1){
			sql.append("  and t1.pro_state in(0,1,2,4)																				 ");
		}
		else if(state==2){
			sql.append("  and t1.pro_state=3																			 ");
		}else if(state==3){
			sql.append("  and t1.pro_state=5																			 ");
		}
		try {
			dbc = new DBConnect(sql.toString());
			dbc.setString(1, id);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				Map<String,String> info = new HashMap<String,String>();
				info.put("pro_num", rs.getString("pro_num"));
				info.put("ini_man", rs.getString("ini_man"));
				info.put("ini_dept", rs.getString("ini_dept"));
				info.put("ini_org", rs.getString("ini_org"));
				info.put("ini_date", sdf.format(rs.getDate("ini_date")));
				info.put("service_type", rs.getInt("service_type")+"");
				info.put("contact_num", rs.getString("contact_num"));
				info.put("acti_name", rs.getString("acti_name"));
				info.put("brand", rs.getInt("brand")+"");
				info.put("car",rs.getInt("car")+"");
				info.put("model",rs.getInt("model")+"");
				String prov_name = rs.getString("prov_name");
				String city_name = rs.getString("city_name");
				int promo_prov = rs.getInt("promo_prov");
				int promo_city = rs.getInt("promo_city");
				prov_name=prov_name == null?"":prov_name;
				city_name=city_name == null?"":city_name;
				if(promo_prov==-1){
					prov_name = "全国";
				}
				info.put("promo_prov", promo_prov+"");
				info.put("promo_city", promo_city+"");
				info.put("promo_area", prov_name+city_name);
				info.put("promo_start_date", sdf.format(rs.getDate("promo_start_date")));
				info.put("promo_end_date", sdf.format(rs.getDate("promo_end_date")));
				info.put("contact_start_date", sdf.format(rs.getDate("contact_start_date")));
				info.put("contact_end_date", sdf.format(rs.getDate("contact_end_date")));
				info.put("acti_start_date", sdf.format(rs.getDate("acti_start_date")));
				info.put("acti_end_date", sdf.format(rs.getDate("acti_end_date")));
				info.put("cust_name", rs.getString("cust_name"));
				info.put("tar_clue_num", rs.getInt("tar_clue_num")+"");
				info.put("tar_reach_num", rs.getInt("tar_reach_num")+"");
				info.put("tar_trans_num", rs.getInt("tar_trans_num")+"");
				info.put("custom_service", rs.getString("custom_service"));
				info.put("pro_state", rs.getInt("pro_state")+"");
				String brand_name = rs.getString("brand_name");
				String iway = rs.getString("iway")==null?"":rs.getString("iway");
				String car_name = rs.getString("car_name");
				String model_name = rs.getString("model_name");
				info.put("car_name", car_name);
				info.put("brand_name", brand_name);
				info.put("iway", iway);
				info.put("model_name", model_name);
				String brand_car_model="";
				brand_car_model += iway;//品牌改为渠道
				if(StringUtils.isNotEmpty(car_name)){
					brand_car_model += "/"+car_name;
				}
				if(StringUtils.isNotEmpty(model_name)){
					brand_car_model += "/"+model_name;
				}
				info.put("brand_car_model",brand_car_model);
				info.put("custom_service_name", rs.getString("custom_service_name"));
				info.put("promo_man_name", rs.getString("promo_man_name"));
				info.put("competing_name", rs.getString("competing_name"));
				String data_source_name = rs.getString("data_source_name");
				if(StringUtils.isNotEmpty(data_source_name)){
					data_source_name = data_source_name.replaceAll(",", "</br>");
				}
				info.put("data_source_name",data_source_name);
				result.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public Map<String, String> findOrgAndDepById(String id) {
		Map<String,String> result=null;
		String sql = "select t1.DEPT_CODE,t2.DEP_NAME, t1.ORG_CODE,t3.ORG_NAME, t3.ORG_COMMENT, t4.catalogname "
					+ "from finance .tb_fin_user t1,finance .tb_fin_dep t2,finance .tb_fin_org t3, car_315.dbo_are_catalog t4  "
					+ "where t1.ORG_CODE = t3.ORG_ID and t1.DEPT_CODE = t2.DEP_ID and t1.USER_CODE=?";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			dbc.setString(1, id);
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				String dept_code = rs.getString("DEPT_CODE");
				String dep_name = rs.getString("DEP_NAME");
				String org_code = rs.getString("ORG_CODE");
				String org_name = rs.getString("ORG_NAME");
				String org_comment = rs.getString("ORG_COMMENT");
				String city_name = rs.getString("catalogname");
				result = new HashMap<String,String>();
				result.put("dep_code", dept_code);
				result.put("dep_name", dep_name);
				result.put("org_code", org_code);
				result.put("org_name", org_name);
				result.put("org_comment", org_comment);
				result.put("city_name", city_name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return result;   
	}

	public List<Map<String, String>> findUsersByCode(String orgCode,String deptCode,String userCode) {
		List<Map<String, String>> users = new ArrayList<Map<String,String>>();
		String sql="select t1.USER_CODE, t1.USER_NAME from finance .tb_fin_user t1,finance .tb_fin_dep t2,finance .tb_fin_org t3 where t1.ISONJOB = '0' and t1.ORG_CODE = t3.ORG_ID and t1.DEPT_CODE = t2.DEP_ID ";
		if(orgCode!=null){
			sql += " and t3.ORG_ID= "+orgCode ;
		}
		if(deptCode!=null){
			sql +=" and t2.DEP_ID = "+deptCode;
		}
		if(userCode!=null){
			sql +=" and t1.USER_CODE = "+userCode;
		}
		DBConnect dbc = null;
		System.out.println(sql);
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				String id = rs.getString("user_code");
				String name = rs.getString("user_name");
				Map<String,String> user = new HashMap<String,String>();
				user.put("id", id);
				user.put("name", name);
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return users;
	}
	public Map<String,String> findProjectInfoByProNum(String pro_num) {
		Map<String,String> info = new HashMap<String,String>();
		DBConnect dbc = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sql = new StringBuffer();
		sql.append("select t1.*,t6.ORG_NAME,t7.DEP_NAME,t8.USER_NAME ini_man_name,t2.catalogname brand_name ,	");
		sql.append("	   t3.catalogname car_name,t9.catalogname model_name,t4.USER_NAME promo_man_name,t1.iway,");
		sql.append("	   t5.USER_NAME custom_service_name,t10.catalogname prov_name,t11.catalogname city_name ");
		sql.append("  from car_315.tb_data_project t1 															");
		sql.append("  left join  car_315.dbo_car_catalognew t2 								 ");
		sql.append(" 	on t1.brand = t2.catalogid 											  						 ");
		sql.append("  left join car_315.dbo_car_catalognew t3														 ");
		sql.append("	on t1.car = t3.catalogid																	 ");
		sql.append("  left join finance.tb_fin_user t4																								 ");
		sql.append("    on t1.promo_man = t4.USER_CODE																				 ");
		sql.append("  left join finance.tb_fin_user t5																				 ");
		sql.append("    on t1.custom_service = t5.USER_CODE 																				 ");
		sql.append("  left join finance.tb_fin_org t6																				 ");
		sql.append("    on t1.ini_org = t6.ORG_ID																				 ");
		sql.append("  left join finance.tb_fin_dep t7																				 ");
		sql.append("    on t1.ini_dept = t7.DEP_ID																				 ");
		sql.append("  left join finance.tb_fin_user t8																				 ");
		sql.append("    on t1.ini_man = t8.USER_CODE 																				 ");
		sql.append("  left join car_315.dbo_car_catalognew t9																			 ");
		sql.append("    on t1.model = t9.catalogid 																				 ");
		sql.append("  left join car_315.dbo_are_catalog t10																			 ");
		sql.append("    on t1.promo_prov = t10.catalogid 																				 ");
		sql.append("  left join car_315.dbo_are_catalog t11																			 ");
		sql.append("    on t1.promo_city = t11.catalogid 																				 ");
		sql.append("    where t1.pro_num=?																				 ");
		try {
			dbc = new DBConnect(sql.toString());
			dbc.setString(1, pro_num);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				info.put("pro_num", rs.getString("pro_num"));
				info.put("ini_man", rs.getString("ini_man"));
				info.put("ini_dept", rs.getString("ini_dept"));
				info.put("ini_org", rs.getString("ini_org"));
				info.put("ini_date", sdf.format(rs.getTimestamp("ini_date")));
				info.put("service_type", rs.getInt("service_type")+"");
				info.put("contact_num", rs.getString("contact_num"));
				info.put("acti_name", rs.getString("acti_name"));
				info.put("brand", rs.getInt("brand")+"");
				info.put("car",rs.getInt("car")+"");
				info.put("model",rs.getInt("model")+"");
				int promo_prov =  rs.getInt("promo_prov");
				String prov_name = rs.getString("prov_name");
				prov_name = prov_name==null?"":prov_name;
				String city_name = rs.getString("city_name");
				city_name = city_name==null?"":city_name;
				String promo_area = "";
				if(promo_prov!=-1){
					promo_area = prov_name+city_name;
				}else{
					promo_area = "全国";
				}
				info.put("promo_area",replaceNull(promo_area));
				info.put("promo_prov",replaceNull(rs.getInt("promo_prov")+""));
				info.put("promo_city",replaceNull(rs.getInt("promo_city")+"" ));
				info.put("promo_start_date", replaceNull(sdf.format(rs.getTimestamp("promo_start_date"))));
				info.put("promo_end_date", replaceNull(sdf.format(rs.getTimestamp("promo_end_date"))));
				info.put("contact_start_date", replaceNull(sdf.format(rs.getTimestamp("contact_start_date"))));
				info.put("contact_end_date",replaceNull( sdf.format(rs.getTimestamp("contact_end_date"))));
				info.put("acti_start_date",replaceNull( sdf.format(rs.getTimestamp("acti_start_date"))));
				info.put("acti_end_date", replaceNull(sdf.format(rs.getTimestamp("acti_end_date"))));
				info.put("cust_name", replaceNull(rs.getString("cust_name")));
				info.put("tar_clue_num", replaceNull(rs.getInt("tar_clue_num")+""));
				info.put("tar_reach_num", replaceNull(rs.getInt("tar_reach_num")+""));
				info.put("tar_trans_num", replaceNull(rs.getInt("tar_trans_num")+""));
				info.put("custom_service", replaceNull(rs.getString("custom_service")));
				info.put("pro_state", replaceNull(rs.getInt("pro_state")+""));
				String brand_name = rs.getString("brand_name");
				String iway = rs.getString("iway")==null?"":rs.getString("iway");
				String car_name = rs.getString("car_name");
				String model_name = rs.getString("model_name");
				info.put("car_name", car_name);
				info.put("brand_name", brand_name);
				info.put("iway", iway);
				info.put("model_name", model_name);
				String brand_car_model="";
				brand_car_model += iway;//品牌改为渠道
				if(StringUtils.isNotEmpty(car_name)){
					brand_car_model += "/"+car_name;
				}
				if(StringUtils.isNotEmpty(model_name)){
					brand_car_model += "/"+model_name;
				}
				info.put("brand_car_model",brand_car_model);
				info.put("custom_service_name", replaceNull(rs.getString("custom_service_name")));
				info.put("promo_man_name", replaceNull(rs.getString("promo_man_name")));
				info.put("org_name", replaceNull(rs.getString("org_name")));
				info.put("dep_name", replaceNull(rs.getString("dep_name")));
				info.put("competing_name", replaceNull(rs.getString("competing_name")));
				info.put("ini_man_name", replaceNull(rs.getString("ini_man_name")));
				info.put("competing", replaceNull(rs.getString("competing")));
				info.put("data_source", replaceNull(rs.getString("data_source")));
				info.put("competing_name", replaceNull(rs.getString("competing_name")));
				info.put("data_source_name", replaceNull(rs.getString("data_source_name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return info;
	}
	private String replaceNull(String arg){
		String str ="";
		if(arg!=null){
			str=arg;
		}
		return str;
	}
	public Map findBlProjectInfoByProNum(String pro_num) {
		Map<String,String> info = new HashMap<String,String>();
		DBConnect dbc = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sql = new StringBuffer();
		sql.append("select t1.*,t6.ORG_NAME,t7.DEP_NAME,t8.USER_NAME ini_man_name,t2.catalogname brand_name ,	");
		sql.append("	   t3.catalogname car_name,t9.catalogname model_name,t4.USER_NAME promo_man_name,t1.iway, ");
		sql.append("	   t5.USER_NAME custom_service_name,t10.catalogname prov_name,t11.catalogname city_name ");
		sql.append("  from car_315.tb_data_project_bl t1 															");
		sql.append("  left join  car_315.dbo_car_catalognew t2 								 ");
		sql.append(" 	on t1.brand = t2.catalogid 											  						 ");
		sql.append("  left join car_315.dbo_car_catalognew t3														 ");
		sql.append("	on t1.car = t3.catalogid																	 ");
		sql.append("  left join finance.tb_fin_user t4																								 ");
		sql.append("    on t1.promo_man = t4.USER_CODE																				 ");
		sql.append("  left join finance.tb_fin_user t5																				 ");
		sql.append("    on t1.custom_service = t5.USER_CODE 																				 ");
		sql.append("  left join finance.tb_fin_org t6																				 ");
		sql.append("    on t1.ini_org = t6.ORG_ID																				 ");
		sql.append("  left join finance.tb_fin_dep t7																				 ");
		sql.append("    on t1.ini_dept = t7.DEP_ID																				 ");
		sql.append("  left join finance.tb_fin_user t8																				 ");
		sql.append("    on t1.ini_man = t8.USER_CODE 																				 ");
		sql.append("  left join car_315.dbo_car_catalognew t9																			 ");
		sql.append("    on t1.model = t9.catalogid 																				 ");
		sql.append("  left join car_315.dbo_are_catalog t10																			 ");
		sql.append("    on t1.promo_prov = t10.catalogid 																				 ");
		sql.append("  left join car_315.dbo_are_catalog t11																			 ");
		sql.append("    on t1.promo_city = t11.catalogid 																				 ");
		sql.append("    where t1.pro_num=?																				 ");
		try {
			dbc = new DBConnect(sql.toString());
			dbc.setString(1, pro_num);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				info.put("pro_num", rs.getString("pro_num"));
				info.put("ini_man", rs.getString("ini_man"));
				info.put("ini_dept", rs.getString("ini_dept"));
				info.put("ini_org", rs.getString("ini_org"));
				info.put("ini_date", sdf.format(rs.getTimestamp("ini_date")));
				info.put("service_type", rs.getInt("service_type")+"");
				info.put("contact_num", rs.getString("contact_num"));
				info.put("acti_name", rs.getString("acti_name"));
				info.put("brand", rs.getInt("brand")+"");
				info.put("car",rs.getInt("car")+"");
				info.put("model",rs.getInt("model")+"");
				int promo_prov =  rs.getInt("promo_prov");
				String prov_name = rs.getString("prov_name");
				prov_name = prov_name==null?"":prov_name;
				String city_name = rs.getString("city_name");
				city_name = city_name==null?"":city_name;
				String promo_area = "";
				if(promo_prov!=-1){
					promo_area = prov_name+city_name;
				}else{
					promo_area = "全国";
				}
				info.put("promo_area",replaceNull(promo_area));
				info.put("promo_prov",replaceNull(rs.getInt("promo_prov")+""));
				info.put("promo_city",replaceNull(rs.getInt("promo_city")+"" ));
				info.put("promo_start_date", replaceNull(sdf.format(rs.getTimestamp("promo_start_date"))));
				info.put("promo_end_date", replaceNull(sdf.format(rs.getTimestamp("promo_end_date"))));
				info.put("contact_start_date", replaceNull(sdf.format(rs.getTimestamp("contact_start_date"))));
				info.put("contact_end_date",replaceNull( sdf.format(rs.getTimestamp("contact_end_date"))));
				info.put("acti_start_date",replaceNull( sdf.format(rs.getTimestamp("acti_start_date"))));
				info.put("acti_end_date", replaceNull(sdf.format(rs.getTimestamp("acti_end_date"))));
				info.put("cust_name", replaceNull(rs.getString("cust_name")));
				info.put("tar_clue_num", replaceNull(rs.getInt("tar_clue_num")+""));
				info.put("tar_reach_num", replaceNull(rs.getInt("tar_reach_num")+""));
				info.put("tar_trans_num", replaceNull(rs.getInt("tar_trans_num")+""));
				info.put("custom_service", replaceNull(rs.getString("custom_service")));
				info.put("pro_state", replaceNull(rs.getInt("pro_state")+""));
				String brand_name = rs.getString("brand_name");
				String iway = rs.getString("iway")==null?"":rs.getString("iway");
				String car_name = rs.getString("car_name");
				String model_name = rs.getString("model_name");
				info.put("car_name", car_name);
				info.put("brand_name", brand_name);
				info.put("iway", iway);
				info.put("model_name", model_name);
				String brand_car_model="";
				brand_car_model += iway;//品牌改为渠道
				if(StringUtils.isNotEmpty(car_name)){
					brand_car_model += "/"+car_name;
				}
				if(StringUtils.isNotEmpty(model_name)){
					brand_car_model += "/"+model_name;
				}
				info.put("brand_car_model",brand_car_model);
				info.put("custom_service_name", replaceNull(rs.getString("custom_service_name")));
				info.put("promo_man_name", replaceNull(rs.getString("promo_man_name")));
				info.put("org_name", replaceNull(rs.getString("org_name")));
				info.put("dep_name", replaceNull(rs.getString("dep_name")));
				info.put("competing_name", replaceNull(rs.getString("competing_name")));
				info.put("ini_man_name", replaceNull(rs.getString("ini_man_name")));
				info.put("competing", replaceNull(rs.getString("competing")));
				info.put("data_source", replaceNull(rs.getString("data_source")));
				info.put("competing_name", replaceNull(rs.getString("competing_name")));
				info.put("data_source_name", replaceNull(rs.getString("data_source_name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return info;
	}
	public Map<String, String> getDeptMap(Map<String, String> map) {
		Map<String, String> deptMap = null;
		
		String sql = "select distinct t1.ini_dept ini_dept, t2.DEP_NAME dept_name "
					+ "from car_315.tb_data_project t1, finance.tb_fin_dep t2 "
					+ "where t1.ini_dept=t2.DEP_ID and t1.pro_state IN(" + map.get("states") + ")";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			deptMap = new HashMap<String,String>();
			while(rs.next()) {
				String deptId = rs.getString("ini_dept");
				String deptName = rs.getString("dept_name");
				deptMap.put(deptId, deptName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return deptMap;
	}

	public Map<String, String> getInimanMap(Map<String, String> map) {
		Map<String, String> inimanMap = null;
		
		String sql = "select distinct t1.ini_man iniman, t2.USER_NAME username "
					+ "from car_315.tb_data_project t1, finance.tb_fin_user t2 "
					+ "where t1.ini_man=t2.USER_CODE and t1.pro_state IN(" + map.get("states") + ")";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			inimanMap = new HashMap<String,String>();
			while(rs.next()) {
				String iniman = rs.getString("iniman");
				String username = rs.getString("username");
				inimanMap.put(iniman, username);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return inimanMap;
	}

	public Map<String, String> getBrandMap(Map<String, String> map) {
		Map<String, String> brandMap = null;
		
//		String sql = "select distinct t1.brand brandid, t2.catalogname brandname "
//					+ "from car_315.tb_data_project t1, car_315.dbo_car_catalognew t2 "
//					+ "where t1.brand=t2.catalogid AND t1.brand IS NOT NULL AND t1.pro_state IN(" + map.get("states") + ")";
		String sql = "SELECT DISTINCT iway FROM tb_data_project WHERE iway IS NOT NULL AND pro_state IN(" + map.get("states") + ")";
		DBConnect dbc = null;
		System.out.println(sql);
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			brandMap = new HashMap<String,String>();
			while(rs.next()) {
				String brandid = rs.getString("iway");
				String brandname = rs.getString("iway");
				brandMap.put(brandid, brandname);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return brandMap;
	}

	public List<String> getAreaList(Map<String, String> map) {
		List<String> areaList = null;
		String sql = "select distinct promo_area from tb_data_project where pro_state IN(" + map.get("states") + ")";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			areaList = new ArrayList<String>();
			while(rs.next()) {
				areaList.add(rs.getString("promo_area"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return areaList;
	}

	public List<Map<String, String>> getProjectsForPromoDirector(Map<String, String> whereMap) {
		
		List<Map<String, String>> resultList = null;
		
		String userid = whereMap.get("userid");
		
		StringBuffer sqlWhere = new StringBuffer();
		if (whereMap.size() > 1) {
			
			if (whereMap.get("pro_num")!=null && whereMap.get("pro_num").length()!=0) sqlWhere.append("t1.pro_num='" + whereMap.get("pro_num") + "' AND ");  //编号
			if (whereMap.get("ini_dept")!=null && whereMap.get("ini_dept").length()!=0) sqlWhere.append("t1.ini_dept='" + whereMap.get("ini_dept") + "' AND ");  //部门
			if (whereMap.get("ini_man")!=null && whereMap.get("ini_man").length()!=0) sqlWhere.append("t1.ini_man='" + whereMap.get("ini_man") + "' AND ");  //发起人
			if (whereMap.get("service_type")!=null && whereMap.get("service_type").length()!=0) sqlWhere.append("t1.service_type=" + whereMap.get("service_type") + " AND ");  //业务类型
			if (whereMap.get("brand")!=null && whereMap.get("brand").length()!=0) sqlWhere.append("t1.iway='" + whereMap.get("brand") + "' AND ");  //品牌
			if (whereMap.get("ini_date")!=null && whereMap.get("ini_date").length()!=0) sqlWhere.append("t1.ini_date like'" + whereMap.get("ini_date") + "%' AND ");  //发起日期
//			if (whereMap.get("promo_area")!=null && whereMap.get("promo_area").length()!=0) sqlWhere.append("t1.promo_area='" + whereMap.get("promo_area") + "' AND ");  //推广区域
			if (whereMap.get("promo_prov")!=null && whereMap.get("promo_prov").length()!=0) sqlWhere.append("t1.promo_prov=" + whereMap.get("promo_prov") + " AND ");  //推广省份
			if (whereMap.get("promo_city")!=null && whereMap.get("promo_city").length()!=0) sqlWhere.append("t1.promo_city=" + whereMap.get("promo_city") + " AND ");  //推广省份
			if (whereMap.get("pro_state")!=null && whereMap.get("pro_state").length()!=0) sqlWhere.append("t1.pro_state=" + whereMap.get("pro_state") + " AND ");  //状态
			if (whereMap.get("pro_finish")!=null && whereMap.get("pro_finish").length()!=0) sqlWhere.append("promo_end_date<NOW() AND pro_state=3 AND ");  //查询已完成项目
		}
		
		int pageNum = Integer.valueOf(whereMap.get("pageNum"));
		int page = Integer.valueOf(whereMap.get("page")) - 1;
		
		sqlWhere.append("pro_state IN("+ whereMap.get("states") +") ");
		sqlWhere.toString();
		
		
		String sql = "select t1.pro_num, t2.DEP_NAME dept_name, t3.USER_NAME ini_man, t1.ini_date, t1.service_type, t1.custom_service, t1.custom_service_name, "
							+ "t1.brand, t1.car, t1.iway, t1.model , t6.catalogname brand_name, t7.catalogname car_name, t12.catalogname model_name, "
							+ "t1.promo_area, t1.promo_prov, t9.catalogname prov_name, t1.promo_city, t10.catalogname city_name, "
							+ "t1.promo_start_date, t1.promo_end_date, t5.USER_NAME promo_man, "
							+ "t1.contact_num, t1.cust_name, t1.contact_start_date, t1.contact_end_date, t1.acti_start_date, t1.acti_end_date, t1.tar_clue_num, "
							+ "t1.tar_reach_num, t1.tar_trans_num, t1.pro_state, t1.baoming_count "
					+ "from car_315.tb_data_project t1 "
							+ "LEFT JOIN finance.tb_fin_dep t2 ON t1.ini_dept=t2.DEP_ID "   //部门
							+ "LEFT JOIN finance.tb_fin_user t3 ON t1.ini_man=t3.USER_CODE  "  //发起人
							+ "LEFT JOIN finance.tb_fin_user t4 ON t1.custom_service=t4.USER_CODE "  //责任客服
							+ "LEFT JOIN finance.tb_fin_user t5 ON t1.promo_man=t5.USER_CODE "  //推广人
							+ "LEFT JOIN car_315.dbo_car_catalognew t6 ON t1.brand=t6.catalogid "  //品牌
							+ "LEFT JOIN car_315.dbo_car_catalognew t7 ON t1.car=t7.catalogid "  //车系
							+ "LEFT JOIN car_315.dbo_car_catalognew t12 ON t1.model=t12.catalogid "  //车系
//							+ "LEFT JOIN finance.tb_fin_user t8 ON t1.ini_org=t8.ORG_CODE "  //部门对应的机构（分站）
							+ "LEFT JOIN car_315.dbo_are_catalog t9 ON t1.promo_prov=t9.catalogid "  //省份
							+ "LEFT JOIN car_315.dbo_are_catalog t10 ON t1.promo_city=t10.catalogid " //城市
					+ "where 1 AND t1.ini_man IS NOT NULL AND " + sqlWhere 
					+ "ORDER BY t1.ini_date DESC "
					+ "LIMIT "+ page*pageNum +","+ pageNum +"";
		
		System.out.println(sql);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			resultList = new ArrayList<Map<String,String>>();
			while(rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				
				map.put("pro_num", rs.getString("pro_num"));  //项目编号
				map.put("dept_name", rs.getString("dept_name"));  //部门名称
				map.put("ini_man", rs.getString("ini_man"));  //发起人
				map.put("ini_date", rs.getString("ini_date"));  //发起日期
				map.put("service_type", String.valueOf(rs.getInt("service_type")));  //业务类型
//				map.put("brand", rs.getInt("brand") + "");  //品牌
				map.put("car", rs.getInt("car") + "");  //车型
				map.put("model", rs.getInt("model") + "");  //车型
//				map.put("brand_name", rs.getString("brand_name"));  //品牌
				map.put("iway", rs.getString("iway"));  //渠道
				map.put("car_name", rs.getString("car_name"));  //车型
				map.put("model_name", rs.getString("model_name"));  //车型
				map.put("promo_area", rs.getString("promo_area"));  //推广区域
				map.put("promo_prov", rs.getInt("promo_prov")+"");  //推广省份
				map.put("promo_city", rs.getInt("promo_city")+"");  //推广城市
				map.put("prov_name", rs.getString("prov_name"));  //省份名
				map.put("city_name", rs.getString("city_name"));  //城市名
				map.put("promo_start_date", rs.getDate("promo_start_date").toString());  //项目开始时间
				map.put("promo_end_date", rs.getDate("promo_end_date").toString());  //项目开始时间
				map.put("custom_service", rs.getString("custom_service"));  //责任客服
				if (rs.getString("promo_man") == null) {
					map.put("promo_man", "");  //责任推广人员
				}else {
					map.put("promo_man", rs.getString("promo_man"));  //责任推广人员
				}
				map.put("pro_state", rs.getString("pro_state"));  //项目状态
				
				//用于在 modal 中显示数据
				map.put("contact_num", rs.getString("contact_num"));
				map.put("cust_name", rs.getString("cust_name"));
				map.put("contact_start_date", rs.getDate("contact_start_date").toString());
				map.put("contact_end_date", rs.getDate("contact_end_date").toString());
				map.put("acti_start_date", rs.getDate("acti_start_date").toString());
				if (rs.getDate("acti_end_date")==null) {
					map.put("acti_end_date", "");
				}else {
					map.put("acti_end_date", rs.getDate("acti_end_date").toString());
				}
				map.put("tar_clue_num", String.valueOf(rs.getInt("tar_clue_num")));
				map.put("tar_reach_num", String.valueOf(rs.getInt("tar_reach_num")));
				map.put("tar_trans_num", String.valueOf(rs.getInt("tar_trans_num")));
				map.put("custom_service_name", rs.getString("custom_service_name"));
				map.put("baoming_count", rs.getInt("baoming_count")+"");
				resultList.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultList;
	}
	public List<Map<String, String>> getProjectsForSerDirector(Map<String, String> whereMap) {
		
		List<Map<String, String>> resultList = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String userid = whereMap.get("userid");
		
		StringBuffer sqlWhere = new StringBuffer();
		if (whereMap.size() > 1) {
			
			if (whereMap.get("pro_num")!=null && whereMap.get("pro_num").length()!=0) sqlWhere.append("t1.pro_num='" + whereMap.get("pro_num") + "' AND ");  //编号
			if (whereMap.get("ini_dept")!=null && whereMap.get("ini_dept").length()!=0) sqlWhere.append("t1.ini_dept='" + whereMap.get("ini_dept") + "' AND ");  //部门
			if (whereMap.get("ini_man")!=null && whereMap.get("ini_man").length()!=0) sqlWhere.append("t1.ini_man='" + whereMap.get("ini_man") + "' AND ");  //发起人
			if (whereMap.get("service_type")!=null && whereMap.get("service_type").length()!=0) sqlWhere.append("t1.service_type=" + whereMap.get("service_type") + " AND ");  //业务类型
			if (whereMap.get("iway")!=null && whereMap.get("iway").length()!=0) sqlWhere.append("t1.iway='" + whereMap.get("iway") + "' AND ");  //品牌
			if (whereMap.get("ini_date")!=null && whereMap.get("ini_date").length()!=0) sqlWhere.append("t1.ini_date like'" + whereMap.get("ini_date") + "%' AND ");  //发起日期
//			if (whereMap.get("promo_area")!=null && whereMap.get("promo_area").length()!=0) sqlWhere.append("t1.promo_area='" + whereMap.get("promo_area") + "' AND ");  //推广区域
			if (whereMap.get("promo_prov")!=null && whereMap.get("promo_prov").length()!=0) sqlWhere.append("t1.promo_prov=" + whereMap.get("promo_prov") + " AND ");  //推广省份
			if (whereMap.get("promo_city")!=null && whereMap.get("promo_city").length()!=0) sqlWhere.append("t1.promo_city=" + whereMap.get("promo_city") + " AND ");  //推广省份
			if (whereMap.get("pro_state")!=null && whereMap.get("pro_state").length()!=0) sqlWhere.append("t1.pro_state=" + whereMap.get("pro_state") + " AND ");  //状态
			if (whereMap.get("pro_finish")!=null && whereMap.get("pro_finish").length()!=0) sqlWhere.append("promo_end_date<NOW() AND pro_state=3 AND ");  //查询已完成项目
		}
		
		int pageNum = Integer.valueOf(whereMap.get("pageNum"));
		int page = Integer.valueOf(whereMap.get("page"))-1;
		page=page==-1?0:page;
		sqlWhere.append("pro_state IN("+ whereMap.get("states") +")  ");
		sqlWhere.toString();
		
		System.out.println(sqlWhere);
		
		String sql = "select t1.pro_num, t2.DEP_NAME dept_name, t3.USER_NAME ini_man, t1.ini_date, t1.service_type, "
				+ "t1.brand, t1.car, t1.model , t6.catalogname brand_name, t7.catalogname car_name, t11.catalogname model_name, "
				+ "t1.promo_area, t1.promo_prov, t9.catalogname prov_name, t1.promo_city, t10.catalogname city_name, "
				+ "t1.promo_start_date, t1.promo_end_date, t1.custom_service_name custom_service, t5.USER_NAME promo_man, "
				+ "t1.contact_num, t1.cust_name, t1.contact_start_date, t1.contact_end_date, t1.acti_start_date, t1.acti_end_date, t1.tar_clue_num, "
				+ "t1.tar_reach_num, t1.tar_trans_num, t1.pro_state ,0 is_bl ,t1.acti_name ,t1.iway, "
				+ "t1.competing,COUNT(DISTINCT(t13.record_id)) AS visit_count "
				+ "from car_315.tb_data_project t1 "
				+ "LEFT JOIN finance.tb_fin_dep t2 ON t1.ini_dept=t2.DEP_ID "   //部门
				+ "LEFT JOIN finance.tb_fin_user t3 ON t1.ini_man=t3.USER_CODE  "  //发起人
				+ "LEFT JOIN finance.tb_fin_user t5 ON t1.promo_man=t5.USER_CODE "  //推广人
				+ "LEFT JOIN car_315.dbo_car_catalognew t6 ON t1.brand=t6.catalogid "  //品牌
				+ "LEFT JOIN car_315.dbo_car_catalognew t7 ON t1.car=t7.catalogid "  //车系
				+ "LEFT JOIN car_315.dbo_car_catalognew t11 ON t1.model=t11.catalogid "  //车系
				+ "LEFT JOIN finance.tb_fin_user t8 ON t1.ini_org=t8.ORG_CODE "  //部门对应的机构（分站）
				+ "LEFT JOIN car_315.dbo_are_catalog t9 ON t1.promo_prov=t9.catalogid "  //省份
				+ "LEFT JOIN car_315.dbo_are_catalog t10 ON t1.promo_city=t10.catalogid " //城市
				+ "LEFT JOIN car_315.tb_data_visit_record t13 ON t1.pro_num=t13.pro_num AND t13.is_invite=1 and t13.attend_type in(1,2,3,4) " //客服记录表   
				+ "where t8.USER_CODE='" + userid + "' AND " + sqlWhere + "GROUP BY t1.pro_num DESC "
						+ "LIMIT "+ page*pageNum +","+ pageNum +" ";
		System.out.println(sql);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			resultList = new ArrayList<Map<String,String>>();
			while(rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("is_bl", rs.getInt("is_bl") + "");
				map.put("pro_num", rs.getString("pro_num"));  //项目编号
				map.put("dept_name", rs.getString("dept_name"));  //部门名称
				map.put("acti_name", rs.getString("acti_name"));  //部门名称
				map.put("ini_man", rs.getString("ini_man"));  //发起人
				Date ini_date = rs.getDate("ini_date");
				String ini_date_str = ini_date==null?"":sdf.format(ini_date);
				map.put("ini_date", ini_date_str);
				map.put("service_type", String.valueOf(rs.getInt("service_type")));  //业务类型
				int brand = rs.getInt("brand");
				map.put("brand", brand+"");  //品牌
				int car = rs.getInt("car");
				map.put("car",car+"");//车系
				int model = rs.getInt("model");
				map.put("model",model+"");//车型
				map.put("brand_name", rs.getString("brand_name"));  //品牌
				String iway = rs.getString("iway");
				map.put("iway", iway==null?"":iway);  //渠道
				map.put("car_name", rs.getString("car_name"));  //车型
				map.put("model_name", rs.getString("model_name"));  //车型
				map.put("promo_area", rs.getString("promo_area"));  //推广区域
				int promo_prov = rs.getInt("promo_prov");
				int promo_city = rs.getInt("promo_city");
				map.put("promo_prov", promo_prov+"");  //推广省份
				map.put("promo_city", promo_city+"");  //推广城市
				map.put("prov_name", rs.getString("prov_name"));  //省份名
				map.put("city_name", rs.getString("city_name"));  //城市名
				Date promo_start_date = rs.getDate("promo_start_date");
				String promo_start_date_str = promo_start_date==null?"":sdf.format(promo_start_date);
				map.put("promo_start_date", promo_start_date_str);
				Date promo_end_date = rs.getDate("promo_end_date");
				String promo_end_date_str = promo_end_date==null?"":sdf.format(promo_end_date);
				map.put("promo_end_date", promo_end_date_str);
				map.put("custom_service", rs.getString("custom_service"));  //责任客服
				if (rs.getString("promo_man") == null) {
					map.put("promo_man", "");  //责任推广人员
				}else {
					map.put("promo_man", rs.getString("promo_man"));  //责任推广人员
				}
				map.put("pro_state", rs.getString("pro_state"));  //项目状态
				
				//用于在 modal 中显示数据
				map.put("contact_num", rs.getString("contact_num"));
				map.put("cust_name", rs.getString("cust_name"));
				map.put("contact_start_date",rs.getDate("contact_start_date")==null?"":rs.getDate("contact_start_date").toString());
				map.put("contact_end_date", rs.getDate("contact_end_date")==null?"":rs.getDate("contact_end_date").toString());
				map.put("acti_start_date", rs.getDate("acti_start_date")==null?"":rs.getDate("acti_start_date").toString());
				if (rs.getDate("acti_end_date")==null) {
					map.put("acti_end_date", "");
				}else {
					map.put("acti_end_date", rs.getDate("acti_end_date").toString());
				}
				map.put("tar_clue_num", String.valueOf(rs.getInt("tar_clue_num")));
				map.put("tar_reach_num", String.valueOf(rs.getInt("tar_reach_num")));
				map.put("tar_trans_num", String.valueOf(rs.getInt("tar_trans_num")));
				map.put("visit_count", rs.getInt("visit_count")+"");
				BaomingSubDao baomingSubDao = new BaomingSubDao();
				String competing = rs.getString("competing");
				int baoming_count = baomingSubDao.queryJinpinCount(competing,promo_start_date_str,promo_end_date_str,promo_prov,promo_city,brand,car,model,iway);
				map.put("baoming_count", baoming_count+"");
				resultList.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultList;
	}
	public int getProjectsPagesForSerDirector(Map<String, String> whereMap) {
		int rows;
		int pages=0;
		String userid = whereMap.get("userid");
		
		StringBuffer sqlWhere = new StringBuffer();
		if (whereMap.size() > 1) {
			
			if (whereMap.get("pro_num")!=null && whereMap.get("pro_num").length()!=0) sqlWhere.append("t1.pro_num='" + whereMap.get("pro_num") + "' AND ");  //编号
			if (whereMap.get("ini_dept")!=null && whereMap.get("ini_dept").length()!=0) sqlWhere.append("t1.ini_dept='" + whereMap.get("ini_dept") + "' AND ");  //部门
			if (whereMap.get("ini_man")!=null && whereMap.get("ini_man").length()!=0) sqlWhere.append("t1.ini_man='" + whereMap.get("ini_man") + "' AND ");  //发起人
			if (whereMap.get("service_type")!=null && whereMap.get("service_type").length()!=0) sqlWhere.append("t1.service_type=" + whereMap.get("service_type") + " AND ");  //业务类型
			if (whereMap.get("brand")!=null && whereMap.get("brand").length()!=0) sqlWhere.append("t1.brand=" + whereMap.get("brand") + " AND ");  //品牌
			if (whereMap.get("ini_date")!=null && whereMap.get("ini_date").length()!=0) sqlWhere.append("t1.ini_date like'" + whereMap.get("ini_date") + "%' AND ");  //发起日期
//			if (whereMap.get("promo_area")!=null && whereMap.get("promo_area").length()!=0) sqlWhere.append("t1.promo_area='" + whereMap.get("promo_area") + "' AND ");  //推广区域
			if (whereMap.get("promo_prov")!=null && whereMap.get("promo_prov").length()!=0) sqlWhere.append("t1.promo_prov=" + whereMap.get("promo_prov") + " AND ");  //推广省份
			if (whereMap.get("promo_city")!=null && whereMap.get("promo_city").length()!=0) sqlWhere.append("t1.promo_city=" + whereMap.get("promo_city") + " AND ");  //推广省份
			if (whereMap.get("pro_state")!=null && whereMap.get("pro_state").length()!=0) sqlWhere.append("t1.pro_state=" + whereMap.get("pro_state") + " AND ");  //状态
			if (whereMap.get("pro_finish")!=null && whereMap.get("pro_finish").length()!=0) sqlWhere.append("promo_end_date<NOW() AND pro_state=3 AND ");  //查询已完成项目
		}
		
		int pageNum = Integer.valueOf(whereMap.get("pageNum"));
		
		sqlWhere.append("pro_state IN("+ whereMap.get("states") +")  ");
		sqlWhere.toString();
		System.out.println(sqlWhere);
		String sql = "select count(*) c from (select t1.pro_num, COUNT(DISTINCT(t12.phone)) AS baoming_count, COUNT(DISTINCT(t13.record_id)) AS visit_count "
				+ "from car_315.tb_data_project t1 "
				+ "LEFT JOIN finance.tb_fin_dep t2 ON t1.ini_dept=t2.DEP_ID "   //部门
				+ "LEFT JOIN finance.tb_fin_user t3 ON t1.ini_man=t3.USER_CODE  "  //发起人
				+ "LEFT JOIN finance.tb_fin_user t5 ON t1.promo_man=t5.USER_CODE "  //推广人
				+ "LEFT JOIN car_315.dbo_car_catalognew t6 ON t1.brand=t6.catalogid "  //品牌
				+ "LEFT JOIN car_315.dbo_car_catalognew t7 ON t1.car=t7.catalogid "  //车系
				+ "LEFT JOIN car_315.dbo_car_catalognew t11 ON t1.model=t11.catalogid "  //车系
				+ "LEFT JOIN finance.tb_fin_user t8 ON t1.ini_org=t8.ORG_CODE "  //部门对应的机构（分站）
				+ "LEFT JOIN car_315.dbo_are_catalog t9 ON t1.promo_prov=t9.catalogid "  //省份
				+ "LEFT JOIN car_315.dbo_are_catalog t10 ON t1.promo_city=t10.catalogid " //城市
				+ "LEFT JOIN tb_data_baoming t12 ON TO_DAYS(t12.baoming_date)>=TO_DAYS(t1.promo_start_date) AND TO_DAYS(t12.baoming_date)<=TO_DAYS(t1.promo_end_date) "
									+ "AND t1.promo_prov=(CASE WHEN t1.promo_prov!=-1 THEN t12.prov ELSE -1 END) "
									+ "AND t1.promo_city=(CASE WHEN t1.promo_city!=-1 THEN t12.city ELSE -1 END) "
//									+ "AND t1.brand=(CASE WHEN t1.brand!=-1 THEN t11.brand ELSE -1 END) "
									+ "AND t1.car=(CASE WHEN t1.car!=-1 THEN t12.serial ELSE -1 END) "
									+ "AND t12.serial IN (SELECT catalogid FROM dbo_car_catalognew WHERE pathlevel=2 AND iway=t1.iway) "
									+ "AND t1.model=(CASE WHEN t1.model!=-1 THEN t12.model ELSE -1 END) " //报名量
							+ "LEFT JOIN car_315.tb_data_visit_record t13 ON t1.pro_num=t13.pro_num AND t13.is_invite=1 and t13.attend_type in(1,2,3,4) " //客服记录表   
				+ "where t8.USER_CODE='" + userid + "' AND " + sqlWhere + "GROUP BY t1.pro_num DESC ) t";
		System.out.println(sql);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			rs.next();
			rows = rs.getInt("c");
			if (rows%pageNum==0) {
				pages = rows/pageNum;
			}else {
				pages = rows/pageNum + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pages;
	}
	
	public int getProjectsPagesForPromoDirector(Map<String, String> whereMap) {
		int pages = 0;
		int rows;
		
		String userid = whereMap.get("userid");
		
		StringBuffer sqlWhere = new StringBuffer();
		if (whereMap.size() > 1) {
			
			if (whereMap.get("pro_num")!=null && whereMap.get("pro_num").length()!=0) sqlWhere.append("t1.pro_num='" + whereMap.get("pro_num") + "' AND ");  //编号
			if (whereMap.get("ini_dept")!=null && whereMap.get("ini_dept").length()!=0) sqlWhere.append("t1.ini_dept='" + whereMap.get("ini_dept") + "' AND ");  //部门
			if (whereMap.get("ini_man")!=null && whereMap.get("ini_man").length()!=0) sqlWhere.append("t1.ini_man='" + whereMap.get("ini_man") + "' AND ");  //发起人
			if (whereMap.get("service_type")!=null && whereMap.get("service_type").length()!=0) sqlWhere.append("t1.service_type=" + whereMap.get("service_type") + " AND ");  //业务类型
			if (whereMap.get("brand")!=null && whereMap.get("brand").length()!=0) sqlWhere.append("t1.iway='" + whereMap.get("brand") + "' AND ");  //品牌
			if (whereMap.get("ini_date")!=null && whereMap.get("ini_date").length()!=0) sqlWhere.append("t1.ini_date like'" + whereMap.get("ini_date") + "%' AND ");  //发起日期
//			if (whereMap.get("promo_area")!=null && whereMap.get("promo_area").length()!=0) sqlWhere.append("t1.promo_area='" + whereMap.get("promo_area") + "' AND ");  //推广区域
			if (whereMap.get("promo_prov")!=null && whereMap.get("promo_prov").length()!=0) sqlWhere.append("t1.promo_prov=" + whereMap.get("promo_prov") + " AND ");  //推广省份
			if (whereMap.get("promo_city")!=null && whereMap.get("promo_city").length()!=0) sqlWhere.append("t1.promo_city=" + whereMap.get("promo_city") + " AND ");  //推广省份
			if (whereMap.get("pro_state")!=null && whereMap.get("pro_state").length()!=0) sqlWhere.append("t1.pro_state=" + whereMap.get("pro_state") + " AND ");  //状态
			if (whereMap.get("pro_finish")!=null && whereMap.get("pro_finish").length()!=0) sqlWhere.append("promo_end_date<NOW() AND pro_state=3 AND ");  //查询已完成项目
		}
		
		int pageNum = Integer.valueOf(whereMap.get("pageNum"));
		
		sqlWhere.append("pro_state IN("+ whereMap.get("states") +") order by ini_date ");
		
//		String sql = "select COUNT(t1.pro_num) pro_count "
//					+ "from car_315.tb_data_project t1 "
//							+ "LEFT JOIN finance.tb_fin_dep t2 ON t1.ini_dept=t2.DEP_ID "   //部门
//							+ "LEFT JOIN finance.tb_fin_user t3 ON t1.ini_man=t3.USER_CODE  "  //发起人
//							+ "LEFT JOIN finance.tb_fin_user t4 ON t1.custom_service=t4.USER_CODE "  //责任客服
//							+ "LEFT JOIN finance.tb_fin_user t5 ON t1.promo_man=t5.USER_CODE "  //推广人
//							+ "LEFT JOIN car_315.dbo_car_catalognew t6 ON t1.brand=t6.catalogid "  //品牌
//							+ "LEFT JOIN car_315.dbo_car_catalognew t7 ON t1.brand=t7.catalogid "  //车系
//							+ "LEFT JOIN finance.tb_fin_user t8 ON t1.ini_org=t8.ORG_CODE "  //部门对应的机构（分站）
//							+ "LEFT JOIN car_315.dbo_are_catalog t9 ON t1.promo_prov=t9.catalogid "  //省份
//							+ "LEFT JOIN car_315.dbo_are_catalog t10 ON t1.promo_city=t10.catalogid " //城市
//					+ "where t8.USER_CODE='" + userid + "' AND " + sqlWhere ;
		String sql = "select COUNT(t1.pro_num) pro_count "
					+ "from car_315.tb_data_project t1 "
							+ "LEFT JOIN finance.tb_fin_dep t2 ON t1.ini_dept=t2.DEP_ID "   //部门
							+ "LEFT JOIN finance.tb_fin_user t3 ON t1.ini_man=t3.USER_CODE  "  //发起人
							+ "LEFT JOIN finance.tb_fin_user t4 ON t1.custom_service=t4.USER_CODE "  //责任客服
							+ "LEFT JOIN finance.tb_fin_user t5 ON t1.promo_man=t5.USER_CODE "  //推广人
							+ "LEFT JOIN car_315.dbo_car_catalognew t6 ON t1.brand=t6.catalogid "  //品牌
							+ "LEFT JOIN car_315.dbo_car_catalognew t7 ON t1.car=t7.catalogid "  //车系
							+ "LEFT JOIN car_315.dbo_car_catalognew t11 ON t1.model=t11.catalogid "  //车系
			//				+ "LEFT JOIN finance.tb_fin_user t8 ON t1.ini_org=t8.ORG_CODE "  //部门对应的机构（分站）
							+ "LEFT JOIN car_315.dbo_are_catalog t9 ON t1.promo_prov=t9.catalogid "  //省份
							+ "LEFT JOIN car_315.dbo_are_catalog t10 ON t1.promo_city=t10.catalogid " //城市
					+ "where 1 AND t1.ini_man IS NOT NULL AND " + sqlWhere ;
		System.out.println(sql);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			rs.next();
			rows = rs.getInt("pro_count");
			if (rows%pageNum==0) {
				pages = rows/pageNum;
			}else {
				pages = rows/pageNum + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return pages;
	}

	public Map<String, String> getPromoPerMap(String userid) {
		
		Map<String, String> perMap = null;
		String sql = "SELECT t1.USER_CODE, t1.USER_NAME "
					+ "FROM finance.tb_fin_user t1, finance.tb_fin_dep t2, finance.tb_fin_user t3 "
					+ "WHERE t1.DEPT_CODE = t2.DEP_ID AND t2.DEP_ID = t3.DEPT_CODE AND t3.USER_CODE = '" + userid + "' AND t3.ISONJOB=0 "; 
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			perMap = new HashMap<String, String>();
			while(rs.next()) {
				perMap.put(rs.getString("USER_CODE"), rs.getString("USER_NAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return perMap;
	}

public List<Map<String, String>> getProjectsForPromoPer(Map<String, String> mapwhere) {
		
		List<Map<String, String>> resultList = null;
		
		String sqlWhere = "";
		if (mapwhere.get("search_state").equals("new")) {
			sqlWhere = "AND t1.pro_state=3 AND t1.pro_num NOT IN(SELECT DISTINCT pro_num FROM car_315.tb_data_promo_method) ";
		}else if (mapwhere.get("search_state").equals("old")) {
			sqlWhere = "AND t1.pro_state=3 ";
		}else if (mapwhere.get("search_state").equals("finish")) {
			sqlWhere = "AND t1.pro_state=5 ";
		}
		
		int pageNum = Integer.valueOf(mapwhere.get("pageNum"));
		int page = Integer.valueOf(mapwhere.get("page")) - 1;
		 
		String sql = "select t1.pro_num, t2.DEP_NAME dept_name, t3.USER_NAME ini_man, t1.ini_date, t1.service_type, t1.custom_service, t1.custom_service_name, "
							+ "t1.brand, t1.iway, t1.car, t1.model, t6.catalogname brand_name, t7.catalogname car_name, t12.catalogname model_name, "
							+ "t1.promo_area, t1.promo_prov, t9.catalogname prov_name, t1.promo_city, t10.catalogname city_name, t1.promo_start_date, t1.promo_end_date, "
							+ "t5.USER_NAME promo_man, t1.pro_state, t1.contact_num, "
							+ "t1.cust_name, t1.contact_start_date, t1.contact_end_date, t1.acti_start_date, t1.acti_end_date, "
							+ "t1.tar_clue_num, t1.tar_reach_num, t1.tar_trans_num, t1.competing, t1.competing_name, "
							+ "COUNT(t8.promo_id) method_count, COUNT(DISTINCT(t11.phone)) AS baoming_count, COUNT(DISTINCT(t13.record_id)) AS visit_count "
					+ "from car_315.tb_data_project t1 "
							+ "LEFT JOIN finance.tb_fin_dep t2 ON t1.ini_dept=t2.DEP_ID "   //部门
							+ "LEFT JOIN finance.tb_fin_user t3 ON t1.ini_man=t3.USER_CODE  "  //发起人
//							+ "LEFT JOIN finance.tb_fin_user t4 ON t1.custom_service=t4.USER_CODE "  //责任客服
							+ "LEFT JOIN finance.tb_fin_user t5 ON t1.promo_man=t5.USER_CODE "  //推广人
							+ "LEFT JOIN car_315.dbo_car_catalognew t6 ON t1.brand=t6.catalogid "  //品牌
							+ "LEFT JOIN car_315.dbo_car_catalognew t7 ON t1.car=t7.catalogid "  //车系
							+ "LEFT JOIN car_315.dbo_car_catalognew t12 ON t1.model=t12.catalogid "  //车系
							+ "LEFT JOIN car_315.tb_data_promo_method t8 ON t1.pro_num=t8.pro_num "  //推广方案
							+ "LEFT JOIN car_315.dbo_are_catalog t9 ON t1.promo_prov=t9.catalogid "  //省份
							+ "LEFT JOIN car_315.dbo_are_catalog t10 ON t1.promo_city=t10.catalogid " //城市
							+ "LEFT JOIN tb_data_baoming t11 ON TO_DAYS(t11.baoming_date)>=TO_DAYS(t1.promo_start_date) AND TO_DAYS(t11.baoming_date)<=TO_DAYS(t1.promo_end_date) "
									+ "AND t1.promo_prov=(CASE WHEN t1.promo_prov!=-1 THEN t11.prov ELSE -1 END) "
									+ "AND t1.promo_city=(CASE WHEN t1.promo_city!=-1 THEN t11.city ELSE -1 END) "
//									+ "AND t1.brand=(CASE WHEN t1.brand!=-1 THEN t11.brand ELSE -1 END) "
									+ "AND t1.car=(CASE WHEN t1.car!=-1 THEN t11.serial ELSE -1 END) "
									+ "AND t11.serial IN (SELECT catalogid FROM dbo_car_catalognew WHERE pathlevel=2 AND iway=t1.iway) "
									+ "AND t1.model=(CASE WHEN t1.model!=-1 THEN t11.model ELSE -1 END) " //报名量
							+ "LEFT JOIN car_315.tb_data_visit_record t13 ON t1.pro_num=t13.pro_num AND t13.is_invite=1 " //客服记录表    
					+ "WHERE t1.promo_man = '" + mapwhere.get("userid") + "' AND pro_state IN(3,5) "
//					+ "t1.promo_man = '" + mapwhere.get("userid") + "' "
					+ sqlWhere
					+ "GROUP BY t1.pro_num "
					+ "ORDER BY t1.ini_date DESC "
					+ "LIMIT "+ page*pageNum +","+ pageNum +" ";
		System.out.println(sql);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			resultList = new ArrayList<Map<String,String>>();
			while(rs.next()) {
				
				Map<String, String> map = new HashMap<String, String>();
				
				map.put("pro_num", rs.getString("pro_num"));  //项目编号
				map.put("dept_name", rs.getString("dept_name"));  //部门名称
				map.put("ini_man", rs.getString("ini_man"));  //发起人
				map.put("ini_date", rs.getString("ini_date"));  //发起日期
				map.put("service_type", String.valueOf(rs.getInt("service_type")));  //业务类型
//				map.put("brand", rs.getInt("brand")+"");  //品牌
				map.put("iway", rs.getString("iway"));
				map.put("car", rs.getInt("car")+"");  //车系
				map.put("model", rs.getInt("model")+"");  //车型
//				map.put("brand_name", rs.getString("brand_name"));  //品牌名称
				map.put("car_name", rs.getString("car_name"));  //车系名称
				map.put("model_name", rs.getString("model_name"));  //车型名称
//				map.put("promo_area", rs.getString("promo_area"));  //推广区域
				map.put("promo_prov", rs.getInt("promo_prov")+"");
				map.put("promo_city", rs.getInt("promo_city")+"");
				map.put("prov_name", rs.getString("prov_name"));
				map.put("city_name", rs.getString("city_name"));
				map.put("promo_start_date", rs.getDate("promo_start_date").toString());  //项目开始时间
				map.put("promo_end_date", rs.getDate("promo_end_date").toString());  //项目开始时间
				map.put("custom_service", rs.getString("custom_service"));  //责任客服
				if (rs.getString("custom_service_name")==null) {
					map.put("custom_service_name", "");  //责任客服
				}else {
					map.put("custom_service_name", rs.getString("custom_service_name"));  //责任客服
				}
				map.put("method_count", rs.getString("method_count"));  //推广发难数量
				if (rs.getString("promo_man") == null) {
					map.put("promo_man", "");  //责任推广人员
				}else {
					map.put("promo_man", rs.getString("promo_man"));  //责任推广人员
				}
				map.put("pro_state", rs.getString("pro_state"));  //项目状态
				
				//用于在 modal 中显示数据
				map.put("contact_num", rs.getString("contact_num"));
				map.put("cust_name", rs.getString("cust_name"));
				map.put("contact_start_date", rs.getDate("contact_start_date").toString());
				map.put("contact_end_date", rs.getDate("contact_end_date").toString());
				map.put("acti_start_date", rs.getDate("acti_start_date").toString());
				map.put("acti_end_date", rs.getDate("acti_end_date").toString());
				map.put("tar_clue_num", String.valueOf(rs.getString("tar_clue_num")));
				map.put("tar_reach_num", String.valueOf(rs.getString("tar_reach_num")));
				map.put("tar_trans_num", String.valueOf(rs.getString("tar_trans_num")));
				
				map.put("competing", "competing");
				
				if (rs.getString("competing_name") == null) {
					map.put("competing_name", "");
				}else {
					map.put("competing_name", rs.getString("competing_name"));
				}
				
				
				double bmcount = rs.getInt("baoming_count")*1.0;
				double vscount = rs.getInt("visit_count")*1.0;
				String vsrate = "0";
				if (bmcount!=0) {
					double rate = vscount/bmcount;
					DecimalFormat df = new DecimalFormat("0.00%");    //##.00%
					vsrate = df.format(rate);
				}
				
				map.put("baoming_count", rs.getInt("baoming_count")+"");
				map.put("visit_count", rs.getInt("visit_count")+"");
				map.put("visit_rate", vsrate);
				resultList.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultList;
	}

	public List<Map<String, String>> getProjectsByPronumForPer(String pro_num) {
		
		List<Map<String, String>> resultList = null;
		
		String sql = "select t1.pro_num, t2.DEP_NAME dept_name, t3.USER_NAME ini_man, t1.ini_date, t1.service_type, t6.catalogname brand, t7.catalogname car, "
							+ "t1.promo_area, t1.promo_prov, t8.catalogname prov_name, t1.promo_city, t9.catalogname city_name, t1.promo_start_date, t1.promo_end_date, t4.USER_NAME custom_service, t5.USER_NAME promo_man, t1.pro_state, "
							+ "t1.contact_num, t1.cust_name, t1.contact_start_date, t1.contact_end_date, t1.acti_start_date, t1.acti_end_date, t1.tar_clue_num, t1.tar_reach_num, t1.tar_trans_num "
					+ "from car_315.tb_data_project t1 "
							+ "LEFT JOIN finance.tb_fin_dep t2 ON t1.ini_dept=t2.DEP_ID "   //部门
							+ "LEFT JOIN finance.tb_fin_user t3 ON t1.ini_man=t3.USER_CODE  "  //发起人
							+ "LEFT JOIN finance.tb_fin_user t4 ON t1.custom_service=t4.USER_CODE "  //责任客服
							+ "LEFT JOIN finance.tb_fin_user t5 ON t1.promo_man=t5.USER_CODE "  //推广人
							+ "LEFT JOIN car_315.dbo_car_catalognew t6 ON t1.brand=t6.catalogid "  //品牌
							+ "LEFT JOIN car_315.dbo_car_catalognew t7 ON t1.car=t7.catalogid "  //车系
							+ "LEFT JOIN car_315.dbo_are_catalog t8 ON t1.promo_prov=t8.catalogid "  //省份
							+ "LEFT JOIN car_315.dbo_are_catalog t9 ON t1.promo_city=t9.catalogid " //城市
					+ "where t1.pro_num = '" + pro_num + "' LIMIT 1";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			resultList = new ArrayList<Map<String,String>>();
			while(rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				
				map.put("pro_num", rs.getString("pro_num"));  //项目编号
				map.put("dept_name", rs.getString("dept_name"));  //部门名称
				map.put("ini_man", rs.getString("ini_man"));  //发起人
				map.put("ini_date", rs.getString("ini_date"));  //发起日期
				map.put("service_type", String.valueOf(rs.getInt("service_type")));  //业务类型
//				map.put("brand", rs.getString("brand"));  //品牌
				map.put("brand", rs.getString("iway"));   //渠道
				map.put("car", rs.getString("car"));  //车型
//				map.put("promo_area", rs.getString("promo_area"));  //推广区域
				map.put("promo_prov", rs.getInt("promo_prov")+"");  //省
				map.put("promo_city", rs.getInt("promo_city")+"");  //市
				map.put("prov_name", rs.getString("prov_name"));  //省
				map.put("city_name", rs.getString("city_name"));  //市
				
				map.put("promo_start_date", rs.getDate("promo_start_date").toString());  //项目开始时间
				map.put("promo_end_date", rs.getDate("promo_end_date").toString());  //项目开始时间
				map.put("custom_service", rs.getString("custom_service"));  //责任客服
				if (rs.getString("promo_man") == null) {
					map.put("promo_man", "");  //责任推广人员
				}else {
					map.put("promo_man", rs.getString("promo_man"));  //责任推广人员
				}
				map.put("pro_state", rs.getString("pro_state"));  //项目状态
				
				//用于在 modal 中显示数据
				map.put("contact_num", rs.getString("contact_num"));
				map.put("cust_name", rs.getString("cust_name"));
				map.put("contact_start_date", rs.getDate("contact_start_date").toString());
				map.put("contact_end_date", rs.getDate("contact_end_date").toString());
				map.put("acti_start_date", rs.getDate("acti_start_date").toString());
				map.put("acti_end_date", rs.getDate("acti_end_date").toString());
				map.put("tar_clue_num", String.valueOf(rs.getString("tar_clue_num")));
				map.put("tar_reach_num", String.valueOf(rs.getString("tar_reach_num")));
				map.put("tar_trans_num", String.valueOf(rs.getString("tar_trans_num")));
				
				resultList.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultList;
	}

	public List<Map<String, String>> findKctModelsByProNum(String pro_num) {
		int brand = -1;
		int car = -1;
		List<Map<String,String>> models = new ArrayList<Map<String,String>>();
		String sql = "select t1.car,t1.brand from car_315.tb_data_project t1 where pro_num=?";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, pro_num);
			ResultSet rs = dbc.executeQuery();
			if(rs.next()) {
				brand = rs.getInt("brand");
				car = rs.getInt("car");
			}
			if(car==-1){
				sql = "select t3.catalogid code,t2.byname carname,t3.byname name,t2.lname lname from car_315.dbo_car_catalognew t3 left join car_315.dbo_car_catalognew t2 on t2.catalogid = t3.fatherid left join car_315.dbo_car_catalognew t1 on t1.catalogid = t2.fatherid where t1.catalogid=? order by t2.lname";
			}else{
				sql = "select t2.catalogid code,t1.byname carname,t2.byname name,t1.lname lname from car_315.dbo_car_catalognew t2 left join car_315.dbo_car_catalognew t1 on t1.catalogid = t2.fatherid where t1.catalogid=? order by t1.lname";
			}
			dbc = new DBConnect(sql);
			if(car==-1){
				dbc.setInt(1, brand);
			}else{
				dbc.setInt(1, car);
			}
			rs = dbc.executeQuery();
			while(rs.next()) {
				Map<String,String> model = new HashMap<String,String>();
				String code = rs.getInt("code")+"";
				String name = rs.getString("lname")+" "+rs.getString("carname")+rs.getString("name");
				model.put("code", code);
				model.put("name", name);
				models.add(model);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return models;
	}

	public List<Map<String, String>> getGivings() {
		List<Map<String,String>>givings = new ArrayList<Map<String,String>>();
		String sql="select * from tb_data_package where isdel=0";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()) {
				Map<String,String> giving = new HashMap<String,String>();
				giving.put("code", "1-"+rs.getInt("package_id"));
				giving.put("name", rs.getString("package_name"));
				givings.add(giving);
			}
			sql = "select * from tb_data_gift where isdel=0";
			dbc = new DBConnect(sql);
			rs = dbc.executeQuery();
			while(rs.next()) {
				Map<String,String> giving = new HashMap<String,String>();
				giving.put("code", "0-"+rs.getInt("gift_id"));
				giving.put("name", rs.getString("gift_name"));
				givings.add(giving);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return givings;
	}

	public List<Map<String, String>> getExamineList(String service_type,
			String pro_num, String start, String end, String examine_state,
			String send_state, String iway, String model,int page,int pageSize,String name,String phone){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sql = new StringBuffer();
		sql.append("		 select t2.trans_date,t1.acti_name,u.USER_NAME ,t2.`name` name,t2.phone,t3.apply_state,");
		sql.append("				t2.giving_name,m.catalogname model,c.iway iway,t2.gift_examine_state,t2.id	");
		sql.append("		   from tb_data_trans_info t2																");
		sql.append("      left join tb_data_project t1 on t1.pro_num = t2.pro_num								");
		sql.append("      left join tb_data_present_apply t3 on t3.transid = t2.id								");
		sql.append("      left join tb_data_act_detail t4 on t4.pro_num = t1.pro_num								");
		sql.append("      left join dbo_car_catalognew m on t2.model = m.catalogid									");
		sql.append("      left join dbo_car_catalognew c on m.fatherid = c.catalogid								");
		sql.append("	  left join finance.tb_fin_user u on t4.detail_executor = u.USER_CODE								");
		sql.append("	   	  where 1=1		and t1.pro_state=5														");
		if(!"-1".equals(service_type)){
			sql.append("		and t1.service_type=												   "+service_type);
		}
		if(!"-1".equals(pro_num)){
			sql.append("		and t2.pro_num='"+pro_num+"'");
		}
		if(StringUtils.isNotEmpty(start)){
			start = start.replaceAll("-", "");
			sql.append("		and date_format(t1.acti_start_date,'%Y%m%d')>=								  "+start);
		}
		if(StringUtils.isNotEmpty(end)){
			end = end.replaceAll("-", "");
			sql.append("		and date_format(t1.acti_end_date,'%Y%m%d')<=								    "+end);
		}
		if(!"-1".equals(examine_state)){
			sql.append("		and t2.gift_examine_state = 								    	  "+examine_state);
		}
		if("0".equals(send_state)){
			sql.append("		and (t3.apply_state <>3 	or 	t3.apply_state is null)						    	     ");
		}
		if("1".equals(send_state)){
			sql.append("		and t3.apply_state =3 								    	         				");
		}
		if(StringUtils.isNotEmpty(iway)){
			sql.append("		and c.iway ='"+iway+"'																");
		}
		if(!"-1".equals(model)){
			sql.append("		and m.catalogid = 								    	              		  "+model);
		}
		if(StringUtils.isNotEmpty(name)){
			sql.append("		and t2.name like '%"+name+"%'															");
		}
		if(StringUtils.isNotEmpty(phone)){
			sql.append("		and t2.phone like '%"+phone+"%'														");
		}
		sql.append("	limit ?,?												  										 ");
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		DBConnect dbc = null;
		try {
			System.out.println(sql.toString());
			dbc = new DBConnect(sql.toString());
			int s = (page-1)*pageSize;
			dbc.setInt(1, s);
			dbc.setInt(2, pageSize);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()) {
				Map<String,String> map = new HashMap<String,String>();
				map.put("trans_date", sdf.format(rs.getDate("trans_date")));
				map.put("acti_name", rs.getString("acti_name"));
				map.put("ini_man_name", rs.getString("USER_NAME"));
				map.put("name", rs.getString("name"));
				map.put("phone", rs.getString("phone"));
				int apply_state = rs.getInt("apply_state");
				if(apply_state==3){
					map.put("send_state", "1");
				}else{
					map.put("send_state", "0");
				}
				map.put("giving_name", rs.getString("giving_name"));
				map.put("model", rs.getString("model"));
				map.put("iway", rs.getString("iway"));
				map.put("gift_examine_state", rs.getInt("gift_examine_state")+"");
				map.put("trans_id", rs.getInt("id")+"");
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public List<Map<String, String>> getModelsByIway(String iway) {
		String sql = "select DISTINCT catalogid,catalogname,lname from dbo_car_catalognew where pathlevel=3 and iway=?";
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			dbc.setString(1, iway);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()) {
				Map<String,String> map = new HashMap<String,String>();
				map.put("code", rs.getInt("catalogid")+"");
				map.put("name", rs.getString("lname")+"&nbsp;"+rs.getString("catalogname"));
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<Map<String, String>> getIways() {
		String sql = "SELECT DISTINCT iway,wayname FROM dbo_car_catalognew WHERE iway != '' AND iway IS NOT NULL AND wayname IS NOT NULL AND wayname != '' AND isdelete = 0 AND pathlevel = 3 ORDER BY wayname";
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			while(rs.next()) {
				Map<String,String> map = new HashMap<String,String>();
				map.put("code", rs.getString("iway"));
				map.put("name", rs.getString("wayname")+"&nbsp;"+rs.getString("iway"));
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public List<Map<String, String>> getProNumsByType(String service_type) {
		String sql="select pro_num,acti_name from tb_data_project where service_type=?";
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			dbc.setInt(1, Integer.parseInt(service_type));
			ResultSet rs = dbc.executeQuery();
			while(rs.next()) {
				Map<String,String> map = new HashMap<String,String>();
				map.put("acti_name", rs.getString("acti_name"));
				map.put("pro_num", rs.getString("pro_num"));
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public String examineGift(String trans_id, String examine_state) {
		String sql = "update tb_data_trans_info set gift_examine_state=? where id=?";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			dbc.setInt(1, Integer.parseInt(examine_state));
			dbc.setInt(2, Integer.parseInt(trans_id));
			dbc.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return "-1";
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "1";
	}

	public int getExamineListPages(String service_type, String pro_num,
			String start, String end, String examine_state, String send_state,
			String iway, String model, int page, int pageSize,String name,String phone) {
		StringBuffer sql = new StringBuffer();
		sql.append("		 select count(*) count																		");
		sql.append("		   from tb_data_trans_info t2																");
		sql.append("      left join tb_data_project t1 on t1.pro_num = t2.pro_num								");
		sql.append("      left join tb_data_present_apply t3 on t3.transid = t2.id								");
		sql.append("      left join dbo_car_catalognew m on t2.model = m.catalogid									");
		sql.append("      left join dbo_car_catalognew c on m.fatherid = c.catalogid								");
		sql.append("	  left join finance.tb_fin_user u on t1.ini_man = u.USER_CODE								");
		sql.append("	   	  where 1=1		and t1.pro_state=5																		");
		if(!"-1".equals(service_type)){
			sql.append("		and t1.service_type=												   "+service_type);
		}
		if(!"-1".equals(pro_num)){
			sql.append("		and t2.pro_num='"+pro_num+"'");
		}
		if(StringUtils.isNotEmpty(start)){
			start = start.replaceAll("-", "");
			sql.append("		and date_format(t1.acti_start_date,'%Y%m%d')>=								  "+start);
		}
		if(StringUtils.isNotEmpty(end)){
			end = end.replaceAll("-", "");
			sql.append("		and date_format(t1.acti_end_date,'%Y%m%d')<=								    "+end);
		}
		if(!"-1".equals(examine_state)){
			sql.append("		and t2.gift_examine_state = 								    	  "+examine_state);
		}
		if("0".equals(send_state)){
			sql.append("		and (t3.apply_state <>3 	or 	t3.apply_state is null)						    	     ");
		}
		if("1".equals(send_state)){
			sql.append("		and t3.apply_state =3 								    	         				");
		}
		if(StringUtils.isNotEmpty(iway)){
			sql.append("		and c.iway ='"+iway+"'																");
		}
		if(!"-1".equals(model)){
			sql.append("		and m.catalogid = 								    	              		  "+model);
		}
		if(StringUtils.isNotEmpty(name)){
			sql.append("		and t2.name like '%"+name+"%'															");
		}
		if(StringUtils.isNotEmpty(phone)){
			sql.append("		and t2.phone like '%"+phone+"%'														");
		}
		DBConnect dbc = null;
		try {
			System.out.println(sql.toString());
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			if(rs.next()) {
				int rows = rs.getInt(1);
				if (rows % pageSize == 0) {
					return rows / pageSize;
				} else {
					return rows / pageSize + 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public Map<String, Integer> getProjectStateNum() {
		Map<String, Integer> resultMap = null;
		
		String sql = "SELECT COUNT(pro_num) state_num, pro_state "
					+ "FROM car_315.tb_data_project "
					+ "WHERE pro_state IN(1,3,4,5) "
					+ "GROUP BY pro_state";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			resultMap = new HashMap<String, Integer>();
			while (rs.next()) {
				resultMap.put(String.valueOf(rs.getInt("pro_state")), rs.getInt("state_num"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return resultMap;
	}

	public int getProjectFinishNum() {
		int finishNum = 0;
		
		String sql = "SELECT COUNT(pro_num) finish_num FROM car_315.tb_data_project WHERE pro_state=5 AND ini_man IS NOT NULL";
		System.out.println(sql);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				finishNum = rs.getInt("finish_num");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return finishNum;
	}

	public int getCountForPromoPerNew(Map<String, String> map) {
		int pro_count = 0;
		String sql = "SELECT COUNT(pro_num) pro_count FROM car_315.tb_data_project "
					+ "WHERE promo_man = '"+ map.get("userid") +"' AND pro_state=3 AND pro_num NOT IN(SELECT DISTINCT pro_num FROM car_315.tb_data_promo_method) ";
		System.out.println(sql);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				pro_count = rs.getInt("pro_count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return pro_count;
	}

	public int getCountForPromoPerOld(Map<String, String> map) {
		int pro_count = 0;
		String sql = "SELECT COUNT(pro_num) pro_count FROM car_315.tb_data_project "
					+ "WHERE promo_man = '"+ map.get("userid") +"' AND pro_state=3 ";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				pro_count = rs.getInt("pro_count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return pro_count;
	}

	public int getCountForPromoPerFinish(Map<String, String> map) {
		int pro_count = 0;
		
		String sql = "SELECT COUNT(pro_num) pro_count FROM car_315.tb_data_project "
					+ "WHERE promo_man = '"+ map.get("userid") +"' AND pro_state=5 ";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				pro_count = rs.getInt("pro_count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return pro_count;
	}

	public int getProjectsPagesForPromoPer(Map<String, String> mapwhere) {
		
		int pages = 0;
		int rows = 0;
		int pageNum = Integer.valueOf(mapwhere.get("pageNum"));
		
		String sqlWhere = "";
		if (mapwhere.get("search_state").equals("new")) {
			sqlWhere = "AND t1.promo_end_date>NOW() AND t1.pro_num NOT IN(SELECT DISTINCT pro_num FROM car_315.tb_data_promo_method) ";
		}else if (mapwhere.get("search_state").equals("old")) {
			sqlWhere = "AND t1.pro_num=3 ";
		}else if (mapwhere.get("search_state").equals("finish")) {
			sqlWhere = "AND t1.pro_num=5 ";
		}
		
		String sql = "select COUNT(t1.pro_num) pro_count "
					+ "from car_315.tb_data_project t1 "
					+ "where t1.promo_man = '" + mapwhere.get("userid") + "' AND t1.pro_num IN(3,5) "
					+ sqlWhere;
		
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			rs.next();
			rows = rs.getInt("pro_count");
			if (rows%pageNum==0) {
				pages = rows/pageNum;
			}else {
				pages = rows/pageNum + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return pages;
	}
	public List<Map<String, String>> getOrgList() {
		List<Map<String,String>>orgList = new ArrayList<Map<String,String>>();
		String sql = "select t.ORG_ID,t.ORG_NAME from finance.tb_fin_org t";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()){
				Map<String,String>org = new HashMap<String,String>();
				org.put("code", rs.getInt("ORG_ID")+"");
				org.put("name", rs.getString("ORG_NAME"));
				orgList.add(org);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return orgList;
	}
	public List<Map<String, String>> getProjectListBlListForPromoDir(Map<String, String> whereMap) {
List<Map<String, String>> resultList = null;
		
		String userid = whereMap.get("userid");
		
		int pageNum = Integer.valueOf(whereMap.get("pageNum"));
		int page = Integer.valueOf(whereMap.get("page")) - 1;
		
		
		String sql = "select t1.pro_num, t2.DEP_NAME dept_name, t3.USER_NAME ini_man, t1.ini_date, t1.service_type, t6.catalogname brand, t7.catalogname car, "
							+ "t1.promo_area, t1.promo_prov, t9.catalogname prov_name, t1.promo_city, t10.catalogname city_name, t1.promo_start_date, t1.promo_end_date, t4.USER_NAME custom_service, t5.USER_NAME promo_man, "
							+ "t1.contact_num, t1.cust_name, t1.contact_start_date, t1.contact_end_date, t1.acti_start_date, t1.acti_end_date, t1.tar_clue_num, "
							+ "t1.tar_reach_num, t1.tar_trans_num, t1.pro_state "
					+ "from car_315.tb_data_project_bl t1 "
							+ "LEFT JOIN finance.tb_fin_dep t2 ON t1.ini_dept=t2.DEP_ID "   //部门
							+ "LEFT JOIN finance.tb_fin_user t3 ON t1.ini_man=t3.USER_CODE  "  //发起人
							+ "LEFT JOIN finance.tb_fin_user t4 ON t1.custom_service=t4.USER_CODE "  //责任客服
							+ "LEFT JOIN finance.tb_fin_user t5 ON t1.promo_man=t5.USER_CODE "  //推广人
							+ "LEFT JOIN car_315.dbo_car_catalognew t6 ON t1.brand=t6.catalogid "  //品牌
							+ "LEFT JOIN car_315.dbo_car_catalognew t7 ON t1.car=t7.catalogid "  //车系
							+ "LEFT JOIN finance.tb_fin_user t8 ON t1.ini_org=t8.ORG_CODE "  //部门对应的机构（分站）
							+ "LEFT JOIN car_315.dbo_are_catalog t9 ON t1.promo_prov=t9.catalogid "  //省份
							+ "LEFT JOIN car_315.dbo_are_catalog t10 ON t1.promo_city=t10.catalogid " //城市
					+ "where t8.USER_CODE='" + userid + "' AND t1.pro_state IN(1,4)" ;
		
		System.out.println(sql);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			resultList = new ArrayList<Map<String,String>>();
			while(rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				
				map.put("pro_num", rs.getString("pro_num"));  //项目编号
				map.put("dept_name", rs.getString("dept_name"));  //部门名称
				map.put("ini_man", rs.getString("ini_man"));  //发起人
				map.put("ini_date", rs.getString("ini_date"));  //发起日期
				map.put("service_type", String.valueOf(rs.getInt("service_type")));  //业务类型
				map.put("brand", rs.getString("brand"));  //品牌
				map.put("car", rs.getString("car"));  //车型
				map.put("promo_area", rs.getString("promo_area"));  //推广区域
				map.put("promo_prov", rs.getInt("promo_prov")+"");  //推广省份
				map.put("promo_city", rs.getInt("promo_city")+"");  //推广城市
				map.put("prov_name", rs.getString("prov_name"));  //省份名
				map.put("city_name", rs.getString("city_name"));  //城市名
				map.put("promo_start_date", rs.getDate("promo_start_date").toString());  //项目开始时间
				map.put("promo_end_date", rs.getDate("promo_end_date").toString());  //项目开始时间
				map.put("custom_service", rs.getString("custom_service"));  //责任客服
				if (rs.getString("promo_man") == null) {
					map.put("promo_man", "");  //责任推广人员
				}else {
					map.put("promo_man", rs.getString("promo_man"));  //责任推广人员
				}
				map.put("pro_state", rs.getString("pro_state"));  //项目状态
				
				//用于在 modal 中显示数据
				map.put("contact_num", rs.getString("contact_num"));
				map.put("cust_name", rs.getString("cust_name"));
				map.put("contact_start_date", rs.getDate("contact_start_date").toString());
				map.put("contact_end_date", rs.getDate("contact_end_date").toString());
				map.put("acti_start_date", rs.getDate("acti_start_date").toString());
				if (rs.getDate("acti_end_date")==null) {
					map.put("acti_end_date", "");
				}else {
					map.put("acti_end_date", rs.getDate("acti_end_date").toString());
				}
				map.put("tar_clue_num", String.valueOf(rs.getInt("tar_clue_num")));
				map.put("tar_reach_num", String.valueOf(rs.getInt("tar_reach_num")));
				map.put("tar_trans_num", String.valueOf(rs.getInt("tar_trans_num")));
				resultList.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultList;
	}
	
	
	public Map getBlProjectInfoForDir(String pro_num) {
		
		Map<String,String> info = new HashMap<String,String>();
		DBConnect dbc = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sql = new StringBuffer();
		sql.append("select t1.*,t6.ORG_NAME,t7.DEP_NAME,t8.USER_NAME ini_man_name,t2.catalogname brand_name ,	");
		sql.append("	   t3.catalogname car_name,t9.catalogname model_name,t4.USER_NAME promo_man_name, 		");
		sql.append("	   t5.USER_NAME custom_service_name,t10.catalogname prov_name,t11.catalogname city_name ");
		sql.append("  from car_315.tb_data_project_bl t1 															");
		sql.append("  left join  car_315.dbo_car_catalognew t2 								 ");
		sql.append(" 	on t1.brand = t2.catalogid 											  						 ");
		sql.append("  left join car_315.dbo_car_catalognew t3														 ");
		sql.append("	on t1.car = t3.catalogid																	 ");
		sql.append("  left join finance.tb_fin_user t4																								 ");
		sql.append("    on t1.promo_man = t4.USER_CODE																				 ");
		sql.append("  left join finance.tb_fin_user t5																				 ");
		sql.append("    on t1.custom_service = t5.USER_CODE 																				 ");
		sql.append("  left join finance.tb_fin_org t6																				 ");
		sql.append("    on t1.ini_org = t6.ORG_ID																				 ");
		sql.append("  left join finance.tb_fin_dep t7																				 ");
		sql.append("    on t1.ini_dept = t7.DEP_ID																				 ");
		sql.append("  left join finance.tb_fin_user t8																				 ");
		sql.append("    on t1.ini_man = t8.USER_CODE 																				 ");
		sql.append("  left join car_315.dbo_car_catalognew t9																			 ");
		sql.append("    on t1.model = t9.catalogid 																				 ");
		sql.append("  left join car_315.dbo_are_catalog t10																			 ");
		sql.append("    on t1.promo_prov = t10.catalogid 																				 ");
		sql.append("  left join car_315.dbo_are_catalog t11																			 ");
		sql.append("    on t1.promo_city = t11.catalogid 																				 ");
		sql.append("    where t1.pro_num=?																				 ");
		System.out.println(sql.toString());
		try {
			dbc = new DBConnect(sql.toString());
			dbc.setString(1, pro_num);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				info.put("pro_num", rs.getString("pro_num"));
				info.put("ini_man", rs.getString("ini_man"));
				info.put("ini_dept", rs.getString("ini_dept"));
				info.put("ini_org", rs.getString("ini_org"));
				info.put("ini_date", sdf.format(rs.getTimestamp("ini_date")));
				info.put("service_type", rs.getInt("service_type")+"");
				info.put("contact_num", rs.getString("contact_num"));
				info.put("acti_name", rs.getString("acti_name"));
				info.put("brand", rs.getInt("brand")+"");
				info.put("car",rs.getInt("car")+"");
				info.put("model",rs.getInt("model")+"");
				int promo_prov =  rs.getInt("promo_prov");
				String prov_name = rs.getString("prov_name");
				prov_name = prov_name==null?"":prov_name;
				String city_name = rs.getString("city_name");
				city_name = city_name==null?"":city_name;
				String promo_area = "";
				if(promo_prov!=-1){
					promo_area = prov_name+city_name;
				}else{
					promo_area = "全国";
				}
				info.put("promo_area",promo_area);
				info.put("promo_prov",rs.getInt("promo_prov")+"");
				info.put("promo_city",rs.getInt("promo_city")+"" );
				info.put("promo_start_date", sdf.format(rs.getTimestamp("promo_start_date")));
				info.put("promo_end_date", sdf.format(rs.getTimestamp("promo_end_date")));
				info.put("contact_start_date", sdf.format(rs.getTimestamp("contact_start_date")));
				info.put("contact_end_date", sdf.format(rs.getTimestamp("contact_end_date")));
				info.put("acti_start_date", sdf.format(rs.getTimestamp("acti_start_date")));
				info.put("acti_end_date", sdf.format(rs.getTimestamp("acti_end_date")));
				info.put("cust_name", rs.getString("cust_name"));
				info.put("tar_clue_num", rs.getInt("tar_clue_num")+"");
				info.put("tar_reach_num", rs.getInt("tar_reach_num")+"");
				info.put("tar_trans_num", rs.getInt("tar_trans_num")+"");
				info.put("custom_service", rs.getString("custom_service"));
				info.put("pro_state", rs.getInt("pro_state")+"");
				info.put("car_name", rs.getString("car_name"));
				info.put("brand_name", rs.getString("brand_name"));
				info.put("model_name", rs.getString("model_name"));
				info.put("custom_service_name", rs.getString("custom_service_name"));
				info.put("promo_man_name", rs.getString("promo_man_name"));
				info.put("org_name", rs.getString("ORG_NAME"));
				info.put("dep_name", rs.getString("DEP_NAME"));
				String competing_name = rs.getString("competing_name");
				competing_name = competing_name==null?"":competing_name;
				info.put("ini_man_name", rs.getString("ini_man_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return info;
	}
	
	public int examineYesForBl(String pro_num) {
		int result = EXECUTE_FAIL;
		
		String sql = "UPDATE car_315.tb_data_project t1, car_315.tb_data_project_bl t2 "
					+ "SET t1.service_type=t2.service_type, "
						+ "t1.contact_num=t2.contact_num, "
						+ "t1.acti_name=t2.acti_name, "
						+ "t1.brand=t2.brand, "
						+ "t1.car=t2.car, "
						+ "t1.model=t2.model, "
						+ "t1.promo_area=t2.promo_area, "
						+ "t1.promo_prov=t2.promo_prov, "
						+ "t1.promo_city=t2.promo_city, "
						+ "t1.promo_start_date=t2.promo_start_date, "
						+ "t1.promo_end_date=t2.promo_end_date, "
						+ "t1.contact_start_date=t2.contact_start_date, "
						+ "t1.contact_end_date=t2.contact_end_date, "
						+ "t1.acti_start_date=t2.acti_start_date, "
						+ "t1.acti_end_date=t2.acti_end_date, "
						+ "t1.cust_name=t2.cust_name, "
						+ "t1.tar_clue_num=t2.tar_clue_num, "
						+ "t1.tar_reach_num=t2.tar_reach_num, "
						+ "t1.tar_trans_num=t2.tar_trans_num, "
						+ "t1.custom_service=t2.custom_service, "
						+ "t1.competing=t2.competing, "
						+ "t1.data_source=t2.data_source, "
						+ "t1.custom_service_name=t2.custom_service_name, "
						+ "t1.competing_name=t2.competing_name, "
						+ "t1.data_source_name=t2.data_source_name, "
						+ "t1.pro_state=3, "
						+ "t2.pro_state=3 "
					+ "WHERE t1.pro_num = '"+ pro_num +"' AND t2.pro_num = '"+ pro_num +"'";
		System.out.println(sql);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public Map<String, String> getProjectInfoForPromoByProNum(String pro_num) {
		
		Map<String, String> resultMap = null;
		
		String sql = "select t1.pro_num, t1.acti_name, t2.DEP_NAME dept_name, t3.USER_NAME ini_man, t1.ini_date, t1.service_type, t1.custom_service, t1.custom_service_name, "
					+ "t1.brand, IFNULL(t1.iway,'') iway, t1.car, t1.model, t6.catalogname brand_name, t7.catalogname car_name, t12.catalogname model_name, "
					+ "t1.promo_area, t1.promo_prov, t9.catalogname prov_name, t1.promo_city, t10.catalogname city_name, t1.promo_start_date, t1.promo_end_date, "
					+ "t5.USER_NAME promo_man, t1.pro_state, t1.contact_num, "
					+ "t1.cust_name, t1.contact_start_date, t1.contact_end_date, t1.acti_start_date, t1.acti_end_date, "
					+ "t1.tar_clue_num, t1.tar_reach_num, t1.tar_trans_num, t1.competing, t1.competing_name, "
					+ "COUNT(t8.promo_id) method_count, COUNT(DISTINCT(t11.phone)) AS baoming_count, COUNT(DISTINCT(t13.record_id)) AS visit_count "
			+ "from car_315.tb_data_project t1 "
					+ "LEFT JOIN finance.tb_fin_dep t2 ON t1.ini_dept=t2.DEP_ID "   //部门
					+ "LEFT JOIN finance.tb_fin_user t3 ON t1.ini_man=t3.USER_CODE  "  //发起人
//					+ "LEFT JOIN finance.tb_fin_user t4 ON t1.custom_service=t4.USER_CODE "  //责任客服
					+ "LEFT JOIN finance.tb_fin_user t5 ON t1.promo_man=t5.USER_CODE "  //推广人
					+ "LEFT JOIN car_315.dbo_car_catalognew t6 ON t1.brand=t6.catalogid "  //品牌
					+ "LEFT JOIN car_315.dbo_car_catalognew t7 ON t1.car=t7.catalogid "  //车系
					+ "LEFT JOIN car_315.dbo_car_catalognew t12 ON t1.model=t12.catalogid "  //车系
					+ "LEFT JOIN car_315.tb_data_promo_method t8 ON t1.pro_num=t8.pro_num "  //推广方案
					+ "LEFT JOIN car_315.dbo_are_catalog t9 ON t1.promo_prov=t9.catalogid "  //省份
					+ "LEFT JOIN car_315.dbo_are_catalog t10 ON t1.promo_city=t10.catalogid " //城市
					+ "LEFT JOIN tb_data_baoming t11 ON TO_DAYS(t11.baoming_date)>=TO_DAYS(t1.promo_start_date) AND TO_DAYS(t11.baoming_date)<=TO_DAYS(t1.promo_end_date) "
							+ "AND t1.promo_prov=(CASE WHEN t1.promo_prov!=-1 THEN t11.prov ELSE -1 END) "
							+ "AND t1.promo_city=(CASE WHEN t1.promo_city!=-1 THEN t11.city ELSE -1 END) "
							+ "AND t1.brand=(CASE WHEN t1.brand!=-1 THEN t11.brand ELSE -1 END) "
							+ "AND t1.car=(CASE WHEN t1.car!=-1 THEN t11.serial ELSE -1 END) "
							+ "AND t1.model=(CASE WHEN t1.model!=-1 THEN t11.model ELSE -1 END) " //报名量
					+ "LEFT JOIN car_315.tb_data_visit_record t13 ON t1.pro_num=t13.pro_num AND t13.is_invite=1 " //客服记录表    COUNT(DISTINCT(t13.record_id)) AS visit_count
			+ "WHERE t1.pro_num='"+ pro_num +"' "
			+ "GROUP BY t1.pro_num ";
		System.out.println(sql);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				resultMap = new HashMap<String, String>();
				
				resultMap.put("pro_num", rs.getString("pro_num"));  //项目编号
				resultMap.put("acti_name", rs.getString("acti_name")); //活动名称
				resultMap.put("dept_name", rs.getString("dept_name"));  //部门名称
				resultMap.put("ini_man", rs.getString("ini_man"));  //发起人
				resultMap.put("ini_date", rs.getString("ini_date"));  //发起日期
				resultMap.put("service_type", String.valueOf(rs.getInt("service_type")));  //业务类型
				resultMap.put("brand", rs.getInt("brand")+"");  //品牌
				resultMap.put("car", rs.getInt("car")+"");  //车系
				resultMap.put("model", rs.getInt("model")+"");  //车型
				resultMap.put("brand_name", rs.getString("brand_name"));  //品牌名称
				resultMap.put("iway", rs.getString("iway"));  //渠道
				resultMap.put("car_name", rs.getString("car_name"));  //车系名称
				resultMap.put("model_name", rs.getString("model_name"));  //车型名称
			//	resultMap.put("promo_area", rs.getString("promo_area"));  //推广区域
				resultMap.put("promo_prov", rs.getInt("promo_prov")+"");
				resultMap.put("promo_city", rs.getInt("promo_city")+"");
				resultMap.put("prov_name", rs.getString("prov_name"));
				resultMap.put("city_name", rs.getString("city_name"));
				resultMap.put("promo_start_date", sdf.format(rs.getDate("promo_start_date")));  //项目开始时间
				resultMap.put("promo_end_date", sdf.format(rs.getDate("promo_end_date")));  //项目开始时间
				resultMap.put("custom_service", rs.getString("custom_service"));  //责任客服
				resultMap.put("custom_service_name", rs.getString("custom_service_name"));  //责任客服
//				resultMap.put("method_count", rs.getString("method_count"));  //推广发难数量
				if (rs.getString("promo_man") == null) {
					resultMap.put("promo_man", "");  //责任推广人员
				}else {
					resultMap.put("promo_man", rs.getString("promo_man"));  //责任推广人员
				}
				resultMap.put("pro_state", rs.getString("pro_state"));  //项目状态
				
				//用于在 modal 中显示数据
				resultMap.put("contact_num", rs.getString("contact_num"));
				resultMap.put("cust_name", rs.getString("cust_name"));
				resultMap.put("contact_start_date", sdf.format(rs.getDate("contact_start_date")));
				resultMap.put("contact_end_date", sdf.format(rs.getDate("contact_end_date")));
				resultMap.put("acti_start_date", sdf.format(rs.getDate("acti_start_date")));
				resultMap.put("acti_end_date", sdf.format(rs.getDate("acti_end_date")));
				resultMap.put("tar_clue_num", String.valueOf(rs.getString("tar_clue_num")));
				resultMap.put("tar_reach_num", String.valueOf(rs.getString("tar_reach_num")));
				resultMap.put("tar_trans_num", String.valueOf(rs.getString("tar_trans_num")));
				
				resultMap.put("competing", "competing");
				resultMap.put("competing_name", rs.getString("competing_name"));
				
				resultMap.put("baoming_count", rs.getInt("baoming_count")+"");
				resultMap.put("visit_count", rs.getInt("visit_count")+"");
				
				int bmcount = rs.getInt("baoming_count");
				int vscount = rs.getInt("visit_count");
				String vsrate = "0";
				if (bmcount!=0) {
					vsrate = (vscount/bmcount*10000)/100.00 + "%";
				}
				
				resultMap.put("baoming_count", rs.getInt("baoming_count")+"");
				resultMap.put("visit_count", rs.getInt("visit_count")+"");
				resultMap.put("visit_rate", vsrate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return resultMap;
	}
	public List<Map<String, String>> getProjectForServiceExamine(String userid,Map<String, String> orgAndDep) {
		String org = orgAndDep.get("org_code");
		String dept = orgAndDep.get("dep_code");
		List<Map<String, String>> resultList= new ArrayList<Map<String,String>>();;
		String sql1 = "select t1.pro_num, t2.DEP_NAME dept_name, t3.USER_NAME ini_man, t1.ini_date, t1.service_type, "
				+ "t1.brand, t1.car, t1.model , t6.catalogname brand_name, t7.catalogname car_name, t11.catalogname model_name, "
				+ "t1.promo_area, t1.promo_prov, t9.catalogname prov_name, t1.promo_city, t10.catalogname city_name, "
				+ "t1.promo_start_date, t1.promo_end_date, t1.custom_service_name custom_service, t5.USER_NAME promo_man, "
				+ "t1.contact_num, t1.cust_name, t1.contact_start_date, t1.contact_end_date, t1.acti_start_date, t1.acti_end_date, t1.tar_clue_num, "
				+ "t1.tar_reach_num, t1.tar_trans_num, t1.pro_state ,0 is_bl,t1.acti_name  "
				+ "from car_315.tb_data_project t1 "
				+ "LEFT JOIN finance.tb_fin_dep t2 ON t1.ini_dept=t2.DEP_ID "   //部门
				+ "LEFT JOIN finance.tb_fin_user t3 ON t1.ini_man=t3.USER_CODE  "  //发起人
				+ "LEFT JOIN finance.tb_fin_user t5 ON t1.promo_man=t5.USER_CODE "  //推广人
				+ "LEFT JOIN car_315.dbo_car_catalognew t6 ON t1.brand=t6.catalogid "  //品牌
				+ "LEFT JOIN car_315.dbo_car_catalognew t7 ON t1.car=t7.catalogid "  //车系
				+ "LEFT JOIN car_315.dbo_car_catalognew t11 ON t1.model=t11.catalogid "  //车系
				+ "LEFT JOIN finance.tb_fin_user t8 ON t1.ini_org=t8.ORG_CODE ";  //部门对应的机构（分站）
		if("1".equals(org)){
			sql1 = sql1+"and t1.ini_dept = t8.DEPT_CODE ";
		}
		sql1 = sql1+ "LEFT JOIN car_315.dbo_are_catalog t9 ON t1.promo_prov=t9.catalogid "  //省份
				+ "LEFT JOIN car_315.dbo_are_catalog t10 ON t1.promo_city=t10.catalogid " //城市
				+ "where t8.USER_CODE='" + userid + "' AND t1.pro_state=0 ";
		String sql2 = "select t1.pro_num, t2.DEP_NAME dept_name, t3.USER_NAME ini_man, t1.ini_date, t1.service_type, "
				+ "t1.brand, t1.car, t1.model , t6.catalogname brand_name, t7.catalogname car_name, t11.catalogname model_name, "
				+ "t1.promo_area, t1.promo_prov, t9.catalogname prov_name, t1.promo_city, t10.catalogname city_name, "
				+ "t1.promo_start_date, t1.promo_end_date, t1.custom_service_name custom_service, t5.USER_NAME promo_man, "
				+ "t1.contact_num, t1.cust_name, t1.contact_start_date, t1.contact_end_date, t1.acti_start_date, t1.acti_end_date, t1.tar_clue_num, "
				+ "t1.tar_reach_num, t1.tar_trans_num, t1.pro_state ,1 is_bl ,t1.acti_name "
				+ "from car_315.tb_data_project_bl t1 "
				+ "LEFT JOIN finance.tb_fin_dep t2 ON t1.ini_dept=t2.DEP_ID "   //部门
				+ "LEFT JOIN finance.tb_fin_user t3 ON t1.ini_man=t3.USER_CODE  "  //发起人
				+ "LEFT JOIN finance.tb_fin_user t5 ON t1.promo_man=t5.USER_CODE "  //推广人
				+ "LEFT JOIN car_315.dbo_car_catalognew t6 ON t1.brand=t6.catalogid "  //品牌
				+ "LEFT JOIN car_315.dbo_car_catalognew t7 ON t1.car=t7.catalogid "  //车系
				+ "LEFT JOIN car_315.dbo_car_catalognew t11 ON t1.model=t11.catalogid "  //车系
				+ "LEFT JOIN finance.tb_fin_user t8 ON t1.ini_org=t8.ORG_CODE ";  //部门对应的机构（分站）
		if("1".equals(org)){
			sql2 = sql2+"and t1.ini_dept = t8.DEPT_CODE ";
		}
		sql2 = sql2+ "LEFT JOIN car_315.dbo_are_catalog t9 ON t1.promo_prov=t9.catalogid "  //省份
				+ "LEFT JOIN car_315.dbo_are_catalog t10 ON t1.promo_city=t10.catalogid " //城市
				+ "where t8.USER_CODE='" + userid + "' AND t1.pro_state=0 ";
		String sql = "select t.* from ("+sql2 + " union  "+ sql1+") t  order by t.is_bl desc ,t.ini_date DESC ";
		System.out.println(sql);
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("is_bl", rs.getInt("is_bl") + "");
				map.put("pro_num", rs.getString("pro_num"));  //项目编号
				map.put("dept_name", rs.getString("dept_name"));  //部门名称
				map.put("acti_name", rs.getString("acti_name"));  //部门名称
				map.put("ini_man", rs.getString("ini_man"));  //发起人
				map.put("ini_date", rs.getString("ini_date"));  //发起日期
				map.put("service_type", String.valueOf(rs.getInt("service_type")));  //业务类型
				map.put("brand", rs.getInt("brand") + "");  //品牌
				map.put("car", rs.getInt("car") + "");  //车型
				map.put("model", rs.getInt("model") + "");  //车型
				map.put("brand_name", rs.getString("brand_name"));  //品牌
				map.put("car_name", rs.getString("car_name"));  //车型
				map.put("model_name", rs.getString("model_name"));  //车型
				map.put("promo_area", rs.getString("promo_area"));  //推广区域
				map.put("promo_prov", rs.getInt("promo_prov")+"");  //推广省份
				map.put("promo_city", rs.getInt("promo_city")+"");  //推广城市
				map.put("prov_name", rs.getString("prov_name"));  //省份名
				map.put("city_name", rs.getString("city_name"));  //城市名
				map.put("promo_start_date", rs.getDate("promo_start_date").toString());  //项目开始时间
				map.put("promo_end_date", rs.getDate("promo_end_date").toString());  //项目开始时间
				map.put("custom_service", rs.getString("custom_service"));  //责任客服
				if (rs.getString("promo_man") == null) {
					map.put("promo_man", "");  //责任推广人员
				}else {
					map.put("promo_man", rs.getString("promo_man"));  //责任推广人员
				}
				map.put("pro_state", rs.getString("pro_state"));  //项目状态
				
				//用于在 modal 中显示数据
				map.put("contact_num", rs.getString("contact_num"));
				map.put("cust_name", rs.getString("cust_name"));
				map.put("contact_start_date", rs.getDate("contact_start_date").toString());
				map.put("contact_end_date", rs.getDate("contact_end_date").toString());
				map.put("acti_start_date", rs.getDate("acti_start_date").toString());
				if (rs.getDate("acti_end_date")==null) {
					map.put("acti_end_date", "");
				}else {
					map.put("acti_end_date", rs.getDate("acti_end_date").toString());
				}
				map.put("tar_clue_num", String.valueOf(rs.getInt("tar_clue_num")));
				map.put("tar_reach_num", String.valueOf(rs.getInt("tar_reach_num")));
				map.put("tar_trans_num", String.valueOf(rs.getInt("tar_trans_num")));
				resultList.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultList;
	}
	public Map<String, Integer> getDataByProNum(String pro_num) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select * FROM ");
		sql.append("		( select count(*) invite				");
		sql.append("			from tb_data_visit_record t1		");
		sql.append("		   where t1.is_invite=1					");
		sql.append("			 and t1.pro_num=?					");
		sql.append("		) invite,								");
		sql.append("		( select count(*) reach					");
		sql.append("			from tb_data_visit_record t2		");
		sql.append("		   where t2.is_invite=1					");
		sql.append("			 and t2.is_reach=1					");
		sql.append("			 and t2.pro_num=?					");
		sql.append("		) reach,								");
		sql.append("		( select count(*) trans					");
		sql.append("		    from tb_data_visit_record t3		");
		sql.append("		   where t3.is_invite=1					");
		sql.append("			 and t3.is_reach=1					");
		sql.append("			 and t3.is_trans=1					");
		sql.append("			 and t3.pro_num=?					");
		sql.append("		) trans,								");
		sql.append("		( select count(*) notInvite				");
		sql.append("			from tb_data_visit_record t1		");
		sql.append("		   where t1.is_invite=0					");
		sql.append("			 and t1.pro_num=?					");
		sql.append("		) notInvite								");
		DBConnect dbc = null;
		Map<String,Integer> data = new HashMap<String,Integer>();
		try {
			dbc = new DBConnect(sql.toString());
			dbc.setString(1, pro_num);
			dbc.setString(2, pro_num);
			dbc.setString(3, pro_num);
			dbc.setString(4, pro_num);
			ResultSet rs = dbc.executeQuery();
			if(rs.next()) {
				data.put("invite", rs.getInt("invite"));
				data.put("reach", rs.getInt("reach"));
				data.put("trans", rs.getInt("trans"));
				data.put("notInvite", rs.getInt("notInvite"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	public List<Map<String, String>> getQtProjects(String orgCode) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sql = new StringBuffer();
		sql.append("select t1.*,t6.ORG_NAME,t7.DEP_NAME,t8.USER_NAME ini_man_name,t2.catalogname brand_name ,	");
		sql.append("	   t3.catalogname car_name,t9.catalogname model_name,t4.USER_NAME promo_man_name,t1.iway,		");
		sql.append("	   t5.USER_NAME custom_service_name,t10.catalogname prov_name,t11.catalogname city_name ");
		sql.append("  from car_315.tb_data_project t1 															");
		sql.append("  left join  car_315.dbo_car_catalognew t2 								 ");
		sql.append(" 	on t1.brand = t2.catalogid 											  						 ");
		sql.append("  left join car_315.dbo_car_catalognew t3														 ");
		sql.append("	on t1.car = t3.catalogid																	 ");
		sql.append("  left join finance.tb_fin_user t4																								 ");
		sql.append("    on t1.promo_man = t4.USER_CODE																				 ");
		sql.append("  left join finance.tb_fin_user t5																				 ");
		sql.append("    on t1.custom_service = t5.USER_CODE 																				 ");
		sql.append("  left join finance.tb_fin_org t6																				 ");
		sql.append("    on t1.ini_org = t6.ORG_ID																				 ");
		sql.append("  left join finance.tb_fin_dep t7																				 ");
		sql.append("    on t1.ini_dept = t7.DEP_ID																				 ");
		sql.append("  left join finance.tb_fin_user t8																				 ");
		sql.append("    on t1.ini_man = t8.USER_CODE 																				 ");
		sql.append("  left join car_315.dbo_car_catalognew t9																			 ");
		sql.append("    on t1.model = t9.catalogid 																				 ");
		sql.append("  left join car_315.dbo_are_catalog t10																			 ");
		sql.append("    on t1.promo_prov = t10.catalogid 																				 ");
		sql.append("  left join car_315.dbo_are_catalog t11																			 ");
		sql.append("    on t1.promo_city = t11.catalogid 																				 ");
		sql.append("    where t1.pro_state=100																				 ");
		sql.append("      and t1.service_type=5																				 ");
		sql.append("      and t1.ini_org=?																				 ");
		List<Map<String,String>> resultList = new ArrayList<Map<String,String>>();
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			dbc.setString(1, orgCode);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()) {
				Map<String,String> info = new HashMap<String,String>();
				info.put("pro_num", rs.getString("pro_num"));
				info.put("brand", rs.getInt("brand")+"");
				int promo_prov =  rs.getInt("promo_prov");
				String prov_name = rs.getString("prov_name");
				prov_name = prov_name==null?"":prov_name;
				String city_name = rs.getString("city_name");
				city_name = city_name==null?"":city_name;
				String promo_area = "";
				if(promo_prov!=-1){
					promo_area = prov_name+city_name;
				}else{
					promo_area = "全国";
				}
				info.put("promo_area",replaceNull(promo_area));
				info.put("promo_prov",replaceNull(rs.getInt("promo_prov")+""));
				info.put("promo_city",replaceNull(rs.getInt("promo_city")+"" ));
				info.put("promo_start_date", replaceNull(sdf.format(rs.getTimestamp("promo_start_date"))));
				info.put("promo_end_date", replaceNull(sdf.format(rs.getTimestamp("promo_end_date"))));
				info.put("custom_service", replaceNull(rs.getString("custom_service")));
				info.put("pro_state", replaceNull(rs.getInt("pro_state")+""));
				String brand_name = rs.getString("brand_name");
				info.put("brand_name",brand_name);
				info.put("iway",replaceNull(rs.getString("iway")));
				info.put("custom_service_name", replaceNull(rs.getString("custom_service_name")));
				info.put("competing_name", replaceNull(rs.getString("competing_name")));
				info.put("competing", replaceNull(rs.getString("competing")));
				info.put("competing_name", replaceNull(rs.getString("competing_name")));
				resultList.add(info);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultList;
	}
	public int getBrandIdByIway(String iway){
		String sql = "select  DISTINCT t.fatherid from  dbo_car_catalognew t where t.pathlevel=2 and t.iway=?";
		DBConnect dbc = null;
		int brandid = -1;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, iway);
			ResultSet rs = dbc.executeQuery();
			if(rs.next()){
				brandid = rs.getInt("fatherid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return brandid;
	}
	public Set<String> getIways_select_Qt(String org_code) {
		String sql = "select iway,competing from tb_data_project t where t.pro_num like 'QT%' and t.ini_org=?";
		DBConnect dbc = null;
		Set<String>iways = new HashSet<String>();
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, Integer.parseInt(org_code));
			ResultSet rs = dbc.executeQuery();
			while(rs.next()){
				String competings = rs.getString("competing");
				String iway = rs.getString("iway");
				String[] competingsArr = competings.split(",");
				for(String c:competingsArr){
					String competing = c.split("①")[0];
					iways.add(competing);
				}
				if(StringUtils.isNotEmpty(iway)){
					iways.add(iway);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return iways;
	}
	public List<Map<String, String>> getCountBaomingChannelList(String start,
			String end) {
		String sql = "select  real_type,count(phone) count from tb_data_baoming t  where 1=1  ";
		if(StringUtils.isNotEmpty(start)){
			sql = sql+"and t.baoming_date >= '"+start+"'" ;
		}
		if(StringUtils.isNotEmpty(end)){
			sql = sql + " and t.baoming_date <= '"+ end+" 23:59:59'";
		}
		sql +=" group by real_type";
		DBConnect dbc = null;
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()){
				int real_type = rs.getInt("real_type");
				int count = rs.getInt("count");
				Map<String,String> map = new HashMap<String,String>();
				map.put("real_type", real_type+"");
				map.put("count", count+"");
				list.add(map);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public Map<String,Map<String,String>> CountKF(String start,String end,String users){
		Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
		end += "23:59:59";
		String sql = "select t.userid,t.username,DATE_FORMAT(t.operate_time,'%Y-%m-%d') days ,count(DISTINCT t.baomingid) count from tb_data_baominglog t where t.operate_time <= '"+end+"' and t.operate_time >= '"+start+"' and t.userid in ("+users+") group by days,userid,username";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
//			dbc.setString(1, end);
//			dbc.setString(2, start);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()){
				String count = rs.getInt("count")+"";
				String userid = rs.getString("userid");
				String date = rs.getString("days");
				Map<String,String> map = data.get(date);
				if(map==null){
					map = new HashMap<String,String>();
				}
				map.put(userid, count);
				data.put(date,map);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	public static int deleteProject(String pro_num) {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		try {
			String sql = "update tb_data_project set pro_state=? where pro_num=?";
			dbc= new DBConnect(sql);
			dbc.setInt(1, 101);
			dbc.setString(2, pro_num);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
