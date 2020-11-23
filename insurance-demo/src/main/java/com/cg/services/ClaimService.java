package com.cg.services;

import java.util.ArrayList;
import java.util.HashMap;

import com.cg.entity.Answers;
import com.cg.entity.Claim;
import com.cg.entity.ClaimQuestionsAndAnswers;
import com.cg.entity.Questions;

public interface ClaimService {
	
	boolean createClaim(Claim claim);
	
	boolean insertClaimQuestionsAndAnswers(ArrayList<ClaimQuestionsAndAnswers> claimQuestionsAndAnswersList);
	
	Claim viewClaim(String claimNo);
	
	HashMap<Questions, ArrayList<Answers>> getClaimQuestionAndAnswers();

}
