package com.cg.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.entity.Answers;
import com.cg.entity.Claim;
import com.cg.entity.Questions;
import com.cg.services.ClaimService;

@Controller
public class GenerateReportController {
	ClaimService claimService;
	
	@Autowired
	public GenerateReportController(ClaimService claimService) {
		this.claimService = claimService;
	}
	
	@RequestMapping(value= "/genrateReport", method = RequestMethod.POST)
	public String claimCreationRedirect(@RequestParam int claimId, 
			HttpSession ses) {
		Claim claim = claimService.viewClaimDetailsForAdjuster(claimId);
		if(claim != null) {
			ses.setAttribute("VIEW_CLAIM_DATA", claim);	
			HashMap<Questions, Answers> claimQuestionAnswerMap = 
					claimService.viewClaimQuestionsAndAnswers(claimId);
			
			ses.setAttribute("CLAIM_QUESTION_ANSWER_MAP", claimQuestionAnswerMap);
				
			return "GenerateReport";
		} else  {
			return "ViewClaimFailure";
		}
			
		
	}
	
	
	

}
