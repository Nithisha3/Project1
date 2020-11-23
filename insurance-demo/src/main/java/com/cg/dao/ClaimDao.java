package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.entity.Claim;
import com.cg.entity.Questions;
import com.cg.entity.Answers;
import com.cg.entity.ClaimQuestionsAndAnswers;
import com.cg.services.ClaimService;

@Component
public class ClaimDao extends Dao{

	//METHOD USED TO INSERT NEW Claim DETAILS INTO DATABASE.
		public boolean insertClaim(Claim claim) {
			boolean status = false;
			
			Connection con = openConnection();
			PreparedStatement psmt = null;
			ResultSet rs = null;
			
			try {
				
				System.out.println(claim);
				psmt=con.prepareStatement("insert into claim values(?,?,?,?,?,?,?,?)");
				psmt.setInt(1,claim.getClaimNumber());
				psmt.setString(2,claim.getClaimReason());
				psmt.setString(3, claim.getaccidentLocationStreet());
				psmt.setString(4,claim.getAccidentCity());
				psmt.setString(5, claim.getAccidentState());
				psmt.setInt(6, claim.getAccidentZip());
				psmt.setString(7, claim.getClaimType());
				psmt.setInt(8, claim.getPolicyNumber());
				
				int rows = psmt.executeUpdate();
				if(rows != 0) {
					status = true;
					
				}
				
			} 
			catch(SQLIntegrityConstraintViolationException
					 s) {
				
			} catch (SQLException se) {
				se.printStackTrace();
				
			} finally {
				closeResultSet(rs);
				closeStatement(psmt);
				closeConnection(con);
			}
			return status;
		}
		
		
		//METHOD USED TO INSERT  Claim Questiona and Answers INTO DATABASE.
				public boolean insertClaimQuestionsAndAnswers(ArrayList<ClaimQuestionsAndAnswers> claimQuestionsAndAnswersList) {
					boolean status = false;
					
					Connection con = openConnection();
					PreparedStatement psmt = null;
					ResultSet rs = null;
					
					try {
						
						psmt=con.prepareStatement("insert into CLAIMQUESTIONANDANSWERS values(?,?,?)");
						for(ClaimQuestionsAndAnswers entry :claimQuestionsAndAnswersList ) {
							psmt.setInt(1,entry.getQuestionId());
							psmt.setInt(2,entry.getAnswerId());
							psmt.setInt(3,entry.getClaimNumber());
							
							psmt.addBatch();
						}
						
						
						int[] rows = psmt.executeBatch();

						if(rows.length != 0  ) {
							status = true;
							
						}
						
					} 
					catch(SQLIntegrityConstraintViolationException
							 s) {
						
					} catch (SQLException se) {
						se.printStackTrace();
						
					} finally {
						closeResultSet(rs);
						closeStatement(psmt);
						closeConnection(con);
					}
					return status;
				}
		
		
		
		
		

}
