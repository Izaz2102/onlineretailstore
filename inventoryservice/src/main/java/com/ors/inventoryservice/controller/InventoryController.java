package com.ors.inventoryservice.controller;

import com.ors.inventoryservice.entity.Inventory;
import com.ors.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/ors/api/v1/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/addInventory")
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return inventoryService.addInventory(inventory);
    }

    @GetMapping("/getInventory/{inventoryId}")
    public Inventory getInventory(@PathVariable("inventoryId") UUID inventoryId) {
        return inventoryService.getInventory(inventoryId);
    }

    @GetMapping("/getAllInventory")
    public Iterable<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }
    @DeleteMapping("/deleteInventory/{inventoryId}")
    public String deleteInventory(@PathVariable("inventoryId") UUID inventoryId) {
        Optional<Inventory> inventory = Optional.ofNullable(inventoryService.getInventory(inventoryId));
        if (inventory.isPresent()) {
            inventoryService.deleteInventory(inventoryId);
            return "Inventory deleted successfully";
        }else {
            return "Inventory not found";
        }
    }
    @PutMapping("/updateInventory/{inventoryId}")
    public Inventory updateInventory(@PathVariable("inventoryId") UUID inventoryId, @RequestBody Inventory inventory) {
        //Optional<Inventory> inventory1 = Optional.ofNullable(inventoryService.getInventory(inventoryId));
        Inventory inventory1 = inventoryService.getInventory(inventoryId);
        if (inventory1 != null) {
            inventory1.setProductId(inventory.getProductId());
            inventory1.setQuantity(inventory.getQuantity());
            return inventoryService.addInventory(inventory1);
        }else {
            return null;
        }
    }
}
