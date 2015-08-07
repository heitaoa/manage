package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboPubAdschedule;

public class  DboPubAdscheduleDao  extends BaseDao {

	public static void fill(ResultSet rs, DboPubAdschedule dbopubadschedule) throws SQLException {
		dbopubadschedule.setSid(rs.getInt("sid"));//广告排期id
		dbopubadschedule.setAdinfoid(rs.getInt("adinfoid"));//广告位id
		dbopubadschedule.setSdate(rs.getTimestamp("sdate"));//广告开始时间
		dbopubadschedule.setEdate(rs.getTimestamp("edate"));//广告结束时间
	}

	public static List<DboPubAdschedule> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_pub_adschedule";
		List<DboPubAdschedule> list = new ArrayList<DboPubAdschedule>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboPubAdschedule dbopubadschedule = new DboPubAdschedule();
				fill(rs, dbopubadschedule);
				list.add(dbopubadschedule);
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


	public static List<DboPubAdschedule> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_pub_adschedule where "+subsql+"";
		List<DboPubAdschedule> list = new ArrayList<DboPubAdschedule>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboPubAdschedule dbopubadschedule = new DboPubAdschedule();
				fill(rs, dbopubadschedule);
				list.add(dbopubadschedule);
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
		String sql = "select count(*) from dbo_pub_adschedule where "+subsql+"";
		
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
		String sql = "delete from dbo_pub_adschedule where "+subsql+"";
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
		String sql = "delete from dbo_pub_adschedule where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboPubAdschedule dbopubadschedule) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_pub_adschedule(`sid`,`adinfoid`,`sdate`,`edate`) values(?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbopubadschedule.getSid());
		dbc.setInt(2, dbopubadschedule.getAdinfoid());
		dbc.setTimestamp(3, new Timestamp(dbopubadschedule.getSdate().getTime()));
		dbc.setTimestamp(4, new Timestamp(dbopubadschedule.getEdate().getTime()));
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboPubAdschedule dbopubadschedule) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_pub_adschedule(`sid`,`adinfoid`,`sdate`,`edate`) values(?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbopubadschedule.getSid());
		dbc.setInt(2, dbopubadschedule.getAdinfoid());
		dbc.setTimestamp(3, new Timestamp(dbopubadschedule.getSdate().getTime()));
		dbc.setTimestamp(4, new Timestamp(dbopubadschedule.getEdate().getTime()));
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboPubAdschedule dbopubadschedule) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_pub_adschedule set ");
		boolean flag = false;
		if(dbopubadschedule.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",sid=?");
			}else{
				sb.append("sid=?");
				flag=true;
			}
		}
		if(dbopubadschedule.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",adinfoid=?");
			}else{
				sb.append("adinfoid=?");
				flag=true;
			}
		}
		if(dbopubadschedule.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",sdate=?");
			}else{
				sb.append("sdate=?");
				flag=true;
			}
		}
		if(dbopubadschedule.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",edate=?");
			}else{
				sb.append("edate=?");
				flag=true;
			}
		}
		sb.append(" where sid=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbopubadschedule.COLUMN_FLAG[0]){
			dbc.setInt(k, dbopubadschedule.getSid());k++;
		}
		if(dbopubadschedule.COLUMN_FLAG[1]){
			dbc.setInt(k, dbopubadschedule.getAdinfoid());k++;
		}
		if(dbopubadschedule.COLUMN_FLAG[2]){
			dbc.setTimestamp(k, new Timestamp(dbopubadschedule.getSdate().getTime()));k++;
		}
		if(dbopubadschedule.COLUMN_FLAG[3]){
			dbc.setTimestamp(k, new Timestamp(dbopubadschedule.getEdate().getTime()));k++;
		}
		dbc.setInt(k, dbopubadschedule.getSid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboPubAdschedule dbopubadschedule) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbopubadschedule);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}