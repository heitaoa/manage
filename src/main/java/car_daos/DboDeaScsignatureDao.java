package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaScsignature;

public class  DboDeaScsignatureDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaScsignature dbodeascsignature) throws SQLException {
		dbodeascsignature.setId(rs.getInt("id"));//
		dbodeascsignature.setCid(rs.getInt("cid"));//商品标示
		dbodeascsignature.setSncode(rs.getString("sncode"));//
		dbodeascsignature.setStatus(rs.getInt("status"));//状态：0：下单未付款；1：已付款；2：未下单，尚在购物车中
		dbodeascsignature.setIsdone(rs.getInt("isdone"));//0：未处理；1：已处理
		dbodeascsignature.setPickup(rs.getInt("pickup"));//
		dbodeascsignature.setAdddate(rs.getTimestamp("adddate"));//
		dbodeascsignature.setEid(rs.getInt("eid"));//
		dbodeascsignature.setUsername(rs.getString("username"));//
		dbodeascsignature.setUserphone(rs.getString("userphone"));//
		dbodeascsignature.setOpenid(rs.getString("openid"));//微信用户
		dbodeascsignature.setNum(rs.getInt("num"));//数量
	}

	public static List<DboDeaScsignature> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_scsignature";
		List<DboDeaScsignature> list = new ArrayList<DboDeaScsignature>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaScsignature dbodeascsignature = new DboDeaScsignature();
				fill(rs, dbodeascsignature);
				list.add(dbodeascsignature);
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


	public static List<DboDeaScsignature> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_scsignature where "+subsql+"";
		List<DboDeaScsignature> list = new ArrayList<DboDeaScsignature>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaScsignature dbodeascsignature = new DboDeaScsignature();
				fill(rs, dbodeascsignature);
				list.add(dbodeascsignature);
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
		String sql = "select count(*) from dbo_dea_scsignature where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_scsignature where "+subsql+"";
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
		String sql = "delete from dbo_dea_scsignature where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaScsignature dbodeascsignature) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_scsignature(`id`,`cid`,`sncode`,`status`,`isdone`,`pickup`,`adddate`,`eid`,`username`,`userphone`,`openid`,`num`) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeascsignature.getId());
		dbc.setInt(2, dbodeascsignature.getCid());
		dbc.setString(3, dbodeascsignature.getSncode());
		dbc.setInt(4, dbodeascsignature.getStatus());
		dbc.setInt(5, dbodeascsignature.getIsdone());
		dbc.setInt(6, dbodeascsignature.getPickup());
		dbc.setTimestamp(7, new Timestamp(dbodeascsignature.getAdddate().getTime()));
		dbc.setInt(8, dbodeascsignature.getEid());
		dbc.setString(9, dbodeascsignature.getUsername());
		dbc.setString(10, dbodeascsignature.getUserphone());
		dbc.setString(11, dbodeascsignature.getOpenid());
		dbc.setInt(12, dbodeascsignature.getNum());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaScsignature dbodeascsignature) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_scsignature(`id`,`cid`,`sncode`,`status`,`isdone`,`pickup`,`adddate`,`eid`,`username`,`userphone`,`openid`,`num`) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeascsignature.getId());
		dbc.setInt(2, dbodeascsignature.getCid());
		dbc.setString(3, dbodeascsignature.getSncode());
		dbc.setInt(4, dbodeascsignature.getStatus());
		dbc.setInt(5, dbodeascsignature.getIsdone());
		dbc.setInt(6, dbodeascsignature.getPickup());
		dbc.setTimestamp(7, new Timestamp(dbodeascsignature.getAdddate().getTime()));
		dbc.setInt(8, dbodeascsignature.getEid());
		dbc.setString(9, dbodeascsignature.getUsername());
		dbc.setString(10, dbodeascsignature.getUserphone());
		dbc.setString(11, dbodeascsignature.getOpenid());
		dbc.setInt(12, dbodeascsignature.getNum());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaScsignature dbodeascsignature) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_scsignature set ");
		boolean flag = false;
		if(dbodeascsignature.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodeascsignature.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",cid=?");
			}else{
				sb.append("cid=?");
				flag=true;
			}
		}
		if(dbodeascsignature.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",sncode=?");
			}else{
				sb.append("sncode=?");
				flag=true;
			}
		}
		if(dbodeascsignature.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",status=?");
			}else{
				sb.append("status=?");
				flag=true;
			}
		}
		if(dbodeascsignature.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",isdone=?");
			}else{
				sb.append("isdone=?");
				flag=true;
			}
		}
		if(dbodeascsignature.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",pickup=?");
			}else{
				sb.append("pickup=?");
				flag=true;
			}
		}
		if(dbodeascsignature.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbodeascsignature.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",eid=?");
			}else{
				sb.append("eid=?");
				flag=true;
			}
		}
		if(dbodeascsignature.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",username=?");
			}else{
				sb.append("username=?");
				flag=true;
			}
		}
		if(dbodeascsignature.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",userphone=?");
			}else{
				sb.append("userphone=?");
				flag=true;
			}
		}
		if(dbodeascsignature.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",openid=?");
			}else{
				sb.append("openid=?");
				flag=true;
			}
		}
		if(dbodeascsignature.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",num=?");
			}else{
				sb.append("num=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeascsignature.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeascsignature.getId());k++;
		}
		if(dbodeascsignature.COLUMN_FLAG[1]){
			dbc.setInt(k, dbodeascsignature.getCid());k++;
		}
		if(dbodeascsignature.COLUMN_FLAG[2]){
			dbc.setString(k, dbodeascsignature.getSncode());k++;
		}
		if(dbodeascsignature.COLUMN_FLAG[3]){
			dbc.setInt(k, dbodeascsignature.getStatus());k++;
		}
		if(dbodeascsignature.COLUMN_FLAG[4]){
			dbc.setInt(k, dbodeascsignature.getIsdone());k++;
		}
		if(dbodeascsignature.COLUMN_FLAG[5]){
			dbc.setInt(k, dbodeascsignature.getPickup());k++;
		}
		if(dbodeascsignature.COLUMN_FLAG[6]){
			dbc.setTimestamp(k, new Timestamp(dbodeascsignature.getAdddate().getTime()));k++;
		}
		if(dbodeascsignature.COLUMN_FLAG[7]){
			dbc.setInt(k, dbodeascsignature.getEid());k++;
		}
		if(dbodeascsignature.COLUMN_FLAG[8]){
			dbc.setString(k, dbodeascsignature.getUsername());k++;
		}
		if(dbodeascsignature.COLUMN_FLAG[9]){
			dbc.setString(k, dbodeascsignature.getUserphone());k++;
		}
		if(dbodeascsignature.COLUMN_FLAG[10]){
			dbc.setString(k, dbodeascsignature.getOpenid());k++;
		}
		if(dbodeascsignature.COLUMN_FLAG[11]){
			dbc.setInt(k, dbodeascsignature.getNum());k++;
		}
		dbc.setInt(k, dbodeascsignature.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaScsignature dbodeascsignature) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeascsignature);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}