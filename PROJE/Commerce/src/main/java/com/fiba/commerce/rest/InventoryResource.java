package com.fiba.commerce.rest;

import com.fiba.commerce.client.InventoryClient;
import com.fiba.commerce.data.CategoryDto;
import com.fiba.commerce.data.ProductDto;
import com.fiba.commerce.service.InventoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryResource {

    private InventoryService inventoryService;

    public InventoryResource(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @GetMapping("/api/commerce/inventory/categories")
    public List<CategoryDto> getCategories(){
    return inventoryService.getCategories();
    }

    @GetMapping("/api/commerce/inventory/product/{id}")
    public ProductDto getProduct(@PathVariable("id")long productId){

        return inventoryService.getProduct(productId);
    }

    @GetMapping("/api/commerce/inventory/products/{id}")
    public List<ProductDto> getProductsByCategory(@PathVariable("id")long categoryId){
        return inventoryService.getProductsByCategory(categoryId);
    }
}
