package com.tastyfood.omf.ordermanagement.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tastyfood.omf.ordermanagement.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID>{

}
