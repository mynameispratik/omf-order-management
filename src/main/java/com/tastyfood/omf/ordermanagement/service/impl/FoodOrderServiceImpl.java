package com.tastyfood.omf.ordermanagement.service.impl;


import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.tastyfood.omf.ordermanagement.dto.FoodOrderDto;
import com.tastyfood.omf.ordermanagement.entity.Customer;
import com.tastyfood.omf.ordermanagement.entity.FoodOrder;
import com.tastyfood.omf.ordermanagement.entity.FoodOrderLine;
import com.tastyfood.omf.ordermanagement.entity.Wallet;
import com.tastyfood.omf.ordermanagement.mapper.FoodOrderMapper;
import com.tastyfood.omf.ordermanagement.repository.CustomerRepository;
import com.tastyfood.omf.ordermanagement.repository.FoodOrderRepository;
import com.tastyfood.omf.ordermanagement.repository.WalletRepository;
import com.tastyfood.omf.ordermanagement.service.FoodOrderService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Service
public class FoodOrderServiceImpl implements FoodOrderService {

	private final FoodOrderRepository foodOrderRepository;
	private final CustomerRepository customerRepository;
	private final FoodOrderMapper foodOrderMapper;
	private final WalletRepository  walletRepository;

	@Override
	public FoodOrderDto placeOrder(FoodOrderDto foodOrderDto, UUID customerId) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		
		if (optionalCustomer.isPresent()) {
			log.info("User exists for ID: " + customerId.toString());
			Double totalPrice =  calculatePrice(foodOrderDto);
			Wallet wallet =optionalCustomer.get().getWallet();
			
			if(wallet.getBalance().doubleValue()>totalPrice) {
			wallet.getBalance().subtract(new BigDecimal(totalPrice));
			walletRepository.save(wallet);
			}else {
				//exception
			}
			
			FoodOrder foodOrder = foodOrderMapper.foodOrderDtoToFoodOrder(foodOrderDto);
			foodOrder.setCustomer(optionalCustomer.get());
			for (FoodOrderLine line : foodOrder.getFoodOrderLines()) {
				line.setFoodOrder(foodOrder);
			}
			foodOrder.setTotalPrice(new BigDecimal(totalPrice));
			foodOrder = foodOrderRepository.save(foodOrder);
			return foodOrderMapper.foodOrderToFoodOrderDto(foodOrder);
		}
		return null;
	}

	@Override
	public FoodOrderDto updateOrder(UUID orderId, FoodOrderDto foodOrderDto) {
		Optional<FoodOrder> optional = foodOrderRepository.findById(orderId);
		FoodOrder foodOrderUpdate = foodOrderMapper.foodOrderDtoToFoodOrder(foodOrderDto);
		FoodOrder foodOrder = null;
		if (optional.isPresent()) {
			foodOrder = optional.get();
			foodOrder.setVersion(foodOrderUpdate.getVersion());
			foodOrder.setCreatedDate(foodOrderUpdate.getCreatedDate());
			foodOrder.setRestaurantId(foodOrderUpdate.getRestaurantId());
			foodOrder.setRestaurantName(foodOrderUpdate.getRestaurantName());
			foodOrder.setFoodOrderLines(foodOrderUpdate.getFoodOrderLines());
			foodOrder.setOrderStatus(foodOrderUpdate.getOrderStatus());

			foodOrder = foodOrderRepository.save(foodOrder);
		}
		return foodOrderMapper.foodOrderToFoodOrderDto(foodOrder);
	}

	@Override
	public FoodOrderDto getOrderById(UUID orderId) {
		Optional<FoodOrder> optional = foodOrderRepository.findById(orderId);
		if (optional.isPresent()) {
			return foodOrderMapper.foodOrderToFoodOrderDto(optional.get());
		}
		return null;
	}

	@Override
	public Double calculatePrice(FoodOrderDto foodOrderDto) {

		Double totalPrice = null;
		if (foodOrderDto != null) {
			totalPrice = foodOrderDto.getFoodOrderLines().stream().map(food -> {
				return food.getPrice() * food.getOrderQuantity();
			}).reduce(0.0, Double::sum);
			return totalPrice;
		} else {
				//exception
		}

		return null;
	}

}
