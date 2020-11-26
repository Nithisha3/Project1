package cg.ocrs.dao;
import java.sql.*;
public class DBUtil {
	
	public static Connection getConnection() {

		Connection con = null;
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "SYSTEM";
		String password = "1999";

		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

}

	public static Connection openConnection() {
		// TODO Auto-generated method stub
		return null;
	}
}
