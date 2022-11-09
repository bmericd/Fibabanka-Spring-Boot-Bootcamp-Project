package com.fiba.commerce.client;

import com.fiba.commerce.data.CartDto;
import com.fiba.commerce.data.CartProductDto;
import com.fiba.commerce.data.CategoryDto;
import com.fiba.commerce.data.ProductDto;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
public class InventoryClient {

    public List<CategoryDto> getCategories(){
        String url = "http://localhost:8081/api/inventory/categories";
        RestTemplate restTemplate = new RestTemplate();
        List<CategoryDto> categoryDtoList = restTemplate.getForObject(url, List.class);
        return categoryDtoList;
    }

    public ProductDto getProduct(long productId){
        String url = "http://localhost:8081/api/inventory/product/"+productId;
        RestTemplate restTemplate = new RestTemplate();
        ProductDto productDto = restTemplate.getForObject(url, ProductDto.class);
        return productDto;
    }

    public List<ProductDto> getProductsByCategory(long categoryId){
        String url = "http://localhost:8081/api/inventory/products/"+categoryId;
        RestTemplate restTemplate = new RestTemplate();
        List<ProductDto> productDtoList = restTemplate.getForObject(url, List.class);
        return productDtoList;
    }
}
