package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboContentbak;

public class  DboContentbakDao  extends BaseDao {

	public static void fill(ResultSet rs, DboContentbak dbocontentbak) throws SQLException {
		dbocontentbak.setId(rs.getInt("id"));//
		dbocontentbak.setCid(rs.getInt("cid"));//dbo_new_content.id
		dbocontentbak.setContentstr(rs.getString("contentstr"));//
		dbocontentbak.setAdddate(rs.getTimestamp("adddate"));//
		dbocontentbak.setIsdesc(rs.getInt("isdesc"));//
		dbocontentbak.setDescription(rs.getString("description"));//内容描述
		dbocontentbak.setPhoto(rs.getString("photo"));//
		dbocontentbak.setNewsid(rs.getInt("newsid"));//dbo_new_news.id
		dbocontentbak.setIsfirst(rs.getInt("isfirst"));//是否第一页 0不是 1是
	}

	public static List<DboContentbak> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_contentbak";
		List<DboContentbak> list = new ArrayList<DboContentbak>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboContentbak dbocontentbak = new DboContentbak();
				fill(rs, dbocontentbak);
				list.add(dbocontentbak);
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


	public static List<DboContentbak> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_contentbak where "+subsql+"";
		List<DboContentbak> list = new ArrayList<DboContentbak>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboContentbak dbocontentbak = new DboContentbak();
				fill(rs, dbocontentbak);
				list.add(dbocontentbak);
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
		String sql = "select count(*) from dbo_contentbak where "+subsql+"";
		
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
		String sql = "delete from dbo_contentbak where "+subsql+"";
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
		String sql = "delete from dbo_contentbak where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboContentbak dbocontentbak) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_contentbak(`id`,`cid`,`contentstr`,`adddate`,`isdesc`,`description`,`photo`,`newsid`,`isfirst`) values(?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbocontentbak.getId());
		dbc.setInt(2, dbocontentbak.getCid());
		dbc.setString(3, dbocontentbak.getContentstr());
		dbc.setTimestamp(4, new Timestamp(dbocontentbak.getAdddate().getTime()));
		dbc.setInt(5, dbocontentbak.getIsdesc());
		dbc.setString(6, dbocontentbak.getDescription());
		dbc.setString(7, dbocontentbak.getPhoto());
		dbc.setInt(8, dbocontentbak.getNewsid());
		dbc.setInt(9, dbocontentbak.getIsfirst());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboContentbak dbocontentbak) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_contentbak(`id`,`cid`,`contentstr`,`adddate`,`isdesc`,`description`,`photo`,`newsid`,`isfirst`) values(?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbocontentbak.getId());
		dbc.setInt(2, dbocontentbak.getCid());
		dbc.setString(3, dbocontentbak.getContentstr());
		dbc.setTimestamp(4, new Timestamp(dbocontentbak.getAdddate().getTime()));
		dbc.setInt(5, dbocontentbak.getIsdesc());
		dbc.setString(6, dbocontentbak.getDescription());
		dbc.setString(7, dbocontentbak.getPhoto());
		dbc.setInt(8, dbocontentbak.getNewsid());
		dbc.setInt(9, dbocontentbak.getIsfirst());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

}