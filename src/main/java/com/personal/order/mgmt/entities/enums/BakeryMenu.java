package com.personal.order.mgmt.entities.enums;

public enum BakeryMenu {
	VEG_BURGER(80L),
	VEG_PIZZA(180L),
	CHICKEN_PIZZA(220L),
	CHICKEN_BURGER(120L),
	VEG_ROLL(40L),
	CHICKEN_ROLL(80L);
	
	private final Long price;
	
	BakeryMenu(Long price){
		this.price=price;
	}
	
	public Long getPrice() {
		return price;
	}
	

}
