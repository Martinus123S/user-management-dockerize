package com.martin.userman.service;

import com.martin.userman.handler.exception.ResourceNotFound;
import com.martin.userman.model.User;
import com.martin.userman.model.request.UserRequest;


public interface UserService {
	User createUser(UserRequest request);
	User updateUser(String id, UserRequest request) throws ResourceNotFound;
	User getUser(String id) throws ResourceNotFound;
	boolean deleteUserById(String id) throws ResourceNotFound;
}
