package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboAreMobile;

public class  DboAreMobileDao  extends BaseDao {

	public static void fill(ResultSet rs, DboAreMobile dboaremobile) throws SQLException {
		dboaremobile.setId(rs.getInt("id"));//
		dboaremobile.setMobstart(rs.getLong("mobstart"));//
		dboaremobile.setMobend(rs.getLong("mobend"));//
		dboaremobile.setArea1(rs.getString("area1"));//
	}

	public static List<DboAreMobile> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_are_mobile";
		List<DboAreMobile> list = new ArrayList<DboAreMobile>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboAreMobile dboaremobile = new DboAreMobile();
				fill(rs, dboaremobile);
				list.add(dboaremobile);
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


	public static List<DboAreMobile> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_are_mobile where "+subsql+"";
		List<DboAreMobile> list = new ArrayList<DboAreMobile>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboAreMobile dboaremobile = new DboAreMobile();
				fill(rs, dboaremobile);
				list.add(dboaremobile);
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
		String sql = "select count(*) from dbo_are_mobile where "+subsql+"";
		
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
		String sql = "delete from dbo_are_mobile where "+subsql+"";
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
		String sql = "delete from dbo_are_mobile where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboAreMobile dboaremobile) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_are_mobile(`id`,`mobstart`,`mobend`,`area1`) values(?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboaremobile.getId());
		dbc.setLong(2, dboaremobile.getMobstart());
		dbc.setLong(3, dboaremobile.getMobend());
		dbc.setString(4, dboaremobile.getArea1());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboAreMobile dboaremobile) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_are_mobile(`id`,`mobstart`,`mobend`,`area1`) values(?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboaremobile.getId());
		dbc.setLong(2, dboaremobile.getMobstart());
		dbc.setLong(3, dboaremobile.getMobend());
		dbc.setString(4, dboaremobile.getArea1());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboAreMobile dboaremobile) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_are_mobile set ");
		boolean flag = false;
		if(dboaremobile.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dboaremobile.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",mobstart=?");
			}else{
				sb.append("mobstart=?");
				flag=true;
			}
		}
		if(dboaremobile.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",mobend=?");
			}else{
				sb.append("mobend=?");
				flag=true;
			}
		}
		if(dboaremobile.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",area1=?");
			}else{
				sb.append("area1=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dboaremobile.COLUMN_FLAG[0]){
			dbc.setInt(k, dboaremobile.getId());k++;
		}
		if(dboaremobile.COLUMN_FLAG[1]){
			dbc.setLong(k, dboaremobile.getMobstart());k++;
		}
		if(dboaremobile.COLUMN_FLAG[2]){
			dbc.setLong(k, dboaremobile.getMobend());k++;
		}
		if(dboaremobile.COLUMN_FLAG[3]){
			dbc.setString(k, dboaremobile.getArea1());k++;
		}
		dbc.setInt(k, dboaremobile.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboAreMobile dboaremobile) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dboaremobile);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}