package com.cg.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.cg.entity.Accounts;
import com.cg.entity.Policy;

@Component
public class PolicyDao extends Dao {
	boolean status = false;

	//METHOD USED TO get Account DETAILS of specific username .
			public ArrayList<Policy> getPolicyDetails(int  accountNumber) {
				
				
				Connection con = openConnection();
				Statement stmt = null;
				ResultSet rs = null;
				ArrayList<Policy> policyList =new ArrayList<Policy>();  
				
				try {
					stmt = con.createStatement();
					
					String sql = "SELECT * FROM POLICY WHERE ACCOUNTNUMBER =" + accountNumber +  "" ;
					rs = stmt.executeQuery(sql);
					
		
					while(rs.next()) {
						Policy policy = new Policy();
						policy.setPolicyNumber(rs.getInt(1));
						policy.setPolicyPremium(rs.getInt(2));
						policy.setAccountNumber(rs.getInt(3));
						
						policyList.add(policy);
						
					}
				} catch (SQLException se) {
					se.printStackTrace();
				} finally {
					closeResultSet(rs);
					closeStatement(stmt);
					closeConnection(con);
				}
				return policyList;	
			
			}
			
	

}
