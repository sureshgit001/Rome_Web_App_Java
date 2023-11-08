package com.restaurent.dtos;

import org.springframework.stereotype.Component;

@Component
public class LoginDTO {

	String userEmail;
	String userPassword;
	
	@Override
	public String toString() {
		return "LoginDTO [userEmail=" + userEmail + ", userPassword=" + userPassword + "]";
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public LoginDTO(String userEmail, String userPassword) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}
	public LoginDTO() {
	
	}
	

	

}
