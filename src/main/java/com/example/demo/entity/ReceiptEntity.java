package com.example.demo.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * A(n) table/entity to represent the receipt
 * The receipt would optionally include the user (if
 * the user have their account available)
 * **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ReceiptEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer receiptId;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	private UserEntity user;
	
	private Date purchaseDate;
}
