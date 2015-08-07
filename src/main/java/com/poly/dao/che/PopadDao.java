package com.poly.dao.che;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;

import car_beans.DboAdPopad;
import car_daos.DBConnect;
import car_daos.DboAdPopadDao;

public class PopadDao extends DboAdPopadDao {
	public static void insertPopad(DboAdPopad popad) {
		DBConnect dbc = null;
		String sql = "insert into dbo_ad_popad (adid,poptotaltimes,remaintimes,adstr,isdelete,jsstr,scheduledday,totalclick,adtitle) value (?,?,?,?,?,?,?,?,?)";
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, popad.getAdid());
			dbc.setInt(2, popad.getPoptotaltimes());
			dbc.setInt(3, popad.getRemaintimes());
			dbc.setString(4, popad.getAdstr());
			dbc.setInt(5, popad.getIsdelete());
			dbc.setString(6, popad.getJsstr());
			dbc.setTimestamp(7,new Timestamp(popad.getScheduledday().getTime()));		
			dbc.setInt(8, popad.getTotalclick());
			dbc.setString(9, popad.getAdtitle());
			dbc.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (dbc != null) {
				try {
					dbc.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}

	public static void deletePopad(String popadid) {
		DBConnect dbc = null;
		String sql = "update dbo_ad_popad set isdelete=1 where id = '"
				+ popadid + "'";
		try {
			dbc = new DBConnect(sql);
			dbc.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (dbc != null) {
				try {
					dbc.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	public static void updatePopad(DboAdPopad popad) {
		DBConnect dbc = null;
		String sql = "update dbo_ad_popad set adid = ?,poptotaltimes = ?,remaintimes = ?,adstr = ?,isdelete = ?,jsstr = ?,scheduledday = ?,totalclick = ?,adtitle = ? where id = ?";
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, popad.getAdid());
			dbc.setInt(2, popad.getPoptotaltimes());
			dbc.setInt(3, popad.getRemaintimes());
			dbc.setString(4, popad.getAdstr());
			dbc.setInt(5, popad.getIsdelete());
			dbc.setString(6, popad.getJsstr());
			dbc.setTimestamp(7,
					new Timestamp(popad.getScheduledday().getTime()));
			dbc.setInt(8, popad.getTotalclick());
			dbc.setString(9, popad.getAdtitle());
			dbc.setString(9, popad.getAdtitle());
			dbc.setInt(10, popad.getId());
			dbc.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (dbc != null) {
				try {
					dbc.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static DboAdPopad getPoapdById(String popadid) {
		// TODO Auto-generated method stub
		String subsql = " id = '" + popadid + "'";
		return where(subsql).get(0);
	}

	public static int getMaxPopId() {
		// TODO Auto-generated method stub
		String sql = "select max(id) as id from dbo_ad_popad";
		DBConnect dbc = null;
		int id = 0;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				id = rs.getInt("id");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (dbc != null) {
				try {
					dbc.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return id;
	}

	public static List<DboAdPopad> getPopadByPage(int from, int i) {

		String subsql = "isdelete = 0 order by scheduledday desc limit " + from + "," + i;
		return where(subsql);

		// TODO Auto-generated method stub

	}
    //获取数据库里面符合条件的数量
	public static int getPopadCount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) as count from dbo_ad_popad where isdelete=0";
		DBConnect dbc = null;
		int count = 0;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (dbc != null) {
				try {
					dbc.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return count;

	}


	
}
