package com.example.terasoluna.domain.service.shared;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.terasoluna.domain.model.UserRoleInfo;
import com.example.terasoluna.domain.repository.UserRoleInfoRepository;

@Transactional
@Service
public class UserRoleInfoSharedServiceImple implements UserRoleInfoSharedService {

	@Inject
	UserRoleInfoRepository userRoleInfoRepository;
	
	@Transactional(readOnly = true)
	@Override
	public Collection<UserRoleInfo> findRole(String userid) {
		// TODO 自動生成されたメソッド・スタブ		
		return userRoleInfoRepository.findRole(userid);
	}

}
