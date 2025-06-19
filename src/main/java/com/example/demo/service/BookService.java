package com.example.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.configuration.CustomResponseCode;
import com.example.demo.dto.request.BookEntityRequest;
import com.example.demo.dto.response.BookEntityResponse;
import com.example.demo.entity.BookEntity;
import com.example.demo.exception.AppException;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	/**
	 * POST /books
	 * Adds a new book
	 * **/
	public BookEntityResponse addBook(BookEntityRequest request) {
		BookEntity book = new BookEntity();
		BeanUtils.copyProperties(request, book);
		
		BookEntity savedBook = bookRepository.save(book);
		BookEntityResponse response = new BookEntityResponse();
		BeanUtils.copyProperties(savedBook, response);
		
		return response;
	}

	/**
	 * GET /books/{id}
	 * Selects a book by its id
	 * **/
	public BookEntityResponse getBook(Integer id) {
		BookEntity book = bookRepository.findById(id).orElseThrow(() -> new AppException(CustomResponseCode.ERR_BOOK_SELECTED));
		BookEntityResponse bookResponse = new BookEntityResponse();
		BeanUtils.copyProperties(book, bookResponse);
		
		return bookResponse;
	}
}
