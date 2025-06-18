package com.martin.userman.controller;

import com.martin.userman.model.dto.UserRequest;
import com.martin.userman.model.response.UserResponse;
import com.martin.userman.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Operation(summary = "Create a new user", description = "Creates and returns the created user object")
	@PostMapping
	public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
		UserResponse user = userService.createUser(request);
		return ResponseEntity.ok(user);
	}
}
