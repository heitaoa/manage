package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboPkztInfo;

public class  DboPkztInfoDao  extends BaseDao {

	public static void fill(ResultSet rs, DboPkztInfo dbopkztinfo) throws SQLException {
		dbopkztinfo.setId(rs.getInt("id"));//pkר��������id
		dbopkztinfo.setCarid1(rs.getInt("carid1"));//��ϵid1
		dbopkztinfo.setCarid2(rs.getInt("carid2"));//��ϵid2
		dbopkztinfo.setPrefacetitle(rs.getString("prefacetitle"));//
		dbopkztinfo.setPrefacecontent(rs.getString("prefacecontent"));//
		dbopkztinfo.setApptitle(rs.getString("apptitle"));//
		dbopkztinfo.setAppcontent1(rs.getString("appcontent1"));//
		dbopkztinfo.setAppcontent2(rs.getString("appcontent2"));//
		dbopkztinfo.setAppimgpath11(rs.getString("appimgpath11"));//
		dbopkztinfo.setAppimgpath12(rs.getString("appimgpath12"));//
		dbopkztinfo.setAppimgpath13(rs.getString("appimgpath13"));//
		dbopkztinfo.setAppimgpath14(rs.getString("appimgpath14"));//
		dbopkztinfo.setAppimgpath15(rs.getString("appimgpath15"));//
		dbopkztinfo.setAppimgpath21(rs.getString("appimgpath21"));//
		dbopkztinfo.setAppimgpath22(rs.getString("appimgpath22"));//
		dbopkztinfo.setAppimgpath23(rs.getString("appimgpath23"));//
		dbopkztinfo.setAppimgpath24(rs.getString("appimgpath24"));//
		dbopkztinfo.setAppimgpath25(rs.getString("appimgpath25"));//
		dbopkztinfo.setSeattitle(rs.getString("seattitle"));//
		dbopkztinfo.setSeatcontent1(rs.getString("seatcontent1"));//
		dbopkztinfo.setSeatcontent2(rs.getString("seatcontent2"));//
		dbopkztinfo.setSeatimgpath11(rs.getString("seatimgpath11"));//
		dbopkztinfo.setSeatimgpath12(rs.getString("seatimgpath12"));//
		dbopkztinfo.setSeatimgpath13(rs.getString("seatimgpath13"));//
		dbopkztinfo.setSeatimgpath14(rs.getString("seatimgpath14"));//
		dbopkztinfo.setSeatimgpath15(rs.getString("seatimgpath15"));//
		dbopkztinfo.setSeatimgpath21(rs.getString("seatimgpath21"));//
		dbopkztinfo.setSeatimgpath22(rs.getString("seatimgpath22"));//
		dbopkztinfo.setSeatimgpath23(rs.getString("seatimgpath23"));//
		dbopkztinfo.setSeatimgpath24(rs.getString("seatimgpath24"));//
		dbopkztinfo.setSeatimgpath25(rs.getString("seatimgpath25"));//
		dbopkztinfo.setCtrltitle(rs.getString("ctrltitle"));//
		dbopkztinfo.setCtrlcontent1(rs.getString("ctrlcontent1"));//
		dbopkztinfo.setCtrlcontent2(rs.getString("ctrlcontent2"));//
		dbopkztinfo.setCtrlimgpath11(rs.getString("ctrlimgpath11"));//
		dbopkztinfo.setCtrlimgpath12(rs.getString("ctrlimgpath12"));//
		dbopkztinfo.setCtrlimgpath21(rs.getString("ctrlimgpath21"));//
		dbopkztinfo.setCtrlimgpath22(rs.getString("ctrlimgpath22"));//
		dbopkztinfo.setSummarytitle(rs.getString("summarytitle"));//
		dbopkztinfo.setSummarycontent(rs.getString("summarycontent"));//
		dbopkztinfo.setAdddate(rs.getTimestamp("adddate"));//
		dbopkztinfo.setUptime(rs.getTimestamp("uptime"));//
		dbopkztinfo.setIsdelete(rs.getInt("isdelete"));//
	}

	public static List<DboPkztInfo> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_pkzt_info";
		List<DboPkztInfo> list = new ArrayList<DboPkztInfo>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboPkztInfo dbopkztinfo = new DboPkztInfo();
				fill(rs, dbopkztinfo);
				list.add(dbopkztinfo);
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


