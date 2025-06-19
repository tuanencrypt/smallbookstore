package com.example.demo.service;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.ReceiptEntityRequest;
import com.example.demo.dto.response.ReceiptEntityResponse;
import com.example.demo.entity.ReceiptEntity;
import com.example.demo.repository.ReceiptRepository;
import com.example.demo.repository.UserRepository;

@Service
public class ReceiptService {
	
	@Autowired
	private ReceiptRepository receiptRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public ReceiptService(ReceiptRepository receiptRepository, UserRepository userRepository) {
		this.receiptRepository = receiptRepository;
		this.userRepository = userRepository;
	}

	/**
	 * POST /receipts
	 * Creates a receipt. The receipt may or may not
	 * have a user
	 * **/
	// Todo: Fix the relationship of receipt and user later
	public ReceiptEntityResponse addReceipt(ReceiptEntityRequest request) {
		ReceiptEntity entity = new ReceiptEntity();
		
		
		
		entity.setPurchaseDate(Date.valueOf(LocalDate.now()));
		
		ReceiptEntity savedEntity = receiptRepository.save(entity);
		ReceiptEntityResponse response = new ReceiptEntityResponse();
		BeanUtils.copyProperties(savedEntity, response);
		
		return response;
	}
	
}
