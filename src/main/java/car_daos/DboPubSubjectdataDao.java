package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboPubSubjectdata;

public class  DboPubSubjectdataDao  extends BaseDao {

	public static void fill(ResultSet rs, DboPubSubjectdata dbopubsubjectdata) throws SQLException {
		dbopubsubjectdata.setDataid(rs.getInt("dataid"));//数据id
		dbopubsubjectdata.setSid(rs.getInt("sid"));//专题id
		dbopubsubjectdata.setMid(rs.getInt("mid"));//模板id
		dbopubsubjectdata.setPhoto(rs.getString("photo"));//图片
		dbopubsubjectdata.setPhotourl(rs.getString("photourl"));//图片链接
		dbopubsubjectdata.setPhotoclass(rs.getString("photoclass"));//图片样式
		dbopubsubjectdata.setText(rs.getString("text"));//文字
		dbopubsubjectdata.setTexturl(rs.getString("texturl"));//文字链接
		dbopubsubjectdata.setTextclass(rs.getString("textclass"));//文字样式
		dbopubsubjectdata.setTitle(rs.getString("title"));//标题
		dbopubsubjectdata.setTitleurl(rs.getString("titleurl"));//标题链接
		dbopubsubjectdata.setTitleclass(rs.getString("titleclass"));//标题样式
	}

	public static List<DboPubSubjectdata> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_pub_subjectdata";
		List<DboPubSubjectdata> list = new ArrayList<DboPubSubjectdata>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboPubSubjectdata dbopubsubjectdata = new DboPubSubjectdata();
				fill(rs, dbopubsubjectdata);
				list.add(dbopubsubjectdata);
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


