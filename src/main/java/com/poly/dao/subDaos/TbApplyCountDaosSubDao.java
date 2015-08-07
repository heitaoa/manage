package com.poly.dao.subDaos;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import car_beans.DboAreCatalog;
import car_beans.TbApplyCount;
import car_daos.DBConnect;

public class TbApplyCountDaosSubDao {
	public void update(TbApplyCount tbApplyCount){
		DBConnect dbc = null;
		String sql ="update tb_apply_count set max_dbid=?,max_315id=?,last_update_time=? where id = 4";
		try {
			dbc = new DBConnect(sql);
			dbc.prepareStatement(sql);
			dbc.setInt(1, tbApplyCount.getMax_dbid());
			dbc.setInt(2, tbApplyCount.getMax_315id());
			dbc.setTimestamp(3, new Timestamp((new Date()).getTime()));
			dbc.executeUpdate();
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
		//System.err.println("====success=====");
	}
	public void updateState(int state){
		DBConnect dbc = null;
		String sql ="update tb_apply_count set islock=? where id = 4";
		try {
			dbc = new DBConnect(sql);
			dbc.prepareStatement(sql);
			dbc.setInt(1, state);
			dbc.executeUpdate();
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
	}
	
	
}
