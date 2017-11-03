package com.tmobile.devops.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidPasswordConstraintValidator.class)
@Documented
public @interface ValidPassword {
	//Define default message
	 public String message() default "Passwords donot match.";
	 
	 //define default email address for example
	// public String value() default "abc@example.com";
     
	    Class<?>[] groups() default {};

	    Class<? extends Payload>[] payload() default {};
	    
	   
}
