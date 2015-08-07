package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbApplyDownloadDetail;

public class  TbApplyDownloadDetailDao  extends BaseDao {

	public static void fill(ResultSet rs, TbApplyDownloadDetail tbapplydownloaddetail) throws SQLException {
		tbapplydownloaddetail.setId(rs.getInt("id"));//
		tbapplydownloaddetail.setUserid(rs.getString("userid"));//操作用户id
		tbapplydownloaddetail.setAppenddate(rs.getTimestamp("appenddate"));//添加时间
		tbapplydownloaddetail.setCount(rs.getInt("count"));//导出数量
		tbapplydownloaddetail.setQuerysql(rs.getString("querysql"));//操作sql
		tbapplydownloaddetail.setIp(rs.getString("ip"));//出口ip
		tbapplydownloaddetail.setHostip(rs.getString("hostip"));//本机ip
		tbapplydownloaddetail.setHostname(rs.getString("hostname"));//本机名称
	}

	public static List<TbApplyDownloadDetail> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_apply_download_detail";
		List<TbApplyDownloadDetail> list = new ArrayList<TbApplyDownloadDetail>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbApplyDownloadDetail tbapplydownloaddetail = new TbApplyDownloadDetail();
				fill(rs, tbapplydownloaddetail);
				list.add(tbapplydownloaddetail);
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


	public static List<TbApplyDownloadDetail> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_apply_download_detail where "+subsql+"";
		List<TbApplyDownloadDetail> list = new ArrayList<TbApplyDownloadDetail>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbApplyDownloadDetail tbapplydownloaddetail = new TbApplyDownloadDetail();
				fill(rs, tbapplydownloaddetail);
				list.add(tbapplydownloaddetail);
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
		String sql = "select count(*) from tb_apply_download_detail where "+subsql+"";
		
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
		String sql = "delete from tb_apply_download_detail where "+subsql+"";
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
		String sql = "delete from tb_apply_download_detail where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbApplyDownloadDetail tbapplydownloaddetail) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_apply_download_detail(`id`,`userid`,`appenddate`,`count`,`querysql`,`ip`,`hostip`,`hostname`) values(?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbapplydownloaddetail.getId());
		dbc.setString(2, tbapplydownloaddetail.getUserid());
		dbc.setTimestamp(3, new Timestamp(tbapplydownloaddetail.getAppenddate().getTime()));
		dbc.setInt(4, tbapplydownloaddetail.getCount());
		dbc.setString(5, tbapplydownloaddetail.getQuerysql());
		dbc.setString(6, tbapplydownloaddetail.getIp());
		dbc.setString(7, tbapplydownloaddetail.getHostip());
		dbc.setString(8, tbapplydownloaddetail.getHostname());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbApplyDownloadDetail tbapplydownloaddetail) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_apply_download_detail(`id`,`userid`,`appenddate`,`count`,`querysql`,`ip`,`hostip`,`hostname`) values(?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbapplydownloaddetail.getId());
		dbc.setString(2, tbapplydownloaddetail.getUserid());
		dbc.setTimestamp(3, new Timestamp(tbapplydownloaddetail.getAppenddate().getTime()));
		dbc.setInt(4, tbapplydownloaddetail.getCount());
		dbc.setString(5, tbapplydownloaddetail.getQuerysql());
		dbc.setString(6, tbapplydownloaddetail.getIp());
		dbc.setString(7, tbapplydownloaddetail.getHostip());
		dbc.setString(8, tbapplydownloaddetail.getHostname());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbApplyDownloadDetail tbapplydownloaddetail) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_apply_download_detail set ");
		boolean flag = false;
		if(tbapplydownloaddetail.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(tbapplydownloaddetail.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",userid=?");
			}else{
				sb.append("userid=?");
				flag=true;
			}
		}
		if(tbapplydownloaddetail.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",appenddate=?");
			}else{
				sb.append("appenddate=?");
				flag=true;
			}
		}
		if(tbapplydownloaddetail.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",count=?");
			}else{
				sb.append("count=?");
				flag=true;
			}
		}
		if(tbapplydownloaddetail.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",querysql=?");
			}else{
				sb.append("querysql=?");
				flag=true;
			}
		}
		if(tbapplydownloaddetail.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",ip=?");
			}else{
				sb.append("ip=?");
				flag=true;
			}
		}
		if(tbapplydownloaddetail.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",hostip=?");
			}else{
				sb.append("hostip=?");
				flag=true;
			}
		}
		if(tbapplydownloaddetail.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",hostname=?");
			}else{
				sb.append("hostname=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbapplydownloaddetail.COLUMN_FLAG[0]){
			dbc.setInt(k, tbapplydownloaddetail.getId());k++;
		}
		if(tbapplydownloaddetail.COLUMN_FLAG[1]){
			dbc.setString(k, tbapplydownloaddetail.getUserid());k++;
		}
		if(tbapplydownloaddetail.COLUMN_FLAG[2]){
			dbc.setTimestamp(k, new Timestamp(tbapplydownloaddetail.getAppenddate().getTime()));k++;
		}
		if(tbapplydownloaddetail.COLUMN_FLAG[3]){
			dbc.setInt(k, tbapplydownloaddetail.getCount());k++;
		}
		if(tbapplydownloaddetail.COLUMN_FLAG[4]){
			dbc.setString(k, tbapplydownloaddetail.getQuerysql());k++;
		}
		if(tbapplydownloaddetail.COLUMN_FLAG[5]){
			dbc.setString(k, tbapplydownloaddetail.getIp());k++;
		}
		if(tbapplydownloaddetail.COLUMN_FLAG[6]){
			dbc.setString(k, tbapplydownloaddetail.getHostip());k++;
		}
		if(tbapplydownloaddetail.COLUMN_FLAG[7]){
			dbc.setString(k, tbapplydownloaddetail.getHostname());k++;
		}
		dbc.setInt(k, tbapplydownloaddetail.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbApplyDownloadDetail tbapplydownloaddetail) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbapplydownloaddetail);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}