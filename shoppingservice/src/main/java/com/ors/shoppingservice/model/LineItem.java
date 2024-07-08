package com.ors.shoppingservice.model;

import java.util.UUID;

public class LineItem {
    private UUID lineItemId;

    private Long productId;
    private String productName;
    private int quantity;
    private double price;
    private Cart cart;

}
