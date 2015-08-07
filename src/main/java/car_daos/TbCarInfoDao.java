package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbCarInfo;

public class  TbCarInfoDao  extends BaseDao {

	public static void fill(ResultSet rs, TbCarInfo tbcarinfo) throws SQLException {
		tbcarinfo.setId(rs.getInt("id"));//
		tbcarinfo.setName(rs.getString("name"));//姓名
		tbcarinfo.setTel(rs.getString("tel"));//电话
		tbcarinfo.setPhone(rs.getString("phone"));//手机
		tbcarinfo.setAddress(rs.getString("address"));//家庭住址
		tbcarinfo.setCar_type(rs.getString("car_type"));//车型
		tbcarinfo.setCar_num(rs.getString("car_num"));//车牌
		tbcarinfo.setBuy_date(rs.getTimestamp("buy_date"));//购车时间
		tbcarinfo.setArea(rs.getString("area"));//区域
		tbcarinfo.setStatus(rs.getInt("status"));//是否购车 0  1购车
	}

	public static List<TbCarInfo> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_car_info";
		List<TbCarInfo> list = new ArrayList<TbCarInfo>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbCarInfo tbcarinfo = new TbCarInfo();
				fill(rs, tbcarinfo);
				list.add(tbcarinfo);
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


	public static List<TbCarInfo> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_car_info where "+subsql+"";
		List<TbCarInfo> list = new ArrayList<TbCarInfo>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbCarInfo tbcarinfo = new TbCarInfo();
				fill(rs, tbcarinfo);
				list.add(tbcarinfo);
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
		String sql = "select count(*) from tb_car_info where "+subsql+"";
		
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
		String sql = "delete from tb_car_info where "+subsql+"";
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
		String sql = "delete from tb_car_info where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbCarInfo tbcarinfo) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_car_info(`id`,`name`,`tel`,`phone`,`address`,`car_type`,`car_num`,`buy_date`,`area`,`status`) values(?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbcarinfo.getId());
		dbc.setString(2, tbcarinfo.getName());
		dbc.setString(3, tbcarinfo.getTel());
		dbc.setString(4, tbcarinfo.getPhone());
		dbc.setString(5, tbcarinfo.getAddress());
		dbc.setString(6, tbcarinfo.getCar_type());
		dbc.setString(7, tbcarinfo.getCar_num());
		dbc.setTimestamp(8, new Timestamp(tbcarinfo.getBuy_date().getTime()));
		dbc.setString(9, tbcarinfo.getArea());
		dbc.setInt(10, tbcarinfo.getStatus());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbCarInfo tbcarinfo) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_car_info(`id`,`name`,`tel`,`phone`,`address`,`car_type`,`car_num`,`buy_date`,`area`,`status`) values(?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbcarinfo.getId());
		dbc.setString(2, tbcarinfo.getName());
		dbc.setString(3, tbcarinfo.getTel());
		dbc.setString(4, tbcarinfo.getPhone());
		dbc.setString(5, tbcarinfo.getAddress());
		dbc.setString(6, tbcarinfo.getCar_type());
		dbc.setString(7, tbcarinfo.getCar_num());
		dbc.setTimestamp(8, new Timestamp(tbcarinfo.getBuy_date().getTime()));
		dbc.setString(9, tbcarinfo.getArea());
		dbc.setInt(10, tbcarinfo.getStatus());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbCarInfo tbcarinfo) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_car_info set ");
		boolean flag = false;
		if(tbcarinfo.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(tbcarinfo.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",name=?");
			}else{
				sb.append("name=?");
				flag=true;
			}
		}
		if(tbcarinfo.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",tel=?");
			}else{
				sb.append("tel=?");
				flag=true;
			}
		}
		if(tbcarinfo.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",phone=?");
			}else{
				sb.append("phone=?");
				flag=true;
			}
		}
		if(tbcarinfo.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",address=?");
			}else{
				sb.append("address=?");
				flag=true;
			}
		}
		if(tbcarinfo.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",car_type=?");
			}else{
				sb.append("car_type=?");
				flag=true;
			}
		}
		if(tbcarinfo.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",car_num=?");
			}else{
				sb.append("car_num=?");
				flag=true;
			}
		}
		if(tbcarinfo.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",buy_date=?");
			}else{
				sb.append("buy_date=?");
				flag=true;
			}
		}
		if(tbcarinfo.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",area=?");
			}else{
				sb.append("area=?");
				flag=true;
			}
		}
		if(tbcarinfo.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",status=?");
			}else{
				sb.append("status=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbcarinfo.COLUMN_FLAG[0]){
			dbc.setInt(k, tbcarinfo.getId());k++;
		}
		if(tbcarinfo.COLUMN_FLAG[1]){
			dbc.setString(k, tbcarinfo.getName());k++;
		}
		if(tbcarinfo.COLUMN_FLAG[2]){
			dbc.setString(k, tbcarinfo.getTel());k++;
		}
		if(tbcarinfo.COLUMN_FLAG[3]){
			dbc.setString(k, tbcarinfo.getPhone());k++;
		}
		if(tbcarinfo.COLUMN_FLAG[4]){
			dbc.setString(k, tbcarinfo.getAddress());k++;
		}
		if(tbcarinfo.COLUMN_FLAG[5]){
			dbc.setString(k, tbcarinfo.getCar_type());k++;
		}
		if(tbcarinfo.COLUMN_FLAG[6]){
			dbc.setString(k, tbcarinfo.getCar_num());k++;
		}
		if(tbcarinfo.COLUMN_FLAG[7]){
			dbc.setTimestamp(k, new Timestamp(tbcarinfo.getBuy_date().getTime()));k++;
		}
		if(tbcarinfo.COLUMN_FLAG[8]){
			dbc.setString(k, tbcarinfo.getArea());k++;
		}
		if(tbcarinfo.COLUMN_FLAG[9]){
			dbc.setInt(k, tbcarinfo.getStatus());k++;
		}
		dbc.setInt(k, tbcarinfo.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbCarInfo tbcarinfo) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbcarinfo);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}