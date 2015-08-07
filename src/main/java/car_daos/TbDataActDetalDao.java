package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbDataActDetal;

public class  TbDataActDetalDao  extends BaseDao {

	public static void fill(ResultSet rs, TbDataActDetal tbdataactdetal) throws SQLException {
		tbdataactdetal.setDetail_id(rs.getInt("detail_id"));//活动详情id
		tbdataactdetal.setPro_num(rs.getString("pro_num"));//项目编号
		tbdataactdetal.setDetal_executor(rs.getString("detal_executor"));//执行人
		tbdataactdetal.setDetal_assist_person(rs.getString("detal_assist_person"));//辅助参与人员
		tbdataactdetal.setDetai_acti_date(rs.getTimestamp("detai_acti_date"));//活动日期
		tbdataactdetal.setDetail_time_interval(rs.getInt("detail_time_interval"));//时段
		tbdataactdetal.setDetail_traffic_expense(rs.getString("detail_traffic_expense"));//大巴交通费
		tbdataactdetal.setDetail_acti_sub(rs.getString("detail_acti_sub"));//活动人员补助
		tbdataactdetal.setDetail_acti_report(rs.getString("detail_acti_report"));//活动总结
	}

	public static List<TbDataActDetal> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_data_act_detal";
		List<TbDataActDetal> list = new ArrayList<TbDataActDetal>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataActDetal tbdataactdetal = new TbDataActDetal();
				fill(rs, tbdataactdetal);
				list.add(tbdataactdetal);
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


	public static List<TbDataActDetal> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_data_act_detal where "+subsql+"";
		List<TbDataActDetal> list = new ArrayList<TbDataActDetal>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataActDetal tbdataactdetal = new TbDataActDetal();
				fill(rs, tbdataactdetal);
				list.add(tbdataactdetal);
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
		String sql = "select count(*) from tb_data_act_detal where "+subsql+"";
		
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
		String sql = "delete from tb_data_act_detal where "+subsql+"";
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
		String sql = "delete from tb_data_act_detal where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbDataActDetal tbdataactdetal) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_data_act_detal(`detail_id`,`pro_num`,`detal_executor`,`detal_assist_person`,`detai_acti_date`,`detail_time_interval`,`detail_traffic_expense`,`detail_acti_sub`,`detail_acti_report`) values(?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdataactdetal.getDetail_id());
		dbc.setString(2, tbdataactdetal.getPro_num());
		dbc.setString(3, tbdataactdetal.getDetal_executor());
		dbc.setString(4, tbdataactdetal.getDetal_assist_person());
		dbc.setTimestamp(5, new Timestamp(tbdataactdetal.getDetai_acti_date().getTime()));
		dbc.setInt(6, tbdataactdetal.getDetail_time_interval());
		dbc.setString(7, tbdataactdetal.getDetail_traffic_expense());
		dbc.setString(8, tbdataactdetal.getDetail_acti_sub());
		dbc.setString(9, tbdataactdetal.getDetail_acti_report());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbDataActDetal tbdataactdetal) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_data_act_detal(`detail_id`,`pro_num`,`detal_executor`,`detal_assist_person`,`detai_acti_date`,`detail_time_interval`,`detail_traffic_expense`,`detail_acti_sub`,`detail_acti_report`) values(?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdataactdetal.getDetail_id());
		dbc.setString(2, tbdataactdetal.getPro_num());
		dbc.setString(3, tbdataactdetal.getDetal_executor());
		dbc.setString(4, tbdataactdetal.getDetal_assist_person());
		dbc.setTimestamp(5, new Timestamp(tbdataactdetal.getDetai_acti_date().getTime()));
		dbc.setInt(6, tbdataactdetal.getDetail_time_interval());
		dbc.setString(7, tbdataactdetal.getDetail_traffic_expense());
		dbc.setString(8, tbdataactdetal.getDetail_acti_sub());
		dbc.setString(9, tbdataactdetal.getDetail_acti_report());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbDataActDetal tbdataactdetal) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_data_act_detal set ");
		boolean flag = false;
		if(tbdataactdetal.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",detail_id=?");
			}else{
				sb.append("detail_id=?");
				flag=true;
			}
		}
		if(tbdataactdetal.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",pro_num=?");
			}else{
				sb.append("pro_num=?");
				flag=true;
			}
		}
		if(tbdataactdetal.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",detal_executor=?");
			}else{
				sb.append("detal_executor=?");
				flag=true;
			}
		}
		if(tbdataactdetal.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",detal_assist_person=?");
			}else{
				sb.append("detal_assist_person=?");
				flag=true;
			}
		}
		if(tbdataactdetal.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",detai_acti_date=?");
			}else{
				sb.append("detai_acti_date=?");
				flag=true;
			}
		}
		if(tbdataactdetal.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",detail_time_interval=?");
			}else{
				sb.append("detail_time_interval=?");
				flag=true;
			}
		}
		if(tbdataactdetal.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",detail_traffic_expense=?");
			}else{
				sb.append("detail_traffic_expense=?");
				flag=true;
			}
		}
		if(tbdataactdetal.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",detail_acti_sub=?");
			}else{
				sb.append("detail_acti_sub=?");
				flag=true;
			}
		}
		if(tbdataactdetal.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",detail_acti_report=?");
			}else{
				sb.append("detail_acti_report=?");
				flag=true;
			}
		}
		sb.append(" where detail_id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbdataactdetal.COLUMN_FLAG[0]){
			dbc.setInt(k, tbdataactdetal.getDetail_id());k++;
		}
		if(tbdataactdetal.COLUMN_FLAG[1]){
			dbc.setString(k, tbdataactdetal.getPro_num());k++;
		}
		if(tbdataactdetal.COLUMN_FLAG[2]){
			dbc.setString(k, tbdataactdetal.getDetal_executor());k++;
		}
		if(tbdataactdetal.COLUMN_FLAG[3]){
			dbc.setString(k, tbdataactdetal.getDetal_assist_person());k++;
		}
		if(tbdataactdetal.COLUMN_FLAG[4]){
			dbc.setTimestamp(k, new Timestamp(tbdataactdetal.getDetai_acti_date().getTime()));k++;
		}
		if(tbdataactdetal.COLUMN_FLAG[5]){
			dbc.setInt(k, tbdataactdetal.getDetail_time_interval());k++;
		}
		if(tbdataactdetal.COLUMN_FLAG[6]){
			dbc.setString(k, tbdataactdetal.getDetail_traffic_expense());k++;
		}
		if(tbdataactdetal.COLUMN_FLAG[7]){
			dbc.setString(k, tbdataactdetal.getDetail_acti_sub());k++;
		}
		if(tbdataactdetal.COLUMN_FLAG[8]){
			dbc.setString(k, tbdataactdetal.getDetail_acti_report());k++;
		}
		dbc.setInt(k, tbdataactdetal.getDetail_id());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbDataActDetal tbdataactdetal) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbdataactdetal);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}