package com.tmobile.devops.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class ValidEmailConstraintValidator implements ConstraintValidator<ValidEmail, String > {
    
	private String email;
	@Override
	public void initialize(ValidEmail constraintAnnotation) {
		// TODO Auto-generated method stub
		email = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		//check the condition
		String pattern = "^.*?\\@.*\\..*$" ;
						  
		//create pattern object 
		Pattern emailPattern  = Pattern.compile(pattern);
		Matcher match = emailPattern.matcher(email);
		
		if ( match.find() ){
			System.out.println("Found the matcher for email Pattern.");
			return true;
		}else {
			System.out.println("Doesn't match the pattern of email.");
			return false;
		}
	}

}
