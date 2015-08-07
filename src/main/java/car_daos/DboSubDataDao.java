package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboSubData;

public class  DboSubDataDao  extends BaseDao {

	public static void fill(ResultSet rs, DboSubData dbosubdata) throws SQLException {
		dbosubdata.setId(rs.getInt("id"));//
		dbosubdata.setSid(rs.getInt("sid"));//
		dbosubdata.setTitle(rs.getString("title"));//
		dbosubdata.setContent(rs.getString("content"));//
		dbosubdata.setPic(rs.getString("pic"));//
		dbosubdata.setLink(rs.getString("link"));//
		dbosubdata.setCtitle(rs.getString("ctitle"));//目录名
		dbosubdata.setClink(rs.getString("clink"));//目录连接
		dbosubdata.setColor(rs.getString("color"));//控制标题颜色
		dbosubdata.setBold(rs.getInt("bold"));//标题是否加粗
		dbosubdata.setAdddate(rs.getTimestamp("adddate"));//
		dbosubdata.setIsdelete(rs.getInt("isdelete"));//
		dbosubdata.setSortid(rs.getInt("sortid"));//
		dbosubdata.setLink_back(rs.getString("link_back"));//
		dbosubdata.setClink_back(rs.getString("clink_back"));//
		dbosubdata.setIsad(rs.getInt("isad"));//是否是广告
		dbosubdata.setSync_id(rs.getInt("sync_id"));//
	}

	public static List<DboSubData> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_sub_data";
		List<DboSubData> list = new ArrayList<DboSubData>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboSubData dbosubdata = new DboSubData();
				fill(rs, dbosubdata);
				list.add(dbosubdata);
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


