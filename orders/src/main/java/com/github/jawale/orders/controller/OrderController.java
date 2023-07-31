package com.github.jawale.orders.controller;

import com.github.jawale.orders.dto.OrderRequest;
import com.github.jawale.orders.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory", fallbackMethod = "circuitBreakerFallBack")
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.placeOrder(orderRequest);
    }

    public String circuitBreakerFallBack(OrderRequest orderRequest, RuntimeException e) {
        return "Oops! Something went wrong. Please try after some time.";
    }
}
