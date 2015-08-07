package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbDataProjectBl;

public class  TbDataProjectBlDao  extends BaseDao {

	public static void fill(ResultSet rs, TbDataProjectBl tbdataprojectbl) throws SQLException {
		tbdataprojectbl.setPro_num(rs.getString("pro_num"));//项目编号
		tbdataprojectbl.setIni_man(rs.getString("ini_man"));//发起人
		tbdataprojectbl.setIni_dept(rs.getInt("ini_dept"));//发起部门
		tbdataprojectbl.setIni_org(rs.getInt("ini_org"));//发起站点
		tbdataprojectbl.setIni_date(rs.getTimestamp("ini_date"));//发起日期
		tbdataprojectbl.setService_type(rs.getInt("service_type"));//业务类型(0-看车团，1-直销，2-车展，3-大客户,4-经销商)
		tbdataprojectbl.setContact_num(rs.getString("contact_num"));//关联合同号
		tbdataprojectbl.setActi_name(rs.getString("acti_name"));//活动名称
		tbdataprojectbl.setBrand(rs.getInt("brand"));//品牌
		tbdataprojectbl.setCar(rs.getInt("car"));//车系
		tbdataprojectbl.setModel(rs.getInt("model"));//车型
		tbdataprojectbl.setPromo_area(rs.getString("promo_area"));//推广区域
		tbdataprojectbl.setPromo_prov(rs.getInt("promo_prov"));//推广省份 -1 代表全国
		tbdataprojectbl.setPromo_city(rs.getInt("promo_city"));//推广城市 -1代表该省份下所有城市
		tbdataprojectbl.setPromo_man(rs.getString("promo_man"));//推广人
		tbdataprojectbl.setPromo_start_date(rs.getTimestamp("promo_start_date"));//推广开始日期
		tbdataprojectbl.setPromo_end_date(rs.getTimestamp("promo_end_date"));//推广结束日期
		tbdataprojectbl.setContact_start_date(rs.getTimestamp("contact_start_date"));//合同开始日期
		tbdataprojectbl.setContact_end_date(rs.getTimestamp("contact_end_date"));//合同结束日期
		tbdataprojectbl.setActi_start_date(rs.getTimestamp("acti_start_date"));//活动开始日期
		tbdataprojectbl.setCust_name(rs.getString("cust_name"));//客户名称
		tbdataprojectbl.setTar_clue_num(rs.getInt("tar_clue_num"));//目标线索量
		tbdataprojectbl.setTar_reach_num(rs.getInt("tar_reach_num"));//目标到达量
		tbdataprojectbl.setTar_trans_num(rs.getInt("tar_trans_num"));//目标成交量
		tbdataprojectbl.setCustom_service(rs.getString("custom_service"));//责任客服(用逗号隔开)
		tbdataprojectbl.setPro_state(rs.getInt("pro_state"));//项目状态(0-未审核、1-业务通过、2-业务驳回、3-推广部通过、4-推广部驳回,5-已结束)
		tbdataprojectbl.setActi_end_date(rs.getTimestamp("acti_end_date"));//活动结束时间
		tbdataprojectbl.setCompeting(rs.getString("competing"));//竞品(品牌-车系，品牌-车系）
		tbdataprojectbl.setData_source(rs.getString("data_source"));//经销商指定数据源（省a市a品牌a车系）用逗号隔开
		tbdataprojectbl.setCustom_service_name(rs.getString("custom_service_name"));//客服姓名(逗号隔开)
		tbdataprojectbl.setCompeting_name(rs.getString("competing_name"));//竞品名称(品牌-车系)逗号隔开
		tbdataprojectbl.setData_source_name(rs.getString("data_source_name"));//数据源名称(逗号隔开)
		tbdataprojectbl.setIway(rs.getString("iway"));//渠道
	}

	public static List<TbDataProjectBl> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_data_project_bl";
		List<TbDataProjectBl> list = new ArrayList<TbDataProjectBl>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataProjectBl tbdataprojectbl = new TbDataProjectBl();
				fill(rs, tbdataprojectbl);
				list.add(tbdataprojectbl);
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


