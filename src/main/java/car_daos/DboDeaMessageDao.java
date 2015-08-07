package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaMessage;

public class  DboDeaMessageDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaMessage dbodeamessage) throws SQLException {
		dbodeamessage.setId(rs.getInt("id"));//
		dbodeamessage.setQuestion(rs.getString("question"));//
		dbodeamessage.setAdddate(rs.getTimestamp("adddate"));//
		dbodeamessage.setEid(rs.getInt("eid"));//
		dbodeamessage.setAnswer(rs.getString("answer"));//
		dbodeamessage.setIsdelete(rs.getInt("isdelete"));//
		dbodeamessage.setAnswerdate(rs.getTimestamp("answerdate"));//
	}

	public static List<DboDeaMessage> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_message";
		List<DboDeaMessage> list = new ArrayList<DboDeaMessage>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaMessage dbodeamessage = new DboDeaMessage();
				fill(rs, dbodeamessage);
				list.add(dbodeamessage);
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


	public static List<DboDeaMessage> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_message where "+subsql+"";
		List<DboDeaMessage> list = new ArrayList<DboDeaMessage>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaMessage dbodeamessage = new DboDeaMessage();
				fill(rs, dbodeamessage);
				list.add(dbodeamessage);
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
		String sql = "select count(*) from dbo_dea_message where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_message where "+subsql+"";
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
		String sql = "delete from dbo_dea_message where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaMessage dbodeamessage) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_message(`id`,`question`,`adddate`,`eid`,`answer`,`isdelete`,`answerdate`) values(?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeamessage.getId());
		dbc.setString(2, dbodeamessage.getQuestion());
		dbc.setTimestamp(3, new Timestamp(dbodeamessage.getAdddate().getTime()));
		dbc.setInt(4, dbodeamessage.getEid());
		dbc.setString(5, dbodeamessage.getAnswer());
		dbc.setInt(6, dbodeamessage.getIsdelete());
		dbc.setTimestamp(7, new Timestamp(dbodeamessage.getAnswerdate().getTime()));
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaMessage dbodeamessage) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_message(`id`,`question`,`adddate`,`eid`,`answer`,`isdelete`,`answerdate`) values(?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeamessage.getId());
		dbc.setString(2, dbodeamessage.getQuestion());
		dbc.setTimestamp(3, new Timestamp(dbodeamessage.getAdddate().getTime()));
		dbc.setInt(4, dbodeamessage.getEid());
		dbc.setString(5, dbodeamessage.getAnswer());
		dbc.setInt(6, dbodeamessage.getIsdelete());
		dbc.setTimestamp(7, new Timestamp(dbodeamessage.getAnswerdate().getTime()));
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaMessage dbodeamessage) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_message set ");
		boolean flag = false;
		if(dbodeamessage.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodeamessage.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",question=?");
			}else{
				sb.append("question=?");
				flag=true;
			}
		}
		if(dbodeamessage.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbodeamessage.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",eid=?");
			}else{
				sb.append("eid=?");
				flag=true;
			}
		}
		if(dbodeamessage.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",answer=?");
			}else{
				sb.append("answer=?");
				flag=true;
			}
		}
		if(dbodeamessage.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dbodeamessage.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",answerdate=?");
			}else{
				sb.append("answerdate=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeamessage.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeamessage.getId());k++;
		}
		if(dbodeamessage.COLUMN_FLAG[1]){
			dbc.setString(k, dbodeamessage.getQuestion());k++;
		}
		if(dbodeamessage.COLUMN_FLAG[2]){
			dbc.setTimestamp(k, new Timestamp(dbodeamessage.getAdddate().getTime()));k++;
		}
		if(dbodeamessage.COLUMN_FLAG[3]){
			dbc.setInt(k, dbodeamessage.getEid());k++;
		}
		if(dbodeamessage.COLUMN_FLAG[4]){
			dbc.setString(k, dbodeamessage.getAnswer());k++;
		}
		if(dbodeamessage.COLUMN_FLAG[5]){
			dbc.setInt(k, dbodeamessage.getIsdelete());k++;
		}
		if(dbodeamessage.COLUMN_FLAG[6]){
			dbc.setTimestamp(k, new Timestamp(dbodeamessage.getAnswerdate().getTime()));k++;
		}
		dbc.setInt(k, dbodeamessage.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaMessage dbodeamessage) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeamessage);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}