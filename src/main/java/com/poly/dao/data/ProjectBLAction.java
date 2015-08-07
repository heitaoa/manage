package com.poly.dao.data;

import car_daos.DBConnect;
import car_daos.TbDataProjectBlDao;

public class ProjectBLAction extends TbDataProjectBlDao{
	public static int deleteProject(String pro_num) {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		try {
			String sql = "update tb_data_project_bl set pro_state=? where pro_num=?";
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
