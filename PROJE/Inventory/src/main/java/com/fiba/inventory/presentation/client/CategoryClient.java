package com.fiba.inventory.presentation.client;

import com.fiba.inventory.business.dto.CategoryDto;
import com.fiba.inventory.business.dto.ProductDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CategoryClient {

    public List<CategoryDto> getCategories(){
        String url = "http://localhost:8081/api/inventory/categories";
        RestTemplate restTemplate = new RestTemplate();
        List<CategoryDto> categoryDtoList = restTemplate.getForObject(url, List.class);
        return categoryDtoList;
    }
}
