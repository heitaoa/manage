package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboZhtContent;

public class  DboZhtContentDao  extends BaseDao {

	public static void fill(ResultSet rs, DboZhtContent dbozhtcontent) throws SQLException {
		dbozhtcontent.setId(rs.getInt("id"));//
		dbozhtcontent.setCatalogid(rs.getInt("catalogid"));//
		dbozhtcontent.setName(rs.getString("name"));//
		dbozhtcontent.setContent(rs.getString("content"));//
		dbozhtcontent.setAdddate(rs.getTimestamp("adddate"));//
		dbozhtcontent.setIsdelete(rs.getInt("isdelete"));//
		dbozhtcontent.setIsshow(rs.getInt("isshow"));//
		dbozhtcontent.setTitlephoto(rs.getString("titlephoto"));//
		dbozhtcontent.setType(rs.getString("type"));//
		dbozhtcontent.setKeywords(rs.getString("keywords"));//
		dbozhtcontent.setDescstr(rs.getString("descstr"));//
		dbozhtcontent.setAddadmin(rs.getString("addadmin"));//
		dbozhtcontent.setUpadmin(rs.getString("upadmin"));//
		dbozhtcontent.setLastup(rs.getTimestamp("lastup"));//
		dbozhtcontent.setRname(rs.getString("rname"));//
		dbozhtcontent.setTopid(rs.getInt("topid"));//
		dbozhtcontent.setSortid(rs.getInt("sortid"));//
		dbozhtcontent.setIshead(rs.getInt("ishead"));//
		dbozhtcontent.setLastcommentdate(rs.getTimestamp("lastcommentdate"));//
	}

	public static List<DboZhtContent> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_zht_content";
		List<DboZhtContent> list = new ArrayList<DboZhtContent>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboZhtContent dbozhtcontent = new DboZhtContent();
				fill(rs, dbozhtcontent);
				list.add(dbozhtcontent);
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


