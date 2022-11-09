package com.fiba.inventory.presentation.client;

import com.fiba.inventory.business.dto.CategoryDto;
import com.fiba.inventory.business.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommerceClient {

    private ProductClient productClient;
    private CategoryClient categoryClient;

    public CommerceClient(ProductClient productClient , CategoryClient categoryClient){
        this.productClient = productClient;
        this.categoryClient = categoryClient;
    }

    @GetMapping("/inventory/product/{id}")
    @ResponseBody
    public ProductDto getProduct(@PathVariable("id") long productId){
        ProductDto productDto = productClient.getProduct(productId);
        return productDto;
    }

    @GetMapping("/inventory/products/{id}")
    @ResponseBody
    public List<ProductDto> getProductByCategory(@PathVariable("id") long categoryId){
        List<ProductDto> productDtoList = productClient.getProductByCategoty(categoryId);
        return productDtoList;
    }

    @GetMapping("/inventory/categories")
    @ResponseBody
    public List<CategoryDto> getCategories(){
        List<CategoryDto> categoryDtoList = categoryClient.getCategories();
        return  categoryDtoList;
    }
}
