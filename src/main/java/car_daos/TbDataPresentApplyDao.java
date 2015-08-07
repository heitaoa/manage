package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbDataPresentApply;

public class  TbDataPresentApplyDao  extends BaseDao {

	public static void fill(ResultSet rs, TbDataPresentApply tbdatapresentapply) throws SQLException {
		tbdatapresentapply.setId(rs.getInt("id"));//礼品申领id
		tbdatapresentapply.setOwner_name(rs.getString("owner_name"));//车主姓名
		tbdatapresentapply.setOwner_phone(rs.getString("owner_phone"));//车主手机
		tbdatapresentapply.setOwner_carcode(rs.getString("owner_carcode"));//车牌号
		tbdatapresentapply.setOwner_address(rs.getString("owner_address"));//车主地址
		tbdatapresentapply.setOwner_idcode(rs.getString("owner_idcode"));//车主身份证号码
		tbdatapresentapply.setTravelcard_date(rs.getTimestamp("travelcard_date"));//行驶证发放日期
		tbdatapresentapply.setCarbill_date(rs.getTimestamp("carbill_date"));//购车发票日期
		tbdatapresentapply.setGiftverify_img(rs.getString("giftverify_img"));//礼品确认单图片
		tbdatapresentapply.setCarbill_img(rs.getString("carbill_img"));//购车发票图片
		tbdatapresentapply.setTravelcard_img(rs.getString("travelcard_img"));//行驶证图片
		tbdatapresentapply.setIdcard_img(rs.getString("idcard_img"));//身份证图片
		tbdatapresentapply.setCar_img(rs.getString("car_img"));//爱车图片
		tbdatapresentapply.setEngine_num(rs.getString("engine_num"));//车架号
		tbdatapresentapply.setVin_num(rs.getString("vin_num"));//vin车架号
		tbdatapresentapply.setOwner_remark(rs.getString("owner_remark"));//车主留言
		tbdatapresentapply.setRemark(rs.getString("remark"));//操作者留言
		tbdatapresentapply.setApply_state(rs.getInt("apply_state"));//状态 0-未审核，1-审核通过，2-审核未通过，3-礼品已发放
		tbdatapresentapply.setApply_date(rs.getTimestamp("apply_date"));//申请日期
		tbdatapresentapply.setCity_buy(rs.getInt("city_buy"));//购车城市
		tbdatapresentapply.setTransid(rs.getInt("transid"));//确认的成交表id
		tbdatapresentapply.setPostbill_code(rs.getString("postbill_code"));//快递单号
		tbdatapresentapply.setEntry_type(rs.getInt("entry_type"));//0-pc版插入的数据 1-app版插入的数据
		tbdatapresentapply.setOrder_number(rs.getString("order_number"));//订单编号-目前app在使用
		tbdatapresentapply.setComment(rs.getString("comment"));//礼品备注
		tbdatapresentapply.setIs_del(rs.getInt("is_del"));//是否已被删除
	}

	public static List<TbDataPresentApply> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_data_present_apply";
		List<TbDataPresentApply> list = new ArrayList<TbDataPresentApply>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataPresentApply tbdatapresentapply = new TbDataPresentApply();
				fill(rs, tbdatapresentapply);
				list.add(tbdatapresentapply);
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


