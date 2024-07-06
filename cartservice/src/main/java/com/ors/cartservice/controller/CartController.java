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
    //public Cart addCart(@RequestBody Cart cart) {
        //return cartService.addCart(cart);
        return cartService.addCart();
    }
    @GetMapping("/getCart/{cartId}")
    public Cart getCart(@PathVariable("cartId") UUID cartId){

        return cartService.getCart(cartId);
    }
    @DeleteMapping("/deleteCartById/{cartId}")
    public String deleteCartById(@PathVariable("cartId") UUID cartId) {
        cartService.deleteCartById(cartId);
        return "Cart deleted successfully";
    }
    @PutMapping("/updateCart/{cartId}")
    public Cart updateCart(@PathVariable("cartId") UUID cartId, @RequestBody Cart cart) {
        return cartService.updateCart(cartId, cart);
    }
}
