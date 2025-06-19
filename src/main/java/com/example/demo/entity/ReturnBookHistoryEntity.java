package com.example.demo.entity;

import java.sql.Date;

import com.example.demo.entity.keycompose.ReturnBookHistoryId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A(n) table/entity represents the history of 
 * the book after returned from the user
 * This table records all the books returned from
 * the user to check the state of the book.
 * **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ReturnBookHistoryEntity {
	
	@EmbeddedId
	private ReturnBookHistoryId id;
	
	@MapsId("rentBookListId")
	@JoinColumns({
		@JoinColumn(name="rent_id", referencedColumnName = "rent_rent_id"),
		@JoinColumn(name="book_id", referencedColumnName = "book_book_id")
	})
	@ManyToOne
	private RentBookListEntity rentBook;
	
	/**
	 * Represent the book state after borrowed
	 * 0. Borrowing
	 * 1. Returned (No Damage)
	 * 2. Returned (Partial or Full Damage)
	 * 3. Lost
	 * 4. Cancelled
	 * **/
	private Integer bookState;
	private Date returnedDate;
}
