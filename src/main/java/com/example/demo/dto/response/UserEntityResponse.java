package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntityResponse {
	private Integer userId;
	private String username;
	private String password;
	private String email;
	private String phoneNumber;
	private Boolean isDeleted;
}
