package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDntTousuDetail;

public class  DboDntTousuDetailDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDntTousuDetail dbodnttousudetail) throws SQLException {
		dbodnttousudetail.setId(rs.getInt("id"));//
		dbodnttousudetail.setTousuid(rs.getInt("tousuid"));//投诉表主键
		dbodnttousudetail.setContent(rs.getString("content"));//回复内容
		dbodnttousudetail.setAddtime(rs.getTimestamp("addtime"));//添加时间
	}

	public static List<DboDntTousuDetail> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dnt_tousu_detail";
		List<DboDntTousuDetail> list = new ArrayList<DboDntTousuDetail>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDntTousuDetail dbodnttousudetail = new DboDntTousuDetail();
				fill(rs, dbodnttousudetail);
				list.add(dbodnttousudetail);
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


	public static List<DboDntTousuDetail> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dnt_tousu_detail where "+subsql+"";
		List<DboDntTousuDetail> list = new ArrayList<DboDntTousuDetail>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDntTousuDetail dbodnttousudetail = new DboDntTousuDetail();
				fill(rs, dbodnttousudetail);
				list.add(dbodnttousudetail);
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
		String sql = "select count(*) from dbo_dnt_tousu_detail where "+subsql+"";
		
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
		String sql = "delete from dbo_dnt_tousu_detail where "+subsql+"";
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
		String sql = "delete from dbo_dnt_tousu_detail where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDntTousuDetail dbodnttousudetail) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dnt_tousu_detail(`id`,`tousuid`,`content`,`addtime`) values(?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodnttousudetail.getId());
		dbc.setInt(2, dbodnttousudetail.getTousuid());
		dbc.setString(3, dbodnttousudetail.getContent());
		dbc.setTimestamp(4, new Timestamp(dbodnttousudetail.getAddtime().getTime()));
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDntTousuDetail dbodnttousudetail) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dnt_tousu_detail(`id`,`tousuid`,`content`,`addtime`) values(?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodnttousudetail.getId());
		dbc.setInt(2, dbodnttousudetail.getTousuid());
		dbc.setString(3, dbodnttousudetail.getContent());
		dbc.setTimestamp(4, new Timestamp(dbodnttousudetail.getAddtime().getTime()));
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDntTousuDetail dbodnttousudetail) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dnt_tousu_detail set ");
		boolean flag = false;
		if(dbodnttousudetail.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodnttousudetail.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",tousuid=?");
			}else{
				sb.append("tousuid=?");
				flag=true;
			}
		}
		if(dbodnttousudetail.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",content=?");
			}else{
				sb.append("content=?");
				flag=true;
			}
		}
		if(dbodnttousudetail.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",addtime=?");
			}else{
				sb.append("addtime=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodnttousudetail.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodnttousudetail.getId());k++;
		}
		if(dbodnttousudetail.COLUMN_FLAG[1]){
			dbc.setInt(k, dbodnttousudetail.getTousuid());k++;
		}
		if(dbodnttousudetail.COLUMN_FLAG[2]){
			dbc.setString(k, dbodnttousudetail.getContent());k++;
		}
		if(dbodnttousudetail.COLUMN_FLAG[3]){
			dbc.setTimestamp(k, new Timestamp(dbodnttousudetail.getAddtime().getTime()));k++;
		}
		dbc.setInt(k, dbodnttousudetail.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDntTousuDetail dbodnttousudetail) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodnttousudetail);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}