package com.example.demo.configuration;

/**
 * The <strong>CustomResponseCode</strong> indicates the operation of
 * the database when processing in <em>Service</em> layer.
 * **/
public enum CustomResponseCode {
	USER_CREATED(1000, "Create user successfully."),
	USER_UPDATED(1001, "Update user successfully."),
	USER_SELECTED(1002, "Select user(s) successfully"),
	USER_DELETED(1003, "Delete a user successfully."),
	ERR_USER_CREATED(10000, "Failed to create a user."),
	ERR_USER_UPDATED(10001, "Failed to update a user."),
	ERR_USER_SELECTED(10002, "Failed to query user(s)."),
	ERR_USER_DELETED(10003, "Failed to delete a user."),
	BOOK_CREATED(1004, "Create book successfully."),
	BOOK_UPDATED(1005, "Update book successfully."),
	BOOK_DELETED(1006, "Delete book successfully."),
	BOOK_SELECTED(1007, "Select book(s) successfully."),
	ERR_BOOK_CREATED(10004, "Failed to create a book."),
	ERR_BOOK_UPDATED(10005, "Failed to update a book."),
	ERR_BOOK_SELECTED(10006, "Failed to query book(s)."),
	ERR_BOOK_DELETED(10007, "Failed to delete a book,"),
	RECEIPT_CREATED(1008, "Create receipt successfully."),
	RECEIPT_UPDATED(1009, "Update receipt successfully."),
	RECEIPT_SELECTED(1010, "Select receipt(s) successfully"),
	RECEIPT_DELETED(1011, "Delete receipt successfully"),
	ERR_RECEIPT_CREATED(10008, "Failed to create receipt."),
	ERR_RECEIPT_UPDATED(10009, "Failed to update receipty."),
	ERR_RECEIPT_SELECTED(10010, "Failed to select receipt(s)"),
	ERR_RECEIPT_DELETED(10011, "Failed to delete receipt"),
	RECEIPT_BOOK_CREATED(1012, "Add a book to receipt successfully."),
	RECEIPT_BOOK_DELETED(1013, "Remove a book from receipt successfully"),
	RECEIPT_BOOK_SELECTED(1014, "Select all books from receipt successfully"),
	RECEIPT_BOOK_UPDATED(1015, "Update a book from receipt successfully."),
	ERR_RECEIPT_BOOK_CREATED(10012, "Failed to add a book to receipt."),
	ERR_RECEIPT_BOOK_DELETED(10013, "Failed to remove a book from receipt."),
	ERR_RECEIPT_BOOK_SELECTED(10014, "Failed to select all books from receipt."),
	ERR_RECEIPT_BOOK_UPDATED(10015, "Failed to update a book from receipt."),
	RENT_CREATED(1016, "Create rent receipt successfully."),
	RENT_UPDATED(1017, "Update rent receipt successfully."),
	RENT_SELECTED(1018, "Select rent receipt(s) successfully."),
	RENT_DELETED(1019, "Delete rent receipt(s) successfully."),
	ERR_RENT_CREATED(10016, "Failed to create rent receipt."),
	ERR_RENT_UPDATED(10017, "Failed to update rent receipt."),
	ERR_RENT_SELECTED(10018, "Failed to select rent receipt(s)."),
	ERR_RENT_DELETED(10019, "Failed to delete rent receipt(s)."),
	RENT_BOOK_CREATED(1020, "Add a book to rent receipt successfully."),
	RENT_BOOK_UPDATED(1021, "Remove a book from rent receipt successfully."),
	RENT_BOOK_SELECTED(1022, "Select all books from rent receipt successfully."),
	RENT_BOOK_DELETED(1023, "Delete a book from rent receipt successfully."),
	ERR_RENT_BOOK_CREATED(10020, "Failed to add a book to rent receipt."),
	ERR_RENT_BOOK_UPDATED(10021, "Failed to remove a book from rent receip.t"),
	ERR_RENT_BOOK_SELECTED(10022, "Failed to select all books from rent receipt."),
	ERR_RENT_BOOK_DELETED(10023, "Failed to delete a book from rent receipt."),
	RETURN_BOOK_HISTORY_CREATED(1024, "Create a return book history successfully."),
	RETURN_BOOK_HISTORY_UPDATED(1025, "Update a return book history successfully."),
	ERR_RETURN_BOOK_HISTORY_CREATED(10024, "Failed to create a return book history."),
	ERR_RETURN_BOOK_HISTORY_UPDATED(10025, "Failed to update a return book history.")
	;
	
	Integer httpCode;
	String  httpStatus;
	
	CustomResponseCode(Integer httpCode, String httpStatus)
	{
		this.httpCode = httpCode;
		this.httpStatus = httpStatus;
	}
	
	public Integer getCode()
	{
		return this.httpCode;
	}
	
	public String getStatus()
	{
		return this.httpStatus;
	}
	
	public void setCode(Integer httpCode)
	{
		this.httpCode = httpCode;
	}
	
	public void setStatus(String httpStatus)
	{
		this.httpStatus = httpStatus;
	}
	
}
