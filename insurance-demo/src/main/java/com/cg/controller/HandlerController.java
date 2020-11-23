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
public class HandlerController {
	PolicyService policyService;
	@Autowired
	public HandlerController(PolicyService policyService) {
		this.policyService = policyService;
	}

	@RequestMapping(value= "/viewUserredirect", method = RequestMethod.POST)
	public String viewCustomerOfHandler(@RequestParam int accNo, HttpSession ses) {
		
		ArrayList<Policy> policyList = policyService.getPolicyDetails(accNo);
		
		if(!policyList.isEmpty()) {
			ses.setAttribute("POLICY_DATA", policyList);
			return "InsuredSuccess";
		} else  {
			return "InsuredFailure";
		}
	
	}

}
