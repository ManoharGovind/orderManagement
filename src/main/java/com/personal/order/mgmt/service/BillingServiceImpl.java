package com.personal.order.mgmt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.order.mgmt.entities.BillEntity;
import com.personal.order.mgmt.entities.OrderDetails;
import com.personal.order.mgmt.exceptions.OrderNotFoundException;
import com.personal.order.mgmt.repository.OrderRepository;
import com.personal.order.mgmt.util.OrderManagementUtil;

@Service
public class BillingServiceImpl implements BillingService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderManagementUtil orderManagementUtil;

	@Override
	public BillEntity generateBillForOrder(Long orderId) {
		Optional<OrderDetails> order = orderRepository.findById(orderId);
		if (order.isPresent()) {
			Long price = order.get().getItems().stream().mapToLong(item -> item.getPrice()).sum();
			return orderManagementUtil.createBillEntityObject(price, order.get());
		} else {
			throw new OrderNotFoundException();
		}
	}

}
