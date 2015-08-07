package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbDataQiandao;

public class  TbDataQiandaoDao  extends BaseDao {

	public static void fill(ResultSet rs, TbDataQiandao tbdataqiandao) throws SQLException {
		tbdataqiandao.setId(rs.getInt("id"));//id
		tbdataqiandao.setPro_num(rs.getString("pro_num"));//项目编号
		tbdataqiandao.setBaoming_id(rs.getInt("baoming_id"));//报名id
		tbdataqiandao.setName(rs.getString("name"));//姓名
		tbdataqiandao.setPhone(rs.getString("phone"));//电话
		tbdataqiandao.setIs_reach(rs.getInt("is_reach"));//是否到店
		tbdataqiandao.setIs_trans(rs.getInt("is_trans"));//是否成交
		tbdataqiandao.setIs_invite(rs.getInt("is_invite"));//是否邀约
	}

	public static List<TbDataQiandao> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_data_qiandao";
		List<TbDataQiandao> list = new ArrayList<TbDataQiandao>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataQiandao tbdataqiandao = new TbDataQiandao();
				fill(rs, tbdataqiandao);
				list.add(tbdataqiandao);
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


	public static List<TbDataQiandao> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_data_qiandao where "+subsql+"";
		List<TbDataQiandao> list = new ArrayList<TbDataQiandao>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataQiandao tbdataqiandao = new TbDataQiandao();
				fill(rs, tbdataqiandao);
				list.add(tbdataqiandao);
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
		String sql = "select count(*) from tb_data_qiandao where "+subsql+"";
		
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
		String sql = "delete from tb_data_qiandao where "+subsql+"";
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
		String sql = "delete from tb_data_qiandao where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbDataQiandao tbdataqiandao) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_data_qiandao(`id`,`pro_num`,`baoming_id`,`name`,`phone`,`is_reach`,`is_trans`,`is_invite`) values(?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdataqiandao.getId());
		dbc.setString(2, tbdataqiandao.getPro_num());
		dbc.setInt(3, tbdataqiandao.getBaoming_id());
		dbc.setString(4, tbdataqiandao.getName());
		dbc.setString(5, tbdataqiandao.getPhone());
		dbc.setInt(6, tbdataqiandao.getIs_reach());
		dbc.setInt(7, tbdataqiandao.getIs_trans());
		dbc.setInt(8, tbdataqiandao.getIs_invite());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbDataQiandao tbdataqiandao) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_data_qiandao(`id`,`pro_num`,`baoming_id`,`name`,`phone`,`is_reach`,`is_trans`,`is_invite`) values(?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdataqiandao.getId());
		dbc.setString(2, tbdataqiandao.getPro_num());
		dbc.setInt(3, tbdataqiandao.getBaoming_id());
		dbc.setString(4, tbdataqiandao.getName());
		dbc.setString(5, tbdataqiandao.getPhone());
		dbc.setInt(6, tbdataqiandao.getIs_reach());
		dbc.setInt(7, tbdataqiandao.getIs_trans());
		dbc.setInt(8, tbdataqiandao.getIs_invite());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbDataQiandao tbdataqiandao) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_data_qiandao set ");
		boolean flag = false;
		if(tbdataqiandao.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(tbdataqiandao.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",pro_num=?");
			}else{
				sb.append("pro_num=?");
				flag=true;
			}
		}
		if(tbdataqiandao.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",baoming_id=?");
			}else{
				sb.append("baoming_id=?");
				flag=true;
			}
		}
		if(tbdataqiandao.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",name=?");
			}else{
				sb.append("name=?");
				flag=true;
			}
		}
		if(tbdataqiandao.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",phone=?");
			}else{
				sb.append("phone=?");
				flag=true;
			}
		}
		if(tbdataqiandao.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",is_reach=?");
			}else{
				sb.append("is_reach=?");
				flag=true;
			}
		}
		if(tbdataqiandao.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",is_trans=?");
			}else{
				sb.append("is_trans=?");
				flag=true;
			}
		}
		if(tbdataqiandao.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",is_invite=?");
			}else{
				sb.append("is_invite=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbdataqiandao.COLUMN_FLAG[0]){
			dbc.setInt(k, tbdataqiandao.getId());k++;
		}
		if(tbdataqiandao.COLUMN_FLAG[1]){
			dbc.setString(k, tbdataqiandao.getPro_num());k++;
		}
		if(tbdataqiandao.COLUMN_FLAG[2]){
			dbc.setInt(k, tbdataqiandao.getBaoming_id());k++;
		}
		if(tbdataqiandao.COLUMN_FLAG[3]){
			dbc.setString(k, tbdataqiandao.getName());k++;
		}
		if(tbdataqiandao.COLUMN_FLAG[4]){
			dbc.setString(k, tbdataqiandao.getPhone());k++;
		}
		if(tbdataqiandao.COLUMN_FLAG[5]){
			dbc.setInt(k, tbdataqiandao.getIs_reach());k++;
		}
		if(tbdataqiandao.COLUMN_FLAG[6]){
			dbc.setInt(k, tbdataqiandao.getIs_trans());k++;
		}
		if(tbdataqiandao.COLUMN_FLAG[7]){
			dbc.setInt(k, tbdataqiandao.getIs_invite());k++;
		}
		dbc.setInt(k, tbdataqiandao.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbDataQiandao tbdataqiandao) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbdataqiandao);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}