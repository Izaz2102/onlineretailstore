package com.ors.customerservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CustomerDTO {
    private UUID customerId;
    private String customerName;
    private String customerEmail;
    private String customerBillingAddress;
    private String customerShippingAddress;
}
