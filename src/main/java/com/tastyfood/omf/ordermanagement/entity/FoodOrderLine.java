package com.tastyfood.omf.ordermanagement.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
public class FoodOrderLine extends BaseEntity {
	
	

    private UUID cuisineId;
    
    private String cuisineName;

    private Integer orderQuantity = 0;
    
    private BigDecimal price;

    @ManyToOne
    private FoodOrder foodOrder;

	public FoodOrderLine(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, UUID cuisineId,
			String cuisineName, Integer orderQuantity, BigDecimal price, FoodOrder foodOrder) {
		super(id, version, createdDate, lastModifiedDate);
		this.cuisineId = cuisineId;
		this.cuisineName = cuisineName;
		this.orderQuantity = orderQuantity;
		this.price = price;
		this.foodOrder = foodOrder;
	}
    
    
	

	
}
