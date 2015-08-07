package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboPubAd;

public class  DboPubAdDao  extends BaseDao {

	public static void fill(ResultSet rs, DboPubAd dbopubad) throws SQLException {
		dbopubad.setId(rs.getInt("id"));//广告位id
		dbopubad.setCity(rs.getInt("city"));//城市站
		dbopubad.setHtml(rs.getString("html"));//广告页面
		dbopubad.setAdwidth(rs.getInt("adwidth"));//广告宽度
		dbopubad.setAdheight(rs.getInt("adheight"));//广告高度
		dbopubad.setAdtype(rs.getString("adtype"));//广告位类型
		dbopubad.setAdplace(rs.getInt("adplace"));//
		dbopubad.setAdprice(rs.getDouble("adprice"));//广告位价格
		dbopubad.setPredictexposure(rs.getLong("predictexposure"));//预估曝光
		dbopubad.setPredictclick(rs.getLong("predictclick"));//预估点击
		dbopubad.setPredictcpc(rs.getDouble("predictcpc"));//预估cpc
		dbopubad.setPredictcpl(rs.getDouble("predictcpl"));//预估cpl
	}

	public static List<DboPubAd> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_pub_ad";
		List<DboPubAd> list = new ArrayList<DboPubAd>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboPubAd dbopubad = new DboPubAd();
				fill(rs, dbopubad);
				list.add(dbopubad);
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


	public static List<DboPubAd> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_pub_ad where "+subsql+"";
		List<DboPubAd> list = new ArrayList<DboPubAd>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboPubAd dbopubad = new DboPubAd();
				fill(rs, dbopubad);
				list.add(dbopubad);
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
		String sql = "select count(*) from dbo_pub_ad where "+subsql+"";
		
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
		String sql = "delete from dbo_pub_ad where "+subsql+"";
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
		String sql = "delete from dbo_pub_ad where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboPubAd dbopubad) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_pub_ad(`id`,`city`,`html`,`adwidth`,`adheight`,`adtype`,`adplace`,`adprice`,`predictexposure`,`predictclick`,`predictcpc`,`predictcpl`) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbopubad.getId());
		dbc.setInt(2, dbopubad.getCity());
		dbc.setString(3, dbopubad.getHtml());
		dbc.setInt(4, dbopubad.getAdwidth());
		dbc.setInt(5, dbopubad.getAdheight());
		dbc.setString(6, dbopubad.getAdtype());
		dbc.setInt(7, dbopubad.getAdplace());
		dbc.setDouble(8, dbopubad.getAdprice());
		dbc.setLong(9, dbopubad.getPredictexposure());
		dbc.setLong(10, dbopubad.getPredictclick());
		dbc.setDouble(11, dbopubad.getPredictcpc());
		dbc.setDouble(12, dbopubad.getPredictcpl());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboPubAd dbopubad) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_pub_ad(`id`,`city`,`html`,`adwidth`,`adheight`,`adtype`,`adplace`,`adprice`,`predictexposure`,`predictclick`,`predictcpc`,`predictcpl`) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbopubad.getId());
		dbc.setInt(2, dbopubad.getCity());
		dbc.setString(3, dbopubad.getHtml());
		dbc.setInt(4, dbopubad.getAdwidth());
		dbc.setInt(5, dbopubad.getAdheight());
		dbc.setString(6, dbopubad.getAdtype());
		dbc.setInt(7, dbopubad.getAdplace());
		dbc.setDouble(8, dbopubad.getAdprice());
		dbc.setLong(9, dbopubad.getPredictexposure());
		dbc.setLong(10, dbopubad.getPredictclick());
		dbc.setDouble(11, dbopubad.getPredictcpc());
		dbc.setDouble(12, dbopubad.getPredictcpl());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboPubAd dbopubad) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_pub_ad set ");
		boolean flag = false;
		if(dbopubad.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbopubad.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",city=?");
			}else{
				sb.append("city=?");
				flag=true;
			}
		}
		if(dbopubad.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",html=?");
			}else{
				sb.append("html=?");
				flag=true;
			}
		}
		if(dbopubad.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",adwidth=?");
			}else{
				sb.append("adwidth=?");
				flag=true;
			}
		}
		if(dbopubad.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",adheight=?");
			}else{
				sb.append("adheight=?");
				flag=true;
			}
		}
		if(dbopubad.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",adtype=?");
			}else{
				sb.append("adtype=?");
				flag=true;
			}
		}
		if(dbopubad.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",adplace=?");
			}else{
				sb.append("adplace=?");
				flag=true;
			}
		}
		if(dbopubad.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",adprice=?");
			}else{
				sb.append("adprice=?");
				flag=true;
			}
		}
		if(dbopubad.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",predictexposure=?");
			}else{
				sb.append("predictexposure=?");
				flag=true;
			}
		}
		if(dbopubad.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",predictclick=?");
			}else{
				sb.append("predictclick=?");
				flag=true;
			}
		}
		if(dbopubad.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",predictcpc=?");
			}else{
				sb.append("predictcpc=?");
				flag=true;
			}
		}
		if(dbopubad.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",predictcpl=?");
			}else{
				sb.append("predictcpl=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbopubad.COLUMN_FLAG[0]){
			dbc.setInt(k, dbopubad.getId());k++;
		}
		if(dbopubad.COLUMN_FLAG[1]){
			dbc.setInt(k, dbopubad.getCity());k++;
		}
		if(dbopubad.COLUMN_FLAG[2]){
			dbc.setString(k, dbopubad.getHtml());k++;
		}
		if(dbopubad.COLUMN_FLAG[3]){
			dbc.setInt(k, dbopubad.getAdwidth());k++;
		}
		if(dbopubad.COLUMN_FLAG[4]){
			dbc.setInt(k, dbopubad.getAdheight());k++;
		}
		if(dbopubad.COLUMN_FLAG[5]){
			dbc.setString(k, dbopubad.getAdtype());k++;
		}
		if(dbopubad.COLUMN_FLAG[6]){
			dbc.setInt(k, dbopubad.getAdplace());k++;
		}
		if(dbopubad.COLUMN_FLAG[7]){
			dbc.setDouble(k, dbopubad.getAdprice());k++;
		}
		if(dbopubad.COLUMN_FLAG[8]){
			dbc.setLong(k, dbopubad.getPredictexposure());k++;
		}
		if(dbopubad.COLUMN_FLAG[9]){
			dbc.setLong(k, dbopubad.getPredictclick());k++;
		}
		if(dbopubad.COLUMN_FLAG[10]){
			dbc.setDouble(k, dbopubad.getPredictcpc());k++;
		}
		if(dbopubad.COLUMN_FLAG[11]){
			dbc.setDouble(k, dbopubad.getPredictcpl());k++;
		}
		dbc.setInt(k, dbopubad.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboPubAd dbopubad) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbopubad);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}