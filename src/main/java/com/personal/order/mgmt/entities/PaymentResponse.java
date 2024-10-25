package com.personal.order.mgmt.entities;

import java.util.List;

import com.personal.order.mgmt.entities.enums.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {
	
	private String id;
	private Long orderId;
	private List<BakeryItem> items; 
	private PaymentStatus paymentStatus;
	//add more details like mode if payment.
	

}
