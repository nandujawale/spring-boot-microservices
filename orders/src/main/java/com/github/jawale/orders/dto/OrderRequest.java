package com.github.jawale.orders.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

	private String orderNumber;
	private List<OrderLineItemDTO> orderLineItems;
}