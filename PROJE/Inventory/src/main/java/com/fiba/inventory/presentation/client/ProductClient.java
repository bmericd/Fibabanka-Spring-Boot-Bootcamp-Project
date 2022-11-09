package com.fiba.inventory.presentation.client;

import com.fiba.inventory.business.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ProductClient {

    public ProductDto getProduct(long productId){
        String url = "http://localhost:8081/api/inventory/product/"+productId;
        RestTemplate restTemplate = new RestTemplate();
        ProductDto productDto = restTemplate.getForObject(url, ProductDto.class);
        return productDto;
    }

    public List<ProductDto> getProductByCategoty(long categoryId){
        String url = "http://localhost:8081/api/inventory/products/"+categoryId;
        RestTemplate restTemplate = new RestTemplate();
        List<ProductDto> productDtoList = restTemplate.getForObject(url, List.class);
        return productDtoList;
    }
}
