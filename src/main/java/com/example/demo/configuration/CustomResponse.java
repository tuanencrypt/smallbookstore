package com.example.demo.configuration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The <strong>CustomResponse</strong> returns the format of
 * a response service in <em>Controller</em> layer.
 * The <strong>CustomResponse</strong> allows the developer
 * to understand more about the response code when performing
 * RestAPI.
 * **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponse<T> {
	private Integer httpCode;
	private String  httpStatus;
	private T responseBody;

	
	public CustomResponse(CustomResponseCode code) {
		this.httpCode = code.getCode();
		this.httpStatus = code.getStatus();
	}
	
	public void setCustomResponseCode(CustomResponseCode code)
	{
		this.httpCode = code.getCode();
		this.httpStatus = code.getStatus();
	}

	public Integer getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(Integer httpCode) {
		this.httpCode = httpCode;
	}

	public String getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

	public T getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(T responseBody) {
		this.responseBody = responseBody;
	}
	
	
}
