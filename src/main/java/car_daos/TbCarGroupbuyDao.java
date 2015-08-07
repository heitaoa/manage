package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbCarGroupbuy;

public class  TbCarGroupbuyDao  extends BaseDao {

	public static void fill(ResultSet rs, TbCarGroupbuy tbcargroupbuy) throws SQLException {
		tbcargroupbuy.setId(rs.getInt("id"));//
		tbcargroupbuy.setCarid(rs.getInt("carid"));//车型id
		tbcargroupbuy.setDeaid(rs.getInt("deaid"));//发布该信息的经销商id
		tbcargroupbuy.setPic(rs.getString("pic"));//团购页面图片
		tbcargroupbuy.setTitle(rs.getString("title"));//标题
		tbcargroupbuy.setAdddate(rs.getTimestamp("adddate"));//
		tbcargroupbuy.setBegdate(rs.getTimestamp("begdate"));//
		tbcargroupbuy.setEnddate(rs.getTimestamp("enddate"));//
		tbcargroupbuy.setAddress(rs.getString("address"));//地址
		tbcargroupbuy.setInfo(rs.getString("info"));//附加信息
		tbcargroupbuy.setRegister_num(rs.getInt("register_num"));//报名人数
		tbcargroupbuy.setPrice(rs.getDouble("price"));//售价
		tbcargroupbuy.setActive_type(rs.getInt("active_type"));//类型 0全部 1降价 2置换
		tbcargroupbuy.setBuy_type(rs.getInt("buy_type"));//0 团购大全 1 特卖惠
		tbcargroupbuy.setFatherid(rs.getInt("fatherid"));//车系id
		tbcargroupbuy.setIsdelete(rs.getInt("isdelete"));//是否被删除 0 未删除 1  已删除
		tbcargroupbuy.setSurplus_num(rs.getInt("surplus_num"));//剩余台数
		tbcargroupbuy.setTime_info(rs.getString("time_info"));//时间描述信息,有则直接显示
		tbcargroupbuy.setCar_info(rs.getString("car_info"));//车型描述信息，有则直接显示
		tbcargroupbuy.setSites_id(rs.getInt("sites_id"));//城市站id
	}

	public static List<TbCarGroupbuy> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_car_groupbuy";
		List<TbCarGroupbuy> list = new ArrayList<TbCarGroupbuy>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbCarGroupbuy tbcargroupbuy = new TbCarGroupbuy();
				fill(rs, tbcargroupbuy);
				list.add(tbcargroupbuy);
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


