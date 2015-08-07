package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaWxershouche;

public class  DboDeaWxershoucheDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaWxershouche dbodeawxershouche) throws SQLException {
		dbodeawxershouche.setId(rs.getInt("id"));//
		dbodeawxershouche.setEid(rs.getInt("eid"));//
		dbodeawxershouche.setModelid(rs.getInt("modelid"));//车系
		dbodeawxershouche.setCarid(rs.getInt("carid"));//车型
		dbodeawxershouche.setWillprice(rs.getString("willprice"));//
		dbodeawxershouche.setLand(rs.getString("land"));//
		dbodeawxershouche.setColor(rs.getInt("color"));//
		dbodeawxershouche.setSptime(rs.getString("sptime"));//
		dbodeawxershouche.setNexttime(rs.getString("nexttime"));//
		dbodeawxershouche.setCzname(rs.getString("czname"));//
		dbodeawxershouche.setCzphone(rs.getString("czphone"));//
		dbodeawxershouche.setCzwant(rs.getString("czwant"));//
		dbodeawxershouche.setAddtime(rs.getTimestamp("addtime"));//
		dbodeawxershouche.setIsdone(rs.getInt("isdone"));//是否已处理
		dbodeawxershouche.setCartype(rs.getString("cartype"));//
	}

	public static List<DboDeaWxershouche> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_wxershouche";
		List<DboDeaWxershouche> list = new ArrayList<DboDeaWxershouche>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaWxershouche dbodeawxershouche = new DboDeaWxershouche();
				fill(rs, dbodeawxershouche);
				list.add(dbodeawxershouche);
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


	public static List<DboDeaWxershouche> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_wxershouche where "+subsql+"";
		List<DboDeaWxershouche> list = new ArrayList<DboDeaWxershouche>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaWxershouche dbodeawxershouche = new DboDeaWxershouche();
				fill(rs, dbodeawxershouche);
				list.add(dbodeawxershouche);
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
		String sql = "select count(*) from dbo_dea_wxershouche where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_wxershouche where "+subsql+"";
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
		String sql = "delete from dbo_dea_wxershouche where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaWxershouche dbodeawxershouche) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_wxershouche(`id`,`eid`,`modelid`,`carid`,`willprice`,`land`,`color`,`sptime`,`nexttime`,`czname`,`czphone`,`czwant`,`addtime`,`isdone`,`cartype`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeawxershouche.getId());
		dbc.setInt(2, dbodeawxershouche.getEid());
		dbc.setInt(3, dbodeawxershouche.getModelid());
		dbc.setInt(4, dbodeawxershouche.getCarid());
		dbc.setString(5, dbodeawxershouche.getWillprice());
		dbc.setString(6, dbodeawxershouche.getLand());
		dbc.setInt(7, dbodeawxershouche.getColor());
		dbc.setString(8, dbodeawxershouche.getSptime());
		dbc.setString(9, dbodeawxershouche.getNexttime());
		dbc.setString(10, dbodeawxershouche.getCzname());
		dbc.setString(11, dbodeawxershouche.getCzphone());
		dbc.setString(12, dbodeawxershouche.getCzwant());
		dbc.setTimestamp(13, new Timestamp(dbodeawxershouche.getAddtime().getTime()));
		dbc.setInt(14, dbodeawxershouche.getIsdone());
		dbc.setString(15, dbodeawxershouche.getCartype());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaWxershouche dbodeawxershouche) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_wxershouche(`id`,`eid`,`modelid`,`carid`,`willprice`,`land`,`color`,`sptime`,`nexttime`,`czname`,`czphone`,`czwant`,`addtime`,`isdone`,`cartype`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeawxershouche.getId());
		dbc.setInt(2, dbodeawxershouche.getEid());
		dbc.setInt(3, dbodeawxershouche.getModelid());
		dbc.setInt(4, dbodeawxershouche.getCarid());
		dbc.setString(5, dbodeawxershouche.getWillprice());
		dbc.setString(6, dbodeawxershouche.getLand());
		dbc.setInt(7, dbodeawxershouche.getColor());
		dbc.setString(8, dbodeawxershouche.getSptime());
		dbc.setString(9, dbodeawxershouche.getNexttime());
		dbc.setString(10, dbodeawxershouche.getCzname());
		dbc.setString(11, dbodeawxershouche.getCzphone());
		dbc.setString(12, dbodeawxershouche.getCzwant());
		dbc.setTimestamp(13, new Timestamp(dbodeawxershouche.getAddtime().getTime()));
		dbc.setInt(14, dbodeawxershouche.getIsdone());
		dbc.setString(15, dbodeawxershouche.getCartype());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaWxershouche dbodeawxershouche) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_wxershouche set ");
		boolean flag = false;
		if(dbodeawxershouche.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodeawxershouche.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",eid=?");
			}else{
				sb.append("eid=?");
				flag=true;
			}
		}
		if(dbodeawxershouche.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",modelid=?");
			}else{
				sb.append("modelid=?");
				flag=true;
			}
		}
		if(dbodeawxershouche.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",carid=?");
			}else{
				sb.append("carid=?");
				flag=true;
			}
		}
		if(dbodeawxershouche.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",willprice=?");
			}else{
				sb.append("willprice=?");
				flag=true;
			}
		}
		if(dbodeawxershouche.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",land=?");
			}else{
				sb.append("land=?");
				flag=true;
			}
		}
		if(dbodeawxershouche.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",color=?");
			}else{
				sb.append("color=?");
				flag=true;
			}
		}
		if(dbodeawxershouche.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",sptime=?");
			}else{
				sb.append("sptime=?");
				flag=true;
			}
		}
		if(dbodeawxershouche.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",nexttime=?");
			}else{
				sb.append("nexttime=?");
				flag=true;
			}
		}
		if(dbodeawxershouche.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",czname=?");
			}else{
				sb.append("czname=?");
				flag=true;
			}
		}
		if(dbodeawxershouche.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",czphone=?");
			}else{
				sb.append("czphone=?");
				flag=true;
			}
		}
		if(dbodeawxershouche.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",czwant=?");
			}else{
				sb.append("czwant=?");
				flag=true;
			}
		}
		if(dbodeawxershouche.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",addtime=?");
			}else{
				sb.append("addtime=?");
				flag=true;
			}
		}
		if(dbodeawxershouche.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",isdone=?");
			}else{
				sb.append("isdone=?");
				flag=true;
			}
		}
		if(dbodeawxershouche.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",cartype=?");
			}else{
				sb.append("cartype=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeawxershouche.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeawxershouche.getId());k++;
		}
		if(dbodeawxershouche.COLUMN_FLAG[1]){
			dbc.setInt(k, dbodeawxershouche.getEid());k++;
		}
		if(dbodeawxershouche.COLUMN_FLAG[2]){
			dbc.setInt(k, dbodeawxershouche.getModelid());k++;
		}
		if(dbodeawxershouche.COLUMN_FLAG[3]){
			dbc.setInt(k, dbodeawxershouche.getCarid());k++;
		}
		if(dbodeawxershouche.COLUMN_FLAG[4]){
			dbc.setString(k, dbodeawxershouche.getWillprice());k++;
		}
		if(dbodeawxershouche.COLUMN_FLAG[5]){
			dbc.setString(k, dbodeawxershouche.getLand());k++;
		}
		if(dbodeawxershouche.COLUMN_FLAG[6]){
			dbc.setInt(k, dbodeawxershouche.getColor());k++;
		}
		if(dbodeawxershouche.COLUMN_FLAG[7]){
			dbc.setString(k, dbodeawxershouche.getSptime());k++;
		}
		if(dbodeawxershouche.COLUMN_FLAG[8]){
			dbc.setString(k, dbodeawxershouche.getNexttime());k++;
		}
		if(dbodeawxershouche.COLUMN_FLAG[9]){
			dbc.setString(k, dbodeawxershouche.getCzname());k++;
		}
		if(dbodeawxershouche.COLUMN_FLAG[10]){
			dbc.setString(k, dbodeawxershouche.getCzphone());k++;
		}
		if(dbodeawxershouche.COLUMN_FLAG[11]){
			dbc.setString(k, dbodeawxershouche.getCzwant());k++;
		}
		if(dbodeawxershouche.COLUMN_FLAG[12]){
			dbc.setTimestamp(k, new Timestamp(dbodeawxershouche.getAddtime().getTime()));k++;
		}
		if(dbodeawxershouche.COLUMN_FLAG[13]){
			dbc.setInt(k, dbodeawxershouche.getIsdone());k++;
		}
		if(dbodeawxershouche.COLUMN_FLAG[14]){
			dbc.setString(k, dbodeawxershouche.getCartype());k++;
		}
		dbc.setInt(k, dbodeawxershouche.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaWxershouche dbodeawxershouche) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeawxershouche);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}