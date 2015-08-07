package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbCarInsurance;

public class  TbCarInsuranceDao  extends BaseDao {

	public static void fill(ResultSet rs, TbCarInsurance tbcarinsurance) throws SQLException {
		tbcarinsurance.setId(rs.getInt("id"));//
		tbcarinsurance.setCity(rs.getString("city"));//所在城市
		tbcarinsurance.setCar_type(rs.getString("car_type"));//品牌车型
		tbcarinsurance.setCar_num(rs.getString("car_num"));//车牌号码
		tbcarinsurance.setInsure_end_date(rs.getTimestamp("insure_end_date"));//保险到期时间
		tbcarinsurance.setName(rs.getString("name"));//姓名
		tbcarinsurance.setTel(rs.getString("tel"));//联系电话
		tbcarinsurance.setStatus(rs.getInt("status"));//是否上牌  0 未上牌  1 已上牌
		tbcarinsurance.setCompany(rs.getInt("company"));//保险公司 0:中国平安 1:中国人保财险 2:太平洋保险
	}

	public static List<TbCarInsurance> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_car_insurance";
		List<TbCarInsurance> list = new ArrayList<TbCarInsurance>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbCarInsurance tbcarinsurance = new TbCarInsurance();
				fill(rs, tbcarinsurance);
				list.add(tbcarinsurance);
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


	public static List<TbCarInsurance> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_car_insurance where "+subsql+"";
		List<TbCarInsurance> list = new ArrayList<TbCarInsurance>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbCarInsurance tbcarinsurance = new TbCarInsurance();
				fill(rs, tbcarinsurance);
				list.add(tbcarinsurance);
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
		String sql = "select count(*) from tb_car_insurance where "+subsql+"";
		
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
		String sql = "delete from tb_car_insurance where "+subsql+"";
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
		String sql = "delete from tb_car_insurance where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbCarInsurance tbcarinsurance) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_car_insurance(`id`,`city`,`car_type`,`car_num`,`insure_end_date`,`name`,`tel`,`status`,`company`) values(?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbcarinsurance.getId());
		dbc.setString(2, tbcarinsurance.getCity());
		dbc.setString(3, tbcarinsurance.getCar_type());
		dbc.setString(4, tbcarinsurance.getCar_num());
		dbc.setTimestamp(5, new Timestamp(tbcarinsurance.getInsure_end_date().getTime()));
		dbc.setString(6, tbcarinsurance.getName());
		dbc.setString(7, tbcarinsurance.getTel());
		dbc.setInt(8, tbcarinsurance.getStatus());
		dbc.setInt(9, tbcarinsurance.getCompany());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbCarInsurance tbcarinsurance) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_car_insurance(`id`,`city`,`car_type`,`car_num`,`insure_end_date`,`name`,`tel`,`status`,`company`) values(?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbcarinsurance.getId());
		dbc.setString(2, tbcarinsurance.getCity());
		dbc.setString(3, tbcarinsurance.getCar_type());
		dbc.setString(4, tbcarinsurance.getCar_num());
		dbc.setTimestamp(5, new Timestamp(tbcarinsurance.getInsure_end_date().getTime()));
		dbc.setString(6, tbcarinsurance.getName());
		dbc.setString(7, tbcarinsurance.getTel());
		dbc.setInt(8, tbcarinsurance.getStatus());
		dbc.setInt(9, tbcarinsurance.getCompany());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbCarInsurance tbcarinsurance) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_car_insurance set ");
		boolean flag = false;
		if(tbcarinsurance.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(tbcarinsurance.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",city=?");
			}else{
				sb.append("city=?");
				flag=true;
			}
		}
		if(tbcarinsurance.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",car_type=?");
			}else{
				sb.append("car_type=?");
				flag=true;
			}
		}
		if(tbcarinsurance.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",car_num=?");
			}else{
				sb.append("car_num=?");
				flag=true;
			}
		}
		if(tbcarinsurance.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",insure_end_date=?");
			}else{
				sb.append("insure_end_date=?");
				flag=true;
			}
		}
		if(tbcarinsurance.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",name=?");
			}else{
				sb.append("name=?");
				flag=true;
			}
		}
		if(tbcarinsurance.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",tel=?");
			}else{
				sb.append("tel=?");
				flag=true;
			}
		}
		if(tbcarinsurance.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",status=?");
			}else{
				sb.append("status=?");
				flag=true;
			}
		}
		if(tbcarinsurance.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",company=?");
			}else{
				sb.append("company=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbcarinsurance.COLUMN_FLAG[0]){
			dbc.setInt(k, tbcarinsurance.getId());k++;
		}
		if(tbcarinsurance.COLUMN_FLAG[1]){
			dbc.setString(k, tbcarinsurance.getCity());k++;
		}
		if(tbcarinsurance.COLUMN_FLAG[2]){
			dbc.setString(k, tbcarinsurance.getCar_type());k++;
		}
		if(tbcarinsurance.COLUMN_FLAG[3]){
			dbc.setString(k, tbcarinsurance.getCar_num());k++;
		}
		if(tbcarinsurance.COLUMN_FLAG[4]){
			dbc.setTimestamp(k, new Timestamp(tbcarinsurance.getInsure_end_date().getTime()));k++;
		}
		if(tbcarinsurance.COLUMN_FLAG[5]){
			dbc.setString(k, tbcarinsurance.getName());k++;
		}
		if(tbcarinsurance.COLUMN_FLAG[6]){
			dbc.setString(k, tbcarinsurance.getTel());k++;
		}
		if(tbcarinsurance.COLUMN_FLAG[7]){
			dbc.setInt(k, tbcarinsurance.getStatus());k++;
		}
		if(tbcarinsurance.COLUMN_FLAG[8]){
			dbc.setInt(k, tbcarinsurance.getCompany());k++;
		}
		dbc.setInt(k, tbcarinsurance.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbCarInsurance tbcarinsurance) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbcarinsurance);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}