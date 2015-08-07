package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboCarQuestions;

public class  DboCarQuestionsDao  extends BaseDao {

	public static void fill(ResultSet rs, DboCarQuestions dbocarquestions) throws SQLException {
		dbocarquestions.setId(rs.getInt("id"));//
		dbocarquestions.setSerialid(rs.getInt("serialid"));//
		dbocarquestions.setMsgtype(rs.getInt("msgtype"));//1-怎么样 2-油耗统计 3-缺点 4-优点 5-保养费用 6-颜色有几种
		dbocarquestions.setIsdelete(rs.getInt("isdelete"));//
		dbocarquestions.setNickname(rs.getString("nickname"));//
		dbocarquestions.setAddtime(rs.getTimestamp("addtime"));//
		dbocarquestions.setBrowses(rs.getInt("browses"));//
		dbocarquestions.setUsername(rs.getString("username"));//
		dbocarquestions.setFormatqcontent(rs.getString("formatqcontent"));//
		dbocarquestions.setAnswercount(rs.getInt("answercount"));//
		dbocarquestions.setAnswertime(rs.getTimestamp("answertime"));//
	}

	public static List<DboCarQuestions> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_car_questions";
		List<DboCarQuestions> list = new ArrayList<DboCarQuestions>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarQuestions dbocarquestions = new DboCarQuestions();
				fill(rs, dbocarquestions);
				list.add(dbocarquestions);
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


	public static List<DboCarQuestions> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_car_questions where "+subsql+"";
		List<DboCarQuestions> list = new ArrayList<DboCarQuestions>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarQuestions dbocarquestions = new DboCarQuestions();
				fill(rs, dbocarquestions);
				list.add(dbocarquestions);
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
		String sql = "select count(*) from dbo_car_questions where "+subsql+"";
		
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
		String sql = "delete from dbo_car_questions where "+subsql+"";
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
		String sql = "delete from dbo_car_questions where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboCarQuestions dbocarquestions) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_car_questions(`id`,`serialid`,`msgtype`,`isdelete`,`nickname`,`addtime`,`browses`,`username`,`formatqcontent`,`answercount`,`answertime`) values(?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbocarquestions.getId());
		dbc.setInt(2, dbocarquestions.getSerialid());
		dbc.setInt(3, dbocarquestions.getMsgtype());
		dbc.setInt(4, dbocarquestions.getIsdelete());
		dbc.setString(5, dbocarquestions.getNickname());
		dbc.setTimestamp(6, new Timestamp(dbocarquestions.getAddtime().getTime()));
		dbc.setInt(7, dbocarquestions.getBrowses());
		dbc.setString(8, dbocarquestions.getUsername());
		dbc.setString(9, dbocarquestions.getFormatqcontent());
		dbc.setInt(10, dbocarquestions.getAnswercount());
		dbc.setTimestamp(11, new Timestamp(dbocarquestions.getAnswertime().getTime()));
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboCarQuestions dbocarquestions) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_car_questions(`id`,`serialid`,`msgtype`,`isdelete`,`nickname`,`addtime`,`browses`,`username`,`formatqcontent`,`answercount`,`answertime`) values(?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbocarquestions.getId());
		dbc.setInt(2, dbocarquestions.getSerialid());
		dbc.setInt(3, dbocarquestions.getMsgtype());
		dbc.setInt(4, dbocarquestions.getIsdelete());
		dbc.setString(5, dbocarquestions.getNickname());
		dbc.setTimestamp(6, new Timestamp(dbocarquestions.getAddtime().getTime()));
		dbc.setInt(7, dbocarquestions.getBrowses());
		dbc.setString(8, dbocarquestions.getUsername());
		dbc.setString(9, dbocarquestions.getFormatqcontent());
		dbc.setInt(10, dbocarquestions.getAnswercount());
		dbc.setTimestamp(11, new Timestamp(dbocarquestions.getAnswertime().getTime()));
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboCarQuestions dbocarquestions) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_car_questions set ");
		boolean flag = false;
		if(dbocarquestions.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbocarquestions.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",serialid=?");
			}else{
				sb.append("serialid=?");
				flag=true;
			}
		}
		if(dbocarquestions.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",msgtype=?");
			}else{
				sb.append("msgtype=?");
				flag=true;
			}
		}
		if(dbocarquestions.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dbocarquestions.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",nickname=?");
			}else{
				sb.append("nickname=?");
				flag=true;
			}
		}
		if(dbocarquestions.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",addtime=?");
			}else{
				sb.append("addtime=?");
				flag=true;
			}
		}
		if(dbocarquestions.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",browses=?");
			}else{
				sb.append("browses=?");
				flag=true;
			}
		}
		if(dbocarquestions.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",username=?");
			}else{
				sb.append("username=?");
				flag=true;
			}
		}
		if(dbocarquestions.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",formatqcontent=?");
			}else{
				sb.append("formatqcontent=?");
				flag=true;
			}
		}
		if(dbocarquestions.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",answercount=?");
			}else{
				sb.append("answercount=?");
				flag=true;
			}
		}
		if(dbocarquestions.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",answertime=?");
			}else{
				sb.append("answertime=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbocarquestions.COLUMN_FLAG[0]){
			dbc.setInt(k, dbocarquestions.getId());k++;
		}
		if(dbocarquestions.COLUMN_FLAG[1]){
			dbc.setInt(k, dbocarquestions.getSerialid());k++;
		}
		if(dbocarquestions.COLUMN_FLAG[2]){
			dbc.setInt(k, dbocarquestions.getMsgtype());k++;
		}
		if(dbocarquestions.COLUMN_FLAG[3]){
			dbc.setInt(k, dbocarquestions.getIsdelete());k++;
		}
		if(dbocarquestions.COLUMN_FLAG[4]){
			dbc.setString(k, dbocarquestions.getNickname());k++;
		}
		if(dbocarquestions.COLUMN_FLAG[5]){
			dbc.setTimestamp(k, new Timestamp(dbocarquestions.getAddtime().getTime()));k++;
		}
		if(dbocarquestions.COLUMN_FLAG[6]){
			dbc.setInt(k, dbocarquestions.getBrowses());k++;
		}
		if(dbocarquestions.COLUMN_FLAG[7]){
			dbc.setString(k, dbocarquestions.getUsername());k++;
		}
		if(dbocarquestions.COLUMN_FLAG[8]){
			dbc.setString(k, dbocarquestions.getFormatqcontent());k++;
		}
		if(dbocarquestions.COLUMN_FLAG[9]){
			dbc.setInt(k, dbocarquestions.getAnswercount());k++;
		}
		if(dbocarquestions.COLUMN_FLAG[10]){
			dbc.setTimestamp(k, new Timestamp(dbocarquestions.getAnswertime().getTime()));k++;
		}
		dbc.setInt(k, dbocarquestions.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboCarQuestions dbocarquestions) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbocarquestions);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}