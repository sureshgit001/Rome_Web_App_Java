package com.restaurent.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurent.models.UserInfo;
import com.restaurent.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/v1")
public class UserController {
	
	
	@Autowired
	private UserService userService;

	// GET ALL USERS
	@GetMapping("/users")
	public ResponseEntity<List<UserInfo>> getUserDetails() {
		
		List<UserInfo> userDetails = userService.getUserDetails();

		return new ResponseEntity<List<UserInfo>>(userDetails, HttpStatus.CREATED);
	}

	// GET USER BYID
	@GetMapping("/users/{userId}")
	public ResponseEntity<Optional<UserInfo>> getUserDetails(@PathVariable Long userId) {
		Optional<UserInfo> userById = userService.getUserById(userId);

		return new ResponseEntity<Optional<UserInfo>>(userById, HttpStatus.CREATED);
 
	}

//	// SAVE USER DETAILS
//	@PostMapping("/users/add")
//	public ResponseEntity<UserInfo> saveUser(@RequestBody UserInfo user) {
//
//		UserInfo saveUser = userService.saveUser(user);
//
//		return new ResponseEntity<UserInfo>(saveUser, HttpStatus.CREATED);
//	}

	// UPDATE USER DETAILS
	@PutMapping("/users/{userId}")
	public ResponseEntity<String> saveUser(@RequestBody UserInfo user, @PathVariable Long userId) {

		boolean saveUser = userService.updateUser(user, userId);
		String userUpdate = ((saveUser) ? "User details updated successfully" : "user doesn't exist").toUpperCase();
		return new ResponseEntity<String>(userUpdate, HttpStatus.CREATED);
	}

	// DELETE USER
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<String> deleteUserDetails(@PathVariable Long userId) {
		String deleteUser = (userService.deleteUser(userId)).toUpperCase();
		return new ResponseEntity<String>(deleteUser, HttpStatus.CREATED);
	}
	
	
}
