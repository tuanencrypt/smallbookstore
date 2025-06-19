package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	public List<BookEntityResponse> findBooksByParam(String bookName, String author, String publisher, String isbn13,
			String isbn10, Integer numOfPage, Double price, Boolean isDeleted) {
		Optional<List<BookEntity>> listBooks = bookRepository
				.findBookByParam(bookName, author, publisher, isbn13, isbn10, numOfPage, price, isDeleted);
		
		if(!listBooks.isPresent()) {
			throw new AppException(CustomResponseCode.ERR_BOOK_SELECTED);
		}
		
		List<BookEntityResponse> bookListResponse = new ArrayList<>();
		
		listBooks.get().forEach(src -> {
			BookEntityResponse dst = new BookEntityResponse();
			BeanUtils.copyProperties(src, dst);
			bookListResponse.add(dst);
		});
		
		return bookListResponse;
	}
}
