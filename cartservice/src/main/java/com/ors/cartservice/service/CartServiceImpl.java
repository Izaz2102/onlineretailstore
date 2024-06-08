package com.ors.cartservice.service;

import com.ors.cartservice.entity.Cart;
import com.ors.cartservice.entity.LineItem;
import com.ors.cartservice.exceptions.EntityNotFoundException;
import com.ors.cartservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;
    @Override
    public Cart addCart() {
        return cartRepository.save(new Cart());
    }

    @Override
    public Cart getCart(UUID cartId){
        Optional<Cart> optional = cartRepository.findById(cartId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new EntityNotFoundException("Cart not found");
        }
    }

    @Override
    public void deleteCartById(UUID cartId) {
        cartRepository.deleteById(cartId);
    }

    @Override
    public Cart updateCart(UUID cartId, LineItem lineItem) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new EntityNotFoundException("Cart not found"));
        cart.getLineItemsList().add(lineItem);
        lineItem.setCart(cart);
        return cartRepository.save(cart);
    }
}
