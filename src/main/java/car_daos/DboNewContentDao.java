package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboNewContent;

public class  DboNewContentDao  extends BaseDao {

	public static void fill(ResultSet rs, DboNewContent dbonewcontent) throws SQLException {
		dbonewcontent.setId(rs.getInt("id"));//自动增长id
		dbonewcontent.setNewsid(rs.getInt("newsid"));//新闻(new_news)的自动增长id
		dbonewcontent.setAreaid(rs.getInt("areaid"));//地域分类id
		dbonewcontent.setCarcatalogid(rs.getInt("carcatalogid"));//车型分类id
		dbonewcontent.setNewstitle(rs.getString("newstitle"));//标题
		dbonewcontent.setNewskeywords(rs.getString("newskeywords"));//关键字
		dbonewcontent.setNewscontent(rs.getString("newscontent"));//内容
		dbonewcontent.setAdddate(rs.getTimestamp("adddate"));//添加时间
		dbonewcontent.setLastupdate(rs.getTimestamp("lastupdate"));//最后更新时间
		dbonewcontent.setSortid(rs.getInt("sortid"));//排序
		dbonewcontent.setIsdelete(rs.getInt("isdelete"));//0正常
		dbonewcontent.setTitleimgpath(rs.getString("titleimgpath"));//
		dbonewcontent.setSerialid(rs.getInt("serialid"));//
	}

	public static List<DboNewContent> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_new_content";
		List<DboNewContent> list = new ArrayList<DboNewContent>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboNewContent dbonewcontent = new DboNewContent();
				fill(rs, dbonewcontent);
				list.add(dbonewcontent);
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


