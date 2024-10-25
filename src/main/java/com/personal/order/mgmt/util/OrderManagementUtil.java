package com.personal.order.mgmt.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.personal.order.mgmt.entities.BillEntity;
import com.personal.order.mgmt.entities.OrderDetails;
import com.personal.order.mgmt.entities.PaymentResponse;
import com.personal.order.mgmt.entities.enums.PaymentStatus;

/**
 * Utility class
 */
@Component
public class OrderManagementUtil {

	public OrderDetails createOrderObject(OrderDetails order) {
		/*
		 * OrderDetails order1 = new OrderDetails(order.getId(), OrderStatus.COMPLETED,
		 * order.getItem(), order.getPrice()); return order1;
		 */
		return null;
	}
	
	public BillEntity createBillEntityObject(Long totalPrice, OrderDetails order) {
		BillEntity bill =  new BillEntity(generateUUID(),order.getId(), 
				order.getCustomerName(), order.getItems(), totalPrice, "NA");
		return bill;
	}
	
	public PaymentResponse createPaymentResponse(PaymentStatus status, OrderDetails order) {
		return new PaymentResponse(generateUUID(), order.getId(), order.getItems(), status);
	}
	
	private String generateUUID() {
		return UUID.randomUUID().toString();
	}

}
