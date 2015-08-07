package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboNewRelated;

public class  DboNewRelatedDao  extends BaseDao {

	public static void fill(ResultSet rs, DboNewRelated dbonewrelated) throws SQLException {
		dbonewrelated.setId(rs.getInt("id"));//
		dbonewrelated.setContentid(rs.getInt("contentid"));//新闻内容id
		dbonewrelated.setUrl(rs.getString("url"));//关联链接地址
		dbonewrelated.setTitle(rs.getString("title"));//关联新闻标题
	}

	public static List<DboNewRelated> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_new_related";
		List<DboNewRelated> list = new ArrayList<DboNewRelated>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboNewRelated dbonewrelated = new DboNewRelated();
				fill(rs, dbonewrelated);
				list.add(dbonewrelated);
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


	public static List<DboNewRelated> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_new_related where "+subsql+"";
		List<DboNewRelated> list = new ArrayList<DboNewRelated>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboNewRelated dbonewrelated = new DboNewRelated();
				fill(rs, dbonewrelated);
				list.add(dbonewrelated);
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
		String sql = "select count(*) from dbo_new_related where "+subsql+"";
		
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
		String sql = "delete from dbo_new_related where "+subsql+"";
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
		String sql = "delete from dbo_new_related where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboNewRelated dbonewrelated) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_new_related(`id`,`contentid`,`url`,`title`) values(?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbonewrelated.getId());
		dbc.setInt(2, dbonewrelated.getContentid());
		dbc.setString(3, dbonewrelated.getUrl());
		dbc.setString(4, dbonewrelated.getTitle());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboNewRelated dbonewrelated) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_new_related(`id`,`contentid`,`url`,`title`) values(?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbonewrelated.getId());
		dbc.setInt(2, dbonewrelated.getContentid());
		dbc.setString(3, dbonewrelated.getUrl());
		dbc.setString(4, dbonewrelated.getTitle());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboNewRelated dbonewrelated) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_new_related set ");
		boolean flag = false;
		if(dbonewrelated.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbonewrelated.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",contentid=?");
			}else{
				sb.append("contentid=?");
				flag=true;
			}
		}
		if(dbonewrelated.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",url=?");
			}else{
				sb.append("url=?");
				flag=true;
			}
		}
		if(dbonewrelated.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",title=?");
			}else{
				sb.append("title=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbonewrelated.COLUMN_FLAG[0]){
			dbc.setInt(k, dbonewrelated.getId());k++;
		}
		if(dbonewrelated.COLUMN_FLAG[1]){
			dbc.setInt(k, dbonewrelated.getContentid());k++;
		}
		if(dbonewrelated.COLUMN_FLAG[2]){
			dbc.setString(k, dbonewrelated.getUrl());k++;
		}
		if(dbonewrelated.COLUMN_FLAG[3]){
			dbc.setString(k, dbonewrelated.getTitle());k++;
		}
		dbc.setInt(k, dbonewrelated.getId());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboNewRelated dbonewrelated) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbonewrelated);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}