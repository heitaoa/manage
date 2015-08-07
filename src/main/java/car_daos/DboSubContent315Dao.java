package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboSubContent315;

public class  DboSubContent315Dao  extends BaseDao {

	public static void fill(ResultSet rs, DboSubContent315 dbosubcontent315) throws SQLException {
		dbosubcontent315.setId(rs.getInt("id"));//
		dbosubcontent315.setPname(rs.getString("pname"));//
		dbosubcontent315.setPlace(rs.getString("place"));//
		dbosubcontent315.setStype(rs.getInt("stype"));//
		dbosubcontent315.setHtmlname(rs.getString("htmlname"));//
		dbosubcontent315.setIsdelete(rs.getInt("isdelete"));//
		dbosubcontent315.setLastvisittime(rs.getTimestamp("lastvisittime"));//
	}

	public static List<DboSubContent315> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_sub_content_315";
		List<DboSubContent315> list = new ArrayList<DboSubContent315>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboSubContent315 dbosubcontent315 = new DboSubContent315();
				fill(rs, dbosubcontent315);
				list.add(dbosubcontent315);
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


	public static List<DboSubContent315> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_sub_content_315 where "+subsql+"";
		List<DboSubContent315> list = new ArrayList<DboSubContent315>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboSubContent315 dbosubcontent315 = new DboSubContent315();
				fill(rs, dbosubcontent315);
				list.add(dbosubcontent315);
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
		String sql = "select count(*) from dbo_sub_content_315 where "+subsql+"";
		
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
		String sql = "delete from dbo_sub_content_315 where "+subsql+"";
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
		String sql = "delete from dbo_sub_content_315 where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboSubContent315 dbosubcontent315) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_sub_content_315(`id`,`pname`,`place`,`stype`,`htmlname`,`isdelete`,`lastvisittime`) values(?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbosubcontent315.getId());
		dbc.setString(2, dbosubcontent315.getPname());
		dbc.setString(3, dbosubcontent315.getPlace());
		dbc.setInt(4, dbosubcontent315.getStype());
		dbc.setString(5, dbosubcontent315.getHtmlname());
		dbc.setInt(6, dbosubcontent315.getIsdelete());
		dbc.setTimestamp(7, new Timestamp(dbosubcontent315.getLastvisittime().getTime()));
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboSubContent315 dbosubcontent315) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_sub_content_315(`id`,`pname`,`place`,`stype`,`htmlname`,`isdelete`,`lastvisittime`) values(?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbosubcontent315.getId());
		dbc.setString(2, dbosubcontent315.getPname());
		dbc.setString(3, dbosubcontent315.getPlace());
		dbc.setInt(4, dbosubcontent315.getStype());
		dbc.setString(5, dbosubcontent315.getHtmlname());
		dbc.setInt(6, dbosubcontent315.getIsdelete());
		dbc.setTimestamp(7, new Timestamp(dbosubcontent315.getLastvisittime().getTime()));
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

}