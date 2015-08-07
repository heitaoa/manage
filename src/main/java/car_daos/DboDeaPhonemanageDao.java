package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaPhonemanage;

public class  DboDeaPhonemanageDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaPhonemanage dbodeaphonemanage) throws SQLException {
		dbodeaphonemanage.setId(rs.getInt("id"));//
		dbodeaphonemanage.setEid(rs.getInt("eid"));//
		dbodeaphonemanage.setPhone(rs.getString("phone"));//
		dbodeaphonemanage.setPassword(rs.getString("password"));//
		dbodeaphonemanage.setTemppassword(rs.getString("temppassword"));//
		dbodeaphonemanage.setRealname(rs.getString("realname"));//
		dbodeaphonemanage.setAdddate(rs.getTimestamp("adddate"));//
		dbodeaphonemanage.setWxcode(rs.getInt("wxcode"));//
		dbodeaphonemanage.setWxopenid(rs.getString("wxopenid"));//
		dbodeaphonemanage.setStartwork(rs.getInt("startwork"));//工作状态：1：值班；0:休息
		dbodeaphonemanage.setJob(rs.getInt("job"));//工作性质：1:售前；2：售后
	}

	public static List<DboDeaPhonemanage> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_phonemanage";
		List<DboDeaPhonemanage> list = new ArrayList<DboDeaPhonemanage>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaPhonemanage dbodeaphonemanage = new DboDeaPhonemanage();
				fill(rs, dbodeaphonemanage);
				list.add(dbodeaphonemanage);
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


	public static List<DboDeaPhonemanage> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_phonemanage where "+subsql+"";
		List<DboDeaPhonemanage> list = new ArrayList<DboDeaPhonemanage>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaPhonemanage dbodeaphonemanage = new DboDeaPhonemanage();
				fill(rs, dbodeaphonemanage);
				list.add(dbodeaphonemanage);
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
		String sql = "select count(*) from dbo_dea_phonemanage where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_phonemanage where "+subsql+"";
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
		String sql = "delete from dbo_dea_phonemanage where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaPhonemanage dbodeaphonemanage) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_phonemanage(`id`,`eid`,`phone`,`password`,`temppassword`,`realname`,`adddate`,`wxcode`,`wxopenid`,`startwork`,`job`) values(?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeaphonemanage.getId());
		dbc.setInt(2, dbodeaphonemanage.getEid());
		dbc.setString(3, dbodeaphonemanage.getPhone());
		dbc.setString(4, dbodeaphonemanage.getPassword());
		dbc.setString(5, dbodeaphonemanage.getTemppassword());
		dbc.setString(6, dbodeaphonemanage.getRealname());
		dbc.setTimestamp(7, new Timestamp(dbodeaphonemanage.getAdddate().getTime()));
		dbc.setInt(8, dbodeaphonemanage.getWxcode());
		dbc.setString(9, dbodeaphonemanage.getWxopenid());
		dbc.setInt(10, dbodeaphonemanage.getStartwork());
		dbc.setInt(11, dbodeaphonemanage.getJob());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaPhonemanage dbodeaphonemanage) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_phonemanage(`id`,`eid`,`phone`,`password`,`temppassword`,`realname`,`adddate`,`wxcode`,`wxopenid`,`startwork`,`job`) values(?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeaphonemanage.getId());
		dbc.setInt(2, dbodeaphonemanage.getEid());
		dbc.setString(3, dbodeaphonemanage.getPhone());
		dbc.setString(4, dbodeaphonemanage.getPassword());
		dbc.setString(5, dbodeaphonemanage.getTemppassword());
		dbc.setString(6, dbodeaphonemanage.getRealname());
		dbc.setTimestamp(7, new Timestamp(dbodeaphonemanage.getAdddate().getTime()));
		dbc.setInt(8, dbodeaphonemanage.getWxcode());
		dbc.setString(9, dbodeaphonemanage.getWxopenid());
		dbc.setInt(10, dbodeaphonemanage.getStartwork());
		dbc.setInt(11, dbodeaphonemanage.getJob());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaPhonemanage dbodeaphonemanage) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_phonemanage set ");
		boolean flag = false;
		if(dbodeaphonemanage.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodeaphonemanage.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",eid=?");
			}else{
				sb.append("eid=?");
				flag=true;
			}
		}
		if(dbodeaphonemanage.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",phone=?");
			}else{
				sb.append("phone=?");
				flag=true;
			}
		}
		if(dbodeaphonemanage.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",password=?");
			}else{
				sb.append("password=?");
				flag=true;
			}
		}
		if(dbodeaphonemanage.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",temppassword=?");
			}else{
				sb.append("temppassword=?");
				flag=true;
			}
		}
		if(dbodeaphonemanage.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",realname=?");
			}else{
				sb.append("realname=?");
				flag=true;
			}
		}
		if(dbodeaphonemanage.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbodeaphonemanage.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",wxcode=?");
			}else{
				sb.append("wxcode=?");
				flag=true;
			}
		}
		if(dbodeaphonemanage.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",wxopenid=?");
			}else{
				sb.append("wxopenid=?");
				flag=true;
			}
		}
		if(dbodeaphonemanage.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",startwork=?");
			}else{
				sb.append("startwork=?");
				flag=true;
			}
		}
		if(dbodeaphonemanage.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",job=?");
			}else{
				sb.append("job=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeaphonemanage.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeaphonemanage.getId());k++;
		}
		if(dbodeaphonemanage.COLUMN_FLAG[1]){
			dbc.setInt(k, dbodeaphonemanage.getEid());k++;
		}
		if(dbodeaphonemanage.COLUMN_FLAG[2]){
			dbc.setString(k, dbodeaphonemanage.getPhone());k++;
		}
		if(dbodeaphonemanage.COLUMN_FLAG[3]){
			dbc.setString(k, dbodeaphonemanage.getPassword());k++;
		}
		if(dbodeaphonemanage.COLUMN_FLAG[4]){
			dbc.setString(k, dbodeaphonemanage.getTemppassword());k++;
		}
		if(dbodeaphonemanage.COLUMN_FLAG[5]){
			dbc.setString(k, dbodeaphonemanage.getRealname());k++;
		}
		if(dbodeaphonemanage.COLUMN_FLAG[6]){
			dbc.setTimestamp(k, new Timestamp(dbodeaphonemanage.getAdddate().getTime()));k++;
		}
		if(dbodeaphonemanage.COLUMN_FLAG[7]){
			dbc.setInt(k, dbodeaphonemanage.getWxcode());k++;
		}
		if(dbodeaphonemanage.COLUMN_FLAG[8]){
			dbc.setString(k, dbodeaphonemanage.getWxopenid());k++;
		}
		if(dbodeaphonemanage.COLUMN_FLAG[9]){
			dbc.setInt(k, dbodeaphonemanage.getStartwork());k++;
		}
		if(dbodeaphonemanage.COLUMN_FLAG[10]){
			dbc.setInt(k, dbodeaphonemanage.getJob());k++;
		}
		dbc.setInt(k, dbodeaphonemanage.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaPhonemanage dbodeaphonemanage) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeaphonemanage);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}