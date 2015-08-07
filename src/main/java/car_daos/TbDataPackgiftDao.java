package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbDataPackgift;

public class  TbDataPackgiftDao  extends BaseDao {

	public static void fill(ResultSet rs, TbDataPackgift tbdatapackgift) throws SQLException {
		tbdatapackgift.setPackgift_id(rs.getInt("packgift_id"));//礼包id
		tbdatapackgift.setPackage_id(rs.getInt("package_id"));//礼包id
		tbdatapackgift.setGift_id(rs.getInt("gift_id"));//礼品id
		tbdatapackgift.setGift_num(rs.getInt("gift_num"));//礼品数量
	}

	public static List<TbDataPackgift> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_data_packgift";
		List<TbDataPackgift> list = new ArrayList<TbDataPackgift>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataPackgift tbdatapackgift = new TbDataPackgift();
				fill(rs, tbdatapackgift);
				list.add(tbdatapackgift);
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


	public static List<TbDataPackgift> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_data_packgift where "+subsql+"";
		List<TbDataPackgift> list = new ArrayList<TbDataPackgift>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataPackgift tbdatapackgift = new TbDataPackgift();
				fill(rs, tbdatapackgift);
				list.add(tbdatapackgift);
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
		String sql = "select count(*) from tb_data_packgift where "+subsql+"";
		
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
		String sql = "delete from tb_data_packgift where "+subsql+"";
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
		String sql = "delete from tb_data_packgift where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbDataPackgift tbdatapackgift) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_data_packgift(`packgift_id`,`package_id`,`gift_id`,`gift_num`) values(?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdatapackgift.getPackgift_id());
		dbc.setInt(2, tbdatapackgift.getPackage_id());
		dbc.setInt(3, tbdatapackgift.getGift_id());
		dbc.setInt(4, tbdatapackgift.getGift_num());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbDataPackgift tbdatapackgift) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_data_packgift(`packgift_id`,`package_id`,`gift_id`,`gift_num`) values(?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdatapackgift.getPackgift_id());
		dbc.setInt(2, tbdatapackgift.getPackage_id());
		dbc.setInt(3, tbdatapackgift.getGift_id());
		dbc.setInt(4, tbdatapackgift.getGift_num());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbDataPackgift tbdatapackgift) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_data_packgift set ");
		boolean flag = false;
		if(tbdatapackgift.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",packgift_id=?");
			}else{
				sb.append("packgift_id=?");
				flag=true;
			}
		}
		if(tbdatapackgift.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",package_id=?");
			}else{
				sb.append("package_id=?");
				flag=true;
			}
		}
		if(tbdatapackgift.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",gift_id=?");
			}else{
				sb.append("gift_id=?");
				flag=true;
			}
		}
		if(tbdatapackgift.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",gift_num=?");
			}else{
				sb.append("gift_num=?");
				flag=true;
			}
		}
		sb.append(" where packgift_id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbdatapackgift.COLUMN_FLAG[0]){
			dbc.setInt(k, tbdatapackgift.getPackgift_id());k++;
		}
		if(tbdatapackgift.COLUMN_FLAG[1]){
			dbc.setInt(k, tbdatapackgift.getPackage_id());k++;
		}
		if(tbdatapackgift.COLUMN_FLAG[2]){
			dbc.setInt(k, tbdatapackgift.getGift_id());k++;
		}
		if(tbdatapackgift.COLUMN_FLAG[3]){
			dbc.setInt(k, tbdatapackgift.getGift_num());k++;
		}
		dbc.setInt(k, tbdatapackgift.getPackgift_id());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbDataPackgift tbdatapackgift) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbdatapackgift);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}