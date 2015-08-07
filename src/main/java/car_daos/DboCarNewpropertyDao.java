package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboCarNewproperty;

public class  DboCarNewpropertyDao  extends BaseDao {

	public static void fill(ResultSet rs, DboCarNewproperty dbocarnewproperty) throws SQLException {
		dbocarnewproperty.setId(rs.getInt("id"));//
		dbocarnewproperty.setType(rs.getString("type"));//
		dbocarnewproperty.setName(rs.getString("name"));//
		dbocarnewproperty.setSort(rs.getInt("sort"));//
		dbocarnewproperty.setLevel(rs.getInt("level"));//
		dbocarnewproperty.setExplain(rs.getString("explain"));//
	}

	public static List<DboCarNewproperty> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_car_newproperty";
		List<DboCarNewproperty> list = new ArrayList<DboCarNewproperty>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarNewproperty dbocarnewproperty = new DboCarNewproperty();
				fill(rs, dbocarnewproperty);
				list.add(dbocarnewproperty);
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


	public static List<DboCarNewproperty> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_car_newproperty where "+subsql+"";
		List<DboCarNewproperty> list = new ArrayList<DboCarNewproperty>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarNewproperty dbocarnewproperty = new DboCarNewproperty();
				fill(rs, dbocarnewproperty);
				list.add(dbocarnewproperty);
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
		String sql = "select count(*) from dbo_car_newproperty where "+subsql+"";
		
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
		String sql = "delete from dbo_car_newproperty where "+subsql+"";
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
		String sql = "delete from dbo_car_newproperty where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboCarNewproperty dbocarnewproperty) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_car_newproperty(`id`,`type`,`name`,`sort`,`level`,`explain`) values(?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbocarnewproperty.getId());
		dbc.setString(2, dbocarnewproperty.getType());
		dbc.setString(3, dbocarnewproperty.getName());
		dbc.setInt(4, dbocarnewproperty.getSort());
		dbc.setInt(5, dbocarnewproperty.getLevel());
		dbc.setString(6, dbocarnewproperty.getExplain());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboCarNewproperty dbocarnewproperty) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_car_newproperty(`id`,`type`,`name`,`sort`,`level`,`explain`) values(?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbocarnewproperty.getId());
		dbc.setString(2, dbocarnewproperty.getType());
		dbc.setString(3, dbocarnewproperty.getName());
		dbc.setInt(4, dbocarnewproperty.getSort());
		dbc.setInt(5, dbocarnewproperty.getLevel());
		dbc.setString(6, dbocarnewproperty.getExplain());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboCarNewproperty dbocarnewproperty) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_car_newproperty set ");
		boolean flag = false;
		if(dbocarnewproperty.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbocarnewproperty.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",type=?");
			}else{
				sb.append("type=?");
				flag=true;
			}
		}
		if(dbocarnewproperty.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",name=?");
			}else{
				sb.append("name=?");
				flag=true;
			}
		}
		if(dbocarnewproperty.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",sort=?");
			}else{
				sb.append("sort=?");
				flag=true;
			}
		}
		if(dbocarnewproperty.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",level=?");
			}else{
				sb.append("level=?");
				flag=true;
			}
		}
		if(dbocarnewproperty.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",explain=?");
			}else{
				sb.append("explain=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbocarnewproperty.COLUMN_FLAG[0]){
			dbc.setInt(k, dbocarnewproperty.getId());k++;
		}
		if(dbocarnewproperty.COLUMN_FLAG[1]){
			dbc.setString(k, dbocarnewproperty.getType());k++;
		}
		if(dbocarnewproperty.COLUMN_FLAG[2]){
			dbc.setString(k, dbocarnewproperty.getName());k++;
		}
		if(dbocarnewproperty.COLUMN_FLAG[3]){
			dbc.setInt(k, dbocarnewproperty.getSort());k++;
		}
		if(dbocarnewproperty.COLUMN_FLAG[4]){
			dbc.setInt(k, dbocarnewproperty.getLevel());k++;
		}
		if(dbocarnewproperty.COLUMN_FLAG[5]){
			dbc.setString(k, dbocarnewproperty.getExplain());k++;
		}
		dbc.setInt(k, dbocarnewproperty.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboCarNewproperty dbocarnewproperty) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbocarnewproperty);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static List<DboCarNewproperty> DboCarNewpropertySelectAllColumnBylimit_beginlimit_num(int limit_begin,int limit_num){
		DBConnect dbc = null;
		String sql = "select * from dbo_car_newproperty order by id asc limit ?,?";
		List<DboCarNewproperty> list = new ArrayList<DboCarNewproperty>();
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, limit_begin);
			dbc.setInt(2, limit_num);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarNewproperty obj = new DboCarNewproperty();
				fill(rs, obj);
				list.add(obj);
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
}