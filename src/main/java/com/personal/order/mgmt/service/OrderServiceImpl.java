package com.personal.order.mgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.order.mgmt.entities.OrderDetails;
import com.personal.order.mgmt.entities.enums.OrderStatus;
import com.personal.order.mgmt.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public OrderDetails createOrder(OrderDetails order) {
		order.setStatus(OrderStatus.NOT_STARTED);
		return orderRepository.save(order);
	}

}
