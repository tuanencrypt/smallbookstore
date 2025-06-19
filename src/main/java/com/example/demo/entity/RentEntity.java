package com.example.demo.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A(n) table/entity represents the user's renting
 * An user can rent one or many books from the bookstore,
 * so that in order to keep track the rented book from the store,
 * a rent receipt is created for the user.
 * **/
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class RentEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rentId;
	
	@NotEmpty
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	// To represent the date of rent receipt is printed
	private Date rentedDate;
}
