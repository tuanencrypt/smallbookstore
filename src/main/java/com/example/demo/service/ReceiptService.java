package com.example.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.configuration.CustomResponseCode;
import com.example.demo.dto.request.ReceiptEntityRequest;
import com.example.demo.dto.response.ReceiptEntityResponse;
import com.example.demo.entity.ReceiptEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.AppException;
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
	public ReceiptEntityResponse addReceipt(ReceiptEntityRequest request) {
		ReceiptEntity entity = new ReceiptEntity();
		Optional<UserEntity> userExisted = Optional.empty();
		if(request.getUserId() != null) {
			userExisted = userRepository.findById(request.getUserId());
			if(userExisted.isEmpty() ) {
				throw new AppException(CustomResponseCode.ERR_RECEIPT_CREATED);
			} else {
				entity.setUser(userExisted.get());
			}
		} else {
			entity.setUser(null);
		}
		 
		entity.setPurchaseDate(Date.valueOf(LocalDate.now()));
		
		ReceiptEntity savedEntity = receiptRepository.save(entity);
		ReceiptEntityResponse response = new ReceiptEntityResponse();
		response.setUserId(userExisted.isPresent() ? userExisted.get().getUserId() : null);
		response.setReceiptId(savedEntity.getReceiptId());
		response.setPurchaseDate(savedEntity.getPurchaseDate());
		
		return response;
	}

	/**
	 * GET /receipts
	 * Selects all the receipts
	 * **/
	// Todo: Rewrite the query to join both the table of UserEntity and ReceiptEntity
	// in order to get UserEntity presented into ReceiptEntity
	public List<ReceiptEntityResponse> getReceipts() {
		List<ReceiptEntity> listReceipt = receiptRepository.findAll();
		List<ReceiptEntityResponse> response = new ArrayList<>();
		
		listReceipt.forEach(src -> {
			ReceiptEntityResponse dst = new ReceiptEntityResponse();

			dst.setReceiptId(src.getReceiptId());
			dst.setPurchaseDate(src.getPurchaseDate());
			response.add(dst);
		});
		
		return response;
	}
	
}
