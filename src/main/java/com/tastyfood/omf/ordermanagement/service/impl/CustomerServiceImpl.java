package com.tastyfood.omf.ordermanagement.service.impl;



import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastyfood.omf.ordermanagement.dto.CustomerDto;
import com.tastyfood.omf.ordermanagement.entity.Customer;
import com.tastyfood.omf.ordermanagement.mapper.CustomerMapper;
import com.tastyfood.omf.ordermanagement.repository.CustomerRepository;
import com.tastyfood.omf.ordermanagement.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public CustomerDto saveCustomer(CustomerDto customerDto) {
		Customer customer = customerRepository.save(customerMapper.customerDtoToCustomer(customerDto));
		return customerMapper.customerToCustomerDto(customer);
	}

	@Override
	public CustomerDto getCustomerById(UUID customeId) {
		Optional<Customer> customerOptional= customerRepository.findById(customeId);
		
		if(customerOptional.isPresent()) {
			return customerMapper.customerToCustomerDto(customerOptional.get());
		}else {
			return null;
		}
	}

}
