
package com.ors.customerservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
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
}

