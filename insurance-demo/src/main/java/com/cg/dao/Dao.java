package com.cg.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class Dao {
	public Connection openConnection() {
		Connection con = null;
	
		try  {
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "password");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();;
		} catch (SQLException se) {
			se.printStackTrace();;
		} 
		return con;
	}
	
	public void closeConnection (Connection con) {
		try {
			if(con != null) {
				con.close();
			}
		} catch(SQLException se) {
			se.printStackTrace();;
		   }
	}
	
	public void closeStatement (Statement stmt) {
		try {
			if(stmt != null) {
				stmt.close();
			}
		} catch(SQLException se) {
			se.printStackTrace();;
		   }
	}
	
	public void closeResultSet (ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch(SQLException se) {
			se.printStackTrace();;
		   }
	}

}
