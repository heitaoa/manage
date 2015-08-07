package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbDataActDetail;

public class  TbDataActDetailDao  extends BaseDao {

	public static void fill(ResultSet rs, TbDataActDetail tbdataactdetail) throws SQLException {
		tbdataactdetail.setDetail_id(rs.getInt("detail_id"));//活动详情id
		tbdataactdetail.setPro_num(rs.getString("pro_num"));//项目编号
		tbdataactdetail.setDetail_executor(rs.getString("detail_executor"));//执行人
		tbdataactdetail.setDetail_assist_person(rs.getString("detail_assist_person"));//辅助参与人员
		tbdataactdetail.setDetail_acti_date(rs.getTimestamp("detail_acti_date"));//活动日期
		tbdataactdetail.setDetail_time_interval(rs.getInt("detail_time_interval"));//时段
		tbdataactdetail.setDetail_traffic_expense(rs.getString("detail_traffic_expense"));//大巴交通费
		tbdataactdetail.setDetail_acti_sub(rs.getString("detail_acti_sub"));//活动人员补助
		tbdataactdetail.setDetail_acti_report(rs.getString("detail_acti_report"));//活动总结
		tbdataactdetail.setDetail_acti_addr(rs.getString("detail_acti_addr"));//公司地址
	}

	public static List<TbDataActDetail> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_data_act_detail";
		List<TbDataActDetail> list = new ArrayList<TbDataActDetail>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataActDetail tbdataactdetail = new TbDataActDetail();
				fill(rs, tbdataactdetail);
				list.add(tbdataactdetail);
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


	public static List<TbDataActDetail> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_data_act_detail where "+subsql+"";
		List<TbDataActDetail> list = new ArrayList<TbDataActDetail>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataActDetail tbdataactdetail = new TbDataActDetail();
				fill(rs, tbdataactdetail);
				list.add(tbdataactdetail);
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
		String sql = "select count(*) from tb_data_act_detail where "+subsql+"";
		
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
		String sql = "delete from tb_data_act_detail where "+subsql+"";
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
		String sql = "delete from tb_data_act_detail where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbDataActDetail tbdataactdetail) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_data_act_detail(`detail_id`,`pro_num`,`detail_executor`,`detail_assist_person`,`detail_acti_date`,`detail_time_interval`,`detail_traffic_expense`,`detail_acti_sub`,`detail_acti_report`,`detail_acti_addr`) values(?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdataactdetail.getDetail_id());
		dbc.setString(2, tbdataactdetail.getPro_num());
		dbc.setString(3, tbdataactdetail.getDetail_executor());
		dbc.setString(4, tbdataactdetail.getDetail_assist_person());
		dbc.setTimestamp(5, new Timestamp(tbdataactdetail.getDetail_acti_date().getTime()));
		dbc.setInt(6, tbdataactdetail.getDetail_time_interval());
		dbc.setString(7, tbdataactdetail.getDetail_traffic_expense());
		dbc.setString(8, tbdataactdetail.getDetail_acti_sub());
		dbc.setString(9, tbdataactdetail.getDetail_acti_report());
		dbc.setString(10, tbdataactdetail.getDetail_acti_addr());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbDataActDetail tbdataactdetail) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_data_act_detail(`detail_id`,`pro_num`,`detail_executor`,`detail_assist_person`,`detail_acti_date`,`detail_time_interval`,`detail_traffic_expense`,`detail_acti_sub`,`detail_acti_report`,`detail_acti_addr`) values(?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdataactdetail.getDetail_id());
		dbc.setString(2, tbdataactdetail.getPro_num());
		dbc.setString(3, tbdataactdetail.getDetail_executor());
		dbc.setString(4, tbdataactdetail.getDetail_assist_person());
		dbc.setTimestamp(5, new Timestamp(tbdataactdetail.getDetail_acti_date().getTime()));
		dbc.setInt(6, tbdataactdetail.getDetail_time_interval());
		dbc.setString(7, tbdataactdetail.getDetail_traffic_expense());
		dbc.setString(8, tbdataactdetail.getDetail_acti_sub());
		dbc.setString(9, tbdataactdetail.getDetail_acti_report());
		dbc.setString(10, tbdataactdetail.getDetail_acti_addr());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbDataActDetail tbdataactdetail) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_data_act_detail set ");
		boolean flag = false;
		if(tbdataactdetail.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",detail_id=?");
			}else{
				sb.append("detail_id=?");
				flag=true;
			}
		}
		if(tbdataactdetail.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",pro_num=?");
			}else{
				sb.append("pro_num=?");
				flag=true;
			}
		}
		if(tbdataactdetail.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",detail_executor=?");
			}else{
				sb.append("detail_executor=?");
				flag=true;
			}
		}
		if(tbdataactdetail.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",detail_assist_person=?");
			}else{
				sb.append("detail_assist_person=?");
				flag=true;
			}
		}
		if(tbdataactdetail.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",detail_acti_date=?");
			}else{
				sb.append("detail_acti_date=?");
				flag=true;
			}
		}
		if(tbdataactdetail.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",detail_time_interval=?");
			}else{
				sb.append("detail_time_interval=?");
				flag=true;
			}
		}
		if(tbdataactdetail.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",detail_traffic_expense=?");
			}else{
				sb.append("detail_traffic_expense=?");
				flag=true;
			}
		}
		if(tbdataactdetail.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",detail_acti_sub=?");
			}else{
				sb.append("detail_acti_sub=?");
				flag=true;
			}
		}
		if(tbdataactdetail.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",detail_acti_report=?");
			}else{
				sb.append("detail_acti_report=?");
				flag=true;
			}
		}
		if(tbdataactdetail.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",detail_acti_addr=?");
			}else{
				sb.append("detail_acti_addr=?");
				flag=true;
			}
		}
		sb.append(" where detail_id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbdataactdetail.COLUMN_FLAG[0]){
			dbc.setInt(k, tbdataactdetail.getDetail_id());k++;
		}
		if(tbdataactdetail.COLUMN_FLAG[1]){
			dbc.setString(k, tbdataactdetail.getPro_num());k++;
		}
		if(tbdataactdetail.COLUMN_FLAG[2]){
			dbc.setString(k, tbdataactdetail.getDetail_executor());k++;
		}
		if(tbdataactdetail.COLUMN_FLAG[3]){
			dbc.setString(k, tbdataactdetail.getDetail_assist_person());k++;
		}
		if(tbdataactdetail.COLUMN_FLAG[4]){
			dbc.setTimestamp(k, new Timestamp(tbdataactdetail.getDetail_acti_date().getTime()));k++;
		}
		if(tbdataactdetail.COLUMN_FLAG[5]){
			dbc.setInt(k, tbdataactdetail.getDetail_time_interval());k++;
		}
		if(tbdataactdetail.COLUMN_FLAG[6]){
			dbc.setString(k, tbdataactdetail.getDetail_traffic_expense());k++;
		}
		if(tbdataactdetail.COLUMN_FLAG[7]){
			dbc.setString(k, tbdataactdetail.getDetail_acti_sub());k++;
		}
		if(tbdataactdetail.COLUMN_FLAG[8]){
			dbc.setString(k, tbdataactdetail.getDetail_acti_report());k++;
		}
		if(tbdataactdetail.COLUMN_FLAG[9]){
			dbc.setString(k, tbdataactdetail.getDetail_acti_addr());k++;
		}
		dbc.setInt(k, tbdataactdetail.getDetail_id());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbDataActDetail tbdataactdetail) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbdataactdetail);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}