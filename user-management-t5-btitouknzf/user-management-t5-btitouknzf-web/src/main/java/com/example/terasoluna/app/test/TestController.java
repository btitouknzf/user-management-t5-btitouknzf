package com.example.terasoluna.app.test;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.terasoluna.domain.model.UserRoleInfo;
import com.example.terasoluna.domain.service.shared.UserRoleInfoSharedService;
import com.example.terasoluna.domain.service.userdetails.SampleUserDetails;

@Controller
public class TestController {
	
	@Inject
	UserRoleInfoSharedService userRoleSharedService;
	
	@ModelAttribute
	public TestRoleForm setUpForm(){
		TestRoleForm form = new TestRoleForm();
		return form;
	}
	
	@RequestMapping(value = "test" ,params = "lookrole")
	public String lookRole(@AuthenticationPrincipal SampleUserDetails sampleUserDetails, Model model){
		
		Collection<UserRoleInfo> role = userRoleSharedService.findRole(sampleUserDetails.getUserInfo().getUserId());
		model.addAttribute("role",role);
		return "test/test";
	}

}
