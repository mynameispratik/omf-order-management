package com.tastyfood.omf.ordermanagement.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tastyfood.omf.ordermanagement.dto.FoodOrderDto;
import com.tastyfood.omf.ordermanagement.service.FoodOrderService;

@RequestMapping("/api/v1/")
@RestController
public class FoodOrderController {
	
	@Autowired
	private FoodOrderService foodOrderService;
	
	@PostMapping("order")
	public ResponseEntity<FoodOrderDto> placeOrder(@RequestBody FoodOrderDto foodOrderDto,
												   @RequestParam("customerId") UUID customerId){
		return new ResponseEntity<FoodOrderDto>(foodOrderService.placeOrder(foodOrderDto,customerId),HttpStatus.CREATED);
	}

	@PutMapping("order/{orderId}")
	public ResponseEntity updateOrder(@PathVariable("orderId") UUID orderId,@RequestBody FoodOrderDto foodOrderDto) {
		return new ResponseEntity<>(foodOrderService.updateOrder(orderId,foodOrderDto),HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("order/{orderId}")
	public ResponseEntity<FoodOrderDto> getOrderById(@PathVariable("orderId") UUID orderId){
		return new ResponseEntity<FoodOrderDto>(foodOrderService.getOrderById(orderId),HttpStatus.OK);
	}
	
	@GetMapping("/order/calculate")
	public ResponseEntity calculatePrice(@RequestBody FoodOrderDto foodOrderDto){
		return new ResponseEntity("Total Price:" + String.valueOf(foodOrderService.calculatePrice(foodOrderDto)),HttpStatus.OK);
	}
	
}