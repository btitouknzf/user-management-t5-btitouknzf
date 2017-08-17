package com.example.terasoluna.domain.repository;

import java.util.Collection;

import com.example.terasoluna.domain.model.UserRoleInfo;

public interface UserRoleInfoRepository {
	Collection<UserRoleInfo> findRole(String userid);
	int userRoleCount(String userid);
	boolean userRoleUpdate(UserRoleInfo userRoleInfo);
	boolean userRoleDelete(UserRoleInfo userRoleInfo);
}
