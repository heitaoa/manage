package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbCityArea;

public class  TbCityAreaDao  extends BaseDao {

	public static void fill(ResultSet rs, TbCityArea tbcityarea) throws SQLException {
		tbcityarea.setId(rs.getInt("id"));//自增id
		tbcityarea.setCity(rs.getInt("city"));//cityid
		tbcityarea.setArea(rs.getString("area"));//城市下面所属区域
	}

	public static List<TbCityArea> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_city_area";
		List<TbCityArea> list = new ArrayList<TbCityArea>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbCityArea tbcityarea = new TbCityArea();
				fill(rs, tbcityarea);
				list.add(tbcityarea);
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


	public static List<TbCityArea> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_city_area where "+subsql+"";
		List<TbCityArea> list = new ArrayList<TbCityArea>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbCityArea tbcityarea = new TbCityArea();
				fill(rs, tbcityarea);
				list.add(tbcityarea);
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
		String sql = "select count(*) from tb_city_area where "+subsql+"";
		
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
		String sql = "delete from tb_city_area where "+subsql+"";
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
		String sql = "delete from tb_city_area where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbCityArea tbcityarea) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_city_area(`id`,`city`,`area`) values(?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbcityarea.getId());
		dbc.setInt(2, tbcityarea.getCity());
		dbc.setString(3, tbcityarea.getArea());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbCityArea tbcityarea) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_city_area(`id`,`city`,`area`) values(?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbcityarea.getId());
		dbc.setInt(2, tbcityarea.getCity());
		dbc.setString(3, tbcityarea.getArea());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbCityArea tbcityarea) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_city_area set ");
		boolean flag = false;
		if(tbcityarea.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(tbcityarea.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",city=?");
			}else{
				sb.append("city=?");
				flag=true;
			}
		}
		if(tbcityarea.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",area=?");
			}else{
				sb.append("area=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbcityarea.COLUMN_FLAG[0]){
			dbc.setInt(k, tbcityarea.getId());k++;
		}
		if(tbcityarea.COLUMN_FLAG[1]){
			dbc.setInt(k, tbcityarea.getCity());k++;
		}
		if(tbcityarea.COLUMN_FLAG[2]){
			dbc.setString(k, tbcityarea.getArea());k++;
		}
		dbc.setInt(k, tbcityarea.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbCityArea tbcityarea) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbcityarea);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}