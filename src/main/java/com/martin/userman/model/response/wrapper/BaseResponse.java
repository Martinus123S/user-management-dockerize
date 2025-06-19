package com.martin.userman.model.response.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseResponse<T extends Object> implements Serializable {
	private static final long serialVersionUID = 1L;
	private T data;
	private String status;
	private int code;
}
