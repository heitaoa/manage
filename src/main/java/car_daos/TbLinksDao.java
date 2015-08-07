package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbLinks;

public class  TbLinksDao  extends BaseDao {

	public static void fill(ResultSet rs, TbLinks tblinks) throws SQLException {
		tblinks.setId(rs.getInt("id"));//
		tblinks.setTitle(rs.getString("title"));//名称
		tblinks.setLink(rs.getString("link"));//链接
		tblinks.setPlace(rs.getString("place"));//链接位置 index_1
		tblinks.setAddtime(rs.getTimestamp("addtime"));//添加时间
		tblinks.setIsdelete(rs.getInt("isdelete"));//0-未删除  1-已删除
	}

	public static List<TbLinks> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_links";
		List<TbLinks> list = new ArrayList<TbLinks>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbLinks tblinks = new TbLinks();
				fill(rs, tblinks);
				list.add(tblinks);
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


	public static List<TbLinks> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_links where "+subsql+"";
		List<TbLinks> list = new ArrayList<TbLinks>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbLinks tblinks = new TbLinks();
				fill(rs, tblinks);
				list.add(tblinks);
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
		String sql = "select count(*) from tb_links where "+subsql+"";
		
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
		String sql = "delete from tb_links where "+subsql+"";
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
		String sql = "delete from tb_links where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbLinks tblinks) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_links(`id`,`title`,`link`,`place`,`addtime`,`isdelete`) values(?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tblinks.getId());
		dbc.setString(2, tblinks.getTitle());
		dbc.setString(3, tblinks.getLink());
		dbc.setString(4, tblinks.getPlace());
		dbc.setTimestamp(5, new Timestamp(tblinks.getAddtime().getTime()));
		dbc.setInt(6, tblinks.getIsdelete());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbLinks tblinks) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_links(`id`,`title`,`link`,`place`,`addtime`,`isdelete`) values(?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tblinks.getId());
		dbc.setString(2, tblinks.getTitle());
		dbc.setString(3, tblinks.getLink());
		dbc.setString(4, tblinks.getPlace());
		dbc.setTimestamp(5, new Timestamp(tblinks.getAddtime().getTime()));
		dbc.setInt(6, tblinks.getIsdelete());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbLinks tblinks) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_links set ");
		boolean flag = false;
		if(tblinks.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(tblinks.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",title=?");
			}else{
				sb.append("title=?");
				flag=true;
			}
		}
		if(tblinks.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",link=?");
			}else{
				sb.append("link=?");
				flag=true;
			}
		}
		if(tblinks.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",place=?");
			}else{
				sb.append("place=?");
				flag=true;
			}
		}
		if(tblinks.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",addtime=?");
			}else{
				sb.append("addtime=?");
				flag=true;
			}
		}
		if(tblinks.COLUMN_FLAG[5]){
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
		if(tblinks.COLUMN_FLAG[0]){
			dbc.setInt(k, tblinks.getId());k++;
		}
		if(tblinks.COLUMN_FLAG[1]){
			dbc.setString(k, tblinks.getTitle());k++;
		}
		if(tblinks.COLUMN_FLAG[2]){
			dbc.setString(k, tblinks.getLink());k++;
		}
		if(tblinks.COLUMN_FLAG[3]){
			dbc.setString(k, tblinks.getPlace());k++;
		}
		if(tblinks.COLUMN_FLAG[4]){
			dbc.setTimestamp(k, new Timestamp(tblinks.getAddtime().getTime()));k++;
		}
		if(tblinks.COLUMN_FLAG[5]){
			dbc.setInt(k, tblinks.getIsdelete());k++;
		}
		dbc.setInt(k, tblinks.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbLinks tblinks) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tblinks);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}