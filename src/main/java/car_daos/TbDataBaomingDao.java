package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbDataBaoming;

public class  TbDataBaomingDao  extends BaseDao {

	public static void fill(ResultSet rs, TbDataBaoming tbdatabaoming) throws SQLException {
		tbdatabaoming.setId(rs.getInt("id"));//
		tbdatabaoming.setName(rs.getString("name"));//用户姓名
		tbdatabaoming.setPhone(rs.getString("phone"));//用户手机
		tbdatabaoming.setType(rs.getInt("type"));//报名类型 0-看车团 1-直销 2-车展 3-大客户
		tbdatabaoming.setBrand(rs.getInt("brand"));//品牌id
		tbdatabaoming.setSerial(rs.getInt("serial"));//报名车系id
		tbdatabaoming.setModel(rs.getInt("model"));//车型id
		tbdatabaoming.setProv(rs.getInt("prov"));//报名省份
		tbdatabaoming.setCity(rs.getInt("city"));//报名城市
		tbdatabaoming.setIs_reach(rs.getInt("is_reach"));//是否到店
		tbdatabaoming.setIs_trans(rs.getInt("is_trans"));//是否成交
		tbdatabaoming.setIs_invite(rs.getInt("is_invite"));// 是否小胖邀约
		tbdatabaoming.setBaoming_date(rs.getTimestamp("baoming_date"));//报名时间
		tbdatabaoming.setCar_info(rs.getString("car_info"));//报名备注信息
		tbdatabaoming.setPhone_prov(rs.getInt("phone_prov"));//手机省
		tbdatabaoming.setPhone_city(rs.getInt("phone_city"));//手机市
		tbdatabaoming.setIp(rs.getString("ip"));//ip地址
		tbdatabaoming.setReturn_visit_state(rs.getInt("return_visit_state"));//回访状态 0-未回访 1-一呼 2-二呼 3-三呼 4- 其他
		tbdatabaoming.setBuycar_emergency(rs.getInt("buycar_emergency"));//0-未知 1-本周 2-2周内 3-一个月内 4-3个月内 5-3个月以上 6 -随时
		tbdatabaoming.setIs_key_cus(rs.getInt("is_key_cus"));//客户类型 0-普通客户 1-重点客户
		tbdatabaoming.setPhoneerror(rs.getInt("phoneerror"));//电话能否接通  0-已接通 1-未接通
		tbdatabaoming.setReturn_visit_time(rs.getTimestamp("return_visit_time"));//回访时间
		tbdatabaoming.setReturn_visit_content(rs.getString("return_visit_content"));//回访内容
		tbdatabaoming.setRemarks(rs.getString("remarks"));//回访历史
		tbdatabaoming.setReturn_visit_man(rs.getString("return_visit_man"));//回访人姓名
		tbdatabaoming.setReturn_visit_id(rs.getString("return_visit_id"));//回访人工号
		tbdatabaoming.setTuisong_flag(rs.getInt("tuisong_flag"));//是否推送 0- 未推送 1- 已推送
		tbdatabaoming.setIsdelete(rs.getInt("isdelete"));//是否删除 0-未删除 1-已删除
		tbdatabaoming.setAttend_type(rs.getInt("attend_type"));//参团方式 1-参加，跟团到 2-参加，自行到 3-参加，不确定 4-可能参加 5-不参加
		tbdatabaoming.setAttend_date(rs.getString("attend_date"));//参团日期
		tbdatabaoming.setPp_state(rs.getString("pp_state"));//拍牌状态
		tbdatabaoming.setPz_city(rs.getString("pz_city"));//拍照城市
		tbdatabaoming.setPhone_state(rs.getInt("phone_state"));//手机状态 0-有效 1-无效 2-重复报名
		tbdatabaoming.setIs_jp(rs.getInt("is_jp"));//是否有竞品  0-否 1-是
		tbdatabaoming.setJp_car(rs.getString("jp_car"));//竞品车系
		tbdatabaoming.setIs_buycar(rs.getInt("is_buycar"));//是否购车 0-否 1-是
		tbdatabaoming.setBuy_state(rs.getInt("buy_state"));//购车情况 0-新车全款 1-新车贷款 2-置换全款 3-增购贷款
		tbdatabaoming.setBuy_ys(rs.getString("buy_ys"));//购车预算
		tbdatabaoming.setBuy_bsx(rs.getInt("buy_bsx"));//变速箱 0-自动 1-手动 2-不限
		tbdatabaoming.setBuy_pl(rs.getString("buy_pl"));//排量
		tbdatabaoming.setBuy_color(rs.getString("buy_color"));//颜色
		tbdatabaoming.setKnow_yh(rs.getString("know_yh"));//4s了解优惠
		tbdatabaoming.setP_job(rs.getInt("p_job"));//职业 0-国企 1-私企 2-个体
		tbdatabaoming.setP_weixin(rs.getString("p_weixin"));//微信
		tbdatabaoming.setP_qq(rs.getString("p_qq"));//qq
		tbdatabaoming.setPhoneerror_count(rs.getInt("phoneerror_count"));//电话未接听次数
		tbdatabaoming.setArea(rs.getInt("area"));//区域
		tbdatabaoming.setReal_type(rs.getInt("real_type"));//报名真正渠道 0-车团pc，1-车团手机，4-tuan.315che.com-pc（百度）,5-taun.315che.com-mobile(百度)，6-315chepc,8-315che手机，7-suncarspc,10-suncars手机，11-专题页报名，9-合作媒体，11-专题页报名,13-合作网站，14-合作app，18-购车节专题，19-车展自行访客',20-合作渠道
		tbdatabaoming.setConstacterror(rs.getInt("constacterror"));//0-已沟通 1-未沟通
		tbdatabaoming.setConstacterror_count(rs.getInt("constacterror_count"));//未沟通次数
		tbdatabaoming.setOldid(rs.getInt("oldid"));//
		tbdatabaoming.setSub_site(rs.getInt("sub_site"));//所属分站
		tbdatabaoming.setIs_sample(rs.getInt("is_sample"));//抽查标志
		tbdatabaoming.setSample_man_id(rs.getString("sample_man_id"));//抽查人工号
		tbdatabaoming.setSample_man_name(rs.getString("sample_man_name"));//抽查人姓名
		tbdatabaoming.setSample_time(rs.getTimestamp("sample_time"));//抽查时间
		tbdatabaoming.setSample_content(rs.getString("sample_content"));//抽查内容
		tbdatabaoming.setType_remark(rs.getString("type_remark"));//渠道类型备注
		tbdatabaoming.setCzname(rs.getString("czname"));//车展活动名称
	}

