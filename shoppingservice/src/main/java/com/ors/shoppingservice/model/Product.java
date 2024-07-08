package com.ors.shoppingservice.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private String productName;
    private String productDescription;
    private double productPrice;
    private int quantity;
}
