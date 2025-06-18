package com.martin.userman.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse implements Serializable {
	private static final long serialVersionUID = -1664348605453118840L;
	private String name;
	private String email;
	private LocalDateTime createdAt;
}