	public static List<DboPkztInfo> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_pkzt_info where "+subsql+"";
		List<DboPkztInfo> list = new ArrayList<DboPkztInfo>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboPkztInfo dbopkztinfo = new DboPkztInfo();
				fill(rs, dbopkztinfo);
				list.add(dbopkztinfo);
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
		String sql = "select count(*) from dbo_pkzt_info where "+subsql+"";
		
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
		String sql = "delete from dbo_pkzt_info where "+subsql+"";
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
		String sql = "delete from dbo_pkzt_info where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboPkztInfo dbopkztinfo) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_pkzt_info(`id`,`carid1`,`carid2`,`prefacetitle`,`prefacecontent`,`apptitle`,`appcontent1`,`appcontent2`,`appimgpath11`,`appimgpath12`,`appimgpath13`,`appimgpath14`,`appimgpath15`,`appimgpath21`,`appimgpath22`,`appimgpath23`,`appimgpath24`,`appimgpath25`,`seattitle`,`seatcontent1`,`seatcontent2`,`seatimgpath11`,`seatimgpath12`,`seatimgpath13`,`seatimgpath14`,`seatimgpath15`,`seatimgpath21`,`seatimgpath22`,`seatimgpath23`,`seatimgpath24`,`seatimgpath25`,`ctrltitle`,`ctrlcontent1`,`ctrlcontent2`,`ctrlimgpath11`,`ctrlimgpath12`,`ctrlimgpath21`,`ctrlimgpath22`,`summarytitle`,`summarycontent`,`adddate`,`uptime`,`isdelete`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbopkztinfo.getId());
		dbc.setInt(2, dbopkztinfo.getCarid1());
		dbc.setInt(3, dbopkztinfo.getCarid2());
		dbc.setString(4, dbopkztinfo.getPrefacetitle());
		dbc.setString(5, dbopkztinfo.getPrefacecontent());
		dbc.setString(6, dbopkztinfo.getApptitle());
		dbc.setString(7, dbopkztinfo.getAppcontent1());
		dbc.setString(8, dbopkztinfo.getAppcontent2());
		dbc.setString(9, dbopkztinfo.getAppimgpath11());
		dbc.setString(10, dbopkztinfo.getAppimgpath12());
		dbc.setString(11, dbopkztinfo.getAppimgpath13());
		dbc.setString(12, dbopkztinfo.getAppimgpath14());
		dbc.setString(13, dbopkztinfo.getAppimgpath15());
		dbc.setString(14, dbopkztinfo.getAppimgpath21());
		dbc.setString(15, dbopkztinfo.getAppimgpath22());
		dbc.setString(16, dbopkztinfo.getAppimgpath23());
		dbc.setString(17, dbopkztinfo.getAppimgpath24());
		dbc.setString(18, dbopkztinfo.getAppimgpath25());
		dbc.setString(19, dbopkztinfo.getSeattitle());
		dbc.setString(20, dbopkztinfo.getSeatcontent1());
		dbc.setString(21, dbopkztinfo.getSeatcontent2());
		dbc.setString(22, dbopkztinfo.getSeatimgpath11());
		dbc.setString(23, dbopkztinfo.getSeatimgpath12());
		dbc.setString(24, dbopkztinfo.getSeatimgpath13());
		dbc.setString(25, dbopkztinfo.getSeatimgpath14());
		dbc.setString(26, dbopkztinfo.getSeatimgpath15());
		dbc.setString(27, dbopkztinfo.getSeatimgpath21());
		dbc.setString(28, dbopkztinfo.getSeatimgpath22());
		dbc.setString(29, dbopkztinfo.getSeatimgpath23());
		dbc.setString(30, dbopkztinfo.getSeatimgpath24());
		dbc.setString(31, dbopkztinfo.getSeatimgpath25());
		dbc.setString(32, dbopkztinfo.getCtrltitle());
		dbc.setString(33, dbopkztinfo.getCtrlcontent1());
		dbc.setString(34, dbopkztinfo.getCtrlcontent2());
		dbc.setString(35, dbopkztinfo.getCtrlimgpath11());
		dbc.setString(36, dbopkztinfo.getCtrlimgpath12());
		dbc.setString(37, dbopkztinfo.getCtrlimgpath21());
		dbc.setString(38, dbopkztinfo.getCtrlimgpath22());
		dbc.setString(39, dbopkztinfo.getSummarytitle());
		dbc.setString(40, dbopkztinfo.getSummarycontent());
		System.out.println(dbopkztinfo.getAdddate());
		dbc.setTimestamp(41, new Timestamp(dbopkztinfo.getAdddate().getTime()));
		
