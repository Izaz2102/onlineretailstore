package com.ors.shoppingservice.repository;

import com.ors.shoppingservice.model.CustomerCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerCartRepository extends JpaRepository<CustomerCart, UUID> {
}