	public static List<TbDataBaoming> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_data_baoming";
		List<TbDataBaoming> list = new ArrayList<TbDataBaoming>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataBaoming tbdatabaoming = new TbDataBaoming();
				fill(rs, tbdatabaoming);
				list.add(tbdatabaoming);
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


	public static List<TbDataBaoming> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_data_baoming where "+subsql+"";
		List<TbDataBaoming> list = new ArrayList<TbDataBaoming>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataBaoming tbdatabaoming = new TbDataBaoming();
				fill(rs, tbdatabaoming);
				list.add(tbdatabaoming);
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
		String sql = "select count(*) from tb_data_baoming where "+subsql+"";
		
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
		String sql = "delete from tb_data_baoming where "+subsql+"";
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
		String sql = "delete from tb_data_baoming where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbDataBaoming tbdatabaoming) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_data_baoming(`id`,`name`,`phone`,`type`,`brand`,`serial`,`model`,`prov`,`city`,`is_reach`,`is_trans`,`is_invite`,`baoming_date`,`car_info`,`phone_prov`,`phone_city`,`ip`,`return_visit_state`,`buycar_emergency`,`is_key_cus`,`phoneerror`,`return_visit_time`,`return_visit_content`,`remarks`,`return_visit_man`,`return_visit_id`,`tuisong_flag`,`isdelete`,`attend_type`,`attend_date`,`pp_state`,`pz_city`,`phone_state`,`is_jp`,`jp_car`,`is_buycar`,`buy_state`,`buy_ys`,`buy_bsx`,`buy_pl`,`buy_color`,`know_yh`,`p_job`,`p_weixin`,`p_qq`,`phoneerror_count`,`area`,`real_type`,`constacterror`,`constacterror_count`,`oldid`,`sub_site`,`is_sample`,`sample_man_id`,`sample_man_name`,`sample_time`,`sample_content`,`type_remark`,`czname`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdatabaoming.getId());
		dbc.setString(2, tbdatabaoming.getName());
		dbc.setString(3, tbdatabaoming.getPhone());
		dbc.setInt(4, tbdatabaoming.getType());
		dbc.setInt(5, tbdatabaoming.getBrand());
		dbc.setInt(6, tbdatabaoming.getSerial());
		dbc.setInt(7, tbdatabaoming.getModel());
		dbc.setInt(8, tbdatabaoming.getProv());
		dbc.setInt(9, tbdatabaoming.getCity());
		dbc.setInt(10, tbdatabaoming.getIs_reach());
		dbc.setInt(11, tbdatabaoming.getIs_trans());
		dbc.setInt(12, tbdatabaoming.getIs_invite());
		dbc.setTimestamp(13, new Timestamp(tbdatabaoming.getBaoming_date().getTime()));
		dbc.setString(14, tbdatabaoming.getCar_info());
		dbc.setInt(15, tbdatabaoming.getPhone_prov());
		dbc.setInt(16, tbdatabaoming.getPhone_city());
		dbc.setString(17, tbdatabaoming.getIp());
		dbc.setInt(18, tbdatabaoming.getReturn_visit_state());
		dbc.setInt(19, tbdatabaoming.getBuycar_emergency());
		dbc.setInt(20, tbdatabaoming.getIs_key_cus());
		dbc.setInt(21, tbdatabaoming.getPhoneerror());
		dbc.setTimestamp(22, new Timestamp(tbdatabaoming.getReturn_visit_time().getTime()));
		dbc.setString(23, tbdatabaoming.getReturn_visit_content());
		dbc.setString(24, tbdatabaoming.getRemarks());
		dbc.setString(25, tbdatabaoming.getReturn_visit_man());
		dbc.setString(26, tbdatabaoming.getReturn_visit_id());
		dbc.setInt(27, tbdatabaoming.getTuisong_flag());
		dbc.setInt(28, tbdatabaoming.getIsdelete());
		dbc.setInt(29, tbdatabaoming.getAttend_type());
		dbc.setString(30, tbdatabaoming.getAttend_date());
		dbc.setString(31, tbdatabaoming.getPp_state());
		dbc.setString(32, tbdatabaoming.getPz_city());
		dbc.setInt(33, tbdatabaoming.getPhone_state());
		dbc.setInt(34, tbdatabaoming.getIs_jp());
		dbc.setString(35, tbdatabaoming.getJp_car());
		dbc.setInt(36, tbdatabaoming.getIs_buycar());
		dbc.setInt(37, tbdatabaoming.getBuy_state());
		dbc.setString(38, tbdatabaoming.getBuy_ys());
		dbc.setInt(39, tbdatabaoming.getBuy_bsx());
		dbc.setString(40, tbdatabaoming.getBuy_pl());
		dbc.setString(41, tbdatabaoming.getBuy_color());
		dbc.setString(42, tbdatabaoming.getKnow_yh());
		dbc.setInt(43, tbdatabaoming.getP_job());
		dbc.setString(44, tbdatabaoming.getP_weixin());
		dbc.setString(45, tbdatabaoming.getP_qq());
		dbc.setInt(46, tbdatabaoming.getPhoneerror_count());
		dbc.setInt(47, tbdatabaoming.getArea());
		dbc.setInt(48, tbdatabaoming.getReal_type());
		dbc.setInt(49, tbdatabaoming.getConstacterror());
		dbc.setInt(50, tbdatabaoming.getConstacterror_count());
		dbc.setInt(51, tbdatabaoming.getOldid());
		dbc.setInt(52, tbdatabaoming.getSub_site());
		dbc.setInt(53, tbdatabaoming.getIs_sample());
		dbc.setString(54, tbdatabaoming.getSample_man_id());
		dbc.setString(55, tbdatabaoming.getSample_man_name());
		dbc.setTimestamp(56, new Timestamp(tbdatabaoming.getSample_time().getTime()));
		dbc.setString(57, tbdatabaoming.getSample_content());
		dbc.setString(58, tbdatabaoming.getType_remark());
		dbc.setString(59, tbdatabaoming.getCzname());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbDataBaoming tbdatabaoming) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_data_baoming(`id`,`name`,`phone`,`type`,`brand`,`serial`,`model`,`prov`,`city`,`is_reach`,`is_trans`,`is_invite`,`baoming_date`,`car_info`,`phone_prov`,`phone_city`,`ip`,`return_visit_state`,`buycar_emergency`,`is_key_cus`,`phoneerror`,`return_visit_time`,`return_visit_content`,`remarks`,`return_visit_man`,`return_visit_id`,`tuisong_flag`,`isdelete`,`attend_type`,`attend_date`,`pp_state`,`pz_city`,`phone_state`,`is_jp`,`jp_car`,`is_buycar`,`buy_state`,`buy_ys`,`buy_bsx`,`buy_pl`,`buy_color`,`know_yh`,`p_job`,`p_weixin`,`p_qq`,`phoneerror_count`,`area`,`real_type`,`constacterror`,`constacterror_count`,`oldid`,`sub_site`,`is_sample`,`sample_man_id`,`sample_man_name`,`sample_time`,`sample_content`,`type_remark`,`czname`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdatabaoming.getId());
		dbc.setString(2, tbdatabaoming.getName());
		dbc.setString(3, tbdatabaoming.getPhone());
		dbc.setInt(4, tbdatabaoming.getType());
		dbc.setInt(5, tbdatabaoming.getBrand());
		dbc.setInt(6, tbdatabaoming.getSerial());
		dbc.setInt(7, tbdatabaoming.getModel());
		dbc.setInt(8, tbdatabaoming.getProv());
		dbc.setInt(9, tbdatabaoming.getCity());
		dbc.setInt(10, tbdatabaoming.getIs_reach());
		dbc.setInt(11, tbdatabaoming.getIs_trans());
		dbc.setInt(12, tbdatabaoming.getIs_invite());
		dbc.setTimestamp(13, new Timestamp(tbdatabaoming.getBaoming_date().getTime()));
		dbc.setString(14, tbdatabaoming.getCar_info());
		dbc.setInt(15, tbdatabaoming.getPhone_prov());
		dbc.setInt(16, tbdatabaoming.getPhone_city());
		dbc.setString(17, tbdatabaoming.getIp());
		dbc.setInt(18, tbdatabaoming.getReturn_visit_state());
		dbc.setInt(19, tbdatabaoming.getBuycar_emergency());
		dbc.setInt(20, tbdatabaoming.getIs_key_cus());
		dbc.setInt(21, tbdatabaoming.getPhoneerror());
		dbc.setTimestamp(22, new Timestamp(tbdatabaoming.getReturn_visit_time().getTime()));
		dbc.setString(23, tbdatabaoming.getReturn_visit_content());
		dbc.setString(24, tbdatabaoming.getRemarks());
		dbc.setString(25, tbdatabaoming.getReturn_visit_man());
		dbc.setString(26, tbdatabaoming.getReturn_visit_id());
		dbc.setInt(27, tbdatabaoming.getTuisong_flag());
		dbc.setInt(28, tbdatabaoming.getIsdelete());
		dbc.setInt(29, tbdatabaoming.getAttend_type());
		dbc.setString(30, tbdatabaoming.getAttend_date());
		dbc.setString(31, tbdatabaoming.getPp_state());
		dbc.setString(32, tbdatabaoming.getPz_city());
		dbc.setInt(33, tbdatabaoming.getPhone_state());
		dbc.setInt(34, tbdatabaoming.getIs_jp());
		dbc.setString(35, tbdatabaoming.getJp_car());
		dbc.setInt(36, tbdatabaoming.getIs_buycar());
		dbc.setInt(37, tbdatabaoming.getBuy_state());
		dbc.setString(38, tbdatabaoming.getBuy_ys());
		dbc.setInt(39, tbdatabaoming.getBuy_bsx());
		dbc.setString(40, tbdatabaoming.getBuy_pl());
		dbc.setString(41, tbdatabaoming.getBuy_color());
		dbc.setString(42, tbdatabaoming.getKnow_yh());
		dbc.setInt(43, tbdatabaoming.getP_job());
		dbc.setString(44, tbdatabaoming.getP_weixin());
		dbc.setString(45, tbdatabaoming.getP_qq());
		dbc.setInt(46, tbdatabaoming.getPhoneerror_count());
		dbc.setInt(47, tbdatabaoming.getArea());
		dbc.setInt(48, tbdatabaoming.getReal_type());
		dbc.setInt(49, tbdatabaoming.getConstacterror());
		dbc.setInt(50, tbdatabaoming.getConstacterror_count());
		dbc.setInt(51, tbdatabaoming.getOldid());
		dbc.setInt(52, tbdatabaoming.getSub_site());
		dbc.setInt(53, tbdatabaoming.getIs_sample());
		dbc.setString(54, tbdatabaoming.getSample_man_id());
		dbc.setString(55, tbdatabaoming.getSample_man_name());
		dbc.setTimestamp(56, new Timestamp(tbdatabaoming.getSample_time().getTime()));
		dbc.setString(57, tbdatabaoming.getSample_content());
		dbc.setString(58, tbdatabaoming.getType_remark());
		dbc.setString(59, tbdatabaoming.getCzname());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbDataBaoming tbdatabaoming) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_data_baoming set ");
		boolean flag = false;
		if(tbdatabaoming.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",name=?");
			}else{
				sb.append("name=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",phone=?");
			}else{
				sb.append("phone=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",type=?");
			}else{
				sb.append("type=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",brand=?");
			}else{
				sb.append("brand=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",serial=?");
			}else{
				sb.append("serial=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",model=?");
			}else{
				sb.append("model=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",prov=?");
			}else{
				sb.append("prov=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",city=?");
			}else{
				sb.append("city=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",is_reach=?");
			}else{
				sb.append("is_reach=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",is_trans=?");
			}else{
				sb.append("is_trans=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",is_invite=?");
			}else{
				sb.append("is_invite=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",baoming_date=?");
			}else{
				sb.append("baoming_date=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",car_info=?");
			}else{
				sb.append("car_info=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",phone_prov=?");
			}else{
				sb.append("phone_prov=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",phone_city=?");
			}else{
				sb.append("phone_city=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",ip=?");
			}else{
				sb.append("ip=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",return_visit_state=?");
			}else{
				sb.append("return_visit_state=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[18]){
			if(flag){
				sb.append(",buycar_emergency=?");
			}else{
				sb.append("buycar_emergency=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[19]){
			if(flag){
				sb.append(",is_key_cus=?");
			}else{
				sb.append("is_key_cus=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[20]){
			if(flag){
				sb.append(",phoneerror=?");
			}else{
				sb.append("phoneerror=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[21]){
			if(flag){
				sb.append(",return_visit_time=?");
			}else{
				sb.append("return_visit_time=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[22]){
			if(flag){
				sb.append(",return_visit_content=?");
			}else{
				sb.append("return_visit_content=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[23]){
			if(flag){
				sb.append(",remarks=?");
			}else{
				sb.append("remarks=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[24]){
			if(flag){
				sb.append(",return_visit_man=?");
			}else{
				sb.append("return_visit_man=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[25]){
			if(flag){
				sb.append(",return_visit_id=?");
			}else{
				sb.append("return_visit_id=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[26]){
			if(flag){
				sb.append(",tuisong_flag=?");
			}else{
				sb.append("tuisong_flag=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[27]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[28]){
			if(flag){
				sb.append(",attend_type=?");
			}else{
				sb.append("attend_type=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[29]){
			if(flag){
				sb.append(",attend_date=?");
			}else{
				sb.append("attend_date=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[30]){
			if(flag){
				sb.append(",pp_state=?");
			}else{
				sb.append("pp_state=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[31]){
			if(flag){
				sb.append(",pz_city=?");
			}else{
				sb.append("pz_city=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[32]){
			if(flag){
				sb.append(",phone_state=?");
			}else{
				sb.append("phone_state=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[33]){
			if(flag){
				sb.append(",is_jp=?");
			}else{
				sb.append("is_jp=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[34]){
			if(flag){
				sb.append(",jp_car=?");
			}else{
				sb.append("jp_car=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[35]){
			if(flag){
				sb.append(",is_buycar=?");
			}else{
				sb.append("is_buycar=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[36]){
			if(flag){
				sb.append(",buy_state=?");
			}else{
				sb.append("buy_state=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[37]){
			if(flag){
				sb.append(",buy_ys=?");
			}else{
				sb.append("buy_ys=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[38]){
			if(flag){
				sb.append(",buy_bsx=?");
			}else{
				sb.append("buy_bsx=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[39]){
			if(flag){
				sb.append(",buy_pl=?");
			}else{
				sb.append("buy_pl=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[40]){
			if(flag){
				sb.append(",buy_color=?");
			}else{
				sb.append("buy_color=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[41]){
			if(flag){
				sb.append(",know_yh=?");
			}else{
				sb.append("know_yh=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[42]){
			if(flag){
				sb.append(",p_job=?");
			}else{
				sb.append("p_job=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[43]){
			if(flag){
				sb.append(",p_weixin=?");
			}else{
				sb.append("p_weixin=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[44]){
			if(flag){
				sb.append(",p_qq=?");
			}else{
				sb.append("p_qq=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[45]){
			if(flag){
				sb.append(",phoneerror_count=?");
			}else{
				sb.append("phoneerror_count=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[46]){
			if(flag){
				sb.append(",area=?");
			}else{
				sb.append("area=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[47]){
			if(flag){
				sb.append(",real_type=?");
			}else{
				sb.append("real_type=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[48]){
			if(flag){
				sb.append(",constacterror=?");
			}else{
				sb.append("constacterror=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[49]){
			if(flag){
				sb.append(",constacterror_count=?");
			}else{
				sb.append("constacterror_count=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[50]){
			if(flag){
				sb.append(",oldid=?");
			}else{
				sb.append("oldid=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[51]){
			if(flag){
				sb.append(",sub_site=?");
			}else{
				sb.append("sub_site=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[52]){
			if(flag){
				sb.append(",is_sample=?");
			}else{
				sb.append("is_sample=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[53]){
			if(flag){
				sb.append(",sample_man_id=?");
			}else{
				sb.append("sample_man_id=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[54]){
			if(flag){
				sb.append(",sample_man_name=?");
			}else{
				sb.append("sample_man_name=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[55]){
			if(flag){
				sb.append(",sample_time=?");
			}else{
				sb.append("sample_time=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[56]){
			if(flag){
				sb.append(",sample_content=?");
			}else{
				sb.append("sample_content=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[57]){
			if(flag){
				sb.append(",type_remark=?");
			}else{
				sb.append("type_remark=?");
				flag=true;
			}
		}
		if(tbdatabaoming.COLUMN_FLAG[58]){
			if(flag){
				sb.append(",czname=?");
			}else{
				sb.append("czname=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbdatabaoming.COLUMN_FLAG[0]){
			dbc.setInt(k, tbdatabaoming.getId());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[1]){
			dbc.setString(k, tbdatabaoming.getName());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[2]){
			dbc.setString(k, tbdatabaoming.getPhone());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[3]){
			dbc.setInt(k, tbdatabaoming.getType());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[4]){
			dbc.setInt(k, tbdatabaoming.getBrand());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[5]){
			dbc.setInt(k, tbdatabaoming.getSerial());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[6]){
			dbc.setInt(k, tbdatabaoming.getModel());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[7]){
			dbc.setInt(k, tbdatabaoming.getProv());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[8]){
			dbc.setInt(k, tbdatabaoming.getCity());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[9]){
			dbc.setInt(k, tbdatabaoming.getIs_reach());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[10]){
			dbc.setInt(k, tbdatabaoming.getIs_trans());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[11]){
			dbc.setInt(k, tbdatabaoming.getIs_invite());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[12]){
			dbc.setTimestamp(k, new Timestamp(tbdatabaoming.getBaoming_date().getTime()));k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[13]){
			dbc.setString(k, tbdatabaoming.getCar_info());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[14]){
			dbc.setInt(k, tbdatabaoming.getPhone_prov());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[15]){
			dbc.setInt(k, tbdatabaoming.getPhone_city());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[16]){
			dbc.setString(k, tbdatabaoming.getIp());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[17]){
			dbc.setInt(k, tbdatabaoming.getReturn_visit_state());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[18]){
			dbc.setInt(k, tbdatabaoming.getBuycar_emergency());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[19]){
			dbc.setInt(k, tbdatabaoming.getIs_key_cus());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[20]){
			dbc.setInt(k, tbdatabaoming.getPhoneerror());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[21]){
			dbc.setTimestamp(k, new Timestamp(tbdatabaoming.getReturn_visit_time().getTime()));k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[22]){
			dbc.setString(k, tbdatabaoming.getReturn_visit_content());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[23]){
			dbc.setString(k, tbdatabaoming.getRemarks());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[24]){
			dbc.setString(k, tbdatabaoming.getReturn_visit_man());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[25]){
			dbc.setString(k, tbdatabaoming.getReturn_visit_id());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[26]){
			dbc.setInt(k, tbdatabaoming.getTuisong_flag());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[27]){
			dbc.setInt(k, tbdatabaoming.getIsdelete());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[28]){
			dbc.setInt(k, tbdatabaoming.getAttend_type());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[29]){
			dbc.setString(k, tbdatabaoming.getAttend_date());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[30]){
			dbc.setString(k, tbdatabaoming.getPp_state());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[31]){
			dbc.setString(k, tbdatabaoming.getPz_city());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[32]){
			dbc.setInt(k, tbdatabaoming.getPhone_state());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[33]){
			dbc.setInt(k, tbdatabaoming.getIs_jp());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[34]){
			dbc.setString(k, tbdatabaoming.getJp_car());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[35]){
			dbc.setInt(k, tbdatabaoming.getIs_buycar());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[36]){
			dbc.setInt(k, tbdatabaoming.getBuy_state());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[37]){
			dbc.setString(k, tbdatabaoming.getBuy_ys());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[38]){
			dbc.setInt(k, tbdatabaoming.getBuy_bsx());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[39]){
			dbc.setString(k, tbdatabaoming.getBuy_pl());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[40]){
			dbc.setString(k, tbdatabaoming.getBuy_color());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[41]){
			dbc.setString(k, tbdatabaoming.getKnow_yh());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[42]){
			dbc.setInt(k, tbdatabaoming.getP_job());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[43]){
			dbc.setString(k, tbdatabaoming.getP_weixin());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[44]){
			dbc.setString(k, tbdatabaoming.getP_qq());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[45]){
			dbc.setInt(k, tbdatabaoming.getPhoneerror_count());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[46]){
			dbc.setInt(k, tbdatabaoming.getArea());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[47]){
			dbc.setInt(k, tbdatabaoming.getReal_type());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[48]){
			dbc.setInt(k, tbdatabaoming.getConstacterror());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[49]){
			dbc.setInt(k, tbdatabaoming.getConstacterror_count());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[50]){
			dbc.setInt(k, tbdatabaoming.getOldid());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[51]){
			dbc.setInt(k, tbdatabaoming.getSub_site());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[52]){
			dbc.setInt(k, tbdatabaoming.getIs_sample());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[53]){
			dbc.setString(k, tbdatabaoming.getSample_man_id());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[54]){
			dbc.setString(k, tbdatabaoming.getSample_man_name());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[55]){
			dbc.setTimestamp(k, new Timestamp(tbdatabaoming.getSample_time().getTime()));k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[56]){
			dbc.setString(k, tbdatabaoming.getSample_content());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[57]){
			dbc.setString(k, tbdatabaoming.getType_remark());k++;
		}
		if(tbdatabaoming.COLUMN_FLAG[58]){
			dbc.setString(k, tbdatabaoming.getCzname());k++;
		}
		dbc.setInt(k, tbdatabaoming.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbDataBaoming tbdatabaoming) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbdatabaoming);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}