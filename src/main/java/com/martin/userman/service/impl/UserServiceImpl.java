package com.martin.userman.service.impl;

import com.martin.userman.model.dto.UserRequest;
import com.martin.userman.model.response.UserResponse;
import com.martin.userman.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Override
	public UserResponse createUser(UserRequest request) {
		return null;
	}
}
