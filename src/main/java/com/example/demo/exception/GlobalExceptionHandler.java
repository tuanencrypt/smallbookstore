package com.example.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.configuration.CustomResponse;
import com.example.demo.configuration.CustomResponseCode;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = AppException.class)
	ResponseEntity<CustomResponse> handlingRuntimeException(AppException e) {
		CustomResponseCode errCode = e.getResponseCode();
		CustomResponse customResponse = new CustomResponse(errCode);
		
		return ResponseEntity.badRequest().body(customResponse);
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	ResponseEntity<String> handlingValidation(MethodArgumentNotValidException e){
		return ResponseEntity.badRequest().body(e.getFieldError().getDefaultMessage());
	}
	
}
