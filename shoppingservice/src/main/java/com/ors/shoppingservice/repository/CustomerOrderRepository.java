package com.ors.shoppingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrderRepository, UUID> {
}
