package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboAdmUser;

public class  DboAdmUserDao  extends BaseDao {

	public static void fill(ResultSet rs, DboAdmUser dboadmuser) throws SQLException {
		dboadmuser.setId(rs.getInt("id"));//自动增长id
		dboadmuser.setUsername(rs.getString("username"));//用户名
		dboadmuser.setPassword(rs.getString("password"));//密码，md5加密
		dboadmuser.setRealname(rs.getString("realname"));//真实姓名
		dboadmuser.setAdddate(rs.getTimestamp("adddate"));//添加日期
		dboadmuser.setUdate(rs.getTimestamp("udate"));//更新日期
		dboadmuser.setAreaid(rs.getInt("areaid"));//
		dboadmuser.setPhone(rs.getString("phone"));//
	}

	public static List<DboAdmUser> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_adm_user";
		List<DboAdmUser> list = new ArrayList<DboAdmUser>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboAdmUser dboadmuser = new DboAdmUser();
				fill(rs, dboadmuser);
				list.add(dboadmuser);
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


	public static List<DboAdmUser> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_adm_user where "+subsql+"";
		List<DboAdmUser> list = new ArrayList<DboAdmUser>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboAdmUser dboadmuser = new DboAdmUser();
				fill(rs, dboadmuser);
				list.add(dboadmuser);
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
		String sql = "select count(*) from dbo_adm_user where "+subsql+"";
		
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
		String sql = "delete from dbo_adm_user where "+subsql+"";
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
		String sql = "delete from dbo_adm_user where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboAdmUser dboadmuser) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_adm_user(`id`,`username`,`password`,`realname`,`adddate`,`udate`,`areaid`,`phone`) values(?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboadmuser.getId());
		dbc.setString(2, dboadmuser.getUsername());
		dbc.setString(3, dboadmuser.getPassword());
		dbc.setString(4, dboadmuser.getRealname());
		dbc.setTimestamp(5, new Timestamp(dboadmuser.getAdddate().getTime()));
		dbc.setTimestamp(6, new Timestamp(dboadmuser.getUdate().getTime()));
		dbc.setInt(7, dboadmuser.getAreaid());
		dbc.setString(8, dboadmuser.getPhone());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboAdmUser dboadmuser) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_adm_user(`id`,`username`,`password`,`realname`,`adddate`,`udate`,`areaid`,`phone`) values(?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboadmuser.getId());
		dbc.setString(2, dboadmuser.getUsername());
		dbc.setString(3, dboadmuser.getPassword());
		dbc.setString(4, dboadmuser.getRealname());
		dbc.setTimestamp(5, new Timestamp(dboadmuser.getAdddate().getTime()));
		dbc.setTimestamp(6, new Timestamp(dboadmuser.getUdate().getTime()));
		dbc.setInt(7, dboadmuser.getAreaid());
		dbc.setString(8, dboadmuser.getPhone());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboAdmUser dboadmuser) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_adm_user set ");
		boolean flag = false;
		if(dboadmuser.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dboadmuser.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",username=?");
			}else{
				sb.append("username=?");
				flag=true;
			}
		}
		if(dboadmuser.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",password=?");
			}else{
				sb.append("password=?");
				flag=true;
			}
		}
		if(dboadmuser.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",realname=?");
			}else{
				sb.append("realname=?");
				flag=true;
			}
		}
		if(dboadmuser.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dboadmuser.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",udate=?");
			}else{
				sb.append("udate=?");
				flag=true;
			}
		}
		if(dboadmuser.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",areaid=?");
			}else{
				sb.append("areaid=?");
				flag=true;
			}
		}
		if(dboadmuser.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",phone=?");
			}else{
				sb.append("phone=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dboadmuser.COLUMN_FLAG[0]){
			dbc.setInt(k, dboadmuser.getId());k++;
		}
		if(dboadmuser.COLUMN_FLAG[1]){
			dbc.setString(k, dboadmuser.getUsername());k++;
		}
		if(dboadmuser.COLUMN_FLAG[2]){
			dbc.setString(k, dboadmuser.getPassword());k++;
		}
		if(dboadmuser.COLUMN_FLAG[3]){
			dbc.setString(k, dboadmuser.getRealname());k++;
		}
		if(dboadmuser.COLUMN_FLAG[4]){
			dbc.setTimestamp(k, new Timestamp(dboadmuser.getAdddate().getTime()));k++;
		}
		if(dboadmuser.COLUMN_FLAG[5]){
			dbc.setTimestamp(k, new Timestamp(dboadmuser.getUdate().getTime()));k++;
		}
		if(dboadmuser.COLUMN_FLAG[6]){
			dbc.setInt(k, dboadmuser.getAreaid());k++;
		}
		if(dboadmuser.COLUMN_FLAG[7]){
			dbc.setString(k, dboadmuser.getPhone());k++;
		}
		dbc.setInt(k, dboadmuser.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboAdmUser dboadmuser) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dboadmuser);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}