package com.example.terasoluna.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class UserSearchResultInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userid;
	private String username;
	private Date birthday;
	private String address;
	private String tellphone;
	private String role;
	private int state;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTellphone() {
		return tellphone;
	}
	public void setTellphone(String tellphone) {
		this.tellphone = tellphone;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	

}
