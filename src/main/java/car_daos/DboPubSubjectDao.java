package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboPubSubject;

public class  DboPubSubjectDao  extends BaseDao {

	public static void fill(ResultSet rs, DboPubSubject dbopubsubject) throws SQLException {
		dbopubsubject.setSubjectid(rs.getInt("subjectid"));//专题id
		dbopubsubject.setSubjectname(rs.getString("subjectname"));//专题名称
		dbopubsubject.setSubjecttype(rs.getString("subjecttype"));//专题类型
		dbopubsubject.setSubjectdate(rs.getTimestamp("subjectdate"));//专题建立时间
		dbopubsubject.setSubjecturl(rs.getString("subjecturl"));//专题链接
	}

	public static List<DboPubSubject> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_pub_subject";
		List<DboPubSubject> list = new ArrayList<DboPubSubject>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboPubSubject dbopubsubject = new DboPubSubject();
				fill(rs, dbopubsubject);
				list.add(dbopubsubject);
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


	public static List<DboPubSubject> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_pub_subject where "+subsql+"";
		List<DboPubSubject> list = new ArrayList<DboPubSubject>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboPubSubject dbopubsubject = new DboPubSubject();
				fill(rs, dbopubsubject);
				list.add(dbopubsubject);
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
		String sql = "select count(*) from dbo_pub_subject where "+subsql+"";
		
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
		String sql = "delete from dbo_pub_subject where "+subsql+"";
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
		String sql = "delete from dbo_pub_subject where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboPubSubject dbopubsubject) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_pub_subject(`subjectid`,`subjectname`,`subjecttype`,`subjectdate`,`subjecturl`) values(?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbopubsubject.getSubjectid());
		dbc.setString(2, dbopubsubject.getSubjectname());
		dbc.setString(3, dbopubsubject.getSubjecttype());
		dbc.setTimestamp(4, new Timestamp(dbopubsubject.getSubjectdate().getTime()));
		dbc.setString(5, dbopubsubject.getSubjecturl());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboPubSubject dbopubsubject) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_pub_subject(`subjectid`,`subjectname`,`subjecttype`,`subjectdate`,`subjecturl`) values(?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbopubsubject.getSubjectid());
		dbc.setString(2, dbopubsubject.getSubjectname());
		dbc.setString(3, dbopubsubject.getSubjecttype());
		dbc.setTimestamp(4, new Timestamp(dbopubsubject.getSubjectdate().getTime()));
		dbc.setString(5, dbopubsubject.getSubjecturl());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboPubSubject dbopubsubject) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_pub_subject set ");
		boolean flag = false;
		if(dbopubsubject.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",subjectid=?");
			}else{
				sb.append("subjectid=?");
				flag=true;
			}
		}
		if(dbopubsubject.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",subjectname=?");
			}else{
				sb.append("subjectname=?");
				flag=true;
			}
		}
		if(dbopubsubject.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",subjecttype=?");
			}else{
				sb.append("subjecttype=?");
				flag=true;
			}
		}
		if(dbopubsubject.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",subjectdate=?");
			}else{
				sb.append("subjectdate=?");
				flag=true;
			}
		}
		if(dbopubsubject.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",subjecturl=?");
			}else{
				sb.append("subjecturl=?");
				flag=true;
			}
		}
		sb.append(" where subjectid=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbopubsubject.COLUMN_FLAG[0]){
			dbc.setInt(k, dbopubsubject.getSubjectid());k++;
		}
		if(dbopubsubject.COLUMN_FLAG[1]){
			dbc.setString(k, dbopubsubject.getSubjectname());k++;
		}
		if(dbopubsubject.COLUMN_FLAG[2]){
			dbc.setString(k, dbopubsubject.getSubjecttype());k++;
		}
		if(dbopubsubject.COLUMN_FLAG[3]){
			dbc.setTimestamp(k, new Timestamp(dbopubsubject.getSubjectdate().getTime()));k++;
		}
		if(dbopubsubject.COLUMN_FLAG[4]){
			dbc.setString(k, dbopubsubject.getSubjecturl());k++;
		}
		dbc.setInt(k, dbopubsubject.getSubjectid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboPubSubject dbopubsubject) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbopubsubject);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}