package com.team.app.validator;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.team.app.model.Login;

@Component
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Login.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Login login = (Login) arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "loginid", "loginid.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "password", "password.empty");

	}

}
