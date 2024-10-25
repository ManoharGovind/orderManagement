package com.personal.order.mgmt.entities;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="bills_table")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillEntity {
	
	@Id
	private String id;
	
	private Long orderId;
	
	private String customerName;
	
	private List<BakeryItem> items;
	
	private Long totalPrice;
	
	private String remarks;

	@PrePersist
	private void generateBillId() {
		if (this.id == null)
			this.id = UUID.randomUUID().toString();
	}

}