		dbc.setTimestamp(42, new Timestamp(dbopkztinfo.getUptime().getTime()));
		dbc.setInt(43, dbopkztinfo.getIsdelete());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboPkztInfo dbopkztinfo) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_pkzt_info(`id`,`carid1`,`carid2`,`prefacetitle`,`prefacecontent`,`apptitle`,`appcontent1`,`appcontent2`,`appimgpath11`,`appimgpath12`,`appimgpath13`,`appimgpath14`,`appimgpath15`,`appimgpath21`,`appimgpath22`,`appimgpath23`,`appimgpath24`,`appimgpath25`,`seattitle`,`seatcontent1`,`seatcontent2`,`seatimgpath11`,`seatimgpath12`,`seatimgpath13`,`seatimgpath14`,`seatimgpath15`,`seatimgpath21`,`seatimgpath22`,`seatimgpath23`,`seatimgpath24`,`seatimgpath25`,`ctrltitle`,`ctrlcontent1`,`ctrlcontent2`,`ctrlimgpath11`,`ctrlimgpath12`,`ctrlimgpath21`,`ctrlimgpath22`,`summarytitle`,`summarycontent`,`adddate`,`uptime`,`isdelete`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbopkztinfo.getId());
		dbc.setInt(2, dbopkztinfo.getCarid1());
		dbc.setInt(3, dbopkztinfo.getCarid2());
		dbc.setString(4, dbopkztinfo.getPrefacetitle());
		dbc.setString(5, dbopkztinfo.getPrefacecontent());
		dbc.setString(6, dbopkztinfo.getApptitle());
		dbc.setString(7, dbopkztinfo.getAppcontent1());
		dbc.setString(8, dbopkztinfo.getAppcontent2());
		dbc.setString(9, dbopkztinfo.getAppimgpath11());
		dbc.setString(10, dbopkztinfo.getAppimgpath12());
		dbc.setString(11, dbopkztinfo.getAppimgpath13());
		dbc.setString(12, dbopkztinfo.getAppimgpath14());
		dbc.setString(13, dbopkztinfo.getAppimgpath15());
		dbc.setString(14, dbopkztinfo.getAppimgpath21());
		dbc.setString(15, dbopkztinfo.getAppimgpath22());
		dbc.setString(16, dbopkztinfo.getAppimgpath23());
		dbc.setString(17, dbopkztinfo.getAppimgpath24());
		dbc.setString(18, dbopkztinfo.getAppimgpath25());
		dbc.setString(19, dbopkztinfo.getSeattitle());
		dbc.setString(20, dbopkztinfo.getSeatcontent1());
		dbc.setString(21, dbopkztinfo.getSeatcontent2());
		dbc.setString(22, dbopkztinfo.getSeatimgpath11());
		dbc.setString(23, dbopkztinfo.getSeatimgpath12());
		dbc.setString(24, dbopkztinfo.getSeatimgpath13());
		dbc.setString(25, dbopkztinfo.getSeatimgpath14());
		dbc.setString(26, dbopkztinfo.getSeatimgpath15());
		dbc.setString(27, dbopkztinfo.getSeatimgpath21());
		dbc.setString(28, dbopkztinfo.getSeatimgpath22());
		dbc.setString(29, dbopkztinfo.getSeatimgpath23());
		dbc.setString(30, dbopkztinfo.getSeatimgpath24());
		dbc.setString(31, dbopkztinfo.getSeatimgpath25());
		dbc.setString(32, dbopkztinfo.getCtrltitle());
		dbc.setString(33, dbopkztinfo.getCtrlcontent1());
		dbc.setString(34, dbopkztinfo.getCtrlcontent2());
		dbc.setString(35, dbopkztinfo.getCtrlimgpath11());
		dbc.setString(36, dbopkztinfo.getCtrlimgpath12());
		dbc.setString(37, dbopkztinfo.getCtrlimgpath21());
		dbc.setString(38, dbopkztinfo.getCtrlimgpath22());
		dbc.setString(39, dbopkztinfo.getSummarytitle());
		dbc.setString(40, dbopkztinfo.getSummarycontent());
		dbc.setTimestamp(41, new Timestamp(dbopkztinfo.getAdddate().getTime()));
		dbc.setTimestamp(42, new Timestamp(dbopkztinfo.getUptime().getTime()));
		dbc.setInt(43, dbopkztinfo.getIsdelete());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboPkztInfo dbopkztinfo) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_pkzt_info set ");
		boolean flag = false;
		if(dbopkztinfo.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",carid1=?");
			}else{
				sb.append("carid1=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",carid2=?");
			}else{
				sb.append("carid2=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",prefacetitle=?");
			}else{
				sb.append("prefacetitle=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",prefacecontent=?");
			}else{
				sb.append("prefacecontent=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",apptitle=?");
			}else{
				sb.append("apptitle=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",appcontent1=?");
			}else{
				sb.append("appcontent1=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",appcontent2=?");
			}else{
				sb.append("appcontent2=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",appimgpath11=?");
			}else{
				sb.append("appimgpath11=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",appimgpath12=?");
			}else{
				sb.append("appimgpath12=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",appimgpath13=?");
			}else{
				sb.append("appimgpath13=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",appimgpath14=?");
			}else{
				sb.append("appimgpath14=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",appimgpath15=?");
			}else{
				sb.append("appimgpath15=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",appimgpath21=?");
			}else{
				sb.append("appimgpath21=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",appimgpath22=?");
			}else{
				sb.append("appimgpath22=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",appimgpath23=?");
			}else{
				sb.append("appimgpath23=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",appimgpath24=?");
			}else{
				sb.append("appimgpath24=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",appimgpath25=?");
			}else{
				sb.append("appimgpath25=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[18]){
			if(flag){
				sb.append(",seattitle=?");
			}else{
				sb.append("seattitle=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[19]){
			if(flag){
				sb.append(",seatcontent1=?");
			}else{
				sb.append("seatcontent1=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[20]){
			if(flag){
				sb.append(",seatcontent2=?");
			}else{
				sb.append("seatcontent2=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[21]){
			if(flag){
				sb.append(",seatimgpath11=?");
			}else{
				sb.append("seatimgpath11=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[22]){
			if(flag){
				sb.append(",seatimgpath12=?");
			}else{
				sb.append("seatimgpath12=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[23]){
			if(flag){
				sb.append(",seatimgpath13=?");
			}else{
				sb.append("seatimgpath13=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[24]){
			if(flag){
				sb.append(",seatimgpath14=?");
			}else{
				sb.append("seatimgpath14=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[25]){
			if(flag){
				sb.append(",seatimgpath15=?");
			}else{
				sb.append("seatimgpath15=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[26]){
			if(flag){
				sb.append(",seatimgpath21=?");
			}else{
				sb.append("seatimgpath21=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[27]){
			if(flag){
				sb.append(",seatimgpath22=?");
			}else{
				sb.append("seatimgpath22=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[28]){
			if(flag){
				sb.append(",seatimgpath23=?");
			}else{
				sb.append("seatimgpath23=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[29]){
			if(flag){
				sb.append(",seatimgpath24=?");
			}else{
				sb.append("seatimgpath24=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[30]){
			if(flag){
				sb.append(",seatimgpath25=?");
			}else{
				sb.append("seatimgpath25=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[31]){
			if(flag){
				sb.append(",ctrltitle=?");
			}else{
				sb.append("ctrltitle=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[32]){
			if(flag){
				sb.append(",ctrlcontent1=?");
			}else{
				sb.append("ctrlcontent1=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[33]){
			if(flag){
				sb.append(",ctrlcontent2=?");
			}else{
				sb.append("ctrlcontent2=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[34]){
			if(flag){
				sb.append(",ctrlimgpath11=?");
			}else{
				sb.append("ctrlimgpath11=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[35]){
			if(flag){
				sb.append(",ctrlimgpath12=?");
			}else{
				sb.append("ctrlimgpath12=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[36]){
			if(flag){
				sb.append(",ctrlimgpath21=?");
			}else{
				sb.append("ctrlimgpath21=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[37]){
			if(flag){
				sb.append(",ctrlimgpath22=?");
			}else{
				sb.append("ctrlimgpath22=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[38]){
			if(flag){
				sb.append(",summarytitle=?");
			}else{
				sb.append("summarytitle=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[39]){
			if(flag){
				sb.append(",summarycontent=?");
			}else{
				sb.append("summarycontent=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[40]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[41]){
			if(flag){
				sb.append(",uptime=?");
			}else{
				sb.append("uptime=?");
				flag=true;
			}
		}
		if(dbopkztinfo.COLUMN_FLAG[42]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbopkztinfo.COLUMN_FLAG[0]){
			dbc.setInt(k, dbopkztinfo.getId());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[1]){
			dbc.setInt(k, dbopkztinfo.getCarid1());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[2]){
			dbc.setInt(k, dbopkztinfo.getCarid2());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[3]){
			dbc.setString(k, dbopkztinfo.getPrefacetitle());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[4]){
			dbc.setString(k, dbopkztinfo.getPrefacecontent());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[5]){
			dbc.setString(k, dbopkztinfo.getApptitle());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[6]){
			dbc.setString(k, dbopkztinfo.getAppcontent1());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[7]){
			dbc.setString(k, dbopkztinfo.getAppcontent2());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[8]){
			dbc.setString(k, dbopkztinfo.getAppimgpath11());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[9]){
			dbc.setString(k, dbopkztinfo.getAppimgpath12());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[10]){
			dbc.setString(k, dbopkztinfo.getAppimgpath13());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[11]){
			dbc.setString(k, dbopkztinfo.getAppimgpath14());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[12]){
			dbc.setString(k, dbopkztinfo.getAppimgpath15());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[13]){
			dbc.setString(k, dbopkztinfo.getAppimgpath21());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[14]){
			dbc.setString(k, dbopkztinfo.getAppimgpath22());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[15]){
			dbc.setString(k, dbopkztinfo.getAppimgpath23());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[16]){
			dbc.setString(k, dbopkztinfo.getAppimgpath24());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[17]){
			dbc.setString(k, dbopkztinfo.getAppimgpath25());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[18]){
			dbc.setString(k, dbopkztinfo.getSeattitle());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[19]){
			dbc.setString(k, dbopkztinfo.getSeatcontent1());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[20]){
			dbc.setString(k, dbopkztinfo.getSeatcontent2());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[21]){
			dbc.setString(k, dbopkztinfo.getSeatimgpath11());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[22]){
			dbc.setString(k, dbopkztinfo.getSeatimgpath12());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[23]){
			dbc.setString(k, dbopkztinfo.getSeatimgpath13());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[24]){
			dbc.setString(k, dbopkztinfo.getSeatimgpath14());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[25]){
			dbc.setString(k, dbopkztinfo.getSeatimgpath15());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[26]){
			dbc.setString(k, dbopkztinfo.getSeatimgpath21());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[27]){
			dbc.setString(k, dbopkztinfo.getSeatimgpath22());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[28]){
			dbc.setString(k, dbopkztinfo.getSeatimgpath23());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[29]){
			dbc.setString(k, dbopkztinfo.getSeatimgpath24());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[30]){
			dbc.setString(k, dbopkztinfo.getSeatimgpath25());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[31]){
			dbc.setString(k, dbopkztinfo.getCtrltitle());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[32]){
			dbc.setString(k, dbopkztinfo.getCtrlcontent1());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[33]){
			dbc.setString(k, dbopkztinfo.getCtrlcontent2());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[34]){
			dbc.setString(k, dbopkztinfo.getCtrlimgpath11());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[35]){
			dbc.setString(k, dbopkztinfo.getCtrlimgpath12());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[36]){
			dbc.setString(k, dbopkztinfo.getCtrlimgpath21());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[37]){
			dbc.setString(k, dbopkztinfo.getCtrlimgpath22());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[38]){
			dbc.setString(k, dbopkztinfo.getSummarytitle());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[39]){
			dbc.setString(k, dbopkztinfo.getSummarycontent());k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[40]){
			dbc.setTimestamp(k, new Timestamp(dbopkztinfo.getAdddate().getTime()));k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[41]){
			dbc.setTimestamp(k, new Timestamp(dbopkztinfo.getUptime().getTime()));k++;
		}
		if(dbopkztinfo.COLUMN_FLAG[42]){
			dbc.setInt(k, dbopkztinfo.getIsdelete());k++;
		}
		dbc.setInt(k, dbopkztinfo.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboPkztInfo dbopkztinfo) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbopkztinfo);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}