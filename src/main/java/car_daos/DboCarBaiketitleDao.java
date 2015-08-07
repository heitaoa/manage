package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboCarBaiketitle;

public class  DboCarBaiketitleDao  extends BaseDao {

	public static void fill(ResultSet rs, DboCarBaiketitle dbocarbaiketitle) throws SQLException {
		dbocarbaiketitle.setId(rs.getInt("id"));//
		dbocarbaiketitle.setHascontent(rs.getInt("hascontent"));//
		dbocarbaiketitle.setIsdelete(rs.getInt("isdelete"));//
		dbocarbaiketitle.setAddtime(rs.getTimestamp("addtime"));//
		dbocarbaiketitle.setUptime(rs.getTimestamp("uptime"));//
		dbocarbaiketitle.setTitle(rs.getString("title"));//
		dbocarbaiketitle.setPhotourl(rs.getString("photourl"));//
		dbocarbaiketitle.setBaikecontent(rs.getString("baikecontent"));//
		dbocarbaiketitle.setHotlevel(rs.getInt("hotlevel"));//
	}

	public static List<DboCarBaiketitle> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_car_baiketitle";
		List<DboCarBaiketitle> list = new ArrayList<DboCarBaiketitle>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarBaiketitle dbocarbaiketitle = new DboCarBaiketitle();
				fill(rs, dbocarbaiketitle);
				list.add(dbocarbaiketitle);
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


	public static List<DboCarBaiketitle> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_car_baiketitle where "+subsql+"";
		List<DboCarBaiketitle> list = new ArrayList<DboCarBaiketitle>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarBaiketitle dbocarbaiketitle = new DboCarBaiketitle();
				fill(rs, dbocarbaiketitle);
				list.add(dbocarbaiketitle);
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
		String sql = "select count(*) from dbo_car_baiketitle where "+subsql+"";
		
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
		String sql = "delete from dbo_car_baiketitle where "+subsql+"";
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
		String sql = "delete from dbo_car_baiketitle where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboCarBaiketitle dbocarbaiketitle) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_car_baiketitle(`id`,`hascontent`,`isdelete`,`addtime`,`uptime`,`title`,`photourl`,`baikecontent`,`hotlevel`) values(?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbocarbaiketitle.getId());
		dbc.setInt(2, dbocarbaiketitle.getHascontent());
		dbc.setInt(3, dbocarbaiketitle.getIsdelete());
		dbc.setTimestamp(4, new Timestamp(dbocarbaiketitle.getAddtime().getTime()));
		dbc.setTimestamp(5, new Timestamp(dbocarbaiketitle.getUptime().getTime()));
		dbc.setString(6, dbocarbaiketitle.getTitle());
		dbc.setString(7, dbocarbaiketitle.getPhotourl());
		dbc.setString(8, dbocarbaiketitle.getBaikecontent());
		dbc.setInt(9, dbocarbaiketitle.getHotlevel());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboCarBaiketitle dbocarbaiketitle) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_car_baiketitle(`id`,`hascontent`,`isdelete`,`addtime`,`uptime`,`title`,`photourl`,`baikecontent`,`hotlevel`) values(?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbocarbaiketitle.getId());
		dbc.setInt(2, dbocarbaiketitle.getHascontent());
		dbc.setInt(3, dbocarbaiketitle.getIsdelete());
		dbc.setTimestamp(4, new Timestamp(dbocarbaiketitle.getAddtime().getTime()));
		dbc.setTimestamp(5, new Timestamp(dbocarbaiketitle.getUptime().getTime()));
		dbc.setString(6, dbocarbaiketitle.getTitle());
		dbc.setString(7, dbocarbaiketitle.getPhotourl());
		dbc.setString(8, dbocarbaiketitle.getBaikecontent());
		dbc.setInt(9, dbocarbaiketitle.getHotlevel());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboCarBaiketitle dbocarbaiketitle) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_car_baiketitle set ");
		boolean flag = false;
		if(dbocarbaiketitle.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbocarbaiketitle.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",hascontent=?");
			}else{
				sb.append("hascontent=?");
				flag=true;
			}
		}
		if(dbocarbaiketitle.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dbocarbaiketitle.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",addtime=?");
			}else{
				sb.append("addtime=?");
				flag=true;
			}
		}
		if(dbocarbaiketitle.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",uptime=?");
			}else{
				sb.append("uptime=?");
				flag=true;
			}
		}
		if(dbocarbaiketitle.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",title=?");
			}else{
				sb.append("title=?");
				flag=true;
			}
		}
		if(dbocarbaiketitle.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",photourl=?");
			}else{
				sb.append("photourl=?");
				flag=true;
			}
		}
		if(dbocarbaiketitle.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",baikecontent=?");
			}else{
				sb.append("baikecontent=?");
				flag=true;
			}
		}
		if(dbocarbaiketitle.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",hotlevel=?");
			}else{
				sb.append("hotlevel=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbocarbaiketitle.COLUMN_FLAG[0]){
			dbc.setInt(k, dbocarbaiketitle.getId());k++;
		}
		if(dbocarbaiketitle.COLUMN_FLAG[1]){
			dbc.setInt(k, dbocarbaiketitle.getHascontent());k++;
		}
		if(dbocarbaiketitle.COLUMN_FLAG[2]){
			dbc.setInt(k, dbocarbaiketitle.getIsdelete());k++;
		}
		if(dbocarbaiketitle.COLUMN_FLAG[3]){
			dbc.setTimestamp(k, new Timestamp(dbocarbaiketitle.getAddtime().getTime()));k++;
		}
		if(dbocarbaiketitle.COLUMN_FLAG[4]){
			dbc.setTimestamp(k, new Timestamp(dbocarbaiketitle.getUptime().getTime()));k++;
		}
		if(dbocarbaiketitle.COLUMN_FLAG[5]){
			dbc.setString(k, dbocarbaiketitle.getTitle());k++;
		}
		if(dbocarbaiketitle.COLUMN_FLAG[6]){
			dbc.setString(k, dbocarbaiketitle.getPhotourl());k++;
		}
		if(dbocarbaiketitle.COLUMN_FLAG[7]){
			dbc.setString(k, dbocarbaiketitle.getBaikecontent());k++;
		}
		if(dbocarbaiketitle.COLUMN_FLAG[8]){
			dbc.setInt(k, dbocarbaiketitle.getHotlevel());k++;
		}
		dbc.setInt(k, dbocarbaiketitle.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboCarBaiketitle dbocarbaiketitle) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbocarbaiketitle);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static List<DboCarBaiketitle> DboCarBaiketitleSelectAllColumnBylimit_beginlimit_num(int limit_begin,int limit_num){
		DBConnect dbc = null;
		String sql = "select * from dbo_car_baiketitle  order by id asc limit ?,?";
		List<DboCarBaiketitle> list = new ArrayList<DboCarBaiketitle>();
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, limit_begin);
			dbc.setInt(2, limit_num);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarBaiketitle obj = new DboCarBaiketitle();
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