package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaSccommodity;

public class  DboDeaSccommodityDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaSccommodity dbodeasccommodity) throws SQLException {
		dbodeasccommodity.setId(rs.getInt("id"));//
		dbodeasccommodity.setTitle(rs.getString("title"));//
		dbodeasccommodity.setModel(rs.getString("model"));//型号
		dbodeasccommodity.setPrice(rs.getDouble("price"));//
		dbodeasccommodity.setType(rs.getInt("type"));//0：附件；1：配件
		dbodeasccommodity.setCartype(rs.getString("cartype"));//
		dbodeasccommodity.setIsinstallation(rs.getInt("isinstallation"));//是否提供安装
		dbodeasccommodity.setDiscount(rs.getDouble("discount"));//折扣
		dbodeasccommodity.setStarttime(rs.getTimestamp("starttime"));//
		dbodeasccommodity.setDiscription(rs.getString("discription"));//
		dbodeasccommodity.setAdddate(rs.getTimestamp("adddate"));//
		dbodeasccommodity.setEid(rs.getInt("eid"));//
		dbodeasccommodity.setEndtime(rs.getTimestamp("endtime"));//
	}

	public static List<DboDeaSccommodity> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_sccommodity";
		List<DboDeaSccommodity> list = new ArrayList<DboDeaSccommodity>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaSccommodity dbodeasccommodity = new DboDeaSccommodity();
				fill(rs, dbodeasccommodity);
				list.add(dbodeasccommodity);
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


	public static List<DboDeaSccommodity> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_sccommodity where "+subsql+"";
		List<DboDeaSccommodity> list = new ArrayList<DboDeaSccommodity>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaSccommodity dbodeasccommodity = new DboDeaSccommodity();
				fill(rs, dbodeasccommodity);
				list.add(dbodeasccommodity);
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
		String sql = "select count(*) from dbo_dea_sccommodity where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_sccommodity where "+subsql+"";
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
		String sql = "delete from dbo_dea_sccommodity where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaSccommodity dbodeasccommodity) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_sccommodity(`id`,`title`,`model`,`price`,`type`,`cartype`,`isinstallation`,`discount`,`starttime`,`discription`,`adddate`,`eid`,`endtime`) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeasccommodity.getId());
		dbc.setString(2, dbodeasccommodity.getTitle());
		dbc.setString(3, dbodeasccommodity.getModel());
		dbc.setDouble(4, dbodeasccommodity.getPrice());
		dbc.setInt(5, dbodeasccommodity.getType());
		dbc.setString(6, dbodeasccommodity.getCartype());
		dbc.setInt(7, dbodeasccommodity.getIsinstallation());
		dbc.setDouble(8, dbodeasccommodity.getDiscount());
		dbc.setTimestamp(9, new Timestamp(dbodeasccommodity.getStarttime().getTime()));
		dbc.setString(10, dbodeasccommodity.getDiscription());
		dbc.setTimestamp(11, new Timestamp(dbodeasccommodity.getAdddate().getTime()));
		dbc.setInt(12, dbodeasccommodity.getEid());
		dbc.setTimestamp(13, new Timestamp(dbodeasccommodity.getEndtime().getTime()));
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaSccommodity dbodeasccommodity) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_sccommodity(`id`,`title`,`model`,`price`,`type`,`cartype`,`isinstallation`,`discount`,`starttime`,`discription`,`adddate`,`eid`,`endtime`) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeasccommodity.getId());
		dbc.setString(2, dbodeasccommodity.getTitle());
		dbc.setString(3, dbodeasccommodity.getModel());
		dbc.setDouble(4, dbodeasccommodity.getPrice());
		dbc.setInt(5, dbodeasccommodity.getType());
		dbc.setString(6, dbodeasccommodity.getCartype());
		dbc.setInt(7, dbodeasccommodity.getIsinstallation());
		dbc.setDouble(8, dbodeasccommodity.getDiscount());
		dbc.setTimestamp(9, new Timestamp(dbodeasccommodity.getStarttime().getTime()));
		dbc.setString(10, dbodeasccommodity.getDiscription());
		dbc.setTimestamp(11, new Timestamp(dbodeasccommodity.getAdddate().getTime()));
		dbc.setInt(12, dbodeasccommodity.getEid());
		dbc.setTimestamp(13, new Timestamp(dbodeasccommodity.getEndtime().getTime()));
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaSccommodity dbodeasccommodity) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_sccommodity set ");
		boolean flag = false;
		if(dbodeasccommodity.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodeasccommodity.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",title=?");
			}else{
				sb.append("title=?");
				flag=true;
			}
		}
		if(dbodeasccommodity.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",model=?");
			}else{
				sb.append("model=?");
				flag=true;
			}
		}
		if(dbodeasccommodity.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",price=?");
			}else{
				sb.append("price=?");
				flag=true;
			}
		}
		if(dbodeasccommodity.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",type=?");
			}else{
				sb.append("type=?");
				flag=true;
			}
		}
		if(dbodeasccommodity.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",cartype=?");
			}else{
				sb.append("cartype=?");
				flag=true;
			}
		}
		if(dbodeasccommodity.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",isinstallation=?");
			}else{
				sb.append("isinstallation=?");
				flag=true;
			}
		}
		if(dbodeasccommodity.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",discount=?");
			}else{
				sb.append("discount=?");
				flag=true;
			}
		}
		if(dbodeasccommodity.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",starttime=?");
			}else{
				sb.append("starttime=?");
				flag=true;
			}
		}
		if(dbodeasccommodity.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",discription=?");
			}else{
				sb.append("discription=?");
				flag=true;
			}
		}
		if(dbodeasccommodity.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbodeasccommodity.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",eid=?");
			}else{
				sb.append("eid=?");
				flag=true;
			}
		}
		if(dbodeasccommodity.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",endtime=?");
			}else{
				sb.append("endtime=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeasccommodity.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeasccommodity.getId());k++;
		}
		if(dbodeasccommodity.COLUMN_FLAG[1]){
			dbc.setString(k, dbodeasccommodity.getTitle());k++;
		}
		if(dbodeasccommodity.COLUMN_FLAG[2]){
			dbc.setString(k, dbodeasccommodity.getModel());k++;
		}
		if(dbodeasccommodity.COLUMN_FLAG[3]){
			dbc.setDouble(k, dbodeasccommodity.getPrice());k++;
		}
		if(dbodeasccommodity.COLUMN_FLAG[4]){
			dbc.setInt(k, dbodeasccommodity.getType());k++;
		}
		if(dbodeasccommodity.COLUMN_FLAG[5]){
			dbc.setString(k, dbodeasccommodity.getCartype());k++;
		}
		if(dbodeasccommodity.COLUMN_FLAG[6]){
			dbc.setInt(k, dbodeasccommodity.getIsinstallation());k++;
		}
		if(dbodeasccommodity.COLUMN_FLAG[7]){
			dbc.setDouble(k, dbodeasccommodity.getDiscount());k++;
		}
		if(dbodeasccommodity.COLUMN_FLAG[8]){
			dbc.setTimestamp(k, new Timestamp(dbodeasccommodity.getStarttime().getTime()));k++;
		}
		if(dbodeasccommodity.COLUMN_FLAG[9]){
			dbc.setString(k, dbodeasccommodity.getDiscription());k++;
		}
		if(dbodeasccommodity.COLUMN_FLAG[10]){
			dbc.setTimestamp(k, new Timestamp(dbodeasccommodity.getAdddate().getTime()));k++;
		}
		if(dbodeasccommodity.COLUMN_FLAG[11]){
			dbc.setInt(k, dbodeasccommodity.getEid());k++;
		}
		if(dbodeasccommodity.COLUMN_FLAG[12]){
			dbc.setTimestamp(k, new Timestamp(dbodeasccommodity.getEndtime().getTime()));k++;
		}
		dbc.setInt(k, dbodeasccommodity.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaSccommodity dbodeasccommodity) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeasccommodity);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}