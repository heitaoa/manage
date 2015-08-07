package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbDataTransInfo;

public class  TbDataTransInfoDao  extends BaseDao {

	public static void fill(ResultSet rs, TbDataTransInfo tbdatatransinfo) throws SQLException {
		tbdatatransinfo.setId(rs.getInt("id"));//id
		tbdatatransinfo.setPro_num(rs.getString("pro_num"));//项目编号
		tbdatatransinfo.setName(rs.getString("name"));//姓名
		tbdatatransinfo.setPhone(rs.getString("phone"));//电话
		tbdatatransinfo.setPlate(rs.getString("plate"));//车牌号
		tbdatatransinfo.setAddr(rs.getString("addr"));//地址
		tbdatatransinfo.setModel(rs.getInt("model"));//成交车型
		tbdatatransinfo.setTrans_date(rs.getTimestamp("trans_date"));//交易日期
		tbdatatransinfo.setTrans_price(rs.getString("trans_price"));//成交价格
		tbdatatransinfo.setEngine_num(rs.getString("engine_num"));//发动机编号
		tbdatatransinfo.setVin_num(rs.getString("vin_num"));//vin车架号
		tbdatatransinfo.setGiving_code(rs.getString("giving_code"));//赠品code(0-1,0-2,1-1,1-2)逗号隔开，“-”号之前表示赠品类型，0表示礼包，1表示礼品，“-”号之后表示赠品id
		tbdatatransinfo.setGiving_name(rs.getString("giving_name"));//赠品名称
		tbdatatransinfo.setIs_giving_send(rs.getInt("is_giving_send"));//赠品是否送出(0-未送出，1-已送出)
		tbdatatransinfo.setQiandao_id(rs.getInt("qiandao_id"));//签到id
		tbdatatransinfo.setSale_man(rs.getString("sale_man"));//签单销售
		tbdatatransinfo.setGiving_total_price(rs.getString("giving_total_price"));//礼品总价
		tbdatatransinfo.setGift_examine_state(rs.getInt("gift_examine_state"));//礼品审核状态(0-未审核，1-审核通过，2-驳回）
	}

	public static List<TbDataTransInfo> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_data_trans_info";
		List<TbDataTransInfo> list = new ArrayList<TbDataTransInfo>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataTransInfo tbdatatransinfo = new TbDataTransInfo();
				fill(rs, tbdatatransinfo);
				list.add(tbdatatransinfo);
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


