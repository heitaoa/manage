package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboNewNews;

public class  DboNewNewsDao  extends BaseDao {

	public static void fill(ResultSet rs, DboNewNews dbonewnews) throws SQLException {
		dbonewnews.setId(rs.getInt("id"));//自动增长id
		dbonewnews.setNewscatalogid(rs.getInt("newscatalogid"));//新闻分类
		dbonewnews.setAreaid(rs.getInt("areaid"));//地域分类id
		dbonewnews.setCarcatalogid(rs.getInt("carcatalogid"));//车型分类id
		dbonewnews.setNewstitle(rs.getString("newstitle"));//标题
		dbonewnews.setNewskeywords(rs.getString("newskeywords"));//关键字
		dbonewnews.setTitlephoto(rs.getString("titlephoto"));//图片
		dbonewnews.setNewseditor(rs.getString("newseditor"));//作者和出处信息
		dbonewnews.setAddadmin(rs.getString("addadmin"));//添加操作管理员用户名
		dbonewnews.setUpdateadmin(rs.getString("updateadmin"));//修改操作管理员用户名
		dbonewnews.setDeladmin(rs.getString("deladmin"));//删除操作管理员用户名
		dbonewnews.setTotop(rs.getInt("totop"));//被顶的次数
		dbonewnews.setTosink(rs.getInt("tosink"));//被踩的次数
		dbonewnews.setGradeid1(rs.getInt("gradeid1"));//扩展列1 (是否是第一次发布)
		dbonewnews.setGradeid2(rs.getInt("gradeid2"));//扩展列2
		dbonewnews.setGradeid3(rs.getInt("gradeid3"));//扩展列3
		dbonewnews.setGradeid4(rs.getInt("gradeid4"));//扩展列4
		dbonewnews.setGradeid5(rs.getInt("gradeid5"));//扩展列5
		dbonewnews.setAdddate(rs.getTimestamp("adddate"));//添加时间
		dbonewnews.setLastupdate(rs.getTimestamp("lastupdate"));//最后更新时间
		dbonewnews.setIsdelete(rs.getInt("isdelete"));//0正常
		dbonewnews.setSortid(rs.getInt("sortid"));//
		dbonewnews.setIsphoto(rs.getInt("isphoto"));//
		dbonewnews.setDescription(rs.getString("description"));//
		dbonewnews.setIsoriginal(rs.getInt("isoriginal"));//
		dbonewnews.setToptime(rs.getTimestamp("toptime"));//
		dbonewnews.setSinktime(rs.getTimestamp("sinktime"));//
		dbonewnews.setRelink(rs.getString("relink"));//
		dbonewnews.setIsimgnews(rs.getInt("isimgnews"));//
		dbonewnews.setPricedown(rs.getInt("pricedown"));//
		dbonewnews.setCarslevel(rs.getString("carslevel"));//
		dbonewnews.setSerialid(rs.getInt("serialid"));//
		dbonewnews.setShorttitle(rs.getString("shorttitle"));//
		dbonewnews.setChktitlephoto(rs.getInt("chktitlephoto"));//
		dbonewnews.setChkdescription(rs.getInt("chkdescription"));//
		dbonewnews.setIslook(rs.getInt("islook"));//
		dbonewnews.setIsmultpagelink(rs.getInt("ismultpagelink"));//是否显示分页链接;0|不显示分页链接；1|显示分页链接；
		dbonewnews.setIswap(rs.getInt("iswap"));//是否需要生成wap版
		dbonewnews.setOld_carcatalogid(rs.getInt("old_carcatalogid"));//老315车型数据
		dbonewnews.setSavedate(rs.getTimestamp("savedate"));//文章第一次保存时间
	}

	public static List<DboNewNews> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_new_news";
		List<DboNewNews> list = new ArrayList<DboNewNews>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboNewNews dbonewnews = new DboNewNews();
				fill(rs, dbonewnews);
				list.add(dbonewnews);
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


