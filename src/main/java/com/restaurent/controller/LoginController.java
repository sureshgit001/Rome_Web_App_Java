package com.restaurent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurent.dtos.LoginDTO;
import com.restaurent.service.LoginServices;

@RestController
@RequestMapping("/v1")
public class LoginController {
	@Autowired
	private LoginDTO log;
	@Autowired
	private LoginServices loginSer;

	@PostMapping("/users/login")
	public ResponseEntity<Object> login(@RequestBody LoginDTO loginDetails) {
		System.out.println("frequest is working");
		Boolean isUserValid;
		Boolean userByEmailAndPass;

		if (log != null) {

			userByEmailAndPass = loginSer.getUserByEmailAndPass(loginDetails);
			isUserValid = (userByEmailAndPass) ? true : false;
		} else {
			isUserValid = false;
		}

		return new ResponseEntity<Object>(isUserValid, HttpStatus.ACCEPTED);
	}

}
