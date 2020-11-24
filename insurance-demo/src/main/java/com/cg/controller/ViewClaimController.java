package com.cg.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.entity.Claim;
import com.cg.services.ClaimService;

@Controller
public class ViewClaimController {
	ClaimService claimService;
	
	
	@Autowired
	public ViewClaimController(ClaimService claimService) {
		this.claimService = claimService;
	}




	@RequestMapping(value= "/viewClaim", method = RequestMethod.POST)
	public String claimCreationRedirect(@RequestParam int claimId, 
			String userName,
			String roleCode,
			HttpSession ses) {
		boolean status = false;
		if(roleCode.equals("INSURED") || roleCode.equals("HANDLER")) {
			Claim claim = claimService.viewClaimDetailsForInsuredAndHandler(claimId, userName);
			if(claim != null) {
				ses.setAttribute("VIEW_CLAIM_DATA", claim);	
				return "ViewClaim";
			} else  {
				return "ViewClaimFailure";
			}
		} else if(roleCode.equals("ADJUSTER")) {
	
			Claim claim = claimService.viewClaimDetailsForAdjuster(claimId);
			if(claim != null) {
				ses.setAttribute("VIEW_CLAIM_DATA", claim);	
				return "ViewClaim";
			} else  {
				return "ViewClaimFailure";
			}
			
		}
		return "";
	}


}
