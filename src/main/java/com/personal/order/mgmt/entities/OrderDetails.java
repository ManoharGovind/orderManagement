package com.personal.order.mgmt.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.personal.order.mgmt.entities.enums.OrderStatus;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "items", "status", "billPayed"})
@Entity
@Table(name="order_details")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)//ignore-deSerialization(request), include-serialization(response)
	private Long id;

	@Enumerated(EnumType.STRING)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private OrderStatus status;
	
	private String customerName;

	@ElementCollection
	private List<BakeryItem> items;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private boolean billPayed;
}
