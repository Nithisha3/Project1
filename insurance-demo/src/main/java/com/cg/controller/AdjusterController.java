package com.cg.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.entity.Policy;
import com.cg.services.ClaimService;
import com.cg.services.PolicyService;

@Controller
public class AdjusterController {
	ClaimService claimService;
	PolicyService policyService;
	
	boolean status = false;
	
	@Autowired
	public AdjusterController(ClaimService claimService, PolicyService policyService) {
		this.claimService = claimService;
		this.policyService = policyService;
	}
	

	@RequestMapping(value= "/createClaimByAdjuster", method = RequestMethod.POST)
	public String viewCustomerOfHandler(@RequestParam int accNo,
			HttpSession ses) {
		
		ArrayList<Policy> policyList = policyService.getPolicyDetails(accNo);
		
		if(!policyList.isEmpty()) {
			ses.setAttribute("POLICY_DATA", policyList);
			return "InsuredSuccess";
		} else  {
			return "InsuredFailure";
		}
	
	}
	

}
