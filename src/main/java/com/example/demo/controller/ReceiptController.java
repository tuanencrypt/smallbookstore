package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configuration.CustomResponse;
import com.example.demo.configuration.CustomResponseCode;
import com.example.demo.dto.request.ReceiptEntityRequest;
import com.example.demo.dto.response.ReceiptEntityResponse;
import com.example.demo.service.ReceiptService;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

	@Autowired
	private ReceiptService receiptService;
	
	public ReceiptController(ReceiptService receiptService) {
		this.receiptService = receiptService;
	}
	
	/**
	 * POST /receipts
	 * **/
	@PostMapping
	public ResponseEntity<CustomResponse<ReceiptEntityResponse>> addReceipt(@RequestBody ReceiptEntityRequest request) {
		CustomResponse<ReceiptEntityResponse> response = new CustomResponse<>();
		ReceiptEntityResponse receiptResponse = receiptService.addReceipt(request);
		response.setCustomResponseCode(CustomResponseCode.RECEIPT_CREATED);
		response.setResponseBody(receiptResponse);
		
		return new ResponseEntity<CustomResponse<ReceiptEntityResponse>>(response, HttpStatus.OK);
	}
	
}
