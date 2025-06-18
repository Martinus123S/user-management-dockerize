package com.martin.userman.service;

import com.martin.userman.model.dto.UserRequest;
import com.martin.userman.model.response.UserResponse;
import org.springframework.stereotype.Service;


public interface UserService {
	UserResponse createUser(UserRequest request);
}
