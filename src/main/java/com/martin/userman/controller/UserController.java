package com.martin.userman.controller;

import com.martin.userman.handler.exception.ResourceNotFound;
import com.martin.userman.model.User;
import com.martin.userman.model.request.UserRequest;
import com.martin.userman.model.response.UserResponse;
import com.martin.userman.model.response.wrapper.BaseResponse;
import com.martin.userman.security.annotation.Authorized;
import com.martin.userman.service.ConverterService;
import com.martin.userman.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ConverterService converterService;

	@Operation(summary = "Create a new user", description = "Creates and returns the created user object")
	@PostMapping
	public UserResponse createUser(@RequestBody UserRequest request) {
		User user = userService.createUser(request);
		return this.converterService.convertToUserResponse(user);
	}

	@Operation(summary = "Update existing user", description = "Update and returns the created user object")
	@PostMapping("/{id}")
	public UserResponse updateUser(@PathVariable String id,
			@RequestBody UserRequest request) throws ResourceNotFound {
		User user = userService.updateUser(id,request);
		return this.converterService.convertToUserResponse(user);
	}

	@Operation(summary = "Get user based on email", description = "get user based on email")
	@GetMapping("/{id}")
	public UserResponse getUser(@PathVariable("id") String id)
			throws ResourceNotFound {
		User user = userService.getUser(id);
		return this.converterService.convertToUserResponse(user);
	}

	@Authorized
	@Operation(summary = "Delete user based on id", description = "delete user based on id")
	@DeleteMapping ("/{id}")
	public BaseResponse<Boolean> deleteUser(@PathVariable("id") String id) throws ResourceNotFound {
		boolean isSuccessDelete = userService.deleteUserById(id);
		return BaseResponse.<Boolean>builder()
				.code(HttpStatus.OK.value()).status(HttpStatus.OK.name())
				.data(Boolean.valueOf("true")).build();
	}

}
