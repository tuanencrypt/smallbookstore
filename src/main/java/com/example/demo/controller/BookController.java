package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configuration.CustomResponse;
import com.example.demo.configuration.CustomResponseCode;
import com.example.demo.dto.request.BookEntityRequest;
import com.example.demo.dto.response.BookEntityResponse;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	/**
	 * POST /books
	 * **/
	@PostMapping
	public ResponseEntity<CustomResponse<BookEntityResponse>> addBook(@RequestBody BookEntityRequest request) {
		CustomResponse<BookEntityResponse> response = new CustomResponse<>();
		BookEntityResponse bookResponse = bookService.addBook(request);
		response.setCustomResponseCode(CustomResponseCode.BOOK_CREATED);
		response.setResponseBody(bookResponse);
		
		return new ResponseEntity<CustomResponse<BookEntityResponse>>(response, HttpStatus.OK);
	}
	
}