	public static List<TbDataProjectBl> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_data_project_bl where "+subsql+"";
		List<TbDataProjectBl> list = new ArrayList<TbDataProjectBl>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataProjectBl tbdataprojectbl = new TbDataProjectBl();
				fill(rs, tbdataprojectbl);
				list.add(tbdataprojectbl);
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
		String sql = "select count(*) from tb_data_project_bl where "+subsql+"";
		
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
		String sql = "delete from tb_data_project_bl where "+subsql+"";
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
		String sql = "delete from tb_data_project_bl where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbDataProjectBl tbdataprojectbl) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_data_project_bl(`pro_num`,`ini_man`,`ini_dept`,`ini_org`,`ini_date`,`service_type`,`contact_num`,`acti_name`,`brand`,`car`,`model`,`promo_area`,`promo_prov`,`promo_city`,`promo_man`,`promo_start_date`,`promo_end_date`,`contact_start_date`,`contact_end_date`,`acti_start_date`,`cust_name`,`tar_clue_num`,`tar_reach_num`,`tar_trans_num`,`custom_service`,`pro_state`,`acti_end_date`,`competing`,`data_source`,`custom_service_name`,`competing_name`,`data_source_name`,`iway`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setString(1, tbdataprojectbl.getPro_num());
		dbc.setString(2, tbdataprojectbl.getIni_man());
		dbc.setInt(3, tbdataprojectbl.getIni_dept());
		dbc.setInt(4, tbdataprojectbl.getIni_org());
		dbc.setTimestamp(5, new Timestamp(tbdataprojectbl.getIni_date().getTime()));
		dbc.setInt(6, tbdataprojectbl.getService_type());
		dbc.setString(7, tbdataprojectbl.getContact_num());
		dbc.setString(8, tbdataprojectbl.getActi_name());
		dbc.setInt(9, tbdataprojectbl.getBrand());
		dbc.setInt(10, tbdataprojectbl.getCar());
		dbc.setInt(11, tbdataprojectbl.getModel());
		dbc.setString(12, tbdataprojectbl.getPromo_area());
		dbc.setInt(13, tbdataprojectbl.getPromo_prov());
		dbc.setInt(14, tbdataprojectbl.getPromo_city());
		dbc.setString(15, tbdataprojectbl.getPromo_man());
		dbc.setTimestamp(16, new Timestamp(tbdataprojectbl.getPromo_start_date().getTime()));
		dbc.setTimestamp(17, new Timestamp(tbdataprojectbl.getPromo_end_date().getTime()));
		dbc.setTimestamp(18, new Timestamp(tbdataprojectbl.getContact_start_date().getTime()));
		dbc.setTimestamp(19, new Timestamp(tbdataprojectbl.getContact_end_date().getTime()));
		dbc.setTimestamp(20, new Timestamp(tbdataprojectbl.getActi_start_date().getTime()));
		dbc.setString(21, tbdataprojectbl.getCust_name());
		dbc.setInt(22, tbdataprojectbl.getTar_clue_num());
		dbc.setInt(23, tbdataprojectbl.getTar_reach_num());
		dbc.setInt(24, tbdataprojectbl.getTar_trans_num());
		dbc.setString(25, tbdataprojectbl.getCustom_service());
		dbc.setInt(26, tbdataprojectbl.getPro_state());
		dbc.setTimestamp(27, new Timestamp(tbdataprojectbl.getActi_end_date().getTime()));
		dbc.setString(28, tbdataprojectbl.getCompeting());
		dbc.setString(29, tbdataprojectbl.getData_source());
		dbc.setString(30, tbdataprojectbl.getCustom_service_name());
		dbc.setString(31, tbdataprojectbl.getCompeting_name());
		dbc.setString(32, tbdataprojectbl.getData_source_name());
		dbc.setString(33, tbdataprojectbl.getIway());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbDataProjectBl tbdataprojectbl) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_data_project_bl(`pro_num`,`ini_man`,`ini_dept`,`ini_org`,`ini_date`,`service_type`,`contact_num`,`acti_name`,`brand`,`car`,`model`,`promo_area`,`promo_prov`,`promo_city`,`promo_man`,`promo_start_date`,`promo_end_date`,`contact_start_date`,`contact_end_date`,`acti_start_date`,`cust_name`,`tar_clue_num`,`tar_reach_num`,`tar_trans_num`,`custom_service`,`pro_state`,`acti_end_date`,`competing`,`data_source`,`custom_service_name`,`competing_name`,`data_source_name`,`iway`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setString(1, tbdataprojectbl.getPro_num());
		dbc.setString(2, tbdataprojectbl.getIni_man());
		dbc.setInt(3, tbdataprojectbl.getIni_dept());
		dbc.setInt(4, tbdataprojectbl.getIni_org());
		dbc.setTimestamp(5, new Timestamp(tbdataprojectbl.getIni_date().getTime()));
		dbc.setInt(6, tbdataprojectbl.getService_type());
		dbc.setString(7, tbdataprojectbl.getContact_num());
		dbc.setString(8, tbdataprojectbl.getActi_name());
		dbc.setInt(9, tbdataprojectbl.getBrand());
		dbc.setInt(10, tbdataprojectbl.getCar());
		dbc.setInt(11, tbdataprojectbl.getModel());
		dbc.setString(12, tbdataprojectbl.getPromo_area());
		dbc.setInt(13, tbdataprojectbl.getPromo_prov());
		dbc.setInt(14, tbdataprojectbl.getPromo_city());
		dbc.setString(15, tbdataprojectbl.getPromo_man());
		dbc.setTimestamp(16, new Timestamp(tbdataprojectbl.getPromo_start_date().getTime()));
		dbc.setTimestamp(17, new Timestamp(tbdataprojectbl.getPromo_end_date().getTime()));
		dbc.setTimestamp(18, new Timestamp(tbdataprojectbl.getContact_start_date().getTime()));
		dbc.setTimestamp(19, new Timestamp(tbdataprojectbl.getContact_end_date().getTime()));
		dbc.setTimestamp(20, new Timestamp(tbdataprojectbl.getActi_start_date().getTime()));
		dbc.setString(21, tbdataprojectbl.getCust_name());
		dbc.setInt(22, tbdataprojectbl.getTar_clue_num());
		dbc.setInt(23, tbdataprojectbl.getTar_reach_num());
		dbc.setInt(24, tbdataprojectbl.getTar_trans_num());
		dbc.setString(25, tbdataprojectbl.getCustom_service());
		dbc.setInt(26, tbdataprojectbl.getPro_state());
		dbc.setTimestamp(27, new Timestamp(tbdataprojectbl.getActi_end_date().getTime()));
		dbc.setString(28, tbdataprojectbl.getCompeting());
		dbc.setString(29, tbdataprojectbl.getData_source());
		dbc.setString(30, tbdataprojectbl.getCustom_service_name());
		dbc.setString(31, tbdataprojectbl.getCompeting_name());
		dbc.setString(32, tbdataprojectbl.getData_source_name());
		dbc.setString(33, tbdataprojectbl.getIway());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbDataProjectBl tbdataprojectbl) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_data_project_bl set ");
		boolean flag = false;
		if(tbdataprojectbl.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",pro_num=?");
			}else{
				sb.append("pro_num=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",ini_man=?");
			}else{
				sb.append("ini_man=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",ini_dept=?");
			}else{
				sb.append("ini_dept=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",ini_org=?");
			}else{
				sb.append("ini_org=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",ini_date=?");
			}else{
				sb.append("ini_date=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",service_type=?");
			}else{
				sb.append("service_type=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",contact_num=?");
			}else{
				sb.append("contact_num=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",acti_name=?");
			}else{
				sb.append("acti_name=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",brand=?");
			}else{
				sb.append("brand=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",car=?");
			}else{
				sb.append("car=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",model=?");
			}else{
				sb.append("model=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",promo_area=?");
			}else{
				sb.append("promo_area=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",promo_prov=?");
			}else{
				sb.append("promo_prov=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",promo_city=?");
			}else{
				sb.append("promo_city=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",promo_man=?");
			}else{
				sb.append("promo_man=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",promo_start_date=?");
			}else{
				sb.append("promo_start_date=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",promo_end_date=?");
			}else{
				sb.append("promo_end_date=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",contact_start_date=?");
			}else{
				sb.append("contact_start_date=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[18]){
			if(flag){
				sb.append(",contact_end_date=?");
			}else{
				sb.append("contact_end_date=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[19]){
			if(flag){
				sb.append(",acti_start_date=?");
			}else{
				sb.append("acti_start_date=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[20]){
			if(flag){
				sb.append(",cust_name=?");
			}else{
				sb.append("cust_name=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[21]){
			if(flag){
				sb.append(",tar_clue_num=?");
			}else{
				sb.append("tar_clue_num=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[22]){
			if(flag){
				sb.append(",tar_reach_num=?");
			}else{
				sb.append("tar_reach_num=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[23]){
			if(flag){
				sb.append(",tar_trans_num=?");
			}else{
				sb.append("tar_trans_num=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[24]){
			if(flag){
				sb.append(",custom_service=?");
			}else{
				sb.append("custom_service=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[25]){
			if(flag){
				sb.append(",pro_state=?");
			}else{
				sb.append("pro_state=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[26]){
			if(flag){
				sb.append(",acti_end_date=?");
			}else{
				sb.append("acti_end_date=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[27]){
			if(flag){
				sb.append(",competing=?");
			}else{
				sb.append("competing=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[28]){
			if(flag){
				sb.append(",data_source=?");
			}else{
				sb.append("data_source=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[29]){
			if(flag){
				sb.append(",custom_service_name=?");
			}else{
				sb.append("custom_service_name=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[30]){
			if(flag){
				sb.append(",competing_name=?");
			}else{
				sb.append("competing_name=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[31]){
			if(flag){
				sb.append(",data_source_name=?");
			}else{
				sb.append("data_source_name=?");
				flag=true;
			}
		}
		if(tbdataprojectbl.COLUMN_FLAG[32]){
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
		if(tbdataprojectbl.COLUMN_FLAG[0]){
			dbc.setString(k, tbdataprojectbl.getPro_num());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[1]){
			dbc.setString(k, tbdataprojectbl.getIni_man());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[2]){
			dbc.setInt(k, tbdataprojectbl.getIni_dept());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[3]){
			dbc.setInt(k, tbdataprojectbl.getIni_org());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[4]){
			dbc.setTimestamp(k, new Timestamp(tbdataprojectbl.getIni_date().getTime()));k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[5]){
			dbc.setInt(k, tbdataprojectbl.getService_type());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[6]){
			dbc.setString(k, tbdataprojectbl.getContact_num());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[7]){
			dbc.setString(k, tbdataprojectbl.getActi_name());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[8]){
			dbc.setInt(k, tbdataprojectbl.getBrand());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[9]){
			dbc.setInt(k, tbdataprojectbl.getCar());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[10]){
			dbc.setInt(k, tbdataprojectbl.getModel());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[11]){
			dbc.setString(k, tbdataprojectbl.getPromo_area());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[12]){
			dbc.setInt(k, tbdataprojectbl.getPromo_prov());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[13]){
			dbc.setInt(k, tbdataprojectbl.getPromo_city());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[14]){
			dbc.setString(k, tbdataprojectbl.getPromo_man());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[15]){
			dbc.setTimestamp(k, new Timestamp(tbdataprojectbl.getPromo_start_date().getTime()));k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[16]){
			dbc.setTimestamp(k, new Timestamp(tbdataprojectbl.getPromo_end_date().getTime()));k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[17]){
			dbc.setTimestamp(k, new Timestamp(tbdataprojectbl.getContact_start_date().getTime()));k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[18]){
			dbc.setTimestamp(k, new Timestamp(tbdataprojectbl.getContact_end_date().getTime()));k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[19]){
			dbc.setTimestamp(k, new Timestamp(tbdataprojectbl.getActi_start_date().getTime()));k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[20]){
			dbc.setString(k, tbdataprojectbl.getCust_name());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[21]){
			dbc.setInt(k, tbdataprojectbl.getTar_clue_num());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[22]){
			dbc.setInt(k, tbdataprojectbl.getTar_reach_num());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[23]){
			dbc.setInt(k, tbdataprojectbl.getTar_trans_num());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[24]){
			dbc.setString(k, tbdataprojectbl.getCustom_service());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[25]){
			dbc.setInt(k, tbdataprojectbl.getPro_state());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[26]){
			dbc.setTimestamp(k, new Timestamp(tbdataprojectbl.getActi_end_date().getTime()));k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[27]){
			dbc.setString(k, tbdataprojectbl.getCompeting());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[28]){
			dbc.setString(k, tbdataprojectbl.getData_source());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[29]){
			dbc.setString(k, tbdataprojectbl.getCustom_service_name());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[30]){
			dbc.setString(k, tbdataprojectbl.getCompeting_name());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[31]){
			dbc.setString(k, tbdataprojectbl.getData_source_name());k++;
		}
		if(tbdataprojectbl.COLUMN_FLAG[32]){
			dbc.setString(k, tbdataprojectbl.getIway());k++;
		}
		dbc.setString(k, tbdataprojectbl.getPro_num());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbDataProjectBl tbdataprojectbl) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbdataprojectbl);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}