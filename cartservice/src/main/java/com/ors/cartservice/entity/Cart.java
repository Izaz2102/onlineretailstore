package com.ors.cartservice.entity;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import lombok.*;
import org.hibernate.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Cart {
    @Id
    //@GeneratedValue(generator = "UUID")
    private UUID cartId;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "cid_fk", referencedColumnName = "cartId")
    private List<LineItem> lineItemsList = new ArrayList<>();

    public Cart() {
        this.cartId = UUID.randomUUID();
    }

    public UUID getCartId() {
        return cartId;
    }

    public void setCartId(UUID cartId) {
        this.cartId = cartId;
    }

    public List<LineItem> getLineItemsList() {
        return lineItemsList;
    }

    public void setLineItemsList(List<LineItem> lineItemsList) {
        this.lineItemsList = lineItemsList;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", lineItemsList=" + lineItemsList +
                '}';
    }
}
