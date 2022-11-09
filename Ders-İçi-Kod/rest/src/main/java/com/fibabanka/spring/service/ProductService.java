package com.fibabanka.spring.service;

import com.fibabanka.spring.Product;

public interface ProductService {

     Product find(long productId);

     Iterable<Product> findAll();

     public void createProduct(Product product);

     public void updateProduct(Product product);

     public void deleteProduct(long productId);


}
