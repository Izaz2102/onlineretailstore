package com.ors.orderservice.repository;

import com.ors.orderservice.model.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface LineItemRepository extends JpaRepository<LineItem, UUID>{
}
