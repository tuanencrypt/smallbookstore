package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserEntity;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	Optional<UserEntity> findByUsername(String username);
	
	@Query("SELECT u FROM UserEntity u WHERE (:username IS NULL OR u.username = :username)"
			+ "AND (:email IS NULL OR u.email = :email)"
			+ "AND (:phoneNumber IS NULL or u.phoneNumber = :phoneNumber)"
			+ "AND (:isDeleted IS NULL or u.isDeleted = :isDeleted)")
	Optional<List<UserEntity>> findUserByParam(
			@Param("username") String username,
			@Param("email") String email,
			@Param("phoneNumber") String phoneNumber,
			@Param("isDeleted") Boolean isDeleted);
}
