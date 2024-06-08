package com.ors.cartservice.controller;

import com.ors.cartservice.entity.Cart;
import com.ors.cartservice.entity.LineItem;
import com.ors.cartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/ors/api/v1/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/addCart")
    public Cart addCart() {
        return cartService.addCart();
    }
    @GetMapping("/getCart")
    public Cart getCart(@PathVariable("cartId") UUID cartId){
        return cartService.getCart(cartId);
    }
    @DeleteMapping("/deleteCartById/{cartId}")
    public String deleteCartById(@PathVariable("cartId") UUID cartId) {
        cartService.deleteCartById(cartId);
        return "Cart deleted successfully";
    }
    @PutMapping("/updateCart/{cartId}")
    public Cart updateCart(@PathVariable("cartId") UUID cartId, @RequestBody LineItem lineItem) {
        return cartService.updateCart(cartId, lineItem);
    }
}