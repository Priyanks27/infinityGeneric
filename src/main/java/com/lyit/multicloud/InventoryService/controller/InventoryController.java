package com.lyit.multicloud.InventoryService.controller;

import com.lyit.multicloud.InventoryService.data.models.InventoryModel;
import com.lyit.multicloud.InventoryService.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @PostMapping("/inventory")
    public InventoryModel addInventory(@RequestBody InventoryModel inventoryModel) {
        return inventoryService.addInventory(inventoryModel);
    }

    @PutMapping("/inventory")
    public InventoryModel updateInventory(@RequestBody InventoryModel inventoryModel) {
        return inventoryService.updateInventory(inventoryModel);
    }

    @GetMapping("/inventory/{id}")
    public InventoryModel getInventoryItemById(@PathVariable Long id) {
     return inventoryService.getInventoryItemById(id);
    }

    @GetMapping("/inventory")
    public List<InventoryModel> getAllInventoryItems() {
        return inventoryService.getAllInventoryItems();
    }

    @GetMapping("/inventory/{category}")
    public List<InventoryModel> getInventoryItemsByCategory(@PathVariable String category) {
        return inventoryService.getInventoryItemsByCategory(category);
    }
}
