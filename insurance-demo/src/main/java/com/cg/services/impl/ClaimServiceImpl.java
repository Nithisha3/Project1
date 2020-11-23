package com.cg.services.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.dao.ClaimDao;
import com.cg.dao.ClaimQuestionDao;
import com.cg.entity.Answers;
import com.cg.entity.Claim;
import com.cg.entity.ClaimQuestionsAndAnswers;
import com.cg.entity.Questions;
import com.cg.services.ClaimService;

@Component
public class ClaimServiceImpl implements ClaimService {
	
	boolean status = false;
	ClaimDao claimDao;
	ClaimQuestionDao claimQuestionDao;
	
	@Autowired
	public ClaimServiceImpl(ClaimDao claimDao, ClaimQuestionDao claimQuestionDao) {
		this.claimDao = claimDao;
		this.claimQuestionDao = claimQuestionDao;
	}

	@Override
	public boolean createClaim(Claim claim) {
		boolean status = claimDao.insertClaim(claim);
		return status;
	}

	@Override
	public boolean insertClaimQuestionsAndAnswers(ArrayList<ClaimQuestionsAndAnswers> claimQuestionsAndAnswersList) {
		boolean status = claimDao.insertClaimQuestionsAndAnswers(claimQuestionsAndAnswersList);
		return status;
	}
	@Override
	public Claim viewClaim(String claimNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public HashMap<Questions, ArrayList<Answers>> getClaimQuestionAndAnswers() {
		HashMap<Questions, ArrayList<Answers>> questionAnswerMap = claimQuestionDao.getClaimquestionsandAnswers();
		return questionAnswerMap;
	}

}
