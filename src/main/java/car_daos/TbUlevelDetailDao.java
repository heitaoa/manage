package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbUlevelDetail;

public class  TbUlevelDetailDao  extends BaseDao {

	public static void fill(ResultSet rs, TbUlevelDetail tbuleveldetail) throws SQLException {
		tbuleveldetail.setLevel(rs.getInt("level"));//用户权限  0-系统管理员 1-大客户回访人员  2-客服 3-销售  4-总站编辑 5-分站编辑  6-分站管理员
		tbuleveldetail.setFunctionid(rs.getString("functionid"));//
	}

	public static List<TbUlevelDetail> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_ulevel_detail";
		List<TbUlevelDetail> list = new ArrayList<TbUlevelDetail>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbUlevelDetail tbuleveldetail = new TbUlevelDetail();
				fill(rs, tbuleveldetail);
				list.add(tbuleveldetail);
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


	public static List<TbUlevelDetail> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_ulevel_detail where "+subsql+"";
		List<TbUlevelDetail> list = new ArrayList<TbUlevelDetail>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbUlevelDetail tbuleveldetail = new TbUlevelDetail();
				fill(rs, tbuleveldetail);
				list.add(tbuleveldetail);
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
		String sql = "select count(*) from tb_ulevel_detail where "+subsql+"";
		
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
		String sql = "delete from tb_ulevel_detail where "+subsql+"";
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
		String sql = "delete from tb_ulevel_detail where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbUlevelDetail tbuleveldetail) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_ulevel_detail(`level`,`functionid`) values(?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbuleveldetail.getLevel());
		dbc.setString(2, tbuleveldetail.getFunctionid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbUlevelDetail tbuleveldetail) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_ulevel_detail(`level`,`functionid`) values(?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbuleveldetail.getLevel());
		dbc.setString(2, tbuleveldetail.getFunctionid());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

}