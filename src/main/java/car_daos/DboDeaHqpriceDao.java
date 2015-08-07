package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaHqprice;

public class  DboDeaHqpriceDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaHqprice dbodeahqprice) throws SQLException {
		dbodeahqprice.setId(rs.getInt("id"));//
		dbodeahqprice.setHqid(rs.getInt("hqid"));//关联dbo_dea_hqnews的id
		dbodeahqprice.setCarid(rs.getInt("carid"));//车型
		dbodeahqprice.setAdddate(rs.getTimestamp("adddate"));//
		dbodeahqprice.setIsdelete(rs.getInt("isdelete"));//
		dbodeahqprice.setEid(rs.getInt("eid"));//
		dbodeahqprice.setFacprice(rs.getDouble("facprice"));//官方价
		dbodeahqprice.setPrice(rs.getDouble("price"));//最终价格
		dbodeahqprice.setLowprice(rs.getDouble("lowprice"));//优惠幅度
	}

	public static List<DboDeaHqprice> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_hqprice";
		List<DboDeaHqprice> list = new ArrayList<DboDeaHqprice>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaHqprice dbodeahqprice = new DboDeaHqprice();
				fill(rs, dbodeahqprice);
				list.add(dbodeahqprice);
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


	public static List<DboDeaHqprice> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_hqprice where "+subsql+"";
		List<DboDeaHqprice> list = new ArrayList<DboDeaHqprice>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaHqprice dbodeahqprice = new DboDeaHqprice();
				fill(rs, dbodeahqprice);
				list.add(dbodeahqprice);
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
		String sql = "select count(*) from dbo_dea_hqprice where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_hqprice where "+subsql+"";
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
		String sql = "delete from dbo_dea_hqprice where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaHqprice dbodeahqprice) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_hqprice(`id`,`hqid`,`carid`,`adddate`,`isdelete`,`eid`,`facprice`,`price`,`lowprice`) values(?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeahqprice.getId());
		dbc.setInt(2, dbodeahqprice.getHqid());
		dbc.setInt(3, dbodeahqprice.getCarid());
		dbc.setTimestamp(4, new Timestamp(dbodeahqprice.getAdddate().getTime()));
		dbc.setInt(5, dbodeahqprice.getIsdelete());
		dbc.setInt(6, dbodeahqprice.getEid());
		dbc.setDouble(7, dbodeahqprice.getFacprice());
		dbc.setDouble(8, dbodeahqprice.getPrice());
		dbc.setDouble(9, dbodeahqprice.getLowprice());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaHqprice dbodeahqprice) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_hqprice(`id`,`hqid`,`carid`,`adddate`,`isdelete`,`eid`,`facprice`,`price`,`lowprice`) values(?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeahqprice.getId());
		dbc.setInt(2, dbodeahqprice.getHqid());
		dbc.setInt(3, dbodeahqprice.getCarid());
		dbc.setTimestamp(4, new Timestamp(dbodeahqprice.getAdddate().getTime()));
		dbc.setInt(5, dbodeahqprice.getIsdelete());
		dbc.setInt(6, dbodeahqprice.getEid());
		dbc.setDouble(7, dbodeahqprice.getFacprice());
		dbc.setDouble(8, dbodeahqprice.getPrice());
		dbc.setDouble(9, dbodeahqprice.getLowprice());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaHqprice dbodeahqprice) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_hqprice set ");
		boolean flag = false;
		if(dbodeahqprice.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodeahqprice.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",hqid=?");
			}else{
				sb.append("hqid=?");
				flag=true;
			}
		}
		if(dbodeahqprice.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",carid=?");
			}else{
				sb.append("carid=?");
				flag=true;
			}
		}
		if(dbodeahqprice.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbodeahqprice.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dbodeahqprice.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",eid=?");
			}else{
				sb.append("eid=?");
				flag=true;
			}
		}
		if(dbodeahqprice.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",facprice=?");
			}else{
				sb.append("facprice=?");
				flag=true;
			}
		}
		if(dbodeahqprice.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",price=?");
			}else{
				sb.append("price=?");
				flag=true;
			}
		}
		if(dbodeahqprice.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",lowprice=?");
			}else{
				sb.append("lowprice=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeahqprice.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeahqprice.getId());k++;
		}
		if(dbodeahqprice.COLUMN_FLAG[1]){
			dbc.setInt(k, dbodeahqprice.getHqid());k++;
		}
		if(dbodeahqprice.COLUMN_FLAG[2]){
			dbc.setInt(k, dbodeahqprice.getCarid());k++;
		}
		if(dbodeahqprice.COLUMN_FLAG[3]){
			dbc.setTimestamp(k, new Timestamp(dbodeahqprice.getAdddate().getTime()));k++;
		}
		if(dbodeahqprice.COLUMN_FLAG[4]){
			dbc.setInt(k, dbodeahqprice.getIsdelete());k++;
		}
		if(dbodeahqprice.COLUMN_FLAG[5]){
			dbc.setInt(k, dbodeahqprice.getEid());k++;
		}
		if(dbodeahqprice.COLUMN_FLAG[6]){
			dbc.setDouble(k, dbodeahqprice.getFacprice());k++;
		}
		if(dbodeahqprice.COLUMN_FLAG[7]){
			dbc.setDouble(k, dbodeahqprice.getPrice());k++;
		}
		if(dbodeahqprice.COLUMN_FLAG[8]){
			dbc.setDouble(k, dbodeahqprice.getLowprice());k++;
		}
		dbc.setInt(k, dbodeahqprice.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaHqprice dbodeahqprice) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeahqprice);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}