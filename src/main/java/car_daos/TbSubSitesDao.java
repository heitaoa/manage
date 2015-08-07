package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbSubSites;

public class  TbSubSitesDao  extends BaseDao {

	public static void fill(ResultSet rs, TbSubSites tbsubsites) throws SQLException {
		tbsubsites.setId(rs.getInt("id"));//
		tbsubsites.setName(rs.getString("name"));//��վ����
		tbsubsites.setAreaid(rs.getInt("areaid"));//��վ���ڵĵ��򣬹���dbo_are_catalog.catalogid
		tbsubsites.setEname(rs.getString("ename"));
	}

	public static List<TbSubSites> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_sub_sites";
		List<TbSubSites> list = new ArrayList<TbSubSites>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbSubSites tbsubsites = new TbSubSites();
				fill(rs, tbsubsites);
				list.add(tbsubsites);
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


	public static List<TbSubSites> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_sub_sites where "+subsql+"";
		List<TbSubSites> list = new ArrayList<TbSubSites>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbSubSites tbsubsites = new TbSubSites();
				fill(rs, tbsubsites);
				list.add(tbsubsites);
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
		String sql = "select count(*) from tb_sub_sites where "+subsql+"";
		
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
		String sql = "delete from tb_sub_sites where "+subsql+"";
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
		String sql = "delete from tb_sub_sites where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbSubSites tbsubsites) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_sub_sites(`id`,`name`,`areaid`,`ename`) values(?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbsubsites.getId());
		dbc.setString(2, tbsubsites.getName());
		dbc.setInt(3, tbsubsites.getAreaid());
		dbc.setString(4, tbsubsites.getEname());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbSubSites tbsubsites) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_sub_sites(`id`,`name`,`areaid`,'ename') values(?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbsubsites.getId());
		dbc.setString(2, tbsubsites.getName());
		dbc.setInt(3, tbsubsites.getAreaid());
		dbc.setString(4, tbsubsites.getEname());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbSubSites tbsubsites) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_sub_sites set ");
		boolean flag = false;
		if(tbsubsites.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(tbsubsites.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",name=?");
			}else{
				sb.append("name=?");
				flag=true;
			}
		}
		if(tbsubsites.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",areaid=?");
			}else{
				sb.append("areaid=?");
				flag=true;
			}
		}
		if(tbsubsites.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",ename=?");
			}else{
				sb.append("ename=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbsubsites.COLUMN_FLAG[0]){
			dbc.setInt(k, tbsubsites.getId());k++;
		}
		if(tbsubsites.COLUMN_FLAG[1]){
			dbc.setString(k, tbsubsites.getName());k++;
		}
		if(tbsubsites.COLUMN_FLAG[2]){
			dbc.setInt(k, tbsubsites.getAreaid());k++;
		}
		if(tbsubsites.COLUMN_FLAG[3]){
			dbc.setString(k, tbsubsites.getEname());k++;
		}
		dbc.setInt(k, tbsubsites.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbSubSites tbsubsites) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbsubsites);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}