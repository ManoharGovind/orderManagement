package com.personal.order.mgmt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.personal.order.mgmt.entities.OrderDetails;
import com.personal.order.mgmt.service.OrderService;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class OrderController {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	
	private final Counter requestCounter;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	public OrderController(MeterRegistry meterRegistry) {
		this.requestCounter = meterRegistry.counter("custom_request_counter");
	}

	@GetMapping("/welcome")
	public ResponseEntity<String> welcomeAPI() throws Exception {
		requestCounter.increment();
		return new ResponseEntity<>("Welcome to order management service", HttpStatus.OK);
	}

	@PostMapping("/createOrder")
	public Object createOrder(@RequestBody OrderDetails order) {
		requestCounter.increment();
		LOGGER.info("Request received to create a order.");
		return orderService.createOrder(order);
	}

}
