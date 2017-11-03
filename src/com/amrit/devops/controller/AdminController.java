package com.tmobile.devops.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tmobile.devops.dto.CredentialsDTO;
import com.tmobile.devops.dto.UserInfoDTO;
import com.tmobile.devops.entity.User;

import com.tmobile.devops.service.UserService;
import com.tmobile.devops.validation.FieldsValueMatchValidator;

@Controller

public class AdminController {


	@Autowired
	private UserService theUserService;
	
	
	@GetMapping("/admin") 
	   public String ListUsers(Model theModel){
			//get customers from dao
			List<User> users = theUserService.getUsers();
			
			//add customers to the model
			theModel.addAttribute("users",users);
			
			return "admin";
		}
	
	@RequestMapping("admin/editUser")
	public String editUser(@RequestParam("username") String username, Model model){
		System.out.println("I am trying to show the user jsp using the username " + username);
		User user = theUserService.getUser(username);
		
		model.addAttribute("user",user);
		return "user";
	}

	
	@PostMapping("admin/updateUser")
	public String updateUser( @Valid @ModelAttribute("user") UserInfoDTO user,BindingResult result){


		   //grabs the attribute from the form and passes it to user service method
           if (result.hasErrors()){
        	   return "user";
           }
        	theUserService.updateUser(user);
        	return "redirect:/admin";
		 }
  
	@GetMapping("/admin/deleteUser")	
	public String deleteCustomer(@RequestParam("username") String username, Model model){
		// delete the customer from our service
		theUserService.deleteUser(username);

		return "redirect:/admin";
		
	}
	
	@PostMapping("/admin/changePassword")	
	public String changePassword(@Valid @ModelAttribute("user")CredentialsDTO user, Model model,BindingResult result){
		// delete the customer from our service
		  //grabs the attribute from the form and passes it to user service method
        if (result.hasErrors()){
     	   return "user";
        }

		theUserService.changePassword(user);

		return "redirect:/admin";
		
	}
	
}
