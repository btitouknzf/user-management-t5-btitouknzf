package com.example.terasoluna.app.user;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class UpdateForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String selectNumber;
	
	@Size(min = 4, max = 4)
	private String userid;
	
	@NotEmpty
	@Size(max = 30)
	private String username;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	
	@NotEmpty
	@Size(max = 60)
	private String address;
	
	@Size(min = 10, max = 11)
	private String tellphone;
	
	@NotEmpty
	private String role;
	
	
	
	public String getSelectNumber() {
		return selectNumber;
	}

	public void setSelectNumber(String selectNumber) {
		this.selectNumber = selectNumber;
	}

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

}
