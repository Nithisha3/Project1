package com.cg.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.entity.Claim;
import com.cg.entity.ClaimQuestionsAndAnswers;
import com.cg.services.ClaimService;

@Controller
public class ClaimQuestionsController {

	ClaimService claimService;
	
	@Autowired
	public ClaimQuestionsController(ClaimService claimService) {
		this.claimService = claimService;
	}
	
	
	@RequestMapping(value= "/claimQuestion", method = RequestMethod.POST)
	public String claimCreation(HttpServletRequest request,
			@RequestParam int questionLength,
			@RequestParam int claimId,
			HttpSession ses) {
		
		boolean status = false;
		int totalWeightage = 0;
		
	
		ArrayList<ClaimQuestionsAndAnswers> claimQuestionsAndAnswersList = new ArrayList<ClaimQuestionsAndAnswers>();
		for(int i = questionLength; i > 0; i-- ) {
			ClaimQuestionsAndAnswers claimQuestionsAndAnswers = new ClaimQuestionsAndAnswers();
			
			String paramName = "count" + i;
			String questionId = request.getParameter(paramName);
			String answerFromReq = request.getParameter(questionId);
			
			String answerId = answerFromReq.split(":")[0];
			int weightage = Integer.parseInt(answerFromReq.split(":")[1]);
			totalWeightage = weightage + totalWeightage;
			
			claimQuestionsAndAnswers.setQuestionId(Integer.parseInt(questionId));
			claimQuestionsAndAnswers.setAnswerId(Integer.parseInt(answerId));
			claimQuestionsAndAnswers.setClaimId(claimId);
			claimQuestionsAndAnswers.setWeightage(weightage);
			
			claimQuestionsAndAnswersList.add(claimQuestionsAndAnswers);
			
		}
		
		status = claimService.insertClaimQuestionsAndAnswers(claimQuestionsAndAnswersList);
		
		boolean claimUpdateStatus = claimService.UpdateClaim(claimId, totalWeightage);
		
		if(status && claimUpdateStatus) {
			ses.setAttribute("CLAIM_ID", claimId);
			return "ClaimCreationSuccess";
		} else {
			
			return "ClaimCreationFailure";	
		}
	}

}
