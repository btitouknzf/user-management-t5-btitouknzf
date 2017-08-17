package com.example.terasoluna.app.test;

import java.io.Serializable;

public class TestRoleForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userid;
	
	private String role;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
