package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LinkController {
	
	//METHOD WHICH MAPS TO VARIOUS FUNCTIONALITIES IN THE WEB APPLICATION.
	@RequestMapping(value= "/link")
	public String linkProcess(@RequestParam String type){
		String actionValue = type;

		if(actionValue.equals("logout")) {
			return "Logout";
		} else if(actionValue.equals("insuredHome")) {
			return "InsuredSuccess";
		} else if(actionValue.equals("handlerHome")) {
			return "HandlerSuccess";
		} else if(actionValue.equals("adjusterHome")) {
			return "AdjusterSuccess";
		} 
		return " ";
	}	
}
