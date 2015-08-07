package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboNewCatalog;

public class  DboNewCatalogDao  extends BaseDao {

	public static void fill(ResultSet rs, DboNewCatalog dbonewcatalog) throws SQLException {
		dbonewcatalog.setCatalogid(rs.getInt("catalogid"));//
		dbonewcatalog.setCatalogname(rs.getString("catalogname"));//
		dbonewcatalog.setFatherid(rs.getInt("fatherid"));//
		dbonewcatalog.setByname(rs.getString("byname"));//
		dbonewcatalog.setNavname(rs.getString("navname"));//
		dbonewcatalog.setHavedir(rs.getInt("havedir"));//
		dbonewcatalog.setClassid(rs.getInt("classid"));//
		dbonewcatalog.setIsdelete(rs.getInt("isdelete"));//
		dbonewcatalog.setPath(rs.getString("path"));//
		dbonewcatalog.setNewshtml(rs.getString("newshtml"));//
		dbonewcatalog.setSortid(rs.getInt("sortid"));//
		dbonewcatalog.setLname(rs.getString("lname"));//
		dbonewcatalog.setPathlevel(rs.getInt("pathlevel"));//
		dbonewcatalog.setSub_sites_id(rs.getInt("sub_sites_id"));//属于哪个分站
		dbonewcatalog.setAreaid(rs.getInt("areaid"));//所属区域
	}

	public static List<DboNewCatalog> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_new_catalog";
		List<DboNewCatalog> list = new ArrayList<DboNewCatalog>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboNewCatalog dbonewcatalog = new DboNewCatalog();
				fill(rs, dbonewcatalog);
				list.add(dbonewcatalog);
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


