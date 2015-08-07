package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboImgTitle;

public class  DboImgTitleDao  extends BaseDao {

	public static void fill(ResultSet rs, DboImgTitle dboimgtitle) throws SQLException {
		dboimgtitle.setId(rs.getInt("id"));//自动增长id
		dboimgtitle.setCatalogid(rs.getInt("catalogid"));//目录id
		dboimgtitle.setQqcatalogid(rs.getInt("qqcatalogid"));//腾讯车型目录id
		dboimgtitle.setType(rs.getInt("type"));//车型类别（0表示非车型）
		dboimgtitle.setTitle(rs.getString("title"));//标题
		dboimgtitle.setKeywords(rs.getString("keywords"));//关键字
		dboimgtitle.setAddadmin(rs.getString("addadmin"));//添加操作管理员用户名
		dboimgtitle.setUpdateadmin(rs.getString("updateadmin"));//修改操作管理员用户名
		dboimgtitle.setDeladmin(rs.getString("deladmin"));//删除操作管理员用户名
		dboimgtitle.setAdddate(rs.getTimestamp("adddate"));//添加时间
		dboimgtitle.setLastupdate(rs.getTimestamp("lastupdate"));//最后修改时间
		dboimgtitle.setIsdelete(rs.getInt("isdelete"));//0正常
		dboimgtitle.setBackcatalogid(rs.getInt("backcatalogid"));//
		dboimgtitle.setNiankuan(rs.getInt("niankuan"));//
		dboimgtitle.setPailiang(rs.getInt("pailiang"));//
		dboimgtitle.setXiangti(rs.getInt("xiangti"));//
		dboimgtitle.setBiansu(rs.getInt("biansu"));//
		dboimgtitle.setColor(rs.getString("color"));//
	}

	public static List<DboImgTitle> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_img_title";
		List<DboImgTitle> list = new ArrayList<DboImgTitle>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboImgTitle dboimgtitle = new DboImgTitle();
				fill(rs, dboimgtitle);
				list.add(dboimgtitle);
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


