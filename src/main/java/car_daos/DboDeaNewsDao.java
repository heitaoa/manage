package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaNews;

public class  DboDeaNewsDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaNews dbodeanews) throws SQLException {
		dbodeanews.setNewsid(rs.getInt("newsid"));//新闻自增长id
		dbodeanews.setEid(rs.getInt("eid"));//企业id
		dbodeanews.setTypeid(rs.getInt("typeid"));//新闻分类id23：资讯促销；24：企业新闻等等
		dbodeanews.setViews(rs.getInt("views"));//浏览量
		dbodeanews.setHotsortid(rs.getInt("hotsortid"));//热点新闻排序id
		dbodeanews.setAdddate(rs.getTimestamp("adddate"));//添加日期
		dbodeanews.setPublishdate(rs.getTimestamp("publishdate"));//发布日期
		dbodeanews.setHotdate(rs.getTimestamp("hotdate"));//推荐日期
		dbodeanews.setIsdelete(rs.getInt("isdelete"));//删除标识，0--正常，1--已删除，2--未发布
		dbodeanews.setIshot(rs.getInt("ishot"));//是否推荐
		dbodeanews.setTitle(rs.getString("title"));//新闻标题
		dbodeanews.setNewscontent(rs.getString("newscontent"));//
		dbodeanews.setBbstopicpostid(rs.getInt("bbstopicpostid"));//
	}

	public static List<DboDeaNews> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_news";
		List<DboDeaNews> list = new ArrayList<DboDeaNews>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaNews dbodeanews = new DboDeaNews();
				fill(rs, dbodeanews);
				list.add(dbodeanews);
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


	public static List<DboDeaNews> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_news where "+subsql+"";
		List<DboDeaNews> list = new ArrayList<DboDeaNews>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaNews dbodeanews = new DboDeaNews();
				fill(rs, dbodeanews);
				list.add(dbodeanews);
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
		String sql = "select count(*) from dbo_dea_news where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_news where "+subsql+"";
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
		String sql = "delete from dbo_dea_news where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaNews dbodeanews) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_news(`newsid`,`eid`,`typeid`,`views`,`hotsortid`,`adddate`,`publishdate`,`hotdate`,`isdelete`,`ishot`,`title`,`newscontent`,`bbstopicpostid`) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeanews.getNewsid());
		dbc.setInt(2, dbodeanews.getEid());
		dbc.setInt(3, dbodeanews.getTypeid());
		dbc.setInt(4, dbodeanews.getViews());
		dbc.setInt(5, dbodeanews.getHotsortid());
		dbc.setTimestamp(6, new Timestamp(dbodeanews.getAdddate().getTime()));
		dbc.setTimestamp(7, new Timestamp(dbodeanews.getPublishdate().getTime()));
		dbc.setTimestamp(8, new Timestamp(dbodeanews.getHotdate().getTime()));
		dbc.setInt(9, dbodeanews.getIsdelete());
		dbc.setInt(10, dbodeanews.getIshot());
		dbc.setString(11, dbodeanews.getTitle());
		dbc.setString(12, dbodeanews.getNewscontent());
		dbc.setInt(13, dbodeanews.getBbstopicpostid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaNews dbodeanews) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_news(`newsid`,`eid`,`typeid`,`views`,`hotsortid`,`adddate`,`publishdate`,`hotdate`,`isdelete`,`ishot`,`title`,`newscontent`,`bbstopicpostid`) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeanews.getNewsid());
		dbc.setInt(2, dbodeanews.getEid());
		dbc.setInt(3, dbodeanews.getTypeid());
		dbc.setInt(4, dbodeanews.getViews());
		dbc.setInt(5, dbodeanews.getHotsortid());
		dbc.setTimestamp(6, new Timestamp(dbodeanews.getAdddate().getTime()));
		dbc.setTimestamp(7, new Timestamp(dbodeanews.getPublishdate().getTime()));
		dbc.setTimestamp(8, new Timestamp(dbodeanews.getHotdate().getTime()));
		dbc.setInt(9, dbodeanews.getIsdelete());
		dbc.setInt(10, dbodeanews.getIshot());
		dbc.setString(11, dbodeanews.getTitle());
		dbc.setString(12, dbodeanews.getNewscontent());
		dbc.setInt(13, dbodeanews.getBbstopicpostid());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaNews dbodeanews) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_news set ");
		boolean flag = false;
		if(dbodeanews.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",newsid=?");
			}else{
				sb.append("newsid=?");
				flag=true;
			}
		}
		if(dbodeanews.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",eid=?");
			}else{
				sb.append("eid=?");
				flag=true;
			}
		}
		if(dbodeanews.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",typeid=?");
			}else{
				sb.append("typeid=?");
				flag=true;
			}
		}
		if(dbodeanews.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",views=?");
			}else{
				sb.append("views=?");
				flag=true;
			}
		}
		if(dbodeanews.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",hotsortid=?");
			}else{
				sb.append("hotsortid=?");
				flag=true;
			}
		}
		if(dbodeanews.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbodeanews.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",publishdate=?");
			}else{
				sb.append("publishdate=?");
				flag=true;
			}
		}
		if(dbodeanews.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",hotdate=?");
			}else{
				sb.append("hotdate=?");
				flag=true;
			}
		}
		if(dbodeanews.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dbodeanews.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",ishot=?");
			}else{
				sb.append("ishot=?");
				flag=true;
			}
		}
		if(dbodeanews.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",title=?");
			}else{
				sb.append("title=?");
				flag=true;
			}
		}
		if(dbodeanews.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",newscontent=?");
			}else{
				sb.append("newscontent=?");
				flag=true;
			}
		}
		if(dbodeanews.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",bbstopicpostid=?");
			}else{
				sb.append("bbstopicpostid=?");
				flag=true;
			}
		}
		sb.append(" where newsid=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeanews.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeanews.getNewsid());k++;
		}
		if(dbodeanews.COLUMN_FLAG[1]){
			dbc.setInt(k, dbodeanews.getEid());k++;
		}
		if(dbodeanews.COLUMN_FLAG[2]){
			dbc.setInt(k, dbodeanews.getTypeid());k++;
		}
		if(dbodeanews.COLUMN_FLAG[3]){
			dbc.setInt(k, dbodeanews.getViews());k++;
		}
		if(dbodeanews.COLUMN_FLAG[4]){
			dbc.setInt(k, dbodeanews.getHotsortid());k++;
		}
		if(dbodeanews.COLUMN_FLAG[5]){
			dbc.setTimestamp(k, new Timestamp(dbodeanews.getAdddate().getTime()));k++;
		}
		if(dbodeanews.COLUMN_FLAG[6]){
			dbc.setTimestamp(k, new Timestamp(dbodeanews.getPublishdate().getTime()));k++;
		}
		if(dbodeanews.COLUMN_FLAG[7]){
			dbc.setTimestamp(k, new Timestamp(dbodeanews.getHotdate().getTime()));k++;
		}
		if(dbodeanews.COLUMN_FLAG[8]){
			dbc.setInt(k, dbodeanews.getIsdelete());k++;
		}
		if(dbodeanews.COLUMN_FLAG[9]){
			dbc.setInt(k, dbodeanews.getIshot());k++;
		}
		if(dbodeanews.COLUMN_FLAG[10]){
			dbc.setString(k, dbodeanews.getTitle());k++;
		}
		if(dbodeanews.COLUMN_FLAG[11]){
			dbc.setString(k, dbodeanews.getNewscontent());k++;
		}
		if(dbodeanews.COLUMN_FLAG[12]){
			dbc.setInt(k, dbodeanews.getBbstopicpostid());k++;
		}
		dbc.setInt(k, dbodeanews.getNewsid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaNews dbodeanews) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeanews);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static int DboDeaNewsCountByeid(int eid){
		DBConnect dbc = null;
		String sql = "select count(*) from dbo_dea_news where eid = ?";
	
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

	public static List<DboDeaNews> DboDeaNewsSelectAllColumnByeid(int eid){
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_news where eid = ? and isdelete = 0 order by publishdate desc limit 8";
		List<DboDeaNews> list = new ArrayList<DboDeaNews>();
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, eid);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaNews obj = new DboDeaNews();
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