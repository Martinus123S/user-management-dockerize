package com.martin.userman.handler;

import com.martin.userman.handler.exception.ResourceNotFound;
import com.martin.userman.model.response.wrapper.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ResourceNotFound.class})
	public ResponseEntity<BaseResponse<Object>> handleResourceNotFound(ResourceNotFound ex) {
		BaseResponse<Object> response = new BaseResponse<>(
				null,
				ex.getMessage(),
				HttpStatus.NOT_FOUND.value()
		);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
