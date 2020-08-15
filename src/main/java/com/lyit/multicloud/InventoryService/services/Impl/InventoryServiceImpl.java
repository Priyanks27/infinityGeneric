package com.lyit.multicloud.InventoryService.services.Impl;


import com.lyit.multicloud.InventoryService.data.models.InventoryModel;
import com.lyit.multicloud.InventoryService.repository.InventoryRepository;
import com.lyit.multicloud.InventoryService.services.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public InventoryModel addInventory(InventoryModel inventoryModel) {
        return inventoryRepository.save(inventoryModel);
    }

    @Override
    public InventoryModel updateInventory(InventoryModel inventoryModel) {
        if(inventoryModel.getId() == null)
            return new InventoryModel();
        Optional<InventoryModel> optionalInventoryModel = inventoryRepository.findById(inventoryModel.getId());
        if(!optionalInventoryModel.isPresent()) return new InventoryModel();
        InventoryModel inventoryModel1 = optionalInventoryModel.get();
        inventoryModel1.setCategory(inventoryModel.getCategory());
        inventoryModel1.setInventoryCount(inventoryModel.getInventoryCount());
        inventoryModel1.setInventoryName(inventoryModel.getInventoryName());
        inventoryModel1.setPriceModel(inventoryModel.getPriceModel());
        return inventoryRepository.save(inventoryModel1);
    }

    @Override
    public InventoryModel removeInventory(InventoryModel inventoryModel) {
        inventoryRepository.deleteById(inventoryModel.getId());
        return inventoryModel;
    }

    @Override
    public InventoryModel getInventoryItemById(Long id) {
        Optional<InventoryModel> optionalInventoryModel = inventoryRepository.findById(id);
        if(optionalInventoryModel.isPresent()) return optionalInventoryModel.get();
        else return new InventoryModel();
    }

    @Override
    public List<InventoryModel> getInventoryItemsByCategory(String category) {
        Optional<List<InventoryModel>> optionalInventoryModelList = inventoryRepository.findAllByCategory(category);
        if(optionalInventoryModelList.isPresent())
        {
            List<InventoryModel> inventoryModels = optionalInventoryModelList.get();
            if(inventoryModels != null || inventoryModels.size() != 0)
                return inventoryModels;
        }
        return new ArrayList<>();
    }

    @Override
    public List<InventoryModel> getAllInventoryItems() {
        return inventoryRepository.findAll();
    }
}
