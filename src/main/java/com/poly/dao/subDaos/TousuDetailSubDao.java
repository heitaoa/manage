package com.poly.dao.subDaos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import car_beans.DboDntTousuDetail;
import car_daos.DBConnect;
import car_daos.DBConnectionManager;
import car_daos.DboDntTousuDetailDao;

public class TousuDetailSubDao extends DboDntTousuDetailDao {
	public static int saveT(DboDntTousuDetail dbodnttousudetail)
			throws Exception {
		int result = EXECUTE_FAIL;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "insert into dbo_dnt_tousu_detail(`tousuid`,`content`,`addtime`) values(?,?,?)";
			con = DBConnectionManager.getInstance().getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dbodnttousudetail.getTousuid());
			pstmt.setString(2, dbodnttousudetail.getContent());
			pstmt.setTimestamp(3, new Timestamp(dbodnttousudetail.getAddtime()
					.getTime()));
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if (rs.next())
				result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
