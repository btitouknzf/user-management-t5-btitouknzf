package com.example.terasoluna.domain.service.shared;

import java.util.Collection;

import com.example.terasoluna.domain.model.UserSearchInfo;
import com.example.terasoluna.domain.model.UserSearchResultInfo;

public interface UserSearchResultInfoSharedService {
	Collection<UserSearchResultInfo> findSearchResult(UserSearchInfo userSearchInfo);
}
