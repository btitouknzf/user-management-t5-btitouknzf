package com.example.terasoluna.domain.repository;

import java.util.Collection;

import com.example.terasoluna.domain.model.UserRoleInfo;

public interface UserRoleInfoRepository {
	Collection<UserRoleInfo> findRole(String userid);
	
}
