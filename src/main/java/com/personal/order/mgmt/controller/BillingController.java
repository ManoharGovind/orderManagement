package com.personal.order.mgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.order.mgmt.service.BillingService;

@RestController
@RequestMapping("/bill/{orderId}")
public class BillingController {
	
	@Autowired
	private BillingService billingService;
	
	@PostMapping/*("/{orderId}")*/
	public ResponseEntity<Object> generateBillForOrderId(@PathVariable("orderId") Long orderId) {
		return new ResponseEntity<>(billingService.generateBillForOrder(orderId), HttpStatus.OK);
	}

}
