package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboKanTotalbaoming;

public class  DboKanTotalbaomingDao  extends BaseDao {

	public static void fill(ResultSet rs, DboKanTotalbaoming dbokantotalbaoming) throws SQLException {
		dbokantotalbaoming.setId(rs.getInt("id"));//
		dbokantotalbaoming.setActivetype(rs.getString("activetype"));//
		dbokantotalbaoming.setSex(rs.getString("sex"));//
		dbokantotalbaoming.setHasbuy(rs.getString("hasbuy"));//
		dbokantotalbaoming.setPaymonth(rs.getString("paymonth"));//
		dbokantotalbaoming.setPhonearea(rs.getString("phonearea"));//
		dbokantotalbaoming.setArea(rs.getString("area"));//
		dbokantotalbaoming.setBuytimeinmind(rs.getString("buytimeinmind"));//
		dbokantotalbaoming.setBirthday(rs.getString("birthday"));//
		dbokantotalbaoming.setPhone(rs.getString("phone"));//
		dbokantotalbaoming.setUsername(rs.getString("username"));//
		dbokantotalbaoming.setCarinmind(rs.getString("carinmind"));//
		dbokantotalbaoming.setComefrominfo(rs.getString("comefrominfo"));//
		dbokantotalbaoming.setAddress(rs.getString("address"));//
		dbokantotalbaoming.setFollowlog(rs.getString("followlog"));//
		dbokantotalbaoming.setBaomingdate(rs.getTimestamp("baomingdate"));//
		dbokantotalbaoming.setIsdelete(rs.getInt("isdelete"));//
		dbokantotalbaoming.setState(rs.getInt("state"));//
		dbokantotalbaoming.setAreaid(rs.getInt("areaid"));//
		dbokantotalbaoming.setBrandid(rs.getInt("brandid"));//
		dbokantotalbaoming.setBuymodel(rs.getString("buymodel"));//
		dbokantotalbaoming.setSerialid(rs.getInt("serialid"));//
	}

	public static List<DboKanTotalbaoming> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_kan_totalbaoming";
		List<DboKanTotalbaoming> list = new ArrayList<DboKanTotalbaoming>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboKanTotalbaoming dbokantotalbaoming = new DboKanTotalbaoming();
				fill(rs, dbokantotalbaoming);
				list.add(dbokantotalbaoming);
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


