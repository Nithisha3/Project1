package com.cg.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.entity.Answers;
import com.cg.entity.Claim;
import com.cg.entity.Policy;
import com.cg.entity.Questions;
import com.cg.entity.UserRole;
import com.cg.services.ClaimService;
import com.cg.services.PolicyService;

@Controller
public class ClaimCreationController {
	
	ClaimService claimService;
	
	
	@Autowired
	public ClaimCreationController(ClaimService claimService) {
		this.claimService = claimService;
	}
	
	
	//METHOD WHICH CALLS METHOD IN SERVICE PACKAGE TO CREATE THE CLAIM.
			@RequestMapping(value= "/claimCreation", method = RequestMethod.POST)
			public String claimCreation(@RequestParam String claimReason, 
					@RequestParam String accidentLocStreet,
					@RequestParam String accidentCity,
					@RequestParam String accidentState,
					@RequestParam int accidentZip,
					@RequestParam String claimType,
					@RequestParam int policyNo,
					HttpSession ses) {
				
				
				
				Claim claim = new Claim();
				claim.setClaimId(generateClaimId());
				claim.setClaimReason(claimReason);
				claim.setaccidentLocationStreet(accidentLocStreet);
				claim.setAccidentCity(accidentCity);
				claim.setAccidentState(accidentState);
				claim.setAccidentZip(accidentZip);
				claim.setClaimType(claimType);
				claim.setPolicyNumber(policyNo);
				
				boolean status = claimService.createClaim(claim);
				System.out.println(status);
				
				if(status) {
					ses.setAttribute("CLAIM_DATA", claim);
					ses.setAttribute("CLAIM_QUESTION_ANSWERS", generateClaimQuestionsAnsAnswers());
					
					return "ClaimQuestions";
				} else {
					
					return "ClaimCreationFailure";	
				}
			}
			
			public HashMap<Questions, ArrayList<Answers>> generateClaimQuestionsAnsAnswers() {
				return claimService.getClaimQuestionAndAnswers();
			}
			
			public int generateClaimId() {
		        int max = 10000; 
		        int min = 1; 
		        int range = max - min + 1; 
		        int rand = 0;
		  
		        // generate random numbers within 1 to 10 
		        for (int i = 0; i < 10000; i++) { 
		            rand = (int)(Math.random() * range) + min;
		         
		        } 
		        return rand;
				
			}
		
}
