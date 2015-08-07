package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.Sequence;

public class  SequenceDao  extends BaseDao {

	public static void fill(ResultSet rs, Sequence sequence) throws SQLException {
		sequence.setSeq_name(rs.getString("seq_name"));//
		sequence.setCurrent_value(rs.getInt("current_value"));//
		sequence.setIncrement(rs.getInt("increment"));//
	}

	public static List<Sequence> find() {
		DBConnect dbc = null;
		String sql = "select * from sequence";
		List<Sequence> list = new ArrayList<Sequence>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				Sequence sequence = new Sequence();
				fill(rs, sequence);
				list.add(sequence);
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


	public static List<Sequence> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from sequence where "+subsql+"";
		List<Sequence> list = new ArrayList<Sequence>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				Sequence sequence = new Sequence();
				fill(rs, sequence);
				list.add(sequence);
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
		String sql = "select count(*) from sequence where "+subsql+"";
		
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
		String sql = "delete from sequence where "+subsql+"";
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
		String sql = "delete from sequence where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(Sequence sequence) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into sequence(`seq_name`,`current_value`,`increment`) values(?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setString(1, sequence.getSeq_name());
		dbc.setInt(2, sequence.getCurrent_value());
		dbc.setInt(3, sequence.getIncrement());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,Sequence sequence) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into sequence(`seq_name`,`current_value`,`increment`) values(?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setString(1, sequence.getSeq_name());
		dbc.setInt(2, sequence.getCurrent_value());
		dbc.setInt(3, sequence.getIncrement());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,Sequence sequence) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update sequence set ");
		boolean flag = false;
		if(sequence.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",seq_name=?");
			}else{
				sb.append("seq_name=?");
				flag=true;
			}
		}
		if(sequence.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",current_value=?");
			}else{
				sb.append("current_value=?");
				flag=true;
			}
		}
		if(sequence.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",increment=?");
			}else{
				sb.append("increment=?");
				flag=true;
			}
		}
		sb.append(" where seq_name=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(sequence.COLUMN_FLAG[0]){
			dbc.setString(k, sequence.getSeq_name());k++;
		}
		if(sequence.COLUMN_FLAG[1]){
			dbc.setInt(k, sequence.getCurrent_value());k++;
		}
		if(sequence.COLUMN_FLAG[2]){
			dbc.setInt(k, sequence.getIncrement());k++;
		}
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(Sequence sequence) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, sequence);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}