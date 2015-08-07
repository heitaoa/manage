package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboNewPublishtime;

public class  DboNewPublishtimeDao  extends BaseDao {

	public static void fill(ResultSet rs, DboNewPublishtime dbonewpublishtime) throws SQLException {
		dbonewpublishtime.setId(rs.getInt("id"));//新闻id
		dbonewpublishtime.setPublishtime(rs.getTimestamp("publishtime"));//发布时间
	}

	public static List<DboNewPublishtime> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_new_publishtime";
		List<DboNewPublishtime> list = new ArrayList<DboNewPublishtime>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboNewPublishtime dbonewpublishtime = new DboNewPublishtime();
				fill(rs, dbonewpublishtime);
				list.add(dbonewpublishtime);
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


	public static List<DboNewPublishtime> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_new_publishtime where "+subsql+"";
		List<DboNewPublishtime> list = new ArrayList<DboNewPublishtime>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboNewPublishtime dbonewpublishtime = new DboNewPublishtime();
				fill(rs, dbonewpublishtime);
				list.add(dbonewpublishtime);
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
		String sql = "select count(*) from dbo_new_publishtime where "+subsql+"";
		
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
		String sql = "delete from dbo_new_publishtime where "+subsql+"";
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
		String sql = "delete from dbo_new_publishtime where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboNewPublishtime dbonewpublishtime) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_new_publishtime(`id`,`publishtime`) values(?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbonewpublishtime.getId());
		dbc.setTimestamp(2, new Timestamp(dbonewpublishtime.getPublishtime().getTime()));
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboNewPublishtime dbonewpublishtime) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_new_publishtime(`id`,`publishtime`) values(?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbonewpublishtime.getId());
		dbc.setTimestamp(2, new Timestamp(dbonewpublishtime.getPublishtime().getTime()));
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboNewPublishtime dbonewpublishtime) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_new_publishtime set ");
		boolean flag = false;
		if(dbonewpublishtime.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbonewpublishtime.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",publishtime=?");
			}else{
				sb.append("publishtime=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbonewpublishtime.COLUMN_FLAG[0]){
			dbc.setInt(k, dbonewpublishtime.getId());k++;
		}
		if(dbonewpublishtime.COLUMN_FLAG[1]){
			dbc.setTimestamp(k, new Timestamp(dbonewpublishtime.getPublishtime().getTime()));k++;
		}
		dbc.setInt(k, dbonewpublishtime.getId());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboNewPublishtime dbonewpublishtime) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbonewpublishtime);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}