	public static List<DboZhtContent> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_zht_content where "+subsql+"";
		List<DboZhtContent> list = new ArrayList<DboZhtContent>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboZhtContent dbozhtcontent = new DboZhtContent();
				fill(rs, dbozhtcontent);
				list.add(dbozhtcontent);
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
		String sql = "select count(*) from dbo_zht_content where "+subsql+"";
		
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
		String sql = "delete from dbo_zht_content where "+subsql+"";
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
		String sql = "delete from dbo_zht_content where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboZhtContent dbozhtcontent) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_zht_content(`id`,`catalogid`,`name`,`content`,`adddate`,`isdelete`,`isshow`,`titlephoto`,`type`,`keywords`,`descstr`,`addadmin`,`upadmin`,`lastup`,`rname`,`topid`,`sortid`,`ishead`,`lastcommentdate`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbozhtcontent.getId());
		dbc.setInt(2, dbozhtcontent.getCatalogid());
		dbc.setString(3, dbozhtcontent.getName());
		dbc.setString(4, dbozhtcontent.getContent());
		dbc.setTimestamp(5, new Timestamp(dbozhtcontent.getAdddate().getTime()));
		dbc.setInt(6, dbozhtcontent.getIsdelete());
		dbc.setInt(7, dbozhtcontent.getIsshow());
		dbc.setString(8, dbozhtcontent.getTitlephoto());
		dbc.setString(9, dbozhtcontent.getType());
		dbc.setString(10, dbozhtcontent.getKeywords());
		dbc.setString(11, dbozhtcontent.getDescstr());
		dbc.setString(12, dbozhtcontent.getAddadmin());
		dbc.setString(13, dbozhtcontent.getUpadmin());
		dbc.setTimestamp(14, new Timestamp(dbozhtcontent.getLastup().getTime()));
		dbc.setString(15, dbozhtcontent.getRname());
		dbc.setInt(16, dbozhtcontent.getTopid());
		dbc.setInt(17, dbozhtcontent.getSortid());
		dbc.setInt(18, dbozhtcontent.getIshead());
		dbc.setTimestamp(19, new Timestamp(dbozhtcontent.getLastcommentdate().getTime()));
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboZhtContent dbozhtcontent) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_zht_content(`id`,`catalogid`,`name`,`content`,`adddate`,`isdelete`,`isshow`,`titlephoto`,`type`,`keywords`,`descstr`,`addadmin`,`upadmin`,`lastup`,`rname`,`topid`,`sortid`,`ishead`,`lastcommentdate`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbozhtcontent.getId());
		dbc.setInt(2, dbozhtcontent.getCatalogid());
		dbc.setString(3, dbozhtcontent.getName());
		dbc.setString(4, dbozhtcontent.getContent());
		dbc.setTimestamp(5, new Timestamp(dbozhtcontent.getAdddate().getTime()));
		dbc.setInt(6, dbozhtcontent.getIsdelete());
		dbc.setInt(7, dbozhtcontent.getIsshow());
		dbc.setString(8, dbozhtcontent.getTitlephoto());
		dbc.setString(9, dbozhtcontent.getType());
		dbc.setString(10, dbozhtcontent.getKeywords());
		dbc.setString(11, dbozhtcontent.getDescstr());
		dbc.setString(12, dbozhtcontent.getAddadmin());
		dbc.setString(13, dbozhtcontent.getUpadmin());
		dbc.setTimestamp(14, new Timestamp(dbozhtcontent.getLastup().getTime()));
		dbc.setString(15, dbozhtcontent.getRname());
		dbc.setInt(16, dbozhtcontent.getTopid());
		dbc.setInt(17, dbozhtcontent.getSortid());
		dbc.setInt(18, dbozhtcontent.getIshead());
		dbc.setTimestamp(19, new Timestamp(dbozhtcontent.getLastcommentdate().getTime()));
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboZhtContent dbozhtcontent) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_zht_content set ");
		boolean flag = false;
		if(dbozhtcontent.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbozhtcontent.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",catalogid=?");
			}else{
				sb.append("catalogid=?");
				flag=true;
			}
		}
		if(dbozhtcontent.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",name=?");
			}else{
				sb.append("name=?");
				flag=true;
			}
		}
		if(dbozhtcontent.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",content=?");
			}else{
				sb.append("content=?");
				flag=true;
			}
		}
		if(dbozhtcontent.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbozhtcontent.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dbozhtcontent.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",isshow=?");
			}else{
				sb.append("isshow=?");
				flag=true;
			}
		}
		if(dbozhtcontent.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",titlephoto=?");
			}else{
				sb.append("titlephoto=?");
				flag=true;
			}
		}
		if(dbozhtcontent.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",type=?");
			}else{
				sb.append("type=?");
				flag=true;
			}
		}
		if(dbozhtcontent.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",keywords=?");
			}else{
				sb.append("keywords=?");
				flag=true;
			}
		}
		if(dbozhtcontent.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",descstr=?");
			}else{
				sb.append("descstr=?");
				flag=true;
			}
		}
		if(dbozhtcontent.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",addadmin=?");
			}else{
				sb.append("addadmin=?");
				flag=true;
			}
		}
		if(dbozhtcontent.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",upadmin=?");
			}else{
				sb.append("upadmin=?");
				flag=true;
			}
		}
		if(dbozhtcontent.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",lastup=?");
			}else{
				sb.append("lastup=?");
				flag=true;
			}
		}
		if(dbozhtcontent.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",rname=?");
			}else{
				sb.append("rname=?");
				flag=true;
			}
		}
		if(dbozhtcontent.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",topid=?");
			}else{
				sb.append("topid=?");
				flag=true;
			}
		}
		if(dbozhtcontent.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",sortid=?");
			}else{
				sb.append("sortid=?");
				flag=true;
			}
		}
		if(dbozhtcontent.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",ishead=?");
			}else{
				sb.append("ishead=?");
				flag=true;
			}
		}
		if(dbozhtcontent.COLUMN_FLAG[18]){
			if(flag){
				sb.append(",lastcommentdate=?");
			}else{
				sb.append("lastcommentdate=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbozhtcontent.COLUMN_FLAG[0]){
			dbc.setInt(k, dbozhtcontent.getId());k++;
		}
		if(dbozhtcontent.COLUMN_FLAG[1]){
			dbc.setInt(k, dbozhtcontent.getCatalogid());k++;
		}
		if(dbozhtcontent.COLUMN_FLAG[2]){
			dbc.setString(k, dbozhtcontent.getName());k++;
		}
		if(dbozhtcontent.COLUMN_FLAG[3]){
			dbc.setString(k, dbozhtcontent.getContent());k++;
		}
		if(dbozhtcontent.COLUMN_FLAG[4]){
			dbc.setTimestamp(k, new Timestamp(dbozhtcontent.getAdddate().getTime()));k++;
		}
		if(dbozhtcontent.COLUMN_FLAG[5]){
			dbc.setInt(k, dbozhtcontent.getIsdelete());k++;
		}
		if(dbozhtcontent.COLUMN_FLAG[6]){
			dbc.setInt(k, dbozhtcontent.getIsshow());k++;
		}
		if(dbozhtcontent.COLUMN_FLAG[7]){
			dbc.setString(k, dbozhtcontent.getTitlephoto());k++;
		}
		if(dbozhtcontent.COLUMN_FLAG[8]){
			dbc.setString(k, dbozhtcontent.getType());k++;
		}
		if(dbozhtcontent.COLUMN_FLAG[9]){
			dbc.setString(k, dbozhtcontent.getKeywords());k++;
		}
		if(dbozhtcontent.COLUMN_FLAG[10]){
			dbc.setString(k, dbozhtcontent.getDescstr());k++;
		}
		if(dbozhtcontent.COLUMN_FLAG[11]){
			dbc.setString(k, dbozhtcontent.getAddadmin());k++;
		}
		if(dbozhtcontent.COLUMN_FLAG[12]){
			dbc.setString(k, dbozhtcontent.getUpadmin());k++;
		}
		if(dbozhtcontent.COLUMN_FLAG[13]){
			dbc.setTimestamp(k, new Timestamp(dbozhtcontent.getLastup().getTime()));k++;
		}
		if(dbozhtcontent.COLUMN_FLAG[14]){
			dbc.setString(k, dbozhtcontent.getRname());k++;
		}
		if(dbozhtcontent.COLUMN_FLAG[15]){
			dbc.setInt(k, dbozhtcontent.getTopid());k++;
		}
		if(dbozhtcontent.COLUMN_FLAG[16]){
			dbc.setInt(k, dbozhtcontent.getSortid());k++;
		}
		if(dbozhtcontent.COLUMN_FLAG[17]){
			dbc.setInt(k, dbozhtcontent.getIshead());k++;
		}
		if(dbozhtcontent.COLUMN_FLAG[18]){
			dbc.setTimestamp(k, new Timestamp(dbozhtcontent.getLastcommentdate().getTime()));k++;
		}
		dbc.setInt(k, dbozhtcontent.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboZhtContent dbozhtcontent) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbozhtcontent);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}