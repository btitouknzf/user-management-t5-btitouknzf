package com.example.terasoluna.domain.service.shared;

import org.joda.time.DateTime;
import org.springframework.data.repository.query.Param;

import com.example.terasoluna.domain.model.UserInfo;

public interface UserInfoSharedService {
	UserInfo findOne(String userid);
	
	boolean passwordUpdate(UserInfo userInfo);
	
	/*
	boolean passwordUpdate(
			String userid,
			String password,
			int state,
			DateTime updatedate);
	*/
}
