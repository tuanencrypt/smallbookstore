package com.example.demo.entity;

import com.example.demo.entity.keycompose.ReceiptBookListId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A(n) table/entity represents the many-to-many
 * relationship of  <strong>ReceiptEntity</strong> and <strong>BookEntity</strong>
 * A user can purchase one or more books that when
 * printing the receipt, it will show the list of
 * books that user have purchased.
 * **/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReceiptBookListEntity {
	@EmbeddedId
	private ReceiptBookListId id;
	
	@ManyToOne
	@MapsId("receiptId")
	private ReceiptEntity receipt;
	
	@ManyToOne
	@MapsId("bookId")
	private BookEntity book;
	
	private Integer quantity;
}
