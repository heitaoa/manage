package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaOrdercar;

public class  DboDeaOrdercarDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaOrdercar dbodeaordercar) throws SQLException {
		dbodeaordercar.setOrderid(rs.getInt("orderid"));//订单自增长id
		dbodeaordercar.setEid(rs.getInt("eid"));//企业id
		dbodeaordercar.setCarid(rs.getInt("carid"));//车型id
		dbodeaordercar.setOrderdate(rs.getTimestamp("orderdate"));//预订日期
		dbodeaordercar.setPhone(rs.getString("phone"));//客户手机
		dbodeaordercar.setCustomername(rs.getString("customername"));//客户姓名
		dbodeaordercar.setEmail(rs.getString("email"));//客户联系邮箱
		dbodeaordercar.setSupplement(rs.getString("supplement"));//补充说明
		dbodeaordercar.setState(rs.getInt("state"));//订单状态
		dbodeaordercar.setOrdertype(rs.getInt("ordertype"));//订单类型，0--非法类型，1--在线订单，2--预约试驾
		dbodeaordercar.setIsdelete(rs.getInt("isdelete"));//删除标识
		dbodeaordercar.setAreaid(rs.getInt("areaid"));//
		dbodeaordercar.setPresices(rs.getString("presices"));//
		dbodeaordercar.setUserid(rs.getInt("userid"));//
		dbodeaordercar.setFromsource(rs.getInt("fromsource"));//
	}

	public static List<DboDeaOrdercar> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_ordercar";
		List<DboDeaOrdercar> list = new ArrayList<DboDeaOrdercar>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaOrdercar dbodeaordercar = new DboDeaOrdercar();
				fill(rs, dbodeaordercar);
				list.add(dbodeaordercar);
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


	public static List<DboDeaOrdercar> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_ordercar where "+subsql+"";
		List<DboDeaOrdercar> list = new ArrayList<DboDeaOrdercar>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaOrdercar dbodeaordercar = new DboDeaOrdercar();
				fill(rs, dbodeaordercar);
				list.add(dbodeaordercar);
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
		String sql = "select count(*) from dbo_dea_ordercar where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_ordercar where "+subsql+"";
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
		String sql = "delete from dbo_dea_ordercar where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaOrdercar dbodeaordercar) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_ordercar(`orderid`,`eid`,`carid`,`orderdate`,`phone`,`customername`,`email`,`supplement`,`state`,`ordertype`,`isdelete`,`areaid`,`presices`,`userid`,`fromsource`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeaordercar.getOrderid());
		dbc.setInt(2, dbodeaordercar.getEid());
		dbc.setInt(3, dbodeaordercar.getCarid());
		dbc.setTimestamp(4, new Timestamp(dbodeaordercar.getOrderdate().getTime()));
		dbc.setString(5, dbodeaordercar.getPhone());
		dbc.setString(6, dbodeaordercar.getCustomername());
		dbc.setString(7, dbodeaordercar.getEmail());
		dbc.setString(8, dbodeaordercar.getSupplement());
		dbc.setInt(9, dbodeaordercar.getState());
		dbc.setInt(10, dbodeaordercar.getOrdertype());
		dbc.setInt(11, dbodeaordercar.getIsdelete());
		dbc.setInt(12, dbodeaordercar.getAreaid());
		dbc.setString(13, dbodeaordercar.getPresices());
		dbc.setInt(14, dbodeaordercar.getUserid());
		dbc.setInt(15, dbodeaordercar.getFromsource());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaOrdercar dbodeaordercar) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_ordercar(`orderid`,`eid`,`carid`,`orderdate`,`phone`,`customername`,`email`,`supplement`,`state`,`ordertype`,`isdelete`,`areaid`,`presices`,`userid`,`fromsource`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeaordercar.getOrderid());
		dbc.setInt(2, dbodeaordercar.getEid());
		dbc.setInt(3, dbodeaordercar.getCarid());
		dbc.setTimestamp(4, new Timestamp(dbodeaordercar.getOrderdate().getTime()));
		dbc.setString(5, dbodeaordercar.getPhone());
		dbc.setString(6, dbodeaordercar.getCustomername());
		dbc.setString(7, dbodeaordercar.getEmail());
		dbc.setString(8, dbodeaordercar.getSupplement());
		dbc.setInt(9, dbodeaordercar.getState());
		dbc.setInt(10, dbodeaordercar.getOrdertype());
		dbc.setInt(11, dbodeaordercar.getIsdelete());
		dbc.setInt(12, dbodeaordercar.getAreaid());
		dbc.setString(13, dbodeaordercar.getPresices());
		dbc.setInt(14, dbodeaordercar.getUserid());
		dbc.setInt(15, dbodeaordercar.getFromsource());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaOrdercar dbodeaordercar) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_ordercar set ");
		boolean flag = false;
		if(dbodeaordercar.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",orderid=?");
			}else{
				sb.append("orderid=?");
				flag=true;
			}
		}
		if(dbodeaordercar.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",eid=?");
			}else{
				sb.append("eid=?");
				flag=true;
			}
		}
		if(dbodeaordercar.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",carid=?");
			}else{
				sb.append("carid=?");
				flag=true;
			}
		}
		if(dbodeaordercar.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",orderdate=?");
			}else{
				sb.append("orderdate=?");
				flag=true;
			}
		}
		if(dbodeaordercar.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",phone=?");
			}else{
				sb.append("phone=?");
				flag=true;
			}
		}
		if(dbodeaordercar.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",customername=?");
			}else{
				sb.append("customername=?");
				flag=true;
			}
		}
		if(dbodeaordercar.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",email=?");
			}else{
				sb.append("email=?");
				flag=true;
			}
		}
		if(dbodeaordercar.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",supplement=?");
			}else{
				sb.append("supplement=?");
				flag=true;
			}
		}
		if(dbodeaordercar.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",state=?");
			}else{
				sb.append("state=?");
				flag=true;
			}
		}
		if(dbodeaordercar.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",ordertype=?");
			}else{
				sb.append("ordertype=?");
				flag=true;
			}
		}
		if(dbodeaordercar.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dbodeaordercar.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",areaid=?");
			}else{
				sb.append("areaid=?");
				flag=true;
			}
		}
		if(dbodeaordercar.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",presices=?");
			}else{
				sb.append("presices=?");
				flag=true;
			}
		}
		if(dbodeaordercar.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",userid=?");
			}else{
				sb.append("userid=?");
				flag=true;
			}
		}
		if(dbodeaordercar.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",fromsource=?");
			}else{
				sb.append("fromsource=?");
				flag=true;
			}
		}
		sb.append(" where orderid=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeaordercar.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeaordercar.getOrderid());k++;
		}
		if(dbodeaordercar.COLUMN_FLAG[1]){
			dbc.setInt(k, dbodeaordercar.getEid());k++;
		}
		if(dbodeaordercar.COLUMN_FLAG[2]){
			dbc.setInt(k, dbodeaordercar.getCarid());k++;
		}
		if(dbodeaordercar.COLUMN_FLAG[3]){
			dbc.setTimestamp(k, new Timestamp(dbodeaordercar.getOrderdate().getTime()));k++;
		}
		if(dbodeaordercar.COLUMN_FLAG[4]){
			dbc.setString(k, dbodeaordercar.getPhone());k++;
		}
		if(dbodeaordercar.COLUMN_FLAG[5]){
			dbc.setString(k, dbodeaordercar.getCustomername());k++;
		}
		if(dbodeaordercar.COLUMN_FLAG[6]){
			dbc.setString(k, dbodeaordercar.getEmail());k++;
		}
		if(dbodeaordercar.COLUMN_FLAG[7]){
			dbc.setString(k, dbodeaordercar.getSupplement());k++;
		}
		if(dbodeaordercar.COLUMN_FLAG[8]){
			dbc.setInt(k, dbodeaordercar.getState());k++;
		}
		if(dbodeaordercar.COLUMN_FLAG[9]){
			dbc.setInt(k, dbodeaordercar.getOrdertype());k++;
		}
		if(dbodeaordercar.COLUMN_FLAG[10]){
			dbc.setInt(k, dbodeaordercar.getIsdelete());k++;
		}
		if(dbodeaordercar.COLUMN_FLAG[11]){
			dbc.setInt(k, dbodeaordercar.getAreaid());k++;
		}
		if(dbodeaordercar.COLUMN_FLAG[12]){
			dbc.setString(k, dbodeaordercar.getPresices());k++;
		}
		if(dbodeaordercar.COLUMN_FLAG[13]){
			dbc.setInt(k, dbodeaordercar.getUserid());k++;
		}
		if(dbodeaordercar.COLUMN_FLAG[14]){
			dbc.setInt(k, dbodeaordercar.getFromsource());k++;
		}
		dbc.setInt(k, dbodeaordercar.getOrderid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaOrdercar dbodeaordercar) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeaordercar);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static int DboDeaOrdercarCountByeid(int eid){
		DBConnect dbc = null;
		String sql = "select count(*) from dbo_dea_ordercar where eid = ?";
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, eid);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static List<DboDeaOrdercar> DboDeaOrdercarSelectAllColumnByeidordertype(int eid,int ordertype){
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_ordercar where eid = ? and ordertype = ?";
		List<DboDeaOrdercar> list = new ArrayList<DboDeaOrdercar>();
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, eid);
			dbc.setInt(2, ordertype);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaOrdercar obj = new DboDeaOrdercar();
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

	public static List<DboDeaOrdercar> SelectBycarid(int carid){
		DBConnect dbc = null;
		String sql = "select a.orderid a_orderid,a.eid a_eid,a.carid a_carid,a.orderdate a_orderdate,a.phone a_phone,a.customername a_customername,a.email a_email,a.supplement a_supplement,a.state a_state,a.ordertype a_ordertype,a.isdelete a_isdelete,a.areaid a_areaid,a.presices a_presices,a.userid a_userid,a.fromsource a_fromsource,b.catalogid b_catalogid,b.catalogname b_catalogname,b.fatherid b_fatherid,b.byname b_byname,b.path b_path,b.islive b_islive,b.onsale b_onsale,b.iyear b_iyear,b.iway b_iway,b.madein b_madein,b.xiangti b_xiangti,b.jibie b_jibie,b.leixing b_leixing,b.bsq b_bsq,b.pailiang b_pailiang,b.photo b_photo,b.serialname b_serialname,b.newsid b_newsid,b.isdelete b_isdelete,b.adddate b_adddate,b.lastupdate b_lastupdate,b.addadmin b_addadmin,b.updateadmin b_updateadmin,b.deladmin b_deladmin,b.sortid b_sortid,b.factorytel b_factorytel,b.carkey b_carkey,b.englishname b_englishname,b.maincatalogid b_maincatalogid,b.ishaverelation b_ishaverelation,b.lname b_lname,b.pathlevel b_pathlevel,b.hotlevel b_hotlevel,b.fadongji b_fadongji,b.baoyangfeiyong b_baoyangfeiyong,b.pengzhuanglevel b_pengzhuanglevel,b.guanurl b_guanurl,b.wayname b_wayname from dbo_dea_ordercar a,dbo_car_catalognew b where a . carid = b . catalogid  and a . carid = ?   ";
		List<DboDeaOrdercar> list = new ArrayList<DboDeaOrdercar>();
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, carid);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaOrdercar dbodeaordercar = new DboDeaOrdercar();
				dbodeaordercar.setOrderid(rs.getInt("a_orderid"));
				dbodeaordercar.setEid(rs.getInt("a_eid"));
				dbodeaordercar.setCarid(rs.getInt("a_carid"));
				dbodeaordercar.setOrderdate(rs.getTimestamp("a_orderdate"));
				dbodeaordercar.setPhone(rs.getString("a_phone"));
				dbodeaordercar.setCustomername(rs.getString("a_customername"));
				dbodeaordercar.setEmail(rs.getString("a_email"));
				dbodeaordercar.setSupplement(rs.getString("a_supplement"));
				dbodeaordercar.setState(rs.getInt("a_state"));
				dbodeaordercar.setOrdertype(rs.getInt("a_ordertype"));
				dbodeaordercar.setIsdelete(rs.getInt("a_isdelete"));
				dbodeaordercar.setAreaid(rs.getInt("a_areaid"));
				dbodeaordercar.setPresices(rs.getString("a_presices"));
				dbodeaordercar.setUserid(rs.getInt("a_userid"));
				dbodeaordercar.setFromsource(rs.getInt("a_fromsource"));
				DboCarCatalognew dbocarcatalognew1 = new DboCarCatalognew();
				dbocarcatalognew1.setCatalogid(rs.getInt("b_catalogid"));
				dbocarcatalognew1.setCatalogname(rs.getString("b_catalogname"));
				dbocarcatalognew1.setFatherid(rs.getInt("b_fatherid"));
				dbocarcatalognew1.setByname(rs.getString("b_byname"));
				dbocarcatalognew1.setPath(rs.getString("b_path"));
				dbocarcatalognew1.setIslive(rs.getInt("b_islive"));
				dbocarcatalognew1.setOnsale(rs.getInt("b_onsale"));
				dbocarcatalognew1.setIyear(rs.getInt("b_iyear"));
				dbocarcatalognew1.setIway(rs.getString("b_iway"));
				dbocarcatalognew1.setMadein(rs.getInt("b_madein"));
				dbocarcatalognew1.setXiangti(rs.getInt("b_xiangti"));
				dbocarcatalognew1.setJibie(rs.getInt("b_jibie"));
				dbocarcatalognew1.setLeixing(rs.getInt("b_leixing"));
				dbocarcatalognew1.setBsq(rs.getInt("b_bsq"));
				dbocarcatalognew1.setPailiang(rs.getInt("b_pailiang"));
				dbocarcatalognew1.setPhoto(rs.getString("b_photo"));
				dbocarcatalognew1.setSerialname(rs.getString("b_serialname"));
				dbocarcatalognew1.setNewsid(rs.getInt("b_newsid"));
				dbocarcatalognew1.setIsdelete(rs.getInt("b_isdelete"));
				dbocarcatalognew1.setAdddate(rs.getTimestamp("b_adddate"));
				dbocarcatalognew1.setLastupdate(rs.getTimestamp("b_lastupdate"));
				dbocarcatalognew1.setAddadmin(rs.getString("b_addadmin"));
				dbocarcatalognew1.setUpdateadmin(rs.getString("b_updateadmin"));
				dbocarcatalognew1.setDeladmin(rs.getString("b_deladmin"));
				dbocarcatalognew1.setSortid(rs.getInt("b_sortid"));
				dbocarcatalognew1.setFactorytel(rs.getString("b_factorytel"));
				dbocarcatalognew1.setCarkey(rs.getString("b_carkey"));
				dbocarcatalognew1.setEnglishname(rs.getString("b_englishname"));
				dbocarcatalognew1.setMaincatalogid(rs.getInt("b_maincatalogid"));
				dbocarcatalognew1.setIshaverelation(rs.getInt("b_ishaverelation"));
				dbocarcatalognew1.setLname(rs.getString("b_lname"));
				dbocarcatalognew1.setPathlevel(rs.getInt("b_pathlevel"));
				dbocarcatalognew1.setHotlevel(rs.getInt("b_hotlevel"));
				dbocarcatalognew1.setFadongji(rs.getInt("b_fadongji"));
				dbocarcatalognew1.setBaoyangfeiyong(rs.getInt("b_baoyangfeiyong"));
				dbocarcatalognew1.setPengzhuanglevel(rs.getInt("b_pengzhuanglevel"));
				dbocarcatalognew1.setGuanurl(rs.getString("b_guanurl"));
				dbocarcatalognew1.setWayname(rs.getString("b_wayname"));
				dbodeaordercar.setCar(dbocarcatalognew1);
				list.add(dbodeaordercar);
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
}