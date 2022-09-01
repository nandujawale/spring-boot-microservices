package com.github.jawale.orders.service;

import com.github.jawale.orders.dto.InventoryResponse;
import com.github.jawale.orders.dto.OrderLineItemDTO;
import com.github.jawale.orders.dto.OrderRequest;
import com.github.jawale.orders.model.Order;
import com.github.jawale.orders.model.OrderLineItem;
import com.github.jawale.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient webClient;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(orderRequest.getOrderNumber());
        order.setOrderLineItems(orderRequest.getOrderLineItems().stream()
                .map(this::toOrderLineItem).toList());

        List<String> skuCodes = order.getOrderLineItems().stream()
                .map(OrderLineItem::getSkuCode)
                .toList();

        InventoryResponse[] inventoryResponseArray = webClient.get()
                .uri("http://localhost:8082/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCodes", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean allProductsInStock = Arrays.stream(inventoryResponseArray)
                .allMatch(InventoryResponse::isInStock);

        if (allProductsInStock) {
            orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Product is out of stock");
        }
    }

    private OrderLineItem toOrderLineItem(OrderLineItemDTO orderLineItemDTO) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setSkuCode(orderLineItemDTO.getSkuCode());
        orderLineItem.setPrice(orderLineItemDTO.getPrice());
        orderLineItem.setQuantity(orderLineItemDTO.getQuantity());
        return orderLineItem;
    }
}
