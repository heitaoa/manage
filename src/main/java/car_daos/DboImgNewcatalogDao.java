package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboImgNewcatalog;

public class  DboImgNewcatalogDao  extends BaseDao {

	public static void fill(ResultSet rs, DboImgNewcatalog dboimgnewcatalog) throws SQLException {
		dboimgnewcatalog.setCatalogid(rs.getInt("catalogid"));//
		dboimgnewcatalog.setCatalogname(rs.getString("catalogname"));//
		dboimgnewcatalog.setFatherid(rs.getInt("fatherid"));//
		dboimgnewcatalog.setByname(rs.getString("byname"));//
		dboimgnewcatalog.setPath(rs.getString("path"));//
		dboimgnewcatalog.setIsdelete(rs.getInt("isdelete"));//
		dboimgnewcatalog.setAdddate(rs.getTimestamp("adddate"));//
		dboimgnewcatalog.setSortid(rs.getInt("sortid"));//
		dboimgnewcatalog.setLname(rs.getString("lname"));//
		dboimgnewcatalog.setPathlevel(rs.getInt("pathlevel"));//
	}

	public static List<DboImgNewcatalog> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_img_newcatalog";
		List<DboImgNewcatalog> list = new ArrayList<DboImgNewcatalog>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboImgNewcatalog dboimgnewcatalog = new DboImgNewcatalog();
				fill(rs, dboimgnewcatalog);
				list.add(dboimgnewcatalog);
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


	public static List<DboImgNewcatalog> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_img_newcatalog where "+subsql+"";
		List<DboImgNewcatalog> list = new ArrayList<DboImgNewcatalog>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboImgNewcatalog dboimgnewcatalog = new DboImgNewcatalog();
				fill(rs, dboimgnewcatalog);
				list.add(dboimgnewcatalog);
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
		String sql = "select count(*) from dbo_img_newcatalog where "+subsql+"";
		
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
		String sql = "delete from dbo_img_newcatalog where "+subsql+"";
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
		String sql = "delete from dbo_img_newcatalog where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboImgNewcatalog dboimgnewcatalog) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_img_newcatalog(`catalogid`,`catalogname`,`fatherid`,`byname`,`path`,`isdelete`,`adddate`,`sortid`,`lname`,`pathlevel`) values(?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboimgnewcatalog.getCatalogid());
		dbc.setString(2, dboimgnewcatalog.getCatalogname());
		dbc.setInt(3, dboimgnewcatalog.getFatherid());
		dbc.setString(4, dboimgnewcatalog.getByname());
		dbc.setString(5, dboimgnewcatalog.getPath());
		dbc.setInt(6, dboimgnewcatalog.getIsdelete());
		dbc.setTimestamp(7, new Timestamp(dboimgnewcatalog.getAdddate().getTime()));
		dbc.setInt(8, dboimgnewcatalog.getSortid());
		dbc.setString(9, dboimgnewcatalog.getLname());
		dbc.setInt(10, dboimgnewcatalog.getPathlevel());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboImgNewcatalog dboimgnewcatalog) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_img_newcatalog(`catalogid`,`catalogname`,`fatherid`,`byname`,`path`,`isdelete`,`adddate`,`sortid`,`lname`,`pathlevel`) values(?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboimgnewcatalog.getCatalogid());
		dbc.setString(2, dboimgnewcatalog.getCatalogname());
		dbc.setInt(3, dboimgnewcatalog.getFatherid());
		dbc.setString(4, dboimgnewcatalog.getByname());
		dbc.setString(5, dboimgnewcatalog.getPath());
		dbc.setInt(6, dboimgnewcatalog.getIsdelete());
		dbc.setTimestamp(7, new Timestamp(dboimgnewcatalog.getAdddate().getTime()));
		dbc.setInt(8, dboimgnewcatalog.getSortid());
		dbc.setString(9, dboimgnewcatalog.getLname());
		dbc.setInt(10, dboimgnewcatalog.getPathlevel());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboImgNewcatalog dboimgnewcatalog) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_img_newcatalog set ");
		boolean flag = false;
		if(dboimgnewcatalog.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",catalogid=?");
			}else{
				sb.append("catalogid=?");
				flag=true;
			}
		}
		if(dboimgnewcatalog.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",catalogname=?");
			}else{
				sb.append("catalogname=?");
				flag=true;
			}
		}
		if(dboimgnewcatalog.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",fatherid=?");
			}else{
				sb.append("fatherid=?");
				flag=true;
			}
		}
		if(dboimgnewcatalog.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",byname=?");
			}else{
				sb.append("byname=?");
				flag=true;
			}
		}
		if(dboimgnewcatalog.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",path=?");
			}else{
				sb.append("path=?");
				flag=true;
			}
		}
		if(dboimgnewcatalog.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dboimgnewcatalog.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dboimgnewcatalog.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",sortid=?");
			}else{
				sb.append("sortid=?");
				flag=true;
			}
		}
		if(dboimgnewcatalog.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",lname=?");
			}else{
				sb.append("lname=?");
				flag=true;
			}
		}
		if(dboimgnewcatalog.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",pathlevel=?");
			}else{
				sb.append("pathlevel=?");
				flag=true;
			}
		}
		sb.append(" where catalogid=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dboimgnewcatalog.COLUMN_FLAG[0]){
			dbc.setInt(k, dboimgnewcatalog.getCatalogid());k++;
		}
		if(dboimgnewcatalog.COLUMN_FLAG[1]){
			dbc.setString(k, dboimgnewcatalog.getCatalogname());k++;
		}
		if(dboimgnewcatalog.COLUMN_FLAG[2]){
			dbc.setInt(k, dboimgnewcatalog.getFatherid());k++;
		}
		if(dboimgnewcatalog.COLUMN_FLAG[3]){
			dbc.setString(k, dboimgnewcatalog.getByname());k++;
		}
		if(dboimgnewcatalog.COLUMN_FLAG[4]){
			dbc.setString(k, dboimgnewcatalog.getPath());k++;
		}
		if(dboimgnewcatalog.COLUMN_FLAG[5]){
			dbc.setInt(k, dboimgnewcatalog.getIsdelete());k++;
		}
		if(dboimgnewcatalog.COLUMN_FLAG[6]){
			dbc.setTimestamp(k, new Timestamp(dboimgnewcatalog.getAdddate().getTime()));k++;
		}
		if(dboimgnewcatalog.COLUMN_FLAG[7]){
			dbc.setInt(k, dboimgnewcatalog.getSortid());k++;
		}
		if(dboimgnewcatalog.COLUMN_FLAG[8]){
			dbc.setString(k, dboimgnewcatalog.getLname());k++;
		}
		if(dboimgnewcatalog.COLUMN_FLAG[9]){
			dbc.setInt(k, dboimgnewcatalog.getPathlevel());k++;
		}
		dbc.setInt(k, dboimgnewcatalog.getCatalogid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboImgNewcatalog dboimgnewcatalog) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dboimgnewcatalog);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}