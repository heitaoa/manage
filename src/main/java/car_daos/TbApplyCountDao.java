package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbApplyCount;

public class  TbApplyCountDao  extends BaseDao {

	public static void fill(ResultSet rs, TbApplyCount tbapplycount) throws SQLException {
		tbapplycount.setId(rs.getInt("id"));//1-从小胖拉取数据 2-从新315拉取数据 3-从易车拉取数据（团购） 4-从易车拉取数据（活动） 5-从老315拉取手机报名数据 9-拉取suncars数据推送至经销商 10-经销商发送信息标识位
		tbapplycount.setMax_dbid(rs.getInt("max_dbid"));//
		tbapplycount.setMax_315id(rs.getInt("max_315id"));//
		tbapplycount.setLast_update_time(rs.getTimestamp("last_update_time"));//
		tbapplycount.setIslock(rs.getInt("islock"));//0-未加锁  1-已加锁  
	}

	public static List<TbApplyCount> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_apply_count";
		List<TbApplyCount> list = new ArrayList<TbApplyCount>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbApplyCount tbapplycount = new TbApplyCount();
				fill(rs, tbapplycount);
				list.add(tbapplycount);
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


	public static List<TbApplyCount> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_apply_count where "+subsql+"";
		List<TbApplyCount> list = new ArrayList<TbApplyCount>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbApplyCount tbapplycount = new TbApplyCount();
				fill(rs, tbapplycount);
				list.add(tbapplycount);
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
		String sql = "select count(*) from tb_apply_count where "+subsql+"";
		
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
		String sql = "delete from tb_apply_count where "+subsql+"";
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
		String sql = "delete from tb_apply_count where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbApplyCount tbapplycount) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_apply_count(`id`,`max_dbid`,`max_315id`,`last_update_time`,`islock`) values(?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbapplycount.getId());
		dbc.setInt(2, tbapplycount.getMax_dbid());
		dbc.setInt(3, tbapplycount.getMax_315id());
		dbc.setTimestamp(4, new Timestamp(tbapplycount.getLast_update_time().getTime()));
		dbc.setInt(5, tbapplycount.getIslock());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbApplyCount tbapplycount) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_apply_count(`id`,`max_dbid`,`max_315id`,`last_update_time`,`islock`) values(?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbapplycount.getId());
		dbc.setInt(2, tbapplycount.getMax_dbid());
		dbc.setInt(3, tbapplycount.getMax_315id());
		dbc.setTimestamp(4, new Timestamp(tbapplycount.getLast_update_time().getTime()));
		dbc.setInt(5, tbapplycount.getIslock());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbApplyCount tbapplycount) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_apply_count set ");
		boolean flag = false;
		if(tbapplycount.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(tbapplycount.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",max_dbid=?");
			}else{
				sb.append("max_dbid=?");
				flag=true;
			}
		}
		if(tbapplycount.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",max_315id=?");
			}else{
				sb.append("max_315id=?");
				flag=true;
			}
		}
		if(tbapplycount.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",last_update_time=?");
			}else{
				sb.append("last_update_time=?");
				flag=true;
			}
		}
		if(tbapplycount.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",islock=?");
			}else{
				sb.append("islock=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbapplycount.COLUMN_FLAG[0]){
			dbc.setInt(k, tbapplycount.getId());k++;
		}
		if(tbapplycount.COLUMN_FLAG[1]){
			dbc.setInt(k, tbapplycount.getMax_dbid());k++;
		}
		if(tbapplycount.COLUMN_FLAG[2]){
			dbc.setInt(k, tbapplycount.getMax_315id());k++;
		}
		if(tbapplycount.COLUMN_FLAG[3]){
			dbc.setTimestamp(k, new Timestamp(tbapplycount.getLast_update_time().getTime()));k++;
		}
		if(tbapplycount.COLUMN_FLAG[4]){
			dbc.setInt(k, tbapplycount.getIslock());k++;
		}
		dbc.setInt(k, tbapplycount.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbApplyCount tbapplycount) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbapplycount);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}