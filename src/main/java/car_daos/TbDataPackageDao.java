package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbDataPackage;

public class  TbDataPackageDao  extends BaseDao {

	public static void fill(ResultSet rs, TbDataPackage tbdatapackage) throws SQLException {
		tbdatapackage.setPackage_id(rs.getInt("package_id"));//礼包id
		tbdatapackage.setPackage_name(rs.getString("package_name"));//礼包名称
		tbdatapackage.setPackage_detail(rs.getString("package_detail"));//礼包明细
		tbdatapackage.setPackage_price(rs.getString("package_price"));//礼包价值
		tbdatapackage.setAddtime(rs.getTimestamp("addtime"));//添加时间
		tbdatapackage.setIsdel(rs.getInt("isdel"));//是否被删除
	}

	public static List<TbDataPackage> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_data_package";
		List<TbDataPackage> list = new ArrayList<TbDataPackage>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataPackage tbdatapackage = new TbDataPackage();
				fill(rs, tbdatapackage);
				list.add(tbdatapackage);
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


	public static List<TbDataPackage> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_data_package where "+subsql+"";
		List<TbDataPackage> list = new ArrayList<TbDataPackage>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataPackage tbdatapackage = new TbDataPackage();
				fill(rs, tbdatapackage);
				list.add(tbdatapackage);
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
		String sql = "select count(*) from tb_data_package where "+subsql+"";
		
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
		String sql = "delete from tb_data_package where "+subsql+"";
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
		String sql = "delete from tb_data_package where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbDataPackage tbdatapackage) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_data_package(`package_id`,`package_name`,`package_detail`,`package_price`,`addtime`,`isdel`) values(?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdatapackage.getPackage_id());
		dbc.setString(2, tbdatapackage.getPackage_name());
		dbc.setString(3, tbdatapackage.getPackage_detail());
		dbc.setString(4, tbdatapackage.getPackage_price());
		dbc.setTimestamp(5, new Timestamp(tbdatapackage.getAddtime().getTime()));
		dbc.setInt(6, tbdatapackage.getIsdel());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbDataPackage tbdatapackage) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_data_package(`package_id`,`package_name`,`package_detail`,`package_price`,`addtime`,`isdel`) values(?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdatapackage.getPackage_id());
		dbc.setString(2, tbdatapackage.getPackage_name());
		dbc.setString(3, tbdatapackage.getPackage_detail());
		dbc.setString(4, tbdatapackage.getPackage_price());
		dbc.setTimestamp(5, new Timestamp(tbdatapackage.getAddtime().getTime()));
		dbc.setInt(6, tbdatapackage.getIsdel());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbDataPackage tbdatapackage) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_data_package set ");
		boolean flag = false;
		if(tbdatapackage.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",package_id=?");
			}else{
				sb.append("package_id=?");
				flag=true;
			}
		}
		if(tbdatapackage.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",package_name=?");
			}else{
				sb.append("package_name=?");
				flag=true;
			}
		}
		if(tbdatapackage.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",package_detail=?");
			}else{
				sb.append("package_detail=?");
				flag=true;
			}
		}
		if(tbdatapackage.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",package_price=?");
			}else{
				sb.append("package_price=?");
				flag=true;
			}
		}
		if(tbdatapackage.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",addtime=?");
			}else{
				sb.append("addtime=?");
				flag=true;
			}
		}
		if(tbdatapackage.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",isdel=?");
			}else{
				sb.append("isdel=?");
				flag=true;
			}
		}
		sb.append(" where package_id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbdatapackage.COLUMN_FLAG[0]){
			dbc.setInt(k, tbdatapackage.getPackage_id());k++;
		}
		if(tbdatapackage.COLUMN_FLAG[1]){
			dbc.setString(k, tbdatapackage.getPackage_name());k++;
		}
		if(tbdatapackage.COLUMN_FLAG[2]){
			dbc.setString(k, tbdatapackage.getPackage_detail());k++;
		}
		if(tbdatapackage.COLUMN_FLAG[3]){
			dbc.setString(k, tbdatapackage.getPackage_price());k++;
		}
		if(tbdatapackage.COLUMN_FLAG[4]){
			dbc.setTimestamp(k, new Timestamp(tbdatapackage.getAddtime().getTime()));k++;
		}
		if(tbdatapackage.COLUMN_FLAG[5]){
			dbc.setInt(k, tbdatapackage.getIsdel());k++;
		}
		dbc.setInt(k, tbdatapackage.getPackage_id());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbDataPackage tbdatapackage) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbdatapackage);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}