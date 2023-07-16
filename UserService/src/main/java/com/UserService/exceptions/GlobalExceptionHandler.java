package com.UserService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.UserService.Dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
		String msg=ex.getMessage();
		ApiResponse response =new ApiResponse();
		response.setMessage(msg);
		response.setSuccess(true);
		response.setStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		
	}
}
