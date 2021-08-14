package com.tastyfood.omf.ordermanagement.entity;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Builder;
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
	@ManyToOne
    private FoodOrder foodOrder;

    private UUID cuisineId;

    private Integer orderQuantity = 0;

	/**
	 * @param id
	 * @param version
	 * @param createdDate
	 * @param lastModifiedDate
	 * @param foodOrder
	 * @param cuisineId
	 * @param orderQuantity
	 */
    @Builder
	public FoodOrderLine(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, FoodOrder foodOrder,
			UUID cuisineId, Integer orderQuantity) {
		super(id, version, createdDate, lastModifiedDate);
		this.foodOrder = foodOrder;
		this.cuisineId = cuisineId;
		this.orderQuantity = orderQuantity;
	}
}
