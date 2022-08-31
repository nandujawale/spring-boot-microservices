package com.github.jawale.orders.dto;

import lombok.*;

import java.util.List;

@Builder
@Value
public class OrderRequest {

    private String orderNumber;
    private List<OrderLineItemDTO> orderLineItems;
}
