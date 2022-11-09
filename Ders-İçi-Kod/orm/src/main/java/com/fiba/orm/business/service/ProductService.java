package com.fiba.orm.business.service;

import com.fiba.orm.business.dto.ProductDto;

import java.util.List;

public interface ProductService {
    long create(ProductDto productDto);
    void update(ProductDto productDto);

    ProductDto find(long productId);

    List<ProductDto> findAll();

    void delete(long productId);
}
