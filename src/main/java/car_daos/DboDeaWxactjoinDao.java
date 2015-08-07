package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaWxactjoin;

public class  DboDeaWxactjoinDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaWxactjoin dbodeawxactjoin) throws SQLException {
		dbodeawxactjoin.setId(rs.getInt("id"));//
		dbodeawxactjoin.setOpenid(rs.getString("openid"));//微信用户对当前公众号唯一id
		dbodeawxactjoin.setPid(rs.getInt("pid"));//奖品
		dbodeawxactjoin.setAid(rs.getInt("aid"));//活动
		dbodeawxactjoin.setAdddate(rs.getTimestamp("adddate"));//
		dbodeawxactjoin.setCount(rs.getInt("count"));//数量
	}

	public static List<DboDeaWxactjoin> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_wxactjoin";
		List<DboDeaWxactjoin> list = new ArrayList<DboDeaWxactjoin>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaWxactjoin dbodeawxactjoin = new DboDeaWxactjoin();
				fill(rs, dbodeawxactjoin);
				list.add(dbodeawxactjoin);
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


	public static List<DboDeaWxactjoin> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_wxactjoin where "+subsql+"";
		List<DboDeaWxactjoin> list = new ArrayList<DboDeaWxactjoin>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaWxactjoin dbodeawxactjoin = new DboDeaWxactjoin();
				fill(rs, dbodeawxactjoin);
				list.add(dbodeawxactjoin);
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
		String sql = "select count(*) from dbo_dea_wxactjoin where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_wxactjoin where "+subsql+"";
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
		String sql = "delete from dbo_dea_wxactjoin where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaWxactjoin dbodeawxactjoin) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_wxactjoin(`id`,`openid`,`pid`,`aid`,`adddate`,`count`) values(?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeawxactjoin.getId());
		dbc.setString(2, dbodeawxactjoin.getOpenid());
		dbc.setInt(3, dbodeawxactjoin.getPid());
		dbc.setInt(4, dbodeawxactjoin.getAid());
		dbc.setTimestamp(5, new Timestamp(dbodeawxactjoin.getAdddate().getTime()));
		dbc.setInt(6, dbodeawxactjoin.getCount());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaWxactjoin dbodeawxactjoin) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_wxactjoin(`id`,`openid`,`pid`,`aid`,`adddate`,`count`) values(?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeawxactjoin.getId());
		dbc.setString(2, dbodeawxactjoin.getOpenid());
		dbc.setInt(3, dbodeawxactjoin.getPid());
		dbc.setInt(4, dbodeawxactjoin.getAid());
		dbc.setTimestamp(5, new Timestamp(dbodeawxactjoin.getAdddate().getTime()));
		dbc.setInt(6, dbodeawxactjoin.getCount());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaWxactjoin dbodeawxactjoin) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_wxactjoin set ");
		boolean flag = false;
		if(dbodeawxactjoin.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodeawxactjoin.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",openid=?");
			}else{
				sb.append("openid=?");
				flag=true;
			}
		}
		if(dbodeawxactjoin.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",pid=?");
			}else{
				sb.append("pid=?");
				flag=true;
			}
		}
		if(dbodeawxactjoin.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",aid=?");
			}else{
				sb.append("aid=?");
				flag=true;
			}
		}
		if(dbodeawxactjoin.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbodeawxactjoin.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",count=?");
			}else{
				sb.append("count=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeawxactjoin.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeawxactjoin.getId());k++;
		}
		if(dbodeawxactjoin.COLUMN_FLAG[1]){
			dbc.setString(k, dbodeawxactjoin.getOpenid());k++;
		}
		if(dbodeawxactjoin.COLUMN_FLAG[2]){
			dbc.setInt(k, dbodeawxactjoin.getPid());k++;
		}
		if(dbodeawxactjoin.COLUMN_FLAG[3]){
			dbc.setInt(k, dbodeawxactjoin.getAid());k++;
		}
		if(dbodeawxactjoin.COLUMN_FLAG[4]){
			dbc.setTimestamp(k, new Timestamp(dbodeawxactjoin.getAdddate().getTime()));k++;
		}
		if(dbodeawxactjoin.COLUMN_FLAG[5]){
			dbc.setInt(k, dbodeawxactjoin.getCount());k++;
		}
		dbc.setInt(k, dbodeawxactjoin.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaWxactjoin dbodeawxactjoin) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeawxactjoin);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}