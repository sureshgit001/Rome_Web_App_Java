package com.restaurent.controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/")
	public ResponseEntity<String> welcomeMessave() {

		return new ResponseEntity<String>("Hi Welcome to My Restarant", HttpStatus.CREATED);
	}
	
	 @GetMapping("/greeting")
	    public String greeting(Authentication authentication) {

	        String userName = authentication.getName();

	        return "Spring Security In-memory Authentication Example - Welcome " + userName;
	    }

}
