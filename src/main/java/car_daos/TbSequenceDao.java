package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbSequence;

public class  TbSequenceDao  extends BaseDao {

	public static void fill(ResultSet rs, TbSequence tbsequence) throws SQLException {
		tbsequence.setName(rs.getString("name"));//
		tbsequence.setCurrent_value(rs.getInt("current_value"));//
		tbsequence.set_increment(rs.getInt("_increment"));//
	}

	public static List<TbSequence> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_sequence";
		List<TbSequence> list = new ArrayList<TbSequence>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbSequence tbsequence = new TbSequence();
				fill(rs, tbsequence);
				list.add(tbsequence);
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


	public static List<TbSequence> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_sequence where "+subsql+"";
		List<TbSequence> list = new ArrayList<TbSequence>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbSequence tbsequence = new TbSequence();
				fill(rs, tbsequence);
				list.add(tbsequence);
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
		String sql = "select count(*) from tb_sequence where "+subsql+"";
		
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
		String sql = "delete from tb_sequence where "+subsql+"";
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
		String sql = "delete from tb_sequence where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbSequence tbsequence) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_sequence(`name`,`current_value`,`_increment`) values(?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setString(1, tbsequence.getName());
		dbc.setInt(2, tbsequence.getCurrent_value());
		dbc.setInt(3, tbsequence.get_increment());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbSequence tbsequence) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_sequence(`name`,`current_value`,`_increment`) values(?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setString(1, tbsequence.getName());
		dbc.setInt(2, tbsequence.getCurrent_value());
		dbc.setInt(3, tbsequence.get_increment());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbSequence tbsequence) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_sequence set ");
		boolean flag = false;
		if(tbsequence.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",name=?");
			}else{
				sb.append("name=?");
				flag=true;
			}
		}
		if(tbsequence.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",current_value=?");
			}else{
				sb.append("current_value=?");
				flag=true;
			}
		}
		if(tbsequence.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",_increment=?");
			}else{
				sb.append("_increment=?");
				flag=true;
			}
		}
		sb.append(" where name=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbsequence.COLUMN_FLAG[0]){
			dbc.setString(k, tbsequence.getName());k++;
		}
		if(tbsequence.COLUMN_FLAG[1]){
			dbc.setInt(k, tbsequence.getCurrent_value());k++;
		}
		if(tbsequence.COLUMN_FLAG[2]){
			dbc.setInt(k, tbsequence.get_increment());k++;
		}
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbSequence tbsequence) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbsequence);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}