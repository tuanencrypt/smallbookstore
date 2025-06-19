package com.example.demo.dto.response;

import java.util.Date;

import com.example.demo.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptEntityResponse {
	private Integer receiptId;
	private Integer userId;
	private Date purchaseDate;
}