	public static List<DboSubData> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_sub_data where "+subsql+"";
		List<DboSubData> list = new ArrayList<DboSubData>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboSubData dbosubdata = new DboSubData();
				fill(rs, dbosubdata);
				list.add(dbosubdata);
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
		String sql = "select count(*) from dbo_sub_data where "+subsql+"";
		
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
		String sql = "delete from dbo_sub_data where "+subsql+"";
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
		String sql = "delete from dbo_sub_data where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboSubData dbosubdata) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_sub_data(`id`,`sid`,`title`,`content`,`pic`,`link`,`ctitle`,`clink`,`color`,`bold`,`adddate`,`isdelete`,`sortid`,`link_back`,`clink_back`,`isad`,`sync_id`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbosubdata.getId());
		dbc.setInt(2, dbosubdata.getSid());
		dbc.setString(3, dbosubdata.getTitle());
		dbc.setString(4, dbosubdata.getContent());
		dbc.setString(5, dbosubdata.getPic());
		dbc.setString(6, dbosubdata.getLink());
		dbc.setString(7, dbosubdata.getCtitle());
		dbc.setString(8, dbosubdata.getClink());
		dbc.setString(9, dbosubdata.getColor());
		dbc.setInt(10, dbosubdata.getBold());
		dbc.setTimestamp(11, new Timestamp(dbosubdata.getAdddate().getTime()));
		dbc.setInt(12, dbosubdata.getIsdelete());
		dbc.setInt(13, dbosubdata.getSortid());
		dbc.setString(14, dbosubdata.getLink_back());
		dbc.setString(15, dbosubdata.getClink_back());
		dbc.setInt(16, dbosubdata.getIsad());
		dbc.setInt(17, dbosubdata.getSync_id());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboSubData dbosubdata) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_sub_data(`id`,`sid`,`title`,`content`,`pic`,`link`,`ctitle`,`clink`,`color`,`bold`,`adddate`,`isdelete`,`sortid`,`link_back`,`clink_back`,`isad`,`sync_id`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbosubdata.getId());
		dbc.setInt(2, dbosubdata.getSid());
		dbc.setString(3, dbosubdata.getTitle());
		dbc.setString(4, dbosubdata.getContent());
		dbc.setString(5, dbosubdata.getPic());
		dbc.setString(6, dbosubdata.getLink());
		dbc.setString(7, dbosubdata.getCtitle());
		dbc.setString(8, dbosubdata.getClink());
		dbc.setString(9, dbosubdata.getColor());
		dbc.setInt(10, dbosubdata.getBold());
		dbc.setTimestamp(11, new Timestamp(dbosubdata.getAdddate().getTime()));
		dbc.setInt(12, dbosubdata.getIsdelete());
		dbc.setInt(13, dbosubdata.getSortid());
		dbc.setString(14, dbosubdata.getLink_back());
		dbc.setString(15, dbosubdata.getClink_back());
		dbc.setInt(16, dbosubdata.getIsad());
		dbc.setInt(17, dbosubdata.getSync_id());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboSubData dbosubdata) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_sub_data set ");
		boolean flag = false;
		if(dbosubdata.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbosubdata.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",sid=?");
			}else{
				sb.append("sid=?");
				flag=true;
			}
		}
		if(dbosubdata.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",title=?");
			}else{
				sb.append("title=?");
				flag=true;
			}
		}
		if(dbosubdata.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",content=?");
			}else{
				sb.append("content=?");
				flag=true;
			}
		}
		if(dbosubdata.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",pic=?");
			}else{
				sb.append("pic=?");
				flag=true;
			}
		}
		if(dbosubdata.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",link=?");
			}else{
				sb.append("link=?");
				flag=true;
			}
		}
		if(dbosubdata.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",ctitle=?");
			}else{
				sb.append("ctitle=?");
				flag=true;
			}
		}
		if(dbosubdata.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",clink=?");
			}else{
				sb.append("clink=?");
				flag=true;
			}
		}
		if(dbosubdata.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",color=?");
			}else{
				sb.append("color=?");
				flag=true;
			}
		}
		if(dbosubdata.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",bold=?");
			}else{
				sb.append("bold=?");
				flag=true;
			}
		}
		if(dbosubdata.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbosubdata.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dbosubdata.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",sortid=?");
			}else{
				sb.append("sortid=?");
				flag=true;
			}
		}
		if(dbosubdata.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",link_back=?");
			}else{
				sb.append("link_back=?");
				flag=true;
			}
		}
		if(dbosubdata.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",clink_back=?");
			}else{
				sb.append("clink_back=?");
				flag=true;
			}
		}
		if(dbosubdata.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",isad=?");
			}else{
				sb.append("isad=?");
				flag=true;
			}
		}
		if(dbosubdata.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",sync_id=?");
			}else{
				sb.append("sync_id=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbosubdata.COLUMN_FLAG[0]){
			dbc.setInt(k, dbosubdata.getId());k++;
		}
		if(dbosubdata.COLUMN_FLAG[1]){
			dbc.setInt(k, dbosubdata.getSid());k++;
		}
		if(dbosubdata.COLUMN_FLAG[2]){
			dbc.setString(k, dbosubdata.getTitle());k++;
		}
		if(dbosubdata.COLUMN_FLAG[3]){
			dbc.setString(k, dbosubdata.getContent());k++;
		}
		if(dbosubdata.COLUMN_FLAG[4]){
			dbc.setString(k, dbosubdata.getPic());k++;
		}
		if(dbosubdata.COLUMN_FLAG[5]){
			dbc.setString(k, dbosubdata.getLink());k++;
		}
		if(dbosubdata.COLUMN_FLAG[6]){
			dbc.setString(k, dbosubdata.getCtitle());k++;
		}
		if(dbosubdata.COLUMN_FLAG[7]){
			dbc.setString(k, dbosubdata.getClink());k++;
		}
		if(dbosubdata.COLUMN_FLAG[8]){
			dbc.setString(k, dbosubdata.getColor());k++;
		}
		if(dbosubdata.COLUMN_FLAG[9]){
			dbc.setInt(k, dbosubdata.getBold());k++;
		}
		if(dbosubdata.COLUMN_FLAG[10]){
			dbc.setTimestamp(k, new Timestamp(dbosubdata.getAdddate().getTime()));k++;
		}
		if(dbosubdata.COLUMN_FLAG[11]){
			dbc.setInt(k, dbosubdata.getIsdelete());k++;
		}
		if(dbosubdata.COLUMN_FLAG[12]){
			dbc.setInt(k, dbosubdata.getSortid());k++;
		}
		if(dbosubdata.COLUMN_FLAG[13]){
			dbc.setString(k, dbosubdata.getLink_back());k++;
		}
		if(dbosubdata.COLUMN_FLAG[14]){
			dbc.setString(k, dbosubdata.getClink_back());k++;
		}
		if(dbosubdata.COLUMN_FLAG[15]){
			dbc.setInt(k, dbosubdata.getIsad());k++;
		}
		if(dbosubdata.COLUMN_FLAG[16]){
			dbc.setInt(k, dbosubdata.getSync_id());k++;
		}
		dbc.setInt(k, dbosubdata.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboSubData dbosubdata) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbosubdata);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}