	public static List<TbDataPresentApply> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_data_present_apply where "+subsql+"";
		List<TbDataPresentApply> list = new ArrayList<TbDataPresentApply>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataPresentApply tbdatapresentapply = new TbDataPresentApply();
				fill(rs, tbdatapresentapply);
				list.add(tbdatapresentapply);
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
		String sql = "select count(*) from tb_data_present_apply where "+subsql+"";
		
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
		String sql = "delete from tb_data_present_apply where "+subsql+"";
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
		String sql = "delete from tb_data_present_apply where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbDataPresentApply tbdatapresentapply) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_data_present_apply(`id`,`owner_name`,`owner_phone`,`owner_carcode`,`owner_address`,`owner_idcode`,`travelcard_date`,`carbill_date`,`giftverify_img`,`carbill_img`,`travelcard_img`,`idcard_img`,`car_img`,`engine_num`,`vin_num`,`owner_remark`,`remark`,`apply_state`,`apply_date`,`city_buy`,`transid`,`postbill_code`,`entry_type`,`order_number`,`comment`,`is_del`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdatapresentapply.getId());
		dbc.setString(2, tbdatapresentapply.getOwner_name());
		dbc.setString(3, tbdatapresentapply.getOwner_phone());
		dbc.setString(4, tbdatapresentapply.getOwner_carcode());
		dbc.setString(5, tbdatapresentapply.getOwner_address());
		dbc.setString(6, tbdatapresentapply.getOwner_idcode());
		dbc.setTimestamp(7, new Timestamp(tbdatapresentapply.getTravelcard_date().getTime()));
		dbc.setTimestamp(8, new Timestamp(tbdatapresentapply.getCarbill_date().getTime()));
		dbc.setString(9, tbdatapresentapply.getGiftverify_img());
		dbc.setString(10, tbdatapresentapply.getCarbill_img());
		dbc.setString(11, tbdatapresentapply.getTravelcard_img());
		dbc.setString(12, tbdatapresentapply.getIdcard_img());
		dbc.setString(13, tbdatapresentapply.getCar_img());
		dbc.setString(14, tbdatapresentapply.getEngine_num());
		dbc.setString(15, tbdatapresentapply.getVin_num());
		dbc.setString(16, tbdatapresentapply.getOwner_remark());
		dbc.setString(17, tbdatapresentapply.getRemark());
		dbc.setInt(18, tbdatapresentapply.getApply_state());
		dbc.setTimestamp(19, new Timestamp(tbdatapresentapply.getApply_date().getTime()));
		dbc.setInt(20, tbdatapresentapply.getCity_buy());
		dbc.setInt(21, tbdatapresentapply.getTransid());
		dbc.setString(22, tbdatapresentapply.getPostbill_code());
		dbc.setInt(23, tbdatapresentapply.getEntry_type());
		dbc.setString(24, tbdatapresentapply.getOrder_number());
		dbc.setString(25, tbdatapresentapply.getComment());
		dbc.setInt(26, tbdatapresentapply.getIs_del());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbDataPresentApply tbdatapresentapply) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_data_present_apply(`id`,`owner_name`,`owner_phone`,`owner_carcode`,`owner_address`,`owner_idcode`,`travelcard_date`,`carbill_date`,`giftverify_img`,`carbill_img`,`travelcard_img`,`idcard_img`,`car_img`,`engine_num`,`vin_num`,`owner_remark`,`remark`,`apply_state`,`apply_date`,`city_buy`,`transid`,`postbill_code`,`entry_type`,`order_number`,`comment`,`is_del`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdatapresentapply.getId());
		dbc.setString(2, tbdatapresentapply.getOwner_name());
		dbc.setString(3, tbdatapresentapply.getOwner_phone());
		dbc.setString(4, tbdatapresentapply.getOwner_carcode());
		dbc.setString(5, tbdatapresentapply.getOwner_address());
		dbc.setString(6, tbdatapresentapply.getOwner_idcode());
		dbc.setTimestamp(7, new Timestamp(tbdatapresentapply.getTravelcard_date().getTime()));
		dbc.setTimestamp(8, new Timestamp(tbdatapresentapply.getCarbill_date().getTime()));
		dbc.setString(9, tbdatapresentapply.getGiftverify_img());
		dbc.setString(10, tbdatapresentapply.getCarbill_img());
		dbc.setString(11, tbdatapresentapply.getTravelcard_img());
		dbc.setString(12, tbdatapresentapply.getIdcard_img());
		dbc.setString(13, tbdatapresentapply.getCar_img());
		dbc.setString(14, tbdatapresentapply.getEngine_num());
		dbc.setString(15, tbdatapresentapply.getVin_num());
		dbc.setString(16, tbdatapresentapply.getOwner_remark());
		dbc.setString(17, tbdatapresentapply.getRemark());
		dbc.setInt(18, tbdatapresentapply.getApply_state());
		dbc.setTimestamp(19, new Timestamp(tbdatapresentapply.getApply_date().getTime()));
		dbc.setInt(20, tbdatapresentapply.getCity_buy());
		dbc.setInt(21, tbdatapresentapply.getTransid());
		dbc.setString(22, tbdatapresentapply.getPostbill_code());
		dbc.setInt(23, tbdatapresentapply.getEntry_type());
		dbc.setString(24, tbdatapresentapply.getOrder_number());
		dbc.setString(25, tbdatapresentapply.getComment());
		dbc.setInt(26, tbdatapresentapply.getIs_del());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbDataPresentApply tbdatapresentapply) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_data_present_apply set ");
		boolean flag = false;
		if(tbdatapresentapply.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",owner_name=?");
			}else{
				sb.append("owner_name=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",owner_phone=?");
			}else{
				sb.append("owner_phone=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",owner_carcode=?");
			}else{
				sb.append("owner_carcode=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",owner_address=?");
			}else{
				sb.append("owner_address=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",owner_idcode=?");
			}else{
				sb.append("owner_idcode=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",travelcard_date=?");
			}else{
				sb.append("travelcard_date=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",carbill_date=?");
			}else{
				sb.append("carbill_date=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",giftverify_img=?");
			}else{
				sb.append("giftverify_img=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",carbill_img=?");
			}else{
				sb.append("carbill_img=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",travelcard_img=?");
			}else{
				sb.append("travelcard_img=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",idcard_img=?");
			}else{
				sb.append("idcard_img=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",car_img=?");
			}else{
				sb.append("car_img=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",engine_num=?");
			}else{
				sb.append("engine_num=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",vin_num=?");
			}else{
				sb.append("vin_num=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",owner_remark=?");
			}else{
				sb.append("owner_remark=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",remark=?");
			}else{
				sb.append("remark=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",apply_state=?");
			}else{
				sb.append("apply_state=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[18]){
			if(flag){
				sb.append(",apply_date=?");
			}else{
				sb.append("apply_date=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[19]){
			if(flag){
				sb.append(",city_buy=?");
			}else{
				sb.append("city_buy=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[20]){
			if(flag){
				sb.append(",transid=?");
			}else{
				sb.append("transid=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[21]){
			if(flag){
				sb.append(",postbill_code=?");
			}else{
				sb.append("postbill_code=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[22]){
			if(flag){
				sb.append(",entry_type=?");
			}else{
				sb.append("entry_type=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[23]){
			if(flag){
				sb.append(",order_number=?");
			}else{
				sb.append("order_number=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[24]){
			if(flag){
				sb.append(",comment=?");
			}else{
				sb.append("comment=?");
				flag=true;
			}
		}
		if(tbdatapresentapply.COLUMN_FLAG[25]){
			if(flag){
				sb.append(",is_del=?");
			}else{
				sb.append("is_del=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbdatapresentapply.COLUMN_FLAG[0]){
			dbc.setInt(k, tbdatapresentapply.getId());k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[1]){
			dbc.setString(k, tbdatapresentapply.getOwner_name());k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[2]){
			dbc.setString(k, tbdatapresentapply.getOwner_phone());k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[3]){
			dbc.setString(k, tbdatapresentapply.getOwner_carcode());k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[4]){
			dbc.setString(k, tbdatapresentapply.getOwner_address());k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[5]){
			dbc.setString(k, tbdatapresentapply.getOwner_idcode());k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[6]){
			dbc.setTimestamp(k, new Timestamp(tbdatapresentapply.getTravelcard_date().getTime()));k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[7]){
			dbc.setTimestamp(k, new Timestamp(tbdatapresentapply.getCarbill_date().getTime()));k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[8]){
			dbc.setString(k, tbdatapresentapply.getGiftverify_img());k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[9]){
			dbc.setString(k, tbdatapresentapply.getCarbill_img());k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[10]){
			dbc.setString(k, tbdatapresentapply.getTravelcard_img());k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[11]){
			dbc.setString(k, tbdatapresentapply.getIdcard_img());k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[12]){
			dbc.setString(k, tbdatapresentapply.getCar_img());k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[13]){
			dbc.setString(k, tbdatapresentapply.getEngine_num());k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[14]){
			dbc.setString(k, tbdatapresentapply.getVin_num());k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[15]){
			dbc.setString(k, tbdatapresentapply.getOwner_remark());k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[16]){
			dbc.setString(k, tbdatapresentapply.getRemark());k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[17]){
			dbc.setInt(k, tbdatapresentapply.getApply_state());k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[18]){
			dbc.setTimestamp(k, new Timestamp(tbdatapresentapply.getApply_date().getTime()));k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[19]){
			dbc.setInt(k, tbdatapresentapply.getCity_buy());k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[20]){
			dbc.setInt(k, tbdatapresentapply.getTransid());k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[21]){
			dbc.setString(k, tbdatapresentapply.getPostbill_code());k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[22]){
			dbc.setInt(k, tbdatapresentapply.getEntry_type());k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[23]){
			dbc.setString(k, tbdatapresentapply.getOrder_number());k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[24]){
			dbc.setString(k, tbdatapresentapply.getComment());k++;
		}
		if(tbdatapresentapply.COLUMN_FLAG[25]){
			dbc.setInt(k, tbdatapresentapply.getIs_del());k++;
		}
		dbc.setInt(k, tbdatapresentapply.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbDataPresentApply tbdatapresentapply) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbdatapresentapply);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}