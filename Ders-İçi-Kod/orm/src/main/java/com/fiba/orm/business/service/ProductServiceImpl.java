package com.fiba.orm.business.service;

import com.fiba.orm.business.dto.ProductDto;
import com.fiba.orm.data.entity.Product;
import com.fiba.orm.data.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    //BUSINESS LOGIC

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public long create(ProductDto productDto) {
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setSalesPrice(productDto.getSalesPrice());
        productRepository.save(product);
        return product.getProductId();
    }

    @Override
    public void update(ProductDto productDto) {
        Optional<Product> optional = productRepository.findById(productDto.getProductId());
        if(optional.isPresent()){
            Product product = optional.get();
            product.setProductId((int) productDto.getProductId());
            product.setProductName(productDto.getProductName());
            product.setSalesPrice(productDto.getSalesPrice());
            productRepository.save(product);
        }

    }

    @Override
    public ProductDto find(long productId) {
        Optional<Product> optional = productRepository.findById(productId);
        if(optional.isPresent()){
            Product product = optional.get();
            ProductDto productDto = new ProductDto();
            productDto.setProductName(product.getProductName());
            productDto.setSalesPrice(product.getSalesPrice());
            return  productDto;
        }
        return null;
    }

    @Override
    public List<ProductDto> findAll() {
        List<ProductDto> productDtos = new ArrayList<>();
        Iterable<Product> products = productRepository.findAll();
        for(Product product: products){
            ProductDto productDto = new ProductDto();
            productDto.setProductName(product.getProductName());
            productDto.setSalesPrice(product.getSalesPrice());
            productDtos.add(productDto);
        }
        return productDtos;
    }

    @Override
    public void delete(long productId) {
        productRepository.deleteById(productId);
    }

    //Mapper
    private Product toEntity(ProductDto dto){
        return null;
    }
    private ProductDto toDto(Product entity){
        return null;
    }
}
