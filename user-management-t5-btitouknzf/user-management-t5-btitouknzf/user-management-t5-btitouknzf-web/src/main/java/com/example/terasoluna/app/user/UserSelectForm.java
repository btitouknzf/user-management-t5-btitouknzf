package com.example.terasoluna.app.user;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class UserSelectForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	private String radioselect;

	public String getRadioselect() {
		return radioselect;
	}

	public void setRadioselect(String radioselect) {
		this.radioselect = radioselect;
	}
	

}
