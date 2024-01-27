package com.ors.customerservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID customerId;
    private String customerName;
    private String customerEmail;
    private String customerBillingAddress;
    private String customerShippingAddress;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customerAddressId")
    private CustomerAddress customerAddress;
}
