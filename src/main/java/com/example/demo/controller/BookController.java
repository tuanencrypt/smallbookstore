package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	/**
	 * GET /books/{id}
	 * **/
	@GetMapping("/{id}")
	public ResponseEntity<CustomResponse<BookEntityResponse>> getBook(@PathVariable Integer id)
	{
		CustomResponse<BookEntityResponse> response = new CustomResponse<>();
		BookEntityResponse bookResponse = bookService.getBook(id);
		response.setCustomResponseCode(CustomResponseCode.BOOK_SELECTED);
		response.setResponseBody(bookResponse);
		
		return new ResponseEntity<CustomResponse<BookEntityResponse>>(response, HttpStatus.OK);
	}
	
	/**
	 * GET /books
	 * GET /books?optionalParam
	 * **/
	@GetMapping
	public ResponseEntity<CustomResponse<List<BookEntityResponse>>> getBooksByParam(
			@RequestParam(required = false) String bookName,
			@RequestParam(required = false) String author,
			@RequestParam(required = false) String publisher,
			@RequestParam(required = false) String isbn13,
			@RequestParam(required = false) String isbn10,
			@RequestParam(required = false) Integer numOfPage,
			@RequestParam(required = false) Double price,
			@RequestParam(required = false, name = "deleted", defaultValue = "false") Boolean isDeleted
			) {
		CustomResponse<List<BookEntityResponse>> response = new CustomResponse<>();
		List<BookEntityResponse> bookListResponse = bookService.findBooksByParam(
				bookName, author, publisher, isbn13, isbn10, numOfPage, price, isDeleted
				);
		response.setCustomResponseCode(CustomResponseCode.BOOK_SELECTED);
		response.setResponseBody(bookListResponse);
		
		return new ResponseEntity<CustomResponse<List<BookEntityResponse>>>(response, HttpStatus.OK);
	}
	
}
