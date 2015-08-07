package com.poly.dao.subDaos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import car_beans.TbApplyInfo;
import car_daos.DBConnectionManager;

public class TbApplyPhonesSubDao {
	public int sendMsg(List<HashMap<String, String>> msgs){
		int flag = 0;

		String sql = "insert into tb_apply_phones(phone,msg) values(?,?) ";
		Connection  con = null;
		
		try {
			con = DBConnectionManager.getInstance().getConnection();
			con.setAutoCommit(false);
			PreparedStatement pst = con.prepareStatement(sql);
			for (int i = 0;i<msgs.size();i++) {
				pst.setString(1,msgs.get(i).get("phone"));
				pst.setString(2,msgs.get(i).get("msg"));
				pst.addBatch();
			}
			pst.executeBatch();
			con.commit();
			pst.close();
			flag = 1;
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

}
