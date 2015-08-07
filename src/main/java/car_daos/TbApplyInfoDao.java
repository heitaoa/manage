package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbApplyInfo;

public class  TbApplyInfoDao  extends BaseDao {

	public static void fill(ResultSet rs, TbApplyInfo tbapplyinfo) throws SQLException {
		tbapplyinfo.setId(rs.getInt("id"));//
		tbapplyinfo.setCarid(rs.getInt("carid"));//
		tbapplyinfo.setModelid(rs.getInt("modelid"));//
		tbapplyinfo.setName(rs.getString("name"));//
		tbapplyinfo.setPhone(rs.getString("phone"));//
		tbapplyinfo.setSex(rs.getInt("sex"));//1-男；2-女；0-保密
		tbapplyinfo.setProv(rs.getString("prov"));//
		tbapplyinfo.setCity(rs.getString("city"));//
		tbapplyinfo.setAppdate(rs.getTimestamp("appdate"));//
		tbapplyinfo.setType(rs.getInt("type"));//0-报名申请；1-询问最低价；2-预约试驾;3-特卖惠 ；  4-小胖看车团315-pc ；5- 小胖看车团315-手机 ;6-老315网页端报名;8-老315 手机端报名；7-老suncars-pc  10suncars-手机 9-车轮微信 11-车团-双十一活动
		tbapplyinfo.setIssendsms(rs.getInt("issendsms"));//
		tbapplyinfo.setLeft_num(rs.getInt("left_num"));//
		tbapplyinfo.setIs_attend(rs.getInt("is_attend"));//参加方式 0 -未知 1-参加-跟团到 2-参加-自行到 3-参加-方式待定  4可能参加 5-不参加
		tbapplyinfo.setLook_time(rs.getTimestamp("look_time"));//看车车团时间
		tbapplyinfo.setIsbuy(rs.getInt("isbuy"));//是否已购车 int 0-未知 1-已购车 2-未购车
		tbapplyinfo.setBuy_time(rs.getTimestamp("buy_time"));//购车时间
		tbapplyinfo.setIs_key_cus(rs.getInt("is_key_cus"));//重点客户 int 0-非重点客户 1-重点客户
		tbapplyinfo.setPhone_state(rs.getInt("phone_state"));//手机状态 int 0-有效号码  1-无效号码 2-重复号码
		tbapplyinfo.setOrder_time(rs.getTimestamp("order_time"));//预约时间
		tbapplyinfo.setOrder_state(rs.getInt("order_state"));//预约状态 int 0-任意时间 1-自定义时间
		tbapplyinfo.setReturn_visit_state(rs.getInt("return_visit_state"));//回访状态 int 0-未回访  1-已回访
		tbapplyinfo.setReturn_visit_time(rs.getTimestamp("return_visit_time"));//回访时间
		tbapplyinfo.setReturn_visit_man(rs.getString("return_visit_man"));//回访人
		tbapplyinfo.setReturn_visit_content(rs.getString("return_visit_content"));//回访记录
		tbapplyinfo.setAgain_return_visit(rs.getInt("again_return_visit"));//再次回访 int 0-不需要  1-需要
		tbapplyinfo.setRemarks(rs.getString("remarks"));//备注
		tbapplyinfo.setCar_info(rs.getString("car_info"));//车名信息
		tbapplyinfo.setIp(rs.getString("ip"));//ip地址
		tbapplyinfo.setIsdelete(rs.getInt("isdelete"));//是否删除
		tbapplyinfo.setPhone_prov(rs.getInt("phone_prov"));//手机归属地-省
		tbapplyinfo.setPhone_city(rs.getInt("phone_city"));//手机归属地-市
		tbapplyinfo.setTuisong_flag(rs.getInt("tuisong_flag"));//0 未推送 1- 已推送
		tbapplyinfo.setCus_intention(rs.getInt("cus_intention"));//客户意向  0 非常紧急，越快越好1 本周有时间参加2 下周有时间参加3 要买，但不太确定时间4 不需要购买了5 未接通，需再次电话 6 其他情况
	}

	public static List<TbApplyInfo> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_apply_info";
		List<TbApplyInfo> list = new ArrayList<TbApplyInfo>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbApplyInfo tbapplyinfo = new TbApplyInfo();
				fill(rs, tbapplyinfo);
				list.add(tbapplyinfo);
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