	public static List<DboNewCatalog> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_new_catalog where "+subsql+"";
		List<DboNewCatalog> list = new ArrayList<DboNewCatalog>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboNewCatalog dbonewcatalog = new DboNewCatalog();
				fill(rs, dbonewcatalog);
				list.add(dbonewcatalog);
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
		String sql = "select count(*) from dbo_new_catalog where "+subsql+"";
		
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
		String sql = "delete from dbo_new_catalog where "+subsql+"";
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
		String sql = "delete from dbo_new_catalog where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboNewCatalog dbonewcatalog) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_new_catalog(`catalogid`,`catalogname`,`fatherid`,`byname`,`navname`,`havedir`,`classid`,`isdelete`,`path`,`newshtml`,`sortid`,`lname`,`pathlevel`,`sub_sites_id`,`areaid`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbonewcatalog.getCatalogid());
		dbc.setString(2, dbonewcatalog.getCatalogname());
		dbc.setInt(3, dbonewcatalog.getFatherid());
		dbc.setString(4, dbonewcatalog.getByname());
		dbc.setString(5, dbonewcatalog.getNavname());
		dbc.setInt(6, dbonewcatalog.getHavedir());
		dbc.setInt(7, dbonewcatalog.getClassid());
		dbc.setInt(8, dbonewcatalog.getIsdelete());
		dbc.setString(9, dbonewcatalog.getPath());
		dbc.setString(10, dbonewcatalog.getNewshtml());
		dbc.setInt(11, dbonewcatalog.getSortid());
		dbc.setString(12, dbonewcatalog.getLname());
		dbc.setInt(13, dbonewcatalog.getPathlevel());
		dbc.setInt(14, dbonewcatalog.getSub_sites_id());
		dbc.setInt(15, dbonewcatalog.getAreaid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboNewCatalog dbonewcatalog) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_new_catalog(`catalogid`,`catalogname`,`fatherid`,`byname`,`navname`,`havedir`,`classid`,`isdelete`,`path`,`newshtml`,`sortid`,`lname`,`pathlevel`,`sub_sites_id`,`areaid`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbonewcatalog.getCatalogid());
		dbc.setString(2, dbonewcatalog.getCatalogname());
		dbc.setInt(3, dbonewcatalog.getFatherid());
		dbc.setString(4, dbonewcatalog.getByname());
		dbc.setString(5, dbonewcatalog.getNavname());
		dbc.setInt(6, dbonewcatalog.getHavedir());
		dbc.setInt(7, dbonewcatalog.getClassid());
		dbc.setInt(8, dbonewcatalog.getIsdelete());
		dbc.setString(9, dbonewcatalog.getPath());
		dbc.setString(10, dbonewcatalog.getNewshtml());
		dbc.setInt(11, dbonewcatalog.getSortid());
		dbc.setString(12, dbonewcatalog.getLname());
		dbc.setInt(13, dbonewcatalog.getPathlevel());
		dbc.setInt(14, dbonewcatalog.getSub_sites_id());
		dbc.setInt(15, dbonewcatalog.getAreaid());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboNewCatalog dbonewcatalog) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_new_catalog set ");
		boolean flag = false;
		if(dbonewcatalog.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",catalogid=?");
			}else{
				sb.append("catalogid=?");
				flag=true;
			}
		}
		if(dbonewcatalog.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",catalogname=?");
			}else{
				sb.append("catalogname=?");
				flag=true;
			}
		}
		if(dbonewcatalog.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",fatherid=?");
			}else{
				sb.append("fatherid=?");
				flag=true;
			}
		}
		if(dbonewcatalog.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",byname=?");
			}else{
				sb.append("byname=?");
				flag=true;
			}
		}
		if(dbonewcatalog.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",navname=?");
			}else{
				sb.append("navname=?");
				flag=true;
			}
		}
		if(dbonewcatalog.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",havedir=?");
			}else{
				sb.append("havedir=?");
				flag=true;
			}
		}
		if(dbonewcatalog.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",classid=?");
			}else{
				sb.append("classid=?");
				flag=true;
			}
		}
		if(dbonewcatalog.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dbonewcatalog.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",path=?");
			}else{
				sb.append("path=?");
				flag=true;
			}
		}
		if(dbonewcatalog.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",newshtml=?");
			}else{
				sb.append("newshtml=?");
				flag=true;
			}
		}
		if(dbonewcatalog.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",sortid=?");
			}else{
				sb.append("sortid=?");
				flag=true;
			}
		}
		if(dbonewcatalog.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",lname=?");
			}else{
				sb.append("lname=?");
				flag=true;
			}
		}
		if(dbonewcatalog.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",pathlevel=?");
			}else{
				sb.append("pathlevel=?");
				flag=true;
			}
		}
		if(dbonewcatalog.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",sub_sites_id=?");
			}else{
				sb.append("sub_sites_id=?");
				flag=true;
			}
		}
		if(dbonewcatalog.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",areaid=?");
			}else{
				sb.append("areaid=?");
				flag=true;
			}
		}
		sb.append(" where catalogid=?");
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbonewcatalog.COLUMN_FLAG[0]){
			dbc.setInt(k, dbonewcatalog.getCatalogid());k++;
		}
		if(dbonewcatalog.COLUMN_FLAG[1]){
			dbc.setString(k, dbonewcatalog.getCatalogname());k++;
		}
		if(dbonewcatalog.COLUMN_FLAG[2]){
			dbc.setInt(k, dbonewcatalog.getFatherid());k++;
		}
		if(dbonewcatalog.COLUMN_FLAG[3]){
			dbc.setString(k, dbonewcatalog.getByname());k++;
		}
		if(dbonewcatalog.COLUMN_FLAG[4]){
			dbc.setString(k, dbonewcatalog.getNavname());k++;
		}
		if(dbonewcatalog.COLUMN_FLAG[5]){
			dbc.setInt(k, dbonewcatalog.getHavedir());k++;
		}
		if(dbonewcatalog.COLUMN_FLAG[6]){
			dbc.setInt(k, dbonewcatalog.getClassid());k++;
		}
		if(dbonewcatalog.COLUMN_FLAG[7]){
			dbc.setInt(k, dbonewcatalog.getIsdelete());k++;
		}
		if(dbonewcatalog.COLUMN_FLAG[8]){
			dbc.setString(k, dbonewcatalog.getPath());k++;
		}
		if(dbonewcatalog.COLUMN_FLAG[9]){
			dbc.setString(k, dbonewcatalog.getNewshtml());k++;
		}
		if(dbonewcatalog.COLUMN_FLAG[10]){
			dbc.setInt(k, dbonewcatalog.getSortid());k++;
		}
		if(dbonewcatalog.COLUMN_FLAG[11]){
			dbc.setString(k, dbonewcatalog.getLname());k++;
		}
		if(dbonewcatalog.COLUMN_FLAG[12]){
			dbc.setInt(k, dbonewcatalog.getPathlevel());k++;
		}
		if(dbonewcatalog.COLUMN_FLAG[13]){
			dbc.setInt(k, dbonewcatalog.getSub_sites_id());k++;
		}
		if(dbonewcatalog.COLUMN_FLAG[14]){
			dbc.setInt(k, dbonewcatalog.getAreaid());k++;
		}
		dbc.setInt(k, dbonewcatalog.getCatalogid());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboNewCatalog dbonewcatalog) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbonewcatalog);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}