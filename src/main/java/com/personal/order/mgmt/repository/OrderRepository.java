package com.personal.order.mgmt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.order.mgmt.entities.OrderDetails;
import com.personal.order.mgmt.entities.enums.OrderStatus;

public interface OrderRepository extends JpaRepository<OrderDetails, String> {

	List<OrderDetails> findByStatus(OrderStatus status);
	
	Optional<OrderDetails> findById(Long orderId);

}
