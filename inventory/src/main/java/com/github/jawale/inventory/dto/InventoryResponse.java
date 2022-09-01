package com.github.jawale.inventory.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class InventoryResponse {

    private String skuCode;
    private boolean isInStock;
}
