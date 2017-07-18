package com.example.terasoluna.domain.repository;

import com.example.terasoluna.domain.model.UserInfo;

public interface UserInfoRepository {
	UserInfo findOne(String userid);

	boolean passwordUpdate(UserInfo userInfo);
	
	/*
	boolean passwordUpdate(
			@Param("userId") String userid,
			@Param("passWord") String password,
			@Param("state") int state,
			@Param("updateDate") DateTime updatedate);
	*/

}
