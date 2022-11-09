package com.fiba.inventory.business.service;

import com.fiba.inventory.business.dto.CategoryDto;
import com.fiba.inventory.business.dto.ProductDto;
import com.fiba.inventory.data.entity.Category;
import com.fiba.inventory.data.entity.Product;
import com.fiba.inventory.data.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> findAll() {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        Iterable<Category> categories = categoryRepository.findAll();
        for(Category category : categories){
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setCategoryId(category.getCategoryId());
            categoryDto.setCategotyName(category.getCategoryName());
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }
}
