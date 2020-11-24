package com.cg.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.entity.Accounts;
import com.cg.entity.Policy;
import com.cg.entity.UserRole;
import com.cg.services.AccountsService;
import com.cg.services.PolicyService;
import com.cg.services.UserService;

@Controller
public class UserLoginController {
	UserService userService;
	AccountsService accountsService;
	PolicyService policyService;
	
	@Autowired
	public UserLoginController(UserService userService, AccountsService accountsService, PolicyService policyService) {
		this.accountsService = accountsService;
		this.userService = userService;
		this.policyService = policyService;
	}
	
	//METHOD WHICH CALLS METHOD IN SERVICE PACKAGE TO VALIDATE THE USER WHEN SIGNING IN.
		@RequestMapping(value= "/login", method = RequestMethod.POST)
		public String loginProcess(@RequestParam String mail,
				@RequestParam String pwd, 
				HttpSession ses) {

			UserRole user = new UserRole();
			user.setUserName(mail);
			user.setPassword(pwd);
			
			boolean status = userService.login(user);
			
			if(status) {
				ses.setAttribute("USER_DATA", user);
				if(user.getRoleCode().equals("INSURED")) {
					Accounts accounts = accountsService.getAccountDetails(user.getUserName());
					
					ArrayList<Policy> policyList = policyService.getPolicyDetails(accounts.getAccountNumber());
					
					if(!policyList.isEmpty()) {
						ses.setAttribute("POLICY_DATA", policyList);
						return "InsuredSuccess";
					} else  {
						return "InsuredFailure";
					}
				} else if(user.getRoleCode().equals("HANDLER")) {
					ArrayList<Accounts> accountsList = accountsService.getAccountDetailsforHandler(user.getUserName());
					
					if(!accountsList.isEmpty()) {
						ses.setAttribute("CUSTOMERS_OF_HANDLER", accountsList);
						return "HandlerSuccess";
					} else  {
						return "HandlerFailure";
					}
					
				} else if(user.getRoleCode().equals("ADJUSTER")) {
					
					return "AdjusterSuccess";
					
				}
			} 
				
				return "LoginFailure";	
		}
			
		

}
