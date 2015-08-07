package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaWxintmsg;

public class  DboDeaWxintmsgDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaWxintmsg dbodeawxintmsg) throws SQLException {
		dbodeawxintmsg.setId(rs.getInt("id"));//
		dbodeawxintmsg.setEid(rs.getInt("eid"));//
		dbodeawxintmsg.setKeyword(rs.getString("keyword"));//
		dbodeawxintmsg.setMsg_type(rs.getString("msg_type"));//回复类型：1:文字；2：图文
		dbodeawxintmsg.setMsg_content(rs.getString("msg_content"));//回复内容
		dbodeawxintmsg.setAdddate(rs.getTimestamp("adddate"));//
	}

	public static List<DboDeaWxintmsg> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_wxintmsg";
		List<DboDeaWxintmsg> list = new ArrayList<DboDeaWxintmsg>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaWxintmsg dbodeawxintmsg = new DboDeaWxintmsg();
				fill(rs, dbodeawxintmsg);
				list.add(dbodeawxintmsg);
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


	public static List<DboDeaWxintmsg> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_wxintmsg where "+subsql+"";
		List<DboDeaWxintmsg> list = new ArrayList<DboDeaWxintmsg>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaWxintmsg dbodeawxintmsg = new DboDeaWxintmsg();
				fill(rs, dbodeawxintmsg);
				list.add(dbodeawxintmsg);
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
		String sql = "select count(*) from dbo_dea_wxintmsg where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_wxintmsg where "+subsql+"";
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
		String sql = "delete from dbo_dea_wxintmsg where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaWxintmsg dbodeawxintmsg) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_wxintmsg(`id`,`eid`,`keyword`,`msg_type`,`msg_content`,`adddate`) values(?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeawxintmsg.getId());
		dbc.setInt(2, dbodeawxintmsg.getEid());
		dbc.setString(3, dbodeawxintmsg.getKeyword());
		dbc.setString(4, dbodeawxintmsg.getMsg_type());
		dbc.setString(5, dbodeawxintmsg.getMsg_content());
		dbc.setTimestamp(6, new Timestamp(dbodeawxintmsg.getAdddate().getTime()));
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaWxintmsg dbodeawxintmsg) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_wxintmsg(`id`,`eid`,`keyword`,`msg_type`,`msg_content`,`adddate`) values(?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeawxintmsg.getId());
		dbc.setInt(2, dbodeawxintmsg.getEid());
		dbc.setString(3, dbodeawxintmsg.getKeyword());
		dbc.setString(4, dbodeawxintmsg.getMsg_type());
		dbc.setString(5, dbodeawxintmsg.getMsg_content());
		dbc.setTimestamp(6, new Timestamp(dbodeawxintmsg.getAdddate().getTime()));
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaWxintmsg dbodeawxintmsg) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_wxintmsg set ");
		boolean flag = false;
		if(dbodeawxintmsg.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodeawxintmsg.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",eid=?");
			}else{
				sb.append("eid=?");
				flag=true;
			}
		}
		if(dbodeawxintmsg.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",keyword=?");
			}else{
				sb.append("keyword=?");
				flag=true;
			}
		}
		if(dbodeawxintmsg.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",msg_type=?");
			}else{
				sb.append("msg_type=?");
				flag=true;
			}
		}
		if(dbodeawxintmsg.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",msg_content=?");
			}else{
				sb.append("msg_content=?");
				flag=true;
			}
		}
		if(dbodeawxintmsg.COLUMN_FLAG[5]){
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
		if(dbodeawxintmsg.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeawxintmsg.getId());k++;
		}
		if(dbodeawxintmsg.COLUMN_FLAG[1]){
			dbc.setInt(k, dbodeawxintmsg.getEid());k++;
		}
		if(dbodeawxintmsg.COLUMN_FLAG[2]){
			dbc.setString(k, dbodeawxintmsg.getKeyword());k++;
		}
		if(dbodeawxintmsg.COLUMN_FLAG[3]){
			dbc.setString(k, dbodeawxintmsg.getMsg_type());k++;
		}
		if(dbodeawxintmsg.COLUMN_FLAG[4]){
			dbc.setString(k, dbodeawxintmsg.getMsg_content());k++;
		}
		if(dbodeawxintmsg.COLUMN_FLAG[5]){
			dbc.setTimestamp(k, new Timestamp(dbodeawxintmsg.getAdddate().getTime()));k++;
		}
		dbc.setInt(k, dbodeawxintmsg.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaWxintmsg dbodeawxintmsg) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeawxintmsg);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}