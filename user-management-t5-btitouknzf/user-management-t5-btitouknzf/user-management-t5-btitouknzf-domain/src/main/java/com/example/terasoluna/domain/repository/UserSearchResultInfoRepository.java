package com.example.terasoluna.domain.repository;

import java.util.Collection;

import com.example.terasoluna.domain.model.UserSearchInfo;
import com.example.terasoluna.domain.model.UserSearchResultInfo;

public interface UserSearchResultInfoRepository {
	Collection<UserSearchResultInfo> findSearchResult(UserSearchInfo userSearchInfo);
}
