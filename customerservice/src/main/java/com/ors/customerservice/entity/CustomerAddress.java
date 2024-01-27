
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
public class CustomerAddress {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID customerAddressId;
    private String doorNo;
    private String streetName;
    private String layoutName;
    private String city;
    private String pinCode;

    //@OneToOne(mappedBy="customerAddress")
    //private Customer customer;
}

