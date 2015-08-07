package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbApplyDetail;

public class  TbApplyDetailDao  extends BaseDao {

	public static void fill(ResultSet rs, TbApplyDetail tbapplydetail) throws SQLException {
		tbapplydetail.setId(rs.getInt("id"));//
		tbapplydetail.setUid(rs.getInt("uid"));//操作者id
		tbapplydetail.setApplyid(rs.getInt("applyid"));//报名表id
		tbapplydetail.setType(rs.getInt("type"));//操作类型  0 -恢复 1-删除
		tbapplydetail.setRemark(rs.getString("remark"));//备注
		tbapplydetail.setAddtime(rs.getTimestamp("addtime"));//
	}

	public static List<TbApplyDetail> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_apply_detail";
		List<TbApplyDetail> list = new ArrayList<TbApplyDetail>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbApplyDetail tbapplydetail = new TbApplyDetail();
				fill(rs, tbapplydetail);
				list.add(tbapplydetail);
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


	public static List<TbApplyDetail> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_apply_detail where "+subsql+"";
		List<TbApplyDetail> list = new ArrayList<TbApplyDetail>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbApplyDetail tbapplydetail = new TbApplyDetail();
				fill(rs, tbapplydetail);
				list.add(tbapplydetail);
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
		String sql = "select count(*) from tb_apply_detail where "+subsql+"";
		
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
		String sql = "delete from tb_apply_detail where "+subsql+"";
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
		String sql = "delete from tb_apply_detail where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbApplyDetail tbapplydetail) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_apply_detail(`id`,`uid`,`applyid`,`type`,`remark`,`addtime`) values(?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbapplydetail.getId());
		dbc.setInt(2, tbapplydetail.getUid());
		dbc.setInt(3, tbapplydetail.getApplyid());
		dbc.setInt(4, tbapplydetail.getType());
		dbc.setString(5, tbapplydetail.getRemark());
		dbc.setTimestamp(6, new Timestamp(tbapplydetail.getAddtime().getTime()));
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbApplyDetail tbapplydetail) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_apply_detail(`id`,`uid`,`applyid`,`type`,`remark`,`addtime`) values(?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbapplydetail.getId());
		dbc.setInt(2, tbapplydetail.getUid());
		dbc.setInt(3, tbapplydetail.getApplyid());
		dbc.setInt(4, tbapplydetail.getType());
		dbc.setString(5, tbapplydetail.getRemark());
		dbc.setTimestamp(6, new Timestamp(tbapplydetail.getAddtime().getTime()));
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbApplyDetail tbapplydetail) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_apply_detail set ");
		boolean flag = false;
		if(tbapplydetail.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(tbapplydetail.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",uid=?");
			}else{
				sb.append("uid=?");
				flag=true;
			}
		}
		if(tbapplydetail.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",applyid=?");
			}else{
				sb.append("applyid=?");
				flag=true;
			}
		}
		if(tbapplydetail.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",type=?");
			}else{
				sb.append("type=?");
				flag=true;
			}
		}
		if(tbapplydetail.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",remark=?");
			}else{
				sb.append("remark=?");
				flag=true;
			}
		}
		if(tbapplydetail.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",addtime=?");
			}else{
				sb.append("addtime=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbapplydetail.COLUMN_FLAG[0]){
			dbc.setInt(k, tbapplydetail.getId());k++;
		}
		if(tbapplydetail.COLUMN_FLAG[1]){
			dbc.setInt(k, tbapplydetail.getUid());k++;
		}
		if(tbapplydetail.COLUMN_FLAG[2]){
			dbc.setInt(k, tbapplydetail.getApplyid());k++;
		}
		if(tbapplydetail.COLUMN_FLAG[3]){
			dbc.setInt(k, tbapplydetail.getType());k++;
		}
		if(tbapplydetail.COLUMN_FLAG[4]){
			dbc.setString(k, tbapplydetail.getRemark());k++;
		}
		if(tbapplydetail.COLUMN_FLAG[5]){
			dbc.setTimestamp(k, new Timestamp(tbapplydetail.getAddtime().getTime()));k++;
		}
		dbc.setInt(k, tbapplydetail.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbApplyDetail tbapplydetail) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbapplydetail);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}