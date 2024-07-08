package com.ors.shoppingservice.controller;

import com.ors.shoppingservice.model.Customer;
import com.ors.shoppingservice.model.Product;
import com.ors.shoppingservice.service.ShoppingService;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ors/api/v1/shopping")
public class ShoppingController {
    private final ShoppingService shoppingService;
    @Autowired
    public ShoppingController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }
    @PostMapping("/product")
    public String createProduct(@RequestBody Product product) {
        return null;
    }
    @PostMapping("/customer")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        shoppingService.addCustomer(customer);
        return ResponseEntity.status(HttpStatus.SC_OK).build();
    }
    @PutMapping("/customer/{customerId}/cart")
    public String addToCart(@PathVariable String customerId) {
        return null;
    }
    @PostMapping("/customer/{customerId}/order")
    public String createOrder(@PathVariable String customerId) {
        return null;
    }
    @GetMapping("/customer/{customerId}/orders")
    public String getOrders(@PathVariable String customerId) {
        return null;
    }
}