	public static List<DboImgTitle> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_img_title where "+subsql+"";
		List<DboImgTitle> list = new ArrayList<DboImgTitle>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboImgTitle dboimgtitle = new DboImgTitle();
				fill(rs, dboimgtitle);
				list.add(dboimgtitle);
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
		String sql = "select count(*) from dbo_img_title where "+subsql+"";
		
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
		String sql = "delete from dbo_img_title where "+subsql+"";
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
		String sql = "delete from dbo_img_title where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboImgTitle dboimgtitle) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_img_title(`id`,`catalogid`,`qqcatalogid`,`type`,`title`,`keywords`,`addadmin`,`updateadmin`,`deladmin`,`adddate`,`lastupdate`,`isdelete`,`backcatalogid`,`niankuan`,`pailiang`,`xiangti`,`biansu`,`color`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboimgtitle.getId());
		dbc.setInt(2, dboimgtitle.getCatalogid());
		dbc.setInt(3, dboimgtitle.getQqcatalogid());
		dbc.setInt(4, dboimgtitle.getType());
		dbc.setString(5, dboimgtitle.getTitle());
		dbc.setString(6, dboimgtitle.getKeywords());
		dbc.setString(7, dboimgtitle.getAddadmin());
		dbc.setString(8, dboimgtitle.getUpdateadmin());
		dbc.setString(9, dboimgtitle.getDeladmin());
		dbc.setTimestamp(10, new Timestamp(dboimgtitle.getAdddate().getTime()));
		dbc.setTimestamp(11, new Timestamp(dboimgtitle.getLastupdate().getTime()));
		dbc.setInt(12, dboimgtitle.getIsdelete());
		dbc.setInt(13, dboimgtitle.getBackcatalogid());
		dbc.setInt(14, dboimgtitle.getNiankuan());
		dbc.setInt(15, dboimgtitle.getPailiang());
		dbc.setInt(16, dboimgtitle.getXiangti());
		dbc.setInt(17, dboimgtitle.getBiansu());
		dbc.setString(18, dboimgtitle.getColor());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboImgTitle dboimgtitle) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_img_title(`id`,`catalogid`,`qqcatalogid`,`type`,`title`,`keywords`,`addadmin`,`updateadmin`,`deladmin`,`adddate`,`lastupdate`,`isdelete`,`backcatalogid`,`niankuan`,`pailiang`,`xiangti`,`biansu`,`color`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboimgtitle.getId());
		dbc.setInt(2, dboimgtitle.getCatalogid());
		dbc.setInt(3, dboimgtitle.getQqcatalogid());
		dbc.setInt(4, dboimgtitle.getType());
		dbc.setString(5, dboimgtitle.getTitle());
		dbc.setString(6, dboimgtitle.getKeywords());
		dbc.setString(7, dboimgtitle.getAddadmin());
		dbc.setString(8, dboimgtitle.getUpdateadmin());
		dbc.setString(9, dboimgtitle.getDeladmin());
		dbc.setTimestamp(10, new Timestamp(dboimgtitle.getAdddate().getTime()));
		dbc.setTimestamp(11, new Timestamp(dboimgtitle.getLastupdate().getTime()));
		dbc.setInt(12, dboimgtitle.getIsdelete());
		dbc.setInt(13, dboimgtitle.getBackcatalogid());
		dbc.setInt(14, dboimgtitle.getNiankuan());
		dbc.setInt(15, dboimgtitle.getPailiang());
		dbc.setInt(16, dboimgtitle.getXiangti());
		dbc.setInt(17, dboimgtitle.getBiansu());
		dbc.setString(18, dboimgtitle.getColor());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboImgTitle dboimgtitle) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_img_title set ");
		boolean flag = false;
		if(dboimgtitle.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dboimgtitle.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",catalogid=?");
			}else{
				sb.append("catalogid=?");
				flag=true;
			}
		}
		if(dboimgtitle.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",qqcatalogid=?");
			}else{
				sb.append("qqcatalogid=?");
				flag=true;
			}
		}
		if(dboimgtitle.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",type=?");
			}else{
				sb.append("type=?");
				flag=true;
			}
		}
		if(dboimgtitle.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",title=?");
			}else{
				sb.append("title=?");
				flag=true;
			}
		}
		if(dboimgtitle.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",keywords=?");
			}else{
				sb.append("keywords=?");
				flag=true;
			}
		}
		if(dboimgtitle.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",addadmin=?");
			}else{
				sb.append("addadmin=?");
				flag=true;
			}
		}
		if(dboimgtitle.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",updateadmin=?");
			}else{
				sb.append("updateadmin=?");
				flag=true;
			}
		}
		if(dboimgtitle.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",deladmin=?");
			}else{
				sb.append("deladmin=?");
				flag=true;
			}
		}
		if(dboimgtitle.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dboimgtitle.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",lastupdate=?");
			}else{
				sb.append("lastupdate=?");
				flag=true;
			}
		}
		if(dboimgtitle.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dboimgtitle.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",backcatalogid=?");
			}else{
				sb.append("backcatalogid=?");
				flag=true;
			}
		}
		if(dboimgtitle.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",niankuan=?");
			}else{
				sb.append("niankuan=?");
				flag=true;
			}
		}
		if(dboimgtitle.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",pailiang=?");
			}else{
				sb.append("pailiang=?");
				flag=true;
			}
		}
		if(dboimgtitle.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",xiangti=?");
			}else{
				sb.append("xiangti=?");
				flag=true;
			}
		}
		if(dboimgtitle.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",biansu=?");
			}else{
				sb.append("biansu=?");
				flag=true;
			}
		}
		if(dboimgtitle.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",color=?");
			}else{
				sb.append("color=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dboimgtitle.COLUMN_FLAG[0]){
			dbc.setInt(k, dboimgtitle.getId());k++;
		}
		if(dboimgtitle.COLUMN_FLAG[1]){
			dbc.setInt(k, dboimgtitle.getCatalogid());k++;
		}
		if(dboimgtitle.COLUMN_FLAG[2]){
			dbc.setInt(k, dboimgtitle.getQqcatalogid());k++;
		}
		if(dboimgtitle.COLUMN_FLAG[3]){
			dbc.setInt(k, dboimgtitle.getType());k++;
		}
		if(dboimgtitle.COLUMN_FLAG[4]){
			dbc.setString(k, dboimgtitle.getTitle());k++;
		}
		if(dboimgtitle.COLUMN_FLAG[5]){
			dbc.setString(k, dboimgtitle.getKeywords());k++;
		}
		if(dboimgtitle.COLUMN_FLAG[6]){
			dbc.setString(k, dboimgtitle.getAddadmin());k++;
		}
		if(dboimgtitle.COLUMN_FLAG[7]){
			dbc.setString(k, dboimgtitle.getUpdateadmin());k++;
		}
		if(dboimgtitle.COLUMN_FLAG[8]){
			dbc.setString(k, dboimgtitle.getDeladmin());k++;
		}
		if(dboimgtitle.COLUMN_FLAG[9]){
			dbc.setTimestamp(k, new Timestamp(dboimgtitle.getAdddate().getTime()));k++;
		}
		if(dboimgtitle.COLUMN_FLAG[10]){
			dbc.setTimestamp(k, new Timestamp(dboimgtitle.getLastupdate().getTime()));k++;
		}
		if(dboimgtitle.COLUMN_FLAG[11]){
			dbc.setInt(k, dboimgtitle.getIsdelete());k++;
		}
		if(dboimgtitle.COLUMN_FLAG[12]){
			dbc.setInt(k, dboimgtitle.getBackcatalogid());k++;
		}
		if(dboimgtitle.COLUMN_FLAG[13]){
			dbc.setInt(k, dboimgtitle.getNiankuan());k++;
		}
		if(dboimgtitle.COLUMN_FLAG[14]){
			dbc.setInt(k, dboimgtitle.getPailiang());k++;
		}
		if(dboimgtitle.COLUMN_FLAG[15]){
			dbc.setInt(k, dboimgtitle.getXiangti());k++;
		}
		if(dboimgtitle.COLUMN_FLAG[16]){
			dbc.setInt(k, dboimgtitle.getBiansu());k++;
		}
		if(dboimgtitle.COLUMN_FLAG[17]){
			dbc.setString(k, dboimgtitle.getColor());k++;
		}
		dbc.setInt(k, dboimgtitle.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboImgTitle dboimgtitle) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dboimgtitle);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}