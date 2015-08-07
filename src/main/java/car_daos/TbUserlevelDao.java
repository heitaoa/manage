package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbUserlevel;

public class  TbUserlevelDao  extends BaseDao {

	public static void fill(ResultSet rs, TbUserlevel tbuserlevel) throws SQLException {
		tbuserlevel.setId(rs.getInt("id"));//
		tbuserlevel.setUserid(rs.getString("userid"));//用户id
		tbuserlevel.setUlevel(rs.getString("ulevel"));//用户权限  0-系统管理员 1-大客户回访人员  2-客服 3-销售  4-总站编辑 5-分站编辑  6-分站管理员
	}

	public static List<TbUserlevel> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_userlevel";
		List<TbUserlevel> list = new ArrayList<TbUserlevel>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbUserlevel tbuserlevel = new TbUserlevel();
				fill(rs, tbuserlevel);
				list.add(tbuserlevel);
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


	public static List<TbUserlevel> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_userlevel where "+subsql+"";
		List<TbUserlevel> list = new ArrayList<TbUserlevel>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbUserlevel tbuserlevel = new TbUserlevel();
				fill(rs, tbuserlevel);
				list.add(tbuserlevel);
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
		String sql = "select count(*) from tb_userlevel where "+subsql+"";
		
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
		String sql = "delete from tb_userlevel where "+subsql+"";
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
		String sql = "delete from tb_userlevel where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbUserlevel tbuserlevel) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_userlevel(`id`,`userid`,`ulevel`) values(?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbuserlevel.getId());
		dbc.setString(2, tbuserlevel.getUserid());
		dbc.setString(3, tbuserlevel.getUlevel());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbUserlevel tbuserlevel) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_userlevel(`id`,`userid`,`ulevel`) values(?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbuserlevel.getId());
		dbc.setString(2, tbuserlevel.getUserid());
		dbc.setString(3, tbuserlevel.getUlevel());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbUserlevel tbuserlevel) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_userlevel set ");
		boolean flag = false;
		if(tbuserlevel.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(tbuserlevel.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",userid=?");
			}else{
				sb.append("userid=?");
				flag=true;
			}
		}
		if(tbuserlevel.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",ulevel=?");
			}else{
				sb.append("ulevel=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbuserlevel.COLUMN_FLAG[0]){
			dbc.setInt(k, tbuserlevel.getId());k++;
		}
		if(tbuserlevel.COLUMN_FLAG[1]){
			dbc.setString(k, tbuserlevel.getUserid());k++;
		}
		if(tbuserlevel.COLUMN_FLAG[2]){
			dbc.setString(k, tbuserlevel.getUlevel());k++;
		}
		dbc.setInt(k, tbuserlevel.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbUserlevel tbuserlevel) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbuserlevel);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}