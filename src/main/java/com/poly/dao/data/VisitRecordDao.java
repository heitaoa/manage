package com.poly.dao.data;

import java.sql.Timestamp;

import car_beans.TbDataVisitRecord;
import car_daos.DBConnect;
import car_daos.TbDataVisitRecordDao;

public class VisitRecordDao extends TbDataVisitRecordDao{
	public static int update(TbDataVisitRecord tbdatavisitrecord) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbdatavisitrecord);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static int update(DBConnect dbc,TbDataVisitRecord tbdatavisitrecord) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_data_visit_record set ");
		boolean flag = false;
		if(tbdatavisitrecord.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",record_id=?");
			}else{
				sb.append("record_id=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",pro_num=?");
			}else{
				sb.append("pro_num=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",phone=?");
			}else{
				sb.append("phone=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",name=?");
			}else{
				sb.append("name=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",baoming_id=?");
			}else{
				sb.append("baoming_id=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",return_visit_state=?");
			}else{
				sb.append("return_visit_state=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",is_key_cus=?");
			}else{
				sb.append("is_key_cus=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",phoneerror=?");
			}else{
				sb.append("phoneerror=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",return_visit_time=?");
			}else{
				sb.append("return_visit_time=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",return_visit_content=CONCAT(return_visit_content,'*',?)");
			}else{
				sb.append("return_visit_content= CONCAT(return_visit_content,'*',?)");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",return_visit_man=?");
			}else{
				sb.append("return_visit_man=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",tuisong_flag=?");
			}else{
				sb.append("tuisong_flag=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",attend_type=?");
			}else{
				sb.append("attend_type=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",attend_date=?");
			}else{
				sb.append("attend_date=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",phone_state=?");
			}else{
				sb.append("phone_state=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",is_jp=?");
			}else{
				sb.append("is_jp=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",jp_car=?");
			}else{
				sb.append("jp_car=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",is_buycar=?");
			}else{
				sb.append("is_buycar=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[18]){
			if(flag){
				sb.append(",buy_state=?");
			}else{
				sb.append("buy_state=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[19]){
			if(flag){
				sb.append(",phoneerror_count=?");
			}else{
				sb.append("phoneerror_count=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[20]){
			if(flag){
				sb.append(",is_reach=?");
			}else{
				sb.append("is_reach=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[21]){
			if(flag){
				sb.append(",is_trans=?");
			}else{
				sb.append("is_trans=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[22]){
			if(flag){
				sb.append(",is_invite=?");
			}else{
				sb.append("is_invite=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[23]){
			if(flag){
				sb.append(",brand=?");
			}else{
				sb.append("brand=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[24]){
			if(flag){
				sb.append(",serial=?");
			}else{
				sb.append("serial=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[25]){
			if(flag){
				sb.append(",model=?");
			}else{
				sb.append("model=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[26]){
			if(flag){
				sb.append(",phone_prov=?");
			}else{
				sb.append("phone_prov=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[27]){
			if(flag){
				sb.append(",phone_city=?");
			}else{
				sb.append("phone_city=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[28]){
			if(flag){
				sb.append(",ip=?");
			}else{
				sb.append("ip=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[29]){
			if(flag){
				sb.append(",prov=?");
			}else{
				sb.append("prov=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[30]){
			if(flag){
				sb.append(",city=?");
			}else{
				sb.append("city=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[31]){
			if(flag){
				sb.append(",buycar_emergency=?");
			}else{
				sb.append("buycar_emergency=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[32]){
			if(flag){
				sb.append(",pp_state=?");
			}else{
				sb.append("pp_state=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[33]){
			if(flag){
				sb.append(",pz_city=?");
			}else{
				sb.append("pz_city=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[34]){
			if(flag){
				sb.append(",buy_ys=?");
			}else{
				sb.append("buy_ys=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[35]){
			if(flag){
				sb.append(",buy_bsx=?");
			}else{
				sb.append("buy_bsx=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[36]){
			if(flag){
				sb.append(",buy_pl=?");
			}else{
				sb.append("buy_pl=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[37]){
			if(flag){
				sb.append(",buy_color=?");
			}else{
				sb.append("buy_color=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[38]){
			if(flag){
				sb.append(",know_yh=?");
			}else{
				sb.append("know_yh=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[39]){
			if(flag){
				sb.append(",p_job=?");
			}else{
				sb.append("p_job=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[40]){
			if(flag){
				sb.append(",p_weixin=?");
			}else{
				sb.append("p_weixin=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[41]){
			if(flag){
				sb.append(",p_qq=?");
			}else{
				sb.append("p_qq=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[42]){
			if(flag){
				sb.append(",baoming_date=?");
			}else{
				sb.append("baoming_date=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[43]){
			if(flag){
				sb.append(",bz=?");
			}else{
				sb.append("bz=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[44]){
			if(flag){
				sb.append(",require=?");
			}else{
				sb.append("require=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[45]){
			if(flag){
				sb.append(",research=?");
			}else{
				sb.append("research=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[46]){
			if(flag){
				sb.append(",not_store_reason=?");
			}else{
				sb.append("not_store_reason=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[47]){
			if(flag){
				sb.append(",lose_reason=?");
			}else{
				sb.append("lose_reason=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[48]){
			if(flag){
				sb.append(",satisfy=?");
			}else{
				sb.append("satisfy=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[49]){
			if(flag){
				sb.append(",advise=?");
			}else{
				sb.append("advise=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[50]){
			if(flag){
				sb.append(",satisfy_date=?");
			}else{
				sb.append("satisfy_date=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[51]){
			if(flag){
				sb.append(",satisfy_state=?");
			}else{
				sb.append("satisfy_state=?");
				flag=true;
			}
		}
		sb.append(" where record_id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbdatavisitrecord.COLUMN_FLAG[0]){
			dbc.setInt(k, tbdatavisitrecord.getRecord_id());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[1]){
			dbc.setString(k, tbdatavisitrecord.getPro_num());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[2]){
			dbc.setString(k, tbdatavisitrecord.getPhone());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[3]){
			dbc.setString(k, tbdatavisitrecord.getName());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[4]){
			dbc.setInt(k, tbdatavisitrecord.getBaoming_id());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[5]){
			dbc.setInt(k, tbdatavisitrecord.getReturn_visit_state());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[6]){
			dbc.setInt(k, tbdatavisitrecord.getIs_key_cus());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[7]){
			dbc.setInt(k, tbdatavisitrecord.getPhoneerror());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[8]){
			dbc.setTimestamp(k, new Timestamp(tbdatavisitrecord.getReturn_visit_time().getTime()));k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[9]){
			dbc.setString(k, tbdatavisitrecord.getReturn_visit_content());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[10]){
			dbc.setString(k, tbdatavisitrecord.getReturn_visit_man());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[11]){
			dbc.setInt(k, tbdatavisitrecord.getTuisong_flag());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[12]){
			dbc.setInt(k, tbdatavisitrecord.getAttend_type());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[13]){
			dbc.setString(k, tbdatavisitrecord.getAttend_date());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[14]){
			dbc.setInt(k, tbdatavisitrecord.getPhone_state());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[15]){
			dbc.setInt(k, tbdatavisitrecord.getIs_jp());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[16]){
			dbc.setString(k, tbdatavisitrecord.getJp_car());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[17]){
			dbc.setInt(k, tbdatavisitrecord.getIs_buycar());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[18]){
			dbc.setInt(k, tbdatavisitrecord.getBuy_state());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[19]){
			dbc.setInt(k, tbdatavisitrecord.getPhoneerror_count());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[20]){
			dbc.setInt(k, tbdatavisitrecord.getIs_reach());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[21]){
			dbc.setInt(k, tbdatavisitrecord.getIs_trans());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[22]){
			dbc.setInt(k, tbdatavisitrecord.getIs_invite());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[23]){
			dbc.setInt(k, tbdatavisitrecord.getBrand());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[24]){
			dbc.setInt(k, tbdatavisitrecord.getSerial());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[25]){
			dbc.setInt(k, tbdatavisitrecord.getModel());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[26]){
			dbc.setInt(k, tbdatavisitrecord.getPhone_prov());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[27]){
			dbc.setInt(k, tbdatavisitrecord.getPhone_city());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[28]){
			dbc.setString(k, tbdatavisitrecord.getIp());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[29]){
			dbc.setInt(k, tbdatavisitrecord.getProv());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[30]){
			dbc.setInt(k, tbdatavisitrecord.getCity());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[31]){
			dbc.setInt(k, tbdatavisitrecord.getBuycar_emergency());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[32]){
			dbc.setString(k, tbdatavisitrecord.getPp_state());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[33]){
			dbc.setString(k, tbdatavisitrecord.getPz_city());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[34]){
			dbc.setString(k, tbdatavisitrecord.getBuy_ys());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[35]){
			dbc.setInt(k, tbdatavisitrecord.getBuy_bsx());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[36]){
			dbc.setString(k, tbdatavisitrecord.getBuy_pl());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[37]){
			dbc.setString(k, tbdatavisitrecord.getBuy_color());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[38]){
			dbc.setString(k, tbdatavisitrecord.getKnow_yh());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[39]){
			dbc.setInt(k, tbdatavisitrecord.getP_job());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[40]){
			dbc.setString(k, tbdatavisitrecord.getP_weixin());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[41]){
			dbc.setString(k, tbdatavisitrecord.getP_qq());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[42]){
			dbc.setTimestamp(k, new Timestamp(tbdatavisitrecord.getBaoming_date().getTime()));k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[43]){
			dbc.setString(k, tbdatavisitrecord.getBz());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[44]){
			dbc.setInt(k, tbdatavisitrecord.getRequire());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[45]){
			dbc.setInt(k, tbdatavisitrecord.getResearch());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[46]){
			dbc.setString(k, tbdatavisitrecord.getNot_store_reason());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[47]){
			dbc.setInt(k, tbdatavisitrecord.getLose_reason());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[48]){
			dbc.setInt(k, tbdatavisitrecord.getSatisfy());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[49]){
			dbc.setString(k, tbdatavisitrecord.getAdvise());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[50]){
			dbc.setTimestamp(k, new Timestamp(tbdatavisitrecord.getSatisfy_date().getTime()));k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[51]){
			dbc.setInt(k, tbdatavisitrecord.getSatisfy_state());k++;
		}
		dbc.setInt(k, tbdatavisitrecord.getRecord_id());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
}
