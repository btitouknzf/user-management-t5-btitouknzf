package com.example.terasoluna.domain.service.shared;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.terasoluna.domain.model.UserSearchInfo;
import com.example.terasoluna.domain.model.UserSearchResultInfo;
import com.example.terasoluna.domain.repository.UserSearchResultInfoRepository;

@Transactional
@Service
public class UserSearchResultInfoSharedServiceImpl implements UserSearchResultInfoSharedService {

	@Inject
	UserSearchResultInfoRepository userSearchResultInfoRepository;
	
	@Transactional(readOnly = true)
	@Override
	public Collection<UserSearchResultInfo> findSearchResult(UserSearchInfo userSearchInfo) {
		// TODO 自動生成されたメソッド・スタブ

		return userSearchResultInfoRepository.findSearchResult(userSearchInfo);
	}

}
