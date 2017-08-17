package com.example.terasoluna.domain.model;

import java.io.Serializable;
import java.util.Date;

public class UserSearchInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userid;
	private String username;
	private Date birthday;
	private String address;
	private String tellphone;
	private int roleInt;
	private int stateInt;
	
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
	public int getRole() {
		return roleInt;
	}
	public void setRole(int setRole) {
		this.roleInt = setRole;
	}
	public int getState() {
		return stateInt;
	}
	public void setState(int stateInt) {
		this.stateInt = stateInt;
	}


}
