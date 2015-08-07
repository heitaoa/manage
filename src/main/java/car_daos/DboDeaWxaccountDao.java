package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaWxaccount;

public class  DboDeaWxaccountDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaWxaccount dbodeawxaccount) throws SQLException {
		dbodeawxaccount.setId(rs.getInt("id"));//
		dbodeawxaccount.setEid(rs.getInt("eid"));//
		dbodeawxaccount.setWx_name(rs.getString("wx_name"));//
		dbodeawxaccount.setWx_pwd(rs.getString("wx_pwd"));//
		dbodeawxaccount.setWx_account(rs.getString("wx_account"));//
		dbodeawxaccount.setWx_ok(rs.getInt("wx_ok"));//0-正在验证，1-成功，2-失败微信号的状态：-1：尚未绑定；2：0/3：验证中；1：绑定成功；2：验证失败；4：验证失败，可能资料不全
		dbodeawxaccount.setWx_qrurl(rs.getString("wx_qrurl"));//
		dbodeawxaccount.setAdddate(rs.getTimestamp("adddate"));//
		dbodeawxaccount.setLast_update(rs.getTimestamp("last_update"));//
		dbodeawxaccount.setAppid(rs.getString("appid"));//
		dbodeawxaccount.setAppsecret(rs.getString("appsecret"));//appid和appsecret可获取access_token（在线调试的token）
		dbodeawxaccount.setIs_service(rs.getInt("is_service"));//
		dbodeawxaccount.setBizuin(rs.getString("bizuin"));//
		dbodeawxaccount.setSlave_user(rs.getString("slave_user"));//微信cookie里面的账号
		dbodeawxaccount.setSlave_sid(rs.getString("slave_sid"));//微信cookie里面的加密串，和slave_user组成关键内容
		dbodeawxaccount.setWtoken(rs.getString("wtoken"));//
		dbodeawxaccount.setChecktime(rs.getTimestamp("checktime"));//上一次api检查时间
		dbodeawxaccount.setCookiecheckdate(rs.getTimestamp("cookiecheckdate"));//上一次更新cookie的时间
		dbodeawxaccount.setHasmenu(rs.getInt("hasmenu"));//
		dbodeawxaccount.setZhuti(rs.getInt("zhuti"));//微官网的风格
		dbodeawxaccount.setApiday(rs.getInt("apiday"));//
		dbodeawxaccount.setMenu_status(rs.getInt("menu_status"));//
		dbodeawxaccount.setIsaskingopen(rs.getInt("isaskingopen"));//是否开通询问功能
		dbodeawxaccount.setStatdate(rs.getInt("statdate"));//
		dbodeawxaccount.setUpdate_interval(rs.getInt("update_interval"));//
	}

	public static List<DboDeaWxaccount> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_wxaccount";
		List<DboDeaWxaccount> list = new ArrayList<DboDeaWxaccount>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaWxaccount dbodeawxaccount = new DboDeaWxaccount();
				fill(rs, dbodeawxaccount);
				list.add(dbodeawxaccount);
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


	public static List<DboDeaWxaccount> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_wxaccount where "+subsql+"";
		List<DboDeaWxaccount> list = new ArrayList<DboDeaWxaccount>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaWxaccount dbodeawxaccount = new DboDeaWxaccount();
				fill(rs, dbodeawxaccount);
				list.add(dbodeawxaccount);
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
		String sql = "select count(*) from dbo_dea_wxaccount where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_wxaccount where "+subsql+"";
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
		String sql = "delete from dbo_dea_wxaccount where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaWxaccount dbodeawxaccount) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_wxaccount(`id`,`eid`,`wx_name`,`wx_pwd`,`wx_account`,`wx_ok`,`wx_qrurl`,`adddate`,`last_update`,`appid`,`appsecret`,`is_service`,`bizuin`,`slave_user`,`slave_sid`,`wtoken`,`checktime`,`cookiecheckdate`,`hasmenu`,`zhuti`,`apiday`,`menu_status`,`isaskingopen`,`statdate`,`update_interval`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeawxaccount.getId());
		dbc.setInt(2, dbodeawxaccount.getEid());
		dbc.setString(3, dbodeawxaccount.getWx_name());
		dbc.setString(4, dbodeawxaccount.getWx_pwd());
		dbc.setString(5, dbodeawxaccount.getWx_account());
		dbc.setInt(6, dbodeawxaccount.getWx_ok());
		dbc.setString(7, dbodeawxaccount.getWx_qrurl());
		dbc.setTimestamp(8, new Timestamp(dbodeawxaccount.getAdddate().getTime()));
		dbc.setTimestamp(9, new Timestamp(dbodeawxaccount.getLast_update().getTime()));
		dbc.setString(10, dbodeawxaccount.getAppid());
		dbc.setString(11, dbodeawxaccount.getAppsecret());
		dbc.setInt(12, dbodeawxaccount.getIs_service());
		dbc.setString(13, dbodeawxaccount.getBizuin());
		dbc.setString(14, dbodeawxaccount.getSlave_user());
		dbc.setString(15, dbodeawxaccount.getSlave_sid());
		dbc.setString(16, dbodeawxaccount.getWtoken());
		dbc.setTimestamp(17, new Timestamp(dbodeawxaccount.getChecktime().getTime()));
		dbc.setTimestamp(18, new Timestamp(dbodeawxaccount.getCookiecheckdate().getTime()));
		dbc.setInt(19, dbodeawxaccount.getHasmenu());
		dbc.setInt(20, dbodeawxaccount.getZhuti());
		dbc.setInt(21, dbodeawxaccount.getApiday());
		dbc.setInt(22, dbodeawxaccount.getMenu_status());
		dbc.setInt(23, dbodeawxaccount.getIsaskingopen());
		dbc.setInt(24, dbodeawxaccount.getStatdate());
		dbc.setInt(25, dbodeawxaccount.getUpdate_interval());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaWxaccount dbodeawxaccount) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_wxaccount(`id`,`eid`,`wx_name`,`wx_pwd`,`wx_account`,`wx_ok`,`wx_qrurl`,`adddate`,`last_update`,`appid`,`appsecret`,`is_service`,`bizuin`,`slave_user`,`slave_sid`,`wtoken`,`checktime`,`cookiecheckdate`,`hasmenu`,`zhuti`,`apiday`,`menu_status`,`isaskingopen`,`statdate`,`update_interval`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeawxaccount.getId());
		dbc.setInt(2, dbodeawxaccount.getEid());
		dbc.setString(3, dbodeawxaccount.getWx_name());
		dbc.setString(4, dbodeawxaccount.getWx_pwd());
		dbc.setString(5, dbodeawxaccount.getWx_account());
		dbc.setInt(6, dbodeawxaccount.getWx_ok());
		dbc.setString(7, dbodeawxaccount.getWx_qrurl());
		dbc.setTimestamp(8, new Timestamp(dbodeawxaccount.getAdddate().getTime()));
		dbc.setTimestamp(9, new Timestamp(dbodeawxaccount.getLast_update().getTime()));
		dbc.setString(10, dbodeawxaccount.getAppid());
		dbc.setString(11, dbodeawxaccount.getAppsecret());
		dbc.setInt(12, dbodeawxaccount.getIs_service());
		dbc.setString(13, dbodeawxaccount.getBizuin());
		dbc.setString(14, dbodeawxaccount.getSlave_user());
		dbc.setString(15, dbodeawxaccount.getSlave_sid());
		dbc.setString(16, dbodeawxaccount.getWtoken());
		dbc.setTimestamp(17, new Timestamp(dbodeawxaccount.getChecktime().getTime()));
		dbc.setTimestamp(18, new Timestamp(dbodeawxaccount.getCookiecheckdate().getTime()));
		dbc.setInt(19, dbodeawxaccount.getHasmenu());
		dbc.setInt(20, dbodeawxaccount.getZhuti());
		dbc.setInt(21, dbodeawxaccount.getApiday());
		dbc.setInt(22, dbodeawxaccount.getMenu_status());
		dbc.setInt(23, dbodeawxaccount.getIsaskingopen());
		dbc.setInt(24, dbodeawxaccount.getStatdate());
		dbc.setInt(25, dbodeawxaccount.getUpdate_interval());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaWxaccount dbodeawxaccount) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_wxaccount set ");
		boolean flag = false;
		if(dbodeawxaccount.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",eid=?");
			}else{
				sb.append("eid=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",wx_name=?");
			}else{
				sb.append("wx_name=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",wx_pwd=?");
			}else{
				sb.append("wx_pwd=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",wx_account=?");
			}else{
				sb.append("wx_account=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",wx_ok=?");
			}else{
				sb.append("wx_ok=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",wx_qrurl=?");
			}else{
				sb.append("wx_qrurl=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",last_update=?");
			}else{
				sb.append("last_update=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",appid=?");
			}else{
				sb.append("appid=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",appsecret=?");
			}else{
				sb.append("appsecret=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",is_service=?");
			}else{
				sb.append("is_service=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",bizuin=?");
			}else{
				sb.append("bizuin=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",slave_user=?");
			}else{
				sb.append("slave_user=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",slave_sid=?");
			}else{
				sb.append("slave_sid=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",wtoken=?");
			}else{
				sb.append("wtoken=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",checktime=?");
			}else{
				sb.append("checktime=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",cookiecheckdate=?");
			}else{
				sb.append("cookiecheckdate=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[18]){
			if(flag){
				sb.append(",hasmenu=?");
			}else{
				sb.append("hasmenu=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[19]){
			if(flag){
				sb.append(",zhuti=?");
			}else{
				sb.append("zhuti=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[20]){
			if(flag){
				sb.append(",apiday=?");
			}else{
				sb.append("apiday=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[21]){
			if(flag){
				sb.append(",menu_status=?");
			}else{
				sb.append("menu_status=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[22]){
			if(flag){
				sb.append(",isaskingopen=?");
			}else{
				sb.append("isaskingopen=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[23]){
			if(flag){
				sb.append(",statdate=?");
			}else{
				sb.append("statdate=?");
				flag=true;
			}
		}
		if(dbodeawxaccount.COLUMN_FLAG[24]){
			if(flag){
				sb.append(",update_interval=?");
			}else{
				sb.append("update_interval=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeawxaccount.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeawxaccount.getId());k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[1]){
			dbc.setInt(k, dbodeawxaccount.getEid());k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[2]){
			dbc.setString(k, dbodeawxaccount.getWx_name());k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[3]){
			dbc.setString(k, dbodeawxaccount.getWx_pwd());k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[4]){
			dbc.setString(k, dbodeawxaccount.getWx_account());k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[5]){
			dbc.setInt(k, dbodeawxaccount.getWx_ok());k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[6]){
			dbc.setString(k, dbodeawxaccount.getWx_qrurl());k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[7]){
			dbc.setTimestamp(k, new Timestamp(dbodeawxaccount.getAdddate().getTime()));k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[8]){
			dbc.setTimestamp(k, new Timestamp(dbodeawxaccount.getLast_update().getTime()));k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[9]){
			dbc.setString(k, dbodeawxaccount.getAppid());k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[10]){
			dbc.setString(k, dbodeawxaccount.getAppsecret());k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[11]){
			dbc.setInt(k, dbodeawxaccount.getIs_service());k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[12]){
			dbc.setString(k, dbodeawxaccount.getBizuin());k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[13]){
			dbc.setString(k, dbodeawxaccount.getSlave_user());k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[14]){
			dbc.setString(k, dbodeawxaccount.getSlave_sid());k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[15]){
			dbc.setString(k, dbodeawxaccount.getWtoken());k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[16]){
			dbc.setTimestamp(k, new Timestamp(dbodeawxaccount.getChecktime().getTime()));k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[17]){
			dbc.setTimestamp(k, new Timestamp(dbodeawxaccount.getCookiecheckdate().getTime()));k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[18]){
			dbc.setInt(k, dbodeawxaccount.getHasmenu());k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[19]){
			dbc.setInt(k, dbodeawxaccount.getZhuti());k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[20]){
			dbc.setInt(k, dbodeawxaccount.getApiday());k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[21]){
			dbc.setInt(k, dbodeawxaccount.getMenu_status());k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[22]){
			dbc.setInt(k, dbodeawxaccount.getIsaskingopen());k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[23]){
			dbc.setInt(k, dbodeawxaccount.getStatdate());k++;
		}
		if(dbodeawxaccount.COLUMN_FLAG[24]){
			dbc.setInt(k, dbodeawxaccount.getUpdate_interval());k++;
		}
		dbc.setInt(k, dbodeawxaccount.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaWxaccount dbodeawxaccount) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeawxaccount);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}