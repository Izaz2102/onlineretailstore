package com.ors.shoppingservice.service;

import com.ors.shoppingservice.feignclients.*;
import com.ors.shoppingservice.repository.CustomerCartRepository;
import com.ors.shoppingservice.model.Customer;
import com.ors.shoppingservice.model.CustomerCart;
import com.ors.shoppingservice.model.Product;
import com.ors.shoppingservice.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ShoppingService {
    private final CustomerServiceClient customerServiceClient;
    private final ProductServiceClient productServiceClient;
    private final OrderServiceClient orderServiceClient;
    private final InventoryServiceClient inventoryServiceClient;
    private final CartServiceClient cartServiceClient;
    private final CustomerCartRepository customerCartRepository;
    private final CustomerOrderRepository customerOrderRepository;
    @Autowired
    public ShoppingService(CustomerServiceClient customerServiceClient, ProductServiceClient productServiceClient, OrderServiceClient orderServiceClient, InventoryServiceClient inventoryServiceClient, CartServiceClient cartServiceClient, CustomerCartRepository customerCartRepository, CustomerOrderRepository customerOrderRepository) {
        this.customerServiceClient = customerServiceClient;
        this.productServiceClient = productServiceClient;
        this.orderServiceClient = orderServiceClient;
        this.inventoryServiceClient = inventoryServiceClient;
        this.cartServiceClient = cartServiceClient;
        this.customerCartRepository = customerCartRepository;
        this.customerOrderRepository = customerOrderRepository;
    }

    public void createProduct(Product product) {
    }
    public void addCustomer(Customer customer) {
        UUID cartId = cartServiceClient.createCart().getBody().getCartId();
        UUID customerId = customerServiceClient.addCustomer().getCustomerId();
        CustomerCart customerCart = new CustomerCart(customerId, cartId);
        customerCartRepository.save(customerCart);
    }
}
