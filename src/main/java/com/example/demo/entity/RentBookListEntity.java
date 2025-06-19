package com.example.demo.entity;

import java.sql.Date;

import com.example.demo.entity.keycompose.RentBookListId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * A(n) table/entity represents the many-to-many
 * relationship of  <strong>RentEntity</strong> and <strong>BookEntity</strong>
 * A user can rent/borrow one or more types of books that when
 * printing the receipt, it will show the list of
 * books that user have rented/borrowed.
 * Reminder that a user can only borrow/rent one book of each kind
 * **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class RentBookListEntity {
	@EmbeddedId
	private RentBookListId id;
	
	@ManyToOne
	@MapsId("rentId")
	private RentEntity rent;
	
	@ManyToOne
	@MapsId("bookId")
	private BookEntity book;
	
	private Date startDate;
	private Date endDate;
	
	public Boolean valiadteDate() {
		if(this.endDate.compareTo(this.startDate) <= 0) {
			return false;
		}
		return true;
	}
}
