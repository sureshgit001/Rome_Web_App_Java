package com.restaurent.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties("ordersList")
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@NotNull(message = "should not be null")
	@NotEmpty(message = "should not be empty")
	@NotBlank(message = "should not be Blank")
	private String userName;
	@Column(unique = true)
	private String userEmail;
	private String userPhoneNo;
	private String userCountry;
	private String userAddress;
	private String userPincode;
	@Pattern(regexp  = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",message = "Please enter valid password")
	private String userPassword;

	// s
	@OneToMany(mappedBy = "userInfoToOrder", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Orders> ordersList = new ArrayList<>();

	public List<Orders> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserCountry() {
		return userCountry;
	}

	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPincode() {
		return userPincode;
	}

	public void setUserPincode(String userPincode) {
		this.userPincode = userPincode;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public UserInfo(Long userId, String userName, String userEmail, String userCountry, String userAddress,
			String userPincode, String userPassword, List<Orders> ordersList) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userCountry = userCountry;
		this.userAddress = userAddress;
		this.userPincode = userPincode;
		this.userPassword = userPassword;
		this.ordersList = ordersList;
	}

	public UserInfo(Long userId, String userName, String userEmail, String userCountry, String userAddress,
			String userPincode, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userCountry = userCountry;
		this.userAddress = userAddress;
		this.userPincode = userPincode;
		this.userPassword = userPassword;

	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userCountry="
				+ userCountry + ", userAddress=" + userAddress + ", userPincode=" + userPincode + ", userPassword="
				+ userPassword + ", ordersList=" + ordersList + "]";
	}

	public UserInfo() {

	}

	public UserInfo(Long userId) {

		this.userId = userId;
	}

	public String getUserPhoneNo() {
		return userPhoneNo;
	}

	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}

}
