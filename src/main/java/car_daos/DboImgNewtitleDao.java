package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboImgNewtitle;

public class  DboImgNewtitleDao  extends BaseDao {

	public static void fill(ResultSet rs, DboImgNewtitle dboimgnewtitle) throws SQLException {
		dboimgnewtitle.setId(rs.getInt("id"));//自动增长id
		dboimgnewtitle.setCatalogid(rs.getInt("catalogid"));//目录id
		dboimgnewtitle.setTotop(rs.getInt("totop"));//被顶次数
		dboimgnewtitle.setTosink(rs.getInt("tosink"));//被踩次数
		dboimgnewtitle.setToptime(rs.getTimestamp("toptime"));//最后被顶时间
		dboimgnewtitle.setSinktime(rs.getTimestamp("sinktime"));//最后被踩时间
		dboimgnewtitle.setContentid(rs.getInt("contentid"));//默认的图片内容id
		dboimgnewtitle.setQqcatalogid(rs.getInt("qqcatalogid"));//腾讯车型目录id
		dboimgnewtitle.setType(rs.getInt("type"));//车型类别（0表示非车型）
		dboimgnewtitle.setIsdelete(rs.getInt("isdelete"));//0正常
		dboimgnewtitle.setTitle(rs.getString("title"));//标题
		dboimgnewtitle.setKeywords(rs.getString("keywords"));//关键字
		dboimgnewtitle.setAddadmin(rs.getString("addadmin"));//添加操作管理员用户名
		dboimgnewtitle.setUpdateadmin(rs.getString("updateadmin"));//修改操作管理员用户名
		dboimgnewtitle.setDeladmin(rs.getString("deladmin"));//删除操作管理员用户名
		dboimgnewtitle.setAdddate(rs.getTimestamp("adddate"));//添加时间
		dboimgnewtitle.setLastupdate(rs.getTimestamp("lastupdate"));//最后修改时间
	}

	public static List<DboImgNewtitle> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_img_newtitle";
		List<DboImgNewtitle> list = new ArrayList<DboImgNewtitle>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboImgNewtitle dboimgnewtitle = new DboImgNewtitle();
				fill(rs, dboimgnewtitle);
				list.add(dboimgnewtitle);
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


