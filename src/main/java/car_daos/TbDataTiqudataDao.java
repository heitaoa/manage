package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbDataTiqudata;

public class  TbDataTiqudataDao  extends BaseDao {

	public static void fill(ResultSet rs, TbDataTiqudata tbdatatiqudata) throws SQLException {
		tbdatatiqudata.setTiqu_num(rs.getString("tiqu_num"));//项目编号
		tbdatatiqudata.setIni_man(rs.getString("ini_man"));//发起人
		tbdatatiqudata.setIni_dept(rs.getInt("ini_dept"));//发起部门
		tbdatatiqudata.setIni_org(rs.getInt("ini_org"));//发起站点
		tbdatatiqudata.setIni_date(rs.getTimestamp("ini_date"));//发起时间
		tbdatatiqudata.setContact_num(rs.getString("contact_num"));//关联合同号
		tbdatatiqudata.setContact_money(rs.getString("contact_money"));//合同金额
		tbdatatiqudata.setContact_start_date(rs.getTimestamp("contact_start_date"));//合同开始日期
		tbdatatiqudata.setContact_end_date(rs.getTimestamp("contact_end_date"));//合同结束日期
		tbdatatiqudata.setCust_name(rs.getString("cust_name"));//客户名称
		tbdatatiqudata.setBrand(rs.getInt("brand"));//品牌
		tbdatatiqudata.setCar(rs.getInt("car"));//车系
		tbdatatiqudata.setProv(rs.getInt("prov"));//推广省份 -1 代表全国
		tbdatatiqudata.setCity(rs.getInt("city"));//推广城市 -1代表该省份下所有城市
		tbdatatiqudata.setData_count(rs.getInt("data_count"));//数据需求量
		tbdatatiqudata.setData_start_date(rs.getTimestamp("data_start_date"));//数据周期开始日期
		tbdatatiqudata.setData_end_date(rs.getTimestamp("data_end_date"));//数据周期结束日期
		tbdatatiqudata.setIs_agree_deduct(rs.getInt("is_agree_deduct"));//是否同意扣除执行金额
		tbdatatiqudata.setApply_cause(rs.getString("apply_cause"));//申请原因
		tbdatatiqudata.setIs_deduct(rs.getInt("is_deduct"));//是否扣除执行金额--高层审核结果
		tbdatatiqudata.setExamine_state(rs.getInt("examine_state"));//审核状态(0-未审核、1-主管通过、2-主管驳回、3-高层通过、4-高层驳回)
		tbdatatiqudata.setDeny_cause(rs.getString("deny_cause"));//
		tbdatatiqudata.setTiqu_state(rs.getInt("tiqu_state"));//提取状态(0-未操作、1-同意执行、2-取消执行、3-已执行)
		tbdatatiqudata.setExport_count(rs.getInt("export_count"));//数据导出次数
	}

	public static List<TbDataTiqudata> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_data_tiqudata";
		List<TbDataTiqudata> list = new ArrayList<TbDataTiqudata>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataTiqudata tbdatatiqudata = new TbDataTiqudata();
				fill(rs, tbdatatiqudata);
				list.add(tbdatatiqudata);
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


