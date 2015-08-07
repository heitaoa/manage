package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboSubData315;

public class  DboSubData315Dao  extends BaseDao {

	public static void fill(ResultSet rs, DboSubData315 dbosubdata315) throws SQLException {
		dbosubdata315.setId(rs.getInt("id"));//
		dbosubdata315.setSid(rs.getInt("sid"));//
		dbosubdata315.setTitle(rs.getString("title"));//
		dbosubdata315.setContent(rs.getString("content"));//
		dbosubdata315.setPic(rs.getString("pic"));//
		dbosubdata315.setLink(rs.getString("link"));//
		dbosubdata315.setCtitle(rs.getString("ctitle"));//
		dbosubdata315.setClink(rs.getString("clink"));//
		dbosubdata315.setColor(rs.getString("color"));//
		dbosubdata315.setBold(rs.getInt("bold"));//
		dbosubdata315.setAdddate(rs.getTimestamp("adddate"));//
		dbosubdata315.setIsdelete(rs.getInt("isdelete"));//
		dbosubdata315.setSortid(rs.getInt("sortid"));//
		dbosubdata315.setLink_back(rs.getString("link_back"));//
		dbosubdata315.setClink_back(rs.getString("clink_back"));//
		dbosubdata315.setIsad(rs.getInt("isad"));//
	}

	public static List<DboSubData315> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_sub_data_315";
		List<DboSubData315> list = new ArrayList<DboSubData315>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboSubData315 dbosubdata315 = new DboSubData315();
				fill(rs, dbosubdata315);
				list.add(dbosubdata315);
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


