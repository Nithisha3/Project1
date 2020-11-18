package claimregistration;
import java.util.*;
import java.sql.*;
public class ConnectionUtil {
	
	public static Connection getConnection() {

		Connection con = null;
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "system";
		String password = "vyshu123";

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
}

