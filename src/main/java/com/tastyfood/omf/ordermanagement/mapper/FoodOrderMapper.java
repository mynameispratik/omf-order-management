package com.tastyfood.omf.ordermanagement.mapper;

import org.mapstruct.Mapper;

import com.tastyfood.omf.ordermanagement.dto.FoodOrderDto;
import com.tastyfood.omf.ordermanagement.entity.FoodOrder;

@Mapper(uses = {DateMapper.class})
public interface FoodOrderMapper {

	FoodOrderDto foodOrderToFoodOrderDto(FoodOrder foodOrder);
	FoodOrder foodOrderDtoToFoodOrder(FoodOrderDto  foodOrderDto);
	
}