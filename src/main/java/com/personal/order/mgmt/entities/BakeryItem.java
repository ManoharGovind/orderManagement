package com.personal.order.mgmt.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.personal.order.mgmt.entities.enums.BakeryMenu;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class BakeryItem {
	@Enumerated(EnumType.STRING)
	private BakeryMenu item;
	private Integer quantity;
	//Ignore at request, but display at response
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long price;
	
	public Long getPrice() {
		return item.getPrice()*quantity;
	}
}
