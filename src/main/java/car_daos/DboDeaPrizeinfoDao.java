package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaPrizeinfo;

public class  DboDeaPrizeinfoDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaPrizeinfo dbodeaprizeinfo) throws SQLException {
		dbodeaprizeinfo.setId(rs.getInt("id"));//
		dbodeaprizeinfo.setAid(rs.getInt("aid"));//
		dbodeaprizeinfo.setName(rs.getString("name"));//奖品名称
		dbodeaprizeinfo.setCount(rs.getInt("count"));//数量
		dbodeaprizeinfo.setUrl(rs.getString("url"));//
		dbodeaprizeinfo.setChance(rs.getDouble("chance"));//概率
	}

	public static List<DboDeaPrizeinfo> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_prizeinfo";
		List<DboDeaPrizeinfo> list = new ArrayList<DboDeaPrizeinfo>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaPrizeinfo dbodeaprizeinfo = new DboDeaPrizeinfo();
				fill(rs, dbodeaprizeinfo);
				list.add(dbodeaprizeinfo);
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


	public static List<DboDeaPrizeinfo> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_prizeinfo where "+subsql+"";
		List<DboDeaPrizeinfo> list = new ArrayList<DboDeaPrizeinfo>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaPrizeinfo dbodeaprizeinfo = new DboDeaPrizeinfo();
				fill(rs, dbodeaprizeinfo);
				list.add(dbodeaprizeinfo);
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
		String sql = "select count(*) from dbo_dea_prizeinfo where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_prizeinfo where "+subsql+"";
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
		String sql = "delete from dbo_dea_prizeinfo where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaPrizeinfo dbodeaprizeinfo) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_prizeinfo(`id`,`aid`,`name`,`count`,`url`,`chance`) values(?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeaprizeinfo.getId());
		dbc.setInt(2, dbodeaprizeinfo.getAid());
		dbc.setString(3, dbodeaprizeinfo.getName());
		dbc.setInt(4, dbodeaprizeinfo.getCount());
		dbc.setString(5, dbodeaprizeinfo.getUrl());
		dbc.setDouble(6, dbodeaprizeinfo.getChance());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaPrizeinfo dbodeaprizeinfo) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_prizeinfo(`id`,`aid`,`name`,`count`,`url`,`chance`) values(?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeaprizeinfo.getId());
		dbc.setInt(2, dbodeaprizeinfo.getAid());
		dbc.setString(3, dbodeaprizeinfo.getName());
		dbc.setInt(4, dbodeaprizeinfo.getCount());
		dbc.setString(5, dbodeaprizeinfo.getUrl());
		dbc.setDouble(6, dbodeaprizeinfo.getChance());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaPrizeinfo dbodeaprizeinfo) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_prizeinfo set ");
		boolean flag = false;
		if(dbodeaprizeinfo.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodeaprizeinfo.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",aid=?");
			}else{
				sb.append("aid=?");
				flag=true;
			}
		}
		if(dbodeaprizeinfo.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",name=?");
			}else{
				sb.append("name=?");
				flag=true;
			}
		}
		if(dbodeaprizeinfo.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",count=?");
			}else{
				sb.append("count=?");
				flag=true;
			}
		}
		if(dbodeaprizeinfo.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",url=?");
			}else{
				sb.append("url=?");
				flag=true;
			}
		}
		if(dbodeaprizeinfo.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",chance=?");
			}else{
				sb.append("chance=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeaprizeinfo.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeaprizeinfo.getId());k++;
		}
		if(dbodeaprizeinfo.COLUMN_FLAG[1]){
			dbc.setInt(k, dbodeaprizeinfo.getAid());k++;
		}
		if(dbodeaprizeinfo.COLUMN_FLAG[2]){
			dbc.setString(k, dbodeaprizeinfo.getName());k++;
		}
		if(dbodeaprizeinfo.COLUMN_FLAG[3]){
			dbc.setInt(k, dbodeaprizeinfo.getCount());k++;
		}
		if(dbodeaprizeinfo.COLUMN_FLAG[4]){
			dbc.setString(k, dbodeaprizeinfo.getUrl());k++;
		}
		if(dbodeaprizeinfo.COLUMN_FLAG[5]){
			dbc.setDouble(k, dbodeaprizeinfo.getChance());k++;
		}
		dbc.setInt(k, dbodeaprizeinfo.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaPrizeinfo dbodeaprizeinfo) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeaprizeinfo);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}