package com.martin.userman.service.impl;

import com.martin.userman.handler.exception.ResourceNotFound;
import com.martin.userman.model.User;
import com.martin.userman.model.request.UserRequest;
import com.martin.userman.repository.UserRepository;
import com.martin.userman.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(UserRequest request) {
		User user = new User();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setCreatedAt(LocalDateTime.now());
		userRepository.save(user);
		return user;
	}

	@Override
	public User getUser(String id) throws ResourceNotFound {
		User user = userRepository.findById(UUID.fromString(id)).orElse(null);
		if (user == null) {
			throw new ResourceNotFound("Data tidak ada");
		}
		return user;
	}

	@Override
	public User updateUser(String id, UserRequest request) throws ResourceNotFound {
		User user = this.userRepository.findById(UUID.fromString(id)).orElse(null);
		if (Objects.isNull(user)) {
			throw new ResourceNotFound("Data tidak ada");
		}
		if (StringUtils.equals(user.getEmail(), request.getEmail())) {
			throw new ResourceNotFound("Email sudah ada tolong diganti");
		}
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setCreatedAt(LocalDateTime.now());
		userRepository.save(user);
		return user;
	}

	@Override
	public boolean deleteUserById(String id) throws ResourceNotFound {
		try{
			User user = this.userRepository.findById(UUID.fromString(id)).orElse(null);
			if (Objects.isNull(user)) {
				throw new ResourceNotFound("Data tidak ada");
			}
			userRepository.delete(user);
			return true;
		} catch (ResourceNotFound e) {
			throw e;
		}
	}
}
