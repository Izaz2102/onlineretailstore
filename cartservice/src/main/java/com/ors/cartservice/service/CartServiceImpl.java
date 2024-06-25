package com.ors.cartservice.service;

import com.ors.cartservice.entity.Cart;
import com.ors.cartservice.entity.LineItem;
import com.ors.cartservice.exceptions.EntityNotFoundException;
import com.ors.cartservice.repository.CartRepository;
import com.ors.cartservice.repository.LineItemRepository;
import org.hibernate.boot.Metadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
//import org.springframework.integration.util.UUIDConverter;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private LineItemRepository lineItemRepository;
    @Override
    public Cart addCart(Cart cart) {
        List<Cart> cartList = cartRepository.findAll();
        //List<LineItem> existngLineItemList = lineItemRepository.findById(cartList.get(0).getLineItemsList().get(0).getLineItemId()).orElseThrow(() -> new EntityNotFoundException("LineItem not found.." + cart.getLineItemsList().get(0).getLineItemId()));
        //Metadata UUIDConverter = null;
        //UUID uuid = Converter.convert(cartList.get(0).getLineItemsList().get(0).getLineItemId());
        //Optional<LineItem> existngLineItemList = Optional.ofNullable(lineItemRepository.findById(UUIDConverter.getUUID(cartList.get(0).getLineItemsList().get(0))).orElseThrow(() -> new EntityNotFoundException("LineItem not found.." + cart.getLineItemsList().get(0).getLineItemId())));

        //Optional<LineItem> existngLineItemList = Optional.ofNullable(lineItemRepository.findById(cartList.get(0).getLineItemsList().get(0).getLineItemId()).orElseThrow(() -> new EntityNotFoundException("LineItem not found.." + cart.getLineItemsList().get(0).getLineItemId())));
        Optional<LineItem> existngLineItemList = Optional.empty();
        if(!cartList.isEmpty()){
            existngLineItemList = Optional.ofNullable(lineItemRepository.findById(cartList.get(0).getLineItemsList().get(0).getLineItemId()).orElseThrow(() -> new EntityNotFoundException("LineItem not found.." + cart.getLineItemsList().get(0).getLineItemId())));
        }

        List<LineItem> toBeAddedLineItemsList = cart.getLineItemsList();

        if (!cartList.isEmpty()) {
            //cartList.get(0).getCartId();

            for(LineItem lineItem : toBeAddedLineItemsList) {
                //lineItem.setCartId(cartList.get(0).getCartId());
                lineItemRepository.save(lineItem);
            }
            return cartList.get(0);
        }else if(existngLineItemList.isEmpty()){
            for(LineItem lineItem : toBeAddedLineItemsList) {
                lineItemRepository.save(lineItem);
            }
            return cartRepository.save(cart);
        }
        return cartList.get(0);
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
    public Cart updateCart(UUID cartId, Cart cart) {
        LineItem updatedLineItem = lineItemRepository.findById(cart.getLineItemsList().get(0).getLineItemId()).orElseThrow(() -> new EntityNotFoundException("LineItem not found"));

        updatedLineItem.setProductId(cart.getLineItemsList().get(0).getProductId());
        updatedLineItem.setProductName(cart.getLineItemsList().get(0).getProductName());
        updatedLineItem.setQuantity(cart.getLineItemsList().get(0).getQuantity());
        updatedLineItem.setPrice(cart.getLineItemsList().get(0).getPrice());

        lineItemRepository.save(updatedLineItem);
        return cartRepository.save(cart);
    }
}
