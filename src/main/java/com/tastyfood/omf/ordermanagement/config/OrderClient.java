package com.tastyfood.omf.ordermanagement.config;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.tastyfood.omf.ordermanagement.dto.DishDto;

@Component
public class OrderClient {

	public final String DISH_PATH="/api/v1/dish";
	
	private final RestTemplate restTemplate;
	
	
	public OrderClient(RestTemplateBuilder templateBuilder) {
		this.restTemplate=templateBuilder.build();
	}
	
	public List<DishDto> getDishes(List<String> ids){
		return restTemplate.getForObject("http://localhost:9090"+DISH_PATH, List.class);
	}
	
}
