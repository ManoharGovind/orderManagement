package com.personal.order.mgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.order.mgmt.entities.PaymentResponse;
import com.personal.order.mgmt.service.PaymentService;

@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;

	@PostMapping("/pay/{orderId}")
	public ResponseEntity<PaymentResponse> payForOrderId(@PathVariable("orderId") Long orderId) {
		return new ResponseEntity<>(paymentService.pay(orderId), HttpStatus.OK);
	}

}
