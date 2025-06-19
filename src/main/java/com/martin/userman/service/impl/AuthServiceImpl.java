package com.martin.userman.service.impl;

import com.martin.userman.handler.exception.ResourceNotFound;
import com.martin.userman.model.User;
import com.martin.userman.model.request.LoginRequest;
import com.martin.userman.model.response.LoginResponse;
import com.martin.userman.repository.UserRepository;
import com.martin.userman.security.JWTUtil;
import com.martin.userman.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JWTUtil jwtUtil;

	@Override
	public LoginResponse login(LoginRequest request) throws ResourceNotFound {
		User user = userRepository.findByEmail(request.getEmail());

		if (Objects.isNull(user)) {
			throw new ResourceNotFound("User Not Found, Please register");
		}

		if (!user.getPassword().equals(request.getPassword())) {
			throw new ResourceNotFound("Wrong Password");
		}

		String token = jwtUtil.generateToken(user.getEmail());
		return LoginResponse.builder().token(token).build();
	}
}
