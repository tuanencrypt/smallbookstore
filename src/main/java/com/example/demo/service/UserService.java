package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.configuration.CustomResponseCode;
import com.example.demo.dto.request.UserEntityRequest;
import com.example.demo.dto.response.UserEntityResponse;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.AppException;
import com.example.demo.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * GET /users
	 * Selects all the users
	 * **/
	public List<UserEntityResponse> getUsers() {
		List<UserEntity> listUsers = userRepository.findAll();
		List<UserEntityResponse> listUsersResponse = new ArrayList<>();
		
		for(UserEntity src : listUsers) {
			UserEntityResponse edst = new UserEntityResponse();
			BeanUtils.copyProperties(src, edst);
			listUsersResponse.add(edst);
		}
		
		return listUsersResponse;
	}
	
	
	/**
	 * POST /users
	 * Creates a new user
	 * **/
	public UserEntityResponse addUser(UserEntityRequest request) {
		UserEntity user = new UserEntity();
		BeanUtils.copyProperties(request, user);
		
		// Checks if user exists
		Optional<UserEntity> existUser = userRepository.findByUsername(user.getUsername());
		if(!existUser.isPresent())
		{
			UserEntity userSaved = userRepository.save(user);
			UserEntityResponse response = new UserEntityResponse();
			BeanUtils.copyProperties(userSaved, response);
			
			return response;			
		}
		throw new AppException(CustomResponseCode.ERR_USER_CREATED);
	}

	/**
	 * GET /users/{id}
	 * Selects a user based on its id
	 * If the id does not exists, return an error
	 * **/
	public UserEntityResponse findUser(Integer id) {
		Optional<UserEntity> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new AppException(CustomResponseCode.ERR_USER_SELECTED);
		}
		
		UserEntityResponse userResponse = new UserEntityResponse();
		BeanUtils.copyProperties(user.get(), userResponse);
		
		return userResponse;
	}

	/**
	 * GET /users?optionalParam
	 * Selects a user based on given param
	 * **/
	public List<UserEntityResponse> findUserByParam(String username, String email,
			String phoneNumber, Boolean isDeleted) {
		
		Optional<List<UserEntity>> listUser = userRepository.findUserByParam(username, email, phoneNumber, isDeleted);
		if(!listUser.isPresent()) {
			throw new AppException(CustomResponseCode.ERR_USER_SELECTED);
		}
		
		List<UserEntityResponse> listResponse = new ArrayList<>();
		
		listUser.get().forEach(src -> {
			UserEntityResponse dst = new UserEntityResponse();
			BeanUtils.copyProperties(src, dst);
			listResponse.add(dst);
		});
		
		return listResponse;
	}
	
	
	
	/**
	 * PUT /users/{id}
	 * Update a user based on the id
	 * **/
	public UserEntityResponse updateUser(Integer id, UserEntityRequest request) {
		
		UserEntity existingUser = userRepository.findById(id).orElseThrow(() -> new AppException(CustomResponseCode.ERR_USER_UPDATED));
		existingUser.setUsername(request.getUsername());
		existingUser.setPassword(request.getPassword());
		existingUser.setEmail(request.getEmail());
		existingUser.setPhoneNumber(request.getPhoneNumber());
		existingUser.setIsDeleted(request.getIsDeleted());
		
		UserEntity updatedUser = userRepository.save(existingUser);
		UserEntityResponse response = new UserEntityResponse();
		
		
		BeanUtils.copyProperties(updatedUser, response);
		
		return response;
	}
	
}
