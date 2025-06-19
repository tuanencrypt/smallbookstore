package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configuration.CustomResponse;
import com.example.demo.configuration.CustomResponseCode;
import com.example.demo.dto.request.UserEntityRequest;
import com.example.demo.dto.response.UserEntityResponse;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * POST /users
	 * **/
	@PostMapping
	public ResponseEntity<CustomResponse<UserEntityResponse>> addUser(@RequestBody UserEntityRequest request) {
		CustomResponse<UserEntityResponse> userResponse = new CustomResponse<>();
		UserEntityResponse user = userService.addUser(request);
		userResponse.setResponseBody(user);
		userResponse.setCustomResponseCode(CustomResponseCode.USER_CREATED);
		
		return new ResponseEntity<CustomResponse<UserEntityResponse>>(userResponse, HttpStatus.OK);
	}
	
	
	/**
	 * GET /users/{id}
	 * **/
	@GetMapping("/{id}")
	public ResponseEntity<CustomResponse<UserEntityResponse>> getUser(@PathVariable Integer id)
	{
		UserEntityResponse user = userService.findUser(id);
		CustomResponse<UserEntityResponse> response = new CustomResponse<>(CustomResponseCode.USER_SELECTED);
		response.setResponseBody(user);
		
		return new ResponseEntity<CustomResponse<UserEntityResponse>>(response, HttpStatus.OK);
	}
	
	/**
	 * GET /users?optionalParam
	 * GET /users
	 * **/
	@GetMapping
	public ResponseEntity<CustomResponse<List<UserEntityResponse>>> getUserParam(
			@RequestParam(required=false) String username,
			@RequestParam(required=false) String email,
			@RequestParam(required=false) String phoneNumber,
			@RequestParam(required=false, name="deleted", defaultValue="false") Boolean isDeleted
			) {
		List<UserEntityResponse> listResponse;
		listResponse = userService.findUserByParam(username, email, phoneNumber, isDeleted);
		
		CustomResponse<List<UserEntityResponse>> response = new CustomResponse<>(CustomResponseCode.USER_SELECTED);
		response.setResponseBody(listResponse);
		
		return new ResponseEntity<CustomResponse<List<UserEntityResponse>>>(response , HttpStatus.OK);
	}
	
	/**
	 * PUT /users/{id}
	 * **/
	@PutMapping("/{id}")
	public ResponseEntity<CustomResponse<UserEntityResponse>> updateUser(@PathVariable Integer id, 
			@RequestBody UserEntityRequest request)
	{
		CustomResponse<UserEntityResponse> response = new CustomResponse<>();
		UserEntityResponse user = userService.updateUser(id, request);
		response.setResponseBody(user);
		response.setCustomResponseCode(CustomResponseCode.USER_UPDATED);
		
		return new ResponseEntity<CustomResponse<UserEntityResponse>>(response, (HttpStatus.OK));
	}
	
	/**
	 * DELETE /users/{id}
	 * **/
	@DeleteMapping("/{id}")
	public ResponseEntity<CustomResponse<UserEntityResponse>> deleteUser(@PathVariable Integer id) {
		CustomResponse<UserEntityResponse> response = new CustomResponse<>();
		UserEntityResponse user = userService.deleteUser(id);
		response.setCustomResponseCode(CustomResponseCode.USER_DELETED);
		response.setResponseBody(user);
		
		return new ResponseEntity<CustomResponse<UserEntityResponse>>(response, HttpStatus.OK);
	}
	
	/**
	 * DELETE /users/delete/{id}
	 * Instead of forcing to delete the user, hide the
	 * user that you want to delete instead of
	 * forcing to delete it
	 * **/
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CustomResponse<UserEntityResponse>> safeDeleteUser(@PathVariable Integer id) {
		CustomResponse<UserEntityResponse> response = new CustomResponse<>();
		UserEntityResponse user = userService.safeDeleteUser(id);
		response.setCustomResponseCode(CustomResponseCode.USER_DELETED);
		response.setResponseBody(user);
		
		
		return new ResponseEntity<CustomResponse<UserEntityResponse>>(response, HttpStatus.OK);
	}
	
}
