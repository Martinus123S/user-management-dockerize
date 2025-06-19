package com.martin.userman.controller;

import com.martin.userman.handler.exception.ResourceNotFound;
import com.martin.userman.model.request.LoginRequest;
import com.martin.userman.model.response.LoginResponse;
import com.martin.userman.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest request) throws ResourceNotFound {
		return authService.login(request);
	}
}
