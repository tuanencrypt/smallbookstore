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
public class RentBookRequest {
	private Integer bookId;
	private Date startDate;
	private Date endDate;
}
