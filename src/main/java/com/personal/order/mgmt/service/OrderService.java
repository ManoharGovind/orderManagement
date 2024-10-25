package com.personal.order.mgmt.service;

import org.springframework.stereotype.Component;

import com.personal.order.mgmt.entities.OrderDetails;

@Component
public interface OrderService {
	
	public OrderDetails createOrder(OrderDetails order);
	

}
