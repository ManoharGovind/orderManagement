package com.personal.order.mgmt.service.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.personal.order.mgmt.entities.OrderDetails;
import com.personal.order.mgmt.entities.enums.OrderStatus;
import com.personal.order.mgmt.repository.OrderRepository;

@Service
public class OrdersScheduler {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Scheduled(fixedRate = 1000*30)
	public void processOrders() {
		List<OrderDetails> orderList = orderRepository.findByStatus(OrderStatus.ACKNOWLEGED);
		orderList.stream().forEach(this::processOrder);
	}
	
	private void processOrder(OrderDetails order) {
		order.setStatus(OrderStatus.IN_PROGRESS);
		orderRepository.save(order);
	}

}
