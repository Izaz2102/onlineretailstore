package com.ors.orderservice.service;

import com.ors.orderservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public interface OrderService {
    Order addOrder(Order order);

    Optional<Order> getOrder(UUID orderId);

    void deleteOrderById(UUID orderId);

    Order updateOrder(UUID orderId, Order order);
}
