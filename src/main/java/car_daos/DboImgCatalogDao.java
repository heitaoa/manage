package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboImgCatalog;

public class  DboImgCatalogDao  extends BaseDao {

	public static void fill(ResultSet rs, DboImgCatalog dboimgcatalog) throws SQLException {
		dboimgcatalog.setCatalogid(rs.getInt("catalogid"));//
		dboimgcatalog.setCatalogname(rs.getString("catalogname"));//
		dboimgcatalog.setFatherid(rs.getInt("fatherid"));//
		dboimgcatalog.setByname(rs.getString("byname"));//
		dboimgcatalog.setPath(rs.getString("path"));//
		dboimgcatalog.setIsdelete(rs.getInt("isdelete"));//
		dboimgcatalog.setAdddate(rs.getTimestamp("adddate"));//
		dboimgcatalog.setSortid(rs.getInt("sortid"));//
		dboimgcatalog.setLname(rs.getString("lname"));//
		dboimgcatalog.setPathlevel(rs.getInt("pathlevel"));//
	}

	public static List<DboImgCatalog> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_img_catalog";
		List<DboImgCatalog> list = new ArrayList<DboImgCatalog>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboImgCatalog dboimgcatalog = new DboImgCatalog();
				fill(rs, dboimgcatalog);
				list.add(dboimgcatalog);
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


	public static List<DboImgCatalog> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_img_catalog where "+subsql+"";
		List<DboImgCatalog> list = new ArrayList<DboImgCatalog>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboImgCatalog dboimgcatalog = new DboImgCatalog();
				fill(rs, dboimgcatalog);
				list.add(dboimgcatalog);
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
		String sql = "select count(*) from dbo_img_catalog where "+subsql+"";
		
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
		String sql = "delete from dbo_img_catalog where "+subsql+"";
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
		String sql = "delete from dbo_img_catalog where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboImgCatalog dboimgcatalog) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_img_catalog(`catalogid`,`catalogname`,`fatherid`,`byname`,`path`,`isdelete`,`adddate`,`sortid`,`lname`,`pathlevel`) values(?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboimgcatalog.getCatalogid());
		dbc.setString(2, dboimgcatalog.getCatalogname());
		dbc.setInt(3, dboimgcatalog.getFatherid());
		dbc.setString(4, dboimgcatalog.getByname());
		dbc.setString(5, dboimgcatalog.getPath());
		dbc.setInt(6, dboimgcatalog.getIsdelete());
		dbc.setTimestamp(7, new Timestamp(dboimgcatalog.getAdddate().getTime()));
		dbc.setInt(8, dboimgcatalog.getSortid());
		dbc.setString(9, dboimgcatalog.getLname());
		dbc.setInt(10, dboimgcatalog.getPathlevel());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboImgCatalog dboimgcatalog) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_img_catalog(`catalogid`,`catalogname`,`fatherid`,`byname`,`path`,`isdelete`,`adddate`,`sortid`,`lname`,`pathlevel`) values(?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboimgcatalog.getCatalogid());
		dbc.setString(2, dboimgcatalog.getCatalogname());
		dbc.setInt(3, dboimgcatalog.getFatherid());
		dbc.setString(4, dboimgcatalog.getByname());
		dbc.setString(5, dboimgcatalog.getPath());
		dbc.setInt(6, dboimgcatalog.getIsdelete());
		dbc.setTimestamp(7, new Timestamp(dboimgcatalog.getAdddate().getTime()));
		dbc.setInt(8, dboimgcatalog.getSortid());
		dbc.setString(9, dboimgcatalog.getLname());
		dbc.setInt(10, dboimgcatalog.getPathlevel());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboImgCatalog dboimgcatalog) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_img_catalog set ");
		boolean flag = false;
		if(dboimgcatalog.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",catalogid=?");
			}else{
				sb.append("catalogid=?");
				flag=true;
			}
		}
		if(dboimgcatalog.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",catalogname=?");
			}else{
				sb.append("catalogname=?");
				flag=true;
			}
		}
		if(dboimgcatalog.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",fatherid=?");
			}else{
				sb.append("fatherid=?");
				flag=true;
			}
		}
		if(dboimgcatalog.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",byname=?");
			}else{
				sb.append("byname=?");
				flag=true;
			}
		}
		if(dboimgcatalog.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",path=?");
			}else{
				sb.append("path=?");
				flag=true;
			}
		}
		if(dboimgcatalog.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dboimgcatalog.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dboimgcatalog.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",sortid=?");
			}else{
				sb.append("sortid=?");
				flag=true;
			}
		}
		if(dboimgcatalog.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",lname=?");
			}else{
				sb.append("lname=?");
				flag=true;
			}
		}
		if(dboimgcatalog.COLUMN_FLAG[9]){
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
		if(dboimgcatalog.COLUMN_FLAG[0]){
			dbc.setInt(k, dboimgcatalog.getCatalogid());k++;
		}
		if(dboimgcatalog.COLUMN_FLAG[1]){
			dbc.setString(k, dboimgcatalog.getCatalogname());k++;
		}
		if(dboimgcatalog.COLUMN_FLAG[2]){
			dbc.setInt(k, dboimgcatalog.getFatherid());k++;
		}
		if(dboimgcatalog.COLUMN_FLAG[3]){
			dbc.setString(k, dboimgcatalog.getByname());k++;
		}
		if(dboimgcatalog.COLUMN_FLAG[4]){
			dbc.setString(k, dboimgcatalog.getPath());k++;
		}
		if(dboimgcatalog.COLUMN_FLAG[5]){
			dbc.setInt(k, dboimgcatalog.getIsdelete());k++;
		}
		if(dboimgcatalog.COLUMN_FLAG[6]){
			dbc.setTimestamp(k, new Timestamp(dboimgcatalog.getAdddate().getTime()));k++;
		}
		if(dboimgcatalog.COLUMN_FLAG[7]){
			dbc.setInt(k, dboimgcatalog.getSortid());k++;
		}
		if(dboimgcatalog.COLUMN_FLAG[8]){
			dbc.setString(k, dboimgcatalog.getLname());k++;
		}
		if(dboimgcatalog.COLUMN_FLAG[9]){
			dbc.setInt(k, dboimgcatalog.getPathlevel());k++;
		}
		dbc.setInt(k, dboimgcatalog.getCatalogid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboImgCatalog dboimgcatalog) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dboimgcatalog);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}