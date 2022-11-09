package com.fiba.inventory.business.service;

import com.fiba.inventory.business.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    ProductDto find(long productId);

    List<ProductDto> findAllByCategoryId(long categoryId);

}
