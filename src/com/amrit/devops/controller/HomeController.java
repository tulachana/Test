package com.tmobile.devops.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {
	@RequestMapping("/")
	public String showHomePage(){
		
		return "home";
	}
	@RequestMapping("/denied")
	public String showDenied(){
		
		return "denied";
	}
	
}
