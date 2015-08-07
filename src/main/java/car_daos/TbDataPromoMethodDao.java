package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbDataPromoMethod;

public class  TbDataPromoMethodDao  extends BaseDao {

	public static void fill(ResultSet rs, TbDataPromoMethod tbdatapromomethod) throws SQLException {
		tbdatapromomethod.setPromo_id(rs.getInt("promo_id"));//推广方案id
		tbdatapromomethod.setPro_num(rs.getString("pro_num"));//项目编号
		tbdatapromomethod.setPromo_channel(rs.getString("promo_channel"));//推广渠道
		tbdatapromomethod.setPromo_url(rs.getString("promo_url"));//url
		tbdatapromomethod.setPromo_pageid(rs.getString("promo_pageid"));//页面标识
		tbdatapromomethod.setPromo_date(rs.getTimestamp("promo_date"));//推广日期
		tbdatapromomethod.setPromo_remarks(rs.getString("promo_remarks"));//url
	}

	public static List<TbDataPromoMethod> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_data_promo_method";
		List<TbDataPromoMethod> list = new ArrayList<TbDataPromoMethod>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataPromoMethod tbdatapromomethod = new TbDataPromoMethod();
				fill(rs, tbdatapromomethod);
				list.add(tbdatapromomethod);
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


	public static List<TbDataPromoMethod> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_data_promo_method where "+subsql+"";
		List<TbDataPromoMethod> list = new ArrayList<TbDataPromoMethod>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataPromoMethod tbdatapromomethod = new TbDataPromoMethod();
				fill(rs, tbdatapromomethod);
				list.add(tbdatapromomethod);
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
		String sql = "select count(*) from tb_data_promo_method where "+subsql+"";
		
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
		String sql = "delete from tb_data_promo_method where "+subsql+"";
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
		String sql = "delete from tb_data_promo_method where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbDataPromoMethod tbdatapromomethod) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_data_promo_method(`promo_id`,`pro_num`,`promo_channel`,`promo_url`,`promo_pageid`,`promo_date`,`promo_remarks`) values(?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdatapromomethod.getPromo_id());
		dbc.setString(2, tbdatapromomethod.getPro_num());
		dbc.setString(3, tbdatapromomethod.getPromo_channel());
		dbc.setString(4, tbdatapromomethod.getPromo_url());
		dbc.setString(5, tbdatapromomethod.getPromo_pageid());
		dbc.setTimestamp(6, new Timestamp(tbdatapromomethod.getPromo_date().getTime()));
		dbc.setString(7, tbdatapromomethod.getPromo_remarks());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbDataPromoMethod tbdatapromomethod) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_data_promo_method(`promo_id`,`pro_num`,`promo_channel`,`promo_url`,`promo_pageid`,`promo_date`,`promo_remarks`) values(?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdatapromomethod.getPromo_id());
		dbc.setString(2, tbdatapromomethod.getPro_num());
		dbc.setString(3, tbdatapromomethod.getPromo_channel());
		dbc.setString(4, tbdatapromomethod.getPromo_url());
		dbc.setString(5, tbdatapromomethod.getPromo_pageid());
		dbc.setTimestamp(6, new Timestamp(tbdatapromomethod.getPromo_date().getTime()));
		dbc.setString(7, tbdatapromomethod.getPromo_remarks());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbDataPromoMethod tbdatapromomethod) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_data_promo_method set ");
		boolean flag = false;
		if(tbdatapromomethod.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",promo_id=?");
			}else{
				sb.append("promo_id=?");
				flag=true;
			}
		}
		if(tbdatapromomethod.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",pro_num=?");
			}else{
				sb.append("pro_num=?");
				flag=true;
			}
		}
		if(tbdatapromomethod.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",promo_channel=?");
			}else{
				sb.append("promo_channel=?");
				flag=true;
			}
		}
		if(tbdatapromomethod.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",promo_url=?");
			}else{
				sb.append("promo_url=?");
				flag=true;
			}
		}
		if(tbdatapromomethod.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",promo_pageid=?");
			}else{
				sb.append("promo_pageid=?");
				flag=true;
			}
		}
		if(tbdatapromomethod.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",promo_date=?");
			}else{
				sb.append("promo_date=?");
				flag=true;
			}
		}
		if(tbdatapromomethod.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",promo_remarks=?");
			}else{
				sb.append("promo_remarks=?");
				flag=true;
			}
		}
		sb.append(" where promo_id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbdatapromomethod.COLUMN_FLAG[0]){
			dbc.setInt(k, tbdatapromomethod.getPromo_id());k++;
		}
		if(tbdatapromomethod.COLUMN_FLAG[1]){
			dbc.setString(k, tbdatapromomethod.getPro_num());k++;
		}
		if(tbdatapromomethod.COLUMN_FLAG[2]){
			dbc.setString(k, tbdatapromomethod.getPromo_channel());k++;
		}
		if(tbdatapromomethod.COLUMN_FLAG[3]){
			dbc.setString(k, tbdatapromomethod.getPromo_url());k++;
		}
		if(tbdatapromomethod.COLUMN_FLAG[4]){
			dbc.setString(k, tbdatapromomethod.getPromo_pageid());k++;
		}
		if(tbdatapromomethod.COLUMN_FLAG[5]){
			dbc.setTimestamp(k, new Timestamp(tbdatapromomethod.getPromo_date().getTime()));k++;
		}
		if(tbdatapromomethod.COLUMN_FLAG[6]){
			dbc.setString(k, tbdatapromomethod.getPromo_remarks());k++;
		}
		dbc.setInt(k, tbdatapromomethod.getPromo_id());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbDataPromoMethod tbdatapromomethod) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbdatapromomethod);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}