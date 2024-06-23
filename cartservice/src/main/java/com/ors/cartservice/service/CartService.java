package com.ors.cartservice.service;

import com.ors.cartservice.entity.Cart;
import com.ors.cartservice.entity.LineItem;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public interface CartService {
    Cart addCart(Cart cart);

    Cart getCart(UUID cartId);

    void deleteCartById(UUID cartId);

    Cart updateCart(UUID cartId, Cart cart);
}
