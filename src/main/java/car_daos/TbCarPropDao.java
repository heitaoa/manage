package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbCarProp;

public class  TbCarPropDao  extends BaseDao {

	public static void fill(ResultSet rs, TbCarProp tbcarprop) throws SQLException {
		tbcarprop.setCatalogid(rs.getInt("catalogid"));//
		tbcarprop.setCatalogname(rs.getString("catalogname"));//
		tbcarprop.setIway(rs.getString("iway"));//
		tbcarprop.setIsdelete(rs.getInt("isdelete"));//
		tbcarprop.setPathlevel(rs.getInt("pathlevel"));//
	}

	public static List<TbCarProp> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_car_prop";
		List<TbCarProp> list = new ArrayList<TbCarProp>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbCarProp tbcarprop = new TbCarProp();
				fill(rs, tbcarprop);
				list.add(tbcarprop);
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


	public static List<TbCarProp> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_car_prop where "+subsql+"";
		List<TbCarProp> list = new ArrayList<TbCarProp>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbCarProp tbcarprop = new TbCarProp();
				fill(rs, tbcarprop);
				list.add(tbcarprop);
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
		String sql = "select count(*) from tb_car_prop where "+subsql+"";
		
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
		String sql = "delete from tb_car_prop where "+subsql+"";
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
		String sql = "delete from tb_car_prop where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbCarProp tbcarprop) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_car_prop(`catalogid`,`catalogname`,`iway`,`isdelete`,`pathlevel`) values(?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbcarprop.getCatalogid());
		dbc.setString(2, tbcarprop.getCatalogname());
		dbc.setString(3, tbcarprop.getIway());
		dbc.setInt(4, tbcarprop.getIsdelete());
		dbc.setInt(5, tbcarprop.getPathlevel());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbCarProp tbcarprop) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_car_prop(`catalogid`,`catalogname`,`iway`,`isdelete`,`pathlevel`) values(?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbcarprop.getCatalogid());
		dbc.setString(2, tbcarprop.getCatalogname());
		dbc.setString(3, tbcarprop.getIway());
		dbc.setInt(4, tbcarprop.getIsdelete());
		dbc.setInt(5, tbcarprop.getPathlevel());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

}