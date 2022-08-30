package com.github.jawale.products.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Builder
@Value
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
