package com.cg.services;

import java.util.ArrayList;
import java.util.HashMap;

import com.cg.entity.Answers;
import com.cg.entity.Claim;
import com.cg.entity.ClaimQuestionsAndAnswers;
import com.cg.entity.Questions;

public interface ClaimService {
	
	boolean createClaim(Claim claim);
	boolean UpdateClaim(int claimId, int  claimNumber);
	
	boolean insertClaimQuestionsAndAnswers(ArrayList<ClaimQuestionsAndAnswers> claimQuestionsAndAnswersList);
	
	HashMap<Questions, ArrayList<Answers>> getClaimQuestionAndAnswers();
	
	 Claim viewClaimDetailsForInsuredAndHandler(int claimId, String userName) ;
	 
	 Claim viewClaimDetailsForAdjuster(int claimId);
	 
	 HashMap<Questions, Answers> viewClaimQuestionsAndAnswers(int claimId);

}
