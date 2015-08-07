package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaScoressort;

public class  DboDeaScoressortDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaScoressort dbodeascoressort) throws SQLException {
		dbodeascoressort.setId(rs.getInt("id"));//
		dbodeascoressort.setEid(rs.getInt("eid"));//
		dbodeascoressort.setScores(rs.getInt("scores"));//活跃度值
		dbodeascoressort.setDatestr(rs.getString("datestr"));//
		dbodeascoressort.setSdate(rs.getTimestamp("sdate"));//
		dbodeascoressort.setEdate(rs.getTimestamp("edate"));//
		dbodeascoressort.setBrandsort(rs.getInt("brandsort"));//同品牌排名
		dbodeascoressort.setAreasort(rs.getInt("areasort"));//同地区排名
		dbodeascoressort.setBrandandareasort(rs.getInt("brandandareasort"));//本地区同品牌排名
		dbodeascoressort.setSortid(rs.getInt("sortid"));//
	}

	public static List<DboDeaScoressort> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_scoressort";
		List<DboDeaScoressort> list = new ArrayList<DboDeaScoressort>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaScoressort dbodeascoressort = new DboDeaScoressort();
				fill(rs, dbodeascoressort);
				list.add(dbodeascoressort);
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


	public static List<DboDeaScoressort> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_scoressort where "+subsql+"";
		List<DboDeaScoressort> list = new ArrayList<DboDeaScoressort>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaScoressort dbodeascoressort = new DboDeaScoressort();
				fill(rs, dbodeascoressort);
				list.add(dbodeascoressort);
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
		String sql = "select count(*) from dbo_dea_scoressort where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_scoressort where "+subsql+"";
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
		String sql = "delete from dbo_dea_scoressort where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaScoressort dbodeascoressort) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_scoressort(`id`,`eid`,`scores`,`datestr`,`sdate`,`edate`,`brandsort`,`areasort`,`brandandareasort`,`sortid`) values(?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeascoressort.getId());
		dbc.setInt(2, dbodeascoressort.getEid());
		dbc.setInt(3, dbodeascoressort.getScores());
		dbc.setString(4, dbodeascoressort.getDatestr());
		dbc.setTimestamp(5, new Timestamp(dbodeascoressort.getSdate().getTime()));
		dbc.setTimestamp(6, new Timestamp(dbodeascoressort.getEdate().getTime()));
		dbc.setInt(7, dbodeascoressort.getBrandsort());
		dbc.setInt(8, dbodeascoressort.getAreasort());
		dbc.setInt(9, dbodeascoressort.getBrandandareasort());
		dbc.setInt(10, dbodeascoressort.getSortid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaScoressort dbodeascoressort) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_scoressort(`id`,`eid`,`scores`,`datestr`,`sdate`,`edate`,`brandsort`,`areasort`,`brandandareasort`,`sortid`) values(?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeascoressort.getId());
		dbc.setInt(2, dbodeascoressort.getEid());
		dbc.setInt(3, dbodeascoressort.getScores());
		dbc.setString(4, dbodeascoressort.getDatestr());
		dbc.setTimestamp(5, new Timestamp(dbodeascoressort.getSdate().getTime()));
		dbc.setTimestamp(6, new Timestamp(dbodeascoressort.getEdate().getTime()));
		dbc.setInt(7, dbodeascoressort.getBrandsort());
		dbc.setInt(8, dbodeascoressort.getAreasort());
		dbc.setInt(9, dbodeascoressort.getBrandandareasort());
		dbc.setInt(10, dbodeascoressort.getSortid());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaScoressort dbodeascoressort) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_scoressort set ");
		boolean flag = false;
		if(dbodeascoressort.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodeascoressort.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",eid=?");
			}else{
				sb.append("eid=?");
				flag=true;
			}
		}
		if(dbodeascoressort.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",scores=?");
			}else{
				sb.append("scores=?");
				flag=true;
			}
		}
		if(dbodeascoressort.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",datestr=?");
			}else{
				sb.append("datestr=?");
				flag=true;
			}
		}
		if(dbodeascoressort.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",sdate=?");
			}else{
				sb.append("sdate=?");
				flag=true;
			}
		}
		if(dbodeascoressort.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",edate=?");
			}else{
				sb.append("edate=?");
				flag=true;
			}
		}
		if(dbodeascoressort.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",brandsort=?");
			}else{
				sb.append("brandsort=?");
				flag=true;
			}
		}
		if(dbodeascoressort.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",areasort=?");
			}else{
				sb.append("areasort=?");
				flag=true;
			}
		}
		if(dbodeascoressort.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",brandandareasort=?");
			}else{
				sb.append("brandandareasort=?");
				flag=true;
			}
		}
		if(dbodeascoressort.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",sortid=?");
			}else{
				sb.append("sortid=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeascoressort.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeascoressort.getId());k++;
		}
		if(dbodeascoressort.COLUMN_FLAG[1]){
			dbc.setInt(k, dbodeascoressort.getEid());k++;
		}
		if(dbodeascoressort.COLUMN_FLAG[2]){
			dbc.setInt(k, dbodeascoressort.getScores());k++;
		}
		if(dbodeascoressort.COLUMN_FLAG[3]){
			dbc.setString(k, dbodeascoressort.getDatestr());k++;
		}
		if(dbodeascoressort.COLUMN_FLAG[4]){
			dbc.setTimestamp(k, new Timestamp(dbodeascoressort.getSdate().getTime()));k++;
		}
		if(dbodeascoressort.COLUMN_FLAG[5]){
			dbc.setTimestamp(k, new Timestamp(dbodeascoressort.getEdate().getTime()));k++;
		}
		if(dbodeascoressort.COLUMN_FLAG[6]){
			dbc.setInt(k, dbodeascoressort.getBrandsort());k++;
		}
		if(dbodeascoressort.COLUMN_FLAG[7]){
			dbc.setInt(k, dbodeascoressort.getAreasort());k++;
		}
		if(dbodeascoressort.COLUMN_FLAG[8]){
			dbc.setInt(k, dbodeascoressort.getBrandandareasort());k++;
		}
		if(dbodeascoressort.COLUMN_FLAG[9]){
			dbc.setInt(k, dbodeascoressort.getSortid());k++;
		}
		dbc.setInt(k, dbodeascoressort.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaScoressort dbodeascoressort) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeascoressort);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}