	public static List<DboPubSubjectdata> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_pub_subjectdata where "+subsql+"";
		List<DboPubSubjectdata> list = new ArrayList<DboPubSubjectdata>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboPubSubjectdata dbopubsubjectdata = new DboPubSubjectdata();
				fill(rs, dbopubsubjectdata);
				list.add(dbopubsubjectdata);
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
		String sql = "select count(*) from dbo_pub_subjectdata where "+subsql+"";
		
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
		String sql = "delete from dbo_pub_subjectdata where "+subsql+"";
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
		String sql = "delete from dbo_pub_subjectdata where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboPubSubjectdata dbopubsubjectdata) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_pub_subjectdata(`dataid`,`sid`,`mid`,`photo`,`photourl`,`photoclass`,`text`,`texturl`,`textclass`,`title`,`titleurl`,`titleclass`) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbopubsubjectdata.getDataid());
		dbc.setInt(2, dbopubsubjectdata.getSid());
		dbc.setInt(3, dbopubsubjectdata.getMid());
		dbc.setString(4, dbopubsubjectdata.getPhoto());
		dbc.setString(5, dbopubsubjectdata.getPhotourl());
		dbc.setString(6, dbopubsubjectdata.getPhotoclass());
		dbc.setString(7, dbopubsubjectdata.getText());
		dbc.setString(8, dbopubsubjectdata.getTexturl());
		dbc.setString(9, dbopubsubjectdata.getTextclass());
		dbc.setString(10, dbopubsubjectdata.getTitle());
		dbc.setString(11, dbopubsubjectdata.getTitleurl());
		dbc.setString(12, dbopubsubjectdata.getTitleclass());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboPubSubjectdata dbopubsubjectdata) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_pub_subjectdata(`dataid`,`sid`,`mid`,`photo`,`photourl`,`photoclass`,`text`,`texturl`,`textclass`,`title`,`titleurl`,`titleclass`) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbopubsubjectdata.getDataid());
		dbc.setInt(2, dbopubsubjectdata.getSid());
		dbc.setInt(3, dbopubsubjectdata.getMid());
		dbc.setString(4, dbopubsubjectdata.getPhoto());
		dbc.setString(5, dbopubsubjectdata.getPhotourl());
		dbc.setString(6, dbopubsubjectdata.getPhotoclass());
		dbc.setString(7, dbopubsubjectdata.getText());
		dbc.setString(8, dbopubsubjectdata.getTexturl());
		dbc.setString(9, dbopubsubjectdata.getTextclass());
		dbc.setString(10, dbopubsubjectdata.getTitle());
		dbc.setString(11, dbopubsubjectdata.getTitleurl());
		dbc.setString(12, dbopubsubjectdata.getTitleclass());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboPubSubjectdata dbopubsubjectdata) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_pub_subjectdata set ");
		boolean flag = false;
		if(dbopubsubjectdata.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",dataid=?");
			}else{
				sb.append("dataid=?");
				flag=true;
			}
		}
		if(dbopubsubjectdata.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",sid=?");
			}else{
				sb.append("sid=?");
				flag=true;
			}
		}
		if(dbopubsubjectdata.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",mid=?");
			}else{
				sb.append("mid=?");
				flag=true;
			}
		}
		if(dbopubsubjectdata.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",photo=?");
			}else{
				sb.append("photo=?");
				flag=true;
			}
		}
		if(dbopubsubjectdata.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",photourl=?");
			}else{
				sb.append("photourl=?");
				flag=true;
			}
		}
		if(dbopubsubjectdata.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",photoclass=?");
			}else{
				sb.append("photoclass=?");
				flag=true;
			}
		}
		if(dbopubsubjectdata.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",text=?");
			}else{
				sb.append("text=?");
				flag=true;
			}
		}
		if(dbopubsubjectdata.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",texturl=?");
			}else{
				sb.append("texturl=?");
				flag=true;
			}
		}
		if(dbopubsubjectdata.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",textclass=?");
			}else{
				sb.append("textclass=?");
				flag=true;
			}
		}
		if(dbopubsubjectdata.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",title=?");
			}else{
				sb.append("title=?");
				flag=true;
			}
		}
		if(dbopubsubjectdata.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",titleurl=?");
			}else{
				sb.append("titleurl=?");
				flag=true;
			}
		}
		if(dbopubsubjectdata.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",titleclass=?");
			}else{
				sb.append("titleclass=?");
				flag=true;
			}
		}
		sb.append(" where dataid=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbopubsubjectdata.COLUMN_FLAG[0]){
			dbc.setInt(k, dbopubsubjectdata.getDataid());k++;
		}
		if(dbopubsubjectdata.COLUMN_FLAG[1]){
			dbc.setInt(k, dbopubsubjectdata.getSid());k++;
		}
		if(dbopubsubjectdata.COLUMN_FLAG[2]){
			dbc.setInt(k, dbopubsubjectdata.getMid());k++;
		}
		if(dbopubsubjectdata.COLUMN_FLAG[3]){
			dbc.setString(k, dbopubsubjectdata.getPhoto());k++;
		}
		if(dbopubsubjectdata.COLUMN_FLAG[4]){
			dbc.setString(k, dbopubsubjectdata.getPhotourl());k++;
		}
		if(dbopubsubjectdata.COLUMN_FLAG[5]){
			dbc.setString(k, dbopubsubjectdata.getPhotoclass());k++;
		}
		if(dbopubsubjectdata.COLUMN_FLAG[6]){
			dbc.setString(k, dbopubsubjectdata.getText());k++;
		}
		if(dbopubsubjectdata.COLUMN_FLAG[7]){
			dbc.setString(k, dbopubsubjectdata.getTexturl());k++;
		}
		if(dbopubsubjectdata.COLUMN_FLAG[8]){
			dbc.setString(k, dbopubsubjectdata.getTextclass());k++;
		}
		if(dbopubsubjectdata.COLUMN_FLAG[9]){
			dbc.setString(k, dbopubsubjectdata.getTitle());k++;
		}
		if(dbopubsubjectdata.COLUMN_FLAG[10]){
			dbc.setString(k, dbopubsubjectdata.getTitleurl());k++;
		}
		if(dbopubsubjectdata.COLUMN_FLAG[11]){
			dbc.setString(k, dbopubsubjectdata.getTitleclass());k++;
		}
		dbc.setInt(k, dbopubsubjectdata.getDataid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboPubSubjectdata dbopubsubjectdata) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbopubsubjectdata);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}