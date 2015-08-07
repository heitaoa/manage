package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboPubIpdata;

public class  DboPubIpdataDao  extends BaseDao {

	public static void fill(ResultSet rs, DboPubIpdata dbopubipdata) throws SQLException {
		dbopubipdata.setId(rs.getInt("id"));//
		dbopubipdata.setIpnumstart(rs.getLong("ipnumstart"));//
		dbopubipdata.setIpnumend(rs.getLong("ipnumend"));//
		dbopubipdata.setAreaid(rs.getInt("areaid"));//
		dbopubipdata.setStartip(rs.getString("startip"));//
		dbopubipdata.setEndip(rs.getString("endip"));//
		dbopubipdata.setAreainfo(rs.getString("areainfo"));//
		dbopubipdata.setHaschecked(rs.getInt("haschecked"));//
	}

	public static List<DboPubIpdata> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_pub_ipdata";
		List<DboPubIpdata> list = new ArrayList<DboPubIpdata>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboPubIpdata dbopubipdata = new DboPubIpdata();
				fill(rs, dbopubipdata);
				list.add(dbopubipdata);
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


	public static List<DboPubIpdata> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_pub_ipdata where "+subsql+"";
		List<DboPubIpdata> list = new ArrayList<DboPubIpdata>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboPubIpdata dbopubipdata = new DboPubIpdata();
				fill(rs, dbopubipdata);
				list.add(dbopubipdata);
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
		String sql = "select count(*) from dbo_pub_ipdata where "+subsql+"";
		
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
		String sql = "delete from dbo_pub_ipdata where "+subsql+"";
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
		String sql = "delete from dbo_pub_ipdata where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboPubIpdata dbopubipdata) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_pub_ipdata(`id`,`ipnumstart`,`ipnumend`,`areaid`,`startip`,`endip`,`areainfo`,`haschecked`) values(?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbopubipdata.getId());
		dbc.setLong(2, dbopubipdata.getIpnumstart());
		dbc.setLong(3, dbopubipdata.getIpnumend());
		dbc.setInt(4, dbopubipdata.getAreaid());
		dbc.setString(5, dbopubipdata.getStartip());
		dbc.setString(6, dbopubipdata.getEndip());
		dbc.setString(7, dbopubipdata.getAreainfo());
		dbc.setInt(8, dbopubipdata.getHaschecked());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboPubIpdata dbopubipdata) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_pub_ipdata(`id`,`ipnumstart`,`ipnumend`,`areaid`,`startip`,`endip`,`areainfo`,`haschecked`) values(?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbopubipdata.getId());
		dbc.setLong(2, dbopubipdata.getIpnumstart());
		dbc.setLong(3, dbopubipdata.getIpnumend());
		dbc.setInt(4, dbopubipdata.getAreaid());
		dbc.setString(5, dbopubipdata.getStartip());
		dbc.setString(6, dbopubipdata.getEndip());
		dbc.setString(7, dbopubipdata.getAreainfo());
		dbc.setInt(8, dbopubipdata.getHaschecked());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboPubIpdata dbopubipdata) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_pub_ipdata set ");
		boolean flag = false;
		if(dbopubipdata.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbopubipdata.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",ipnumstart=?");
			}else{
				sb.append("ipnumstart=?");
				flag=true;
			}
		}
		if(dbopubipdata.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",ipnumend=?");
			}else{
				sb.append("ipnumend=?");
				flag=true;
			}
		}
		if(dbopubipdata.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",areaid=?");
			}else{
				sb.append("areaid=?");
				flag=true;
			}
		}
		if(dbopubipdata.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",startip=?");
			}else{
				sb.append("startip=?");
				flag=true;
			}
		}
		if(dbopubipdata.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",endip=?");
			}else{
				sb.append("endip=?");
				flag=true;
			}
		}
		if(dbopubipdata.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",areainfo=?");
			}else{
				sb.append("areainfo=?");
				flag=true;
			}
		}
		if(dbopubipdata.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",haschecked=?");
			}else{
				sb.append("haschecked=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbopubipdata.COLUMN_FLAG[0]){
			dbc.setInt(k, dbopubipdata.getId());k++;
		}
		if(dbopubipdata.COLUMN_FLAG[1]){
			dbc.setLong(k, dbopubipdata.getIpnumstart());k++;
		}
		if(dbopubipdata.COLUMN_FLAG[2]){
			dbc.setLong(k, dbopubipdata.getIpnumend());k++;
		}
		if(dbopubipdata.COLUMN_FLAG[3]){
			dbc.setInt(k, dbopubipdata.getAreaid());k++;
		}
		if(dbopubipdata.COLUMN_FLAG[4]){
			dbc.setString(k, dbopubipdata.getStartip());k++;
		}
		if(dbopubipdata.COLUMN_FLAG[5]){
			dbc.setString(k, dbopubipdata.getEndip());k++;
		}
		if(dbopubipdata.COLUMN_FLAG[6]){
			dbc.setString(k, dbopubipdata.getAreainfo());k++;
		}
		if(dbopubipdata.COLUMN_FLAG[7]){
			dbc.setInt(k, dbopubipdata.getHaschecked());k++;
		}
		dbc.setInt(k, dbopubipdata.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboPubIpdata dbopubipdata) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbopubipdata);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}