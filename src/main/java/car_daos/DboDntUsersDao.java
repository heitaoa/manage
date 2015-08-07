package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDntUsers;

public class  DboDntUsersDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDntUsers dbodntusers) throws SQLException {
		dbodntusers.setUid(rs.getInt("uid"));//
		dbodntusers.setUsername(rs.getString("username"));//登录名
		dbodntusers.setNickname(rs.getString("nickname"));//
		dbodntusers.setPassword(rs.getString("password"));//
		dbodntusers.setSecques(rs.getString("secques"));//
		dbodntusers.setSpaceid(rs.getInt("spaceid"));//地域信息
		dbodntusers.setGender(rs.getInt("gender"));//
		dbodntusers.setAdminid(rs.getInt("adminid"));//
		dbodntusers.setGroupid(rs.getInt("groupid"));//
		dbodntusers.setGroupexpiry(rs.getInt("groupexpiry"));//
		dbodntusers.setExtgroupids(rs.getString("extgroupids"));//
		dbodntusers.setRegip(rs.getString("regip"));//
		dbodntusers.setJoindate(rs.getTimestamp("joindate"));//
		dbodntusers.setLastip(rs.getString("lastip"));//
		dbodntusers.setLastvisit(rs.getTimestamp("lastvisit"));//
		dbodntusers.setLastactivity(rs.getTimestamp("lastactivity"));//
		dbodntusers.setLastpost(rs.getTimestamp("lastpost"));//
		dbodntusers.setLastpostid(rs.getInt("lastpostid"));//
		dbodntusers.setLastposttitle(rs.getString("lastposttitle"));//
		dbodntusers.setPosts(rs.getInt("posts"));//
		dbodntusers.setDigestposts(rs.getInt("digestposts"));//
		dbodntusers.setOltime(rs.getInt("oltime"));//
		dbodntusers.setPageviews(rs.getInt("pageviews"));//
		dbodntusers.setCredits(rs.getDouble("credits"));//
		dbodntusers.setExtcredits1(rs.getDouble("extcredits1"));//
		dbodntusers.setExtcredits2(rs.getDouble("extcredits2"));//
		dbodntusers.setExtcredits3(rs.getDouble("extcredits3"));//
		dbodntusers.setExtcredits4(rs.getDouble("extcredits4"));//
		dbodntusers.setExtcredits5(rs.getDouble("extcredits5"));//
		dbodntusers.setExtcredits6(rs.getDouble("extcredits6"));//
		dbodntusers.setExtcredits7(rs.getDouble("extcredits7"));//
		dbodntusers.setExtcredits8(rs.getDouble("extcredits8"));//
		dbodntusers.setAvatarshowid(rs.getInt("avatarshowid"));//
		dbodntusers.setEmail(rs.getString("email"));//
		dbodntusers.setBday(rs.getString("bday"));//
		dbodntusers.setSigstatus(rs.getInt("sigstatus"));//
		dbodntusers.setTpp(rs.getInt("tpp"));//
		dbodntusers.setPpp(rs.getInt("ppp"));//
		dbodntusers.setTemplateid(rs.getInt("templateid"));//
		dbodntusers.setPmsound(rs.getInt("pmsound"));//
		dbodntusers.setShowemail(rs.getInt("showemail"));//
		dbodntusers.setNewsletter(rs.getInt("newsletter"));//
		dbodntusers.setInvisible(rs.getInt("invisible"));//
		dbodntusers.setNewpm(rs.getInt("newpm"));//
		dbodntusers.setNewpmcount(rs.getInt("newpmcount"));//
		dbodntusers.setAccessmasks(rs.getInt("accessmasks"));//
		dbodntusers.setOnlinestate(rs.getInt("onlinestate"));//
		dbodntusers.setPass(rs.getString("pass"));//
		dbodntusers.setSalt(rs.getString("salt"));//
		dbodntusers.setSalt2(rs.getString("salt2"));//
		dbodntusers.setCarnumber(rs.getString("carnumber"));//
		dbodntusers.setGuid(rs.getInt("guid"));//
		dbodntusers.setBuydate(rs.getTimestamp("buydate"));//
	}

	public static List<DboDntUsers> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dnt_users";
		List<DboDntUsers> list = new ArrayList<DboDntUsers>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDntUsers dbodntusers = new DboDntUsers();
				fill(rs, dbodntusers);
				list.add(dbodntusers);
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


	public static List<DboDntUsers> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dnt_users where "+subsql+"";
		List<DboDntUsers> list = new ArrayList<DboDntUsers>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDntUsers dbodntusers = new DboDntUsers();
				fill(rs, dbodntusers);
				list.add(dbodntusers);
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
		String sql = "select count(*) from dbo_dnt_users where "+subsql+"";
		
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
		String sql = "delete from dbo_dnt_users where "+subsql+"";
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
		String sql = "delete from dbo_dnt_users where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDntUsers dbodntusers) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dnt_users(`uid`,`username`,`nickname`,`password`,`secques`,`spaceid`,`gender`,`adminid`,`groupid`,`groupexpiry`,`extgroupids`,`regip`,`joindate`,`lastip`,`lastvisit`,`lastactivity`,`lastpost`,`lastpostid`,`lastposttitle`,`posts`,`digestposts`,`oltime`,`pageviews`,`credits`,`extcredits1`,`extcredits2`,`extcredits3`,`extcredits4`,`extcredits5`,`extcredits6`,`extcredits7`,`extcredits8`,`avatarshowid`,`email`,`bday`,`sigstatus`,`tpp`,`ppp`,`templateid`,`pmsound`,`showemail`,`newsletter`,`invisible`,`newpm`,`newpmcount`,`accessmasks`,`onlinestate`,`pass`,`salt`,`salt2`,`carnumber`,`guid`,`buydate`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodntusers.getUid());
		dbc.setString(2, dbodntusers.getUsername());
		dbc.setString(3, dbodntusers.getNickname());
		dbc.setString(4, dbodntusers.getPassword());
		dbc.setString(5, dbodntusers.getSecques());
		dbc.setInt(6, dbodntusers.getSpaceid());
		dbc.setInt(7, dbodntusers.getGender());
		dbc.setInt(8, dbodntusers.getAdminid());
		dbc.setInt(9, dbodntusers.getGroupid());
		dbc.setInt(10, dbodntusers.getGroupexpiry());
		dbc.setString(11, dbodntusers.getExtgroupids());
		dbc.setString(12, dbodntusers.getRegip());
		dbc.setTimestamp(13, new Timestamp(dbodntusers.getJoindate().getTime()));
		dbc.setString(14, dbodntusers.getLastip());
		dbc.setTimestamp(15, new Timestamp(dbodntusers.getLastvisit().getTime()));
		dbc.setTimestamp(16, new Timestamp(dbodntusers.getLastactivity().getTime()));
		dbc.setTimestamp(17, new Timestamp(dbodntusers.getLastpost().getTime()));
		dbc.setInt(18, dbodntusers.getLastpostid());
		dbc.setString(19, dbodntusers.getLastposttitle());
		dbc.setInt(20, dbodntusers.getPosts());
		dbc.setInt(21, dbodntusers.getDigestposts());
		dbc.setInt(22, dbodntusers.getOltime());
		dbc.setInt(23, dbodntusers.getPageviews());
		dbc.setDouble(24, dbodntusers.getCredits());
		dbc.setDouble(25, dbodntusers.getExtcredits1());
		dbc.setDouble(26, dbodntusers.getExtcredits2());
		dbc.setDouble(27, dbodntusers.getExtcredits3());
		dbc.setDouble(28, dbodntusers.getExtcredits4());
		dbc.setDouble(29, dbodntusers.getExtcredits5());
		dbc.setDouble(30, dbodntusers.getExtcredits6());
		dbc.setDouble(31, dbodntusers.getExtcredits7());
		dbc.setDouble(32, dbodntusers.getExtcredits8());
		dbc.setInt(33, dbodntusers.getAvatarshowid());
		dbc.setString(34, dbodntusers.getEmail());
		dbc.setString(35, dbodntusers.getBday());
		dbc.setInt(36, dbodntusers.getSigstatus());
		dbc.setInt(37, dbodntusers.getTpp());
		dbc.setInt(38, dbodntusers.getPpp());
		dbc.setInt(39, dbodntusers.getTemplateid());
		dbc.setInt(40, dbodntusers.getPmsound());
		dbc.setInt(41, dbodntusers.getShowemail());
		dbc.setInt(42, dbodntusers.getNewsletter());
		dbc.setInt(43, dbodntusers.getInvisible());
		dbc.setInt(44, dbodntusers.getNewpm());
		dbc.setInt(45, dbodntusers.getNewpmcount());
		dbc.setInt(46, dbodntusers.getAccessmasks());
		dbc.setInt(47, dbodntusers.getOnlinestate());
		dbc.setString(48, dbodntusers.getPass());
		dbc.setString(49, dbodntusers.getSalt());
		dbc.setString(50, dbodntusers.getSalt2());
		dbc.setString(51, dbodntusers.getCarnumber());
		dbc.setInt(52, dbodntusers.getGuid());
		dbc.setTimestamp(53, new Timestamp(dbodntusers.getBuydate().getTime()));
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDntUsers dbodntusers) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dnt_users(`uid`,`username`,`nickname`,`password`,`secques`,`spaceid`,`gender`,`adminid`,`groupid`,`groupexpiry`,`extgroupids`,`regip`,`joindate`,`lastip`,`lastvisit`,`lastactivity`,`lastpost`,`lastpostid`,`lastposttitle`,`posts`,`digestposts`,`oltime`,`pageviews`,`credits`,`extcredits1`,`extcredits2`,`extcredits3`,`extcredits4`,`extcredits5`,`extcredits6`,`extcredits7`,`extcredits8`,`avatarshowid`,`email`,`bday`,`sigstatus`,`tpp`,`ppp`,`templateid`,`pmsound`,`showemail`,`newsletter`,`invisible`,`newpm`,`newpmcount`,`accessmasks`,`onlinestate`,`pass`,`salt`,`salt2`,`carnumber`,`guid`,`buydate`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodntusers.getUid());
		dbc.setString(2, dbodntusers.getUsername());
		dbc.setString(3, dbodntusers.getNickname());
		dbc.setString(4, dbodntusers.getPassword());
		dbc.setString(5, dbodntusers.getSecques());
		dbc.setInt(6, dbodntusers.getSpaceid());
		dbc.setInt(7, dbodntusers.getGender());
		dbc.setInt(8, dbodntusers.getAdminid());
		dbc.setInt(9, dbodntusers.getGroupid());
		dbc.setInt(10, dbodntusers.getGroupexpiry());
		dbc.setString(11, dbodntusers.getExtgroupids());
		dbc.setString(12, dbodntusers.getRegip());
		dbc.setTimestamp(13, new Timestamp(dbodntusers.getJoindate().getTime()));
		dbc.setString(14, dbodntusers.getLastip());
		dbc.setTimestamp(15, new Timestamp(dbodntusers.getLastvisit().getTime()));
		dbc.setTimestamp(16, new Timestamp(dbodntusers.getLastactivity().getTime()));
		dbc.setTimestamp(17, new Timestamp(dbodntusers.getLastpost().getTime()));
		dbc.setInt(18, dbodntusers.getLastpostid());
		dbc.setString(19, dbodntusers.getLastposttitle());
		dbc.setInt(20, dbodntusers.getPosts());
		dbc.setInt(21, dbodntusers.getDigestposts());
		dbc.setInt(22, dbodntusers.getOltime());
		dbc.setInt(23, dbodntusers.getPageviews());
		dbc.setDouble(24, dbodntusers.getCredits());
		dbc.setDouble(25, dbodntusers.getExtcredits1());
		dbc.setDouble(26, dbodntusers.getExtcredits2());
		dbc.setDouble(27, dbodntusers.getExtcredits3());
		dbc.setDouble(28, dbodntusers.getExtcredits4());
		dbc.setDouble(29, dbodntusers.getExtcredits5());
		dbc.setDouble(30, dbodntusers.getExtcredits6());
		dbc.setDouble(31, dbodntusers.getExtcredits7());
		dbc.setDouble(32, dbodntusers.getExtcredits8());
		dbc.setInt(33, dbodntusers.getAvatarshowid());
		dbc.setString(34, dbodntusers.getEmail());
		dbc.setString(35, dbodntusers.getBday());
		dbc.setInt(36, dbodntusers.getSigstatus());
		dbc.setInt(37, dbodntusers.getTpp());
		dbc.setInt(38, dbodntusers.getPpp());
		dbc.setInt(39, dbodntusers.getTemplateid());
		dbc.setInt(40, dbodntusers.getPmsound());
		dbc.setInt(41, dbodntusers.getShowemail());
		dbc.setInt(42, dbodntusers.getNewsletter());
		dbc.setInt(43, dbodntusers.getInvisible());
		dbc.setInt(44, dbodntusers.getNewpm());
		dbc.setInt(45, dbodntusers.getNewpmcount());
		dbc.setInt(46, dbodntusers.getAccessmasks());
		dbc.setInt(47, dbodntusers.getOnlinestate());
		dbc.setString(48, dbodntusers.getPass());
		dbc.setString(49, dbodntusers.getSalt());
		dbc.setString(50, dbodntusers.getSalt2());
		dbc.setString(51, dbodntusers.getCarnumber());
		dbc.setInt(52, dbodntusers.getGuid());
		dbc.setTimestamp(53, new Timestamp(dbodntusers.getBuydate().getTime()));
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDntUsers dbodntusers) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dnt_users set ");
		boolean flag = false;
		if(dbodntusers.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",uid=?");
			}else{
				sb.append("uid=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",username=?");
			}else{
				sb.append("username=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",nickname=?");
			}else{
				sb.append("nickname=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",password=?");
			}else{
				sb.append("password=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",secques=?");
			}else{
				sb.append("secques=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",spaceid=?");
			}else{
				sb.append("spaceid=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",gender=?");
			}else{
				sb.append("gender=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",adminid=?");
			}else{
				sb.append("adminid=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",groupid=?");
			}else{
				sb.append("groupid=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",groupexpiry=?");
			}else{
				sb.append("groupexpiry=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",extgroupids=?");
			}else{
				sb.append("extgroupids=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",regip=?");
			}else{
				sb.append("regip=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",joindate=?");
			}else{
				sb.append("joindate=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",lastip=?");
			}else{
				sb.append("lastip=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",lastvisit=?");
			}else{
				sb.append("lastvisit=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",lastactivity=?");
			}else{
				sb.append("lastactivity=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",lastpost=?");
			}else{
				sb.append("lastpost=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",lastpostid=?");
			}else{
				sb.append("lastpostid=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[18]){
			if(flag){
				sb.append(",lastposttitle=?");
			}else{
				sb.append("lastposttitle=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[19]){
			if(flag){
				sb.append(",posts=?");
			}else{
				sb.append("posts=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[20]){
			if(flag){
				sb.append(",digestposts=?");
			}else{
				sb.append("digestposts=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[21]){
			if(flag){
				sb.append(",oltime=?");
			}else{
				sb.append("oltime=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[22]){
			if(flag){
				sb.append(",pageviews=?");
			}else{
				sb.append("pageviews=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[23]){
			if(flag){
				sb.append(",credits=?");
			}else{
				sb.append("credits=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[24]){
			if(flag){
				sb.append(",extcredits1=?");
			}else{
				sb.append("extcredits1=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[25]){
			if(flag){
				sb.append(",extcredits2=?");
			}else{
				sb.append("extcredits2=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[26]){
			if(flag){
				sb.append(",extcredits3=?");
			}else{
				sb.append("extcredits3=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[27]){
			if(flag){
				sb.append(",extcredits4=?");
			}else{
				sb.append("extcredits4=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[28]){
			if(flag){
				sb.append(",extcredits5=?");
			}else{
				sb.append("extcredits5=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[29]){
			if(flag){
				sb.append(",extcredits6=?");
			}else{
				sb.append("extcredits6=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[30]){
			if(flag){
				sb.append(",extcredits7=?");
			}else{
				sb.append("extcredits7=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[31]){
			if(flag){
				sb.append(",extcredits8=?");
			}else{
				sb.append("extcredits8=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[32]){
			if(flag){
				sb.append(",avatarshowid=?");
			}else{
				sb.append("avatarshowid=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[33]){
			if(flag){
				sb.append(",email=?");
			}else{
				sb.append("email=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[34]){
			if(flag){
				sb.append(",bday=?");
			}else{
				sb.append("bday=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[35]){
			if(flag){
				sb.append(",sigstatus=?");
			}else{
				sb.append("sigstatus=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[36]){
			if(flag){
				sb.append(",tpp=?");
			}else{
				sb.append("tpp=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[37]){
			if(flag){
				sb.append(",ppp=?");
			}else{
				sb.append("ppp=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[38]){
			if(flag){
				sb.append(",templateid=?");
			}else{
				sb.append("templateid=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[39]){
			if(flag){
				sb.append(",pmsound=?");
			}else{
				sb.append("pmsound=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[40]){
			if(flag){
				sb.append(",showemail=?");
			}else{
				sb.append("showemail=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[41]){
			if(flag){
				sb.append(",newsletter=?");
			}else{
				sb.append("newsletter=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[42]){
			if(flag){
				sb.append(",invisible=?");
			}else{
				sb.append("invisible=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[43]){
			if(flag){
				sb.append(",newpm=?");
			}else{
				sb.append("newpm=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[44]){
			if(flag){
				sb.append(",newpmcount=?");
			}else{
				sb.append("newpmcount=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[45]){
			if(flag){
				sb.append(",accessmasks=?");
			}else{
				sb.append("accessmasks=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[46]){
			if(flag){
				sb.append(",onlinestate=?");
			}else{
				sb.append("onlinestate=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[47]){
			if(flag){
				sb.append(",pass=?");
			}else{
				sb.append("pass=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[48]){
			if(flag){
				sb.append(",salt=?");
			}else{
				sb.append("salt=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[49]){
			if(flag){
				sb.append(",salt2=?");
			}else{
				sb.append("salt2=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[50]){
			if(flag){
				sb.append(",carnumber=?");
			}else{
				sb.append("carnumber=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[51]){
			if(flag){
				sb.append(",guid=?");
			}else{
				sb.append("guid=?");
				flag=true;
			}
		}
		if(dbodntusers.COLUMN_FLAG[52]){
			if(flag){
				sb.append(",buydate=?");
			}else{
				sb.append("buydate=?");
				flag=true;
			}
		}
		sb.append(" where uid=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodntusers.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodntusers.getUid());k++;
		}
		if(dbodntusers.COLUMN_FLAG[1]){
			dbc.setString(k, dbodntusers.getUsername());k++;
		}
		if(dbodntusers.COLUMN_FLAG[2]){
			dbc.setString(k, dbodntusers.getNickname());k++;
		}
		if(dbodntusers.COLUMN_FLAG[3]){
			dbc.setString(k, dbodntusers.getPassword());k++;
		}
		if(dbodntusers.COLUMN_FLAG[4]){
			dbc.setString(k, dbodntusers.getSecques());k++;
		}
		if(dbodntusers.COLUMN_FLAG[5]){
			dbc.setInt(k, dbodntusers.getSpaceid());k++;
		}
		if(dbodntusers.COLUMN_FLAG[6]){
			dbc.setInt(k, dbodntusers.getGender());k++;
		}
		if(dbodntusers.COLUMN_FLAG[7]){
			dbc.setInt(k, dbodntusers.getAdminid());k++;
		}
		if(dbodntusers.COLUMN_FLAG[8]){
			dbc.setInt(k, dbodntusers.getGroupid());k++;
		}
		if(dbodntusers.COLUMN_FLAG[9]){
			dbc.setInt(k, dbodntusers.getGroupexpiry());k++;
		}
		if(dbodntusers.COLUMN_FLAG[10]){
			dbc.setString(k, dbodntusers.getExtgroupids());k++;
		}
		if(dbodntusers.COLUMN_FLAG[11]){
			dbc.setString(k, dbodntusers.getRegip());k++;
		}
		if(dbodntusers.COLUMN_FLAG[12]){
			dbc.setTimestamp(k, new Timestamp(dbodntusers.getJoindate().getTime()));k++;
		}
		if(dbodntusers.COLUMN_FLAG[13]){
			dbc.setString(k, dbodntusers.getLastip());k++;
		}
		if(dbodntusers.COLUMN_FLAG[14]){
			dbc.setTimestamp(k, new Timestamp(dbodntusers.getLastvisit().getTime()));k++;
		}
		if(dbodntusers.COLUMN_FLAG[15]){
			dbc.setTimestamp(k, new Timestamp(dbodntusers.getLastactivity().getTime()));k++;
		}
		if(dbodntusers.COLUMN_FLAG[16]){
			dbc.setTimestamp(k, new Timestamp(dbodntusers.getLastpost().getTime()));k++;
		}
		if(dbodntusers.COLUMN_FLAG[17]){
			dbc.setInt(k, dbodntusers.getLastpostid());k++;
		}
		if(dbodntusers.COLUMN_FLAG[18]){
			dbc.setString(k, dbodntusers.getLastposttitle());k++;
		}
		if(dbodntusers.COLUMN_FLAG[19]){
			dbc.setInt(k, dbodntusers.getPosts());k++;
		}
		if(dbodntusers.COLUMN_FLAG[20]){
			dbc.setInt(k, dbodntusers.getDigestposts());k++;
		}
		if(dbodntusers.COLUMN_FLAG[21]){
			dbc.setInt(k, dbodntusers.getOltime());k++;
		}
		if(dbodntusers.COLUMN_FLAG[22]){
			dbc.setInt(k, dbodntusers.getPageviews());k++;
		}
		if(dbodntusers.COLUMN_FLAG[23]){
			dbc.setDouble(k, dbodntusers.getCredits());k++;
		}
		if(dbodntusers.COLUMN_FLAG[24]){
			dbc.setDouble(k, dbodntusers.getExtcredits1());k++;
		}
		if(dbodntusers.COLUMN_FLAG[25]){
			dbc.setDouble(k, dbodntusers.getExtcredits2());k++;
		}
		if(dbodntusers.COLUMN_FLAG[26]){
			dbc.setDouble(k, dbodntusers.getExtcredits3());k++;
		}
		if(dbodntusers.COLUMN_FLAG[27]){
			dbc.setDouble(k, dbodntusers.getExtcredits4());k++;
		}
		if(dbodntusers.COLUMN_FLAG[28]){
			dbc.setDouble(k, dbodntusers.getExtcredits5());k++;
		}
		if(dbodntusers.COLUMN_FLAG[29]){
			dbc.setDouble(k, dbodntusers.getExtcredits6());k++;
		}
		if(dbodntusers.COLUMN_FLAG[30]){
			dbc.setDouble(k, dbodntusers.getExtcredits7());k++;
		}
		if(dbodntusers.COLUMN_FLAG[31]){
			dbc.setDouble(k, dbodntusers.getExtcredits8());k++;
		}
		if(dbodntusers.COLUMN_FLAG[32]){
			dbc.setInt(k, dbodntusers.getAvatarshowid());k++;
		}
		if(dbodntusers.COLUMN_FLAG[33]){
			dbc.setString(k, dbodntusers.getEmail());k++;
		}
		if(dbodntusers.COLUMN_FLAG[34]){
			dbc.setString(k, dbodntusers.getBday());k++;
		}
		if(dbodntusers.COLUMN_FLAG[35]){
			dbc.setInt(k, dbodntusers.getSigstatus());k++;
		}
		if(dbodntusers.COLUMN_FLAG[36]){
			dbc.setInt(k, dbodntusers.getTpp());k++;
		}
		if(dbodntusers.COLUMN_FLAG[37]){
			dbc.setInt(k, dbodntusers.getPpp());k++;
		}
		if(dbodntusers.COLUMN_FLAG[38]){
			dbc.setInt(k, dbodntusers.getTemplateid());k++;
		}
		if(dbodntusers.COLUMN_FLAG[39]){
			dbc.setInt(k, dbodntusers.getPmsound());k++;
		}
		if(dbodntusers.COLUMN_FLAG[40]){
			dbc.setInt(k, dbodntusers.getShowemail());k++;
		}
		if(dbodntusers.COLUMN_FLAG[41]){
			dbc.setInt(k, dbodntusers.getNewsletter());k++;
		}
		if(dbodntusers.COLUMN_FLAG[42]){
			dbc.setInt(k, dbodntusers.getInvisible());k++;
		}
		if(dbodntusers.COLUMN_FLAG[43]){
			dbc.setInt(k, dbodntusers.getNewpm());k++;
		}
		if(dbodntusers.COLUMN_FLAG[44]){
			dbc.setInt(k, dbodntusers.getNewpmcount());k++;
		}
		if(dbodntusers.COLUMN_FLAG[45]){
			dbc.setInt(k, dbodntusers.getAccessmasks());k++;
		}
		if(dbodntusers.COLUMN_FLAG[46]){
			dbc.setInt(k, dbodntusers.getOnlinestate());k++;
		}
		if(dbodntusers.COLUMN_FLAG[47]){
			dbc.setString(k, dbodntusers.getPass());k++;
		}
		if(dbodntusers.COLUMN_FLAG[48]){
			dbc.setString(k, dbodntusers.getSalt());k++;
		}
		if(dbodntusers.COLUMN_FLAG[49]){
			dbc.setString(k, dbodntusers.getSalt2());k++;
		}
		if(dbodntusers.COLUMN_FLAG[50]){
			dbc.setString(k, dbodntusers.getCarnumber());k++;
		}
		if(dbodntusers.COLUMN_FLAG[51]){
			dbc.setInt(k, dbodntusers.getGuid());k++;
		}
		if(dbodntusers.COLUMN_FLAG[52]){
			dbc.setTimestamp(k, new Timestamp(dbodntusers.getBuydate().getTime()));k++;
		}
		dbc.setInt(k, dbodntusers.getUid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDntUsers dbodntusers) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodntusers);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static List<DboDntUsers> DboDntUsersSelectAllColumn(){
		DBConnect dbc = null;
		String sql = "select * from dbo_dnt_users";
		List<DboDntUsers> list = new ArrayList<DboDntUsers>();
	
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDntUsers obj = new DboDntUsers();
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

	public static List<DboDntUsers> DboDntUsersSelectAllColumnByusername(String username){
		DBConnect dbc = null;
		String sql = "select * from dbo_dnt_users where username=?";
		List<DboDntUsers> list = new ArrayList<DboDntUsers>();
	
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, username);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDntUsers obj = new DboDntUsers();
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