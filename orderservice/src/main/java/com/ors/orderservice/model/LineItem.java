package com.ors.orderservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "order_line_item")
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class LineItem {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID lineItemId;

    private UUID productId;
    private String productName;
    private int quantity;
    private double price;
}
