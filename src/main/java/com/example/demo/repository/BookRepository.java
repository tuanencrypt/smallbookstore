package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
	
	@Query("SELECT b "
		+  "FROM BookEntity b "
		+  "WHERE (:bookName IS NULL OR b.bookName = :bookName) AND "
		+  "(:author IS NULL or b.author = :author) AND "
		+  "(:publisher IS NULL or b.publisher = publisher) AND "
		+  "(:isbn13 IS NULL or b.isbn13 = :isbn13) AND "
		+  "(:isbn10 IS NULL or b.isbn10 = :isbn10) AND "
		+  "(:numOfPage IS NULL or b.numOfPage = :numOfPage) AND "
		+  "(:price IS NULL or b.price = :price) AND "
		+  "(b.isDeleted = :isDeleted)"
		)
	Optional<List<BookEntity>> findBookByParam(
			@Param("bookName") String bookName, 
			@Param("author") String author, 
			@Param("publisher") String publisher, 
			@Param("isbn13") String isbn13,
			@Param("isbn10") String isbn10, 
			@Param("numOfPage") Integer numOfPage, 
			@Param("price") Double price, 
			@Param("isDeleted") Boolean isDeleted
	);
}