	public static List<TbCarGroupbuy> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_car_groupbuy where "+subsql+"";
		List<TbCarGroupbuy> list = new ArrayList<TbCarGroupbuy>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbCarGroupbuy tbcargroupbuy = new TbCarGroupbuy();
				fill(rs, tbcargroupbuy);
				list.add(tbcargroupbuy);
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
		String sql = "select count(*) from tb_car_groupbuy where "+subsql+"";
		
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
		String sql = "delete from tb_car_groupbuy where "+subsql+"";
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
		String sql = "delete from tb_car_groupbuy where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbCarGroupbuy tbcargroupbuy) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_car_groupbuy(`id`,`carid`,`deaid`,`pic`,`title`,`adddate`,`begdate`,`enddate`,`address`,`info`,`register_num`,`price`,`active_type`,`buy_type`,`fatherid`,`isdelete`,`surplus_num`,`time_info`,`car_info`,`sites_id`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbcargroupbuy.getId());
		dbc.setInt(2, tbcargroupbuy.getCarid());
		dbc.setInt(3, tbcargroupbuy.getDeaid());
		dbc.setString(4, tbcargroupbuy.getPic());
		dbc.setString(5, tbcargroupbuy.getTitle());
		dbc.setTimestamp(6, new Timestamp(tbcargroupbuy.getAdddate().getTime()));
		dbc.setTimestamp(7, new Timestamp(tbcargroupbuy.getBegdate().getTime()));
		dbc.setTimestamp(8, new Timestamp(tbcargroupbuy.getEnddate().getTime()));
		dbc.setString(9, tbcargroupbuy.getAddress());
		dbc.setString(10, tbcargroupbuy.getInfo());
		dbc.setInt(11, tbcargroupbuy.getRegister_num());
		dbc.setDouble(12, tbcargroupbuy.getPrice());
		dbc.setInt(13, tbcargroupbuy.getActive_type());
		dbc.setInt(14, tbcargroupbuy.getBuy_type());
		dbc.setInt(15, tbcargroupbuy.getFatherid());
		dbc.setInt(16, tbcargroupbuy.getIsdelete());
		dbc.setInt(17, tbcargroupbuy.getSurplus_num());
		dbc.setString(18, tbcargroupbuy.getTime_info());
		dbc.setString(19, tbcargroupbuy.getCar_info());
		dbc.setInt(20, tbcargroupbuy.getSites_id());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbCarGroupbuy tbcargroupbuy) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_car_groupbuy(`id`,`carid`,`deaid`,`pic`,`title`,`adddate`,`begdate`,`enddate`,`address`,`info`,`register_num`,`price`,`active_type`,`buy_type`,`fatherid`,`isdelete`,`surplus_num`,`time_info`,`car_info`,`sites_id`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbcargroupbuy.getId());
		dbc.setInt(2, tbcargroupbuy.getCarid());
		dbc.setInt(3, tbcargroupbuy.getDeaid());
		dbc.setString(4, tbcargroupbuy.getPic());
		dbc.setString(5, tbcargroupbuy.getTitle());
		dbc.setTimestamp(6, new Timestamp(tbcargroupbuy.getAdddate().getTime()));
		dbc.setTimestamp(7, new Timestamp(tbcargroupbuy.getBegdate().getTime()));
		dbc.setTimestamp(8, new Timestamp(tbcargroupbuy.getEnddate().getTime()));
		dbc.setString(9, tbcargroupbuy.getAddress());
		dbc.setString(10, tbcargroupbuy.getInfo());
		dbc.setInt(11, tbcargroupbuy.getRegister_num());
		dbc.setDouble(12, tbcargroupbuy.getPrice());
		dbc.setInt(13, tbcargroupbuy.getActive_type());
		dbc.setInt(14, tbcargroupbuy.getBuy_type());
		dbc.setInt(15, tbcargroupbuy.getFatherid());
		dbc.setInt(16, tbcargroupbuy.getIsdelete());
		dbc.setInt(17, tbcargroupbuy.getSurplus_num());
		dbc.setString(18, tbcargroupbuy.getTime_info());
		dbc.setString(19, tbcargroupbuy.getCar_info());
		dbc.setInt(20, tbcargroupbuy.getSites_id());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbCarGroupbuy tbcargroupbuy) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_car_groupbuy set ");
		boolean flag = false;
		if(tbcargroupbuy.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(tbcargroupbuy.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",carid=?");
			}else{
				sb.append("carid=?");
				flag=true;
			}
		}
		if(tbcargroupbuy.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",deaid=?");
			}else{
				sb.append("deaid=?");
				flag=true;
			}
		}
		if(tbcargroupbuy.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",pic=?");
			}else{
				sb.append("pic=?");
				flag=true;
			}
		}
		if(tbcargroupbuy.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",title=?");
			}else{
				sb.append("title=?");
				flag=true;
			}
		}
		if(tbcargroupbuy.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(tbcargroupbuy.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",begdate=?");
			}else{
				sb.append("begdate=?");
				flag=true;
			}
		}
		if(tbcargroupbuy.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",enddate=?");
			}else{
				sb.append("enddate=?");
				flag=true;
			}
		}
		if(tbcargroupbuy.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",address=?");
			}else{
				sb.append("address=?");
				flag=true;
			}
		}
		if(tbcargroupbuy.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",info=?");
			}else{
				sb.append("info=?");
				flag=true;
			}
		}
		if(tbcargroupbuy.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",register_num=?");
			}else{
				sb.append("register_num=?");
				flag=true;
			}
		}
		if(tbcargroupbuy.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",price=?");
			}else{
				sb.append("price=?");
				flag=true;
			}
		}
		if(tbcargroupbuy.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",active_type=?");
			}else{
				sb.append("active_type=?");
				flag=true;
			}
		}
		if(tbcargroupbuy.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",buy_type=?");
			}else{
				sb.append("buy_type=?");
				flag=true;
			}
		}
		if(tbcargroupbuy.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",fatherid=?");
			}else{
				sb.append("fatherid=?");
				flag=true;
			}
		}
		if(tbcargroupbuy.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(tbcargroupbuy.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",surplus_num=?");
			}else{
				sb.append("surplus_num=?");
				flag=true;
			}
		}
		if(tbcargroupbuy.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",time_info=?");
			}else{
				sb.append("time_info=?");
				flag=true;
			}
		}
		if(tbcargroupbuy.COLUMN_FLAG[18]){
			if(flag){
				sb.append(",car_info=?");
			}else{
				sb.append("car_info=?");
				flag=true;
			}
		}
		if(tbcargroupbuy.COLUMN_FLAG[19]){
			if(flag){
				sb.append(",sites_id=?");
			}else{
				sb.append("sites_id=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbcargroupbuy.COLUMN_FLAG[0]){
			dbc.setInt(k, tbcargroupbuy.getId());k++;
		}
		if(tbcargroupbuy.COLUMN_FLAG[1]){
			dbc.setInt(k, tbcargroupbuy.getCarid());k++;
		}
		if(tbcargroupbuy.COLUMN_FLAG[2]){
			dbc.setInt(k, tbcargroupbuy.getDeaid());k++;
		}
		if(tbcargroupbuy.COLUMN_FLAG[3]){
			dbc.setString(k, tbcargroupbuy.getPic());k++;
		}
		if(tbcargroupbuy.COLUMN_FLAG[4]){
			dbc.setString(k, tbcargroupbuy.getTitle());k++;
		}
		if(tbcargroupbuy.COLUMN_FLAG[5]){
			dbc.setTimestamp(k, new Timestamp(tbcargroupbuy.getAdddate().getTime()));k++;
		}
		if(tbcargroupbuy.COLUMN_FLAG[6]){
			dbc.setTimestamp(k, new Timestamp(tbcargroupbuy.getBegdate().getTime()));k++;
		}
		if(tbcargroupbuy.COLUMN_FLAG[7]){
			dbc.setTimestamp(k, new Timestamp(tbcargroupbuy.getEnddate().getTime()));k++;
		}
		if(tbcargroupbuy.COLUMN_FLAG[8]){
			dbc.setString(k, tbcargroupbuy.getAddress());k++;
		}
		if(tbcargroupbuy.COLUMN_FLAG[9]){
			dbc.setString(k, tbcargroupbuy.getInfo());k++;
		}
		if(tbcargroupbuy.COLUMN_FLAG[10]){
			dbc.setInt(k, tbcargroupbuy.getRegister_num());k++;
		}
		if(tbcargroupbuy.COLUMN_FLAG[11]){
			dbc.setDouble(k, tbcargroupbuy.getPrice());k++;
		}
		if(tbcargroupbuy.COLUMN_FLAG[12]){
			dbc.setInt(k, tbcargroupbuy.getActive_type());k++;
		}
		if(tbcargroupbuy.COLUMN_FLAG[13]){
			dbc.setInt(k, tbcargroupbuy.getBuy_type());k++;
		}
		if(tbcargroupbuy.COLUMN_FLAG[14]){
			dbc.setInt(k, tbcargroupbuy.getFatherid());k++;
		}
		if(tbcargroupbuy.COLUMN_FLAG[15]){
			dbc.setInt(k, tbcargroupbuy.getIsdelete());k++;
		}
		if(tbcargroupbuy.COLUMN_FLAG[16]){
			dbc.setInt(k, tbcargroupbuy.getSurplus_num());k++;
		}
		if(tbcargroupbuy.COLUMN_FLAG[17]){
			dbc.setString(k, tbcargroupbuy.getTime_info());k++;
		}
		if(tbcargroupbuy.COLUMN_FLAG[18]){
			dbc.setString(k, tbcargroupbuy.getCar_info());k++;
		}
		if(tbcargroupbuy.COLUMN_FLAG[19]){
			dbc.setInt(k, tbcargroupbuy.getSites_id());k++;
		}
		dbc.setInt(k, tbcargroupbuy.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbCarGroupbuy tbcargroupbuy) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbcargroupbuy);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}