	public static List<DboImgNewtitle> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_img_newtitle where "+subsql+"";
		List<DboImgNewtitle> list = new ArrayList<DboImgNewtitle>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboImgNewtitle dboimgnewtitle = new DboImgNewtitle();
				fill(rs, dboimgnewtitle);
				list.add(dboimgnewtitle);
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
		String sql = "select count(*) from dbo_img_newtitle where "+subsql+"";
		
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
		String sql = "delete from dbo_img_newtitle where "+subsql+"";
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
		String sql = "delete from dbo_img_newtitle where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboImgNewtitle dboimgnewtitle) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_img_newtitle(`id`,`catalogid`,`totop`,`tosink`,`toptime`,`sinktime`,`contentid`,`qqcatalogid`,`type`,`isdelete`,`title`,`keywords`,`addadmin`,`updateadmin`,`deladmin`,`adddate`,`lastupdate`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboimgnewtitle.getId());
		dbc.setInt(2, dboimgnewtitle.getCatalogid());
		dbc.setInt(3, dboimgnewtitle.getTotop());
		dbc.setInt(4, dboimgnewtitle.getTosink());
		dbc.setTimestamp(5, new Timestamp(dboimgnewtitle.getToptime().getTime()));
		dbc.setTimestamp(6, new Timestamp(dboimgnewtitle.getSinktime().getTime()));
		dbc.setInt(7, dboimgnewtitle.getContentid());
		dbc.setInt(8, dboimgnewtitle.getQqcatalogid());
		dbc.setInt(9, dboimgnewtitle.getType());
		dbc.setInt(10, dboimgnewtitle.getIsdelete());
		dbc.setString(11, dboimgnewtitle.getTitle());
		dbc.setString(12, dboimgnewtitle.getKeywords());
		dbc.setString(13, dboimgnewtitle.getAddadmin());
		dbc.setString(14, dboimgnewtitle.getUpdateadmin());
		dbc.setString(15, dboimgnewtitle.getDeladmin());
		dbc.setTimestamp(16, new Timestamp(dboimgnewtitle.getAdddate().getTime()));
		dbc.setTimestamp(17, new Timestamp(dboimgnewtitle.getLastupdate().getTime()));
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboImgNewtitle dboimgnewtitle) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_img_newtitle(`id`,`catalogid`,`totop`,`tosink`,`toptime`,`sinktime`,`contentid`,`qqcatalogid`,`type`,`isdelete`,`title`,`keywords`,`addadmin`,`updateadmin`,`deladmin`,`adddate`,`lastupdate`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboimgnewtitle.getId());
		dbc.setInt(2, dboimgnewtitle.getCatalogid());
		dbc.setInt(3, dboimgnewtitle.getTotop());
		dbc.setInt(4, dboimgnewtitle.getTosink());
		dbc.setTimestamp(5, new Timestamp(dboimgnewtitle.getToptime().getTime()));
		dbc.setTimestamp(6, new Timestamp(dboimgnewtitle.getSinktime().getTime()));
		dbc.setInt(7, dboimgnewtitle.getContentid());
		dbc.setInt(8, dboimgnewtitle.getQqcatalogid());
		dbc.setInt(9, dboimgnewtitle.getType());
		dbc.setInt(10, dboimgnewtitle.getIsdelete());
		dbc.setString(11, dboimgnewtitle.getTitle());
		dbc.setString(12, dboimgnewtitle.getKeywords());
		dbc.setString(13, dboimgnewtitle.getAddadmin());
		dbc.setString(14, dboimgnewtitle.getUpdateadmin());
		dbc.setString(15, dboimgnewtitle.getDeladmin());
		dbc.setTimestamp(16, new Timestamp(dboimgnewtitle.getAdddate().getTime()));
		dbc.setTimestamp(17, new Timestamp(dboimgnewtitle.getLastupdate().getTime()));
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboImgNewtitle dboimgnewtitle) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_img_newtitle set ");
		boolean flag = false;
		if(dboimgnewtitle.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dboimgnewtitle.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",catalogid=?");
			}else{
				sb.append("catalogid=?");
				flag=true;
			}
		}
		if(dboimgnewtitle.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",totop=?");
			}else{
				sb.append("totop=?");
				flag=true;
			}
		}
		if(dboimgnewtitle.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",tosink=?");
			}else{
				sb.append("tosink=?");
				flag=true;
			}
		}
		if(dboimgnewtitle.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",toptime=?");
			}else{
				sb.append("toptime=?");
				flag=true;
			}
		}
		if(dboimgnewtitle.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",sinktime=?");
			}else{
				sb.append("sinktime=?");
				flag=true;
			}
		}
		if(dboimgnewtitle.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",contentid=?");
			}else{
				sb.append("contentid=?");
				flag=true;
			}
		}
		if(dboimgnewtitle.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",qqcatalogid=?");
			}else{
				sb.append("qqcatalogid=?");
				flag=true;
			}
		}
		if(dboimgnewtitle.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",type=?");
			}else{
				sb.append("type=?");
				flag=true;
			}
		}
		if(dboimgnewtitle.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dboimgnewtitle.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",title=?");
			}else{
				sb.append("title=?");
				flag=true;
			}
		}
		if(dboimgnewtitle.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",keywords=?");
			}else{
				sb.append("keywords=?");
				flag=true;
			}
		}
		if(dboimgnewtitle.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",addadmin=?");
			}else{
				sb.append("addadmin=?");
				flag=true;
			}
		}
		if(dboimgnewtitle.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",updateadmin=?");
			}else{
				sb.append("updateadmin=?");
				flag=true;
			}
		}
		if(dboimgnewtitle.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",deladmin=?");
			}else{
				sb.append("deladmin=?");
				flag=true;
			}
		}
		if(dboimgnewtitle.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dboimgnewtitle.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",lastupdate=?");
			}else{
				sb.append("lastupdate=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dboimgnewtitle.COLUMN_FLAG[0]){
			dbc.setInt(k, dboimgnewtitle.getId());k++;
		}
		if(dboimgnewtitle.COLUMN_FLAG[1]){
			dbc.setInt(k, dboimgnewtitle.getCatalogid());k++;
		}
		if(dboimgnewtitle.COLUMN_FLAG[2]){
			dbc.setInt(k, dboimgnewtitle.getTotop());k++;
		}
		if(dboimgnewtitle.COLUMN_FLAG[3]){
			dbc.setInt(k, dboimgnewtitle.getTosink());k++;
		}
		if(dboimgnewtitle.COLUMN_FLAG[4]){
			dbc.setTimestamp(k, new Timestamp(dboimgnewtitle.getToptime().getTime()));k++;
		}
		if(dboimgnewtitle.COLUMN_FLAG[5]){
			dbc.setTimestamp(k, new Timestamp(dboimgnewtitle.getSinktime().getTime()));k++;
		}
		if(dboimgnewtitle.COLUMN_FLAG[6]){
			dbc.setInt(k, dboimgnewtitle.getContentid());k++;
		}
		if(dboimgnewtitle.COLUMN_FLAG[7]){
			dbc.setInt(k, dboimgnewtitle.getQqcatalogid());k++;
		}
		if(dboimgnewtitle.COLUMN_FLAG[8]){
			dbc.setInt(k, dboimgnewtitle.getType());k++;
		}
		if(dboimgnewtitle.COLUMN_FLAG[9]){
			dbc.setInt(k, dboimgnewtitle.getIsdelete());k++;
		}
		if(dboimgnewtitle.COLUMN_FLAG[10]){
			dbc.setString(k, dboimgnewtitle.getTitle());k++;
		}
		if(dboimgnewtitle.COLUMN_FLAG[11]){
			dbc.setString(k, dboimgnewtitle.getKeywords());k++;
		}
		if(dboimgnewtitle.COLUMN_FLAG[12]){
			dbc.setString(k, dboimgnewtitle.getAddadmin());k++;
		}
		if(dboimgnewtitle.COLUMN_FLAG[13]){
			dbc.setString(k, dboimgnewtitle.getUpdateadmin());k++;
		}
		if(dboimgnewtitle.COLUMN_FLAG[14]){
			dbc.setString(k, dboimgnewtitle.getDeladmin());k++;
		}
		if(dboimgnewtitle.COLUMN_FLAG[15]){
			dbc.setTimestamp(k, new Timestamp(dboimgnewtitle.getAdddate().getTime()));k++;
		}
		if(dboimgnewtitle.COLUMN_FLAG[16]){
			dbc.setTimestamp(k, new Timestamp(dboimgnewtitle.getLastupdate().getTime()));k++;
		}
		dbc.setInt(k, dboimgnewtitle.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboImgNewtitle dboimgnewtitle) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dboimgnewtitle);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}