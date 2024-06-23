package com.ors.cartservice.entity;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import lombok.*;
import org.hibernate.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID cartId;

    /*@OneToMany(mappedBy = "cart")
    @Fetch(FetchMode.SELECT)*/
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cid_fk", referencedColumnName = "cartId")
    private List<LineItem> lineItemsList = new ArrayList<>();
}
