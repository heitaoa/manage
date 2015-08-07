package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbSiteMap;

public class  TbSiteMapDao  extends BaseDao {

	public static void fill(ResultSet rs, TbSiteMap tbsitemap) throws SQLException {
		tbsitemap.setId(rs.getInt("id"));//
		tbsitemap.setLoc(rs.getString("loc"));//
		tbsitemap.setLastmod(rs.getTimestamp("lastmod"));//
		tbsitemap.setPriority(rs.getString("priority"));//
		tbsitemap.setChangefreq(rs.getString("changefreq"));//
		tbsitemap.setDomain(rs.getInt("domain"));//
	}

	public static List<TbSiteMap> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_site_map";
		List<TbSiteMap> list = new ArrayList<TbSiteMap>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbSiteMap tbsitemap = new TbSiteMap();
				fill(rs, tbsitemap);
				list.add(tbsitemap);
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


	public static List<TbSiteMap> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_site_map where "+subsql+"";
		List<TbSiteMap> list = new ArrayList<TbSiteMap>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbSiteMap tbsitemap = new TbSiteMap();
				fill(rs, tbsitemap);
				list.add(tbsitemap);
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
		String sql = "select count(*) from tb_site_map where "+subsql+"";
		
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
		String sql = "delete from tb_site_map where "+subsql+"";
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
		String sql = "delete from tb_site_map where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbSiteMap tbsitemap) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_site_map(`id`,`loc`,`lastmod`,`priority`,`changefreq`,`domain`) values(?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbsitemap.getId());
		dbc.setString(2, tbsitemap.getLoc());
		dbc.setTimestamp(3, new Timestamp(tbsitemap.getLastmod().getTime()));
		dbc.setString(4, tbsitemap.getPriority());
		dbc.setString(5, tbsitemap.getChangefreq());
		dbc.setInt(6, tbsitemap.getDomain());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbSiteMap tbsitemap) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_site_map(`id`,`loc`,`lastmod`,`priority`,`changefreq`,`domain`) values(?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbsitemap.getId());
		dbc.setString(2, tbsitemap.getLoc());
		dbc.setTimestamp(3, new Timestamp(tbsitemap.getLastmod().getTime()));
		dbc.setString(4, tbsitemap.getPriority());
		dbc.setString(5, tbsitemap.getChangefreq());
		dbc.setInt(6, tbsitemap.getDomain());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbSiteMap tbsitemap) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_site_map set ");
		boolean flag = false;
		if(tbsitemap.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(tbsitemap.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",loc=?");
			}else{
				sb.append("loc=?");
				flag=true;
			}
		}
		if(tbsitemap.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",lastmod=?");
			}else{
				sb.append("lastmod=?");
				flag=true;
			}
		}
		if(tbsitemap.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",priority=?");
			}else{
				sb.append("priority=?");
				flag=true;
			}
		}
		if(tbsitemap.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",changefreq=?");
			}else{
				sb.append("changefreq=?");
				flag=true;
			}
		}
		if(tbsitemap.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",domain=?");
			}else{
				sb.append("domain=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbsitemap.COLUMN_FLAG[0]){
			dbc.setInt(k, tbsitemap.getId());k++;
		}
		if(tbsitemap.COLUMN_FLAG[1]){
			dbc.setString(k, tbsitemap.getLoc());k++;
		}
		if(tbsitemap.COLUMN_FLAG[2]){
			dbc.setTimestamp(k, new Timestamp(tbsitemap.getLastmod().getTime()));k++;
		}
		if(tbsitemap.COLUMN_FLAG[3]){
			dbc.setString(k, tbsitemap.getPriority());k++;
		}
		if(tbsitemap.COLUMN_FLAG[4]){
			dbc.setString(k, tbsitemap.getChangefreq());k++;
		}
		if(tbsitemap.COLUMN_FLAG[5]){
			dbc.setInt(k, tbsitemap.getDomain());k++;
		}
		dbc.setInt(k, tbsitemap.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbSiteMap tbsitemap) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbsitemap);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}