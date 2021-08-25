package com.tastyfood.omf.ordermanagement.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class FoodOrder extends BaseEntity {
	
	private String restaurantName;
	private UUID restaurantId;

	private String orderStatus;
	private String orderStatusCallbackUrl;
	
	private BigDecimal totalPrice;

	@ManyToOne
	private Customer customer;

	@OneToMany(mappedBy = "foodOrder", cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	private Set<FoodOrderLine> foodOrderLines;

	@Builder
	public FoodOrder(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, String restaurantName,
			UUID restaurantId, String orderStatus, String orderStatusCallbackUrl, Customer customer,
			Set<FoodOrderLine> foodOrderLines) {
		super(id, version, createdDate, lastModifiedDate);
		this.restaurantName = restaurantName;
		this.restaurantId = restaurantId;
		this.orderStatus = orderStatus;
		this.orderStatusCallbackUrl = orderStatusCallbackUrl;
		this.customer = customer;
		this.foodOrderLines = foodOrderLines;
	}

	

}