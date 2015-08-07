package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaStoredisplay;

public class  DboDeaStoredisplayDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaStoredisplay dbodeastoredisplay) throws SQLException {
		dbodeastoredisplay.setPicid(rs.getInt("picid"));//店面展示图片自增长id
		dbodeastoredisplay.setSortid(rs.getInt("sortid"));//排序id
		dbodeastoredisplay.setTitle(rs.getString("title"));//描述
		dbodeastoredisplay.setPath(rs.getString("path"));//图片路径
		dbodeastoredisplay.setIsdelete(rs.getInt("isdelete"));//删除标识
		dbodeastoredisplay.setEid(rs.getInt("eid"));//
		dbodeastoredisplay.setLink(rs.getString("link"));//
	}

	public static List<DboDeaStoredisplay> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_storedisplay";
		List<DboDeaStoredisplay> list = new ArrayList<DboDeaStoredisplay>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaStoredisplay dbodeastoredisplay = new DboDeaStoredisplay();
				fill(rs, dbodeastoredisplay);
				list.add(dbodeastoredisplay);
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


	public static List<DboDeaStoredisplay> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_storedisplay where "+subsql+"";
		List<DboDeaStoredisplay> list = new ArrayList<DboDeaStoredisplay>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaStoredisplay dbodeastoredisplay = new DboDeaStoredisplay();
				fill(rs, dbodeastoredisplay);
				list.add(dbodeastoredisplay);
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
		String sql = "select count(*) from dbo_dea_storedisplay where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_storedisplay where "+subsql+"";
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
		String sql = "delete from dbo_dea_storedisplay where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaStoredisplay dbodeastoredisplay) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_storedisplay(`picid`,`sortid`,`title`,`path`,`isdelete`,`eid`,`link`) values(?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeastoredisplay.getPicid());
		dbc.setInt(2, dbodeastoredisplay.getSortid());
		dbc.setString(3, dbodeastoredisplay.getTitle());
		dbc.setString(4, dbodeastoredisplay.getPath());
		dbc.setInt(5, dbodeastoredisplay.getIsdelete());
		dbc.setInt(6, dbodeastoredisplay.getEid());
		dbc.setString(7, dbodeastoredisplay.getLink());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaStoredisplay dbodeastoredisplay) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_storedisplay(`picid`,`sortid`,`title`,`path`,`isdelete`,`eid`,`link`) values(?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeastoredisplay.getPicid());
		dbc.setInt(2, dbodeastoredisplay.getSortid());
		dbc.setString(3, dbodeastoredisplay.getTitle());
		dbc.setString(4, dbodeastoredisplay.getPath());
		dbc.setInt(5, dbodeastoredisplay.getIsdelete());
		dbc.setInt(6, dbodeastoredisplay.getEid());
		dbc.setString(7, dbodeastoredisplay.getLink());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaStoredisplay dbodeastoredisplay) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_storedisplay set ");
		boolean flag = false;
		if(dbodeastoredisplay.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",picid=?");
			}else{
				sb.append("picid=?");
				flag=true;
			}
		}
		if(dbodeastoredisplay.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",sortid=?");
			}else{
				sb.append("sortid=?");
				flag=true;
			}
		}
		if(dbodeastoredisplay.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",title=?");
			}else{
				sb.append("title=?");
				flag=true;
			}
		}
		if(dbodeastoredisplay.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",path=?");
			}else{
				sb.append("path=?");
				flag=true;
			}
		}
		if(dbodeastoredisplay.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dbodeastoredisplay.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",eid=?");
			}else{
				sb.append("eid=?");
				flag=true;
			}
		}
		if(dbodeastoredisplay.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",link=?");
			}else{
				sb.append("link=?");
				flag=true;
			}
		}
		sb.append(" where picid=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeastoredisplay.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeastoredisplay.getPicid());k++;
		}
		if(dbodeastoredisplay.COLUMN_FLAG[1]){
			dbc.setInt(k, dbodeastoredisplay.getSortid());k++;
		}
		if(dbodeastoredisplay.COLUMN_FLAG[2]){
			dbc.setString(k, dbodeastoredisplay.getTitle());k++;
		}
		if(dbodeastoredisplay.COLUMN_FLAG[3]){
			dbc.setString(k, dbodeastoredisplay.getPath());k++;
		}
		if(dbodeastoredisplay.COLUMN_FLAG[4]){
			dbc.setInt(k, dbodeastoredisplay.getIsdelete());k++;
		}
		if(dbodeastoredisplay.COLUMN_FLAG[5]){
			dbc.setInt(k, dbodeastoredisplay.getEid());k++;
		}
		if(dbodeastoredisplay.COLUMN_FLAG[6]){
			dbc.setString(k, dbodeastoredisplay.getLink());k++;
		}
		dbc.setInt(k, dbodeastoredisplay.getPicid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaStoredisplay dbodeastoredisplay) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeastoredisplay);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static int DboDeaStoredisplayUpdateBypicid3(int isdelete,int picid){
	int result=EXECUTE_FAIL;
	DBConnect dbc = null;
	String sql = "update dbo_dea_storedisplay set isdelete = ?  where picid = ?";

	try {
		dbc = new DBConnect(sql);
		dbc.setInt(1, isdelete);
		dbc.setInt(2, picid);
		dbc.executeUpdate();
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

	public static int DboDeaStoredisplayUpdateBypicid3(DBConnect dbc,int isdelete,int picid){
	int result=EXECUTE_FAIL;
	String sql = "update dbo_dea_storedisplay set isdelete = ?  where picid = ?";

	try {
		dbc.prepareStatement(sql);
		dbc.setInt(1, isdelete);
		dbc.setInt(2, picid);
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
	}
	public static int DboDeaStoredisplayUpdateByeid(String title,String link,int eid){
	int result=EXECUTE_FAIL;
	DBConnect dbc = null;
	String sql = "update dbo_dea_storedisplay set title = ?,link = ? where eid = ?";

	try {
		dbc = new DBConnect(sql);
		dbc.setString(1, title);
		dbc.setString(2, link);
		dbc.setInt(3, eid);
		dbc.executeUpdate();
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

	public static int DboDeaStoredisplayUpdateByeid(DBConnect dbc,String title,String link,int eid){
	int result=EXECUTE_FAIL;
	String sql = "update dbo_dea_storedisplay set title = ?,link = ? where eid = ?";

	try {
		dbc.prepareStatement(sql);
		dbc.setString(1, title);
		dbc.setString(2, link);
		dbc.setInt(3, eid);
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
	}
	public static int DboDeaStoredisplayUpdateBypicid(String title,String link,int picid){
	int result=EXECUTE_FAIL;
	DBConnect dbc = null;
	String sql = "update dbo_dea_storedisplay set title = ?,link = ? where picid = ?";

	try {
		dbc = new DBConnect(sql);
		dbc.setString(1, title);
		dbc.setString(2, link);
		dbc.setInt(3, picid);
		dbc.executeUpdate();
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

	public static int DboDeaStoredisplayUpdateBypicid(DBConnect dbc,String title,String link,int picid){
	int result=EXECUTE_FAIL;
	String sql = "update dbo_dea_storedisplay set title = ?,link = ? where picid = ?";

	try {
		dbc.prepareStatement(sql);
		dbc.setString(1, title);
		dbc.setString(2, link);
		dbc.setInt(3, picid);
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
	}

	public static List<DboDeaStoredisplay> DboDeaStoredisplaySelectAllColumnByeid2(int eid){
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_storedisplay where eid = ? and isdelete = 0 order by sortid";
		List<DboDeaStoredisplay> list = new ArrayList<DboDeaStoredisplay>();
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, eid);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaStoredisplay obj = new DboDeaStoredisplay();
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
	public static int DboDeaStoredisplayUpdateBypicid2(int sortid,int picid){
	int result=EXECUTE_FAIL;
	DBConnect dbc = null;
	String sql = "update dbo_dea_storedisplay set sortid = ? where picid = ?";

	try {
		dbc = new DBConnect(sql);
		dbc.setInt(1, sortid);
		dbc.setInt(2, picid);
		dbc.executeUpdate();
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

	public static int DboDeaStoredisplayUpdateBypicid2(DBConnect dbc,int sortid,int picid){
	int result=EXECUTE_FAIL;
	String sql = "update dbo_dea_storedisplay set sortid = ? where picid = ?";

	try {
		dbc.prepareStatement(sql);
		dbc.setInt(1, sortid);
		dbc.setInt(2, picid);
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
	}

	public static List<DboDeaStoredisplay> DboDeaStoredisplaySelectAllColumnByeid(int eid){
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_storedisplay where eid = ?";
		List<DboDeaStoredisplay> list = new ArrayList<DboDeaStoredisplay>();
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, eid);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaStoredisplay obj = new DboDeaStoredisplay();
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

	public static int DboDeaStoredisplayCountByeid(int eid){
		DBConnect dbc = null;
		String sql = "select count(*) from dbo_dea_storedisplay where eid = ?";
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, eid);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}