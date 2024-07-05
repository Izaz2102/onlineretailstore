package com.ors.orderservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "order_table")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID orderId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "oid_fk", referencedColumnName = "orderId")
    private List<LineItem> lineItemsList = new ArrayList<>();
}
