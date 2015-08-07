package com.poly.util.syscardata;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

//import org.apache.log4j.Logger;

public class DBConnect {
	// static Logger logger = Logger.getLogger(DBConnect.class.getName());


	private Connection conn = null;

	private PreparedStatement prepstmt = null;

	private int isTX = 0;// 锟角凤拷锟斤拷锟斤拷锟斤拷;0|锟斤拷1|锟斤拷锟斤拷

	void init() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn =  DriverManager.getConnection("jdbc:mysql://182.254.131.113:3306/car_315?useUnicode=true&characterEncoding=UTF-8", "admin", "root178ZXC");
			//conn =  DriverManager.getConnection("jdbc:mysql://192.168.1.249:3306/car_315?useUnicode=true&characterEncoding=UTF-8", "main", "main");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public DBConnect() throws Exception {

		init();
	}

	public DBConnect(int is_tx) throws Exception {
		isTX = is_tx;
		init();
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷锟接和凤拷锟斤拷锟斤拷 预锟斤拷锟斤拷SQL锟斤拷锟�
	 * 
	 * @param sql
	 *            SQL锟斤拷锟�
	 */
	public DBConnect(String sql) throws Exception {
		init();
		this.prepareStatement(sql);
	}

	/**
	 * PreparedStatement
	 * 
	 * @return sql 预锟斤拷SQL锟斤拷锟�
	 */
	public void prepareStatement(String sql) throws SQLException {
		try {
			prepstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException {
		prepstmt = conn.prepareStatement(sql, resultSetType,
				resultSetConcurrency);
		prepstmt.setQueryTimeout(5);
	}

	/**
	 * 锟斤拷锟矫讹拷应值
	 * 
	 * @param index
	 *            锟斤拷锟斤拷锟斤拷锟斤拷
	 * @param value
	 *            锟斤拷应值
	 */

	public void setString(int index, String value) throws SQLException {
		prepstmt.setString(index, value);
	}

	public void setInt(int index, int value) throws SQLException {
		prepstmt.setInt(index, value);
	}

	public void setBoolean(int index, boolean value) throws SQLException {
		prepstmt.setBoolean(index, value);
	}

	public void setDate(int index, Date value) throws SQLException {
		prepstmt.setDate(index, value);
	}

	public void setLong(int index, long value) throws SQLException {
		prepstmt.setLong(index, value);
	}

	public void setFloat(int index, float value) throws SQLException {
		prepstmt.setFloat(index, value);
	}

	public void setObject(int index, Object value) throws SQLException {
		prepstmt.setObject(index, value);
	}
	
	public void setDouble(int index, double value) throws SQLException {
		prepstmt.setDouble(index, value);
	}

	public void setBytes(int index, byte[] value) throws SQLException {
		prepstmt.setBytes(index, value);
	}

	public void setTimestamp(int index, Timestamp value) throws SQLException {
		prepstmt.setTimestamp(index, value);
	}

	public void clearParameters() throws SQLException {
		prepstmt.clearParameters();
		// prepstmt.close();
		// prepstmt=null;
	}

	/**
	 * 锟斤拷锟斤拷预锟斤拷状态
	 */
	public PreparedStatement getPreparedStatement() {
		return prepstmt;
	}

	public ResultSet executeQuery() throws SQLException {
		if (prepstmt != null) {
			return prepstmt.executeQuery();
		} else {
			System.out.println("stat is null");
			return null;
		}
	}

	public void executeUpdate() throws SQLException {
		if (prepstmt != null)
			prepstmt.executeUpdate();
		else
			throw new SQLException();
	}

	public int executeUpdateReturnInt() throws SQLException {
		if (prepstmt != null) {
			return prepstmt.executeUpdate();
		} else {
			throw new SQLException();
		}
	}

	public void executeBatch() throws SQLException {
		if (prepstmt != null)
			prepstmt.executeBatch();
		else
			throw new SQLException();
	}

	public void addBatch(String sql) throws SQLException {
		prepstmt.addBatch(sql);
	}

	public void addBatch() throws SQLException {
		prepstmt.addBatch();
	}

	public void rollback() throws SQLException {
		if (conn != null) {
			conn.rollback();
		}
	}

	public void setAutoCommit(boolean commit) throws SQLException {
		if (conn != null) {
			conn.setAutoCommit(commit);
		}
	}

	public void commit() throws SQLException {
		if (conn != null) {
			conn.commit();
		}
	}

	public void closePrepareStmt() throws SQLException {
		if (prepstmt != null) {
			prepstmt.close();
			prepstmt = null;
		}
	}

	/**
	 * 锟截憋拷锟斤拷锟斤拷
	 */
	public void close() throws Exception {
		try {
			this.closePrepareStmt();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn = null;
			}
		}
	}

}