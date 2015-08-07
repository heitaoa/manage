package com.poly.util.syscardata;
import java.sql.*;
import java.util.*;

import car_beans.DboCarCatalognew;
import car_daos.BaseDao;

public class  DboCarCatalognewDao194  extends BaseDao {

	public static void fill(ResultSet rs, DboCarCatalognew dbocarcatalognew) throws SQLException {
		dbocarcatalognew.setCatalogid(rs.getInt("catalogid"));//
		dbocarcatalognew.setCatalogname(rs.getString("catalogname"));//
		dbocarcatalognew.setFatherid(rs.getInt("fatherid"));//
		dbocarcatalognew.setByname(rs.getString("byname"));//
		dbocarcatalognew.setPath(rs.getString("path"));//
		dbocarcatalognew.setIslive(rs.getInt("islive"));
		dbocarcatalognew.setIyear(rs.getInt("iyear"));//
		dbocarcatalognew.setIway(rs.getString("iway"));//
		dbocarcatalognew.setMadein(rs.getInt("madein"));
		dbocarcatalognew.setJibie(rs.getInt("jibie"));
		dbocarcatalognew.setLeixing(rs.getInt("leixing"));
		dbocarcatalognew.setBsq(rs.getInt("bsq"));
		dbocarcatalognew.setPailiang(rs.getInt("pailiang"));
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
		dbocarcatalognew.setPathlevel(rs.getInt("pathlevel"));//
		dbocarcatalognew.setHotlevel(rs.getInt("hotlevel"));//
		dbocarcatalognew.setFadongji(rs.getInt("fadongji"));
		dbocarcatalognew.setBaoyangfeiyong(rs.getInt("baoyangfeiyong"));//
		dbocarcatalognew.setPengzhuanglevel(rs.getInt("pengzhuanglevel"));//
		dbocarcatalognew.setGuanurl(rs.getString("guanurl"));//
		dbocarcatalognew.setWayname(rs.getString("wayname"));
		//dbocarcatalognew.setCarbrandphoto(rs.getString("carbrandphoto"));
		//dbocarcatalognew.setOld_catalogid(rs.getInt("old_catalogid"));
	}

	public static List<DboCarCatalognew> find() {
		DBConnect194 dbc = null;
		String sql = "select * from dbo_car_catalognew";
		List<DboCarCatalognew> list = new ArrayList<DboCarCatalognew>();
		
		try {
			dbc = new DBConnect194(sql);
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
		DBConnect194 dbc = null;
		String sql = "select * from dbo_car_catalognew where "+subsql+"";
		List<DboCarCatalognew> list = new ArrayList<DboCarCatalognew>();
		
		try {
			dbc = new DBConnect194(sql);
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
		DBConnect194 dbc = null;
		int result = EXECUTE_FAIL;
		String sql = "select count(*) from dbo_car_catalognew where "+subsql+"";
		
		try {
			dbc = new DBConnect194(sql);
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
		DBConnect194 dbc = null;
		String sql = "delete from dbo_car_catalognew where "+subsql+"";
		try {
			dbc = new DBConnect194();
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

	public static int delete(DBConnect194 dbc,String subsql) {
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
		DBConnect194 dbc = null;
		String sql = "insert into dbo_car_catalognew(`catalogid`,`catalogname`,`fatherid`,`byname`,`path`,`islive`,`onsale`,`iyear`,`iway`,`madein`,`xiangti`,`jibie`,`leixing`,`bsq`,`pailiang`,`photo`,`serialname`,`newsid`,`isdelete`,`adddate`,`lastupdate`,`addadmin`,`updateadmin`,`deladmin`,`sortid`,`factorytel`,`carkey`,`englishname`,`maincatalogid`,`ishaverelation`,`lname`,`pathlevel`,`hotlevel`,`fadongji`,`baoyangfeiyong`,`pengzhuanglevel`,`guanurl`,`wayname`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect194();
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
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect194 dbc,DboCarCatalognew dbocarcatalognew) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_car_catalognew(`catalogid`,`catalogname`,`fatherid`,`byname`,`path`,`islive`,`onsale`,`iyear`,`iway`,`madein`,`xiangti`,`jibie`,`leixing`,`bsq`,`pailiang`,`photo`,`serialname`,`newsid`,`isdelete`,`adddate`,`lastupdate`,`addadmin`,`updateadmin`,`deladmin`,`sortid`,`factorytel`,`carkey`,`englishname`,`maincatalogid`,`ishaverelation`,`lname`,`pathlevel`,`hotlevel`,`fadongji`,`baoyangfeiyong`,`pengzhuanglevel`,`guanurl`,`wayname`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect194 dbc,DboCarCatalognew dbocarcatalognew) throws Exception {
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
		sb.append(" where catalogid=?");
		dbc = new DBConnect194();
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
		dbc.setInt(k, dbocarcatalognew.getCatalogid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboCarCatalognew dbocarcatalognew) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect194 dbc = new DBConnect194();
			result = update(dbc, dbocarcatalognew);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}