	public static List<DboSubData315> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_sub_data_315 where "+subsql+"";
		List<DboSubData315> list = new ArrayList<DboSubData315>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboSubData315 dbosubdata315 = new DboSubData315();
				fill(rs, dbosubdata315);
				list.add(dbosubdata315);
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
		String sql = "select count(*) from dbo_sub_data_315 where "+subsql+"";
		
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
		String sql = "delete from dbo_sub_data_315 where "+subsql+"";
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
		String sql = "delete from dbo_sub_data_315 where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboSubData315 dbosubdata315) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_sub_data_315(`id`,`sid`,`title`,`content`,`pic`,`link`,`ctitle`,`clink`,`color`,`bold`,`adddate`,`isdelete`,`sortid`,`link_back`,`clink_back`,`isad`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbosubdata315.getId());
		dbc.setInt(2, dbosubdata315.getSid());
		dbc.setString(3, dbosubdata315.getTitle());
		dbc.setString(4, dbosubdata315.getContent());
		dbc.setString(5, dbosubdata315.getPic());
		dbc.setString(6, dbosubdata315.getLink());
		dbc.setString(7, dbosubdata315.getCtitle());
		dbc.setString(8, dbosubdata315.getClink());
		dbc.setString(9, dbosubdata315.getColor());
		dbc.setInt(10, dbosubdata315.getBold());
		dbc.setTimestamp(11, new Timestamp(dbosubdata315.getAdddate().getTime()));
		dbc.setInt(12, dbosubdata315.getIsdelete());
		dbc.setInt(13, dbosubdata315.getSortid());
		dbc.setString(14, dbosubdata315.getLink_back());
		dbc.setString(15, dbosubdata315.getClink_back());
		dbc.setInt(16, dbosubdata315.getIsad());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboSubData315 dbosubdata315) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_sub_data_315(`id`,`sid`,`title`,`content`,`pic`,`link`,`ctitle`,`clink`,`color`,`bold`,`adddate`,`isdelete`,`sortid`,`link_back`,`clink_back`,`isad`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbosubdata315.getId());
		dbc.setInt(2, dbosubdata315.getSid());
		dbc.setString(3, dbosubdata315.getTitle());
		dbc.setString(4, dbosubdata315.getContent());
		dbc.setString(5, dbosubdata315.getPic());
		dbc.setString(6, dbosubdata315.getLink());
		dbc.setString(7, dbosubdata315.getCtitle());
		dbc.setString(8, dbosubdata315.getClink());
		dbc.setString(9, dbosubdata315.getColor());
		dbc.setInt(10, dbosubdata315.getBold());
		dbc.setTimestamp(11, new Timestamp(dbosubdata315.getAdddate().getTime()));
		dbc.setInt(12, dbosubdata315.getIsdelete());
		dbc.setInt(13, dbosubdata315.getSortid());
		dbc.setString(14, dbosubdata315.getLink_back());
		dbc.setString(15, dbosubdata315.getClink_back());
		dbc.setInt(16, dbosubdata315.getIsad());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboSubData315 dbosubdata315) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_sub_data_315 set ");
		boolean flag = false;
		if(dbosubdata315.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbosubdata315.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",sid=?");
			}else{
				sb.append("sid=?");
				flag=true;
			}
		}
		if(dbosubdata315.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",title=?");
			}else{
				sb.append("title=?");
				flag=true;
			}
		}
		if(dbosubdata315.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",content=?");
			}else{
				sb.append("content=?");
				flag=true;
			}
		}
		if(dbosubdata315.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",pic=?");
			}else{
				sb.append("pic=?");
				flag=true;
			}
		}
		if(dbosubdata315.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",link=?");
			}else{
				sb.append("link=?");
				flag=true;
			}
		}
		if(dbosubdata315.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",ctitle=?");
			}else{
				sb.append("ctitle=?");
				flag=true;
			}
		}
		if(dbosubdata315.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",clink=?");
			}else{
				sb.append("clink=?");
				flag=true;
			}
		}
		if(dbosubdata315.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",color=?");
			}else{
				sb.append("color=?");
				flag=true;
			}
		}
		if(dbosubdata315.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",bold=?");
			}else{
				sb.append("bold=?");
				flag=true;
			}
		}
		if(dbosubdata315.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbosubdata315.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dbosubdata315.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",sortid=?");
			}else{
				sb.append("sortid=?");
				flag=true;
			}
		}
		if(dbosubdata315.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",link_back=?");
			}else{
				sb.append("link_back=?");
				flag=true;
			}
		}
		if(dbosubdata315.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",clink_back=?");
			}else{
				sb.append("clink_back=?");
				flag=true;
			}
		}
		if(dbosubdata315.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",isad=?");
			}else{
				sb.append("isad=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbosubdata315.COLUMN_FLAG[0]){
			dbc.setInt(k, dbosubdata315.getId());k++;
		}
		if(dbosubdata315.COLUMN_FLAG[1]){
			dbc.setInt(k, dbosubdata315.getSid());k++;
		}
		if(dbosubdata315.COLUMN_FLAG[2]){
			dbc.setString(k, dbosubdata315.getTitle());k++;
		}
		if(dbosubdata315.COLUMN_FLAG[3]){
			dbc.setString(k, dbosubdata315.getContent());k++;
		}
		if(dbosubdata315.COLUMN_FLAG[4]){
			dbc.setString(k, dbosubdata315.getPic());k++;
		}
		if(dbosubdata315.COLUMN_FLAG[5]){
			dbc.setString(k, dbosubdata315.getLink());k++;
		}
		if(dbosubdata315.COLUMN_FLAG[6]){
			dbc.setString(k, dbosubdata315.getCtitle());k++;
		}
		if(dbosubdata315.COLUMN_FLAG[7]){
			dbc.setString(k, dbosubdata315.getClink());k++;
		}
		if(dbosubdata315.COLUMN_FLAG[8]){
			dbc.setString(k, dbosubdata315.getColor());k++;
		}
		if(dbosubdata315.COLUMN_FLAG[9]){
			dbc.setInt(k, dbosubdata315.getBold());k++;
		}
		if(dbosubdata315.COLUMN_FLAG[10]){
			dbc.setTimestamp(k, new Timestamp(dbosubdata315.getAdddate().getTime()));k++;
		}
		if(dbosubdata315.COLUMN_FLAG[11]){
			dbc.setInt(k, dbosubdata315.getIsdelete());k++;
		}
		if(dbosubdata315.COLUMN_FLAG[12]){
			dbc.setInt(k, dbosubdata315.getSortid());k++;
		}
		if(dbosubdata315.COLUMN_FLAG[13]){
			dbc.setString(k, dbosubdata315.getLink_back());k++;
		}
		if(dbosubdata315.COLUMN_FLAG[14]){
			dbc.setString(k, dbosubdata315.getClink_back());k++;
		}
		if(dbosubdata315.COLUMN_FLAG[15]){
			dbc.setInt(k, dbosubdata315.getIsad());k++;
		}
		dbc.setInt(k, dbosubdata315.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboSubData315 dbosubdata315) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbosubdata315);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}