	public static List<TbDataTransInfo> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_data_trans_info where "+subsql+"";
		List<TbDataTransInfo> list = new ArrayList<TbDataTransInfo>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataTransInfo tbdatatransinfo = new TbDataTransInfo();
				fill(rs, tbdatatransinfo);
				list.add(tbdatatransinfo);
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
		String sql = "select count(*) from tb_data_trans_info where "+subsql+"";
		
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
		String sql = "delete from tb_data_trans_info where "+subsql+"";
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
		String sql = "delete from tb_data_trans_info where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbDataTransInfo tbdatatransinfo) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_data_trans_info(`id`,`pro_num`,`name`,`phone`,`plate`,`addr`,`model`,`trans_date`,`trans_price`,`engine_num`,`vin_num`,`giving_code`,`giving_name`,`is_giving_send`,`qiandao_id`,`sale_man`,`giving_total_price`,`gift_examine_state`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdatatransinfo.getId());
		dbc.setString(2, tbdatatransinfo.getPro_num());
		dbc.setString(3, tbdatatransinfo.getName());
		dbc.setString(4, tbdatatransinfo.getPhone());
		dbc.setString(5, tbdatatransinfo.getPlate());
		dbc.setString(6, tbdatatransinfo.getAddr());
		dbc.setInt(7, tbdatatransinfo.getModel());
		dbc.setTimestamp(8, new Timestamp(tbdatatransinfo.getTrans_date().getTime()));
		dbc.setString(9, tbdatatransinfo.getTrans_price());
		dbc.setString(10, tbdatatransinfo.getEngine_num());
		dbc.setString(11, tbdatatransinfo.getVin_num());
		dbc.setString(12, tbdatatransinfo.getGiving_code());
		dbc.setString(13, tbdatatransinfo.getGiving_name());
		dbc.setInt(14, tbdatatransinfo.getIs_giving_send());
		dbc.setInt(15, tbdatatransinfo.getQiandao_id());
		dbc.setString(16, tbdatatransinfo.getSale_man());
		dbc.setString(17, tbdatatransinfo.getGiving_total_price());
		dbc.setInt(18, tbdatatransinfo.getGift_examine_state());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbDataTransInfo tbdatatransinfo) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_data_trans_info(`id`,`pro_num`,`name`,`phone`,`plate`,`addr`,`model`,`trans_date`,`trans_price`,`engine_num`,`vin_num`,`giving_code`,`giving_name`,`is_giving_send`,`qiandao_id`,`sale_man`,`giving_total_price`,`gift_examine_state`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdatatransinfo.getId());
		dbc.setString(2, tbdatatransinfo.getPro_num());
		dbc.setString(3, tbdatatransinfo.getName());
		dbc.setString(4, tbdatatransinfo.getPhone());
		dbc.setString(5, tbdatatransinfo.getPlate());
		dbc.setString(6, tbdatatransinfo.getAddr());
		dbc.setInt(7, tbdatatransinfo.getModel());
		dbc.setTimestamp(8, new Timestamp(tbdatatransinfo.getTrans_date().getTime()));
		dbc.setString(9, tbdatatransinfo.getTrans_price());
		dbc.setString(10, tbdatatransinfo.getEngine_num());
		dbc.setString(11, tbdatatransinfo.getVin_num());
		dbc.setString(12, tbdatatransinfo.getGiving_code());
		dbc.setString(13, tbdatatransinfo.getGiving_name());
		dbc.setInt(14, tbdatatransinfo.getIs_giving_send());
		dbc.setInt(15, tbdatatransinfo.getQiandao_id());
		dbc.setString(16, tbdatatransinfo.getSale_man());
		dbc.setString(17, tbdatatransinfo.getGiving_total_price());
		dbc.setInt(18, tbdatatransinfo.getGift_examine_state());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbDataTransInfo tbdatatransinfo) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_data_trans_info set ");
		boolean flag = false;
		if(tbdatatransinfo.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(tbdatatransinfo.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",pro_num=?");
			}else{
				sb.append("pro_num=?");
				flag=true;
			}
		}
		if(tbdatatransinfo.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",name=?");
			}else{
				sb.append("name=?");
				flag=true;
			}
		}
		if(tbdatatransinfo.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",phone=?");
			}else{
				sb.append("phone=?");
				flag=true;
			}
		}
		if(tbdatatransinfo.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",plate=?");
			}else{
				sb.append("plate=?");
				flag=true;
			}
		}
		if(tbdatatransinfo.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",addr=?");
			}else{
				sb.append("addr=?");
				flag=true;
			}
		}
		if(tbdatatransinfo.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",model=?");
			}else{
				sb.append("model=?");
				flag=true;
			}
		}
		if(tbdatatransinfo.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",trans_date=?");
			}else{
				sb.append("trans_date=?");
				flag=true;
			}
		}
		if(tbdatatransinfo.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",trans_price=?");
			}else{
				sb.append("trans_price=?");
				flag=true;
			}
		}
		if(tbdatatransinfo.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",engine_num=?");
			}else{
				sb.append("engine_num=?");
				flag=true;
			}
		}
		if(tbdatatransinfo.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",vin_num=?");
			}else{
				sb.append("vin_num=?");
				flag=true;
			}
		}
		if(tbdatatransinfo.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",giving_code=?");
			}else{
				sb.append("giving_code=?");
				flag=true;
			}
		}
		if(tbdatatransinfo.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",giving_name=?");
			}else{
				sb.append("giving_name=?");
				flag=true;
			}
		}
		if(tbdatatransinfo.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",is_giving_send=?");
			}else{
				sb.append("is_giving_send=?");
				flag=true;
			}
		}
		if(tbdatatransinfo.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",qiandao_id=?");
			}else{
				sb.append("qiandao_id=?");
				flag=true;
			}
		}
		if(tbdatatransinfo.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",sale_man=?");
			}else{
				sb.append("sale_man=?");
				flag=true;
			}
		}
		if(tbdatatransinfo.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",giving_total_price=?");
			}else{
				sb.append("giving_total_price=?");
				flag=true;
			}
		}
		if(tbdatatransinfo.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",gift_examine_state=?");
			}else{
				sb.append("gift_examine_state=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbdatatransinfo.COLUMN_FLAG[0]){
			dbc.setInt(k, tbdatatransinfo.getId());k++;
		}
		if(tbdatatransinfo.COLUMN_FLAG[1]){
			dbc.setString(k, tbdatatransinfo.getPro_num());k++;
		}
		if(tbdatatransinfo.COLUMN_FLAG[2]){
			dbc.setString(k, tbdatatransinfo.getName());k++;
		}
		if(tbdatatransinfo.COLUMN_FLAG[3]){
			dbc.setString(k, tbdatatransinfo.getPhone());k++;
		}
		if(tbdatatransinfo.COLUMN_FLAG[4]){
			dbc.setString(k, tbdatatransinfo.getPlate());k++;
		}
		if(tbdatatransinfo.COLUMN_FLAG[5]){
			dbc.setString(k, tbdatatransinfo.getAddr());k++;
		}
		if(tbdatatransinfo.COLUMN_FLAG[6]){
			dbc.setInt(k, tbdatatransinfo.getModel());k++;
		}
		if(tbdatatransinfo.COLUMN_FLAG[7]){
			dbc.setTimestamp(k, new Timestamp(tbdatatransinfo.getTrans_date().getTime()));k++;
		}
		if(tbdatatransinfo.COLUMN_FLAG[8]){
			dbc.setString(k, tbdatatransinfo.getTrans_price());k++;
		}
		if(tbdatatransinfo.COLUMN_FLAG[9]){
			dbc.setString(k, tbdatatransinfo.getEngine_num());k++;
		}
		if(tbdatatransinfo.COLUMN_FLAG[10]){
			dbc.setString(k, tbdatatransinfo.getVin_num());k++;
		}
		if(tbdatatransinfo.COLUMN_FLAG[11]){
			dbc.setString(k, tbdatatransinfo.getGiving_code());k++;
		}
		if(tbdatatransinfo.COLUMN_FLAG[12]){
			dbc.setString(k, tbdatatransinfo.getGiving_name());k++;
		}
		if(tbdatatransinfo.COLUMN_FLAG[13]){
			dbc.setInt(k, tbdatatransinfo.getIs_giving_send());k++;
		}
		if(tbdatatransinfo.COLUMN_FLAG[14]){
			dbc.setInt(k, tbdatatransinfo.getQiandao_id());k++;
		}
		if(tbdatatransinfo.COLUMN_FLAG[15]){
			dbc.setString(k, tbdatatransinfo.getSale_man());k++;
		}
		if(tbdatatransinfo.COLUMN_FLAG[16]){
			dbc.setString(k, tbdatatransinfo.getGiving_total_price());k++;
		}
		if(tbdatatransinfo.COLUMN_FLAG[17]){
			dbc.setInt(k, tbdatatransinfo.getGift_examine_state());k++;
		}
		dbc.setInt(k, tbdatatransinfo.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbDataTransInfo tbdatatransinfo) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbdatatransinfo);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}