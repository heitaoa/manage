package com.poly.dao.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import car_beans.TbDataProject;
import car_daos.DBConnect;
import car_daos.TbDataBaomingDao;

public class BaomingDao extends TbDataBaomingDao {
	
	public int getKctBaomingTotalPage(int pagesize,TbDataProject project) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date startDate = project.getPromo_start_date();
		Date endDate = project.getPromo_end_date();
		int type = project.getService_type();
		int car = project.getCar();
		String sql = "select count(*) from tb_data_baoming where type = ? and baoming_date>=? and baoming_date<=? and serial =?";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			dbc.setInt(1, type);
			dbc.setDate(2,new java.sql.Date(startDate.getTime()));
			dbc.setDate(3,new java.sql.Date(endDate.getTime()));
			dbc.setInt(4, car);
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

	public List<Map<String,String>> findKctBaomingListByPage(int page, int pagesize,TbDataProject project) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date startDate = project.getPromo_start_date();
		Date endDate = project.getPromo_end_date();
		int type = project.getService_type();
		int car = project.getCar();
		List<Map<String,String>> info = new ArrayList<Map<String,String>>();
		String sql = "select t1.*,t2.model model_trans,t2.addr,t2.giving_code,t2.giving_name, t2.sale_man from tb_data_baoming t1 left join tb_data_trans_info t2 on t1.id=t2.baoming_id where t1.type = ? and t1.baoming_date>=? and t1.baoming_date<=?  and t1.serial =? order by t1.id limit ?,?";
		int start = (page-1)*pagesize;
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, type);
			dbc.setDate(2,new java.sql.Date(startDate.getTime()));
			dbc.setDate(3,new java.sql.Date(endDate.getTime()));
			dbc.setInt(4, car);
			dbc.setInt(5, start);
			dbc.setInt(6, pagesize);
			ResultSet rs = dbc.executeQuery();
			while(rs.next()){
				Map<String,String> map = new HashMap<String,String>();
				map.put("name", rs.getString("name"));
				map.put("phone", rs.getString("phone"));
				map.put("is_reach", rs.getInt("is_reach")+"");
				map.put("is_trans", rs.getInt("is_trans")+"");
				map.put("is_invite", rs.getInt("is_invite")+"");
				map.put("baoming_id", rs.getInt("id")+"");
				map.put("model", rs.getInt("model_trans")+"");
				map.put("giving_code", rs.getString("giving_code"));
				map.put("giving_name", rs.getString("giving_name"));
				map.put("addr", rs.getString("addr"));
				map.put("sale_man", rs.getString("sale_man"));
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
				Date baomingDate = null;
				int type = -1;
				int car = -1;
				
				sql = "select * from tb_data_project where pro_num=?";
				dbc.prepareStatement(sql);
				dbc.setString(1, pro_num);
				ResultSet rs = dbc.executeQuery();
				if(rs.next()){
					baomingDate = rs.getDate("promo_end_date");
					type = rs.getInt("service_type");
					car = rs.getInt("car");
				}
				if(baomingDate==null){
					dbc.rollback();
					return;
				}
				sql = "insert into tb_data_baoming (name,phone,is_reach,is_trans,is_invite,type,serial,baoming_date) values(?,?,?,?,?,?,?,?)";
				dbc.prepareStatement(sql);
				dbc.setString(1, name);
				dbc.setString(2, phone);
				dbc.setInt(3, Integer.parseInt(is_reach));
				dbc.setInt(4, Integer.parseInt(is_trans));
				dbc.setInt(5, Integer.parseInt(is_invite));
				dbc.setInt(6, type);
				dbc.setInt(7, car);
				dbc.setDate(8, new java.sql.Date(baomingDate.getTime()));
				dbc.executeUpdate();
				sql = "select last_insert_id();";
				dbc.prepareStatement(sql);
				rs = dbc.executeQuery();
				int id=0;
				if(rs.next()){
					id = rs.getInt(1);
				}
				sql = "insert into tb_data_trans_info (baoming_id,pro_num,name,phone,addr,model,sale_man,giving_code,giving_name,giving_total_price)values(?,?,?,?,?,?,?,?,?,?)";
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
		String baoming_id= map.get("baoming_id");
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
			sql = "update tb_data_baoming set is_invite=? ,is_reach=? ,is_trans=? where id=?";
			dbc.prepareStatement(sql);
			dbc.setInt(1, Integer.parseInt(is_invite));
			dbc.setInt(2, Integer.parseInt(is_reach));
			dbc.setInt(3, Integer.parseInt(is_trans));
			dbc.setInt(4, Integer.parseInt(baoming_id));
			dbc.executeUpdate();
			if("1".equals(is_trans)){
				sql = "select count(*) c from tb_data_trans_info where baoming_id=? and pro_num=?";
				dbc.prepareStatement(sql);
				dbc.setInt(1, Integer.parseInt(baoming_id));
				dbc.setString(2, pro_num);
				ResultSet rs = dbc.executeQuery();
				int c = 0;
				if(rs.next()){
					c = rs.getInt("c");
				}
				if(c>0){
					sql="update tb_data_trans_info set addr=? ,giving_code=? ,giving_name=? ,model=? ,sale_man=?,giving_total_price=? where baoming_id=?";
					dbc.prepareStatement(sql);
					dbc.setString(1, addr);
					dbc.setString(2, giving_code);
					dbc.setString(3,giving_name);
					dbc.setInt(4, Integer.parseInt(model));
					dbc.setString(5, sale_man);
					dbc.setString(6, totalPrice.toString());
					dbc.setInt(7, Integer.parseInt(baoming_id));
					dbc.executeUpdate();
				}else{
					sql = "insert into tb_data_trans_info (baoming_id,name,phone,model,addr,giving_code,giving_name,sale_man,pro_num,giving_total_price) values(?,?,?,?,?,?,?,?,?,?)";
					dbc.prepareStatement(sql);
					dbc.setInt(1, Integer.parseInt(baoming_id));
					dbc.setString(2, name);
					dbc.setString(3, phone);
					dbc.setInt(4, Integer.parseInt(model));
					dbc.setString(5, addr);
					dbc.setString(6,giving_code);
					dbc.setString(7,giving_name);
					dbc.setString(8,sale_man);
					dbc.setString(9,pro_num);
					dbc.setString(10,totalPrice.toString());
					dbc.executeUpdate();
				}
			}else{
				sql = "delete from tb_data_trans_info where pro_num=? and baoming_id=?";
				dbc.prepareStatement(sql);
				dbc.setString(1, pro_num);
				dbc.setInt(2,Integer.parseInt(baoming_id));
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
}
