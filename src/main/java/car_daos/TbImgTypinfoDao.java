package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbImgTypinfo;

public class  TbImgTypinfoDao  extends BaseDao {

	public static void fill(ResultSet rs, TbImgTypinfo tbimgtypinfo) throws SQLException {
		tbimgtypinfo.setId(rs.getInt("id"));//
		tbimgtypinfo.setName(rs.getString("name"));//
		tbimgtypinfo.setType(rs.getInt("type"));//
	}

	public static List<TbImgTypinfo> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_img_typinfo";
		List<TbImgTypinfo> list = new ArrayList<TbImgTypinfo>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbImgTypinfo tbimgtypinfo = new TbImgTypinfo();
				fill(rs, tbimgtypinfo);
				list.add(tbimgtypinfo);
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


	public static List<TbImgTypinfo> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_img_typinfo where "+subsql+"";
		List<TbImgTypinfo> list = new ArrayList<TbImgTypinfo>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbImgTypinfo tbimgtypinfo = new TbImgTypinfo();
				fill(rs, tbimgtypinfo);
				list.add(tbimgtypinfo);
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
		String sql = "select count(*) from tb_img_typinfo where "+subsql+"";
		
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
		String sql = "delete from tb_img_typinfo where "+subsql+"";
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
		String sql = "delete from tb_img_typinfo where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbImgTypinfo tbimgtypinfo) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_img_typinfo(`id`,`name`,`type`) values(?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbimgtypinfo.getId());
		dbc.setString(2, tbimgtypinfo.getName());
		dbc.setInt(3, tbimgtypinfo.getType());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbImgTypinfo tbimgtypinfo) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_img_typinfo(`id`,`name`,`type`) values(?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbimgtypinfo.getId());
		dbc.setString(2, tbimgtypinfo.getName());
		dbc.setInt(3, tbimgtypinfo.getType());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbImgTypinfo tbimgtypinfo) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_img_typinfo set ");
		boolean flag = false;
		if(tbimgtypinfo.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(tbimgtypinfo.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",name=?");
			}else{
				sb.append("name=?");
				flag=true;
			}
		}
		if(tbimgtypinfo.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",type=?");
			}else{
				sb.append("type=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbimgtypinfo.COLUMN_FLAG[0]){
			dbc.setInt(k, tbimgtypinfo.getId());k++;
		}
		if(tbimgtypinfo.COLUMN_FLAG[1]){
			dbc.setString(k, tbimgtypinfo.getName());k++;
		}
		if(tbimgtypinfo.COLUMN_FLAG[2]){
			dbc.setInt(k, tbimgtypinfo.getType());k++;
		}
		dbc.setInt(k, tbimgtypinfo.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbImgTypinfo tbimgtypinfo) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbimgtypinfo);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}