package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaBackdayclick;

public class  DboDeaBackdayclickDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaBackdayclick dbodeabackdayclick) throws SQLException {
		dbodeabackdayclick.setId(rs.getInt("id"));//
		dbodeabackdayclick.setClicktype(rs.getInt("clicktype"));//
		dbodeabackdayclick.setDeaid(rs.getInt("deaid"));//
		dbodeabackdayclick.setClickcount(rs.getInt("clickcount"));//
		dbodeabackdayclick.setAdddate(rs.getString("adddate"));//
	}

	public static List<DboDeaBackdayclick> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_backdayclick";
		List<DboDeaBackdayclick> list = new ArrayList<DboDeaBackdayclick>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaBackdayclick dbodeabackdayclick = new DboDeaBackdayclick();
				fill(rs, dbodeabackdayclick);
				list.add(dbodeabackdayclick);
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


	public static List<DboDeaBackdayclick> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_backdayclick where "+subsql+"";
		List<DboDeaBackdayclick> list = new ArrayList<DboDeaBackdayclick>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaBackdayclick dbodeabackdayclick = new DboDeaBackdayclick();
				fill(rs, dbodeabackdayclick);
				list.add(dbodeabackdayclick);
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
		String sql = "select count(*) from dbo_dea_backdayclick where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_backdayclick where "+subsql+"";
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
		String sql = "delete from dbo_dea_backdayclick where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaBackdayclick dbodeabackdayclick) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_backdayclick(`id`,`clicktype`,`deaid`,`clickcount`,`adddate`) values(?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeabackdayclick.getId());
		dbc.setInt(2, dbodeabackdayclick.getClicktype());
		dbc.setInt(3, dbodeabackdayclick.getDeaid());
		dbc.setInt(4, dbodeabackdayclick.getClickcount());
		dbc.setString(5, dbodeabackdayclick.getAdddate());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaBackdayclick dbodeabackdayclick) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_backdayclick(`id`,`clicktype`,`deaid`,`clickcount`,`adddate`) values(?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeabackdayclick.getId());
		dbc.setInt(2, dbodeabackdayclick.getClicktype());
		dbc.setInt(3, dbodeabackdayclick.getDeaid());
		dbc.setInt(4, dbodeabackdayclick.getClickcount());
		dbc.setString(5, dbodeabackdayclick.getAdddate());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaBackdayclick dbodeabackdayclick) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_backdayclick set ");
		boolean flag = false;
		if(dbodeabackdayclick.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodeabackdayclick.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",clicktype=?");
			}else{
				sb.append("clicktype=?");
				flag=true;
			}
		}
		if(dbodeabackdayclick.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",deaid=?");
			}else{
				sb.append("deaid=?");
				flag=true;
			}
		}
		if(dbodeabackdayclick.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",clickcount=?");
			}else{
				sb.append("clickcount=?");
				flag=true;
			}
		}
		if(dbodeabackdayclick.COLUMN_FLAG[4]){
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
		if(dbodeabackdayclick.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeabackdayclick.getId());k++;
		}
		if(dbodeabackdayclick.COLUMN_FLAG[1]){
			dbc.setInt(k, dbodeabackdayclick.getClicktype());k++;
		}
		if(dbodeabackdayclick.COLUMN_FLAG[2]){
			dbc.setInt(k, dbodeabackdayclick.getDeaid());k++;
		}
		if(dbodeabackdayclick.COLUMN_FLAG[3]){
			dbc.setInt(k, dbodeabackdayclick.getClickcount());k++;
		}
		if(dbodeabackdayclick.COLUMN_FLAG[4]){
			dbc.setString(k, dbodeabackdayclick.getAdddate());k++;
		}
		dbc.setInt(k, dbodeabackdayclick.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaBackdayclick dbodeabackdayclick) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeabackdayclick);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}