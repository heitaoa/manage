package com.poly.dao.data;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.util.StringUtils;

import car_daos.DBConnect;
public class QiandaoDao{

	public List<Map<String, String>> findKctQiandaoListByPage(int page,
			int pagesize, String pro_num) {
		//String sql ="select t1.*,t2.gift_examine_state,t2.model model_trans,t2.addr,t2.giving_code,t2.giving_name, t2.sale_man from tb_data_qiandao t1 left join tb_data_trans_info t2 on t1.id = t2.qiandao_id where t1.pro_num=? order by t1.id limit ?,? ";
		StringBuffer sql = new StringBuffer();
		sql.append(" select t1.record_id,t1.pro_num,t1.baoming_id,t1.attend_type,t1.is_reach,	");
		sql.append(" 		t1.is_trans,t1.is_invite,t2.gift_examine_state,t2.model model_trans,");
		sql.append("		t2.giving_code,t2.giving_name, t2.sale_man,t1.name,t1.phone,t2.addr,");
		sql.append("		t2.trans_date														");
		sql.append("   from tb_data_visit_record t1												");
		sql.append("   left join tb_data_trans_info t2											");
		sql.append("	 on t1.record_id = t2.qiandao_id										");
		sql.append("  where t1.pro_num=?														");
		sql.append("  	and t1.attend_type in(1,2,3,4)											");
		sql.append("  order by t1.record_id 													");
		sql.append("  limit ?,? 																");
		int start = (page-1)*pagesize;
		DBConnect dbc = null;
		List<Map<String,String>> info = new ArrayList<Map<String,String>>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dbc = new DBConnect(sql.toString());
			dbc.setString(1, pro_num);
			dbc.setInt(2, start);
			dbc.setInt(3, pagesize);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()){
				Map<String,String> map = new HashMap<String,String>();
				map.put("pro_num", rs.getString("pro_num"));
				map.put("name", rs.getString("name"));
				map.put("phone", rs.getString("phone"));
				map.put("baoming_id", rs.getInt("baoming_id")+"");
				map.put("attend_type", rs.getInt("attend_type")+"");
				map.put("is_reach", rs.getInt("is_reach")+"");
				map.put("is_trans", rs.getInt("is_trans")+"");
				map.put("is_invite", rs.getInt("is_invite")+"");
				map.put("qiandao_id", rs.getInt("record_id")+"");
				map.put("model", rs.getInt("model_trans")+"");
				map.put("giving_code", rs.getString("giving_code"));
				map.put("giving_name", rs.getString("giving_name"));
				map.put("addr", rs.getString("addr"));
				map.put("sale_man", rs.getString("sale_man"));
				map.put("trans_date", rs.getDate("trans_date")==null?null:sdf.format(rs.getDate("trans_date")));
				map.put("gift_examine_state", rs.getInt("gift_examine_state")+"");
				info.add(map);
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
	public List<Map<String, String>> findKctQiandaoListForViewByPage(int page,
			int pagesize, String pro_num) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select t1.record_id,t1.pro_num,t1.baoming_id,t1.attend_type,				");
		sql.append("		t1.name,t1.phone,t1.baoming_date,t4.catalogname prov_name,t1.ip,	");
		sql.append("		t5.catalogname city_name,t1.is_key_cus,t1.buycar_emergency,			");
		sql.append("		t6.catalogname brand_name,t7.catalogname serial_name,t1.buy_state, 	");
		sql.append("		t8.catalogname pz_city_name,t1.buy_ys								");
		sql.append("   from tb_data_visit_record t1												");
		sql.append("   left join dbo_are_catalog t4												");
		sql.append("	 on t1.prov = t4.catalogid												");
		sql.append("   left join dbo_are_catalog t5												");
		sql.append("	 on t1.city = t5.catalogid												");
		sql.append("   left join dbo_car_catalognew t6											");
		sql.append("	 on t1.brand = t6.catalogid												");
		sql.append("   left join dbo_car_catalognew t7											");
		sql.append("	 on t1.serial = t7.catalogid											");
		sql.append("   left join dbo_are_catalog t8												");
		sql.append("	 on t1.pz_city = t8.catalogid											");
		sql.append("  where t1.pro_num=?														");
		sql.append("  	and t1.attend_type in(1,2,3,4)											");
		sql.append("  order by t1.return_visit_time desc 										");
		sql.append("  limit ?,? 																");
		int start = (page-1)*pagesize;
		DBConnect dbc = null;
		List<Map<String,String>> info = new ArrayList<Map<String,String>>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sql);
		try {
			dbc = new DBConnect(sql.toString());
			dbc.setString(1, pro_num);
			dbc.setInt(2, start);
			dbc.setInt(3, pagesize);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()){
				Map<String,String> map = new HashMap<String,String>();
				map.put("record_id", rs.getInt("record_id")+"");
				map.put("pro_num", rs.getString("pro_num"));
				map.put("name", rs.getString("name"));
				map.put("phone", rs.getString("phone"));
				map.put("baoming_id", rs.getInt("baoming_id")+"");
				map.put("is_key_cus", rs.getInt("is_key_cus")+"");
				map.put("buycar_emergency", rs.getInt("buycar_emergency")+"");
				map.put("buy_state", rs.getInt("buy_state")+"");
				map.put("attend_type", rs.getInt("attend_type")+"");
				map.put("buy_state", rs.getInt("buy_state")+"");
				Date baoming_date = rs.getDate("baoming_date");
				map.put("baoming_date", baoming_date==null?null:sdf.format(baoming_date));
				map.put("prov_name", rs.getString("prov_name"));
				map.put("ip", rs.getString("ip"));
				map.put("city_name", rs.getString("city_name"));
				map.put("brand_name", rs.getString("brand_name"));
				map.put("serial_name", rs.getString("serial_name"));
				map.put("pz_city_name", rs.getString("pz_city_name"));
				map.put("buy_ys", rs.getString("buy_ys"));
				info.add(map);
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
	
	public void saveNotInvite(Map<String, String> map) throws Exception {
		String name= map.get("name");
		String phone= map.get("phone");
		String is_reach= map.get("is_reach");
		String is_trans= map.get("is_trans");
		String is_invite= map.get("is_invite");
		String model= map.get("model");
		String giving_code= map.get("giving_code");
		String addr= map.get("addr");
		String giving_name= map.get("giving_name");
		String sale_man= map.get("sale_man");
		String pro_num= map.get("pro_num");
		String trans_date= map.get("trans_date");
		Double totalPrice = new Double(0);
		String[]a = giving_code.split(",");
		String sql = "";
		if("1".equals(is_trans)){
			DBConnect dbc = new DBConnect();
			dbc.setAutoCommit(false);
			try {
				for(int i=0;i<a.length;i++){
					String[] b = a[i].split("-");
					String code = b[0];
					String value= b[1];
					if("0".equals(code)){
						sql = "select gift_price from tb_data_gift where gift_id = ?";
					}else{
						sql = "select sum(t2.gift_price) from tb_data_packgift t1,tb_data_gift t2 where t1.gift_id = t2.gift_id and t1.package_id = ?";
					}
					dbc.prepareStatement(sql);
					dbc.setInt(1, Integer.parseInt(value));
					ResultSet rs = dbc.executeQuery();
					if(rs.next()){
						totalPrice =totalPrice+ rs.getDouble(1);
					}
				}
				sql = "insert into tb_data_visit_record (name,phone,is_reach,is_trans,is_invite,pro_num,attend_type) values(?,?,?,?,?,?,?)";
				dbc.prepareStatement(sql);
				dbc.setString(1, name);
				dbc.setString(2, phone);
				dbc.setInt(3, Integer.parseInt(is_reach));
				dbc.setInt(4, Integer.parseInt(is_trans));
				dbc.setInt(5, Integer.parseInt(is_invite));
				dbc.setString(6, pro_num);
				dbc.setInt(7, 1);
				dbc.executeUpdate();
				sql = "select last_insert_id();";
				dbc.prepareStatement(sql);
				ResultSet rs = dbc.executeQuery();
				int id=0;
				if(rs.next()){
					id = rs.getInt(1);
				}
				sql = "insert into tb_data_trans_info (qiandao_id,pro_num,name,phone,addr,model,sale_man,giving_code,giving_name,giving_total_price,trans_date)values(?,?,?,?,?,?,?,?,?,?,?)";
				dbc.prepareStatement(sql);
				dbc.setInt(1, id);
				dbc.setString(2, pro_num);
				dbc.setString(3, name);
				dbc.setString(4, phone);
				dbc.setString(5, addr);
				dbc.setInt(6, Integer.parseInt(model));
				dbc.setString(7, sale_man);
				dbc.setString(8, giving_code);
				dbc.setString(9, giving_name);
				dbc.setString(10, totalPrice.toString());
				dbc.setDate(11, new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(trans_date).getTime()));
				dbc.executeUpdate();
				dbc.commit();
			} catch (Exception e) {
				e.printStackTrace();
				dbc.rollback();
			} finally {
				try {
					if (dbc != null)
						dbc.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public void saveInvite(Map<String, String> map) throws Exception {
		String qiandao_id= map.get("qiandao_id");
		String name= map.get("name");
		String phone= map.get("phone");
		String is_reach= map.get("is_reach");
		String is_trans= map.get("is_trans");
		String is_invite= map.get("is_invite");
		String model= map.get("model");
		String giving_code= map.get("giving_code");
		String addr= map.get("addr");
		String giving_name= map.get("giving_name");
		String sale_man= map.get("sale_man");
		String pro_num= map.get("pro_num");
		String trans_date= map.get("trans_date");
		DBConnect dbc = new DBConnect();
		String[]a = giving_code.split(",");
		String sql = "";
		Double totalPrice = new Double(0);
		dbc.setAutoCommit(false);
		
		try {
			if(!"".equals(a[0])){
				for(String g:a){
					String[] b = g.split("-");
					String code = b[0];
					String value= b[1];
					if("0".equals(code)){
						sql = "select gift_price from tb_data_gift where gift_id = ?";
					}else{
						sql = "select sum(t2.gift_price) from tb_data_packgift t1,tb_data_gift t2 where t1.gift_id = t2.gift_id and t1.package_id = ?";
					}
					dbc.prepareStatement(sql);
					dbc.setInt(1, Integer.parseInt(value));
					ResultSet rs = dbc.executeQuery();
					if(rs.next()){
						totalPrice =totalPrice+ rs.getDouble(1);
					}
				}
			}
			sql = "update tb_data_visit_record set is_invite=? ,is_reach=? ,is_trans=? where record_id=?";
			dbc.prepareStatement(sql);
			dbc.setInt(1, Integer.parseInt(is_invite));
			dbc.setInt(2, Integer.parseInt(is_reach));
			dbc.setInt(3, Integer.parseInt(is_trans));
			dbc.setInt(4, Integer.parseInt(qiandao_id));
			dbc.executeUpdate();
			if("1".equals(is_trans)){
				sql = "select count(*) c from tb_data_trans_info where qiandao_id=? and pro_num=?";
				dbc.prepareStatement(sql);
				dbc.setInt(1, Integer.parseInt(qiandao_id));
				dbc.setString(2, pro_num);
				ResultSet rs = dbc.executeQuery();
				int c = 0;
				if(rs.next()){
					c = rs.getInt("c");
				}
				if(c>0){
					sql="update tb_data_trans_info set addr=? ,giving_code=? ,giving_name=? ,model=? ,sale_man=?,giving_total_price=? ,gift_examine_state=?,trans_date=? where qiandao_id=?";
					dbc.prepareStatement(sql);
					dbc.setString(1, addr);
					dbc.setString(2, giving_code);
					dbc.setString(3,giving_name);
					dbc.setInt(4, Integer.parseInt(model));
					dbc.setString(5, sale_man);
					dbc.setString(6, totalPrice.toString());
					dbc.setInt(7, 0);
					dbc.setDate(8, new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(trans_date).getTime()));
					dbc.setInt(9, Integer.parseInt(qiandao_id));
					dbc.executeUpdate();
				}else{
					sql = "insert into tb_data_trans_info (qiandao_id,name,phone,model,addr,giving_code,giving_name,sale_man,pro_num,giving_total_price,trans_date) values(?,?,?,?,?,?,?,?,?,?,?)";
					dbc.prepareStatement(sql);
					dbc.setInt(1, Integer.parseInt(qiandao_id));
					dbc.setString(2, name);
					dbc.setString(3, phone);
					dbc.setInt(4, Integer.parseInt(model));
					dbc.setString(5, addr);
					dbc.setString(6,giving_code);
					dbc.setString(7,giving_name);
					dbc.setString(8,sale_man);
					dbc.setString(9,pro_num);
					dbc.setString(10,totalPrice.toString());
					dbc.setDate(11, new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(trans_date).getTime()));
					dbc.executeUpdate();
				}
			}else{
				sql = "delete from tb_data_trans_info where pro_num=? and qiandao_id=?";
				dbc.prepareStatement(sql);
				dbc.setString(1, pro_num);
				dbc.setInt(2,Integer.parseInt(qiandao_id));
				dbc.executeUpdate();
			}
			
			dbc.commit();
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
	}

	public int getKctQiandaoTotalPage(int pagesize, String pro_num) {
		String sql="select count(*) from tb_data_visit_record where pro_num= ? and attend_type in(1,2,3,4)";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			dbc.setString(1, pro_num);
			ResultSet rs = dbc.executeQuery();
			rs.next();
			int rows = rs.getInt(1);
			if (rows % pagesize == 0) {
				return rows / pagesize;
			} else {
				return rows / pagesize + 1;
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

	public List<Map<String, String>> getQiandaoListByProNum(String pro_num) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select t1.record_id,t1.pro_num,t1.baoming_id,t1.attend_type,t1.is_reach,	");
		sql.append(" 		t1.is_trans,t1.is_invite,t2.gift_examine_state,t2.model model_trans,");
		sql.append("		t2.giving_code,t2.giving_name, t2.sale_man,t1.name,t1.phone,t2.addr,");
		sql.append("		t2.trans_date,t3.catalogname model_trans_name						");
		sql.append("   from tb_data_visit_record t1												");
		sql.append("   left join tb_data_trans_info t2											");
		sql.append("	 on t1.record_id = t2.qiandao_id										");
		sql.append("   left join dbo_car_catalognew t3											");
		sql.append("	 on t2.model = t3.catalogid										");
		sql.append("  where t1.pro_num=?														");
		sql.append("  	and t1.attend_type in(1,2,3,4)											");
		sql.append("  order by t2.gift_examine_state desc, t1.record_id 						");
		DBConnect dbc = null;
		List<Map<String,String>> info = new ArrayList<Map<String,String>>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dbc = new DBConnect(sql.toString());
			dbc.setString(1, pro_num);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()){
				Map<String,String> map = new HashMap<String,String>();
				map.put("pro_num", rs.getString("pro_num"));
				map.put("name", rs.getString("name"));
				map.put("phone", rs.getString("phone"));
				map.put("baoming_id", rs.getInt("baoming_id")+"");
				map.put("attend_type", rs.getInt("attend_type")+"");
				map.put("is_reach", rs.getInt("is_reach")+"");
				map.put("is_trans", rs.getInt("is_trans")+"");
				map.put("is_invite", rs.getInt("is_invite")+"");
				map.put("qiandao_id", rs.getInt("record_id")+"");
				map.put("model", rs.getInt("model_trans")+"");
				map.put("giving_code", rs.getString("giving_code"));
				map.put("giving_name", rs.getString("giving_name"));
				map.put("addr", rs.getString("addr"));
				map.put("model_trans_name", rs.getString("model_trans_name"));
				map.put("sale_man", rs.getString("sale_man"));
				map.put("trans_date", rs.getDate("trans_date")==null?null:sdf.format(rs.getDate("trans_date")));
				map.put("gift_examine_state", rs.getInt("gift_examine_state")+"");
				info.add(map);
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
	public Map<String, String> getQiandaoInfoByRecordId(int record_id) {
		Map<String,String> map = new HashMap<String,String>();
		StringBuffer sql = new StringBuffer();
		sql.append(" select t1.record_id,t1.pro_num,t1.attend_type,t1.know_yh,t1.jp_car,t1.p_job,	");
		sql.append(" 		t2.prov phone_prov_name,t2.city phone_city_name,t1.return_visit_content,");
		sql.append("		t1.name,t1.phone,t1.baoming_date,t4.catalogname prov_name,t1.ip,		");
		sql.append("		t5.catalogname city_name,t1.is_key_cus,t1.buycar_emergency,				");
		sql.append("		t6.catalogname brand_name,t7.catalogname serial_name,t1.buy_state, 		");
		sql.append("		t8.catalogname pz_city_name,t1.buy_ys,t1.p_weixin,t1.p_qq,t1.bz,		");
		sql.append("		t1.buy_bsx,t1.buy_color,t1.buy_pl,t1.require							");
		sql.append("   from tb_data_visit_record t1													");
		sql.append("   left join tb_dict_phone t2													");
		sql.append("	 on t1.phone like CONCAT(t2.phone_num,'%')								");
		sql.append("   left join dbo_are_catalog t4													");
		sql.append("	 on t1.prov = t4.catalogid													");
		sql.append("   left join dbo_are_catalog t5													");
		sql.append("	 on t1.city = t5.catalogid													");
		sql.append("   left join dbo_car_catalognew t6												");
		sql.append("	 on t1.brand = t6.catalogid													");
		sql.append("   left join dbo_car_catalognew t7												");
		sql.append("	 on t1.serial = t7.catalogid												");
		sql.append("   left join dbo_are_catalog t8													");
		sql.append("	 on t1.pz_city = t8.catalogid												");
		sql.append("  where t1.record_id=?															");
		DBConnect dbc = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sql);
		System.out.println(record_id);
		try {
			dbc = new DBConnect(sql.toString());
			dbc.setInt(1, record_id);
			ResultSet rs = dbc.executeQuery();
			if(rs.next()){
				map.put("record_id", rs.getInt("record_id")+"");
				map.put("pro_num", rs.getString("pro_num"));
				map.put("name", rs.getString("name"));
				map.put("phone", rs.getString("phone"));
				map.put("is_key_cus", rs.getInt("is_key_cus")+"");
				map.put("p_job", rs.getInt("p_job")+"");
				map.put("buycar_emergency", rs.getInt("buycar_emergency")+"");
				map.put("buy_state", rs.getInt("buy_state")+"");
				map.put("attend_type", rs.getInt("attend_type")+"");
				map.put("buy_state", rs.getInt("buy_state")+"");
				map.put("buy_bsx", rs.getInt("buy_bsx")+"");
				map.put("require", rs.getInt("require")+"");
				map.put("phone_prov_name", rs.getString("phone_prov_name"));
				map.put("phone_city_name", rs.getString("phone_city_name"));
				Date baoming_date = rs.getDate("baoming_date");
				map.put("baoming_date", baoming_date==null?null:sdf.format(baoming_date));
				map.put("prov_name", rs.getString("prov_name"));
				map.put("ip", rs.getString("ip"));
				map.put("city_name", rs.getString("city_name"));
				map.put("brand_name", rs.getString("brand_name"));
				map.put("serial_name", rs.getString("serial_name"));
				map.put("pz_city_name", rs.getString("pz_city_name"));
				map.put("buy_ys", rs.getString("buy_ys"));
				map.put("jp_car", rs.getString("jp_car"));
				map.put("p_weixin", rs.getString("p_weixin"));
				map.put("p_qq", rs.getString("p_qq"));
				map.put("bz", rs.getString("bz"));
				map.put("buy_color", rs.getString("buy_color"));
				map.put("buy_pl", rs.getString("buy_pl"));
				map.put("know_yh", rs.getString("know_yh"));
				map.put("return_visit_content", StringUtils.parseReturnVisitContent(rs.getString("return_visit_content")).replaceAll("<br>", " "));
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
		return map;
	}
	public List<Map<String, String>> getQiandaoListForDownLoad(String pro_num) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select t1.attend_type,t1.name,t1.phone,t2.catalogname 	serial,t1.return_visit_content ");
		sql.append("   from tb_data_visit_record t1												");
		sql.append("   left join dbo_car_catalognew t2											");
		sql.append("	 on t1.serial = t2.catalogid												");
		sql.append("  where t1.pro_num=?														");
		sql.append("  	and t1.attend_type in(1,2,3,4)											");
		DBConnect dbc = null;
		List<Map<String,String>> info = new ArrayList<Map<String,String>>();
		try {
			dbc = new DBConnect(sql.toString());
			dbc.setString(1, pro_num);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()){
				Map<String,String> map = new HashMap<String,String>();
				map.put("name", rs.getString("name"));
				map.put("phone", rs.getString("phone"));
				map.put("attend_type", rs.getInt("attend_type")+"");
				map.put("serial", rs.getString("serial"));
				map.put("return_visit_content", rs.getString("return_visit_content"));
				info.add(map);
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
		
	
}
