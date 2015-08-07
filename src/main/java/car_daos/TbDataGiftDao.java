package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbDataGift;

public class  TbDataGiftDao  extends BaseDao {

	public static void fill(ResultSet rs, TbDataGift tbdatagift) throws SQLException {
		tbdatagift.setGift_id(rs.getInt("gift_id"));//礼品id
		tbdatagift.setGift_name(rs.getString("gift_name"));//礼品名称
		tbdatagift.setGift_price(rs.getString("gift_price"));//礼品名称
		tbdatagift.setGift_addtime(rs.getTimestamp("gift_addtime"));//添加时间
		tbdatagift.setIsdel(rs.getInt("isdel"));//是否被删除
	}

	public static List<TbDataGift> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_data_gift";
		List<TbDataGift> list = new ArrayList<TbDataGift>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataGift tbdatagift = new TbDataGift();
				fill(rs, tbdatagift);
				list.add(tbdatagift);
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


	public static List<TbDataGift> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_data_gift where "+subsql+"";
		List<TbDataGift> list = new ArrayList<TbDataGift>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataGift tbdatagift = new TbDataGift();
				fill(rs, tbdatagift);
				list.add(tbdatagift);
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
		String sql = "select count(*) from tb_data_gift where "+subsql+"";
		
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
		String sql = "delete from tb_data_gift where "+subsql+"";
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
		String sql = "delete from tb_data_gift where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbDataGift tbdatagift) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_data_gift(`gift_id`,`gift_name`,`gift_price`,`gift_addtime`,`isdel`) values(?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdatagift.getGift_id());
		dbc.setString(2, tbdatagift.getGift_name());
		dbc.setString(3, tbdatagift.getGift_price());
		dbc.setTimestamp(4, new Timestamp(tbdatagift.getGift_addtime().getTime()));
		dbc.setInt(5, tbdatagift.getIsdel());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbDataGift tbdatagift) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_data_gift(`gift_id`,`gift_name`,`gift_price`,`gift_addtime`,`isdel`) values(?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdatagift.getGift_id());
		dbc.setString(2, tbdatagift.getGift_name());
		dbc.setString(3, tbdatagift.getGift_price());
		dbc.setTimestamp(4, new Timestamp(tbdatagift.getGift_addtime().getTime()));
		dbc.setInt(5, tbdatagift.getIsdel());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbDataGift tbdatagift) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_data_gift set ");
		boolean flag = false;
		if(tbdatagift.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",gift_id=?");
			}else{
				sb.append("gift_id=?");
				flag=true;
			}
		}
		if(tbdatagift.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",gift_name=?");
			}else{
				sb.append("gift_name=?");
				flag=true;
			}
		}
		if(tbdatagift.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",gift_price=?");
			}else{
				sb.append("gift_price=?");
				flag=true;
			}
		}
		if(tbdatagift.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",gift_addtime=?");
			}else{
				sb.append("gift_addtime=?");
				flag=true;
			}
		}
		if(tbdatagift.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",isdel=?");
			}else{
				sb.append("isdel=?");
				flag=true;
			}
		}
		sb.append(" where gift_id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbdatagift.COLUMN_FLAG[0]){
			dbc.setInt(k, tbdatagift.getGift_id());k++;
		}
		if(tbdatagift.COLUMN_FLAG[1]){
			dbc.setString(k, tbdatagift.getGift_name());k++;
		}
		if(tbdatagift.COLUMN_FLAG[2]){
			dbc.setString(k, tbdatagift.getGift_price());k++;
		}
		if(tbdatagift.COLUMN_FLAG[3]){
			dbc.setTimestamp(k, new Timestamp(tbdatagift.getGift_addtime().getTime()));k++;
		}
		if(tbdatagift.COLUMN_FLAG[4]){
			dbc.setInt(k, tbdatagift.getIsdel());k++;
		}
		dbc.setInt(k, tbdatagift.getGift_id());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbDataGift tbdatagift) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbdatagift);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}