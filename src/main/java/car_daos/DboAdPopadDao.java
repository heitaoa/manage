package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboAdPopad;

public class  DboAdPopadDao  extends BaseDao {

	public static void fill(ResultSet rs, DboAdPopad dboadpopad) throws SQLException {
		dboadpopad.setId(rs.getInt("id"));//弹出广告自增长id
		dboadpopad.setAdid(rs.getInt("adid"));//来源广告id
		dboadpopad.setPoptotaltimes(rs.getInt("poptotaltimes"));//最大弹出次数
		dboadpopad.setRemaintimes(rs.getInt("remaintimes"));//剩余弹出次数
		dboadpopad.setAdstr(rs.getString("adstr"));//弹出广告代码
		dboadpopad.setIsdelete(rs.getInt("isdelete"));//删除标识
		dboadpopad.setJsstr(rs.getString("jsstr"));//
		dboadpopad.setScheduledday(rs.getTimestamp("scheduledday"));//
		dboadpopad.setTotalclick(rs.getInt("totalclick"));//
		dboadpopad.setAdtitle(rs.getString("adtitle"));//
	}

	public static List<DboAdPopad> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_ad_popad";
		List<DboAdPopad> list = new ArrayList<DboAdPopad>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboAdPopad dboadpopad = new DboAdPopad();
				fill(rs, dboadpopad);
				list.add(dboadpopad);
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


	public static List<DboAdPopad> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_ad_popad where "+subsql+"";
		List<DboAdPopad> list = new ArrayList<DboAdPopad>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboAdPopad dboadpopad = new DboAdPopad();
				fill(rs, dboadpopad);
				list.add(dboadpopad);
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
		String sql = "select count(*) from dbo_ad_popad where "+subsql+"";
		
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
		String sql = "delete from dbo_ad_popad where "+subsql+"";
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
		String sql = "delete from dbo_ad_popad where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboAdPopad dboadpopad) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_ad_popad(`id`,`adid`,`poptotaltimes`,`remaintimes`,`adstr`,`isdelete`,`jsstr`,`scheduledday`,`totalclick`,`adtitle`) values(?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboadpopad.getId());
		dbc.setInt(2, dboadpopad.getAdid());
		dbc.setInt(3, dboadpopad.getPoptotaltimes());
		dbc.setInt(4, dboadpopad.getRemaintimes());
		dbc.setString(5, dboadpopad.getAdstr());
		dbc.setInt(6, dboadpopad.getIsdelete());
		dbc.setString(7, dboadpopad.getJsstr());
		dbc.setTimestamp(8, new Timestamp(dboadpopad.getScheduledday().getTime()));
		dbc.setInt(9, dboadpopad.getTotalclick());
		dbc.setString(10, dboadpopad.getAdtitle());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboAdPopad dboadpopad) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_ad_popad(`id`,`adid`,`poptotaltimes`,`remaintimes`,`adstr`,`isdelete`,`jsstr`,`scheduledday`,`totalclick`,`adtitle`) values(?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboadpopad.getId());
		dbc.setInt(2, dboadpopad.getAdid());
		dbc.setInt(3, dboadpopad.getPoptotaltimes());
		dbc.setInt(4, dboadpopad.getRemaintimes());
		dbc.setString(5, dboadpopad.getAdstr());
		dbc.setInt(6, dboadpopad.getIsdelete());
		dbc.setString(7, dboadpopad.getJsstr());
		dbc.setTimestamp(8, new Timestamp(dboadpopad.getScheduledday().getTime()));
		dbc.setInt(9, dboadpopad.getTotalclick());
		dbc.setString(10, dboadpopad.getAdtitle());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboAdPopad dboadpopad) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_ad_popad set ");
		boolean flag = false;
		if(dboadpopad.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dboadpopad.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",adid=?");
			}else{
				sb.append("adid=?");
				flag=true;
			}
		}
		if(dboadpopad.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",poptotaltimes=?");
			}else{
				sb.append("poptotaltimes=?");
				flag=true;
			}
		}
		if(dboadpopad.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",remaintimes=?");
			}else{
				sb.append("remaintimes=?");
				flag=true;
			}
		}
		if(dboadpopad.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",adstr=?");
			}else{
				sb.append("adstr=?");
				flag=true;
			}
		}
		if(dboadpopad.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dboadpopad.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",jsstr=?");
			}else{
				sb.append("jsstr=?");
				flag=true;
			}
		}
		if(dboadpopad.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",scheduledday=?");
			}else{
				sb.append("scheduledday=?");
				flag=true;
			}
		}
		if(dboadpopad.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",totalclick=?");
			}else{
				sb.append("totalclick=?");
				flag=true;
			}
		}
		if(dboadpopad.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",adtitle=?");
			}else{
				sb.append("adtitle=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dboadpopad.COLUMN_FLAG[0]){
			dbc.setInt(k, dboadpopad.getId());k++;
		}
		if(dboadpopad.COLUMN_FLAG[1]){
			dbc.setInt(k, dboadpopad.getAdid());k++;
		}
		if(dboadpopad.COLUMN_FLAG[2]){
			dbc.setInt(k, dboadpopad.getPoptotaltimes());k++;
		}
		if(dboadpopad.COLUMN_FLAG[3]){
			dbc.setInt(k, dboadpopad.getRemaintimes());k++;
		}
		if(dboadpopad.COLUMN_FLAG[4]){
			dbc.setString(k, dboadpopad.getAdstr());k++;
		}
		if(dboadpopad.COLUMN_FLAG[5]){
			dbc.setInt(k, dboadpopad.getIsdelete());k++;
		}
		if(dboadpopad.COLUMN_FLAG[6]){
			dbc.setString(k, dboadpopad.getJsstr());k++;
		}
		if(dboadpopad.COLUMN_FLAG[7]){
			dbc.setTimestamp(k, new Timestamp(dboadpopad.getScheduledday().getTime()));k++;
		}
		if(dboadpopad.COLUMN_FLAG[8]){
			dbc.setInt(k, dboadpopad.getTotalclick());k++;
		}
		if(dboadpopad.COLUMN_FLAG[9]){
			dbc.setString(k, dboadpopad.getAdtitle());k++;
		}
		dbc.setInt(k, dboadpopad.getId());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboAdPopad dboadpopad) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dboadpopad);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}