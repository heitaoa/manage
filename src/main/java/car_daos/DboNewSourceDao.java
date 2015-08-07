package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboNewSource;

public class  DboNewSourceDao  extends BaseDao {

	public static void fill(ResultSet rs, DboNewSource dbonewsource) throws SQLException {
		dbonewsource.setId(rs.getInt("id"));//
		dbonewsource.setNewseditor(rs.getString("newseditor"));//
		dbonewsource.setUrl(rs.getString("url"));//
	}

	public static List<DboNewSource> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_new_source";
		List<DboNewSource> list = new ArrayList<DboNewSource>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboNewSource dbonewsource = new DboNewSource();
				fill(rs, dbonewsource);
				list.add(dbonewsource);
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


	public static List<DboNewSource> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_new_source where "+subsql+"";
		List<DboNewSource> list = new ArrayList<DboNewSource>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboNewSource dbonewsource = new DboNewSource();
				fill(rs, dbonewsource);
				list.add(dbonewsource);
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
		String sql = "select count(*) from dbo_new_source where "+subsql+"";
		
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
		String sql = "delete from dbo_new_source where "+subsql+"";
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
		String sql = "delete from dbo_new_source where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboNewSource dbonewsource) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_new_source(`id`,`newseditor`,`url`) values(?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbonewsource.getId());
		dbc.setString(2, dbonewsource.getNewseditor());
		dbc.setString(3, dbonewsource.getUrl());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboNewSource dbonewsource) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_new_source(`id`,`newseditor`,`url`) values(?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbonewsource.getId());
		dbc.setString(2, dbonewsource.getNewseditor());
		dbc.setString(3, dbonewsource.getUrl());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboNewSource dbonewsource) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_new_source set ");
		boolean flag = false;
		if(dbonewsource.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbonewsource.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",newseditor=?");
			}else{
				sb.append("newseditor=?");
				flag=true;
			}
		}
		if(dbonewsource.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",url=?");
			}else{
				sb.append("url=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbonewsource.COLUMN_FLAG[0]){
			dbc.setInt(k, dbonewsource.getId());k++;
		}
		if(dbonewsource.COLUMN_FLAG[1]){
			dbc.setString(k, dbonewsource.getNewseditor());k++;
		}
		if(dbonewsource.COLUMN_FLAG[2]){
			dbc.setString(k, dbonewsource.getUrl());k++;
		}
		dbc.setInt(k, dbonewsource.getId());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboNewSource dbonewsource) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbonewsource);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}