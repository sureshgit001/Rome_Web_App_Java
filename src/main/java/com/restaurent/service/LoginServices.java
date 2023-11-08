package com.restaurent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurent.dtos.LoginDTO;
import com.restaurent.models.UserInfo;
import com.restaurent.repos.UserInfoRepo;

@Service
public class LoginServices {
	@Autowired
	private UserInfoRepo userRepo;

	public Boolean getUserByEmailAndPass(LoginDTO loginDetails) {
		UserInfo userByEmailAndPass = userRepo.getUserByEmailAndPass(loginDetails.getUserEmail(),
				loginDetails.getUserPassword());

		if (userByEmailAndPass != null) {
			return true;
		} else {
			return false;
		}

	}

}
