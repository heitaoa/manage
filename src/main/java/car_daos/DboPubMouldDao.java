package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboPubMould;

public class  DboPubMouldDao  extends BaseDao {

	public static void fill(ResultSet rs, DboPubMould dbopubmould) throws SQLException {
		dbopubmould.setMouldid(rs.getInt("mouldid"));//模型id
		dbopubmould.setMouldname(rs.getString("mouldname"));//模板名称
		dbopubmould.setMouldphoto(rs.getString("mouldphoto"));//模板图片
		dbopubmould.setMouldhtml(rs.getString("mouldhtml"));//模板代码
		dbopubmould.setMouldftl(rs.getString("mouldftl"));//模板ftl
	}

	public static List<DboPubMould> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_pub_mould";
		List<DboPubMould> list = new ArrayList<DboPubMould>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboPubMould dbopubmould = new DboPubMould();
				fill(rs, dbopubmould);
				list.add(dbopubmould);
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


	public static List<DboPubMould> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_pub_mould where "+subsql+"";
		List<DboPubMould> list = new ArrayList<DboPubMould>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboPubMould dbopubmould = new DboPubMould();
				fill(rs, dbopubmould);
				list.add(dbopubmould);
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
		String sql = "select count(*) from dbo_pub_mould where "+subsql+"";
		
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
		String sql = "delete from dbo_pub_mould where "+subsql+"";
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
		String sql = "delete from dbo_pub_mould where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboPubMould dbopubmould) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_pub_mould(`mouldid`,`mouldname`,`mouldphoto`,`mouldhtml`,`mouldftl`) values(?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbopubmould.getMouldid());
		dbc.setString(2, dbopubmould.getMouldname());
		dbc.setString(3, dbopubmould.getMouldphoto());
		dbc.setString(4, dbopubmould.getMouldhtml());
		dbc.setString(5, dbopubmould.getMouldftl());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboPubMould dbopubmould) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_pub_mould(`mouldid`,`mouldname`,`mouldphoto`,`mouldhtml`,`mouldftl`) values(?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbopubmould.getMouldid());
		dbc.setString(2, dbopubmould.getMouldname());
		dbc.setString(3, dbopubmould.getMouldphoto());
		dbc.setString(4, dbopubmould.getMouldhtml());
		dbc.setString(5, dbopubmould.getMouldftl());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboPubMould dbopubmould) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_pub_mould set ");
		boolean flag = false;
		if(dbopubmould.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",mouldid=?");
			}else{
				sb.append("mouldid=?");
				flag=true;
			}
		}
		if(dbopubmould.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",mouldname=?");
			}else{
				sb.append("mouldname=?");
				flag=true;
			}
		}
		if(dbopubmould.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",mouldphoto=?");
			}else{
				sb.append("mouldphoto=?");
				flag=true;
			}
		}
		if(dbopubmould.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",mouldhtml=?");
			}else{
				sb.append("mouldhtml=?");
				flag=true;
			}
		}
		if(dbopubmould.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",mouldftl=?");
			}else{
				sb.append("mouldftl=?");
				flag=true;
			}
		}
		sb.append(" where mouldid=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbopubmould.COLUMN_FLAG[0]){
			dbc.setInt(k, dbopubmould.getMouldid());k++;
		}
		if(dbopubmould.COLUMN_FLAG[1]){
			dbc.setString(k, dbopubmould.getMouldname());k++;
		}
		if(dbopubmould.COLUMN_FLAG[2]){
			dbc.setString(k, dbopubmould.getMouldphoto());k++;
		}
		if(dbopubmould.COLUMN_FLAG[3]){
			dbc.setString(k, dbopubmould.getMouldhtml());k++;
		}
		if(dbopubmould.COLUMN_FLAG[4]){
			dbc.setString(k, dbopubmould.getMouldftl());k++;
		}
		dbc.setInt(k, dbopubmould.getMouldid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboPubMould dbopubmould) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbopubmould);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}