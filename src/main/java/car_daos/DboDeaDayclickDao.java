package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaDayclick;

public class  DboDeaDayclickDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaDayclick dbodeadayclick) throws SQLException {
		dbodeadayclick.setId(rs.getLong("id"));//
		dbodeadayclick.setClicktype(rs.getInt("clicktype"));//
		dbodeadayclick.setDeaid(rs.getInt("deaid"));//
		dbodeadayclick.setClickcount(rs.getInt("clickcount"));//
		dbodeadayclick.setAdddate(rs.getString("adddate"));//
	}

	public static List<DboDeaDayclick> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_dayclick";
		List<DboDeaDayclick> list = new ArrayList<DboDeaDayclick>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaDayclick dbodeadayclick = new DboDeaDayclick();
				fill(rs, dbodeadayclick);
				list.add(dbodeadayclick);
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


	public static List<DboDeaDayclick> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_dayclick where "+subsql+"";
		List<DboDeaDayclick> list = new ArrayList<DboDeaDayclick>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaDayclick dbodeadayclick = new DboDeaDayclick();
				fill(rs, dbodeadayclick);
				list.add(dbodeadayclick);
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
		String sql = "select count(*) from dbo_dea_dayclick where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_dayclick where "+subsql+"";
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
		String sql = "delete from dbo_dea_dayclick where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaDayclick dbodeadayclick) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_dayclick(`id`,`clicktype`,`deaid`,`clickcount`,`adddate`) values(?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setLong(1, dbodeadayclick.getId());
		dbc.setInt(2, dbodeadayclick.getClicktype());
		dbc.setInt(3, dbodeadayclick.getDeaid());
		dbc.setInt(4, dbodeadayclick.getClickcount());
		dbc.setString(5, dbodeadayclick.getAdddate());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaDayclick dbodeadayclick) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_dayclick(`id`,`clicktype`,`deaid`,`clickcount`,`adddate`) values(?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setLong(1, dbodeadayclick.getId());
		dbc.setInt(2, dbodeadayclick.getClicktype());
		dbc.setInt(3, dbodeadayclick.getDeaid());
		dbc.setInt(4, dbodeadayclick.getClickcount());
		dbc.setString(5, dbodeadayclick.getAdddate());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaDayclick dbodeadayclick) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_dayclick set ");
		boolean flag = false;
		if(dbodeadayclick.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodeadayclick.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",clicktype=?");
			}else{
				sb.append("clicktype=?");
				flag=true;
			}
		}
		if(dbodeadayclick.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",deaid=?");
			}else{
				sb.append("deaid=?");
				flag=true;
			}
		}
		if(dbodeadayclick.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",clickcount=?");
			}else{
				sb.append("clickcount=?");
				flag=true;
			}
		}
		if(dbodeadayclick.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeadayclick.COLUMN_FLAG[0]){
			dbc.setLong(k, dbodeadayclick.getId());k++;
		}
		if(dbodeadayclick.COLUMN_FLAG[1]){
			dbc.setInt(k, dbodeadayclick.getClicktype());k++;
		}
		if(dbodeadayclick.COLUMN_FLAG[2]){
			dbc.setInt(k, dbodeadayclick.getDeaid());k++;
		}
		if(dbodeadayclick.COLUMN_FLAG[3]){
			dbc.setInt(k, dbodeadayclick.getClickcount());k++;
		}
		if(dbodeadayclick.COLUMN_FLAG[4]){
			dbc.setString(k, dbodeadayclick.getAdddate());k++;
		}
		dbc.setLong(k, dbodeadayclick.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaDayclick dbodeadayclick) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeadayclick);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}