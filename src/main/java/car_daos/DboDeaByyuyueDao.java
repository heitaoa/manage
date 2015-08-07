package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaByyuyue;

public class  DboDeaByyuyueDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaByyuyue dbodeabyyuyue) throws SQLException {
		dbodeabyyuyue.setId(rs.getInt("id"));//
		dbodeabyyuyue.setEid(rs.getInt("eid"));//
		dbodeabyyuyue.setPlaceid(rs.getInt("placeid"));//
		dbodeabyyuyue.setIsdelete(rs.getInt("isdelete"));//
		dbodeabyyuyue.setDealstate(rs.getInt("dealstate"));//
		dbodeabyyuyue.setUserid(rs.getInt("userid"));//
		dbodeabyyuyue.setZhekou(rs.getString("zhekou"));//
		dbodeabyyuyue.setRealname(rs.getString("realname"));//姓名
		dbodeabyyuyue.setPhone(rs.getString("phone"));//
		dbodeabyyuyue.setCarcode(rs.getString("carcode"));//车牌号
		dbodeabyyuyue.setAdddate(rs.getTimestamp("adddate"));//
		dbodeabyyuyue.setDealmessage(rs.getString("dealmessage"));//
		dbodeabyyuyue.setQujian(rs.getInt("qujian"));//
		dbodeabyyuyue.setOpenid(rs.getString("openid"));//
		dbodeabyyuyue.setFromsource(rs.getInt("fromsource"));//
		dbodeabyyuyue.setLicheng(rs.getString("licheng"));//
		dbodeabyyuyue.setIssenior(rs.getInt("issenior"));// 默认为0，不为空
	}

	public static List<DboDeaByyuyue> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_byyuyue";
		List<DboDeaByyuyue> list = new ArrayList<DboDeaByyuyue>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaByyuyue dbodeabyyuyue = new DboDeaByyuyue();
				fill(rs, dbodeabyyuyue);
				list.add(dbodeabyyuyue);
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


	public static List<DboDeaByyuyue> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_byyuyue where "+subsql+"";
		List<DboDeaByyuyue> list = new ArrayList<DboDeaByyuyue>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaByyuyue dbodeabyyuyue = new DboDeaByyuyue();
				fill(rs, dbodeabyyuyue);
				list.add(dbodeabyyuyue);
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
		String sql = "select count(*) from dbo_dea_byyuyue where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_byyuyue where "+subsql+"";
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
		String sql = "delete from dbo_dea_byyuyue where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaByyuyue dbodeabyyuyue) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_byyuyue(`id`,`eid`,`placeid`,`isdelete`,`dealstate`,`userid`,`zhekou`,`realname`,`phone`,`carcode`,`adddate`,`dealmessage`,`qujian`,`openid`,`fromsource`,`licheng`,`issenior`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeabyyuyue.getId());
		dbc.setInt(2, dbodeabyyuyue.getEid());
		dbc.setInt(3, dbodeabyyuyue.getPlaceid());
		dbc.setInt(4, dbodeabyyuyue.getIsdelete());
		dbc.setInt(5, dbodeabyyuyue.getDealstate());
		dbc.setInt(6, dbodeabyyuyue.getUserid());
		dbc.setString(7, dbodeabyyuyue.getZhekou());
		dbc.setString(8, dbodeabyyuyue.getRealname());
		dbc.setString(9, dbodeabyyuyue.getPhone());
		dbc.setString(10, dbodeabyyuyue.getCarcode());
		dbc.setTimestamp(11, new Timestamp(dbodeabyyuyue.getAdddate().getTime()));
		dbc.setString(12, dbodeabyyuyue.getDealmessage());
		dbc.setInt(13, dbodeabyyuyue.getQujian());
		dbc.setString(14, dbodeabyyuyue.getOpenid());
		dbc.setInt(15, dbodeabyyuyue.getFromsource());
		dbc.setString(16, dbodeabyyuyue.getLicheng());
		dbc.setInt(17, dbodeabyyuyue.getIssenior());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaByyuyue dbodeabyyuyue) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_byyuyue(`id`,`eid`,`placeid`,`isdelete`,`dealstate`,`userid`,`zhekou`,`realname`,`phone`,`carcode`,`adddate`,`dealmessage`,`qujian`,`openid`,`fromsource`,`licheng`,`issenior`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeabyyuyue.getId());
		dbc.setInt(2, dbodeabyyuyue.getEid());
		dbc.setInt(3, dbodeabyyuyue.getPlaceid());
		dbc.setInt(4, dbodeabyyuyue.getIsdelete());
		dbc.setInt(5, dbodeabyyuyue.getDealstate());
		dbc.setInt(6, dbodeabyyuyue.getUserid());
		dbc.setString(7, dbodeabyyuyue.getZhekou());
		dbc.setString(8, dbodeabyyuyue.getRealname());
		dbc.setString(9, dbodeabyyuyue.getPhone());
		dbc.setString(10, dbodeabyyuyue.getCarcode());
		dbc.setTimestamp(11, new Timestamp(dbodeabyyuyue.getAdddate().getTime()));
		dbc.setString(12, dbodeabyyuyue.getDealmessage());
		dbc.setInt(13, dbodeabyyuyue.getQujian());
		dbc.setString(14, dbodeabyyuyue.getOpenid());
		dbc.setInt(15, dbodeabyyuyue.getFromsource());
		dbc.setString(16, dbodeabyyuyue.getLicheng());
		dbc.setInt(17, dbodeabyyuyue.getIssenior());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaByyuyue dbodeabyyuyue) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_byyuyue set ");
		boolean flag = false;
		if(dbodeabyyuyue.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodeabyyuyue.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",eid=?");
			}else{
				sb.append("eid=?");
				flag=true;
			}
		}
		if(dbodeabyyuyue.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",placeid=?");
			}else{
				sb.append("placeid=?");
				flag=true;
			}
		}
		if(dbodeabyyuyue.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dbodeabyyuyue.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",dealstate=?");
			}else{
				sb.append("dealstate=?");
				flag=true;
			}
		}
		if(dbodeabyyuyue.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",userid=?");
			}else{
				sb.append("userid=?");
				flag=true;
			}
		}
		if(dbodeabyyuyue.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",zhekou=?");
			}else{
				sb.append("zhekou=?");
				flag=true;
			}
		}
		if(dbodeabyyuyue.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",realname=?");
			}else{
				sb.append("realname=?");
				flag=true;
			}
		}
		if(dbodeabyyuyue.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",phone=?");
			}else{
				sb.append("phone=?");
				flag=true;
			}
		}
		if(dbodeabyyuyue.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",carcode=?");
			}else{
				sb.append("carcode=?");
				flag=true;
			}
		}
		if(dbodeabyyuyue.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbodeabyyuyue.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",dealmessage=?");
			}else{
				sb.append("dealmessage=?");
				flag=true;
			}
		}
		if(dbodeabyyuyue.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",qujian=?");
			}else{
				sb.append("qujian=?");
				flag=true;
			}
		}
		if(dbodeabyyuyue.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",openid=?");
			}else{
				sb.append("openid=?");
				flag=true;
			}
		}
		if(dbodeabyyuyue.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",fromsource=?");
			}else{
				sb.append("fromsource=?");
				flag=true;
			}
		}
		if(dbodeabyyuyue.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",licheng=?");
			}else{
				sb.append("licheng=?");
				flag=true;
			}
		}
		if(dbodeabyyuyue.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",issenior=?");
			}else{
				sb.append("issenior=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeabyyuyue.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeabyyuyue.getId());k++;
		}
		if(dbodeabyyuyue.COLUMN_FLAG[1]){
			dbc.setInt(k, dbodeabyyuyue.getEid());k++;
		}
		if(dbodeabyyuyue.COLUMN_FLAG[2]){
			dbc.setInt(k, dbodeabyyuyue.getPlaceid());k++;
		}
		if(dbodeabyyuyue.COLUMN_FLAG[3]){
			dbc.setInt(k, dbodeabyyuyue.getIsdelete());k++;
		}
		if(dbodeabyyuyue.COLUMN_FLAG[4]){
			dbc.setInt(k, dbodeabyyuyue.getDealstate());k++;
		}
		if(dbodeabyyuyue.COLUMN_FLAG[5]){
			dbc.setInt(k, dbodeabyyuyue.getUserid());k++;
		}
		if(dbodeabyyuyue.COLUMN_FLAG[6]){
			dbc.setString(k, dbodeabyyuyue.getZhekou());k++;
		}
		if(dbodeabyyuyue.COLUMN_FLAG[7]){
			dbc.setString(k, dbodeabyyuyue.getRealname());k++;
		}
		if(dbodeabyyuyue.COLUMN_FLAG[8]){
			dbc.setString(k, dbodeabyyuyue.getPhone());k++;
		}
		if(dbodeabyyuyue.COLUMN_FLAG[9]){
			dbc.setString(k, dbodeabyyuyue.getCarcode());k++;
		}
		if(dbodeabyyuyue.COLUMN_FLAG[10]){
			dbc.setTimestamp(k, new Timestamp(dbodeabyyuyue.getAdddate().getTime()));k++;
		}
		if(dbodeabyyuyue.COLUMN_FLAG[11]){
			dbc.setString(k, dbodeabyyuyue.getDealmessage());k++;
		}
		if(dbodeabyyuyue.COLUMN_FLAG[12]){
			dbc.setInt(k, dbodeabyyuyue.getQujian());k++;
		}
		if(dbodeabyyuyue.COLUMN_FLAG[13]){
			dbc.setString(k, dbodeabyyuyue.getOpenid());k++;
		}
		if(dbodeabyyuyue.COLUMN_FLAG[14]){
			dbc.setInt(k, dbodeabyyuyue.getFromsource());k++;
		}
		if(dbodeabyyuyue.COLUMN_FLAG[15]){
			dbc.setString(k, dbodeabyyuyue.getLicheng());k++;
		}
		if(dbodeabyyuyue.COLUMN_FLAG[16]){
			dbc.setInt(k, dbodeabyyuyue.getIssenior());k++;
		}
		dbc.setInt(k, dbodeabyyuyue.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaByyuyue dbodeabyyuyue) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeabyyuyue);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static List<DboDeaByyuyue> DboDeaByyuyueSelectAllColumnByeid(int eid){
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_byyuyue where eid = ?";
		List<DboDeaByyuyue> list = new ArrayList<DboDeaByyuyue>();
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, eid);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaByyuyue obj = new DboDeaByyuyue();
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