package com.github.jawale.products.dto;

import java.math.BigDecimal;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

	private String name;
	private String description;
	private Double price;
}
