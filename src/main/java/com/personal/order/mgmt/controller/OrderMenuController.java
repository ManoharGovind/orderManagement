package com.personal.order.mgmt.controller;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.order.mgmt.entities.enums.BakeryMenu;

@RestController
public class OrderMenuController {

	@GetMapping("/getMenu")
	public ResponseEntity<Map<String, Long>> getMenu() {
		Map<String, Long> availabeItems = Stream.of(BakeryMenu.values())
				.collect(Collectors.toMap(BakeryMenu::name, BakeryMenu::getPrice));
		return new ResponseEntity<>(availabeItems, HttpStatus.OK);
	}
}
