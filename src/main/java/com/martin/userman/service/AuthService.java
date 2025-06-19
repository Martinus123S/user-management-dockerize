package com.martin.userman.service;

import com.martin.userman.handler.exception.ResourceNotFound;
import com.martin.userman.model.request.LoginRequest;
import com.martin.userman.model.response.LoginResponse;

public interface AuthService {
	LoginResponse login(LoginRequest request) throws ResourceNotFound;
}
