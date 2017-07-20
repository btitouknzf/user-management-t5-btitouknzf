package com.example.terasoluna.domain.service.shared;

import javax.inject.Inject;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

import com.example.terasoluna.domain.model.UserInfo;
import com.example.terasoluna.domain.repository.UserInfoRepository;

@Service
@Transactional
public class UserInfoSharedServiceImpl implements UserInfoSharedService {

	@Inject
	UserInfoRepository userInfoRepository;
	
	
	@Transactional(readOnly = true)
	@Override
	public UserInfo findOne(String userid) {
		// TODO 自動生成されたメソッド・スタブ
		UserInfo userInfo = userInfoRepository.findOne(userid);
		
		if(userInfo == null){
			throw new ResourceNotFoundException("The given account is not found! userID=" + userid);
		}
		
		return userInfo;
	}


	@Override
	public boolean passwordUpdate(UserInfo userInfo) {
		// TODO 自動生成されたメソッド・スタブ
		return userInfoRepository.passwordUpdate(userInfo);
	}


	@Override
	public boolean userInfoUpdate(UserInfo userInfo) {
		// TODO 自動生成されたメソッド・スタブ
		return userInfoRepository.userInfoUpdate(userInfo);
	}


	@Override
	public boolean userInfoDelete(String userid) {
		// TODO 自動生成されたメソッド・スタブ
		return userInfoRepository.userInfoDelete(userid);
	}


	@Override
	public boolean userInfoDeleteState(UserInfo userInfo) {
		// TODO 自動生成されたメソッド・スタブ
		return userInfoRepository.userInfoDeleteState(userInfo);
	}
	
	/*
	@Override
	public boolean passwordUpdate(String userid, String password, int state, DateTime updatedate) {
		// TODO 自動生成されたメソッド・スタブ
		return userInfoRepository.passwordUpdate(userid, password, state, updatedate);
	}
	*/

}
