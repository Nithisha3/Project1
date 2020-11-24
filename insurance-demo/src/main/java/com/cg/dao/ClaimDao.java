package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
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
		
		

						//METHOD USED TO VIEW  Claim .
						public Claim viewClaimDetailsForInsuredAndHandler(int claimId, String userName) {
							boolean status = false;
							
							Connection con = openConnection();
							Statement stmt = null;
							ResultSet rs = null;
							Claim claim = null;
							
							try {
								
								stmt = con.createStatement();
								
								String sql = "SELECT * FROM CLAIM WHERE CLAIMNUMBER ='" + claimId +  "'" ;
								rs = stmt.executeQuery(sql);
								if(rs.next()) {
									int policyNo = rs.getInt(8);
									if(checkValidClaimOrNot(policyNo, userName)) {
										claim = new Claim();
										claim.setClaimNumber(rs.getInt(1));
										claim.setClaimReason(rs.getString(2));
										claim.setaccidentLocationStreet(rs.getString(3));
										claim.setAccidentCity(rs.getString(4));
										claim.setAccidentState(rs.getString(5));
										claim.setAccidentZip(rs.getInt(6));
										claim.setClaimType(rs.getString(7));
										claim.setPolicyNumber(rs.getInt(8));
										
										return claim;
									}
								} 
								
								
							} 
							catch(SQLIntegrityConstraintViolationException
									 s) {
								
							} catch (SQLException se) {
								se.printStackTrace();
								
							} finally {
								closeResultSet(rs);
								closeStatement(stmt);
								closeConnection(con);
							}
							return claim;
						}
				
				
				public boolean checkValidClaimOrNot(int policyNo,  String userName) {
					boolean status = false;
					
					Connection con = openConnection();
					Statement stmt = null;
					ResultSet rs = null;
					Claim claim = null;
					
					try {
						
						stmt = con.createStatement();
						
						String sql = "SELECT * FROM ACCOUNTS WHERE ACCOUNTNUMBER = "
								+ "(SELECT ACCOUNTNUMBER FROM POLICY WHERE POLICYNUMBER  ='" + policyNo + "')" ;
						rs = stmt.executeQuery(sql);
						if(rs.next()) {
							String userNameFromTable = rs.getString(8);
							if(userNameFromTable.equals(userName)) {
								status = true;
								return status;
							}
							
						}
						
					} 
					catch(SQLIntegrityConstraintViolationException
							 s) {
						
					} catch (SQLException se) {
						se.printStackTrace();
						
					} finally {
						closeResultSet(rs);
						closeStatement(stmt);
						closeConnection(con);
					}
					return status;
					
				}
				
				//METHOD USED TO VIEW  Claim .
				public Claim viewClaimDetailsForAdjuster(int claimId) {
					boolean status = false;
					
					Connection con = openConnection();
					Statement stmt = null;
					ResultSet rs = null;
					Claim claim = null;
					
					try {
						
						stmt = con.createStatement();
						
						String sql = "SELECT * FROM CLAIM WHERE CLAIMNUMBER ='" + claimId +  "'" ;
						rs = stmt.executeQuery(sql);
						if(rs.next()) {
								claim = new Claim();
								claim.setClaimNumber(rs.getInt(1));
								claim.setClaimReason(rs.getString(2));
								claim.setaccidentLocationStreet(rs.getString(3));
								claim.setAccidentCity(rs.getString(4));
								claim.setAccidentState(rs.getString(5));
								claim.setAccidentZip(rs.getInt(6));
								claim.setClaimType(rs.getString(7));
								claim.setPolicyNumber(rs.getInt(8));
								
								return claim;
		
						} 
						
						
					} 
					catch(SQLIntegrityConstraintViolationException
							 s) {
						
					} catch (SQLException se) {
						se.printStackTrace();
						
					} finally {
						closeResultSet(rs);
						closeStatement(stmt);
						closeConnection(con);
					}
					return claim;
				}
				
		
				public HashMap<Questions, Answers> viewClaimQuestionsAndAnswers(int claimId) {
					boolean status = false;
					
					Connection con = openConnection();
					Statement stmt = null;
					ResultSet rs = null;
					HashMap<Questions, Answers> questionAnswerMap = new HashMap<Questions, Answers>();
					Questions questions = null;
					Answers answers = null;
					try {
						
						stmt = con.createStatement();
						
						String sql = "SELECT * FROM CLAIMQUESTIONANDANSWERS WHERE CLAIMNUMBER ='" + claimId +  "'" ;
						rs = stmt.executeQuery(sql);
						while (rs.next()) {
							int questionId = rs.getInt(1);
							int answerId = rs.getInt(2);
							questions = getQuestions(questionId);
							answers = getAnswer(questionId, answerId);
							
							if(questions != null && answers != null) {
								questionAnswerMap.put(questions, answers);
								
							}
						}
						
					} 	catch(SQLIntegrityConstraintViolationException
							 s) {
						
					} catch (SQLException se) {
						se.printStackTrace();
						
					} finally {
						closeResultSet(rs);
						closeStatement(stmt);
						closeConnection(con);
					}
					return questionAnswerMap;
				}
				
	
		public Questions getQuestions(int questionId) {
			Connection con = openConnection();
			Statement stmt = null;
			ResultSet rs = null;
			Questions questions = null;
			try {
				
				stmt = con.createStatement();
				
				String sql = "SELECT * FROM QUESTIONS WHERE QUESTIONID = '" + questionId + "'" ;
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
				questions = new Questions();
				questions.setQuestionId(rs.getInt(1));
				questions.setQuestion(rs.getString(2));
				
				}
				
			} 	catch(SQLIntegrityConstraintViolationException
					 s) {
				
			} catch (SQLException se) {
				se.printStackTrace();
				
			} finally {
				closeResultSet(rs);
				closeStatement(stmt);
				closeConnection(con);
			}
			return questions;
		}
		
		public Answers getAnswer(int questionId, int answerId) {
			
			Connection con = openConnection();
			Statement stmt = null;
			ResultSet rs = null;
			Answers answers = null;
			try {
				
				stmt = con.createStatement();
				
				String sql = "SELECT * FROM ANSWESRTOQUESTIONS WHERE ANSWERID ='" + answerId +  "' AND QUESTIONID = '" + questionId + "'" ;
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
				answers = new Answers();
				answers.setAnswerId(rs.getInt(1));
				answers.setAnswer(rs.getString(2));
				answers.setWeightage(rs.getInt(3));
				answers.setQuestionId(rs.getInt(4));
				
				
				
				
				}
				
			} 	catch(SQLIntegrityConstraintViolationException
					 s) {
				
			} catch (SQLException se) {
				se.printStackTrace();
				
			} finally {
				closeResultSet(rs);
				closeStatement(stmt);
				closeConnection(con);
			}
			return answers;
		}
		
}
		
		
