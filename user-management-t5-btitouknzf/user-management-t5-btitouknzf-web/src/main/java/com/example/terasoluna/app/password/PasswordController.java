package com.example.terasoluna.app.password;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Mapper;
import org.joda.time.DateTime;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.terasoluna.domain.model.UserInfo;
import com.example.terasoluna.domain.service.shared.UserInfoSharedService;
import com.example.terasoluna.domain.service.shared.UserInfoSharedServiceImpl;
import com.example.terasoluna.domain.service.userdetails.SampleUserDetails;

@Controller
@SessionAttributes(value = {"passwordUpdateForm"})
public class PasswordController {
	
	@Inject
	UserInfoSharedService userInfoSharedService;
	
	@Inject
	PasswordEqualsValidator passwordEqualsValidator;
	
	@Inject
	PasswordEncoder passwordEncoder;
	
	@ModelAttribute(value = "passwordUpdateForm")
	public PasswordUpdateForm setUpPasswordForm(){
		return new PasswordUpdateForm();
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(passwordEqualsValidator);
	}
	
	@RequestMapping(value = "password/change", params = "changepassword")
	public String chengePassword(@AuthenticationPrincipal SampleUserDetails sampleUserDetails, @Validated PasswordUpdateForm form, BindingResult result){
		if(result.hasErrors()){
			return "password/changeForm";
		}
		DateTime dt = new DateTime();
		String passwordencode = passwordEncoder.encode(form.getPassword1());
		UserInfo userInfo = sampleUserDetails.getUserInfo();
		userInfo.setPassword(passwordencode);
		userInfo.setState(1);
		userInfo.setUpdatedate(dt);
		
		userInfoSharedService.passwordUpdate(userInfo);
		
		return "password/Finish";
	}
	
	
}
