package car_daos;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.logicalcobwebs.proxool.configuration.PropertyConfigurator;

public class DBConnectionManagerFin {

	private static final DBConnectionManagerFin instance = new DBConnectionManagerFin();

	private static String driverClass, jdbcUrl, user, password;

	static {
		System.out.println("DBConnectionManager static{...}");
	}

	public static void destroyDS() {

	}

	public static DBConnectionManagerFin getInstance() {
		return instance;
	}

	private DBConnectionManagerFin() {
		System.out.println("create a new DBConnectionManagerFin");
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
			//conn = DriverManager.getConnection(jdbcUrl, user, password);
			
			conn = DriverManager.getConnection("proxool.finance-194");
			
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
			is = new FileInputStream(rootPath + "/WEB-INF/classes/db.properties");
			props.load(is);

			driverClass = props.getProperty("driverClass");
			jdbcUrl = props.getProperty("jdbcUrlFin");
			user = props.getProperty("userFin");
			password = props.getProperty("passwordFin");
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
