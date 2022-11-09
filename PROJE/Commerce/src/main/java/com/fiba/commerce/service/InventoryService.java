package com.fiba.commerce.service;

import com.fiba.commerce.data.CategoryDto;
import com.fiba.commerce.data.ProductDto;

import java.util.List;

public interface InventoryService {
    List<CategoryDto>getCategories();
    ProductDto getProduct(long productId);
    List<ProductDto> getProductsByCategory(long categoryId);
}
