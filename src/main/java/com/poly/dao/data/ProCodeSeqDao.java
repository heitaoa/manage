package com.poly.dao.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import car_beans.TbDataProCodeSeq;
import car_beans.TbDataProject;
import car_daos.DBConnect;
import car_daos.TbDataProCodeSeqDao;

public class ProCodeSeqDao extends TbDataProCodeSeqDao {

	public String getProNum(String head) {
		Integer code = null;
		DBConnect dbc = null;
		String sql = "select * from car_315.tb_data_pro_code_seq where head=? for update";
		try {
			dbc = new DBConnect();
			dbc.setAutoCommit(false);
			dbc.prepareStatement(sql);
			dbc.setString(1, head);
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				code = rs.getInt("code");
				code += 1;
				sql = "update car_315.tb_data_pro_code_seq set code=? where head=?";
				dbc.prepareStatement(sql);
				dbc.setInt(1, code);
				dbc.setString(2, head);
				dbc.executeUpdate();
			}else{
				code = 10001;
				sql = "insert into car_315.tb_data_pro_code_seq (head,code) values(?,?)";
				dbc.prepareStatement(sql);
				dbc.setInt(2, code);
				dbc.setString(1, head);
				dbc.executeUpdate();
			}
		} catch (Exception e) {
			try {
				dbc.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.commit();
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String v = code.toString().substring(1);
		String proNum = head+"-"+v;
		return proNum;
	}
	
	
	
}
