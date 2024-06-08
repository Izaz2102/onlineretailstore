package com.ors.inventoryservice.service;

import com.ors.inventoryservice.entity.Inventory;
import com.ors.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InventoryServiceImpl implements InventoryService{
    @Autowired
    private InventoryRepository inventoryRepository;
    @Override
    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory getInventory(UUID inventoryId) {
        return inventoryRepository.findById(inventoryId).orElse(null);
    }

    @Override
    public Iterable<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public void deleteInventory(UUID inventoryId) {
        inventoryRepository.deleteById(inventoryId);
    }
}
