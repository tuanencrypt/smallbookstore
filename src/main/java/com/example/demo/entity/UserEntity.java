package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * A(n) table/entity represents the user (the customer)
 * An user is created mostly for renting/borrowing book
 * Optionally, that user can purchase the book and have
 * their record saved for future use such as bonus for that user
 * in the future.
 * **/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	private String email;
	private String phoneNumber;
	
	@OneToMany(mappedBy = "user")
	private List<ReceiptEntity> receipt;
	
	@OneToMany(mappedBy = "user")
	private List<RentEntity> rent;
	
	private Boolean isDeleted;
}
