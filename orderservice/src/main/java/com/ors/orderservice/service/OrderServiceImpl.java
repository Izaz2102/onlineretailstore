package com.ors.orderservice.service;

import com.ors.orderservice.exceptions.NotFoundException;
import com.ors.orderservice.model.LineItem;
import com.ors.orderservice.model.Order;
import com.ors.orderservice.repository.LineItemRepository;
import com.ors.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private LineItemRepository lineItemRepository;
    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> getOrder(UUID orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public void deleteOrderById(UUID orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public Order updateOrder(UUID orderId, Order order) {
        Optional<Order> existingOrder = orderRepository.findById(orderId);
        if (existingOrder.isPresent()) {
            Order order1 = existingOrder.get();
            List<LineItem> existingLineItems = order1.getLineItemsList();

            for (LineItem lineItem : existingLineItems) {
                lineItemRepository.delete(lineItem);
            }
            orderRepository.save(order);
        }else {
            throw new NotFoundException("Specified Order not found");
        }
        return null;
    }
}
