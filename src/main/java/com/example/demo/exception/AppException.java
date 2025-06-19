package com.example.demo.exception;

import com.example.demo.configuration.CustomResponseCode;

public class AppException extends RuntimeException {
	
	private CustomResponseCode errCode;
	
	public AppException(CustomResponseCode errCode) {
		super(errCode.getStatus());
		this.errCode = errCode;
	}
	
	public CustomResponseCode getResponseCode() {
		return this.errCode;
	}
	
	public void setResponseCode(CustomResponseCode errCode) {
		this.errCode = errCode;
	}
}
