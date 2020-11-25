package com.cg.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

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
	/* Get actual class name to be printed on */
	private static Logger log = Logger.getLogger(UserLoginController.class.getName());
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
			final String METHOD_NAME = "loginProcess";
			log.info("Entered the method" + METHOD_NAME);

			UserRole user = new UserRole();
			user.setUserName(mail);
			user.setPassword(pwd);
			
			boolean status = userService.login(user);
			log.info("The User login Validation is" + status);
			
			if(status) {
				ses.setAttribute("USER_DATA", user);
				log.info("The logged in user is " + user.getUserName() + " role code is " + user.getRoleCode());
				if(user.getRoleCode().equals("INSURED")) {
					Accounts accounts = accountsService.getAccountDetails(user.getUserName());
					
					ArrayList<Policy> policyList = policyService.getPolicyDetails(accounts.getAccountNumber());
					
					if(!policyList.isEmpty()) {
						ses.setAttribute("POLICY_DATA", policyList);
						log.info("The returned page on success is InsuredSuccess.jsp " );
						return "InsuredSuccess";
					} else  {
						log.info("The returned page on failure is InsuredFailure.jsp " );

						return "InsuredFailure";
					}
				} else if(user.getRoleCode().equals("HANDLER")) {
					ArrayList<Accounts> accountsList = accountsService.getAccountDetailsforHandler(user.getUserName());
					
					if(!accountsList.isEmpty()) {
						ses.setAttribute("CUSTOMERS_OF_HANDLER", accountsList);
						log.info("The returned page on failure is HandlerSuccess.jsp " );

						return "HandlerSuccess";
					} else  {
						log.info("The returned page on failure is HandlerFailure.jsp " );

						return "HandlerFailure";
					}
					
				} else if(user.getRoleCode().equals("ADJUSTER")) {
					log.info("The returned page on failure is AdjusterSuccess.jsp " );

					return "AdjusterSuccess";
					
				}
			} 
			log.info("The returned page on failure is LoginFailure.jsp " );

				return "LoginFailure";	
		}
			
		

}
