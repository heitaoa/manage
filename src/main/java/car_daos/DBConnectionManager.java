package car_daos;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.logicalcobwebs.proxool.configuration.PropertyConfigurator;

import com.redis.RedisManager;

//import com.deity.adminCT.servlets.InitServlet;


/**
 * ������DBConnectionManager֧�ֶ�һ�������������ļ��������ݿ�����
 * �صķ���.�ͻ�������Ե���getInstance()�������ʱ����Ψһʵ��.
 */

public class DBConnectionManager {

	private static final DBConnectionManager instance = new DBConnectionManager();

	private static String driverClass, jdbcUrl, user, password;

	static {
		System.out.println("DBConnectionManager static{...}");
//		servletContext.getRealPath("/");
//		init();
	}

	public static void destroyDS() {

	}

	public static DBConnectionManager getInstance() {
		return instance;
	}

	private DBConnectionManager() {
		System.out.println("create a new DBConnectionManager");
	}

	public void freeConnection(Connection conn) {
		if (conn == null) {
			return;
		}
		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			//Class.forName(driverClass);// Ҫ��JVM���Ҳ�����ָ�����࣬Ҳ����˵JVM��ִ�и���ľ�̬�����
			DriverManager.setLoginTimeout(10);// ����10s�ò������ӱ���
			
//			Properties info = new Properties();
//			info.setProperty("proxool.maximum-connection-count", "20");
//			info.setProperty("proxool.house-keeping-test-sql", "select CURRENT_DATE");
//			info.setProperty("user", user);
//			info.setProperty("password", password);
//			String alias = "test";
//			String driverClass = "org.hsqldb.jdbcDriver";
//			String driverUrl = "jdbc:hsqldb:test";
//			String url = "proxool." + alias + ":" + driverClass + ":" + driverUrl;
////			connection = DriverManager.getConnection(url, info);
//			conn =DriverManager.getConnection("proxool.example:"+driverClass+":"+jdbcUrl, user, password);
			
//			conn = DriverManager.getConnection(jdbcUrl, user, password);
			
			conn = DriverManager.getConnection("proxool.che-113");

			
			conn.setAutoCommit(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	

	public static void init(String rootPath) {
		InputStream is = null;
		try {
			Properties props = new Properties();
			//String rootPath = InitServlet.rootPath;
//			is = new FileInputStream(rootPath + "/WEB-INF/classes/db.properties");
//			props.load(is);
//
//			driverClass = props.getProperty("driverClass");
//			jdbcUrl = props.getProperty("jdbcUrl");
//			user = props.getProperty("user");
//			password = props.getProperty("password");

			
//			Class.forName(driverClass);
			
			
			PropertyConfigurator.configure(rootPath + "/WEB-INF/classes/proxool.properties");
			
			System.out.println("read db.properties");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
					// just ignore it
				}
			}
		}
	}
}