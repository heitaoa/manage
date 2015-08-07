package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaDealerinfo;

public class  DboDeaDealerinfoDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaDealerinfo dbodeadealerinfo) throws SQLException {
		dbodeadealerinfo.setInfoid(rs.getInt("infoid"));//企业信息自增长id
		dbodeadealerinfo.setEid(rs.getInt("eid"));//企业id
		dbodeadealerinfo.setIsdelete(rs.getInt("isdelete"));//删除标识，0--正常，1--已删除
		dbodeadealerinfo.setAddress(rs.getString("address"));//企业地址
		dbodeadealerinfo.setIntro(rs.getString("intro"));//企业介绍
		dbodeadealerinfo.setZipcode(rs.getString("zipcode"));//邮编
		dbodeadealerinfo.setFaq(rs.getString("faq"));//传真
		dbodeadealerinfo.setWebaddress(rs.getString("webaddress"));//网址
		dbodeadealerinfo.setEmail(rs.getString("email"));//邮箱
		dbodeadealerinfo.setSalephone(rs.getString("salephone"));//销售电话
		dbodeadealerinfo.setTraffic(rs.getString("traffic"));//交通描述
		dbodeadealerinfo.setSpeech(rs.getString("speech"));//领导致辞
		dbodeadealerinfo.setHonor(rs.getString("honor"));//资质荣誉
		dbodeadealerinfo.setMapinfo(rs.getString("mapinfo"));//地图信息
		dbodeadealerinfo.setH_lat(rs.getString("h_lat"));//定位-北纬
		dbodeadealerinfo.setH_lng(rs.getString("h_lng"));//定位-东经
		dbodeadealerinfo.setQq(rs.getString("qq"));//
		dbodeadealerinfo.setWangwang(rs.getString("wangwang"));//
		dbodeadealerinfo.setSinaweibo(rs.getString("sinaweibo"));//
		dbodeadealerinfo.setAfterphone(rs.getString("afterphone"));//
		dbodeadealerinfo.setHelpphone(rs.getString("helpphone"));//
		dbodeadealerinfo.setNavurl(rs.getString("navurl"));//
	}

	public static List<DboDeaDealerinfo> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_dealerinfo";
		List<DboDeaDealerinfo> list = new ArrayList<DboDeaDealerinfo>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaDealerinfo dbodeadealerinfo = new DboDeaDealerinfo();
				fill(rs, dbodeadealerinfo);
				list.add(dbodeadealerinfo);
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


	public static List<DboDeaDealerinfo> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_dealerinfo where "+subsql+"";
		List<DboDeaDealerinfo> list = new ArrayList<DboDeaDealerinfo>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaDealerinfo dbodeadealerinfo = new DboDeaDealerinfo();
				fill(rs, dbodeadealerinfo);
				list.add(dbodeadealerinfo);
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
		String sql = "select count(*) from dbo_dea_dealerinfo where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_dealerinfo where "+subsql+"";
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
		String sql = "delete from dbo_dea_dealerinfo where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaDealerinfo dbodeadealerinfo) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_dealerinfo(`infoid`,`eid`,`isdelete`,`address`,`intro`,`zipcode`,`faq`,`webaddress`,`email`,`salephone`,`traffic`,`speech`,`honor`,`mapinfo`,`h_lat`,`h_lng`,`qq`,`wangwang`,`sinaweibo`,`afterphone`,`helpphone`,`navurl`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeadealerinfo.getInfoid());
		dbc.setInt(2, dbodeadealerinfo.getEid());
		dbc.setInt(3, dbodeadealerinfo.getIsdelete());
		dbc.setString(4, dbodeadealerinfo.getAddress());
		dbc.setString(5, dbodeadealerinfo.getIntro());
		dbc.setString(6, dbodeadealerinfo.getZipcode());
		dbc.setString(7, dbodeadealerinfo.getFaq());
		dbc.setString(8, dbodeadealerinfo.getWebaddress());
		dbc.setString(9, dbodeadealerinfo.getEmail());
		dbc.setString(10, dbodeadealerinfo.getSalephone());
		dbc.setString(11, dbodeadealerinfo.getTraffic());
		dbc.setString(12, dbodeadealerinfo.getSpeech());
		dbc.setString(13, dbodeadealerinfo.getHonor());
		dbc.setString(14, dbodeadealerinfo.getMapinfo());
		dbc.setString(15, dbodeadealerinfo.getH_lat());
		dbc.setString(16, dbodeadealerinfo.getH_lng());
		dbc.setString(17, dbodeadealerinfo.getQq());
		dbc.setString(18, dbodeadealerinfo.getWangwang());
		dbc.setString(19, dbodeadealerinfo.getSinaweibo());
		dbc.setString(20, dbodeadealerinfo.getAfterphone());
		dbc.setString(21, dbodeadealerinfo.getHelpphone());
		dbc.setString(22, dbodeadealerinfo.getNavurl());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaDealerinfo dbodeadealerinfo) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_dealerinfo(`infoid`,`eid`,`isdelete`,`address`,`intro`,`zipcode`,`faq`,`webaddress`,`email`,`salephone`,`traffic`,`speech`,`honor`,`mapinfo`,`h_lat`,`h_lng`,`qq`,`wangwang`,`sinaweibo`,`afterphone`,`helpphone`,`navurl`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeadealerinfo.getInfoid());
		dbc.setInt(2, dbodeadealerinfo.getEid());
		dbc.setInt(3, dbodeadealerinfo.getIsdelete());
		dbc.setString(4, dbodeadealerinfo.getAddress());
		dbc.setString(5, dbodeadealerinfo.getIntro());
		dbc.setString(6, dbodeadealerinfo.getZipcode());
		dbc.setString(7, dbodeadealerinfo.getFaq());
		dbc.setString(8, dbodeadealerinfo.getWebaddress());
		dbc.setString(9, dbodeadealerinfo.getEmail());
		dbc.setString(10, dbodeadealerinfo.getSalephone());
		dbc.setString(11, dbodeadealerinfo.getTraffic());
		dbc.setString(12, dbodeadealerinfo.getSpeech());
		dbc.setString(13, dbodeadealerinfo.getHonor());
		dbc.setString(14, dbodeadealerinfo.getMapinfo());
		dbc.setString(15, dbodeadealerinfo.getH_lat());
		dbc.setString(16, dbodeadealerinfo.getH_lng());
		dbc.setString(17, dbodeadealerinfo.getQq());
		dbc.setString(18, dbodeadealerinfo.getWangwang());
		dbc.setString(19, dbodeadealerinfo.getSinaweibo());
		dbc.setString(20, dbodeadealerinfo.getAfterphone());
		dbc.setString(21, dbodeadealerinfo.getHelpphone());
		dbc.setString(22, dbodeadealerinfo.getNavurl());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaDealerinfo dbodeadealerinfo) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_dealerinfo set ");
		boolean flag = false;
		if(dbodeadealerinfo.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",infoid=?");
			}else{
				sb.append("infoid=?");
				flag=true;
			}
		}
		if(dbodeadealerinfo.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",eid=?");
			}else{
				sb.append("eid=?");
				flag=true;
			}
		}
		if(dbodeadealerinfo.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dbodeadealerinfo.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",address=?");
			}else{
				sb.append("address=?");
				flag=true;
			}
		}
		if(dbodeadealerinfo.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",intro=?");
			}else{
				sb.append("intro=?");
				flag=true;
			}
		}
		if(dbodeadealerinfo.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",zipcode=?");
			}else{
				sb.append("zipcode=?");
				flag=true;
			}
		}
		if(dbodeadealerinfo.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",faq=?");
			}else{
				sb.append("faq=?");
				flag=true;
			}
		}
		if(dbodeadealerinfo.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",webaddress=?");
			}else{
				sb.append("webaddress=?");
				flag=true;
			}
		}
		if(dbodeadealerinfo.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",email=?");
			}else{
				sb.append("email=?");
				flag=true;
			}
		}
		if(dbodeadealerinfo.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",salephone=?");
			}else{
				sb.append("salephone=?");
				flag=true;
			}
		}
		if(dbodeadealerinfo.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",traffic=?");
			}else{
				sb.append("traffic=?");
				flag=true;
			}
		}
		if(dbodeadealerinfo.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",speech=?");
			}else{
				sb.append("speech=?");
				flag=true;
			}
		}
		if(dbodeadealerinfo.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",honor=?");
			}else{
				sb.append("honor=?");
				flag=true;
			}
		}
		if(dbodeadealerinfo.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",mapinfo=?");
			}else{
				sb.append("mapinfo=?");
				flag=true;
			}
		}
		if(dbodeadealerinfo.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",h_lat=?");
			}else{
				sb.append("h_lat=?");
				flag=true;
			}
		}
		if(dbodeadealerinfo.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",h_lng=?");
			}else{
				sb.append("h_lng=?");
				flag=true;
			}
		}
		if(dbodeadealerinfo.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",qq=?");
			}else{
				sb.append("qq=?");
				flag=true;
			}
		}
		if(dbodeadealerinfo.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",wangwang=?");
			}else{
				sb.append("wangwang=?");
				flag=true;
			}
		}
		if(dbodeadealerinfo.COLUMN_FLAG[18]){
			if(flag){
				sb.append(",sinaweibo=?");
			}else{
				sb.append("sinaweibo=?");
				flag=true;
			}
		}
		if(dbodeadealerinfo.COLUMN_FLAG[19]){
			if(flag){
				sb.append(",afterphone=?");
			}else{
				sb.append("afterphone=?");
				flag=true;
			}
		}
		if(dbodeadealerinfo.COLUMN_FLAG[20]){
			if(flag){
				sb.append(",helpphone=?");
			}else{
				sb.append("helpphone=?");
				flag=true;
			}
		}
		if(dbodeadealerinfo.COLUMN_FLAG[21]){
			if(flag){
				sb.append(",navurl=?");
			}else{
				sb.append("navurl=?");
				flag=true;
			}
		}
		sb.append(" where infoid=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeadealerinfo.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeadealerinfo.getInfoid());k++;
		}
		if(dbodeadealerinfo.COLUMN_FLAG[1]){
			dbc.setInt(k, dbodeadealerinfo.getEid());k++;
		}
		if(dbodeadealerinfo.COLUMN_FLAG[2]){
			dbc.setInt(k, dbodeadealerinfo.getIsdelete());k++;
		}
		if(dbodeadealerinfo.COLUMN_FLAG[3]){
			dbc.setString(k, dbodeadealerinfo.getAddress());k++;
		}
		if(dbodeadealerinfo.COLUMN_FLAG[4]){
			dbc.setString(k, dbodeadealerinfo.getIntro());k++;
		}
		if(dbodeadealerinfo.COLUMN_FLAG[5]){
			dbc.setString(k, dbodeadealerinfo.getZipcode());k++;
		}
		if(dbodeadealerinfo.COLUMN_FLAG[6]){
			dbc.setString(k, dbodeadealerinfo.getFaq());k++;
		}
		if(dbodeadealerinfo.COLUMN_FLAG[7]){
			dbc.setString(k, dbodeadealerinfo.getWebaddress());k++;
		}
		if(dbodeadealerinfo.COLUMN_FLAG[8]){
			dbc.setString(k, dbodeadealerinfo.getEmail());k++;
		}
		if(dbodeadealerinfo.COLUMN_FLAG[9]){
			dbc.setString(k, dbodeadealerinfo.getSalephone());k++;
		}
		if(dbodeadealerinfo.COLUMN_FLAG[10]){
			dbc.setString(k, dbodeadealerinfo.getTraffic());k++;
		}
		if(dbodeadealerinfo.COLUMN_FLAG[11]){
			dbc.setString(k, dbodeadealerinfo.getSpeech());k++;
		}
		if(dbodeadealerinfo.COLUMN_FLAG[12]){
			dbc.setString(k, dbodeadealerinfo.getHonor());k++;
		}
		if(dbodeadealerinfo.COLUMN_FLAG[13]){
			dbc.setString(k, dbodeadealerinfo.getMapinfo());k++;
		}
		if(dbodeadealerinfo.COLUMN_FLAG[14]){
			dbc.setString(k, dbodeadealerinfo.getH_lat());k++;
		}
		if(dbodeadealerinfo.COLUMN_FLAG[15]){
			dbc.setString(k, dbodeadealerinfo.getH_lng());k++;
		}
		if(dbodeadealerinfo.COLUMN_FLAG[16]){
			dbc.setString(k, dbodeadealerinfo.getQq());k++;
		}
		if(dbodeadealerinfo.COLUMN_FLAG[17]){
			dbc.setString(k, dbodeadealerinfo.getWangwang());k++;
		}
		if(dbodeadealerinfo.COLUMN_FLAG[18]){
			dbc.setString(k, dbodeadealerinfo.getSinaweibo());k++;
		}
		if(dbodeadealerinfo.COLUMN_FLAG[19]){
			dbc.setString(k, dbodeadealerinfo.getAfterphone());k++;
		}
		if(dbodeadealerinfo.COLUMN_FLAG[20]){
			dbc.setString(k, dbodeadealerinfo.getHelpphone());k++;
		}
		if(dbodeadealerinfo.COLUMN_FLAG[21]){
			dbc.setString(k, dbodeadealerinfo.getNavurl());k++;
		}
		dbc.setInt(k, dbodeadealerinfo.getInfoid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaDealerinfo dbodeadealerinfo) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeadealerinfo);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static int DboDeaDealerinfoUpdateByeid(String faq,String zipcode,String email,String salephone,String afterphone,String helpphone,String address,String traffic,int eid){
	int result=EXECUTE_FAIL;
	DBConnect dbc = null;
	String sql = "update dbo_dea_dealerinfo set faq = ?,zipcode = ?,email = ?,salephone = ?,afterphone = ?,helpphone = ?,address = ?,traffic = ? where eid = ?";

	try {
		dbc = new DBConnect(sql);
		dbc.setString(1, faq);
		dbc.setString(2, zipcode);
		dbc.setString(3, email);
		dbc.setString(4, salephone);
		dbc.setString(5, afterphone);
		dbc.setString(6, helpphone);
		dbc.setString(7, address);
		dbc.setString(8, traffic);
		dbc.setInt(9, eid);
		dbc.executeUpdate();
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

	public static int DboDeaDealerinfoUpdateByeid(DBConnect dbc,String faq,String zipcode,String email,String salephone,String afterphone,String helpphone,String address,String traffic,int eid){
	int result=EXECUTE_FAIL;
	String sql = "update dbo_dea_dealerinfo set faq = ?,zipcode = ?,email = ?,salephone = ?,afterphone = ?,helpphone = ?,address = ?,traffic = ? where eid = ?";

	try {
		dbc.prepareStatement(sql);
		dbc.setString(1, faq);
		dbc.setString(2, zipcode);
		dbc.setString(3, email);
		dbc.setString(4, salephone);
		dbc.setString(5, afterphone);
		dbc.setString(6, helpphone);
		dbc.setString(7, address);
		dbc.setString(8, traffic);
		dbc.setInt(9, eid);
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
	}

	public static List<DboDeaDealerinfo> DboDeaDealerinfoSelectAllColumnByeid(int eid){
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_dealerinfo where eid = ?";
		List<DboDeaDealerinfo> list = new ArrayList<DboDeaDealerinfo>();
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, eid);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaDealerinfo obj = new DboDeaDealerinfo();
				fill(rs, obj);
				list.add(obj);
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
	public static int DboDeaDealerinfoUpdateByeid3(String intro,int eid){
	int result=EXECUTE_FAIL;
	DBConnect dbc = null;
	String sql = "update dbo_dea_dealerinfo set intro = ? where eid = ?";

	try {
		dbc = new DBConnect(sql);
		dbc.setString(1, intro);
		dbc.setInt(2, eid);
		dbc.executeUpdate();
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

	public static int DboDeaDealerinfoUpdateByeid3(DBConnect dbc,String intro,int eid){
	int result=EXECUTE_FAIL;
	String sql = "update dbo_dea_dealerinfo set intro = ? where eid = ?";

	try {
		dbc.prepareStatement(sql);
		dbc.setString(1, intro);
		dbc.setInt(2, eid);
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
	}
	public static int DboDeaDealerinfoUpdateByeid2(String address,int eid){
	int result=EXECUTE_FAIL;
	DBConnect dbc = null;
	String sql = "update dbo_dea_dealerinfo set address = ? where eid = ?";

	try {
		dbc = new DBConnect(sql);
		dbc.setString(1, address);
		dbc.setInt(2, eid);
		dbc.executeUpdate();
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

	public static int DboDeaDealerinfoUpdateByeid2(DBConnect dbc,String address,int eid){
	int result=EXECUTE_FAIL;
	String sql = "update dbo_dea_dealerinfo set address = ? where eid = ?";

	try {
		dbc.prepareStatement(sql);
		dbc.setString(1, address);
		dbc.setInt(2, eid);
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
	}
}