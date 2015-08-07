package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaDealers;

public class  DboDeaDealersDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaDealers dbodeadealers) throws SQLException {
		dbodeadealers.setEid(rs.getInt("eid"));//企业id
		dbodeadealers.setPaylevel(rs.getInt("paylevel"));//企业级别  0一般 4试用 5正式
		dbodeadealers.setAreaid(rs.getInt("areaid"));//所在地区
		dbodeadealers.setModelid(rs.getInt("modelid"));//使用模板id
		dbodeadealers.setShortename(rs.getString("shortename"));//企业简称
		dbodeadealers.setMainbrand(rs.getString("mainbrand"));//主营品牌
		dbodeadealers.setUsername(rs.getString("username"));//登录账号
		dbodeadealers.setEname(rs.getString("ename"));//企业名称
		dbodeadealers.setDomain(rs.getString("domain"));//个性域名
		dbodeadealers.setIndexhotnewssetting(rs.getInt("indexhotnewssetting"));//首页热点新闻设置，0--自动选取最新新闻，1--手动选取
		dbodeadealers.setIsdelete(rs.getInt("isdelete"));//删除标识
		dbodeadealers.setAdddate(rs.getTimestamp("adddate"));//
		dbodeadealers.setAreaids(rs.getString("areaids"));//
		dbodeadealers.setTelephone(rs.getString("telephone"));//
		dbodeadealers.setExpirationdate(rs.getTimestamp("expirationdate"));//
		dbodeadealers.setIsbitauto(rs.getInt("isbitauto"));//
		dbodeadealers.setIs4s(rs.getInt("is4s"));//
		dbodeadealers.setIsbitautoprice(rs.getInt("isbitautoprice"));//
		dbodeadealers.setSeposttableid(rs.getInt("seposttableid"));//
		dbodeadealers.setAddress(rs.getString("address"));//
		dbodeadealers.setAddbbs(rs.getInt("addbbs"));//
		dbodeadealers.setMaxpushid(rs.getInt("maxpushid"));//
		dbodeadealers.setPushdate(rs.getTimestamp("pushdate"));//
		dbodeadealers.setBmbasiccount(rs.getInt("bmbasiccount"));//
		dbodeadealers.setIway(rs.getString("iway"));//
		dbodeadealers.setIssenior(rs.getInt("issenior"));// 默认为0，不为空
		dbodeadealers.setRemarks(rs.getString("remarks"));//
		dbodeadealers.setIsvip(rs.getInt("isvip"));//是否vip经销商1：是，0：不是（默认0）
		dbodeadealers.setJinbi(rs.getInt("jinbi"));//金币（也可以理解是积分）
		dbodeadealers.setIsfinishinfo(rs.getInt("isfinishinfo"));//是否100%完善信息
		dbodeadealers.setIsfirstbindmobile(rs.getInt("isfirstbindmobile"));//是否首次成功绑定手机号
		dbodeadealers.setLastlogintime(rs.getTimestamp("lastlogintime"));//最后一次登录时间 (用于对以下规则的判断：vip会员每天第一次登陆后台，奖励金币2)
		dbodeadealers.setIstmp(rs.getInt("istmp"));//0不是临时1临时用户
		dbodeadealers.setIshaotuban(rs.getInt("ishaotuban"));//是否是好途邦
		dbodeadealers.setIssupervip(rs.getInt("issupervip"));//是否是超级vip
	}

	public static List<DboDeaDealers> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_dealers";
		List<DboDeaDealers> list = new ArrayList<DboDeaDealers>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaDealers dbodeadealers = new DboDeaDealers();
				fill(rs, dbodeadealers);
				list.add(dbodeadealers);
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


	public static List<DboDeaDealers> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_dealers where "+subsql+"";
		List<DboDeaDealers> list = new ArrayList<DboDeaDealers>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaDealers dbodeadealers = new DboDeaDealers();
				fill(rs, dbodeadealers);
				list.add(dbodeadealers);
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
		String sql = "select count(*) from dbo_dea_dealers where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_dealers where "+subsql+"";
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
		String sql = "delete from dbo_dea_dealers where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaDealers dbodeadealers) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_dealers(`eid`,`paylevel`,`areaid`,`modelid`,`shortename`,`mainbrand`,`username`,`ename`,`domain`,`indexhotnewssetting`,`isdelete`,`adddate`,`areaids`,`telephone`,`expirationdate`,`isbitauto`,`is4s`,`isbitautoprice`,`seposttableid`,`address`,`addbbs`,`maxpushid`,`pushdate`,`bmbasiccount`,`iway`,`issenior`,`remarks`,`isvip`,`jinbi`,`isfinishinfo`,`isfirstbindmobile`,`lastlogintime`,`istmp`,`ishaotuban`,`issupervip`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeadealers.getEid());
		dbc.setInt(2, dbodeadealers.getPaylevel());
		dbc.setInt(3, dbodeadealers.getAreaid());
		dbc.setInt(4, dbodeadealers.getModelid());
		dbc.setString(5, dbodeadealers.getShortename());
		dbc.setString(6, dbodeadealers.getMainbrand());
		dbc.setString(7, dbodeadealers.getUsername());
		dbc.setString(8, dbodeadealers.getEname());
		dbc.setString(9, dbodeadealers.getDomain());
		dbc.setInt(10, dbodeadealers.getIndexhotnewssetting());
		dbc.setInt(11, dbodeadealers.getIsdelete());
		dbc.setTimestamp(12, new Timestamp(dbodeadealers.getAdddate().getTime()));
		dbc.setString(13, dbodeadealers.getAreaids());
		dbc.setString(14, dbodeadealers.getTelephone());
		dbc.setTimestamp(15, new Timestamp(dbodeadealers.getExpirationdate().getTime()));
		dbc.setInt(16, dbodeadealers.getIsbitauto());
		dbc.setInt(17, dbodeadealers.getIs4s());
		dbc.setInt(18, dbodeadealers.getIsbitautoprice());
		dbc.setInt(19, dbodeadealers.getSeposttableid());
		dbc.setString(20, dbodeadealers.getAddress());
		dbc.setInt(21, dbodeadealers.getAddbbs());
		dbc.setInt(22, dbodeadealers.getMaxpushid());
		dbc.setTimestamp(23, new Timestamp(dbodeadealers.getPushdate().getTime()));
		dbc.setInt(24, dbodeadealers.getBmbasiccount());
		dbc.setString(25, dbodeadealers.getIway());
		dbc.setInt(26, dbodeadealers.getIssenior());
		dbc.setString(27, dbodeadealers.getRemarks());
		dbc.setInt(28, dbodeadealers.getIsvip());
		dbc.setInt(29, dbodeadealers.getJinbi());
		dbc.setInt(30, dbodeadealers.getIsfinishinfo());
		dbc.setInt(31, dbodeadealers.getIsfirstbindmobile());
		dbc.setTimestamp(32, new Timestamp(dbodeadealers.getLastlogintime().getTime()));
		dbc.setInt(33, dbodeadealers.getIstmp());
		dbc.setInt(34, dbodeadealers.getIshaotuban());
		dbc.setInt(35, dbodeadealers.getIssupervip());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaDealers dbodeadealers) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_dealers(`eid`,`paylevel`,`areaid`,`modelid`,`shortename`,`mainbrand`,`username`,`ename`,`domain`,`indexhotnewssetting`,`isdelete`,`adddate`,`areaids`,`telephone`,`expirationdate`,`isbitauto`,`is4s`,`isbitautoprice`,`seposttableid`,`address`,`addbbs`,`maxpushid`,`pushdate`,`bmbasiccount`,`iway`,`issenior`,`remarks`,`isvip`,`jinbi`,`isfinishinfo`,`isfirstbindmobile`,`lastlogintime`,`istmp`,`ishaotuban`,`issupervip`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeadealers.getEid());
		dbc.setInt(2, dbodeadealers.getPaylevel());
		dbc.setInt(3, dbodeadealers.getAreaid());
		dbc.setInt(4, dbodeadealers.getModelid());
		dbc.setString(5, dbodeadealers.getShortename());
		dbc.setString(6, dbodeadealers.getMainbrand());
		dbc.setString(7, dbodeadealers.getUsername());
		dbc.setString(8, dbodeadealers.getEname());
		dbc.setString(9, dbodeadealers.getDomain());
		dbc.setInt(10, dbodeadealers.getIndexhotnewssetting());
		dbc.setInt(11, dbodeadealers.getIsdelete());
		dbc.setTimestamp(12, new Timestamp(dbodeadealers.getAdddate().getTime()));
		dbc.setString(13, dbodeadealers.getAreaids());
		dbc.setString(14, dbodeadealers.getTelephone());
		dbc.setTimestamp(15, new Timestamp(dbodeadealers.getExpirationdate().getTime()));
		dbc.setInt(16, dbodeadealers.getIsbitauto());
		dbc.setInt(17, dbodeadealers.getIs4s());
		dbc.setInt(18, dbodeadealers.getIsbitautoprice());
		dbc.setInt(19, dbodeadealers.getSeposttableid());
		dbc.setString(20, dbodeadealers.getAddress());
		dbc.setInt(21, dbodeadealers.getAddbbs());
		dbc.setInt(22, dbodeadealers.getMaxpushid());
		dbc.setTimestamp(23, new Timestamp(dbodeadealers.getPushdate().getTime()));
		dbc.setInt(24, dbodeadealers.getBmbasiccount());
		dbc.setString(25, dbodeadealers.getIway());
		dbc.setInt(26, dbodeadealers.getIssenior());
		dbc.setString(27, dbodeadealers.getRemarks());
		dbc.setInt(28, dbodeadealers.getIsvip());
		dbc.setInt(29, dbodeadealers.getJinbi());
		dbc.setInt(30, dbodeadealers.getIsfinishinfo());
		dbc.setInt(31, dbodeadealers.getIsfirstbindmobile());
		dbc.setTimestamp(32, new Timestamp(dbodeadealers.getLastlogintime().getTime()));
		dbc.setInt(33, dbodeadealers.getIstmp());
		dbc.setInt(34, dbodeadealers.getIshaotuban());
		dbc.setInt(35, dbodeadealers.getIssupervip());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaDealers dbodeadealers) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_dealers set ");
		boolean flag = false;
		if(dbodeadealers.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",eid=?");
			}else{
				sb.append("eid=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",paylevel=?");
			}else{
				sb.append("paylevel=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",areaid=?");
			}else{
				sb.append("areaid=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",modelid=?");
			}else{
				sb.append("modelid=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",shortename=?");
			}else{
				sb.append("shortename=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",mainbrand=?");
			}else{
				sb.append("mainbrand=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",username=?");
			}else{
				sb.append("username=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",ename=?");
			}else{
				sb.append("ename=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",domain=?");
			}else{
				sb.append("domain=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",indexhotnewssetting=?");
			}else{
				sb.append("indexhotnewssetting=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",areaids=?");
			}else{
				sb.append("areaids=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",telephone=?");
			}else{
				sb.append("telephone=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",expirationdate=?");
			}else{
				sb.append("expirationdate=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",isbitauto=?");
			}else{
				sb.append("isbitauto=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",is4s=?");
			}else{
				sb.append("is4s=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",isbitautoprice=?");
			}else{
				sb.append("isbitautoprice=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[18]){
			if(flag){
				sb.append(",seposttableid=?");
			}else{
				sb.append("seposttableid=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[19]){
			if(flag){
				sb.append(",address=?");
			}else{
				sb.append("address=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[20]){
			if(flag){
				sb.append(",addbbs=?");
			}else{
				sb.append("addbbs=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[21]){
			if(flag){
				sb.append(",maxpushid=?");
			}else{
				sb.append("maxpushid=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[22]){
			if(flag){
				sb.append(",pushdate=?");
			}else{
				sb.append("pushdate=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[23]){
			if(flag){
				sb.append(",bmbasiccount=?");
			}else{
				sb.append("bmbasiccount=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[24]){
			if(flag){
				sb.append(",iway=?");
			}else{
				sb.append("iway=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[25]){
			if(flag){
				sb.append(",issenior=?");
			}else{
				sb.append("issenior=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[26]){
			if(flag){
				sb.append(",remarks=?");
			}else{
				sb.append("remarks=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[27]){
			if(flag){
				sb.append(",isvip=?");
			}else{
				sb.append("isvip=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[28]){
			if(flag){
				sb.append(",jinbi=?");
			}else{
				sb.append("jinbi=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[29]){
			if(flag){
				sb.append(",isfinishinfo=?");
			}else{
				sb.append("isfinishinfo=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[30]){
			if(flag){
				sb.append(",isfirstbindmobile=?");
			}else{
				sb.append("isfirstbindmobile=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[31]){
			if(flag){
				sb.append(",lastlogintime=?");
			}else{
				sb.append("lastlogintime=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[32]){
			if(flag){
				sb.append(",istmp=?");
			}else{
				sb.append("istmp=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[33]){
			if(flag){
				sb.append(",ishaotuban=?");
			}else{
				sb.append("ishaotuban=?");
				flag=true;
			}
		}
		if(dbodeadealers.COLUMN_FLAG[34]){
			if(flag){
				sb.append(",issupervip=?");
			}else{
				sb.append("issupervip=?");
				flag=true;
			}
		}
		sb.append(" where eid=?");
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeadealers.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeadealers.getEid());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[1]){
			dbc.setInt(k, dbodeadealers.getPaylevel());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[2]){
			dbc.setInt(k, dbodeadealers.getAreaid());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[3]){
			dbc.setInt(k, dbodeadealers.getModelid());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[4]){
			dbc.setString(k, dbodeadealers.getShortename());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[5]){
			dbc.setString(k, dbodeadealers.getMainbrand());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[6]){
			dbc.setString(k, dbodeadealers.getUsername());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[7]){
			dbc.setString(k, dbodeadealers.getEname());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[8]){
			dbc.setString(k, dbodeadealers.getDomain());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[9]){
			dbc.setInt(k, dbodeadealers.getIndexhotnewssetting());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[10]){
			dbc.setInt(k, dbodeadealers.getIsdelete());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[11]){
			dbc.setTimestamp(k, new Timestamp(dbodeadealers.getAdddate().getTime()));k++;
		}
		if(dbodeadealers.COLUMN_FLAG[12]){
			dbc.setString(k, dbodeadealers.getAreaids());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[13]){
			dbc.setString(k, dbodeadealers.getTelephone());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[14]){
			dbc.setTimestamp(k, new Timestamp(dbodeadealers.getExpirationdate().getTime()));k++;
		}
		if(dbodeadealers.COLUMN_FLAG[15]){
			dbc.setInt(k, dbodeadealers.getIsbitauto());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[16]){
			dbc.setInt(k, dbodeadealers.getIs4s());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[17]){
			dbc.setInt(k, dbodeadealers.getIsbitautoprice());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[18]){
			dbc.setInt(k, dbodeadealers.getSeposttableid());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[19]){
			dbc.setString(k, dbodeadealers.getAddress());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[20]){
			dbc.setInt(k, dbodeadealers.getAddbbs());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[21]){
			dbc.setInt(k, dbodeadealers.getMaxpushid());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[22]){
			dbc.setTimestamp(k, new Timestamp(dbodeadealers.getPushdate().getTime()));k++;
		}
		if(dbodeadealers.COLUMN_FLAG[23]){
			dbc.setInt(k, dbodeadealers.getBmbasiccount());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[24]){
			dbc.setString(k, dbodeadealers.getIway());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[25]){
			dbc.setInt(k, dbodeadealers.getIssenior());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[26]){
			dbc.setString(k, dbodeadealers.getRemarks());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[27]){
			dbc.setInt(k, dbodeadealers.getIsvip());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[28]){
			dbc.setInt(k, dbodeadealers.getJinbi());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[29]){
			dbc.setInt(k, dbodeadealers.getIsfinishinfo());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[30]){
			dbc.setInt(k, dbodeadealers.getIsfirstbindmobile());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[31]){
			dbc.setTimestamp(k, new Timestamp(dbodeadealers.getLastlogintime().getTime()));k++;
		}
		if(dbodeadealers.COLUMN_FLAG[32]){
			dbc.setInt(k, dbodeadealers.getIstmp());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[33]){
			dbc.setInt(k, dbodeadealers.getIshaotuban());k++;
		}
		if(dbodeadealers.COLUMN_FLAG[34]){
			dbc.setInt(k, dbodeadealers.getIssupervip());k++;
		}
		dbc.setInt(k, dbodeadealers.getEid());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaDealers dbodeadealers) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeadealers);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static int DboDeaDealersUpdateByeid(String telephone,int eid){
	int result=EXECUTE_FAIL;
	DBConnect dbc = null;
	String sql = "update dbo_dea_dealers set telephone = ? where eid = ?";

	try {
		dbc = new DBConnect(sql);
		dbc.setString(1, telephone);
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

	public static int DboDeaDealersUpdateByeid(DBConnect dbc,String telephone,int eid){
	int result=EXECUTE_FAIL;
	String sql = "update dbo_dea_dealers set telephone = ? where eid = ?";

	try {
		dbc.prepareStatement(sql);
		dbc.setString(1, telephone);
		dbc.setInt(2, eid);
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
	}

	public static List<DboDeaDealers> DboDeaDealersSelectAllColumnByusername(String username){
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_dealers where username=?";
		List<DboDeaDealers> list = new ArrayList<DboDeaDealers>();
	
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, username);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaDealers obj = new DboDeaDealers();
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