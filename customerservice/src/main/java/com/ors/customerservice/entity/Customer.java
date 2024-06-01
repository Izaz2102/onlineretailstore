package com.ors.customerservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID customerId;
    private String customerName;
    private String customerEmail;
    private String customerBillingAddress;
    private String customerShippingAddress;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cid_fk", referencedColumnName = "customerId")
    private List<CustomerAddress> customerAddressList = new ArrayList<>();
    public Customer(String customerName, String customerEmail, String customerBillingAddress, String customerShippingAddress, List<CustomerAddress> customerAddressList) {
        super();
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerBillingAddress = customerBillingAddress;
        this.customerShippingAddress = customerShippingAddress;
        this.customerAddressList = customerAddressList;
    }
}