	public static List<TbApplyInfo> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_apply_info where "+subsql+"";
		List<TbApplyInfo> list = new ArrayList<TbApplyInfo>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbApplyInfo tbapplyinfo = new TbApplyInfo();
				fill(rs, tbapplyinfo);
				list.add(tbapplyinfo);
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
		String sql = "select count(*) from tb_apply_info where "+subsql+"";
		
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
		String sql = "delete from tb_apply_info where "+subsql+"";
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
		String sql = "delete from tb_apply_info where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbApplyInfo tbapplyinfo) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_apply_info(`id`,`carid`,`modelid`,`name`,`phone`,`sex`,`prov`,`city`,`appdate`,`type`,`issendsms`,`left_num`,`is_attend`,`look_time`,`isbuy`,`buy_time`,`is_key_cus`,`phone_state`,`order_time`,`order_state`,`return_visit_state`,`return_visit_time`,`return_visit_man`,`return_visit_content`,`again_return_visit`,`remarks`,`car_info`,`ip`,`isdelete`,`phone_prov`,`phone_city`,`tuisong_flag`,`cus_intention`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbapplyinfo.getId());
		dbc.setInt(2, tbapplyinfo.getCarid());
		dbc.setInt(3, tbapplyinfo.getModelid());
		dbc.setString(4, tbapplyinfo.getName());
		dbc.setString(5, tbapplyinfo.getPhone());
		dbc.setInt(6, tbapplyinfo.getSex());
		dbc.setString(7, tbapplyinfo.getProv());
		dbc.setString(8, tbapplyinfo.getCity());
		dbc.setTimestamp(9, new Timestamp(tbapplyinfo.getAppdate().getTime()));
		dbc.setInt(10, tbapplyinfo.getType());
		dbc.setInt(11, tbapplyinfo.getIssendsms());
		dbc.setInt(12, tbapplyinfo.getLeft_num());
		dbc.setInt(13, tbapplyinfo.getIs_attend());
		dbc.setTimestamp(14, new Timestamp(tbapplyinfo.getLook_time().getTime()));
		dbc.setInt(15, tbapplyinfo.getIsbuy());
		dbc.setTimestamp(16, new Timestamp(tbapplyinfo.getBuy_time().getTime()));
		dbc.setInt(17, tbapplyinfo.getIs_key_cus());
		dbc.setInt(18, tbapplyinfo.getPhone_state());
		dbc.setTimestamp(19, new Timestamp(tbapplyinfo.getOrder_time().getTime()));
		dbc.setInt(20, tbapplyinfo.getOrder_state());
		dbc.setInt(21, tbapplyinfo.getReturn_visit_state());
		dbc.setTimestamp(22, new Timestamp(tbapplyinfo.getReturn_visit_time().getTime()));
		dbc.setString(23, tbapplyinfo.getReturn_visit_man());
		dbc.setString(24, tbapplyinfo.getReturn_visit_content());
		dbc.setInt(25, tbapplyinfo.getAgain_return_visit());
		dbc.setString(26, tbapplyinfo.getRemarks());
		dbc.setString(27, tbapplyinfo.getCar_info());
		dbc.setString(28, tbapplyinfo.getIp());
		dbc.setInt(29, tbapplyinfo.getIsdelete());
		dbc.setInt(30, tbapplyinfo.getPhone_prov());
		dbc.setInt(31, tbapplyinfo.getPhone_city());
		dbc.setInt(32, tbapplyinfo.getTuisong_flag());
		dbc.setInt(33, tbapplyinfo.getCus_intention());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbApplyInfo tbapplyinfo) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_apply_info(`id`,`carid`,`modelid`,`name`,`phone`,`sex`,`prov`,`city`,`appdate`,`type`,`issendsms`,`left_num`,`is_attend`,`look_time`,`isbuy`,`buy_time`,`is_key_cus`,`phone_state`,`order_time`,`order_state`,`return_visit_state`,`return_visit_time`,`return_visit_man`,`return_visit_content`,`again_return_visit`,`remarks`,`car_info`,`ip`,`isdelete`,`phone_prov`,`phone_city`,`tuisong_flag`,`cus_intention`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbapplyinfo.getId());
		dbc.setInt(2, tbapplyinfo.getCarid());
		dbc.setInt(3, tbapplyinfo.getModelid());
		dbc.setString(4, tbapplyinfo.getName());
		dbc.setString(5, tbapplyinfo.getPhone());
		dbc.setInt(6, tbapplyinfo.getSex());
		dbc.setString(7, tbapplyinfo.getProv());
		dbc.setString(8, tbapplyinfo.getCity());
		dbc.setTimestamp(9, new Timestamp(tbapplyinfo.getAppdate().getTime()));
		dbc.setInt(10, tbapplyinfo.getType());
		dbc.setInt(11, tbapplyinfo.getIssendsms());
		dbc.setInt(12, tbapplyinfo.getLeft_num());
		dbc.setInt(13, tbapplyinfo.getIs_attend());
		dbc.setTimestamp(14, new Timestamp(tbapplyinfo.getLook_time().getTime()));
		dbc.setInt(15, tbapplyinfo.getIsbuy());
		dbc.setTimestamp(16, new Timestamp(tbapplyinfo.getBuy_time().getTime()));
		dbc.setInt(17, tbapplyinfo.getIs_key_cus());
		dbc.setInt(18, tbapplyinfo.getPhone_state());
		dbc.setTimestamp(19, new Timestamp(tbapplyinfo.getOrder_time().getTime()));
		dbc.setInt(20, tbapplyinfo.getOrder_state());
		dbc.setInt(21, tbapplyinfo.getReturn_visit_state());
		dbc.setTimestamp(22, new Timestamp(tbapplyinfo.getReturn_visit_time().getTime()));
		dbc.setString(23, tbapplyinfo.getReturn_visit_man());
		dbc.setString(24, tbapplyinfo.getReturn_visit_content());
		dbc.setInt(25, tbapplyinfo.getAgain_return_visit());
		dbc.setString(26, tbapplyinfo.getRemarks());
		dbc.setString(27, tbapplyinfo.getCar_info());
		dbc.setString(28, tbapplyinfo.getIp());
		dbc.setInt(29, tbapplyinfo.getIsdelete());
		dbc.setInt(30, tbapplyinfo.getPhone_prov());
		dbc.setInt(31, tbapplyinfo.getPhone_city());
		dbc.setInt(32, tbapplyinfo.getTuisong_flag());
		dbc.setInt(33, tbapplyinfo.getCus_intention());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbApplyInfo tbapplyinfo) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_apply_info set ");
		boolean flag = false;
		if(tbapplyinfo.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",carid=?");
			}else{
				sb.append("carid=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",modelid=?");
			}else{
				sb.append("modelid=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",name=?");
			}else{
				sb.append("name=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",phone=?");
			}else{
				sb.append("phone=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",sex=?");
			}else{
				sb.append("sex=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",prov=?");
			}else{
				sb.append("prov=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",city=?");
			}else{
				sb.append("city=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",appdate=?");
			}else{
				sb.append("appdate=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",type=?");
			}else{
				sb.append("type=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",issendsms=?");
			}else{
				sb.append("issendsms=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",left_num=?");
			}else{
				sb.append("left_num=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",is_attend=?");
			}else{
				sb.append("is_attend=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",look_time=?");
			}else{
				sb.append("look_time=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",isbuy=?");
			}else{
				sb.append("isbuy=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",buy_time=?");
			}else{
				sb.append("buy_time=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",is_key_cus=?");
			}else{
				sb.append("is_key_cus=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",phone_state=?");
			}else{
				sb.append("phone_state=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[18]){
			if(flag){
				sb.append(",order_time=?");
			}else{
				sb.append("order_time=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[19]){
			if(flag){
				sb.append(",order_state=?");
			}else{
				sb.append("order_state=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[20]){
			if(flag){
				sb.append(",return_visit_state=?");
			}else{
				sb.append("return_visit_state=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[21]){
			if(flag){
				sb.append(",return_visit_time=?");
			}else{
				sb.append("return_visit_time=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[22]){
			if(flag){
				sb.append(",return_visit_man=?");
			}else{
				sb.append("return_visit_man=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[23]){
			if(flag){
				sb.append(",return_visit_content=?");
			}else{
				sb.append("return_visit_content=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[24]){
			if(flag){
				sb.append(",again_return_visit=?");
			}else{
				sb.append("again_return_visit=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[25]){
			if(flag){
				sb.append(",remarks=?");
			}else{
				sb.append("remarks=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[26]){
			if(flag){
				sb.append(",car_info=?");
			}else{
				sb.append("car_info=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[27]){
			if(flag){
				sb.append(",ip=?");
			}else{
				sb.append("ip=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[28]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[29]){
			if(flag){
				sb.append(",phone_prov=?");
			}else{
				sb.append("phone_prov=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[30]){
			if(flag){
				sb.append(",phone_city=?");
			}else{
				sb.append("phone_city=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[31]){
			if(flag){
				sb.append(",tuisong_flag=?");
			}else{
				sb.append("tuisong_flag=?");
				flag=true;
			}
		}
		if(tbapplyinfo.COLUMN_FLAG[32]){
			if(flag){
				sb.append(",cus_intention=?");
			}else{
				sb.append("cus_intention=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbapplyinfo.COLUMN_FLAG[0]){
			dbc.setInt(k, tbapplyinfo.getId());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[1]){
			dbc.setInt(k, tbapplyinfo.getCarid());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[2]){
			dbc.setInt(k, tbapplyinfo.getModelid());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[3]){
			dbc.setString(k, tbapplyinfo.getName());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[4]){
			dbc.setString(k, tbapplyinfo.getPhone());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[5]){
			dbc.setInt(k, tbapplyinfo.getSex());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[6]){
			dbc.setString(k, tbapplyinfo.getProv());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[7]){
			dbc.setString(k, tbapplyinfo.getCity());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[8]){
			dbc.setTimestamp(k, new Timestamp(tbapplyinfo.getAppdate().getTime()));k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[9]){
			dbc.setInt(k, tbapplyinfo.getType());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[10]){
			dbc.setInt(k, tbapplyinfo.getIssendsms());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[11]){
			dbc.setInt(k, tbapplyinfo.getLeft_num());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[12]){
			dbc.setInt(k, tbapplyinfo.getIs_attend());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[13]){
			dbc.setTimestamp(k, new Timestamp(tbapplyinfo.getLook_time().getTime()));k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[14]){
			dbc.setInt(k, tbapplyinfo.getIsbuy());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[15]){
			dbc.setTimestamp(k, new Timestamp(tbapplyinfo.getBuy_time().getTime()));k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[16]){
			dbc.setInt(k, tbapplyinfo.getIs_key_cus());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[17]){
			dbc.setInt(k, tbapplyinfo.getPhone_state());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[18]){
			dbc.setTimestamp(k, new Timestamp(tbapplyinfo.getOrder_time().getTime()));k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[19]){
			dbc.setInt(k, tbapplyinfo.getOrder_state());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[20]){
			dbc.setInt(k, tbapplyinfo.getReturn_visit_state());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[21]){
			dbc.setTimestamp(k, new Timestamp(tbapplyinfo.getReturn_visit_time().getTime()));k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[22]){
			dbc.setString(k, tbapplyinfo.getReturn_visit_man());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[23]){
			dbc.setString(k, tbapplyinfo.getReturn_visit_content());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[24]){
			dbc.setInt(k, tbapplyinfo.getAgain_return_visit());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[25]){
			dbc.setString(k, tbapplyinfo.getRemarks());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[26]){
			dbc.setString(k, tbapplyinfo.getCar_info());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[27]){
			dbc.setString(k, tbapplyinfo.getIp());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[28]){
			dbc.setInt(k, tbapplyinfo.getIsdelete());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[29]){
			dbc.setInt(k, tbapplyinfo.getPhone_prov());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[30]){
			dbc.setInt(k, tbapplyinfo.getPhone_city());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[31]){
			dbc.setInt(k, tbapplyinfo.getTuisong_flag());k++;
		}
		if(tbapplyinfo.COLUMN_FLAG[32]){
			dbc.setInt(k, tbapplyinfo.getCus_intention());k++;
		}
		dbc.setInt(k, tbapplyinfo.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbApplyInfo tbapplyinfo) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbapplyinfo);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}