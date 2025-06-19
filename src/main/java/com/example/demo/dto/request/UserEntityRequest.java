package com.example.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntityRequest {
	private String username;
	private String password;
	private String email;
	private String phoneNumber;
	private Boolean isDeleted;
}
