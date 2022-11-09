package com.fiba.inventory.presentation.rest;

import com.fiba.inventory.business.dto.CategoryDto;
import com.fiba.inventory.business.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryResource {

    private CategoryService categoryService;

    public CategoryResource(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/api/inventory/categories")
    public List<CategoryDto> getCategories(){
        List<CategoryDto> categoryDtoList = categoryService.findAll();
        return categoryDtoList;
    }
}
