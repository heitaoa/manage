package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbDataProject;

public class  TbDataProjectDao  extends BaseDao {

	public static void fill(ResultSet rs, TbDataProject tbdataproject) throws SQLException {
		tbdataproject.setPro_num(rs.getString("pro_num"));//项目编号
		tbdataproject.setIni_man(rs.getString("ini_man"));//发起人
		tbdataproject.setIni_dept(rs.getInt("ini_dept"));//发起部门
		tbdataproject.setIni_org(rs.getInt("ini_org"));//发起站点
		tbdataproject.setIni_date(rs.getTimestamp("ini_date"));//发起日期
		tbdataproject.setService_type(rs.getInt("service_type"));//业务类型(0-看车团，1-直销，2-车展，3-大客户,4-经销商,5-其他)
		tbdataproject.setContact_num(rs.getString("contact_num"));//关联合同号
		tbdataproject.setActi_name(rs.getString("acti_name"));//活动名称
		tbdataproject.setBrand(rs.getInt("brand"));//品牌
		tbdataproject.setCar(rs.getInt("car"));//车系
		tbdataproject.setModel(rs.getInt("model"));//车型
		tbdataproject.setPromo_area(rs.getString("promo_area"));//推广区域
		tbdataproject.setPromo_prov(rs.getInt("promo_prov"));//推广省份 -1 代表全国
		tbdataproject.setPromo_city(rs.getInt("promo_city"));//推广城市 -1代表该省份下所有城市
		tbdataproject.setPromo_man(rs.getString("promo_man"));//推广人
		tbdataproject.setPromo_start_date(rs.getTimestamp("promo_start_date"));//推广开始日期
		tbdataproject.setPromo_end_date(rs.getTimestamp("promo_end_date"));//推广结束日期
		tbdataproject.setContact_start_date(rs.getTimestamp("contact_start_date"));//合同开始日期
		tbdataproject.setContact_end_date(rs.getTimestamp("contact_end_date"));//合同结束日期
		tbdataproject.setActi_start_date(rs.getTimestamp("acti_start_date"));//活动开始日期
		tbdataproject.setCust_name(rs.getString("cust_name"));//客户名称
		tbdataproject.setTar_clue_num(rs.getInt("tar_clue_num"));//目标线索量
		tbdataproject.setTar_reach_num(rs.getInt("tar_reach_num"));//目标到达量
		tbdataproject.setTar_trans_num(rs.getInt("tar_trans_num"));//目标成交量
		tbdataproject.setCustom_service(rs.getString("custom_service"));//责任客服(用逗号隔开)
		tbdataproject.setPro_state(rs.getInt("pro_state"));//项目状态(0-未审核、1-业务通过、2-业务驳回、3-推广部通过、4-推广部驳回,5-已结束,100-品牌项目默认状态)
		tbdataproject.setActi_end_date(rs.getTimestamp("acti_end_date"));//活动结束时间
		tbdataproject.setCompeting(rs.getString("competing"));//竞品(品牌-车系，品牌-车系）
		tbdataproject.setData_source(rs.getString("data_source"));//经销商指定数据源（省a市a品牌a车系）用逗号隔开
		tbdataproject.setCustom_service_name(rs.getString("custom_service_name"));//客服姓名(逗号隔开)
		tbdataproject.setCompeting_name(rs.getString("competing_name"));//竞品名称(品牌-车系)逗号隔开
		tbdataproject.setData_source_name(rs.getString("data_source_name"));//数据源名称(逗号隔开)
		tbdataproject.setIway(rs.getString("iway"));//渠道
	}

	public static List<TbDataProject> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_data_project";
		List<TbDataProject> list = new ArrayList<TbDataProject>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataProject tbdataproject = new TbDataProject();
				fill(rs, tbdataproject);
				list.add(tbdataproject);
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


