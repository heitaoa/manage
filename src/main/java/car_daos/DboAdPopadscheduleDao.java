package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboAdPopadschedule;

public class  DboAdPopadscheduleDao  extends BaseDao {

	public static void fill(ResultSet rs, DboAdPopadschedule dboadpopadschedule) throws SQLException {
		dboadpopadschedule.setId(rs.getInt("id"));//弹出广告日期安排表自增长id
		dboadpopadschedule.setPopaid(rs.getInt("popaid"));//弹出广告id
		dboadpopadschedule.setSdate(rs.getTimestamp("sdate"));//起始日期
		dboadpopadschedule.setEdate(rs.getTimestamp("edate"));//结束日期
		dboadpopadschedule.setIsdelete(rs.getInt("isdelete"));//删除标识
	}

	public static List<DboAdPopadschedule> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_ad_popadschedule";
		List<DboAdPopadschedule> list = new ArrayList<DboAdPopadschedule>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboAdPopadschedule dboadpopadschedule = new DboAdPopadschedule();
				fill(rs, dboadpopadschedule);
				list.add(dboadpopadschedule);
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


	public static List<DboAdPopadschedule> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_ad_popadschedule where "+subsql+"";
		List<DboAdPopadschedule> list = new ArrayList<DboAdPopadschedule>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboAdPopadschedule dboadpopadschedule = new DboAdPopadschedule();
				fill(rs, dboadpopadschedule);
				list.add(dboadpopadschedule);
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
		String sql = "select count(*) from dbo_ad_popadschedule where "+subsql+"";
		
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
		String sql = "delete from dbo_ad_popadschedule where "+subsql+"";
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
		String sql = "delete from dbo_ad_popadschedule where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboAdPopadschedule dboadpopadschedule) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_ad_popadschedule(`id`,`popaid`,`sdate`,`edate`,`isdelete`) values(?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboadpopadschedule.getId());
		dbc.setInt(2, dboadpopadschedule.getPopaid());
		dbc.setTimestamp(3, new Timestamp(dboadpopadschedule.getSdate().getTime()));
		dbc.setTimestamp(4, new Timestamp(dboadpopadschedule.getEdate().getTime()));
		dbc.setInt(5, dboadpopadschedule.getIsdelete());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboAdPopadschedule dboadpopadschedule) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_ad_popadschedule(`id`,`popaid`,`sdate`,`edate`,`isdelete`) values(?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboadpopadschedule.getId());
		dbc.setInt(2, dboadpopadschedule.getPopaid());
		dbc.setTimestamp(3, new Timestamp(dboadpopadschedule.getSdate().getTime()));
		dbc.setTimestamp(4, new Timestamp(dboadpopadschedule.getEdate().getTime()));
		dbc.setInt(5, dboadpopadschedule.getIsdelete());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboAdPopadschedule dboadpopadschedule) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_ad_popadschedule set ");
		boolean flag = false;
		if(dboadpopadschedule.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dboadpopadschedule.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",popaid=?");
			}else{
				sb.append("popaid=?");
				flag=true;
			}
		}
		if(dboadpopadschedule.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",sdate=?");
			}else{
				sb.append("sdate=?");
				flag=true;
			}
		}
		if(dboadpopadschedule.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",edate=?");
			}else{
				sb.append("edate=?");
				flag=true;
			}
		}
		if(dboadpopadschedule.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dboadpopadschedule.COLUMN_FLAG[0]){
			dbc.setInt(k, dboadpopadschedule.getId());k++;
		}
		if(dboadpopadschedule.COLUMN_FLAG[1]){
			dbc.setInt(k, dboadpopadschedule.getPopaid());k++;
		}
		if(dboadpopadschedule.COLUMN_FLAG[2]){
			dbc.setTimestamp(k, new Timestamp(dboadpopadschedule.getSdate().getTime()));k++;
		}
		if(dboadpopadschedule.COLUMN_FLAG[3]){
			dbc.setTimestamp(k, new Timestamp(dboadpopadschedule.getEdate().getTime()));k++;
		}
		if(dboadpopadschedule.COLUMN_FLAG[4]){
			dbc.setInt(k, dboadpopadschedule.getIsdelete());k++;
		}
		dbc.setInt(k, dboadpopadschedule.getId());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboAdPopadschedule dboadpopadschedule) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dboadpopadschedule);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}