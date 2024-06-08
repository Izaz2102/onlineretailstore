package com.ors.cartservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cart {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<LineItem> lineItemsList = new ArrayList<>();
}
