package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboSubContent;

public class  DboSubContentDao  extends BaseDao {

	public static void fill(ResultSet rs, DboSubContent dbosubcontent) throws SQLException {
		dbosubcontent.setId(rs.getInt("id"));//
		dbosubcontent.setPname(rs.getString("pname"));//
		dbosubcontent.setPlace(rs.getString("place"));//
		dbosubcontent.setStype(rs.getInt("stype"));//#���ͣ�1|ҳ��ģ�飻2|ר��ģ�飻3|wap��4|315��5|315wap
		dbosubcontent.setHtmltype(rs.getInt("htmltype"));//�����ļ����ͣ�1|html��2|js��
		dbosubcontent.setHtmlname(rs.getString("htmlname"));//
		dbosubcontent.setIsdelete(rs.getInt("isdelete"));//
		dbosubcontent.setLastvisittime(rs.getTimestamp("lastvisittime"));//
		dbosubcontent.setDesc(rs.getString("desc"));//���༭����ע��
		dbosubcontent.setParent_id(rs.getInt("parent_id"));//��id��0|��ҳ��
		dbosubcontent.setTemplatename(rs.getString("templatename"));//
		dbosubcontent.setSub_sites_id(rs.getInt("sub_sites_id"));//�����ĸ���վ
		dbosubcontent.setSync_id(rs.getInt("sync_id"));//
	}

	public static List<DboSubContent> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_sub_content";
		List<DboSubContent> list = new ArrayList<DboSubContent>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboSubContent dbosubcontent = new DboSubContent();
				fill(rs, dbosubcontent);
				list.add(dbosubcontent);
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


