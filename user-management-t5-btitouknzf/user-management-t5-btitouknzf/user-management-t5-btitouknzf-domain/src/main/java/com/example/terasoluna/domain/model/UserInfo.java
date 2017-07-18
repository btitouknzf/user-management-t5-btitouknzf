package com.example.terasoluna.domain.model;

import java.io.Serializable;
import java.security.Timestamp;
import java.sql.Date;

import org.joda.time.DateTime;


public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userId;
	private String username;
	private Date birthday;
	private String address;
	private String tellphone;
	private String password;
	private int state;
	private DateTime updatedate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public DateTime getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(DateTime updatedate) {
		this.updatedate = updatedate;
	}
	
	
}
