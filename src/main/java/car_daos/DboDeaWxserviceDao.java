package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaWxservice;

public class  DboDeaWxserviceDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaWxservice dbodeawxservice) throws SQLException {
		dbodeawxservice.setId(rs.getInt("id"));//
		dbodeawxservice.setEid(rs.getInt("eid"));//
		dbodeawxservice.setOpenid(rs.getString("openid"));//
		dbodeawxservice.setStars(rs.getInt("stars"));//
		dbodeawxservice.setComment(rs.getString("comment"));//
		dbodeawxservice.setAdddate(rs.getTimestamp("adddate"));//
		dbodeawxservice.setComtype(rs.getInt("comtype"));//
		dbodeawxservice.setPlaceid(rs.getInt("placeid"));//
	}

	public static List<DboDeaWxservice> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_wxservice";
		List<DboDeaWxservice> list = new ArrayList<DboDeaWxservice>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaWxservice dbodeawxservice = new DboDeaWxservice();
				fill(rs, dbodeawxservice);
				list.add(dbodeawxservice);
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


	public static List<DboDeaWxservice> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_wxservice where "+subsql+"";
		List<DboDeaWxservice> list = new ArrayList<DboDeaWxservice>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaWxservice dbodeawxservice = new DboDeaWxservice();
				fill(rs, dbodeawxservice);
				list.add(dbodeawxservice);
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
		String sql = "select count(*) from dbo_dea_wxservice where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_wxservice where "+subsql+"";
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
		String sql = "delete from dbo_dea_wxservice where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaWxservice dbodeawxservice) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_wxservice(`id`,`eid`,`openid`,`stars`,`comment`,`adddate`,`comtype`,`placeid`) values(?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeawxservice.getId());
		dbc.setInt(2, dbodeawxservice.getEid());
		dbc.setString(3, dbodeawxservice.getOpenid());
		dbc.setInt(4, dbodeawxservice.getStars());
		dbc.setString(5, dbodeawxservice.getComment());
		dbc.setTimestamp(6, new Timestamp(dbodeawxservice.getAdddate().getTime()));
		dbc.setInt(7, dbodeawxservice.getComtype());
		dbc.setInt(8, dbodeawxservice.getPlaceid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaWxservice dbodeawxservice) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_wxservice(`id`,`eid`,`openid`,`stars`,`comment`,`adddate`,`comtype`,`placeid`) values(?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeawxservice.getId());
		dbc.setInt(2, dbodeawxservice.getEid());
		dbc.setString(3, dbodeawxservice.getOpenid());
		dbc.setInt(4, dbodeawxservice.getStars());
		dbc.setString(5, dbodeawxservice.getComment());
		dbc.setTimestamp(6, new Timestamp(dbodeawxservice.getAdddate().getTime()));
		dbc.setInt(7, dbodeawxservice.getComtype());
		dbc.setInt(8, dbodeawxservice.getPlaceid());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaWxservice dbodeawxservice) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_wxservice set ");
		boolean flag = false;
		if(dbodeawxservice.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodeawxservice.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",eid=?");
			}else{
				sb.append("eid=?");
				flag=true;
			}
		}
		if(dbodeawxservice.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",openid=?");
			}else{
				sb.append("openid=?");
				flag=true;
			}
		}
		if(dbodeawxservice.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",stars=?");
			}else{
				sb.append("stars=?");
				flag=true;
			}
		}
		if(dbodeawxservice.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",comment=?");
			}else{
				sb.append("comment=?");
				flag=true;
			}
		}
		if(dbodeawxservice.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbodeawxservice.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",comtype=?");
			}else{
				sb.append("comtype=?");
				flag=true;
			}
		}
		if(dbodeawxservice.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",placeid=?");
			}else{
				sb.append("placeid=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeawxservice.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeawxservice.getId());k++;
		}
		if(dbodeawxservice.COLUMN_FLAG[1]){
			dbc.setInt(k, dbodeawxservice.getEid());k++;
		}
		if(dbodeawxservice.COLUMN_FLAG[2]){
			dbc.setString(k, dbodeawxservice.getOpenid());k++;
		}
		if(dbodeawxservice.COLUMN_FLAG[3]){
			dbc.setInt(k, dbodeawxservice.getStars());k++;
		}
		if(dbodeawxservice.COLUMN_FLAG[4]){
			dbc.setString(k, dbodeawxservice.getComment());k++;
		}
		if(dbodeawxservice.COLUMN_FLAG[5]){
			dbc.setTimestamp(k, new Timestamp(dbodeawxservice.getAdddate().getTime()));k++;
		}
		if(dbodeawxservice.COLUMN_FLAG[6]){
			dbc.setInt(k, dbodeawxservice.getComtype());k++;
		}
		if(dbodeawxservice.COLUMN_FLAG[7]){
			dbc.setInt(k, dbodeawxservice.getPlaceid());k++;
		}
		dbc.setInt(k, dbodeawxservice.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaWxservice dbodeawxservice) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeawxservice);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}