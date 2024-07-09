package com.ors.shoppingservice.model;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    private UUID customerId;
    private String customerName;
    private String customerEmail;
    private String customerBillingAddress;
    private String customerShippingAddress;
}
