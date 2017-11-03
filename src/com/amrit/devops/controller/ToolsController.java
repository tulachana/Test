package com.tmobile.devops.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToolsController {
	
	@RequestMapping("/jenkins")
	public String showJenkinsptions(){
		
		return "jenkins/jenkins-options";
	}
	


}
