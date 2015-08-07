package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaWxmsg;

public class  DboDeaWxmsgDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaWxmsg dbodeawxmsg) throws SQLException {
		dbodeawxmsg.setId(rs.getInt("id"));//
		dbodeawxmsg.setMsg_content(rs.getString("msg_content"));//
		dbodeawxmsg.setMsg_type(rs.getString("msg_type"));//
		dbodeawxmsg.setMsg_srl(rs.getString("msg_srl"));//
		dbodeawxmsg.setChange_time(rs.getString("change_time"));//
		dbodeawxmsg.setMsg_status(rs.getInt("msg_status"));//
		dbodeawxmsg.setRetry_num(rs.getInt("retry_num"));//
		dbodeawxmsg.setEid(rs.getInt("eid"));//
		dbodeawxmsg.setAdddate(rs.getTimestamp("adddate"));//
		dbodeawxmsg.setNewsid(rs.getInt("newsid"));//对应dea_news的id
		dbodeawxmsg.setNewscontent(rs.getString("newscontent"));//
		dbodeawxmsg.setTitle(rs.getString("title"));//新闻标题
		dbodeawxmsg.setFrom_type(rs.getInt("from_type"));//
	}

	public static List<DboDeaWxmsg> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_wxmsg";
		List<DboDeaWxmsg> list = new ArrayList<DboDeaWxmsg>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaWxmsg dbodeawxmsg = new DboDeaWxmsg();
				fill(rs, dbodeawxmsg);
				list.add(dbodeawxmsg);
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


	public static List<DboDeaWxmsg> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_wxmsg where "+subsql+"";
		List<DboDeaWxmsg> list = new ArrayList<DboDeaWxmsg>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaWxmsg dbodeawxmsg = new DboDeaWxmsg();
				fill(rs, dbodeawxmsg);
				list.add(dbodeawxmsg);
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
		String sql = "select count(*) from dbo_dea_wxmsg where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_wxmsg where "+subsql+"";
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
		String sql = "delete from dbo_dea_wxmsg where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaWxmsg dbodeawxmsg) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_wxmsg(`id`,`msg_content`,`msg_type`,`msg_srl`,`change_time`,`msg_status`,`retry_num`,`eid`,`adddate`,`newsid`,`newscontent`,`title`,`from_type`) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeawxmsg.getId());
		dbc.setString(2, dbodeawxmsg.getMsg_content());
		dbc.setString(3, dbodeawxmsg.getMsg_type());
		dbc.setString(4, dbodeawxmsg.getMsg_srl());
		dbc.setString(5, dbodeawxmsg.getChange_time());
		dbc.setInt(6, dbodeawxmsg.getMsg_status());
		dbc.setInt(7, dbodeawxmsg.getRetry_num());
		dbc.setInt(8, dbodeawxmsg.getEid());
		dbc.setTimestamp(9, new Timestamp(dbodeawxmsg.getAdddate().getTime()));
		dbc.setInt(10, dbodeawxmsg.getNewsid());
		dbc.setString(11, dbodeawxmsg.getNewscontent());
		dbc.setString(12, dbodeawxmsg.getTitle());
		dbc.setInt(13, dbodeawxmsg.getFrom_type());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaWxmsg dbodeawxmsg) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_wxmsg(`id`,`msg_content`,`msg_type`,`msg_srl`,`change_time`,`msg_status`,`retry_num`,`eid`,`adddate`,`newsid`,`newscontent`,`title`,`from_type`) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeawxmsg.getId());
		dbc.setString(2, dbodeawxmsg.getMsg_content());
		dbc.setString(3, dbodeawxmsg.getMsg_type());
		dbc.setString(4, dbodeawxmsg.getMsg_srl());
		dbc.setString(5, dbodeawxmsg.getChange_time());
		dbc.setInt(6, dbodeawxmsg.getMsg_status());
		dbc.setInt(7, dbodeawxmsg.getRetry_num());
		dbc.setInt(8, dbodeawxmsg.getEid());
		dbc.setTimestamp(9, new Timestamp(dbodeawxmsg.getAdddate().getTime()));
		dbc.setInt(10, dbodeawxmsg.getNewsid());
		dbc.setString(11, dbodeawxmsg.getNewscontent());
		dbc.setString(12, dbodeawxmsg.getTitle());
		dbc.setInt(13, dbodeawxmsg.getFrom_type());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaWxmsg dbodeawxmsg) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_wxmsg set ");
		boolean flag = false;
		if(dbodeawxmsg.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodeawxmsg.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",msg_content=?");
			}else{
				sb.append("msg_content=?");
				flag=true;
			}
		}
		if(dbodeawxmsg.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",msg_type=?");
			}else{
				sb.append("msg_type=?");
				flag=true;
			}
		}
		if(dbodeawxmsg.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",msg_srl=?");
			}else{
				sb.append("msg_srl=?");
				flag=true;
			}
		}
		if(dbodeawxmsg.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",change_time=?");
			}else{
				sb.append("change_time=?");
				flag=true;
			}
		}
		if(dbodeawxmsg.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",msg_status=?");
			}else{
				sb.append("msg_status=?");
				flag=true;
			}
		}
		if(dbodeawxmsg.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",retry_num=?");
			}else{
				sb.append("retry_num=?");
				flag=true;
			}
		}
		if(dbodeawxmsg.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",eid=?");
			}else{
				sb.append("eid=?");
				flag=true;
			}
		}
		if(dbodeawxmsg.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbodeawxmsg.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",newsid=?");
			}else{
				sb.append("newsid=?");
				flag=true;
			}
		}
		if(dbodeawxmsg.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",newscontent=?");
			}else{
				sb.append("newscontent=?");
				flag=true;
			}
		}
		if(dbodeawxmsg.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",title=?");
			}else{
				sb.append("title=?");
				flag=true;
			}
		}
		if(dbodeawxmsg.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",from_type=?");
			}else{
				sb.append("from_type=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeawxmsg.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeawxmsg.getId());k++;
		}
		if(dbodeawxmsg.COLUMN_FLAG[1]){
			dbc.setString(k, dbodeawxmsg.getMsg_content());k++;
		}
		if(dbodeawxmsg.COLUMN_FLAG[2]){
			dbc.setString(k, dbodeawxmsg.getMsg_type());k++;
		}
		if(dbodeawxmsg.COLUMN_FLAG[3]){
			dbc.setString(k, dbodeawxmsg.getMsg_srl());k++;
		}
		if(dbodeawxmsg.COLUMN_FLAG[4]){
			dbc.setString(k, dbodeawxmsg.getChange_time());k++;
		}
		if(dbodeawxmsg.COLUMN_FLAG[5]){
			dbc.setInt(k, dbodeawxmsg.getMsg_status());k++;
		}
		if(dbodeawxmsg.COLUMN_FLAG[6]){
			dbc.setInt(k, dbodeawxmsg.getRetry_num());k++;
		}
		if(dbodeawxmsg.COLUMN_FLAG[7]){
			dbc.setInt(k, dbodeawxmsg.getEid());k++;
		}
		if(dbodeawxmsg.COLUMN_FLAG[8]){
			dbc.setTimestamp(k, new Timestamp(dbodeawxmsg.getAdddate().getTime()));k++;
		}
		if(dbodeawxmsg.COLUMN_FLAG[9]){
			dbc.setInt(k, dbodeawxmsg.getNewsid());k++;
		}
		if(dbodeawxmsg.COLUMN_FLAG[10]){
			dbc.setString(k, dbodeawxmsg.getNewscontent());k++;
		}
		if(dbodeawxmsg.COLUMN_FLAG[11]){
			dbc.setString(k, dbodeawxmsg.getTitle());k++;
		}
		if(dbodeawxmsg.COLUMN_FLAG[12]){
			dbc.setInt(k, dbodeawxmsg.getFrom_type());k++;
		}
		dbc.setInt(k, dbodeawxmsg.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaWxmsg dbodeawxmsg) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeawxmsg);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}