	public static List<DboNewNews> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_new_news where "+subsql+"";
		List<DboNewNews> list = new ArrayList<DboNewNews>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboNewNews dbonewnews = new DboNewNews();
				fill(rs, dbonewnews);
				list.add(dbonewnews);
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
		String sql = "select count(*) from dbo_new_news where "+subsql+"";
		
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
		String sql = "delete from dbo_new_news where "+subsql+"";
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
		String sql = "delete from dbo_new_news where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboNewNews dbonewnews) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_new_news(`id`,`newscatalogid`,`areaid`,`carcatalogid`,`newstitle`,`newskeywords`,`titlephoto`,`newseditor`,`addadmin`,`updateadmin`,`deladmin`,`totop`,`tosink`,`gradeid1`,`gradeid2`,`gradeid3`,`gradeid4`,`gradeid5`,`adddate`,`lastupdate`,`isdelete`,`sortid`,`isphoto`,`description`,`isoriginal`,`toptime`,`sinktime`,`relink`,`isimgnews`,`pricedown`,`carslevel`,`serialid`,`shorttitle`,`chktitlephoto`,`chkdescription`,`islook`,`ismultpagelink`,`iswap`,`old_carcatalogid`,`savedate`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbonewnews.getId());
		dbc.setInt(2, dbonewnews.getNewscatalogid());
		dbc.setInt(3, dbonewnews.getAreaid());
		dbc.setInt(4, dbonewnews.getCarcatalogid());
		dbc.setString(5, dbonewnews.getNewstitle());
		dbc.setString(6, dbonewnews.getNewskeywords());
		dbc.setString(7, dbonewnews.getTitlephoto());
		dbc.setString(8, dbonewnews.getNewseditor());
		dbc.setString(9, dbonewnews.getAddadmin());
		dbc.setString(10, dbonewnews.getUpdateadmin());
		dbc.setString(11, dbonewnews.getDeladmin());
		dbc.setInt(12, dbonewnews.getTotop());
		dbc.setInt(13, dbonewnews.getTosink());
		dbc.setInt(14, dbonewnews.getGradeid1());
		dbc.setInt(15, dbonewnews.getGradeid2());
		dbc.setInt(16, dbonewnews.getGradeid3());
		dbc.setInt(17, dbonewnews.getGradeid4());
		dbc.setInt(18, dbonewnews.getGradeid5());
		dbc.setTimestamp(19, new Timestamp(dbonewnews.getAdddate().getTime()));
		dbc.setTimestamp(20, new Timestamp(dbonewnews.getLastupdate().getTime()));
		dbc.setInt(21, dbonewnews.getIsdelete());
		dbc.setInt(22, dbonewnews.getSortid());
		dbc.setInt(23, dbonewnews.getIsphoto());
		dbc.setString(24, dbonewnews.getDescription());
		dbc.setInt(25, dbonewnews.getIsoriginal());
		dbc.setTimestamp(26, new Timestamp(dbonewnews.getToptime().getTime()));
		dbc.setTimestamp(27, new Timestamp(dbonewnews.getSinktime().getTime()));
		dbc.setString(28, dbonewnews.getRelink());
		dbc.setInt(29, dbonewnews.getIsimgnews());
		dbc.setInt(30, dbonewnews.getPricedown());
		dbc.setString(31, dbonewnews.getCarslevel());
		dbc.setInt(32, dbonewnews.getSerialid());
		dbc.setString(33, dbonewnews.getShorttitle());
		dbc.setInt(34, dbonewnews.getChktitlephoto());
		dbc.setInt(35, dbonewnews.getChkdescription());
		dbc.setInt(36, dbonewnews.getIslook());
		dbc.setInt(37, dbonewnews.getIsmultpagelink());
		dbc.setInt(38, dbonewnews.getIswap());
		dbc.setInt(39, dbonewnews.getOld_carcatalogid());
		dbc.setTimestamp(40, new Timestamp(dbonewnews.getSavedate().getTime()));
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboNewNews dbonewnews) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_new_news(`id`,`newscatalogid`,`areaid`,`carcatalogid`,`newstitle`,`newskeywords`,`titlephoto`,`newseditor`,`addadmin`,`updateadmin`,`deladmin`,`totop`,`tosink`,`gradeid1`,`gradeid2`,`gradeid3`,`gradeid4`,`gradeid5`,`adddate`,`lastupdate`,`isdelete`,`sortid`,`isphoto`,`description`,`isoriginal`,`toptime`,`sinktime`,`relink`,`isimgnews`,`pricedown`,`carslevel`,`serialid`,`shorttitle`,`chktitlephoto`,`chkdescription`,`islook`,`ismultpagelink`,`iswap`,`old_carcatalogid`,`savedate`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbonewnews.getId());
		dbc.setInt(2, dbonewnews.getNewscatalogid());
		dbc.setInt(3, dbonewnews.getAreaid());
		dbc.setInt(4, dbonewnews.getCarcatalogid());
		dbc.setString(5, dbonewnews.getNewstitle());
		dbc.setString(6, dbonewnews.getNewskeywords());
		dbc.setString(7, dbonewnews.getTitlephoto());
		dbc.setString(8, dbonewnews.getNewseditor());
		dbc.setString(9, dbonewnews.getAddadmin());
		dbc.setString(10, dbonewnews.getUpdateadmin());
		dbc.setString(11, dbonewnews.getDeladmin());
		dbc.setInt(12, dbonewnews.getTotop());
		dbc.setInt(13, dbonewnews.getTosink());
		dbc.setInt(14, dbonewnews.getGradeid1());
		dbc.setInt(15, dbonewnews.getGradeid2());
		dbc.setInt(16, dbonewnews.getGradeid3());
		dbc.setInt(17, dbonewnews.getGradeid4());
		dbc.setInt(18, dbonewnews.getGradeid5());
		dbc.setTimestamp(19, new Timestamp(dbonewnews.getAdddate().getTime()));
		dbc.setTimestamp(20, new Timestamp(dbonewnews.getLastupdate().getTime()));
		dbc.setInt(21, dbonewnews.getIsdelete());
		dbc.setInt(22, dbonewnews.getSortid());
		dbc.setInt(23, dbonewnews.getIsphoto());
		dbc.setString(24, dbonewnews.getDescription());
		dbc.setInt(25, dbonewnews.getIsoriginal());
		dbc.setTimestamp(26, new Timestamp(dbonewnews.getToptime().getTime()));
		dbc.setTimestamp(27, new Timestamp(dbonewnews.getSinktime().getTime()));
		dbc.setString(28, dbonewnews.getRelink());
		dbc.setInt(29, dbonewnews.getIsimgnews());
		dbc.setInt(30, dbonewnews.getPricedown());
		dbc.setString(31, dbonewnews.getCarslevel());
		dbc.setInt(32, dbonewnews.getSerialid());
		dbc.setString(33, dbonewnews.getShorttitle());
		dbc.setInt(34, dbonewnews.getChktitlephoto());
		dbc.setInt(35, dbonewnews.getChkdescription());
		dbc.setInt(36, dbonewnews.getIslook());
		dbc.setInt(37, dbonewnews.getIsmultpagelink());
		dbc.setInt(38, dbonewnews.getIswap());
		dbc.setInt(39, dbonewnews.getOld_carcatalogid());
		dbc.setTimestamp(40, new Timestamp(dbonewnews.getSavedate().getTime()));
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboNewNews dbonewnews) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_new_news set ");
		boolean flag = false;
		if(dbonewnews.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",newscatalogid=?");
			}else{
				sb.append("newscatalogid=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",areaid=?");
			}else{
				sb.append("areaid=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",carcatalogid=?");
			}else{
				sb.append("carcatalogid=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",newstitle=?");
			}else{
				sb.append("newstitle=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",newskeywords=?");
			}else{
				sb.append("newskeywords=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",titlephoto=?");
			}else{
				sb.append("titlephoto=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",newseditor=?");
			}else{
				sb.append("newseditor=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",addadmin=?");
			}else{
				sb.append("addadmin=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",updateadmin=?");
			}else{
				sb.append("updateadmin=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",deladmin=?");
			}else{
				sb.append("deladmin=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",totop=?");
			}else{
				sb.append("totop=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",tosink=?");
			}else{
				sb.append("tosink=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",gradeid1=?");
			}else{
				sb.append("gradeid1=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",gradeid2=?");
			}else{
				sb.append("gradeid2=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",gradeid3=?");
			}else{
				sb.append("gradeid3=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",gradeid4=?");
			}else{
				sb.append("gradeid4=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",gradeid5=?");
			}else{
				sb.append("gradeid5=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[18]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[19]){
			if(flag){
				sb.append(",lastupdate=?");
			}else{
				sb.append("lastupdate=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[20]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[21]){
			if(flag){
				sb.append(",sortid=?");
			}else{
				sb.append("sortid=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[22]){
			if(flag){
				sb.append(",isphoto=?");
			}else{
				sb.append("isphoto=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[23]){
			if(flag){
				sb.append(",description=?");
			}else{
				sb.append("description=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[24]){
			if(flag){
				sb.append(",isoriginal=?");
			}else{
				sb.append("isoriginal=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[25]){
			if(flag){
				sb.append(",toptime=?");
			}else{
				sb.append("toptime=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[26]){
			if(flag){
				sb.append(",sinktime=?");
			}else{
				sb.append("sinktime=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[27]){
			if(flag){
				sb.append(",relink=?");
			}else{
				sb.append("relink=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[28]){
			if(flag){
				sb.append(",isimgnews=?");
			}else{
				sb.append("isimgnews=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[29]){
			if(flag){
				sb.append(",pricedown=?");
			}else{
				sb.append("pricedown=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[30]){
			if(flag){
				sb.append(",carslevel=?");
			}else{
				sb.append("carslevel=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[31]){
			if(flag){
				sb.append(",serialid=?");
			}else{
				sb.append("serialid=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[32]){
			if(flag){
				sb.append(",shorttitle=?");
			}else{
				sb.append("shorttitle=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[33]){
			if(flag){
				sb.append(",chktitlephoto=?");
			}else{
				sb.append("chktitlephoto=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[34]){
			if(flag){
				sb.append(",chkdescription=?");
			}else{
				sb.append("chkdescription=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[35]){
			if(flag){
				sb.append(",islook=?");
			}else{
				sb.append("islook=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[36]){
			if(flag){
				sb.append(",ismultpagelink=?");
			}else{
				sb.append("ismultpagelink=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[37]){
			if(flag){
				sb.append(",iswap=?");
			}else{
				sb.append("iswap=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[38]){
			if(flag){
				sb.append(",old_carcatalogid=?");
			}else{
				sb.append("old_carcatalogid=?");
				flag=true;
			}
		}
		if(dbonewnews.COLUMN_FLAG[39]){
			if(flag){
				sb.append(",savedate=?");
			}else{
				sb.append("savedate=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbonewnews.COLUMN_FLAG[0]){
			dbc.setInt(k, dbonewnews.getId());k++;
		}
		if(dbonewnews.COLUMN_FLAG[1]){
			dbc.setInt(k, dbonewnews.getNewscatalogid());k++;
		}
		if(dbonewnews.COLUMN_FLAG[2]){
			dbc.setInt(k, dbonewnews.getAreaid());k++;
		}
		if(dbonewnews.COLUMN_FLAG[3]){
			dbc.setInt(k, dbonewnews.getCarcatalogid());k++;
		}
		if(dbonewnews.COLUMN_FLAG[4]){
			dbc.setString(k, dbonewnews.getNewstitle());k++;
		}
		if(dbonewnews.COLUMN_FLAG[5]){
			dbc.setString(k, dbonewnews.getNewskeywords());k++;
		}
		if(dbonewnews.COLUMN_FLAG[6]){
			dbc.setString(k, dbonewnews.getTitlephoto());k++;
		}
		if(dbonewnews.COLUMN_FLAG[7]){
			dbc.setString(k, dbonewnews.getNewseditor());k++;
		}
		if(dbonewnews.COLUMN_FLAG[8]){
			dbc.setString(k, dbonewnews.getAddadmin());k++;
		}
		if(dbonewnews.COLUMN_FLAG[9]){
			dbc.setString(k, dbonewnews.getUpdateadmin());k++;
		}
		if(dbonewnews.COLUMN_FLAG[10]){
			dbc.setString(k, dbonewnews.getDeladmin());k++;
		}
		if(dbonewnews.COLUMN_FLAG[11]){
			dbc.setInt(k, dbonewnews.getTotop());k++;
		}
		if(dbonewnews.COLUMN_FLAG[12]){
			dbc.setInt(k, dbonewnews.getTosink());k++;
		}
		if(dbonewnews.COLUMN_FLAG[13]){
			dbc.setInt(k, dbonewnews.getGradeid1());k++;
		}
		if(dbonewnews.COLUMN_FLAG[14]){
			dbc.setInt(k, dbonewnews.getGradeid2());k++;
		}
		if(dbonewnews.COLUMN_FLAG[15]){
			dbc.setInt(k, dbonewnews.getGradeid3());k++;
		}
		if(dbonewnews.COLUMN_FLAG[16]){
			dbc.setInt(k, dbonewnews.getGradeid4());k++;
		}
		if(dbonewnews.COLUMN_FLAG[17]){
			dbc.setInt(k, dbonewnews.getGradeid5());k++;
		}
		if(dbonewnews.COLUMN_FLAG[18]){
			dbc.setTimestamp(k, new Timestamp(dbonewnews.getAdddate().getTime()));k++;
		}
		if(dbonewnews.COLUMN_FLAG[19]){
			dbc.setTimestamp(k, new Timestamp(dbonewnews.getLastupdate().getTime()));k++;
		}
		if(dbonewnews.COLUMN_FLAG[20]){
			dbc.setInt(k, dbonewnews.getIsdelete());k++;
		}
		if(dbonewnews.COLUMN_FLAG[21]){
			dbc.setInt(k, dbonewnews.getSortid());k++;
		}
		if(dbonewnews.COLUMN_FLAG[22]){
			dbc.setInt(k, dbonewnews.getIsphoto());k++;
		}
		if(dbonewnews.COLUMN_FLAG[23]){
			dbc.setString(k, dbonewnews.getDescription());k++;
		}
		if(dbonewnews.COLUMN_FLAG[24]){
			dbc.setInt(k, dbonewnews.getIsoriginal());k++;
		}
		if(dbonewnews.COLUMN_FLAG[25]){
			dbc.setTimestamp(k, new Timestamp(dbonewnews.getToptime().getTime()));k++;
		}
		if(dbonewnews.COLUMN_FLAG[26]){
			dbc.setTimestamp(k, new Timestamp(dbonewnews.getSinktime().getTime()));k++;
		}
		if(dbonewnews.COLUMN_FLAG[27]){
			dbc.setString(k, dbonewnews.getRelink());k++;
		}
		if(dbonewnews.COLUMN_FLAG[28]){
			dbc.setInt(k, dbonewnews.getIsimgnews());k++;
		}
		if(dbonewnews.COLUMN_FLAG[29]){
			dbc.setInt(k, dbonewnews.getPricedown());k++;
		}
		if(dbonewnews.COLUMN_FLAG[30]){
			dbc.setString(k, dbonewnews.getCarslevel());k++;
		}
		if(dbonewnews.COLUMN_FLAG[31]){
			dbc.setInt(k, dbonewnews.getSerialid());k++;
		}
		if(dbonewnews.COLUMN_FLAG[32]){
			dbc.setString(k, dbonewnews.getShorttitle());k++;
		}
		if(dbonewnews.COLUMN_FLAG[33]){
			dbc.setInt(k, dbonewnews.getChktitlephoto());k++;
		}
		if(dbonewnews.COLUMN_FLAG[34]){
			dbc.setInt(k, dbonewnews.getChkdescription());k++;
		}
		if(dbonewnews.COLUMN_FLAG[35]){
			dbc.setInt(k, dbonewnews.getIslook());k++;
		}
		if(dbonewnews.COLUMN_FLAG[36]){
			dbc.setInt(k, dbonewnews.getIsmultpagelink());k++;
		}
		if(dbonewnews.COLUMN_FLAG[37]){
			dbc.setInt(k, dbonewnews.getIswap());k++;
		}
		if(dbonewnews.COLUMN_FLAG[38]){
			dbc.setInt(k, dbonewnews.getOld_carcatalogid());k++;
		}
		if(dbonewnews.COLUMN_FLAG[39]){
			dbc.setTimestamp(k, new Timestamp(dbonewnews.getSavedate().getTime()));k++;
		}
		dbc.setInt(k, dbonewnews.getId());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboNewNews dbonewnews) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbonewnews);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}