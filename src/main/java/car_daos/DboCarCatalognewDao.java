package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboCarCatalognew;

public class  DboCarCatalognewDao  extends BaseDao {

	public static void fill(ResultSet rs, DboCarCatalognew dbocarcatalognew) throws SQLException {
		dbocarcatalognew.setCatalogid(rs.getInt("catalogid"));//
		dbocarcatalognew.setCatalogname(rs.getString("catalogname"));//
		dbocarcatalognew.setFatherid(rs.getInt("fatherid"));//
		dbocarcatalognew.setByname(rs.getString("byname"));//
		dbocarcatalognew.setPath(rs.getString("path"));//
		dbocarcatalognew.setIslive(rs.getInt("islive"));//0-停产，1-在产，2-未生产
		dbocarcatalognew.setOnsale(rs.getInt("onsale"));//0-停售，1-在售，2-未销售，3-未上市
		dbocarcatalognew.setIyear(rs.getInt("iyear"));//
		dbocarcatalognew.setIway(rs.getString("iway"));//
		dbocarcatalognew.setMadein(rs.getInt("madein"));//0-海外，1- 国产，2-进口
		dbocarcatalognew.setXiangti(rs.getInt("xiangti"));//0-无，1-单厢，2-两厢，3-三厢
		dbocarcatalognew.setJibie(rs.getInt("jibie"));//0-无，1-微型，2-小型，3-紧凑型，4-轻型，5-中型，6-中大型，7-大型，8-豪华，9-超级
		dbocarcatalognew.setLeixing(rs.getInt("leixing"));//0-无，1-轿车，2-跨界车，3-suv，4-旅行车，5-mpv，6-跑车，7-概念车，8-皮卡，9-客车，10-卡车
		dbocarcatalognew.setBsq(rs.getInt("bsq"));//0-无，1-手动，2-自动，3-双离合，4-无级变速，5-手自一体(amt)
		dbocarcatalognew.setPailiang(rs.getInt("pailiang"));//用10倍表示，整数，排量存在无的情况，则用-1表示 （0不表示无）
		dbocarcatalognew.setPhoto(rs.getString("photo"));//
		dbocarcatalognew.setSerialname(rs.getString("serialname"));//
		dbocarcatalognew.setNewsid(rs.getInt("newsid"));//
		dbocarcatalognew.setIsdelete(rs.getInt("isdelete"));//
		dbocarcatalognew.setAdddate(rs.getTimestamp("adddate"));//
		dbocarcatalognew.setLastupdate(rs.getTimestamp("lastupdate"));//
		dbocarcatalognew.setAddadmin(rs.getString("addadmin"));//
		dbocarcatalognew.setUpdateadmin(rs.getString("updateadmin"));//
		dbocarcatalognew.setDeladmin(rs.getString("deladmin"));//
		dbocarcatalognew.setSortid(rs.getInt("sortid"));//
		dbocarcatalognew.setFactorytel(rs.getString("factorytel"));//
		dbocarcatalognew.setCarkey(rs.getString("carkey"));//
		dbocarcatalognew.setEnglishname(rs.getString("englishname"));//
		dbocarcatalognew.setMaincatalogid(rs.getInt("maincatalogid"));//
		dbocarcatalognew.setIshaverelation(rs.getInt("ishaverelation"));//
		dbocarcatalognew.setLname(rs.getString("lname"));//
		dbocarcatalognew.setPathlevel(rs.getInt("pathlevel"));//1-品牌 2-车系 3-车型
		dbocarcatalognew.setHotlevel(rs.getInt("hotlevel"));//
		dbocarcatalognew.setFadongji(rs.getInt("fadongji"));//1-汽油 2-柴油 3-混合动力 4-纯电动 5-天然气
		dbocarcatalognew.setBaoyangfeiyong(rs.getInt("baoyangfeiyong"));//
		dbocarcatalognew.setPengzhuanglevel(rs.getInt("pengzhuanglevel"));//
		dbocarcatalognew.setGuanurl(rs.getString("guanurl"));//
		dbocarcatalognew.setWayname(rs.getString("wayname"));//渠道首字母
		dbocarcatalognew.setCarbrandphoto(rs.getString("carbrandphoto"));//品牌图片
		dbocarcatalognew.setOld_catalogid(rs.getInt("old_catalogid"));//老315车型数据
		dbocarcatalognew.setOld_fatherid(rs.getInt("old_fatherid"));//老315车型数据
		dbocarcatalognew.setYiche_price(rs.getDouble("yiche_price"));//
		dbocarcatalognew.setChetuanphoto(rs.getString("chetuanphoto"));//车团图片
	}

	public static List<DboCarCatalognew> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_car_catalognew";
		List<DboCarCatalognew> list = new ArrayList<DboCarCatalognew>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarCatalognew dbocarcatalognew = new DboCarCatalognew();
				fill(rs, dbocarcatalognew);
				list.add(dbocarcatalognew);
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


