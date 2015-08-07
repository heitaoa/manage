package com.poly.dao.data;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import car_beans.TbDataActDetail;
import car_daos.DBConnect;
import car_daos.TbDataActDetailDao;

public class ActDetailDao extends TbDataActDetailDao {

	public Map<String, String> getActDetailInfoByProNum(String pro_num) {
		String sql = "select t1.* ,t2.acti_name ,t3.user_name detail_executor_name from car_315.tb_data_act_detail t1 left join car_315.tb_data_project t2 on t1.pro_num = t2.pro_num  left join  finance.tb_fin_user t3 on t3.USER_CODE = t1.detail_executor where t1.pro_num = ? ";
		Map<String, String> info = new HashMap<String, String>();
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, pro_num);
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				info.put("pro_num", rs.getString("pro_num"));
				info.put("detail_assist_person", rs.getString("detail_assist_person"));
				info.put("detail_executor_name", rs.getString("detail_executor_name"));
				info.put("acti_name", rs.getString("acti_name"));
				info.put("detail_traffic_expense", rs.getString("detail_traffic_expense"));
				info.put("detail_acti_sub", rs.getString("detail_acti_sub"));
				info.put("detail_acti_report", rs.getString("detail_acti_report"));
				info.put("detail_executor", rs.getString("detail_executor"));
				info.put("detail_time_interval", rs.getInt("detail_time_interval")+"");
				info.put("detail_acti_date", new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("detail_acti_date")));
				
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

	public String insertOrUpdateActDetail(TbDataActDetail detail) {
		DBConnect dbc = null;
		try {
			List<TbDataActDetail> list  = where("pro_num='"+detail.getPro_num()+"'");
			if(list.size()>0){
				detail.setDetail_id(list.get(0).getDetail_id());
				update(detail);
			}else{
				String sql = "insert into tb_data_act_detail(`pro_num`,`detail_executor`,`detail_assist_person`,`detail_acti_date`,`detail_time_interval`,`detail_traffic_expense`,`detail_acti_sub`,`detail_acti_report`,`detail_acti_addr`) values(?,?,?,?,?,?,?,?,?)";
				dbc = new DBConnect();
				dbc.prepareStatement(sql);
				dbc.setString(1, detail.getPro_num());
				dbc.setString(2, detail.getDetail_executor());
				dbc.setString(3, detail.getDetail_assist_person());
				dbc.setTimestamp(4, new Timestamp(detail.getDetail_acti_date().getTime()));
				dbc.setInt(5, detail.getDetail_time_interval());
				dbc.setString(6, detail.getDetail_traffic_expense());
				dbc.setString(7, detail.getDetail_acti_sub());
				dbc.setString(8, detail.getDetail_acti_report());
				dbc.setString(9, detail.getDetail_acti_addr());
				dbc.executeUpdate();
			}
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

	
}
