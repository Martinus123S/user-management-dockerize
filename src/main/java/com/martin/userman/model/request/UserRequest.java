package com.martin.userman.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequest {
	private String name;
	private String email;
	private String password;
}