	public static List<TbDataTiqudata> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_data_tiqudata where "+subsql+"";
		List<TbDataTiqudata> list = new ArrayList<TbDataTiqudata>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataTiqudata tbdatatiqudata = new TbDataTiqudata();
				fill(rs, tbdatatiqudata);
				list.add(tbdatatiqudata);
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
		String sql = "select count(*) from tb_data_tiqudata where "+subsql+"";
		
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
		String sql = "delete from tb_data_tiqudata where "+subsql+"";
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
		String sql = "delete from tb_data_tiqudata where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbDataTiqudata tbdatatiqudata) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_data_tiqudata(`tiqu_num`,`ini_man`,`ini_dept`,`ini_org`,`ini_date`,`contact_num`,`contact_money`,`contact_start_date`,`contact_end_date`,`cust_name`,`brand`,`car`,`prov`,`city`,`data_count`,`data_start_date`,`data_end_date`,`is_agree_deduct`,`apply_cause`,`is_deduct`,`examine_state`,`deny_cause`,`tiqu_state`,`export_count`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setString(1, tbdatatiqudata.getTiqu_num());
		dbc.setString(2, tbdatatiqudata.getIni_man());
		dbc.setInt(3, tbdatatiqudata.getIni_dept());
		dbc.setInt(4, tbdatatiqudata.getIni_org());
		dbc.setTimestamp(5, new Timestamp(tbdatatiqudata.getIni_date().getTime()));
		dbc.setString(6, tbdatatiqudata.getContact_num());
		dbc.setString(7, tbdatatiqudata.getContact_money());
		dbc.setTimestamp(8, new Timestamp(tbdatatiqudata.getContact_start_date().getTime()));
		dbc.setTimestamp(9, new Timestamp(tbdatatiqudata.getContact_end_date().getTime()));
		dbc.setString(10, tbdatatiqudata.getCust_name());
		dbc.setInt(11, tbdatatiqudata.getBrand());
		dbc.setInt(12, tbdatatiqudata.getCar());
		dbc.setInt(13, tbdatatiqudata.getProv());
		dbc.setInt(14, tbdatatiqudata.getCity());
		dbc.setInt(15, tbdatatiqudata.getData_count());
		dbc.setTimestamp(16, new Timestamp(tbdatatiqudata.getData_start_date().getTime()));
		dbc.setTimestamp(17, new Timestamp(tbdatatiqudata.getData_end_date().getTime()));
		dbc.setInt(18, tbdatatiqudata.getIs_agree_deduct());
		dbc.setString(19, tbdatatiqudata.getApply_cause());
		dbc.setInt(20, tbdatatiqudata.getIs_deduct());
		dbc.setInt(21, tbdatatiqudata.getExamine_state());
		dbc.setString(22, tbdatatiqudata.getDeny_cause());
		dbc.setInt(23, tbdatatiqudata.getTiqu_state());
		dbc.setInt(24, tbdatatiqudata.getExport_count());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbDataTiqudata tbdatatiqudata) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_data_tiqudata(`tiqu_num`,`ini_man`,`ini_dept`,`ini_org`,`ini_date`,`contact_num`,`contact_money`,`contact_start_date`,`contact_end_date`,`cust_name`,`brand`,`car`,`prov`,`city`,`data_count`,`data_start_date`,`data_end_date`,`is_agree_deduct`,`apply_cause`,`is_deduct`,`examine_state`,`deny_cause`,`tiqu_state`,`export_count`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setString(1, tbdatatiqudata.getTiqu_num());
		dbc.setString(2, tbdatatiqudata.getIni_man());
		dbc.setInt(3, tbdatatiqudata.getIni_dept());
		dbc.setInt(4, tbdatatiqudata.getIni_org());
		dbc.setTimestamp(5, new Timestamp(tbdatatiqudata.getIni_date().getTime()));
		dbc.setString(6, tbdatatiqudata.getContact_num());
		dbc.setString(7, tbdatatiqudata.getContact_money());
		dbc.setTimestamp(8, new Timestamp(tbdatatiqudata.getContact_start_date().getTime()));
		dbc.setTimestamp(9, new Timestamp(tbdatatiqudata.getContact_end_date().getTime()));
		dbc.setString(10, tbdatatiqudata.getCust_name());
		dbc.setInt(11, tbdatatiqudata.getBrand());
		dbc.setInt(12, tbdatatiqudata.getCar());
		dbc.setInt(13, tbdatatiqudata.getProv());
		dbc.setInt(14, tbdatatiqudata.getCity());
		dbc.setInt(15, tbdatatiqudata.getData_count());
		dbc.setTimestamp(16, new Timestamp(tbdatatiqudata.getData_start_date().getTime()));
		dbc.setTimestamp(17, new Timestamp(tbdatatiqudata.getData_end_date().getTime()));
		dbc.setInt(18, tbdatatiqudata.getIs_agree_deduct());
		dbc.setString(19, tbdatatiqudata.getApply_cause());
		dbc.setInt(20, tbdatatiqudata.getIs_deduct());
		dbc.setInt(21, tbdatatiqudata.getExamine_state());
		dbc.setString(22, tbdatatiqudata.getDeny_cause());
		dbc.setInt(23, tbdatatiqudata.getTiqu_state());
		dbc.setInt(24, tbdatatiqudata.getExport_count());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbDataTiqudata tbdatatiqudata) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_data_tiqudata set ");
		boolean flag = false;
		if(tbdatatiqudata.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",tiqu_num=?");
			}else{
				sb.append("tiqu_num=?");
				flag=true;
			}
		}
		if(tbdatatiqudata.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",ini_man=?");
			}else{
				sb.append("ini_man=?");
				flag=true;
			}
		}
		if(tbdatatiqudata.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",ini_dept=?");
			}else{
				sb.append("ini_dept=?");
				flag=true;
			}
		}
		if(tbdatatiqudata.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",ini_org=?");
			}else{
				sb.append("ini_org=?");
				flag=true;
			}
		}
		if(tbdatatiqudata.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",ini_date=?");
			}else{
				sb.append("ini_date=?");
				flag=true;
			}
		}
		if(tbdatatiqudata.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",contact_num=?");
			}else{
				sb.append("contact_num=?");
				flag=true;
			}
		}
		if(tbdatatiqudata.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",contact_money=?");
			}else{
				sb.append("contact_money=?");
				flag=true;
			}
		}
		if(tbdatatiqudata.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",contact_start_date=?");
			}else{
				sb.append("contact_start_date=?");
				flag=true;
			}
		}
		if(tbdatatiqudata.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",contact_end_date=?");
			}else{
				sb.append("contact_end_date=?");
				flag=true;
			}
		}
		if(tbdatatiqudata.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",cust_name=?");
			}else{
				sb.append("cust_name=?");
				flag=true;
			}
		}
		if(tbdatatiqudata.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",brand=?");
			}else{
				sb.append("brand=?");
				flag=true;
			}
		}
		if(tbdatatiqudata.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",car=?");
			}else{
				sb.append("car=?");
				flag=true;
			}
		}
		if(tbdatatiqudata.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",prov=?");
			}else{
				sb.append("prov=?");
				flag=true;
			}
		}
		if(tbdatatiqudata.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",city=?");
			}else{
				sb.append("city=?");
				flag=true;
			}
		}
		if(tbdatatiqudata.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",data_count=?");
			}else{
				sb.append("data_count=?");
				flag=true;
			}
		}
		if(tbdatatiqudata.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",data_start_date=?");
			}else{
				sb.append("data_start_date=?");
				flag=true;
			}
		}
		if(tbdatatiqudata.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",data_end_date=?");
			}else{
				sb.append("data_end_date=?");
				flag=true;
			}
		}
		if(tbdatatiqudata.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",is_agree_deduct=?");
			}else{
				sb.append("is_agree_deduct=?");
				flag=true;
			}
		}
		if(tbdatatiqudata.COLUMN_FLAG[18]){
			if(flag){
				sb.append(",apply_cause=?");
			}else{
				sb.append("apply_cause=?");
				flag=true;
			}
		}
		if(tbdatatiqudata.COLUMN_FLAG[19]){
			if(flag){
				sb.append(",is_deduct=?");
			}else{
				sb.append("is_deduct=?");
				flag=true;
			}
		}
		if(tbdatatiqudata.COLUMN_FLAG[20]){
			if(flag){
				sb.append(",examine_state=?");
			}else{
				sb.append("examine_state=?");
				flag=true;
			}
		}
		if(tbdatatiqudata.COLUMN_FLAG[21]){
			if(flag){
				sb.append(",deny_cause=?");
			}else{
				sb.append("deny_cause=?");
				flag=true;
			}
		}
		if(tbdatatiqudata.COLUMN_FLAG[22]){
			if(flag){
				sb.append(",tiqu_state=?");
			}else{
				sb.append("tiqu_state=?");
				flag=true;
			}
		}
		if(tbdatatiqudata.COLUMN_FLAG[23]){
			if(flag){
				sb.append(",export_count=?");
			}else{
				sb.append("export_count=?");
				flag=true;
			}
		}
		sb.append(" where tiqu_num=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbdatatiqudata.COLUMN_FLAG[0]){
			dbc.setString(k, tbdatatiqudata.getTiqu_num());k++;
		}
		if(tbdatatiqudata.COLUMN_FLAG[1]){
			dbc.setString(k, tbdatatiqudata.getIni_man());k++;
		}
		if(tbdatatiqudata.COLUMN_FLAG[2]){
			dbc.setInt(k, tbdatatiqudata.getIni_dept());k++;
		}
		if(tbdatatiqudata.COLUMN_FLAG[3]){
			dbc.setInt(k, tbdatatiqudata.getIni_org());k++;
		}
		if(tbdatatiqudata.COLUMN_FLAG[4]){
			dbc.setTimestamp(k, new Timestamp(tbdatatiqudata.getIni_date().getTime()));k++;
		}
		if(tbdatatiqudata.COLUMN_FLAG[5]){
			dbc.setString(k, tbdatatiqudata.getContact_num());k++;
		}
		if(tbdatatiqudata.COLUMN_FLAG[6]){
			dbc.setString(k, tbdatatiqudata.getContact_money());k++;
		}
		if(tbdatatiqudata.COLUMN_FLAG[7]){
			dbc.setTimestamp(k, new Timestamp(tbdatatiqudata.getContact_start_date().getTime()));k++;
		}
		if(tbdatatiqudata.COLUMN_FLAG[8]){
			dbc.setTimestamp(k, new Timestamp(tbdatatiqudata.getContact_end_date().getTime()));k++;
		}
		if(tbdatatiqudata.COLUMN_FLAG[9]){
			dbc.setString(k, tbdatatiqudata.getCust_name());k++;
		}
		if(tbdatatiqudata.COLUMN_FLAG[10]){
			dbc.setInt(k, tbdatatiqudata.getBrand());k++;
		}
		if(tbdatatiqudata.COLUMN_FLAG[11]){
			dbc.setInt(k, tbdatatiqudata.getCar());k++;
		}
		if(tbdatatiqudata.COLUMN_FLAG[12]){
			dbc.setInt(k, tbdatatiqudata.getProv());k++;
		}
		if(tbdatatiqudata.COLUMN_FLAG[13]){
			dbc.setInt(k, tbdatatiqudata.getCity());k++;
		}
		if(tbdatatiqudata.COLUMN_FLAG[14]){
			dbc.setInt(k, tbdatatiqudata.getData_count());k++;
		}
		if(tbdatatiqudata.COLUMN_FLAG[15]){
			dbc.setTimestamp(k, new Timestamp(tbdatatiqudata.getData_start_date().getTime()));k++;
		}
		if(tbdatatiqudata.COLUMN_FLAG[16]){
			dbc.setTimestamp(k, new Timestamp(tbdatatiqudata.getData_end_date().getTime()));k++;
		}
		if(tbdatatiqudata.COLUMN_FLAG[17]){
			dbc.setInt(k, tbdatatiqudata.getIs_agree_deduct());k++;
		}
		if(tbdatatiqudata.COLUMN_FLAG[18]){
			dbc.setString(k, tbdatatiqudata.getApply_cause());k++;
		}
		if(tbdatatiqudata.COLUMN_FLAG[19]){
			dbc.setInt(k, tbdatatiqudata.getIs_deduct());k++;
		}
		if(tbdatatiqudata.COLUMN_FLAG[20]){
			dbc.setInt(k, tbdatatiqudata.getExamine_state());k++;
		}
		if(tbdatatiqudata.COLUMN_FLAG[21]){
			dbc.setString(k, tbdatatiqudata.getDeny_cause());k++;
		}
		if(tbdatatiqudata.COLUMN_FLAG[22]){
			dbc.setInt(k, tbdatatiqudata.getTiqu_state());k++;
		}
		if(tbdatatiqudata.COLUMN_FLAG[23]){
			dbc.setInt(k, tbdatatiqudata.getExport_count());k++;
		}
		dbc.setString(k, tbdatatiqudata.getTiqu_num());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbDataTiqudata tbdatatiqudata) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbdatatiqudata);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}