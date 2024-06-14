package com.ors.cartservice.repository;

import com.ors.cartservice.entity.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LineItemRepository extends JpaRepository<LineItem, UUID> {
}
