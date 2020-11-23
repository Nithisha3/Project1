package com.cg.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import com.cg.entity.UserRole;


@Component
public class UserDao extends Dao {
	
	
	//METHOD USED TO VALIDATE USER DETAILS WHILE SIGNING IN.
		public boolean validateUser(UserRole user) {
			
			boolean status = false;
			
			Connection con = openConnection();
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				stmt = con.createStatement();
				
				String sql = "SELECT * FROM USERROLE WHERE USERNAME ='" + user.getUserName() + "' and PASSWORD = '" + user.getPassword() + "'" ;
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					status = true;
					user.setRoleCode(rs.getString(3));
					
				}
			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				closeResultSet(rs);
				closeStatement(stmt);
				closeConnection(con);
			}
			return status;	
		
		}

}
