package com.example.terasoluna.domain.service.userdetails;



import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.example.terasoluna.domain.model.UserInfo;

public class SampleUserDetails extends User {
	private static final long serialVersionUID = 1L;
	private final UserInfo userInfo;
	
	
	public SampleUserDetails(UserInfo userInfo, String[] userRoleString){
		super(userInfo.getUserId(), userInfo.getPassword(), AuthorityUtils.createAuthorityList(userRoleString));
		this.userInfo = userInfo;
	}
	
	/*
	public SampleUserDetails(UserInfo userInfo){
		super(userInfo.getUserId(), userInfo.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.userInfo = userInfo;
	}
	*/
	public UserInfo getUserInfo(){
		return userInfo;
	}
	

}
