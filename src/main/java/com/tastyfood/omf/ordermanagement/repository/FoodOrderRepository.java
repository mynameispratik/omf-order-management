package com.tastyfood.omf.ordermanagement.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tastyfood.omf.ordermanagement.entity.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, UUID>{

}
