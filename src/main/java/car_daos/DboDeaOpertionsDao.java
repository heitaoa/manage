package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaOpertions;

public class  DboDeaOpertionsDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaOpertions dbodeaopertions) throws SQLException {
		dbodeaopertions.setId(rs.getInt("id"));//
		dbodeaopertions.setEid(rs.getInt("eid"));//
		dbodeaopertions.setScores(rs.getInt("scores"));//
		dbodeaopertions.setType(rs.getInt("type"));//得分缘由
		dbodeaopertions.setAdddate(rs.getTimestamp("adddate"));//日期
	}

	public static List<DboDeaOpertions> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_opertions";
		List<DboDeaOpertions> list = new ArrayList<DboDeaOpertions>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaOpertions dbodeaopertions = new DboDeaOpertions();
				fill(rs, dbodeaopertions);
				list.add(dbodeaopertions);
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


	public static List<DboDeaOpertions> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_opertions where "+subsql+"";
		List<DboDeaOpertions> list = new ArrayList<DboDeaOpertions>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaOpertions dbodeaopertions = new DboDeaOpertions();
				fill(rs, dbodeaopertions);
				list.add(dbodeaopertions);
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
		String sql = "select count(*) from dbo_dea_opertions where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_opertions where "+subsql+"";
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
		String sql = "delete from dbo_dea_opertions where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaOpertions dbodeaopertions) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_opertions(`id`,`eid`,`scores`,`type`,`adddate`) values(?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeaopertions.getId());
		dbc.setInt(2, dbodeaopertions.getEid());
		dbc.setInt(3, dbodeaopertions.getScores());
		dbc.setInt(4, dbodeaopertions.getType());
		dbc.setTimestamp(5, new Timestamp(dbodeaopertions.getAdddate().getTime()));
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaOpertions dbodeaopertions) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_opertions(`id`,`eid`,`scores`,`type`,`adddate`) values(?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeaopertions.getId());
		dbc.setInt(2, dbodeaopertions.getEid());
		dbc.setInt(3, dbodeaopertions.getScores());
		dbc.setInt(4, dbodeaopertions.getType());
		dbc.setTimestamp(5, new Timestamp(dbodeaopertions.getAdddate().getTime()));
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaOpertions dbodeaopertions) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_opertions set ");
		boolean flag = false;
		if(dbodeaopertions.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodeaopertions.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",eid=?");
			}else{
				sb.append("eid=?");
				flag=true;
			}
		}
		if(dbodeaopertions.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",scores=?");
			}else{
				sb.append("scores=?");
				flag=true;
			}
		}
		if(dbodeaopertions.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",type=?");
			}else{
				sb.append("type=?");
				flag=true;
			}
		}
		if(dbodeaopertions.COLUMN_FLAG[4]){
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
		if(dbodeaopertions.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeaopertions.getId());k++;
		}
		if(dbodeaopertions.COLUMN_FLAG[1]){
			dbc.setInt(k, dbodeaopertions.getEid());k++;
		}
		if(dbodeaopertions.COLUMN_FLAG[2]){
			dbc.setInt(k, dbodeaopertions.getScores());k++;
		}
		if(dbodeaopertions.COLUMN_FLAG[3]){
			dbc.setInt(k, dbodeaopertions.getType());k++;
		}
		if(dbodeaopertions.COLUMN_FLAG[4]){
			dbc.setTimestamp(k, new Timestamp(dbodeaopertions.getAdddate().getTime()));k++;
		}
		dbc.setInt(k, dbodeaopertions.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaOpertions dbodeaopertions) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeaopertions);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}