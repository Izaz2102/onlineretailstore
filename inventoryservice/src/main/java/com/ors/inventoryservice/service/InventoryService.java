package com.ors.inventoryservice.service;

import com.ors.inventoryservice.entity.Inventory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface InventoryService {
    Inventory addInventory(Inventory inventory);

    Inventory getInventory(UUID inventoryId);

    Iterable<Inventory> getAllInventory();

    void deleteInventory(UUID inventoryId);
}
