package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboPubSubjectmould;

public class  DboPubSubjectmouldDao  extends BaseDao {

	public static void fill(ResultSet rs, DboPubSubjectmould dbopubsubjectmould) throws SQLException {
		dbopubsubjectmould.setId(rs.getInt("id"));//关联id
		dbopubsubjectmould.setSid(rs.getInt("sid"));//专题id
		dbopubsubjectmould.setMid(rs.getInt("mid"));//模板id
	}

	public static List<DboPubSubjectmould> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_pub_subjectmould";
		List<DboPubSubjectmould> list = new ArrayList<DboPubSubjectmould>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboPubSubjectmould dbopubsubjectmould = new DboPubSubjectmould();
				fill(rs, dbopubsubjectmould);
				list.add(dbopubsubjectmould);
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


	public static List<DboPubSubjectmould> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_pub_subjectmould where "+subsql+"";
		List<DboPubSubjectmould> list = new ArrayList<DboPubSubjectmould>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboPubSubjectmould dbopubsubjectmould = new DboPubSubjectmould();
				fill(rs, dbopubsubjectmould);
				list.add(dbopubsubjectmould);
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
		String sql = "select count(*) from dbo_pub_subjectmould where "+subsql+"";
		
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
		String sql = "delete from dbo_pub_subjectmould where "+subsql+"";
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
		String sql = "delete from dbo_pub_subjectmould where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboPubSubjectmould dbopubsubjectmould) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_pub_subjectmould(`id`,`sid`,`mid`) values(?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbopubsubjectmould.getId());
		dbc.setInt(2, dbopubsubjectmould.getSid());
		dbc.setInt(3, dbopubsubjectmould.getMid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboPubSubjectmould dbopubsubjectmould) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_pub_subjectmould(`id`,`sid`,`mid`) values(?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbopubsubjectmould.getId());
		dbc.setInt(2, dbopubsubjectmould.getSid());
		dbc.setInt(3, dbopubsubjectmould.getMid());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboPubSubjectmould dbopubsubjectmould) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_pub_subjectmould set ");
		boolean flag = false;
		if(dbopubsubjectmould.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbopubsubjectmould.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",sid=?");
			}else{
				sb.append("sid=?");
				flag=true;
			}
		}
		if(dbopubsubjectmould.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",mid=?");
			}else{
				sb.append("mid=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbopubsubjectmould.COLUMN_FLAG[0]){
			dbc.setInt(k, dbopubsubjectmould.getId());k++;
		}
		if(dbopubsubjectmould.COLUMN_FLAG[1]){
			dbc.setInt(k, dbopubsubjectmould.getSid());k++;
		}
		if(dbopubsubjectmould.COLUMN_FLAG[2]){
			dbc.setInt(k, dbopubsubjectmould.getMid());k++;
		}
		dbc.setInt(k, dbopubsubjectmould.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboPubSubjectmould dbopubsubjectmould) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbopubsubjectmould);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}