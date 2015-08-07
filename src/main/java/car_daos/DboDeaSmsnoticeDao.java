package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaSmsnotice;

public class  DboDeaSmsnoticeDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaSmsnotice dbodeasmsnotice) throws SQLException {
		dbodeasmsnotice.setId(rs.getInt("id"));//
		dbodeasmsnotice.setName(rs.getString("name"));//
		dbodeasmsnotice.setEid(rs.getInt("eid"));//
		dbodeasmsnotice.setAdddate(rs.getTimestamp("adddate"));//
		dbodeasmsnotice.setIsdelete(rs.getInt("isdelete"));//
		dbodeasmsnotice.setNumber(rs.getString("number"));//
		dbodeasmsnotice.setType(rs.getInt("type"));//1手机号码 2qq号 3旺旺号 4邮箱（type为1的都是经销商设置的短信提醒号码）
		dbodeasmsnotice.setYewu(rs.getInt("yewu"));//1：会接受到‘在线订单预约试驾’的短信的通知；2：‘预约保养’的短信通知
	}

	public static List<DboDeaSmsnotice> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_smsnotice";
		List<DboDeaSmsnotice> list = new ArrayList<DboDeaSmsnotice>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaSmsnotice dbodeasmsnotice = new DboDeaSmsnotice();
				fill(rs, dbodeasmsnotice);
				list.add(dbodeasmsnotice);
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


	public static List<DboDeaSmsnotice> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_smsnotice where "+subsql+"";
		List<DboDeaSmsnotice> list = new ArrayList<DboDeaSmsnotice>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaSmsnotice dbodeasmsnotice = new DboDeaSmsnotice();
				fill(rs, dbodeasmsnotice);
				list.add(dbodeasmsnotice);
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
		String sql = "select count(*) from dbo_dea_smsnotice where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_smsnotice where "+subsql+"";
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
		String sql = "delete from dbo_dea_smsnotice where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaSmsnotice dbodeasmsnotice) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_smsnotice(`id`,`name`,`eid`,`adddate`,`isdelete`,`number`,`type`,`yewu`) values(?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeasmsnotice.getId());
		dbc.setString(2, dbodeasmsnotice.getName());
		dbc.setInt(3, dbodeasmsnotice.getEid());
		dbc.setTimestamp(4, new Timestamp(dbodeasmsnotice.getAdddate().getTime()));
		dbc.setInt(5, dbodeasmsnotice.getIsdelete());
		dbc.setString(6, dbodeasmsnotice.getNumber());
		dbc.setInt(7, dbodeasmsnotice.getType());
		dbc.setInt(8, dbodeasmsnotice.getYewu());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaSmsnotice dbodeasmsnotice) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_smsnotice(`id`,`name`,`eid`,`adddate`,`isdelete`,`number`,`type`,`yewu`) values(?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeasmsnotice.getId());
		dbc.setString(2, dbodeasmsnotice.getName());
		dbc.setInt(3, dbodeasmsnotice.getEid());
		dbc.setTimestamp(4, new Timestamp(dbodeasmsnotice.getAdddate().getTime()));
		dbc.setInt(5, dbodeasmsnotice.getIsdelete());
		dbc.setString(6, dbodeasmsnotice.getNumber());
		dbc.setInt(7, dbodeasmsnotice.getType());
		dbc.setInt(8, dbodeasmsnotice.getYewu());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaSmsnotice dbodeasmsnotice) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_smsnotice set ");
		boolean flag = false;
		if(dbodeasmsnotice.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodeasmsnotice.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",name=?");
			}else{
				sb.append("name=?");
				flag=true;
			}
		}
		if(dbodeasmsnotice.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",eid=?");
			}else{
				sb.append("eid=?");
				flag=true;
			}
		}
		if(dbodeasmsnotice.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbodeasmsnotice.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dbodeasmsnotice.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",number=?");
			}else{
				sb.append("number=?");
				flag=true;
			}
		}
		if(dbodeasmsnotice.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",type=?");
			}else{
				sb.append("type=?");
				flag=true;
			}
		}
		if(dbodeasmsnotice.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",yewu=?");
			}else{
				sb.append("yewu=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeasmsnotice.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeasmsnotice.getId());k++;
		}
		if(dbodeasmsnotice.COLUMN_FLAG[1]){
			dbc.setString(k, dbodeasmsnotice.getName());k++;
		}
		if(dbodeasmsnotice.COLUMN_FLAG[2]){
			dbc.setInt(k, dbodeasmsnotice.getEid());k++;
		}
		if(dbodeasmsnotice.COLUMN_FLAG[3]){
			dbc.setTimestamp(k, new Timestamp(dbodeasmsnotice.getAdddate().getTime()));k++;
		}
		if(dbodeasmsnotice.COLUMN_FLAG[4]){
			dbc.setInt(k, dbodeasmsnotice.getIsdelete());k++;
		}
		if(dbodeasmsnotice.COLUMN_FLAG[5]){
			dbc.setString(k, dbodeasmsnotice.getNumber());k++;
		}
		if(dbodeasmsnotice.COLUMN_FLAG[6]){
			dbc.setInt(k, dbodeasmsnotice.getType());k++;
		}
		if(dbodeasmsnotice.COLUMN_FLAG[7]){
			dbc.setInt(k, dbodeasmsnotice.getYewu());k++;
		}
		dbc.setInt(k, dbodeasmsnotice.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaSmsnotice dbodeasmsnotice) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeasmsnotice);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}