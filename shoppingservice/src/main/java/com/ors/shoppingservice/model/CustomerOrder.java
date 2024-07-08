package com.ors.shoppingservice.model;

import lombok.*;

import java.util.UUID;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerOrder {
    private UUID customerId;
    private UUID orderId;
}
