package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaByschedulesenior;

public class  DboDeaByscheduleseniorDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaByschedulesenior dbodeabyschedulesenior) throws SQLException {
		dbodeabyschedulesenior.setId(rs.getInt("id"));//
		dbodeabyschedulesenior.setEid(rs.getInt("eid"));//
		dbodeabyschedulesenior.setTime(rs.getString("time"));//
		dbodeabyschedulesenior.setBydate(rs.getTimestamp("bydate"));//
		dbodeabyschedulesenior.setPlaces(rs.getInt("places"));//¹¤Î»Êý
		dbodeabyschedulesenior.setZhekou(rs.getString("zhekou"));//
		dbodeabyschedulesenior.setAdddate(rs.getTimestamp("adddate"));//
		dbodeabyschedulesenior.setNote(rs.getString("note"));//
		dbodeabyschedulesenior.setIsdelete(rs.getInt("isdelete"));//
	}

	public static List<DboDeaByschedulesenior> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_byschedulesenior";
		List<DboDeaByschedulesenior> list = new ArrayList<DboDeaByschedulesenior>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaByschedulesenior dbodeabyschedulesenior = new DboDeaByschedulesenior();
				fill(rs, dbodeabyschedulesenior);
				list.add(dbodeabyschedulesenior);
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


	public static List<DboDeaByschedulesenior> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_byschedulesenior where "+subsql+"";
		List<DboDeaByschedulesenior> list = new ArrayList<DboDeaByschedulesenior>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaByschedulesenior dbodeabyschedulesenior = new DboDeaByschedulesenior();
				fill(rs, dbodeabyschedulesenior);
				list.add(dbodeabyschedulesenior);
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
		String sql = "select count(*) from dbo_dea_byschedulesenior where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_byschedulesenior where "+subsql+"";
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
		String sql = "delete from dbo_dea_byschedulesenior where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaByschedulesenior dbodeabyschedulesenior) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_byschedulesenior(`id`,`eid`,`time`,`bydate`,`places`,`zhekou`,`adddate`,`note`,`isdelete`) values(?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeabyschedulesenior.getId());
		dbc.setInt(2, dbodeabyschedulesenior.getEid());
		dbc.setString(3, dbodeabyschedulesenior.getTime());
		dbc.setTimestamp(4, new Timestamp(dbodeabyschedulesenior.getBydate().getTime()));
		dbc.setInt(5, dbodeabyschedulesenior.getPlaces());
		dbc.setString(6, dbodeabyschedulesenior.getZhekou());
		dbc.setTimestamp(7, new Timestamp(dbodeabyschedulesenior.getAdddate().getTime()));
		dbc.setString(8, dbodeabyschedulesenior.getNote());
		dbc.setInt(9, dbodeabyschedulesenior.getIsdelete());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaByschedulesenior dbodeabyschedulesenior) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_byschedulesenior(`id`,`eid`,`time`,`bydate`,`places`,`zhekou`,`adddate`,`note`,`isdelete`) values(?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeabyschedulesenior.getId());
		dbc.setInt(2, dbodeabyschedulesenior.getEid());
		dbc.setString(3, dbodeabyschedulesenior.getTime());
		dbc.setTimestamp(4, new Timestamp(dbodeabyschedulesenior.getBydate().getTime()));
		dbc.setInt(5, dbodeabyschedulesenior.getPlaces());
		dbc.setString(6, dbodeabyschedulesenior.getZhekou());
		dbc.setTimestamp(7, new Timestamp(dbodeabyschedulesenior.getAdddate().getTime()));
		dbc.setString(8, dbodeabyschedulesenior.getNote());
		dbc.setInt(9, dbodeabyschedulesenior.getIsdelete());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaByschedulesenior dbodeabyschedulesenior) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_byschedulesenior set ");
		boolean flag = false;
		if(dbodeabyschedulesenior.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodeabyschedulesenior.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",eid=?");
			}else{
				sb.append("eid=?");
				flag=true;
			}
		}
		if(dbodeabyschedulesenior.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",time=?");
			}else{
				sb.append("time=?");
				flag=true;
			}
		}
		if(dbodeabyschedulesenior.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",bydate=?");
			}else{
				sb.append("bydate=?");
				flag=true;
			}
		}
		if(dbodeabyschedulesenior.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",places=?");
			}else{
				sb.append("places=?");
				flag=true;
			}
		}
		if(dbodeabyschedulesenior.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",zhekou=?");
			}else{
				sb.append("zhekou=?");
				flag=true;
			}
		}
		if(dbodeabyschedulesenior.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbodeabyschedulesenior.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",note=?");
			}else{
				sb.append("note=?");
				flag=true;
			}
		}
		if(dbodeabyschedulesenior.COLUMN_FLAG[8]){
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
		if(dbodeabyschedulesenior.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeabyschedulesenior.getId());k++;
		}
		if(dbodeabyschedulesenior.COLUMN_FLAG[1]){
			dbc.setInt(k, dbodeabyschedulesenior.getEid());k++;
		}
		if(dbodeabyschedulesenior.COLUMN_FLAG[2]){
			dbc.setString(k, dbodeabyschedulesenior.getTime());k++;
		}
		if(dbodeabyschedulesenior.COLUMN_FLAG[3]){
			dbc.setTimestamp(k, new Timestamp(dbodeabyschedulesenior.getBydate().getTime()));k++;
		}
		if(dbodeabyschedulesenior.COLUMN_FLAG[4]){
			dbc.setInt(k, dbodeabyschedulesenior.getPlaces());k++;
		}
		if(dbodeabyschedulesenior.COLUMN_FLAG[5]){
			dbc.setString(k, dbodeabyschedulesenior.getZhekou());k++;
		}
		if(dbodeabyschedulesenior.COLUMN_FLAG[6]){
			dbc.setTimestamp(k, new Timestamp(dbodeabyschedulesenior.getAdddate().getTime()));k++;
		}
		if(dbodeabyschedulesenior.COLUMN_FLAG[7]){
			dbc.setString(k, dbodeabyschedulesenior.getNote());k++;
		}
		if(dbodeabyschedulesenior.COLUMN_FLAG[8]){
			dbc.setInt(k, dbodeabyschedulesenior.getIsdelete());k++;
		}
		dbc.setInt(k, dbodeabyschedulesenior.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaByschedulesenior dbodeabyschedulesenior) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeabyschedulesenior);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static List<DboDeaByschedulesenior> DboDeaByscheduleseniorSelectAllColumnByeidbydatebydate(int eid,String bydate,String bydate2){
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_byschedulesenior where eid = ? and bydate >= ? and bydate <= ?";
		List<DboDeaByschedulesenior> list = new ArrayList<DboDeaByschedulesenior>();
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, eid);
			dbc.setString(2, bydate);
			dbc.setString(3, bydate2);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaByschedulesenior obj = new DboDeaByschedulesenior();
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
	public static int DboDeaByscheduleseniorUpdateByid(int isdelete,int id){
	int result=EXECUTE_FAIL;
	DBConnect dbc = null;
	String sql = "update dbo_dea_byschedulesenior set isdelete = ? where id = ?";

	try {
		dbc = new DBConnect(sql);
		dbc.setInt(1, isdelete);
		dbc.setInt(2, id);
		dbc.executeUpdate();
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

	public static int DboDeaByscheduleseniorUpdateByid(DBConnect dbc,int isdelete,int id){
	int result=EXECUTE_FAIL;
	String sql = "update dbo_dea_byschedulesenior set isdelete = ? where id = ?";

	try {
		dbc.prepareStatement(sql);
		dbc.setInt(1, isdelete);
		dbc.setInt(2, id);
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
	}

	public static List<DboDeaByschedulesenior> DboDeaByscheduleseniorSelectAllColumnByeidbydatebydate2(int eid,String bydate,String bydate2){
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_byschedulesenior where eid = ? and bydate >= ? and bydate <= ? and isdelete = 0";
		List<DboDeaByschedulesenior> list = new ArrayList<DboDeaByschedulesenior>();
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, eid);
			dbc.setString(2, bydate);
			dbc.setString(3, bydate2);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaByschedulesenior obj = new DboDeaByschedulesenior();
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

	public static int DboDeaByscheduleseniorCountByidbydate(int id,String bydate){
		DBConnect dbc = null;
		String sql = "select count(*) from dbo_dea_byschedulesenior where id=? and bydate = ?";
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, id);
			dbc.setString(2, bydate);
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

	public static int DboDeaByscheduleseniorCountByeidbydatetime(int eid,String bydate,String time){
		DBConnect dbc = null;
		String sql = "select count(*) from dbo_dea_byschedulesenior where eid = ? and bydate = ? and time = ?";
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, eid);
			dbc.setString(2, bydate);
			dbc.setString(3, time);
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
	public static int DboDeaByscheduleseniorUpdateByid2(String time,int places,String zhekou,String note,int id){
	int result=EXECUTE_FAIL;
	DBConnect dbc = null;
	String sql = "update dbo_dea_byschedulesenior set time = ?,places = ?,zhekou = ?,note = ? where id = ?";

	try {
		dbc = new DBConnect(sql);
		dbc.setString(1, time);
		dbc.setInt(2, places);
		dbc.setString(3, zhekou);
		dbc.setString(4, note);
		dbc.setInt(5, id);
		dbc.executeUpdate();
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

	public static int DboDeaByscheduleseniorUpdateByid2(DBConnect dbc,String time,int places,String zhekou,String note,int id){
	int result=EXECUTE_FAIL;
	String sql = "update dbo_dea_byschedulesenior set time = ?,places = ?,zhekou = ?,note = ? where id = ?";

	try {
		dbc.prepareStatement(sql);
		dbc.setString(1, time);
		dbc.setInt(2, places);
		dbc.setString(3, zhekou);
		dbc.setString(4, note);
		dbc.setInt(5, id);
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
	}

	public static int DboDeaByscheduleseniorCountByeidbydatetime2(int eid,String bydate,String time){
		DBConnect dbc = null;
		String sql = "select count(*) from dbo_dea_byschedulesenior where eid = ? and bydate = ? and time = ? and isdelete = 0";
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, eid);
			dbc.setString(2, bydate);
			dbc.setString(3, time);
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

	public static int DboDeaByscheduleseniorCountByeidbydatetimeid(int eid,String bydate,String time,int id){
		DBConnect dbc = null;
		String sql = "select count(*) from dbo_dea_byschedulesenior where eid = ? and bydate = ? and time = ? and isdelete = 0 and id <> ?";
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, eid);
			dbc.setString(2, bydate);
			dbc.setString(3, time);
			dbc.setInt(4, id);
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

	public static List<DboDeaByschedulesenior> DboDeaByscheduleseniorSelectAllColumnByeidbydatebydate3(int eid,String bydate,String bydate2){
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_byschedulesenior where eid = ? and bydate >= ? and bydate < ? and isdelete = 0";
		List<DboDeaByschedulesenior> list = new ArrayList<DboDeaByschedulesenior>();
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, eid);
			dbc.setString(2, bydate);
			dbc.setString(3, bydate2);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaByschedulesenior obj = new DboDeaByschedulesenior();
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