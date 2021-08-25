package com.tastyfood.omf.ordermanagement.service;

import java.util.UUID;

import com.tastyfood.omf.ordermanagement.dto.CustomerDto;

public interface CustomerService {

	CustomerDto saveCustomer(CustomerDto customerDto);

	CustomerDto getCustomerById(UUID customeId);

}