	public static List<DboKanTotalbaoming> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_kan_totalbaoming where "+subsql+"";
		List<DboKanTotalbaoming> list = new ArrayList<DboKanTotalbaoming>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboKanTotalbaoming dbokantotalbaoming = new DboKanTotalbaoming();
				fill(rs, dbokantotalbaoming);
				list.add(dbokantotalbaoming);
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
		String sql = "select count(*) from dbo_kan_totalbaoming where "+subsql+"";
		
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
		String sql = "delete from dbo_kan_totalbaoming where "+subsql+"";
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
		String sql = "delete from dbo_kan_totalbaoming where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboKanTotalbaoming dbokantotalbaoming) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_kan_totalbaoming(`id`,`activetype`,`sex`,`hasbuy`,`paymonth`,`phonearea`,`area`,`buytimeinmind`,`birthday`,`phone`,`username`,`carinmind`,`comefrominfo`,`address`,`followlog`,`baomingdate`,`isdelete`,`state`,`areaid`,`brandid`,`buymodel`,`serialid`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbokantotalbaoming.getId());
		dbc.setString(2, dbokantotalbaoming.getActivetype());
		dbc.setString(3, dbokantotalbaoming.getSex());
		dbc.setString(4, dbokantotalbaoming.getHasbuy());
		dbc.setString(5, dbokantotalbaoming.getPaymonth());
		dbc.setString(6, dbokantotalbaoming.getPhonearea());
		dbc.setString(7, dbokantotalbaoming.getArea());
		dbc.setString(8, dbokantotalbaoming.getBuytimeinmind());
		dbc.setString(9, dbokantotalbaoming.getBirthday());
		dbc.setString(10, dbokantotalbaoming.getPhone());
		dbc.setString(11, dbokantotalbaoming.getUsername());
		dbc.setString(12, dbokantotalbaoming.getCarinmind());
		dbc.setString(13, dbokantotalbaoming.getComefrominfo());
		dbc.setString(14, dbokantotalbaoming.getAddress());
		dbc.setString(15, dbokantotalbaoming.getFollowlog());
		dbc.setTimestamp(16, new Timestamp(dbokantotalbaoming.getBaomingdate().getTime()));
		dbc.setInt(17, dbokantotalbaoming.getIsdelete());
		dbc.setInt(18, dbokantotalbaoming.getState());
		dbc.setInt(19, dbokantotalbaoming.getAreaid());
		dbc.setInt(20, dbokantotalbaoming.getBrandid());
		dbc.setString(21, dbokantotalbaoming.getBuymodel());
		dbc.setInt(22, dbokantotalbaoming.getSerialid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboKanTotalbaoming dbokantotalbaoming) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_kan_totalbaoming(`id`,`activetype`,`sex`,`hasbuy`,`paymonth`,`phonearea`,`area`,`buytimeinmind`,`birthday`,`phone`,`username`,`carinmind`,`comefrominfo`,`address`,`followlog`,`baomingdate`,`isdelete`,`state`,`areaid`,`brandid`,`buymodel`,`serialid`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbokantotalbaoming.getId());
		dbc.setString(2, dbokantotalbaoming.getActivetype());
		dbc.setString(3, dbokantotalbaoming.getSex());
		dbc.setString(4, dbokantotalbaoming.getHasbuy());
		dbc.setString(5, dbokantotalbaoming.getPaymonth());
		dbc.setString(6, dbokantotalbaoming.getPhonearea());
		dbc.setString(7, dbokantotalbaoming.getArea());
		dbc.setString(8, dbokantotalbaoming.getBuytimeinmind());
		dbc.setString(9, dbokantotalbaoming.getBirthday());
		dbc.setString(10, dbokantotalbaoming.getPhone());
		dbc.setString(11, dbokantotalbaoming.getUsername());
		dbc.setString(12, dbokantotalbaoming.getCarinmind());
		dbc.setString(13, dbokantotalbaoming.getComefrominfo());
		dbc.setString(14, dbokantotalbaoming.getAddress());
		dbc.setString(15, dbokantotalbaoming.getFollowlog());
		dbc.setTimestamp(16, new Timestamp(dbokantotalbaoming.getBaomingdate().getTime()));
		dbc.setInt(17, dbokantotalbaoming.getIsdelete());
		dbc.setInt(18, dbokantotalbaoming.getState());
		dbc.setInt(19, dbokantotalbaoming.getAreaid());
		dbc.setInt(20, dbokantotalbaoming.getBrandid());
		dbc.setString(21, dbokantotalbaoming.getBuymodel());
		dbc.setInt(22, dbokantotalbaoming.getSerialid());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboKanTotalbaoming dbokantotalbaoming) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_kan_totalbaoming set ");
		boolean flag = false;
		if(dbokantotalbaoming.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbokantotalbaoming.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",activetype=?");
			}else{
				sb.append("activetype=?");
				flag=true;
			}
		}
		if(dbokantotalbaoming.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",sex=?");
			}else{
				sb.append("sex=?");
				flag=true;
			}
		}
		if(dbokantotalbaoming.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",hasbuy=?");
			}else{
				sb.append("hasbuy=?");
				flag=true;
			}
		}
		if(dbokantotalbaoming.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",paymonth=?");
			}else{
				sb.append("paymonth=?");
				flag=true;
			}
		}
		if(dbokantotalbaoming.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",phonearea=?");
			}else{
				sb.append("phonearea=?");
				flag=true;
			}
		}
		if(dbokantotalbaoming.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",area=?");
			}else{
				sb.append("area=?");
				flag=true;
			}
		}
		if(dbokantotalbaoming.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",buytimeinmind=?");
			}else{
				sb.append("buytimeinmind=?");
				flag=true;
			}
		}
		if(dbokantotalbaoming.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",birthday=?");
			}else{
				sb.append("birthday=?");
				flag=true;
			}
		}
		if(dbokantotalbaoming.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",phone=?");
			}else{
				sb.append("phone=?");
				flag=true;
			}
		}
		if(dbokantotalbaoming.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",username=?");
			}else{
				sb.append("username=?");
				flag=true;
			}
		}
		if(dbokantotalbaoming.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",carinmind=?");
			}else{
				sb.append("carinmind=?");
				flag=true;
			}
		}
		if(dbokantotalbaoming.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",comefrominfo=?");
			}else{
				sb.append("comefrominfo=?");
				flag=true;
			}
		}
		if(dbokantotalbaoming.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",address=?");
			}else{
				sb.append("address=?");
				flag=true;
			}
		}
		if(dbokantotalbaoming.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",followlog=?");
			}else{
				sb.append("followlog=?");
				flag=true;
			}
		}
		if(dbokantotalbaoming.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",baomingdate=?");
			}else{
				sb.append("baomingdate=?");
				flag=true;
			}
		}
		if(dbokantotalbaoming.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dbokantotalbaoming.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",state=?");
			}else{
				sb.append("state=?");
				flag=true;
			}
		}
		if(dbokantotalbaoming.COLUMN_FLAG[18]){
			if(flag){
				sb.append(",areaid=?");
			}else{
				sb.append("areaid=?");
				flag=true;
			}
		}
		if(dbokantotalbaoming.COLUMN_FLAG[19]){
			if(flag){
				sb.append(",brandid=?");
			}else{
				sb.append("brandid=?");
				flag=true;
			}
		}
		if(dbokantotalbaoming.COLUMN_FLAG[20]){
			if(flag){
				sb.append(",buymodel=?");
			}else{
				sb.append("buymodel=?");
				flag=true;
			}
		}
		if(dbokantotalbaoming.COLUMN_FLAG[21]){
			if(flag){
				sb.append(",serialid=?");
			}else{
				sb.append("serialid=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbokantotalbaoming.COLUMN_FLAG[0]){
			dbc.setInt(k, dbokantotalbaoming.getId());k++;
		}
		if(dbokantotalbaoming.COLUMN_FLAG[1]){
			dbc.setString(k, dbokantotalbaoming.getActivetype());k++;
		}
		if(dbokantotalbaoming.COLUMN_FLAG[2]){
			dbc.setString(k, dbokantotalbaoming.getSex());k++;
		}
		if(dbokantotalbaoming.COLUMN_FLAG[3]){
			dbc.setString(k, dbokantotalbaoming.getHasbuy());k++;
		}
		if(dbokantotalbaoming.COLUMN_FLAG[4]){
			dbc.setString(k, dbokantotalbaoming.getPaymonth());k++;
		}
		if(dbokantotalbaoming.COLUMN_FLAG[5]){
			dbc.setString(k, dbokantotalbaoming.getPhonearea());k++;
		}
		if(dbokantotalbaoming.COLUMN_FLAG[6]){
			dbc.setString(k, dbokantotalbaoming.getArea());k++;
		}
		if(dbokantotalbaoming.COLUMN_FLAG[7]){
			dbc.setString(k, dbokantotalbaoming.getBuytimeinmind());k++;
		}
		if(dbokantotalbaoming.COLUMN_FLAG[8]){
			dbc.setString(k, dbokantotalbaoming.getBirthday());k++;
		}
		if(dbokantotalbaoming.COLUMN_FLAG[9]){
			dbc.setString(k, dbokantotalbaoming.getPhone());k++;
		}
		if(dbokantotalbaoming.COLUMN_FLAG[10]){
			dbc.setString(k, dbokantotalbaoming.getUsername());k++;
		}
		if(dbokantotalbaoming.COLUMN_FLAG[11]){
			dbc.setString(k, dbokantotalbaoming.getCarinmind());k++;
		}
		if(dbokantotalbaoming.COLUMN_FLAG[12]){
			dbc.setString(k, dbokantotalbaoming.getComefrominfo());k++;
		}
		if(dbokantotalbaoming.COLUMN_FLAG[13]){
			dbc.setString(k, dbokantotalbaoming.getAddress());k++;
		}
		if(dbokantotalbaoming.COLUMN_FLAG[14]){
			dbc.setString(k, dbokantotalbaoming.getFollowlog());k++;
		}
		if(dbokantotalbaoming.COLUMN_FLAG[15]){
			dbc.setTimestamp(k, new Timestamp(dbokantotalbaoming.getBaomingdate().getTime()));k++;
		}
		if(dbokantotalbaoming.COLUMN_FLAG[16]){
			dbc.setInt(k, dbokantotalbaoming.getIsdelete());k++;
		}
		if(dbokantotalbaoming.COLUMN_FLAG[17]){
			dbc.setInt(k, dbokantotalbaoming.getState());k++;
		}
		if(dbokantotalbaoming.COLUMN_FLAG[18]){
			dbc.setInt(k, dbokantotalbaoming.getAreaid());k++;
		}
		if(dbokantotalbaoming.COLUMN_FLAG[19]){
			dbc.setInt(k, dbokantotalbaoming.getBrandid());k++;
		}
		if(dbokantotalbaoming.COLUMN_FLAG[20]){
			dbc.setString(k, dbokantotalbaoming.getBuymodel());k++;
		}
		if(dbokantotalbaoming.COLUMN_FLAG[21]){
			dbc.setInt(k, dbokantotalbaoming.getSerialid());k++;
		}
		dbc.setInt(k, dbokantotalbaoming.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboKanTotalbaoming dbokantotalbaoming) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbokantotalbaoming);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}