package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboPubAdinfo;

public class  DboPubAdinfoDao  extends BaseDao {

	public static void fill(ResultSet rs, DboPubAdinfo dbopubadinfo) throws SQLException {
		dbopubadinfo.setAdinfoid(rs.getInt("adinfoid"));//广告元素id
		dbopubadinfo.setAdid(rs.getInt("adid"));//广告位id
		dbopubadinfo.setAdimg(rs.getString("adimg"));//广告图片
		dbopubadinfo.setAdexposure(rs.getLong("adexposure"));//广告曝光
		dbopubadinfo.setAdclick(rs.getLong("adclick"));//广告点击
		dbopubadinfo.setAdurl(rs.getString("adurl"));//广告链接地址
		dbopubadinfo.setIsdelete(rs.getInt("isdelete"));//是否删除“0”：未删除，“1”：删除
		dbopubadinfo.setIsshow(rs.getInt("isshow"));//是否显示，“0”：显示，“1”：不显示
		dbopubadinfo.setIsdefault(rs.getInt("isdefault"));//是否是默认广告“0”：是，“1”：否
		dbopubadinfo.setAdftl(rs.getString("adftl"));//广告位模板
	}

	public static List<DboPubAdinfo> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_pub_adinfo";
		List<DboPubAdinfo> list = new ArrayList<DboPubAdinfo>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboPubAdinfo dbopubadinfo = new DboPubAdinfo();
				fill(rs, dbopubadinfo);
				list.add(dbopubadinfo);
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


	public static List<DboPubAdinfo> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_pub_adinfo where "+subsql+"";
		List<DboPubAdinfo> list = new ArrayList<DboPubAdinfo>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboPubAdinfo dbopubadinfo = new DboPubAdinfo();
				fill(rs, dbopubadinfo);
				list.add(dbopubadinfo);
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
		String sql = "select count(*) from dbo_pub_adinfo where "+subsql+"";
		
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
		String sql = "delete from dbo_pub_adinfo where "+subsql+"";
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
		String sql = "delete from dbo_pub_adinfo where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboPubAdinfo dbopubadinfo) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_pub_adinfo(`adinfoid`,`adid`,`adimg`,`adexposure`,`adclick`,`adurl`,`isdelete`,`isshow`,`isdefault`,`adftl`) values(?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbopubadinfo.getAdinfoid());
		dbc.setInt(2, dbopubadinfo.getAdid());
		dbc.setString(3, dbopubadinfo.getAdimg());
		dbc.setLong(4, dbopubadinfo.getAdexposure());
		dbc.setLong(5, dbopubadinfo.getAdclick());
		dbc.setString(6, dbopubadinfo.getAdurl());
		dbc.setInt(7, dbopubadinfo.getIsdelete());
		dbc.setInt(8, dbopubadinfo.getIsshow());
		dbc.setInt(9, dbopubadinfo.getIsdefault());
		dbc.setString(10, dbopubadinfo.getAdftl());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboPubAdinfo dbopubadinfo) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_pub_adinfo(`adinfoid`,`adid`,`adimg`,`adexposure`,`adclick`,`adurl`,`isdelete`,`isshow`,`isdefault`,`adftl`) values(?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbopubadinfo.getAdinfoid());
		dbc.setInt(2, dbopubadinfo.getAdid());
		dbc.setString(3, dbopubadinfo.getAdimg());
		dbc.setLong(4, dbopubadinfo.getAdexposure());
		dbc.setLong(5, dbopubadinfo.getAdclick());
		dbc.setString(6, dbopubadinfo.getAdurl());
		dbc.setInt(7, dbopubadinfo.getIsdelete());
		dbc.setInt(8, dbopubadinfo.getIsshow());
		dbc.setInt(9, dbopubadinfo.getIsdefault());
		dbc.setString(10, dbopubadinfo.getAdftl());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboPubAdinfo dbopubadinfo) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_pub_adinfo set ");
		boolean flag = false;
		if(dbopubadinfo.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",adinfoid=?");
			}else{
				sb.append("adinfoid=?");
				flag=true;
			}
		}
		if(dbopubadinfo.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",adid=?");
			}else{
				sb.append("adid=?");
				flag=true;
			}
		}
		if(dbopubadinfo.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",adimg=?");
			}else{
				sb.append("adimg=?");
				flag=true;
			}
		}
		if(dbopubadinfo.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",adexposure=?");
			}else{
				sb.append("adexposure=?");
				flag=true;
			}
		}
		if(dbopubadinfo.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",adclick=?");
			}else{
				sb.append("adclick=?");
				flag=true;
			}
		}
		if(dbopubadinfo.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",adurl=?");
			}else{
				sb.append("adurl=?");
				flag=true;
			}
		}
		if(dbopubadinfo.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dbopubadinfo.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",isshow=?");
			}else{
				sb.append("isshow=?");
				flag=true;
			}
		}
		if(dbopubadinfo.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",isdefault=?");
			}else{
				sb.append("isdefault=?");
				flag=true;
			}
		}
		if(dbopubadinfo.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",adftl=?");
			}else{
				sb.append("adftl=?");
				flag=true;
			}
		}
		sb.append(" where adinfoid=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbopubadinfo.COLUMN_FLAG[0]){
			dbc.setInt(k, dbopubadinfo.getAdinfoid());k++;
		}
		if(dbopubadinfo.COLUMN_FLAG[1]){
			dbc.setInt(k, dbopubadinfo.getAdid());k++;
		}
		if(dbopubadinfo.COLUMN_FLAG[2]){
			dbc.setString(k, dbopubadinfo.getAdimg());k++;
		}
		if(dbopubadinfo.COLUMN_FLAG[3]){
			dbc.setLong(k, dbopubadinfo.getAdexposure());k++;
		}
		if(dbopubadinfo.COLUMN_FLAG[4]){
			dbc.setLong(k, dbopubadinfo.getAdclick());k++;
		}
		if(dbopubadinfo.COLUMN_FLAG[5]){
			dbc.setString(k, dbopubadinfo.getAdurl());k++;
		}
		if(dbopubadinfo.COLUMN_FLAG[6]){
			dbc.setInt(k, dbopubadinfo.getIsdelete());k++;
		}
		if(dbopubadinfo.COLUMN_FLAG[7]){
			dbc.setInt(k, dbopubadinfo.getIsshow());k++;
		}
		if(dbopubadinfo.COLUMN_FLAG[8]){
			dbc.setInt(k, dbopubadinfo.getIsdefault());k++;
		}
		if(dbopubadinfo.COLUMN_FLAG[9]){
			dbc.setString(k, dbopubadinfo.getAdftl());k++;
		}
		dbc.setInt(k, dbopubadinfo.getAdinfoid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboPubAdinfo dbopubadinfo) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbopubadinfo);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}