	public static List<TbDataProject> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_data_project where "+subsql+"";
		List<TbDataProject> list = new ArrayList<TbDataProject>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataProject tbdataproject = new TbDataProject();
				fill(rs, tbdataproject);
				list.add(tbdataproject);
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
		String sql = "select count(*) from tb_data_project where "+subsql+"";
		
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
		String sql = "delete from tb_data_project where "+subsql+"";
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
		String sql = "delete from tb_data_project where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbDataProject tbdataproject) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_data_project(`pro_num`,`ini_man`,`ini_dept`,`ini_org`,`ini_date`,`service_type`,`contact_num`,`acti_name`,`brand`,`car`,`model`,`promo_area`,`promo_prov`,`promo_city`,`promo_man`,`promo_start_date`,`promo_end_date`,`contact_start_date`,`contact_end_date`,`acti_start_date`,`cust_name`,`tar_clue_num`,`tar_reach_num`,`tar_trans_num`,`custom_service`,`pro_state`,`acti_end_date`,`competing`,`data_source`,`custom_service_name`,`competing_name`,`data_source_name`,`iway`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setString(1, tbdataproject.getPro_num());
		dbc.setString(2, tbdataproject.getIni_man());
		dbc.setInt(3, tbdataproject.getIni_dept());
		dbc.setInt(4, tbdataproject.getIni_org());
		dbc.setTimestamp(5, new Timestamp(tbdataproject.getIni_date().getTime()));
		dbc.setInt(6, tbdataproject.getService_type());
		dbc.setString(7, tbdataproject.getContact_num());
		dbc.setString(8, tbdataproject.getActi_name());
		dbc.setInt(9, tbdataproject.getBrand());
		dbc.setInt(10, tbdataproject.getCar());
		dbc.setInt(11, tbdataproject.getModel());
		dbc.setString(12, tbdataproject.getPromo_area());
		dbc.setInt(13, tbdataproject.getPromo_prov());
		dbc.setInt(14, tbdataproject.getPromo_city());
		dbc.setString(15, tbdataproject.getPromo_man());
		dbc.setTimestamp(16, new Timestamp(tbdataproject.getPromo_start_date().getTime()));
		dbc.setTimestamp(17, new Timestamp(tbdataproject.getPromo_end_date().getTime()));
		dbc.setTimestamp(18, new Timestamp(tbdataproject.getContact_start_date().getTime()));
		dbc.setTimestamp(19, new Timestamp(tbdataproject.getContact_end_date().getTime()));
		dbc.setTimestamp(20, new Timestamp(tbdataproject.getActi_start_date().getTime()));
		dbc.setString(21, tbdataproject.getCust_name());
		dbc.setInt(22, tbdataproject.getTar_clue_num());
		dbc.setInt(23, tbdataproject.getTar_reach_num());
		dbc.setInt(24, tbdataproject.getTar_trans_num());
		dbc.setString(25, tbdataproject.getCustom_service());
		dbc.setInt(26, tbdataproject.getPro_state());
		dbc.setTimestamp(27, new Timestamp(tbdataproject.getActi_end_date().getTime()));
		dbc.setString(28, tbdataproject.getCompeting());
		dbc.setString(29, tbdataproject.getData_source());
		dbc.setString(30, tbdataproject.getCustom_service_name());
		dbc.setString(31, tbdataproject.getCompeting_name());
		dbc.setString(32, tbdataproject.getData_source_name());
		dbc.setString(33, tbdataproject.getIway());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbDataProject tbdataproject) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_data_project(`pro_num`,`ini_man`,`ini_dept`,`ini_org`,`ini_date`,`service_type`,`contact_num`,`acti_name`,`brand`,`car`,`model`,`promo_area`,`promo_prov`,`promo_city`,`promo_man`,`promo_start_date`,`promo_end_date`,`contact_start_date`,`contact_end_date`,`acti_start_date`,`cust_name`,`tar_clue_num`,`tar_reach_num`,`tar_trans_num`,`custom_service`,`pro_state`,`acti_end_date`,`competing`,`data_source`,`custom_service_name`,`competing_name`,`data_source_name`,`iway`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setString(1, tbdataproject.getPro_num());
		dbc.setString(2, tbdataproject.getIni_man());
		dbc.setInt(3, tbdataproject.getIni_dept());
		dbc.setInt(4, tbdataproject.getIni_org());
		dbc.setTimestamp(5, new Timestamp(tbdataproject.getIni_date().getTime()));
		dbc.setInt(6, tbdataproject.getService_type());
		dbc.setString(7, tbdataproject.getContact_num());
		dbc.setString(8, tbdataproject.getActi_name());
		dbc.setInt(9, tbdataproject.getBrand());
		dbc.setInt(10, tbdataproject.getCar());
		dbc.setInt(11, tbdataproject.getModel());
		dbc.setString(12, tbdataproject.getPromo_area());
		dbc.setInt(13, tbdataproject.getPromo_prov());
		dbc.setInt(14, tbdataproject.getPromo_city());
		dbc.setString(15, tbdataproject.getPromo_man());
		dbc.setTimestamp(16, new Timestamp(tbdataproject.getPromo_start_date().getTime()));
		dbc.setTimestamp(17, new Timestamp(tbdataproject.getPromo_end_date().getTime()));
		dbc.setTimestamp(18, new Timestamp(tbdataproject.getContact_start_date().getTime()));
		dbc.setTimestamp(19, new Timestamp(tbdataproject.getContact_end_date().getTime()));
		dbc.setTimestamp(20, new Timestamp(tbdataproject.getActi_start_date().getTime()));
		dbc.setString(21, tbdataproject.getCust_name());
		dbc.setInt(22, tbdataproject.getTar_clue_num());
		dbc.setInt(23, tbdataproject.getTar_reach_num());
		dbc.setInt(24, tbdataproject.getTar_trans_num());
		dbc.setString(25, tbdataproject.getCustom_service());
		dbc.setInt(26, tbdataproject.getPro_state());
		dbc.setTimestamp(27, new Timestamp(tbdataproject.getActi_end_date().getTime()));
		dbc.setString(28, tbdataproject.getCompeting());
		dbc.setString(29, tbdataproject.getData_source());
		dbc.setString(30, tbdataproject.getCustom_service_name());
		dbc.setString(31, tbdataproject.getCompeting_name());
		dbc.setString(32, tbdataproject.getData_source_name());
		dbc.setString(33, tbdataproject.getIway());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbDataProject tbdataproject) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_data_project set ");
		boolean flag = false;
		if(tbdataproject.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",pro_num=?");
			}else{
				sb.append("pro_num=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",ini_man=?");
			}else{
				sb.append("ini_man=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",ini_dept=?");
			}else{
				sb.append("ini_dept=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",ini_org=?");
			}else{
				sb.append("ini_org=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",ini_date=?");
			}else{
				sb.append("ini_date=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",service_type=?");
			}else{
				sb.append("service_type=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",contact_num=?");
			}else{
				sb.append("contact_num=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",acti_name=?");
			}else{
				sb.append("acti_name=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",brand=?");
			}else{
				sb.append("brand=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",car=?");
			}else{
				sb.append("car=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",model=?");
			}else{
				sb.append("model=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",promo_area=?");
			}else{
				sb.append("promo_area=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",promo_prov=?");
			}else{
				sb.append("promo_prov=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",promo_city=?");
			}else{
				sb.append("promo_city=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",promo_man=?");
			}else{
				sb.append("promo_man=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",promo_start_date=?");
			}else{
				sb.append("promo_start_date=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",promo_end_date=?");
			}else{
				sb.append("promo_end_date=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",contact_start_date=?");
			}else{
				sb.append("contact_start_date=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[18]){
			if(flag){
				sb.append(",contact_end_date=?");
			}else{
				sb.append("contact_end_date=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[19]){
			if(flag){
				sb.append(",acti_start_date=?");
			}else{
				sb.append("acti_start_date=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[20]){
			if(flag){
				sb.append(",cust_name=?");
			}else{
				sb.append("cust_name=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[21]){
			if(flag){
				sb.append(",tar_clue_num=?");
			}else{
				sb.append("tar_clue_num=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[22]){
			if(flag){
				sb.append(",tar_reach_num=?");
			}else{
				sb.append("tar_reach_num=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[23]){
			if(flag){
				sb.append(",tar_trans_num=?");
			}else{
				sb.append("tar_trans_num=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[24]){
			if(flag){
				sb.append(",custom_service=?");
			}else{
				sb.append("custom_service=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[25]){
			if(flag){
				sb.append(",pro_state=?");
			}else{
				sb.append("pro_state=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[26]){
			if(flag){
				sb.append(",acti_end_date=?");
			}else{
				sb.append("acti_end_date=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[27]){
			if(flag){
				sb.append(",competing=?");
			}else{
				sb.append("competing=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[28]){
			if(flag){
				sb.append(",data_source=?");
			}else{
				sb.append("data_source=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[29]){
			if(flag){
				sb.append(",custom_service_name=?");
			}else{
				sb.append("custom_service_name=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[30]){
			if(flag){
				sb.append(",competing_name=?");
			}else{
				sb.append("competing_name=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[31]){
			if(flag){
				sb.append(",data_source_name=?");
			}else{
				sb.append("data_source_name=?");
				flag=true;
			}
		}
		if(tbdataproject.COLUMN_FLAG[32]){
			if(flag){
				sb.append(",iway=?");
			}else{
				sb.append("iway=?");
				flag=true;
			}
		}
		sb.append(" where pro_num=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbdataproject.COLUMN_FLAG[0]){
			dbc.setString(k, tbdataproject.getPro_num());k++;
		}
		if(tbdataproject.COLUMN_FLAG[1]){
			dbc.setString(k, tbdataproject.getIni_man());k++;
		}
		if(tbdataproject.COLUMN_FLAG[2]){
			dbc.setInt(k, tbdataproject.getIni_dept());k++;
		}
		if(tbdataproject.COLUMN_FLAG[3]){
			dbc.setInt(k, tbdataproject.getIni_org());k++;
		}
		if(tbdataproject.COLUMN_FLAG[4]){
			dbc.setTimestamp(k, new Timestamp(tbdataproject.getIni_date().getTime()));k++;
		}
		if(tbdataproject.COLUMN_FLAG[5]){
			dbc.setInt(k, tbdataproject.getService_type());k++;
		}
		if(tbdataproject.COLUMN_FLAG[6]){
			dbc.setString(k, tbdataproject.getContact_num());k++;
		}
		if(tbdataproject.COLUMN_FLAG[7]){
			dbc.setString(k, tbdataproject.getActi_name());k++;
		}
		if(tbdataproject.COLUMN_FLAG[8]){
			dbc.setInt(k, tbdataproject.getBrand());k++;
		}
		if(tbdataproject.COLUMN_FLAG[9]){
			dbc.setInt(k, tbdataproject.getCar());k++;
		}
		if(tbdataproject.COLUMN_FLAG[10]){
			dbc.setInt(k, tbdataproject.getModel());k++;
		}
		if(tbdataproject.COLUMN_FLAG[11]){
			dbc.setString(k, tbdataproject.getPromo_area());k++;
		}
		if(tbdataproject.COLUMN_FLAG[12]){
			dbc.setInt(k, tbdataproject.getPromo_prov());k++;
		}
		if(tbdataproject.COLUMN_FLAG[13]){
			dbc.setInt(k, tbdataproject.getPromo_city());k++;
		}
		if(tbdataproject.COLUMN_FLAG[14]){
			dbc.setString(k, tbdataproject.getPromo_man());k++;
		}
		if(tbdataproject.COLUMN_FLAG[15]){
			dbc.setTimestamp(k, new Timestamp(tbdataproject.getPromo_start_date().getTime()));k++;
		}
		if(tbdataproject.COLUMN_FLAG[16]){
			dbc.setTimestamp(k, new Timestamp(tbdataproject.getPromo_end_date().getTime()));k++;
		}
		if(tbdataproject.COLUMN_FLAG[17]){
			dbc.setTimestamp(k, new Timestamp(tbdataproject.getContact_start_date().getTime()));k++;
		}
		if(tbdataproject.COLUMN_FLAG[18]){
			dbc.setTimestamp(k, new Timestamp(tbdataproject.getContact_end_date().getTime()));k++;
		}
		if(tbdataproject.COLUMN_FLAG[19]){
			dbc.setTimestamp(k, new Timestamp(tbdataproject.getActi_start_date().getTime()));k++;
		}
		if(tbdataproject.COLUMN_FLAG[20]){
			dbc.setString(k, tbdataproject.getCust_name());k++;
		}
		if(tbdataproject.COLUMN_FLAG[21]){
			dbc.setInt(k, tbdataproject.getTar_clue_num());k++;
		}
		if(tbdataproject.COLUMN_FLAG[22]){
			dbc.setInt(k, tbdataproject.getTar_reach_num());k++;
		}
		if(tbdataproject.COLUMN_FLAG[23]){
			dbc.setInt(k, tbdataproject.getTar_trans_num());k++;
		}
		if(tbdataproject.COLUMN_FLAG[24]){
			dbc.setString(k, tbdataproject.getCustom_service());k++;
		}
		if(tbdataproject.COLUMN_FLAG[25]){
			dbc.setInt(k, tbdataproject.getPro_state());k++;
		}
		if(tbdataproject.COLUMN_FLAG[26]){
			dbc.setTimestamp(k, new Timestamp(tbdataproject.getActi_end_date().getTime()));k++;
		}
		if(tbdataproject.COLUMN_FLAG[27]){
			dbc.setString(k, tbdataproject.getCompeting());k++;
		}
		if(tbdataproject.COLUMN_FLAG[28]){
			dbc.setString(k, tbdataproject.getData_source());k++;
		}
		if(tbdataproject.COLUMN_FLAG[29]){
			dbc.setString(k, tbdataproject.getCustom_service_name());k++;
		}
		if(tbdataproject.COLUMN_FLAG[30]){
			dbc.setString(k, tbdataproject.getCompeting_name());k++;
		}
		if(tbdataproject.COLUMN_FLAG[31]){
			dbc.setString(k, tbdataproject.getData_source_name());k++;
		}
		if(tbdataproject.COLUMN_FLAG[32]){
			dbc.setString(k, tbdataproject.getIway());k++;
		}
		dbc.setString(k, tbdataproject.getPro_num());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbDataProject tbdataproject) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbdataproject);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}