package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboImgNewcontent;

public class  DboImgNewcontentDao  extends BaseDao {

	public static void fill(ResultSet rs, DboImgNewcontent dboimgnewcontent) throws SQLException {
		dboimgnewcontent.setId(rs.getInt("id"));//自动增长id
		dboimgnewcontent.setTitleid(rs.getInt("titleid"));//图片主题id
		dboimgnewcontent.setTitle(rs.getString("title"));//小标题
		dboimgnewcontent.setKeywords(rs.getString("keywords"));//关键字
		dboimgnewcontent.setPath(rs.getString("path"));//保存路径
		dboimgnewcontent.setAdddate(rs.getTimestamp("adddate"));//添加时间
		dboimgnewcontent.setLastupdate(rs.getTimestamp("lastupdate"));//最后修改时间
		dboimgnewcontent.setSortid(rs.getInt("sortid"));//排序
		dboimgnewcontent.setIsdelete(rs.getInt("isdelete"));//0正常
	}

	public static List<DboImgNewcontent> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_img_newcontent";
		List<DboImgNewcontent> list = new ArrayList<DboImgNewcontent>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboImgNewcontent dboimgnewcontent = new DboImgNewcontent();
				fill(rs, dboimgnewcontent);
				list.add(dboimgnewcontent);
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


	public static List<DboImgNewcontent> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_img_newcontent where "+subsql+"";
		List<DboImgNewcontent> list = new ArrayList<DboImgNewcontent>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboImgNewcontent dboimgnewcontent = new DboImgNewcontent();
				fill(rs, dboimgnewcontent);
				list.add(dboimgnewcontent);
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
		String sql = "select count(*) from dbo_img_newcontent where "+subsql+"";
		
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
		String sql = "delete from dbo_img_newcontent where "+subsql+"";
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
		String sql = "delete from dbo_img_newcontent where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboImgNewcontent dboimgnewcontent) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_img_newcontent(`id`,`titleid`,`title`,`keywords`,`path`,`adddate`,`lastupdate`,`sortid`,`isdelete`) values(?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboimgnewcontent.getId());
		dbc.setInt(2, dboimgnewcontent.getTitleid());
		dbc.setString(3, dboimgnewcontent.getTitle());
		dbc.setString(4, dboimgnewcontent.getKeywords());
		dbc.setString(5, dboimgnewcontent.getPath());
		dbc.setTimestamp(6, new Timestamp(dboimgnewcontent.getAdddate().getTime()));
		dbc.setTimestamp(7, new Timestamp(dboimgnewcontent.getLastupdate().getTime()));
		dbc.setInt(8, dboimgnewcontent.getSortid());
		dbc.setInt(9, dboimgnewcontent.getIsdelete());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboImgNewcontent dboimgnewcontent) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_img_newcontent(`id`,`titleid`,`title`,`keywords`,`path`,`adddate`,`lastupdate`,`sortid`,`isdelete`) values(?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboimgnewcontent.getId());
		dbc.setInt(2, dboimgnewcontent.getTitleid());
		dbc.setString(3, dboimgnewcontent.getTitle());
		dbc.setString(4, dboimgnewcontent.getKeywords());
		dbc.setString(5, dboimgnewcontent.getPath());
		dbc.setTimestamp(6, new Timestamp(dboimgnewcontent.getAdddate().getTime()));
		dbc.setTimestamp(7, new Timestamp(dboimgnewcontent.getLastupdate().getTime()));
		dbc.setInt(8, dboimgnewcontent.getSortid());
		dbc.setInt(9, dboimgnewcontent.getIsdelete());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboImgNewcontent dboimgnewcontent) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_img_newcontent set ");
		boolean flag = false;
		if(dboimgnewcontent.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dboimgnewcontent.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",titleid=?");
			}else{
				sb.append("titleid=?");
				flag=true;
			}
		}
		if(dboimgnewcontent.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",title=?");
			}else{
				sb.append("title=?");
				flag=true;
			}
		}
		if(dboimgnewcontent.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",keywords=?");
			}else{
				sb.append("keywords=?");
				flag=true;
			}
		}
		if(dboimgnewcontent.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",path=?");
			}else{
				sb.append("path=?");
				flag=true;
			}
		}
		if(dboimgnewcontent.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dboimgnewcontent.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",lastupdate=?");
			}else{
				sb.append("lastupdate=?");
				flag=true;
			}
		}
		if(dboimgnewcontent.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",sortid=?");
			}else{
				sb.append("sortid=?");
				flag=true;
			}
		}
		if(dboimgnewcontent.COLUMN_FLAG[8]){
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
		if(dboimgnewcontent.COLUMN_FLAG[0]){
			dbc.setInt(k, dboimgnewcontent.getId());k++;
		}
		if(dboimgnewcontent.COLUMN_FLAG[1]){
			dbc.setInt(k, dboimgnewcontent.getTitleid());k++;
		}
		if(dboimgnewcontent.COLUMN_FLAG[2]){
			dbc.setString(k, dboimgnewcontent.getTitle());k++;
		}
		if(dboimgnewcontent.COLUMN_FLAG[3]){
			dbc.setString(k, dboimgnewcontent.getKeywords());k++;
		}
		if(dboimgnewcontent.COLUMN_FLAG[4]){
			dbc.setString(k, dboimgnewcontent.getPath());k++;
		}
		if(dboimgnewcontent.COLUMN_FLAG[5]){
			dbc.setTimestamp(k, new Timestamp(dboimgnewcontent.getAdddate().getTime()));k++;
		}
		if(dboimgnewcontent.COLUMN_FLAG[6]){
			dbc.setTimestamp(k, new Timestamp(dboimgnewcontent.getLastupdate().getTime()));k++;
		}
		if(dboimgnewcontent.COLUMN_FLAG[7]){
			dbc.setInt(k, dboimgnewcontent.getSortid());k++;
		}
		if(dboimgnewcontent.COLUMN_FLAG[8]){
			dbc.setInt(k, dboimgnewcontent.getIsdelete());k++;
		}
		dbc.setInt(k, dboimgnewcontent.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboImgNewcontent dboimgnewcontent) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dboimgnewcontent);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}