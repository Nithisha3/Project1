package com.cg.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.entity.Answers;
import com.cg.entity.Questions;

@Component
public class ClaimQuestionDao extends Dao {
	
			public HashMap<Questions, ArrayList<Answers>> getClaimquestionsandAnswers() {
				boolean status = false;
				
				Connection con = openConnection();
				Statement stmt = null;
				ResultSet rs = null;
				HashMap<Questions, ArrayList<Answers>> questionAnswerMap = new HashMap<Questions, ArrayList<Answers>>();
				
				try {
					stmt = con.createStatement();
					
					String sql = "SELECT * FROM QUESTIONS";
					rs = stmt.executeQuery(sql);
					
					while (rs.next()) {
						Questions questions = new Questions();
						
						questions.setQuestionId(rs.getInt(1));
						questions.setQuestion(rs.getString(2));
						
						questionAnswerMap.put(questions, getAnswers(questions.getQuestionId()));
						
					}
					
				}  catch (SQLException se) {
					se.printStackTrace();
					
				} finally {
					closeResultSet(rs);
					closeStatement(stmt);
					closeConnection(con);
				}
				return questionAnswerMap;
			}
			
			
			public ArrayList<Answers> getAnswers(int questionId) {
				
				Connection con = openConnection();
				Statement stmt = null;
				ResultSet rs = null;
				ArrayList<Answers> ansArrayList = new ArrayList<Answers>();
				
				try {
						stmt = con.createStatement();	
						
						String sql = "SELECT * FROM ANSWESRTOQUESTIONS WHERE QUESTIONID = " + questionId;
						rs = stmt.executeQuery(sql);
						while(rs.next()) {
							Answers answers = new Answers();
							answers.setAnswerId(rs.getInt(1));
							answers.setAnswer(rs.getString(2));
							answers.setWeightage(rs.getInt(3));
							answers.setQuestionId(rs.getInt(4));
							
							ansArrayList.add(answers);
							
						}
				
					
				}  catch (SQLException se) {
					se.printStackTrace();
					
				} finally {
					closeResultSet(rs);
					closeStatement(stmt);
					closeConnection(con);
				}
				return ansArrayList;
			}

	}


