package com.github.jawale.orders.service;

import com.github.jawale.orders.dto.OrderLineItemDTO;
import com.github.jawale.orders.dto.OrderRequest;
import com.github.jawale.orders.model.Order;
import com.github.jawale.orders.model.OrderLineItem;
import com.github.jawale.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(orderRequest.getOrderNumber());
        order.setOrderLineItems(orderRequest.getOrderLineItems().stream()
                .map(this::toOrderLineItem).toList());

        orderRepository.save(order);
    }

    private OrderLineItem toOrderLineItem(OrderLineItemDTO orderLineItemDTO) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setSkuCode(orderLineItemDTO.getSkuCode());
        orderLineItem.setPrice(orderLineItemDTO.getPrice());
        orderLineItem.setQuantity(orderLineItemDTO.getQuantity());
        return orderLineItem;
    }
}
