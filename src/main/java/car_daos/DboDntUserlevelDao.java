package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDntUserlevel;

public class  DboDntUserlevelDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDntUserlevel dbodntuserlevel) throws SQLException {
		dbodntuserlevel.setUid(rs.getInt("uid"));//
		dbodntuserlevel.setUlevel(rs.getInt("ulevel"));//经销商后台{1|总经理；2|售前服务；3|售后服务}；车团后台{4|总站，所有可见；5|分站权限}；
		dbodntuserlevel.setEid(rs.getInt("eid"));//
		dbodntuserlevel.setIsdelete(rs.getInt("isdelete"));//
		dbodntuserlevel.setSub_sites_id(rs.getInt("sub_sites_id"));//分站权限
	}

	public static List<DboDntUserlevel> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dnt_userlevel";
		List<DboDntUserlevel> list = new ArrayList<DboDntUserlevel>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDntUserlevel dbodntuserlevel = new DboDntUserlevel();
				fill(rs, dbodntuserlevel);
				list.add(dbodntuserlevel);
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


	public static List<DboDntUserlevel> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dnt_userlevel where "+subsql+"";
		List<DboDntUserlevel> list = new ArrayList<DboDntUserlevel>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDntUserlevel dbodntuserlevel = new DboDntUserlevel();
				fill(rs, dbodntuserlevel);
				list.add(dbodntuserlevel);
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

	public static int whereCount(String subsql) {
		DBConnect dbc = null;
		int result = EXECUTE_FAIL;
		String sql = "select count(*) from dbo_dnt_userlevel where "+subsql+"";
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			return EXECUTE_FAIL;
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


	public static int delete(String subsql) {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "delete from dbo_dnt_userlevel where "+subsql+"";
		try {
			dbc = new DBConnect();
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			dbc.close();
			result = EXECUTE_SUCCESSS;
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

	public static int delete(DBConnect dbc,String subsql) {
		int result = EXECUTE_FAIL;
		String sql = "delete from dbo_dnt_userlevel where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDntUserlevel dbodntuserlevel) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dnt_userlevel(`uid`,`ulevel`,`eid`,`isdelete`,`sub_sites_id`) values(?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodntuserlevel.getUid());
		dbc.setInt(2, dbodntuserlevel.getUlevel());
		dbc.setInt(3, dbodntuserlevel.getEid());
		dbc.setInt(4, dbodntuserlevel.getIsdelete());
		dbc.setInt(5, dbodntuserlevel.getSub_sites_id());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDntUserlevel dbodntuserlevel) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dnt_userlevel(`uid`,`ulevel`,`eid`,`isdelete`,`sub_sites_id`) values(?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodntuserlevel.getUid());
		dbc.setInt(2, dbodntuserlevel.getUlevel());
		dbc.setInt(3, dbodntuserlevel.getEid());
		dbc.setInt(4, dbodntuserlevel.getIsdelete());
		dbc.setInt(5, dbodntuserlevel.getSub_sites_id());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

}