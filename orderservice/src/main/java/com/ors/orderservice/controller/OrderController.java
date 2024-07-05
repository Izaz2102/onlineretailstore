package com.ors.orderservice.controller;

import com.ors.orderservice.exceptions.NotFoundException;
import com.ors.orderservice.model.Order;
import com.ors.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/ors/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/addOrder")
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @GetMapping("/getOrder/{orderId}")
    public Order getOrder(@PathVariable("orderId") UUID orderId){
        Optional<Order> order = orderService.getOrder(orderId);
        if (order.isPresent()) {
            return order.get();
        }else {
            throw new NotFoundException("Specified Order not found");
        }
    }

    @DeleteMapping("/deleteOrderById/{orderId}")
    public String deleteOrderById(@PathVariable("orderId") UUID orderId) {
        Optional<Order> order = orderService.getOrder(orderId);
        if (order.isPresent()) {
            orderService.deleteOrderById(orderId);
            return "Order deleted successfully";
        }else {
            throw new NotFoundException("Specified Order not found");
        }
    }
    @PutMapping("/updateOrder/{orderId}")
    public Order updateOrder(@PathVariable("orderId") UUID orderId, @RequestBody Order order) {
        return orderService.updateOrder(orderId, order);
    }
}
