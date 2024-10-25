package com.personal.order.mgmt.service;

import org.springframework.stereotype.Component;

@Component
public interface BillingService {
	public Object generateBillForOrder(Long orderId);
}
