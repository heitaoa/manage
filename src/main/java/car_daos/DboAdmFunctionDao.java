package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboAdmFunction;

public class  DboAdmFunctionDao  extends BaseDao {

	public static void fill(ResultSet rs, DboAdmFunction dboadmfunction) throws SQLException {
		dboadmfunction.setId(rs.getInt("id"));//自动增长id
		dboadmfunction.setAction(rs.getString("action"));//跳转路径
		dboadmfunction.setName(rs.getString("name"));//功能点名称
		dboadmfunction.setFatherid(rs.getInt("fatherid"));//父节点id
		dboadmfunction.setIsdelete(rs.getInt("isdelete"));//是否删除状态
	}

	public static List<DboAdmFunction> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_adm_function";
		List<DboAdmFunction> list = new ArrayList<DboAdmFunction>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboAdmFunction dboadmfunction = new DboAdmFunction();
				fill(rs, dboadmfunction);
				list.add(dboadmfunction);
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


	public static List<DboAdmFunction> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_adm_function where "+subsql+"";
		List<DboAdmFunction> list = new ArrayList<DboAdmFunction>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboAdmFunction dboadmfunction = new DboAdmFunction();
				fill(rs, dboadmfunction);
				list.add(dboadmfunction);
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
		String sql = "select count(*) from dbo_adm_function where "+subsql+"";
		
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
		String sql = "delete from dbo_adm_function where "+subsql+"";
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
		String sql = "delete from dbo_adm_function where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboAdmFunction dboadmfunction) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_adm_function(`id`,`action`,`name`,`fatherid`,`isdelete`) values(?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboadmfunction.getId());
		dbc.setString(2, dboadmfunction.getAction());
		dbc.setString(3, dboadmfunction.getName());
		dbc.setInt(4, dboadmfunction.getFatherid());
		dbc.setInt(5, dboadmfunction.getIsdelete());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboAdmFunction dboadmfunction) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_adm_function(`id`,`action`,`name`,`fatherid`,`isdelete`) values(?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboadmfunction.getId());
		dbc.setString(2, dboadmfunction.getAction());
		dbc.setString(3, dboadmfunction.getName());
		dbc.setInt(4, dboadmfunction.getFatherid());
		dbc.setInt(5, dboadmfunction.getIsdelete());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboAdmFunction dboadmfunction) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_adm_function set ");
		boolean flag = false;
		if(dboadmfunction.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dboadmfunction.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",action=?");
			}else{
				sb.append("action=?");
				flag=true;
			}
		}
		if(dboadmfunction.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",name=?");
			}else{
				sb.append("name=?");
				flag=true;
			}
		}
		if(dboadmfunction.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",fatherid=?");
			}else{
				sb.append("fatherid=?");
				flag=true;
			}
		}
		if(dboadmfunction.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dboadmfunction.COLUMN_FLAG[0]){
			dbc.setInt(k, dboadmfunction.getId());k++;
		}
		if(dboadmfunction.COLUMN_FLAG[1]){
			dbc.setString(k, dboadmfunction.getAction());k++;
		}
		if(dboadmfunction.COLUMN_FLAG[2]){
			dbc.setString(k, dboadmfunction.getName());k++;
		}
		if(dboadmfunction.COLUMN_FLAG[3]){
			dbc.setInt(k, dboadmfunction.getFatherid());k++;
		}
		if(dboadmfunction.COLUMN_FLAG[4]){
			dbc.setInt(k, dboadmfunction.getIsdelete());k++;
		}
		dbc.setInt(k, dboadmfunction.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboAdmFunction dboadmfunction) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dboadmfunction);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}