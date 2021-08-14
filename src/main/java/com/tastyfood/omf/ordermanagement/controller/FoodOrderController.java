package com.tastyfood.omf.ordermanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.tastyfood.omf.ordermanagement.dto.FoodOrderDto;

@RestController
public class FoodOrderController {
	
	
	public ResponseEntity<FoodOrderDto> placeOrder(){
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
