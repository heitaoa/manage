package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboCarInfo;

public class  DboCarInfoDao  extends BaseDao {

	public static void fill(ResultSet rs, DboCarInfo dbocarinfo) throws SQLException {
		dbocarinfo.setId(rs.getInt("id"));//
		dbocarinfo.setCatalogid(rs.getInt("catalogid"));//
		dbocarinfo.setIntroduction(rs.getString("introduction"));//
		dbocarinfo.setAdvantage(rs.getString("advantage"));//
		dbocarinfo.setDisadvantage(rs.getString("disadvantage"));//
		dbocarinfo.setOld_catalogid(rs.getInt("old_catalogid"));//老315车型数据
	}

	public static List<DboCarInfo> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_car_info";
		List<DboCarInfo> list = new ArrayList<DboCarInfo>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarInfo dbocarinfo = new DboCarInfo();
				fill(rs, dbocarinfo);
				list.add(dbocarinfo);
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


	public static List<DboCarInfo> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_car_info where "+subsql+"";
		List<DboCarInfo> list = new ArrayList<DboCarInfo>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarInfo dbocarinfo = new DboCarInfo();
				fill(rs, dbocarinfo);
				list.add(dbocarinfo);
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
		String sql = "select count(*) from dbo_car_info where "+subsql+"";
		
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
		String sql = "delete from dbo_car_info where "+subsql+"";
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
		String sql = "delete from dbo_car_info where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboCarInfo dbocarinfo) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_car_info(`id`,`catalogid`,`introduction`,`advantage`,`disadvantage`,`old_catalogid`) values(?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbocarinfo.getId());
		dbc.setInt(2, dbocarinfo.getCatalogid());
		dbc.setString(3, dbocarinfo.getIntroduction());
		dbc.setString(4, dbocarinfo.getAdvantage());
		dbc.setString(5, dbocarinfo.getDisadvantage());
		dbc.setInt(6, dbocarinfo.getOld_catalogid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboCarInfo dbocarinfo) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_car_info(`id`,`catalogid`,`introduction`,`advantage`,`disadvantage`,`old_catalogid`) values(?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbocarinfo.getId());
		dbc.setInt(2, dbocarinfo.getCatalogid());
		dbc.setString(3, dbocarinfo.getIntroduction());
		dbc.setString(4, dbocarinfo.getAdvantage());
		dbc.setString(5, dbocarinfo.getDisadvantage());
		dbc.setInt(6, dbocarinfo.getOld_catalogid());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboCarInfo dbocarinfo) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_car_info set ");
		boolean flag = false;
		if(dbocarinfo.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbocarinfo.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",catalogid=?");
			}else{
				sb.append("catalogid=?");
				flag=true;
			}
		}
		if(dbocarinfo.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",introduction=?");
			}else{
				sb.append("introduction=?");
				flag=true;
			}
		}
		if(dbocarinfo.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",advantage=?");
			}else{
				sb.append("advantage=?");
				flag=true;
			}
		}
		if(dbocarinfo.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",disadvantage=?");
			}else{
				sb.append("disadvantage=?");
				flag=true;
			}
		}
		if(dbocarinfo.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",old_catalogid=?");
			}else{
				sb.append("old_catalogid=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbocarinfo.COLUMN_FLAG[0]){
			dbc.setInt(k, dbocarinfo.getId());k++;
		}
		if(dbocarinfo.COLUMN_FLAG[1]){
			dbc.setInt(k, dbocarinfo.getCatalogid());k++;
		}
		if(dbocarinfo.COLUMN_FLAG[2]){
			dbc.setString(k, dbocarinfo.getIntroduction());k++;
		}
		if(dbocarinfo.COLUMN_FLAG[3]){
			dbc.setString(k, dbocarinfo.getAdvantage());k++;
		}
		if(dbocarinfo.COLUMN_FLAG[4]){
			dbc.setString(k, dbocarinfo.getDisadvantage());k++;
		}
		if(dbocarinfo.COLUMN_FLAG[5]){
			dbc.setInt(k, dbocarinfo.getOld_catalogid());k++;
		}
		dbc.setInt(k, dbocarinfo.getId());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboCarInfo dbocarinfo) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbocarinfo);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static List<DboCarInfo> DboCarInfoSelectAllColumn(){
		DBConnect dbc = null;
		String sql = "select * from dbo_car_info";
		List<DboCarInfo> list = new ArrayList<DboCarInfo>();
	
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarInfo obj = new DboCarInfo();
				fill(rs, obj);
				list.add(obj);
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
}