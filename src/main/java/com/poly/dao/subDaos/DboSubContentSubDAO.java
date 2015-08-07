package com.poly.dao.subDaos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.dao.SeqDao;

import car_beans.DboSubContent;
import car_daos.DBConnect;
import car_daos.DboSubContentDao;
import car_daos.TbSequenceDao;

public class DboSubContentSubDAO extends DboSubContentDao {

	public static int getId() throws Exception {
		return SeqDao.getNextId("dbo_sub_content");
	}

	public static List<String> queryAllTitleInPname() {
		String sql = "select DISTINCT pname from dbo_sub_content";
		List<String> contents = new ArrayList<String>();
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				contents.add(rs.getString("pname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null) {
					dbc.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return contents;
	}
}
