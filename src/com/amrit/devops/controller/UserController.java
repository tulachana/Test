package com.tmobile.devops.controller;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tmobile.devops.entity.User;
import com.tmobile.devops.entity.UserRole;
import com.tmobile.devops.service.UserService;
import com.tmobile.devops.validation.FieldsValueMatchValidator;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService theUserService;
	@Autowired
    private FieldsValueMatchValidator userValidator;
	
	
	// shows the login page for login
   @RequestMapping("/login")
   public String showLogin(){
	   System.out.println("show some login page");
		// create new model attribute to bind new data
	  // User theUser = new User();
	  // theModel.addAttribute("user",theUser);
	   return "login-form";
   }
   
   
   
   //shows the sign up page for registration
   @GetMapping("/signUp")
   public String showSignUp(Model theModel){
	   System.out.println("show Register page");
	// create new model attribute to bind new data
	   User theUser = new User();
	   theModel.addAttribute("user",theUser);
	   return "signup-form";
   }
   
   // will register or add user info in database
   @PostMapping("/registerUser")
   public String registerUser(@Valid @ModelAttribute("user") User theUser, BindingResult theBindingResult,ModelMap model){
	   //Validation code
	   userValidator.validate(theUser, theBindingResult);
	   if (theBindingResult.hasErrors()){
		  System.out.println("There are some binding errors.");
		  return "signup-form"; 
	   }else {
	   //grabs the attribute from the form and passes it to user service method
	        boolean userExists = theUserService.checkUserExists(theUser.getUserName());
	        if (!userExists){
	           UserRole role = new UserRole();
	        	theUserService.addUser(theUser);
	        	theUserService.setUserRole(role, theUser, "USER");
	        	model.addAttribute("success", "Dear "+ theUser.getFirstName()+" , your Registration has been completed successfully");
	        	return "registration-successful";
	        }else {
	        	System.out.print("Caught Duplicate Name");
	        	theBindingResult.rejectValue("userName", "DuplicateUser.user.userName","This user already Exists!");
	        	return "signup-form";
	        			
	        }
	  
	   }
   }
 
 
 
   //////////////////////////Logout the USer ///////////////////////////////////////////
   @RequestMapping("/logout")
   public String logoutUser(){
	   return "loggedout";
   }



public FieldsValueMatchValidator getUserValidator() {
	return userValidator;
}



public void setUserValidator(FieldsValueMatchValidator userValidator) {
	this.userValidator = userValidator;
}
   
   
}