	public static List<DboCarCatalognew> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_car_catalognew where "+subsql+"";
		List<DboCarCatalognew> list = new ArrayList<DboCarCatalognew>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarCatalognew dbocarcatalognew = new DboCarCatalognew();
				fill(rs, dbocarcatalognew);
				list.add(dbocarcatalognew);
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
		String sql = "select count(*) from dbo_car_catalognew where "+subsql+"";
		
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
		String sql = "delete from dbo_car_catalognew where "+subsql+"";
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
		String sql = "delete from dbo_car_catalognew where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboCarCatalognew dbocarcatalognew) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_car_catalognew(`catalogid`,`catalogname`,`fatherid`,`byname`,`path`,`islive`,`onsale`,`iyear`,`iway`,`madein`,`xiangti`,`jibie`,`leixing`,`bsq`,`pailiang`,`photo`,`serialname`,`newsid`,`isdelete`,`adddate`,`lastupdate`,`addadmin`,`updateadmin`,`deladmin`,`sortid`,`factorytel`,`carkey`,`englishname`,`maincatalogid`,`ishaverelation`,`lname`,`pathlevel`,`hotlevel`,`fadongji`,`baoyangfeiyong`,`pengzhuanglevel`,`guanurl`,`wayname`,`carbrandphoto`,`old_catalogid`,`old_fatherid`,`yiche_price`,`chetuanphoto`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbocarcatalognew.getCatalogid());
		dbc.setString(2, dbocarcatalognew.getCatalogname());
		dbc.setInt(3, dbocarcatalognew.getFatherid());
		dbc.setString(4, dbocarcatalognew.getByname());
		dbc.setString(5, dbocarcatalognew.getPath());
		dbc.setInt(6, dbocarcatalognew.getIslive());
		dbc.setInt(7, dbocarcatalognew.getOnsale());
		dbc.setInt(8, dbocarcatalognew.getIyear());
		dbc.setString(9, dbocarcatalognew.getIway());
		dbc.setInt(10, dbocarcatalognew.getMadein());
		dbc.setInt(11, dbocarcatalognew.getXiangti());
		dbc.setInt(12, dbocarcatalognew.getJibie());
		dbc.setInt(13, dbocarcatalognew.getLeixing());
		dbc.setInt(14, dbocarcatalognew.getBsq());
		dbc.setInt(15, dbocarcatalognew.getPailiang());
		dbc.setString(16, dbocarcatalognew.getPhoto());
		dbc.setString(17, dbocarcatalognew.getSerialname());
		dbc.setInt(18, dbocarcatalognew.getNewsid());
		dbc.setInt(19, dbocarcatalognew.getIsdelete());
		dbc.setTimestamp(20, new Timestamp(dbocarcatalognew.getAdddate().getTime()));
		dbc.setTimestamp(21, new Timestamp(dbocarcatalognew.getLastupdate().getTime()));
		dbc.setString(22, dbocarcatalognew.getAddadmin());
		dbc.setString(23, dbocarcatalognew.getUpdateadmin());
		dbc.setString(24, dbocarcatalognew.getDeladmin());
		dbc.setInt(25, dbocarcatalognew.getSortid());
		dbc.setString(26, dbocarcatalognew.getFactorytel());
		dbc.setString(27, dbocarcatalognew.getCarkey());
		dbc.setString(28, dbocarcatalognew.getEnglishname());
		dbc.setInt(29, dbocarcatalognew.getMaincatalogid());
		dbc.setInt(30, dbocarcatalognew.getIshaverelation());
		dbc.setString(31, dbocarcatalognew.getLname());
		dbc.setInt(32, dbocarcatalognew.getPathlevel());
		dbc.setInt(33, dbocarcatalognew.getHotlevel());
		dbc.setInt(34, dbocarcatalognew.getFadongji());
		dbc.setInt(35, dbocarcatalognew.getBaoyangfeiyong());
		dbc.setInt(36, dbocarcatalognew.getPengzhuanglevel());
		dbc.setString(37, dbocarcatalognew.getGuanurl());
		dbc.setString(38, dbocarcatalognew.getWayname());
		dbc.setString(39, dbocarcatalognew.getCarbrandphoto());
		dbc.setInt(40, dbocarcatalognew.getOld_catalogid());
		dbc.setInt(41, dbocarcatalognew.getOld_fatherid());
		dbc.setDouble(42, dbocarcatalognew.getYiche_price());
		dbc.setString(43, dbocarcatalognew.getChetuanphoto());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboCarCatalognew dbocarcatalognew) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_car_catalognew(`catalogid`,`catalogname`,`fatherid`,`byname`,`path`,`islive`,`onsale`,`iyear`,`iway`,`madein`,`xiangti`,`jibie`,`leixing`,`bsq`,`pailiang`,`photo`,`serialname`,`newsid`,`isdelete`,`adddate`,`lastupdate`,`addadmin`,`updateadmin`,`deladmin`,`sortid`,`factorytel`,`carkey`,`englishname`,`maincatalogid`,`ishaverelation`,`lname`,`pathlevel`,`hotlevel`,`fadongji`,`baoyangfeiyong`,`pengzhuanglevel`,`guanurl`,`wayname`,`carbrandphoto`,`old_catalogid`,`old_fatherid`,`yiche_price`,`chetuanphoto`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbocarcatalognew.getCatalogid());
		dbc.setString(2, dbocarcatalognew.getCatalogname());
		dbc.setInt(3, dbocarcatalognew.getFatherid());
		dbc.setString(4, dbocarcatalognew.getByname());
		dbc.setString(5, dbocarcatalognew.getPath());
		dbc.setInt(6, dbocarcatalognew.getIslive());
		dbc.setInt(7, dbocarcatalognew.getOnsale());
		dbc.setInt(8, dbocarcatalognew.getIyear());
		dbc.setString(9, dbocarcatalognew.getIway());
		dbc.setInt(10, dbocarcatalognew.getMadein());
		dbc.setInt(11, dbocarcatalognew.getXiangti());
		dbc.setInt(12, dbocarcatalognew.getJibie());
		dbc.setInt(13, dbocarcatalognew.getLeixing());
		dbc.setInt(14, dbocarcatalognew.getBsq());
		dbc.setInt(15, dbocarcatalognew.getPailiang());
		dbc.setString(16, dbocarcatalognew.getPhoto());
		dbc.setString(17, dbocarcatalognew.getSerialname());
		dbc.setInt(18, dbocarcatalognew.getNewsid());
		dbc.setInt(19, dbocarcatalognew.getIsdelete());
		dbc.setTimestamp(20, new Timestamp(dbocarcatalognew.getAdddate().getTime()));
		dbc.setTimestamp(21, new Timestamp(dbocarcatalognew.getLastupdate().getTime()));
		dbc.setString(22, dbocarcatalognew.getAddadmin());
		dbc.setString(23, dbocarcatalognew.getUpdateadmin());
		dbc.setString(24, dbocarcatalognew.getDeladmin());
		dbc.setInt(25, dbocarcatalognew.getSortid());
		dbc.setString(26, dbocarcatalognew.getFactorytel());
		dbc.setString(27, dbocarcatalognew.getCarkey());
		dbc.setString(28, dbocarcatalognew.getEnglishname());
		dbc.setInt(29, dbocarcatalognew.getMaincatalogid());
		dbc.setInt(30, dbocarcatalognew.getIshaverelation());
		dbc.setString(31, dbocarcatalognew.getLname());
		dbc.setInt(32, dbocarcatalognew.getPathlevel());
		dbc.setInt(33, dbocarcatalognew.getHotlevel());
		dbc.setInt(34, dbocarcatalognew.getFadongji());
		dbc.setInt(35, dbocarcatalognew.getBaoyangfeiyong());
		dbc.setInt(36, dbocarcatalognew.getPengzhuanglevel());
		dbc.setString(37, dbocarcatalognew.getGuanurl());
		dbc.setString(38, dbocarcatalognew.getWayname());
		dbc.setString(39, dbocarcatalognew.getCarbrandphoto());
		dbc.setInt(40, dbocarcatalognew.getOld_catalogid());
		dbc.setInt(41, dbocarcatalognew.getOld_fatherid());
		dbc.setDouble(42, dbocarcatalognew.getYiche_price());
		dbc.setString(43, dbocarcatalognew.getChetuanphoto());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboCarCatalognew dbocarcatalognew) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_car_catalognew set ");
		boolean flag = false;
		if(dbocarcatalognew.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",catalogid=?");
			}else{
				sb.append("catalogid=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",catalogname=?");
			}else{
				sb.append("catalogname=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",fatherid=?");
			}else{
				sb.append("fatherid=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",byname=?");
			}else{
				sb.append("byname=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",path=?");
			}else{
				sb.append("path=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",islive=?");
			}else{
				sb.append("islive=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",onsale=?");
			}else{
				sb.append("onsale=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",iyear=?");
			}else{
				sb.append("iyear=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",iway=?");
			}else{
				sb.append("iway=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",madein=?");
			}else{
				sb.append("madein=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",xiangti=?");
			}else{
				sb.append("xiangti=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",jibie=?");
			}else{
				sb.append("jibie=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",leixing=?");
			}else{
				sb.append("leixing=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",bsq=?");
			}else{
				sb.append("bsq=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",pailiang=?");
			}else{
				sb.append("pailiang=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",photo=?");
			}else{
				sb.append("photo=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",serialname=?");
			}else{
				sb.append("serialname=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",newsid=?");
			}else{
				sb.append("newsid=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[18]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[19]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[20]){
			if(flag){
				sb.append(",lastupdate=?");
			}else{
				sb.append("lastupdate=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[21]){
			if(flag){
				sb.append(",addadmin=?");
			}else{
				sb.append("addadmin=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[22]){
			if(flag){
				sb.append(",updateadmin=?");
			}else{
				sb.append("updateadmin=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[23]){
			if(flag){
				sb.append(",deladmin=?");
			}else{
				sb.append("deladmin=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[24]){
			if(flag){
				sb.append(",sortid=?");
			}else{
				sb.append("sortid=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[25]){
			if(flag){
				sb.append(",factorytel=?");
			}else{
				sb.append("factorytel=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[26]){
			if(flag){
				sb.append(",carkey=?");
			}else{
				sb.append("carkey=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[27]){
			if(flag){
				sb.append(",englishname=?");
			}else{
				sb.append("englishname=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[28]){
			if(flag){
				sb.append(",maincatalogid=?");
			}else{
				sb.append("maincatalogid=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[29]){
			if(flag){
				sb.append(",ishaverelation=?");
			}else{
				sb.append("ishaverelation=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[30]){
			if(flag){
				sb.append(",lname=?");
			}else{
				sb.append("lname=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[31]){
			if(flag){
				sb.append(",pathlevel=?");
			}else{
				sb.append("pathlevel=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[32]){
			if(flag){
				sb.append(",hotlevel=?");
			}else{
				sb.append("hotlevel=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[33]){
			if(flag){
				sb.append(",fadongji=?");
			}else{
				sb.append("fadongji=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[34]){
			if(flag){
				sb.append(",baoyangfeiyong=?");
			}else{
				sb.append("baoyangfeiyong=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[35]){
			if(flag){
				sb.append(",pengzhuanglevel=?");
			}else{
				sb.append("pengzhuanglevel=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[36]){
			if(flag){
				sb.append(",guanurl=?");
			}else{
				sb.append("guanurl=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[37]){
			if(flag){
				sb.append(",wayname=?");
			}else{
				sb.append("wayname=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[38]){
			if(flag){
				sb.append(",carbrandphoto=?");
			}else{
				sb.append("carbrandphoto=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[39]){
			if(flag){
				sb.append(",old_catalogid=?");
			}else{
				sb.append("old_catalogid=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[40]){
			if(flag){
				sb.append(",old_fatherid=?");
			}else{
				sb.append("old_fatherid=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[41]){
			if(flag){
				sb.append(",yiche_price=?");
			}else{
				sb.append("yiche_price=?");
				flag=true;
			}
		}
		if(dbocarcatalognew.COLUMN_FLAG[42]){
			if(flag){
				sb.append(",chetuanphoto=?");
			}else{
				sb.append("chetuanphoto=?");
				flag=true;
			}
		}
		sb.append(" where catalogid=?");
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbocarcatalognew.COLUMN_FLAG[0]){
			dbc.setInt(k, dbocarcatalognew.getCatalogid());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[1]){
			dbc.setString(k, dbocarcatalognew.getCatalogname());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[2]){
			dbc.setInt(k, dbocarcatalognew.getFatherid());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[3]){
			dbc.setString(k, dbocarcatalognew.getByname());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[4]){
			dbc.setString(k, dbocarcatalognew.getPath());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[5]){
			dbc.setInt(k, dbocarcatalognew.getIslive());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[6]){
			dbc.setInt(k, dbocarcatalognew.getOnsale());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[7]){
			dbc.setInt(k, dbocarcatalognew.getIyear());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[8]){
			dbc.setString(k, dbocarcatalognew.getIway());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[9]){
			dbc.setInt(k, dbocarcatalognew.getMadein());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[10]){
			dbc.setInt(k, dbocarcatalognew.getXiangti());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[11]){
			dbc.setInt(k, dbocarcatalognew.getJibie());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[12]){
			dbc.setInt(k, dbocarcatalognew.getLeixing());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[13]){
			dbc.setInt(k, dbocarcatalognew.getBsq());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[14]){
			dbc.setInt(k, dbocarcatalognew.getPailiang());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[15]){
			dbc.setString(k, dbocarcatalognew.getPhoto());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[16]){
			dbc.setString(k, dbocarcatalognew.getSerialname());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[17]){
			dbc.setInt(k, dbocarcatalognew.getNewsid());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[18]){
			dbc.setInt(k, dbocarcatalognew.getIsdelete());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[19]){
			dbc.setTimestamp(k, new Timestamp(dbocarcatalognew.getAdddate().getTime()));k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[20]){
			dbc.setTimestamp(k, new Timestamp(dbocarcatalognew.getLastupdate().getTime()));k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[21]){
			dbc.setString(k, dbocarcatalognew.getAddadmin());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[22]){
			dbc.setString(k, dbocarcatalognew.getUpdateadmin());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[23]){
			dbc.setString(k, dbocarcatalognew.getDeladmin());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[24]){
			dbc.setInt(k, dbocarcatalognew.getSortid());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[25]){
			dbc.setString(k, dbocarcatalognew.getFactorytel());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[26]){
			dbc.setString(k, dbocarcatalognew.getCarkey());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[27]){
			dbc.setString(k, dbocarcatalognew.getEnglishname());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[28]){
			dbc.setInt(k, dbocarcatalognew.getMaincatalogid());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[29]){
			dbc.setInt(k, dbocarcatalognew.getIshaverelation());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[30]){
			dbc.setString(k, dbocarcatalognew.getLname());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[31]){
			dbc.setInt(k, dbocarcatalognew.getPathlevel());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[32]){
			dbc.setInt(k, dbocarcatalognew.getHotlevel());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[33]){
			dbc.setInt(k, dbocarcatalognew.getFadongji());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[34]){
			dbc.setInt(k, dbocarcatalognew.getBaoyangfeiyong());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[35]){
			dbc.setInt(k, dbocarcatalognew.getPengzhuanglevel());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[36]){
			dbc.setString(k, dbocarcatalognew.getGuanurl());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[37]){
			dbc.setString(k, dbocarcatalognew.getWayname());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[38]){
			dbc.setString(k, dbocarcatalognew.getCarbrandphoto());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[39]){
			dbc.setInt(k, dbocarcatalognew.getOld_catalogid());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[40]){
			dbc.setInt(k, dbocarcatalognew.getOld_fatherid());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[41]){
			dbc.setDouble(k, dbocarcatalognew.getYiche_price());k++;
		}
		if(dbocarcatalognew.COLUMN_FLAG[42]){
			dbc.setString(k, dbocarcatalognew.getChetuanphoto());k++;
		}
		dbc.setInt(k, dbocarcatalognew.getCatalogid());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboCarCatalognew dbocarcatalognew) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbocarcatalognew);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static List<DboCarCatalognew> DboCarCatalognewSelectAllColumnBylimit_beginlimit_num(int limit_begin,int limit_num){
		DBConnect dbc = null;
		String sql = "select * from dbo_car_catalognew  order by id asc limit ?,?";
		List<DboCarCatalognew> list = new ArrayList<DboCarCatalognew>();
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, limit_begin);
			dbc.setInt(2, limit_num);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarCatalognew obj = new DboCarCatalognew();
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

	public static List<DboCarCatalognew> SelectBycatalogid(int catalogid){
		DBConnect dbc = null;
		String sql = "select a.catalogid a_catalogid,a.catalogname a_catalogname,a.fatherid a_fatherid,a.byname a_byname,a.path a_path,a.islive a_islive,a.onsale a_onsale,a.iyear a_iyear,a.iway a_iway,a.madein a_madein,a.xiangti a_xiangti,a.jibie a_jibie,a.leixing a_leixing,a.bsq a_bsq,a.pailiang a_pailiang,a.photo a_photo,a.serialname a_serialname,a.newsid a_newsid,a.isdelete a_isdelete,a.adddate a_adddate,a.lastupdate a_lastupdate,a.addadmin a_addadmin,a.updateadmin a_updateadmin,a.deladmin a_deladmin,a.sortid a_sortid,a.factorytel a_factorytel,a.carkey a_carkey,a.englishname a_englishname,a.maincatalogid a_maincatalogid,a.ishaverelation a_ishaverelation,a.lname a_lname,a.pathlevel a_pathlevel,a.hotlevel a_hotlevel,a.fadongji a_fadongji,a.baoyangfeiyong a_baoyangfeiyong,a.pengzhuanglevel a_pengzhuanglevel,a.guanurl a_guanurl,a.wayname a_wayname,a.carbrandphoto a_carbrandphoto,a.old_catalogid a_old_catalogid,a.old_fatherid a_old_fatherid,a.yiche_price a_yiche_price,a.chetuanphoto a_chetuanphoto,b.catalogid b_catalogid,b.catalogname b_catalogname,b.fatherid b_fatherid,b.byname b_byname,b.path b_path,b.islive b_islive,b.onsale b_onsale,b.iyear b_iyear,b.iway b_iway,b.madein b_madein,b.xiangti b_xiangti,b.jibie b_jibie,b.leixing b_leixing,b.bsq b_bsq,b.pailiang b_pailiang,b.photo b_photo,b.serialname b_serialname,b.newsid b_newsid,b.isdelete b_isdelete,b.adddate b_adddate,b.lastupdate b_lastupdate,b.addadmin b_addadmin,b.updateadmin b_updateadmin,b.deladmin b_deladmin,b.sortid b_sortid,b.factorytel b_factorytel,b.carkey b_carkey,b.englishname b_englishname,b.maincatalogid b_maincatalogid,b.ishaverelation b_ishaverelation,b.lname b_lname,b.pathlevel b_pathlevel,b.hotlevel b_hotlevel,b.fadongji b_fadongji,b.baoyangfeiyong b_baoyangfeiyong,b.pengzhuanglevel b_pengzhuanglevel,b.guanurl b_guanurl,b.wayname b_wayname,b.carbrandphoto b_carbrandphoto,b.old_catalogid b_old_catalogid,b.old_fatherid b_old_fatherid,b.yiche_price b_yiche_price,b.chetuanphoto b_chetuanphoto from dbo_car_catalognew a,dbo_car_catalognew b where a . fatherid = b . catalogid  and a . catalogid = ?   ";
		List<DboCarCatalognew> list = new ArrayList<DboCarCatalognew>();
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, catalogid);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarCatalognew dbocarcatalognew = new DboCarCatalognew();
				dbocarcatalognew.setCatalogid(rs.getInt("a_catalogid"));
				dbocarcatalognew.setCatalogname(rs.getString("a_catalogname"));
				dbocarcatalognew.setFatherid(rs.getInt("a_fatherid"));
				dbocarcatalognew.setByname(rs.getString("a_byname"));
				dbocarcatalognew.setPath(rs.getString("a_path"));
				dbocarcatalognew.setIslive(rs.getInt("a_islive"));
				dbocarcatalognew.setOnsale(rs.getInt("a_onsale"));
				dbocarcatalognew.setIyear(rs.getInt("a_iyear"));
				dbocarcatalognew.setIway(rs.getString("a_iway"));
				dbocarcatalognew.setMadein(rs.getInt("a_madein"));
				dbocarcatalognew.setXiangti(rs.getInt("a_xiangti"));
				dbocarcatalognew.setJibie(rs.getInt("a_jibie"));
				dbocarcatalognew.setLeixing(rs.getInt("a_leixing"));
				dbocarcatalognew.setBsq(rs.getInt("a_bsq"));
				dbocarcatalognew.setPailiang(rs.getInt("a_pailiang"));
				dbocarcatalognew.setPhoto(rs.getString("a_photo"));
				dbocarcatalognew.setSerialname(rs.getString("a_serialname"));
				dbocarcatalognew.setNewsid(rs.getInt("a_newsid"));
				dbocarcatalognew.setIsdelete(rs.getInt("a_isdelete"));
				dbocarcatalognew.setAdddate(rs.getTimestamp("a_adddate"));
				dbocarcatalognew.setLastupdate(rs.getTimestamp("a_lastupdate"));
				dbocarcatalognew.setAddadmin(rs.getString("a_addadmin"));
				dbocarcatalognew.setUpdateadmin(rs.getString("a_updateadmin"));
				dbocarcatalognew.setDeladmin(rs.getString("a_deladmin"));
				dbocarcatalognew.setSortid(rs.getInt("a_sortid"));
				dbocarcatalognew.setFactorytel(rs.getString("a_factorytel"));
				dbocarcatalognew.setCarkey(rs.getString("a_carkey"));
				dbocarcatalognew.setEnglishname(rs.getString("a_englishname"));
				dbocarcatalognew.setMaincatalogid(rs.getInt("a_maincatalogid"));
				dbocarcatalognew.setIshaverelation(rs.getInt("a_ishaverelation"));
				dbocarcatalognew.setLname(rs.getString("a_lname"));
				dbocarcatalognew.setPathlevel(rs.getInt("a_pathlevel"));
				dbocarcatalognew.setHotlevel(rs.getInt("a_hotlevel"));
				dbocarcatalognew.setFadongji(rs.getInt("a_fadongji"));
				dbocarcatalognew.setBaoyangfeiyong(rs.getInt("a_baoyangfeiyong"));
				dbocarcatalognew.setPengzhuanglevel(rs.getInt("a_pengzhuanglevel"));
				dbocarcatalognew.setGuanurl(rs.getString("a_guanurl"));
				dbocarcatalognew.setWayname(rs.getString("a_wayname"));
				dbocarcatalognew.setCarbrandphoto(rs.getString("a_carbrandphoto"));
				dbocarcatalognew.setOld_catalogid(rs.getInt("a_old_catalogid"));
				dbocarcatalognew.setOld_fatherid(rs.getInt("a_old_fatherid"));
				dbocarcatalognew.setYiche_price(rs.getDouble("a_yiche_price"));
				dbocarcatalognew.setChetuanphoto(rs.getString("a_chetuanphoto"));
				DboCarCatalognew dbocarcatalognew1 = new DboCarCatalognew();
				dbocarcatalognew1.setCatalogid(rs.getInt("a_catalogid"));
				dbocarcatalognew1.setCatalogname(rs.getString("a_catalogname"));
				dbocarcatalognew1.setFatherid(rs.getInt("a_fatherid"));
				dbocarcatalognew1.setByname(rs.getString("a_byname"));
				dbocarcatalognew1.setPath(rs.getString("a_path"));
				dbocarcatalognew1.setIslive(rs.getInt("a_islive"));
				dbocarcatalognew1.setOnsale(rs.getInt("a_onsale"));
				dbocarcatalognew1.setIyear(rs.getInt("a_iyear"));
				dbocarcatalognew1.setIway(rs.getString("a_iway"));
				dbocarcatalognew1.setMadein(rs.getInt("a_madein"));
				dbocarcatalognew1.setXiangti(rs.getInt("a_xiangti"));
				dbocarcatalognew1.setJibie(rs.getInt("a_jibie"));
				dbocarcatalognew1.setLeixing(rs.getInt("a_leixing"));
				dbocarcatalognew1.setBsq(rs.getInt("a_bsq"));
				dbocarcatalognew1.setPailiang(rs.getInt("a_pailiang"));
				dbocarcatalognew1.setPhoto(rs.getString("a_photo"));
				dbocarcatalognew1.setSerialname(rs.getString("a_serialname"));
				dbocarcatalognew1.setNewsid(rs.getInt("a_newsid"));
				dbocarcatalognew1.setIsdelete(rs.getInt("a_isdelete"));
				dbocarcatalognew1.setAdddate(rs.getTimestamp("a_adddate"));
				dbocarcatalognew1.setLastupdate(rs.getTimestamp("a_lastupdate"));
				dbocarcatalognew1.setAddadmin(rs.getString("a_addadmin"));
				dbocarcatalognew1.setUpdateadmin(rs.getString("a_updateadmin"));
				dbocarcatalognew1.setDeladmin(rs.getString("a_deladmin"));
				dbocarcatalognew1.setSortid(rs.getInt("a_sortid"));
				dbocarcatalognew1.setFactorytel(rs.getString("a_factorytel"));
				dbocarcatalognew1.setCarkey(rs.getString("a_carkey"));
				dbocarcatalognew1.setEnglishname(rs.getString("a_englishname"));
				dbocarcatalognew1.setMaincatalogid(rs.getInt("a_maincatalogid"));
				dbocarcatalognew1.setIshaverelation(rs.getInt("a_ishaverelation"));
				dbocarcatalognew1.setLname(rs.getString("a_lname"));
				dbocarcatalognew1.setPathlevel(rs.getInt("a_pathlevel"));
				dbocarcatalognew1.setHotlevel(rs.getInt("a_hotlevel"));
				dbocarcatalognew1.setFadongji(rs.getInt("a_fadongji"));
				dbocarcatalognew1.setBaoyangfeiyong(rs.getInt("a_baoyangfeiyong"));
				dbocarcatalognew1.setPengzhuanglevel(rs.getInt("a_pengzhuanglevel"));
				dbocarcatalognew1.setGuanurl(rs.getString("a_guanurl"));
				dbocarcatalognew1.setWayname(rs.getString("a_wayname"));
				dbocarcatalognew1.setCarbrandphoto(rs.getString("a_carbrandphoto"));
				dbocarcatalognew1.setOld_catalogid(rs.getInt("a_old_catalogid"));
				dbocarcatalognew1.setOld_fatherid(rs.getInt("a_old_fatherid"));
				dbocarcatalognew1.setYiche_price(rs.getDouble("a_yiche_price"));
				dbocarcatalognew1.setChetuanphoto(rs.getString("a_chetuanphoto"));
				dbocarcatalognew.setCarSeries(dbocarcatalognew1);
				list.add(dbocarcatalognew);
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

	public static List<DboCarCatalognew> DboCarCatalognewSelectAllColumnBylimit_beginlimit_num2(int limit_begin,int limit_num){
		DBConnect dbc = null;
		String sql = "select * from dbo_car_catalognew  order by catalogid asc limit ?,?";
		List<DboCarCatalognew> list = new ArrayList<DboCarCatalognew>();
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, limit_begin);
			dbc.setInt(2, limit_num);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarCatalognew obj = new DboCarCatalognew();
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

	public static List<DboCarCatalognew> SelectBycatalogid3(int catalogid){
		DBConnect dbc = null;
		String sql = "select a.catalogid a_catalogid,a.catalogname a_catalogname,a.fatherid a_fatherid,a.byname a_byname,a.path a_path,a.islive a_islive,a.onsale a_onsale,a.iyear a_iyear,a.iway a_iway,a.madein a_madein,a.xiangti a_xiangti,a.jibie a_jibie,a.leixing a_leixing,a.bsq a_bsq,a.pailiang a_pailiang,a.photo a_photo,a.serialname a_serialname,a.newsid a_newsid,a.isdelete a_isdelete,a.adddate a_adddate,a.lastupdate a_lastupdate,a.addadmin a_addadmin,a.updateadmin a_updateadmin,a.deladmin a_deladmin,a.sortid a_sortid,a.factorytel a_factorytel,a.carkey a_carkey,a.englishname a_englishname,a.maincatalogid a_maincatalogid,a.ishaverelation a_ishaverelation,a.lname a_lname,a.pathlevel a_pathlevel,a.hotlevel a_hotlevel,a.fadongji a_fadongji,a.baoyangfeiyong a_baoyangfeiyong,a.pengzhuanglevel a_pengzhuanglevel,a.guanurl a_guanurl,a.wayname a_wayname,a.carbrandphoto a_carbrandphoto,a.old_catalogid a_old_catalogid,a.old_fatherid a_old_fatherid,a.yiche_price a_yiche_price,a.chetuanphoto a_chetuanphoto,b.id b_id,b.catalogid b_catalogid,b.introduction b_introduction,b.advantage b_advantage,b.disadvantage b_disadvantage,b.old_catalogid b_old_catalogid from dbo_car_catalognew a,dbo_car_info b where a . catalogid = b . catalogid  and a . catalogid = ?   ";
		List<DboCarCatalognew> list = new ArrayList<DboCarCatalognew>();
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, catalogid);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarCatalognew dbocarcatalognew = new DboCarCatalognew();
				dbocarcatalognew.setCatalogid(rs.getInt("a_catalogid"));
				dbocarcatalognew.setCatalogname(rs.getString("a_catalogname"));
				dbocarcatalognew.setFatherid(rs.getInt("a_fatherid"));
				dbocarcatalognew.setByname(rs.getString("a_byname"));
				dbocarcatalognew.setPath(rs.getString("a_path"));
				dbocarcatalognew.setIslive(rs.getInt("a_islive"));
				dbocarcatalognew.setOnsale(rs.getInt("a_onsale"));
				dbocarcatalognew.setIyear(rs.getInt("a_iyear"));
				dbocarcatalognew.setIway(rs.getString("a_iway"));
				dbocarcatalognew.setMadein(rs.getInt("a_madein"));
				dbocarcatalognew.setXiangti(rs.getInt("a_xiangti"));
				dbocarcatalognew.setJibie(rs.getInt("a_jibie"));
				dbocarcatalognew.setLeixing(rs.getInt("a_leixing"));
				dbocarcatalognew.setBsq(rs.getInt("a_bsq"));
				dbocarcatalognew.setPailiang(rs.getInt("a_pailiang"));
				dbocarcatalognew.setPhoto(rs.getString("a_photo"));
				dbocarcatalognew.setSerialname(rs.getString("a_serialname"));
				dbocarcatalognew.setNewsid(rs.getInt("a_newsid"));
				dbocarcatalognew.setIsdelete(rs.getInt("a_isdelete"));
				dbocarcatalognew.setAdddate(rs.getTimestamp("a_adddate"));
				dbocarcatalognew.setLastupdate(rs.getTimestamp("a_lastupdate"));
				dbocarcatalognew.setAddadmin(rs.getString("a_addadmin"));
				dbocarcatalognew.setUpdateadmin(rs.getString("a_updateadmin"));
				dbocarcatalognew.setDeladmin(rs.getString("a_deladmin"));
				dbocarcatalognew.setSortid(rs.getInt("a_sortid"));
				dbocarcatalognew.setFactorytel(rs.getString("a_factorytel"));
				dbocarcatalognew.setCarkey(rs.getString("a_carkey"));
				dbocarcatalognew.setEnglishname(rs.getString("a_englishname"));
				dbocarcatalognew.setMaincatalogid(rs.getInt("a_maincatalogid"));
				dbocarcatalognew.setIshaverelation(rs.getInt("a_ishaverelation"));
				dbocarcatalognew.setLname(rs.getString("a_lname"));
				dbocarcatalognew.setPathlevel(rs.getInt("a_pathlevel"));
				dbocarcatalognew.setHotlevel(rs.getInt("a_hotlevel"));
				dbocarcatalognew.setFadongji(rs.getInt("a_fadongji"));
				dbocarcatalognew.setBaoyangfeiyong(rs.getInt("a_baoyangfeiyong"));
				dbocarcatalognew.setPengzhuanglevel(rs.getInt("a_pengzhuanglevel"));
				dbocarcatalognew.setGuanurl(rs.getString("a_guanurl"));
				dbocarcatalognew.setWayname(rs.getString("a_wayname"));
				dbocarcatalognew.setCarbrandphoto(rs.getString("a_carbrandphoto"));
				dbocarcatalognew.setOld_catalogid(rs.getInt("a_old_catalogid"));
				dbocarcatalognew.setOld_fatherid(rs.getInt("a_old_fatherid"));
				dbocarcatalognew.setYiche_price(rs.getDouble("a_yiche_price"));
				dbocarcatalognew.setChetuanphoto(rs.getString("a_chetuanphoto"));
				DboCarInfo dbocarinfo1 = new DboCarInfo();
				dbocarinfo1.setId(rs.getInt("b_id"));
				dbocarinfo1.setCatalogid(rs.getInt("b_catalogid"));
				dbocarinfo1.setIntroduction(rs.getString("b_introduction"));
				dbocarinfo1.setAdvantage(rs.getString("b_advantage"));
				dbocarinfo1.setDisadvantage(rs.getString("b_disadvantage"));
				dbocarinfo1.setOld_catalogid(rs.getInt("b_old_catalogid"));
				dbocarcatalognew.setCarInfo(dbocarinfo1);
				list.add(dbocarcatalognew);
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

	public static List<DboCarCatalognew> DboCarCatalognewSelectAllColumn(){
		DBConnect dbc = null;
		String sql = "select * from dbo_car_catalognew";
		List<DboCarCatalognew> list = new ArrayList<DboCarCatalognew>();
	
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarCatalognew obj = new DboCarCatalognew();
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
}