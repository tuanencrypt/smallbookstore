package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * A table and an entity to represent the book
 * **/
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	
	private String bookName;
	private String author;
	private String publisher;
	private String isbn13;
	private String isbn10;
	private Integer numOfPage;
	private Double price;
	
	private Boolean isDeleted;
}
