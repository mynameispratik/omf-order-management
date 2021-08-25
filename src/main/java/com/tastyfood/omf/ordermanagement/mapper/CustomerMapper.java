package com.tastyfood.omf.ordermanagement.mapper;

import org.mapstruct.Mapper;

import com.tastyfood.omf.ordermanagement.dto.CustomerDto;
import com.tastyfood.omf.ordermanagement.entity.Customer;

@Mapper
public interface CustomerMapper {

	Customer customerDtoToCustomer(CustomerDto customerDto);
	
	CustomerDto customerToCustomerDto(Customer customer);
}
