package com.fiba.inventory.presentation.rest;

import com.fiba.inventory.business.dto.ProductDto;
import com.fiba.inventory.business.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductResource {
    @Autowired
    private ProductService productService;

    public ProductResource(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/api/inventory/product/{id}")
    public ProductDto getProduct(@PathVariable("id")long productId){
        ProductDto productDto = productService.find(productId);
        return productDto;
    }

    @GetMapping("/api/inventory/products/{id}")
    public List<ProductDto> getProductsByCategory(@PathVariable("id")long categoryId){
        List<ProductDto> productDto = productService.findAllByCategoryId(categoryId);
        return productDto;
    }
}
