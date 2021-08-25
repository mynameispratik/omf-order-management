package com.tastyfood.omf.ordermanagement.service;

import java.util.UUID;

import com.tastyfood.omf.ordermanagement.dto.FoodOrderDto;

public interface FoodOrderService {

	FoodOrderDto placeOrder(FoodOrderDto foodOrderDto, UUID customerId);

	FoodOrderDto updateOrder(UUID orderId, FoodOrderDto foodOrderDto);

	FoodOrderDto getOrderById(UUID orderId);

	Double calculatePrice(FoodOrderDto foodOrderDto);

}
