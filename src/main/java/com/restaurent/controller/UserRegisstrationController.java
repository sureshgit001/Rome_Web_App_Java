package com.restaurent.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurent.models.UserInfo;
import com.restaurent.service.UserService;

@RestController
public class UserRegisstrationController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/v1/user/register", consumes = "application/json")
	public ResponseEntity<Object> registerUser(@Valid @RequestBody UserInfo user, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {

			// Create a map to store field errors
			Map<String, String> fieldErrorsMap = new HashMap<>();

			// Populate the map with field errors
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				fieldErrorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
			}

			// You can return the fieldErrorsMap or use it as needed
			return ResponseEntity.badRequest().body(fieldErrorsMap);
		}
		Boolean saveUser = userService.saveUser(user);

		return ResponseEntity.ok(saveUser);
	}

}
