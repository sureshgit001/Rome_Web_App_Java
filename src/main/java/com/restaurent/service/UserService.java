package com.restaurent.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restaurent.models.UserInfo;
import com.restaurent.repos.UserInfoRepo;

@Service
public class UserService {

	@Autowired
	private UserInfoRepo userRepo;

	// GET USER BY ID
	public Optional<UserInfo> getUserById(Long userId) {
		return userRepo.findById(userId);

	}

	// GET ALL USERS
	public List<UserInfo> getUserDetails() {

		return userRepo.findAll();

	}


	// SAVE USER
	public Boolean saveUser(UserInfo user) {
		
		UserInfo findByUserEmail = userRepo.findByUserEmail(user.getUserEmail());
		if (findByUserEmail!=null) {
			System.out.println("user already Exist "+findByUserEmail.getUserEmail());
			return false;
		}else {
			userRepo.save(user);
			return true;
		}


	}

	// UPDATE USER DETAILS
	@SuppressWarnings("deprecation")
	public boolean updateUser(UserInfo user, Long userId) {

		Optional<UserInfo> findById = userRepo.findById(userId);
		if (findById.isPresent()) {
			user.setUserId(userId);
			user = userRepo.save(user);
			return true;
		} else {
			return false;
		}
	}
	

	// DELETE USER
	public String deleteUser(Long userId) {
		String deleteUSer;
		Optional<UserInfo> findById = userRepo.findById(userId);
		if (findById.isPresent()) {
			userRepo.deleteById(userId);
			deleteUSer = "user deleted successfully";
		} else {
			deleteUSer = "user doesn't exist";
		}
		deleteUSer.toUpperCase();
		return deleteUSer;
	}

}