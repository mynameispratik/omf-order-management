package com.tastyfood.omf.ordermanagement.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodOrderLineDto {
	@JsonProperty("id")
	private UUID id = null;

	@JsonProperty("version")
	private Integer version = null;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
	@JsonProperty("createdDate")
	private OffsetDateTime createdDate = null;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
	@JsonProperty("lastModifiedDate")
	private OffsetDateTime lastModifiedDate = null;

	private String cuisineName;
	private UUID cuisineId;
	private Integer orderQuantity = 0;
	private Double price;
}
