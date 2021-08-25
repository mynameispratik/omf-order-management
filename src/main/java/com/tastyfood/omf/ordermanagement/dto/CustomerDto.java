package com.tastyfood.omf.ordermanagement.dto;

import java.util.UUID;

import javax.validation.constraints.Null;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

	@Null
    private UUID customerId;
    
	@NotNull
	private String customerName;
	
	@NotNull
	private String customerEmail;
	 
	
	private String customerLocation;
	
}

