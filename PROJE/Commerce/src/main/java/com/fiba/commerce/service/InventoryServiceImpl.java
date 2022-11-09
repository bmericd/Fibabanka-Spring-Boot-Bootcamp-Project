package com.fiba.commerce.service;

import com.fiba.commerce.client.InventoryClient;
import com.fiba.commerce.data.CategoryDto;
import com.fiba.commerce.data.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InventoryServiceImpl implements InventoryService{

    private InventoryClient inventoryClient;

    public InventoryServiceImpl(InventoryClient inventoryClient){
        this.inventoryClient = inventoryClient;
    }

    @Override
    public List<CategoryDto> getCategories() {
        return inventoryClient.getCategories();
    }

    @Override
    public ProductDto getProduct(long productId) {
        return inventoryClient.getProduct(productId);
    }

    @Override
    public List<ProductDto> getProductsByCategory(long categoryId) {
        return inventoryClient.getProductsByCategory(categoryId);
    }
}
