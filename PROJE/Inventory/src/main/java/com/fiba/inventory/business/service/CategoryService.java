package com.fiba.inventory.business.service;

import com.fiba.inventory.business.dto.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
        List<CategoryDto> findAll();
}
