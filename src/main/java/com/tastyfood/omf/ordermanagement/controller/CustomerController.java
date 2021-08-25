package com.tastyfood.omf.ordermanagement.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tastyfood.omf.ordermanagement.dto.CustomerDto;
import com.tastyfood.omf.ordermanagement.service.CustomerService;

@RequestMapping("/api/v1/")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@PostMapping("customer")
	public ResponseEntity<CustomerDto> saveCustomer(@Valid @RequestBody CustomerDto customerDto){
		return new ResponseEntity<CustomerDto>(customerService.saveCustomer(customerDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") UUID customeId){
		return new ResponseEntity<CustomerDto>(customerService.getCustomerById(customeId),HttpStatus.OK);
	}
	
}
