package com.ors.shoppingservice.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    private String customerId;
    private String customerName;
    private String customerEmail;
    private String customerBillingAddress;
    private String customerShippingAddress;

}
