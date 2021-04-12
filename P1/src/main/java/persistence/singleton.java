package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class singleton {
	private static final String DRIVER = "net.sourceforge.jtds.jdbc.Driver";
	private static final String HOST = "127.0.0.1";
	private static final String DB = "campeonatoFutebol";
	private static final String USER = "SA";
	//tem espaço mesmo
	private static final String PASS = " SqlServer19";

	private static singleton instance = null;
	private Connection con;

	public static singleton getInstance() {
		if (instance == null) {
			instance = new singleton();
		}
		return instance;
	}

	private singleton() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		try {
			if (con == null || con.isClosed()) {
				con = DriverManager.getConnection(String.format(
						"jdbc:jtds:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s;", HOST, DB, USER, PASS));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}