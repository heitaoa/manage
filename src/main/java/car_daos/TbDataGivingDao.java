package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbDataGiving;

public class  TbDataGivingDao  extends BaseDao {

	public static void fill(ResultSet rs, TbDataGiving tbdatagiving) throws SQLException {
		tbdatagiving.setGiving_id(rs.getInt("giving_id"));//赠品id
		tbdatagiving.setTrans_id(rs.getInt("trans_id"));//购车id
		tbdatagiving.setGive_type(rs.getInt("give_type"));//赠品类型
		tbdatagiving.setGive_id(rs.getInt("give_id"));//赠品编号
		tbdatagiving.setGiving_num(rs.getInt("giving_num"));//数量
	}

	public static List<TbDataGiving> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_data_giving";
		List<TbDataGiving> list = new ArrayList<TbDataGiving>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataGiving tbdatagiving = new TbDataGiving();
				fill(rs, tbdatagiving);
				list.add(tbdatagiving);
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


	public static List<TbDataGiving> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_data_giving where "+subsql+"";
		List<TbDataGiving> list = new ArrayList<TbDataGiving>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataGiving tbdatagiving = new TbDataGiving();
				fill(rs, tbdatagiving);
				list.add(tbdatagiving);
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
		String sql = "select count(*) from tb_data_giving where "+subsql+"";
		
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
		String sql = "delete from tb_data_giving where "+subsql+"";
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
		String sql = "delete from tb_data_giving where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbDataGiving tbdatagiving) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_data_giving(`giving_id`,`trans_id`,`give_type`,`give_id`,`giving_num`) values(?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdatagiving.getGiving_id());
		dbc.setInt(2, tbdatagiving.getTrans_id());
		dbc.setInt(3, tbdatagiving.getGive_type());
		dbc.setInt(4, tbdatagiving.getGive_id());
		dbc.setInt(5, tbdatagiving.getGiving_num());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbDataGiving tbdatagiving) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_data_giving(`giving_id`,`trans_id`,`give_type`,`give_id`,`giving_num`) values(?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdatagiving.getGiving_id());
		dbc.setInt(2, tbdatagiving.getTrans_id());
		dbc.setInt(3, tbdatagiving.getGive_type());
		dbc.setInt(4, tbdatagiving.getGive_id());
		dbc.setInt(5, tbdatagiving.getGiving_num());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbDataGiving tbdatagiving) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_data_giving set ");
		boolean flag = false;
		if(tbdatagiving.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",giving_id=?");
			}else{
				sb.append("giving_id=?");
				flag=true;
			}
		}
		if(tbdatagiving.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",trans_id=?");
			}else{
				sb.append("trans_id=?");
				flag=true;
			}
		}
		if(tbdatagiving.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",give_type=?");
			}else{
				sb.append("give_type=?");
				flag=true;
			}
		}
		if(tbdatagiving.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",give_id=?");
			}else{
				sb.append("give_id=?");
				flag=true;
			}
		}
		if(tbdatagiving.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",giving_num=?");
			}else{
				sb.append("giving_num=?");
				flag=true;
			}
		}
		sb.append(" where giving_id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbdatagiving.COLUMN_FLAG[0]){
			dbc.setInt(k, tbdatagiving.getGiving_id());k++;
		}
		if(tbdatagiving.COLUMN_FLAG[1]){
			dbc.setInt(k, tbdatagiving.getTrans_id());k++;
		}
		if(tbdatagiving.COLUMN_FLAG[2]){
			dbc.setInt(k, tbdatagiving.getGive_type());k++;
		}
		if(tbdatagiving.COLUMN_FLAG[3]){
			dbc.setInt(k, tbdatagiving.getGive_id());k++;
		}
		if(tbdatagiving.COLUMN_FLAG[4]){
			dbc.setInt(k, tbdatagiving.getGiving_num());k++;
		}
		dbc.setInt(k, tbdatagiving.getGiving_id());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbDataGiving tbdatagiving) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbdatagiving);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}