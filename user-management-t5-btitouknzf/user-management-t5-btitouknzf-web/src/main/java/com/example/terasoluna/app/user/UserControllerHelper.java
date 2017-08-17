package com.example.terasoluna.app.user;

import org.joda.time.DateTime;

import com.example.terasoluna.domain.model.UserInfo;
import com.example.terasoluna.domain.model.UserRoleInfo;
import com.example.terasoluna.domain.model.UserSearchInfo;

public class UserControllerHelper {
	public UserSearchInfo makeUserSearchInfo(SearchForm form){
		UserSearchInfo userSearchInfo = new UserSearchInfo();
		
		userSearchInfo.setUserid(form.getUserid());
		userSearchInfo.setUsername(form.getUsername());
		userSearchInfo.setBirthday(form.getBirthday());
		userSearchInfo.setAddress(form.getAddress());
		userSearchInfo.setTellphone(form.getTellphone());
		
		System.out.println(form.getUserid());
		System.out.println(form.getUsername());
		System.out.println(form.getBirthday());
		System.out.println(form.getAddress());
		System.out.println(form.getTellphone());
		System.out.println(form.getRole());
		System.out.println(form.getState());
		
		/*
		if(form.getUserid().equals("")){
			userSearchInfo.setUserid(null);
		}else{
			userSearchInfo.setUserid(form.getUserid());
		}
		
		if(form.getUsername().equals("")){
			userSearchInfo.setUsername(null);
		}else{
			userSearchInfo.setUsername(form.getUsername());
		}
		
		if(form.getBirthday().equals("")){
			userSearchInfo.setBirthday(null);
		}else{
			userSearchInfo.setBirthday(form.getBirthday());
		}
		
		if(form.getAddress().equals("")){
			userSearchInfo.setAddress(null);
		}else{
			userSearchInfo.setAddress(form.getAddress());
		}
		
		if(form.getTellphone().equals("")){
			userSearchInfo.setTellphone(null);
		}else{
			userSearchInfo.setTellphone(form.getTellphone());
		}
		*/
		
		
		if(form.getRole().equals("ADMN")){
			userSearchInfo.setRole(0);
		}else if(form.getRole().equals("USER")){
			userSearchInfo.setRole(1);
		}else{
			userSearchInfo.setRole(2);
		}
		
		if(form.getState().equals("ACTV")){
			userSearchInfo.setState(0);
		}else if(form.getState().equals("INIT")){
			userSearchInfo.setState(1);
		}else if(form.getState().equals("RMVD")){
			userSearchInfo.setState(2);
		}else{
			userSearchInfo.setState(3);
		}
		
		return userSearchInfo;
	}
	
	public UserInfo makeUserInfoUpdate(UpdateForm form){
		UserInfo userInfo = new UserInfo();
		
		userInfo.setUserId(form.getUserid());
		userInfo.setUsername(form.getUsername());
		userInfo.setBirthday(form.getBirthday());
		userInfo.setAddress(form.getAddress());
		userInfo.setTellphone(form.getTellphone());
		
		DateTime updatedate = new DateTime();
		userInfo.setUpdatedate(updatedate);
		
		userInfo.setState(0);
		
		return userInfo;
	}
	
	public UserInfo makeUserInfoDelete(DeleteForm form){
		UserInfo userInfo = new UserInfo();
		
		userInfo.setUserId(form.getUserid());
		userInfo.setState(2);
		
		DateTime updatedate = new DateTime();
		userInfo.setUpdatedate(updatedate);
		
		return userInfo;
	}
	
	public UserRoleInfo makeUserRoleUpdate(UpdateForm form){
		UserRoleInfo userRoleInfo = new UserRoleInfo();
		
		userRoleInfo.setUserid(form.getUserid());
		userRoleInfo.setRole(form.getRole());
		
		return userRoleInfo;
	}
	
	public UserRoleInfo makeUserRoleDelete(DeleteForm form){
		UserRoleInfo userRoleInfo = new UserRoleInfo();
		
		userRoleInfo.setUserid(form.getUserid());
		userRoleInfo.setRole(form.getRole());
		
		return userRoleInfo;
	}
	
}
