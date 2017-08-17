package com.example.terasoluna.domain.service.shared;

import java.util.Collection;

import com.example.terasoluna.domain.model.UserRoleInfo;

public interface UserRoleInfoSharedService {
	Collection<UserRoleInfo> findRole(String userid);
	int userRoleCount(String userid);
	boolean userRoleUpdate(UserRoleInfo userRoleInfo);
	boolean userRoleDelete(UserRoleInfo userRoleInfo);
}
