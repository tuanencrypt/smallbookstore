package com.example.demo.dto.request;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReturnBookHistoryRequest {
	private Integer bookId;
	private Integer bookState;
	private Date returnedDate;
	
}
