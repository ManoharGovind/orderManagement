package com.personal.order.mgmt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.order.mgmt.entities.OrderDetails;
import com.personal.order.mgmt.entities.PaymentResponse;
import com.personal.order.mgmt.entities.enums.OrderStatus;
import com.personal.order.mgmt.entities.enums.PaymentStatus;
import com.personal.order.mgmt.exceptions.OrderNotFoundException;
import com.personal.order.mgmt.repository.OrderRepository;
import com.personal.order.mgmt.util.OrderManagementUtil;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderManagementUtil orderUtil;

	@Override
	public PaymentResponse pay(Long orderId) {
		//hard Complete order.
		Optional<OrderDetails> order = orderRepository.findById(orderId);
		if(order.isPresent()) {
			order.get().setBillPayed(true);
			order.get().setStatus(OrderStatus.ACKNOWLEGED);
			orderRepository.save(order.get());
			return orderUtil.createPaymentResponse(PaymentStatus.SUCCESS, order.get());
		}
		else
			throw new OrderNotFoundException();
		
	}

	

}
