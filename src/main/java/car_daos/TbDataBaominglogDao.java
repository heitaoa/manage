package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbDataBaominglog;

public class  TbDataBaominglogDao  extends BaseDao {

	public static void fill(ResultSet rs, TbDataBaominglog tbdatabaominglog) throws SQLException {
		tbdatabaominglog.setId(rs.getInt("id"));//
		tbdatabaominglog.setBaomingid(rs.getInt("baomingid"));//报名id
		tbdatabaominglog.setUserid(rs.getString("userid"));//工号
		tbdatabaominglog.setUsername(rs.getString("username"));//姓名
		tbdatabaominglog.setOperate_content(rs.getString("operate_content"));//操作内容
		tbdatabaominglog.setOperate_time(rs.getTimestamp("operate_time"));//操作时间
		tbdatabaominglog.setOperate_state(rs.getString("operate_state"));//操作步骤
		tbdatabaominglog.setReturn_visit_state(rs.getInt("return_visit_state"));//回访状态 0-未回访 1-一呼 2-二呼 3-三呼 4- 其他
		tbdatabaominglog.setPhoneerror(rs.getInt("phoneerror"));//电话能否接通  0-已接通 1-未接通
		tbdatabaominglog.setConstacterror(rs.getInt("constacterror"));//0-已沟通 1-未沟通
	}

	public static List<TbDataBaominglog> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_data_baominglog";
		List<TbDataBaominglog> list = new ArrayList<TbDataBaominglog>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataBaominglog tbdatabaominglog = new TbDataBaominglog();
				fill(rs, tbdatabaominglog);
				list.add(tbdatabaominglog);
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


	public static List<TbDataBaominglog> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_data_baominglog where "+subsql+"";
		List<TbDataBaominglog> list = new ArrayList<TbDataBaominglog>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataBaominglog tbdatabaominglog = new TbDataBaominglog();
				fill(rs, tbdatabaominglog);
				list.add(tbdatabaominglog);
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
		String sql = "select count(*) from tb_data_baominglog where "+subsql+"";
		
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
		String sql = "delete from tb_data_baominglog where "+subsql+"";
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
		String sql = "delete from tb_data_baominglog where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbDataBaominglog tbdatabaominglog) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_data_baominglog(`id`,`baomingid`,`userid`,`username`,`operate_content`,`operate_time`,`operate_state`,`return_visit_state`,`phoneerror`,`constacterror`) values(?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdatabaominglog.getId());
		dbc.setInt(2, tbdatabaominglog.getBaomingid());
		dbc.setString(3, tbdatabaominglog.getUserid());
		dbc.setString(4, tbdatabaominglog.getUsername());
		dbc.setString(5, tbdatabaominglog.getOperate_content());
		dbc.setTimestamp(6, new Timestamp(tbdatabaominglog.getOperate_time().getTime()));
		dbc.setString(7, tbdatabaominglog.getOperate_state());
		dbc.setInt(8, tbdatabaominglog.getReturn_visit_state());
		dbc.setInt(9, tbdatabaominglog.getPhoneerror());
		dbc.setInt(10, tbdatabaominglog.getConstacterror());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbDataBaominglog tbdatabaominglog) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_data_baominglog(`id`,`baomingid`,`userid`,`username`,`operate_content`,`operate_time`,`operate_state`,`return_visit_state`,`phoneerror`,`constacterror`) values(?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdatabaominglog.getId());
		dbc.setInt(2, tbdatabaominglog.getBaomingid());
		dbc.setString(3, tbdatabaominglog.getUserid());
		dbc.setString(4, tbdatabaominglog.getUsername());
		dbc.setString(5, tbdatabaominglog.getOperate_content());
		dbc.setTimestamp(6, new Timestamp(tbdatabaominglog.getOperate_time().getTime()));
		dbc.setString(7, tbdatabaominglog.getOperate_state());
		dbc.setInt(8, tbdatabaominglog.getReturn_visit_state());
		dbc.setInt(9, tbdatabaominglog.getPhoneerror());
		dbc.setInt(10, tbdatabaominglog.getConstacterror());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbDataBaominglog tbdatabaominglog) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_data_baominglog set ");
		boolean flag = false;
		if(tbdatabaominglog.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(tbdatabaominglog.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",baomingid=?");
			}else{
				sb.append("baomingid=?");
				flag=true;
			}
		}
		if(tbdatabaominglog.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",userid=?");
			}else{
				sb.append("userid=?");
				flag=true;
			}
		}
		if(tbdatabaominglog.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",username=?");
			}else{
				sb.append("username=?");
				flag=true;
			}
		}
		if(tbdatabaominglog.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",operate_content=?");
			}else{
				sb.append("operate_content=?");
				flag=true;
			}
		}
		if(tbdatabaominglog.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",operate_time=?");
			}else{
				sb.append("operate_time=?");
				flag=true;
			}
		}
		if(tbdatabaominglog.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",operate_state=?");
			}else{
				sb.append("operate_state=?");
				flag=true;
			}
		}
		if(tbdatabaominglog.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",return_visit_state=?");
			}else{
				sb.append("return_visit_state=?");
				flag=true;
			}
		}
		if(tbdatabaominglog.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",phoneerror=?");
			}else{
				sb.append("phoneerror=?");
				flag=true;
			}
		}
		if(tbdatabaominglog.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",constacterror=?");
			}else{
				sb.append("constacterror=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbdatabaominglog.COLUMN_FLAG[0]){
			dbc.setInt(k, tbdatabaominglog.getId());k++;
		}
		if(tbdatabaominglog.COLUMN_FLAG[1]){
			dbc.setInt(k, tbdatabaominglog.getBaomingid());k++;
		}
		if(tbdatabaominglog.COLUMN_FLAG[2]){
			dbc.setString(k, tbdatabaominglog.getUserid());k++;
		}
		if(tbdatabaominglog.COLUMN_FLAG[3]){
			dbc.setString(k, tbdatabaominglog.getUsername());k++;
		}
		if(tbdatabaominglog.COLUMN_FLAG[4]){
			dbc.setString(k, tbdatabaominglog.getOperate_content());k++;
		}
		if(tbdatabaominglog.COLUMN_FLAG[5]){
			dbc.setTimestamp(k, new Timestamp(tbdatabaominglog.getOperate_time().getTime()));k++;
		}
		if(tbdatabaominglog.COLUMN_FLAG[6]){
			dbc.setString(k, tbdatabaominglog.getOperate_state());k++;
		}
		if(tbdatabaominglog.COLUMN_FLAG[7]){
			dbc.setInt(k, tbdatabaominglog.getReturn_visit_state());k++;
		}
		if(tbdatabaominglog.COLUMN_FLAG[8]){
			dbc.setInt(k, tbdatabaominglog.getPhoneerror());k++;
		}
		if(tbdatabaominglog.COLUMN_FLAG[9]){
			dbc.setInt(k, tbdatabaominglog.getConstacterror());k++;
		}
		dbc.setInt(k, tbdatabaominglog.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbDataBaominglog tbdatabaominglog) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbdatabaominglog);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}