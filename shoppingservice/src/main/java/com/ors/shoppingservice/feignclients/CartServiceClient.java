package com.ors.shoppingservice.feignclients;

import com.ors.shoppingservice.model.Cart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "cart-service")
public interface CartServiceClient {
    @PostMapping("/addCart")
    public ResponseEntity<Cart> createCart();
}
