package com.ors.cartservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "cart_line_item")
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

    @ManyToOne()
    @JoinColumn(name = "cart_id")
    @JsonIgnore
    private Cart cart;
}
