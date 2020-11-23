package com.cg.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InsuredController {
	
	@RequestMapping(value= "/claimCreationredirect", method = RequestMethod.POST)
	public String claimCreationRedirect(@RequestParam int policyNo, HttpSession ses) {
		
		ses.setAttribute("POLICYNO_FOR_CLAIMCREATION", policyNo);
		
		return "ClaimCreation";
	}

}
