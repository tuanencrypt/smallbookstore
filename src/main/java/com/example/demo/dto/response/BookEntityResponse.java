package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntityResponse {
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
