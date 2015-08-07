package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbDataProCodeSeq;

public class  TbDataProCodeSeqDao  extends BaseDao {

	public static void fill(ResultSet rs, TbDataProCodeSeq tbdataprocodeseq) throws SQLException {
		tbdataprocodeseq.setHead(rs.getString("head"));//
		tbdataprocodeseq.setCode(rs.getInt("code"));//
	}

	public static List<TbDataProCodeSeq> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_data_pro_code_seq";
		List<TbDataProCodeSeq> list = new ArrayList<TbDataProCodeSeq>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataProCodeSeq tbdataprocodeseq = new TbDataProCodeSeq();
				fill(rs, tbdataprocodeseq);
				list.add(tbdataprocodeseq);
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


	public static List<TbDataProCodeSeq> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_data_pro_code_seq where "+subsql+"";
		List<TbDataProCodeSeq> list = new ArrayList<TbDataProCodeSeq>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataProCodeSeq tbdataprocodeseq = new TbDataProCodeSeq();
				fill(rs, tbdataprocodeseq);
				list.add(tbdataprocodeseq);
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
		String sql = "select count(*) from tb_data_pro_code_seq where "+subsql+"";
		
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
		String sql = "delete from tb_data_pro_code_seq where "+subsql+"";
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
		String sql = "delete from tb_data_pro_code_seq where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbDataProCodeSeq tbdataprocodeseq) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_data_pro_code_seq(`head`,`code`) values(?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setString(1, tbdataprocodeseq.getHead());
		dbc.setInt(2, tbdataprocodeseq.getCode());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbDataProCodeSeq tbdataprocodeseq) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_data_pro_code_seq(`head`,`code`) values(?,?)";
		dbc.prepareStatement(sql);
		dbc.setString(1, tbdataprocodeseq.getHead());
		dbc.setInt(2, tbdataprocodeseq.getCode());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

}