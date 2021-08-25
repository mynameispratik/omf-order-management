package com.tastyfood.omf.ordermanagement.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tastyfood.omf.ordermanagement.entity.Customer;
import com.tastyfood.omf.ordermanagement.entity.Wallet;
import com.tastyfood.omf.ordermanagement.repository.CustomerRepository;
import com.tastyfood.omf.ordermanagement.repository.WalletRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CustomerLoader implements CommandLineRunner{
	
	
	private final CustomerRepository customerRepository;
	
	private final WalletRepository walletRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		if(customerRepository.count()==0) {
			loadCustomerObjects();
		}
	}

	
	private void loadCustomerObjects() {
		
		Wallet wallet=Wallet.builder().balance(new BigDecimal("500")).build();
		
		Customer customer= Customer.builder()
							.customerName("Harry")
							.customerEmail("harry@omf.com")
							.build();
		
		customer=customerRepository.save(customer);
		wallet.setCustomer(customer);
		walletRepository.save(wallet);
		
	}

}
