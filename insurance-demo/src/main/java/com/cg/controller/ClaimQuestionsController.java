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
			@RequestParam int claimNo,
			HttpSession ses) {
		
		boolean status = false;
		
	
		ArrayList<ClaimQuestionsAndAnswers> claimQuestionsAndAnswersList = new ArrayList<ClaimQuestionsAndAnswers>();
		for(int i = questionLength; i > 0; i-- ) {
			ClaimQuestionsAndAnswers claimQuestionsAndAnswers = new ClaimQuestionsAndAnswers();
			
			String paramName = "questionId" + i;
			String questionId = request.getParameter(paramName);
			String answerId = request.getParameter(questionId);
			
			claimQuestionsAndAnswers.setQuestionId(Integer.parseInt(questionId));
			claimQuestionsAndAnswers.setAnswerId(Integer.parseInt(answerId));
			claimQuestionsAndAnswers.setClaimNumber(claimNo);
			
			claimQuestionsAndAnswersList.add(claimQuestionsAndAnswers);
			
		}
		
		status = claimService.insertClaimQuestionsAndAnswers(claimQuestionsAndAnswersList);
		
		
		if(status) {
			
			return "ClaimCreationSuccess";
		} else {
			
			return "ClaimCreationFailure";	
		}
	}


}
