package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboCarCatalog;

public class  DboCarCatalogDao  extends BaseDao {

	public static void fill(ResultSet rs, DboCarCatalog dbocarcatalog) throws SQLException {
		dbocarcatalog.setCatalogid(rs.getInt("catalogid"));//
		dbocarcatalog.setCatalogname(rs.getString("catalogname"));//
		dbocarcatalog.setFatherid(rs.getInt("fatherid"));//
		dbocarcatalog.setByname(rs.getString("byname"));//
		dbocarcatalog.setPath(rs.getString("path"));//
		dbocarcatalog.setIslive(rs.getInt("islive"));//
		dbocarcatalog.setPhoto(rs.getString("photo"));//
		dbocarcatalog.setNewsid(rs.getInt("newsid"));//
		dbocarcatalog.setIsdelete(rs.getInt("isdelete"));//
		dbocarcatalog.setAdddate(rs.getTimestamp("adddate"));//
		dbocarcatalog.setLastupdate(rs.getTimestamp("lastupdate"));//
		dbocarcatalog.setAddadmin(rs.getString("addadmin"));//
		dbocarcatalog.setUpdateadmin(rs.getString("updateadmin"));//
		dbocarcatalog.setDeladmin(rs.getString("deladmin"));//
		dbocarcatalog.setSortid(rs.getInt("sortid"));//
		dbocarcatalog.setFactorytel(rs.getString("factorytel"));//
		dbocarcatalog.setCarkey(rs.getString("carkey"));//
		dbocarcatalog.setEnglishname(rs.getString("englishname"));//
		dbocarcatalog.setBackename(rs.getString("backename"));//
		dbocarcatalog.setMaincatalogid(rs.getInt("maincatalogid"));//
		dbocarcatalog.setMainenglishname(rs.getString("mainenglishname"));//
		dbocarcatalog.setIshaverelation(rs.getInt("ishaverelation"));//
		dbocarcatalog.setLname(rs.getString("lname"));//
		dbocarcatalog.setPathlevel(rs.getInt("pathlevel"));//
		dbocarcatalog.setHotlevel(rs.getInt("hotlevel"));//
	}

	public static List<DboCarCatalog> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_car_catalog";
		List<DboCarCatalog> list = new ArrayList<DboCarCatalog>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarCatalog dbocarcatalog = new DboCarCatalog();
				fill(rs, dbocarcatalog);
				list.add(dbocarcatalog);
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


	public static List<DboCarCatalog> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_car_catalog where "+subsql+"";
		List<DboCarCatalog> list = new ArrayList<DboCarCatalog>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarCatalog dbocarcatalog = new DboCarCatalog();
				fill(rs, dbocarcatalog);
				list.add(dbocarcatalog);
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
		String sql = "select count(*) from dbo_car_catalog where "+subsql+"";
		
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
		String sql = "delete from dbo_car_catalog where "+subsql+"";
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
		String sql = "delete from dbo_car_catalog where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboCarCatalog dbocarcatalog) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_car_catalog(`catalogid`,`catalogname`,`fatherid`,`byname`,`path`,`islive`,`photo`,`newsid`,`isdelete`,`adddate`,`lastupdate`,`addadmin`,`updateadmin`,`deladmin`,`sortid`,`factorytel`,`carkey`,`englishname`,`backename`,`maincatalogid`,`mainenglishname`,`ishaverelation`,`lname`,`pathlevel`,`hotlevel`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbocarcatalog.getCatalogid());
		dbc.setString(2, dbocarcatalog.getCatalogname());
		dbc.setInt(3, dbocarcatalog.getFatherid());
		dbc.setString(4, dbocarcatalog.getByname());
		dbc.setString(5, dbocarcatalog.getPath());
		dbc.setInt(6, dbocarcatalog.getIslive());
		dbc.setString(7, dbocarcatalog.getPhoto());
		dbc.setInt(8, dbocarcatalog.getNewsid());
		dbc.setInt(9, dbocarcatalog.getIsdelete());
		dbc.setTimestamp(10, new Timestamp(dbocarcatalog.getAdddate().getTime()));
		dbc.setTimestamp(11, new Timestamp(dbocarcatalog.getLastupdate().getTime()));
		dbc.setString(12, dbocarcatalog.getAddadmin());
		dbc.setString(13, dbocarcatalog.getUpdateadmin());
		dbc.setString(14, dbocarcatalog.getDeladmin());
		dbc.setInt(15, dbocarcatalog.getSortid());
		dbc.setString(16, dbocarcatalog.getFactorytel());
		dbc.setString(17, dbocarcatalog.getCarkey());
		dbc.setString(18, dbocarcatalog.getEnglishname());
		dbc.setString(19, dbocarcatalog.getBackename());
		dbc.setInt(20, dbocarcatalog.getMaincatalogid());
		dbc.setString(21, dbocarcatalog.getMainenglishname());
		dbc.setInt(22, dbocarcatalog.getIshaverelation());
		dbc.setString(23, dbocarcatalog.getLname());
		dbc.setInt(24, dbocarcatalog.getPathlevel());
		dbc.setInt(25, dbocarcatalog.getHotlevel());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboCarCatalog dbocarcatalog) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_car_catalog(`catalogid`,`catalogname`,`fatherid`,`byname`,`path`,`islive`,`photo`,`newsid`,`isdelete`,`adddate`,`lastupdate`,`addadmin`,`updateadmin`,`deladmin`,`sortid`,`factorytel`,`carkey`,`englishname`,`backename`,`maincatalogid`,`mainenglishname`,`ishaverelation`,`lname`,`pathlevel`,`hotlevel`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbocarcatalog.getCatalogid());
		dbc.setString(2, dbocarcatalog.getCatalogname());
		dbc.setInt(3, dbocarcatalog.getFatherid());
		dbc.setString(4, dbocarcatalog.getByname());
		dbc.setString(5, dbocarcatalog.getPath());
		dbc.setInt(6, dbocarcatalog.getIslive());
		dbc.setString(7, dbocarcatalog.getPhoto());
		dbc.setInt(8, dbocarcatalog.getNewsid());
		dbc.setInt(9, dbocarcatalog.getIsdelete());
		dbc.setTimestamp(10, new Timestamp(dbocarcatalog.getAdddate().getTime()));
		dbc.setTimestamp(11, new Timestamp(dbocarcatalog.getLastupdate().getTime()));
		dbc.setString(12, dbocarcatalog.getAddadmin());
		dbc.setString(13, dbocarcatalog.getUpdateadmin());
		dbc.setString(14, dbocarcatalog.getDeladmin());
		dbc.setInt(15, dbocarcatalog.getSortid());
		dbc.setString(16, dbocarcatalog.getFactorytel());
		dbc.setString(17, dbocarcatalog.getCarkey());
		dbc.setString(18, dbocarcatalog.getEnglishname());
		dbc.setString(19, dbocarcatalog.getBackename());
		dbc.setInt(20, dbocarcatalog.getMaincatalogid());
		dbc.setString(21, dbocarcatalog.getMainenglishname());
		dbc.setInt(22, dbocarcatalog.getIshaverelation());
		dbc.setString(23, dbocarcatalog.getLname());
		dbc.setInt(24, dbocarcatalog.getPathlevel());
		dbc.setInt(25, dbocarcatalog.getHotlevel());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

}