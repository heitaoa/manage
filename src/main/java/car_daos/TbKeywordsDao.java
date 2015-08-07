package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbKeywords;

public class  TbKeywordsDao  extends BaseDao {

	public static void fill(ResultSet rs, TbKeywords tbkeywords) throws SQLException {
		tbkeywords.setId(rs.getInt("id"));//
		tbkeywords.setKeyword(rs.getString("keyword"));//¹Ø¼ü×Ö
		tbkeywords.setUrl(rs.getString("url"));//Ìø×ªµØÖ·
		tbkeywords.setDesc(rs.getString("desc"));//
	}

	public static List<TbKeywords> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_keywords";
		List<TbKeywords> list = new ArrayList<TbKeywords>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbKeywords tbkeywords = new TbKeywords();
				fill(rs, tbkeywords);
				list.add(tbkeywords);
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


	public static List<TbKeywords> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_keywords where "+subsql+"";
		List<TbKeywords> list = new ArrayList<TbKeywords>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbKeywords tbkeywords = new TbKeywords();
				fill(rs, tbkeywords);
				list.add(tbkeywords);
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
		String sql = "select count(*) from tb_keywords where "+subsql+"";
		
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
		String sql = "delete from tb_keywords where "+subsql+"";
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
		String sql = "delete from tb_keywords where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbKeywords tbkeywords) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_keywords(`id`,`keyword`,`url`,`desc`) values(?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbkeywords.getId());
		dbc.setString(2, tbkeywords.getKeyword());
		dbc.setString(3, tbkeywords.getUrl());
		dbc.setString(4, tbkeywords.getDesc());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbKeywords tbkeywords) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_keywords(`id`,`keyword`,`url`,`desc`) values(?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbkeywords.getId());
		dbc.setString(2, tbkeywords.getKeyword());
		dbc.setString(3, tbkeywords.getUrl());
		dbc.setString(4, tbkeywords.getDesc());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbKeywords tbkeywords) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_keywords set ");
		boolean flag = false;
		if(tbkeywords.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(tbkeywords.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",keyword=?");
			}else{
				sb.append("keyword=?");
				flag=true;
			}
		}
		if(tbkeywords.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",url=?");
			}else{
				sb.append("url=?");
				flag=true;
			}
		}
		if(tbkeywords.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",desc=?");
			}else{
				sb.append("desc=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbkeywords.COLUMN_FLAG[0]){
			dbc.setInt(k, tbkeywords.getId());k++;
		}
		if(tbkeywords.COLUMN_FLAG[1]){
			dbc.setString(k, tbkeywords.getKeyword());k++;
		}
		if(tbkeywords.COLUMN_FLAG[2]){
			dbc.setString(k, tbkeywords.getUrl());k++;
		}
		if(tbkeywords.COLUMN_FLAG[3]){
			dbc.setString(k, tbkeywords.getDesc());k++;
		}
		dbc.setInt(k, tbkeywords.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbKeywords tbkeywords) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbkeywords);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}