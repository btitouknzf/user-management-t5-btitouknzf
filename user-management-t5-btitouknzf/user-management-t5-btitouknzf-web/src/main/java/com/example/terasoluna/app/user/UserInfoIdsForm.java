package com.example.terasoluna.app.user;

import java.io.Serializable;
import java.util.Set;

import org.hibernate.validator.constraints.NotEmpty;

public class UserInfoIdsForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	private Set<String> userInfoIds;

	public Set<String> getUserInfoIds() {
		return userInfoIds;
	}

	public void setUserInfoIds(Set<String> userInfoIds) {
		this.userInfoIds = userInfoIds;
	}
	
	

}
