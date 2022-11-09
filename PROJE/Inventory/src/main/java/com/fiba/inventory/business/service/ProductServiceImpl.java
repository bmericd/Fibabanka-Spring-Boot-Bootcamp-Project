package com.fiba.inventory.business.service;

import com.fiba.inventory.business.dto.ProductDto;
import com.fiba.inventory.data.entity.Product;
import com.fiba.inventory.data.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    @Override
    public ProductDto find(long productId) {
        Optional<Product> optional = productRepository.findById(productId);
        if(optional.isPresent())
        {
            Product product = optional.get();
            ProductDto productDto = new ProductDto();
            productDto.setProductId(product.getProductId());
            productDto.setProductName(product.getProductName());
            productDto.setSalesPrice(product.getSalesPrice());
            return productDto;
        }
        return null;
    }

    @Override
    public List<ProductDto> findAllByCategoryId(long categoryId) {
        Optional<List<Product>> optional = Optional.ofNullable(productRepository.findAllByCategoryId(categoryId));
        if(optional.isPresent()){
            List<ProductDto>  productDtoList = new ArrayList<>();
            for(Product product : optional.get()){
                ProductDto productDto = new ProductDto();
                productDto.setProductId(product.getProductId());
                productDto.setProductName(product.getProductName());
                productDto.setSalesPrice(product.getSalesPrice());
                productDtoList.add(productDto);
            }
            return productDtoList;
        }
        return null;
    }
}
