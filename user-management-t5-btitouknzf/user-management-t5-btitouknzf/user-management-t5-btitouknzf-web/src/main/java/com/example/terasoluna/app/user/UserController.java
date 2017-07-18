package com.example.terasoluna.app.user;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.terasoluna.domain.model.UserSearchInfo;
import com.example.terasoluna.domain.model.UserSearchResultInfo;
import com.example.terasoluna.domain.service.shared.UserSearchResultInfoSharedService;
import com.example.terasoluna.domain.service.shared.UserSearchResultInfoSharedServiceImpl;

@Controller
@SessionAttributes("SearchForm")
@RequestMapping("user")
public class UserController {
	
	@Inject
	UserSearchResultInfoSharedService userSearchResultInfoSharedService;
	
	@ModelAttribute(value = "searchForm")
	public SearchForm setUpSearchForm(){
		return new SearchForm();
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String SearcUserForm(){
		return "user/searchForm";
	}
	
	
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String SearchUser(@Validated SearchForm form, BindingResult result, Model model, @ModelAttribute UserSelectForm userSelectForm){
		if(form.getUserid().length() > 0 ){
			if(form.getUserid().length() != 4 ){
				result.rejectValue("userid", null, "size must be 4");
			}
		}
		
		if(form.getTellphone().length() > 0 ){
			if(form.getTellphone().length() != 10 || form.getTellphone().length() != 11){
				result.rejectValue("tellphone", null, "size must be 10 or 11");
			}
		}
		
		if(result.hasErrors()){
			return "user/searchForm";
		}
		
		UserControllerHelper userControllerHelper = new UserControllerHelper();
		
		Collection<UserSearchResultInfo> resultInfo = userSearchResultInfoSharedService.findSearchResult(userControllerHelper.makeUserSearchInfo(form));
		model.addAttribute("resultInfo",resultInfo);
		return "user/searchList";
	}
	
	
	@RequestMapping(value = "search", method = RequestMethod.POST, params = "update")
	public String RemoveUserInfo(@Validated UserSelectForm selectform, BindingResult result, Model model, SearchForm form){
		
		if(result.hasErrors()){
			/*UserControllerHelper userControllerHelper = new UserControllerHelper();
			Collection<UserSearchResultInfo> resultInfo = userSearchResultInfoSharedService.findSearchResult(userControllerHelper.makeUserSearchInfo(form));
			model.addAttribute("resultInfo",resultInfo);
			*/
			return "user/searchList";
		}
		
		System.out.println(selectform.getRadioselect());
		
		
		
		return "user/searchList";
	}
	

	
}
