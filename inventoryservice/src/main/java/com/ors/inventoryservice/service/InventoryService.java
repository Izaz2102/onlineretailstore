package com.ors.inventoryservice.service;

import com.ors.inventoryservice.entity.Inventory;
import org.springframework.stereotype.Service;

@Service
public interface InventoryService {
    Inventory addInventory(Inventory inventory);
}
