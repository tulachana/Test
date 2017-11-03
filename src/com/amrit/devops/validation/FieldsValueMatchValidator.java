package com.tmobile.devops.validation;

import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tmobile.devops.entity.User;


@Component
public class FieldsValueMatchValidator implements Validator {

	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User)target;
		
	 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "valid.user.confirmPassword");
	 if (!user.getPassword().equals(user.getConfirmPassword())){
		  System.out.println("Doesn't match password");
		  errors.rejectValue("confirmPassword", "matchPassword.user.confirmPassword");
	 }
	}

	
}
