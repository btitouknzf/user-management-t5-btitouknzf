package com.example.terasoluna.app.password;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PasswordEqualsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO 自動生成されたメソッド・スタブ
		return PasswordUpdateForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO 自動生成されたメソッド・スタブ
		
		if(errors.hasFieldErrors("password1")){
			return;
		}

		PasswordUpdateForm form = (PasswordUpdateForm) target;
		String password1 = form.getPassword1();
		String password2 = form.getPassword2();
		
		if(!password1.equals(password2)){
			errors.rejectValue("password1", "PasswordEqualsValidator.passwordUpdateForm.password1","password1 and password2 must be same.");
		}
	}
}
