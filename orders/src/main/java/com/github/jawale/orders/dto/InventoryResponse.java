package com.github.jawale.orders.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class InventoryResponse {

    private String skuCode;
    private boolean isInStock;
}
