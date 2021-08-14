package com.tastyfood.omf.ordermanagement.entity;

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
	
	

	/**
	 * @param id
	 * @param version
	 * @param createdDate
	 * @param lastModifiedDate
	 * @param customerRef
	 * @param customer
	 * @param beerOrderLines
	 * @param orderStatus
	 * @param orderStatusCallbackUrl
	 */
	@Builder
	public FoodOrder(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, String customerRef,
			Customer customer, Set<FoodOrderLine> foodOrderLines, String orderStatus,
			String orderStatusCallbackUrl) {
		super(id, version, createdDate, lastModifiedDate);
		this.customerRef = customerRef;
		this.customer = customer;
		this.foodOrderLines = foodOrderLines;
		this.orderStatus = orderStatus;
		this.orderStatusCallbackUrl = orderStatusCallbackUrl;
	}
	private String customerRef;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "beerOrder", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private Set<FoodOrderLine> foodOrderLines;

    private String orderStatus;
    private String orderStatusCallbackUrl;

}
