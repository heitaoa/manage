package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboCarSerialpeizhides;

public class  DboCarSerialpeizhidesDao  extends BaseDao {

	public static void fill(ResultSet rs, DboCarSerialpeizhides dbocarserialpeizhides) throws SQLException {
		dbocarserialpeizhides.setSerialid(rs.getInt("serialid"));//
		dbocarserialpeizhides.setLink1(rs.getString("link1"));//
		dbocarserialpeizhides.setLink2(rs.getString("link2"));//
		dbocarserialpeizhides.setLink3(rs.getString("link3"));//
		dbocarserialpeizhides.setLink4(rs.getString("link4"));//
		dbocarserialpeizhides.setLink5(rs.getString("link5"));//
		dbocarserialpeizhides.setAdddate(rs.getTimestamp("adddate"));//
		dbocarserialpeizhides.setUpdatetime(rs.getTimestamp("updatetime"));//
		dbocarserialpeizhides.setIsdelete(rs.getInt("isdelete"));//
	}

	public static List<DboCarSerialpeizhides> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_car_serialpeizhides";
		List<DboCarSerialpeizhides> list = new ArrayList<DboCarSerialpeizhides>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarSerialpeizhides dbocarserialpeizhides = new DboCarSerialpeizhides();
				fill(rs, dbocarserialpeizhides);
				list.add(dbocarserialpeizhides);
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


	public static List<DboCarSerialpeizhides> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_car_serialpeizhides where "+subsql+"";
		List<DboCarSerialpeizhides> list = new ArrayList<DboCarSerialpeizhides>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarSerialpeizhides dbocarserialpeizhides = new DboCarSerialpeizhides();
				fill(rs, dbocarserialpeizhides);
				list.add(dbocarserialpeizhides);
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
		String sql = "select count(*) from dbo_car_serialpeizhides where "+subsql+"";
		
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
		String sql = "delete from dbo_car_serialpeizhides where "+subsql+"";
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
		String sql = "delete from dbo_car_serialpeizhides where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboCarSerialpeizhides dbocarserialpeizhides) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_car_serialpeizhides(`serialid`,`link1`,`link2`,`link3`,`link4`,`link5`,`adddate`,`updatetime`,`isdelete`) values(?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbocarserialpeizhides.getSerialid());
		dbc.setString(2, dbocarserialpeizhides.getLink1());
		dbc.setString(3, dbocarserialpeizhides.getLink2());
		dbc.setString(4, dbocarserialpeizhides.getLink3());
		dbc.setString(5, dbocarserialpeizhides.getLink4());
		dbc.setString(6, dbocarserialpeizhides.getLink5());
		dbc.setTimestamp(7, new Timestamp(dbocarserialpeizhides.getAdddate().getTime()));
		dbc.setTimestamp(8, new Timestamp(dbocarserialpeizhides.getUpdatetime().getTime()));
		dbc.setInt(9, dbocarserialpeizhides.getIsdelete());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboCarSerialpeizhides dbocarserialpeizhides) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_car_serialpeizhides(`serialid`,`link1`,`link2`,`link3`,`link4`,`link5`,`adddate`,`updatetime`,`isdelete`) values(?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbocarserialpeizhides.getSerialid());
		dbc.setString(2, dbocarserialpeizhides.getLink1());
		dbc.setString(3, dbocarserialpeizhides.getLink2());
		dbc.setString(4, dbocarserialpeizhides.getLink3());
		dbc.setString(5, dbocarserialpeizhides.getLink4());
		dbc.setString(6, dbocarserialpeizhides.getLink5());
		dbc.setTimestamp(7, new Timestamp(dbocarserialpeizhides.getAdddate().getTime()));
		dbc.setTimestamp(8, new Timestamp(dbocarserialpeizhides.getUpdatetime().getTime()));
		dbc.setInt(9, dbocarserialpeizhides.getIsdelete());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboCarSerialpeizhides dbocarserialpeizhides) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_car_serialpeizhides set ");
		boolean flag = false;
		if(dbocarserialpeizhides.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",serialid=?");
			}else{
				sb.append("serialid=?");
				flag=true;
			}
		}
		if(dbocarserialpeizhides.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",link1=?");
			}else{
				sb.append("link1=?");
				flag=true;
			}
		}
		if(dbocarserialpeizhides.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",link2=?");
			}else{
				sb.append("link2=?");
				flag=true;
			}
		}
		if(dbocarserialpeizhides.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",link3=?");
			}else{
				sb.append("link3=?");
				flag=true;
			}
		}
		if(dbocarserialpeizhides.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",link4=?");
			}else{
				sb.append("link4=?");
				flag=true;
			}
		}
		if(dbocarserialpeizhides.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",link5=?");
			}else{
				sb.append("link5=?");
				flag=true;
			}
		}
		if(dbocarserialpeizhides.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbocarserialpeizhides.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",updatetime=?");
			}else{
				sb.append("updatetime=?");
				flag=true;
			}
		}
		if(dbocarserialpeizhides.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		sb.append(" where serialid=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbocarserialpeizhides.COLUMN_FLAG[0]){
			dbc.setInt(k, dbocarserialpeizhides.getSerialid());k++;
		}
		if(dbocarserialpeizhides.COLUMN_FLAG[1]){
			dbc.setString(k, dbocarserialpeizhides.getLink1());k++;
		}
		if(dbocarserialpeizhides.COLUMN_FLAG[2]){
			dbc.setString(k, dbocarserialpeizhides.getLink2());k++;
		}
		if(dbocarserialpeizhides.COLUMN_FLAG[3]){
			dbc.setString(k, dbocarserialpeizhides.getLink3());k++;
		}
		if(dbocarserialpeizhides.COLUMN_FLAG[4]){
			dbc.setString(k, dbocarserialpeizhides.getLink4());k++;
		}
		if(dbocarserialpeizhides.COLUMN_FLAG[5]){
			dbc.setString(k, dbocarserialpeizhides.getLink5());k++;
		}
		if(dbocarserialpeizhides.COLUMN_FLAG[6]){
			dbc.setTimestamp(k, new Timestamp(dbocarserialpeizhides.getAdddate().getTime()));k++;
		}
		if(dbocarserialpeizhides.COLUMN_FLAG[7]){
			dbc.setTimestamp(k, new Timestamp(dbocarserialpeizhides.getUpdatetime().getTime()));k++;
		}
		if(dbocarserialpeizhides.COLUMN_FLAG[8]){
			dbc.setInt(k, dbocarserialpeizhides.getIsdelete());k++;
		}
		dbc.setInt(k, dbocarserialpeizhides.getSerialid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboCarSerialpeizhides dbocarserialpeizhides) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbocarserialpeizhides);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}