	public static List<DboSubContent> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_sub_content where "+subsql+"";
		List<DboSubContent> list = new ArrayList<DboSubContent>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboSubContent dbosubcontent = new DboSubContent();
				fill(rs, dbosubcontent);
				list.add(dbosubcontent);
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
		String sql = "select count(*) from dbo_sub_content where "+subsql+"";
		
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
		String sql = "delete from dbo_sub_content where "+subsql+"";
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
		String sql = "delete from dbo_sub_content where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboSubContent dbosubcontent) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_sub_content(`id`,`pname`,`place`,`stype`,`htmltype`,`htmlname`,`isdelete`,`lastvisittime`,`desc`,`parent_id`,`templatename`,`sub_sites_id`,`sync_id`) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbosubcontent.getId());
		dbc.setString(2, dbosubcontent.getPname());
		dbc.setString(3, dbosubcontent.getPlace());
		dbc.setInt(4, dbosubcontent.getStype());
		dbc.setInt(5, dbosubcontent.getHtmltype());
		dbc.setString(6, dbosubcontent.getHtmlname());
		dbc.setInt(7, dbosubcontent.getIsdelete());
		dbc.setTimestamp(8, new Timestamp(dbosubcontent.getLastvisittime().getTime()));
		dbc.setString(9, dbosubcontent.getDesc());
		dbc.setInt(10, dbosubcontent.getParent_id());
		dbc.setString(11, dbosubcontent.getTemplatename());
		dbc.setInt(12, dbosubcontent.getSub_sites_id());
		dbc.setInt(13, dbosubcontent.getSync_id());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboSubContent dbosubcontent) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_sub_content(`id`,`pname`,`place`,`stype`,`htmltype`,`htmlname`,`isdelete`,`lastvisittime`,`desc`,`parent_id`,`templatename`,`sub_sites_id`,`sync_id`) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbosubcontent.getId());
		dbc.setString(2, dbosubcontent.getPname());
		dbc.setString(3, dbosubcontent.getPlace());
		dbc.setInt(4, dbosubcontent.getStype());
		dbc.setInt(5, dbosubcontent.getHtmltype());
		dbc.setString(6, dbosubcontent.getHtmlname());
		dbc.setInt(7, dbosubcontent.getIsdelete());
		dbc.setTimestamp(8, new Timestamp(dbosubcontent.getLastvisittime().getTime()));
		dbc.setString(9, dbosubcontent.getDesc());
		dbc.setInt(10, dbosubcontent.getParent_id());
		dbc.setString(11, dbosubcontent.getTemplatename());
		dbc.setInt(12, dbosubcontent.getSub_sites_id());
		dbc.setInt(13, dbosubcontent.getSync_id());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboSubContent dbosubcontent) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_sub_content set ");
		boolean flag = false;
		if(dbosubcontent.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbosubcontent.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",pname=?");
			}else{
				sb.append("pname=?");
				flag=true;
			}
		}
		if(dbosubcontent.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",place=?");
			}else{
				sb.append("place=?");
				flag=true;
			}
		}
		if(dbosubcontent.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",stype=?");
			}else{
				sb.append("stype=?");
				flag=true;
			}
		}
		if(dbosubcontent.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",htmltype=?");
			}else{
				sb.append("htmltype=?");
				flag=true;
			}
		}
		if(dbosubcontent.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",htmlname=?");
			}else{
				sb.append("htmlname=?");
				flag=true;
			}
		}
		if(dbosubcontent.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dbosubcontent.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",lastvisittime=?");
			}else{
				sb.append("lastvisittime=?");
				flag=true;
			}
		}
		if(dbosubcontent.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",`desc`=?");
			}else{
				sb.append("`desc`=?");
				flag=true;
			}
		}
		if(dbosubcontent.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",parent_id=?");
			}else{
				sb.append("parent_id=?");
				flag=true;
			}
		}
		if(dbosubcontent.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",templatename=?");
			}else{
				sb.append("templatename=?");
				flag=true;
			}
		}
		if(dbosubcontent.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",sub_sites_id=?");
			}else{
				sb.append("sub_sites_id=?");
				flag=true;
			}
		}
		if(dbosubcontent.COLUMN_FLAG[12]){
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
		if(dbosubcontent.COLUMN_FLAG[0]){
			dbc.setInt(k, dbosubcontent.getId());k++;
		}
		if(dbosubcontent.COLUMN_FLAG[1]){
			dbc.setString(k, dbosubcontent.getPname());k++;
		}
		if(dbosubcontent.COLUMN_FLAG[2]){
			dbc.setString(k, dbosubcontent.getPlace());k++;
		}
		if(dbosubcontent.COLUMN_FLAG[3]){
			dbc.setInt(k, dbosubcontent.getStype());k++;
		}
		if(dbosubcontent.COLUMN_FLAG[4]){
			dbc.setInt(k, dbosubcontent.getHtmltype());k++;
		}
		if(dbosubcontent.COLUMN_FLAG[5]){
			dbc.setString(k, dbosubcontent.getHtmlname());k++;
		}
		if(dbosubcontent.COLUMN_FLAG[6]){
			dbc.setInt(k, dbosubcontent.getIsdelete());k++;
		}
		if(dbosubcontent.COLUMN_FLAG[7]){
			dbc.setTimestamp(k, new Timestamp(dbosubcontent.getLastvisittime().getTime()));k++;
		}
		if(dbosubcontent.COLUMN_FLAG[8]){
			dbc.setString(k, dbosubcontent.getDesc());k++;
		}
		if(dbosubcontent.COLUMN_FLAG[9]){
			dbc.setInt(k, dbosubcontent.getParent_id());k++;
		}
		if(dbosubcontent.COLUMN_FLAG[10]){
			dbc.setString(k, dbosubcontent.getTemplatename());k++;
		}
		if(dbosubcontent.COLUMN_FLAG[11]){
			dbc.setInt(k, dbosubcontent.getSub_sites_id());k++;
		}
		if(dbosubcontent.COLUMN_FLAG[12]){
			dbc.setInt(k, dbosubcontent.getSync_id());k++;
		}
		dbc.setInt(k, dbosubcontent.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboSubContent dbosubcontent) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbosubcontent);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}