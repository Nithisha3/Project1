package com.cg.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.cg.entity.Accounts;
import com.cg.entity.UserRole;

@Component
public class AccountsDao extends Dao {
	
	//METHOD USED TO get Account DETAILS of specific username .
			public Accounts getAccountDetails(String  userName) {
				
				boolean status = false;
				
				Connection con = openConnection();
				Statement stmt = null;
				ResultSet rs = null;
				Accounts accounts = new Accounts();
				
				try {
					stmt = con.createStatement();
					
					String sql = "SELECT * FROM ACCOUNTS WHERE USERNAME ='" + userName +  "'" ;
					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						status = true;
						accounts.setAccountNumber(rs.getInt(1));
						accounts.setInsuredName(rs.getString(2));
						accounts.setInsuredStreet(rs.getString(3));
						accounts.setInsuredCity(rs.getString(4));
						accounts.setInsuredState(rs.getString(5));
						accounts.setInsuredZip(rs.getInt(6));
						accounts.setBusinessSegment(rs.getString(7));
						accounts.setUserName(rs.getString(8));
			
						
					}
				} catch (SQLException se) {
					se.printStackTrace();
				} finally {
					closeResultSet(rs);
					closeStatement(stmt);
					closeConnection(con);
				}
				return accounts;	
			
			}
			
			public ArrayList<Accounts> getAccountDetailsforHandler(String  userName) {
				
			
				
				Connection con = openConnection();
				Statement stmt = null;
				ResultSet rs = null;
				ArrayList<Accounts> accountsArrayList = new ArrayList<Accounts>();
				
				try {
					stmt = con.createStatement();
					
					String sql = "SELECT * FROM ACCOUNTS WHERE USERNAME ='" + userName +  "'" ;
					rs = stmt.executeQuery(sql);
					while (rs.next()) {
					
						Accounts accounts = new Accounts();
						accounts.setAccountNumber(rs.getInt(1));
						accounts.setInsuredName(rs.getString(2));
						accounts.setInsuredStreet(rs.getString(3));
						accounts.setInsuredCity(rs.getString(4));
						accounts.setInsuredState(rs.getString(5));
						accounts.setInsuredZip(rs.getInt(6));
						accounts.setBusinessSegment(rs.getString(7));
						accounts.setUserName(rs.getString(8));
						accountsArrayList.add(accounts);
						
						
					}
				} catch (SQLException se) {
					se.printStackTrace();
				} finally {
					closeResultSet(rs);
					closeStatement(stmt);
					closeConnection(con);
				}
				return accountsArrayList;
				
			
			}
			
			


}