	public static List<DboNewContent> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_new_content where "+subsql+"";
		List<DboNewContent> list = new ArrayList<DboNewContent>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboNewContent dbonewcontent = new DboNewContent();
				fill(rs, dbonewcontent);
				list.add(dbonewcontent);
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
		String sql = "select count(*) from dbo_new_content where "+subsql+"";
		
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
		String sql = "delete from dbo_new_content where "+subsql+"";
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
		String sql = "delete from dbo_new_content where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboNewContent dbonewcontent) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_new_content(`id`,`newsid`,`areaid`,`carcatalogid`,`newstitle`,`newskeywords`,`newscontent`,`adddate`,`lastupdate`,`sortid`,`isdelete`,`titleimgpath`,`serialid`) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbonewcontent.getId());
		dbc.setInt(2, dbonewcontent.getNewsid());
		dbc.setInt(3, dbonewcontent.getAreaid());
		dbc.setInt(4, dbonewcontent.getCarcatalogid());
		dbc.setString(5, dbonewcontent.getNewstitle());
		dbc.setString(6, dbonewcontent.getNewskeywords());
		dbc.setString(7, dbonewcontent.getNewscontent());
		dbc.setTimestamp(8, new Timestamp(dbonewcontent.getAdddate().getTime()));
		dbc.setTimestamp(9, new Timestamp(dbonewcontent.getLastupdate().getTime()));
		dbc.setInt(10, dbonewcontent.getSortid());
		dbc.setInt(11, dbonewcontent.getIsdelete());
		dbc.setString(12, dbonewcontent.getTitleimgpath());
		dbc.setInt(13, dbonewcontent.getSerialid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboNewContent dbonewcontent) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_new_content(`id`,`newsid`,`areaid`,`carcatalogid`,`newstitle`,`newskeywords`,`newscontent`,`adddate`,`lastupdate`,`sortid`,`isdelete`,`titleimgpath`,`serialid`) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbonewcontent.getId());
		dbc.setInt(2, dbonewcontent.getNewsid());
		dbc.setInt(3, dbonewcontent.getAreaid());
		dbc.setInt(4, dbonewcontent.getCarcatalogid());
		dbc.setString(5, dbonewcontent.getNewstitle());
		dbc.setString(6, dbonewcontent.getNewskeywords());
		dbc.setString(7, dbonewcontent.getNewscontent());
		dbc.setTimestamp(8, new Timestamp(dbonewcontent.getAdddate().getTime()));
		dbc.setTimestamp(9, new Timestamp(dbonewcontent.getLastupdate().getTime()));
		dbc.setInt(10, dbonewcontent.getSortid());
		dbc.setInt(11, dbonewcontent.getIsdelete());
		dbc.setString(12, dbonewcontent.getTitleimgpath());
		dbc.setInt(13, dbonewcontent.getSerialid());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboNewContent dbonewcontent) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_new_content set ");
		boolean flag = false;
		if(dbonewcontent.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbonewcontent.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",newsid=?");
			}else{
				sb.append("newsid=?");
				flag=true;
			}
		}
		if(dbonewcontent.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",areaid=?");
			}else{
				sb.append("areaid=?");
				flag=true;
			}
		}
		if(dbonewcontent.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",carcatalogid=?");
			}else{
				sb.append("carcatalogid=?");
				flag=true;
			}
		}
		if(dbonewcontent.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",newstitle=?");
			}else{
				sb.append("newstitle=?");
				flag=true;
			}
		}
		if(dbonewcontent.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",newskeywords=?");
			}else{
				sb.append("newskeywords=?");
				flag=true;
			}
		}
		if(dbonewcontent.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",newscontent=?");
			}else{
				sb.append("newscontent=?");
				flag=true;
			}
		}
		if(dbonewcontent.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbonewcontent.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",lastupdate=?");
			}else{
				sb.append("lastupdate=?");
				flag=true;
			}
		}
		if(dbonewcontent.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",sortid=?");
			}else{
				sb.append("sortid=?");
				flag=true;
			}
		}
		if(dbonewcontent.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dbonewcontent.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",titleimgpath=?");
			}else{
				sb.append("titleimgpath=?");
				flag=true;
			}
		}
		if(dbonewcontent.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",serialid=?");
			}else{
				sb.append("serialid=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbonewcontent.COLUMN_FLAG[0]){
			dbc.setInt(k, dbonewcontent.getId());k++;
		}
		if(dbonewcontent.COLUMN_FLAG[1]){
			dbc.setInt(k, dbonewcontent.getNewsid());k++;
		}
		if(dbonewcontent.COLUMN_FLAG[2]){
			dbc.setInt(k, dbonewcontent.getAreaid());k++;
		}
		if(dbonewcontent.COLUMN_FLAG[3]){
			dbc.setInt(k, dbonewcontent.getCarcatalogid());k++;
		}
		if(dbonewcontent.COLUMN_FLAG[4]){
			dbc.setString(k, dbonewcontent.getNewstitle());k++;
		}
		if(dbonewcontent.COLUMN_FLAG[5]){
			dbc.setString(k, dbonewcontent.getNewskeywords());k++;
		}
		if(dbonewcontent.COLUMN_FLAG[6]){
			dbc.setString(k, dbonewcontent.getNewscontent());k++;
		}
		if(dbonewcontent.COLUMN_FLAG[7]){
			dbc.setTimestamp(k, new Timestamp(dbonewcontent.getAdddate().getTime()));k++;
		}
		if(dbonewcontent.COLUMN_FLAG[8]){
			dbc.setTimestamp(k, new Timestamp(dbonewcontent.getLastupdate().getTime()));k++;
		}
		if(dbonewcontent.COLUMN_FLAG[9]){
			dbc.setInt(k, dbonewcontent.getSortid());k++;
		}
		if(dbonewcontent.COLUMN_FLAG[10]){
			dbc.setInt(k, dbonewcontent.getIsdelete());k++;
		}
		if(dbonewcontent.COLUMN_FLAG[11]){
			dbc.setString(k, dbonewcontent.getTitleimgpath());k++;
		}
		if(dbonewcontent.COLUMN_FLAG[12]){
			dbc.setInt(k, dbonewcontent.getSerialid());k++;
		}
		dbc.setInt(k, dbonewcontent.getId());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboNewContent dbonewcontent) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbonewcontent);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}