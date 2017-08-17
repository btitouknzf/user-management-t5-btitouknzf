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

import com.example.terasoluna.domain.model.SearchResult;
import com.example.terasoluna.domain.model.UserRoleInfo;
import com.example.terasoluna.domain.model.UserSearchInfo;
import com.example.terasoluna.domain.model.UserSearchResultInfo;
import com.example.terasoluna.domain.service.shared.UserInfoSharedService;
import com.example.terasoluna.domain.service.shared.UserRoleInfoSharedService;
import com.example.terasoluna.domain.service.shared.UserSearchResultInfoSharedService;
import com.example.terasoluna.domain.service.shared.UserSearchResultInfoSharedServiceImpl;

@Controller
@SessionAttributes("SearchForm")
@RequestMapping("user")
public class UserController {
	
	@Inject
	UserSearchResultInfoSharedService userSearchResultInfoSharedService;
	
	@Inject
	UserInfoSharedService userInfoSharedService;
	
	@Inject
	UserRoleInfoSharedService userRoleInfoSharedService;
	
	@Inject
	SearchResult searchResult;
	
	@ModelAttribute(value = "searchForm")
	public SearchForm setUpSearchForm(){
		return new SearchForm();
	}
	
	@ModelAttribute(value = "updateForm")
	public UpdateForm setUpUpdateForm(){
		return new UpdateForm();
	}
	
	@ModelAttribute(value = "deleteForm")
	public DeleteForm setUpDeleteForm(){
		return new DeleteForm();
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
		
		searchResult.setUsersearchResultInfo(userSearchResultInfoSharedService.findSearchResult(userControllerHelper.makeUserSearchInfo(form)));
		
		/* Collection<UserSearchResultInfo> resultInfo = userSearchResultInfoSharedService.findSearchResult(userControllerHelper.makeUserSearchInfo(form)); */
		model.addAttribute("resultInfo",searchResult.getUserSearchResultInfo());
		return "user/searchList";
	}
	
	
	@RequestMapping(value = "search", method = RequestMethod.POST, params = "update")
	public String UpdateUserInfo(@Validated UserSelectForm selectform, BindingResult result, Model model, SearchForm form){
		
		if(result.hasErrors()){
			/*UserControllerHelper userControllerHelper = new UserControllerHelper();
			Collection<UserSearchResultInfo> resultInfo = userSearchResultInfoSharedService.findSearchResult(userControllerHelper.makeUserSearchInfo(form));
			model.addAttribute("resultInfo",resultInfo);
			*/
			model.addAttribute("resultInfo",searchResult.getUserSearchResultInfo());
			return "user/searchList";
		}
		
		System.out.println(selectform.getRadioselect());
		System.out.println(searchResult.getSelectUserSearchResultInfo(selectform.getRadioselect()).getUserid());
		System.out.println(searchResult.getSelectUserSearchResultInfo(selectform.getRadioselect()).getUsername());
		System.out.println(searchResult.getSelectUserSearchResultInfo(selectform.getRadioselect()).getBirthday());
		System.out.println(searchResult.getSelectUserSearchResultInfo(selectform.getRadioselect()).getAddress());
		System.out.println(searchResult.getSelectUserSearchResultInfo(selectform.getRadioselect()).getRole());
		System.out.println(searchResult.getSelectUserSearchResultInfo(selectform.getRadioselect()).getTellphone());
		System.out.println(searchResult.getSelectUserSearchResultInfo(selectform.getRadioselect()).getState());
		
		
		model.addAttribute("selectResultInfo",searchResult.getSelectUserSearchResultInfo(selectform.getRadioselect()));
		model.addAttribute("selectNumber",selectform.getRadioselect());
		
		return "user/updateConfirm";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.POST, params = "remove")
	public String RemoveUserInfo(@Validated UserSelectForm selectform, BindingResult result, Model model, SearchForm form){
		
		if(result.hasErrors()){
			/*UserControllerHelper userControllerHelper = new UserControllerHelper();
			Collection<UserSearchResultInfo> resultInfo = userSearchResultInfoSharedService.findSearchResult(userControllerHelper.makeUserSearchInfo(form));
			model.addAttribute("resultInfo",resultInfo);
			*/
			model.addAttribute("resultInfo",searchResult.getUserSearchResultInfo());
			return "user/searchList";
		}
		
		System.out.println(selectform.getRadioselect());
		
		
		model.addAttribute("selectResultInfo",searchResult.getSelectUserSearchResultInfo(selectform.getRadioselect()));
		return "user/removeConfirm";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.POST, params = "back")
	public String backUserInfo(Model model, UserSelectForm form){
		
		model.addAttribute("resultInfo",searchResult.getUserSearchResultInfo());
		return "user/searchList";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.POST, params = "backSearch")
	public String backUserInfoSearch(@ModelAttribute UserSelectForm userSelectForm){
		
		searchResult.clear();
		return "user/searchForm";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.POST, params = "updateFinish")
	public String UpdateFinish(@Validated UpdateForm form, BindingResult result, Model model){
		
		System.out.println(form.getSelectNumber());
		System.out.println(form.getUserid());
		System.out.println(form.getUsername());
		System.out.println(form.getBirthday());
		System.out.println(form.getAddress());
		System.out.println(form.getTellphone());
		System.out.println(form.getRole());
		System.out.println(result.hasErrors());
		if(result.hasErrors()){
			/*UserControllerHelper userControllerHelper = new UserControllerHelper();
			Collection<UserSearchResultInfo> resultInfo = userSearchResultInfoSharedService.findSearchResult(userControllerHelper.makeUserSearchInfo(form));
			model.addAttribute("resultInfo",resultInfo);
			*/
			model.addAttribute("selectResultInfo",searchResult.getSelectUserSearchResultInfo(form.getSelectNumber()));
			return "user/updateConfirm";
		}
		
		UserControllerHelper userControllerHelper = new UserControllerHelper();
		
		
		if(userInfoSharedService.userInfoUpdate(userControllerHelper.makeUserInfoUpdate(form))){
			Collection<UserRoleInfo> userRole = userRoleInfoSharedService.findRole(form.getUserid());
			int roleCheck = 0;
			for(UserRoleInfo s:userRole){
				System.out.println(s.getRole());
				if(s.getRole().equals(form.getRole())){
					roleCheck = 1;
				}
			}
			if(roleCheck == 0){
				userRoleInfoSharedService.userRoleUpdate(userControllerHelper.makeUserRoleUpdate(form));
			}
		}
		searchResult.clear();
		return "user/Finish";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.POST, params = "deleteFinish")
	public String DeleteFinish(DeleteForm form, Model model){
		
		System.out.println(form.getUserid());
		System.out.println(form.getRole());
		
		
		UserControllerHelper userControllerHelper = new UserControllerHelper();
		
		userInfoSharedService.userInfoDeleteState(userControllerHelper.makeUserInfoDelete(form));
		
		/*
		if(userRoleInfoSharedService.userRoleDelete(userControllerHelper.makeUserRoleDelete(form))){
			if(userRoleInfoSharedService.userRoleCount(form.getUserid()) == 0){
				userInfoSharedService.userInfoDelete(form.getUserid());
			}
		}
		*/
		
		searchResult.clear();
		return "user/Finish";
	}
	
	
}
