package com.cg.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.entity.Policy;
import com.cg.entity.UserRole;
import com.cg.services.ClaimService;
import com.cg.services.PolicyService;
import com.cg.services.UserService;

@Controller
public class AdjusterController {
	ClaimService claimService;
	PolicyService policyService;
	UserService userService;
	
	boolean status = false;
	
	@Autowired
	public AdjusterController(ClaimService claimService, 
			PolicyService policyService,
			UserService userService) {
		this.claimService = claimService;
		this.policyService = policyService;
		this.userService = userService;
	}
	

	@RequestMapping(value= "/createClaimByAdjuster", method = RequestMethod.POST)
	public String createClaimByAdjuster(@RequestParam int accNo,
			HttpSession ses) {
		
		ArrayList<Policy> policyList = policyService.getPolicyDetails(accNo);
		
		if(!policyList.isEmpty()) {
			ses.setAttribute("POLICY_DATA", policyList);
			return "InsuredSuccess";
		} else  {
			return "InsuredFailure";
		}
	
	}
	
	@RequestMapping(value= "/createUserRole", method = RequestMethod.POST)
	public String createUserRole(@RequestParam String userName,
			@RequestParam String pwd,
			@RequestParam String roleCode,
			HttpSession ses) {
		
		UserRole userRole = new UserRole();
		
		userRole.setUserName(userName);
		userRole.setPassword(pwd);
		userRole.setRoleCode(roleCode);
		boolean status = userService.addUser(userRole);
		
		if(status) {
			return "UserCreatedSuccess";
		} else  {
			return "UserCreatedFailure";
		}
	
	}
	

}
