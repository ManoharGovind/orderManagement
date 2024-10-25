package com.personal.order.mgmt.service;

import org.springframework.stereotype.Component;

import com.personal.order.mgmt.entities.PaymentResponse;

@Component
public interface PaymentService {
	public PaymentResponse pay(Long orderId);

}
