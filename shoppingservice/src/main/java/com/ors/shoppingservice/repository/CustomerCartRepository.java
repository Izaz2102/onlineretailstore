package com.ors.shoppingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerCartRepository extends JpaRepository<CustomerCartRepository, UUID> {
}
