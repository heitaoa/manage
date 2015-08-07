package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbUsers;

public class  TbUsersDao  extends BaseDao {

	public static void fill(ResultSet rs, TbUsers tbusers) throws SQLException {
		tbusers.setId(rs.getInt("id"));//
		tbusers.setUserid(rs.getString("userid"));//用户名
		tbusers.setIsdelete(rs.getInt("isdelete"));//用户状态 0-使用 1-删除
		tbusers.setProv(rs.getInt("prov"));//分管地域 -省
		tbusers.setCity(rs.getInt("city"));//分管地域-市
		tbusers.setBrands(rs.getString("brands"));//分管品牌
		tbusers.setAddtime(rs.getTimestamp("addtime"));//添加时间
		tbusers.setUlevel(rs.getString("ulevel"));//用户权限  0-系统管理员 1-大客户回访人员  2-客服 3-销售  4-总站编辑 5-分站编辑  6-分站管理员
		tbusers.setDetail(rs.getString("detail"));//
	}

	public static List<TbUsers> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_users";
		List<TbUsers> list = new ArrayList<TbUsers>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbUsers tbusers = new TbUsers();
				fill(rs, tbusers);
				list.add(tbusers);
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


	public static List<TbUsers> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_users where "+subsql+"";
		List<TbUsers> list = new ArrayList<TbUsers>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbUsers tbusers = new TbUsers();
				fill(rs, tbusers);
				list.add(tbusers);
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
		String sql = "select count(*) from tb_users where "+subsql+"";
		
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
		String sql = "delete from tb_users where "+subsql+"";
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
		String sql = "delete from tb_users where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbUsers tbusers) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_users(`id`,`userid`,`isdelete`,`prov`,`city`,`brands`,`addtime`,`ulevel`,`detail`) values(?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbusers.getId());
		dbc.setString(2, tbusers.getUserid());
		dbc.setInt(3, tbusers.getIsdelete());
		dbc.setInt(4, tbusers.getProv());
		dbc.setInt(5, tbusers.getCity());
		dbc.setString(6, tbusers.getBrands());
		dbc.setTimestamp(7, new Timestamp(tbusers.getAddtime().getTime()));
		dbc.setString(8, tbusers.getUlevel());
		dbc.setString(9, tbusers.getDetail());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbUsers tbusers) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_users(`id`,`userid`,`isdelete`,`prov`,`city`,`brands`,`addtime`,`ulevel`,`detail`) values(?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbusers.getId());
		dbc.setString(2, tbusers.getUserid());
		dbc.setInt(3, tbusers.getIsdelete());
		dbc.setInt(4, tbusers.getProv());
		dbc.setInt(5, tbusers.getCity());
		dbc.setString(6, tbusers.getBrands());
		dbc.setTimestamp(7, new Timestamp(tbusers.getAddtime().getTime()));
		dbc.setString(8, tbusers.getUlevel());
		dbc.setString(9, tbusers.getDetail());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbUsers tbusers) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_users set ");
		boolean flag = false;
		if(tbusers.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(tbusers.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",userid=?");
			}else{
				sb.append("userid=?");
				flag=true;
			}
		}
		if(tbusers.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(tbusers.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",prov=?");
			}else{
				sb.append("prov=?");
				flag=true;
			}
		}
		if(tbusers.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",city=?");
			}else{
				sb.append("city=?");
				flag=true;
			}
		}
		if(tbusers.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",brands=?");
			}else{
				sb.append("brands=?");
				flag=true;
			}
		}
		if(tbusers.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",addtime=?");
			}else{
				sb.append("addtime=?");
				flag=true;
			}
		}
		if(tbusers.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",ulevel=?");
			}else{
				sb.append("ulevel=?");
				flag=true;
			}
		}
		if(tbusers.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",detail=?");
			}else{
				sb.append("detail=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbusers.COLUMN_FLAG[0]){
			dbc.setInt(k, tbusers.getId());k++;
		}
		if(tbusers.COLUMN_FLAG[1]){
			dbc.setString(k, tbusers.getUserid());k++;
		}
		if(tbusers.COLUMN_FLAG[2]){
			dbc.setInt(k, tbusers.getIsdelete());k++;
		}
		if(tbusers.COLUMN_FLAG[3]){
			dbc.setInt(k, tbusers.getProv());k++;
		}
		if(tbusers.COLUMN_FLAG[4]){
			dbc.setInt(k, tbusers.getCity());k++;
		}
		if(tbusers.COLUMN_FLAG[5]){
			dbc.setString(k, tbusers.getBrands());k++;
		}
		if(tbusers.COLUMN_FLAG[6]){
			dbc.setTimestamp(k, new Timestamp(tbusers.getAddtime().getTime()));k++;
		}
		if(tbusers.COLUMN_FLAG[7]){
			dbc.setString(k, tbusers.getUlevel());k++;
		}
		if(tbusers.COLUMN_FLAG[8]){
			dbc.setString(k, tbusers.getDetail());k++;
		}
		dbc.setInt(k, tbusers.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbUsers tbusers) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbusers);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}