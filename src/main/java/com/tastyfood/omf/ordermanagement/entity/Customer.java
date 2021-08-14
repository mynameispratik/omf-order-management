package com.tastyfood.omf.ordermanagement.entity;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer extends BaseEntity{

    /**
	 * @param id
	 * @param version
	 * @param createdDate
	 * @param lastModifiedDate
	 * @param apiKey
	 * @param customerName
	 * @param customerLocation
	 * @param foodOrders
	 */
	@Builder
	public Customer(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, UUID apiKey,
			String customerName, String customerLocation, Set<FoodOrder> foodOrders) {
		super(id, version, createdDate, lastModifiedDate);
		this.apiKey = apiKey;
		this.customerName = customerName;
		this.customerLocation = customerLocation;
		this.foodOrders = foodOrders;
	}



	@Type(type="org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar(36)")
    private UUID apiKey;
    
	private String customerName;
	
	private String customerLocation;

    @OneToMany(mappedBy = "customer")
    private Set<FoodOrder> foodOrders;
}
