package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaClick;

public class  DboDeaClickDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaClick dbodeaclick) throws SQLException {
		dbodeaclick.setId(rs.getInt("id"));//
		dbodeaclick.setClicktype(rs.getInt("clicktype"));//
		dbodeaclick.setDeaid(rs.getInt("deaid"));//
		dbodeaclick.setAdddate(rs.getTimestamp("adddate"));//
		dbodeaclick.setClickcount(rs.getInt("clickcount"));//
	}

	public static List<DboDeaClick> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_click";
		List<DboDeaClick> list = new ArrayList<DboDeaClick>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaClick dbodeaclick = new DboDeaClick();
				fill(rs, dbodeaclick);
				list.add(dbodeaclick);
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


	public static List<DboDeaClick> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_click where "+subsql+"";
		List<DboDeaClick> list = new ArrayList<DboDeaClick>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaClick dbodeaclick = new DboDeaClick();
				fill(rs, dbodeaclick);
				list.add(dbodeaclick);
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
		String sql = "select count(*) from dbo_dea_click where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_click where "+subsql+"";
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
		String sql = "delete from dbo_dea_click where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaClick dbodeaclick) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_click(`id`,`clicktype`,`deaid`,`adddate`,`clickcount`) values(?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeaclick.getId());
		dbc.setInt(2, dbodeaclick.getClicktype());
		dbc.setInt(3, dbodeaclick.getDeaid());
		dbc.setTimestamp(4, new Timestamp(dbodeaclick.getAdddate().getTime()));
		dbc.setInt(5, dbodeaclick.getClickcount());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaClick dbodeaclick) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_click(`id`,`clicktype`,`deaid`,`adddate`,`clickcount`) values(?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeaclick.getId());
		dbc.setInt(2, dbodeaclick.getClicktype());
		dbc.setInt(3, dbodeaclick.getDeaid());
		dbc.setTimestamp(4, new Timestamp(dbodeaclick.getAdddate().getTime()));
		dbc.setInt(5, dbodeaclick.getClickcount());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaClick dbodeaclick) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_click set ");
		boolean flag = false;
		if(dbodeaclick.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodeaclick.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",clicktype=?");
			}else{
				sb.append("clicktype=?");
				flag=true;
			}
		}
		if(dbodeaclick.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",deaid=?");
			}else{
				sb.append("deaid=?");
				flag=true;
			}
		}
		if(dbodeaclick.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbodeaclick.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",clickcount=?");
			}else{
				sb.append("clickcount=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeaclick.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeaclick.getId());k++;
		}
		if(dbodeaclick.COLUMN_FLAG[1]){
			dbc.setInt(k, dbodeaclick.getClicktype());k++;
		}
		if(dbodeaclick.COLUMN_FLAG[2]){
			dbc.setInt(k, dbodeaclick.getDeaid());k++;
		}
		if(dbodeaclick.COLUMN_FLAG[3]){
			dbc.setTimestamp(k, new Timestamp(dbodeaclick.getAdddate().getTime()));k++;
		}
		if(dbodeaclick.COLUMN_FLAG[4]){
			dbc.setInt(k, dbodeaclick.getClickcount());k++;
		}
		dbc.setInt(k, dbodeaclick.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaClick dbodeaclick) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeaclick);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}