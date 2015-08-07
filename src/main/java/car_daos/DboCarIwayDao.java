package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboCarIway;

public class  DboCarIwayDao  extends BaseDao {

	public static void fill(ResultSet rs, DboCarIway dbocariway) throws SQLException {
		dbocariway.setId(rs.getInt("id"));//
		dbocariway.setBrandid(rs.getInt("brandid"));//
		dbocariway.setIway(rs.getString("iway"));//
		dbocariway.setGuanurl(rs.getString("guanurl"));//
	}

	public static List<DboCarIway> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_car_iway";
		List<DboCarIway> list = new ArrayList<DboCarIway>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarIway dbocariway = new DboCarIway();
				fill(rs, dbocariway);
				list.add(dbocariway);
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


	public static List<DboCarIway> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_car_iway where "+subsql+"";
		List<DboCarIway> list = new ArrayList<DboCarIway>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarIway dbocariway = new DboCarIway();
				fill(rs, dbocariway);
				list.add(dbocariway);
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
		String sql = "select count(*) from dbo_car_iway where "+subsql+"";
		
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
		String sql = "delete from dbo_car_iway where "+subsql+"";
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
		String sql = "delete from dbo_car_iway where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboCarIway dbocariway) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_car_iway(`id`,`brandid`,`iway`,`guanurl`) values(?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbocariway.getId());
		dbc.setInt(2, dbocariway.getBrandid());
		dbc.setString(3, dbocariway.getIway());
		dbc.setString(4, dbocariway.getGuanurl());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboCarIway dbocariway) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_car_iway(`id`,`brandid`,`iway`,`guanurl`) values(?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbocariway.getId());
		dbc.setInt(2, dbocariway.getBrandid());
		dbc.setString(3, dbocariway.getIway());
		dbc.setString(4, dbocariway.getGuanurl());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboCarIway dbocariway) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_car_iway set ");
		boolean flag = false;
		if(dbocariway.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbocariway.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",brandid=?");
			}else{
				sb.append("brandid=?");
				flag=true;
			}
		}
		if(dbocariway.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",iway=?");
			}else{
				sb.append("iway=?");
				flag=true;
			}
		}
		if(dbocariway.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",guanurl=?");
			}else{
				sb.append("guanurl=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbocariway.COLUMN_FLAG[0]){
			dbc.setInt(k, dbocariway.getId());k++;
		}
		if(dbocariway.COLUMN_FLAG[1]){
			dbc.setInt(k, dbocariway.getBrandid());k++;
		}
		if(dbocariway.COLUMN_FLAG[2]){
			dbc.setString(k, dbocariway.getIway());k++;
		}
		if(dbocariway.COLUMN_FLAG[3]){
			dbc.setString(k, dbocariway.getGuanurl());k++;
		}
		dbc.setInt(k, dbocariway.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboCarIway dbocariway) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbocariway);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}