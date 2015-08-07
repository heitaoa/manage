package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbDictPhone;

public class  TbDictPhoneDao  extends BaseDao {

	public static void fill(ResultSet rs, TbDictPhone tbdictphone) throws SQLException {
		tbdictphone.setId(rs.getInt("id"));//
		tbdictphone.setPhone_num(rs.getInt("phone_num"));//
		tbdictphone.setProv(rs.getString("prov"));//Ê¡
		tbdictphone.setCity(rs.getString("city"));//ÊÐ
		tbdictphone.setSource(rs.getString("source"));//
		tbdictphone.setCode(rs.getString("code"));//ÇøºÅ
		tbdictphone.setZip(rs.getString("zip"));//ÓÊ±à
		tbdictphone.setProvid(rs.getInt("provid"));//
		tbdictphone.setCityid(rs.getInt("cityid"));//
	}

	public static List<TbDictPhone> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_dict_phone";
		List<TbDictPhone> list = new ArrayList<TbDictPhone>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDictPhone tbdictphone = new TbDictPhone();
				fill(rs, tbdictphone);
				list.add(tbdictphone);
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


	public static List<TbDictPhone> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_dict_phone where "+subsql+"";
		List<TbDictPhone> list = new ArrayList<TbDictPhone>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDictPhone tbdictphone = new TbDictPhone();
				fill(rs, tbdictphone);
				list.add(tbdictphone);
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
		String sql = "select count(*) from tb_dict_phone where "+subsql+"";
		
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
		String sql = "delete from tb_dict_phone where "+subsql+"";
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
		String sql = "delete from tb_dict_phone where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbDictPhone tbdictphone) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_dict_phone(`id`,`phone_num`,`prov`,`city`,`source`,`code`,`zip`,`provid`,`cityid`) values(?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdictphone.getId());
		dbc.setInt(2, tbdictphone.getPhone_num());
		dbc.setString(3, tbdictphone.getProv());
		dbc.setString(4, tbdictphone.getCity());
		dbc.setString(5, tbdictphone.getSource());
		dbc.setString(6, tbdictphone.getCode());
		dbc.setString(7, tbdictphone.getZip());
		dbc.setInt(8, tbdictphone.getProvid());
		dbc.setInt(9, tbdictphone.getCityid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbDictPhone tbdictphone) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_dict_phone(`id`,`phone_num`,`prov`,`city`,`source`,`code`,`zip`,`provid`,`cityid`) values(?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdictphone.getId());
		dbc.setInt(2, tbdictphone.getPhone_num());
		dbc.setString(3, tbdictphone.getProv());
		dbc.setString(4, tbdictphone.getCity());
		dbc.setString(5, tbdictphone.getSource());
		dbc.setString(6, tbdictphone.getCode());
		dbc.setString(7, tbdictphone.getZip());
		dbc.setInt(8, tbdictphone.getProvid());
		dbc.setInt(9, tbdictphone.getCityid());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbDictPhone tbdictphone) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_dict_phone set ");
		boolean flag = false;
		if(tbdictphone.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(tbdictphone.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",phone_num=?");
			}else{
				sb.append("phone_num=?");
				flag=true;
			}
		}
		if(tbdictphone.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",prov=?");
			}else{
				sb.append("prov=?");
				flag=true;
			}
		}
		if(tbdictphone.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",city=?");
			}else{
				sb.append("city=?");
				flag=true;
			}
		}
		if(tbdictphone.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",source=?");
			}else{
				sb.append("source=?");
				flag=true;
			}
		}
		if(tbdictphone.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",code=?");
			}else{
				sb.append("code=?");
				flag=true;
			}
		}
		if(tbdictphone.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",zip=?");
			}else{
				sb.append("zip=?");
				flag=true;
			}
		}
		if(tbdictphone.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",provid=?");
			}else{
				sb.append("provid=?");
				flag=true;
			}
		}
		if(tbdictphone.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",cityid=?");
			}else{
				sb.append("cityid=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbdictphone.COLUMN_FLAG[0]){
			dbc.setInt(k, tbdictphone.getId());k++;
		}
		if(tbdictphone.COLUMN_FLAG[1]){
			dbc.setInt(k, tbdictphone.getPhone_num());k++;
		}
		if(tbdictphone.COLUMN_FLAG[2]){
			dbc.setString(k, tbdictphone.getProv());k++;
		}
		if(tbdictphone.COLUMN_FLAG[3]){
			dbc.setString(k, tbdictphone.getCity());k++;
		}
		if(tbdictphone.COLUMN_FLAG[4]){
			dbc.setString(k, tbdictphone.getSource());k++;
		}
		if(tbdictphone.COLUMN_FLAG[5]){
			dbc.setString(k, tbdictphone.getCode());k++;
		}
		if(tbdictphone.COLUMN_FLAG[6]){
			dbc.setString(k, tbdictphone.getZip());k++;
		}
		if(tbdictphone.COLUMN_FLAG[7]){
			dbc.setInt(k, tbdictphone.getProvid());k++;
		}
		if(tbdictphone.COLUMN_FLAG[8]){
			dbc.setInt(k, tbdictphone.getCityid());k++;
		}
		dbc.setInt(k, tbdictphone.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbDictPhone tbdictphone) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbdictphone);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}