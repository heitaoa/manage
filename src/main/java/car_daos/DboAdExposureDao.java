package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboAdExposure;

public class  DboAdExposureDao  extends BaseDao {

	public static void fill(ResultSet rs, DboAdExposure dboadexposure) throws SQLException {
		dboadexposure.setId(rs.getInt("id"));//曝光id
		dboadexposure.setUrl(rs.getString("url"));//广告曝光链接
		dboadexposure.setSdate(rs.getTimestamp("sdate"));//曝光开始时间
		dboadexposure.setEdate(rs.getTimestamp("edate"));//
		dboadexposure.setCount(rs.getInt("count"));//生成iframe个数
		dboadexposure.setIsdelete(rs.getInt("isdelete"));//状态，0表示未删除，1表示删除
		dboadexposure.setTitle(rs.getString("title"));//
	}

	public static List<DboAdExposure> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_ad_exposure";
		List<DboAdExposure> list = new ArrayList<DboAdExposure>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboAdExposure dboadexposure = new DboAdExposure();
				fill(rs, dboadexposure);
				list.add(dboadexposure);
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


	public static List<DboAdExposure> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_ad_exposure where "+subsql+"";
		List<DboAdExposure> list = new ArrayList<DboAdExposure>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboAdExposure dboadexposure = new DboAdExposure();
				fill(rs, dboadexposure);
				list.add(dboadexposure);
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
		String sql = "select count(*) from dbo_ad_exposure where "+subsql+"";
		
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
		String sql = "delete from dbo_ad_exposure where "+subsql+"";
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
		String sql = "delete from dbo_ad_exposure where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboAdExposure dboadexposure) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_ad_exposure(`id`,`url`,`sdate`,`edate`,`count`,`isdelete`,`title`) values(?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboadexposure.getId());
		dbc.setString(2, dboadexposure.getUrl());
		dbc.setTimestamp(3, new Timestamp(dboadexposure.getSdate().getTime()));
		dbc.setTimestamp(4, new Timestamp(dboadexposure.getEdate().getTime()));
		dbc.setInt(5, dboadexposure.getCount());
		dbc.setInt(6, dboadexposure.getIsdelete());
		dbc.setString(7, dboadexposure.getTitle());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboAdExposure dboadexposure) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_ad_exposure(`id`,`url`,`sdate`,`edate`,`count`,`isdelete`,`title`) values(?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboadexposure.getId());
		dbc.setString(2, dboadexposure.getUrl());
		dbc.setTimestamp(3, new Timestamp(dboadexposure.getSdate().getTime()));
		dbc.setTimestamp(4, new Timestamp(dboadexposure.getEdate().getTime()));
		dbc.setInt(5, dboadexposure.getCount());
		dbc.setInt(6, dboadexposure.getIsdelete());
		dbc.setString(7, dboadexposure.getTitle());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboAdExposure dboadexposure) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_ad_exposure set ");
		boolean flag = false;
		if(dboadexposure.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dboadexposure.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",url=?");
			}else{
				sb.append("url=?");
				flag=true;
			}
		}
		if(dboadexposure.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",sdate=?");
			}else{
				sb.append("sdate=?");
				flag=true;
			}
		}
		if(dboadexposure.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",edate=?");
			}else{
				sb.append("edate=?");
				flag=true;
			}
		}
		if(dboadexposure.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",count=?");
			}else{
				sb.append("count=?");
				flag=true;
			}
		}
		if(dboadexposure.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dboadexposure.COLUMN_FLAG[6]){
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
		if(dboadexposure.COLUMN_FLAG[0]){
			dbc.setInt(k, dboadexposure.getId());k++;
		}
		if(dboadexposure.COLUMN_FLAG[1]){
			dbc.setString(k, dboadexposure.getUrl());k++;
		}
		if(dboadexposure.COLUMN_FLAG[2]){
			dbc.setTimestamp(k, new Timestamp(dboadexposure.getSdate().getTime()));k++;
		}
		if(dboadexposure.COLUMN_FLAG[3]){
			dbc.setTimestamp(k, new Timestamp(dboadexposure.getEdate().getTime()));k++;
		}
		if(dboadexposure.COLUMN_FLAG[4]){
			dbc.setInt(k, dboadexposure.getCount());k++;
		}
		if(dboadexposure.COLUMN_FLAG[5]){
			dbc.setInt(k, dboadexposure.getIsdelete());k++;
		}
		if(dboadexposure.COLUMN_FLAG[6]){
			dbc.setString(k, dboadexposure.getTitle());k++;
		}
		dbc.setInt(k, dboadexposure.getId());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboAdExposure dboadexposure) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dboadexposure);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}