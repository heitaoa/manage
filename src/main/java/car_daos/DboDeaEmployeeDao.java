package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaEmployee;

public class  DboDeaEmployeeDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaEmployee dbodeaemployee) throws SQLException {
		dbodeaemployee.setEmpid(rs.getInt("empid"));//企业员工自增长id
		dbodeaemployee.setEid(rs.getInt("eid"));//所属企业id
		dbodeaemployee.setSortid(rs.getInt("sortid"));//排序id
		dbodeaemployee.setEmpname(rs.getString("empname"));//员工姓名
		dbodeaemployee.setPlane(rs.getString("plane"));//座机号
		dbodeaemployee.setPhone(rs.getString("phone"));//手机号
		dbodeaemployee.setDuty(rs.getString("duty"));//职务
		dbodeaemployee.setAvatar(rs.getString("avatar"));//头像图片路径
		dbodeaemployee.setAdddate(rs.getTimestamp("adddate"));//添加日期
		dbodeaemployee.setIsdelete(rs.getInt("isdelete"));//删除标识
		dbodeaemployee.setServicetype(rs.getInt("servicetype"));//类型：1：售前，2：售后
	}

	public static List<DboDeaEmployee> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_employee";
		List<DboDeaEmployee> list = new ArrayList<DboDeaEmployee>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaEmployee dbodeaemployee = new DboDeaEmployee();
				fill(rs, dbodeaemployee);
				list.add(dbodeaemployee);
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


	public static List<DboDeaEmployee> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_employee where "+subsql+"";
		List<DboDeaEmployee> list = new ArrayList<DboDeaEmployee>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaEmployee dbodeaemployee = new DboDeaEmployee();
				fill(rs, dbodeaemployee);
				list.add(dbodeaemployee);
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
		String sql = "select count(*) from dbo_dea_employee where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_employee where "+subsql+"";
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
		String sql = "delete from dbo_dea_employee where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaEmployee dbodeaemployee) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_employee(`empid`,`eid`,`sortid`,`empname`,`plane`,`phone`,`duty`,`avatar`,`adddate`,`isdelete`,`servicetype`) values(?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeaemployee.getEmpid());
		dbc.setInt(2, dbodeaemployee.getEid());
		dbc.setInt(3, dbodeaemployee.getSortid());
		dbc.setString(4, dbodeaemployee.getEmpname());
		dbc.setString(5, dbodeaemployee.getPlane());
		dbc.setString(6, dbodeaemployee.getPhone());
		dbc.setString(7, dbodeaemployee.getDuty());
		dbc.setString(8, dbodeaemployee.getAvatar());
		dbc.setTimestamp(9, new Timestamp(dbodeaemployee.getAdddate().getTime()));
		dbc.setInt(10, dbodeaemployee.getIsdelete());
		dbc.setInt(11, dbodeaemployee.getServicetype());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaEmployee dbodeaemployee) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_employee(`empid`,`eid`,`sortid`,`empname`,`plane`,`phone`,`duty`,`avatar`,`adddate`,`isdelete`,`servicetype`) values(?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeaemployee.getEmpid());
		dbc.setInt(2, dbodeaemployee.getEid());
		dbc.setInt(3, dbodeaemployee.getSortid());
		dbc.setString(4, dbodeaemployee.getEmpname());
		dbc.setString(5, dbodeaemployee.getPlane());
		dbc.setString(6, dbodeaemployee.getPhone());
		dbc.setString(7, dbodeaemployee.getDuty());
		dbc.setString(8, dbodeaemployee.getAvatar());
		dbc.setTimestamp(9, new Timestamp(dbodeaemployee.getAdddate().getTime()));
		dbc.setInt(10, dbodeaemployee.getIsdelete());
		dbc.setInt(11, dbodeaemployee.getServicetype());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaEmployee dbodeaemployee) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_employee set ");
		boolean flag = false;
		if(dbodeaemployee.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",empid=?");
			}else{
				sb.append("empid=?");
				flag=true;
			}
		}
		if(dbodeaemployee.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",eid=?");
			}else{
				sb.append("eid=?");
				flag=true;
			}
		}
		if(dbodeaemployee.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",sortid=?");
			}else{
				sb.append("sortid=?");
				flag=true;
			}
		}
		if(dbodeaemployee.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",empname=?");
			}else{
				sb.append("empname=?");
				flag=true;
			}
		}
		if(dbodeaemployee.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",plane=?");
			}else{
				sb.append("plane=?");
				flag=true;
			}
		}
		if(dbodeaemployee.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",phone=?");
			}else{
				sb.append("phone=?");
				flag=true;
			}
		}
		if(dbodeaemployee.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",duty=?");
			}else{
				sb.append("duty=?");
				flag=true;
			}
		}
		if(dbodeaemployee.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",avatar=?");
			}else{
				sb.append("avatar=?");
				flag=true;
			}
		}
		if(dbodeaemployee.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbodeaemployee.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dbodeaemployee.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",servicetype=?");
			}else{
				sb.append("servicetype=?");
				flag=true;
			}
		}
		sb.append(" where empid=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeaemployee.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeaemployee.getEmpid());k++;
		}
		if(dbodeaemployee.COLUMN_FLAG[1]){
			dbc.setInt(k, dbodeaemployee.getEid());k++;
		}
		if(dbodeaemployee.COLUMN_FLAG[2]){
			dbc.setInt(k, dbodeaemployee.getSortid());k++;
		}
		if(dbodeaemployee.COLUMN_FLAG[3]){
			dbc.setString(k, dbodeaemployee.getEmpname());k++;
		}
		if(dbodeaemployee.COLUMN_FLAG[4]){
			dbc.setString(k, dbodeaemployee.getPlane());k++;
		}
		if(dbodeaemployee.COLUMN_FLAG[5]){
			dbc.setString(k, dbodeaemployee.getPhone());k++;
		}
		if(dbodeaemployee.COLUMN_FLAG[6]){
			dbc.setString(k, dbodeaemployee.getDuty());k++;
		}
		if(dbodeaemployee.COLUMN_FLAG[7]){
			dbc.setString(k, dbodeaemployee.getAvatar());k++;
		}
		if(dbodeaemployee.COLUMN_FLAG[8]){
			dbc.setTimestamp(k, new Timestamp(dbodeaemployee.getAdddate().getTime()));k++;
		}
		if(dbodeaemployee.COLUMN_FLAG[9]){
			dbc.setInt(k, dbodeaemployee.getIsdelete());k++;
		}
		if(dbodeaemployee.COLUMN_FLAG[10]){
			dbc.setInt(k, dbodeaemployee.getServicetype());k++;
		}
		dbc.setInt(k, dbodeaemployee.getEmpid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaEmployee dbodeaemployee) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeaemployee);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static int DboDeaEmployeeCountByeid(int eid){
		DBConnect dbc = null;
		String sql = "select count(*) from dbo_dea_employee where eid = ?";
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, eid);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}