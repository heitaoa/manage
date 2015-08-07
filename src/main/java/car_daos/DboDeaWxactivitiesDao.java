package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaWxactivities;

public class  DboDeaWxactivitiesDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaWxactivities dbodeawxactivities) throws SQLException {
		dbodeawxactivities.setId(rs.getInt("id"));//
		dbodeawxactivities.setName(rs.getString("name"));//
		dbodeawxactivities.setType(rs.getInt("type"));//
		dbodeawxactivities.setIntro(rs.getString("intro"));//
		dbodeawxactivities.setEid(rs.getInt("eid"));//
		dbodeawxactivities.setStime(rs.getTimestamp("stime"));//
		dbodeawxactivities.setEtime(rs.getTimestamp("etime"));//
		dbodeawxactivities.setAddtime(rs.getTimestamp("addtime"));//
		dbodeawxactivities.setUrl(rs.getString("url"));//
		dbodeawxactivities.setKey(rs.getString("key"));//
		dbodeawxactivities.setState(rs.getInt("state"));//
		dbodeawxactivities.setCount(rs.getInt("count"));//
	}

	public static List<DboDeaWxactivities> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_wxactivities";
		List<DboDeaWxactivities> list = new ArrayList<DboDeaWxactivities>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaWxactivities dbodeawxactivities = new DboDeaWxactivities();
				fill(rs, dbodeawxactivities);
				list.add(dbodeawxactivities);
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


	public static List<DboDeaWxactivities> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_wxactivities where "+subsql+"";
		List<DboDeaWxactivities> list = new ArrayList<DboDeaWxactivities>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaWxactivities dbodeawxactivities = new DboDeaWxactivities();
				fill(rs, dbodeawxactivities);
				list.add(dbodeawxactivities);
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
		String sql = "select count(*) from dbo_dea_wxactivities where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_wxactivities where "+subsql+"";
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
		String sql = "delete from dbo_dea_wxactivities where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaWxactivities dbodeawxactivities) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_wxactivities(`id`,`name`,`type`,`intro`,`eid`,`stime`,`etime`,`addtime`,`url`,`key`,`state`,`count`) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeawxactivities.getId());
		dbc.setString(2, dbodeawxactivities.getName());
		dbc.setInt(3, dbodeawxactivities.getType());
		dbc.setString(4, dbodeawxactivities.getIntro());
		dbc.setInt(5, dbodeawxactivities.getEid());
		dbc.setTimestamp(6, new Timestamp(dbodeawxactivities.getStime().getTime()));
		dbc.setTimestamp(7, new Timestamp(dbodeawxactivities.getEtime().getTime()));
		dbc.setTimestamp(8, new Timestamp(dbodeawxactivities.getAddtime().getTime()));
		dbc.setString(9, dbodeawxactivities.getUrl());
		dbc.setString(10, dbodeawxactivities.getKey());
		dbc.setInt(11, dbodeawxactivities.getState());
		dbc.setInt(12, dbodeawxactivities.getCount());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaWxactivities dbodeawxactivities) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_wxactivities(`id`,`name`,`type`,`intro`,`eid`,`stime`,`etime`,`addtime`,`url`,`key`,`state`,`count`) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeawxactivities.getId());
		dbc.setString(2, dbodeawxactivities.getName());
		dbc.setInt(3, dbodeawxactivities.getType());
		dbc.setString(4, dbodeawxactivities.getIntro());
		dbc.setInt(5, dbodeawxactivities.getEid());
		dbc.setTimestamp(6, new Timestamp(dbodeawxactivities.getStime().getTime()));
		dbc.setTimestamp(7, new Timestamp(dbodeawxactivities.getEtime().getTime()));
		dbc.setTimestamp(8, new Timestamp(dbodeawxactivities.getAddtime().getTime()));
		dbc.setString(9, dbodeawxactivities.getUrl());
		dbc.setString(10, dbodeawxactivities.getKey());
		dbc.setInt(11, dbodeawxactivities.getState());
		dbc.setInt(12, dbodeawxactivities.getCount());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaWxactivities dbodeawxactivities) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_wxactivities set ");
		boolean flag = false;
		if(dbodeawxactivities.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodeawxactivities.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",name=?");
			}else{
				sb.append("name=?");
				flag=true;
			}
		}
		if(dbodeawxactivities.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",type=?");
			}else{
				sb.append("type=?");
				flag=true;
			}
		}
		if(dbodeawxactivities.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",intro=?");
			}else{
				sb.append("intro=?");
				flag=true;
			}
		}
		if(dbodeawxactivities.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",eid=?");
			}else{
				sb.append("eid=?");
				flag=true;
			}
		}
		if(dbodeawxactivities.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",stime=?");
			}else{
				sb.append("stime=?");
				flag=true;
			}
		}
		if(dbodeawxactivities.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",etime=?");
			}else{
				sb.append("etime=?");
				flag=true;
			}
		}
		if(dbodeawxactivities.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",addtime=?");
			}else{
				sb.append("addtime=?");
				flag=true;
			}
		}
		if(dbodeawxactivities.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",url=?");
			}else{
				sb.append("url=?");
				flag=true;
			}
		}
		if(dbodeawxactivities.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",key=?");
			}else{
				sb.append("key=?");
				flag=true;
			}
		}
		if(dbodeawxactivities.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",state=?");
			}else{
				sb.append("state=?");
				flag=true;
			}
		}
		if(dbodeawxactivities.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",count=?");
			}else{
				sb.append("count=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeawxactivities.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeawxactivities.getId());k++;
		}
		if(dbodeawxactivities.COLUMN_FLAG[1]){
			dbc.setString(k, dbodeawxactivities.getName());k++;
		}
		if(dbodeawxactivities.COLUMN_FLAG[2]){
			dbc.setInt(k, dbodeawxactivities.getType());k++;
		}
		if(dbodeawxactivities.COLUMN_FLAG[3]){
			dbc.setString(k, dbodeawxactivities.getIntro());k++;
		}
		if(dbodeawxactivities.COLUMN_FLAG[4]){
			dbc.setInt(k, dbodeawxactivities.getEid());k++;
		}
		if(dbodeawxactivities.COLUMN_FLAG[5]){
			dbc.setTimestamp(k, new Timestamp(dbodeawxactivities.getStime().getTime()));k++;
		}
		if(dbodeawxactivities.COLUMN_FLAG[6]){
			dbc.setTimestamp(k, new Timestamp(dbodeawxactivities.getEtime().getTime()));k++;
		}
		if(dbodeawxactivities.COLUMN_FLAG[7]){
			dbc.setTimestamp(k, new Timestamp(dbodeawxactivities.getAddtime().getTime()));k++;
		}
		if(dbodeawxactivities.COLUMN_FLAG[8]){
			dbc.setString(k, dbodeawxactivities.getUrl());k++;
		}
		if(dbodeawxactivities.COLUMN_FLAG[9]){
			dbc.setString(k, dbodeawxactivities.getKey());k++;
		}
		if(dbodeawxactivities.COLUMN_FLAG[10]){
			dbc.setInt(k, dbodeawxactivities.getState());k++;
		}
		if(dbodeawxactivities.COLUMN_FLAG[11]){
			dbc.setInt(k, dbodeawxactivities.getCount());k++;
		}
		dbc.setInt(k, dbodeawxactivities.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaWxactivities dbodeawxactivities) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeawxactivities);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}